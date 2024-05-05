package views.main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.ChiDinhModel;
import controllers.ChiDinhCtrl;
import utils.DialogHelper;

public class KetQuaCLS extends javax.swing.JPanel {

    public static KetQuaCLS Instance;
    public String maBenhNhan, maBenhAn, maBacSi;

    DefaultTableModel tableModel;
    public List<ChiDinhModel> dsChiDinh = new ArrayList<>();

    public KetQuaCLS() {
        initComponents();
        Instance = this;
        tableModel = (DefaultTableModel) tblDSChiDinh.getModel();
    }

    private void lamMoi() {
        txtMaChiDinh.setText("");
        txtMaDichVu.setText("");
        txtTenDichVu.setText("");
        txaKetQua.setText("");
    }

    public void hienThiDSDichvu() throws ClassNotFoundException {
        tableModel.setRowCount(0);

        dsChiDinh.forEach(cd -> {
            tableModel.addRow(new Object[]{cd.getMaChiDinh(), cd.getMaDichVuCLS(),
                cd.getTenDichVuCLS(), cd.getKetQua()
            });
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TongChiDinhPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDSChiDinh = new javax.swing.JTable();
        txtTenDichVu = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtMaChiDinh = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaKetQua = new javax.swing.JTextArea();
        btnLuuKetQua = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtMaDichVu = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1100, 500));

        TongChiDinhPanel.setBackground(new java.awt.Color(255, 255, 255));
        TongChiDinhPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TongChiDinhPanel.setPreferredSize(new java.awt.Dimension(1100, 500));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Mã dịch vụ");

        jPanel2.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("DANH SÁCH CHỈ ĐỊNH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(965, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        tblDSChiDinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã chỉ định", "Mã dịch vụ", "Tên dịch vụ", "Kết quả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSChiDinh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDSChiDinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSChiDinhMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblDSChiDinh);

        txtTenDichVu.setEditable(false);
        txtTenDichVu.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Mã chỉ định");

        txtMaChiDinh.setEditable(false);
        txtMaChiDinh.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Kết quả");

        txaKetQua.setColumns(20);
        txaKetQua.setRows(5);
        jScrollPane1.setViewportView(txaKetQua);

        btnLuuKetQua.setBackground(new java.awt.Color(0, 102, 255));
        btnLuuKetQua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuuKetQua.setForeground(new java.awt.Color(255, 255, 255));
        btnLuuKetQua.setText("Lưu kết quả");
        btnLuuKetQua.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLuuKetQua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLuuKetQua.setPreferredSize(new java.awt.Dimension(100, 30));
        btnLuuKetQua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuKetQuaActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Tên dịch vụ");

        txtMaDichVu.setEditable(false);
        txtMaDichVu.setPreferredSize(new java.awt.Dimension(64, 30));

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

        javax.swing.GroupLayout TongChiDinhPanelLayout = new javax.swing.GroupLayout(TongChiDinhPanel);
        TongChiDinhPanel.setLayout(TongChiDinhPanelLayout);
        TongChiDinhPanelLayout.setHorizontalGroup(
            TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TongChiDinhPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(TongChiDinhPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(TongChiDinhPanelLayout.createSequentialGroup()
                        .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(txtMaChiDinh, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(40, 40, 40)
                        .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addGroup(TongChiDinhPanelLayout.createSequentialGroup()
                        .addComponent(btnLuuKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        TongChiDinhPanelLayout.setVerticalGroup(
            TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TongChiDinhPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaChiDinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLuuKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(TongChiDinhPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TongChiDinhPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSChiDinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSChiDinhMouseClicked
        int selectedIndex = tblDSChiDinh.getSelectedRow();
        if (selectedIndex >= 0) {
            ChiDinhModel cd = dsChiDinh.get(selectedIndex);

            txtMaChiDinh.setText(cd.getMaChiDinh());
            txtMaDichVu.setText(cd.getMaDichVuCLS());
            txtTenDichVu.setText(cd.getTenDichVuCLS());
            txaKetQua.setText(cd.getKetQua());
        }
    }//GEN-LAST:event_tblDSChiDinhMouseClicked

    private void btnLuuKetQuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuKetQuaActionPerformed
        try {
            String maChiDinh = txtMaChiDinh.getText();
            String ketQua = txaKetQua.getText();
            if (maBacSi.isEmpty() || maBacSi.equals("---Khoa---")) {
                DialogHelper.showError("Bác sĩ không được bỏ trống");
            } else if (maChiDinh.isEmpty()) {
                DialogHelper.showError("Mã chỉ định không được bỏ trống");
            } else if (ketQua.isEmpty()) {
                DialogHelper.showError("Kết quả không được bỏ trống");
            } else {
                ChiDinhModel kq = new ChiDinhModel(maChiDinh, maBacSi.split(" ")[0], ketQua);
                ChiDinhCtrl.capNhatKetQua(kq);
                DialogHelper.showMessage("Lưu kết quả thành công!");
                dsChiDinh = ChiDinhCtrl.timChiDinhTheoMa(maBenhAn);
                hienThiDSDichvu();
                lamMoi();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KetQuaCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLuuKetQuaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoi();

        try {
            dsChiDinh = ChiDinhCtrl.timChiDinhTheoMa(maBenhAn);
            hienThiDSDichvu();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KetQuaCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TongChiDinhPanel;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLuuKetQua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tblDSChiDinh;
    private javax.swing.JTextArea txaKetQua;
    private javax.swing.JTextField txtMaChiDinh;
    private javax.swing.JTextField txtMaDichVu;
    private javax.swing.JTextField txtTenDichVu;
    // End of variables declaration//GEN-END:variables
}
