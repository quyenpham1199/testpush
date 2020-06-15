/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import DoiTuong.ToTruong;
import btl.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pham Quyen
 */
public class ToTruongCon {
     Connect con = new Connect();
    public ArrayList<ToTruong> layDanhSach1(String sql){
        ArrayList<ToTruong> danhsach1= new ArrayList<>();
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                ToTruong h = new ToTruong();
                h.setMaGV(rs.getString("maGV"));
                h.setMaLop(rs.getString("maLop"));
                h.setChucvu(rs.getString("chucvu"));
                h.setMaM(rs.getString("maM"));
                h.setMaPC(rs.getString("maPC"));
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
     public void ThemMoi(ToTruong h){
         String sql= "insert into phancong (maGV,maLop, chucvu,maM, maPC) values (?,?,?,?,?)";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(1, h.getMaGV());
            ps.setString(2, h.getMaLop());
            ps.setString(3, h.getChucvu());
            ps.setString(4, h.getMaM());
            ps.setString(5, h.getMaPC());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     public void CapNhat(ToTruong h){
         String sql= "update  phancong set maGV=?, maLop=?, chucvu=?,maM=? where maPC=? ";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(1, h.getMaGV());
            ps.setString(2, h.getMaLop());
            ps.setString(3, h.getChucvu());
            ps.setString(4, h.getMaM());
            ps.setString(5, h.getMaPC());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     public void Xoa(ToTruong h){
         String sql= "delete from phancong where maPC=?";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(1, h.getMaPC());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
    
}
