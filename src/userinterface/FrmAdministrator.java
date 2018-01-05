/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import classes.DatabaseConnection;
import classes.db.DbUser;
import classes.entity.User;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Angg Suta Dharmawan - 16101650
 */
public class FrmAdministrator extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmAdministrator
     */
    private DefaultTableModel model;
    
    // penanda untuk operasi edit apa buat baru
    boolean isEdit = false;
    
    // var untuk menyimpan kode lama, jika seandainya kodenya diganti
    String kodeOld = "";
    
    
    public FrmAdministrator() {
        initComponents();
        
        model = new DefaultTableModel();
        model.addColumn("Kode");       
        model.addColumn("Nama Lengkap");
        model.addColumn("Username");
        model.addColumn("Password");
        
        tableAdmin.setModel(model);
        tableAdmin.getColumnModel().getColumn(0).setPreferredWidth(30);
        tableAdmin.getColumnModel().getColumn(1).setPreferredWidth(170);
        tableAdmin.getColumnModel().getColumn(2).setPreferredWidth(50);
        tableAdmin.getColumnModel().getColumn(3).setPreferredWidth(50);
        
        refreshData();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmdClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAdmin = new javax.swing.JTable();
        cmdTambah = new javax.swing.JButton();
        cmdSimpan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtFullName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtRetype = new javax.swing.JPasswordField();
        cmdHapus = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setTitle("Administrator");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Administrator");

        cmdClose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdClose.setText("Keluar");
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        tableAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAdmin);

        cmdTambah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdTambah.setText("Tambah");
        cmdTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTambahActionPerformed(evt);
            }
        });

        cmdSimpan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdSimpan.setText("Simpan");
        cmdSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSimpanActionPerformed(evt);
            }
        });

        jLabel2.setText("Kode User");

        jLabel3.setText("Nama Lengkap");

        txtKode.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtFullName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Username");

        jLabel5.setText("Password");

        jLabel6.setText("Ketik Ulang Password");

        txtUsername.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtPassword.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtRetype.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmdHapus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdHapus.setText("Hapus");
        cmdHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cmdTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdClose))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsername)
                                    .addComponent(txtPassword)
                                    .addComponent(txtRetype))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtRetype, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdClose)
                    .addComponent(cmdTambah)
                    .addComponent(cmdSimpan)
                    .addComponent(cmdHapus))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        try {
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FrmAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTambahActionPerformed
        kosongkanField();
    }//GEN-LAST:event_cmdTambahActionPerformed

    private void tableAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAdminMouseClicked
        int selected = tableAdmin.getSelectedRow();
        if(selected==-1){
            return;
        }
        
        isEdit = true;
        kodeOld = (String) model.getValueAt(selected, 0);
        txtKode.setText(kodeOld);
        txtFullName.setText((String) model.getValueAt(selected, 1));
        txtUsername.setText((String) model.getValueAt(selected, 2));
    }//GEN-LAST:event_tableAdminMouseClicked

    private void cmdSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSimpanActionPerformed
        boolean success = false;
        
        //ambil data dari form
        User user = new User();
        user.setKode(txtKode.getText());
        user.setFullName(txtFullName.getText());
        user.setUsername(txtUsername.getText());
        user.setPassword(String.valueOf(txtPassword.getPassword()));
        
        //simpan data dengan method simpandata
        //cek dulu password sudah sesuai dengan ketik ulang
        if(user.getPassword().equals(String.valueOf(txtRetype.getPassword()))){
            if(!isEdit && user.getPassword().length()==0){
                JOptionPane.showMessageDialog(null, "ulang password tidak boleh kosong...\nSilahkan di cek kembali.", "Perhatian", JOptionPane.ERROR_MESSAGE);
            }else{
                success = DbUser.simpanData(isEdit, kodeOld, user);
                if(success){
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan...", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    kosongkanField();
                    refreshData();
                }else{
                    JOptionPane.showMessageDialog(null, "Data gagal disimpan...", "Perhatian", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ketik ulang password tidak sesuai...\nSilahkan di cek kembali.", "Perhatian", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmdSimpanActionPerformed

    private void cmdHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHapusActionPerformed
        int selected = tableAdmin.getSelectedRow();
        if(selected==-1){
            return;
        }
        
        int reply = JOptionPane.showConfirmDialog(null, "Anda yakin akan menghapus " + ((String) tableAdmin.getValueAt(selected, 1)), "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            DbUser.hapusUser((String) tableAdmin.getValueAt(selected, 0));
            kosongkanField();
            refreshData();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus...", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_cmdHapusActionPerformed
    
    public void kosongkanField(){
        txtKode.setText("");
        txtFullName.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txtRetype.setText("");
        isEdit = false;
    }
    
    public void refreshData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        ArrayList userList = new ArrayList();
        try{
            userList = DbUser.tampil(0, 0, "", "kode asc");
            if(userList!=null && userList.size()>0){
                for(int i=0; i<userList.size(); i++){
                    User user = (User) userList.get(i);
                    Object[] o = new Object[4];
                    o[0] = user.getKode();
                    o[1] = user.getFullName();
                    o[2] = user.getUsername();
                    o[3] = "***************";
                    model.addRow(o);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdHapus;
    private javax.swing.JButton cmdSimpan;
    private javax.swing.JButton cmdTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAdmin;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtKode;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtRetype;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
