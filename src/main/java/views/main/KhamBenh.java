package views.main;

import java.awt.Color;
import javax.swing.JLabel;

public class KhamBenh extends javax.swing.JPanel {

    public static KhamBenh Instance;

    public JLabel MaBNLabel;
    public JLabel NameLabel;
    public JLabel SexLabel;
    public JLabel MaBALabel;
    public JLabel DateLabel;
    public JLabel RoomLabel;
    public JLabel ServiceLabel;

    public KhamBenh() {
        initComponents();
        Instance = this;
        MaBNLabel = lblMaBenhNhan;
        NameLabel = lblHoTen;
        SexLabel = lblGioiTinh;
        MaBALabel = lblMaBenhAn;
        DateLabel = lblNgayKham;
        RoomLabel = lblPhongKham;
        ServiceLabel = lblDichVuKham;
        btnKhamLamSan.setBackground(new Color(0, 102, 255));
        lblKhamLamSang.setForeground(Color.white);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblMaBenhNhan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnChiDinh = new javax.swing.JPanel();
        lblChiDinh = new javax.swing.JLabel();
        btnKhamLamSan = new javax.swing.JPanel();
        lblKhamLamSang = new javax.swing.JLabel();
        btnChonThuoc = new javax.swing.JPanel();
        lblChonThuoc = new javax.swing.JLabel();
        btnDSBenhAn = new javax.swing.JPanel();
        lblDSBenhAn = new javax.swing.JLabel();
        btnKetQuaCLS = new javax.swing.JPanel();
        lblKetQuaCLS = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        pnlKhamLamSan = new views.main.KhamLamSang();
        pnlChiDinh = new views.main.ChiDinh();
        pnlChonThuoc = new views.main.ChonThuoc();
        pnlBenhAn = new views.list.DSBenhAn();
        pnlKetQuaCLS = new views.main.KetQuaCLS();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pkLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNgayKham = new javax.swing.JLabel();
        lblPhongKham = new javax.swing.JLabel();
        lblMaBenhAn = new javax.swing.JLabel();
        lblDichVuKham = new javax.swing.JLabel();
        lblBacSi = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1360, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin bệnh nhân"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã BN:");

        lblMaBenhNhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaBenhNhan.setText("_______________________");
        lblMaBenhNhan.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblMaBenhNhanPropertyChange(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Họ tên:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Giới tính:");

        lblHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHoTen.setText("_______________________");

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGioiTinh.setText("_______________________");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMaBenhNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(lblHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblMaBenhNhan))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblHoTen))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblGioiTinh))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("KHÁM BỆNH");

        btnChiDinh.setBackground(new java.awt.Color(255, 255, 255));
        btnChiDinh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChiDinh.setPreferredSize(new java.awt.Dimension(100, 40));
        btnChiDinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChiDinhMouseClicked(evt);
            }
        });

        lblChiDinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblChiDinh.setForeground(new java.awt.Color(0, 153, 204));
        lblChiDinh.setText("Chỉ định dịch vụ cận lâm sàng");
        lblChiDinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChiDinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnChiDinhLayout = new javax.swing.GroupLayout(btnChiDinh);
        btnChiDinh.setLayout(btnChiDinhLayout);
        btnChiDinhLayout.setHorizontalGroup(
            btnChiDinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnChiDinhLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblChiDinh)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        btnChiDinhLayout.setVerticalGroup(
            btnChiDinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnChiDinhLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblChiDinh)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        btnKhamLamSan.setBackground(new java.awt.Color(255, 255, 255));
        btnKhamLamSan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKhamLamSan.setPreferredSize(new java.awt.Dimension(100, 40));
        btnKhamLamSan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKhamLamSanMouseClicked(evt);
            }
        });

        lblKhamLamSang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblKhamLamSang.setForeground(new java.awt.Color(0, 153, 255));
        lblKhamLamSang.setText("Khám lâm sàng");
        lblKhamLamSang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhamLamSangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnKhamLamSanLayout = new javax.swing.GroupLayout(btnKhamLamSan);
        btnKhamLamSan.setLayout(btnKhamLamSanLayout);
        btnKhamLamSanLayout.setHorizontalGroup(
            btnKhamLamSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnKhamLamSanLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblKhamLamSang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnKhamLamSanLayout.setVerticalGroup(
            btnKhamLamSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnKhamLamSanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblKhamLamSang)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        btnChonThuoc.setBackground(new java.awt.Color(255, 255, 255));
        btnChonThuoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChonThuoc.setPreferredSize(new java.awt.Dimension(100, 40));
        btnChonThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonThuocMouseClicked(evt);
            }
        });

        lblChonThuoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblChonThuoc.setForeground(new java.awt.Color(0, 153, 204));
        lblChonThuoc.setText("Đơn thuốc");
        lblChonThuoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblChonThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChonThuocMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnChonThuocLayout = new javax.swing.GroupLayout(btnChonThuoc);
        btnChonThuoc.setLayout(btnChonThuocLayout);
        btnChonThuocLayout.setHorizontalGroup(
            btnChonThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnChonThuocLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblChonThuoc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnChonThuocLayout.setVerticalGroup(
            btnChonThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnChonThuocLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblChonThuoc)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        btnDSBenhAn.setBackground(new java.awt.Color(255, 255, 255));
        btnDSBenhAn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDSBenhAn.setPreferredSize(new java.awt.Dimension(100, 40));
        btnDSBenhAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDSBenhAnMouseClicked(evt);
            }
        });

        lblDSBenhAn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDSBenhAn.setForeground(new java.awt.Color(0, 153, 204));
        lblDSBenhAn.setText("Danh sách bệnh án");
        lblDSBenhAn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDSBenhAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDSBenhAnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnDSBenhAnLayout = new javax.swing.GroupLayout(btnDSBenhAn);
        btnDSBenhAn.setLayout(btnDSBenhAnLayout);
        btnDSBenhAnLayout.setHorizontalGroup(
            btnDSBenhAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDSBenhAnLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblDSBenhAn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnDSBenhAnLayout.setVerticalGroup(
            btnDSBenhAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDSBenhAnLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblDSBenhAn)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        btnKetQuaCLS.setBackground(new java.awt.Color(255, 255, 255));
        btnKetQuaCLS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKetQuaCLS.setPreferredSize(new java.awt.Dimension(100, 40));
        btnKetQuaCLS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKetQuaCLSMouseClicked(evt);
            }
        });

        lblKetQuaCLS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblKetQuaCLS.setForeground(new java.awt.Color(0, 153, 204));
        lblKetQuaCLS.setText("Kết quả cận lâm sàng");
        lblKetQuaCLS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKetQuaCLSMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnKetQuaCLSLayout = new javax.swing.GroupLayout(btnKetQuaCLS);
        btnKetQuaCLS.setLayout(btnKetQuaCLSLayout);
        btnKetQuaCLSLayout.setHorizontalGroup(
            btnKetQuaCLSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnKetQuaCLSLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblKetQuaCLS)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        btnKetQuaCLSLayout.setVerticalGroup(
            btnKetQuaCLSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnKetQuaCLSLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblKetQuaCLS)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnKhamLamSan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(btnChiDinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(btnChonThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(btnDSBenhAn, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(btnKetQuaCLS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                .addGap(1, 1, 1))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(btnKhamLamSan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnChiDinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnKetQuaCLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnChonThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnDSBenhAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.setMinimumSize(new java.awt.Dimension(1000, 549));
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1000, 588));
        jLayeredPane1.setLayout(new java.awt.CardLayout());

        pnlKhamLamSan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLayeredPane1.add(pnlKhamLamSan, "card2");
        jLayeredPane1.add(pnlChiDinh, "card4");
        jLayeredPane1.add(pnlChonThuoc, "card5");
        jLayeredPane1.add(pnlBenhAn, "card3");
        jLayeredPane1.add(pnlKetQuaCLS, "card6");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khám bệnh"));
        jPanel9.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã bệnh án:");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Bác sĩ:");

        pkLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pkLabel.setText("Phòng khám:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Ngày khám:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Dịch vụ khám:");

        lblNgayKham.setText("____________________________");
        lblNgayKham.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblNgayKhamPropertyChange(evt);
            }
        });

        lblPhongKham.setText("____________________________");
        lblPhongKham.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblPhongKhamPropertyChange(evt);
            }
        });

        lblMaBenhAn.setText("____________________________");
        lblMaBenhAn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblMaBenhAnPropertyChange(evt);
            }
        });

        lblDichVuKham.setText("____________________________");
        lblDichVuKham.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblDichVuKhamPropertyChange(evt);
            }
        });

        lblBacSi.setText("BS253615 Nguyễn Văn Hưng");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMaBenhAn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(lblNgayKham, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(12, 12, 12)
                        .addComponent(lblDichVuKham, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(pkLabel)
                        .addGap(18, 18, 18)
                        .addComponent(lblPhongKham, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lblBacSi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(258, 258, 258))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaBenhAn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPhongKham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBacSi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pkLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNgayKham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDichVuKham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnKhamLamSanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhamLamSanMouseClicked
        pnlKhamLamSan.setVisible(true);
        pnlChiDinh.setVisible(false);
        pnlChonThuoc.setVisible(false);
        pnlKetQuaCLS.setVisible(false);
        pnlBenhAn.setVisible(false);

        btnKhamLamSan.setBackground(new Color(0, 102, 255));
        lblKhamLamSang.setForeground(Color.white);

        btnChiDinh.setBackground(Color.white);
        lblChiDinh.setForeground(new Color(0, 102, 255));

        btnChonThuoc.setBackground(Color.white);
        lblChonThuoc.setForeground(new Color(0, 102, 255));

        btnDSBenhAn.setBackground(Color.white);
        lblDSBenhAn.setForeground(new Color(0, 102, 255));

        btnKetQuaCLS.setBackground(Color.white);
        lblKetQuaCLS.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_btnKhamLamSanMouseClicked

    private void btnChiDinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChiDinhMouseClicked
        pnlKhamLamSan.setVisible(false);
        pnlChiDinh.setVisible(true);
        pnlChonThuoc.setVisible(false);
        pnlKetQuaCLS.setVisible(false);
        pnlBenhAn.setVisible(false);

        btnChiDinh.setBackground(new Color(0, 102, 255));
        lblChiDinh.setForeground(Color.white);

        btnKhamLamSan.setBackground(Color.white);
        lblKhamLamSang.setForeground(new Color(0, 102, 255));

        btnChonThuoc.setBackground(Color.white);
        lblChonThuoc.setForeground(new Color(0, 102, 255));

        btnDSBenhAn.setBackground(Color.white);
        lblDSBenhAn.setForeground(new Color(0, 102, 255));

        btnKetQuaCLS.setBackground(Color.white);
        lblKetQuaCLS.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_btnChiDinhMouseClicked

    private void btnChonThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonThuocMouseClicked
        pnlKhamLamSan.setVisible(false);
        pnlChiDinh.setVisible(false);
        pnlChonThuoc.setVisible(true);
        pnlKetQuaCLS.setVisible(false);
        pnlBenhAn.setVisible(false);

        btnChonThuoc.setBackground(new Color(0, 102, 255));
        lblChonThuoc.setForeground(Color.white);

        btnKhamLamSan.setBackground(Color.white);
        lblKhamLamSang.setForeground(new Color(0, 102, 255));

        btnChiDinh.setBackground(Color.white);
        lblChiDinh.setForeground(new Color(0, 102, 255));

        btnDSBenhAn.setBackground(Color.white);
        lblDSBenhAn.setForeground(new Color(0, 102, 255));

        btnKetQuaCLS.setBackground(Color.white);
        lblKetQuaCLS.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_btnChonThuocMouseClicked

    private void lblMaBenhNhanPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblMaBenhNhanPropertyChange
        KhamLamSang.Instance.maBenhNhan = lblMaBenhNhan.getText();
        ChiDinh.Instance.maBenhNhan = lblMaBenhNhan.getText();
        ChonThuoc.Instance.maBenhNhan = lblMaBenhNhan.getText();
        KetQuaCLS.Instance.maBenhNhan = lblMaBenhNhan.getText();
    }//GEN-LAST:event_lblMaBenhNhanPropertyChange

    private void lblNgayKhamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblNgayKhamPropertyChange
        KhamLamSang.Instance.ngayKham = lblNgayKham.getText();
    }//GEN-LAST:event_lblNgayKhamPropertyChange

    private void lblPhongKhamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblPhongKhamPropertyChange
        KhamLamSang.Instance.maPhongKham = lblPhongKham.getText();
    }//GEN-LAST:event_lblPhongKhamPropertyChange

    private void lblMaBenhAnPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblMaBenhAnPropertyChange
        KhamLamSang.Instance.maBenhAn = lblMaBenhAn.getText();
        KhamLamSang.Instance.maBacSi = lblBacSi.getText().split(" ")[0];

        ChiDinh.Instance.maBenhAn = lblMaBenhAn.getText();
        ChiDinh.Instance.maBacSi = lblBacSi.getText().split(" ")[0];

        ChonThuoc.Instance.maBenhAn = lblMaBenhAn.getText();
        ChonThuoc.Instance.maBacSi = lblBacSi.getText().split(" ")[0];

        KetQuaCLS.Instance.maBenhAn = lblMaBenhAn.getText();
        KetQuaCLS.Instance.maBacSi = lblBacSi.getText().split(" ")[0];
    }//GEN-LAST:event_lblMaBenhAnPropertyChange

    private void btnDSBenhAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDSBenhAnMouseClicked
        pnlKhamLamSan.setVisible(false);
        pnlChiDinh.setVisible(false);
        pnlChonThuoc.setVisible(false);
        pnlKetQuaCLS.setVisible(false);
        pnlBenhAn.setVisible(true);

        btnDSBenhAn.setBackground(new Color(0, 102, 255));
        lblDSBenhAn.setForeground(Color.white);

        btnKhamLamSan.setBackground(Color.white);
        lblKhamLamSang.setForeground(new Color(0, 102, 255));

        btnChiDinh.setBackground(Color.white);
        lblChiDinh.setForeground(new Color(0, 102, 255));

        btnChonThuoc.setBackground(Color.white);
        lblChonThuoc.setForeground(new Color(0, 102, 255));

        btnKetQuaCLS.setBackground(Color.white);
        lblKetQuaCLS.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_btnDSBenhAnMouseClicked

    private void lblDichVuKhamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblDichVuKhamPropertyChange
        KhamLamSang.Instance.maDichVu = lblDichVuKham.getText();
    }//GEN-LAST:event_lblDichVuKhamPropertyChange

    private void lblKhamLamSangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhamLamSangMouseClicked
        pnlKhamLamSan.setVisible(true);
        pnlChiDinh.setVisible(false);
        pnlChonThuoc.setVisible(false);
        pnlKetQuaCLS.setVisible(false);
        pnlBenhAn.setVisible(false);

        btnKhamLamSan.setBackground(new Color(0, 102, 255));
        lblKhamLamSang.setForeground(Color.white);

        btnChiDinh.setBackground(Color.white);
        lblChiDinh.setForeground(new Color(0, 102, 255));

        btnChonThuoc.setBackground(Color.white);
        lblChonThuoc.setForeground(new Color(0, 102, 255));

        btnDSBenhAn.setBackground(Color.white);
        lblDSBenhAn.setForeground(new Color(0, 102, 255));

        btnKetQuaCLS.setBackground(Color.white);
        lblKetQuaCLS.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_lblKhamLamSangMouseClicked

    private void lblChiDinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChiDinhMouseClicked
        pnlKhamLamSan.setVisible(false);
        pnlChiDinh.setVisible(true);
        pnlChonThuoc.setVisible(false);
        pnlKetQuaCLS.setVisible(false);
        pnlBenhAn.setVisible(false);

        btnChiDinh.setBackground(new Color(0, 102, 255));
        lblChiDinh.setForeground(Color.white);

        btnKhamLamSan.setBackground(Color.white);
        lblKhamLamSang.setForeground(new Color(0, 102, 255));

        btnChonThuoc.setBackground(Color.white);
        lblChonThuoc.setForeground(new Color(0, 102, 255));

        btnDSBenhAn.setBackground(Color.white);
        lblDSBenhAn.setForeground(new Color(0, 102, 255));

        btnKetQuaCLS.setBackground(Color.white);
        lblKetQuaCLS.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_lblChiDinhMouseClicked

    private void lblChonThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChonThuocMouseClicked
        pnlKhamLamSan.setVisible(false);
        pnlChiDinh.setVisible(false);
        pnlChonThuoc.setVisible(true);
        pnlKetQuaCLS.setVisible(false);
        pnlBenhAn.setVisible(false);

        btnChonThuoc.setBackground(new Color(0, 102, 255));
        lblChonThuoc.setForeground(Color.white);

        btnKhamLamSan.setBackground(Color.white);
        lblKhamLamSang.setForeground(new Color(0, 102, 255));

        btnChiDinh.setBackground(Color.white);
        lblChiDinh.setForeground(new Color(0, 102, 255));

        btnDSBenhAn.setBackground(Color.white);
        lblDSBenhAn.setForeground(new Color(0, 102, 255));

        btnKetQuaCLS.setBackground(Color.white);
        lblKetQuaCLS.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_lblChonThuocMouseClicked

    private void lblDSBenhAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDSBenhAnMouseClicked
        pnlKhamLamSan.setVisible(false);
        pnlChiDinh.setVisible(false);
        pnlChonThuoc.setVisible(false);
        pnlKetQuaCLS.setVisible(false);
        pnlBenhAn.setVisible(true);

        btnDSBenhAn.setBackground(new Color(0, 102, 255));
        lblDSBenhAn.setForeground(Color.white);

        btnKhamLamSan.setBackground(Color.white);
        lblKhamLamSang.setForeground(new Color(0, 102, 255));

        btnChiDinh.setBackground(Color.white);
        lblChiDinh.setForeground(new Color(0, 102, 255));

        btnChonThuoc.setBackground(Color.white);
        lblChonThuoc.setForeground(new Color(0, 102, 255));

        btnKetQuaCLS.setBackground(Color.white);
        lblKetQuaCLS.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_lblDSBenhAnMouseClicked

    private void lblKetQuaCLSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKetQuaCLSMouseClicked
        pnlKhamLamSan.setVisible(false);
        pnlChiDinh.setVisible(false);
        pnlChonThuoc.setVisible(false);
        pnlKetQuaCLS.setVisible(true);
        pnlBenhAn.setVisible(false);

        btnKetQuaCLS.setBackground(new Color(0, 102, 255));
        lblKetQuaCLS.setForeground(Color.white);

        btnKhamLamSan.setBackground(Color.white);
        lblKhamLamSang.setForeground(new Color(0, 102, 255));

        btnChiDinh.setBackground(Color.white);
        lblChiDinh.setForeground(new Color(0, 102, 255));

        btnChonThuoc.setBackground(Color.white);
        lblChonThuoc.setForeground(new Color(0, 102, 255));

        btnDSBenhAn.setBackground(Color.white);
        lblDSBenhAn.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_lblKetQuaCLSMouseClicked

    private void btnKetQuaCLSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKetQuaCLSMouseClicked
        pnlKhamLamSan.setVisible(false);
        pnlChiDinh.setVisible(false);
        pnlChonThuoc.setVisible(false);
        pnlKetQuaCLS.setVisible(true);
        pnlBenhAn.setVisible(false);

        btnKetQuaCLS.setBackground(new Color(0, 102, 255));
        lblKetQuaCLS.setForeground(Color.white);

        btnKhamLamSan.setBackground(Color.white);
        lblKhamLamSang.setForeground(new Color(0, 102, 255));

        btnChiDinh.setBackground(Color.white);
        lblChiDinh.setForeground(new Color(0, 102, 255));

        btnChonThuoc.setBackground(Color.white);
        lblChonThuoc.setForeground(new Color(0, 102, 255));

        btnDSBenhAn.setBackground(Color.white);
        lblDSBenhAn.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_btnKetQuaCLSMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnChiDinh;
    private javax.swing.JPanel btnChonThuoc;
    private javax.swing.JPanel btnDSBenhAn;
    private javax.swing.JPanel btnKetQuaCLS;
    private javax.swing.JPanel btnKhamLamSan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblBacSi;
    private javax.swing.JLabel lblChiDinh;
    private javax.swing.JLabel lblChonThuoc;
    private javax.swing.JLabel lblDSBenhAn;
    private javax.swing.JLabel lblDichVuKham;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblKetQuaCLS;
    private javax.swing.JLabel lblKhamLamSang;
    private javax.swing.JLabel lblMaBenhAn;
    private javax.swing.JLabel lblMaBenhNhan;
    private javax.swing.JLabel lblNgayKham;
    private javax.swing.JLabel lblPhongKham;
    private javax.swing.JLabel pkLabel;
    private views.list.DSBenhAn pnlBenhAn;
    private views.main.ChiDinh pnlChiDinh;
    private views.main.ChonThuoc pnlChonThuoc;
    private views.main.KetQuaCLS pnlKetQuaCLS;
    private views.main.KhamLamSang pnlKhamLamSan;
    // End of variables declaration//GEN-END:variables
}
