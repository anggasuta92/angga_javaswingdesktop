/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.db;

import classes.DatabaseConnection;
import classes.entity.Absensi;
import classes.entity.AnggotaKelas;
import classes.entity.Mahasiswa;
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
    
    public static ArrayList tampil(int start, int limit, String where, String order){
        ArrayList result = new ArrayList();
        
        String sql = "select * from absensi";
        if(where.length()>0){
            sql += " where " + where;
        }
        
        if(order.length()>0){
            sql += " order by " + order;
        }
        
        if(start!=0 || limit!=0){
            sql = sql + " limit " + start + "," + limit;
        }
        
        Connection conn = DatabaseConnection.getConnection();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Absensi absensi = new Absensi();
                absensi.setKodeKelas(rs.getString("kode_kelas"));
                absensi.setNim(rs.getString("nim"));
                absensi.setTanggal(rs.getDate("tanggal"));
                result.add(absensi);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println("errProcTampil: "+e.toString());
        }finally{
        }
        
        return result;
    }
    
    public static String terjemahkanHariKeIndonesia(String hari){
        for(int i = 0; i < hariENG.length; i++){
            if(hariENG[i].equalsIgnoreCase(hari)){
                return hariINA[i];
            }
        }
        
        return "";
    }
    
    public static boolean cekAbsensi(String nim, String kodeKelas, Date tanggal){
        boolean sudahAbsen = false;
        //cek sudah absen apa belum 
        ArrayList listAbsen = new ArrayList();
        try{
            String strTanggal = new SimpleDateFormat("yyyy-MM-dd").format(tanggal);
            String where = "tanggal='"+ strTanggal +"' and nim='"+ nim +"' and kode_kelas='"+ kodeKelas +"'";
            listAbsen = DbAbsensi.tampil(0, 0, where, "");
            if(listAbsen.size()>0 && listAbsen!=null){
                sudahAbsen = true;
            }
        }catch(Exception e){}
        return sudahAbsen;
    }
    
    public static String lakukanAbsensi(String nim){
        String result = "";
        
        //cek nim terdaftar apa tidak
        Mahasiswa mhs = new Mahasiswa();
        try{
            mhs = DbMahasiswa.tampilByNim(nim);
            if(mhs.getNim()==null || mhs.getNim().length()==0){
                return "NIM Anda tidak terdaftar...";
            }
        }catch(Exception e){
            return "NIM Anda tidak terdaftar...";
        }
        
        //cek tanggal berapa saat ini
        Date tanggalSekarang = new Date();
        //cari tahu tanggal ini hari apa / dalam english
        String strHari = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(tanggalSekarang);
        //terjemahkan ke indonesia
        strHari = terjemahkanHariKeIndonesia(strHari);
        
        //cek jam sekarang dan ubah dalam bentuk menit
        String jamSekarang = String.valueOf((tanggalSekarang.getHours()*60) + tanggalSekarang.getMinutes());
        
        String sqlCekKelas = "SELECT * FROM " +
                            "(SELECT k.kode, k.nama, k.kode_matakuliah, ((k.jam_mulai*60)+k.menit_mulai) AS mulaidalammenit, ((k.jam_berakhir*60)+k.menit_berakhir) AS berakhirdalammenit "
                            + "FROM kelas k inner join anggota_kelas ak on k.kode=ak.kode_kelas WHERE k.hari='"+ strHari +"' and ak.nim='"+ mhs.getNim() +"') " +
                            "AS tblx WHERE "+ jamSekarang +"<=berakhirdalammenit ORDER BY berakhirdalammenit ASC limit 0,1";
        
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlCekKelas);
            
            int jmlData = 0;
            while(rs.next()){
                jmlData++;
                //jika ada data simpan dulu ke class entity
                Absensi absen = new Absensi();
                absen.setKodeKelas(rs.getString("kode"));
                absen.setNim(nim);
                absen.setTanggal(tanggalSekarang);
                
                //cek sudah absen apa belum
                if(cekAbsensi(absen.getNim(), absen.getKodeKelas(), tanggalSekarang)){
                    //jika sudah absen, keluarkan pesan sudah absen dan batalkan absesn
                    result = "Anda sudah melakukan absensi";
                }else{
                    //jika belum absen lakukan absen
                    DbAbsensi.simpanData(absen);
                    result = mhs.getNama() + " Terima kasih sudah melakukan absensi... \n";
                    
                    int mulaiDalamMenit = rs.getInt("mulaidalammenit");
                    int datangDalamMenit = Integer.parseInt(jamSekarang);
                    if(datangDalamMenit<mulaiDalamMenit){
                        result += "\n"
                                + "Anda hari ini datang " + String.valueOf(mulaiDalamMenit - datangDalamMenit) + " menit lebih awal";
                    }if(datangDalamMenit==mulaiDalamMenit){
                        result += "\n"
                                + "Anda hari ini datang tepat waktu";                    
                    }else if(datangDalamMenit>mulaiDalamMenit){
                        result += "\n"
                                + "Maaf, anda terlambat : " + String.valueOf(datangDalamMenit - mulaiDalamMenit) + " menit.";
                    }
                }
            }
            
            if(jmlData==0){
                result = "Anda tidak mempunyai jadwal hari ini.";
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{}

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
