package controllers;

import database.ConnectDB;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ThuocModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ThuocCtrl {

    public static List<ThuocModel> timTatCaThuoc() throws ClassNotFoundException {
        List<ThuocModel> dsThuoc = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT THUOC.*, NHOMTHUOC.TenNhomThuoc FROM THUOC "
                    + "JOIN NHOMTHUOC ON THUOC.MaNhomThuoc = NHOMTHUOC.MaNhomThuoc  ";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                ThuocModel thuoc = new ThuocModel(
                        resultSet.getString("MaThuoc"), resultSet.getString("TenThuoc"),
                        resultSet.getString("TenHoatChat"), resultSet.getString("MaNhomThuoc"),
                        resultSet.getString("TenNhomThuoc"), resultSet.getString("DuongDung"),
                        resultSet.getString("HamLuong"), resultSet.getString("SoDangKy"),
                        resultSet.getString("DongGoi"), resultSet.getString("DonViTinh"),
                        resultSet.getString("HangSanXuat"), resultSet.getString("NuocSanXuat"),
                        resultSet.getInt("GiaTien"), resultSet.getInt("GiaBaoHiem"),
                        resultSet.getString("TrangThai"));
                dsThuoc.add(thuoc);
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
        return dsThuoc;
    }

    public static ThuocModel timThuocTheoMa(String maThuoc) throws ClassNotFoundException {
        ThuocModel thuoc = null;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM THUOC WHERE MaThuoc = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maThuoc);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ThuocModel t = new ThuocModel(
                        resultSet.getString("MaThuoc"), resultSet.getString("TenThuoc"),
                        resultSet.getString("DuongDung"), resultSet.getInt("GiaTien"),
                        resultSet.getInt("GiaBaoHiem"), resultSet.getString("TrangThai"));
                thuoc = t;
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

        return thuoc;
    }

    public static void themThuoc(ThuocModel thuoc) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO THUOC (MaThuoc, TenThuoc, TenHoatChat, MaNhomThuoc, DuongDung, HamLuong, SoDangKy, DongGoi, DonViTinh, HangSanXuat, NuocSanXuat,GiaTien, GiaBaoHiem, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
            statement = connection.prepareStatement(sql);

            statement.setString(1, thuoc.getMaThuoc());
            statement.setString(2, thuoc.getTenThuoc());
            statement.setString(3, thuoc.getTenHoatChat());
            statement.setString(4, thuoc.getMaNhomThuoc());
            statement.setString(5, thuoc.getDuongDung());
            statement.setString(6, thuoc.getHamLuong());
            statement.setString(7, thuoc.getSoDangKy());
            statement.setString(8, thuoc.getDongGoi());
            statement.setString(9, thuoc.getDonViTinh());
            statement.setString(10, thuoc.getHangSanXuat());
            statement.setString(11, thuoc.getNuocSanXuat());
            statement.setInt(12, thuoc.getGiaTien());
            statement.setInt(13, thuoc.getGiaBHYT());
            statement.setString(14, thuoc.getTrangThai());

            statement.executeUpdate();

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
    }

    public static void capNhatThuoc(ThuocModel thuoc) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE THUOC SET TenThuoc=?, TenHoatChat=?, MaNhomThuoc=?,DuongDung=?,HamLuong=?,SoDangKy=?,DongGoi=?,DonViTinh=?,HangSanXuat=?,NuocSanXuat=?,GiaTien=?,GiaBaoHiem=?,TrangThai=? WHERE MaThuoc=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, thuoc.getTenThuoc());
            statement.setString(2, thuoc.getTenHoatChat());
            statement.setString(3, thuoc.getMaNhomThuoc());
            statement.setString(4, thuoc.getDuongDung());
            statement.setString(5, thuoc.getHamLuong());
            statement.setString(6, thuoc.getSoDangKy());
            statement.setString(7, thuoc.getDongGoi());
            statement.setString(8, thuoc.getDonViTinh());
            statement.setString(9, thuoc.getHangSanXuat());
            statement.setString(10, thuoc.getNuocSanXuat());
            statement.setInt(11, thuoc.getGiaTien());
            statement.setInt(12, thuoc.getGiaBHYT());
            statement.setString(13, thuoc.getTrangThai());
            statement.setString(14, thuoc.getMaThuoc());

            statement.executeUpdate();
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
    }

    public static void xoaThuoc(String maThuoc) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "DELETE FROM THUOC WHERE MaThuoc=?";
            statement = connection.prepareStatement(sql);

            statement.setString(1, maThuoc);

            statement.executeUpdate();

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
    }

    public static List<ThuocModel> timKiemThuoc(String timKiem, String maNhomThuoc) throws ClassNotFoundException {
        List<ThuocModel> dsThuoc = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = """
                         SELECT THUOC.*, NHOMTHUOC.TenNhomThuoc
                         FROM THUOC
                         JOIN NHOMTHUOC ON THUOC.MaNhomThuoc = NHOMTHUOC.MaNhomThuoc
                         WHERE (MaThuoc LIKE ?
                         OR TenThuoc LIKE ?
                         OR THUOC.MaNhomThuoc LIKE ?
                         OR NHOMTHUOC.TenNhomThuoc LIKE ?
                         OR SoDangKy LIKE ?
                         OR HangSanXuat LIKE ?
                         OR NuocSanXuat LIKE ?)""";

            if (!maNhomThuoc.isEmpty()) {
                sql += " AND NHOMTHUOC.MaNhomThuoc = ?";
            }

            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + timKiem + "%");
            statement.setString(2, "%" + timKiem + "%");
            statement.setString(3, "%" + timKiem + "%");
            statement.setString(4, "%" + timKiem + "%");
            statement.setString(5, "%" + timKiem + "%");
            statement.setString(6, "%" + timKiem + "%");
            statement.setString(7, "%" + timKiem + "%");
            if (!maNhomThuoc.isEmpty()) {
                statement.setString(8, maNhomThuoc);
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ThuocModel thuoc = new ThuocModel(
                        resultSet.getString("MaThuoc"), resultSet.getString("TenThuoc"),
                        resultSet.getString("TenHoatChat"), resultSet.getString("MaNhomThuoc"),
                        resultSet.getString("TenNhomThuoc"), resultSet.getString("DuongDung"),
                        resultSet.getString("HamLuong"), resultSet.getString("SoDangKy"),
                        resultSet.getString("DongGoi"), resultSet.getString("DonViTinh"),
                        resultSet.getString("HangSanXuat"), resultSet.getString("NuocSanXuat"),
                        resultSet.getInt("GiaTien"), resultSet.getInt("GiaBaoHiem"),
                        resultSet.getString("TrangThai"));
                dsThuoc.add(thuoc);
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
        return dsThuoc;
    }

    public static boolean kiemTraMaThuocTonTai(String maThuoc) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT 1 FROM THUOC WHERE MaThuoc=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maThuoc);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraThuocDaDuocSuDung(String maThuoc) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT 1 FROM DONTHUOC WHERE MaThuoc=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maThuoc);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void exportToExcel(List<ThuocModel> dsThuoc, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachThuoc");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("MaThuoc");
            headerRow.createCell(1).setCellValue("TenThuoc");
            headerRow.createCell(2).setCellValue("TenHoatChat");
            headerRow.createCell(3).setCellValue("MaNhomThuoc");
            headerRow.createCell(4).setCellValue("TenNhomThuoc");
            headerRow.createCell(5).setCellValue("DuongDung");
            headerRow.createCell(6).setCellValue("HamLuong");
            headerRow.createCell(7).setCellValue("SoDangKy");
            headerRow.createCell(8).setCellValue("DongGoi");
            headerRow.createCell(9).setCellValue("DonViTinh");
            headerRow.createCell(10).setCellValue("HangSanXuat");
            headerRow.createCell(11).setCellValue("NuocSanXuat");
            headerRow.createCell(12).setCellValue("GiaTien");
            headerRow.createCell(13).setCellValue("GiaBaoHiem");
            headerRow.createCell(14).setCellValue("TrangThai");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (ThuocModel thuoc : dsThuoc) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(thuoc.getMaThuoc());
                row.createCell(1).setCellValue(thuoc.getTenThuoc());
                row.createCell(2).setCellValue(thuoc.getTenHoatChat());
                row.createCell(3).setCellValue(thuoc.getMaNhomThuoc());
                row.createCell(4).setCellValue(thuoc.getTenNhomThuoc());
                row.createCell(5).setCellValue(thuoc.getDuongDung());
                row.createCell(6).setCellValue(thuoc.getHamLuong());
                row.createCell(7).setCellValue(thuoc.getSoDangKy());
                row.createCell(8).setCellValue(thuoc.getDongGoi());
                row.createCell(9).setCellValue(thuoc.getDonViTinh());
                row.createCell(10).setCellValue(thuoc.getHangSanXuat());
                row.createCell(11).setCellValue(thuoc.getNuocSanXuat());
                row.createCell(12).setCellValue(thuoc.getGiaTien());
                row.createCell(13).setCellValue(thuoc.getGiaBHYT());
                row.createCell(14).setCellValue(thuoc.getTrangThai());
            }

            // Xuất workbook ra file Excel
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
