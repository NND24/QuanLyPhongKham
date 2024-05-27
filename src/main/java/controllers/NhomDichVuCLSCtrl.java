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
import models.NhomDichVuCLSModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NhomDichVuCLSCtrl {

    public static List<NhomDichVuCLSModel> timTatNhomDichVuCLS() throws ClassNotFoundException {
        List<NhomDichVuCLSModel> dsNhomDichVu = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM NHOMDICHVUCLS";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    NhomDichVuCLSModel dvkb = new NhomDichVuCLSModel(
                            resultSet.getString("MaNhomDichVuCLS"),
                            resultSet.getString("TenNhomDichVuCLS"),
                            resultSet.getString("TrangThai"));
                    dsNhomDichVu.add(dvkb);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNhomDichVu;
    }

    public static void themNhomDichVuCLS(NhomDichVuCLSModel dv) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO NHOMDICHVUCLS (MaNhomDichVuCLS, TenNhomDichVuCLS, TrangThai) VALUES (?, ?, ?)")) {
            statement.setString(1, dv.getMaNhomDichVuCLS());
            statement.setString(2, dv.getTenNhomDichVuCLS());
            statement.setString(3, dv.getTrangThai());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatNhomDichVuCLS(NhomDichVuCLSModel dv) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "UPDATE NHOMDICHVUCLS SET TenNhomDichVuCLS=?, TrangThai=? WHERE MaNhomDichVuCLS=?")) {
            statement.setString(1, dv.getTenNhomDichVuCLS());
            statement.setString(2, dv.getTrangThai());
            statement.setString(3, dv.getMaNhomDichVuCLS());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaNhomDichVuCLS(String maNhomDichVu) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM NHOMDICHVUCLS WHERE MaNhomDichVuCLS=?")) {
            statement.setString(1, maNhomDichVu);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<NhomDichVuCLSModel> timTatCaDichVuTheoDK(String timKiem) throws ClassNotFoundException {
        List<NhomDichVuCLSModel> dsNhomDichVu = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM NHOMDICHVUCLS WHERE MaNhomDichVuCLS LIKE ? OR TenNhomDichVuCLS LIKE ?")) {
            statement.setString(1, "%" + timKiem + "%");
            statement.setString(2, "%" + timKiem + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    NhomDichVuCLSModel dvkb = new NhomDichVuCLSModel(
                            resultSet.getString("MaNhomDichVuCLS"),
                            resultSet.getString("TenNhomDichVuCLS"),
                            resultSet.getString("TrangThai"));
                    dsNhomDichVu.add(dvkb);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNhomDichVu;
    }

    public static boolean kiemTraDVTrongNhomDVDaDuocSuDung(String maNhomDichVu) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT 1 FROM CHIDINH
                     JOIN DICHVUCLS ON DICHVUCLS.MaDichVuCLS=CHIDINH.MaDichVuCLS
                     WHERE MaNhomDichVuCLS=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maNhomDichVu);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraMaNhomDVCLSTonTai(String MaNhomDichVuCLS) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT 1 FROM NHOMDICHVUCLS WHERE MaNhomDichVuCLS=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, MaNhomDichVuCLS);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void exportToExcel(List<NhomDichVuCLSModel> dsDichVu, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachNhomDichVuCLS");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("MaNhomDichVuCLS");
            headerRow.createCell(1).setCellValue("TenNhomDichVuCLS");
            headerRow.createCell(2).setCellValue("TrangThai");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (NhomDichVuCLSModel dv : dsDichVu) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(dv.getMaNhomDichVuCLS());
                row.createCell(1).setCellValue(dv.getTenNhomDichVuCLS());
                row.createCell(2).setCellValue(dv.getTrangThai());
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
