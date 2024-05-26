package views.main;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import models.KhamLamSangModel;
import models.ChiDinhModel;
import models.DonThuocModel;
import models.BenhAnModel;
import models.BenhNhanModel;
import models.XepGiuongModel;
import controllers.KhamLamSangCtrl;
import controllers.ChiDinhCtrl;
import controllers.DonThuocCtrl;
import controllers.BenhAnCtrl;
import controllers.BenhNhanCtrl;
import pdfForm.GenerateHoaDon;
import utils.DialogHelper;

public class ThuTien extends javax.swing.JPanel {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static ThuTien Instance;
    public JLabel MaBNLabel;
    public JLabel NameLabel;
    public JLabel SexLabel;
    public JLabel MaBALabel;

    DefaultTableModel tableModel;
    List<KhamLamSangModel> dsKhamLamSang = new ArrayList<>();
    List<ChiDinhModel> dsChiDinh = new ArrayList<>();
    List<DonThuocModel> dsDonThuoc = new ArrayList<>();
    List<XepGiuongModel> dsXepGiuong = new ArrayList<>();

    public ThuTien() {
        initComponents();

        Instance = this;
        MaBNLabel = txtMaBenhNhan;
        NameLabel = txtHoTen;
        SexLabel = txtGioiTinh;
        MaBALabel = txtMaBenhAn;

        tableModel = (DefaultTableModel) tblThanhToan.getModel();

        LocalDate currentDate = LocalDate.now();
        txtNgayThu.setText(currentDate.format(formatter));
    }

