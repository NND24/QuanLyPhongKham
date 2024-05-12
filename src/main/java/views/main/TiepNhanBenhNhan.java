package views.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import models.NhomDichVuKhamBenhModelTest;
import models.DichVuKhamBenhModelTest;
import models.PhongKhamModelTest;
import models.BenhNhanModel;
import models.DangKyModel;
import models.BenhAnModel;
import controllers.BenhNhanCtrl;
import controllers.DangKyCtrl;
import controllers.KhamLamSangCtrl;
import controllers.BenhAnCtrl;
import controllers.DichVuKhamBenhCtrlTest;
import controllers.NhomDichVuKhamBenhCtrlTest;
import controllers.PhongKhamCtrlTest;
import pdfForm.GeneratePhieuKham;
import utils.Validator;
import utils.DialogHelper;
import utils.GenerateCode;

public class TiepNhanBenhNhan extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    List<BenhNhanModel> dsBenhNhan = new ArrayList<>();
    List<PhongKhamModelTest> dsPhongKham = new ArrayList<>();
    List<NhomDichVuKhamBenhModelTest> dsNhomDichVu = new ArrayList<>();
    List<DichVuKhamBenhModelTest> dsDichVu = new ArrayList<>();

    public TiepNhanBenhNhan() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) tblDSBenhNhan.getModel();

            hienThiTatCaBenhNhan();

            LocalDate currentDate = LocalDate.now();
            txtNgayKham.setText(currentDate.format(formatter));

            hienThiDSPhongKham();
            hienThiDSNhomDichVu();
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(TiepNhanBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
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

    private void hienThiDSPhongKham() {
        try {
            cmbPhongKham.removeAllItems();
            dsPhongKham = PhongKhamCtrlTest.timTatCaPhongKham();
            dsPhongKham.forEach(pk -> {
                cmbPhongKham.addItem(pk.getTenPhongKham() + " " + pk.getSoLuongBenhNhan());
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TiepNhanBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSNhomDichVu() {
        try {
            cmbNhomDichVu.removeAllItems();
            dsNhomDichVu = NhomDichVuKhamBenhCtrlTest.timTatNhomDichVuKhamBenh();
            dsNhomDichVu.forEach(ndv -> {
                cmbNhomDichVu.addItem(ndv.getTenNhomDichVuKB());
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TiepNhanBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lamMoiTTBenhNhan() {
        try {
            txtMaBenhNhan.setText("");
            txtHoTen.setText("");
            txtDiaChi.setText("");
            cmbGioiTinh.setSelectedIndex(0);
            txtNamSinh.setText("");
            txtCanCuoc.setText("");
            txtBHYT.setText("");
            txtNgheNghiep.setText("");
            txtSoDienThoai.setText("");
            txtDanToc.setText("");
            txtQuocTich.setText("");

            hienThiTatCaBenhNhan();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TiepNhanBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lamMoiTTKhamBenh() {
        txtMaDangKy.setText("");
        cmbDichVu.setSelectedIndex(0);
        cmbPhongKham.setSelectedIndex(0);
        txtLyDoKham.setText(null);
        txtThuTuKham.setText("0");
        hienThiDSPhongKham();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLuuBenhNhan = new javax.swing.JButton();
        btnNhapMoiBenhNhan = new javax.swing.JButton();
        btnSuaBenhNhan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnLuuDangKy = new javax.swing.JButton();
        btnNhapMoiDangKy = new javax.swing.JButton();
        btnInPhieuKham = new javax.swing.JButton();
        btnLamMoiThuTu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMaBenhNhan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbGioiTinh = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNgheNghiep = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNamSinh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDanToc = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMaDangKy = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cmbDichVu = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cmbPhongKham = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtCanCuoc = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtNgayKham = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtBHYT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtQuocTich = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cmbLoc = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtThuTuKham = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cmbNhomDichVu = new javax.swing.JComboBox<>();
        txtLyDoKham = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSBenhNhan = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1360, 592));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 592));

        jPanel2.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("THÔNG TIN BỆNH NHÂN");

        btnLuuBenhNhan.setBackground(new java.awt.Color(0, 102, 255));
        btnLuuBenhNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuuBenhNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnLuuBenhNhan.setText("Lưu TT bệnh nhân");
        btnLuuBenhNhan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLuuBenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLuuBenhNhan.setPreferredSize(new java.awt.Dimension(120, 25));
        btnLuuBenhNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuBenhNhanActionPerformed(evt);
            }
        });

        btnNhapMoiBenhNhan.setBackground(new java.awt.Color(0, 102, 255));
        btnNhapMoiBenhNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhapMoiBenhNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapMoiBenhNhan.setText("Làm mới");
        btnNhapMoiBenhNhan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNhapMoiBenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapMoiBenhNhan.setPreferredSize(new java.awt.Dimension(90, 25));
        btnNhapMoiBenhNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapMoiBenhNhanActionPerformed(evt);
            }
        });

        btnSuaBenhNhan.setBackground(new java.awt.Color(0, 102, 255));
        btnSuaBenhNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaBenhNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaBenhNhan.setText("Sửa thông tin");
        btnSuaBenhNhan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSuaBenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaBenhNhan.setPreferredSize(new java.awt.Dimension(100, 25));
        btnSuaBenhNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaBenhNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 785, Short.MAX_VALUE)
                .addComponent(btnLuuBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnSuaBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnNhapMoiBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnLuuBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhapMoiBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(199, 35));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("THÔNG TIN ĐĂNG KÝ KHÁM BỆNH");

        btnLuuDangKy.setBackground(new java.awt.Color(0, 102, 255));
        btnLuuDangKy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuuDangKy.setForeground(new java.awt.Color(255, 255, 255));
        btnLuuDangKy.setText("Lưu TT khám");
        btnLuuDangKy.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLuuDangKy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLuuDangKy.setPreferredSize(new java.awt.Dimension(110, 25));
        btnLuuDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuDangKyActionPerformed(evt);
            }
        });

        btnNhapMoiDangKy.setBackground(new java.awt.Color(0, 102, 255));
        btnNhapMoiDangKy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhapMoiDangKy.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapMoiDangKy.setText("Làm mới");
        btnNhapMoiDangKy.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNhapMoiDangKy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapMoiDangKy.setPreferredSize(new java.awt.Dimension(90, 25));
        btnNhapMoiDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapMoiDangKyActionPerformed(evt);
            }
        });

        btnInPhieuKham.setBackground(new java.awt.Color(0, 102, 255));
        btnInPhieuKham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInPhieuKham.setForeground(new java.awt.Color(255, 255, 255));
        btnInPhieuKham.setText("In phiếu khám");
        btnInPhieuKham.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInPhieuKham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInPhieuKham.setPreferredSize(new java.awt.Dimension(115, 25));
        btnInPhieuKham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInPhieuKhamActionPerformed(evt);
            }
        });

        btnLamMoiThuTu.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoiThuTu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoiThuTu.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiThuTu.setText("Làm mới thứ tự");
        btnLamMoiThuTu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLamMoiThuTu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoiThuTu.setPreferredSize(new java.awt.Dimension(115, 25));
        btnLamMoiThuTu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiThuTuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 638, Short.MAX_VALUE)
                .addComponent(btnLuuDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnNhapMoiDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnInPhieuKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnLamMoiThuTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnLuuDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhapMoiDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInPhieuKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoiThuTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
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

        txtNamSinh.setPreferredSize(new java.awt.Dimension(64, 30));
        txtNamSinh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNamSinhFocusLost(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Dân tộc");

        txtDanToc.setPreferredSize(new java.awt.Dimension(64, 30));
        txtDanToc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDanTocFocusLost(evt);
            }
        });

        txtSoDienThoai.setMinimumSize(new java.awt.Dimension(64, 30));
        txtSoDienThoai.setPreferredSize(new java.awt.Dimension(64, 30));
        txtSoDienThoai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiFocusLost(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Số điện thoại");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Căn cước");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Mã ĐK khám");

        txtMaDangKy.setEnabled(false);
        txtMaDangKy.setMinimumSize(new java.awt.Dimension(64, 30));
        txtMaDangKy.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Dịch vụ khám");

        cmbDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Dịch vụ---", "KB654321 Khám họng" }));
        cmbDichVu.setPreferredSize(new java.awt.Dimension(106, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Phòng khám");

        cmbPhongKham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Phòng khám---", "PK123456 Tai mũi họng" }));
        cmbPhongKham.setPreferredSize(new java.awt.Dimension(132, 30));
        cmbPhongKham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPhongKhamActionPerformed(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("(*)");

        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("(*)");

        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("(*)");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Lý do khám");

        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setText("(*)");

        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("(*)");

        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("(*)");

        txtCanCuoc.setPreferredSize(new java.awt.Dimension(64, 30));
        txtCanCuoc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCanCuocFocusLost(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Địa chỉ");

        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("(*)");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Ngày khám");

        jLabel35.setForeground(new java.awt.Color(255, 0, 0));
        jLabel35.setText("(*)");

        txtNgayKham.setEnabled(false);
        txtNgayKham.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("BHYT");

        txtBHYT.setMinimumSize(new java.awt.Dimension(64, 30));
        txtBHYT.setPreferredSize(new java.awt.Dimension(64, 30));
        txtBHYT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBHYTFocusLost(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Quốc tịch");

        txtQuocTich.setPreferredSize(new java.awt.Dimension(64, 30));

        jPanel4.setPreferredSize(new java.awt.Dimension(199, 35));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("DANH SÁCH BỆNH NHÂN");

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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Tìm kiếm");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Lọc");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(5, 5, 5)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel21)
                .addGap(5, 5, 5)
                .addComponent(cmbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel21))
                .addGap(11, 11, 11))
        );

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Thứ tự khám");

        txtThuTuKham.setText("0");
        txtThuTuKham.setEnabled(false);
        txtThuTuKham.setPreferredSize(new java.awt.Dimension(64, 30));

        txtDiaChi.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Nhóm dịch vụ");

        cmbNhomDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Nhóm dịch vụ---" }));
        cmbNhomDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNhomDichVuActionPerformed(evt);
            }
        });

        txtLyDoKham.setMinimumSize(new java.awt.Dimension(64, 30));
        txtLyDoKham.setPreferredSize(new java.awt.Dimension(64, 30));

        tblDSBenhNhan.setModel(new javax.swing.table.DefaultTableModel(
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
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSBenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDSBenhNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSBenhNhanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSBenhNhan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBHYT, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
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
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgheNghiep, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCanCuoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDanToc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbNhomDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNgayKham, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(txtLyDoKham, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel28)
                                .addGap(10, 10, 10)
                                .addComponent(cmbPhongKham, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtThuTuKham, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel17)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel7)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addComponent(jLabel22)
                    .addComponent(txtCanCuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDanToc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtNgheNghiep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(txtBHYT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel23)
                    .addComponent(jLabel8)
                    .addComponent(txtQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtMaDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel35)
                            .addComponent(txtNgayKham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPhongKham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel28))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(cmbDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel27)
                                    .addComponent(txtLyDoKham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(cmbNhomDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(15, 15, 15)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(txtThuTuKham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhapMoiDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapMoiDangKyActionPerformed
        lamMoiTTKhamBenh();
    }//GEN-LAST:event_btnNhapMoiDangKyActionPerformed

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

                BenhNhanModel benhNhan = BenhNhanCtrl.timBenhNhanTheoMa(maBenhNhan);

                int index = 0;
                txtMaBenhNhan.setText(benhNhan.getMaBenhNhan());
                txtHoTen.setText(benhNhan.getHoTen());
                txtDiaChi.setText(benhNhan.getDiaChi());
                if (benhNhan.getGioiTinh().equalsIgnoreCase("Nam")) {
                    index = 0;
                } else if (benhNhan.getGioiTinh().equalsIgnoreCase("Nữ")) {
                    index = 1;
                }
                cmbGioiTinh.setSelectedIndex(index);
                txtNamSinh.setText(benhNhan.getNamSinh());
                txtCanCuoc.setText(benhNhan.getCanCuoc());
                txtBHYT.setText(benhNhan.getBhyt());
                txtNgheNghiep.setText(benhNhan.getNgheNghiep());
                txtSoDienThoai.setText(benhNhan.getSoDienThoai());
                txtDanToc.setText(benhNhan.getDanToc());
                txtQuocTich.setText(benhNhan.getQuocTich());

            }
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(TiepNhanBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLuuBenhNhanActionPerformed

    private void btnNhapMoiBenhNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapMoiBenhNhanActionPerformed
        lamMoiTTBenhNhan();
    }//GEN-LAST:event_btnNhapMoiBenhNhanActionPerformed

    private void btnLuuDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuDangKyActionPerformed
        try {
            String maDangKy = GenerateCode.generateMa("DK");
            String maBenhNhan = txtMaBenhNhan.getText();
            String lyDoKham = txtLyDoKham.getText();
            int thuTuKham = Integer.parseInt(txtThuTuKham.getText());

            LocalDate currentDate = LocalDate.now();
            java.sql.Date ngayKham = java.sql.Date.valueOf(currentDate);

            if (!txtMaDangKy.getText().isEmpty()) {
                DialogHelper.showError("Đã có mã đăng ký khám");
            } else if (maBenhNhan.isEmpty()) {
                DialogHelper.showError("Mã bệnh nhân không được để trống!");
            } else if (lyDoKham.isEmpty()) {
                DialogHelper.showError("Lý do khám không được để trống!");
            } else if (cmbPhongKham.getSelectedItem().equals("---Phòng khám---")) {
                DialogHelper.showError("Phòng khám không được để trống!");
            } else if (cmbDichVu.getSelectedItem() != null && cmbDichVu.getSelectedItem().equals("---Dịch vụ---")) {
                DialogHelper.showError("Dịch vụ khám không được để trống!");
            } else {
                int dichVuIndex = cmbDichVu.getSelectedIndex();
                String maDichVu = dsDichVu.get(dichVuIndex).getMaDichVuKB();

                int phongKhamIndex = cmbPhongKham.getSelectedIndex();
                String maPhongKham = dsPhongKham.get(phongKhamIndex).getMaPhongKham();

                DangKyModel dk = new DangKyModel(maDangKy, maBenhNhan, maDichVu, maPhongKham, lyDoKham, thuTuKham, ngayKham, "Đợi khám");
                DangKyCtrl.themBenhNhanCho(dk);
                DialogHelper.showMessage("Lưu thông tin đăng ký thành công!");

                txtMaDangKy.setText(maDangKy);
                String maKhamLamSang = KhamLamSangCtrl.generateMaKhamLamSang();
                KhamLamSangCtrl.themMaKhamLamSang(maKhamLamSang);

                String maBenhAn = GenerateCode.generateMa("BA");
                BenhAnModel ba = new BenhAnModel(maBenhAn, maDangKy, maKhamLamSang, maBenhNhan);
                BenhAnCtrl.themBenhAn(ba);
                PhongKhamCtrlTest.themSoLuong(maPhongKham);
                hienThiDSPhongKham();
            }
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(TiepNhanBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLuuDangKyActionPerformed

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
            Logger.getLogger(TiepNhanBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbLocActionPerformed

    private void btnSuaBenhNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaBenhNhanActionPerformed
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
            } else if (!BHYT.isEmpty() && BenhNhanCtrl.kiemTrabHYTCoTonTai(BHYT, maBenhNhan)) {
                DialogHelper.showError("Bảo hiểm y tế đã tồn tại");
            } else {
                if (DialogHelper.showConfirmation("Bạn có chắc sửa thông tin bệnh nhân này")) {
                    BenhNhanModel bn = new BenhNhanModel(maBenhNhan, hoTen, gioiTinh, namSinh, diaChi, canCuoc, BHYT, soDienThoai, ngheNghiep, danToc, quocTich);
                    BenhNhanCtrl.capNhatBenhNhan(bn);
                    hienThiTatCaBenhNhan();
                    DialogHelper.showMessage("Sửa thông tin bệnh nhân thành công");
                }
            }
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(TiepNhanBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaBenhNhanActionPerformed

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
            Logger.getLogger(TiepNhanBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void txtNamSinhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamSinhFocusLost
        String namSinh = txtNamSinh.getText();
        if (!namSinh.isEmpty() && !Validator.isValidYearOfBirth(namSinh)) {
            DialogHelper.showError("Năm sinh không hợp lệ");
            txtNamSinh.requestFocus();
        }
    }//GEN-LAST:event_txtNamSinhFocusLost

    private void txtCanCuocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCanCuocFocusLost
        String cccd = txtCanCuoc.getText();

        if (!cccd.isEmpty() && !Validator.isValidCccd(cccd)) {
            DialogHelper.showError("Căn cước công dân không hợp lệ");
            txtCanCuoc.requestFocus();
        } else try {
            if (!cccd.isEmpty() && BenhNhanCtrl.kiemTraCccdCoTonTai(cccd)) {
                DialogHelper.showError("CCCD đã tồn tại");
                txtCanCuoc.requestFocus();
            }
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(TiepNhanBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCanCuocFocusLost

    private void txtSoDienThoaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiFocusLost
        String sdt = txtSoDienThoai.getText();
        if (!sdt.isEmpty() && !Validator.isValidPhoneNumber(sdt)) {
            DialogHelper.showError("Số điện thoại không hợp lệ");
            txtSoDienThoai.requestFocus();
        }
    }//GEN-LAST:event_txtSoDienThoaiFocusLost

    private void txtBHYTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBHYTFocusLost
        String bhyt = txtBHYT.getText();
        String maBenhNhan = txtMaBenhNhan.getText();
        if (!bhyt.isEmpty() && !Validator.isValidBhyt(bhyt)) {
            DialogHelper.showError("Bảo hiểm y tế không hợp lệ");
            txtBHYT.requestFocus();
        } else try {
            if (!bhyt.isEmpty() && BenhNhanCtrl.kiemTrabHYTCoTonTai(bhyt, maBenhNhan)) {
                DialogHelper.showError("BHYT đã tồn tại");
                txtBHYT.requestFocus();
            }
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(TiepNhanBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtBHYTFocusLost

    private void txtDanTocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDanTocFocusLost
        String danToc = txtDanToc.getText();
        if (!danToc.isEmpty() && !Validator.isValidEthnicGroup(danToc)) {
            DialogHelper.showError("Dân tộc không hợp lệ");
            txtBHYT.requestFocus();
        }
    }//GEN-LAST:event_txtDanTocFocusLost

    private void tblDSBenhNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSBenhNhanMouseClicked
        int selectedIndex = tblDSBenhNhan.getSelectedRow();
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
    }//GEN-LAST:event_tblDSBenhNhanMouseClicked

    private void cmbNhomDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNhomDichVuActionPerformed
        if (cmbNhomDichVu.getSelectedItem() != null) {
            try {
                int nhomDVIndex = cmbNhomDichVu.getSelectedIndex();
                String maNhomDichVu = dsNhomDichVu.get(nhomDVIndex).getMaNhomDichVuKB();
                cmbDichVu.removeAllItems();
                dsDichVu = DichVuKhamBenhCtrlTest.timTatCaDichVuTheoMaNhom(maNhomDichVu);
                dsDichVu.forEach(dv -> {
                    cmbDichVu.addItem(dv.getTenDichVuKB());
                });
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TiepNhanBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmbNhomDichVuActionPerformed

    private void btnInPhieuKhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInPhieuKhamActionPerformed
        try {
            if (txtHoTen.getText().isEmpty()) {
                DialogHelper.showError("Chưa có tên của bệnh nhân");
            } else if (cmbGioiTinh.getSelectedItem().toString().isEmpty()) {
                DialogHelper.showError("Chưa có giới tính của bệnh nhân");
            } else if (txtDiaChi.getText().isEmpty()) {
                DialogHelper.showError("Chưa có địa chỉ của bệnh nhân");
            } else if (txtMaDangKy.getText().isEmpty()) {
                DialogHelper.showError("Chưa có mã đăng ký");
            } else if (txtMaBenhNhan.getText().isEmpty()) {
                DialogHelper.showError("Chưa có mã bệnh nhân");
            } else if (cmbDichVu.getSelectedItem().toString().split(" ")[0].isEmpty()) {
                DialogHelper.showError("Chưa có dịch vụ khám");
            } else {
                int namHienTai = LocalDate.now().getYear();

                String ten = txtHoTen.getText();
                String tuoi = Integer.toString(namHienTai - Integer.parseInt(txtNamSinh.getText()));
                String gioiTinh = cmbGioiTinh.getSelectedItem().toString();
                String diaChi = txtDiaChi.getText();
                String maDangKy = txtMaDangKy.getText();
                String maBenhNhan = txtMaBenhNhan.getText();
                String[] dichVuKham = cmbDichVu.getSelectedItem().toString().split(" ");
                String tenDichVu = "";

                for (int i = 1; i < dichVuKham.length; i++) {
                    tenDichVu += dichVuKham[i] + " ";
                }
                String[] phongKham = cmbPhongKham.getSelectedItem().toString().split(" ");
                String tenPhongKham = "";
                for (int i = 1; i < phongKham.length - 1; i++) {
                    tenPhongKham += phongKham[i] + " ";
                }
                String lyDoKham = txtLyDoKham.getText();
                String thuTuKham = txtThuTuKham.getText();
                String ngayKham = txtNgayKham.getText();

                GeneratePhieuKham inDon = new GeneratePhieuKham(ten, tuoi, gioiTinh, diaChi, maDangKy, ngayKham, lyDoKham, tenDichVu, tenPhongKham, thuTuKham);
                if (maBenhNhan.isEmpty()) {
                    DialogHelper.showError("Chưa có mã đăng ký");
                } else {
                    inDon.taoPhieuKham();
                    DialogHelper.showMessage("In phiếu khám thành công!");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TiepNhanBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInPhieuKhamActionPerformed

    private void cmbPhongKhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPhongKhamActionPerformed
        if (cmbPhongKham.getSelectedItem() != null) {
            String selectedItem = cmbPhongKham.getSelectedItem().toString();
            String[] items = selectedItem.split(" ");
            if (items.length > 2) {
                int soLuong = Integer.parseInt(items[items.length - 1]);
                int thuTuKham = soLuong + 1;
                txtThuTuKham.setText(Integer.toString(thuTuKham));
            } else {
                txtThuTuKham.setText("0");
            }
        }
    }//GEN-LAST:event_cmbPhongKhamActionPerformed

    private void btnLamMoiThuTuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiThuTuActionPerformed
        try {
            if (cmbPhongKham.getSelectedItem().equals("---Phòng khám---")) {
                DialogHelper.showError("Chưa chọn phòng khám muốn làm mới lại thứ tự!");
            } else {
                if (DialogHelper.showConfirmation("Bạn có chắc muốn làm mới lại thứ tự")) {
                    int phongKhamIndex = cmbPhongKham.getSelectedIndex();
                    String maPhongKham = dsPhongKham.get(phongKhamIndex).getMaPhongKham();

                    PhongKhamCtrlTest.capNhatLaiSoLuong(maPhongKham);
                    DialogHelper.showMessage("Làm mới thành công");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TiepNhanBenhNhan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLamMoiThuTuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInPhieuKham;
    private javax.swing.JButton btnLamMoiThuTu;
    private javax.swing.JButton btnLuuBenhNhan;
    private javax.swing.JButton btnLuuDangKy;
    private javax.swing.JButton btnNhapMoiBenhNhan;
    private javax.swing.JButton btnNhapMoiDangKy;
    private javax.swing.JButton btnSuaBenhNhan;
    private javax.swing.JComboBox<String> cmbDichVu;
    private javax.swing.JComboBox<String> cmbGioiTinh;
    private javax.swing.JComboBox<String> cmbLoc;
    private javax.swing.JComboBox<String> cmbNhomDichVu;
    private javax.swing.JComboBox<String> cmbPhongKham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDSBenhNhan;
    private javax.swing.JTextField txtBHYT;
    private javax.swing.JTextField txtCanCuoc;
    private javax.swing.JTextField txtDanToc;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLyDoKham;
    private javax.swing.JTextField txtMaBenhNhan;
    private javax.swing.JTextField txtMaDangKy;
    private javax.swing.JTextField txtNamSinh;
    private javax.swing.JTextField txtNgayKham;
    private javax.swing.JTextField txtNgheNghiep;
    private javax.swing.JTextField txtQuocTich;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtThuTuKham;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
