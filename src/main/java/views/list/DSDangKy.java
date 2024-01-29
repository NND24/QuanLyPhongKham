package views.list;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import controllers.DangKyCtrl;
import controllers.DangKyBenhNhanCtrl;
import models.DangKyModel;
import models.DangKyBenhNhanModel;
import utils.DialogHelper;

public class DSDangKy extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    List<DangKyBenhNhanModel> dsDangKy = new ArrayList<>();

    public DSDangKy() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) tblDSDangKy.getModel();

            hienThiBenhNhan();
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(DSDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiBenhNhan() throws ClassNotFoundException {
        dsDangKy = DangKyBenhNhanCtrl.timTatCaBenhNhanDK();
        tableModel.setRowCount(0);

        dsDangKy.forEach(bn -> {
            tableModel.addRow(new Object[]{
                bn.getThuTuKham(), bn.getMaDangKy(), bn.getMaBenhNhan(),
                bn.getHoTen(), bn.getGioiTinh(), bn.getNamSinh(),
                bn.getTenPhongKham(), bn.getNgayKham(), bn.getTrangThai()});
        });
    }

    private void lamMoiThongTin() {
        txtMaBenhNhan.setText("");
        txtHoTen.setText("");
        txtGioiTinh.setText("");
        txtNamSinh.setText("");
        txtMaDangKy.setText("");
        txtNgayKham.setText("");
        cmbDichVuKham.setSelectedIndex(0);
        cmbPhongKham.setSelectedIndex(0);
        txtLyDoKham.setText("");
        cmbTrangThai.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cmbLocPhong = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTimKiemBN = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbLocTrangThai = new javax.swing.JComboBox<>();
        btnLamMoi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnBatDauKham = new javax.swing.JButton();
        btnSuaThongTin = new javax.swing.JButton();
        txtMaBenhNhan = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtGioiTinh = new javax.swing.JTextField();
        txtNamSinh = new javax.swing.JTextField();
        cmbDichVuKham = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cmbPhongKham = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        txtLyDoKham = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtMaDangKy = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtNgayKham = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        cmbTrangThai = new javax.swing.JComboBox<>();
        cmbNhomDichVu = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSDangKy = new javax.swing.JTable();

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
        setPreferredSize(new java.awt.Dimension(1360, 592));

        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 66));

        cmbLocPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbLocPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Phòng khám---" }));
        cmbLocPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLocPhongActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Chọn phòng");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Tìm kiếm");

        txtTimKiemBN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiemBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemBNKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Trạng thái");

        cmbLocTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbLocTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đợi khám", "Đang khám" }));
        cmbLocTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLocTrangThaiActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(100, 30));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbLocPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbLocTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel15)
                .addGap(6, 6, 6)
                .addComponent(txtTimKiemBN, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbLocPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtTimKiemBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cmbLocTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1360, 588));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin bệnh nhân"));
        jPanel4.setPreferredSize(new java.awt.Dimension(1360, 550));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã BN");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Họ tên");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nhóm dịch vụ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Giới tính");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Năm sinh");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Dịch vụ");

        btnBatDauKham.setBackground(new java.awt.Color(0, 102, 255));
        btnBatDauKham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBatDauKham.setForeground(new java.awt.Color(255, 255, 255));
        btnBatDauKham.setText("Bắt đầu khám");
        btnBatDauKham.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBatDauKham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBatDauKham.setPreferredSize(new java.awt.Dimension(110, 26));
        btnBatDauKham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatDauKhamActionPerformed(evt);
            }
        });

        btnSuaThongTin.setBackground(new java.awt.Color(0, 102, 255));
        btnSuaThongTin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaThongTin.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaThongTin.setText("Sửa thông tin đăng ký");
        btnSuaThongTin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSuaThongTin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaThongTin.setPreferredSize(new java.awt.Dimension(190, 26));
        btnSuaThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaThongTinMouseClicked(evt);
            }
        });
        btnSuaThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThongTinActionPerformed(evt);
            }
        });

        txtMaBenhNhan.setEditable(false);
        txtMaBenhNhan.setBackground(new java.awt.Color(255, 255, 255));
        txtMaBenhNhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaBenhNhan.setText("_____________________________________________________________________");
        txtMaBenhNhan.setBorder(null);

        txtHoTen.setEditable(false);
        txtHoTen.setBackground(new java.awt.Color(255, 255, 255));
        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHoTen.setText("_____________________________________________________________________");
        txtHoTen.setBorder(null);

        txtGioiTinh.setEditable(false);
        txtGioiTinh.setBackground(new java.awt.Color(255, 255, 255));
        txtGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGioiTinh.setText("_____________________________________________________________________");
        txtGioiTinh.setBorder(null);

        txtNamSinh.setEditable(false);
        txtNamSinh.setBackground(new java.awt.Color(255, 255, 255));
        txtNamSinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNamSinh.setText("_____________________________________________________________________");
        txtNamSinh.setBorder(null);

        cmbDichVuKham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbDichVuKham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Dịch vụ---" }));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Phòng khám");

        cmbPhongKham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbPhongKham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Phòng khám---" }));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Lý do khám");

        txtLyDoKham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Mã đăng ký");

        txtMaDangKy.setEditable(false);
        txtMaDangKy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Ngày khám");

        txtNgayKham.setEditable(false);
        txtNgayKham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnXoa.setBackground(new java.awt.Color(0, 102, 255));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.setPreferredSize(new java.awt.Dimension(70, 26));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Trạng thái");

        cmbTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Trạng thái---", "Đợi khám", "Đang khám" }));

        cmbNhomDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbNhomDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Nhóm dịch vụ---" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnBatDauKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnSuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel17)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayKham, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDichVuKham, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPhongKham, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLyDoKham, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbNhomDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtMaDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtNgayKham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbNhomDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmbDichVuKham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cmbPhongKham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtLyDoKham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatDauKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        tblDSDangKy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Thứ tự", "Mã ĐK khám", "Mã bệnh nhân", "Họ tên", "Giới tính", "Năm sinh", "Phòng khám", "Ngày khám", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSDangKy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDSDangKy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSDangKyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSDangKy);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaThongTinMouseClicked

    }//GEN-LAST:event_btnSuaThongTinMouseClicked

    private void btnBatDauKhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatDauKhamActionPerformed
        // TODO add your handling code here:
        String maBenhNhan = txtMaBenhNhan.getText();
        String hoTen = txtHoTen.getText();
        String gioiTinh = txtGioiTinh.getText();
        String ngayKham = txtNgayKham.getText();
        String phongKham = cmbPhongKham.getSelectedItem().toString();
        String dichVuKham = cmbDichVuKham.getSelectedItem().toString();
        String lyDoKham = txtLyDoKham.getText();
        String trangThai = cmbTrangThai.getSelectedItem().toString();
        String maDangKy = txtMaDangKy.getText();

        if (dichVuKham.equals("---Dịch vụ---")) {
            DialogHelper.showError("Dịch vụ khám bệnh không được để trống");
        } else if (phongKham.equals("---Phòng khám---")) {
            DialogHelper.showError("Phòng khám không được để trống");
        } else if (lyDoKham.equals("")) {
            DialogHelper.showError("Lý do khám không được để trống");
        } else if (!trangThai.equals("Đợi khám")) {
            DialogHelper.showError("Bệnh án đã được tạo vui lòng sang mục khám bệnh");
        } else {
            try {
                DangKyModel dk = new DangKyModel(maDangKy, "Đang khám");
                DangKyCtrl.capNhatTrangThai(dk);

                hienThiBenhNhan();
                lamMoiThongTin();
                cmbLocPhong.setSelectedIndex(0);
                cmbLocTrangThai.setSelectedIndex(0);
                txtTimKiemBN.setText("");
            } catch (ClassNotFoundException ex) {
                DialogHelper.showError("Đã có lỗi xảy ra");
                Logger.getLogger(DSDangKy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBatDauKhamActionPerformed

    private void cmbLocPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLocPhongActionPerformed
        try {
            if (cmbLocPhong.getSelectedItem() != null) {
                String chonPhong = cmbLocPhong.getSelectedItem().toString();
                if (chonPhong.equals("---Phòng khám---")) {
                    hienThiBenhNhan();
                } else {
                    dsDangKy = DangKyBenhNhanCtrl.timTatCaBenhNhanDKTheoDieuKien(chonPhong.split(" ")[0], "", "Tất cả");
                    tableModel.setRowCount(0);

                    dsDangKy.forEach(bn -> {
                        tableModel.addRow(new Object[]{bn.getThuTuKham(), bn.getMaDangKy(), bn.getNgayKham(),
                            bn.getHoTen(), bn.getMaBenhNhan(), bn.getGioiTinh(), bn.getNamSinh(),
                            bn.getTenPhongKham(), bn.getTrangThai()});
                    });
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbLocPhongActionPerformed

    private void cmbLocTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLocTrangThaiActionPerformed
        try {
            String trangThai = cmbLocTrangThai.getSelectedItem().toString();
            if (trangThai.equals("Tất cả")) {
                hienThiBenhNhan();
            } else {
                dsDangKy = DangKyBenhNhanCtrl.timTatCaBenhNhanDKTheoDieuKien("---Phòng khám---", "", trangThai);
                tableModel.setRowCount(0);

                dsDangKy.forEach(bn -> {
                    tableModel.addRow(new Object[]{
                        bn.getThuTuKham(), bn.getMaDangKy(), bn.getMaBenhNhan(),
                        bn.getHoTen(), bn.getGioiTinh(), bn.getNamSinh(),
                        bn.getTenPhongKham(), bn.getNgayKham(), bn.getTrangThai()});
                });
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbLocTrangThaiActionPerformed

    private void txtTimKiemBNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemBNKeyTyped
        try {
            String timKiem = txtTimKiemBN.getText();
            if (timKiem.equals("")) {
                hienThiBenhNhan();
            } else {
                dsDangKy = DangKyBenhNhanCtrl.timTatCaBenhNhanDKTheoDieuKien("---Phòng khám---", timKiem, "Tất cả");
                tableModel.setRowCount(0);

                dsDangKy.forEach(bn -> {
                    tableModel.addRow(new Object[]{
                        bn.getThuTuKham(), bn.getMaDangKy(), bn.getMaBenhNhan(),
                        bn.getHoTen(), bn.getGioiTinh(), bn.getNamSinh(),
                        bn.getTenPhongKham(), bn.getNgayKham(), bn.getTrangThai()});
                });
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTimKiemBNKeyTyped

    private void btnSuaThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThongTinActionPerformed
        try {
            String maDangKy = txtMaDangKy.getText();
            String dichVuKham = cmbDichVuKham.getSelectedItem().toString();
            String phongKham = cmbPhongKham.getSelectedItem().toString();
            String lyDoKham = txtLyDoKham.getText();
            String trangThai = cmbTrangThai.getSelectedItem().toString();

            if (maDangKy.isEmpty()) {
                DialogHelper.showError("Mã đăng ký không được để trống");
            } else if (dichVuKham.equals("---Dịch vụ---")) {
                DialogHelper.showError("Dịch vụ không được để trống");
            } else if (phongKham.equals("---Phòng khám---")) {
                DialogHelper.showError("Phòng khám không được để trống");
            } else if (phongKham.equals("---Trạng thái---")) {
                DialogHelper.showError("Trạng thái không được để trống");
            } else {
                boolean flag = DialogHelper.showConfirmation("Bạn có chắc muốn sửa thông tin khám bệnh này");

                if (flag) {
                    DangKyModel dk = new DangKyModel(maDangKy, dichVuKham.split(" ")[0], phongKham.split(" ")[0], lyDoKham, trangThai);
                    DangKyCtrl.capNhatDangKy(dk);
                    DialogHelper.showMessage("Sửa thông tin khám bệnh thành công!");
                    hienThiBenhNhan();
                }
            }
        } catch (ClassNotFoundException ex) {
            DialogHelper.showError("Đã có lỗi xảy ra");
            Logger.getLogger(DSDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaThongTinActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        try {
            hienThiBenhNhan();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String maDangKy = txtMaDangKy.getText();

        if (maDangKy.isEmpty()) {
            DialogHelper.showError("Mã đăng ký không được để trống");
        } else {
            boolean flag = DialogHelper.showConfirmation("Bạn có chắc muốn xóa thông tin khám bệnh này");

            if (flag) {
                try {
                    DangKyCtrl.xoaDangKy(maDangKy);
                    hienThiBenhNhan();
                    DialogHelper.showMessage("Xóa thông tin đăng ký thành công");
                    cmbLocPhong.setSelectedIndex(0);
                    cmbLocTrangThai.setSelectedIndex(0);
                    txtTimKiemBN.setText("");
                } catch (ClassNotFoundException ex) {
                    DialogHelper.showError("Đã có lỗi xảy ra");
                    Logger.getLogger(DSDangKy.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblDSDangKyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSDangKyMouseClicked
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        int selectedIndex = tblDSDangKy.getSelectedRow();
        if (selectedIndex >= 0) {
            DangKyBenhNhanModel bn = dsDangKy.get(selectedIndex);
            txtMaBenhNhan.setText(bn.getMaBenhNhan());
            txtHoTen.setText(bn.getHoTen());
            txtNamSinh.setText(bn.getNamSinh());
            txtGioiTinh.setText(bn.getGioiTinh());
            txtLyDoKham.setText(bn.getLyDoKham());
            // DichVuKhamComboBox.setSelectedItem(bn.getMaDichVuKham() + " " + bn.getTenDichVuKham());
            cmbPhongKham.setSelectedItem(bn.getMaPhongKham() + " " + bn.getTenPhongKham());
            txtMaDangKy.setText(bn.getMaDangKy());
            cmbTrangThai.setSelectedItem(bn.getTrangThai());
            String dateString = dateFormat.format(bn.getNgayKham());
            txtNgayKham.setText(dateString);
        }
    }//GEN-LAST:event_tblDSDangKyMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatDauKham;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSuaThongTin;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cmbDichVuKham;
    private javax.swing.JComboBox<String> cmbLocPhong;
    private javax.swing.JComboBox<String> cmbLocTrangThai;
    private javax.swing.JComboBox<String> cmbNhomDichVu;
    private javax.swing.JComboBox<String> cmbPhongKham;
    private javax.swing.JComboBox<String> cmbTrangThai;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDSDangKy;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLyDoKham;
    private javax.swing.JTextField txtMaBenhNhan;
    private javax.swing.JTextField txtMaDangKy;
    private javax.swing.JTextField txtNamSinh;
    private javax.swing.JTextField txtNgayKham;
    private javax.swing.JTextField txtTimKiemBN;
    // End of variables declaration//GEN-END:variables
}
