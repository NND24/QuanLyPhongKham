package views.list;

import controllers.XepGiuongCtrl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.GiuongBenhModel;
import utils.DialogHelper;

/**
 *
 * @author Phu Bao
 */
public class DSGiuongBenhKhaDung extends javax.swing.JFrame {

    public static DSGiuongBenhKhaDung Instance;
    public JTextField txtMaXepGiuong;
    public JTextField txtMaGiuongBenhNhanDangDung;
    public JTextField txtTenLoaiPhong;

    DefaultTableModel tableModel;
    List<GiuongBenhModel> dsGiuongKhaDung = new ArrayList<>();

    public DSGiuongBenhKhaDung() {
        initComponents();
        tableModel = (DefaultTableModel) tblDanhSachGiuongBenhKhaDung.getModel();
        txtMaXepGiuong = txtMaXepGiuongBenhNhanDangDoi;
        txtMaGiuongBenhNhanDangDung = txtMaGiuong;
        txtTenLoaiPhong = txtLoaiPhong;
        Instance = this;
        try {
            hienThiGiuongBenhKhaDung();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSGiuongBenhKhaDung.class.getName()).log(Level.SEVERE, null, ex);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                setVisible(false);
            }
        });

    }

    private void hienThiGiuongBenhKhaDung() throws ClassNotFoundException {
        String loaiPhong = txtLoaiPhong.getText();
        dsGiuongKhaDung = XepGiuongCtrl.hienThiGiuongBenhKhaDung(loaiPhong);
        tableModel.setRowCount(0);
        dsGiuongKhaDung.forEach(xg -> {
            tableModel.addRow(new Object[]{xg.getMaGiuong(), xg.getMaPhong(),
                xg.getTenPhong(), xg.getTenLoaiPhong(), xg.getCoNguoi(), xg.getDonGia()});
        });
    }

    private void timKiemGiuongBenhKhaDung(String loaiPhong, String tuKhoa) throws ClassNotFoundException {
        dsGiuongKhaDung = XepGiuongCtrl.timKiemGiuongBenhKhaDung(loaiPhong, tuKhoa);
        tableModel.setRowCount(0);
        dsGiuongKhaDung.forEach(xg -> {
            tableModel.addRow(new Object[]{xg.getMaGiuong(), xg.getMaPhong(),
                xg.getTenPhong(), xg.getTenLoaiPhong(), xg.getCoNguoi(), xg.getDonGia()});
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblDanhSachGiuongBenhKhaDung = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaGiuong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaGiuongMoi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMaXepGiuongBenhNhanDangDoi = new javax.swing.JTextField();
        txtLoaiPhong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnTimPhong = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblDanhSachGiuongBenhKhaDung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblDanhSachGiuongBenhKhaDung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Giường", "Mã Phòng", "Tên Phòng", "Loại Phòng", "Có Người", "Đơn Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachGiuongBenhKhaDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachGiuongBenhKhaDungMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDanhSachGiuongBenhKhaDung);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đổi giường cho bệnh nhân", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã Giường");

        txtMaGiuong.setEditable(false);
        txtMaGiuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaGiuong.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mã Giường Mới");

        txtMaGiuongMoi.setEditable(false);
        txtMaGiuongMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaGiuongMoi.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mã Xếp Giường");

        txtMaXepGiuongBenhNhanDangDoi.setEditable(false);
        txtMaXepGiuongBenhNhanDangDoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaXepGiuongBenhNhanDangDoi.setPreferredSize(new java.awt.Dimension(150, 25));

        txtLoaiPhong.setEditable(false);
        txtLoaiPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLoaiPhong.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Loại Phòng");

        btnTimPhong.setBackground(new java.awt.Color(0, 102, 255));
        btnTimPhong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTimPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnTimPhong.setText("Tìm Phòng");
        btnTimPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimPhongActionPerformed(evt);
            }
        });

        btnXacNhan.setBackground(new java.awt.Color(0, 102, 255));
        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tìm kiếm");

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiem.setPreferredSize(new java.awt.Dimension(64, 25));
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTimPhong)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoi)
                        .addGap(18, 18, 18)
                        .addComponent(btnXacNhan))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaGiuongMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaGiuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLoaiPhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(txtMaXepGiuongBenhNhanDangDoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaXepGiuongBenhNhanDangDoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaGiuongMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTimPhong)
                            .addComponent(btnXacNhan)
                            .addComponent(jLabel2)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLamMoi))
                        .addGap(38, 38, 38))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void lamMoi() {
        try {
            hienThiGiuongBenhKhaDung();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSGiuongBenhKhaDung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnTimPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimPhongActionPerformed
        lamMoi();
    }//GEN-LAST:event_btnTimPhongActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tblDanhSachGiuongBenhKhaDung.getSelectedRow();
        if (selectedIndex >= 0) {
            GiuongBenhModel gb = dsGiuongKhaDung.get(selectedIndex);
            String maGiuongHienTai = txtMaGiuong.getText();
            String maGiuongMuonDoi = txtMaGiuongMoi.getText();
            String maXepGiuong = txtMaXepGiuong.getText();
            try {
                if (XepGiuongCtrl.loaiPhong(maGiuongHienTai).equals(XepGiuongCtrl.loaiPhong(maGiuongMuonDoi))) {
                    XepGiuongCtrl.doiGiuongBenh(maGiuongHienTai, maGiuongMuonDoi, maXepGiuong);
                    DialogHelper.showMessage("Cập nhật giường bệnh mới cho bệnh nhân thành công");

                } else {
                    DialogHelper.showError("Phòng đổi không hợp lệ!\nVui lòng ấn nút Làm Mới hoặc Tìm phòng rồi chọn lại");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DSGiuongBenhKhaDung.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (tblDanhSachGiuongBenhKhaDung.getRowCount() == 0) {
            DialogHelper.showError("Vui lòng ấn nút Làm Mới hoặc Tìm phòng để tiếp tục");
        } else {
            DialogHelper.showError("Chưa có dòng nào trong bảng được chọn");
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        // TODO add your handling code here:
        String loaiPhong = txtLoaiPhong.getText();
        String tuKhoa = txtTimKiem.getText();
        try {
            if (loaiPhong.isEmpty()) {
                hienThiGiuongBenhKhaDung();
            } else {
                timKiemGiuongBenhKhaDung(loaiPhong, tuKhoa);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSGiuongBenhKhaDung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void tblDanhSachGiuongBenhKhaDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachGiuongBenhKhaDungMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblDanhSachGiuongBenhKhaDung.getSelectedRow();
        if (selectedRow >= 0) {
            GiuongBenhModel gb = dsGiuongKhaDung.get(selectedRow);
            txtMaGiuongMoi.setText(gb.getMaGiuong());
        } else {
            DialogHelper.showError("Chưa có giường nào được chọn");
        }
    }//GEN-LAST:event_tblDanhSachGiuongBenhKhaDungMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        lamMoi();
        txtTimKiem.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

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
            java.util.logging.Logger.getLogger(DSGiuongBenhKhaDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DSGiuongBenhKhaDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DSGiuongBenhKhaDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DSGiuongBenhKhaDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSGiuongBenhKhaDung().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTimPhong;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblDanhSachGiuongBenhKhaDung;
    private javax.swing.JTextField txtLoaiPhong;
    private javax.swing.JTextField txtMaGiuong;
    private javax.swing.JTextField txtMaGiuongMoi;
    private javax.swing.JTextField txtMaXepGiuongBenhNhanDangDoi;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
