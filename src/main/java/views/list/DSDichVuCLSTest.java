package views.list;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.DichVuCLSModelTest;
import models.NhomDichVuCLSModelTest;
import controllers.DichVuCLSCtrlTest;
import controllers.NhomDichVuCLSCtrlTest;
import utils.DialogHelper;
import utils.Validator;

public class DSDichVuCLSTest extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    List<NhomDichVuCLSModelTest> dsNhomDichVu = new ArrayList<>();
    List<DichVuCLSModelTest> dsDichVu = new ArrayList<>();

    public DSDichVuCLSTest() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) tblDSDichVuKB.getModel();

            hienThiTatCaDichVu();
            hienThiDSNhomDichVu();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLSTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSNhomDichVu() {
        try {
            dsNhomDichVu = NhomDichVuCLSCtrlTest.timTatNhomDichVuCLS();
            cmbNhomDichVu.removeAllItems();
            cmbNhomDichVu.addItem("---Nhóm dịch vụ---");
            cmbTimKiemNhomDichVu.removeAllItems();
            cmbTimKiemNhomDichVu.addItem("---Nhóm dịch vụ---");
            dsNhomDichVu.forEach(ndv -> {
                if (ndv.getTrangThai().equals("Kích hoạt")) {
                    String nhomDichVu = ndv.getMaNhomDichVuCLS() + " " + ndv.getTenNhomDichVuCLS();
                    cmbNhomDichVu.addItem(nhomDichVu);
                    cmbTimKiemNhomDichVu.addItem(nhomDichVu);
                }

            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLSTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiTatCaDichVu() throws ClassNotFoundException {
        dsDichVu = DichVuCLSCtrlTest.timTatCaDichVu();

        tableModel.setRowCount(0);

        dsDichVu.forEach(dv -> {
            tableModel.addRow(new Object[]{dv.getMaDichVuCLS(), dv.getTenDichVuCLS(),
                dv.getTenNhomDichVuCLS(), dv.getGiaTien(), dv.getGiaBaoHiem(), dv.getTrangThai()});
        });
    }

    private void lamMoi() {
        txtMaDichVu.setText("");
        txtTenDichVu.setText("");
        //NhomDichVuComboBox.setSelectedIndex(0);
        txtGiaTien.setText("");
        txtGiaBaoHiem.setText("");
        cmbTrangThai.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblMaDichVu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSDichVuKB = new javax.swing.JTable();
        txtMaDichVu = new javax.swing.JTextField();
        txtTenDichVu = new javax.swing.JTextField();
        cmbTrangThai = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnxuatDS = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbNhomDichVu = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtGiaTien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGiaBaoHiem = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbTimKiemNhomDichVu = new javax.swing.JComboBox<>();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách dịch vụ cận lâm sàn");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 436));

        lblMaDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaDichVu.setText("Mã dịch vụ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên dịch vụ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Trạng thái");

        tblDSDichVuKB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Nhóm dịch vụ", "Giá tiền", "Giá bảo hiểm", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSDichVuKB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDSDichVuKB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSDichVuKBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSDichVuKB);

        txtMaDichVu.setEditable(false);

        cmbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kích hoạt", "Ẩn" }));

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

        btnxuatDS.setBackground(new java.awt.Color(0, 102, 255));
        btnxuatDS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxuatDS.setForeground(new java.awt.Color(255, 255, 255));
        btnxuatDS.setText("Xuất danh sách");
        btnxuatDS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnxuatDS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnxuatDS.setPreferredSize(new java.awt.Dimension(130, 30));
        btnxuatDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxuatDSActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(90, 30));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Nhóm dịch vụ");

        cmbNhomDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Nhóm dịch vụ---" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Giá tiền");

        txtGiaTien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGiaTienFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Giá bảo hiểm");

        txtGiaBaoHiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGiaBaoHiemFocusLost(evt);
            }
        });

        jPanel6.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("DANH SÁCH DỊCH VỤ CLS");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tìm kiếm");

        cmbTimKiemNhomDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Nhóm dịch vụ---" }));
        cmbTimKiemNhomDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTimKiemNhomDichVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(cmbTimKiemNhomDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbTimKiemNhomDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnxuatDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaDichVu)
                                    .addComponent(jLabel4))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbNhomDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGiaBaoHiem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaDichVu)
                    .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbNhomDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtGiaBaoHiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnxuatDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        try {
            lamMoi();
            hienThiDSNhomDichVu();
            hienThiTatCaDichVu();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (txtTenDichVu.getText().isEmpty()) {
            DialogHelper.showError("Tên dịch vụ không được để trống!");
        } else if (!txtMaDichVu.getText().isEmpty()) {
            DialogHelper.showError("Dịch vụ đã tồn tại");
        } else if (cmbNhomDichVu.getSelectedItem().toString().equals("---Nhóm dịch vụ---")) {
            DialogHelper.showError("Nhóm dịch vụ không được để trống");
        } else if (txtGiaTien.getText().isEmpty()) {
            DialogHelper.showError("Giá tiền không được để trống");
        } else if (txtGiaBaoHiem.getText().isEmpty()) {
            DialogHelper.showError("Giá bảo hiểm không được để trống");
        } else {
            try {
                String maDichVu = DichVuCLSCtrlTest.generateMaDichVuCLS();
                String tenDichVu = txtTenDichVu.getText();
                String maNhomDichVu = cmbNhomDichVu.getSelectedItem().toString();
                int giaTien = Integer.parseInt(txtGiaTien.getText());
                int giaBaoHiem = Integer.parseInt(txtGiaBaoHiem.getText());
                String trangThai = cmbTrangThai.getSelectedItem().toString();

                DichVuCLSModelTest dv = new DichVuCLSModelTest(maDichVu, tenDichVu, maNhomDichVu.split(" ")[0], giaTien, giaBaoHiem, trangThai);
                DichVuCLSCtrlTest.themDichVuCLS(dv);
                hienThiTatCaDichVu();
                lamMoi();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            String maDichVu = txtMaDichVu.getText();
            if (maDichVu.isEmpty()) {
                DialogHelper.showError("Chưa có dịch vụ được chọn");
            } else {
                if (DialogHelper.showConfirmation("Bạn có chắc muốn xóa dịch vụ cận lâm sàn này")) {
                    DichVuCLSCtrlTest.xoaDichVuCLS(maDichVu);
                    DialogHelper.showMessage("Xóa dịch vụ cận lâm sàn thành công!");
                    lamMoi();
                    hienThiTatCaDichVu();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (txtTenDichVu.getText().isEmpty()) {
                DialogHelper.showError("Tên dịch vụ không được để trống!");
            } else if (cmbNhomDichVu.getSelectedItem().toString().equals("---Nhóm dịch vụ---")) {
                DialogHelper.showError("Nhóm dịch vụ không được để trống");
            } else if (txtMaDichVu.getText().isEmpty()) {
                DialogHelper.showError("Mã dịch vụ không được để trống!");
            } else if (txtGiaTien.getText().isEmpty()) {
                DialogHelper.showError("Giá tiền không được để trống");
            } else if (txtGiaBaoHiem.getText().isEmpty()) {
                DialogHelper.showError("Giá bảo hiểm không được để trống");
            } else {
                if (DialogHelper.showConfirmation("Bạn có chắc muốn sửa dịch vụ cận lâm sàn này")) {
                    String maDichVu = txtMaDichVu.getText();
                    String tenDichVu = txtTenDichVu.getText();
                    String maNhomDichVu = cmbNhomDichVu.getSelectedItem().toString();
                    int giaTien = Integer.parseInt(txtGiaTien.getText());
                    int giaBaoHiem = Integer.parseInt(txtGiaBaoHiem.getText());
                    String trangThai = cmbTrangThai.getSelectedItem().toString();

                    DichVuCLSModelTest dv = new DichVuCLSModelTest(maDichVu, tenDichVu, maNhomDichVu.split(" ")[0], giaTien, giaBaoHiem, trangThai);
                    DichVuCLSCtrlTest.capNhatDichVuCLS(dv);
                    DialogHelper.showMessage("Sửa dịch vụ cận lâm sàn thành công!");
                    hienThiTatCaDichVu();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblDSDichVuKBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSDichVuKBMouseClicked
        int selectedIndex = tblDSDichVuKB.getSelectedRow();
        if (selectedIndex >= 0) {
            DichVuCLSModelTest dv = dsDichVu.get(selectedIndex);
            txtMaDichVu.setText(dv.getMaDichVuCLS());
            txtTenDichVu.setText(dv.getTenDichVuCLS());
            cmbNhomDichVu.setSelectedItem(dv.getMaNhomDichVuCLS() + " " + dv.getTenNhomDichVuCLS());
            txtGiaTien.setText(Integer.toString(dv.getGiaTien()));
            txtGiaBaoHiem.setText(Integer.toString(dv.getGiaBaoHiem()));
            cmbTrangThai.setSelectedItem(dv.getTrangThai());
        }
    }//GEN-LAST:event_tblDSDichVuKBMouseClicked

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        try {
            if (cmbTimKiemNhomDichVu.getSelectedItem() != null) {
                String timKiem = txtTimKiem.getText();
                String nhomDichVu = cmbTimKiemNhomDichVu.getSelectedItem().toString();
                if (timKiem.equals("")) {
                    hienThiTatCaDichVu();
                } else if (!timKiem.equals("") && nhomDichVu.equals("---Nhóm dịch vụ---")) {
                    dsDichVu = DichVuCLSCtrlTest.timTatCaDichVuTheoDK(timKiem, "---Nhóm dịch vụ---");
                    tableModel.setRowCount(0);

                    dsDichVu.forEach(dv -> {
                        tableModel.addRow(new Object[]{dv.getMaDichVuCLS(), dv.getTenDichVuCLS(),
                            dv.getTenNhomDichVuCLS(), dv.getGiaTien(), dv.getGiaBaoHiem(), dv.getTrangThai()});
                    });
                } else {
                    dsDichVu = DichVuCLSCtrlTest.timTatCaDichVuTheoDK(timKiem, nhomDichVu.split(" ")[0]);
                    tableModel.setRowCount(0);

                    dsDichVu.forEach(dv -> {
                        tableModel.addRow(new Object[]{dv.getMaDichVuCLS(), dv.getTenDichVuCLS(),
                            dv.getTenNhomDichVuCLS(), dv.getGiaTien(), dv.getGiaBaoHiem(), dv.getTrangThai()});
                    });
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void btnxuatDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxuatDSActionPerformed
        try {
            dsDichVu = DichVuCLSCtrlTest.timTatCaDichVu();
            DichVuCLSCtrlTest.exportToExcel(dsDichVu, "src/main/java/files/DSDichVuCLS.xlsx");
            DialogHelper.showMessage("Xuất danh sách thành công!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnxuatDSActionPerformed

    private void txtGiaBaoHiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaBaoHiemFocusLost
        String giaBH = txtGiaBaoHiem.getText();
        if (!giaBH.isEmpty() && !Validator.isIntegerString(giaBH)) {
            DialogHelper.showError("Giá bảo hiểm không hợp lệ");
            txtGiaBaoHiem.requestFocus();
        }
    }//GEN-LAST:event_txtGiaBaoHiemFocusLost

    private void txtGiaTienFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaTienFocusLost
        String giaTien = txtGiaTien.getText();
        if (!giaTien.isEmpty() && !Validator.isIntegerString(giaTien)) {
            DialogHelper.showError("Giá tiền không hợp lệ");
            txtGiaTien.requestFocus();
        }
    }//GEN-LAST:event_txtGiaTienFocusLost

    private void cmbTimKiemNhomDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTimKiemNhomDichVuActionPerformed
        try {
            if (cmbTimKiemNhomDichVu.getSelectedItem() != null) {
                String timKiem = txtTimKiem.getText();
                String nhomDichVu = cmbTimKiemNhomDichVu.getSelectedItem().toString();
                if (nhomDichVu.equals("---Nhóm dịch vụ---")) {
                    hienThiTatCaDichVu();
                } else {
                    dsDichVu = DichVuCLSCtrlTest.timTatCaDichVuTheoDK(timKiem, nhomDichVu.split(" ")[0]);
                    tableModel.setRowCount(0);

                    dsDichVu.forEach(dv -> {
                        tableModel.addRow(new Object[]{dv.getMaDichVuCLS(), dv.getTenDichVuCLS(),
                            dv.getTenNhomDichVuCLS(), dv.getGiaTien(), dv.getGiaBaoHiem(), dv.getTrangThai()});
                    });
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbTimKiemNhomDichVuActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSDichVuCLSTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnxuatDS;
    private javax.swing.JComboBox<String> cmbNhomDichVu;
    private javax.swing.JComboBox<String> cmbTimKiemNhomDichVu;
    private javax.swing.JComboBox<String> cmbTrangThai;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMaDichVu;
    private javax.swing.JTable tblDSDichVuKB;
    private javax.swing.JTextField txtGiaBaoHiem;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtMaDichVu;
    private javax.swing.JTextField txtTenDichVu;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}