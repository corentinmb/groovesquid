package com.groovesquid.gui;

import com.groovesquid.Main;
import com.groovesquid.model.Song;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SquidTableColumnModel extends DefaultTableColumnModel {

    private JTable table;
    
    public SquidTableColumnModel(JTable table) {
        this.table = table;
        this.columnMargin = 0;
    }

    @Override
    public void addColumn(TableColumn tc) {
        if(table.getModel() instanceof SongSearchTableModel) {
            if(tc.getModelIndex() == 0) {
                tc.setMaxWidth(22);
                
                Action download = new AbstractAction() {
                    public void actionPerformed(ActionEvent e) { 
                        int modelRow = Integer.valueOf( e.getActionCommand() );
                        DownloadTableModel downloadTableModel = (DownloadTableModel) Main.getMainFrame().getDownloadTable().getModel();
                        SongSearchTableModel songSearchTableModel = (SongSearchTableModel) Main.getMainFrame().getSearchTable().getModel();
                        Song song = songSearchTableModel.getSongs().get(modelRow);
                        downloadTableModel.addRow(0, Main.getDownloadService().download(song, Main.getMainFrame().getDownloadListener(downloadTableModel)));
                    } 
                };
                SquidButtonEditor buttonColumn = new SquidButtonEditor(table, download);
                
                tc.setCellRenderer(buttonColumn);
                tc.setCellEditor(buttonColumn);
            }
        } else if(table.getModel() instanceof DownloadTableModel) {
            if(tc.getModelIndex() == 5) {
                tc.setCellRenderer(new ProgressCellRenderer());
                tc.setMinWidth(200);
            }
        }
        super.addColumn(tc);
    }

}