    public void hienThiDSThanhToan() throws ClassNotFoundException {
        int tongTien = 0;

        dsKhamLamSang = KhamLamSangCtrl.thanhToanKLS(txtMaBenhAn.getText());
        dsChiDinh = ChiDinhCtrl.timChiDinhTheoMa(txtMaBenhAn.getText());
        dsDonThuoc = DonThuocCtrl.timDonThuocTheoMa(txtMaBenhAn.getText());

        tableModel.setRowCount(0);

        tableModel.addRow(new Object[]{"Dịch vụ khám", "", "", ""});
        for (KhamLamSangModel ls : dsKhamLamSang) {
            tableModel.addRow(new Object[]{ls.getTenDichVu(), "", ls.getGiaTien(),
                ls.getGiaTien()});
            tongTien += Integer.parseInt(ls.getGiaTien());
        }
        tableModel.addRow(new Object[]{"", "", "", ""});

        tableModel.addRow(new Object[]{"Dịch vụ cận lâm sàn", "", "", ""});
        for (ChiDinhModel ls : dsChiDinh) {
            tableModel.addRow(new Object[]{ls.getTenDichVuCLS(), ls.getSoLuong(), ls.getDonGia(),
                ls.getThanhTien()});
            tongTien += ls.getThanhTien();
        }
        tableModel.addRow(new Object[]{"", "", "", ""});

        tableModel.addRow(new Object[]{"Thuốc", "", "", ""});
        for (DonThuocModel ls : dsDonThuoc) {
            tableModel.addRow(new Object[]{ls.getTenThuoc(), ls.getSoLuong(), ls.getDonGia(),
                ls.getThanhTien()});
            tongTien += ls.getThanhTien();
        }
        tableModel.addRow(new Object[]{"", "", "", ""});

        tableModel.addRow(new Object[]{"Nhập viện", "", "", ""});
        for (XepGiuongModel xg : dsXepGiuong) {
            tableModel.addRow(new Object[]{"Mã giường: " + xg.getMaGiuong() + " Tên phòng: " + xg.getTenPhong(), xg.getSoNgay(), "",
                xg.getThanhTien()});
            tongTien += xg.getThanhTien();
        }
        tableModel.addRow(new Object[]{"", "", "", ""});

        txtTongTien.setText(Integer.toString(tongTien));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThanhToan = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNgayThu = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtThuTien = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCon = new javax.swing.JTextField();
        btnLuuHoaDon = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMaBenhAn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaBenhNhan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtGioiTinh = new javax.swing.JLabel();
        btnXuatHoaDon = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtDaThu = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1360, 635));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 635));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblThanhToan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nội dung", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(tblThanhToan);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel19.setText("Chi tiết dịch vụ thanh toán");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Thông tin phiếu thu");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Ngày thu:");

        txtNgayThu.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Tổng tiền:");

        txtTongTien.setEditable(false);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Thu:");

        txtThuTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThuTienActionPerformed(evt);
            }
        });
        txtThuTien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtThuTienKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Còn:");

        txtCon.setEditable(false);

        btnLuuHoaDon.setBackground(new java.awt.Color(0, 102, 255));
        btnLuuHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuuHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnLuuHoaDon.setText("Lưu hóa đơn");
        btnLuuHoaDon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLuuHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLuuHoaDon.setPreferredSize(new java.awt.Dimension(60, 30));
        btnLuuHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuHoaDonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã bệnh án:");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtMaBenhAn.setText("______________________________________________");
        txtMaBenhAn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtMaBenhAnPropertyChange(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã BN:");

        txtMaBenhNhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaBenhNhan.setText("_______________________________________");
        txtMaBenhNhan.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtMaBenhNhanPropertyChange(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Họ tên:");

        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHoTen.setText("_______________________________________");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Giới tính:");

        txtGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGioiTinh.setText("_______________________________________");

        btnXuatHoaDon.setBackground(new java.awt.Color(0, 102, 255));
        btnXuatHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatHoaDon.setText("Xuất hóa đơn");
        btnXuatHoaDon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXuatHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatHoaDon.setPreferredSize(new java.awt.Dimension(120, 30));
        btnXuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHoaDonActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Đã thu:");

        txtDaThu.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnLuuHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCon, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtThuTien, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDaThu, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayThu, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaBenhAn, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaBenhNhan))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoTen))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGioiTinh))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaBenhAn))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNgayThu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtDaThu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtThuTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtCon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuuHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtMaBenhAn.getAccessibleContext().setAccessibleName("_______________________________");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaBenhNhanPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtMaBenhNhanPropertyChange

    }//GEN-LAST:event_txtMaBenhNhanPropertyChange

    private void txtThuTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThuTienActionPerformed
        int daThu = Integer.parseInt(txtDaThu.getText());
        if (daThu != 0) {
            int tienCon = Integer.parseInt(txtTongTien.getText()) - daThu - Integer.parseInt(txtThuTien.getText());
            txtCon.setText(Integer.toString(tienCon));
        } else {
            int tienCon = Integer.parseInt(txtTongTien.getText()) - Integer.parseInt(txtThuTien.getText());
            txtCon.setText(Integer.toString(tienCon));
        }

    }//GEN-LAST:event_txtThuTienActionPerformed

    private void txtMaBenhAnPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtMaBenhAnPropertyChange
        try {
            hienThiDSThanhToan();
            String maBenhAn = MaBALabel.getText();
            if (!maBenhAn.isEmpty() && maBenhAn != null) {
                List<BenhAnModel> dsThuTien = BenhAnCtrl.timTienDaThu(maBenhAn);

                if (!dsThuTien.isEmpty()) {
                    BenhAnModel thuTien = dsThuTien.get(0);
                    if (thuTien.getDaThu() != 0) {
                        txtDaThu.setText(Integer.toString(thuTien.getDaThu()));
                    }
                } else {
                    txtDaThu.setText("0");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThuTien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtMaBenhAnPropertyChange

    private void btnLuuHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuHoaDonActionPerformed

        if (txtMaBenhAn.getText().isEmpty() || txtMaBenhAn.getText().startsWith("__")) {
            DialogHelper.showError("Chưa có bệnh án nào được chọn. Vui lòng chọn bệnh án");
        } else if (txtTongTien.getText().isEmpty()) {
            DialogHelper.showError("Tổng tiền chưa được nhập. Vui lòng chọn bệnh án");
        } else if (txtThuTien.getText().isEmpty()) {
            DialogHelper.showError("Thu chưa được nhập. Vui lòng nhập số tiền đã thu");
        } else if (Integer.parseInt(txtThuTien.getText()) > Integer.parseInt(txtTongTien.getText())) {
            DialogHelper.showError("Số tiền thu vượt quá tổng tiền!");
        } else if (Integer.parseInt(txtTongTien.getText()) == Integer.parseInt(txtDaThu.getText())) {
            DialogHelper.showError("Đã thu đủ tiền!");
        } else {
            if (Integer.parseInt(txtDaThu.getText()) > 0) {
                try {
                    String maBenhAn = txtMaBenhAn.getText();
                    int tongTien = Integer.parseInt(txtTongTien.getText());
                    int thu = Integer.parseInt(txtThuTien.getText());
                    int daThu = Integer.parseInt(txtDaThu.getText());

                    BenhAnModel ba = new BenhAnModel(maBenhAn, tongTien, thu + daThu);
                    BenhAnCtrl.capNhatTien(ba);
                    DialogHelper.showMessage("Thu tiền thành công!");
//                    ThuTextField.setText("");
//                    ConTextField.setText("");

                    List<BenhAnModel> dsThuTien = BenhAnCtrl.timTienDaThu(maBenhAn);

                    if (!dsThuTien.isEmpty()) {
                        BenhAnModel thuTien = dsThuTien.get(0);
                        if (thuTien.getDaThu() != 0) {
                            txtDaThu.setText(Integer.toString(thuTien.getDaThu()));
                        }
                    } else {
                        txtDaThu.setText("0");
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ThuTien.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    String maBenhAn = txtMaBenhAn.getText();
                    int tongTien = Integer.parseInt(txtTongTien.getText());
                    int thu = Integer.parseInt(txtThuTien.getText());
                    int daThu = Integer.parseInt(txtDaThu.getText());

                    BenhAnModel ba = new BenhAnModel(maBenhAn, tongTien, thu);
                    BenhAnCtrl.capNhatTien(ba);
                    DialogHelper.showMessage("Thu tiền thành công!");
//                    ThuTextField.setText("");
//                    ConTextField.setText("");

                    List<BenhAnModel> dsThuTien = BenhAnCtrl.timTienDaThu(maBenhAn);

                    if (!dsThuTien.isEmpty()) {
                        BenhAnModel thuTien = dsThuTien.get(0);
                        if (thuTien.getDaThu() != 0) {
                            txtDaThu.setText(Integer.toString(thuTien.getDaThu()));
                        }
                    } else {
                        txtDaThu.setText("0");
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ThuTien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnLuuHoaDonActionPerformed

    private void txtThuTienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThuTienKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThuTienKeyTyped

    private void btnXuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHoaDonActionPerformed
        String maBenhAn = MaBALabel.getText();
        String maBenhNhan = MaBNLabel.getText();
        String daThu = txtDaThu.getText();
        String thu = txtThuTien.getText();

        if (daThu.isEmpty() || daThu == null) {
            daThu = "0";
        }

        if (maBenhAn.isEmpty() || maBenhAn.startsWith("__")) {
            DialogHelper.showError("Chưa có bệnh án nào được chọn. Vui lòng chọn bệnh án");
        } else if (thu.isEmpty()) {
            DialogHelper.showError("Thu chưa được nhập. Vui lòng nhập số tiền đã thu");
        } else {
            try {
                BenhNhanModel benhNhan;
                benhNhan = BenhNhanCtrl.timBenhNhanTheoMa(maBenhNhan);

                List<DonThuocModel> dsThuoc = new ArrayList<>();

                dsThuoc = DonThuocCtrl.timDonThuocTheoMa(maBenhAn);

                BenhAnModel benhAn = BenhAnCtrl.timBenhAn(maBenhAn);

                KhamLamSangModel khamLS = KhamLamSangCtrl.timKhamBenhTheoMa(benhAn.getMaKhamLamSang());

                int namHienTai = LocalDate.now().getYear();
                int thangHienTai = LocalDate.now().getMonthValue();
                int ngayHienTai = LocalDate.now().getDayOfMonth();

                String ten = benhNhan.getHoTen();
                String tuoi = Integer.toString(namHienTai - Integer.parseInt(benhNhan.getNamSinh()));
                String gioiTinh = benhNhan.getGioiTinh();
                String diaChi = benhNhan.getDiaChi();
                String chuanDoan = khamLS.getChuanDoan();
                String tongTien = txtTongTien.getText();

                if (ten.isEmpty()) {
                    DialogHelper.showError("Chưa có tên của bệnh nhân");
                } else if (gioiTinh.isEmpty()) {
                    DialogHelper.showError("Chưa có giới tính của bệnh nhân");
                } else if (diaChi.isEmpty()) {
                    DialogHelper.showError("Chưa có địa chỉ của bệnh nhân");
                } else if (chuanDoan == null || chuanDoan.isEmpty()) {
                    DialogHelper.showError("Bệnh nhân chưa được chuẩn đoán");
                } else if (tongTien.isEmpty()) {
                    DialogHelper.showError("Chưa có tổng tiền");
                } else {
                    GenerateHoaDon inDon = new GenerateHoaDon(ten, tuoi, gioiTinh, diaChi, chuanDoan, tongTien, daThu, thu, Integer.toString(ngayHienTai), Integer.toString(thangHienTai), Integer.toString(namHienTai));

                    List<String> noiDung = new ArrayList<>();
                    List<String> soLuong = new ArrayList<>();
                    List<String> donGia = new ArrayList<>();
                    List<String> thanhTien = new ArrayList<>();

                    for (KhamLamSangModel ls : dsKhamLamSang) {
                        noiDung.add(ls.getTenDichVu());
                        soLuong.add("");
                        donGia.add(ls.getGiaTien());
                        thanhTien.add(ls.getGiaTien());
                    }

                    for (ChiDinhModel ls : dsChiDinh) {
                        noiDung.add(ls.getTenDichVuCLS());
                        soLuong.add(Integer.toString(ls.getSoLuong()));
                        donGia.add(Integer.toString(ls.getDonGia()));
                        thanhTien.add(Integer.toString(ls.getThanhTien()));
                    }

                    for (DonThuocModel ls : dsDonThuoc) {
                        noiDung.add(ls.getTenThuoc());
                        soLuong.add(Integer.toString(ls.getSoLuong()));
                        donGia.add(Integer.toString(ls.getDonGia()));
                        thanhTien.add(Integer.toString(ls.getThanhTien()));
                    }

                    for (XepGiuongModel xg : dsXepGiuong) {
                        noiDung.add("Mã giường: " + xg.getMaGiuong() + " Tên phòng: " + xg.getTenPhong());
                        soLuong.add(Integer.toString(xg.getSoNgay()));
                        donGia.add(Integer.toString(xg.getThanhTien()));
                        thanhTien.add(Integer.toString(xg.getThanhTien()));

                    }

                    inDon.setNoiDung(noiDung);
                    inDon.setSoLuong(soLuong);
                    inDon.setDonGia(donGia);
                    inDon.setThanhTien(thanhTien);

                    try {
                        inDon.taoHoaDon();
                        DialogHelper.showMessage("In hóa đơn thành công!");
                    } catch (IOException ex) {
                        Logger.getLogger(ThuTien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThuTien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnXuatHoaDonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuuHoaDon;
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThanhToan;
    private javax.swing.JTextField txtCon;
    private javax.swing.JTextField txtDaThu;
    private javax.swing.JLabel txtGioiTinh;
    private javax.swing.JLabel txtHoTen;
    private javax.swing.JLabel txtMaBenhAn;
    private javax.swing.JLabel txtMaBenhNhan;
    private javax.swing.JTextField txtNgayThu;
    private javax.swing.JTextField txtThuTien;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
