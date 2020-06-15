/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import DoiTuong.HocSinh;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controller.HocSinhCon;

/**
 *
 * @author Pham Quyen
 */
public class hocsinh extends javax.swing.JFrame {
    private String[] tenDeCot={ "Ma Hoc Sinh", "Ma Lop","Ten Hoc Sinh", "Ngay Sinh", "Dia Chi", "Ma Mon"};
    private ArrayList<HocSinh> danhsach= new ArrayList<>();
    private DefaultTableModel model;

    /**
     * Creates new form NewJFrame
     */
    public hocsinh() {
        initComponents();
        
        hienThiDanhSach("Select * from hocsinh");
    }
    public int hienThiDanhSach(String sql){  
        model= (DefaultTableModel) tblDanhSach.getModel();
        model.setColumnIdentifiers(tenDeCot);
        danhsach= new HocSinhCon().layDanhSach(sql);
        model.setRowCount(0);
        for(HocSinh h: danhsach){
           Object[] s={h.getMaHS(),h.getMaLop(), h.getTenHS(), h.getNgaysinh(), h.getDiachi(), h.getMaM()};
                   model.addRow(s);
        }
        return danhsach.size();
    }
    public void XoaText(){
        txtmaHS.setText("");
        txtmaLop.setText("");
        txttenHS.setText("");
        txtngaysinh.setText("");
        txtdiachi.setText("");
        txtmaM.setText("");

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        btnthem = new javax.swing.JButton();
        txtmaHS = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttenHS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtngaysinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtmaLop = new javax.swing.JTextField();
        t = new javax.swing.JLabel();
        txtmaM = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("HỌC SINH");

        jLabel2.setText("Mã học sinh");

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

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên học sinh");

        jLabel5.setText("Ngày sinh");

        jLabel6.setText("Địa chỉ");

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setText("Xoá");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setText("Quay lại");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel3.setText("Mã lớp");

        t.setText("Mã môn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(27, 27, 27)
                            .addComponent(txtmaHS, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(txttenHS)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(83, 83, 83)
                            .addComponent(txtmaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(t))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtmaM, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtdiachi, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                        .addComponent(txtngaysinh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnthem, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(btnsua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnxoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)
                        .addGap(296, 296, 296)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnthem, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(btnTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtmaHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(txttenHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtmaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(t))
                            .addComponent(txtmaM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        String maHS=null,maLop= null, tenHS= null, ngaysinh=null, diachi=null, maM=null;
        boolean ok= true;
        if("".equals(txtmaHS.getText())){
            JOptionPane.showMessageDialog(rootPane, "Mã học sinh không được để trống");
            ok= false;
        }
        else {
            maHS= txtmaHS.getText();
        }
        if("".equals(txtmaLop.getText())){
            JOptionPane.showMessageDialog(rootPane, "Mã lớp không được để trống");
            ok= false;
        }
        else {
            maLop= txtmaLop.getText();
        }
        
        if("".equals(txttenHS.getText())){
            JOptionPane.showMessageDialog(rootPane, "Tên học sinh không được để trống");
            ok= false;
        }
        else {
            tenHS= txttenHS.getText();
        }
        if("".equals(txtngaysinh.getText())){
            JOptionPane.showMessageDialog(rootPane, "Ngày sinh không được để trống");
            ok= false;
        }
        else {
            ngaysinh= txtngaysinh.getText();
        }
        if("".equals(txtdiachi.getText())){
            JOptionPane.showMessageDialog(rootPane, "Địa chỉ không được để trống");
            ok= false;
        }
        else {
            diachi= txtdiachi.getText();
        }
        if("".equals(txtmaM.getText())){
            JOptionPane.showMessageDialog(rootPane, "Mã môn không được để trống");
            ok= false;
        }
        else {
            maM= txtmaM.getText();
        }
        if(ok){
            HocSinh h= new HocSinh(maHS,maLop, tenHS, ngaysinh, diachi, maM);
            new HocSinhCon().ThemMoi(h);
            danhsach.add(h);
            hienThiDanhSach("Select * from hocsinh");
            XoaText();
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        String maHS=null,maLop=null,tenHS= null, ngaysinh=null, diachi=null, maM=null;
        boolean ok= true;
        if("".equals(txtmaHS.getText())){
            JOptionPane.showMessageDialog(rootPane, "Mã học sinh không được để trống");
            ok= false;
        }
        else {
            maHS= txtmaHS.getText();
        }
        if("".equals(txtmaLop.getText())){
            JOptionPane.showMessageDialog(rootPane, "Mã lớp không được để trống");
            ok= false;
        }
        else {
            maLop= txtmaLop.getText();
        }
        if("".equals(txttenHS.getText())){
            JOptionPane.showMessageDialog(rootPane, "Tên học sinh không được để trống");
            ok= false;
        }
        else {
            tenHS= txttenHS.getText();
        }
        if("".equals(txtngaysinh.getText())){
            JOptionPane.showMessageDialog(rootPane, "Ngày sinh không được để trống");
            ok= false;
        }
        else {
            ngaysinh= txtngaysinh.getText();
        }
        if("".equals(txtdiachi.getText())){
            JOptionPane.showMessageDialog(rootPane, "Địa chỉ không được để trống");
            ok= false;
        }
        else {
            diachi= txtdiachi.getText();
        }
        if("".equals(txtmaM.getText())){
            JOptionPane.showMessageDialog(rootPane, "Mã môn không được để trống");
            ok= false;
        }
        else {
            maM= txtmaM.getText();
        }
        if(ok){
            HocSinh h= new HocSinh(maHS,maLop, tenHS, ngaysinh, diachi, maM);
            new HocSinhCon().CapNhat(h);
            JOptionPane.showMessageDialog(rootPane, "cap nhat thanh cong");
            int viTri= tblDanhSach.getSelectedRow();
            danhsach.remove(viTri);
            danhsach.add(h);
            hienThiDanhSach("Select * from hocsinh");
            XoaText();
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void tblDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMouseClicked
        // TODO add your handling code here:
        int viTri= tblDanhSach.getSelectedRow();
        HocSinh h = danhsach.get(viTri);
        txtmaHS.setText(h.getMaHS());
        txtmaLop.setText(h.getMaLop());
        txttenHS.setText(h.getTenHS());
        txtngaysinh.setText(h.getNgaysinh());
        txtdiachi.setText(h.getDiachi());
        txtmaM.setText(h.getMaM());
    }//GEN-LAST:event_tblDanhSachMouseClicked

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        int viTri= tblDanhSach.getSelectedRow();
        HocSinh h = danhsach.get(viTri);
        new HocSinhCon().Xoa(h);
            JOptionPane.showMessageDialog(rootPane, "Xoa thanh cong");
            danhsach.remove(viTri);
            hienThiDanhSach("Select * from hocsinh");
            XoaText();
    }//GEN-LAST:event_btnxoaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new Admin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
            if(hienThiDanhSach("Select * from hocsinh where maHS='"+txtmaHS.getText()+"'")==0){
                JOptionPane.showMessageDialog(rootPane, "Không có mã học sinh "+txtmaHS.getText());
            } 
        
    }//GEN-LAST:event_btnTimActionPerformed

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
            java.util.logging.Logger.getLogger(hocsinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hocsinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hocsinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hocsinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hocsinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel t;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtmaHS;
    private javax.swing.JTextField txtmaLop;
    private javax.swing.JTextField txtmaM;
    private javax.swing.JTextField txtngaysinh;
    private javax.swing.JTextField txttenHS;
    // End of variables declaration//GEN-END:variables
}