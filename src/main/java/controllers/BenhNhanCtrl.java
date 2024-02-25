package controllers;

import database.ConnectDB;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.BenhNhanModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BenhNhanCtrl {

    public static List<BenhNhanModel> timTatCaBenhNhan() throws ClassNotFoundException {
        List<BenhNhanModel> dsBenhNhan = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM BENHNHAN";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                if (!resultSet.getBoolean("TrangThaiXoa")) {
                    BenhNhanModel bn = new BenhNhanModel(
                            resultSet.getString("MaBenhNhan"),
                            resultSet.getString("HoTen"),
                            resultSet.getString("GioiTinh"),
                            resultSet.getString("NamSinh"),
                            resultSet.getString("DiaChi"),
                            resultSet.getString("CanCuoc"),
                            resultSet.getString("BHYT"),
                            resultSet.getString("SoDienThoai"),
                            resultSet.getString("ngheNghiep"),
                            resultSet.getString("DanToc"),
                            resultSet.getString("QuocTich")
                    );
                    dsBenhNhan.add(bn);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsBenhNhan;
    }

    public static BenhNhanModel timBenhNhanTheoMa(String maBenhNhan) throws ClassNotFoundException {
        BenhNhanModel benhNhan = null;
        String sql = "SELECT * FROM BENHNHAN WHERE MaBenhNhan=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maBenhNhan);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (!resultSet.getBoolean("TrangThaiXoa")) {
                    BenhNhanModel bn = new BenhNhanModel(
                            resultSet.getString("MaBenhNhan"),
                            resultSet.getString("HoTen"),
                            resultSet.getString("GioiTinh"),
                            resultSet.getString("NamSinh"),
                            resultSet.getString("DiaChi"),
                            resultSet.getString("CanCuoc"),
                            resultSet.getString("BHYT"),
                            resultSet.getString("SoDienThoai"),
                            resultSet.getString("ngheNghiep"),
                            resultSet.getString("DanToc"),
                            resultSet.getString("QuocTich")
                    );
                    benhNhan = bn;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return benhNhan;
    }

    public static List<BenhNhanModel> timBenhNhanTheoDK(String timKiem, String gioiTinh) throws ClassNotFoundException {
        List<BenhNhanModel> dsBenhNhan = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();

            if (!timKiem.isEmpty() && gioiTinh.equals("Tất cả")) {
                String sql = "SELECT * FROM BENHNHAN WHERE MaBenhNhan LIKE ? OR HoTen LIKE ? OR SoDienThoai LIKE ? OR CanCuoc LIKE ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + timKiem + "%");
                statement.setString(2, "%" + timKiem + "%");
                statement.setString(3, "%" + timKiem + "%");
                statement.setString(4, "%" + timKiem + "%");

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    if (resultSet.getInt("TrangThaiXoa") == 0) {
                        BenhNhanModel bn = new BenhNhanModel(
                                resultSet.getString("MaBenhNhan"),
                                resultSet.getString("HoTen"),
                                resultSet.getString("GioiTinh"),
                                resultSet.getString("NamSinh"),
                                resultSet.getString("DiaChi"),
                                resultSet.getString("CanCuoc"),
                                resultSet.getString("BHYT"),
                                resultSet.getString("SoDienThoai"),
                                resultSet.getString("ngheNghiep"),
                                resultSet.getString("DanToc"),
                                resultSet.getString("QuocTich")
                        );
                        dsBenhNhan.add(bn);
                    }
                }
            } else if (timKiem.isEmpty() && !gioiTinh.equals("Tất cả")) {
                String sql = "SELECT * FROM BENHNHAN WHERE GioiTinh LIKE ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + gioiTinh + "%");

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    if (!resultSet.getBoolean("TrangThaiXoa")) {
                        BenhNhanModel bn = new BenhNhanModel(
                                resultSet.getString("MaBenhNhan"),
                                resultSet.getString("HoTen"),
                                resultSet.getString("GioiTinh"),
                                resultSet.getString("NamSinh"),
                                resultSet.getString("DiaChi"),
                                resultSet.getString("CanCuoc"),
                                resultSet.getString("BHYT"),
                                resultSet.getString("SoDienThoai"),
                                resultSet.getString("ngheNghiep"),
                                resultSet.getString("DanToc"),
                                resultSet.getString("QuocTich")
                        );
                        dsBenhNhan.add(bn);
                    }
                }
            } else if (!timKiem.isEmpty() && !gioiTinh.equals("Tất cả")) {
                String sql = "SELECT * FROM BENHNHAN WHERE ( MaBenhNhan LIKE ? OR HoTen LIKE ? OR SoDienThoai LIKE ? OR CanCuoc LIKE ?) AND GioiTinh LIKE ?";
                statement = connection.prepareStatement(sql);
                statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + timKiem + "%");
                statement.setString(2, "%" + timKiem + "%");
                statement.setString(3, "%" + timKiem + "%");
                statement.setString(4, "%" + timKiem + "%");
                statement.setString(5, "%" + gioiTinh + "%");

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    if (!resultSet.getBoolean("TrangThaiXoa")) {
                        BenhNhanModel bn = new BenhNhanModel(
                                resultSet.getString("MaBenhNhan"),
                                resultSet.getString("HoTen"),
                                resultSet.getString("GioiTinh"),
                                resultSet.getString("NamSinh"),
                                resultSet.getString("DiaChi"),
                                resultSet.getString("CanCuoc"),
                                resultSet.getString("BHYT"),
                                resultSet.getString("SoDienThoai"),
                                resultSet.getString("ngheNghiep"),
                                resultSet.getString("DanToc"),
                                resultSet.getString("QuocTich")
                        );
                        dsBenhNhan.add(bn);
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dsBenhNhan;
    }

    public static void themBenhNhan(BenhNhanModel bn) throws ClassNotFoundException {
        String sql = "INSERT INTO BENHNHAN (MaBenhNhan, HoTen, GioiTinh, NamSinh, DiaChi, CanCuoc, SoDienThoai, NgheNghiep, DanToc, BHYT, QuocTich) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, bn.getMaBenhNhan());
            statement.setString(2, bn.getHoTen());
            statement.setString(3, bn.getGioiTinh());
            statement.setString(4, bn.getNamSinh());
            statement.setString(5, bn.getDiaChi());
            statement.setString(6, bn.getCanCuoc());
            statement.setString(7, bn.getSoDienThoai());
            statement.setString(8, bn.getNgheNghiep());
            statement.setString(9, bn.getDanToc());
            statement.setString(10, bn.getBhyt());
            statement.setString(11, bn.getQuocTich());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatBenhNhan(BenhNhanModel bn) throws ClassNotFoundException {
        String sql = "UPDATE BENHNHAN SET HoTen=?, GioiTinh=?, NamSinh=?, DiaChi=?,CanCuoc=?,SoDienThoai=?,NgheNghiep=?,DanToc=?,BHYT=?,QuocTich=? WHERE MaBenhNhan=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, bn.getHoTen());
            statement.setString(2, bn.getGioiTinh());
            statement.setString(3, bn.getNamSinh());
            statement.setString(4, bn.getDiaChi());
            statement.setString(5, bn.getCanCuoc());
            statement.setString(6, bn.getSoDienThoai());
            statement.setString(7, bn.getNgheNghiep());
            statement.setString(8, bn.getDanToc());
            statement.setString(9, bn.getBhyt());
            statement.setString(10, bn.getQuocTich());
            statement.setString(11, bn.getMaBenhNhan());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void XoaBenhNhan(String maBN) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "UPDATE BENHNHAN SET TrangThaiXoa='1' WHERE MaBenhNhan=?")) {

            statement.setString(1, maBN);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xuatFileExcel(List<BenhNhanModel> dsDichVu, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachBenhNhan");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã bệnh nhân");
            headerRow.createCell(1).setCellValue("Họ tên");
            headerRow.createCell(2).setCellValue("Giới tính");
            headerRow.createCell(3).setCellValue("Năm sinh");
            headerRow.createCell(4).setCellValue("Địa chỉ");
            headerRow.createCell(5).setCellValue("Căn cước");
            headerRow.createCell(6).setCellValue("Bảo hiểm y tế");
            headerRow.createCell(7).setCellValue("Số điện thoại");
            headerRow.createCell(8).setCellValue("Nghề nghiệp");
            headerRow.createCell(9).setCellValue("Dân tộc");
            headerRow.createCell(10).setCellValue("Quốc tịch");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (BenhNhanModel bn : dsDichVu) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(bn.getMaBenhNhan());
                row.createCell(1).setCellValue(bn.getHoTen());
                row.createCell(2).setCellValue(bn.getGioiTinh());
                row.createCell(3).setCellValue(bn.getNamSinh());
                row.createCell(4).setCellValue(bn.getDiaChi());
                row.createCell(5).setCellValue(bn.getCanCuoc());
                row.createCell(6).setCellValue(bn.getBhyt());
                row.createCell(7).setCellValue(bn.getSoDienThoai());
                row.createCell(8).setCellValue(bn.getNgheNghiep());
                row.createCell(9).setCellValue(bn.getDanToc());
                row.createCell(10).setCellValue(bn.getQuocTich());
            }

            // Xuất workbook ra file Excel
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean kiemTraCccdCoTonTai(String cccd) throws ClassNotFoundException {
        boolean flag = false;

        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM BENHNHAN WHERE CanCuoc=?")) {

            statement.setString(1, cccd);
            ResultSet resultSet = statement.executeQuery();

            flag = resultSet.next();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTrabHYTCoTonTai(String bhyt, String maBenhNhan) throws ClassNotFoundException {
        boolean flag = false;

        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM BENHNHAN WHERE BHYT=? AND MaBenhNhan!=?")) {

            statement.setString(1, bhyt);
            statement.setString(2, maBenhNhan);
            ResultSet resultSet = statement.executeQuery();

            flag = resultSet.next();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static String generateMaBenhNhan() {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String timeString = dateFormat.format(now);

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String randomString = "BN" + timeString + randomNumber;
        return randomString;
    }
}
