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
import models.PhongKhamModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PhongKhamCtrl {

    public static List<PhongKhamModel> timTatCaPhongKham() throws ClassNotFoundException {
        List<PhongKhamModel> dsPhongKham = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM PHONGKHAM")) {

            while (resultSet.next()) {
                PhongKhamModel pk = new PhongKhamModel(
                        resultSet.getString("MaPhongKham"),
                        resultSet.getString("TenPhongKham"),
                        resultSet.getString("TrangThai"),
                        resultSet.getInt("SoLuongBenhNhan"));
                dsPhongKham.add(pk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsPhongKham;
    }

    public static void themPhongKham(PhongKhamModel pk) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO PHONGKHAM (MaPhongKham, TenPhongKham, TrangThai, SoLuongBenhNhan) VALUES (?, ?, ?, ?)")) {

            statement.setString(1, pk.getMaPhongKham());
            statement.setString(2, pk.getTenPhongKham());
            statement.setString(3, pk.getTrangThai());
            statement.setInt(4, pk.getSoLuongBenhNhan());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatPhongKham(PhongKhamModel pk) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "UPDATE PHONGKHAM SET TenPhongKham=?, TrangThai=? WHERE MaPhongKham=?")) {

            statement.setString(1, pk.getTenPhongKham());
            statement.setString(2, pk.getTrangThai());
            statement.setString(3, pk.getMaPhongKham());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatLaiSoLuong(String maPhongKham) throws ClassNotFoundException {
        String sql = "UPDATE PHONGKHAM SET SoLuongBenhNhan=0 WHERE MaPhongKham=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maPhongKham);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void themSoLuong(String maPhongKham) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "UPDATE PHONGKHAM SET SoLuongBenhNhan = (CASE WHEN SoLuongBenhNhan + 1 = 51 THEN 0 ELSE SoLuongBenhNhan + 1 END) WHERE MaPhongKham=?")) {
            statement.setString(1, maPhongKham);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaPhongKham(String maPhongKham) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("DELETE FROM PHONGKHAM WHERE MaPhongKham=?")) {
            statement.setString(1, maPhongKham);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<PhongKhamModel> timTatCaDichVuTheoDK(String timKiem) throws ClassNotFoundException {
        List<PhongKhamModel> dsPhongKham = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM PHONGKHAM WHERE MaPhongKham LIKE ? OR TenPhongKham LIKE ?")) {
            statement.setString(1, "%" + timKiem + "%");
            statement.setString(2, "%" + timKiem + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    PhongKhamModel pk = new PhongKhamModel(
                            resultSet.getString("MaPhongKham"),
                            resultSet.getString("TenPhongKham"),
                            resultSet.getString("TrangThai"),
                            resultSet.getInt("SoLuongBenhNhan"));
                    dsPhongKham.add(pk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsPhongKham;
    }

    public static boolean kiemTraPhongKhamDaDuocSuDung(String maPhongKham) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT 1 FROM DANGKY WHERE MaPhongKham=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maPhongKham);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void exportToExcel(List<PhongKhamModel> dsDichVu, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachDichVuKhamBenh");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("MaPhongKham");
            headerRow.createCell(1).setCellValue("TenPhongKham");
            headerRow.createCell(2).setCellValue("TrangThai");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (PhongKhamModel dv : dsDichVu) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(dv.getMaPhongKham());
                row.createCell(1).setCellValue(dv.getTenPhongKham());
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
