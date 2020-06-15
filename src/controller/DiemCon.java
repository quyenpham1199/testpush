/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DoiTuong.Diem;
import btl.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pham Quyen
 */
public class DiemCon {
    Connect con = new Connect();
    public ArrayList<Diem> layDanhSach1(String sql){
        ArrayList<Diem> danhsach1= new ArrayList<>();
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Diem h = new Diem();
                h.setMaM(rs.getString("maM"));
                h.setMaHS(rs.getString("maHS"));
                h.setHocky(rs.getString("hocky"));
                h.setDiemmieng(rs.getFloat("diemmieng"));
                h.setDiem15(rs.getFloat("diem15"));
                h.setDiem45(rs.getFloat("diem45"));
                h.setDiemhocky(rs.getFloat("diemhocky"));
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
     public void ThemMoi(Diem h){
         String sql= "insert into diem (maM,maHS, hocky,diemmieng,diem15, diem45,diemhocky) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(1, h.getMaM());
            ps.setString(2, h.getMaHS());
            ps.setString(3, h.getHocky());
            ps.setFloat(4, h.getDiemmieng());
            ps.setFloat(5, h.getDiem15());
            ps.setFloat(6, h.getDiem45());
            ps.setFloat(7, h.getDiemhocky());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     public void CapNhat(Diem h){
         String sql= "update  diem set maHS=?, hocky=?,diemmieng=?,diem15=?, diem45=?, diemhocky=? where maM=? ";
        try {
            PreparedStatement ps= con.conn.prepareStatement(sql);
            ps.setString(7, h.getMaM());
            ps.setString(1, h.getMaHS());
            ps.setString(2, h.getHocky());
            ps.setFloat(3, h.getDiemmieng());
            ps.setFloat(4, h.getDiem15());
            ps.setFloat(5, h.getDiem45());
            ps.setFloat(6, h.getDiemhocky());
            ps.executeUpdate();
            ps.close();
            con.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     public void Xoa(Diem h){
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
