package views.list;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.NhomDichVuCLSModelTest;
import controllers.NhomDichVuCLSCtrlTest;
import utils.DialogHelper;

public class DSNhomDichVuCLSTest extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    List<NhomDichVuCLSModelTest> dsNhomDichVu = new ArrayList<>();

    public DSNhomDichVuCLSTest() {
        initComponents();

        tableModel = (DefaultTableModel) tbldsNhomDichVuKB.getModel();

        try {
            hienThiTatCaNhomDichVu();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSNhomDichVuCLSTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiTatCaNhomDichVu() throws ClassNotFoundException {

        dsNhomDichVu = NhomDichVuCLSCtrlTest.timTatNhomDichVuCLS();
        tableModel.setRowCount(0);

        dsNhomDichVu.forEach(ndv -> {
            tableModel.addRow(new Object[]{ndv.getMaNhomDichVuCLS(), ndv.getTenNhomDichVuCLS(),
                ndv.getTrangThai()});
        });
    }

    private void lamMoi() {
        txtMaNhomDichVuCLS.setText("");
        txtTenNhomDichVuCLS.setText("");
        cmbtrangthai.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblMaNhomDichVu = new javax.swing.JLabel();
        lblTenNhomDichVu = new javax.swing.JLabel();
        lbltrangthai = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldsNhomDichVuKB = new javax.swing.JTable();
        txtMaNhomDichVuCLS = new javax.swing.JTextField();
        txtTenNhomDichVuCLS = new javax.swing.JTextField();
        cmbtrangthai = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lbldanhsachnhomdichvucls = new javax.swing.JLabel();
        txttimKiem = new javax.swing.JTextField();
        lbltimkiem = new javax.swing.JLabel();
        btnNhapMoi = new javax.swing.JButton();
        btnxuatDS = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách nhóm dịch vụ cận lâm sàn");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblMaNhomDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaNhomDichVu.setText("Mã nhóm dịch vụ");

        lblTenNhomDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTenNhomDichVu.setText("Tên nhóm dịch vụ");

        lbltrangthai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbltrangthai.setText("Trạng thái");

        tbldsNhomDichVuKB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã nhóm dịch vụ", "Tên nhóm dịch vụ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbldsNhomDichVuKB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbldsNhomDichVuKB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldsNhomDichVuKBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldsNhomDichVuKB);

        txtMaNhomDichVuCLS.setEditable(false);

        cmbtrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kích hoạt", "Ẩn" }));

        btnThem.setBackground(new java.awt.Color(0, 102, 255));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.setPreferredSize(new java.awt.Dimension(70, 30));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(0, 102, 255));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.setPreferredSize(new java.awt.Dimension(70, 30));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 102, 255));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.setPreferredSize(new java.awt.Dimension(70, 30));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jPanel6.setPreferredSize(new java.awt.Dimension(88, 35));

        lbldanhsachnhomdichvucls.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbldanhsachnhomdichvucls.setText("DANH SÁCH NHÓM DỊCH VỤ CLS");

        txttimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttimKiemKeyTyped(evt);
            }
        });

        lbltimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbltimkiem.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbldanhsachnhomdichvucls)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltimkiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldanhsachnhomdichvucls)
                    .addComponent(txttimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltimkiem))
                .addGap(10, 10, 10))
        );

        btnNhapMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnNhapMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhapMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapMoi.setText("Làm mới");
        btnNhapMoi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNhapMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapMoi.setPreferredSize(new java.awt.Dimension(80, 30));
        btnNhapMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapMoiActionPerformed(evt);
            }
        });

        btnxuatDS.setBackground(new java.awt.Color(0, 102, 255));
        btnxuatDS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxuatDS.setForeground(new java.awt.Color(255, 255, 255));
        btnxuatDS.setText("Xuất danh sách");
        btnxuatDS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnxuatDS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnxuatDS.setPreferredSize(new java.awt.Dimension(120, 30));
        btnxuatDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxuatDSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnNhapMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnxuatDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTenNhomDichVu)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbltrangthai)
                                        .addComponent(lblMaNhomDichVu)))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaNhomDichVuCLS, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenNhomDichVuCLS, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaNhomDichVu)
                    .addComponent(txtMaNhomDichVuCLS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenNhomDichVu)
                    .addComponent(txtTenNhomDichVuCLS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltrangthai)
                    .addComponent(cmbtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhapMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnxuatDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhapMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapMoiActionPerformed
        try {
            lamMoi();
            hienThiTatCaNhomDichVu();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSNhomDichVuCLSTest.class.getName()).log(Level.SEVERE, null, ex);

        }

    }//GEN-LAST:event_btnNhapMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (txtTenNhomDichVuCLS.getText().isEmpty()) {
            DialogHelper.showError("Tên nhóm dịch vụ không được để trống!");
        } else if (!txtMaNhomDichVuCLS.getText().isEmpty()) {
            DialogHelper.showError("Nhóm dịch vụ đã tồn tại");
        } else {
            try {
                String maNhomDichVuCLS = NhomDichVuCLSCtrlTest.generateMaNhomDichVuCLS();
                String tenNhomDichVuCLS = txtTenNhomDichVuCLS.getText();
                String trangThai = cmbtrangthai.getSelectedItem().toString();

                NhomDichVuCLSModelTest ndv = new NhomDichVuCLSModelTest(maNhomDichVuCLS, tenNhomDichVuCLS, trangThai);
                NhomDichVuCLSCtrlTest.themNhomDichVuCLS(ndv);
                lamMoi();
                hienThiTatCaNhomDichVu();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DSNhomDichVuCLSTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            String maNhomDichVu = txtMaNhomDichVuCLS.getText();
            if (maNhomDichVu.isEmpty()) {
                DialogHelper.showError("Chưa có nhóm dịch vụ được chọn");
            } else {
                if (DialogHelper.showConfirmation("Bạn có chắc muốn xóa nhóm dịch vụ cận lâm sàn này")) {
                    NhomDichVuCLSCtrlTest.xoaNhomDichVuCLS(maNhomDichVu);
                    DialogHelper.showMessage("Xóa nhóm dịch vụ cận lâm sàn thành công!");
                    lamMoi();
                    hienThiTatCaNhomDichVu();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSNhomDichVuCLSTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (txtMaNhomDichVuCLS.getText().isEmpty()) {
                DialogHelper.showError("Mã nhóm dịch vụ không được để trống!");
            } else if (txtTenNhomDichVuCLS.getText().isEmpty()) {
                DialogHelper.showError("Tên nhóm dịch vụ không được để trống!");
            } else {
                if (DialogHelper.showConfirmation("Bạn có chắc muốn sửa nhóm dịch vụ cận lâm sàn này")) {
                    String maNhomDichVuCLS = txtMaNhomDichVuCLS.getText();
                    String tenNhomDichVuCLS = txtTenNhomDichVuCLS.getText();
                    String trangThai = cmbtrangthai.getSelectedItem().toString();

                    NhomDichVuCLSModelTest ndv = new NhomDichVuCLSModelTest(maNhomDichVuCLS, tenNhomDichVuCLS, trangThai);
                    NhomDichVuCLSCtrlTest.CapNhatNhomDichVuCLS(ndv);
                    DialogHelper.showMessage("Sửa nhóm dịch vụ cận lâm sàn thành công!");
                    hienThiTatCaNhomDichVu();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSNhomDichVuCLSTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tbldsNhomDichVuKBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldsNhomDichVuKBMouseClicked
        int selectedIndex = tbldsNhomDichVuKB.getSelectedRow();
        if (selectedIndex >= 0) {
            NhomDichVuCLSModelTest ndv = dsNhomDichVu.get(selectedIndex);

            txtMaNhomDichVuCLS.setText(ndv.getMaNhomDichVuCLS());
            txtTenNhomDichVuCLS.setText(ndv.getTenNhomDichVuCLS());
            cmbtrangthai.setSelectedItem(ndv.getTrangThai());
        }
    }//GEN-LAST:event_tbldsNhomDichVuKBMouseClicked

    private void btnxuatDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxuatDSActionPerformed

    }//GEN-LAST:event_btnxuatDSActionPerformed

    private void txttimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimKiemKeyTyped
        try {
            String timKiem = txttimKiem.getText();
            if (timKiem.equals("")) {
                hienThiTatCaNhomDichVu();
            } else {
                dsNhomDichVu = new ArrayList<>();
                dsNhomDichVu = NhomDichVuCLSCtrlTest.timTatCaDichVuTheoDK(timKiem);
                tableModel.setRowCount(0);

                dsNhomDichVu.forEach(ndv -> {
                    tableModel.addRow(new Object[]{ndv.getMaNhomDichVuCLS(), ndv.getTenNhomDichVuCLS(),
                        ndv.getTrangThai()});
                });
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txttimKiemKeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSNhomDichVuCLSTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhapMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnxuatDS;
    private javax.swing.JComboBox<String> cmbtrangthai;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMaNhomDichVu;
    private javax.swing.JLabel lblTenNhomDichVu;
    private javax.swing.JLabel lbldanhsachnhomdichvucls;
    private javax.swing.JLabel lbltimkiem;
    private javax.swing.JLabel lbltrangthai;
    private javax.swing.JTable tbldsNhomDichVuKB;
    private javax.swing.JTextField txtMaNhomDichVuCLS;
    private javax.swing.JTextField txtTenNhomDichVuCLS;
    private javax.swing.JTextField txttimKiem;
    // End of variables declaration//GEN-END:variables
}
