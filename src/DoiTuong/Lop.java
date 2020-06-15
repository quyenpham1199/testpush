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
public class Lop {
    private String maLop;
    private String tenLop;
    private String maGV;
    private int siso;

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public int getSiso() {
        return siso;
    }

    public void setSiso(int siso) {
        this.siso = siso;
    }

    public Lop(String maLop, String tenLop, String maGV, int siso) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maGV = maGV;
        this.siso = siso;
    }

    

    public Lop() {
    }

    
}
