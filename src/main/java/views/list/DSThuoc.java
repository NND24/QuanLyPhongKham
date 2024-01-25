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

            tableModel = (DefaultTableModel) dsThuocTable.getModel();

            hienThiTatThuoc();
            hienThiDSNhomThuoc();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSNhomThuoc() {
        try {
            NhomThuocComboBox.removeAllItems();
            NhomThuocComboBox.addItem("---Nhóm thuốc---");
            tkNhomThuocComboBox.removeAllItems();
            tkNhomThuocComboBox.addItem("---Nhóm thuốc---");

            dsNhomThuoc = NhomThuocCtrl.timTatCaNhomThuoc();
            dsNhomThuoc.forEach(nt -> {
                if (nt.getTrangThai().equals("Kích hoạt")) {
                    String nhomThuoc = nt.getMaNhomThuoc() + " " + nt.getTenNhomThuoc();
                    NhomThuocComboBox.addItem(nhomThuoc);
                    tkNhomThuocComboBox.addItem(nhomThuoc);
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
                thuoc.getNuocSanXuat(), thuoc.getDonGia(), thuoc.getGiaBHYT(), thuoc.getTrangThai()});
        });
    }

    private void lamMoi() {
        MaThuocTextField.setText("");
        TenThuocTextField.setText("");
        NhomThuocComboBox.setSelectedIndex(0);
        TenHoatChatTextField.setText("");
        DuongDungTextField.setText("");
        HamLuongTextField.setText("");
        SoDangKyTextField.setText("");
        DongGoiTextField.setText("");
        DonViTextField.setText("");
        HangSanXuatTextField.setText("");
        NuocSanXuatTextField.setText("");
        DonGiaTextField.setText("");
        GiaBHYTTextField.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LamMoiButton = new javax.swing.JButton();
        SuaThongTinBacSiButton = new javax.swing.JButton();
        XoaBacSiButton = new javax.swing.JButton();
        ThemBacSiButton = new javax.swing.JButton();
        xuatDSButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        MaThuocTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TenThuocTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        NhomThuocComboBox = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        SoDangKyTextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        DuongDungTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        DongGoiTextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        TenHoatChatTextField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        HamLuongTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        HangSanXuatTextField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        timKiemTextField = new javax.swing.JTextField();
        tkNhomThuocComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsThuocTable = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        DonViTextField = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        NuocSanXuatTextField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        DonGiaTextField = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        GiaBHYTTextField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        TrangThaiComboBox = new javax.swing.JComboBox<>();

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

        LamMoiButton.setBackground(new java.awt.Color(0, 102, 255));
        LamMoiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LamMoiButton.setForeground(new java.awt.Color(255, 255, 255));
        LamMoiButton.setText("Làm mới");
        LamMoiButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LamMoiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LamMoiButton.setPreferredSize(new java.awt.Dimension(90, 25));
        LamMoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiButtonActionPerformed(evt);
            }
        });

        SuaThongTinBacSiButton.setBackground(new java.awt.Color(0, 102, 255));
        SuaThongTinBacSiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SuaThongTinBacSiButton.setForeground(new java.awt.Color(255, 255, 255));
        SuaThongTinBacSiButton.setText("Sửa thông tin");
        SuaThongTinBacSiButton.setToolTipText("");
        SuaThongTinBacSiButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SuaThongTinBacSiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SuaThongTinBacSiButton.setPreferredSize(new java.awt.Dimension(110, 25));
        SuaThongTinBacSiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaThongTinBacSiButtonActionPerformed(evt);
            }
        });

        XoaBacSiButton.setBackground(new java.awt.Color(0, 102, 255));
        XoaBacSiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        XoaBacSiButton.setForeground(new java.awt.Color(255, 255, 255));
        XoaBacSiButton.setText("Xóa thuốc");
        XoaBacSiButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        XoaBacSiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XoaBacSiButton.setPreferredSize(new java.awt.Dimension(90, 25));
        XoaBacSiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaBacSiButtonActionPerformed(evt);
            }
        });

        ThemBacSiButton.setBackground(new java.awt.Color(0, 102, 255));
        ThemBacSiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ThemBacSiButton.setForeground(new java.awt.Color(255, 255, 255));
        ThemBacSiButton.setText("Thêm thuốc");
        ThemBacSiButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ThemBacSiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ThemBacSiButton.setPreferredSize(new java.awt.Dimension(90, 25));
        ThemBacSiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemBacSiButtonActionPerformed(evt);
            }
        });

        xuatDSButton.setBackground(new java.awt.Color(0, 102, 255));
        xuatDSButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        xuatDSButton.setForeground(new java.awt.Color(255, 255, 255));
        xuatDSButton.setText("Xuất danh sách");
        xuatDSButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        xuatDSButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        xuatDSButton.setPreferredSize(new java.awt.Dimension(120, 25));
        xuatDSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xuatDSButtonActionPerformed(evt);
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
                .addComponent(ThemBacSiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(XoaBacSiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(SuaThongTinBacSiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(LamMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(xuatDSButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LamMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuaThongTinBacSiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XoaBacSiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThemBacSiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xuatDSButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã thuốc");

        MaThuocTextField.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên thuốc");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Nhóm thuốc");

        NhomThuocComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Nhóm thuốc---" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Số đăng ký");

        SoDangKyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoDangKyTextFieldActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Đường dùng");

        DuongDungTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DuongDungTextFieldActionPerformed(evt);
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

        timKiemTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                timKiemTextFieldKeyTyped(evt);
            }
        });

        tkNhomThuocComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Nhóm thuốc---" }));
        tkNhomThuocComboBox.setPreferredSize(new java.awt.Dimension(72, 25));
        tkNhomThuocComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkNhomThuocComboBoxActionPerformed(evt);
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
                .addComponent(timKiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tkNhomThuocComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timKiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tkNhomThuocComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 200));

        dsThuocTable.setModel(new javax.swing.table.DefaultTableModel(
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
        dsThuocTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dsThuocTable.setPreferredSize(new java.awt.Dimension(500, 330));
        dsThuocTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dsThuocTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dsThuocTable);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Đơn vị tính");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Nước sản xuất");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Giá tiền");

        DonGiaTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DonGiaTextFieldFocusLost(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Giá BHYT");

        GiaBHYTTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                GiaBHYTTextFieldFocusLost(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Trạng thái");

        TrangThaiComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kích hoạt", "Ẩn" }));

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
                                .addComponent(GiaBHYTTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(HangSanXuatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MaThuocTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(41, 41, 41)
                                .addComponent(NhomThuocComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SoDangKyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                        .addComponent(TenThuocTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(DongGoiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(DuongDungTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel30))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TrangThaiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NuocSanXuatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(TenHoatChatTextField))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel27))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DonGiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DonViTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(HamLuongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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
                    .addComponent(MaThuocTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TenHoatChatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(TenThuocTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HamLuongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(NhomThuocComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DuongDungTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SoDangKyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DongGoiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DonViTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HangSanXuatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NuocSanXuatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DonGiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GiaBHYTTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TrangThaiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void dsThuocTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsThuocTableMouseClicked
        int selectedIndex = dsThuocTable.getSelectedRow();
        if (selectedIndex >= 0) {
            ThuocModel thuoc = dsThuoc.get(selectedIndex);

            MaThuocTextField.setText(thuoc.getMaThuoc());
            TenThuocTextField.setText(thuoc.getTenThuoc());
            TenHoatChatTextField.setText(thuoc.getTenHoatChat());
            NhomThuocComboBox.setSelectedItem(thuoc.getMaNhomThuoc() + " " + thuoc.getTenNhomThuoc());
            DuongDungTextField.setText(thuoc.getDuongDung());
            HamLuongTextField.setText(thuoc.getHamLuong());
            SoDangKyTextField.setText(thuoc.getSoDangKy());
            DongGoiTextField.setText(thuoc.getDongGoi());
            DonViTextField.setText(thuoc.getDonViTinh());
            HangSanXuatTextField.setText(thuoc.getHangSanXuat());
            NuocSanXuatTextField.setText(thuoc.getNuocSanXuat());
            DonGiaTextField.setText(Integer.toString(thuoc.getDonGia()));
            GiaBHYTTextField.setText(Integer.toString(thuoc.getGiaBHYT()));
        }
    }//GEN-LAST:event_dsThuocTableMouseClicked

    private void SoDangKyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoDangKyTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SoDangKyTextFieldActionPerformed

    private void DuongDungTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DuongDungTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DuongDungTextFieldActionPerformed

    private void ThemBacSiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemBacSiButtonActionPerformed
        String maThuoc = ThuocCtrl.generateMaThuoc();
        String tenThuoc = TenThuocTextField.getText();
        String tenHoatChat = TenHoatChatTextField.getText();
        String nhomThuoc = NhomThuocComboBox.getSelectedItem().toString();
        String duongDung = DuongDungTextField.getText();
        String hamLuong = HamLuongTextField.getText();
        String soDangKy = SoDangKyTextField.getText();
        String dongGoi = DongGoiTextField.getText();
        String donViTinh = DonViTextField.getText();
        String hangSanXuat = HangSanXuatTextField.getText();
        String nuocSanXuat = NuocSanXuatTextField.getText();
        int donGia = Integer.parseInt(DonGiaTextField.getText());
        int giaBaoHiem = Integer.parseInt(GiaBHYTTextField.getText());
        String trangThai = TrangThaiComboBox.getSelectedItem().toString();

        if (tenThuoc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên thuốc không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (duongDung.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Đường dùng không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (!MaThuocTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Thuốc đã tồn tại", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (nhomThuoc.equals("---Nhóm thuốc---")) {
            JOptionPane.showMessageDialog(null, "Nhóm thuốc không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (DonGiaTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Giá tiền không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (GiaBHYTTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Giá bảo hiểm không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                ThuocModel thuoc = new ThuocModel(maThuoc, tenThuoc, tenHoatChat, nhomThuoc.split(" ")[0], duongDung, hamLuong, soDangKy, dongGoi, donViTinh, hangSanXuat, nuocSanXuat, donGia, giaBaoHiem, trangThai);
                ThuocCtrl.ThemThuoc(thuoc);
                //  JOptionPane.showMessageDialog(null, "Thêm thuốc thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                hienThiTatThuoc();

                MaThuocTextField.setText("");
                TenThuocTextField.setText("");
                TenHoatChatTextField.setText("");
                DuongDungTextField.setText("");
                HamLuongTextField.setText("");
                SoDangKyTextField.setText("");
                DongGoiTextField.setText("");
                DonViTextField.setText("");
                HangSanXuatTextField.setText("");
                NuocSanXuatTextField.setText("");
                DonGiaTextField.setText("");
                GiaBHYTTextField.setText("");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ThemBacSiButtonActionPerformed

    private void XoaBacSiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaBacSiButtonActionPerformed
        try {
            String maThuoc = MaThuocTextField.getText();
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
    }//GEN-LAST:event_XoaBacSiButtonActionPerformed

    private void SuaThongTinBacSiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaThongTinBacSiButtonActionPerformed
        try {
            String maThuoc = MaThuocTextField.getText();
            String tenThuoc = TenThuocTextField.getText();
            String tenHoatChat = TenHoatChatTextField.getText();
            String nhomThuoc = NhomThuocComboBox.getSelectedItem().toString();
            String duongDung = DuongDungTextField.getText();
            String hamLuong = HamLuongTextField.getText();
            String soDangKy = SoDangKyTextField.getText();
            String dongGoi = DongGoiTextField.getText();
            String donViTinh = DonViTextField.getText();
            String hangSanXuat = HangSanXuatTextField.getText();
            String nuocSanXuat = NuocSanXuatTextField.getText();
            int donGia = Integer.parseInt(DonGiaTextField.getText());
            int giaBaoHiem = Integer.parseInt(GiaBHYTTextField.getText());
            String trangThai = TrangThaiComboBox.getSelectedItem().toString();

            if (maThuoc.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mã thuốc không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (duongDung.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Đường dùng không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (tenThuoc.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tên thuốc không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (nhomThuoc.equals("---Nhóm thuốc---")) {
                JOptionPane.showMessageDialog(null, "Nhóm thuốc không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (DonGiaTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Giá tiền không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (GiaBHYTTextField.getText().isEmpty()) {
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
                    ThuocModel dv = new ThuocModel(maThuoc, tenThuoc, tenHoatChat, nhomThuoc.split(" ")[0], duongDung, hamLuong, soDangKy, dongGoi, donViTinh, hangSanXuat, nuocSanXuat, donGia, giaBaoHiem, trangThai);
                    ThuocCtrl.CapNhatThuoc(dv);
                    JOptionPane.showMessageDialog(null, "Sửa thông tin thuốc thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    hienThiTatThuoc();
                    lamMoi();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SuaThongTinBacSiButtonActionPerformed

    private void LamMoiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiButtonActionPerformed
        try {
            // TODO add your handling code here:
            lamMoi();
            hienThiDSNhomThuoc();
            hienThiTatThuoc();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LamMoiButtonActionPerformed

    private void xuatDSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatDSButtonActionPerformed
        try {
            dsThuoc = ThuocCtrl.timTatCaThuoc();
            ThuocCtrl.exportToExcel(dsThuoc, "D:\\Workspace Java\\DoAn\\DSThuoc.xlsx");
            JOptionPane.showMessageDialog(null, "Xuất danh sách thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_xuatDSButtonActionPerformed

    private void timKiemTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timKiemTextFieldKeyTyped
        // TODO add your handling code here:
        try {
            String timKiem = timKiemTextField.getText();
            if (timKiem.equals("")) {
                hienThiTatThuoc();
            } else {
                dsThuoc = ThuocCtrl.timTatCaThuocTheoDK(timKiem);
                tableModel.setRowCount(0);

                dsThuoc.forEach(thuoc -> {
                    tableModel.addRow(new Object[]{thuoc.getMaThuoc(), thuoc.getTenThuoc(),
                        thuoc.getTenHoatChat(), thuoc.getTenNhomThuoc(), thuoc.getDuongDung(), thuoc.getHamLuong(),
                        thuoc.getSoDangKy(), thuoc.getDongGoi(), thuoc.getDonViTinh(), thuoc.getHangSanXuat(),
                        thuoc.getNuocSanXuat(), thuoc.getDonGia(), thuoc.getGiaBHYT(), thuoc.getTrangThai()});
                });
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_timKiemTextFieldKeyTyped

    private void DonGiaTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DonGiaTextFieldFocusLost
        String donGia = DonGiaTextField.getText();
        if (!donGia.isEmpty() && !Validator.isIntegerString(donGia)) {
            JOptionPane.showMessageDialog(null, "Giá tiền không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            DonGiaTextField.requestFocus();
        }
    }//GEN-LAST:event_DonGiaTextFieldFocusLost

    private void GiaBHYTTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GiaBHYTTextFieldFocusLost
        String giaBH = GiaBHYTTextField.getText();
        if (!giaBH.isEmpty() && !Validator.isIntegerString(giaBH)) {
            JOptionPane.showMessageDialog(null, "Giá BHYT không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            GiaBHYTTextField.requestFocus();
        }
    }//GEN-LAST:event_GiaBHYTTextFieldFocusLost

    private void tkNhomThuocComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkNhomThuocComboBoxActionPerformed
        try {
            if (tkNhomThuocComboBox.getSelectedItem() != null) {
                String nhomThuoc = tkNhomThuocComboBox.getSelectedItem().toString();
                if (nhomThuoc.equals("---Nhóm thuốc---")) {
                    hienThiTatThuoc();
                } else {
                    dsThuoc = ThuocCtrl.timThuocTheoNhomThuoc(nhomThuoc.split(" ")[0]);
                    tableModel.setRowCount(0);

                    dsThuoc.forEach(thuoc -> {
                        tableModel.addRow(new Object[]{thuoc.getMaThuoc(), thuoc.getTenThuoc(),
                            thuoc.getTenHoatChat(), thuoc.getTenNhomThuoc(), thuoc.getDuongDung(), thuoc.getHamLuong(),
                            thuoc.getSoDangKy(), thuoc.getDongGoi(), thuoc.getDonViTinh(), thuoc.getHangSanXuat(),
                            thuoc.getNuocSanXuat(), thuoc.getDonGia(), thuoc.getGiaBHYT(), thuoc.getTrangThai()});
                    });
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tkNhomThuocComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DonGiaTextField;
    private javax.swing.JTextField DonViTextField;
    private javax.swing.JTextField DongGoiTextField;
    private javax.swing.JTextField DuongDungTextField;
    private javax.swing.JTextField GiaBHYTTextField;
    private javax.swing.JTextField HamLuongTextField;
    private javax.swing.JTextField HangSanXuatTextField;
    private javax.swing.JButton LamMoiButton;
    private javax.swing.JTextField MaThuocTextField;
    private javax.swing.JComboBox<String> NhomThuocComboBox;
    private javax.swing.JTextField NuocSanXuatTextField;
    private javax.swing.JTextField SoDangKyTextField;
    private javax.swing.JButton SuaThongTinBacSiButton;
    private javax.swing.JTextField TenHoatChatTextField;
    private javax.swing.JTextField TenThuocTextField;
    private javax.swing.JButton ThemBacSiButton;
    private javax.swing.JComboBox<String> TrangThaiComboBox;
    private javax.swing.JButton XoaBacSiButton;
    private javax.swing.JTable dsThuocTable;
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
    private javax.swing.JTextField timKiemTextField;
    private javax.swing.JComboBox<String> tkNhomThuocComboBox;
    private javax.swing.JButton xuatDSButton;
    // End of variables declaration//GEN-END:variables
}
