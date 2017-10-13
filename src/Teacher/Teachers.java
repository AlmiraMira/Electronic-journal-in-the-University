/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teacher;

import Help.SizeSetter;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class Teachers extends javax.swing.JDialog {
   
    Connection connection;
    TeacherModel model;
    SizeSetter columnWidth;
    /**
     * Creates new form Prepodavatels
     */
   public Teachers(java.awt.Frame parent, boolean modal, Connection c) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        connection = c;

        model = new TeacherModel(connection);
        jTable1.setModel(model);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        columnWidth = new SizeSetter();
        columnWidth.resizeColumnWidth(jTable1);
        
//        getCountRows();
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonDELETE = new javax.swing.JButton();
        jButtonALTER = new javax.swing.JButton();
        jButtonADD = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonDELETE.setText("DELETE");
        jButtonDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDELETEActionPerformed(evt);
            }
        });

        jButtonALTER.setText("ATLER");
        jButtonALTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonALTERActionPerformed(evt);
            }
        });

        jButtonADD.setText("ADD");
        jButtonADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonADDActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Заголовок 3"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonADD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonALTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDELETE, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                .addGap(209, 209, 209))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonADD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonALTER)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDELETE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDELETEActionPerformed
          if (jTable1.getSelectedRow() >= 0) {
            model.delete(model.getSelectesItem(jTable1.getSelectedRow()).getId());
        }
        try {
            model.updateData();
        } catch (SQLException ex) {
            Logger.getLogger(Teachers.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_jButtonDELETEActionPerformed

    private void jButtonALTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonALTERActionPerformed
        if (jTable1.getSelectedRow() >= 0) {
            NewTeacher np = null;
            try {
                np = new NewTeacher((Frame) this.getParent(), true,
                    connection, model.getSelectesItem(jTable1.getSelectedRow()));
            } catch (SQLException ex) {
                Logger.getLogger(Teachers.class.getName()).log(Level.SEVERE, null, ex);
            }
            np.setVisible(true);
            try {
                model.updateData();
            } catch (SQLException ex) {
                Logger.getLogger(Teachers.class.getName()).log(Level.SEVERE, null, ex);
            }
            ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
        }
    }//GEN-LAST:event_jButtonALTERActionPerformed

    private void jButtonADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonADDActionPerformed
          NewTeacher np = null;
        try {
            np = new NewTeacher((Frame) this.getParent(), true, connection);
        } catch (SQLException ex) {
            Logger.getLogger(Teachers.class.getName()).log(Level.SEVERE, null, ex);
        }
        np.setVisible(true);
        try {
            model.updateData();
        } catch (SQLException ex) {
            Logger.getLogger(Teachers.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged(); np = null;
        
    }//GEN-LAST:event_jButtonADDActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonADD;
    private javax.swing.JButton jButtonALTER;
    private javax.swing.JButton jButtonDELETE;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}