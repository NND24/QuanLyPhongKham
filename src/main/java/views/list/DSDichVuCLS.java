package views.list;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.DichVuCLSModel;
import controllers.DichVuCLSCtrl;
import javax.swing.JOptionPane;
import models.NhomDichVuCLSModel;
import controllers.NhomDichVuCLSCtrl;
import utils.Validator;

public class DSDichVuCLS extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    List<NhomDichVuCLSModel> dsNhomDichVu = new ArrayList<>();
    List<DichVuCLSModel> dsDichVu = new ArrayList<>();

    public DSDichVuCLS() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) dsDichVuKBTable.getModel();

            hienThiTatCaDichVu();
            hienThiDSNhomDichVu();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSNhomDichVu() {
        try {
            dsNhomDichVu = NhomDichVuCLSCtrl.timTatNhomDichVuCLS();
            NhomDichVuComboBox.removeAllItems();
            NhomDichVuComboBox.addItem("---Nhóm dịch vụ---");
            tkNhomDichVuComboBox.removeAllItems();
            tkNhomDichVuComboBox.addItem("---Nhóm dịch vụ---");
            dsNhomDichVu.forEach(ndv -> {
                if (ndv.getTrangThai().equals("Kích hoạt")) {
                    String nhomDichVu = ndv.getMaNhomDichVu() + " " + ndv.getTenNhomDichVu();
                    NhomDichVuComboBox.addItem(nhomDichVu);
                    tkNhomDichVuComboBox.addItem(nhomDichVu);
                }

            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiTatCaDichVu() throws ClassNotFoundException {
        dsDichVu = DichVuCLSCtrl.timTatCaDichVu();

        tableModel.setRowCount(0);

        dsDichVu.forEach(dv -> {
            tableModel.addRow(new Object[]{dv.getMaDichVu(), dv.getTenDichVu(),
                dv.getTenNhomDichVu(), dv.getGiaTien(), dv.getGiaBaoHiem(), dv.getTrangThai()});
        });
    }

    private void lamMoi() {
        MaDichVuTextField.setText("");
        TenDichVuTextField.setText("");
        //NhomDichVuComboBox.setSelectedIndex(0);
        GiaTienTextField.setText("");
        GiaBaoHiemTextField.setText("");
        TrangThaiComboBox.setSelectedIndex(0);
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
        MaDichVuTextField = new javax.swing.JTextField();
        TenDichVuTextField = new javax.swing.JTextField();
        TrangThaiComboBox = new javax.swing.JComboBox<>();
        ThemButton = new javax.swing.JButton();
        XoaButton = new javax.swing.JButton();
        SuaButton = new javax.swing.JButton();
        xuatDSButton = new javax.swing.JButton();
        NhapMoiButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        NhomDichVuComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        GiaTienTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        GiaBaoHiemTextField = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        timKiemTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tkNhomDichVuComboBox = new javax.swing.JComboBox<>();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách dịch vụ cận lâm sàn");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 436));

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

        MaDichVuTextField.setEditable(false);

        TrangThaiComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kích hoạt", "Ẩn" }));

        ThemButton.setBackground(new java.awt.Color(0, 102, 255));
        ThemButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ThemButton.setForeground(new java.awt.Color(255, 255, 255));
        ThemButton.setText("Thêm");
        ThemButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ThemButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ThemButton.setPreferredSize(new java.awt.Dimension(70, 30));
        ThemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemButtonActionPerformed(evt);
            }
        });

        XoaButton.setBackground(new java.awt.Color(0, 102, 255));
        XoaButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        XoaButton.setForeground(new java.awt.Color(255, 255, 255));
        XoaButton.setText("Xóa");
        XoaButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        XoaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XoaButton.setPreferredSize(new java.awt.Dimension(70, 30));
        XoaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaButtonActionPerformed(evt);
            }
        });

        SuaButton.setBackground(new java.awt.Color(0, 102, 255));
        SuaButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SuaButton.setForeground(new java.awt.Color(255, 255, 255));
        SuaButton.setText("Sửa");
        SuaButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SuaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SuaButton.setPreferredSize(new java.awt.Dimension(70, 30));
        SuaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaButtonActionPerformed(evt);
            }
        });

        xuatDSButton.setBackground(new java.awt.Color(0, 102, 255));
        xuatDSButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        xuatDSButton.setForeground(new java.awt.Color(255, 255, 255));
        xuatDSButton.setText("Xuất danh sách");
        xuatDSButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        xuatDSButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        xuatDSButton.setPreferredSize(new java.awt.Dimension(130, 30));
        xuatDSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xuatDSButtonActionPerformed(evt);
            }
        });

        NhapMoiButton.setBackground(new java.awt.Color(0, 102, 255));
        NhapMoiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NhapMoiButton.setForeground(new java.awt.Color(255, 255, 255));
        NhapMoiButton.setText("Làm mới");
        NhapMoiButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NhapMoiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NhapMoiButton.setPreferredSize(new java.awt.Dimension(90, 30));
        NhapMoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NhapMoiButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Nhóm dịch vụ");

        NhomDichVuComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Nhóm dịch vụ---" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Giá tiền");

        GiaTienTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                GiaTienTextFieldFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Giá bảo hiểm");

        GiaBaoHiemTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                GiaBaoHiemTextFieldFocusLost(evt);
            }
        });

        jPanel6.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("DANH SÁCH DỊCH VỤ CLS");

        timKiemTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                timKiemTextFieldKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tìm kiếm");

        tkNhomDichVuComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Nhóm dịch vụ---" }));
        tkNhomDichVuComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkNhomDichVuComboBoxActionPerformed(evt);
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
                .addComponent(timKiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(tkNhomDichVuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(timKiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(tkNhomDichVuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(ThemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(XoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(SuaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(NhapMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(xuatDSButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(MaDichVuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NhomDichVuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(GiaBaoHiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(GiaTienTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TenDichVuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TrangThaiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(MaDichVuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(TenDichVuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(NhomDichVuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(GiaTienTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TrangThaiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(GiaBaoHiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xuatDSButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NhapMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NhapMoiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhapMoiButtonActionPerformed
        try {
            lamMoi();
            hienThiDSNhomDichVu();
            hienThiTatCaDichVu();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NhapMoiButtonActionPerformed

    private void ThemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemButtonActionPerformed
        // TODO add your handling code here:
        String maDichVu = DichVuCLSCtrl.generateMaDichVuCLS();
        String tenDichVu = TenDichVuTextField.getText();
        String maNhomDichVu = NhomDichVuComboBox.getSelectedItem().toString();
        int giaTien = Integer.parseInt(GiaTienTextField.getText());
        int giaBaoHiem = Integer.parseInt(GiaBaoHiemTextField.getText());
        String trangThai = TrangThaiComboBox.getSelectedItem().toString();

        if (tenDichVu.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên dịch vụ không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (!MaDichVuTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Dịch vụ đã tồn tại", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (maNhomDichVu.equals("---Nhóm dịch vụ---")) {
            JOptionPane.showMessageDialog(null, "Nhóm dịch vụ không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (GiaTienTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Giá tiền không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (GiaBaoHiemTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Giá bảo hiểm không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                DichVuCLSModel dv = new DichVuCLSModel(maDichVu, tenDichVu, maNhomDichVu.split(" ")[0], giaTien, giaBaoHiem, trangThai);
                DichVuCLSCtrl.ThemDichVuCLS(dv);
                // JOptionPane.showMessageDialog(null, "Thêm dịch vụ khám bệnh thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                hienThiTatCaDichVu();
                lamMoi();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ThemButtonActionPerformed

    private void XoaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaButtonActionPerformed
        try {
            String maDichVu = MaDichVuTextField.getText();
            if (maDichVu.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Chưa có dịch vụ được chọn", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                String[] options = {"Đồng ý", "Thoát"};
                int option = JOptionPane.showOptionDialog(
                        null,
                        "Bạn có chắc muốn xóa dịch vụ cận lâm sàn này",
                        "Cảnh báo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]
                );

                if (option == 0) {
                    DichVuCLSCtrl.XoaDichVuCLS(maDichVu);
                    JOptionPane.showMessageDialog(null, "Xóa dịch vụ cận lâm sàn thành công!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    lamMoi();
                    hienThiTatCaDichVu();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_XoaButtonActionPerformed

    private void SuaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaButtonActionPerformed
        try {
            // TODO add your handling code here:
            String maDichVu = MaDichVuTextField.getText();
            String tenDichVu = TenDichVuTextField.getText();
            String maNhomDichVu = NhomDichVuComboBox.getSelectedItem().toString();
            int giaTien = Integer.parseInt(GiaTienTextField.getText());
            int giaBaoHiem = Integer.parseInt(GiaBaoHiemTextField.getText());
            String trangThai = TrangThaiComboBox.getSelectedItem().toString();
            if (tenDichVu.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tên dịch vụ không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                JOptionPane.showMessageDialog(null, "Nhóm dịch vụ không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (maDichVu.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mã dịch vụ không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (GiaTienTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Giá tiền không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (GiaBaoHiemTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Giá bảo hiểm không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                String[] options = {"Đồng ý", "Thoát"};
                int option = JOptionPane.showOptionDialog(
                        null,
                        "Bạn có chắc muốn sửa dịch vụ cận lâm sàn này",
                        "Cảnh báo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]
                );

                if (option == 0) {
                    DichVuCLSModel dv = new DichVuCLSModel(maDichVu, tenDichVu, maNhomDichVu.split(" ")[0], giaTien, giaBaoHiem, trangThai);
                    DichVuCLSCtrl.CapNhatDichVuCLS(dv);
                    JOptionPane.showMessageDialog(null, "Sửa dịch vụ cận lâm sàn thành công!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    lamMoi();
                    hienThiTatCaDichVu();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SuaButtonActionPerformed

    private void dsDichVuKBTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsDichVuKBTableMouseClicked
        // TODO add your handling code here:
        int selectedIndex = dsDichVuKBTable.getSelectedRow();
        if (selectedIndex >= 0) {
            DichVuCLSModel dv = dsDichVu.get(selectedIndex);
            MaDichVuTextField.setText(dv.getMaDichVu());
            TenDichVuTextField.setText(dv.getTenDichVu());
            NhomDichVuComboBox.setSelectedItem(dv.getMaNhomDichVu() + " " + dv.getTenNhomDichVu());
            GiaTienTextField.setText(Integer.toString(dv.getGiaTien()));
            GiaBaoHiemTextField.setText(Integer.toString(dv.getGiaBaoHiem()));
            TrangThaiComboBox.setSelectedItem(dv.getTrangThai());
        }
    }//GEN-LAST:event_dsDichVuKBTableMouseClicked

    private void timKiemTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timKiemTextFieldKeyTyped
        try {
            if (tkNhomDichVuComboBox.getSelectedItem() != null) {
                String timKiem = timKiemTextField.getText();
                String nhomDichVu = tkNhomDichVuComboBox.getSelectedItem().toString();
                if (timKiem.equals("")) {
                    hienThiTatCaDichVu();
                } else if (!timKiem.equals("") && nhomDichVu.equals("---Nhóm dịch vụ---")) {
                    dsDichVu = DichVuCLSCtrl.timTatCaDichVuTheoDK(timKiem, "---Nhóm dịch vụ---");
                    tableModel.setRowCount(0);

                    dsDichVu.forEach(dv -> {
                        tableModel.addRow(new Object[]{dv.getMaDichVu(), dv.getTenDichVu(),
                            dv.getTenNhomDichVu(), dv.getGiaTien(), dv.getGiaBaoHiem(), dv.getTrangThai()});
                    });
                } else {
                    dsDichVu = DichVuCLSCtrl.timTatCaDichVuTheoDK(timKiem, nhomDichVu.split(" ")[0]);
                    tableModel.setRowCount(0);

                    dsDichVu.forEach(dv -> {
                        tableModel.addRow(new Object[]{dv.getMaDichVu(), dv.getTenDichVu(),
                            dv.getTenNhomDichVu(), dv.getGiaTien(), dv.getGiaBaoHiem(), dv.getTrangThai()});
                    });
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_timKiemTextFieldKeyTyped

    private void xuatDSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatDSButtonActionPerformed
        try {
            dsDichVu = DichVuCLSCtrl.timTatCaDichVu();
            DichVuCLSCtrl.exportToExcel(dsDichVu, "D:\\Workspace Java\\DoAn\\DSDichVuCLS.xlsx");
            JOptionPane.showMessageDialog(null, "Xuất danh sách thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_xuatDSButtonActionPerformed

    private void GiaBaoHiemTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GiaBaoHiemTextFieldFocusLost
        String giaBH = GiaBaoHiemTextField.getText();
        if (!giaBH.isEmpty() && !Validator.isIntegerString(giaBH)) {
            JOptionPane.showMessageDialog(null, "Giá bảo hiểm không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            GiaBaoHiemTextField.requestFocus();
        }
    }//GEN-LAST:event_GiaBaoHiemTextFieldFocusLost

    private void GiaTienTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GiaTienTextFieldFocusLost
        String giaTien = GiaTienTextField.getText();
        if (!giaTien.isEmpty() && !Validator.isIntegerString(giaTien)) {
            JOptionPane.showMessageDialog(null, "Giá tiền không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            GiaTienTextField.requestFocus();
        }
    }//GEN-LAST:event_GiaTienTextFieldFocusLost

    private void tkNhomDichVuComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkNhomDichVuComboBoxActionPerformed
        try {
            if (tkNhomDichVuComboBox.getSelectedItem() != null) {
                String timKiem = timKiemTextField.getText();
                String nhomDichVu = tkNhomDichVuComboBox.getSelectedItem().toString();
                if (nhomDichVu.equals("---Nhóm dịch vụ---")) {
                    hienThiTatCaDichVu();
                } else {
                    dsDichVu = DichVuCLSCtrl.timTatCaDichVuTheoDK(timKiem, nhomDichVu.split(" ")[0]);
                    tableModel.setRowCount(0);

                    dsDichVu.forEach(dv -> {
                        tableModel.addRow(new Object[]{dv.getMaDichVu(), dv.getTenDichVu(),
                            dv.getTenNhomDichVu(), dv.getGiaTien(), dv.getGiaBaoHiem(), dv.getTrangThai()});
                    });
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tkNhomDichVuComboBoxActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSDichVuCLS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField GiaBaoHiemTextField;
    private javax.swing.JTextField GiaTienTextField;
    private javax.swing.JTextField MaDichVuTextField;
    private javax.swing.JButton NhapMoiButton;
    private javax.swing.JComboBox<String> NhomDichVuComboBox;
    private javax.swing.JButton SuaButton;
    private javax.swing.JTextField TenDichVuTextField;
    private javax.swing.JButton ThemButton;
    private javax.swing.JComboBox<String> TrangThaiComboBox;
    private javax.swing.JButton XoaButton;
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
    private javax.swing.JTextField timKiemTextField;
    private javax.swing.JComboBox<String> tkNhomDichVuComboBox;
    private javax.swing.JButton xuatDSButton;
    // End of variables declaration//GEN-END:variables
}
