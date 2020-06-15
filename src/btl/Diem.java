/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import controller.DiemCon;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pham Quyen
 */
public class Diem extends javax.swing.JFrame {
    private String[] tenDeCot={ "Ma Mon", "Ma Hoc Sinh", "Hoc Ky", "Diem Mieng", "Diem 15","Diem 45","Diem Hoc Ky"};
    private ArrayList<DoiTuong.Diem> danhsach1= new ArrayList<>();
    private DefaultTableModel model;

    /**
     * Creates new form Diem
     */
    public Diem() {
        initComponents();
        this.lbtaikhoan.setText(DangNhapJF.mauser);
        this.lbchucvu.setText(DangNhapJF.loaiuser);
        model= (DefaultTableModel) tblDanhSach.getModel();
        model.setColumnIdentifiers(tenDeCot);
                
        hienthi();
    }
    public void hienthi(){
        String taikhoan=lbtaikhoan.getText();
        String chucvu=lbchucvu.getText();
        String sql="select * from phancong inner join hocsinh on phancong.maLop = hocsinh.maLop inner join diem on diem.maHS = hocsinh.maHS where phancong.maGV='"+taikhoan+"'";
        System.out.println(sql);
        if(chucvu.equals("chủ nhiệm")){
            hienThiDanhSach(sql);
            System.out.println(sql);
        }else if(chucvu.equals("bộ môn")){
           hienThiDanhSach(sql);
         }else if(chucvu.equals("ad")){
           hienThiDanhSach("select * from diem");
         }
        else System.out.println("lỗi");
    }
    public int hienThiDanhSach(String sql){
        danhsach1= new DiemCon().layDanhSach1(sql);        
        model.setRowCount(0);
        for(DoiTuong.Diem h: danhsach1){
            model.addRow(new Object[]{
                h.getMaM(),h.getMaHS(), h.getHocky(),
                 h.getDiemmieng(),h.getDiem15(),
                 h.getDiem45(), h.getDiemhocky()
            }
                    );
        }
        return danhsach1.size();        
    }
    public void XoaText(){
        txtmaM.setText("");
        txtmaHS.setText("");
        txthocky.setText("");
        txtdiemmieng.setText("");
        txtdiem15.setText("");
        txtdiem45.setText("");
        txtdiemhocky.setText("");

    }
    public boolean checkchucvu(){
        ResultSet rs = new Connect().getData("Select * From phancong where maGV='"+lbtaikhoan.getText()+"'");
        String mamon=txtmaM.getText();
        int check=0;
        try {
            while(rs.next()){
                if(rs.getString("maM").equals(mamon)){
                check++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Diem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check>0;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmaM = new javax.swing.JTextField();
        txtmaHS = new javax.swing.JTextField();
        txthocky = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtdiemmieng = new javax.swing.JTextField();
        txtdiem15 = new javax.swing.JTextField();
        txtdiem45 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtdiemhocky = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbtaikhoan = new javax.swing.JLabel();
        lbchucvu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã môn");

        jLabel2.setText("Mã học sinh");

        jLabel3.setText("Học kỳ");

        jLabel4.setText("Điểm miệng");

        jLabel5.setText("Điểm 15");

        jLabel6.setText("Điểm 45");

        jButton1.setText("Thêm Mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cập Nhật");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Xoá");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSach);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("BẢNG ĐIỂM");

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton4.setText("Trang chủ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Điểm học kỳ");

        jLabel9.setText("tài khoản:");

        jLabel10.setText("chức vụ:");

        lbtaikhoan.setText("none");

        lbchucvu.setText("none");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbchucvu))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(lbtaikhoan)))
                .addGap(208, 208, 208))
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmaM)
                            .addComponent(txtmaHS)
                            .addComponent(txthocky, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtdiem15)
                                    .addComponent(txtdiem45)
                                    .addComponent(txtdiemmieng, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtdiemhocky, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lbtaikhoan))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lbchucvu))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdiemmieng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdiem15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jButton2))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdiem45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtmaM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtmaHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txthocky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtdiemhocky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //them
        String maM=null, maHS= null, hocky=null; float diemmieng=0, diem15=0, diem45= 0, diemhocky=0;
             
        
        boolean ok= true;
        if("".equals(txtmaM.getText())){
            JOptionPane.showMessageDialog(rootPane, "Ma mon khong duoc de trong");
            ok= false;
        }
        else {
            maM= txtmaM.getText();
        }
         if("".equals(txtmaHS.getText())){
            JOptionPane.showMessageDialog(rootPane, "Ma hoc sinh khong duoc de trong");
            ok= false;
        }
        else {
            maHS= txtmaHS.getText();
        }
         if("".equals(txthocky.getText())){
            JOptionPane.showMessageDialog(rootPane, "Hoc ky khong duoc de trong");
            ok= false;
        }
        else {
            hocky= txthocky.getText();
        }
            diemmieng = Float.parseFloat(txtdiemmieng.getText());
    
            diem15 = Float.parseFloat(txtdiem15.getText());
       
            diem45 = Float.parseFloat(txtdiem45.getText());
       
            diemhocky = Float.parseFloat(txtdiemhocky.getText());
        

        if(ok){
            if(checkchucvu()){
            DoiTuong.Diem h= new DoiTuong.Diem(maM,maHS, hocky,diemmieng,diem15, diem45, diemhocky);
            new DiemCon().ThemMoi(h);
            JOptionPane.showMessageDialog(rootPane, "Them moi thanh cong");
            danhsach1.add(h);
            hienThiDanhSach("select* from diem");
            XoaText();
            }else JOptionPane.showMessageDialog(rootPane, "bạn không phải giáo viên phụ trách môn học này!");
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMouseClicked
        // TODO add your handling code here:
        //click
        int viTri= tblDanhSach.getSelectedRow();
        DoiTuong.Diem h = danhsach1.get(viTri);
        txtmaM.setText(h.getMaM());
        txtmaHS.setText(h.getMaHS());
        txthocky.setText(h.getHocky());
        txtdiemmieng.setText("" + h.getDiemmieng());
        txtdiem15.setText("" + h.getDiem15());
        txtdiem45.setText("" + h.getDiem45());
        txtdiemhocky.setText("" + h.getDiemhocky());
        
    }//GEN-LAST:event_tblDanhSachMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //sua
        String maM=null; String maHS="", hocky="";
        float diemmieng=0, diem15=0, diem45= 0, diemhocky=0;
             
        
        boolean ok= true;
        if("".equals(txtmaM.getText())){
            JOptionPane.showMessageDialog(rootPane, "Ma mon khong duoc de trong");
            ok= false;
        }
        else {
            maM= txtmaM.getText();
        }
            diemmieng = Float.parseFloat(txtdiemmieng.getText());
        
         
            diem15 = Float.parseFloat(txtdiem15.getText());
        
            diem45 = Float.parseFloat(txtdiem45.getText());
        
            diemhocky = Float.parseFloat(txtdiemhocky.getText());

        if(ok){
            DoiTuong.Diem h= new DoiTuong.Diem(maM, maHS,hocky,diemmieng,diem15, diem45, diemhocky);
            new DiemCon().CapNhat(h);
            JOptionPane.showMessageDialog(rootPane, "cap nhat thanh cong");
            int viTri= tblDanhSach.getSelectedRow();
            danhsach1.remove(viTri);
            danhsach1.add(h);
            hienThiDanhSach("select* from diem");
            XoaText();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int viTri= tblDanhSach.getSelectedRow();
        DoiTuong.Diem h = danhsach1.get(viTri);
        new DiemCon().Xoa(h);
            JOptionPane.showMessageDialog(rootPane, "Xoa thanh cong");
            danhsach1.remove(viTri);
            hienThiDanhSach("select* from diem");
            XoaText();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String taikhoan=lbtaikhoan.getText();
        String chucvu=lbchucvu.getText();
        if(chucvu.equals("chủ nhiệm")){
            new GiaoVienForm().setVisible(true);
            this.dispose();
        }else if(chucvu.equals("bộ môn")){
           new trangchu().setVisible(true);
        this.dispose();
         }else if(chucvu.equals("ad")){
           new Admin().setVisible(true);
        this.dispose();
         }
      
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Diem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbchucvu;
    private javax.swing.JLabel lbtaikhoan;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtdiem15;
    private javax.swing.JTextField txtdiem45;
    private javax.swing.JTextField txtdiemhocky;
    private javax.swing.JTextField txtdiemmieng;
    private javax.swing.JTextField txthocky;
    private javax.swing.JTextField txtmaHS;
    private javax.swing.JTextField txtmaM;
    // End of variables declaration//GEN-END:variables
}