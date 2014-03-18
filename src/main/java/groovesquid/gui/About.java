/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package groovesquid.gui;

import groovesquid.Main;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Marius
 */
public class About extends javax.swing.JFrame {

    /**
     * Creates new form About
     */
    public About() {
        initComponents();
        
        // center screen
        setLocationRelativeTo(null);
        
        // icon
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        
        versionLabel.setText("Version " + Main.getVersion());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        websiteLabel = new javax.swing.JLabel();
        facebookLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        twitterLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lekoLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        versionLabel = new javax.swing.JLabel();

        setTitle(Main.getLocaleString("ABOUT"));
        setResizable(false);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel3.setText("Website:");

        websiteLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        websiteLabel.setForeground(java.awt.Color.blue);
        websiteLabel.setText("http://groovesquid.com");
        websiteLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        websiteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                websiteLabelMousePressed(evt);
            }
        });

        facebookLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        facebookLabel.setForeground(java.awt.Color.blue);
        facebookLabel.setText("http://facebook.com/groovesquid");
        facebookLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        facebookLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                facebookLabelwebsiteLabelMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel4.setText("Facebook:");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel5.setText("Twitter:");

        twitterLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        twitterLabel.setForeground(java.awt.Color.blue);
        twitterLabel.setText("http://twitter.com/groovesquid");
        twitterLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        twitterLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                twitterLabelwebsiteLabelMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Copyright (c) 2014 by Maino Development. All rights reserved.");

        closeButton.setText(Main.getLocaleString("CLOSE"));
        closeButton.setFocusable(false);
        closeButton.setRequestFocusEnabled(false);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel1.setText("Logo & UI:");

        lekoLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        lekoLabel.setForeground(java.awt.Color.blue);
        lekoLabel.setText("http://facebook.com/LeKoArtsDE");
        lekoLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lekoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lekoLabelMousePressed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/groovesquid/gui/logo.png"))); // NOI18N

        versionLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        versionLabel.setText("Version");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lekoLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(websiteLabel)
                                            .addComponent(facebookLabel)
                                            .addComponent(twitterLabel))))
                                .addGap(74, 74, 74))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(versionLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(websiteLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(facebookLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(twitterLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lekoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(versionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closeButton))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void websiteLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_websiteLabelMousePressed
        try {
            Desktop.getDesktop().browse(java.net.URI.create(((JLabel) evt.getSource()).getText()));
        } catch (IOException ex) {
            Logger.getLogger(About.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_websiteLabelMousePressed

    private void facebookLabelwebsiteLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facebookLabelwebsiteLabelMousePressed
        try {
            Desktop.getDesktop().browse(java.net.URI.create(((JLabel) evt.getSource()).getText()));
        } catch (IOException ex) {
            Logger.getLogger(About.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_facebookLabelwebsiteLabelMousePressed

    private void twitterLabelwebsiteLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twitterLabelwebsiteLabelMousePressed
        try {
            Desktop.getDesktop().browse(java.net.URI.create(((JLabel) evt.getSource()).getText()));
        } catch (IOException ex) {
            Logger.getLogger(About.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_twitterLabelwebsiteLabelMousePressed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void lekoLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lekoLabelMousePressed
        try {
            Desktop.getDesktop().browse(java.net.URI.create(((JLabel) evt.getSource()).getText()));
        } catch (IOException ex) {
            Logger.getLogger(About.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lekoLabelMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel facebookLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lekoLabel;
    private javax.swing.JLabel twitterLabel;
    private javax.swing.JLabel versionLabel;
    private javax.swing.JLabel websiteLabel;
    // End of variables declaration//GEN-END:variables
}
