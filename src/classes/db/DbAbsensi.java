/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.db;

import classes.DatabaseConnection;
import classes.entity.Absensi;
import classes.entity.AnggotaKelas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Angga Suta Dharmawan - 16101650
 */
public class DbAbsensi {
    
    public static final String[] hariINA = {"Senin","Selasa","Rabu","Kamis","Jumat","Sabtu","Minggu"};
    public static final String[] hariENG = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    
    public static String terjemahkanHariKeIndonesia(String hari){
        for(int i = 0; i < hariENG.length; i++){
            if(hariENG[i].equalsIgnoreCase(hari)){
                return hariINA[i];
            }
        }
        
        return "";
    }
    
    public static void String cekAbsensi(String nim){
        //cek sudah absen apa belum 
        ArrayList listAbsen = new ArrayList();
        try{
            
        }catch(Exception e){}
        return "";
    }
    
    public static String lakukanAbsensi(String nim){
        String result = "";
//SELECT * FROM 
//(SELECT kode, nama, kode_matakuliah, ((jam_mulai*10)+menit_mulai) AS mulaidalammenit, ((jam_berakhir*10)+menit_berakhir) AS berakhirdalammenit FROM kelas WHERE hari='Jumat')
//AS tblx WHERE 22<=berakhirdalammenit ORDER BY berakhirdalammenit ASC
        //cek tanggal berapa saat ini
        Date tanggalSekarang = new Date();
        //cari tahu tanggal ini hari apa / dalam english
        String strHari = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(tanggalSekarang);
        //terjemahkan ke indonesia
        strHari = terjemahkanHariKeIndonesia(strHari);
        
        //cek jam sekarang dan ubah dalam bentuk menit
        String jamSekarang = String.valueOf((tanggalSekarang.getHours()*60) + tanggalSekarang.getMinutes());
        
        String sqlCekKelas = "SELECT * FROM " +
                            "(SELECT kode, nama, kode_matakuliah, ((jam_mulai*10)+menit_mulai) AS mulaidalammenit, ((jam_berakhir*10)+menit_berakhir) AS berakhirdalammenit FROM kelas WHERE hari='"+ strHari +"') " +
                            "AS tblx WHERE "+ jamSekarang +"<=berakhirdalammenit ORDER BY berakhirdalammenit ASC limit 0,1";
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlCekKelas);
            while(rs.next()){
                //jika ada simpan ke absen
                Absensi absen = new Absensi();
                absen.setKodeKelas(rs.getString("kode"));
                absen.setNim(nim);
                absen.setTanggal(tanggalSekarang);
                
                
                DbAbsensi.simpanData(absen);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{}
        System.out.println(" => " + tanggalSekarang.getHours() + " " + tanggalSekarang.getMinutes());
        
        
        return result;
    }
    
    public static void simpanData(Absensi absensi){
        String sqlinsert = "insert into absensi (kode_kelas, nim, tanggal) values (?,?,?)";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            conn = DatabaseConnection.getConnection();
            preparedStatement = conn.prepareStatement(sqlinsert);
            preparedStatement.setString(1, absensi.getKodeKelas());
            preparedStatement.setString(2, absensi.getNim());
            preparedStatement.setDate(3, new java.sql.Date(absensi.getTanggal().getTime()));
            preparedStatement.executeUpdate();            
        }catch(SQLException e){
            System.out.println("err save" + e.toString());
        }finally{
            if(preparedStatement!=null){
                try{
                    preparedStatement.close();
                }catch(SQLException e){}
            }
        }
    }
}
