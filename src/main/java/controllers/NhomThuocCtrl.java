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
import models.NhomThuocModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NhomThuocCtrl {

    public static List<NhomThuocModel> timTatCaNhomThuoc() throws ClassNotFoundException {
        List<NhomThuocModel> dsNhomThuoc = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM NHOMTHUOC")) {

            while (resultSet.next()) {
                NhomThuocModel nt = new NhomThuocModel(
                        resultSet.getString("MaNhomThuoc"),
                        resultSet.getString("TenNhomThuoc"),
                        resultSet.getString("TrangThai"));
                dsNhomThuoc.add(nt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNhomThuoc;
    }

    public static void themNhomThuoc(NhomThuocModel nt) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO NHOMTHUOC (MaNhomThuoc, TenNhomThuoc, TrangThai) VALUES (?, ?, ?)")) {

            statement.setString(1, nt.getMaNhomThuoc());
            statement.setString(2, nt.getTenNhomThuoc());
            statement.setString(3, nt.getTrangThai());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatNhomThuoc(NhomThuocModel nt) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "UPDATE NHOMTHUOC SET TenNhomThuoc=?, TrangThai=? WHERE MaNhomThuoc=?")) {

            statement.setString(1, nt.getTenNhomThuoc());
            statement.setString(2, nt.getTrangThai());
            statement.setString(3, nt.getMaNhomThuoc());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaNhomThuoc(String maNhomThuoc) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM NHOMTHUOC WHERE MaNhomThuoc=?")) {

            statement.setString(1, maNhomThuoc);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<NhomThuocModel> timNhomThuocTheoDK(String timKiem) throws ClassNotFoundException {
        List<NhomThuocModel> dsNhomThuoc = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM NHOMTHUOC WHERE MaNhomThuoc LIKE ? OR TenNhomThuoc LIKE ?")) {

            statement.setString(1, "%" + timKiem + "%");
            statement.setString(2, "%" + timKiem + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                NhomThuocModel nt = new NhomThuocModel(
                        resultSet.getString("MaNhomThuoc"),
                        resultSet.getString("TenNhomThuoc"),
                        resultSet.getString("TrangThai"));
                dsNhomThuoc.add(nt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsNhomThuoc;
    }

    public static boolean kiemTraThuocTrongNhomThuocDaDuocSuDung(String maNhomThuoc) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT 1 FROM DONTHUOC
                     JOIN THUOC ON THUOC.MaThuoc=DONTHUOC.MaThuoc
                     WHERE MaNhomThuoc=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maNhomThuoc);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraMaNhomThuocTonTai(String maNhomThuoc) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT 1 FROM NHOMTHUOC WHERE MaNhomThuoc=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maNhomThuoc);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void exportToExcel(List<NhomThuocModel> dsNhomThuoc, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachNhomThuoc");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("MaNhomThuoc");
            headerRow.createCell(1).setCellValue("TenNhomThuoc");
            headerRow.createCell(2).setCellValue("TrangThai");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (NhomThuocModel nhomThuoc : dsNhomThuoc) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(nhomThuoc.getMaNhomThuoc());
                row.createCell(1).setCellValue(nhomThuoc.getTenNhomThuoc());
                row.createCell(2).setCellValue(nhomThuoc.getTrangThai());
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
