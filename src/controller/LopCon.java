/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DoiTuong.Lop;
import btl.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pham Quyen
 */
public class LopCon {
    Connect con = new Connect();
    public ArrayList<Lop> layDanhSach1(String sql){
        ArrayList<Lop> danhsach1= new ArrayList<>();
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Lop h = new Lop();
                h.setMaLop(rs.getString("maLop"));
                h.setTenLop(rs.getString("tenLop"));
                 h.setMaGV(rs.getString("maGV"));
                h.setSiso(rs.getInt("siso"));
                
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
     public void ThemMoi(Lop h){
         String sql= "insert into lop (maLop, tenLop,maGV, siso) values (?,?,?,?)";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(1, h.getMaLop());
            ps.setString(2, h.getTenLop());
            ps.setString(3, h.getMaGV());
            ps.setInt(4, h.getSiso());
            
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     public void CapNhat(Lop h){
         String sql= "update  lop set tenLop=?, maGV=?, siso=? where maLop=? ";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(4, h.getMaLop());
            ps.setString(1, h.getTenLop());
            ps.setString(2, h.getMaGV());
            ps.setString(3, Integer.toString(h.getSiso()));
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     public void Xoa(Lop h){
         String sql= "delete from lop where maLop=?";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(1, h.getMaLop());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
    
}
