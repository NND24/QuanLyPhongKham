package controllers;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DichVuCLSModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class DichVuCLSCtrl {

    public static List<DichVuCLSModel> timTatCaDichVu() throws ClassNotFoundException {
        List<DichVuCLSModel> dsDichVu = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "SELECT MaDichVuCLS, TenDichVuCLS, DICHVUCLS.MaNhomDichVuCLS, TenNhomDichVuCLS, GiaTien, GiaBaoHiem, DICHVUCLS.TrangThai "
                    + "FROM DICHVUCLS, NHOMDICHVUCLS WHERE DICHVUCLS.MaNhomDichVuCLS=NHOMDICHVUCLS.MaNhomDichVuCLS";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    DichVuCLSModel dv = new DichVuCLSModel(
                            resultSet.getString("MaDichVuCLS"),
                            resultSet.getString("TenDichVuCLS"),
                            resultSet.getString("MaNhomDichVuCLS"),
                            resultSet.getString("TenNhomDichVuCLS"),
                            resultSet.getInt("GiaTien"),
                            resultSet.getInt("GiaBaoHiem"),
                            resultSet.getString("TrangThai"));
                    dsDichVu.add(dv);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDichVu;
    }

    public static List<DichVuCLSModel> timTatCaDichVuTheoMaNhom(String maNhomDichVu) throws ClassNotFoundException {
        List<DichVuCLSModel> dsDichVu = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT MaDichVuCLS, TenDichVuCLS, DICHVUCLS.MaNhomDichVuCLS, TenNhomDichVuCLS, GiaTien, GiaBaoHiem, DICHVUCLS.TrangThai "
                + "FROM DICHVUCLS, NHOMDICHVUCLS WHERE DICHVUCLS.MaNhomDichVuCLS=NHOMDICHVUCLS.MaNhomDichVuCLS AND DICHVUCLS.MaNhomDichVuCLS=?")) {

            statement.setString(1, maNhomDichVu);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    DichVuCLSModel dv = new DichVuCLSModel(
                            resultSet.getString("MaDichVuCLS"),
                            resultSet.getString("TenDichVuCLS"),
                            resultSet.getString("MaNhomDichVuCLS"),
                            resultSet.getString("TenNhomDichVuCLS"),
                            resultSet.getInt("GiaTien"),
                            resultSet.getInt("GiaBaoHiem"),
                            resultSet.getString("TrangThai"));
                    dsDichVu.add(dv);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDichVu;
    }

    public static List<DichVuCLSModel> timTatCaDichVuTheoDK(String timKiem, String maNhomDichVu) throws ClassNotFoundException {
        List<DichVuCLSModel> dsDichVu = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection()) {
            String sql = """
                     SELECT MaDichVuCLS, TenDichVuCLS, DICHVUCLS.MaNhomDichVuCLS, TenNhomDichVuCLS, GiaTien, GiaBaoHiem, DICHVUCLS.TrangThai
                     FROM DICHVUCLS, NHOMDICHVUCLS
                     WHERE DICHVUCLS.MaNhomDichVuCLS=NHOMDICHVUCLS.MaNhomDichVuCLS""";

            if (!timKiem.isEmpty() && maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                sql += " AND (MaDichVuCLS LIKE ? OR TenDichVuCLS LIKE ? OR DICHVUCLS.MaNhomDichVuCLS LIKE ? OR TenNhomDichVuCLS LIKE ?)";
            } else if (timKiem.isEmpty() && !maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                sql += " AND DICHVUCLS.MaNhomDichVuCLS = ?";
            } else if (!timKiem.isEmpty() && !maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                sql += " AND (MaDichVuCLS LIKE ? OR TenDichVuCLS LIKE ? OR DICHVUCLS.MaNhomDichVuCLS LIKE ? OR TenNhomDichVuCLS LIKE ?) AND DICHVUCLS.MaNhomDichVuCLS = ?";
            }

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                int paramIndex = 1;
                if (!timKiem.isEmpty() && maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                    statement.setString(paramIndex++, "%" + timKiem + "%");
                    statement.setString(paramIndex++, "%" + timKiem + "%");
                    statement.setString(paramIndex++, "%" + timKiem + "%");
                    statement.setString(paramIndex++, "%" + timKiem + "%");
                } else if (timKiem.isEmpty() && !maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                    statement.setString(paramIndex++, maNhomDichVu);
                } else if (!timKiem.isEmpty() && !maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                    statement.setString(paramIndex++, "%" + timKiem + "%");
                    statement.setString(paramIndex++, "%" + timKiem + "%");
                    statement.setString(paramIndex++, "%" + timKiem + "%");
                    statement.setString(paramIndex++, "%" + timKiem + "%");
                    statement.setString(paramIndex++, maNhomDichVu);
                }

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        DichVuCLSModel dv = new DichVuCLSModel(
                                resultSet.getString("MaDichVuCLS"),
                                resultSet.getString("TenDichVuCLS"),
                                resultSet.getString("MaNhomDichVuCLS"),
                                resultSet.getString("TenNhomDichVuCLS"),
                                resultSet.getInt("GiaTien"),
                                resultSet.getInt("GiaBaoHiem"),
                                resultSet.getString("TrangThai"));
                        dsDichVu.add(dv);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDichVu;
    }

    public static DichVuCLSModel timDichVuTheoMa(String MaDichVuCLS) throws ClassNotFoundException {
        DichVuCLSModel dichVu = null;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT MaDichVuCLS, TenDichVuCLS, DICHVUCLS.MaNhomDichVuCLS, TenNhomDichVuCLS, GiaTien, GiaBaoHiem, DICHVUCLS.TrangThai "
                + "FROM DICHVUCLS, NHOMDICHVUCLS WHERE DICHVUCLS.MaNhomDichVuCLS=NHOMDICHVUCLS.MaNhomDichVuCLS AND DICHVUCLS.MaDichVuCLS=?")) {
            statement.setString(1, MaDichVuCLS);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    dichVu = new DichVuCLSModel(
                            resultSet.getString("MaDichVuCLS"),
                            resultSet.getString("TenDichVuCLS"),
                            resultSet.getString("MaNhomDichVuCLS"),
                            resultSet.getString("TenNhomDichVuCLS"),
                            resultSet.getInt("GiaTien"),
                            resultSet.getInt("GiaBaoHiem"),
                            resultSet.getString("TrangThai"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dichVu;
    }

    public static void themDichVuCLS(DichVuCLSModel dv) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("INSERT INTO DICHVUCLS (MaDichVuCLS, TenDichVuCLS, MaNhomDichVuCLS, GiaTien, GiaBaoHiem, TrangThai) VALUES (?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, dv.getMaDichVuCLS());
            statement.setString(2, dv.getTenDichVuCLS());
            statement.setString(3, dv.getMaNhomDichVuCLS());
            statement.setInt(4, dv.getGiaTien());
            statement.setInt(5, dv.getGiaBaoHiem());
            statement.setString(6, dv.getTrangThai());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatDichVuCLS(DichVuCLSModel dv) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("UPDATE DICHVUCLS SET TenDichVuCLS=?, MaNhomDichVuCLS=?, GiaTien=?, GiaBaoHiem=?, TrangThai=? WHERE MaDichVuCLS=?")) {

            statement.setString(1, dv.getTenDichVuCLS());
            statement.setString(2, dv.getMaNhomDichVuCLS());
            statement.setInt(3, dv.getGiaTien());
            statement.setInt(4, dv.getGiaBaoHiem());
            statement.setString(5, dv.getTrangThai());
            statement.setString(6, dv.getMaDichVuCLS());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaDichVuCLS(String MaDichVuCLS) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("DELETE FROM DICHVUCLS WHERE MaDichVuCLS=?")) {

            statement.setString(1, MaDichVuCLS);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean kiemTraMaDVCLSTonTai(String maDichVuCLS) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT 1 FROM DICHVUCLS WHERE MaDichVuCLS=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maDichVuCLS);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraDVDaDuocSuDung(String maDichVu) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT 1 FROM CHIDINH
                     WHERE MaDichVuCLS=?
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

    public static void exportToExcel(List<DichVuCLSModel> dsDichVu, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachDichVuCLS");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("MaDichVuCLS");
            headerRow.createCell(1).setCellValue("TenDichVuCLS");
            headerRow.createCell(2).setCellValue("MaNhomDichVuCLS");
            headerRow.createCell(3).setCellValue("TenNhomDichVuCLS");
            headerRow.createCell(4).setCellValue("GiaTien");
            headerRow.createCell(5).setCellValue("GiaBaoHiem");
            headerRow.createCell(6).setCellValue("TrangThai");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (DichVuCLSModel dv : dsDichVu) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(dv.getMaDichVuCLS());
                row.createCell(1).setCellValue(dv.getTenDichVuCLS());
                row.createCell(2).setCellValue(dv.getMaNhomDichVuCLS());
                row.createCell(3).setCellValue(dv.getTenNhomDichVuCLS());
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
