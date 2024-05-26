package views.list;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.BenhNhanModel;
import controllers.BenhNhanCtrl;
import utils.DialogHelper;
import utils.GenerateCode;
import utils.Validator;

public class DSBenhNhan extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    List<BenhNhanModel> dsBenhNhan = new ArrayList<>();

    public DSBenhNhan() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) dsBenhNhanTable.getModel();
            hienThiTatCaBenhNhan();
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(DSBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiTatCaBenhNhan() throws ClassNotFoundException {
        dsBenhNhan = BenhNhanCtrl.timTatCaBenhNhan();
        tableModel.setRowCount(0);

        dsBenhNhan.forEach(bn -> {
            tableModel.addRow(new Object[]{bn.getMaBenhNhan(), bn.getHoTen(),
                bn.getGioiTinh(), bn.getNamSinh(), bn.getDiaChi(),
                bn.getCanCuoc(), bn.getBhyt(), bn.getSoDienThoai(),
                bn.getNgheNghiep(), bn.getDanToc(), bn.getQuocTich()});
        });
    }

    private void lamMoiTTBenhNhan() {
        try {
            txtMaBenhNhan.setText("");
            txtHoTen.setText("");
            txtDiaChi.setText("");
            cmbGioiTinh.setSelectedIndex(0);
            txtNamSinh.setText("");
            txtCanCuoc.setText("");
            txtNgheNghiep.setText("");
            txtSoDienThoai.setText("");
            txtDanToc.setText("");
            txtBHYT.setText("");
            hienThiTatCaBenhNhan();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnNhapMoiBenhNhan = new javax.swing.JButton();
        btnXoaBenhNhan = new javax.swing.JButton();
        btnXuatDSBenhNhan = new javax.swing.JButton();
        btnLuuBenhNhan = new javax.swing.JButton();
        btnSuaBenhnhan = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMaBenhNhan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbGioiTinh = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNgheNghiep = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtQuocTich = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cmbLoc = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNamSinh = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtCanCuoc = new javax.swing.JTextField();
        txtDanToc = new javax.swing.JTextField();
        txtBHYT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsBenhNhanTable = new javax.swing.JTable();

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

        jPanel6.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("THÔNG TIN BỆNH NHÂN");

        btnNhapMoiBenhNhan.setBackground(new java.awt.Color(0, 102, 255));
        btnNhapMoiBenhNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhapMoiBenhNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapMoiBenhNhan.setText("Làm mới");
        btnNhapMoiBenhNhan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNhapMoiBenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapMoiBenhNhan.setPreferredSize(new java.awt.Dimension(72, 25));
        btnNhapMoiBenhNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapMoiBenhNhanActionPerformed(evt);
            }
        });

        btnXoaBenhNhan.setBackground(new java.awt.Color(0, 102, 255));
        btnXoaBenhNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaBenhNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaBenhNhan.setText("Xóa bệnh nhân");
        btnXoaBenhNhan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoaBenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaBenhNhan.setPreferredSize(new java.awt.Dimension(32, 25));
        btnXoaBenhNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaBenhNhanActionPerformed(evt);
            }
        });

        btnXuatDSBenhNhan.setBackground(new java.awt.Color(0, 102, 255));
        btnXuatDSBenhNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatDSBenhNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatDSBenhNhan.setText("Xuất danh sách");
        btnXuatDSBenhNhan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXuatDSBenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatDSBenhNhan.setPreferredSize(new java.awt.Dimension(120, 25));
        btnXuatDSBenhNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDSBenhNhanActionPerformed(evt);
            }
        });

        btnLuuBenhNhan.setBackground(new java.awt.Color(0, 102, 255));
        btnLuuBenhNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuuBenhNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnLuuBenhNhan.setText("Lưu bệnh nhân");
        btnLuuBenhNhan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLuuBenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLuuBenhNhan.setPreferredSize(new java.awt.Dimension(70, 25));
        btnLuuBenhNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuBenhNhanActionPerformed(evt);
            }
        });

        btnSuaBenhnhan.setBackground(new java.awt.Color(0, 102, 255));
        btnSuaBenhnhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaBenhnhan.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaBenhnhan.setText("Sửa thông tin");
        btnSuaBenhnhan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSuaBenhnhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaBenhnhan.setPreferredSize(new java.awt.Dimension(70, 25));
        btnSuaBenhnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaBenhnhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 560, Short.MAX_VALUE)
                .addComponent(btnLuuBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXoaBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnSuaBenhnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnNhapMoiBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXuatDSBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnNhapMoiBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatDSBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaBenhnhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã bệnh nhân");

        txtMaBenhNhan.setEditable(false);
        txtMaBenhNhan.setMinimumSize(new java.awt.Dimension(64, 30));
        txtMaBenhNhan.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Giới tính");

        cmbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        cmbGioiTinh.setPreferredSize(new java.awt.Dimension(109, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Họ tên");

        txtHoTen.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nghề nghiệp");

        txtNgheNghiep.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Năm sinh");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Dân tộc");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Số điện thoại");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Căn cước");

        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("(*)");

        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("(*)");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Địa chỉ");

        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("(*)");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("BHYT");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Quốc tịch");

        txtQuocTich.setPreferredSize(new java.awt.Dimension(64, 30));

        txtDiaChi.setPreferredSize(new java.awt.Dimension(64, 30));

        jPanel5.setPreferredSize(new java.awt.Dimension(199, 35));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("DANH SÁCH BỆNH NHÂN");

        cmbLoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Nam", "Nữ" }));
        cmbLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLocActionPerformed(evt);
            }
        });

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tìm kiếm");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Lọc");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 733, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(5, 5, 5)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel15)
                .addGap(5, 5, 5)
                .addComponent(cmbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel15))
                .addGap(11, 11, 11))
        );

        txtNamSinh.setPreferredSize(new java.awt.Dimension(64, 30));

        txtSoDienThoai.setMinimumSize(new java.awt.Dimension(64, 30));
        txtSoDienThoai.setPreferredSize(new java.awt.Dimension(64, 30));
        txtSoDienThoai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiFocusLost(evt);
            }
        });

        txtCanCuoc.setPreferredSize(new java.awt.Dimension(64, 30));
        txtCanCuoc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCanCuocFocusLost(evt);
            }
        });

        txtDanToc.setPreferredSize(new java.awt.Dimension(64, 30));
        txtDanToc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDanTocFocusLost(evt);
            }
        });

        txtBHYT.setMinimumSize(new java.awt.Dimension(64, 30));
        txtBHYT.setPreferredSize(new java.awt.Dimension(64, 30));
        txtBHYT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBHYTFocusLost(evt);
            }
        });

        dsBenhNhanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã bệnh nhân", "Họ tên", "Giới tính", "Năm sinh", "Địa chỉ", "Căn cước", "Bảo hiểm", "Số điện thoại", "Nghề nghiệp", "Dân tộc", "Quốc tịch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dsBenhNhanTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dsBenhNhanTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dsBenhNhanTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dsBenhNhanTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBHYT, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17))
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgheNghiep, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel9)))
                            .addComponent(txtQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDanToc, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCanCuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel17)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addComponent(jLabel22)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCanCuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(txtNgheNghiep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(txtBHYT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDanToc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel23)
                    .addComponent(jLabel8)
                    .addComponent(txtQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhapMoiBenhNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapMoiBenhNhanActionPerformed
        lamMoiTTBenhNhan();
    }//GEN-LAST:event_btnNhapMoiBenhNhanActionPerformed

    private void cmbLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLocActionPerformed
        try {
            String timKiem = txtTimKiem.getText();
            String gioiTinh = cmbLoc.getSelectedItem().toString();

            if (gioiTinh.equals("Tất cả")) {
                hienThiTatCaBenhNhan();
            } else {
                dsBenhNhan = BenhNhanCtrl.timBenhNhanTheoDK(timKiem, gioiTinh);

                tableModel.setRowCount(0);

                dsBenhNhan.forEach(bn -> {
                    tableModel.addRow(new Object[]{bn.getMaBenhNhan(), bn.getHoTen(),
                        bn.getGioiTinh(), bn.getNamSinh(), bn.getDiaChi(),
                        bn.getCanCuoc(), bn.getBhyt(), bn.getSoDienThoai(),
                        bn.getNgheNghiep(), bn.getDanToc(), bn.getQuocTich()});
                });
            }
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(DSBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbLocActionPerformed

    private void btnXoaBenhNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaBenhNhanActionPerformed
        try {
            String maBenhNhan = txtMaBenhNhan.getText();
            if (maBenhNhan.isEmpty()) {
                DialogHelper.showError("Chưa có bệnh nhân được chọn");
            } else if (BenhNhanCtrl.kiemTraBenhNhanDaKhamBenh(maBenhNhan)) {
                DialogHelper.showError("Bệnh nhân đã khám bệnh, không thể xóa");
            } else {
                if (DialogHelper.showConfirmation("Bạn có chắc muốn xóa bệnh nhân này")) {
                    BenhNhanCtrl.xoaBenhNhan(maBenhNhan);
                    DialogHelper.showMessage("Xóa bệnh nhân thành công!");
                    lamMoiTTBenhNhan();
                    hienThiTatCaBenhNhan();
                }
            }
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(DSBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaBenhNhanActionPerformed

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        try {
            String timKiem = txtTimKiem.getText();
            String gioiTinh = cmbLoc.getSelectedItem().toString();

            if (timKiem.equals("")) {
                hienThiTatCaBenhNhan();
            } else {
                dsBenhNhan = BenhNhanCtrl.timBenhNhanTheoDK(timKiem, gioiTinh);

                tableModel.setRowCount(0);

                dsBenhNhan.forEach(bn -> {
                    tableModel.addRow(new Object[]{bn.getMaBenhNhan(), bn.getHoTen(),
                        bn.getGioiTinh(), bn.getNamSinh(), bn.getDiaChi(),
                        bn.getCanCuoc(), bn.getBhyt(), bn.getSoDienThoai(),
                        bn.getNgheNghiep(), bn.getDanToc(), bn.getQuocTich()});
                });
            }

        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(DSBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void btnXuatDSBenhNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDSBenhNhanActionPerformed
        try {
            dsBenhNhan = BenhNhanCtrl.timTatCaBenhNhan();
            BenhNhanCtrl.xuatFileExcel(dsBenhNhan, "src/main/java/ExcelStorage/DSBenhNhan.xlsx");
            DialogHelper.showMessage("Xuất danh sách thành công!");
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(DSBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXuatDSBenhNhanActionPerformed

    private void btnLuuBenhNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuBenhNhanActionPerformed
        try {
            String maBenhNhan = GenerateCode.generateMa("BN");
            String hoTen = txtHoTen.getText();
            String gioiTinh = cmbGioiTinh.getSelectedItem().toString();
            String namSinh = txtNamSinh.getText();
            String diaChi = txtDiaChi.getText();
            String canCuoc = txtCanCuoc.getText();
            String BHYT = txtBHYT.getText();
            String soDienThoai = txtSoDienThoai.getText();
            String ngheNghiep = txtNgheNghiep.getText();
            String danToc = txtDanToc.getText();
            String quocTich = txtQuocTich.getText();

            if (!txtMaBenhNhan.getText().isEmpty()) {
                DialogHelper.showError("Bệnh nhân đã tồn tại");
            } else if (hoTen.isEmpty()) {
                DialogHelper.showError("Họ tên không được để trống");
            } else if (namSinh.isEmpty()) {
                DialogHelper.showError("Năm sinh không được để trống");
            } else if (!namSinh.isEmpty() && !Validator.isValidYearOfBirth(namSinh)) {
                DialogHelper.showError("Năm sinh không hợp lệ");
            } else if (!Validator.isValidYearOfBirth(namSinh)) {
                DialogHelper.showError("Năm sinh không hợp lệ");
            } else if (soDienThoai.isEmpty()) {
                DialogHelper.showError("Số điện thoại không được để trống");
            } else if (!soDienThoai.isEmpty() && !Validator.isValidPhoneNumber(soDienThoai)) {
                DialogHelper.showError("Số điện thoại không hợp lệ");
            } else if (diaChi.isEmpty()) {
                DialogHelper.showError("Địa chỉ không được để trống");
            } else if (!canCuoc.isEmpty() && !Validator.isValidCccd(canCuoc)) {
                DialogHelper.showError("Căn cước công dân không hợp lệ");
            } else if (!canCuoc.isEmpty() && BenhNhanCtrl.kiemTraCccdCoTonTai(canCuoc)) {
                DialogHelper.showError("CCCD đã tồn tại");
            } else if (!BHYT.isEmpty() && !Validator.isValidBhyt(BHYT)) {
                DialogHelper.showError("Bảo hiểm y tế không hợp lệ");
            } else if (!BHYT.isEmpty() && BenhNhanCtrl.kiemTrabHYTCoTonTai(BHYT, maBenhNhan)) {
                DialogHelper.showError("BHYT đã tồn tại");
            } else {
                BenhNhanModel bn = new BenhNhanModel(maBenhNhan, hoTen, gioiTinh, namSinh, diaChi, canCuoc, BHYT, soDienThoai, ngheNghiep, danToc, quocTich);
                BenhNhanCtrl.themBenhNhan(bn);
                DialogHelper.showMessage("Thêm bệnh nhân thành công");
                hienThiTatCaBenhNhan();
                lamMoiTTBenhNhan();
            }
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(DSBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLuuBenhNhanActionPerformed

    private void btnSuaBenhnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaBenhnhanActionPerformed
        try {
            String maBenhNhan = txtMaBenhNhan.getText();
            String hoTen = txtHoTen.getText();
            String gioiTinh = cmbGioiTinh.getSelectedItem().toString();
            String namSinh = txtNamSinh.getText();
            String diaChi = txtDiaChi.getText();
            String canCuoc = txtCanCuoc.getText();
            String BHYT = txtBHYT.getText();
            String soDienThoai = txtSoDienThoai.getText();
            String ngheNghiep = txtNgheNghiep.getText();
            String danToc = txtDanToc.getText();
            String quocTich = txtQuocTich.getText();

            if (hoTen.isEmpty()) {
                DialogHelper.showError("Họ tên không được để trống");
            } else if (namSinh.isEmpty()) {
                DialogHelper.showError("Năm sinh không được để trống");
            } else if (!namSinh.isEmpty() && !Validator.isValidYearOfBirth(namSinh)) {
                DialogHelper.showError("Năm sinh không hợp lệ");
            } else if (!Validator.isValidYearOfBirth(namSinh)) {
                DialogHelper.showError("Năm sinh không hợp lệ");
            } else if (soDienThoai.isEmpty()) {
                DialogHelper.showError("Số điện thoại không được để trống");
            } else if (!soDienThoai.isEmpty() && !Validator.isValidPhoneNumber(soDienThoai)) {
                DialogHelper.showError("Số điện thoại không hợp lệ");
            } else if (diaChi.isEmpty()) {
                DialogHelper.showError("Địa chỉ không được để trống");
            } else if (!canCuoc.isEmpty() && !Validator.isValidCccd(canCuoc)) {
                DialogHelper.showError("Căn cước công dân không hợp lệ");
            } else if (!BHYT.isEmpty() && !Validator.isValidBhyt(BHYT)) {
                DialogHelper.showError("Bảo hiểm y tế không hợp lệ");
            } else {
                if (DialogHelper.showConfirmation("Bạn có chắc sửa thông tin bệnh nhân này")) {
                    BenhNhanModel bn = new BenhNhanModel(maBenhNhan, hoTen, gioiTinh, namSinh, diaChi, canCuoc, BHYT, soDienThoai, ngheNghiep, danToc, quocTich);
                    BenhNhanCtrl.capNhatBenhNhan(bn);
                    hienThiTatCaBenhNhan();
                    lamMoiTTBenhNhan();
                    DialogHelper.showMessage("Sửa thông tin bệnh nhân thành công");
                }
            }
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(DSBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaBenhnhanActionPerformed

    private void txtSoDienThoaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiFocusLost
        String sdt = txtSoDienThoai.getText();
        if (!sdt.isEmpty() && !Validator.isValidPhoneNumber(sdt)) {
            DialogHelper.showError("Số điện thoại không hợp lệ");
            txtSoDienThoai.requestFocus();
        }
    }//GEN-LAST:event_txtSoDienThoaiFocusLost

    private void txtCanCuocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCanCuocFocusLost
        String cccd = txtCanCuoc.getText();
        if (!cccd.isEmpty() && !Validator.isValidCccd(cccd)) {
            DialogHelper.showError("Căn cước công dân không hợp lệ");
            txtCanCuoc.requestFocus();
        } else try {
            if (!cccd.isEmpty() && BenhNhanCtrl.kiemTraCccdCoTonTai(cccd)) {
                DialogHelper.showError("Căn cước công dân đã tồn tại");
                txtCanCuoc.requestFocus();
            }
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(DSBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCanCuocFocusLost

    private void txtDanTocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDanTocFocusLost
        String danToc = txtDanToc.getText();
        if (!danToc.isEmpty() && !Validator.isValidEthnicGroup(danToc)) {
            DialogHelper.showError("Dân tộc không hợp lệ");
            txtBHYT.requestFocus();
        }
    }//GEN-LAST:event_txtDanTocFocusLost

    private void txtBHYTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBHYTFocusLost
        String bhyt = txtBHYT.getText();
        String maBenhNhan = txtMaBenhNhan.getText();
        if (!bhyt.isEmpty() && !Validator.isValidBhyt(bhyt)) {
            DialogHelper.showError("Bảo hiểm y tế không hợp lệ");
            txtBHYT.requestFocus();
        } else try {
            if (!bhyt.isEmpty() && BenhNhanCtrl.kiemTrabHYTCoTonTai(bhyt, maBenhNhan)) {
                DialogHelper.showError("Bảo hiểm y tế đã tồn tại");
                txtBHYT.requestFocus();
            }
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(DSBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtBHYTFocusLost

    private void dsBenhNhanTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsBenhNhanTableMouseClicked
        int selectedIndex = dsBenhNhanTable.getSelectedRow();
        if (selectedIndex >= 0) {
            BenhNhanModel bn = dsBenhNhan.get(selectedIndex);

            txtMaBenhNhan.setText(bn.getMaBenhNhan());
            txtHoTen.setText(bn.getHoTen());
            txtDiaChi.setText(bn.getDiaChi());
            cmbGioiTinh.setSelectedIndex(0);
            txtNamSinh.setText(bn.getNamSinh());
            txtCanCuoc.setText(bn.getCanCuoc());
            txtBHYT.setText(bn.getBhyt());
            txtNgheNghiep.setText(bn.getNgheNghiep());
            txtSoDienThoai.setText(bn.getSoDienThoai());
            txtDanToc.setText(bn.getDanToc());
            txtQuocTich.setText(bn.getQuocTich());
        }
    }//GEN-LAST:event_dsBenhNhanTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuuBenhNhan;
    private javax.swing.JButton btnNhapMoiBenhNhan;
    private javax.swing.JButton btnSuaBenhnhan;
    private javax.swing.JButton btnXoaBenhNhan;
    private javax.swing.JButton btnXuatDSBenhNhan;
    private javax.swing.JComboBox<String> cmbGioiTinh;
    private javax.swing.JComboBox<String> cmbLoc;
    private javax.swing.JTable dsBenhNhanTable;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBHYT;
    private javax.swing.JTextField txtCanCuoc;
    private javax.swing.JTextField txtDanToc;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaBenhNhan;
    private javax.swing.JTextField txtNamSinh;
    private javax.swing.JTextField txtNgheNghiep;
    private javax.swing.JTextField txtQuocTich;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
