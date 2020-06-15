/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DoiTuong.Mon;
import btl.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pham Quyen
 */
public class MonCon {
    Connect con = new Connect();
    public ArrayList<Mon> layDanhSach1(String sql){
        ArrayList<Mon> danhsach1= new ArrayList<>();
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Mon h = new Mon();
                h.setMaM(rs.getString("maM"));
                h.setTenM(rs.getString("tenM"));
                
                danhsach1.add(h);
            }
            ps.close();
            rs.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return danhsach1;
    }
     public void ThemMoi(Mon h){
         String sql= "insert into mon (maM, tenM) values (?,?)";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(1, h.getMaM());
            ps.setString(2, h.getTenM());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     public void CapNhat(Mon h){
         String sql= "update  mon set tenM=? where maM=? ";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(2, h.getMaM());
            ps.setString(1, h.getTenM());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     public void Xoa(Mon h){
         String sql= "delete from mon where maM=?";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(1, h.getMaM());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
}
