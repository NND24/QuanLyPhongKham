package views.list;

import controllers.YTaCtrl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import models.YTaModel;
import utils.Validator;

public class DSYTa extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    List<YTaModel> dsYTa = new ArrayList<>();

    public DSYTa() {
        try {
            initComponents();
            tableModel = (DefaultTableModel) dsYTaTable.getModel();
            hienThiCacYTa();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSYTa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiCacYTa() throws ClassNotFoundException {
        dsYTa = YTaCtrl.hienthiYTa();
        tableModel.setRowCount(0);

        dsYTa.forEach(yTa -> {
            tableModel.addRow(new Object[]{yTa.getMaYT(), yTa.getHoTen(), yTa.getGioiTinh(),
                yTa.getNgaySinh(), yTa.getCCCD(), yTa.getDiaChi(),
                yTa.getSDT(), yTa.getEmail()});
        });
    }

    private void lamMoi() {
        MaYTaTextField.setText("");
        HoTenTextField.setText("");
        DiaChiTextField.setText("");
        GioiTinhComboBox.setSelectedIndex(0);
        NamSinhTextField.setText(null);
        CCCDTextField.setText("");
        EmailTextField.setText("");
        SDTTextField.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LamMoiButton = new javax.swing.JButton();
        SuaThongTinBacSiButton = new javax.swing.JButton();
        XoaBacSiButton = new javax.swing.JButton();
        ThemBacSiButton = new javax.swing.JButton();
        InButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        MaYTaTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        HoTenTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        GioiTinhComboBox = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        CCCDTextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        SDTTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        EmailTextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        NamSinhTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        DiaChiTextField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        TKGioiTinhComboBox = new javax.swing.JComboBox<>();
        timKiemTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsYTaTable = new javax.swing.JTable();

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
        setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 660));

        jPanel4.setPreferredSize(new java.awt.Dimension(88, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("THÔNG TIN Y TÁ");

        LamMoiButton.setBackground(new java.awt.Color(0, 102, 255));
        LamMoiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LamMoiButton.setForeground(new java.awt.Color(255, 255, 255));
        LamMoiButton.setText("Làm mới");
        LamMoiButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LamMoiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LamMoiButton.setPreferredSize(new java.awt.Dimension(80, 25));
        LamMoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiButtonActionPerformed(evt);
            }
        });

        SuaThongTinBacSiButton.setBackground(new java.awt.Color(0, 102, 255));
        SuaThongTinBacSiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SuaThongTinBacSiButton.setForeground(new java.awt.Color(255, 255, 255));
        SuaThongTinBacSiButton.setText("Sửa thông tin");
        SuaThongTinBacSiButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SuaThongTinBacSiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SuaThongTinBacSiButton.setPreferredSize(new java.awt.Dimension(110, 25));
        SuaThongTinBacSiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaThongTinBacSiButtonActionPerformed(evt);
            }
        });

        XoaBacSiButton.setBackground(new java.awt.Color(0, 102, 255));
        XoaBacSiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        XoaBacSiButton.setForeground(new java.awt.Color(255, 255, 255));
        XoaBacSiButton.setText("Xóa y tá");
        XoaBacSiButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        XoaBacSiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XoaBacSiButton.setPreferredSize(new java.awt.Dimension(80, 25));
        XoaBacSiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaBacSiButtonActionPerformed(evt);
            }
        });

        ThemBacSiButton.setBackground(new java.awt.Color(0, 102, 255));
        ThemBacSiButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ThemBacSiButton.setForeground(new java.awt.Color(255, 255, 255));
        ThemBacSiButton.setText("Thêm y tá");
        ThemBacSiButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ThemBacSiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ThemBacSiButton.setPreferredSize(new java.awt.Dimension(90, 25));
        ThemBacSiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemBacSiButtonActionPerformed(evt);
            }
        });

        InButton.setBackground(new java.awt.Color(0, 102, 255));
        InButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        InButton.setForeground(new java.awt.Color(255, 255, 255));
        InButton.setText("Xuất danh sách");
        InButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        InButton.setPreferredSize(new java.awt.Dimension(120, 25));
        InButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 645, Short.MAX_VALUE)
                .addComponent(ThemBacSiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(XoaBacSiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(SuaThongTinBacSiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(LamMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(InButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LamMoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuaThongTinBacSiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XoaBacSiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThemBacSiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã y tá");

        MaYTaTextField.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Họ tên");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Giới tính");

        GioiTinhComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Căn cước");

        CCCDTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CCCDTextFieldFocusLost(evt);
            }
        });
        CCCDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCCDTextFieldActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Số điện thoại");

        SDTTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SDTTextFieldFocusLost(evt);
            }
        });
        SDTTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SDTTextFieldActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Email");

        EmailTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmailTextFieldFocusLost(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Năm sinh");

        NamSinhTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NamSinhTextFieldFocusLost(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Địa chỉ");

        jPanel8.setPreferredSize(new java.awt.Dimension(199, 35));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("DANH SÁCH Y TÁ");

        TKGioiTinhComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Nam", "Nữ", "Khác" }));
        TKGioiTinhComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TKGioiTinhComboBoxActionPerformed(evt);
            }
        });

        timKiemTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                timKiemTextFieldKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 870, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timKiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(TKGioiTinhComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TKGioiTinhComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timKiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(7, 7, 7))
        );

        dsYTaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã y tá", "Họ tên", "Giới tính", "Năm sinh", "Căn cước", "Địa chỉ", "Số điện thoại", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dsYTaTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dsYTaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dsYTaTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dsYTaTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MaYTaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(41, 41, 41)
                        .addComponent(GioiTinhComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CCCDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel4)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(HoTenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SDTTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NamSinhTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DiaChiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(MaYTaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NamSinhTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(HoTenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(GioiTinhComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SDTTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CCCDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DiaChiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CCCDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCCDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CCCDTextFieldActionPerformed

    private void SDTTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SDTTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SDTTextFieldActionPerformed

    private void ThemBacSiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemBacSiButtonActionPerformed

        try {
            String maYTa = YTaCtrl.generateMaYTa();
            String tenYTa = HoTenTextField.getText();
            String gioiTinh = GioiTinhComboBox.getSelectedItem().toString();
            String diaChi = DiaChiTextField.getText();
            String namSinh = NamSinhTextField.getText();
            String cccd = CCCDTextField.getText();
            String sdt = SDTTextField.getText();
            String email = EmailTextField.getText();

            if (!MaYTaTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Đã có y tá", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (tenYTa.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Họ tên không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (namSinh.isEmpty()) {
                JOptionPane.showMessageDialog(this, "");
                JOptionPane.showMessageDialog(null, "Năm sinh không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (!namSinh.isEmpty() && !Validator.isValidYearOfBirth(namSinh)) {
                JOptionPane.showMessageDialog(null, "Năm sinh không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if (sdt.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (!sdt.isEmpty() && !Validator.isValidPhoneNumber(sdt)) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if (diaChi.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (maYTa.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mã y tá không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (!cccd.isEmpty() && !Validator.isValidCccd(cccd)) {
                JOptionPane.showMessageDialog(null, "Căn cước công dân không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if (YTaCtrl.kiemTraCccdCoTonTai(cccd)) {
                JOptionPane.showMessageDialog(null, "CCCD đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if (!email.isEmpty() && !Validator.isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Email không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if (YTaCtrl.kiemTraEmailCoTonTai(email)) {
                JOptionPane.showMessageDialog(null, "Email đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                YTaModel yTa = new YTaModel(maYTa, tenYTa, gioiTinh, namSinh, diaChi, sdt, cccd, email);

                YTaCtrl.themYTa(yTa);
                hienThiCacYTa();
                lamMoi();
                JOptionPane.showMessageDialog(null, "Thêm y tá thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DSYTa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ThemBacSiButtonActionPerformed

    private void XoaBacSiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaBacSiButtonActionPerformed
        try {
            String maYTa = MaYTaTextField.getText();
            if (maYTa.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Chưa có y tá được chọn", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                if (YTaCtrl.kiemTraYTaCoGiamSatPhong(maYTa)) {
                    JOptionPane.showMessageDialog(null, "Y tá đang giám sát phòng bệnh\nVui lòng chỉnh lại Giám Sát phòng bệnh trước khi xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    String[] options = {"Đồng ý", "Thoát"};
                    int option = JOptionPane.showOptionDialog(
                            null,
                            "Bạn có chắc muốn xóa y tá này",
                            "Cảnh báo",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,
                            options,
                            options[1]
                    );

                    if (option == 0) {
                        YTaCtrl.xoaYTa(maYTa);
                        JOptionPane.showMessageDialog(null, "Xóa y tá thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        lamMoi();
                        hienThiCacYTa();
                    }
                }

            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra", "Thông báo", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DSDichVuCLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_XoaBacSiButtonActionPerformed

    private void SuaThongTinBacSiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaThongTinBacSiButtonActionPerformed

        try {
            String maYTa = MaYTaTextField.getText();
            String tenYTa = HoTenTextField.getText();
            String gioiTinh = GioiTinhComboBox.getSelectedItem().toString();
            String diaChi = DiaChiTextField.getText();
            String namSinh = NamSinhTextField.getText();
            String cccd = CCCDTextField.getText();
            String sdt = SDTTextField.getText();
            String email = EmailTextField.getText();

            if (tenYTa.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Họ tên không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (namSinh.isEmpty()) {
                JOptionPane.showMessageDialog(this, "");
                JOptionPane.showMessageDialog(null, "Năm sinh không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (!namSinh.isEmpty() && !Validator.isValidYearOfBirth(namSinh)) {
                JOptionPane.showMessageDialog(null, "Năm sinh không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if (sdt.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (!sdt.isEmpty() && !Validator.isValidPhoneNumber(sdt)) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if (diaChi.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (maYTa.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mã y tá không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (!cccd.isEmpty() && !Validator.isValidCccd(cccd)) {
                JOptionPane.showMessageDialog(null, "Căn cước công dân không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if (!email.isEmpty() && !Validator.isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Email không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                String[] options = {"Đồng ý", "Thoát"};
                int option = JOptionPane.showOptionDialog(
                        null,
                        "Bạn có chắc sửa thông tin y tá này",
                        "Cảnh báo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        options[1]
                );
                if (option == 0) {
                    YTaModel yTa = new YTaModel(maYTa, tenYTa, gioiTinh, namSinh, diaChi, sdt, cccd, email);
                    YTaCtrl.capNhatYTa(yTa);
                    hienThiCacYTa();
                    lamMoi();
                    JOptionPane.showMessageDialog(null, "Sửa thông tin y tá thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra", "Thông báo", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DSYTa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SuaThongTinBacSiButtonActionPerformed

    private void LamMoiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiButtonActionPerformed
        // TODO add your handling code here:
        lamMoi();
    }//GEN-LAST:event_LamMoiButtonActionPerformed

    private void CCCDTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CCCDTextFieldFocusLost
        String cccd = CCCDTextField.getText();
        if (!cccd.isEmpty() && !Validator.isValidCccd(cccd)) {
            JOptionPane.showMessageDialog(null, "Căn cước công dân không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            CCCDTextField.requestFocus();
        } else try {
            if (YTaCtrl.kiemTraCccdCoTonTai(cccd)) {
                JOptionPane.showMessageDialog(null, "CCCD đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                EmailTextField.requestFocus();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CCCDTextFieldFocusLost

    private void SDTTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SDTTextFieldFocusLost
        String sdt = SDTTextField.getText();
        if (!sdt.isEmpty() && !Validator.isValidPhoneNumber(sdt)) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            SDTTextField.requestFocus();
        }
    }//GEN-LAST:event_SDTTextFieldFocusLost

    private void EmailTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailTextFieldFocusLost
        String email = EmailTextField.getText();
        if (!email.isEmpty() && !Validator.isValidEmail(email)) {
            JOptionPane.showMessageDialog(null, "Email không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            EmailTextField.requestFocus();
        } else try {
            if (YTaCtrl.kiemTraEmailCoTonTai(email)) {
                JOptionPane.showMessageDialog(null, "Email đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                EmailTextField.requestFocus();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EmailTextFieldFocusLost

    private void NamSinhTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NamSinhTextFieldFocusLost
        String namSinh = NamSinhTextField.getText();
        if (!namSinh.isEmpty() && !Validator.isValidYearOfBirth(namSinh)) {
            JOptionPane.showMessageDialog(null, "Năm sinh không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            NamSinhTextField.requestFocus();
        }
    }//GEN-LAST:event_NamSinhTextFieldFocusLost

    private void InButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InButtonActionPerformed
        // TODO add your handling code here:
        try {
            List<YTaModel> dsYTa = YTaCtrl.hienthiYTa();
            YTaCtrl.exportToExcel(dsYTa, "D:\\Workspace Java\\DoAn\\DSYTa.xlsx");
            JOptionPane.showMessageDialog(this, "Xuất file thành công");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSBacSi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_InButtonActionPerformed

    private void timKiemTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timKiemTextFieldKeyTyped
        try {
            String timKiem = timKiemTextField.getText();
            String gioiTinh = TKGioiTinhComboBox.getSelectedItem().toString();

            if (timKiem.equals("")) {
                hienThiCacYTa();
            } else {
                dsYTa = YTaCtrl.timYTaTheoDK(timKiem, gioiTinh);;
                tableModel.setRowCount(0);

                dsYTa.forEach(yTa -> {
                    tableModel.addRow(new Object[]{yTa.getMaYT(), yTa.getHoTen(), yTa.getGioiTinh(),
                        yTa.getNgaySinh(), yTa.getCCCD(), yTa.getDiaChi(),
                        yTa.getSDT(), yTa.getEmail()});
                });
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra", "Thông báo", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DSYTa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_timKiemTextFieldKeyTyped

    private void TKGioiTinhComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TKGioiTinhComboBoxActionPerformed
        try {
            String timKiem = timKiemTextField.getText();
            String gioiTinh = TKGioiTinhComboBox.getSelectedItem().toString();

            if (gioiTinh.equals("Tất cả")) {
                hienThiCacYTa();
            } else {
                dsYTa = YTaCtrl.timYTaTheoDK(timKiem, gioiTinh);

                tableModel.setRowCount(0);

                dsYTa.forEach(yTa -> {
                    tableModel.addRow(new Object[]{yTa.getMaYT(), yTa.getHoTen(), yTa.getGioiTinh(),
                        yTa.getNgaySinh(), yTa.getCCCD(), yTa.getDiaChi(),
                        yTa.getSDT(), yTa.getEmail()});
                });
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra", "Thông báo", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DSYTa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TKGioiTinhComboBoxActionPerformed

    private void dsYTaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsYTaTableMouseClicked
        lamMoi();
        int selectedIndex = dsYTaTable.getSelectedRow();
        if (selectedIndex >= 0) {
            YTaModel yTa = dsYTa.get(selectedIndex);
            MaYTaTextField.setText(yTa.getMaYT());
            HoTenTextField.setText(yTa.getHoTen());
            DiaChiTextField.setText(yTa.getDiaChi());
            NamSinhTextField.setText(yTa.getNgaySinh());
            CCCDTextField.setText(yTa.getCCCD());
            SDTTextField.setText(yTa.getSDT());
            EmailTextField.setText(yTa.getEmail());
            GioiTinhComboBox.setSelectedItem(yTa.getGioiTinh());

        }
    }//GEN-LAST:event_dsYTaTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CCCDTextField;
    private javax.swing.JTextField DiaChiTextField;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JComboBox<String> GioiTinhComboBox;
    private javax.swing.JTextField HoTenTextField;
    private javax.swing.JButton InButton;
    private javax.swing.JButton LamMoiButton;
    private javax.swing.JTextField MaYTaTextField;
    private javax.swing.JTextField NamSinhTextField;
    private javax.swing.JTextField SDTTextField;
    private javax.swing.JButton SuaThongTinBacSiButton;
    private javax.swing.JComboBox<String> TKGioiTinhComboBox;
    private javax.swing.JButton ThemBacSiButton;
    private javax.swing.JButton XoaBacSiButton;
    private javax.swing.JTable dsYTaTable;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField timKiemTextField;
    // End of variables declaration//GEN-END:variables
}
