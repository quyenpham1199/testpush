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
public class Diem {
    private String maM;
    private String maHS;
    private String hocky;
    private float diemmieng;
    private float diem15;
    private float diem45;
    private float diemhocky;

    public String getMaM() {
        return maM;
    }

    public void setMaM(String maM) {
        this.maM = maM;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getHocky() {
        return hocky;
    }

    public void setHocky(String hocky) {
        this.hocky = hocky;
    }

    public float getDiemmieng() {
        return diemmieng;
    }

    public void setDiemmieng(float diemmieng) {
        this.diemmieng = diemmieng;
    }

    public float getDiem15() {
        return diem15;
    }

    public void setDiem15(float diem15) {
        this.diem15 = diem15;
    }

    public float getDiem45() {
        return diem45;
    }

    public void setDiem45(float diem45) {
        this.diem45 = diem45;
    }

    public float getDiemhocky() {
        return diemhocky;
    }

    public void setDiemhocky(float diemhocky) {
        this.diemhocky = diemhocky;
    }

    public Diem(String maM, String maHS, String hocky, float diemmieng, float diem15, float diem45, float diemhocky) {
        this.maM = maM;
        this.maHS = maHS;
        this.hocky = hocky;
        this.diemmieng = diemmieng;
        this.diem15 = diem15;
        this.diem45 = diem45;
        this.diemhocky = diemhocky;
    }

    

    public Diem() {
    }
    
}
