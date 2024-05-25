package views.list;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.NhomThuocModel;
import controllers.NhomThuocCtrl;
import javax.swing.JOptionPane;

public class DSNhomThuoc extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    List<NhomThuocModel> dsNhomThuoc = new ArrayList<>();

    public DSNhomThuoc() {
        initComponents();

        tableModel = (DefaultTableModel) tblDSNhomThuoc.getModel();

        try {
            hienThiTatCaNhomThuoc();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSNhomThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiTatCaNhomThuoc() throws ClassNotFoundException {
        dsNhomThuoc = NhomThuocCtrl.timTatCaNhomThuoc();
        tableModel.setRowCount(0);

        dsNhomThuoc.forEach(ndv -> {
            tableModel.addRow(new Object[]{ndv.getMaNhomThuoc(), ndv.getTenNhomThuoc(),
                ndv.getTrangThai()});
        });
    }

    private void lamMoi() {
        txtMaNhomThuoc.setText("");
        txtTenNhomThuoc.setText("");
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
        tblDSNhomThuoc = new javax.swing.JTable();
        txtMaNhomThuoc = new javax.swing.JTextField();
        txtTenNhomThuoc = new javax.swing.JTextField();
        cmbTrangThai = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnXuatDS = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txttimKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách nhóm thuốc");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã nhóm thuốc");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên nhóm thuốc");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Trạng thái");

        tblDSNhomThuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã nhóm thuốc", "Tên nhóm thuốc", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNhomThuoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDSNhomThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNhomThuocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSNhomThuoc);

        txtMaNhomThuoc.setEditable(false);

        cmbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kích hoạt", "Ẩn" }));
        cmbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTrangThaiActionPerformed(evt);
            }
        });

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

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(80, 30));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnXuatDS.setBackground(new java.awt.Color(0, 102, 255));
        btnXuatDS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatDS.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatDS.setText("Xuất danh sách");
        btnXuatDS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXuatDS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatDS.setPreferredSize(new java.awt.Dimension(120, 30));
        btnXuatDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDSActionPerformed(evt);
            }
        });

        jPanel6.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("DANH SÁCH NHÓM THUỐC");

        txttimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttimKiemKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txttimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(10, 10, 10))
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnXuatDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1)))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTenNhomThuoc, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMaNhomThuoc))
                                .addGap(25, 25, 25)))))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaNhomThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenNhomThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        try {
            lamMoi();
            hienThiTatCaNhomThuoc();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSNhomThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String maNhomThuoc = NhomThuocCtrl.generateMaNhomThuoc();
        String tenNhomThuoc = txtTenNhomThuoc.getText();
        String trangThai = cmbTrangThai.getSelectedItem().toString();

        if (tenNhomThuoc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "tên nhóm thuốc không được bỏ trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                NhomThuocModel nt = new NhomThuocModel(maNhomThuoc, tenNhomThuoc, trangThai);
                NhomThuocCtrl.ThemNhomThuoc(nt);
                lamMoi();
                hienThiTatCaNhomThuoc();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DSNhomThuoc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            String maNhomThuoc = txtMaNhomThuoc.getText();

            if (maNhomThuoc.isEmpty()) {
                JOptionPane.showMessageDialog(null, "chưa có nhóm thuốc cần chọn để xóa", "cảnh báo", JOptionPane.WARNING_MESSAGE);
            } else {
                String[] options = {"Đồng ý, Thoát"};
                int option = JOptionPane.showOptionDialog(null,
                        "Bạn có chắc muốn xóa nhóm thuốc này không",
                        "Cảnh báo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]
                );
                if (option == 0) {
                    NhomThuocCtrl.XoaNhomThuoc(maNhomThuoc);

                    lamMoi();
                    hienThiTatCaNhomThuoc();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSNhomThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            String maNhomThuoc = txtMaNhomThuoc.getText();
            String tenNhomThuoc = txtTenNhomThuoc.getText();
            String trangThai = cmbTrangThai.getSelectedItem().toString();

            if (tenNhomThuoc.isEmpty()) {
                JOptionPane.showMessageDialog(null, "tên nhóm thuốc không được bỏ trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (maNhomThuoc.isEmpty()) {
                JOptionPane.showMessageDialog(null, "mã nhóm thuốc không được bỏ trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                String options[] = {"Đồng ý", "Thoát"};
                int option = JOptionPane.showOptionDialog(
                        null,
                        "Bạn có chắc muốn sửa nhóm thuốc này",
                        "Cảnh báo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]
                );
                if (option == 0) {
                    NhomThuocModel nt = new NhomThuocModel(maNhomThuoc, tenNhomThuoc, trangThai);
                    NhomThuocCtrl.CapNhatNhomThuoc(nt);
                    JOptionPane.showMessageDialog(null, "Sửa nhóm thuốc thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    lamMoi();
                    hienThiTatCaNhomThuoc();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSNhomThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void cmbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTrangThaiActionPerformed

    private void tblDSNhomThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNhomThuocMouseClicked
        // TODO add your handling code here:
        int selectedIndex = tblDSNhomThuoc.getSelectedRow();
        if (selectedIndex >= 0) {
            NhomThuocModel nt = dsNhomThuoc.get(selectedIndex);

            txtMaNhomThuoc.setText(nt.getMaNhomThuoc());
            txtTenNhomThuoc.setText(nt.getTenNhomThuoc());
            cmbTrangThai.setSelectedItem(nt.getTrangThai());
        }
    }//GEN-LAST:event_tblDSNhomThuocMouseClicked

    private void btnXuatDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDSActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnXuatDSActionPerformed

    private void txttimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimKiemKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimKiemKeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSNhomThuoc().setVisible(true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDSNhomThuoc;
    private javax.swing.JTextField txtMaNhomThuoc;
    private javax.swing.JTextField txtTenNhomThuoc;
    private javax.swing.JTextField txttimKiem;
    // End of variables declaration//GEN-END:variables
}
