/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.db;

import classes.DatabaseConnection;
import classes.entity.AnggotaKelas;
import classes.entity.Dosen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Angga Suta Dharmawan - 16101650
 */
public class DbAnggotaKelas {
    public static ArrayList tampil(int start, int limit, String where, String order){
        ArrayList result = new ArrayList();
        
        String sql = "select * from anggota_kelas";
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
                AnggotaKelas anggotaKelas = new AnggotaKelas();
                anggotaKelas.setKodeKelas(rs.getString("kode_kelas"));
                anggotaKelas.setNim(rs.getString("nim"));
                result.add(anggotaKelas);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println("errProcTampil: "+e.toString());
        }finally{
        }
        
        return result;
    }
    
    public static void deleteData(AnggotaKelas anggotaKelas){
        String sqlDelete = "delete from anggota_kelas where kode_kelas=? and nim=?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            conn = DatabaseConnection.getConnection();
            preparedStatement = conn.prepareStatement(sqlDelete);
            preparedStatement.setString(1, anggotaKelas.getKodeKelas());
            preparedStatement.setString(2, anggotaKelas.getNim());
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
    
    public static void simpanData(AnggotaKelas anggotaKelas){
        //boolean result = false;
        String sqlinsert = "insert into anggota_kelas (kode_kelas, nim) values (?,?)";
        //String sqlupdate = "update dosen set nidn=?, nama=?, jenis_kelamin=? where nidn=?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            conn = DatabaseConnection.getConnection();
            preparedStatement = conn.prepareStatement(sqlinsert);
            preparedStatement.setString(1, anggotaKelas.getKodeKelas());
            preparedStatement.setString(2, anggotaKelas.getNim());
            preparedStatement.executeUpdate();            
            
            //result = true;
        }catch(SQLException e){
            //result = false;
            System.out.println("err save" + e.toString());
        }finally{
            if(preparedStatement!=null){
                try{
                    preparedStatement.close();
                }catch(SQLException e){}
            }
        }
        //return result;
    }
}
