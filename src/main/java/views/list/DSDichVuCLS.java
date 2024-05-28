package views.list;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.DichVuCLSModel;
import models.NhomDichVuCLSModel;
import controllers.DichVuCLSCtrl;
import controllers.NhomDichVuCLSCtrl;
import utils.DialogHelper;
import utils.GenerateCode;
import utils.Validator;

public class DSDichVuCLS extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    List<NhomDichVuCLSModel> dsNhomDichVu = new ArrayList<>();
    List<DichVuCLSModel> dsDichVu = new ArrayList<>();

    public DSDichVuCLS() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) tblDSDichVuKB.getModel();
            dsDichVu = DichVuCLSCtrl.timTatCaDichVu();

            timKiemDVCLS();
            hienThiDSNhomDichVu();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSNhomDichVu() {
        try {
            dsNhomDichVu = NhomDichVuCLSCtrl.timTatNhomDichVuCLS();
            cmbNhomDichVu.removeAllItems();
            cmbTKNhomDichVu.removeAllItems();
            dsNhomDichVu.forEach(ndv -> {
                if (ndv.getTrangThai().equals("Kích hoạt")) {
                    cmbNhomDichVu.addItem(ndv.getTenNhomDichVuCLS());
                    cmbTKNhomDichVu.addItem(ndv.getTenNhomDichVuCLS());
                }
            });
            cmbNhomDichVu.addItem("---Nhóm dịch vụ---");
            cmbNhomDichVu.setSelectedItem("---Nhóm dịch vụ---");
            cmbTKNhomDichVu.addItem("---Nhóm dịch vụ---");
            cmbTKNhomDichVu.setSelectedItem("---Nhóm dịch vụ---");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSDichVu() throws ClassNotFoundException {

        tableModel.setRowCount(0);

        dsDichVu.forEach(dv -> {
            tableModel.addRow(new Object[]{dv.getMaDichVuCLS(), dv.getTenDichVuCLS(),
                dv.getTenNhomDichVuCLS(), dv.getGiaTien(), dv.getGiaBaoHiem(), dv.getTrangThai()});
        });
    }

    private void lamMoi() {
        txtMaDichVu.setText("");
        txtTenDichVu.setText("");
        cmbNhomDichVu.setSelectedItem("---Nhóm dịch vụ---");
        txtGiaTien.setText("");
        txtGiaBaoHiem.setText("");
        cmbTrangThai.setSelectedIndex(0);
    }

    private void timKiemDVCLS() {
        try {
            if (cmbTKNhomDichVu.getSelectedItem() != null) {
                String timKiem = txtTimKiem.getText();
                if (timKiem.equals("") && cmbTKNhomDichVu.getSelectedItem().toString().equals("---Nhóm dịch vụ---")) {
                    dsDichVu = DichVuCLSCtrl.timTatCaDichVu();
                    hienThiDSDichVu();
                    return;
                }

                String maNhomDichVu = "";
                if (cmbTKNhomDichVu.getSelectedItem().toString().equals("---Nhóm dịch vụ---")) {
                    maNhomDichVu = "---Nhóm dịch vụ---";
                } else {
                    int nhomDichVuId = cmbTKNhomDichVu.getSelectedIndex();
                    maNhomDichVu = dsNhomDichVu.get(nhomDichVuId).getMaNhomDichVuCLS();
                }
                dsDichVu = DichVuCLSCtrl.timTatCaDichVuTheoDK(timKiem, maNhomDichVu);
                hienThiDSDichVu();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        cmbTKNhomDichVu = new javax.swing.JComboBox<>();

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Giá bảo hiểm");

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

        cmbTKNhomDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Nhóm dịch vụ---" }));
        cmbTKNhomDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKNhomDichVuActionPerformed(evt);
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
                .addComponent(cmbTKNhomDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(cmbTKNhomDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        lamMoi();
        cmbTKNhomDichVu.setSelectedItem("---Nhóm dịch vụ---");
        txtTimKiem.setText("");
        timKiemDVCLS();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            String maDichVu = GenerateCode.generateMa("DVC");
            if (DichVuCLSCtrl.kiemTraMaDVCLSTonTai(maDichVu)) {
                DialogHelper.showError("Mã dịch vụ cận lâm sàng đã tồn tại");
            } else if (!txtMaDichVu.getText().isEmpty()) {
                DialogHelper.showError("Dịch vụ cận lâm sàng đã tồn tại");
            } else if (txtTenDichVu.getText().isEmpty()) {
                DialogHelper.showError("Tên dịch vụ không được để trống!");
            } else if (cmbNhomDichVu.getSelectedItem().toString().equals("---Nhóm dịch vụ---")) {
                DialogHelper.showError("Nhóm dịch vụ không được để trống");
            } else if (txtGiaTien.getText().isEmpty()) {
                DialogHelper.showError("Giá tiền không được để trống");
            } else if (!txtGiaTien.getText().isEmpty() && !Validator.isIntegerString(txtGiaTien.getText())) {
                DialogHelper.showError("Giá tiền không hợp lệ");
            } else if (txtGiaBaoHiem.getText().isEmpty()) {
                DialogHelper.showError("Giá bảo hiểm không được để trống");
            } else if (!txtGiaBaoHiem.getText().isEmpty() && !Validator.isIntegerString(txtGiaBaoHiem.getText())) {
                DialogHelper.showError("Giá bảo hiểm không hợp lệ");
            } else {
                String tenDichVu = txtTenDichVu.getText();
                int nhomDichVuId = cmbNhomDichVu.getSelectedIndex();
                String maNhomDichVu = dsNhomDichVu.get(nhomDichVuId).getMaNhomDichVuCLS();
                int giaTien = Integer.parseInt(txtGiaTien.getText());
                int giaBaoHiem = Integer.parseInt(txtGiaBaoHiem.getText());
                String trangThai = cmbTrangThai.getSelectedItem().toString();

                DichVuCLSModel dv = new DichVuCLSModel(maDichVu, tenDichVu, maNhomDichVu, giaTien, giaBaoHiem, trangThai);
                DichVuCLSCtrl.themDichVuCLS(dv);
                timKiemDVCLS();
                lamMoi();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            if (txtMaDichVu.getText().isEmpty()) {
                DialogHelper.showError("Vui lòng chọn dịch vụ cận lâm sàng muốn xóa");
            } else if (DichVuCLSCtrl.kiemTraDVDaDuocSuDung(txtMaDichVu.getText())) {
                DialogHelper.showError("Dịch vụ cận lâm sàng đã được sử dụng, không thể xóa");
            } else {
                if (DialogHelper.showConfirmation("Bạn có chắc muốn xóa dịch vụ cận lâm sàn này")) {
                    String maDichVu = txtMaDichVu.getText();
                    DichVuCLSCtrl.xoaDichVuCLS(maDichVu);
                    DialogHelper.showMessage("Xóa dịch vụ cận lâm sàng thành công!");
                    lamMoi();
                    timKiemDVCLS();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (txtMaDichVu.getText().isEmpty()) {
                DialogHelper.showError("Vui lòng chọn dịch vụ cận lâm sàng muốn chỉnh sửa");
            } else if (txtTenDichVu.getText().isEmpty()) {
                DialogHelper.showError("Tên dịch vụ không được để trống!");
            } else if (cmbNhomDichVu.getSelectedItem().toString().equals("---Nhóm dịch vụ---")) {
                DialogHelper.showError("Nhóm dịch vụ không được để trống");
            } else if (txtGiaTien.getText().isEmpty()) {
                DialogHelper.showError("Giá tiền không được để trống");
            } else if (!txtGiaTien.getText().isEmpty() && !Validator.isIntegerString(txtGiaTien.getText())) {
                DialogHelper.showError("Giá tiền không hợp lệ");
            } else if (txtGiaBaoHiem.getText().isEmpty()) {
                DialogHelper.showError("Giá bảo hiểm không được để trống");
            } else if (!txtGiaBaoHiem.getText().isEmpty() && !Validator.isIntegerString(txtGiaBaoHiem.getText())) {
                DialogHelper.showError("Giá bảo hiểm không hợp lệ");
            } else {
                if (DialogHelper.showConfirmation("Bạn có chắc muốn sửa dịch vụ cận lâm sàng này")) {
                    String maDichVu = txtMaDichVu.getText();
                    String tenDichVu = txtTenDichVu.getText();
                    int nhomDichVuId = cmbNhomDichVu.getSelectedIndex();
                    String maNhomDichVu = dsNhomDichVu.get(nhomDichVuId).getMaNhomDichVuCLS();
                    int giaTien = Integer.parseInt(txtGiaTien.getText());
                    int giaBaoHiem = Integer.parseInt(txtGiaBaoHiem.getText());
                    String trangThai = cmbTrangThai.getSelectedItem().toString();

                    DichVuCLSModel dv = new DichVuCLSModel(maDichVu, tenDichVu, maNhomDichVu, giaTien, giaBaoHiem, trangThai);
                    DichVuCLSCtrl.capNhatDichVuCLS(dv);
                    DialogHelper.showMessage("Sửa dịch vụ cận lâm sàng thành công!");
                    timKiemDVCLS();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblDSDichVuKBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSDichVuKBMouseClicked
        int selectedIndex = tblDSDichVuKB.getSelectedRow();
        if (selectedIndex >= 0) {
            DichVuCLSModel dv = dsDichVu.get(selectedIndex);
            txtMaDichVu.setText(dv.getMaDichVuCLS());
            txtTenDichVu.setText(dv.getTenDichVuCLS());
            cmbNhomDichVu.setSelectedItem(dv.getTenNhomDichVuCLS());
            txtGiaTien.setText(Integer.toString(dv.getGiaTien()));
            txtGiaBaoHiem.setText(Integer.toString(dv.getGiaBaoHiem()));
            cmbTrangThai.setSelectedItem(dv.getTrangThai());
        }
    }//GEN-LAST:event_tblDSDichVuKBMouseClicked

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        timKiemDVCLS();
    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void btnxuatDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxuatDSActionPerformed
        try {
            dsDichVu = DichVuCLSCtrl.timTatCaDichVu();
            DichVuCLSCtrl.exportToExcel(dsDichVu, "src/main/java/ExcelStorage/DSDichVuCLS.xlsx");
            DialogHelper.showMessage("Xuất danh sách thành công!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnxuatDSActionPerformed

    private void cmbTKNhomDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKNhomDichVuActionPerformed
        timKiemDVCLS();
    }//GEN-LAST:event_cmbTKNhomDichVuActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSDichVuCLS().setVisible(true);
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
    private javax.swing.JComboBox<String> cmbTKNhomDichVu;
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
