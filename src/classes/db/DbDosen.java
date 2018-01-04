/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.db;

import classes.DatabaseConnection;
import classes.entity.AnggotaKelas;
import classes.entity.Dosen;
import classes.entity.MataKuliah;
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
public class DbDosen {
    public static ArrayList tampil(int start, int limit, String where, String order){
        ArrayList result = new ArrayList();
        
        String sql = "select * from dosen";
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
                Dosen dosen = new Dosen();
                dosen.setNidn(rs.getString("nidn"));
                dosen.setNama(rs.getString("nama"));
                dosen.setJenisKelamin(rs.getString("jenis_kelamin"));
                result.add(dosen);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println("errProcTampil: "+e.toString());
        }finally{
        }
        
        return result;
    }
    
    public static boolean simpanData(boolean isEdit, String primaryKey, Dosen dosen){
        boolean result = false;
        String sqlinsert = "insert into dosen (nidn, nama, jenis_kelamin) values (?,?,?)";
        String sqlupdate = "update dosen set nidn=?, nama=?, jenis_kelamin=? where nidn=?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            conn = DatabaseConnection.getConnection();
            if(isEdit){
                preparedStatement = conn.prepareStatement(sqlupdate);
                preparedStatement.setString(4, primaryKey);
            }else{
                preparedStatement = conn.prepareStatement(sqlinsert);
            }
            
            preparedStatement.setString(1, dosen.getNidn());
            preparedStatement.setString(2, dosen.getNama());
            preparedStatement.setString(3, dosen.getJenisKelamin());
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
    
    public static Dosen tampilByNidn(String nidn){
        Dosen dosen = new Dosen();
        try{
            ArrayList result = tampil(0, 0, "nidn='"+ nidn +"'", "");
            if(result!=null && result.size()>0){
                dosen = (Dosen) result.get(0);
            }
        }catch(Exception e){}
        return dosen;
    }
    
    public static Dosen tampilByNama(String nama){
        Dosen dosen = new Dosen();
        try{
            ArrayList result = tampil(0, 0, "nama='"+ nama +"'", "");
            if(result!=null && result.size()>0){
                dosen = (Dosen) result.get(0);
            }
        }catch(Exception e){}
        return dosen;
    }
}
