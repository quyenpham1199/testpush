/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import btl.Connect;
/**
 *
 * @author Pham Quyen
 */
public class HocSinhCon {
    Connect con = new Connect();
    public ArrayList<DoiTuong.HocSinh> layDanhSach(String sql){
        ArrayList<DoiTuong.HocSinh> danhsach= new ArrayList<>();
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                DoiTuong.HocSinh h = new DoiTuong.HocSinh();
                h.setMaHS(rs.getString("maHS"));
                h.setMaLop(rs.getString("maLop"));
                h.setTenHS(rs.getString("tenHS"));
                h.setNgaysinh(rs.getString("ngaysinh"));
                h.setDiachi(rs.getString("diachi"));
                h.setMaM(rs.getString("maM"));
                danhsach.add(h);
            }
            ps.close();
            rs.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return danhsach;
    }
     public void ThemMoi(DoiTuong.HocSinh h){
         String sql= "insert into hocsinh (maHS, maLop,tenHS, ngaysinh, diachi, maM) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(1, h.getMaHS());
            ps.setString(2, h.getMaLop());
            ps.setString(3, h.getTenHS());
            ps.setString(4, h.getNgaysinh());
            ps.setString(5, h.getDiachi());
            ps.setString(6, h.getMaM());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     public void CapNhat(DoiTuong.HocSinh h){
         String sql= "update  hocsinh set maLop=?, tenHS=?, ngaysinh=?, diachi=?, maM=?  where maHS=?";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(6, h.getMaHS());
            ps.setString(1, h.getMaLop());
            ps.setString(2, h.getTenHS());
            ps.setString(3, h.getNgaysinh());
            ps.setString(4, h.getDiachi());
            ps.setString(5, h.getMaM());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     public void Xoa(DoiTuong.HocSinh h){
         String sql= "delete from hocsinh where maHS=?";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(1, h.getMaHS());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
}
