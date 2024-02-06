package views.list;

import controllers.DonGiaPhongBenhCtrl;
import controllers.GiuongBenhCtrl;
import controllers.PhongBenhCtrl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.DonGiaPhongBenhModel;
import models.GiuongBenhModel;
import models.PhongBenhModel;
import utils.DialogHelper;
import utils.Validator;
/**
 *
 * @author Phu Bao
 */
public class DSPhongBenh extends javax.swing.JPanel {

    /**
     * Creates new form DSPhongBenh
     */
    DefaultTableModel tabelModel;
    List<PhongBenhModel> dsPhongBenh = new ArrayList<>();

    DefaultTableModel tabelModel2;
    List<GiuongBenhModel> dsGiuongBenh = new ArrayList<>();
    
    public DSPhongBenh() {
        initComponents();

        tabelModel = (DefaultTableModel) tblDanhSachPhongBenh.getModel();
        tabelModel2 = (DefaultTableModel) tblDanhSachGiuongBenh.getModel();
        try {
            hienThiCacPhongBenh();
            hienThiTatCaGiuongBenh();
            hienThiLoaiPhong();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void hienThiCacPhongBenh() throws ClassNotFoundException {
        dsPhongBenh = PhongBenhCtrl.hienThiTatCa();
        tabelModel.setRowCount(0);
        dsPhongBenh.forEach(pb -> {
            tabelModel.addRow(new Object[]{pb.getMaPhong(), pb.getTenPhong(), pb.getLoaiPhong(),
                pb.getSoGiuong(), pb.getDonGia(), pb.getTenYTa()});
        });
    }
    
    private void hienThiCacPhongBenhTimKiem(String tuKhoa) throws ClassNotFoundException {
        dsPhongBenh = PhongBenhCtrl.timKiemPhongBenh(tuKhoa);
        tabelModel.setRowCount(0);
        dsPhongBenh.forEach(pb -> {
            tabelModel.addRow(new Object[]{pb.getMaPhong(), pb.getTenPhong(), pb.getLoaiPhong(),
                pb.getSoGiuong(), pb.getDonGia(), pb.getTenYTa()});
        });
    }

    private void hienThiTatCaGiuongBenh() throws ClassNotFoundException {
        dsGiuongBenh = GiuongBenhCtrl.hienThiTatCa();
        tabelModel2.setRowCount(0);
        dsGiuongBenh.forEach(gb -> {
            tabelModel2.addRow(new Object[]{gb.getMaGiuong(), gb.getMaPhong(), gb.getTenPhong(),
                gb.getTenLoaiPhong(), gb.getDonGia(), gb.getCoNguoi()});
        });
    }

    private void hienThiGiuongBenhTheoMaPhong(String maPhong) throws ClassNotFoundException {
        dsGiuongBenh = GiuongBenhCtrl.hienThiTheoMaPhong(maPhong);
        tabelModel2.setRowCount(0);
        dsGiuongBenh.forEach(gb -> {
            tabelModel2.addRow(new Object[]{gb.getMaGiuong(), gb.getMaPhong(), gb.getTenPhong(),
                gb.getTenLoaiPhong(), gb.getDonGia(), gb.getCoNguoi()});
        });
    }

    private void hienThiLoaiPhong() {
        try {
            List<DonGiaPhongBenhModel> dsDonGia = new ArrayList<>();
            dsDonGia = DonGiaPhongBenhCtrl.hienThiTatCa();
            cboLoaiPhong.removeAllItems();
            dsDonGia.forEach(dg -> {
                String loaiPhong = dg.getMaDonGia() + " " + dg.getTenLoaiPhong();
                cboLoaiPhong.addItem(loaiPhong);

            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhongBenh.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LamMoiButton = new javax.swing.JButton();
        XoaPhongBenhButton = new javax.swing.JButton();
        SuaPhongBenhButton = new javax.swing.JButton();
        ThemPhongButton = new javax.swing.JButton();
        LoaiPhongLabel = new javax.swing.JLabel();
        txtTenPhong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboLoaiPhong = new javax.swing.JComboBox<>();
        txtSoGiuong = new javax.swing.JTextField();
        GSTextField = new javax.swing.JLabel();
        cboYTa = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        btnCong = new javax.swing.JButton();
        btnTru = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtPhongBenh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMaPhongBenh = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhSachGiuongBenh = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachPhongBenh = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel4.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("THÔNG TIN PHÒNG BỆNH");

        LamMoiButton.setBackground(new java.awt.Color(0, 102, 255));
        LamMoiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LamMoiButton.setForeground(new java.awt.Color(255, 255, 255));
        LamMoiButton.setText("Làm mới");
        LamMoiButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LamMoiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LamMoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiButtonActionPerformed(evt);
            }
        });

        XoaPhongBenhButton.setBackground(new java.awt.Color(0, 102, 255));
        XoaPhongBenhButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        XoaPhongBenhButton.setForeground(new java.awt.Color(255, 255, 255));
        XoaPhongBenhButton.setText("Xóa");
        XoaPhongBenhButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        XoaPhongBenhButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XoaPhongBenhButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaPhongBenhButtonActionPerformed(evt);
            }
        });

