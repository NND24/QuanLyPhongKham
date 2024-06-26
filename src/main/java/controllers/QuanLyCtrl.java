package controllers;

import database.ConnectDB;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.QuanLyModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.GenerateCode;

public class QuanLyCtrl {

    public static List<QuanLyModel> hienThiTatCa() throws ClassNotFoundException {
        List<QuanLyModel> dsQuanLy = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM QUANLY WHERE TrangThaiXoa = 0";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                QuanLyModel ql = new QuanLyModel(
                        resultSet.getString("MaQuanLy"),
                        resultSet.getString("Email"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getString("DiaChi"),
                        resultSet.getString("NamSinh"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("Anh"),
                        resultSet.getBoolean("TrangThaiXoa"));
                dsQuanLy.add(ql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsQuanLy;
    }

    public static void themQuanLy(QuanLyModel quanLy) throws ClassNotFoundException {
        if (!TaiKhoanCtrl.kiemTraEmailCoTonTai(quanLy.getEmail())) {
            String sql = "INSERT INTO QUANLY (MaQuanLy, Email, HoTen, GioiTinh, DiaChi, NamSinh, SoDienThoai, CanCuoc, Anh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

                String maQuanLy = GenerateCode.generateMa("QL");
                String email = GenerateCode.generateEmail(maQuanLy, "manager");
                String password = GenerateCode.generatePassword(maQuanLy, quanLy.getNamSinh());

                TaiKhoanCtrl.themTaiKhoan(email, "QL", password);
                statement.setString(1, maQuanLy);
                statement.setString(2, email);
                statement.setString(3, quanLy.getHoTen());
                statement.setString(4, quanLy.getGioiTinh());
                statement.setString(5, quanLy.getDiaChi());
                statement.setString(6, quanLy.getNamSinh());
                statement.setString(7, quanLy.getSoDienThoai());
                statement.setString(8, quanLy.getCanCuoc());
                statement.setString(9, quanLy.getAnh());
                statement.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static boolean kiemTraEmailCoTonTai(String email) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM QUANLY WHERE Email=? AND TrangThaiXoa = 0";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraCanCuocCoTonTai(String canCuoc) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM QUANLY WHERE CanCuoc=? AND TrangThaiXoa=0";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, canCuoc);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraCanCuocCoTonTai_CapNhat(String canCuoc, String maQuanLy) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM QUANLY WHERE CanCuoc=? AND MaQuanLy!=? AND TrangThaiXoa=0";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, canCuoc);
            statement.setString(2, maQuanLy);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void xoaQuanLy(QuanLyModel ql) throws ClassNotFoundException {
        String sql = "UPDATE QUANLY SET TrangThaiXoa=? WHERE MaQuanLy=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, true);
            statement.setString(2, ql.getMaQuanLy());
            statement.executeUpdate();
            TaiKhoanCtrl.xoaTaiKhoan(ql.getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatQuanLy(QuanLyModel ql) throws ClassNotFoundException {
        String sql = "UPDATE QUANLY SET Email=?, HoTen=?, GioiTinh=?, NamSinh=?, DiaChi=?, SoDienThoai=?, CanCuoc=?, Anh=? WHERE MaQuanLy=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, ql.getEmail());
            statement.setString(2, ql.getHoTen());
            statement.setString(3, ql.getGioiTinh());
            statement.setString(4, ql.getNamSinh());
            statement.setString(5, ql.getDiaChi());
            statement.setString(6, ql.getSoDienThoai());
            statement.setString(7, ql.getCanCuoc());
            statement.setString(8, ql.getAnh());
            statement.setString(9, ql.getMaQuanLy());
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<QuanLyModel> timKiemQuanLy(String tuKhoa) throws ClassNotFoundException {
        List<QuanLyModel> ketQua = new ArrayList<>();
        String sql = "SELECT * FROM QUANLY WHERE TrangThaiXoa=0 "
                + "AND(MaQuanLy LIKE ? OR Email LIKE ? OR HoTen LIKE ? OR GioiTinh LIKE ? OR NamSinh LIKE ? OR DiaChi LIKE ? OR SoDienThoai LIKE ? OR CanCuoc LIKE ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            String keyword = "%" + tuKhoa + "%";
            statement.setString(1, keyword);
            statement.setString(2, keyword);
            statement.setString(3, keyword);
            statement.setString(4, keyword);
            statement.setString(5, keyword);
            statement.setString(6, keyword);
            statement.setString(7, keyword);
            statement.setString(8, keyword);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                QuanLyModel ql = new QuanLyModel();
                ql.setMaQuanLy(resultSet.getString("MaQuanLy"));
                ql.setHoTen(resultSet.getString("HoTen"));
                ql.setGioiTinh(resultSet.getString("GioiTinh"));
                ql.setNamSinh(resultSet.getString("NamSinh"));
                ql.setDiaChi(resultSet.getString("DiaChi"));
                ql.setSoDienThoai(resultSet.getString("SoDienThoai"));
                ql.setCanCuoc(resultSet.getString("CanCuoc"));
                ql.setEmail(resultSet.getString("Email"));
                ketQua.add(ql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    public static List<QuanLyModel> sapXepTheoTen_AZ() throws ClassNotFoundException {
        List<QuanLyModel> dsQuanLy = hienThiTatCa();
        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);
        Collections.sort(dsQuanLy, Comparator.comparing(ql -> ql.getHoTen().substring(ql.getHoTen().lastIndexOf(" ") + 1), collator));
        return dsQuanLy;
    }

    public static List<QuanLyModel> sapXepTheoTen_ZA() throws ClassNotFoundException {
        List<QuanLyModel> dsQuanLy = sapXepTheoTen_AZ();
        Collections.reverse(dsQuanLy);
        return dsQuanLy;
    }

    public static List<QuanLyModel> sapXepTheoNamSinh_TangDan() throws ClassNotFoundException {
        List<QuanLyModel> dsQuanLy = hienThiTatCa();
        dsQuanLy.sort(Comparator.comparing(QuanLyModel::getNamSinh));
        return dsQuanLy;
    }

    public static List<QuanLyModel> sapXepTheoNamSinh_GiamDan() throws ClassNotFoundException {
        List<QuanLyModel> dsQuanLy = hienThiTatCa();
        dsQuanLy.sort(Comparator.comparing(QuanLyModel::getNamSinh).reversed());
        return dsQuanLy;
    }
    
     public static void exportToExcel(List<QuanLyModel> dsQuanLy, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachDonGia");

            // Thêm tiêu đề "Danh Sách Khoa"
            Row titleRow = sheet.createRow(0);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("Danh Sách Quản Lý");
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9)); // Merge cells cho tiêu đề

            // Tạo header
            Row headerRow = sheet.createRow(1); // Dòng 1 là dòng header
            headerRow.createCell(0).setCellValue("Mã quản lý");
            headerRow.createCell(1).setCellValue("Họ tên");
            headerRow.createCell(2).setCellValue("Email");
            headerRow.createCell(3).setCellValue("Giới tính");
            headerRow.createCell(4).setCellValue("Địa chỉ");
            headerRow.createCell(5).setCellValue("Năm sinh");
            headerRow.createCell(6).setCellValue("Số điện thoại");
            headerRow.createCell(7).setCellValue("Căn cước");
            // Ghi dữ liệu vào sheet
            int rowNum = 2; // Bắt đầu ghi từ dòng 2
            for (QuanLyModel ql : dsQuanLy) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(ql.getMaQuanLy());
                row.createCell(1).setCellValue(ql.getHoTen());
                row.createCell(2).setCellValue(ql.getEmail());
                row.createCell(3).setCellValue(ql.getGioiTinh());
                row.createCell(4).setCellValue(ql.getDiaChi());
                row.createCell(5).setCellValue(ql.getNamSinh());
                row.createCell(6).setCellValue(ql.getSoDienThoai());
                row.createCell(7).setCellValue(ql.getCanCuoc());
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
