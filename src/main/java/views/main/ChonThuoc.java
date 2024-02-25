package views.main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.DonThuocModel;
import models.NhomThuocModel;
import models.BenhAnModel;
import models.BenhNhanModel;
import models.DangKyModel;
import controllers.BenhAnCtrl;
import controllers.BenhNhanCtrl;
import controllers.DangKyCtrl;
import controllers.DonThuocCtrl;
import controllers.NhomThuocCtrl;
import utils.Validator;
import utils.DialogHelper;

public class ChonThuoc extends javax.swing.JPanel {

    public static ChonThuoc Instance;
    public String maBenhNhan, maBenhAn, maBacSi;

    DefaultTableModel tableModel;
    public List<DonThuocModel> dsDonThuoc = new ArrayList<>();

    public ChonThuoc() {
        initComponents();
        Instance = this;
        tableModel = (DefaultTableModel) tblDSDonThuoc.getModel();
        hienThiDSNhomThuoc();
    }

    private void hienThiDSNhomThuoc() {
        try {
            List<NhomThuocModel> dsNhomThuoc = NhomThuocCtrl.timTatCaNhomThuoc();
            cmbNhomThuoc.removeAllItems();
            cmbNhomThuoc.addItem("---Nhóm thuốc---");
            dsNhomThuoc.forEach(nt -> {
                if (nt.getTrangThai().equals("Kích hoạt")) {
                    String nhomThuoc = nt.getMaNhomThuoc() + " " + nt.getTenNhomThuoc();
                    cmbNhomThuoc.addItem(nhomThuoc);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChonThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hienThiDSDonThuoc() throws ClassNotFoundException {
        tableModel.setRowCount(0);

        dsDonThuoc.forEach(dt -> {
            tableModel.addRow(new Object[]{dt.getTenThuoc(), dt.getSang(),
                dt.getTrua(), dt.getChieu(), dt.getToi(),
                dt.getSoLuong(), dt.getDuongDung(), dt.getCachDung(),
                dt.getDonGia(), dt.getThanhTien()
            });
        });
    }

    private void lamMoi() {
        cmbNhomThuoc.setSelectedIndex(0);
        cmbThuoc.setSelectedIndex(0);
        txtTenThuoc.setText("");
        txtDuongDung.setText("");
        txtCachDung.setText("");
        txtDonGia.setText(Integer.toString(0));
        txtSoLuong.setText(Integer.toString(0));
        txtSoNgay.setText(Integer.toString(0));
        txtSang.setText(Integer.toString(0));
        txtTrua.setText(Integer.toString(0));
        txtChieu.setText(Integer.toString(0));
        txtToi.setText(Integer.toString(0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChiDinhPanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblTongSoThuoc = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cmbThuoc = new javax.swing.JComboBox<>();
        txtTenThuoc = new javax.swing.JTextField();
        txtSoNgay = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtSang = new javax.swing.JTextField();
        txtTrua = new javax.swing.JTextField();
        txtChieu = new javax.swing.JTextField();
        btnThemThuoc = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDSDonThuoc = new javax.swing.JTable();
        btnKetThucKham = new javax.swing.JButton();
        btnInDonThuoc = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        txtCachDung = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtToi = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cmbNhomThuoc = new javax.swing.JComboBox<>();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        txtDuongDung = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1110, 503));

        ChiDinhPanel.setBackground(new java.awt.Color(255, 255, 255));
        ChiDinhPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ChiDinhPanel.setPreferredSize(new java.awt.Dimension(1110, 503));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Chọn thuốc");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Số ngày");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Sáng");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Trưa");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Số tiền:");

        lblTongSoThuoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTongSoThuoc.setForeground(new java.awt.Color(255, 0, 0));
        lblTongSoThuoc.setText("0");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Tổng:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("thuốc");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Chiều");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Số lượng");

        cmbThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Thuốc---" }));
        cmbThuoc.setPreferredSize(new java.awt.Dimension(72, 30));
        cmbThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbThuocActionPerformed(evt);
            }
        });

        txtTenThuoc.setEditable(false);
        txtTenThuoc.setPreferredSize(new java.awt.Dimension(64, 30));

