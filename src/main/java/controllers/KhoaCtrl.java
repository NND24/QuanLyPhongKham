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
import models.KhoaModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.GenerateCode;

public class KhoaCtrl {

    public static List<KhoaModel> hienThiTatCa() throws ClassNotFoundException {
        List<KhoaModel> dsKhoa = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM KHOA WHERE TrangThaiXoa = 0";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                KhoaModel khoa = new KhoaModel(
                        resultSet.getString("MaKhoa"),
                        resultSet.getString("TenKhoa"),
                        resultSet.getString("TrangThai"));
                dsKhoa.add(khoa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsKhoa;
    }

    public static List<KhoaModel> hienThiCacKhoaConHoatDong() throws ClassNotFoundException {
        List<KhoaModel> dsKhoa = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM KHOA WHERE TrangThaiXoa=0";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                KhoaModel khoa = new KhoaModel(
                        resultSet.getString("MaKhoa"),
                        resultSet.getString("TenKhoa"),
                        resultSet.getString("TrangThai"));
                if (khoa.getTrangThai().equalsIgnoreCase("Kích hoạt")) {
                    dsKhoa.add(khoa);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsKhoa;
    }

    public static void themKhoa(KhoaModel khoa) throws ClassNotFoundException {
        String sql = "INSERT INTO KHOA(MaKhoa, TenKhoa, TrangThai) VALUES (?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            String maKhoa = GenerateCode.generateMa("KH");
            statement.setString(1, maKhoa);
            statement.setString(2, khoa.getTenKhoa());
            statement.setString(3, khoa.getTrangThai());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatKhoa(KhoaModel khoa, String maKhoa) throws ClassNotFoundException {
        String sql = "UPDATE KHOA SET TenKhoa=?, TrangThai=? WHERE MaKhoa=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, khoa.getTenKhoa());
            statement.setString(2, khoa.getTrangThai());
            statement.setString(3, maKhoa);

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaKhoa(String maKhoa) throws ClassNotFoundException {
        String sql = "UPDATE KHOA SET TrangThaiXoa=? WHERE MaKhoa=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, true);
            statement.setString(2, maKhoa);

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean kiemTraKhoaCoBacSi(String maKhoa) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM BACSI WHERE MaKhoa=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maKhoa);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static List<KhoaModel> timKiemKhoa(String tuKhoa) throws ClassNotFoundException {
        List<KhoaModel> ketQua = new ArrayList<>();
        ResultSet resultSet = null;
        String sql = "SELECT * FROM KHOA WHERE (MaKhoa LIKE ? OR TenKhoa LIKE ?) AND TrangThaiXoa = 0";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            String keyword = "%" + tuKhoa + "%";
            statement.setString(1, keyword);
            statement.setString(2, keyword);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maKhoa = resultSet.getString("MaKhoa");
                String tenKhoa = resultSet.getString("TenKhoa");
                String trangThai = resultSet.getString("TrangThai");

                KhoaModel khoa = new KhoaModel(maKhoa, tenKhoa, trangThai);
                ketQua.add(khoa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }
    
    public static void exportToExcel(List<KhoaModel> dsKhoa, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachKhoa");

            // Thêm tiêu đề "Danh Sách Khoa"
            Row titleRow = sheet.createRow(0);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("Danh Sách Khoa");
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9)); // Merge cells cho tiêu đề

            // Tạo header
            Row headerRow = sheet.createRow(1); // Dòng 1 là dòng header
            headerRow.createCell(0).setCellValue("Mã khoa");
            headerRow.createCell(1).setCellValue("Tên khoa");
            headerRow.createCell(2).setCellValue("Trạng thái");

            // Ghi dữ liệu vào sheet
            int rowNum = 2; // Bắt đầu ghi từ dòng 2
            for (KhoaModel kh : dsKhoa) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(kh.getMaKhoa());
                row.createCell(1).setCellValue(kh.getTenKhoa());
                row.createCell(2).setCellValue(kh.getTrangThai());
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
