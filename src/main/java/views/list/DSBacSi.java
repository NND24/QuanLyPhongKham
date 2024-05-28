package views.list;

import controllers.BacSiCtrl;
import controllers.KhoaCtrl;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.BacSiModel;
import models.KhoaModel;
import utils.DialogHelper;
import utils.Validator;

/**
 *
 * @author Phu Bao
 */
public class DSBacSi extends javax.swing.JPanel {

    /**
     * Creates new form DSBacSi1
     */
    DefaultTableModel tableModel;
    List<BacSiModel> dsBacSi = new ArrayList<>();
    private String currentImage = null;
    private String defaultPath = "src/main/java/Images/BacSi/default.png";
    private List<KhoaModel> dsKhoa;
    private List<KhoaModel> dsKhoaLoc;

    public DSBacSi() {
        initComponents();
        this.currentImage = defaultPath;
        tableModel = (DefaultTableModel) tblDanhSachBacSi.getModel();
        try {
            hienThiCacBacSi();
            hienThiDSKhoa();
            hienThiDSLocKhoa();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiCacBacSi() throws ClassNotFoundException {
        dsBacSi = BacSiCtrl.hienThiTatCa();
        tableModel.setRowCount(0);
        dsBacSi.forEach(bs -> {
            tableModel.addRow(new Object[]{bs.getMaBacSi(), bs.getHoTen(), bs.getGioiTinh(), bs.getNamSinh(),
                bs.getCanCuoc(), bs.getDiaChi(), bs.getSoDienThoai(), bs.getEmail(), bs.getTrinhDo(), bs.getTenKhoa()});
        });
    }

    private void hienThiDSKhoa() {
        try {
            dsKhoa = KhoaCtrl.hienThiCacKhoaConHoatDong();
            cboKhoa.removeAllItems();
            cboKhoa.addItem("--Khoa--");
            dsKhoa.forEach(khoa -> {
                String tenKhoa = khoa.getTenKhoa();
                cboKhoa.addItem(tenKhoa);
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSLocKhoa() {
        try {
            dsKhoaLoc = KhoaCtrl.hienThiTatCa();
            cboLoc.removeAllItems();
            cboLoc.addItem("Tất cả");
            dsKhoaLoc.forEach(khoa -> {
                String tenKhoa = khoa.getTenKhoa();
                cboLoc.addItem(tenKhoa);
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiCacBacSiTheoKhoa(String maKhoa) throws ClassNotFoundException {
        dsBacSi = BacSiCtrl.hienThiDanhSachTheoKhoa(maKhoa);
        tableModel.setRowCount(0);
        dsBacSi.forEach(bs -> {
            tableModel.addRow(new Object[]{bs.getMaBacSi(), bs.getHoTen(), bs.getGioiTinh(), bs.getNamSinh(),
                bs.getCanCuoc(), bs.getDiaChi(), bs.getSoDienThoai(), bs.getEmail(), bs.getTrinhDo(), bs.getTenKhoa()});
        });
    }

    private void hienThiDanhSachBacSiTimKiem(String tuKhoa) throws ClassNotFoundException {
        dsBacSi = BacSiCtrl.timKiemBacSi(tuKhoa);
        tableModel.setRowCount(0);
        dsBacSi.forEach(bs -> {
            tableModel.addRow(new Object[]{bs.getMaBacSi(), bs.getHoTen(), bs.getGioiTinh(), bs.getNamSinh(),
                bs.getCanCuoc(), bs.getDiaChi(), bs.getSoDienThoai(), bs.getEmail(), bs.getTrinhDo(), bs.getTenKhoa()});
        });
    }

    private void hienThiTheoTenAZ() throws ClassNotFoundException {
        dsBacSi = BacSiCtrl.sapXepTheoTen_AZ();
        tableModel.setRowCount(0);
        dsBacSi.forEach(bs -> {
            tableModel.addRow(new Object[]{bs.getMaBacSi(), bs.getHoTen(), bs.getGioiTinh(), bs.getNamSinh(),
                bs.getCanCuoc(), bs.getDiaChi(), bs.getSoDienThoai(), bs.getEmail(), bs.getTrinhDo(), bs.getTenKhoa()});
        });
    }

    private void hienThiTheoTenZA() throws ClassNotFoundException {
        dsBacSi = BacSiCtrl.sapXepTheoTen_ZA();
        tableModel.setRowCount(0);
        dsBacSi.forEach(bs -> {
            tableModel.addRow(new Object[]{bs.getMaBacSi(), bs.getHoTen(), bs.getGioiTinh(), bs.getNamSinh(),
                bs.getCanCuoc(), bs.getDiaChi(), bs.getSoDienThoai(), bs.getEmail(), bs.getTrinhDo(), bs.getTenKhoa()});
        });
    }

    private void hienThiTheoNamSinhTangDan() throws ClassNotFoundException {
        dsBacSi = BacSiCtrl.sapXepTheoNamSinh_TangDan();
        tableModel.setRowCount(0);
        dsBacSi.forEach(bs -> {
            tableModel.addRow(new Object[]{bs.getMaBacSi(), bs.getHoTen(), bs.getGioiTinh(), bs.getNamSinh(),
                bs.getCanCuoc(), bs.getDiaChi(), bs.getSoDienThoai(), bs.getEmail(), bs.getTrinhDo(), bs.getTenKhoa()});
        });
    }

    private void hienThiTheoNamSinhGiamDan() throws ClassNotFoundException {
        dsBacSi = BacSiCtrl.sapXepTheoNamSinh_GiamDan();
        tableModel.setRowCount(0);
        dsBacSi.forEach(bs -> {
            tableModel.addRow(new Object[]{bs.getMaBacSi(), bs.getHoTen(), bs.getGioiTinh(), bs.getNamSinh(),
                bs.getCanCuoc(), bs.getDiaChi(), bs.getSoDienThoai(), bs.getEmail(), bs.getTrinhDo(), bs.getTenKhoa()});
        });
    }

    private void lamMoi() {
        txtMaBacSi.setText("");
        txtHoTen.setText("");
        cboGioiTinh.setSelectedIndex(0);
        txtDiaChi.setText("");
        txtNamSinh.setText("");
        txtCanCuoc.setText("");
        txtSoDienThoai.setText("");
        txtEmail.setText("");
        txtTrinhDo.setText("");
        cboKhoa.setSelectedIndex(0);
        currentImage = null;
        lblImage.setIcon(null);
        currentImage = defaultPath;
        showImageOnLabel(currentImage);
    }

    private void showImageOnLabel(String duongDan) {
        try {
            // Đọc ảnh từ đường dẫn tương đối
            ImageIcon originalIcon = new ImageIcon(ImageIO.read(new File(duongDan)));

            // Lấy kích thước của JLabel
            int labelWidth = lblImage.getWidth();
            int labelHeight = lblImage.getHeight();

            // Chỉnh kích thước của ảnh để phù hợp với JLabel
            Image scaledImage = originalIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);

            // Tạo ImageIcon mới từ ảnh đã được chỉnh kích thước
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // Đặt ảnh cho JLabel
            lblImage.setIcon(scaledIcon);
        } catch (IOException e) {
            DialogHelper.showError("Lỗi hình ảnh: " + e.getMessage());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnXuatDanhSach = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMaBacSi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cboGioiTinh = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        txtCanCuoc = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNamSinh = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtTrinhDo = new javax.swing.JTextField();
        cboKhoa = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboSapXep = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboLoc = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachBacSi = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnChonAnh = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1360, 585));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel4.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("THÔNG TIN BÁC SĨ");

        btnXuatDanhSach.setBackground(new java.awt.Color(0, 102, 255));
        btnXuatDanhSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatDanhSach.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatDanhSach.setText("Xuất danh sách");
        btnXuatDanhSach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatDanhSach.setPreferredSize(new java.awt.Dimension(140, 25));
        btnXuatDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDanhSachActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(100, 25));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 102, 255));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa thông tin");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.setPreferredSize(new java.awt.Dimension(125, 25));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(0, 102, 255));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa bác sĩ");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.setPreferredSize(new java.awt.Dimension(98, 25));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(0, 102, 255));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm bác sĩ");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.setPreferredSize(new java.awt.Dimension(120, 25));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 528, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXuatDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnXuatDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã bác sĩ");

        txtMaBacSi.setEditable(false);
        txtMaBacSi.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Họ tên");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Giới tính");

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Căn cước");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Số điện thoại");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Email");

        txtEmail.setEditable(false);
        txtEmail.setBackground(new java.awt.Color(204, 204, 204));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Năm sinh");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Trình độ");

        cboKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKhoaActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Địa chỉ");

        jPanel8.setPreferredSize(new java.awt.Dimension(199, 35));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("DANH SÁCH BÁC SĨ");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Sắp xếp");

        cboSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mặc định", "Sắp xếp theo tên: A-Z", "Sắp xếp theo tên: Z-A", "Sắp xếp theo năm sinh: Tăng dần", "Sắp xếp theo năm sinh: Giảm dần" }));
        cboSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXepActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tìm kiếm");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Lọc");

        cboLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(61, 61, 61)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(cboSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(cboLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(cboSapXep)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(cboLoc))
                .addGap(9, 9, 9))
        );

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Khoa");

        tblDanhSachBacSi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã bác sĩ", "Họ tên", "Giới tính", "Năm sinh", "Căn cước", "Địa chỉ", "Số điện thoại", "Email", "Trình độ", "Khoa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachBacSi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDanhSachBacSi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachBacSiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachBacSi);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Ảnh thẻ");

        btnChonAnh.setBackground(new java.awt.Color(204, 204, 204));
        btnChonAnh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnChonAnh.setText("Chọn file");
        btnChonAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });

        lblImage.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("Hình ảnh");
        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaBacSi, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(41, 41, 41)
                        .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCanCuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel25)
                            .addComponent(jLabel17)
                            .addComponent(jLabel22))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel7)
                        .addGap(58, 58, 58)
                        .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(162, 162, 162)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaBacSi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnChonAnh))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCanCuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(txtTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXuatDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDanhSachActionPerformed
        // TODO add your handling code here:
        String tenTep = "DSBacSi.xlsx";
        String duongDan = "src/main/java/ExcelStorage/" + tenTep;
        try {
            dsBacSi = BacSiCtrl.hienThiTatCa();
            BacSiCtrl.exportToExcel(this.dsBacSi, duongDan);
            DialogHelper.showMessage("Xuất file thành công");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXuatDanhSachActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        lamMoi();
        try {
            hienThiCacBacSi();
            hienThiDSKhoa();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        try {
            int selectedIndex = tblDanhSachBacSi.getSelectedRow();
            if (selectedIndex >= 0) {
                String maBacSi = txtMaBacSi.getText();
                String hoTen = txtHoTen.getText();
                String gioiTinh = cboGioiTinh.getSelectedItem().toString();
                String diaChi = txtDiaChi.getText();
                String namSinh = txtNamSinh.getText();
                String canCuoc = txtCanCuoc.getText();
                String soDienThoai = txtSoDienThoai.getText();
                String trinhDo = txtTrinhDo.getText();

                int index = cboKhoa.getSelectedIndex();
                
                if(cboKhoa.getSelectedIndex()==0){
                    DialogHelper.showError("Vui lòng chọn khoa ");
                } else if (hoTen.isEmpty() || canCuoc.isEmpty() || trinhDo.isEmpty()) {
                    DialogHelper.showError("Vui lòng điền đầy đủ các thông tin");
                } else if (!canCuoc.isEmpty() && !Validator.isValidCccd(canCuoc)) {
                    DialogHelper.showError("Căn cước không hợp lệ");
                } else if (!soDienThoai.isEmpty() && !Validator.isValidPhoneNumber(soDienThoai)) {
                    DialogHelper.showError("Số điện thoại không hợp lệ");
                } else if (!canCuoc.isEmpty() && BacSiCtrl.kiemTraCanCuocCoTonTai_CapNhat(canCuoc, maBacSi)) {
                    DialogHelper.showError("Căn cước đã tồn tại");
                } else if (!namSinh.isEmpty() && !Validator.isValidYearOfBirth(namSinh)) {
                    DialogHelper.showError("Năm sinh không hợp lệ");
                } else {
                    String maKhoa = dsKhoa.get(index - 1).getMaKhoa();
                    BacSiModel bs = new BacSiModel(maBacSi, maKhoa.split(" ")[0], hoTen, gioiTinh, namSinh, diaChi, soDienThoai, canCuoc, trinhDo, currentImage);
                    BacSiCtrl.capNhatBacSi(bs);
                    DialogHelper.showMessage("Cập nhật thành công.");
                    hienThiCacBacSi();
                    lamMoi();
                }
            } else {
                DialogHelper.showError("Chưa có dòng nào trong bảng được chọn");
            }
        } catch (ClassCastException | ClassNotFoundException ex) {
            Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tblDanhSachBacSi.getSelectedRow();
        if (selectedIndex >= 0) {
            BacSiModel bs = dsBacSi.get(selectedIndex);
            boolean option = DialogHelper.showConfirmation("Bạn có chắc muốn xóa Bác sĩ này không?");

            if (option) {
                try {
                    BacSiCtrl.xoaBacSi(bs);
                    DialogHelper.showMessage("Xóa thành công");
                    hienThiCacBacSi();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            DialogHelper.showError("Chưa có dòng nào trong bảng được chọn");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        try {
            if (!txtMaBacSi.getText().isEmpty()) {
                DialogHelper.showError("Bác sĩ đã tồn tại trong cơ sở dữ liệu");
            } else {
                String tenBS = txtHoTen.getText();
                String gioiTinh = cboGioiTinh.getSelectedItem().toString();
                String diaChi = txtDiaChi.getText();
                String namSinh = txtNamSinh.getText();
                String canCuoc = txtCanCuoc.getText();
                String sdt = txtSoDienThoai.getText();
                String trinhDo = txtTrinhDo.getText();
                String maKhoa = "";
                if (cboKhoa.getSelectedIndex() == 0) {
                    DialogHelper.showError("Vui lòng điền đầy đủ các thông tin");
                } else if (tenBS.isEmpty() || canCuoc.isEmpty() || trinhDo.isEmpty()) {
                    DialogHelper.showError("Vui lòng điền đầy đủ các thông tin");
                } else if (!canCuoc.isEmpty() && !Validator.isValidCccd(canCuoc)) {
                    DialogHelper.showError("Căn cước không hợp lệ");
                } else if (BacSiCtrl.kiemTraCanCuocCoTonTai(canCuoc)) {
                    DialogHelper.showError("Căn cước đã tồn tại");
                } else if (!sdt.isEmpty() && !Validator.isValidPhoneNumber(sdt)) {
                    DialogHelper.showError("Số điện thoại không hợp lệ");
                } else if (!namSinh.isEmpty() && !Validator.isValidYearOfBirth(namSinh)) {
                    DialogHelper.showError("Năm sinh không hợp lệ");
                } else {
                    if (!dsKhoa.isEmpty()) {
                        int index = cboKhoa.getSelectedIndex();
                        maKhoa = dsKhoa.get(index - 1).getMaKhoa();
                    }
                    BacSiModel bs = new BacSiModel(maKhoa, tenBS, gioiTinh, namSinh, diaChi, sdt, canCuoc, trinhDo, currentImage);
                    try {
                        BacSiCtrl.themBacSi(bs);
                        DialogHelper.showMessage("Thêm thành công");
                        hienThiCacBacSi();
                        lamMoi();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (ClassCastException | ClassNotFoundException ex) {
            Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void cboKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboKhoaActionPerformed

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        // TODO add your handling code here:
        String tuKhoa = txtTimKiem.getText();
        try {
            hienThiDanhSachBacSiTimKiem(tuKhoa);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void cboSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXepActionPerformed
        // TODO add your handling code here:
        switch (cboSapXep.getSelectedIndex()) {
            case 0 -> {
                try {
                    hienThiCacBacSi();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 1 -> {
                try {
                    hienThiTheoTenAZ();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 2 -> {
                try {
                    hienThiTheoTenZA();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 3 -> {
                try {
                    hienThiTheoNamSinhTangDan();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 4 -> {
                try {
                    hienThiTheoNamSinhGiamDan();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            default -> {
            }
        }
    }//GEN-LAST:event_cboSapXepActionPerformed

    private void cboLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocActionPerformed
        // TODO add your handling code here:
        if (cboLoc.getSelectedIndex() == 0) {
            try {
                hienThiCacBacSi();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            int index = cboLoc.getSelectedIndex();
            String maKhoa = dsKhoaLoc.get(index - 1).getMaKhoa();
            System.out.println(maKhoa);
            if (maKhoa != null) {
                try {
                    hienThiCacBacSiTheoKhoa(maKhoa);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                DialogHelper.showError("Lỗi tải dữ liệu");
            }
        }
    }//GEN-LAST:event_cboLocActionPerformed

    private void tblDanhSachBacSiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachBacSiMouseClicked
        // TODO add your handling code here:
        lamMoi();
        int selectedIndex = tblDanhSachBacSi.getSelectedRow();
        if (selectedIndex >= 0) {
            BacSiModel bs = dsBacSi.get(selectedIndex);
            txtMaBacSi.setText(bs.getMaBacSi());
            txtHoTen.setText(bs.getHoTen());
            txtDiaChi.setText(bs.getDiaChi());
            txtNamSinh.setText(bs.getNamSinh());
            txtCanCuoc.setText(bs.getCanCuoc());
            txtSoDienThoai.setText(bs.getSoDienThoai());
            txtEmail.setText(bs.getEmail());
            txtTrinhDo.setText(bs.getTrinhDo());
            cboGioiTinh.setSelectedItem(bs.getGioiTinh());
            cboKhoa.setSelectedItem(bs.getTenKhoa());
            showImageOnLabel(bs.getAnh());
        } else {
            System.out.println("Chưa có dòng nào được chọn");
        }
    }//GEN-LAST:event_tblDanhSachBacSiMouseClicked

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        String sourceDirectory = Paths.get("src", "main", "java", "Images", "BacSi").toAbsolutePath().toString();

        JFileChooser fileChooser = new JFileChooser(sourceDirectory);

        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Hình ảnh", "jpg", "png");
        fileChooser.setFileFilter(imageFilter);
        fileChooser.setMultiSelectionEnabled(false);

        int x = fileChooser.showDialog(this, "Chọn File");
        if (x == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                // Đọc ảnh từ đường dẫn
                BufferedImage originalImage = ImageIO.read(selectedFile);

                // Lấy kích thước của JLabel
                int labelWidth = lblImage.getWidth();
                int labelHeight = lblImage.getHeight();

                // Chỉnh kích thước của ảnh để phù hợp với JLabel
                Image scaledImage = originalImage.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);

                // Tạo BufferedImage từ ảnh đã được chỉnh kích thước
                BufferedImage bufferedScaledImage = new BufferedImage(labelWidth, labelHeight, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = bufferedScaledImage.createGraphics();
                g2d.drawImage(scaledImage, 0, 0, null);
                g2d.dispose();

                // Đặt ảnh cho JLabel
                lblImage.setIcon(new ImageIcon(bufferedScaledImage));

                // Tạo chuỗi id duy nhất
                String uniqueID = UUID.randomUUID().toString();

                // Lưu ảnh vào thư mục đích với tên duy nhất
                String newFileName = uniqueID + "_" + selectedFile.getName();
                String relativeImagePath = "src/main/java/Images/BacSi/" + newFileName;
                File outputfile = new File(relativeImagePath);
                ImageIO.write(bufferedScaledImage, "png", outputfile);

                // Lưu đường dẫn tương đối của ảnh
                currentImage = relativeImagePath;
            } catch (IOException e) {
                e.printStackTrace();
                DialogHelper.showError("Lỗi hình ảnh");
            }
        }
    }//GEN-LAST:event_btnChonAnhActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatDanhSach;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JComboBox<String> cboKhoa;
    private javax.swing.JComboBox<String> cboLoc;
    private javax.swing.JComboBox<String> cboSapXep;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTable tblDanhSachBacSi;
    private javax.swing.JTextField txtCanCuoc;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaBacSi;
    private javax.swing.JTextField txtNamSinh;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTrinhDo;
    // End of variables declaration//GEN-END:variables
}
