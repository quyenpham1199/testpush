/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoiTuong;

/**
 *
 * @author Pham Quyen
 */
public class DangNhap {
    private String user;
    private String pass;
    private String loaitaikhoan;

    public DangNhap(String user, String pass, String loaitaikhoan) {
        this.user = user;
        this.pass = pass;
        this.loaitaikhoan = loaitaikhoan;
    }

    public DangNhap() {
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getLoaitaikhoan() {
        return loaitaikhoan;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setLoaitaikhoan(String loaitaikhoan) {
        this.loaitaikhoan = loaitaikhoan;
    }
    
}
