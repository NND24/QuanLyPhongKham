package views.main;

import controllers.DonGiaPhongBenhCtrl;
import controllers.XepGiuongCtrl;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import models.DonGiaPhongBenhModel;
import models.GiuongBenhModel;
import models.XepGiuongModel;
import utils.DialogHelper;
import views.list.DSGiuongBenhKhaDung;

/**
 *
 * @author Phu Bao
 */
public class XepGiuong extends javax.swing.JPanel {

    /**
     * Creates new form XepGiuong
     */
    public static XepGiuong Instance;
    public JLabel MaBNLabel;
    public JLabel NameLabel;
    public JLabel MaBALabel;

    DefaultTableModel tableModel1;
    List<GiuongBenhModel> dsGiuongBenhTrong = new ArrayList<>();

    DefaultTableModel tableModel2;
    List<XepGiuongModel> dsGiuongBenhCoNguoi = new ArrayList<>();
    
    private List<DonGiaPhongBenhModel> dsLoaiPhong;
    
    public XepGiuong() {
        initComponents();
        tableModel1 = (DefaultTableModel) tblDanhSachGiuongBenhTrong.getModel();
        tableModel2 = (DefaultTableModel) tblDanhSachGiuongBenhCoNguoi.getModel();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate currentDate = LocalDate.now();
        txtNgayNhapVien.setText(currentDate.format(formatter));
        hienThiDanhSachLoaiPhongComboBox();

        Instance = this;
        MaBALabel = lblMaBenhAn;
        MaBNLabel = lblMaBenhNhan;
        NameLabel = lblTenBenhNhan;

        try {
            hienThiCacGiuongTrong();
            hienThiCacGiuongCoNguoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XepGiuong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    private void hienThiDanhSachLoaiPhongComboBox() {
        try {
            dsLoaiPhong = DonGiaPhongBenhCtrl.hienThiTatCa();
            cboLocPhong.removeAllItems();
            cboLocPhong.addItem("Mặc định");
            dsLoaiPhong.forEach(loaiPhong -> {
                String tenLoaiPhong = loaiPhong.getTenLoaiPhong();
                cboLocPhong.addItem(tenLoaiPhong);
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XepGiuong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiCacGiuongTrong() throws ClassNotFoundException {
        dsGiuongBenhTrong = XepGiuongCtrl.hienThiGiuongTrong();
        tableModel1.setRowCount(0);
        dsGiuongBenhTrong.forEach(xg -> {
            tableModel1.addRow(new Object[]{xg.getMaGiuong(), xg.getMaPhong(),
                xg.getTenPhong(), xg.getTenLoaiPhong(), xg.getCoNguoi(), xg.getDonGia()});
        });
    }

    private void timKiemNhapVien(String tuKhoa) throws ClassNotFoundException {
        dsGiuongBenhTrong = XepGiuongCtrl.timKiemNhapVien(tuKhoa);
        tableModel1.setRowCount(0);
        dsGiuongBenhTrong.forEach(xg -> {
            tableModel1.addRow(new Object[]{xg.getMaGiuong(), xg.getMaPhong(),
                xg.getTenPhong(), xg.getTenLoaiPhong(), xg.getCoNguoi(), xg.getDonGia()});
        });
    }
    
    private void locLoaiPhong(String tuKhoa) throws ClassNotFoundException {
        dsGiuongBenhTrong = XepGiuongCtrl.locPhongTheoLoai(tuKhoa);
        tableModel1.setRowCount(0);
        dsGiuongBenhTrong.forEach(xg -> {
            tableModel1.addRow(new Object[]{xg.getMaGiuong(), xg.getMaPhong(),
                xg.getTenPhong(), xg.getTenLoaiPhong(), xg.getCoNguoi(), xg.getDonGia()});
        });
    }

    private void hienThiCacGiuongCoNguoi() throws ClassNotFoundException {
        dsGiuongBenhCoNguoi = XepGiuongCtrl.hienThiGiuongDangCoNguoi();
        tableModel2.setRowCount(0);
        dsGiuongBenhCoNguoi.forEach(xg -> {
            tableModel2.addRow(new Object[]{xg.getMaPhong(), xg.getTenPhong(), xg.getMaXepGiuong(),
                xg.getMaGiuong(), xg.getMaBenhAn(), xg.getMaBenhNhan(), xg.getTenBenhNhan(), xg.getNgayNhapVien()});
        });
    }

    private void timKiemXuatVien(String tuKhoa) throws ClassNotFoundException {
        dsGiuongBenhCoNguoi = XepGiuongCtrl.timKiemGiuongDangCoNguoi(tuKhoa);
        tableModel2.setRowCount(0);
        dsGiuongBenhCoNguoi.forEach(xg -> {
            tableModel2.addRow(new Object[]{xg.getMaPhong(), xg.getTenPhong(), xg.getMaXepGiuong(),
                xg.getMaGiuong(), xg.getMaBenhAn(), xg.getMaBenhNhan(), xg.getTenBenhNhan(), xg.getNgayNhapVien()});
        });
    }

    private void sapXepGiuongBenhDangCoNguoiTheoTenPhong() throws ClassNotFoundException {
        dsGiuongBenhCoNguoi = XepGiuongCtrl.sapXepGiuongDangCoNguoiTheoTenPhong();
        tableModel2.setRowCount(0);
        dsGiuongBenhCoNguoi.forEach(xg -> {
            tableModel2.addRow(new Object[]{xg.getMaPhong(), xg.getTenPhong(), xg.getMaXepGiuong(),
                xg.getMaGiuong(), xg.getMaBenhAn(), xg.getMaBenhNhan(), xg.getTenBenhNhan(), xg.getNgayNhapVien()});
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhSachGiuongBenhTrong = new javax.swing.JTable();
        txtNgayNhapVien = new javax.swing.JTextField();
        btnNhapVien = new javax.swing.JButton();
        txtMaGiuong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtLoaiPhong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTimKiemNhapVien = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblMaBenhAn = new javax.swing.JLabel();
        lblMaBenhNhan = new javax.swing.JLabel();
        lblTenBenhNhan = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cboLocPhong = new javax.swing.JComboBox<>();
        btnLamMoi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachGiuongBenhCoNguoi = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtMaBenhNhan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNgayVaoVien = new javax.swing.JTextField();
        txtNgayXuatVien = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSoNgay = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        btnXuatVien = new javax.swing.JButton();
        txtMaGiuongBenhNhanDangDung = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTimKiemXuatVien = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        cboSapXep = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btnDoiGiuong = new javax.swing.JButton();
        MaBenhAnXVLabel = new javax.swing.JLabel();
        txtMaXepGiuong = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTenLoaiPhong = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập Viện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã Bệnh Nhân:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên Bệnh Nhân");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ngày Nhập Viện:");

        tblDanhSachGiuongBenhTrong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Giường", "Mã Phòng", "Tên Phòng", "Loại Phòng", "Có Người", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachGiuongBenhTrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachGiuongBenhTrongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhSachGiuongBenhTrong);

        txtNgayNhapVien.setEditable(false);
        txtNgayNhapVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnNhapVien.setBackground(new java.awt.Color(0, 104, 255));
        btnNhapVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNhapVien.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapVien.setText("Nhập Viện");
        btnNhapVien.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNhapVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapVien.setPreferredSize(new java.awt.Dimension(120, 30));
        btnNhapVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapVienActionPerformed(evt);
            }
        });

        txtMaGiuong.setEditable(false);
        txtMaGiuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Mã Giường");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Loại Phòng");

        txtLoaiPhong.setEditable(false);
        txtLoaiPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Tìm kiếm");

        txtTimKiemNhapVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiemNhapVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemNhapVienKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Mã Bệnh Án");

        lblMaBenhAn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaBenhAn.setText("_____________________________________");
        lblMaBenhAn.setToolTipText("");

        lblMaBenhNhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaBenhNhan.setText("_____________________________________");

        lblTenBenhNhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTenBenhNhan.setText("_________________________________");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Lọc Phòng");

        cboLocPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboLocPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mặc định" }));
        cboLocPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocPhongActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemNhapVien, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(cboLocPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaBenhAn)
                    .addComponent(lblMaBenhNhan)
                    .addComponent(txtMaGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayNhapVien, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(btnNhapVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTimKiemNhapVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaBenhAn)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(cboLocPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblMaBenhNhan)
                            .addComponent(jLabel2)
                            .addComponent(lblTenBenhNhan))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtMaGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNgayNhapVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNhapVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Xuất Viện - Sửa Thông Tin Bệnh Nhân", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        tblDanhSachGiuongBenhCoNguoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phòng", "Tên Phòng", "Mã Xếp Giường", "Mã Giường", "Mã Bệnh Án", "Mã Bệnh Nhân", "Tên Bệnh Nhân", "Ngày Nhập Viện"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachGiuongBenhCoNguoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachGiuongBenhCoNguoiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachGiuongBenhCoNguoi);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mã BN");

        txtMaBenhNhan.setEditable(false);
        txtMaBenhNhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Ngày Vào Viện");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Ngày Xuất Viện");

        txtNgayVaoVien.setEditable(false);
        txtNgayVaoVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtNgayXuatVien.setEditable(false);
        txtNgayXuatVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Số Ngày");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Thành Tiền");

        txtSoNgay.setEditable(false);
        txtSoNgay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtThanhTien.setEditable(false);
        txtThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnXuatVien.setBackground(new java.awt.Color(0, 102, 255));
        btnXuatVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXuatVien.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatVien.setText("Xuất Viện");
        btnXuatVien.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXuatVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatVien.setPreferredSize(new java.awt.Dimension(90, 30));
        btnXuatVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatVienActionPerformed(evt);
            }
        });

        txtMaGiuongBenhNhanDangDung.setEditable(false);
        txtMaGiuongBenhNhanDangDung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Mã Giường");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Tìm kiếm");

        txtTimKiemXuatVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemXuatVienKeyTyped(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(0, 102, 255));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.setPreferredSize(new java.awt.Dimension(90, 30));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        cboSapXep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo Ngày", "Theo Phòng" }));
        cboSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXepActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Sắp xếp");

        btnDoiGiuong.setBackground(new java.awt.Color(0, 102, 255));
        btnDoiGiuong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDoiGiuong.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiGiuong.setText("Đổi giường");
        btnDoiGiuong.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDoiGiuong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDoiGiuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiGiuongActionPerformed(evt);
            }
        });

        MaBenhAnXVLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MaBenhAnXVLabel.setText("Mã XG");

        txtMaXepGiuong.setEditable(false);
        txtMaXepGiuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Loại Phòng");

        txtTenLoaiPhong.setEditable(false);
        txtTenLoaiPhong.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiemXuatVien, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(cboSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenLoaiPhong)
                        .addGap(18, 18, 18)
                        .addComponent(btnDoiGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(btnXuatVien, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNgayXuatVien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgayVaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaGiuongBenhNhanDangDung, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(MaBenhAnXVLabel))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaBenhNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtMaXepGiuong))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txtTimKiemXuatVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel17)
                        .addComponent(txtTenLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDoiGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MaBenhAnXVLabel)
                        .addComponent(txtMaXepGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMaBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtMaGiuongBenhNhanDangDung, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNgayVaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNgayXuatVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXuatVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1360, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhSachGiuongBenhTrongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachGiuongBenhTrongMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblDanhSachGiuongBenhTrong.getSelectedRow();
        if (selectedRow >= 0) {
            GiuongBenhModel gb = dsGiuongBenhTrong.get(selectedRow);
            txtMaGiuong.setText(gb.getMaGiuong());
            txtLoaiPhong.setText(gb.getTenLoaiPhong());
        } else {
            System.out.println("Chưa có dòng nào được chọn");
        }
    }//GEN-LAST:event_tblDanhSachGiuongBenhTrongMouseClicked

    private void btnNhapVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapVienActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tblDanhSachGiuongBenhTrong.getSelectedRow();
        if (selectedIndex >= 0) {
            GiuongBenhModel gb = dsGiuongBenhTrong.get(selectedIndex);
            String maGiuong = txtMaGiuong.getText();
            String maBA = lblMaBenhAn.getText();
            LocalDate ngayHomNay = LocalDate.now();
            Date sqlDateNhapVien = Date.valueOf(ngayHomNay);
            String maBN = lblMaBenhNhan.getText();
            if (maBA.contains("_")) {
                DialogHelper.showError("Chưa có bệnh nhân");
            } else {
                try {
                    if (!XepGiuongCtrl.kiemTraTonTaiBenhNhan(maBA, maBN)) {
                        XepGiuongModel xg = new XepGiuongModel(maGiuong, maBA, sqlDateNhapVien);
                        try {
                            XepGiuongCtrl.nhapVien(xg, gb);
                            DialogHelper.showMessage("Bệnh nhân nhập viện thành công!");
                            hienThiCacGiuongTrong();
                            hienThiCacGiuongCoNguoi();
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(XepGiuong.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        DialogHelper.showError("Bệnh nhân đã nhập viện.");
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(XepGiuong.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            DialogHelper.showError("Chưa có dòng nào trong danh sách được chọn.");
        }
    }//GEN-LAST:event_btnNhapVienActionPerformed

    private void txtTimKiemNhapVienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemNhapVienKeyTyped
        // TODO add your handling code here:
        try {
            String tuKhoa = txtTimKiemNhapVien.getText();
            if(tuKhoa.equals("")){
                hienThiCacGiuongTrong();
            } else {
                timKiemNhapVien(tuKhoa);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XepGiuong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTimKiemNhapVienKeyTyped

    private void cboLocPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocPhongActionPerformed
        // TODO add your handling code here:
        if (cboLocPhong.getSelectedIndex() == 0) {
            try {
                hienThiCacGiuongTrong();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(XepGiuong.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Object selectedItem = cboLocPhong.getSelectedItem();
            if (selectedItem != null) {
                String loaiPhong = selectedItem.toString();
                try {
                    locLoaiPhong(loaiPhong);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(XepGiuong.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_cboLocPhongActionPerformed

    private void lamMoi() {
        txtMaXepGiuong.setText("");
        txtMaBenhNhan.setText("");
        txtMaGiuong.setText("");
        txtNgayVaoVien.setText("");
        txtNgayXuatVien.setText("");
        txtSoNgay.setText("");
        txtThanhTien.setText("");
        txtMaGiuongBenhNhanDangDung.setText("");
        hienThiDanhSachLoaiPhongComboBox();
        try {
            hienThiCacGiuongTrong();
            hienThiCacGiuongCoNguoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XepGiuong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        lamMoi();
        cboSapXep.setSelectedIndex(0);
        cboLocPhong.setSelectedIndex(0);
        txtTimKiemNhapVien.setText("");
        txtTimKiemXuatVien.setText("");
        txtLoaiPhong.setText("");
        txtTenLoaiPhong.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblDanhSachGiuongBenhCoNguoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachGiuongBenhCoNguoiMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblDanhSachGiuongBenhCoNguoi.getSelectedRow();
        if (selectedRow >= 0) {
            XepGiuongModel xg = dsGiuongBenhCoNguoi.get(selectedRow);

            txtMaXepGiuong.setText(xg.getMaXepGiuong());
            txtMaBenhNhan.setText(xg.getMaBenhNhan());
            txtMaGiuongBenhNhanDangDung.setText(xg.getMaGiuong());

            try {
                String loaiPhong = XepGiuongCtrl.loaiPhong(xg.getMaGiuong());
                txtTenLoaiPhong.setText(loaiPhong);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(XepGiuong.class.getName()).log(Level.SEVERE, null, ex);
            }

            Date ngayNhapVien = xg.getNgayNhapVien();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
            String ngayNhapVienStr = sdf.format(ngayNhapVien);
            txtNgayVaoVien.setText(ngayNhapVienStr);
            LocalDate ngayNhapVienLocalDate = ngayNhapVien.toLocalDate();

            LocalDate ngayHomNay = LocalDate.now();
            Date sqlDate = Date.valueOf(ngayHomNay);
            String ngayXuatVienStr = sdf.format(sqlDate);
            txtNgayXuatVien.setText(ngayXuatVienStr);

            long khoangCachNgay = ChronoUnit.DAYS.between(ngayNhapVienLocalDate, ngayHomNay);
            txtSoNgay.setText(String.valueOf(khoangCachNgay));
            //            xg.setNgayXuatVien(sqlDate);
            int tienPhong;
            try {
                tienPhong = (int) (khoangCachNgay * XepGiuongCtrl.donGia(xg.getMaPhong()));
                txtThanhTien.setText(String.valueOf(tienPhong));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(XepGiuong.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            DialogHelper.showError("Chưa có dòng nào trong table được chọn!");
        }
    }//GEN-LAST:event_tblDanhSachGiuongBenhCoNguoiMouseClicked

    private void btnXuatVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatVienActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tblDanhSachGiuongBenhCoNguoi.getSelectedRow();
        if (selectedIndex >= 0) {
            XepGiuongModel xg = dsGiuongBenhCoNguoi.get(selectedIndex);
            try {
                XepGiuongCtrl.xuatVien(xg.getMaGiuong(), xg.getMaXepGiuong());
                DialogHelper.showMessage("Xuất viện thành công");
                lamMoi();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(XepGiuongCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            DialogHelper.showError("Chưa có dòng nào trong danh sách được chọn!");
        }
    }//GEN-LAST:event_btnXuatVienActionPerformed

    private void txtTimKiemXuatVienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemXuatVienKeyTyped
        // TODO add your handling code here:
        String tuKhoa = txtTimKiemXuatVien.getText();
        try {
            timKiemXuatVien(tuKhoa);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XepGiuong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTimKiemXuatVienKeyTyped

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tblDanhSachGiuongBenhCoNguoi.getSelectedRow();
        if (selectedIndex >= 0) {
            XepGiuongModel xg = dsGiuongBenhCoNguoi.get(selectedIndex);
            try {
                XepGiuongCtrl.xoaXepGiuong(xg.getMaXepGiuong(), xg.getMaGiuong());
                DialogHelper.showMessage("Xóa thành công");
                hienThiCacGiuongTrong();
                hienThiCacGiuongCoNguoi();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(XepGiuong.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            DialogHelper.showError("Chưa có dòng nào trong bảng được chọn");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void cboSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXepActionPerformed
        // TODO add your handling code here:
        int selectedIndex = cboSapXep.getSelectedIndex();
        if (selectedIndex == 0) {
            try {
                hienThiCacGiuongCoNguoi();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(XepGiuong.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (selectedIndex == 1) {
            try {
                sapXepGiuongBenhDangCoNguoiTheoTenPhong();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(XepGiuong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cboSapXepActionPerformed

    private void btnDoiGiuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiGiuongActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tblDanhSachGiuongBenhCoNguoi.getSelectedRow();
        if (selectedIndex >= 0) {
            XepGiuongModel xg = dsGiuongBenhCoNguoi.get(selectedIndex);
            if (DSGiuongBenhKhaDung.Instance == null) {
                DSGiuongBenhKhaDung.Instance = new DSGiuongBenhKhaDung();
            }
            DSGiuongBenhKhaDung.Instance.txtMaXepGiuong.setText(xg.getMaXepGiuong());
            DSGiuongBenhKhaDung.Instance.txtMaGiuongBenhNhanDangDung.setText(xg.getMaGiuong());
            try {
                String loaiPhong = XepGiuongCtrl.loaiPhong(xg.getMaGiuong());
                DSGiuongBenhKhaDung.Instance.txtTenLoaiPhong.setText(loaiPhong);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(XepGiuong.class.getName()).log(Level.SEVERE, null, ex);
            }
            DSGiuongBenhKhaDung.Instance.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    // Khi cửa sổ DSGiuongBenhKhaDung được đóng, gọi phương thức làm mới
                    lamMoi();
                }
            });
            DSGiuongBenhKhaDung.Instance.setVisible(true);

        } else {
            DialogHelper.showError("Chưa có dòng nào trong bảng được chọn");
        }
    }//GEN-LAST:event_btnDoiGiuongActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MaBenhAnXVLabel;
    private javax.swing.JButton btnDoiGiuong;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnNhapVien;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatVien;
    private javax.swing.JComboBox<String> cboLocPhong;
    private javax.swing.JComboBox<String> cboSapXep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMaBenhAn;
    private javax.swing.JLabel lblMaBenhNhan;
    private javax.swing.JLabel lblTenBenhNhan;
    private javax.swing.JTable tblDanhSachGiuongBenhCoNguoi;
    private javax.swing.JTable tblDanhSachGiuongBenhTrong;
    private javax.swing.JTextField txtLoaiPhong;
    private javax.swing.JTextField txtMaBenhNhan;
    private javax.swing.JTextField txtMaGiuong;
    private javax.swing.JTextField txtMaGiuongBenhNhanDangDung;
    private javax.swing.JTextField txtMaXepGiuong;
    private javax.swing.JTextField txtNgayNhapVien;
    private javax.swing.JTextField txtNgayVaoVien;
    private javax.swing.JTextField txtNgayXuatVien;
    private javax.swing.JTextField txtSoNgay;
    private javax.swing.JTextField txtTenLoaiPhong;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTimKiemNhapVien;
    private javax.swing.JTextField txtTimKiemXuatVien;
    // End of variables declaration//GEN-END:variables
}
