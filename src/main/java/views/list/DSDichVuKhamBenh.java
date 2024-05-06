package views.list;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.DichVuKhamBenhModel;
import controllers.DichVuKhamBenhCtrl;
import javax.swing.JOptionPane;
import models.NhomDichVuKhamBenhModel;
import controllers.NhomDichVuKhamBenhCtrl;
import utils.Validator;

public class DSDichVuKhamBenh extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    List<NhomDichVuKhamBenhModel> dsNhomDichVu = new ArrayList<>();
    List<DichVuKhamBenhModel> dsDichVu = new ArrayList<>();

    public DSDichVuKhamBenh() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) dsDichVuKBTable.getModel();

            hienThiTatCaDichVu();
            hienThiDSNhomDichVu();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuKhamBenh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSNhomDichVu() {
        try {
            txtNhomDichVu.removeAllItems();
            txtNhomDichVu.addItem("---Nhóm dịch vụ---");
            cmbtkNhomDichVu.removeAllItems();
            cmbtkNhomDichVu.addItem("---Nhóm dịch vụ---");
            dsNhomDichVu = NhomDichVuKhamBenhCtrl.timTatNhomDichVuKhamBenh();
            dsNhomDichVu.forEach(ndv -> {
                if (ndv.getTrangThai().equals("Kích hoạt")) {
                    String nhomDichVu = ndv.getMaNhomDichVuKB()+ " " + ndv.getTenNhomDichVuKB();
                    txtNhomDichVu.addItem(nhomDichVu);
                    cmbtkNhomDichVu.addItem(nhomDichVu);
                }

            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuKhamBenh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiTatCaDichVu() throws ClassNotFoundException {

        dsDichVu = DichVuKhamBenhCtrl.timTatCaDichVu();
        tableModel.setRowCount(0);

        dsDichVu.forEach(dv -> {
            tableModel.addRow(new Object[]{dv.getMaDichVuKB(), dv.getTenDichVuKB(),
                dv.getTenNhomDichVuKB(), dv.getGiaTien(), dv.getGiaBaoHiem(), dv.getTrangThai()});
        });
    }

    private void lamMoi() {
        txtMaDichVu.setText("");
        txtTenDichVu.setText("");
        txtNhomDichVu.setSelectedIndex(0);
        txtGiaTien.setText("");
        txtGiaBH.setText("");
        cmbTrangThai.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsDichVuKBTable = new javax.swing.JTable();
        txtMaDichVu = new javax.swing.JTextField();
        txtTenDichVu = new javax.swing.JTextField();
        cmbTrangThai = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXuatDS = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNhomDichVu = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtGiaTien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGiaBH = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbtkNhomDichVu = new javax.swing.JComboBox<>();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách dịch vụ khám bệnh");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã dịch vụ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên dịch vụ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Trạng thái");

        dsDichVuKBTable.setModel(new javax.swing.table.DefaultTableModel(
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
        dsDichVuKBTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dsDichVuKBTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dsDichVuKBTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dsDichVuKBTable);

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

        btnXuatDS.setBackground(new java.awt.Color(0, 102, 255));
        btnXuatDS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatDS.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatDS.setText("Xuất danh sách");
        btnXuatDS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXuatDS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatDS.setPreferredSize(new java.awt.Dimension(130, 30));
        btnXuatDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDSActionPerformed(evt);
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

        txtNhomDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Nhóm dịch vụ---" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Giá tiền");

        txtGiaTien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGiaTienFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Giá bảo hiểm");

        txtGiaBH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGiaBHFocusLost(evt);
            }
        });

        jPanel6.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("DANH SÁCH DỊCH VỤ KHÁM BỆNH");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tìm kiếm");

        cmbtkNhomDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Nhóm dịch vụ---" }));
        cmbtkNhomDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtkNhomDichVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbtkNhomDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(cmbtkNhomDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNhomDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtGiaTien)
                    .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnXuatDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNhomDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtGiaBH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        try {
            // TODO add your handling code here:
            lamMoi();
            hienThiDSNhomDichVu();
            hienThiTatCaDichVu();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuKhamBenh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String maDichVu = DichVuKhamBenhCtrl.generateMaDichVuKhamBenh();
        String tenDichVu = txtTenDichVu.getText();
        String maNhomDichVu = txtNhomDichVu.getSelectedItem().toString();
        int giaTien = Integer.parseInt(txtGiaTien.getText());
        int giaBaoHiem = Integer.parseInt(txtGiaBH.getText());
        String trangThai = cmbTrangThai.getSelectedItem().toString();

        if (tenDichVu.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên dịch vụ không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (!txtMaDichVu.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Dịch vụ đã tồn tại", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (maNhomDichVu.equals("---Nhóm dịch vụ---")) {
            JOptionPane.showMessageDialog(null, "Nhóm dịch vụ không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (txtGiaTien.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Giá tiền không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (txtGiaBH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Giá bảo hiểm không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                DichVuKhamBenhModel dv = new DichVuKhamBenhModel(maDichVu, tenDichVu, maNhomDichVu.split(" ")[0], giaTien, giaBaoHiem, trangThai);
                DichVuKhamBenhCtrl.ThemDichVuKhamBenh(dv);
                // JOptionPane.showMessageDialog(null, "Thêm dịch vụ khám bệnh thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                hienThiTatCaDichVu();
                txtMaDichVu.setText("");
                txtTenDichVu.setText("");
                txtGiaTien.setText("");
                txtGiaBH.setText("");
                cmbTrangThai.setSelectedIndex(0);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DSDichVuKhamBenh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            String maDichVu = txtMaDichVu.getText();
            if (maDichVu.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Chưa có dịch vụ được chọn", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                String[] options = {"Đồng ý", "Thoát"};
                int option = JOptionPane.showOptionDialog(
                        null,
                        "Bạn có chắc muốn xóa dịch vụ khám bệnh này",
                        "Cảnh báo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]
                );

                if (option == 0) {
                    DichVuKhamBenhCtrl.XoaDichVuKhamBenh(maDichVu);
                    JOptionPane.showMessageDialog(null, "Xóa dịch vụ khám bệnh thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    lamMoi();
                    hienThiTatCaDichVu();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuKhamBenh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            // TODO add your handling code here:
            String maDichVu = txtMaDichVu.getText();
            String tenDichVu = txtTenDichVu.getText();
            String maNhomDichVu = txtNhomDichVu.getSelectedItem().toString();
            int giaTien = Integer.parseInt(txtGiaTien.getText());
            int giaBaoHiem = Integer.parseInt(txtGiaBH.getText());
            String trangThai = cmbTrangThai.getSelectedItem().toString();
            if (maDichVu.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mã dịch vụ không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (tenDichVu.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tên dịch vụ không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                JOptionPane.showMessageDialog(null, "Nhóm dịch vụ không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (txtGiaTien.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Giá tiền không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (txtGiaBH.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Giá bảo hiểm không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                String[] options = {"Đồng ý", "Thoát"};
                int option = JOptionPane.showOptionDialog(
                        null,
                        "Bạn có chắc muốn sửa dịch vụ khám bệnh này",
                        "Cảnh báo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]
                );

                if (option == 0) {
                    DichVuKhamBenhModel dv = new DichVuKhamBenhModel(maDichVu, tenDichVu, maNhomDichVu.split(" ")[0], giaTien, giaBaoHiem, trangThai);
                    DichVuKhamBenhCtrl.CapNhatDichVuKhamBenh(dv);
                    JOptionPane.showMessageDialog(null, "Sửa dịch vụ khám bệnh thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    lamMoi();
                    hienThiTatCaDichVu();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuKhamBenh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void dsDichVuKBTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsDichVuKBTableMouseClicked
        int selectedIndex = dsDichVuKBTable.getSelectedRow();
        if (selectedIndex >= 0) {
            DichVuKhamBenhModel dv = dsDichVu.get(selectedIndex);

            txtMaDichVu.setText(dv.getMaDichVuKB());
            txtTenDichVu.setText(dv.getTenDichVuKB());
            txtNhomDichVu.setSelectedItem(dv.getMaNhomDichVuKB()+ " " + dv.getTenNhomDichVuKB());
            txtGiaTien.setText(Integer.toString(dv.getGiaTien()));
            txtGiaBH.setText(Integer.toString(dv.getGiaBaoHiem()));
            cmbTrangThai.setSelectedItem(dv.getTrangThai());
        }
    }//GEN-LAST:event_dsDichVuKBTableMouseClicked

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        try {
            if (cmbtkNhomDichVu.getSelectedItem() != null) {
                String timKiem = txtTimKiem.getText();
                String nhomDichVu = cmbtkNhomDichVu.getSelectedItem().toString();
                if (timKiem.equals("")) {
                    hienThiTatCaDichVu();
                } else if (!timKiem.equals("") && nhomDichVu.equals("---Nhóm dịch vụ---")) {
                    dsDichVu = DichVuKhamBenhCtrl.timTatCaDichVuTheoDK(timKiem, "---Nhóm dịch vụ---");
                    tableModel.setRowCount(0);

                    dsDichVu.forEach(dv -> {
                        tableModel.addRow(new Object[]{dv.getMaDichVuKB(), dv.getTenDichVuKB(),
                            dv.getTenNhomDichVuKB(), dv.getGiaTien(), dv.getGiaBaoHiem(), dv.getTrangThai()});
                    });
                } else {
                    dsDichVu = DichVuKhamBenhCtrl.timTatCaDichVuTheoDK(timKiem, nhomDichVu.split(" ")[0]);
                    tableModel.setRowCount(0);

                    dsDichVu.forEach(dv -> {
                        tableModel.addRow(new Object[]{dv.getMaDichVuKB(), dv.getTenDichVuKB(),
                            dv.getTenNhomDichVuKB(), dv.getGiaTien(), dv.getGiaBaoHiem(), dv.getTrangThai()});
                    });
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void btnXuatDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDSActionPerformed
        try {
            dsDichVu = DichVuKhamBenhCtrl.timTatCaDichVu();
            DichVuKhamBenhCtrl.exportToExcel(dsDichVu, "D:\\Workspace Java\\DoAn\\DSDichVuKhamBenh.xlsx");
            JOptionPane.showMessageDialog(null, "Xuất danh sách thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXuatDSActionPerformed

    private void txtGiaTienFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaTienFocusLost
        String giaTien = txtGiaTien.getText();
        if (!giaTien.isEmpty() && !Validator.isIntegerString(giaTien)) {
            JOptionPane.showMessageDialog(null, "Giá tiền không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtGiaTien.requestFocus();
        }
    }//GEN-LAST:event_txtGiaTienFocusLost

    private void txtGiaBHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaBHFocusLost
        String giaBH = txtGiaBH.getText();
        if (!giaBH.isEmpty() && !Validator.isIntegerString(giaBH)) {
            JOptionPane.showMessageDialog(null, "Giá bảo hiểm không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtGiaBH.requestFocus();
        }
    }//GEN-LAST:event_txtGiaBHFocusLost

    private void cmbtkNhomDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtkNhomDichVuActionPerformed
        try {
            if (cmbtkNhomDichVu.getSelectedItem() != null) {
                String timKiem = txtTimKiem.getText();
                String nhomDichVu = cmbtkNhomDichVu.getSelectedItem().toString();
                if (nhomDichVu.equals("---Nhóm dịch vụ---")) {
                    hienThiTatCaDichVu();
                } else {
                    dsDichVu = DichVuKhamBenhCtrl.timTatCaDichVuTheoDK(timKiem, nhomDichVu.split(" ")[0]);
                    tableModel.setRowCount(0);

                    dsDichVu.forEach(dv -> {
                        tableModel.addRow(new Object[]{dv.getMaDichVuKB(), dv.getTenDichVuKB(),
                            dv.getTenNhomDichVuKB(), dv.getGiaTien(), dv.getGiaBaoHiem(), dv.getTrangThai()});
                    });
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbtkNhomDichVuActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSDichVuKhamBenh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatDS;
    private javax.swing.JComboBox<String> cmbTrangThai;
    private javax.swing.JComboBox<String> cmbtkNhomDichVu;
    private javax.swing.JTable dsDichVuKBTable;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextField txtGiaBH;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtMaDichVu;
    private javax.swing.JComboBox<String> txtNhomDichVu;
    private javax.swing.JTextField txtTenDichVu;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
