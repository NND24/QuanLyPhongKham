package views.list;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import models.ThuocModel;
import controllers.ThuocCtrl;
import models.NhomThuocModel;
import controllers.NhomThuocCtrl;
import utils.Validator;

public class DSThuoc extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    List<ThuocModel> dsThuoc = new ArrayList<>();
    List<NhomThuocModel> dsNhomThuoc = new ArrayList<>();

    public DSThuoc() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) tblDSThuoc.getModel();

            hienThiTatThuoc();
            hienThiDSNhomThuoc();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSNhomThuoc() {
        try {
            cmbNhomThuoc.removeAllItems();
            cmbNhomThuoc.addItem("---Nhóm thuốc---");
            cmbTKNhomThuoc.removeAllItems();
            cmbTKNhomThuoc.addItem("---Nhóm thuốc---");

            dsNhomThuoc = NhomThuocCtrl.timTatCaNhomThuoc();
            dsNhomThuoc.forEach(nt -> {
                if (nt.getTrangThai().equals("Kích hoạt")) {
                    String nhomThuoc = nt.getMaNhomThuoc() + " " + nt.getTenNhomThuoc();
                    cmbNhomThuoc.addItem(nhomThuoc);
                    cmbTKNhomThuoc.addItem(nhomThuoc);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiTatThuoc() throws ClassNotFoundException {
        tableModel.setRowCount(0);

        dsThuoc = ThuocCtrl.timTatCaThuoc();
        dsThuoc.forEach(thuoc -> {
            tableModel.addRow(new Object[]{thuoc.getMaThuoc(), thuoc.getTenThuoc(),
                thuoc.getTenHoatChat(), thuoc.getTenNhomThuoc(), thuoc.getDuongDung(), thuoc.getHamLuong(),
                thuoc.getSoDangKy(), thuoc.getDongGoi(), thuoc.getDonViTinh(), thuoc.getHangSanXuat(),
                thuoc.getNuocSanXuat(), thuoc.getGiaTien(), thuoc.getGiaBHYT(), thuoc.getTrangThai()});
        });
    }

    private void lamMoi() {
        txtMaThuoc.setText("");
        txtTenThuoc.setText("");
        cmbNhomThuoc.setSelectedIndex(0);
        txtTenHoaChat.setText("");
        txtDuongDung.setText("");
        txthamLuong.setText("");
        txtSoDangKy.setText("");
        txtDongGoi.setText("");
        txtDonViTinh.setText("");
        txtHangSanXuat.setText("");
        txtNuocSanXuat.setText("");
        txtGiaTien.setText("");
        txtGiaBHYT.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        btnSuaThongTin = new javax.swing.JButton();
        btnXoaThuoc = new javax.swing.JButton();
        btnThemThuoc = new javax.swing.JButton();
        btnXuatDS = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMaThuoc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenThuoc = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cmbNhomThuoc = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        txtSoDangKy = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtDuongDung = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtDongGoi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTenHoaChat = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txthamLuong = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtHangSanXuat = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        cmbTKNhomThuoc = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSThuoc = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        txtDonViTinh = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtNuocSanXuat = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtGiaTien = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtGiaBHYT = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        cmbTrangThai = new javax.swing.JComboBox<>();

        jFrame1.setBackground(new java.awt.Color(51, 255, 51));

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel4.setPreferredSize(new java.awt.Dimension(1360, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("THÔNG TIN THUỐC");

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(90, 25));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnSuaThongTin.setBackground(new java.awt.Color(0, 102, 255));
        btnSuaThongTin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaThongTin.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaThongTin.setText("Sửa thông tin");
        btnSuaThongTin.setToolTipText("");
        btnSuaThongTin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSuaThongTin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaThongTin.setPreferredSize(new java.awt.Dimension(110, 25));
        btnSuaThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThongTinActionPerformed(evt);
            }
        });

        btnXoaThuoc.setBackground(new java.awt.Color(0, 102, 255));
        btnXoaThuoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaThuoc.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaThuoc.setText("Xóa thuốc");
        btnXoaThuoc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoaThuoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaThuoc.setPreferredSize(new java.awt.Dimension(90, 25));
        btnXoaThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaThuocActionPerformed(evt);
            }
        });

        btnThemThuoc.setBackground(new java.awt.Color(0, 102, 255));
        btnThemThuoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemThuoc.setForeground(new java.awt.Color(255, 255, 255));
        btnThemThuoc.setText("Thêm thuốc");
        btnThemThuoc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThemThuoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemThuoc.setPreferredSize(new java.awt.Dimension(90, 25));
        btnThemThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThuocActionPerformed(evt);
            }
        });

        btnXuatDS.setBackground(new java.awt.Color(0, 102, 255));
        btnXuatDS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatDS.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatDS.setText("Xuất danh sách");
        btnXuatDS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXuatDS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatDS.setPreferredSize(new java.awt.Dimension(120, 25));
        btnXuatDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 608, Short.MAX_VALUE)
                .addComponent(btnThemThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXoaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnSuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXuatDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã thuốc");

        txtMaThuoc.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên thuốc");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Nhóm thuốc");

        cmbNhomThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Nhóm thuốc---" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Số đăng ký");

        txtSoDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDangKyActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Đường dùng");

        txtDuongDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuongDungActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Đóng gói");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Tên hoạt chất");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Hàm lượng");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Hãng sản xuất");

        jPanel8.setPreferredSize(new java.awt.Dimension(1360, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("DANH SÁCH THUỐC");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Tìm kiếm");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        cmbTKNhomThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Nhóm thuốc---" }));
        cmbTKNhomThuoc.setPreferredSize(new java.awt.Dimension(72, 25));
        cmbTKNhomThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKNhomThuocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(5, 5, 5)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbTKNhomThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTKNhomThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 200));

        tblDSThuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã thuốc", "Tên thuốc", "Tên hoạt chất", "Nhóm thuốc", "Đường dùng", "Hàm lượng", "Số đăng ký", "Đóng gói", "Đơn vị tính", "Hãng sản xuất", "Nước sản xuất", "Giá tiền", "Giá BHYT", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSThuoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDSThuoc.setPreferredSize(new java.awt.Dimension(500, 330));
        tblDSThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSThuocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSThuoc);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Đơn vị tính");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Nước sản xuất");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Giá tiền");

        txtGiaTien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGiaTienFocusLost(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Giá BHYT");

        txtGiaBHYT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGiaBHYTFocusLost(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Trạng thái");

        cmbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kích hoạt", "Ẩn" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGiaBHYT, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtHangSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(41, 41, 41)
                                .addComponent(cmbNhomThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSoDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel4))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(txtTenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtDongGoi, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtDuongDung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel30))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNuocSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenHoaChat))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel27))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txthamLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenHoaChat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthamLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(cmbNhomThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDuongDung, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDongGoi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHangSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNuocSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGiaBHYT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSThuocMouseClicked
        int selectedIndex = tblDSThuoc.getSelectedRow();
        if (selectedIndex >= 0) {
            ThuocModel thuoc = dsThuoc.get(selectedIndex);

            txtMaThuoc.setText(thuoc.getMaThuoc());
            txtTenThuoc.setText(thuoc.getTenThuoc());
            txtTenHoaChat.setText(thuoc.getTenHoatChat());
            cmbNhomThuoc.setSelectedItem(thuoc.getMaNhomThuoc() + " " + thuoc.getTenNhomThuoc());
            txtDuongDung.setText(thuoc.getDuongDung());
            txthamLuong.setText(thuoc.getHamLuong());
            txtSoDangKy.setText(thuoc.getSoDangKy());
            txtDongGoi.setText(thuoc.getDongGoi());
            txtDonViTinh.setText(thuoc.getDonViTinh());
            txtHangSanXuat.setText(thuoc.getHangSanXuat());
            txtNuocSanXuat.setText(thuoc.getNuocSanXuat());
            txtGiaTien.setText(Integer.toString(thuoc.getGiaTien()));
            txtGiaBHYT.setText(Integer.toString(thuoc.getGiaBHYT()));
        }
    }//GEN-LAST:event_tblDSThuocMouseClicked

    private void txtSoDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDangKyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDangKyActionPerformed

    private void txtDuongDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuongDungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuongDungActionPerformed

    private void btnThemThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThuocActionPerformed
        String maThuoc = ThuocCtrl.generateMaThuoc();
        String tenThuoc = txtTenThuoc.getText();
        String tenHoatChat = txtTenHoaChat.getText();
        String nhomThuoc = cmbNhomThuoc.getSelectedItem().toString();
        String duongDung = txtDuongDung.getText();
        String hamLuong = txthamLuong.getText();
        String soDangKy = txtSoDangKy.getText();
        String dongGoi = txtDongGoi.getText();
        String donViTinh = txtDonViTinh.getText();
        String hangSanXuat = txtHangSanXuat.getText();
        String nuocSanXuat = txtNuocSanXuat.getText();
        int giaTien = Integer.parseInt(txtGiaTien.getText());
        int giaBaoHiem = Integer.parseInt(txtGiaBHYT.getText());
        String trangThai = cmbTrangThai.getSelectedItem().toString();

        if (tenThuoc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên thuốc không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (duongDung.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Đường dùng không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (!txtMaThuoc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Thuốc đã tồn tại", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (nhomThuoc.equals("---Nhóm thuốc---")) {
            JOptionPane.showMessageDialog(null, "Nhóm thuốc không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (txtGiaTien.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Giá tiền không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (txtGiaBHYT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Giá bảo hiểm không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                ThuocModel thuoc = new ThuocModel(maThuoc, tenThuoc, tenHoatChat, nhomThuoc.split(" ")[0], duongDung, hamLuong, soDangKy, dongGoi, donViTinh, hangSanXuat, nuocSanXuat, giaTien, giaBaoHiem, trangThai);
                ThuocCtrl.ThemThuoc(thuoc);
                //  JOptionPane.showMessageDialog(null, "Thêm thuốc thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                hienThiTatThuoc();

                txtMaThuoc.setText("");
                txtTenThuoc.setText("");
                txtTenHoaChat.setText("");
                txtDuongDung.setText("");
                txthamLuong.setText("");
                txtSoDangKy.setText("");
                txtDongGoi.setText("");
                txtDonViTinh.setText("");
                txtHangSanXuat.setText("");
                txtNuocSanXuat.setText("");
                txtGiaTien.setText("");
                txtGiaBHYT.setText("");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnThemThuocActionPerformed

    private void btnXoaThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaThuocActionPerformed
        try {
            String maThuoc = txtMaThuoc.getText();
            if (maThuoc.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Chưa có thuốc được chọn", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                String[] options = {"Đồng ý", "Thoát"};
                int option = JOptionPane.showOptionDialog(
                        null,
                        "Bạn có chắc muốn xóa thuốc này",
                        "Cảnh báo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]
                );

                if (option == 0) {
                    ThuocCtrl.XoaThuoc(maThuoc);
                    JOptionPane.showMessageDialog(null, "Xóa thuốc thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    lamMoi();
                    hienThiTatThuoc();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaThuocActionPerformed

    private void btnSuaThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThongTinActionPerformed
        try {
            String maThuoc = txtMaThuoc.getText();
            String tenThuoc = txtTenThuoc.getText();
            String tenHoatChat = txtTenHoaChat.getText();
            String nhomThuoc = cmbNhomThuoc.getSelectedItem().toString();
            String duongDung = txtDuongDung.getText();
            String hamLuong = txthamLuong.getText();
            String soDangKy = txtSoDangKy.getText();
            String dongGoi = txtDongGoi.getText();
            String donViTinh = txtDonViTinh.getText();
            String hangSanXuat = txtHangSanXuat.getText();
            String nuocSanXuat = txtNuocSanXuat.getText();
            int giaTien = Integer.parseInt(txtGiaTien.getText());
            int giaBaoHiem = Integer.parseInt(txtGiaBHYT.getText());
            String trangThai = cmbTrangThai.getSelectedItem().toString();

            if (maThuoc.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mã thuốc không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (duongDung.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Đường dùng không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (tenThuoc.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tên thuốc không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (nhomThuoc.equals("---Nhóm thuốc---")) {
                JOptionPane.showMessageDialog(null, "Nhóm thuốc không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (txtGiaTien.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Giá tiền không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (txtGiaBHYT.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Giá bảo hiểm không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                String[] options = {"Đồng ý", "Thoát"};
                int option = JOptionPane.showOptionDialog(
                        null,
                        "Bạn có chắc sửa thông tin thuốc này",
                        "Cảnh báo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]
                );
                if (option == 0) {
                    ThuocModel dv = new ThuocModel(maThuoc, tenThuoc, tenHoatChat, nhomThuoc.split(" ")[0], duongDung, hamLuong, soDangKy, dongGoi, donViTinh, hangSanXuat, nuocSanXuat, giaTien, giaBaoHiem, trangThai);
                    ThuocCtrl.CapNhatThuoc(dv);
                    JOptionPane.showMessageDialog(null, "Sửa thông tin thuốc thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    hienThiTatThuoc();
                    lamMoi();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaThongTinActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        try {
            // TODO add your handling code here:
            lamMoi();
            hienThiDSNhomThuoc();
            hienThiTatThuoc();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnXuatDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDSActionPerformed
        try {
            dsThuoc = ThuocCtrl.timTatCaThuoc();
            ThuocCtrl.exportToExcel(dsThuoc, "D:\\Workspace Java\\DoAn\\DSThuoc.xlsx");
            JOptionPane.showMessageDialog(null, "Xuất danh sách thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXuatDSActionPerformed

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        // TODO add your handling code here:
        try {
            String timKiem = txtTimKiem.getText();
            if (timKiem.equals("")) {
                hienThiTatThuoc();
            } else {
                dsThuoc = ThuocCtrl.timTatCaThuocTheoDK(timKiem);
                tableModel.setRowCount(0);

                dsThuoc.forEach(thuoc -> {
                    tableModel.addRow(new Object[]{thuoc.getMaThuoc(), thuoc.getTenThuoc(),
                        thuoc.getTenHoatChat(), thuoc.getTenNhomThuoc(), thuoc.getDuongDung(), thuoc.getHamLuong(),
                        thuoc.getSoDangKy(), thuoc.getDongGoi(), thuoc.getDonViTinh(), thuoc.getHangSanXuat(),
                        thuoc.getNuocSanXuat(), thuoc.getGiaTien(), thuoc.getGiaBHYT(), thuoc.getTrangThai()});
                });
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void txtGiaTienFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaTienFocusLost
        String giaTien = txtGiaTien.getText();
        if (!giaTien.isEmpty() && !Validator.isIntegerString(giaTien)) {
            JOptionPane.showMessageDialog(null, "Giá tiền không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtGiaTien.requestFocus();
        }
    }//GEN-LAST:event_txtGiaTienFocusLost

    private void txtGiaBHYTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaBHYTFocusLost
        String giaBH = txtGiaBHYT.getText();
        if (!giaBH.isEmpty() && !Validator.isIntegerString(giaBH)) {
            JOptionPane.showMessageDialog(null, "Giá BHYT không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtGiaBHYT.requestFocus();
        }
    }//GEN-LAST:event_txtGiaBHYTFocusLost

    private void cmbTKNhomThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKNhomThuocActionPerformed
        try {
            if (cmbTKNhomThuoc.getSelectedItem() != null) {
                String nhomThuoc = cmbTKNhomThuoc.getSelectedItem().toString();
                if (nhomThuoc.equals("---Nhóm thuốc---")) {
                    hienThiTatThuoc();
                } else {
                    dsThuoc = ThuocCtrl.timThuocTheoNhomThuoc(nhomThuoc.split(" ")[0]);
                    tableModel.setRowCount(0);

                    dsThuoc.forEach(thuoc -> {
                        tableModel.addRow(new Object[]{thuoc.getMaThuoc(), thuoc.getTenThuoc(),
                            thuoc.getTenHoatChat(), thuoc.getTenNhomThuoc(), thuoc.getDuongDung(), thuoc.getHamLuong(),
                            thuoc.getSoDangKy(), thuoc.getDongGoi(), thuoc.getDonViTinh(), thuoc.getHangSanXuat(),
                            thuoc.getNuocSanXuat(), thuoc.getGiaTien(), thuoc.getGiaBHYT(), thuoc.getTrangThai()});
                    });
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbTKNhomThuocActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSuaThongTin;
    private javax.swing.JButton btnThemThuoc;
    private javax.swing.JButton btnXoaThuoc;
    private javax.swing.JButton btnXuatDS;
    private javax.swing.JComboBox<String> cmbNhomThuoc;
    private javax.swing.JComboBox<String> cmbTKNhomThuoc;
    private javax.swing.JComboBox<String> cmbTrangThai;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDSThuoc;
    private javax.swing.JTextField txtDonViTinh;
    private javax.swing.JTextField txtDongGoi;
    private javax.swing.JTextField txtDuongDung;
    private javax.swing.JTextField txtGiaBHYT;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtHangSanXuat;
    private javax.swing.JTextField txtMaThuoc;
    private javax.swing.JTextField txtNuocSanXuat;
    private javax.swing.JTextField txtSoDangKy;
    private javax.swing.JTextField txtTenHoaChat;
    private javax.swing.JTextField txtTenThuoc;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txthamLuong;
    // End of variables declaration//GEN-END:variables
}
