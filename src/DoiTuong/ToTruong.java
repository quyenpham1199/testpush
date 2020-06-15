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
public class ToTruong {
    
     private String maGV;
      private String maLop;
       private String chucvu;
        private String maM;
private String maPC;

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getMaM() {
        return maM;
    }

    public void setMaM(String maM) {
        this.maM = maM;
    }

    public String getMaPC() {
        return maPC;
    }

    public void setMaPC(String maPC) {
        this.maPC = maPC;
    }

    public ToTruong(String maGV, String maLop, String chucvu, String maM, String maPC) {
        this.maGV = maGV;
        this.maLop = maLop;
        this.chucvu = chucvu;
        this.maM = maM;
        this.maPC = maPC;
    }

   
    
    public ToTruong() {
    }
}
