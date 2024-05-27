package views.list;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import models.ThuocModel;
import models.NhomThuocModel;
import controllers.ThuocCtrl;
import controllers.NhomThuocCtrl;
import utils.DialogHelper;
import utils.GenerateCode;
import utils.Validator;

public class DSThuoc extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    List<ThuocModel> dsThuoc = new ArrayList<>();
    List<NhomThuocModel> dsNhomThuoc = new ArrayList<>();

    public DSThuoc() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) tblDSThuoc.getModel();

            dsThuoc = ThuocCtrl.timTatCaThuoc();

            hienThiDSNhomThuoc();
            hienThiDSThuoc();

            cmbNhomThuoc.setSelectedItem("---Nhóm thuốc---");
            cmbTKNhomThuoc.setSelectedItem("---Nhóm thuốc---");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSNhomThuoc() {
        try {
            cmbNhomThuoc.removeAllItems();
            cmbTKNhomThuoc.removeAllItems();

            dsNhomThuoc = NhomThuocCtrl.timTatCaNhomThuoc();
            dsNhomThuoc.forEach(nt -> {
                if (nt.getTrangThai().equals("Kích hoạt")) {
                    cmbNhomThuoc.addItem(nt.getTenNhomThuoc());
                    cmbTKNhomThuoc.addItem(nt.getTenNhomThuoc());
                }
            });
            cmbNhomThuoc.addItem("---Nhóm thuốc---");
            cmbTKNhomThuoc.addItem("---Nhóm thuốc---");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSThuoc() throws ClassNotFoundException {
        tableModel.setRowCount(0);

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
        cmbNhomThuoc.setSelectedItem("---Nhóm thuốc---");
        txtTenHoaChat.setText("");
        txtDuongDung.setText("");
        txtHamLuong.setText("");
        txtSoDangKy.setText("");
        txtDongGoi.setText("");
        txtDonViTinh.setText("");
        txtHangSanXuat.setText("");
        txtNuocSanXuat.setText("");
        txtGiaTien.setText("");
        txtGiaBHYT.setText("");
    }

    private void timKiemThuoc() {
        try {
            if (cmbTKNhomThuoc.getSelectedItem() != null) {
                if (txtTimKiem.getText().equals("") && cmbTKNhomThuoc.getSelectedItem().toString().equals("---Nhóm thuốc---")) {
                    dsThuoc = ThuocCtrl.timTatCaThuoc();
                    hienThiDSThuoc();
                    return;
                }

                String timKiem = txtTimKiem.getText();
                int nhomThuocId = cmbTKNhomThuoc.getSelectedIndex();
                String maNhomThuoc = dsNhomThuoc.get(nhomThuocId).getMaNhomThuoc();

                dsThuoc = ThuocCtrl.timKiemThuoc(timKiem, maNhomThuoc);
                hienThiDSThuoc();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        txtHamLuong = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtHangSanXuat = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        cmbTKNhomThuoc = new javax.swing.JComboBox<>();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSThuoc = new javax.swing.JTable();

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
        setPreferredSize(new java.awt.Dimension(1360, 585));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 585));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 609, Short.MAX_VALUE)
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

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Đường dùng");

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

        tblDSThuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thuốc", "Tên thuốc", "Tên hoạt chất", "Nhóm thuốc", "Đường dùng", "Hàm lượng", "Số đăng ký", "Đóng gói", "Đơn vị tính", "Hãng sản xuất", "Nước sản xuất", "Giá tiền", "Giá BHYT", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSThuocMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSThuoc);

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
                                    .addComponent(txtHamLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
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
                    .addComponent(txtHamLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1364, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThuocActionPerformed
        try {
            String maThuoc = GenerateCode.generateMa("T");
            if (ThuocCtrl.kiemTraMaThuocTonTai(maThuoc)) {
                DialogHelper.showError("Mã thuốc đã tồn tại");
            } else if (txtTenThuoc.getText().isEmpty()) {
                DialogHelper.showError("Tên thuốc không được để trống!");
            } else if (txtDuongDung.getText().isEmpty()) {
                DialogHelper.showError("Đường dùng không được để trống!");
            } else if (!txtMaThuoc.getText().isEmpty()) {
                DialogHelper.showError("Thuốc đã tồn tại");
            } else if (cmbNhomThuoc.getSelectedItem().equals("---Nhóm thuốc---")) {
                DialogHelper.showError("Nhóm thuốc không được để trống");
            } else if (txtGiaTien.getText().isEmpty()) {
                DialogHelper.showError("Giá tiền không được để trống");
            } else if (txtGiaBHYT.getText().isEmpty()) {
                DialogHelper.showError("Giá bảo hiểm không được để trống");
            } else {
                String tenThuoc = txtTenThuoc.getText();
                String tenHoatChat = txtTenHoaChat.getText();
                String duongDung = txtDuongDung.getText();
                String hamLuong = txtHamLuong.getText();
                String soDangKy = txtSoDangKy.getText();
                String dongGoi = txtDongGoi.getText();
                String donViTinh = txtDonViTinh.getText();
                String hangSanXuat = txtHangSanXuat.getText();
                String nuocSanXuat = txtNuocSanXuat.getText();
                int giaTien = Integer.parseInt(txtGiaTien.getText());
                int giaBaoHiem = Integer.parseInt(txtGiaBHYT.getText());
                String trangThai = cmbTrangThai.getSelectedItem().toString();

                int nhomThuocIndex = cmbNhomThuoc.getSelectedIndex();
                String maNhomThuoc = dsNhomThuoc.get(nhomThuocIndex).getMaNhomThuoc();
                ThuocModel thuoc = new ThuocModel(maThuoc, tenThuoc, tenHoatChat, maNhomThuoc, duongDung, hamLuong, soDangKy, dongGoi, donViTinh, hangSanXuat, nuocSanXuat, giaTien, giaBaoHiem, trangThai);
                ThuocCtrl.themThuoc(thuoc);
                timKiemThuoc();
                lamMoi();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemThuocActionPerformed

    private void btnXoaThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaThuocActionPerformed
        try {
            String maThuoc = txtMaThuoc.getText();
            if (maThuoc.isEmpty()) {
                DialogHelper.showError("Chưa có thuốc được chọn");
            } else if (ThuocCtrl.kiemTraThuocDaDuocSuDung(maThuoc)) {
                DialogHelper.showError("Thuốc đã được sử dụng, không thể xóa");
            } else {
                if (DialogHelper.showConfirmation("Bạn có chắc muốn xóa thuốc này")) {
                    ThuocCtrl.xoaThuoc(maThuoc);
                    DialogHelper.showError("Xóa thuốc thành công!");
                    lamMoi();
                    timKiemThuoc();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaThuocActionPerformed

    private void btnSuaThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThongTinActionPerformed
        try {
            if (txtMaThuoc.getText().isEmpty()) {
                DialogHelper.showError("Mã thuốc không được để trống!");
            } else if (txtTenThuoc.getText().isEmpty()) {
                DialogHelper.showError("Tên thuốc không được để trống!");
            } else if (txtDuongDung.getText().isEmpty()) {
                DialogHelper.showError("Đường dùng không được để trống!");
            } else if (cmbNhomThuoc.getSelectedItem().equals("---Nhóm thuốc---")) {
                DialogHelper.showError("Nhóm thuốc không được để trống");
            } else if (txtGiaTien.getText().isEmpty()) {
                DialogHelper.showError("Giá tiền không được để trống");
            } else if (txtGiaBHYT.getText().isEmpty()) {
                DialogHelper.showError("Giá bảo hiểm không được để trống");
            } else {
                if (DialogHelper.showConfirmation("Bạn có chắc sửa thông tin thuốc này")) {
                    String maThuoc = txtMaThuoc.getText();
                    String tenThuoc = txtTenThuoc.getText();
                    String tenHoatChat = txtTenHoaChat.getText();
                    String duongDung = txtDuongDung.getText();
                    String hamLuong = txtHamLuong.getText();
                    String soDangKy = txtSoDangKy.getText();
                    String dongGoi = txtDongGoi.getText();
                    String donViTinh = txtDonViTinh.getText();
                    String hangSanXuat = txtHangSanXuat.getText();
                    String nuocSanXuat = txtNuocSanXuat.getText();
                    int giaTien = Integer.parseInt(txtGiaTien.getText());
                    int giaBaoHiem = Integer.parseInt(txtGiaBHYT.getText());
                    String trangThai = cmbTrangThai.getSelectedItem().toString();
                    int nhomThuocIndex = cmbNhomThuoc.getSelectedIndex();
                    String maNhomThuoc = dsNhomThuoc.get(nhomThuocIndex).getMaNhomThuoc();

                    ThuocModel dv = new ThuocModel(maThuoc, tenThuoc, tenHoatChat, maNhomThuoc, duongDung, hamLuong, soDangKy, dongGoi, donViTinh, hangSanXuat, nuocSanXuat, giaTien, giaBaoHiem, trangThai);
                    ThuocCtrl.capNhatThuoc(dv);
                    DialogHelper.showMessage("Sửa thông tin thuốc thành công!");
                    timKiemThuoc();
                    lamMoi();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaThongTinActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoi();
        txtTimKiem.setText("");
        cmbTKNhomThuoc.setSelectedItem("---Nhóm thuốc---");
        timKiemThuoc();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnXuatDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDSActionPerformed
        try {
            dsThuoc = ThuocCtrl.timTatCaThuoc();
            ThuocCtrl.exportToExcel(dsThuoc, "src/main/java/ExcelStorage/DSThuoc.xlsx");
            DialogHelper.showMessage("Xuất danh sách thành công!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXuatDSActionPerformed

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        timKiemThuoc();
    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void txtGiaTienFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaTienFocusLost
        String giaTien = txtGiaTien.getText();
        if (!giaTien.isEmpty() && !Validator.isIntegerString(giaTien)) {
            DialogHelper.showError("Giá tiền không hợp lệ");
            txtGiaTien.requestFocus();
        }
    }//GEN-LAST:event_txtGiaTienFocusLost

    private void txtGiaBHYTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaBHYTFocusLost
        String giaBH = txtGiaBHYT.getText();
        if (!giaBH.isEmpty() && !Validator.isIntegerString(giaBH)) {
            DialogHelper.showError("Giá BHYT không hợp lệ");
            txtGiaBHYT.requestFocus();
        }
    }//GEN-LAST:event_txtGiaBHYTFocusLost

    private void cmbTKNhomThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKNhomThuocActionPerformed
        timKiemThuoc();
    }//GEN-LAST:event_cmbTKNhomThuocActionPerformed

    private void tblDSThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSThuocMouseClicked
        int selectedIndex = tblDSThuoc.getSelectedRow();
        if (selectedIndex >= 0) {
            ThuocModel thuoc = dsThuoc.get(selectedIndex);

            txtMaThuoc.setText(thuoc.getMaThuoc());
            txtTenThuoc.setText(thuoc.getTenThuoc());
            txtTenHoaChat.setText(thuoc.getTenHoatChat());
            cmbNhomThuoc.setSelectedItem(thuoc.getTenNhomThuoc());
            txtDuongDung.setText(thuoc.getDuongDung());
            txtHamLuong.setText(thuoc.getHamLuong());
            txtSoDangKy.setText(thuoc.getSoDangKy());
            txtDongGoi.setText(thuoc.getDongGoi());
            txtDonViTinh.setText(thuoc.getDonViTinh());
            txtHangSanXuat.setText(thuoc.getHangSanXuat());
            txtNuocSanXuat.setText(thuoc.getNuocSanXuat());
            txtGiaTien.setText(Integer.toString(thuoc.getGiaTien()));
            txtGiaBHYT.setText(Integer.toString(thuoc.getGiaBHYT()));
        }
    }//GEN-LAST:event_tblDSThuocMouseClicked

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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDSThuoc;
    private javax.swing.JTextField txtDonViTinh;
    private javax.swing.JTextField txtDongGoi;
    private javax.swing.JTextField txtDuongDung;
    private javax.swing.JTextField txtGiaBHYT;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtHamLuong;
    private javax.swing.JTextField txtHangSanXuat;
    private javax.swing.JTextField txtMaThuoc;
    private javax.swing.JTextField txtNuocSanXuat;
    private javax.swing.JTextField txtSoDangKy;
    private javax.swing.JTextField txtTenHoaChat;
    private javax.swing.JTextField txtTenThuoc;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
