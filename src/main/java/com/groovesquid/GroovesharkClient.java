package com.groovesquid;

import com.google.gson.Gson;
import com.groovesquid.model.Clients;
import com.groovesquid.model.Clients.Client;
import com.groovesquid.model.Country;
import com.groovesquid.model.JsonRequest;
import com.groovesquid.util.Utils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GroovesharkClient {
    
    private final static Logger log = Logger.getLogger(Main.class.getName());

    private static String[] jsqueueMethods = {"getCountry", "getStreamKeyFromSongIDEx", "markSongDownloadedEx"};

    // http://www.scilor.com/grooveshark/xml/GrooveFix.xml
    private static Clients clients = Main.getConfig().getClients();
    
    private static HashMap<String, Object> header = new HashMap<String, Object>();
    
    private static String commtoken = "";
    private static String session = "";
    private static String uuid = UUID.randomUUID().toString();
    private static Country country = new Country();
    
    private static long tokenExpires = 0;

    public static String sendRequest(String method, HashMap<String, Object> parameters) {
        if(tokenExpires <= new Date().getTime() && tokenExpires != 0 && !"initiateSession".equals(method) && !"getCommunicationToken".equals(method) && !"getCountry".equals(method)) {
            try {
                InitThread initThread = new InitThread();
                initThread.start();
                initThread.getLatch().await();
            } catch (InterruptedException ex) {
                log.log(Level.SEVERE, null, ex);
            }
        }
        String responseContent = null;
        HttpEntity httpEntity = null;
        try {
            Client client = clients.getHtmlshark();

            String protocol = "http://";

            if(method.equals("getCommunicationToken")) {
                protocol = "https://";
            }

            String url = protocol + "grooveshark.com/more.php?" + method;

            for(String jsqueueMethod : jsqueueMethods) {
                if(jsqueueMethod.equals(method)) {
                    client = clients.getJsqueue();
                    break;
                }
            }

            header.put("client", client.getName());
            header.put("clientRevision", client.getRevision());
            header.put("privacy", "0");
            header.put("uuid", uuid);
            header.put("country", country);
            if(!method.equals("initiateSession")) {
                header.put("session", session);
                header.put("token", generateToken(method, client.getSecret()));
            }

            Gson gson = new Gson();
            String jsonString = gson.toJson(new JsonRequest(header, parameters, method));
            log.info(">>> " + jsonString);

            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json");
            httpPost.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpPost.setHeader(HTTP.USER_AGENT, "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31");
            httpPost.setHeader("Referer", "http://grooveshark.com/JSQueue.swf?" + client.getRevision());
            httpPost.setHeader("Content-Language", "en-US");
            httpPost.setHeader("Cache-Control", "max-age=0");
            httpPost.setHeader("Accept", "*/*");
            httpPost.setHeader("Accept-Charset", "utf-8,ISO-8859-1;q=0.7,*;q=0.3");
            httpPost.setHeader("Accept-Language", "de-DE,de;q=0.8,en-US;q=0.6,en;q=0.4");
            httpPost.setHeader("Accept-Encoding", "gzip,deflate,sdch");
            httpPost.setHeader("Origin", "http://grooveshark.com");
            if(!method.equals("initiateSession")) {
                httpPost.setHeader("Cookie", "PHPSESSID=" + session);
            }
            httpPost.setEntity(new StringEntity(jsonString, "UTF-8"));
       
            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            if(Main.getConfig().getProxyHost() != null && Main.getConfig().getProxyPort() != null) {
                httpClientBuilder.setProxy(new HttpHost(Main.getConfig().getProxyHost(), Main.getConfig().getProxyPort()));
            }
            HttpClient httpClient = httpClientBuilder.build();
            HttpResponse httpResponse = httpClient.execute(httpPost);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            httpEntity = httpResponse.getEntity();
            
            StatusLine statusLine = httpResponse.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                httpEntity.writeTo(baos);
            } else {
                throw new RuntimeException("method " + method + ": " + statusLine);
            }

            responseContent = baos.toString("UTF-8");
            

        } catch (Exception ex) {
            Logger.getLogger(GroovesharkClient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                EntityUtils.consume(httpEntity);
            } catch (IOException ex) {
                Logger.getLogger(GroovesharkClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        log.info("<<< " + responseContent);
        return responseContent;
    }
    
    public static double calcProgress(long downloadedBytes, long totalBytes) {
        return totalBytes > 0 ? (double) downloadedBytes / (double) totalBytes : 0.0;
    }
    
    public static InputStream downloadSong(HttpEntity httpEntity) {
        InputStream inputStream = null;
        if (httpEntity != null) {
            try {
                inputStream = httpEntity.getContent();
                int read = 0;
                byte[] bytes = new byte[10240];
                while ((read = inputStream.read(bytes)) != -1) {
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(GroovesharkClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalStateException ex) {
                Logger.getLogger(GroovesharkClient.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    EntityUtils.consume(httpEntity);
                } catch (IOException ex) {
                    Logger.getLogger(GroovesharkClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return inputStream;
    }
    
    public static String generateToken(String method, String secret) throws NoSuchAlgorithmException {
        String randomHex = Utils.createRandomHexNumber(6);
        return randomHex + Utils.sha1(method + ":" + commtoken + ":" + secret + ":" + randomHex);
    }
    
    public static synchronized String getSession() {
        return session;
    }
    
    public static synchronized void setSession(String session) {
        GroovesharkClient.session = session;
        log.info("session: " + session);
    }
    
    public static synchronized void setCommtoken(String commtoken) {
        GroovesharkClient.commtoken = commtoken;
        log.info("commtoken: " + commtoken);
    }
    
    public static synchronized Country getCountry() {
        return country;
    }
    
    public static synchronized void setCountry(Country country) {
        GroovesharkClient.country = country;
        log.info("country: " + country);
    }
    
    public static synchronized Clients getClients() {
        return clients;
    }
    
    public static synchronized void setClients(Clients clients) {
        GroovesharkClient.clients = clients;
        log.info("clients: " + clients.toString());
    }
    
    public static synchronized long getTokenExpires() {
        return tokenExpires;
    }
    
    public static synchronized void setTokenExpires(long tokenExpires) {
        GroovesharkClient.tokenExpires = tokenExpires;
    }
}