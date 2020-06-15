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
public class HocKy {
    private String hocky;
    private String maHS;
    private String renluyen;
    private String khenthuong;
    private String totnghiep;
    private int namhoc;

    public String getHocky() {
        return hocky;
    }

    public void setHocky(String hocky) {
        this.hocky = hocky;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getRenluyen() {
        return renluyen;
    }

    public void setRenluyen(String renluyen) {
        this.renluyen = renluyen;
    }

    public String getKhenthuong() {
        return khenthuong;
    }

    public void setKhenthuong(String khenthuong) {
        this.khenthuong = khenthuong;
    }

    public String getTotnghiep() {
        return totnghiep;
    }

    public void setTotnghiep(String totnghiep) {
        this.totnghiep = totnghiep;
    }

    public int getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(int namhoc) {
        this.namhoc = namhoc;
    }

    public HocKy(String hocky, String maHS, String renluyen, String khenthuong, String totnghiep, int namhoc) {
        this.hocky = hocky;
        this.maHS = maHS;
        this.renluyen = renluyen;
        this.khenthuong = khenthuong;
        this.totnghiep = totnghiep;
        this.namhoc = namhoc;
    }

   
    public HocKy() {
    }
}
