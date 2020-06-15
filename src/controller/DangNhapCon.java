/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import btl.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DoiTuong.DangNhap;

/**
 *
 * @author Pham Quyen
 */
public class DangNhapCon {
    Connect con = new Connect();
    public ArrayList<DangNhap> layDanhSachtaikhoan(String sql){
        ArrayList<DangNhap> danhsach= new ArrayList<>();
        PreparedStatement ps;
          try {
              ps = con.conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                DoiTuong.DangNhap d = new DoiTuong.DangNhap();
                d.setUser(rs.getString("user"));
                d.setPass(rs.getString("pass"));
                d.setLoaitaikhoan(rs.getString("loaitaikhoan"));
                danhsach.add(d);
            }
            ps.close();
            rs.close();
            con.conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
          }
        return danhsach;
    }
    public void changepass(String user,String pass){
        String sql = "Update dangnhap set pass=? where user=?";
        try {
            PreparedStatement pr = con.conn.prepareStatement(sql);
            pr.setString(1, pass);
            pr.setString(2, user);
            pr.execute();
            pr.close();
            con.conn.close();            
        } catch (SQLException ex) {
            Logger.getLogger(DangNhapCon.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
