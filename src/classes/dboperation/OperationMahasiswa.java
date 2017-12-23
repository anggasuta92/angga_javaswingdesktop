/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.dboperation;

import classes.DatabaseConnection;
import classes.entity.Mahasiswa;
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
 * @author OxysystemPC
 */
public class OperationMahasiswa {
    public static Vector tampil(int start, int limit, String where, String order){
        Vector result = new Vector();
        
        String sql = "select * from mahasiswa";
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
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setNim(rs.getString("nim"));
                mahasiswa.setNama(rs.getString("nama"));
                mahasiswa.setTempatLahir(rs.getString("tempat_lahir"));
                mahasiswa.setTanggalLahir(rs.getDate("tanggal_lahir"));
                mahasiswa.setJenisKelamin(rs.getString("jenis_kelamin"));
                mahasiswa.setProgramStudi(rs.getString("program_studi"));
                mahasiswa.setJurusan(rs.getString("jurusan"));
                mahasiswa.setTahunMasuk(rs.getInt("tahun_masuk"));
                result.add(mahasiswa);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println("errProcTampil: "+e.toString());
        }finally{
        }
        
        return result;
    }
    
    public static Mahasiswa tampilByNim(String nim){
        Mahasiswa mhs = new Mahasiswa();
        try{
            Vector result = tampil(0, 0, "nim='"+ nim +"'", "");
            if(result!=null && result.size()>0){
                mhs = (Mahasiswa) result.get(0);
            }
        }catch(Exception e){}
        return mhs;
    }
    
    public static boolean simpanData(String primaryKey, Mahasiswa mahasiswa){
        boolean result = false;
        String sqlinsert = "insert into mahasiswa (nim, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, program_studi, jurusan, tahun_masuk) values (?,?,?,?,?,?,?,?)";
        String sqlupdate = "update mahasiswa set nim=?, nama=?, tempat_lahir=?, tanggal_lahir=?, "
                            + "jenis_kelamin=?, program_studi=?, jurusan=?, tahun_masuk=? "
                            + "where nim=?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            conn = DatabaseConnection.getConnection();
            if(primaryKey.length()>0){
                preparedStatement = conn.prepareCall(sqlupdate);
                preparedStatement.setString(9, primaryKey);
            }else{
                preparedStatement = conn.prepareCall(sqlinsert);
            }
            
            preparedStatement.setString(1, mahasiswa.getNim());
            preparedStatement.setString(2, mahasiswa.getNama());
            preparedStatement.setString(3, mahasiswa.getTempatLahir());
            preparedStatement.setDate(4, new java.sql.Date(mahasiswa.getTanggalLahir().getTime()));
            preparedStatement.setString(5, mahasiswa.getJenisKelamin());
            preparedStatement.setString(6, mahasiswa.getProgramStudi());
            preparedStatement.setString(7, mahasiswa.getJurusan());
            preparedStatement.setInt(8, mahasiswa.getTahunMasuk());
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
    
    public static boolean hapusData(String nim){
        boolean result = false;
        String sql = "delete from mahasiswa where nim=?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            conn = DatabaseConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nim.trim());
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
