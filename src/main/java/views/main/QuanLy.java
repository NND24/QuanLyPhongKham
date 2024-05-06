package views.main;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import views.list.DSDichVuCLSTest;
import views.list.DSDichVuKhamBenhTest;
import views.list.DSDonGiaPhongBenh;
import views.list.DSKhoa;
import views.list.DSNhomDichVuCLSTest;
import views.list.DSNhomDichVuKhamBenhTest;
import views.list.DSNhomThuoc;

public class QuanLy extends javax.swing.JFrame {

    public QuanLy() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lypQuanLy = new javax.swing.JLayeredPane();
        tabQuanLyBenhNhan = new javax.swing.JTabbedPane();
        dSBenhNhan1 = new views.list.DSBenhNhan();
        tabVienPhi = new javax.swing.JTabbedPane();
        dSThuTien2 = new views.list.DSThuTien();
        tabQuanLyBacSi = new javax.swing.JTabbedPane();
        dSBacSi1 = new views.list.DSBacSi();
        tabQuanLyYTa = new javax.swing.JTabbedPane();
        dSYTa1 = new views.list.DSYTa();
        tabQuanLyAdmin = new javax.swing.JTabbedPane();
        dSQuanLy1 = new views.list.DSQuanLy();
        tabQuanLyPhongBenh = new javax.swing.JTabbedPane();
        dSPhongBenh1 = new views.list.DSPhongBenh();
        tabQuanLyThuoc = new javax.swing.JTabbedPane();
        dSThuoc1 = new views.list.DSThuoc();
        tabThongTinCaNhan = new javax.swing.JTabbedPane();
        taiKhoanCaNhan1 = new views.main.TaiKhoanCaNhan();
        header = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        HoTenUserLabel = new javax.swing.JLabel();
        ChucVuUserLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mniQuanLyBenhNhan = new javax.swing.JMenu();
        mniQuanLyVienPhi = new javax.swing.JMenu();
        mniQuanLyNhanVien = new javax.swing.JMenu();
        mniQuanLyBacSi = new javax.swing.JMenuItem();
        mniQuanLyYTa = new javax.swing.JMenuItem();
        mniQuanLyAdmin = new javax.swing.JMenuItem();
        mniQuanLyPhongBenh = new javax.swing.JMenu();
        mniDanhSachPhongBenh = new javax.swing.JMenuItem();
        mniDonGiaPB = new javax.swing.JMenuItem();
        mniQuanLyKhamBenh = new javax.swing.JMenu();
        mniQuanLyKhoa = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniQuanLyNhomThuoc = new javax.swing.JMenuItem();
        mniQuanLyThuoc = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mniQuanLyNhomDVKB = new javax.swing.JMenuItem();
        mniQuanLyDVKB = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mniQuanLyNhomDVCLS = new javax.swing.JMenuItem();
        mniQuanLyDVCLS = new javax.swing.JMenuItem();
        mniQuanLyTaiKhoan = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setPreferredSize(new java.awt.Dimension(1360, 715));

        lypQuanLy.setBackground(new java.awt.Color(255, 255, 255));
        lypQuanLy.setPreferredSize(new java.awt.Dimension(1674, 800));
        lypQuanLy.setLayout(new java.awt.CardLayout());

        tabQuanLyBenhNhan.addTab("Quản lý bệnh nhân", dSBenhNhan1);

        lypQuanLy.add(tabQuanLyBenhNhan, "card2");

        tabVienPhi.addTab("Danh sách viện phí", dSThuTien2);

        lypQuanLy.add(tabVienPhi, "card2");

        tabQuanLyBacSi.addTab("Quản lý bác sĩ", dSBacSi1);

        lypQuanLy.add(tabQuanLyBacSi, "card2");

        tabQuanLyYTa.addTab("Quản lý y tá", dSYTa1);

        lypQuanLy.add(tabQuanLyYTa, "card2");

