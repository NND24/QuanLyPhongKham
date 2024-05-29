package views.main;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import models.BenhAnModel;
import models.KhamLamSangModel;
import models.DangKyModel;
import models.BenhNhanModel;
import controllers.BenhAnCtrl;
import controllers.BenhNhanCtrl;
import controllers.DangKyCtrl;
import controllers.KhamLamSangCtrl;
import pdfForm.GenerateKhamLS;
import utils.DialogHelper;
import utils.Validator;

public class KhamLamSang extends javax.swing.JPanel {

    public static KhamLamSang Instance;
    public String maBenhNhan, maPhongKham, maDichVu, maBacSi = "", ngayKham, maBenhAn;
    public JTextField reasonTextField;

    public JTextField heightTextField;
    public JTextField weightTextField;
    public JTextField temperatureTextField;
    public JTextField breathTextField;
    public JTextField pressureTextField1;
    public JTextField pressureTextField2;
    public JTextField circuitTextField;
    public JTextField bmiTextField;
    public JTextField diagnosticTextField;
    public JTextField handleTextField;
    public JTextField mainTextField;
    public JTextField secondaryTextField;
    public JTextField adviceTextField;
    public JTextArea medicalHistoryTextArea;
    public JTextArea antecedentTextArea;
    public JTextArea bodyTextArea;
    public JTextArea partTextArea;
    public JTextArea summaryTextArea;

    public KhamLamSang() {
        initComponents();

        Instance = this;
        reasonTextField = txtLyDoKham;

        heightTextField = txtChieuCao;
        weightTextField = txtCanNang;
        temperatureTextField = txtNhietDo;
        breathTextField = txtNhipTho;
        pressureTextField1 = txtHuyetAp1;
        pressureTextField2 = txtHuyetAp2;
        circuitTextField = txtMach;
        bmiTextField = txtBMI;
        diagnosticTextField = txtChuanDoan;
        handleTextField = txtHuongXuLy;
        mainTextField = txtBenhChinh;
        secondaryTextField = txtBenhPhu;
        adviceTextField = txtLoiDan;
        medicalHistoryTextArea = txaBenhSu;
        antecedentTextArea = txaTienSu;
        bodyTextArea = txaKhamToanThan;
        partTextArea = txaKhamBoPhan;
        summaryTextArea = txaTomTatKetQuanCLS;
    }

