package views.main;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import views.list.DSKhoa;

public class YTa extends javax.swing.JFrame {

    public YTa() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lypQuanLy = new javax.swing.JLayeredPane();
        tabTiepNhanBenhNhan = new javax.swing.JTabbedPane();
        tiepNhanBenhNhan2 = new views.main.TiepNhanBenhNhan();
        tabKhamBenh = new javax.swing.JTabbedPane();
        khamBenhYTa1 = new views.main.KhamBenhYTa();
        xepGiuong1 = new views.main.XepGiuong();
        thuTien1 = new views.main.ThuTien();
        tabVienPhi = new javax.swing.JTabbedPane();
        dSThuTien1 = new views.list.DSThuTien();
        header = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        HoTenUserLabel = new javax.swing.JLabel();
        ChucVuUserLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mniTiepNhanBenhNhan = new javax.swing.JMenu();
        mniKhamBenh = new javax.swing.JMenu();
        mniTaiKhoan = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());

        lypQuanLy.setBackground(new java.awt.Color(255, 255, 255));
        lypQuanLy.setPreferredSize(new java.awt.Dimension(1674, 800));
        lypQuanLy.setLayout(new java.awt.CardLayout());

        tabTiepNhanBenhNhan.addTab("Tiếp nhận bệnh nhân", tiepNhanBenhNhan2);

        lypQuanLy.add(tabTiepNhanBenhNhan, "card2");

        tabKhamBenh.addTab("Danh sách bệnh án", khamBenhYTa1);
        tabKhamBenh.addTab("Xếp giường", xepGiuong1);
        tabKhamBenh.addTab("Thu tiền", thuTien1);

        lypQuanLy.add(tabKhamBenh, "card2");

        tabVienPhi.addTab("Danh sách viện phí", dSThuTien1);

        lypQuanLy.add(tabVienPhi, "card2");

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

        mniTiepNhanBenhNhan.setText("Tiếp nhận bệnh nhân");
        mniTiepNhanBenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniTiepNhanBenhNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mniTiepNhanBenhNhanMouseClicked(evt);
            }
        });
        jMenuBar1.add(mniTiepNhanBenhNhan);

        mniKhamBenh.setText("Xếp giường");
        mniKhamBenh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mniKhamBenh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mniKhamBenhMouseClicked(evt);
            }
        });
        jMenuBar1.add(mniKhamBenh);

        mniTaiKhoan.setText("Tài khoản cá nhân");
        mniTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.add(mniTaiKhoan);

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

    private void mniTiepNhanBenhNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mniTiepNhanBenhNhanMouseClicked
        lypQuanLy.removeAll();
        lypQuanLy.add(tabTiepNhanBenhNhan);
        lypQuanLy.repaint();
        lypQuanLy.revalidate();
    }//GEN-LAST:event_mniTiepNhanBenhNhanMouseClicked

    private void mniKhamBenhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mniKhamBenhMouseClicked
        lypQuanLy.removeAll();
        lypQuanLy.add(tabKhamBenh);
        lypQuanLy.repaint();
        lypQuanLy.revalidate();
    }//GEN-LAST:event_mniKhamBenhMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                YTa main = new YTa();

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
    private views.list.DSThuTien dSThuTien1;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private views.main.KhamBenhYTa khamBenhYTa1;
    private javax.swing.JLayeredPane lypQuanLy;
    private javax.swing.JMenu mniKhamBenh;
    private javax.swing.JMenu mniTaiKhoan;
    private javax.swing.JMenu mniTiepNhanBenhNhan;
    private javax.swing.JTabbedPane tabKhamBenh;
    private javax.swing.JTabbedPane tabTiepNhanBenhNhan;
    private javax.swing.JTabbedPane tabVienPhi;
    private views.main.ThuTien thuTien1;
    private views.main.TiepNhanBenhNhan tiepNhanBenhNhan2;
    private views.main.XepGiuong xepGiuong1;
    // End of variables declaration//GEN-END:variables

}