        tabQuanLyAdmin.addTab("Quản lý admin", dSQuanLy1);

        lypQuanLy.add(tabQuanLyAdmin, "card2");

        tabQuanLyPhongBenh.addTab("Quản lý phòng bệnh", dSPhongBenh1);

        lypQuanLy.add(tabQuanLyPhongBenh, "card2");

        tabQuanLyThuoc.addTab("Quản lý thuốc", dSThuoc1);

        lypQuanLy.add(tabQuanLyThuoc, "card2");

        tabThongTinCaNhan.addTab("Thông tin cá nhân", taiKhoanCaNhan1);

        lypQuanLy.add(tabThongTinCaNhan, "card2");

        header.setBackground(new java.awt.Color(50, 112, 83));
        header.setPreferredSize(new java.awt.Dimension(1360, 61));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Họ tên:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Chức vụ:");

        HoTenUserLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        HoTenUserLabel.setForeground(new java.awt.Color(255, 255, 255));
        HoTenUserLabel.setText("____________________________");

        ChucVuUserLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ChucVuUserLabel.setForeground(new java.awt.Color(255, 255, 255));
        ChucVuUserLabel.setText("____________________________");
        ChucVuUserLabel.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Phòng khám Đa Khoa ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 58, 64));
        jLabel7.setText("PTIT");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 168, 121));
        jLabel8.setText("CARE");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(407, 407, 407)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChucVuUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HoTenUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HoTenUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ChucVuUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(10, 10, 10))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jMenuBar1.setPreferredSize(new java.awt.Dimension(70, 30));

        mniQuanLyBenhNhan.setText("Quản lý bệnh nhân");
        mniQuanLyBenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniQuanLyBenhNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mniQuanLyBenhNhanMouseClicked(evt);
            }
        });
        jMenuBar1.add(mniQuanLyBenhNhan);

        mniQuanLyVienPhi.setText("Quản lý bệnh nhân");
        mniQuanLyVienPhi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniQuanLyVienPhi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mniQuanLyVienPhiMouseClicked(evt);
            }
        });
        jMenuBar1.add(mniQuanLyVienPhi);

        mniQuanLyNhanVien.setText("Quản lý nhân viên");
        mniQuanLyNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mniQuanLyBacSi.setText("Danh sách bác sĩ");
        mniQuanLyBacSi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniQuanLyBacSi.setPreferredSize(new java.awt.Dimension(136, 30));
        mniQuanLyBacSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQuanLyBacSiActionPerformed(evt);
            }
        });
        mniQuanLyNhanVien.add(mniQuanLyBacSi);

        mniQuanLyYTa.setText("Danh sách y tá");
        mniQuanLyYTa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniQuanLyYTa.setPreferredSize(new java.awt.Dimension(125, 30));
        mniQuanLyYTa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQuanLyYTaActionPerformed(evt);
            }
        });
        mniQuanLyNhanVien.add(mniQuanLyYTa);

        mniQuanLyAdmin.setText("Danh sách admin");
        mniQuanLyAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniQuanLyAdmin.setPreferredSize(new java.awt.Dimension(140, 30));
        mniQuanLyAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQuanLyAdminActionPerformed(evt);
            }
        });
        mniQuanLyNhanVien.add(mniQuanLyAdmin);

        jMenuBar1.add(mniQuanLyNhanVien);

        mniQuanLyPhongBenh.setText("Quản lý phòng bệnh");
        mniQuanLyPhongBenh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mniDanhSachPhongBenh.setText("Danh sách phòng bệnh");
        mniDanhSachPhongBenh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniDanhSachPhongBenh.setPreferredSize(new java.awt.Dimension(171, 30));
        mniDanhSachPhongBenh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDanhSachPhongBenhActionPerformed(evt);
            }
        });
        mniQuanLyPhongBenh.add(mniDanhSachPhongBenh);

        mniDonGiaPB.setText("Danh sách đơn giá phòng bệnh");
        mniDonGiaPB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniDonGiaPB.setPreferredSize(new java.awt.Dimension(214, 30));
        mniDonGiaPB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDonGiaPBActionPerformed(evt);
            }
        });
        mniQuanLyPhongBenh.add(mniDonGiaPB);

        jMenuBar1.add(mniQuanLyPhongBenh);

        mniQuanLyKhamBenh.setText("Quản lý khám bệnh");
        mniQuanLyKhamBenh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mniQuanLyKhoa.setText("Danh sách khoa");
        mniQuanLyKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniQuanLyKhoa.setPreferredSize(new java.awt.Dimension(132, 30));
        mniQuanLyKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQuanLyKhoaActionPerformed(evt);
            }
        });
        mniQuanLyKhamBenh.add(mniQuanLyKhoa);
        mniQuanLyKhamBenh.add(jSeparator1);

        mniQuanLyNhomThuoc.setText("Danh sách nhóm thuốc");
        mniQuanLyNhomThuoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniQuanLyNhomThuoc.setPreferredSize(new java.awt.Dimension(172, 30));
        mniQuanLyNhomThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQuanLyNhomThuocActionPerformed(evt);
            }
        });
        mniQuanLyKhamBenh.add(mniQuanLyNhomThuoc);

        mniQuanLyThuoc.setText("Danh sách thuốc");
        mniQuanLyThuoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniQuanLyThuoc.setPreferredSize(new java.awt.Dimension(137, 30));
        mniQuanLyThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQuanLyThuocActionPerformed(evt);
            }
        });
        mniQuanLyKhamBenh.add(mniQuanLyThuoc);
        mniQuanLyKhamBenh.add(jSeparator2);

        mniQuanLyNhomDVKB.setText("Danh sách nhóm DV khám bệnh");
        mniQuanLyNhomDVKB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniQuanLyNhomDVKB.setPreferredSize(new java.awt.Dimension(219, 30));
        mniQuanLyNhomDVKB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQuanLyNhomDVKBActionPerformed(evt);
            }
        });
        mniQuanLyKhamBenh.add(mniQuanLyNhomDVKB);

        mniQuanLyDVKB.setText("Danh sách DV khám bệnh");
        mniQuanLyDVKB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniQuanLyDVKB.setPreferredSize(new java.awt.Dimension(184, 30));
        mniQuanLyDVKB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQuanLyDVKBActionPerformed(evt);
            }
        });
        mniQuanLyKhamBenh.add(mniQuanLyDVKB);
        mniQuanLyKhamBenh.add(jSeparator3);

        mniQuanLyNhomDVCLS.setText("Danh sách nhóm DV cận lâm sàn");
        mniQuanLyNhomDVCLS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniQuanLyNhomDVCLS.setPreferredSize(new java.awt.Dimension(222, 30));
        mniQuanLyNhomDVCLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQuanLyNhomDVCLSActionPerformed(evt);
            }
        });
        mniQuanLyKhamBenh.add(mniQuanLyNhomDVCLS);

        mniQuanLyDVCLS.setText("Danh sách DV cận lâm sàn");
        mniQuanLyDVCLS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniQuanLyDVCLS.setPreferredSize(new java.awt.Dimension(187, 30));
        mniQuanLyDVCLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQuanLyDVCLSActionPerformed(evt);
            }
        });
        mniQuanLyKhamBenh.add(mniQuanLyDVCLS);

        jMenuBar1.add(mniQuanLyKhamBenh);

        mniQuanLyTaiKhoan.setText("Tài khoản cá nhân");
        mniQuanLyTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniQuanLyTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mniQuanLyTaiKhoanMouseClicked(evt);
            }
        });
        mniQuanLyTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQuanLyTaiKhoanActionPerformed(evt);
            }
        });
        jMenuBar1.add(mniQuanLyTaiKhoan);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lypQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lypQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mniQuanLyKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQuanLyKhoaActionPerformed
        new DSKhoa().setVisible(true);
        new DSKhoa().setAlwaysOnTop(true);
    }//GEN-LAST:event_mniQuanLyKhoaActionPerformed

    private void mniQuanLyBenhNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mniQuanLyBenhNhanMouseClicked
        lypQuanLy.removeAll();
        lypQuanLy.add(tabQuanLyBenhNhan);
        lypQuanLy.repaint();
        lypQuanLy.revalidate();
    }//GEN-LAST:event_mniQuanLyBenhNhanMouseClicked

    private void mniQuanLyBacSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQuanLyBacSiActionPerformed
        lypQuanLy.removeAll();
        lypQuanLy.add(tabQuanLyBacSi);
        lypQuanLy.repaint();
        lypQuanLy.revalidate();
    }//GEN-LAST:event_mniQuanLyBacSiActionPerformed

    private void mniQuanLyYTaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQuanLyYTaActionPerformed
        lypQuanLy.removeAll();
        lypQuanLy.add(tabQuanLyYTa);
        lypQuanLy.repaint();
        lypQuanLy.revalidate();
    }//GEN-LAST:event_mniQuanLyYTaActionPerformed

    private void mniQuanLyAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQuanLyAdminActionPerformed
        lypQuanLy.removeAll();
        lypQuanLy.add(tabQuanLyAdmin);
        lypQuanLy.repaint();
        lypQuanLy.revalidate();
    }//GEN-LAST:event_mniQuanLyAdminActionPerformed

    private void mniDanhSachPhongBenhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDanhSachPhongBenhActionPerformed
        lypQuanLy.removeAll();
        lypQuanLy.add(tabQuanLyPhongBenh);
        lypQuanLy.repaint();
        lypQuanLy.revalidate();
    }//GEN-LAST:event_mniDanhSachPhongBenhActionPerformed

    private void mniQuanLyThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQuanLyThuocActionPerformed
        lypQuanLy.removeAll();
        lypQuanLy.add(tabQuanLyThuoc);
        lypQuanLy.repaint();
        lypQuanLy.revalidate();
    }//GEN-LAST:event_mniQuanLyThuocActionPerformed

    private void mniDonGiaPBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDonGiaPBActionPerformed
        new DSDonGiaPhongBenh().setVisible(true);
        new DSDonGiaPhongBenh().setAlwaysOnTop(true);
    }//GEN-LAST:event_mniDonGiaPBActionPerformed

    private void mniQuanLyNhomThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQuanLyNhomThuocActionPerformed
        new DSNhomThuoc().setVisible(true);
        new DSNhomThuoc().setAlwaysOnTop(true);
    }//GEN-LAST:event_mniQuanLyNhomThuocActionPerformed

    private void mniQuanLyNhomDVKBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQuanLyNhomDVKBActionPerformed
        new DSNhomDichVuKhamBenhTest().setVisible(true);
        new DSNhomDichVuKhamBenhTest().setAlwaysOnTop(true);
    }//GEN-LAST:event_mniQuanLyNhomDVKBActionPerformed

    private void mniQuanLyDVKBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQuanLyDVKBActionPerformed
        new DSDichVuKhamBenhTest().setVisible(true);
        new DSDichVuKhamBenhTest().setAlwaysOnTop(true);
    }//GEN-LAST:event_mniQuanLyDVKBActionPerformed

    private void mniQuanLyNhomDVCLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQuanLyNhomDVCLSActionPerformed
        new DSNhomDichVuCLSTest().setVisible(true);
        new DSNhomDichVuCLSTest().setAlwaysOnTop(true);
    }//GEN-LAST:event_mniQuanLyNhomDVCLSActionPerformed

    private void mniQuanLyDVCLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQuanLyDVCLSActionPerformed
        new DSDichVuCLSTest().setVisible(true);
        new DSDichVuCLSTest().setAlwaysOnTop(true);
    }//GEN-LAST:event_mniQuanLyDVCLSActionPerformed

    private void mniQuanLyTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQuanLyTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniQuanLyTaiKhoanActionPerformed

    private void mniQuanLyTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mniQuanLyTaiKhoanMouseClicked
        // TODO add your handling code here:
        lypQuanLy.removeAll();
        lypQuanLy.add(tabThongTinCaNhan);
        lypQuanLy.repaint();
        lypQuanLy.revalidate();
    }//GEN-LAST:event_mniQuanLyTaiKhoanMouseClicked

    private void mniQuanLyVienPhiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mniQuanLyVienPhiMouseClicked
        lypQuanLy.removeAll();
        lypQuanLy.add(tabVienPhi);
        lypQuanLy.repaint();
        lypQuanLy.revalidate();
    }//GEN-LAST:event_mniQuanLyVienPhiMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLy main = new QuanLy();

                // Lấy kích thước màn hình
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice gd = ge.getDefaultScreenDevice();
                DisplayMode mode = gd.getDisplayMode();

                // Đặt kích thước cửa sổ là fullscreen
                main.setSize(mode.getWidth(), mode.getHeight());

                // Đặt trạng thái cửa sổ là toàn màn hình
                main.setExtendedState(JFrame.MAXIMIZED_BOTH);

                main.setTitle("QUẢN LÝ PHÒNG KHÁM");
                main.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ChucVuUserLabel;
    private javax.swing.JLabel HoTenUserLabel;
    private views.list.DSBacSi dSBacSi1;
    private views.list.DSBenhNhan dSBenhNhan1;
    private views.list.DSPhongBenh dSPhongBenh1;
    private views.list.DSQuanLy dSQuanLy1;
    private views.list.DSThuTien dSThuTien2;
    private views.list.DSThuoc dSThuoc1;
    private views.list.DSYTa dSYTa1;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLayeredPane lypQuanLy;
    private javax.swing.JMenuItem mniDanhSachPhongBenh;
    private javax.swing.JMenuItem mniDonGiaPB;
    private javax.swing.JMenuItem mniQuanLyAdmin;
    private javax.swing.JMenuItem mniQuanLyBacSi;
    private javax.swing.JMenu mniQuanLyBenhNhan;
    private javax.swing.JMenuItem mniQuanLyDVCLS;
    private javax.swing.JMenuItem mniQuanLyDVKB;
    private javax.swing.JMenu mniQuanLyKhamBenh;
    private javax.swing.JMenuItem mniQuanLyKhoa;
    private javax.swing.JMenu mniQuanLyNhanVien;
    private javax.swing.JMenuItem mniQuanLyNhomDVCLS;
    private javax.swing.JMenuItem mniQuanLyNhomDVKB;
    private javax.swing.JMenuItem mniQuanLyNhomThuoc;
    private javax.swing.JMenu mniQuanLyPhongBenh;
    private javax.swing.JMenu mniQuanLyTaiKhoan;
    private javax.swing.JMenuItem mniQuanLyThuoc;
    private javax.swing.JMenu mniQuanLyVienPhi;
    private javax.swing.JMenuItem mniQuanLyYTa;
    private javax.swing.JTabbedPane tabQuanLyAdmin;
    private javax.swing.JTabbedPane tabQuanLyBacSi;
    private javax.swing.JTabbedPane tabQuanLyBenhNhan;
    private javax.swing.JTabbedPane tabQuanLyPhongBenh;
    private javax.swing.JTabbedPane tabQuanLyThuoc;
    private javax.swing.JTabbedPane tabQuanLyYTa;
    private javax.swing.JTabbedPane tabThongTinCaNhan;
    private javax.swing.JTabbedPane tabVienPhi;
    private views.main.TaiKhoanCaNhan taiKhoanCaNhan1;
    // End of variables declaration//GEN-END:variables

}
