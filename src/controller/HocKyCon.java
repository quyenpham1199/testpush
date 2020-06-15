/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DoiTuong.HocKy;
import btl.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pham Quyen
 */
public class HocKyCon {
    Connect con = new Connect();
    public ArrayList<HocKy> layDanhSach1(String sql){
        ArrayList<HocKy> danhsach1= new ArrayList<>();
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                HocKy h = new HocKy();
                h.setHocky(rs.getString("hocky"));
                h.setMaHS(rs.getString("maHS"));
                h.setRenluyen(rs.getString("renluyen"));
                h.setKhenthuong(rs.getString("khenthuong"));
                h.setTotnghiep(rs.getString("totnghiep"));
                h.setNamhoc(rs.getInt("namhoc"));
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
     public void ThemMoi(HocKy h){
         String sql= "insert into hocky (hocky,maHS, renluyen,khenthuong, totnghiep, namhoc) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(1, h.getHocky());
            ps.setString(2, h.getMaHS());
            ps.setString(3, h.getRenluyen());
            ps.setString(4, h.getKhenthuong());
            ps.setString(5, h.getTotnghiep());
            ps.setInt(6, h.getNamhoc());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     public void CapNhat(HocKy h){
         String sql= "update  hocky set maHS=?, renluyen=?,khenthuong=?, totnghiep=?, namhoc=? where hocky=? ";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(6, h.getHocky());
            ps.setString(1, h.getMaHS());
            ps.setString(2, h.getRenluyen());
            ps.setString(3, h.getKhenthuong());
            ps.setString(4, h.getTotnghiep());
            ps.setInt(5, h.getNamhoc());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     public void Xoa(HocKy h){
         String sql= "delete from hocky where hocky=?";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(1, h.getHocky());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
}