        SuaPhongBenhButton.setBackground(new java.awt.Color(0, 102, 255));
        SuaPhongBenhButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SuaPhongBenhButton.setForeground(new java.awt.Color(255, 255, 255));
        SuaPhongBenhButton.setText("Cập nhật");
        SuaPhongBenhButton.setToolTipText("");
        SuaPhongBenhButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SuaPhongBenhButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SuaPhongBenhButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaPhongBenhButtonActionPerformed(evt);
            }
        });

        ThemPhongButton.setBackground(new java.awt.Color(0, 102, 255));
        ThemPhongButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ThemPhongButton.setForeground(new java.awt.Color(255, 255, 255));
        ThemPhongButton.setText("Thêm");
        ThemPhongButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ThemPhongButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ThemPhongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemPhongButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 772, Short.MAX_VALUE)
                .addComponent(ThemPhongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(SuaPhongBenhButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(XoaPhongBenhButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(LamMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LamMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XoaPhongBenhButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuaPhongBenhButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThemPhongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        LoaiPhongLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LoaiPhongLabel.setText("Loại Phòng");

        txtTenPhong.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tên Phòng");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Số Giường");

        txtSoGiuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        GSTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        GSTextField.setText("Y tá");

        cboYTa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YT001 Y Văn Tá" }));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã Phòng");

        txtMaPhong.setEnabled(false);

        btnCong.setText("+");
        btnCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCongActionPerformed(evt);
            }
        });

        btnTru.setText("-");
        btnTru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnTru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCong)))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GSTextField)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(LoaiPhongLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboYTa, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(LoaiPhongLabel)
                    .addComponent(cboLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSoGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GSTextField)
                    .addComponent(cboYTa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCong)
                    .addComponent(btnTru))
                .addGap(25, 25, 25))
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(1360, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Phòng");

        txtPhongBenh.setEditable(false);
        txtPhongBenh.setBackground(new java.awt.Color(204, 204, 204));
        txtPhongBenh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Mã Phòng");

        txtMaPhongBenh.setEditable(false);
        txtMaPhongBenh.setBackground(new java.awt.Color(204, 204, 204));
        txtMaPhongBenh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("DANH SÁCH GIƯỜNG BỆNH");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 702, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhongBenh, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaPhongBenh, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPhongBenh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(txtMaPhongBenh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblDanhSachGiuongBenh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Giường", "Mã Phòng", "Tên Phòng", "Loại Phòng", "Đơn Giá", "Có Người"
            }
        ));
        jScrollPane2.setViewportView(tblDanhSachGiuongBenh);

        tblDanhSachPhongBenh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phòng", "Tên Phòng", "Loại Phòng", "Số Giường", "Đơn Giá", "Giám Sát"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachPhongBenh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachPhongBenhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachPhongBenh);

        jLabel9.setToolTipText("");

        jPanel5.setPreferredSize(new java.awt.Dimension(1360, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("DANH SÁCH PHÒNG BỆNH");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 788, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(42, 42, 42)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtTimKiem)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1364, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178)))
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
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
    
    private void lamMoi() {
        txtMaPhong.setText("");
        txtMaPhongBenh.setText("");
        txtPhongBenh.setText("");
        txtTenPhong.setText("");
        txtTimKiem.setText("");
        txtSoGiuong.setText("0");
        cboLoaiPhong.setSelectedIndex(0);
    }
    
    private void LamMoiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiButtonActionPerformed
        // TODO add your handling code here:
        lamMoi();
        tabelModel2.setRowCount(0);
        try {
            hienThiCacPhongBenh();
            hienThiTatCaGiuongBenh();
            PhongBenhCtrl.capNhatTenPhong();
            //            hienThiDSYTa();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhongBenh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LamMoiButtonActionPerformed

    private void XoaPhongBenhButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaPhongBenhButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tblDanhSachPhongBenh.getSelectedRow();
        if (selectedIndex >= 0) {
            try {
                PhongBenhModel pb = dsPhongBenh.get(selectedIndex);
                if (!PhongBenhCtrl.kiemTraPhongBenhCoNguoi(pb.getMaPhong())) {
                    // Cài đặt giá trị mặc định cho nút "No"
                    boolean option = DialogHelper.showConfirmation("Bạn có chắc muốn xóa phòng bệnh này không?");

                    if (option) {
                        try {
                            // Kiểm tra lại trước khi xóa một lần nữa
                            if (!PhongBenhCtrl.kiemTraPhongBenhCoNguoi(pb.getMaPhong())) {
                                PhongBenhCtrl.xoaPhongBenh(pb.getMaPhong());
                                hienThiCacPhongBenh();
                                DialogHelper.showMessage("Xóa thành công");
                                lamMoi();
                                tabelModel2.setRowCount(0);
                            } else {
                                DialogHelper.showMessage("Phòng bệnh đang có người, không thể xóa");

                            }
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(PhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    DialogHelper.showMessage("Phòng bệnh đang có người, không thể xóa");

                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DSPhongBenh.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            DialogHelper.showError("Chưa chọn dòng nào trong table");
        }
    }//GEN-LAST:event_XoaPhongBenhButtonActionPerformed

    private void SuaPhongBenhButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaPhongBenhButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tblDanhSachPhongBenh.getSelectedRow();
        if (selectedIndex >= 0) {
            PhongBenhModel pbDaChon = dsPhongBenh.get(selectedIndex);
            String yTa = cboYTa.getSelectedItem().toString();
            String loaiPhong = cboLoaiPhong.getSelectedItem().toString();
            String soGiuongStr = txtSoGiuong.getText();
            int soGiuong = Integer.parseInt(soGiuongStr);
            PhongBenhModel pb = new PhongBenhModel(yTa.split(" ")[0], loaiPhong.split(" ")[0], soGiuong);
            try {
                PhongBenhCtrl.capNhatPhongBenh(pb, pbDaChon);
                DialogHelper.showMessage("Cập nhật thành công");
                hienThiCacPhongBenh();
                hienThiGiuongBenhTheoMaPhong(pbDaChon.getMaPhong());
                lamMoi();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            DialogHelper.showError("Chưa có phòng nào được chọn");
        }
    }//GEN-LAST:event_SuaPhongBenhButtonActionPerformed

    private void ThemPhongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemPhongButtonActionPerformed
        // TODO add your handling code here:
        if (!txtMaPhong.getText().isEmpty()) {
            DialogHelper.showError("Phòng bệnh đã tồn tại");
        } else {
            try {
                String loaiPhong = cboLoaiPhong.getSelectedItem().toString();
                String soGiuongStr = txtSoGiuong.getText();
                if (!Validator.isIntegerString(soGiuongStr) || "0".equals(soGiuongStr)) {
                    DialogHelper.showError("Số giường không hợp lệ");
                    txtSoGiuong.requestFocus();
                } else {
                    int soGiuong = Integer.parseInt(soGiuongStr);
                    String maYTa = cboYTa.getSelectedItem().toString();
                    PhongBenhModel pb = new PhongBenhModel(maYTa.split(" ")[0], loaiPhong.split(" ")[0], soGiuong);

                    try {
                        PhongBenhCtrl.themPhongBenh(pb);
                        DialogHelper.showMessage("Thêm thành công!");
                        hienThiCacPhongBenh();
                        hienThiTatCaGiuongBenh();
                        lamMoi();
                        tabelModel2.setRowCount(0);

                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DSPhongBenh.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (ClassCastException ex) {
                Logger.getLogger(DSPhongBenh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ThemPhongButtonActionPerformed

    private void btnCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCongActionPerformed
        // TODO add your handling code here:
        String soGiuongStr = txtSoGiuong.getText();
        // Kiểm tra nếu giá trị là rỗng hoặc null
        if (soGiuongStr != null && !soGiuongStr.isEmpty()) {
            int soGiuong = Integer.parseInt(soGiuongStr);
            soGiuong += 1;
            String soGiuongStrMoi = String.valueOf(soGiuong);
            // Sử dụng setText để cập nhật giá trị của text field
            txtSoGiuong.setText(soGiuongStrMoi);
        } else {
            DialogHelper.showError("Số giường không hợp lệ");
        }
    }//GEN-LAST:event_btnCongActionPerformed

    private void btnTruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruActionPerformed
        // TODO add your handling code here:
        String soGiuongStr = txtSoGiuong.getText();
        // Kiểm tra nếu giá trị là rỗng hoặc null
        if (soGiuongStr != null && !soGiuongStr.isEmpty()) {
            int soGiuong = Integer.parseInt(soGiuongStr);
            if (soGiuong == 0) {
                DialogHelper.showError("Không thể nhỏ hơn được nữa");
            } else {
                soGiuong -= 1;
                String soGiuongStrMoi = String.valueOf(soGiuong);
                // Sử dụng setText để cập nhật giá trị của text field
                txtSoGiuong.setText(soGiuongStrMoi);
            }
        } else {
            DialogHelper.showError("Số giường không hợp lệ");
        }
    }//GEN-LAST:event_btnTruActionPerformed

    private void tblDanhSachPhongBenhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachPhongBenhMouseClicked
        // TODO add your handling code here:
        lamMoi();
        int selectedRow = tblDanhSachPhongBenh.getSelectedRow();
        if (selectedRow >= 0) {
            PhongBenhModel pb = dsPhongBenh.get(selectedRow);
            try {
                if(PhongBenhCtrl.kiemTraPhongBenhCoNguoi(pb.getMaPhong())){
                    cboLoaiPhong.setEnabled(false);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DSPhongBenh.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtMaPhong.setText(pb.getMaPhong());
            txtTenPhong.setText(pb.getTenPhong());
            cboLoaiPhong.setSelectedItem(pb.getMaDonGia() + " " + pb.getLoaiPhong());
            txtSoGiuong.setText(String.valueOf(pb.getSoGiuong()));
            cboYTa.setSelectedItem(pb.getMaYTa() + " " + pb.getTenYTa());

            txtMaPhongBenh.setText(pb.getMaPhong());
            txtPhongBenh.setText(pb.getTenPhong());
            tabelModel2.setRowCount(0);
            try {
                hienThiGiuongBenhTheoMaPhong(pb.getMaPhong());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GiuongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            DialogHelper.showError("Chưa có dòng nào trong table được chọn");
        }
    }//GEN-LAST:event_tblDanhSachPhongBenhMouseClicked

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        // TODO add your handling code here:
        try {
            String tuKhoa = txtTimKiem.getText();
            if (tuKhoa.equals("")) {
                hienThiCacPhongBenh();
            } else {
                hienThiCacPhongBenhTimKiem(tuKhoa);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSPhongBenh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTimKiemKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GSTextField;
    private javax.swing.JButton LamMoiButton;
    private javax.swing.JLabel LoaiPhongLabel;
    private javax.swing.JButton SuaPhongBenhButton;
    private javax.swing.JButton ThemPhongButton;
    private javax.swing.JButton XoaPhongBenhButton;
    private javax.swing.JButton btnCong;
    private javax.swing.JButton btnTru;
    private javax.swing.JComboBox<String> cboLoaiPhong;
    private javax.swing.JComboBox<String> cboYTa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDanhSachGiuongBenh;
    private javax.swing.JTable tblDanhSachPhongBenh;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtMaPhongBenh;
    private javax.swing.JTextField txtPhongBenh;
    private javax.swing.JTextField txtSoGiuong;
    private javax.swing.JTextField txtTenPhong;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
