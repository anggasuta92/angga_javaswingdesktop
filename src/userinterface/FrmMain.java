/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import classes.dboperation.OperationUser;
import classes.entity.User;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.xml.bind.PropertyException;

/**
 *
 * @author OxysystemPC
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    User userLogin = new User();
    public static JDesktopPane desktopPanex; 
    
    public FrmMain() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //jMenuUtama.setVisible(false);
        this.setLocationRelativeTo(null);
        
        //Dimension desktopSize = this.getSize();
        //Dimension jLoginFrameSize = frameLogin.getSize();
        //frameLogin.setLocation((desktopSize.width - jLoginFrameSize.width)/2, (desktopSize.height - jLoginFrameSize.height)/2);
        desktopPanex = desktopPane;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        desktopPane = new javax.swing.JDesktopPane();
        jMenuUtama = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        mnAdministrator = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mnMatkul = new javax.swing.JMenuItem();
        mnDosen = new javax.swing.JMenuItem();
        mnMahasiswa = new javax.swing.JMenuItem();
        mnKelas = new javax.swing.JMenuItem();
        mnAnggota = new javax.swing.JMenuItem();
        mnLibur = new javax.swing.JMenuItem();
        mnAbsensi = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Absensi");

        desktopPane.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1396, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        jMenu3.setText("File");

        mnAdministrator.setText("Administrator");
        mnAdministrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAdministratorActionPerformed(evt);
            }
        });
        jMenu3.add(mnAdministrator);

        jMenuItem1.setText("Keluar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuUtama.add(jMenu3);

        jMenu4.setText("Data Bank");

        mnMatkul.setText("Mata Kuliah");
        mnMatkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMatkulActionPerformed(evt);
            }
        });
        jMenu4.add(mnMatkul);

        mnDosen.setText("Dosen");
        mnDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDosenActionPerformed(evt);
            }
        });
        jMenu4.add(mnDosen);

        mnMahasiswa.setText("Mahasiswa");
        mnMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMahasiswaActionPerformed(evt);
            }
        });
        jMenu4.add(mnMahasiswa);

        mnKelas.setText("Kelas");
        jMenu4.add(mnKelas);

        mnAnggota.setText("Anggota Kelas");
        jMenu4.add(mnAnggota);

        mnLibur.setText("Jadwal Libur");
        jMenu4.add(mnLibur);

        jMenuUtama.add(jMenu4);

        mnAbsensi.setText("Absensi");
        jMenuUtama.add(mnAbsensi);

        jMenu6.setText("Laporan");

        jMenuItem8.setText("Cetak Form Absensi");
        jMenu6.add(jMenuItem8);

        jMenuItem9.setText("Laporan Absesnsi Detail");
        jMenu6.add(jMenuItem9);

        jMenuItem10.setText("Laporan Rekapitulasi Absensi");
        jMenu6.add(jMenuItem10);

        jMenuUtama.add(jMenu6);

        setJMenuBar(jMenuUtama);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void openForm(JInternalFrame frame, String frmTitle){
        //JDesktopPane desktopPane = this.desktopPane;
        
        try{
            boolean status=false;  
            javax.swing.JInternalFrame[] children;  
            children=desktopPanex.getAllFrames();
            for (JInternalFrame f:children){  
                if(
                    f.getTitle().equalsIgnoreCase(frmTitle) ||
                    (f.getTitle().equalsIgnoreCase("Editor Mahasiswa") && frmTitle.equalsIgnoreCase("Form Mahasiswa"))
                ){  
                    f.setSelected(true);  
                    status=true;  
                    break;
                }
            }
            
            if (status==false){
                desktopPanex.add(frame);
                frame.setTitle(frmTitle);
                frame.setVisible(true);
                
                Dimension desktopSize = desktopPanex.getSize();
                Dimension jLoginFrameSize = frame.getSize();
                frame.setLocation((desktopSize.width - jLoginFrameSize.width)/2, (desktopSize.height - jLoginFrameSize.height)/2);
            }
        }catch(PropertyVetoException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void mnDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDosenActionPerformed
        openForm(new FrmDosen(), "Form Dosen");
    }//GEN-LAST:event_mnDosenActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnAdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAdministratorActionPerformed
        openForm(new FrmAdministrator(), "Form Administrator");
    }//GEN-LAST:event_mnAdministratorActionPerformed

    private void mnMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMahasiswaActionPerformed
        openForm(new FrmMahasiswa(), "Form Mahasiswa");
    }//GEN-LAST:event_mnMahasiswaActionPerformed

    private void mnMatkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMatkulActionPerformed
        openForm(new FrmMataKuliah(), "Form Mata Kuliah");
    }//GEN-LAST:event_mnMatkulActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuBar jMenuUtama;
    private javax.swing.JMenu mnAbsensi;
    private javax.swing.JMenuItem mnAdministrator;
    private javax.swing.JMenuItem mnAnggota;
    private javax.swing.JMenuItem mnDosen;
    private javax.swing.JMenuItem mnKelas;
    private javax.swing.JMenuItem mnLibur;
    private javax.swing.JMenuItem mnMahasiswa;
    private javax.swing.JMenuItem mnMatkul;
    // End of variables declaration//GEN-END:variables
}
