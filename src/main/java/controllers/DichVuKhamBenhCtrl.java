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
import models.DichVuKhamBenhModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DichVuKhamBenhCtrl {

    public static List<DichVuKhamBenhModel> timTatCaDichVu() throws ClassNotFoundException {
        List<DichVuKhamBenhModel> dsDichVu = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = "SELECT MaDichVuKB, TenDichVuKB, DICHVUKB.MaNhomDichVuKB, TenNhomDichVuKB, GiaTien, GiaBaoHiem, DICHVUKB.TrangThai "
                    + "FROM DICHVUKB, NHOMDICHVUKB WHERE DICHVUKB.MaNhomDichVuKB=NHOMDICHVUKB.MaNhomDichVuKB";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                DichVuKhamBenhModel dv = new DichVuKhamBenhModel(
                        resultSet.getString("MaDichVuKB"),
                        resultSet.getString("TenDichVuKB"),
                        resultSet.getInt("GiaTien"),
                        resultSet.getInt("GiaBaoHiem"),
                        resultSet.getString("TrangThai"),
                        resultSet.getString("MaNhomDichVuKB"),
                        resultSet.getString("TenNhomDichVuKB"));
                dsDichVu.add(dv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDichVu;
    }

    public static List<DichVuKhamBenhModel> timTatCaDichVuTheoMaNhom(String maNhomDichVu) throws ClassNotFoundException {
        List<DichVuKhamBenhModel> dsDichVu = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT MaDichVuKB, TenDichVuKB, DICHVUKB.MaNhomDichVuKB, TenNhomDichVuKB, GiaTien, GiaBaoHiem, DICHVUKB.TrangThai FROM DICHVUKB, NHOMDICHVUKB WHERE DICHVUKB.MaNhomDichVuKB=NHOMDICHVUKB.MaNhomDichVuKB AND DICHVUKB.MaNhomDichVuKB=?")) {

            statement.setString(1, maNhomDichVu);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DichVuKhamBenhModel dv = new DichVuKhamBenhModel(
                        resultSet.getString("MaDichVuKB"),
                        resultSet.getString("TenDichVuKB"),
                        resultSet.getInt("GiaTien"),
                        resultSet.getInt("GiaBaoHiem"),
                        resultSet.getString("TrangThai"),
                        resultSet.getString("MaNhomDichVuKB"),
                        resultSet.getString("TenNhomDichVuKB"));
                dsDichVu.add(dv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDichVu;
    }

    public static void themDichVuKhamBenh(DichVuKhamBenhModel dv) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("INSERT INTO DICHVUKB (MaDichVuKB, TenDichVuKB, MaNhomDichVuKB, GiaTien, GiaBaoHiem, TrangThai) VALUES (?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, dv.getMaDichVuKB());
            statement.setString(2, dv.getTenDichVuKB());
            statement.setString(3, dv.getMaNhomDichVuKB());
            statement.setInt(4, dv.getGiaTien());
            statement.setInt(5, dv.getGiaBaoHiem());
            statement.setString(6, dv.getTrangThai());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatDichVuKhamBenh(DichVuKhamBenhModel dv) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("UPDATE DICHVUKB SET TenDichVuKB=?, MaNhomDichVuKB=?, GiaTien=?, GiaBaoHiem=?, TrangThai=? WHERE MaDichVuKB=?")) {

            statement.setString(1, dv.getTenDichVuKB());
            statement.setString(2, dv.getMaNhomDichVuKB());
            statement.setInt(3, dv.getGiaTien());
            statement.setInt(4, dv.getGiaBaoHiem());
            statement.setString(5, dv.getTrangThai());
            statement.setString(6, dv.getMaDichVuKB());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaDichVuKhamBenh(String maDichVu) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("DELETE FROM DICHVUKB WHERE MaDichVuKB=?")) {

            statement.setString(1, maDichVu);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<DichVuKhamBenhModel> timTatCaDichVuTheoDK(String timKiem, String maNhomDichVu) throws ClassNotFoundException {
        List<DichVuKhamBenhModel> dsDichVu = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection()) {
            String sql = "SELECT MaDichVuKB, TenDichVuKB, DICHVUKB.MaNhomDichVuKB, TenNhomDichVuKB, GiaTien, GiaBaoHiem, DICHVUKB.TrangThai "
                    + "FROM DICHVUKB, NHOMDICHVUKB WHERE DICHVUKB.MaNhomDichVuKB=NHOMDICHVUKB.MaNhomDichVuKB ";

            if (!timKiem.isEmpty() && !maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                sql += " AND (MaDichVuKB LIKE ? OR TenDichVuKB LIKE ? OR DICHVUKB.MaNhomDichVuKB LIKE ? OR TenNhomDichVuKB LIKE ?) AND DICHVUKB.MaNhomDichVuKB = ?";
            } else if (!timKiem.isEmpty() && maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                sql += " AND (MaDichVuKB LIKE ? OR TenDichVuKB LIKE ? OR DICHVUKB.MaNhomDichVuKB LIKE ? OR TenNhomDichVuKB LIKE ?)";
            } else if (timKiem.isEmpty() && !maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                sql += " AND DICHVUKB.MaNhomDichVuKB = ?";
            }

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                if (!timKiem.isEmpty() && !maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                    statement.setString(1, "%" + timKiem + "%");
                    statement.setString(2, "%" + timKiem + "%");
                    statement.setString(3, "%" + timKiem + "%");
                    statement.setString(4, "%" + timKiem + "%");
                    statement.setString(5, maNhomDichVu);
                } else if (!timKiem.isEmpty() && maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                    statement.setString(1, "%" + timKiem + "%");
                    statement.setString(2, "%" + timKiem + "%");
                    statement.setString(3, "%" + timKiem + "%");
                    statement.setString(4, "%" + timKiem + "%");
                } else if (timKiem.isEmpty() && !maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                    statement.setString(1, maNhomDichVu);
                }

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        DichVuKhamBenhModel dv = new DichVuKhamBenhModel(
                                resultSet.getString("MaDichVuKB"),
                                resultSet.getString("TenDichVuKB"),
                                resultSet.getInt("GiaTien"),
                                resultSet.getInt("GiaBaoHiem"),
                                resultSet.getString("TrangThai"),
                                resultSet.getString("MaNhomDichVuKB"),
                                resultSet.getString("TenNhomDichVuKB"));
                        dsDichVu.add(dv);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDichVu;
    }

    public static boolean kiemTraDVDaDuocSuDung(String maDichVu) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT 1 FROM DANGKY
                     WHERE MaDichVuKB=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maDichVu);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void exportToExcel(List<DichVuKhamBenhModel> dsDichVu, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachDichVuKhamBenh");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("MaDichVuKB");
            headerRow.createCell(1).setCellValue("TenDichVuKB");
            headerRow.createCell(2).setCellValue("MaNhomDichVuKB");
            headerRow.createCell(3).setCellValue("TenNhomDichVuKB");
            headerRow.createCell(4).setCellValue("GiaTien");
            headerRow.createCell(5).setCellValue("GiaBaoHiem");
            headerRow.createCell(6).setCellValue("TrangThai");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (DichVuKhamBenhModel dv : dsDichVu) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(dv.getMaDichVuKB());
                row.createCell(1).setCellValue(dv.getTenDichVuKB());
                row.createCell(2).setCellValue(dv.getMaNhomDichVuKB());
                row.createCell(3).setCellValue(dv.getTenNhomDichVuKB());
                row.createCell(4).setCellValue(dv.getGiaTien());
                row.createCell(5).setCellValue(dv.getGiaBaoHiem());
                row.createCell(6).setCellValue(dv.getTrangThai());
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
