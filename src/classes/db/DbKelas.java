/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.db;

import classes.DatabaseConnection;
import static classes.db.DbMahasiswa.tampil;
import classes.entity.Dosen;
import classes.entity.Kelas;
import classes.entity.Mahasiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Angga Suta Dharmawan - 16101650
 */
public class DbKelas {
    public static ArrayList tampil(int start, int limit, String where, String order){
        ArrayList result = new ArrayList();
        
        String sql = "select * from kelas";
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
                Kelas kelas = new Kelas();
                kelas.setKode(rs.getString("kode"));
                kelas.setNama(rs.getString("nama"));
                kelas.setKodeMataKuliah(rs.getString("kode_matakuliah"));
                kelas.setNidn(rs.getString("nidn"));
                kelas.setRuangan(rs.getString("ruangan"));
                kelas.setHari(rs.getString("hari"));
                kelas.setJamMulai(rs.getInt("jam_mulai"));
                kelas.setMenitMulai(rs.getInt("menit_mulai"));
                kelas.setJamBerakhir(rs.getInt("jam_berakhir"));
                kelas.setMenitBerakhir(rs.getInt("menit_berakhir"));
                result.add(kelas);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println("errProcTampil: "+e.toString());
        }finally{
        }
        
        return result;
    }
    
    public static Kelas tampilByKode(String kode){
        Kelas kelas = new Kelas();
        try{
            ArrayList result = tampil(0, 0, "kode='"+ kode +"'", "");
            if(result!=null && result.size()>0){
                kelas = (Kelas) result.get(0);
            }
        }catch(Exception e){}
        return kelas;
    }
    
    public static boolean simpanData(String primaryKey, Kelas kelas){
        boolean result = false;
        String sqlinsert = "insert into kelas (kode, nama, kode_matakuliah, nidn, ruangan, hari, jam_mulai, menit_mulai, jam_berakhir, menit_berakhir) values (?,?,?,?,?,?,?,?,?,?)";
        String sqlupdate = "update kelas set kode=?, nama=?, kode_matakuliah=?, nidn=?, ruangan=?, hari=?, jam_mulai=?, menit_mulai=?, jam_berakhir=?, menit_berakhir=? where kode=?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            conn = DatabaseConnection.getConnection();
            if(primaryKey.length()>0){
                preparedStatement = conn.prepareStatement(sqlupdate);
                preparedStatement.setString(11, primaryKey);
            }else{
                preparedStatement = conn.prepareStatement(sqlinsert);
            }

            preparedStatement.setString(1, kelas.getKode());
            preparedStatement.setString(2, kelas.getNama());
            preparedStatement.setString(3, kelas.getKodeMataKuliah());
            preparedStatement.setString(4, kelas.getNidn());
            preparedStatement.setString(5, kelas.getRuangan());
            preparedStatement.setString(6, kelas.getHari());
            preparedStatement.setInt(7, kelas.getJamMulai());
            preparedStatement.setInt(8, kelas.getMenitMulai());
            preparedStatement.setInt(9, kelas.getJamBerakhir());
            preparedStatement.setInt(10, kelas.getMenitBerakhir());
            
            preparedStatement.executeUpdate();            
            
            result = true;
        }catch(SQLException e){
            result = false;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("err save" + e.toString());
        }finally{
            if(preparedStatement!=null){
                try{
                    preparedStatement.close();
                }catch(SQLException e){}
            }
        }
        return result;
    }
}