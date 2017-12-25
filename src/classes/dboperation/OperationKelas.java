/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.dboperation;

import classes.DatabaseConnection;
import classes.entity.Dosen;
import classes.entity.Kelas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Angga Suta Dharmawan - 16101650
 */
public class OperationKelas {
    public static Vector tampil(int start, int limit, String where, String order){
        Vector result = new Vector();
        
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
                kelas.setMenitMulai(rs.getInt("meni_mulai"));
                kelas.setJamBerakhir(rs.getInt("jam_berakhir"));
                kelas.setMenitBerakhir(rs.getInt("menit_mulai"));
                result.add(kelas);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println("errProcTampil: "+e.toString());
        }finally{
        }
        
        return result;
    }
}