    private void nhapMoi() {
        txtChieuCao.setText("");
        txtCanNang.setText("");
        txtNhietDo.setText("");
        txtNhipTho.setText("");
        txtHuyetAp1.setText("0");
        txtHuyetAp2.setText("0");
        txtMach.setText("");
        txtBMI.setText("");
        txtChuanDoan.setText("");
        txtHuongXuLy.setText("");
        txtBenhChinh.setText("");
        txtBenhPhu.setText("");
        txtLoiDan.setText("");
        txaBenhSu.setText("");
        txaTienSu.setText("");
        txaKhamToanThan.setText("");
        txaKhamBoPhan.setText("");
        txaTomTatKetQuanCLS.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnKhamBenh = new javax.swing.JButton();
        btnKetThucKham = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtCanNang = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtChieuCao = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtNhietDo = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtNhipTho = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtHuyetAp1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtHuyetAp2 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtMach = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtBMI = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtLyDoKham = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaBenhSu = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txaKhamToanThan = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txaTienSu = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        txaKhamBoPhan = new javax.swing.JTextArea();
        btnInPhieu = new javax.swing.JButton();
        txtChuanDoan = new javax.swing.JTextField();
        txtHuongXuLy = new javax.swing.JTextField();
        txtBenhChinh = new javax.swing.JTextField();
        txtLoiDan = new javax.swing.JTextField();
        txtBenhPhu = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txaTomTatKetQuanCLS = new javax.swing.JTextArea();
        btnNhapMoi = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1107, 437));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        btnKhamBenh.setBackground(new java.awt.Color(0, 102, 255));
        btnKhamBenh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKhamBenh.setForeground(new java.awt.Color(255, 255, 255));
        btnKhamBenh.setText("Lưu");
        btnKhamBenh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnKhamBenh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKhamBenh.setPreferredSize(new java.awt.Dimension(60, 30));
        btnKhamBenh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhamBenhActionPerformed(evt);
            }
        });

        btnKetThucKham.setBackground(new java.awt.Color(0, 102, 255));
        btnKetThucKham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKetThucKham.setForeground(new java.awt.Color(255, 255, 255));
        btnKetThucKham.setText("Kết thúc khám");
        btnKetThucKham.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnKetThucKham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKetThucKham.setPreferredSize(new java.awt.Dimension(120, 30));
        btnKetThucKham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucKhamActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("Chỉ số");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setText("Cân nặng(kg)");

        txtCanNang.setPreferredSize(new java.awt.Dimension(65, 22));
        txtCanNang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCanNangFocusLost(evt);
            }
        });
        txtCanNang.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtCanNangInputMethodTextChanged(evt);
            }
        });
        txtCanNang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCanNangActionPerformed(evt);
            }
        });
        txtCanNang.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtCanNangPropertyChange(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setText("Chiều cao(cm)");

        txtChieuCao.setPreferredSize(new java.awt.Dimension(65, 22));
        txtChieuCao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtChieuCaoFocusLost(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("Nhiệt độ(oC)");

        txtNhietDo.setPreferredSize(new java.awt.Dimension(65, 22));
        txtNhietDo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNhietDoFocusLost(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("Nhịp thở(l/p)");

        txtNhipTho.setToolTipText("");
        txtNhipTho.setPreferredSize(new java.awt.Dimension(65, 22));
        txtNhipTho.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNhipThoFocusLost(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setText("Huyết áp");

        txtHuyetAp1.setText("0");
        txtHuyetAp1.setMinimumSize(new java.awt.Dimension(50, 22));
        txtHuyetAp1.setPreferredSize(new java.awt.Dimension(50, 22));
        txtHuyetAp1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHuyetAp1FocusLost(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText(" / ");

        txtHuyetAp2.setText("0");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setText("Mạch(l/p)");

        txtMach.setMinimumSize(new java.awt.Dimension(65, 22));
        txtMach.setPreferredSize(new java.awt.Dimension(65, 22));
        txtMach.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMachFocusLost(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setText("BMI");

        txtBMI.setEditable(false);

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel44.setText("Lý do khám");

        txtLyDoKham.setPreferredSize(new java.awt.Dimension(65, 40));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setText("Chuẩn đoán");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setText("ban đầu");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setText("Bệnh chính");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel48.setText("Bệnh phụ");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setText("Hướng xử lý");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setText("Lời dặn của");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel58.setText("bác sĩ");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setText("Bệnh sử");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setText("Tiền sử");

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setText("Khám toàn");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel52.setText("thân");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel53.setText("Khám bộ");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setText("phận");

        txaBenhSu.setColumns(20);
        txaBenhSu.setRows(5);
        txaBenhSu.setPreferredSize(new java.awt.Dimension(230, 85));
        jScrollPane4.setViewportView(txaBenhSu);

        txaKhamToanThan.setColumns(20);
        txaKhamToanThan.setRows(5);
        txaKhamToanThan.setPreferredSize(new java.awt.Dimension(230, 85));
        jScrollPane5.setViewportView(txaKhamToanThan);

        txaTienSu.setColumns(20);
        txaTienSu.setRows(5);
        txaTienSu.setPreferredSize(new java.awt.Dimension(230, 85));
        jScrollPane6.setViewportView(txaTienSu);

        txaKhamBoPhan.setColumns(20);
        txaKhamBoPhan.setRows(5);
        txaKhamBoPhan.setPreferredSize(new java.awt.Dimension(230, 85));
        jScrollPane9.setViewportView(txaKhamBoPhan);

        btnInPhieu.setBackground(new java.awt.Color(0, 102, 255));
        btnInPhieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInPhieu.setForeground(new java.awt.Color(255, 255, 255));
        btnInPhieu.setText("In phiếu khám");
        btnInPhieu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInPhieu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInPhieu.setPreferredSize(new java.awt.Dimension(120, 30));
        btnInPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInPhieuActionPerformed(evt);
            }
        });

        txtChuanDoan.setPreferredSize(new java.awt.Dimension(65, 40));

        txtHuongXuLy.setPreferredSize(new java.awt.Dimension(65, 40));

        txtBenhChinh.setPreferredSize(new java.awt.Dimension(65, 40));

        txtLoiDan.setPreferredSize(new java.awt.Dimension(65, 40));

        txtBenhPhu.setPreferredSize(new java.awt.Dimension(65, 40));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setText("Tóm tắt kết ");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel59.setText("quả CLS");

        txaTomTatKetQuanCLS.setColumns(20);
        txaTomTatKetQuanCLS.setRows(5);
        txaTomTatKetQuanCLS.setPreferredSize(new java.awt.Dimension(230, 85));
        jScrollPane10.setViewportView(txaTomTatKetQuanCLS);

        btnNhapMoi.setBackground(new java.awt.Color(0, 102, 255));
        btnNhapMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhapMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapMoi.setText("Nhập mới");
        btnNhapMoi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNhapMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapMoi.setPreferredSize(new java.awt.Dimension(90, 30));
        btnNhapMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55)
                    .addComponent(jLabel46)
                    .addComponent(jLabel45)
                    .addComponent(jLabel48)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLyDoKham, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtChieuCao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCanNang, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39)
                                    .addComponent(txtNhietDo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel49))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNhipTho, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtHuyetAp1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel18)
                                        .addGap(2, 2, 2)
                                        .addComponent(txtHuyetAp2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMach, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel42))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBMI, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel43)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBenhChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBenhPhu, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel56)
                                    .addComponent(jLabel59)
                                    .addComponent(btnKhamBenh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNhapMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btnKetThucKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btnInPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtChuanDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel50))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHuongXuLy, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLoiDan, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel52)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel54))))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane9))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(txtChieuCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNhietDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHuyetAp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHuyetAp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(txtCanNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNhipTho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLyDoKham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtChuanDoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel46))
                            .addComponent(jLabel50)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel53)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel54))
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel51)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel52))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel55)
                                    .addComponent(txtHuongXuLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel47)
                                    .addComponent(txtBenhChinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel44))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBenhPhu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtLoiDan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnKhamBenh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnNhapMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnKetThucKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnInPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel58))))
                    .addComponent(jLabel48)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel59)))
                .addGap(93, 93, 93))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnKhamBenhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhamBenhActionPerformed
        try {
            if (maBenhAn.isEmpty() || maBenhAn.contains("_")) {
                DialogHelper.showError("Chưa có bệnh án nào được chọn. Vui lòng chọn bệnh án");
            } else if (maBacSi.isEmpty() || maBacSi.contains("_")) {
                DialogHelper.showError("Bác sĩ không được để trống");
            } else if (!maBacSi.contains("BS")) {
                DialogHelper.showError("Người khám phải là bác sĩ");
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                String maKhamLamSang = "";
                BenhAnModel benhAn = BenhAnCtrl.timBenhAn(maBenhAn);

                if (benhAn != null) {
                    maKhamLamSang = benhAn.getMaKhamLamSang();
                }

                String canNang = txtCanNang.getText();
                String chieuCao = txtChieuCao.getText();
                String nhietDo = txtNhietDo.getText();
                String nhipTho = txtNhipTho.getText();
                String huyetAp = txtHuyetAp1.getText() + "/" + txtHuyetAp2.getText();
                String mach = txtMach.getText();
                String BMI = txtBMI.getText();
                String lyDoKham = txtLyDoKham.getText();
                String chuanDoan = txtChuanDoan.getText();
                String benhChinh = txtBenhChinh.getText();
                String benhPhu = txtBenhPhu.getText();
                String huongXuLy = txtHuongXuLy.getText();
                String loiDan = txtLoiDan.getText();
                String benhSu = txaBenhSu.getText();
                String tienSu = txaTienSu.getText();
                String khamToanThan = txaKhamToanThan.getText();
                String khamBoPhan = txaKhamBoPhan.getText();
                String tomTatKetQuaCLS = txaTomTatKetQuanCLS.getText();

                Date date = dateFormat.parse(ngayKham);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                if (!chieuCao.isEmpty() && !Validator.isIntegerString(chieuCao)) {
                    DialogHelper.showError("Chiều cao không hợp lệ");
                    txtChieuCao.requestFocus();
                } else if (!canNang.isEmpty() && !Validator.isDecimalString(canNang)) {
                    DialogHelper.showError("Cân nặng không hợp lệ");
                    txtCanNang.requestFocus();
                } else if (!nhietDo.isEmpty() && !Validator.isDecimalString(nhietDo)) {
                    DialogHelper.showError("Nhiêt độ không hợp lệ");
                    txtNhietDo.requestFocus();
                } else if (!nhipTho.isEmpty() && !Validator.isIntegerString(nhipTho)) {
                    DialogHelper.showError("Nhịp thở không hợp lệ");
                    txtNhipTho.requestFocus();
                } else if ((!txtHuyetAp1.getText().isEmpty() && !Validator.isIntegerString(txtHuyetAp1.getText())) || (!txtHuyetAp2.getText().isEmpty() && !Validator.isIntegerString(txtHuyetAp2.getText()))) {
                    DialogHelper.showError("huyết áp không hợp lệ");
                    txtNhipTho.requestFocus();
                } else if (!mach.isEmpty() && !Validator.isIntegerString(mach)) {
                    DialogHelper.showError("Mạch không hợp lệ");
                    txtMach.requestFocus();
                } else {
                    KhamLamSangModel kls = new KhamLamSangModel(maKhamLamSang, maBacSi.split(" ")[0], sqlDate, canNang, chieuCao, nhietDo, nhipTho, huyetAp, mach, BMI, lyDoKham, chuanDoan, benhChinh, benhPhu, huongXuLy, loiDan, benhSu, tienSu, khamToanThan, khamBoPhan, tomTatKetQuaCLS);
                    KhamLamSangCtrl.capNhatKhamLamSang(kls);
                    DialogHelper.showMessage("Lưu thông tin khám bệnh lâm sàng thành công");
                }
            }
        } catch (ClassNotFoundException | ParseException ex) {
            Logger.getLogger(KhamLamSang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnKhamBenhActionPerformed

    private void btnKetThucKhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucKhamActionPerformed
        if (maBenhAn.isEmpty() || maBenhAn.startsWith("__")) {
            DialogHelper.showError("Chưa có bệnh án nào được chọn. Vui lòng chọn bệnh án");
        } else {
            try {
                BenhAnModel benhAn = BenhAnCtrl.timBenhAn(maBenhAn);
                DangKyModel dangKy = new DangKyModel(benhAn.getMaDangKy(), "Đã khám");
                DangKyCtrl.capNhatTrangThai(dangKy);
                DialogHelper.showMessage("Kết thúc khám bệnh thành công!");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(KhamLamSang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnKetThucKhamActionPerformed

    private void btnInPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInPhieuActionPerformed
        if (maBenhAn.isEmpty() || maBenhAn.startsWith("__")) {
            JOptionPane.showMessageDialog(null, "Chưa có bệnh án nào được chọn. Vui lòng chọn bệnh án", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                BenhNhanModel benhNhan = BenhNhanCtrl.timBenhNhanTheoMa(maBenhNhan);

                BenhAnModel benhAn = BenhAnCtrl.timBenhAn(maBenhAn);

                KhamLamSangModel khamLS = KhamLamSangCtrl.timKhamBenhTheoMa(benhAn.getMaKhamLamSang());

                int namHienTai = LocalDate.now().getYear();
                int thangHienTai = LocalDate.now().getMonthValue();
                int ngayHienTai = LocalDate.now().getDayOfMonth();

                String ten = benhNhan.getHoTen();
                String tuoi = Integer.toString(namHienTai - Integer.parseInt(benhNhan.getNamSinh()));
                String gioiTinh = benhNhan.getGioiTinh();
                String diaChi = benhNhan.getDiaChi();
                String chieuCao = khamLS.getChieuCao();
                String canNang = khamLS.getCanNang();
                String nhietDo = khamLS.getNhietDo();
                String nhipTho = khamLS.getNhipTho();
                String huyetAp = khamLS.getHuyetAp();
                String mach = khamLS.getMach();
                String bmi = khamLS.getBMI();
                String lyDoKham = khamLS.getLyDoKhamBenh();
                String chuanDoan = khamLS.getChuanDoan();
                String huongXuLy = khamLS.getHuongXuLy();
                String benhChinh = khamLS.getBenhChinh();
                String benhPhu = khamLS.getBenhPhu();
                String loiDan = khamLS.getLoiDan();
                String benhSu = khamLS.getBenhSu();
                String tienSu = khamLS.getTienSu();
                String khamToanThan = khamLS.getKhamToanThan();
                String khamBoPhan = khamLS.getKhamBoPhan();
                String tomTatKQ = khamLS.getTomTatKetQuaCLS();

                GenerateKhamLS inDon = new GenerateKhamLS(ten, tuoi, gioiTinh, diaChi, chieuCao, canNang, nhietDo, nhipTho, huyetAp, mach, bmi, lyDoKham, chuanDoan, huongXuLy, benhChinh, benhPhu, loiDan, benhSu, tienSu, khamToanThan, khamBoPhan, tomTatKQ, Integer.toString(ngayHienTai), Integer.toString(thangHienTai), Integer.toString(namHienTai));

                inDon.taoPhieuKham();
                JOptionPane.showMessageDialog(null, "In phiếu khám thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(KhamLamSang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnInPhieuActionPerformed

    private void txtCanNangInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtCanNangInputMethodTextChanged
        String BMI = Integer.toString((Integer.parseInt(txtCanNang.getText())) / (Integer.parseInt(txtCanNang.getText()) ^ 2));
        txtBMI.setText(BMI);
    }//GEN-LAST:event_txtCanNangInputMethodTextChanged

    private void txtCanNangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCanNangActionPerformed
        String BMI = Integer.toString((Integer.parseInt(txtCanNang.getText())) / (Integer.parseInt(txtCanNang.getText()) ^ 2));
        txtBMI.setText(BMI);
    }//GEN-LAST:event_txtCanNangActionPerformed

    private void txtCanNangPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtCanNangPropertyChange
        if (!txtChieuCao.getText().isEmpty()) {
            String BMI = Integer.toString((Integer.parseInt(txtCanNang.getText())) / (Integer.parseInt(txtCanNang.getText()) ^ 2));
            txtBMI.setText(BMI);
        }
    }//GEN-LAST:event_txtCanNangPropertyChange

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if (!txtChieuCao.getText().isEmpty() && !txtCanNang.getText().isEmpty()) {
            double weight = Double.parseDouble(txtCanNang.getText());
            double height = Double.parseDouble(txtChieuCao.getText());
            double BMI = weight / ((height / 100) * (height / 100));
            DecimalFormat df = new DecimalFormat("#.#");
            String formattedBMI = df.format(BMI);
            if (BMI < 18.5) {
                txtBMI.setText(String.valueOf(formattedBMI) + " (Gầy)");
            } else if (BMI < 22.9) {
                txtBMI.setText(String.valueOf(formattedBMI) + " (Bình thường)");
            } else if (BMI < 29.9) {
                txtBMI.setText(String.valueOf(formattedBMI) + " (Thừa cân)");
            } else {
                txtBMI.setText(String.valueOf(formattedBMI) + " Béo phì");
            }
        }
    }//GEN-LAST:event_formMouseMoved

    private void btnNhapMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapMoiActionPerformed
        if (DialogHelper.showConfirmation("Bạn có chắc muốn nhập lại tất cả thông tin")) {
            nhapMoi();
        }
    }//GEN-LAST:event_btnNhapMoiActionPerformed

    private void txtChieuCaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtChieuCaoFocusLost
        String chieuCao = txtChieuCao.getText();
        if (!chieuCao.isEmpty() && !Validator.isIntegerString(chieuCao)) {
            DialogHelper.showError("Chiều cao không hợp lệ");
            txtChieuCao.requestFocus();
        }
    }//GEN-LAST:event_txtChieuCaoFocusLost

    private void txtCanNangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCanNangFocusLost
        String canNang = txtCanNang.getText();
        if (!canNang.isEmpty() && !Validator.isDecimalString(canNang)) {
            DialogHelper.showError("Cân nặng không hợp lệ");
            txtCanNang.requestFocus();
        }
    }//GEN-LAST:event_txtCanNangFocusLost

    private void txtNhietDoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNhietDoFocusLost
        String nhietDo = txtNhietDo.getText();
        if (!nhietDo.isEmpty() && !Validator.isDecimalString(nhietDo)) {
            DialogHelper.showError("Nhiêt độ không hợp lệ");
            txtNhietDo.requestFocus();
        }
    }//GEN-LAST:event_txtNhietDoFocusLost

    private void txtNhipThoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNhipThoFocusLost
        String nhipTho = txtNhipTho.getText();
        if (!nhipTho.isEmpty() && !Validator.isIntegerString(nhipTho)) {
            DialogHelper.showError("Nhịp thở không hợp lệ");
            txtNhipTho.requestFocus();
        }
    }//GEN-LAST:event_txtNhipThoFocusLost

    private void txtHuyetAp1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHuyetAp1FocusLost
        String huyetAp1 = txtHuyetAp1.getText();
        String huyetAp2 = txtHuyetAp2.getText();
        if ((!huyetAp1.isEmpty() && !Validator.isIntegerString(huyetAp1)) || (!huyetAp2.isEmpty() && !Validator.isIntegerString(huyetAp2))) {
            DialogHelper.showError("huyết áp không hợp lệ");
            txtNhipTho.requestFocus();
        }
    }//GEN-LAST:event_txtHuyetAp1FocusLost

    private void txtMachFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMachFocusLost
        String mach = txtMach.getText();
        if (!mach.isEmpty() && !Validator.isIntegerString(mach)) {
            DialogHelper.showError("Mạch không hợp lệ");
            txtMach.requestFocus();
        }
    }//GEN-LAST:event_txtMachFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInPhieu;
    private javax.swing.JButton btnKetThucKham;
    private javax.swing.JButton btnKhamBenh;
    private javax.swing.JButton btnNhapMoi;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea txaBenhSu;
    private javax.swing.JTextArea txaKhamBoPhan;
    private javax.swing.JTextArea txaKhamToanThan;
    private javax.swing.JTextArea txaTienSu;
    private javax.swing.JTextArea txaTomTatKetQuanCLS;
    private javax.swing.JTextField txtBMI;
    private javax.swing.JTextField txtBenhChinh;
    private javax.swing.JTextField txtBenhPhu;
    private javax.swing.JTextField txtCanNang;
    private javax.swing.JTextField txtChieuCao;
    private javax.swing.JTextField txtChuanDoan;
    private javax.swing.JTextField txtHuongXuLy;
    private javax.swing.JTextField txtHuyetAp1;
    private javax.swing.JTextField txtHuyetAp2;
    private javax.swing.JTextField txtLoiDan;
    private javax.swing.JTextField txtLyDoKham;
    private javax.swing.JTextField txtMach;
    private javax.swing.JTextField txtNhietDo;
    private javax.swing.JTextField txtNhipTho;
    // End of variables declaration//GEN-END:variables
}
