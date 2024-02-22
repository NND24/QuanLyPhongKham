package views.main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.ChiDinhModel;
import models.BenhNhanModel;
import models.DichVuCLSModel;
import models.NhomDichVuCLSModel;
import models.BenhAnModel;
import controllers.BenhAnCtrl;
import controllers.DangKyCtrl;
import controllers.BenhNhanCtrl;
import controllers.ChiDinhCtrl;
import controllers.DichVuCLSCtrl;
import controllers.NhomDichVuCLSCtrl;
import models.DangKyModel;
import utils.DialogHelper;
import utils.Validator;

public class ChiDinh extends javax.swing.JPanel {

    public static ChiDinh Instance;
    public String maBenhNhan, maBenhAn, maBacSi;

    DefaultTableModel tableModel;
    public List<ChiDinhModel> dsChiDinh = new ArrayList<>();
    List<DichVuCLSModel> dsDichVu = new ArrayList<>();

    public ChiDinh() {
        initComponents();
        Instance = this;
        tableModel = (DefaultTableModel) tblDSChiDinh.getModel();
        hienThiDSNhomDV();
    }

    private void hienThiDSNhomDV() {
        try {
            List<NhomDichVuCLSModel> dsNhomDichVu = NhomDichVuCLSCtrl.timTatNhomDichVuCLS();
            cmbNhomDichVuCLS.removeAllItems();
            cmbNhomDichVuCLS.addItem("---Nhóm dịch vụ---");
            dsNhomDichVu.forEach(ndv -> {
                if (ndv.getTrangThai().equals("Kích hoạt")) {
                    String nhomDichVu = ndv.getMaNhomDichVu() + " " + ndv.getTenNhomDichVu();
                    cmbNhomDichVuCLS.addItem(nhomDichVu);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChiDinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hienThiDSDichvu() throws ClassNotFoundException {
        tableModel.setRowCount(0);

        dsChiDinh.forEach(cd -> {
            tableModel.addRow(new Object[]{cd.getTenDichVuCLS(), cd.getSoLuong(),
                cd.getDonGia(), cd.getThanhTien(), cd.getGhiChu()
            });
        });
    }

    private void lamMoi() {
        cmbNhomDichVuCLS.setSelectedIndex(0);
        cmbDichVuCLS.setSelectedIndex(0);
        txtTenDichVu.setText("");
        txtDonGia.setText("0");
        txtSoLan.setText("");
        txtGhiChu.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TongChiDinhPanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        cmbDichVuCLS = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtSoLan = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        lblTongDichVu = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        btnKetThucKham = new javax.swing.JButton();
        btnInChiDinh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDSChiDinh = new javax.swing.JTable();
        txtTenDichVu = new javax.swing.JTextField();
        btnThemChiDinh = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        cmbNhomDichVuCLS = new javax.swing.JComboBox<>();
        btnXoaChiDinh = new javax.swing.JButton();
        btnSuaChiDinh = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1100, 500));

        TongChiDinhPanel.setBackground(new java.awt.Color(255, 255, 255));
        TongChiDinhPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TongChiDinhPanel.setPreferredSize(new java.awt.Dimension(1100, 500));
        TongChiDinhPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TongChiDinhPanelMouseMoved(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Chọn dịch vụ");

        cmbDichVuCLS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Dịch vụ---", "DVC000034 Chụp cộng hưởng từ cột sống cổ (0.2-1.5T) (không thuốc)", "DVC00193247 Chụp cộng hưởng từ cột sống cổ có tiêm tương phản (0.2-1.5T)", "DVC19464858 Điều trị một số bệnh da bằng laser (nốt ruồi, ban vàng, u tuyến mồ hôi, thịt dư, đuôi da, mụn cóc…)-Loại 1" }));
        cmbDichVuCLS.setPreferredSize(new java.awt.Dimension(72, 30));
        cmbDichVuCLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDichVuCLSActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Tên dịch vụ");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Đơn giá");

        txtDonGia.setEditable(false);
        txtDonGia.setText("0");
        txtDonGia.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Số lần");

        txtSoLan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoLanFocusLost(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Ghi chú");

        txtGhiChu.setPreferredSize(new java.awt.Dimension(200, 22));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Số tiền:");

        lblTongDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTongDichVu.setForeground(new java.awt.Color(255, 0, 0));
        lblTongDichVu.setText("0");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Tổng:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("dịch vụ");

        btnKetThucKham.setBackground(new java.awt.Color(0, 102, 255));
        btnKetThucKham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKetThucKham.setForeground(new java.awt.Color(255, 255, 255));
        btnKetThucKham.setText("Kết thúc khám");
        btnKetThucKham.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnKetThucKham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucKhamActionPerformed(evt);
            }
        });

        btnInChiDinh.setBackground(new java.awt.Color(0, 102, 255));
        btnInChiDinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInChiDinh.setForeground(new java.awt.Color(255, 255, 255));
        btnInChiDinh.setText("In chỉ định");
        btnInChiDinh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tblDSChiDinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên dịch vụ", "Số lần", "Đơn giá", "Thành tiền", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSChiDinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSChiDinhMouseClicked(evt);
            }
        });
        tblDSChiDinh.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblDSChiDinhPropertyChange(evt);
            }
        });
        jScrollPane7.setViewportView(tblDSChiDinh);

        txtTenDichVu.setEditable(false);
        txtTenDichVu.setPreferredSize(new java.awt.Dimension(64, 30));

        btnThemChiDinh.setBackground(new java.awt.Color(0, 102, 255));
        btnThemChiDinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemChiDinh.setForeground(new java.awt.Color(255, 255, 255));
        btnThemChiDinh.setText("Thêm");
        btnThemChiDinh.setToolTipText("Thêm chỉ định");
        btnThemChiDinh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThemChiDinh.setPreferredSize(new java.awt.Dimension(70, 30));
        btnThemChiDinh.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnThemChiDinhMouseMoved(evt);
            }
        });
        btnThemChiDinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemChiDinhActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Chọn nhóm dịch vụ");

        cmbNhomDichVuCLS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Nhóm dịch vụ---", "NDV06108015 Chẩn Đoán Hình Ảnh", "NDV06351398 Phẫu Thuật  - Thủ Thuật" }));
        cmbNhomDichVuCLS.setToolTipText("");
        cmbNhomDichVuCLS.setPreferredSize(new java.awt.Dimension(72, 30));
        cmbNhomDichVuCLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNhomDichVuCLSActionPerformed(evt);
            }
        });

        btnXoaChiDinh.setBackground(new java.awt.Color(0, 102, 255));
        btnXoaChiDinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaChiDinh.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaChiDinh.setText("Xóa");
        btnXoaChiDinh.setToolTipText("Xóa dịch vụ");
        btnXoaChiDinh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoaChiDinh.setPreferredSize(new java.awt.Dimension(70, 30));
        btnXoaChiDinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaChiDinhActionPerformed(evt);
            }
        });

        btnSuaChiDinh.setBackground(new java.awt.Color(0, 102, 255));
        btnSuaChiDinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaChiDinh.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaChiDinh.setText("Sửa ");
        btnSuaChiDinh.setToolTipText("Xóa dịch vụ");
        btnSuaChiDinh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSuaChiDinh.setPreferredSize(new java.awt.Dimension(70, 30));
        btnSuaChiDinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaChiDinhActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setToolTipText("Làm mới");
        btnLamMoi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(90, 30));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TongChiDinhPanelLayout = new javax.swing.GroupLayout(TongChiDinhPanel);
        TongChiDinhPanel.setLayout(TongChiDinhPanelLayout);
        TongChiDinhPanelLayout.setHorizontalGroup(
            TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
            .addGroup(TongChiDinhPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TongChiDinhPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(TongChiDinhPanelLayout.createSequentialGroup()
                .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TongChiDinhPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addGroup(TongChiDinhPanelLayout.createSequentialGroup()
                                .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(txtSoLan, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbNhomDichVuCLS, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23)
                                    .addComponent(cmbDichVuCLS, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))))
                        .addGap(30, 30, 30)
                        .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TongChiDinhPanelLayout.createSequentialGroup()
                                .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(TongChiDinhPanelLayout.createSequentialGroup()
                                .addComponent(btnThemChiDinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btnXoaChiDinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btnSuaChiDinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(TongChiDinhPanelLayout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(btnKetThucKham, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnInChiDinh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTongDichVu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)))
                .addContainerGap())
        );
        TongChiDinhPanelLayout.setVerticalGroup(
            TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TongChiDinhPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(2, 2, 2)
                .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDichVuCLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNhomDichVuCLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(2, 2, 2)
                .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemChiDinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaChiDinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaChiDinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(TongChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTongDichVu)
                    .addComponent(jLabel27)
                    .addComponent(btnKetThucKham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInChiDinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
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

    private void tblDSChiDinhPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblDSChiDinhPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDSChiDinhPropertyChange

    private void TongChiDinhPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TongChiDinhPanelMouseMoved
        int tongDichVu = 0;
        int tongTien = 0;
        for (ChiDinhModel dcd : dsChiDinh) {
            tongDichVu += 1;
            tongTien += dcd.getThanhTien();
        }
        lblTongDichVu.setText(Integer.toString(tongDichVu));
        txtTongTien.setText(Integer.toString(tongTien));
    }//GEN-LAST:event_TongChiDinhPanelMouseMoved

    private void cmbNhomDichVuCLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNhomDichVuCLSActionPerformed
        try {
            if (maBenhAn != null) {
                if (maBenhAn.isEmpty() || maBenhAn.startsWith("__")) {
                    DialogHelper.showError("Chưa có bệnh án nào được chọn. Vui lòng chọn bệnh án");
                } else {
                    if (cmbNhomDichVuCLS.getSelectedItem() != null) {
                        if (cmbNhomDichVuCLS.getSelectedItem().toString().equals("---Nhóm dịch vụ---")) {
                            txtTenDichVu.setText("");
                            txtDonGia.setText("0");
                            txtSoLan.setText("");
                            txtGhiChu.setText("");
                        } else {
                            String maNhomDichVu = cmbNhomDichVuCLS.getSelectedItem().toString().split(" ")[0];

                            dsDichVu.clear();
                            cmbDichVuCLS.removeAllItems();
                            cmbDichVuCLS.addItem("---Dịch vụ---");
                            dsDichVu = DichVuCLSCtrl.timTatCaDichVuTheoMaNhom(maNhomDichVu);
                            dsDichVu.forEach(dv -> {
                                if (dv.getTrangThai().equals("Kích hoạt")) {
                                    String dichVu = dv.getMaDichVu() + " " + dv.getTenDichVu();
                                    cmbDichVuCLS.addItem(dichVu);
                                }
                            });
                        }
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChiDinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbNhomDichVuCLSActionPerformed

    private void cmbDichVuCLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDichVuCLSActionPerformed
        // TODO add your handling code here:
        try {
            if (cmbDichVuCLS.getSelectedItem() != null) {
                if (!cmbDichVuCLS.getSelectedItem().toString().equals("---Dịch vụ---")) {
                    BenhNhanModel benhNhan = BenhNhanCtrl.timBenhNhanTheoMa(maBenhNhan);

                    if (benhNhan.getBhyt() == null || benhNhan.getBhyt().equals("")) {
                        String maDichVu = cmbDichVuCLS.getSelectedItem().toString().split(" ")[0];
                        dsDichVu = DichVuCLSCtrl.timTatCaDichVuTheoMa(maDichVu);
                        dsDichVu.forEach(dv -> {
                            txtTenDichVu.setText(dv.getTenDichVu());
                            txtDonGia.setText(Integer.toString(dv.getGiaTien()));
                        });
                    } else {
                        String maDichVu = cmbDichVuCLS.getSelectedItem().toString().split(" ")[0];
                        dsDichVu = DichVuCLSCtrl.timTatCaDichVuTheoMa(maDichVu);
                        dsDichVu.forEach(dv -> {
                            txtTenDichVu.setText(dv.getTenDichVu());
                            txtDonGia.setText(Integer.toString(dv.getGiaBaoHiem()));
                        });
                    }
                } else {
                    txtTenDichVu.setText("");
                    txtDonGia.setText("0");
                    txtSoLan.setText("");
                    txtGhiChu.setText("");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChiDinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbDichVuCLSActionPerformed

    private void btnThemChiDinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemChiDinhActionPerformed
        try {
            if (maBenhAn.isEmpty() || maBenhAn.startsWith("__")) {
                DialogHelper.showError("Chưa có bệnh án nào được chọn. Vui lòng chọn bệnh án");
            } else if (txtSoLan.getText().isEmpty()) {
                DialogHelper.showError("Số lần không được để trống");
            } else if (txtSoLan.getText().equals("0")) {
                DialogHelper.showError("Số lần phải lớn hơn không");
            } else if (!txtSoLan.getText().isEmpty() && !Validator.isIntegerString(txtSoLan.getText())) {
                DialogHelper.showError("Số lần không hợp lệ");
            } else {
                String maChiDinh = ChiDinhCtrl.generateMaChiDinh();
                String maDichVu = cmbDichVuCLS.getSelectedItem().toString();
                int soLuong = Integer.parseInt(txtSoLan.getText());
                int donGia = Integer.parseInt(txtDonGia.getText());
                int thanhTien = soLuong * donGia;
                String ghiChu = txtGhiChu.getText();

                ChiDinhModel cd = new ChiDinhModel(maChiDinh, maBacSi, maBenhAn, maDichVu.split(" ")[0], soLuong, donGia, thanhTien, ghiChu);
                ChiDinhCtrl.themChiDinh(cd);
                dsChiDinh = ChiDinhCtrl.timChiDinhTheoMa(maBenhAn);
                hienThiDSDichvu();
                lamMoi();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChiDinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemChiDinhActionPerformed

    private void btnThemChiDinhMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemChiDinhMouseMoved
        // TODO add your handling code here:
        int tongDichVu = 0;
        int tongTien = 0;

        for (ChiDinhModel dcd : dsChiDinh) {
            tongDichVu += 1;
            tongTien += dcd.getThanhTien();
        }

        lblTongDichVu.setText(Integer.toString(tongDichVu));
        txtTongTien.setText(Integer.toString(tongTien));
    }//GEN-LAST:event_btnThemChiDinhMouseMoved

    private void btnXoaChiDinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaChiDinhActionPerformed
        int selectedIndex = tblDSChiDinh.getSelectedRow();
        if (selectedIndex >= 0) {
            try {
                boolean flag = DialogHelper.showConfirmation("Bạn có chắc muốn xóa chỉ định này");

                if (flag) {
                    ChiDinhModel cd = dsChiDinh.get(selectedIndex);
                    ChiDinhCtrl.xoaChiDinh(cd.getMaChiDinh());
                    dsChiDinh = ChiDinhCtrl.timChiDinhTheoMa(maBenhAn);
                    hienThiDSDichvu();
                    lamMoi();
                    DialogHelper.showMessage("Xóa chỉ định thành công");
                }
                hienThiDSDichvu();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ChiDinh.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            DialogHelper.showError("Chưa có dòng nào được chọn");
        }
    }//GEN-LAST:event_btnXoaChiDinhActionPerformed

    private void tblDSChiDinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSChiDinhMouseClicked
        // TODO add your handling code here:
        int selectedIndex = tblDSChiDinh.getSelectedRow();
        if (selectedIndex >= 0) {
            ChiDinhModel cd = dsChiDinh.get(selectedIndex);

            cmbNhomDichVuCLS.setSelectedItem(cd.getMaNhomDichVuCLS() + " " + cd.getTenNhomDichVuCLS());
            cmbDichVuCLS.setSelectedItem(cd.getMaDichVuCLS() + " " + cd.getTenDichVuCLS());
            txtTenDichVu.setText(cd.getTenDichVuCLS());
            txtDonGia.setText(Integer.toString(cd.getDonGia()));
            txtSoLan.setText(Integer.toString(cd.getSoLuong()));
            txtGhiChu.setText(cd.getGhiChu());
        }
    }//GEN-LAST:event_tblDSChiDinhMouseClicked

    private void btnKetThucKhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucKhamActionPerformed
        // TODO add your handling code here:
        if (maBenhAn.isEmpty() || maBenhAn.startsWith("__")) {
            DialogHelper.showError("Chưa có bệnh án nào được chọn. Vui lòng chọn bệnh án");
        } else {
            try {
                BenhAnModel benhAn = BenhAnCtrl.timBenhAn(maBenhAn);

                DangKyModel dk = new DangKyModel(benhAn.getMaDangKy(), "Đã khám");
                DangKyCtrl.capNhatTrangThai(dk);
                DialogHelper.showMessage("Kết thúc khám bệnh thành công!");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ChiDinh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnKetThucKhamActionPerformed

    private void btnSuaChiDinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaChiDinhActionPerformed
        try {
            int selectedIndex = tblDSChiDinh.getSelectedRow();
            if (selectedIndex >= 0) {
                if (!txtSoLan.getText().isEmpty() && !Validator.isIntegerString(txtSoLan.getText())) {
                    DialogHelper.showError("Số lần không hợp lệ");
                } else if (txtSoLan.getText().equals("0")) {
                    DialogHelper.showError("Số lần phải lớn hơn không");
                } else if (txtSoLan.getText().isEmpty()) {
                    DialogHelper.showError("Số lần không được để trống");
                } else if (!txtSoLan.getText().isEmpty() && !Validator.isIntegerString(txtSoLan.getText())) {
                    DialogHelper.showError("Số lần không hợp lệ");
                } else {
                    ChiDinhModel cd = dsChiDinh.get(selectedIndex);

                    String dichVuCLS = cmbDichVuCLS.getSelectedItem().toString();
                    int donGia = Integer.parseInt(txtDonGia.getText());
                    int soLuong = Integer.parseInt(txtSoLan.getText());
                    int thanhTien = donGia * soLuong;
                    String ghiChu = txtGhiChu.getText();
                    ChiDinhModel chiDinh = new ChiDinhModel(cd.getMaChiDinh(), dichVuCLS.split(" ")[0], ghiChu, soLuong, thanhTien);
                    ChiDinhCtrl.capNhatChiDinh(chiDinh);
                    dsChiDinh = ChiDinhCtrl.timChiDinhTheoMa(maBenhAn);
                    hienThiDSDichvu();
                    lamMoi();
                }
            } else {
                DialogHelper.showError("Chưa có dòng nào được chọn");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChiDinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaChiDinhActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoi();
        hienThiDSNhomDV();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtSoLanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoLanFocusLost
        String soLan = txtSoLan.getText();
        if (!soLan.isEmpty() && !Validator.isIntegerString(soLan)) {
            DialogHelper.showError("Số lần không hợp lệ");
            txtSoLan.requestFocus();
        }
    }//GEN-LAST:event_txtSoLanFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TongChiDinhPanel;
    private javax.swing.JButton btnInChiDinh;
    private javax.swing.JButton btnKetThucKham;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSuaChiDinh;
    private javax.swing.JButton btnThemChiDinh;
    private javax.swing.JButton btnXoaChiDinh;
    private javax.swing.JComboBox<String> cmbDichVuCLS;
    private javax.swing.JComboBox<String> cmbNhomDichVuCLS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblTongDichVu;
    private javax.swing.JTable tblDSChiDinh;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtSoLan;
    private javax.swing.JTextField txtTenDichVu;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
