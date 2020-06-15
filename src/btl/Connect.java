/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;
import java.sql.*;
import DoiTuong.GiaoVien;
import DoiTuong.HocSinh;
import DoiTuong.DangNhap;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pham Quyen
 */
public class Connect {
    public Connection conn=null;
    public Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydiemthpt", "root", "");
            System.out.println("Ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            System.out.println("ket noi that bai");
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet getData(String sql){
        Statement st=null;
        ResultSet rs=null;
        try {
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
            return rs;
    }
     
}
