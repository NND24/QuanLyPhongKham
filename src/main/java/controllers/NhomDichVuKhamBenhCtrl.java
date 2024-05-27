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
import models.NhomDichVuKhamBenhModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NhomDichVuKhamBenhCtrl {

    public static List<NhomDichVuKhamBenhModel> timTatNhomDichVuKhamBenh() throws ClassNotFoundException {
        List<NhomDichVuKhamBenhModel> dsNhomDichVuKhamBenh = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM NHOMDICHVUKB")) {
            while (resultSet.next()) {
                NhomDichVuKhamBenhModel dvkb = new NhomDichVuKhamBenhModel(
                        resultSet.getString("MaNhomDichVuKB"),
                        resultSet.getString("TenNhomDichVuKB"),
                        resultSet.getString("TrangThai"));
                dsNhomDichVuKhamBenh.add(dvkb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNhomDichVuKhamBenh;
    }

    public static void themNhomDichVuKhamBenh(NhomDichVuKhamBenhModel dvkb) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("INSERT INTO NHOMDICHVUKB (MaNhomDichVuKB, TenNhomDichVuKB, TrangThai) VALUES (?, ?, ?)")) {
            statement.setString(1, dvkb.getMaNhomDichVuKB());
            statement.setString(2, dvkb.getTenNhomDichVuKB());
            statement.setString(3, dvkb.getTrangThai());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatNhomDichVuKhamBenh(NhomDichVuKhamBenhModel dvkb) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("UPDATE NHOMDICHVUKB SET TenNhomDichVuKB=?, TrangThai=? WHERE MaNhomDichVuKB=?")) {

            statement.setString(1, dvkb.getTenNhomDichVuKB());
            statement.setString(2, dvkb.getTrangThai());
            statement.setString(3, dvkb.getMaNhomDichVuKB());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaNhomDichVuKhamBenh(String maNhomDichVu) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("DELETE FROM NHOMDICHVUKB WHERE MaNhomDichVuKB=?")) {

            statement.setString(1, maNhomDichVu);

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<NhomDichVuKhamBenhModel> timTatCaDichVuTheoDK(String timKiem) throws ClassNotFoundException {
        List<NhomDichVuKhamBenhModel> dsNhomDichVu = new ArrayList<>();
        String sql = "SELECT * FROM NHOMDICHVUKB WHERE MaNhomDichVuKB LIKE ? OR TenNhomDichVuKB LIKE ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + timKiem + "%");
            statement.setString(2, "%" + timKiem + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    NhomDichVuKhamBenhModel dvkb = new NhomDichVuKhamBenhModel(
                            resultSet.getString("MaNhomDichVuKB"),
                            resultSet.getString("TenNhomDichVuKB"),
                            resultSet.getString("TrangThai"));
                    dsNhomDichVu.add(dvkb);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNhomDichVu;
    }

    public static NhomDichVuKhamBenhModel timNhomDichVuTheoMaDichVu(String maDichVu) throws ClassNotFoundException {
        NhomDichVuKhamBenhModel dichVuKB = null;
        String sql = """
                     SELECT NHOMDICHVUKB.MaNhomDichVuKB, TenNhomDichVuKB, NHOMDICHVUKB.TrangThai FROM NHOMDICHVUKB
                     JOIN DICHVUKB ON DICHVUKB.MaNhomDichVuKB=NHOMDICHVUKB.MaNhomDichVuKB
                     WHERE MaDichVuKB=? """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maDichVu);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    NhomDichVuKhamBenhModel dvkb = new NhomDichVuKhamBenhModel(
                            resultSet.getString("MaNhomDichVuKB"),
                            resultSet.getString("TenNhomDichVuKB"),
                            resultSet.getString("TrangThai"));
                    dichVuKB = dvkb;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dichVuKB;
    }

    public static boolean kiemTraMaNhomDVKBTonTai(String MaNhomDichVuKB) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT 1 FROM NHOMDICHVUKB WHERE MaNhomDichVuKB=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, MaNhomDichVuKB);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraDVTrongNhomDVDaDuocSuDung(String maNhomDichVu) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT 1 FROM DANGKY
                     JOIN DICHVUKB ON DICHVUKB.MaDichVuKB=DANGKY.MaDichVuKB
                     WHERE MaNhomDichVuKB=?
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

    public static void exportToExcel(List<NhomDichVuKhamBenhModel> dsDichVu, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachNhomDichVuKhamBenh");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("MaNhomDichVuKB");
            headerRow.createCell(1).setCellValue("TenNhomDichVuKB");
            headerRow.createCell(2).setCellValue("TrangThai");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (NhomDichVuKhamBenhModel dv : dsDichVu) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(dv.getMaNhomDichVuKB());
                row.createCell(1).setCellValue(dv.getTenNhomDichVuKB());
                row.createCell(2).setCellValue(dv.getMaNhomDichVuKB());
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
