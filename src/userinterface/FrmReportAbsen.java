/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import classes.db.DbAbsensi;
import classes.db.DbAnggotaKelas;
import classes.db.DbDosen;
import classes.db.DbKelas;
import classes.db.DbMahasiswa;
import classes.db.DbMataKuliah;
import classes.entity.AnggotaKelas;
import classes.entity.Dosen;
import classes.entity.Kelas;
import classes.entity.Mahasiswa;
import classes.entity.MataKuliah;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author Angga Suta Dharmawan - 16101650
 */
public class FrmReportAbsen extends javax.swing.JInternalFrame {
    public FrmReportAbsen() {
        initComponents();
        txtReport.setContentType("text/html");
        txtReport.setEditable(false);
        
        txtTanggal.setValue(new Date());
        isiListKelas();
    }
    
    public void isiListKelas(){
        ArrayList listKelas = new ArrayList();
        try{
            listKelas = DbKelas.tampil(0, 0, "", "nama asc");
        }catch(Exception e){}
        
        if(listKelas!=null && listKelas.size()>0){
            for(int i = 0; i < listKelas.size(); i++){
                Kelas kelas = (Kelas) listKelas.get(i);
                String strNamaKelas = "";
                String strMataKuliah = "";
                try{
                    MataKuliah matkul = DbMataKuliah.tampilByKode(kelas.getKodeMataKuliah());
                    strMataKuliah = matkul.getNama();
                }catch(Exception e){}                
                strNamaKelas = kelas.getKode() + " / " + kelas.getNama() + " / " + strMataKuliah + " / "+ ((kelas.getJamMulai()<10 ? "0" + kelas.getJamMulai() : kelas.getJamMulai()) + ":" + (kelas.getMenitMulai()<10 ? "0" + kelas.getMenitMulai() : kelas.getMenitMulai()) + " - " + (kelas.getJamBerakhir()<10 ? "0" + kelas.getJamBerakhir(): kelas.getJamBerakhir()) + ":" + (kelas.getMenitBerakhir()<10 ? "0" + kelas.getMenitBerakhir() : kelas.getMenitBerakhir())) +"";
                cmbKelas.addItem(strNamaKelas);
            }
        }else{
            cmbKelas.addItem("- Tidak ada kelas -");
        }
    }
    
    public static String generateReport(String strKelas, Date tanggal){
        String result = "";
        String strTanggal = new SimpleDateFormat("dd MMMM yyyy").format(tanggal);
        Kelas kelas = new Kelas();
        try{
            //cari berdasarkan kode, kode didapat dari nama kelas, kode paling awal
            kelas = DbKelas.tampilByKode(strKelas.substring(0, strKelas.indexOf(" /")));
        }catch(Exception e){}
        
	result += "<div style=\"font-weight:bolder; font-size:24px;\">LAPORAN ABSENSI</div>";
	result += "<table cellpadding=\"0\" cellspacing=\"0\" width=\"400px\">";
	result += "	<tr>";
	result += "		<td style=\"font-weight:bolder;\" width=\"100px\">Mata Kuliah</td>";
	result += "		<td>: "+ strKelas +"</td>";
	result += "	</tr>";
	result += "	<tr>";
	result += "		<td style=\"font-weight:bolder;\">Tanggal</td>";
	result += "		<td>: "+ strTanggal +"</td>";
	result += "	</tr>";
	result += "</table>";

        result += "<br/>";
        
	result += "<table cellpadding=\"0\" cellspacing=\"0\" width=\"460px\" border=\"1\" style=\"border-collapse:collapse;\">";
	result += "	<tr>";
	result += "		<td width=\"30px\" align=\"center\"><b>No</b></td>";
	result += "		<td width=\"100px\" align=\"center\"><b>NIM</b></td>";
	result += "		<td width=\"230px\" align=\"center\"><b>Nama</b></td>";
	result += "		<td align=\"center\" width=\"100px\" colspan=\"1\"><b>Keterangan</b></td>";
	result += "	</tr>";
        
        //tampilkan anggota kelas pada kelas bersangkutan
        ArrayList listAnggota = new ArrayList();
        try{
            listAnggota = DbMahasiswa.tampil(0, 0, "nim in (select nim from anggota_kelas where kode_kelas='"+ kelas.getKode() +"')", "nama asc"); //DbAnggotaKelas.tampil(0, 0, "kode_kelas='"+ kelas.getKode() +"'", "nama asc");
        }catch(Exception e){}
        
        for(int i = 0; i < listAnggota.size(); i++){
            Mahasiswa mhs = (Mahasiswa) listAnggota.get(i);
            boolean hadir = DbAbsensi.cekKehadiran(mhs.getNim(), kelas.getKode(), tanggal);
            String keteranganHadir = "<font color=\"#ffffff\">Tidak hadir</font>";
            String styleKeterangan = "bgcolor=\"red\"";
            if(hadir){
                keteranganHadir = "<font color=\"#000000\">-</font>";
                styleKeterangan = "bgcolor=\"#green\"";
            }
            
            result += "	<tr>";
            result += "		<td align=\"center\">"+ (i+1) +"</td>";
            result += "		<td align=\"center\">"+ mhs.getNim() +"</td>";
            result += "		<td align=\"left\">&nbsp;&nbsp;"+ mhs.getNama() +"</td>";
            result += "		<td align=\"center\" "+ styleKeterangan +" ><b>"+ keteranganHadir +"</b></td>";
            result += "	</tr>";
        }
	result += "</table>"
               + "<br/><br/>";
        
        String strNamaDosen = "";
        try{
            Dosen dosen = DbDosen.tampilByNidn(kelas.getNidn());
            strNamaDosen = "<u><b>"+dosen.getNama()+"</b></u>";
        }catch(Exception e){}
        result += "<table cellpadding=\"0\" cellspacing=\"0\" width=\"400px\">";
        result += "	<tr>";
        result += "		<td align=\"center\" width=\"310\"></td>";
        result += "		<td align=\"left\" width=\"90\" nowrap >Denpasar, "+ strTanggal +"</td>";
        result += "	</tr>";
        result += "	<tr>";
        result += "		<td align=\"center\"></td>";
        result += "		<td align=\"left\">Dosen</td>";
        result += "	</tr>";
        result += "	<tr>";
        result += "		<td align=\"center\"><br/><br/><br/><br/></td>";
        result += "		<td align=\"center\">&nbsp;</td>";
        result += "	</tr>";
        result += "	<tr>";
        result += "		<td align=\"center\"></td>";
        result += "		<td align=\"left\" nowrap>"+ strNamaDosen +"</td>";
        result += "	</tr>";
        result += "</table>"
               + "<br/><br/><br/><br/>";
        return result;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        cmbKelas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtReport = new javax.swing.JTextPane();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Mata Kuliah");

        jLabel2.setText("Tanggal");

        txtTanggal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        jButton1.setText("Tampilkan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txtReport);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtReport.setText(generateReport(String.valueOf(cmbKelas.getSelectedItem()), ((Date) txtTanggal.getValue())));
        txtReport.setCaretPosition(0);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbKelas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane txtReport;
    private javax.swing.JFormattedTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
