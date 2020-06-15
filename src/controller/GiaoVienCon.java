/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DoiTuong.GiaoVien;
import btl.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Pham Quyen
 */
public class GiaoVienCon {
    Connect con = new Connect();
    public ArrayList<GiaoVien> layDanhSach1(String sql){
        ArrayList<GiaoVien> danhsach1= new ArrayList<>();
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                GiaoVien h = new GiaoVien();
                h.setMaGV(rs.getString("maGV"));
                h.setTenGV(rs.getString("tenGV"));
                h.setNgaysinh(rs.getString("ngaysinh"));
                h.setDiachi(rs.getString("diachi"));
                h.setGioitinh(rs.getString("gioitinh"));
                h.setSodienthoai(rs.getString("sodienthoai"));
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
     public void ThemMoi(GiaoVien h){
         String sql= "insert into giaovien (maGV,tenGV, ngaysinh,diachi, gioitinh, sodienthoai) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(1, h.getMaGV());
            ps.setString(2, h.getTenGV());
            ps.setString(3, h.getNgaysinh());
            ps.setString(4, h.getDiachi());
            ps.setString(5, h.getGioitinh());
            ps.setString(6, h.getSodienthoai());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     public void CapNhat(GiaoVien h){
         String sql= "update  giaovien set tenGV=?, ngaysinh=?,diachi=?,gioitinh=?, sodienthoai=? where maGV=? ";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(6, h.getMaGV());
            ps.setString(1, h.getTenGV());
            ps.setString(2, h.getNgaysinh());
            ps.setString(3, h.getDiachi());
            ps.setString(4, h.getGioitinh());
            ps.setString(5, h.getSodienthoai());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     public void Xoa(GiaoVien h){
         String sql= "delete from giaovien where maGV=?";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(1, h.getMaGV());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
}
