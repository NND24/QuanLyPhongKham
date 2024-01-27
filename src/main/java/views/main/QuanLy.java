package views.main;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import views.list.DSKhoa;

public class QuanLy extends javax.swing.JFrame {

    public QuanLy() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lypQuanLy = new javax.swing.JLayeredPane();
        tabTiepNhanBenhNhan = new javax.swing.JTabbedPane();
        tiepNhanBenhNhan2 = new views.main.TiepNhanBenhNhan();
        tabQuanLyBenhNhan = new javax.swing.JTabbedPane();
        dSBenhNhan1 = new views.list.DSBenhNhan();
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
        jMenu2 = new javax.swing.JMenu();
        mniQuanLyBenhNhan = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        mniDSKhoa = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setPreferredSize(new java.awt.Dimension(1360, 715));

        lypQuanLy.setBackground(new java.awt.Color(255, 255, 255));
        lypQuanLy.setPreferredSize(new java.awt.Dimension(1674, 800));
        lypQuanLy.setLayout(new java.awt.CardLayout());

        tabTiepNhanBenhNhan.addTab("Tiếp nhận bệnh nhân", tiepNhanBenhNhan2);

        lypQuanLy.add(tabTiepNhanBenhNhan, "card2");

        tabQuanLyBenhNhan.addTab("Quản lý bệnh nhân", dSBenhNhan1);

        lypQuanLy.add(tabQuanLyBenhNhan, "card2");

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
        mniTiepNhanBenhNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mniTiepNhanBenhNhanMouseClicked(evt);
            }
        });
        jMenuBar1.add(mniTiepNhanBenhNhan);

        jMenu2.setText("Khám bệnh");
        jMenuBar1.add(jMenu2);

        mniQuanLyBenhNhan.setText("Quản lý bệnh nhân");
        mniQuanLyBenhNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mniQuanLyBenhNhanMouseClicked(evt);
            }
        });
        jMenuBar1.add(mniQuanLyBenhNhan);

        jMenu5.setText("Quản lý viện phí");
        jMenuBar1.add(jMenu5);

        jMenu10.setText("Quản lý nhân viên");

        jMenuItem1.setText("Danh sách bác sĩ");
        jMenuItem1.setPreferredSize(new java.awt.Dimension(136, 30));
        jMenu10.add(jMenuItem1);

        jMenuItem2.setText("Danh sách y tá");
        jMenuItem2.setPreferredSize(new java.awt.Dimension(125, 30));
        jMenu10.add(jMenuItem2);

        jMenuItem3.setText("Danh sách admin");
        jMenuItem3.setPreferredSize(new java.awt.Dimension(140, 30));
        jMenu10.add(jMenuItem3);

        jMenuBar1.add(jMenu10);

        jMenu7.setText("Quản lý phòng bệnh");

        jMenuItem4.setText("Danh sách phòng bệnh");
        jMenuItem4.setPreferredSize(new java.awt.Dimension(171, 30));
        jMenu7.add(jMenuItem4);

        jMenuItem5.setText("Danh sách đơn giá phòng bệnh");
        jMenuItem5.setPreferredSize(new java.awt.Dimension(214, 30));
        jMenu7.add(jMenuItem5);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Quản lý khám bệnh");

        mniDSKhoa.setText("Danh sách khoa");
        mniDSKhoa.setPreferredSize(new java.awt.Dimension(132, 30));
        mniDSKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDSKhoaActionPerformed(evt);
            }
        });
        jMenu8.add(mniDSKhoa);
        jMenu8.add(jSeparator1);

        jMenuItem6.setText("Danh sách nhóm thuốc");
        jMenuItem6.setPreferredSize(new java.awt.Dimension(172, 30));
        jMenu8.add(jMenuItem6);

        jMenuItem7.setText("Danh sách thuốc");
        jMenuItem7.setPreferredSize(new java.awt.Dimension(137, 30));
        jMenu8.add(jMenuItem7);
        jMenu8.add(jSeparator2);

        jMenuItem8.setText("Danh sách nhóm DV khám bệnh");
        jMenuItem8.setPreferredSize(new java.awt.Dimension(219, 30));
        jMenu8.add(jMenuItem8);

        jMenuItem9.setText("Danh sách DV khám bệnh");
        jMenuItem9.setPreferredSize(new java.awt.Dimension(184, 30));
        jMenu8.add(jMenuItem9);
        jMenu8.add(jSeparator3);

        jMenuItem10.setText("Danh sách nhóm DV cận lâm sàn");
        jMenuItem10.setPreferredSize(new java.awt.Dimension(222, 30));
        jMenu8.add(jMenuItem10);

        jMenuItem11.setText("Danh sách DV cận lâm sàn");
        jMenuItem11.setPreferredSize(new java.awt.Dimension(187, 30));
        jMenu8.add(jMenuItem11);

        jMenuBar1.add(jMenu8);

        jMenu3.setText("Tài khoản cá nhân");
        jMenuBar1.add(jMenu3);

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

    private void mniDSKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDSKhoaActionPerformed
        new DSKhoa().setVisible(true);
        new DSKhoa().setAlwaysOnTop(true);
    }//GEN-LAST:event_mniDSKhoaActionPerformed

    private void mniQuanLyBenhNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mniQuanLyBenhNhanMouseClicked
        lypQuanLy.removeAll();
        lypQuanLy.add(tabQuanLyBenhNhan);
        lypQuanLy.repaint();
        lypQuanLy.revalidate();
    }//GEN-LAST:event_mniQuanLyBenhNhanMouseClicked

    private void mniTiepNhanBenhNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mniTiepNhanBenhNhanMouseClicked
        lypQuanLy.removeAll();
        lypQuanLy.add(tabTiepNhanBenhNhan);
        lypQuanLy.repaint();
        lypQuanLy.revalidate();
    }//GEN-LAST:event_mniTiepNhanBenhNhanMouseClicked

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
    private views.list.DSBenhNhan dSBenhNhan1;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLayeredPane lypQuanLy;
    private javax.swing.JMenuItem mniDSKhoa;
    private javax.swing.JMenu mniQuanLyBenhNhan;
    private javax.swing.JMenu mniTiepNhanBenhNhan;
    private javax.swing.JTabbedPane tabQuanLyBenhNhan;
    private javax.swing.JTabbedPane tabTiepNhanBenhNhan;
    private views.main.TiepNhanBenhNhan tiepNhanBenhNhan2;
    // End of variables declaration//GEN-END:variables

}
