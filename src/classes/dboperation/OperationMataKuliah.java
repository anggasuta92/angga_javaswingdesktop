/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.dboperation;

import classes.DatabaseConnection;
import classes.entity.MataKuliah;
import classes.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Angga Suta Dharmawan - 16101650
 */
public class OperationMataKuliah {
    public static Vector tampil(int start, int limit, String where, String order){
        Vector result = new Vector();
        
        String sql = "select * from mata_kuliah";
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
                MataKuliah mataKuliah = new MataKuliah();
                mataKuliah.setKode(rs.getString("kode"));
                mataKuliah.setNama(rs.getString("nama"));
                mataKuliah.setJmlSks(rs.getInt("jml_sks"));
                result.add(mataKuliah);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println("errProcTampil: "+e.toString());
        }finally{
        }
        
        return result;
    }
    
    public static boolean simpanData(boolean isEdit, String primaryKey, MataKuliah mataKuliah){
        boolean result = false;
        String sqlinsert = "insert into mata_kuliah (kode, nama, jml_sks) values (?,?,?)";
        String sqlupdate = "update mata_kuliah set kode=?, nama=?, jml_sks=? where kode=?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            conn = DatabaseConnection.getConnection();
            if(isEdit){
                preparedStatement = conn.prepareCall(sqlupdate);
                preparedStatement.setString(4, primaryKey);
            }else{
                preparedStatement = conn.prepareCall(sqlinsert);
            }
            
            preparedStatement.setString(1, mataKuliah.getKode());
            preparedStatement.setString(2, mataKuliah.getNama());
            preparedStatement.setInt(3, mataKuliah.getJmlSks());
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