        txtSoNgay.setText("0");
        txtSoNgay.setPreferredSize(new java.awt.Dimension(64, 30));
        txtSoNgay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoNgayFocusLost(evt);
            }
        });

        txtSoLuong.setText("0");
        txtSoLuong.setPreferredSize(new java.awt.Dimension(64, 30));
        txtSoLuong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoLuongFocusLost(evt);
            }
        });

        txtSang.setText("0");
        txtSang.setPreferredSize(new java.awt.Dimension(64, 30));
        txtSang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSangFocusLost(evt);
            }
        });

        txtTrua.setText("0");
        txtTrua.setPreferredSize(new java.awt.Dimension(64, 30));
        txtTrua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTruaFocusLost(evt);
            }
        });

        txtChieu.setText("0");
        txtChieu.setPreferredSize(new java.awt.Dimension(64, 30));
        txtChieu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtChieuFocusLost(evt);
            }
        });

        btnThemThuoc.setBackground(new java.awt.Color(0, 102, 255));
        btnThemThuoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemThuoc.setForeground(new java.awt.Color(255, 255, 255));
        btnThemThuoc.setText("Thêm");
        btnThemThuoc.setToolTipText("Thêm thuốc");
        btnThemThuoc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThemThuoc.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnThemThuocMouseMoved(evt);
            }
        });
        btnThemThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThuocActionPerformed(evt);
            }
        });

        jPanel3.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("CHI TIẾT ĐƠN THUỐC");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(983, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tblDSDonThuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên thuốc", "Sáng", "Trưa", "Chiều", "Tối", "Tổng", "Đường dùng", "Cách dùng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSDonThuoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDSDonThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSDonThuocMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblDSDonThuoc);

        btnKetThucKham.setBackground(new java.awt.Color(0, 102, 255));
        btnKetThucKham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKetThucKham.setForeground(new java.awt.Color(255, 255, 255));
        btnKetThucKham.setText("Kết thúc khám");
        btnKetThucKham.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnKetThucKham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKetThucKham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucKhamActionPerformed(evt);
            }
        });

        btnInDonThuoc.setBackground(new java.awt.Color(0, 102, 255));
        btnInDonThuoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInDonThuoc.setForeground(new java.awt.Color(255, 255, 255));
        btnInDonThuoc.setText("In đơn thuốc");
        btnInDonThuoc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInDonThuoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Cách dùng");

        txtCachDung.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Tên thuốc");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Tối");

        txtToi.setText("0");
        txtToi.setPreferredSize(new java.awt.Dimension(64, 30));
        txtToi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtToiFocusLost(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Đơn giá");

        txtDonGia.setEditable(false);
        txtDonGia.setText("0");
        txtDonGia.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Chọn nhóm thuốc");

        cmbNhomThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Nhóm thuốc---" }));
        cmbNhomThuoc.setPreferredSize(new java.awt.Dimension(72, 30));
        cmbNhomThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNhomThuocActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(0, 102, 255));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa ");
        btnXoa.setToolTipText("Xóa thuốc");
        btnXoa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 102, 255));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa ");
        btnSua.setToolTipText("Sửa thuốc");
        btnSua.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setToolTipText("Làm mới");
        btnLamMoi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        txtDuongDung.setEditable(false);
        txtDuongDung.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Đường dùng");

        javax.swing.GroupLayout ChiDinhPanelLayout = new javax.swing.GroupLayout(ChiDinhPanel);
        ChiDinhPanel.setLayout(ChiDinhPanelLayout);
        ChiDinhPanelLayout.setHorizontalGroup(
            ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChiDinhPanelLayout.createSequentialGroup()
                .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ChiDinhPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(cmbNhomThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCachDung, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ChiDinhPanelLayout.createSequentialGroup()
                        .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addGap(18, 18, 18)
                        .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addGap(18, 18, 18)
                        .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(txtDuongDung, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ChiDinhPanelLayout.createSequentialGroup()
                        .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTrua, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addGroup(ChiDinhPanelLayout.createSequentialGroup()
                                .addComponent(txtChieu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(txtToi, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25)
                        .addComponent(btnThemThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChiDinhPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnKetThucKham, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnInDonThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTongSoThuoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        ChiDinhPanelLayout.setVerticalGroup(
            ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChiDinhPanelLayout.createSequentialGroup()
                .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ChiDinhPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel32)
                            .addComponent(jLabel20))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChiDinhPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbNhomThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDuongDung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(15, 15, 15)
                .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(jLabel21)
                        .addComponent(jLabel22)
                        .addComponent(jLabel23)
                        .addComponent(jLabel30)
                        .addComponent(jLabel28))
                    .addComponent(jLabel31))
                .addGap(2, 2, 2)
                .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCachDung, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTrua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChieu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtToi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(ChiDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(lblTongSoThuoc)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInDonThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKetThucKham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ChiDinhPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ChiDinhPanel, 509, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbThuocActionPerformed
        try {
            if (cmbThuoc.getSelectedItem() != null) {
                if (!cmbThuoc.getSelectedItem().toString().equals("---Thuốc---")) {
                    BenhNhanModel benhNhan = BenhNhanCtrl.timBenhNhanTheoMa(maBenhNhan);
                    if (benhNhan.getBhyt() == null || benhNhan.getBhyt().equals("")) {
                        String maThuoc = cmbThuoc.getSelectedItem().toString().split(" ")[0];
//                        dsThuoc = ThuocCtrl.timTatCaThuocTheoMa(maThuoc);
//                        dsThuoc.forEach(thuoc -> {
//                            TenThuocTextField.setText(thuoc.getTenThuoc());
//                            DonGiaTextField.setText(Integer.toString(thuoc.getDonGia()));
//                            DuongDungTextField.setText(thuoc.getDuongDung());
//                        });
                    } else {
                        String maThuoc = cmbThuoc.getSelectedItem().toString().split(" ")[0];
//                        dsThuoc = ThuocCtrl.timTatCaThuocTheoMa(maThuoc);
//                        dsThuoc.forEach(thuoc -> {
//                            TenThuocTextField.setText(thuoc.getTenThuoc());
//                            DonGiaTextField.setText(Integer.toString(thuoc.getGiaBHYT()));
//                            DuongDungTextField.setText(thuoc.getDuongDung());
//                        });
                    }
                } else {
                    txtTenThuoc.setText("");
                    txtDuongDung.setText("");
                    txtCachDung.setText("");
                    txtDonGia.setText(Integer.toString(0));
                    txtSoLuong.setText(Integer.toString(0));
                    txtSoNgay.setText(Integer.toString(0));
                    txtSang.setText(Integer.toString(0));
                    txtTrua.setText(Integer.toString(0));
                    txtChieu.setText(Integer.toString(0));
                    txtToi.setText(Integer.toString(0));
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChiDinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbThuocActionPerformed

    private void btnThemThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThuocActionPerformed
        try {
            if (maBenhAn.isEmpty() || maBenhAn.startsWith("__")) {
                DialogHelper.showError("Chưa có bệnh án nào được chọn. Vui lòng chọn bệnh án");
            } else if (txtSoLuong.getText().isEmpty()) {
                DialogHelper.showError(maBenhAn);
                JOptionPane.showMessageDialog(null, "Số lượng không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (txtSoLuong.getText().equals("0")) {
                DialogHelper.showError(maBenhAn);
                JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (txtDonGia.getText().isEmpty()) {
                DialogHelper.showError(maBenhAn);
                JOptionPane.showMessageDialog(null, "Đơn giá không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (txtSoNgay.getText().isEmpty()) {
                DialogHelper.showError(maBenhAn);
                JOptionPane.showMessageDialog(null, "Số ngày không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (txtSoNgay.getText().equals("0")) {
                DialogHelper.showError(maBenhAn);
                JOptionPane.showMessageDialog(null, "Số ngày phải lớn hơn không", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (!txtSoNgay.getText().isEmpty() && !Validator.isIntegerString(txtSoNgay.getText())) {
                DialogHelper.showError(maBenhAn);
                JOptionPane.showMessageDialog(null, "Số ngày không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if (!txtSoLuong.getText().isEmpty() && !Validator.isIntegerString(txtSoLuong.getText())) {
                DialogHelper.showError(maBenhAn);
                JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if (!txtSang.getText().isEmpty() && !Validator.isIntegerString(txtSang.getText())) {
                DialogHelper.showError(maBenhAn);
                JOptionPane.showMessageDialog(null, "Sáng không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if (!txtTrua.getText().isEmpty() && !Validator.isIntegerString(txtTrua.getText())) {
                DialogHelper.showError(maBenhAn);
                JOptionPane.showMessageDialog(null, "Trưa không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if (!txtChieu.getText().isEmpty() && !Validator.isIntegerString(txtChieu.getText())) {
                DialogHelper.showError(maBenhAn);
                JOptionPane.showMessageDialog(null, "Chiều không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if (!txtToi.getText().isEmpty() && !Validator.isIntegerString(txtToi.getText())) {
                DialogHelper.showError(maBenhAn);
                JOptionPane.showMessageDialog(null, "Tối không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                String maDonThuoc = DonThuocCtrl.generateMaDonThuoc();
                String tenThuoc = txtTenThuoc.getText();
                String thuoc = cmbThuoc.getSelectedItem().toString();
                String duongDung = txtDuongDung.getText();
                String cachDung = txtCachDung.getText();
                int soLuong = Integer.parseInt(txtSoLuong.getText());
                int donGia = Integer.parseInt(txtDonGia.getText());
                int thanhTien = soLuong * donGia;
                int soNgay = Integer.parseInt(txtSoNgay.getText());
                int sang = Integer.parseInt(txtSang.getText());
                int trua = Integer.parseInt(txtTrua.getText());
                int chieu = Integer.parseInt(txtChieu.getText());
                int toi = Integer.parseInt(txtToi.getText());
                int tong = soNgay * (sang + trua + chieu + toi);

                if (thuoc.equals("---Thuốc---")) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Chọn thuốc không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else if (tenThuoc.isEmpty()) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Tên thuốc không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else if (duongDung.isEmpty()) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Đường dùng không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else if (soLuong != tong) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Số lượng = số ngày x (sáng + trưa + chiều + tối)", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else {
                    DonThuocModel dt = new DonThuocModel(maDonThuoc, maBenhAn, maBenhNhan, thuoc.split(" ")[0], tenThuoc, duongDung, cachDung, soNgay, soLuong, sang, trua, chieu, toi, donGia, thanhTien);
                    DonThuocCtrl.themDonThuoc(dt);
                    dsDonThuoc = DonThuocCtrl.timDonThuocTheoMa(maBenhAn);
                    hienThiDSDonThuoc();
                    lamMoi();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChiDinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemThuocActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int selectedIndex = tblDSDonThuoc.getSelectedRow();
        if (selectedIndex >= 0) {
            try {
                boolean flag = DialogHelper.showConfirmation(maBenhAn);
                String[] options = {"Đồng ý", "Thoát"};
                int option = JOptionPane.showOptionDialog(
                        null,
                        "Bạn có chắc muốn đơn xóa thuốc này",
                        "Cảnh báo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        options[1]
                );

                if (option == 0) {
                    DonThuocModel dt = dsDonThuoc.get(selectedIndex);
                    DonThuocCtrl.xoaThuocKhoiDon(dt.getMaDonThuoc());
                    dsDonThuoc = DonThuocCtrl.timDonThuocTheoMa(maBenhAn);
                    hienThiDSDonThuoc();
                    lamMoi();
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ChiDinh.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            DialogHelper.showError(maBenhAn);
            JOptionPane.showMessageDialog(null, "Chưa có dòng nào được chọn", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemThuocMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemThuocMouseMoved
        // TODO add your handling code here:
        int tongDichVu = 0;
        int tongTien = 0;

        for (DonThuocModel dt : dsDonThuoc) {
            tongDichVu += 1;
            tongTien += dt.getThanhTien();
        }

        lblTongSoThuoc.setText(Integer.toString(tongDichVu));
        txtTongTien.setText(Integer.toString(tongTien));
    }//GEN-LAST:event_btnThemThuocMouseMoved

    private void cmbNhomThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNhomThuocActionPerformed
        if (maBenhAn != null) {
            if (maBenhAn.isEmpty() || maBenhAn.startsWith("__")) {
                DialogHelper.showError(maBenhAn);
                JOptionPane.showMessageDialog(null, "Chưa có bệnh án nào được chọn. Vui lòng chọn bệnh án", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else {
                if (cmbThuoc.getSelectedItem() != null && cmbNhomThuoc.getSelectedItem() != null) {
                    if (cmbNhomThuoc.getSelectedItem().toString().equals("---Nhóm thuốc---")) {
                        txtTenThuoc.setText("");
                        txtDonGia.setText("");
                        txtDuongDung.setText("");
                        txtCachDung.setText("");
                        txtDonGia.setText(Integer.toString(0));
                        txtSoLuong.setText(Integer.toString(0));
                        txtSoNgay.setText(Integer.toString(0));
                        txtSang.setText(Integer.toString(0));
                        txtTrua.setText(Integer.toString(0));
                        txtChieu.setText(Integer.toString(0));
                        txtToi.setText(Integer.toString(0));
                    } else {
                        String maNhomThuoc = cmbNhomThuoc.getSelectedItem().toString().split(" ")[0];

                        cmbThuoc.removeAllItems();
                        cmbThuoc.addItem("---Thuốc---");
//                            dsThuoc = ThuocCtrl.timThuocTheoNhomThuoc(maNhomThuoc);
//                            dsThuoc.forEach(t -> {
//                                if (t.getTrangThai().equals("Kích hoạt")) {
//                                    String thuoc = t.getMaThuoc() + " " + t.getTenThuoc();
//                                    ChonThuocComboBox.addItem(thuoc);
//                                }
//                            });
                    }
                }
            }
        }
    }//GEN-LAST:event_cmbNhomThuocActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int selectedIndex = tblDSDonThuoc.getSelectedRow();
        if (selectedIndex >= 0) {
            try {
                if (maBenhAn.isEmpty() || maBenhAn.startsWith("__")) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Chưa có bệnh án nào được chọn. Vui lòng chọn bệnh án", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else if (txtSoLuong.getText().isEmpty()) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Số lượng không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else if (txtSoLuong.getText().equals("0")) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else if (txtDonGia.getText().isEmpty()) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Đơn giá không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else if (txtSoNgay.getText().isEmpty()) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Số ngày không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else if (txtSoNgay.getText().equals("0")) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Số ngày phải lớn hơn không", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else if (!txtSoNgay.getText().isEmpty() && !Validator.isIntegerString(txtSoNgay.getText())) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Số ngày không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else if (!txtSoLuong.getText().isEmpty() && !Validator.isIntegerString(txtSoLuong.getText())) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else if (!txtSang.getText().isEmpty() && !Validator.isIntegerString(txtSang.getText())) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Sáng không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else if (!txtTrua.getText().isEmpty() && !Validator.isIntegerString(txtTrua.getText())) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Trưa không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else if (!txtChieu.getText().isEmpty() && !Validator.isIntegerString(txtChieu.getText())) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Chiều không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else if (!txtToi.getText().isEmpty() && !Validator.isIntegerString(txtToi.getText())) {
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Tối không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else {
                    DonThuocModel dt = dsDonThuoc.get(selectedIndex);

                    String maDonThuoc = dt.getMaDonThuoc();
                    String tenThuoc = txtTenThuoc.getText();
                    String thuoc = cmbThuoc.getSelectedItem().toString();
                    String duongDung = txtDuongDung.getText();
                    String cachDung = txtCachDung.getText();
                    int soLuong = Integer.parseInt(txtSoLuong.getText());
                    int donGia = Integer.parseInt(txtDonGia.getText());
                    int thanhTien = soLuong * donGia;
                    int soNgay = Integer.parseInt(txtSoNgay.getText());
                    int sang = Integer.parseInt(txtSang.getText());
                    int trua = Integer.parseInt(txtTrua.getText());
                    int chieu = Integer.parseInt(txtChieu.getText());
                    int toi = Integer.parseInt(txtToi.getText());
                    int tong = soNgay * (sang + trua + chieu + toi);

                    if (thuoc.equals("---Thuốc---")) {
                        DialogHelper.showError(maBenhAn);
                        JOptionPane.showMessageDialog(null, "Chọn thuốc không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    } else if (tenThuoc.isEmpty()) {
                        DialogHelper.showError(maBenhAn);
                        JOptionPane.showMessageDialog(null, "Tên thuốc không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    } else if (duongDung.isEmpty()) {
                        DialogHelper.showError(maBenhAn);
                        JOptionPane.showMessageDialog(null, "Đường dùng không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    } else if (soLuong != tong) {
                        DialogHelper.showError(maBenhAn);
                        JOptionPane.showMessageDialog(null, "Số lượng = số ngày x (sáng + trưa + chiều + tối)", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    } else {
                        DonThuocModel donThuoc = new DonThuocModel(maDonThuoc, maBenhAn, maBenhNhan, thuoc.split(" ")[0], tenThuoc, duongDung, cachDung, soNgay, soLuong, sang, trua, chieu, toi, donGia, thanhTien);
                        DonThuocCtrl.capNhatDonThuoc(donThuoc);
                        dsDonThuoc = DonThuocCtrl.timDonThuocTheoMa(maBenhAn);
                        hienThiDSDonThuoc();
                        lamMoi();
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ChiDinh.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chưa có dòng nào được chọn", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblDSDonThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSDonThuocMouseClicked
        // TODO add your handling code here:
        int selectedIndex = tblDSDonThuoc.getSelectedRow();
        if (selectedIndex >= 0) {
            DonThuocModel dt = dsDonThuoc.get(selectedIndex);

            cmbNhomThuoc.setSelectedItem(dt.getMaNhomThuoc() + " " + dt.getTenNhomThuoc());
            cmbThuoc.setSelectedItem(dt.getMaThuoc() + " " + dt.getTenThuoc());
            txtTenThuoc.setText(dt.getTenThuoc());
            txtDonGia.setText(Integer.toString(dt.getDonGia()));
            txtDuongDung.setText(dt.getDuongDung());
            txtCachDung.setText(dt.getCachDung());
            txtSoNgay.setText(Integer.toString(dt.getSoNgay()));
            txtSoLuong.setText(Integer.toString(dt.getSoLuong()));
            txtSang.setText(Integer.toString(dt.getSang()));
            txtTrua.setText(Integer.toString(dt.getTrua()));
            txtChieu.setText(Integer.toString(dt.getChieu()));
            txtToi.setText(Integer.toString(dt.getToi()));
        }
    }//GEN-LAST:event_tblDSDonThuocMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoi();
        hienThiDSNhomThuoc();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnKetThucKhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucKhamActionPerformed
        if (maBenhAn.isEmpty() || maBenhAn.startsWith("__")) {
            DialogHelper.showError(maBenhAn);
            JOptionPane.showMessageDialog(null, "Chưa có bệnh án nào được chọn. Vui lòng chọn bệnh án", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                BenhAnModel benhAn = BenhAnCtrl.timBenhAn(maBenhAn);

                try {
                    DangKyModel dk = new DangKyModel(benhAn.getMaDangKy(), "Đã khám");
                    DangKyCtrl.capNhatTrangThai(dk);
                    DialogHelper.showError(maBenhAn);
                    JOptionPane.showMessageDialog(null, "Kết thúc khám bệnh thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ChiDinh.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ChiDinh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnKetThucKhamActionPerformed

    private void txtSoNgayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoNgayFocusLost
        String soNgay = txtSoNgay.getText();
        if (!soNgay.isEmpty() && !Validator.isIntegerString(soNgay)) {
            DialogHelper.showError(maBenhAn);
            JOptionPane.showMessageDialog(null, "Số ngày không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtSoNgay.requestFocus();
        }
    }//GEN-LAST:event_txtSoNgayFocusLost

    private void txtSoLuongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoLuongFocusLost
        String soLuong = txtSoLuong.getText();
        if (!soLuong.isEmpty() && !Validator.isIntegerString(soLuong)) {
            JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtSoLuong.requestFocus();
        }
    }//GEN-LAST:event_txtSoLuongFocusLost

    private void txtSangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSangFocusLost
        String sang = txtSang.getText();
        if (!sang.isEmpty() && !Validator.isIntegerString(sang)) {
            DialogHelper.showError(maBenhAn);
            JOptionPane.showMessageDialog(null, "Sáng không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtSang.requestFocus();
        }
    }//GEN-LAST:event_txtSangFocusLost

    private void txtTruaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTruaFocusLost
        String trua = txtTrua.getText();
        if (!trua.isEmpty() && !Validator.isIntegerString(trua)) {
            DialogHelper.showError(maBenhAn);
            JOptionPane.showMessageDialog(null, "Trưa không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtTrua.requestFocus();
        }
    }//GEN-LAST:event_txtTruaFocusLost

    private void txtChieuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtChieuFocusLost
        String chieu = txtChieu.getText();
        if (!chieu.isEmpty() && !Validator.isIntegerString(chieu)) {
            DialogHelper.showError(maBenhAn);
            JOptionPane.showMessageDialog(null, "Chiều không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtChieu.requestFocus();
        }
    }//GEN-LAST:event_txtChieuFocusLost

    private void txtToiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtToiFocusLost
        String toi = txtToi.getText();
        if (!toi.isEmpty() && !Validator.isIntegerString(toi)) {
            DialogHelper.showError(maBenhAn);
            JOptionPane.showMessageDialog(null, "Tối không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtToi.requestFocus();
        }
    }//GEN-LAST:event_txtToiFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChiDinhPanel;
    private javax.swing.JButton btnInDonThuoc;
    private javax.swing.JButton btnKetThucKham;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThemThuoc;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cmbNhomThuoc;
    private javax.swing.JComboBox<String> cmbThuoc;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblTongSoThuoc;
    private javax.swing.JTable tblDSDonThuoc;
    private javax.swing.JTextField txtCachDung;
    private javax.swing.JTextField txtChieu;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtDuongDung;
    private javax.swing.JTextField txtSang;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoNgay;
    private javax.swing.JTextField txtTenThuoc;
    private javax.swing.JTextField txtToi;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtTrua;
    // End of variables declaration//GEN-END:variables
}