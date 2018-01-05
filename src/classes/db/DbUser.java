/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.db;

import classes.DatabaseConnection;
import classes.entity.User;
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
 * @author OxysystemPC
 */
public class DbUser{
    public static User processLogin(String username, String password){
        User result = new User();
        //generate connection
        Connection conn = DatabaseConnection.getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from user where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                result.setKode(rs.getString("kode"));
                result.setFullName(rs.getString("full_name"));
                result.setUsername(rs.getString("username"));
                result.setPassword(rs.getString("password"));
            }
            rs.close();
        }catch(SQLException e){
            System.out.println("errProcLogin: "+e.toString());
        }finally{
        }
        return result;
    }
    
    public static User tampilByKode(String kode){
        User result = new User();
        String sql = "select * from user where kode=?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            conn = DatabaseConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, kode);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                
            }
        }catch(SQLException e){}finally{
        }
        return result;
    }
    
    public static ArrayList tampil(int start, int limit, String where, String order){
        ArrayList result = new ArrayList();
        
        String sql = "select * from user";
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
                User user = new User();
                user.setKode(rs.getString("kode"));
                user.setFullName(rs.getString("full_name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                result.add(user);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println("errProcTampil: "+e.toString());
        }finally{
        }
        
        return result;
    }
    
    public static boolean simpanData(boolean isEdit, String primaryKey, User user){
        boolean result = false;
        String sqlinsert = "insert into user (kode, full_name, username, password) values (?,?,?,?)";
        String sqlupdate = "update user set kode=?, full_name=?, username=?, password=? where kode=?";
        if(user.getPassword().length()==0){
            sqlupdate = "update user set kode=?, full_name=?, username=? where kode=?";
        }
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            conn = DatabaseConnection.getConnection();
            if(isEdit){
                preparedStatement = conn.prepareStatement(sqlupdate);
                if(user.getPassword().length()==0){
                    preparedStatement.setString(4, primaryKey);
                }else{
                    preparedStatement.setString(5, primaryKey);
                }
            }else{
                preparedStatement = conn.prepareStatement(sqlinsert);
            }
            
            preparedStatement.setString(1, user.getKode());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setString(3, user.getUsername());
            if(user.getPassword().length()!=0){
                preparedStatement.setString(4, user.getPassword());
            }
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
    
    public static boolean hapusUser(String kode){
        boolean result = false;
        try{
            String sql = "delete from user where kode=?";
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1, kode);
            pr.executeUpdate();
            result = true;
        }catch(SQLException e){}
        return result;
    }
}
