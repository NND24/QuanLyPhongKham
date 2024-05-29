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
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DonGiaPhongBenhModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Phu Bao
 */
public class DonGiaPhongBenhCtrl {
    public static String generateMaDonGia() {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String timeString = dateFormat.format(now);

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String randomString = "DG" + timeString + randomNumber;
        return randomString;
    }

    public static List<DonGiaPhongBenhModel> hienThiTatCa() throws ClassNotFoundException {
        List<DonGiaPhongBenhModel> dsDichVu = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM DONGIAPHONGBENH WHERE TrangThaiXoa=0";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                DonGiaPhongBenhModel dv = new DonGiaPhongBenhModel(
                        resultSet.getString("MaDonGia"),
                        resultSet.getString("TenLoaiPhong"),
                        resultSet.getInt("DonGia"));
                dsDichVu.add(dv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonGiaPhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDichVu;
    }

    public static void themLoaiPhongBenh(DonGiaPhongBenhModel dg) throws ClassNotFoundException {
        String sql = "INSERT INTO DONGIAPHONGBENH (MaDonGia, TenLoaiPhong, DonGia) VALUES (?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            String maDonGia = generateMaDonGia();
            statement.setString(1, maDonGia);
            statement.setString(2, dg.getTenLoaiPhong());
            statement.setInt(3, dg.getDonGia());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DonGiaPhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean kiemTraTenLoaiPhongCoTonTai(String tenLoaiPhong) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM DONGIAPHONGBENH WHERE TenLoaiPhong=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tenLoaiPhong);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    flag = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonGiaPhongBenhCtrl.class.getName()).log(Level.SEVERE, "Error during database operation", ex);
        }
        return flag;
    }

    public static void capNhatLoaiPhong(DonGiaPhongBenhModel dg) throws ClassNotFoundException {
        String sql = "UPDATE DONGIAPHONGBENH SET TenLoaiPhong=?, DonGia=? WHERE MaDonGia=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, dg.getTenLoaiPhong());
            statement.setInt(2, dg.getDonGia());
            statement.setString(3, dg.getMaDonGia());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DonGiaPhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaLoaiPhong(DonGiaPhongBenhModel dg) throws ClassNotFoundException {
        String sql = "UPDATE DONGIAPHONGBENH SET TrangThaiXoa=? WHERE MaDonGia=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setBoolean(1, true);
            statement.setString(2, dg.getMaDonGia());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DonGiaPhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<DonGiaPhongBenhModel> sapXepTheoGiaTien_TangDan() throws ClassNotFoundException {
        List<DonGiaPhongBenhModel> dsDichVu = hienThiTatCa();
        Collections.sort(dsDichVu, (DonGiaPhongBenhModel donGia1, DonGiaPhongBenhModel donGia2) -> Integer.compare(donGia1.getDonGia(), donGia2.getDonGia()));
        return dsDichVu;
    }

    public static List<DonGiaPhongBenhModel> sapXepTheoGiaTien_GiamDan() throws ClassNotFoundException {
        List<DonGiaPhongBenhModel> dsDichVu = hienThiTatCa();
        Collections.sort(dsDichVu, (DonGiaPhongBenhModel donGia1, DonGiaPhongBenhModel donGia2) -> Integer.compare(donGia2.getDonGia(), donGia1.getDonGia()));
        return dsDichVu;
    }

    public static List<DonGiaPhongBenhModel> sapXepTheoTenLoaiPhong_AZ() throws ClassNotFoundException {
        List<DonGiaPhongBenhModel> dsDichVu = hienThiTatCa();
        Collections.sort(dsDichVu, (DonGiaPhongBenhModel donGia1, DonGiaPhongBenhModel donGia2) -> donGia1.getTenLoaiPhong().compareTo(donGia2.getTenLoaiPhong()));
        return dsDichVu;
    }
    
    public static List<DonGiaPhongBenhModel> sapXepTheoTenLoaiPhong_ZA() throws ClassNotFoundException {
        List<DonGiaPhongBenhModel> dsDichVu = hienThiTatCa();
        Collections.sort(dsDichVu, (DonGiaPhongBenhModel donGia1, DonGiaPhongBenhModel donGia2) -> donGia2.getTenLoaiPhong().compareTo(donGia1.getTenLoaiPhong()));
        return dsDichVu;
    }
    
    public static void exportToExcel(List<DonGiaPhongBenhModel> dsDonGia, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachDonGia");

            // Thêm tiêu đề "Danh Sách Khoa"
            Row titleRow = sheet.createRow(0);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("Danh Sách Đơn Giá");
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9)); // Merge cells cho tiêu đề

            // Tạo header
            Row headerRow = sheet.createRow(1); // Dòng 1 là dòng header
            headerRow.createCell(0).setCellValue("Mã đơn giá");
            headerRow.createCell(1).setCellValue("Tên loại phòng");
            headerRow.createCell(2).setCellValue("Đơn giá");

            // Ghi dữ liệu vào sheet
            int rowNum = 2; // Bắt đầu ghi từ dòng 2
            for (DonGiaPhongBenhModel dg : dsDonGia) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(dg.getMaDonGia());
                row.createCell(1).setCellValue(dg.getTenLoaiPhong());
                row.createCell(2).setCellValue(dg.getDonGia());
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
