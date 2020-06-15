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
public class HocSinh {
    private String maHS;
    private String maLop;
    private String tenHS;
    private String ngaysinh;
    private String diachi;
    private String maM;

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenHS() {
        return tenHS;
    }

    public void setTenHS(String tenHS) {
        this.tenHS = tenHS;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMaM() {
        return maM;
    }

    public void setMaM(String maM) {
        this.maM = maM;
    }

    public HocSinh(String maHS, String maLop, String tenHS, String ngaysinh, String diachi, String maM) {
        this.maHS = maHS;
        this.maLop = maLop;
        this.tenHS = tenHS;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.maM = maM;
    }

    
    

    public HocSinh() {
    }

    
}
