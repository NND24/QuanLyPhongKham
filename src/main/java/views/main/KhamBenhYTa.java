package views.main;

import java.awt.Color;
import javax.swing.JLabel;

public class KhamBenhYTa extends javax.swing.JPanel {

    public static KhamBenhYTa Instance;

    public JLabel MaBNLabel;
    public JLabel NameLabel;
    public JLabel SexLabel;
    public JLabel MaBALabel;
    public JLabel DateLabel;
    public JLabel RoomLabel;
    public JLabel ServiceLabel;

    public KhamBenhYTa() {
        initComponents();
        Instance = this;
        MaBNLabel = lblMaBenhNhan;
        NameLabel = lblHoTen;
        SexLabel = lblGioiTinh;
        MaBALabel = lblMaBenhAn;
        DateLabel = lblNgayKham;
        RoomLabel = lblPhongKham;
        ServiceLabel = lblDichVuKham;
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
        btnDSBenhAn = new javax.swing.JPanel();
        lblDSBenhAn = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        pnlBenhAn = new views.list.DSBenhAn();
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

        btnDSBenhAn.setBackground(new java.awt.Color(255, 255, 255));
        btnDSBenhAn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDSBenhAn.setPreferredSize(new java.awt.Dimension(100, 40));
        btnDSBenhAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDSBenhAnMouseClicked(evt);
            }
        });

        lblDSBenhAn.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDSBenhAn, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnDSBenhAn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLayeredPane1.setMinimumSize(new java.awt.Dimension(1000, 549));
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1000, 588));
        jLayeredPane1.setLayout(new java.awt.CardLayout());
        jLayeredPane1.add(pnlBenhAn, "card3");

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

        lblBacSi.setText("____________________________");

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

    private void lblMaBenhNhanPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblMaBenhNhanPropertyChange

    }//GEN-LAST:event_lblMaBenhNhanPropertyChange

    private void lblNgayKhamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblNgayKhamPropertyChange

    }//GEN-LAST:event_lblNgayKhamPropertyChange

    private void lblPhongKhamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblPhongKhamPropertyChange

    }//GEN-LAST:event_lblPhongKhamPropertyChange

    private void lblMaBenhAnPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblMaBenhAnPropertyChange

    }//GEN-LAST:event_lblMaBenhAnPropertyChange

    private void btnDSBenhAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDSBenhAnMouseClicked

    }//GEN-LAST:event_btnDSBenhAnMouseClicked

    private void lblDichVuKhamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblDichVuKhamPropertyChange

    }//GEN-LAST:event_lblDichVuKhamPropertyChange

    private void lblDSBenhAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDSBenhAnMouseClicked

    }//GEN-LAST:event_lblDSBenhAnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnDSBenhAn;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel lblDSBenhAn;
    private javax.swing.JLabel lblDichVuKham;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblMaBenhAn;
    private javax.swing.JLabel lblMaBenhNhan;
    private javax.swing.JLabel lblNgayKham;
    private javax.swing.JLabel lblPhongKham;
    private javax.swing.JLabel pkLabel;
    private views.list.DSBenhAn pnlBenhAn;
    // End of variables declaration//GEN-END:variables
}
