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
import models.YTaModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.GenerateCode;

public class YTaCtrl {

    public static List<YTaModel> timYTaTheoDK(String timKiem, String gioiTinh) throws ClassNotFoundException {
        List<YTaModel> dsyt = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();

            StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM YTA WHERE");
            List<Object> parameters = new ArrayList<>();

            if (!timKiem.isEmpty()) {
                sqlBuilder.append(" (MaYTa LIKE ? OR HoTen LIKE ? OR SoDienThoai LIKE ?)");
                parameters.add("%" + timKiem + "%");
                parameters.add("%" + timKiem + "%");
                parameters.add("%" + timKiem + "%");
            }

            if (!timKiem.isEmpty() && !gioiTinh.equals("Tất cả")) {
                sqlBuilder.append(" AND");
            }

            if (!gioiTinh.equals("Tất cả")) {
                sqlBuilder.append(" GioiTinh LIKE ?");
                parameters.add("%" + gioiTinh + "%");
            }

            statement = connection.prepareStatement(sqlBuilder.toString());

            for (int i = 0; i < parameters.size(); i++) {
                statement.setObject(i + 1, parameters.get(i));
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                YTaModel yt = new YTaModel(
                        resultSet.getString("MaYTa"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getString("DiaChi"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("Email"),
                        resultSet.getString("NamSinh"),
                        resultSet.getString("Anh"));
                dsyt.add(yt);
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

        return dsyt;
    }

    public static List<YTaModel> hienthiYTa() throws ClassNotFoundException {
        List<YTaModel> dsyt = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM YTA";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                YTaModel yt = new YTaModel(
                        resultSet.getString("MaYTa"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getString("DiaChi"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("Email"),
                        resultSet.getString("NamSinh"),
                        resultSet.getString("Anh")
                );
                dsyt.add(yt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(YTaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsyt;
    }

    public static void themYTa(YTaModel yt) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("INSERT INTO YTA(MaYTa, HoTen, GioiTinh, NamSinh, DiaChi, SoDienThoai, CanCuoc, Email, Anh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            String maYTa = GenerateCode.generateMa("YT");
            String matKhau = GenerateCode.generatePassword(maYTa, yt.getNamSinh());
            String email = GenerateCode.generateEmail(maYTa, "nurse");
            TaiKhoanCtrl.themTaiKhoan(email, "YT", matKhau);

            statement.setString(1, maYTa);
            statement.setString(2, yt.getHoTen());
            statement.setString(3, yt.getGioiTinh());
            statement.setString(4, yt.getNamSinh());
            statement.setString(5, yt.getDiaChi());
            statement.setString(6, yt.getSDT());
            statement.setString(7, yt.getCCCD());
            statement.setString(8, email);
            statement.setString(9, yt.getAnh());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(YTaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaYTa(YTaModel yTa) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("DELETE FROM YTA WHERE MaYTa = ?")) {
            statement.setString(1, yTa.getMaYT());
            statement.executeUpdate();
            TaiKhoanCtrl.xoaTaiKhoan(yTa.getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(YTaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatYTa(YTaModel yt) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("UPDATE YTA SET HoTen=?, GioiTinh=?, NamSinh=?, DiaChi=?, SoDienThoai=?, CanCuoc=?  WHERE MaYTa=?")) {

            statement.setString(1, yt.getHoTen());
            statement.setString(2, yt.getGioiTinh());
            statement.setString(3, yt.getNamSinh());
            statement.setString(4, yt.getDiaChi());
            statement.setString(5, yt.getSDT());
            statement.setString(6, yt.getCCCD());
            statement.setString(7, yt.getMaYT());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(YTaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean kiemTraCccdCoTonTai(String cccd) throws ClassNotFoundException {
        boolean flag = false;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM YTA WHERE CanCuoc=?")) {

            statement.setString(1, cccd);
            try (ResultSet resultSet = statement.executeQuery()) {
                flag = resultSet.next();
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraEmailCoTonTai(String email) throws ClassNotFoundException {
        boolean flag = false;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM YTA WHERE Email=?")) {

            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                flag = resultSet.next();
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void exportToExcel(List<YTaModel> dsYTa, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachYTa");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã Bác sĩ");
            headerRow.createCell(1).setCellValue("Tên Bác sĩ");
            headerRow.createCell(2).setCellValue("Giới tính");
            headerRow.createCell(3).setCellValue("Năm sinh");
            headerRow.createCell(4).setCellValue("Địa chỉ");
            headerRow.createCell(5).setCellValue("Số điện thoại");
            headerRow.createCell(6).setCellValue("Căn cước công dân");
            headerRow.createCell(7).setCellValue("Email");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (YTaModel yTa : dsYTa) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(yTa.getMaYT());
                row.createCell(1).setCellValue(yTa.getHoTen());
                row.createCell(2).setCellValue(yTa.getGioiTinh());
                row.createCell(3).setCellValue(yTa.getNamSinh());
                row.createCell(4).setCellValue(yTa.getDiaChi());
                row.createCell(5).setCellValue(yTa.getSDT());
                row.createCell(6).setCellValue(yTa.getCCCD());
                row.createCell(7).setCellValue(yTa.getEmail());
            }

            // Xuất workbook ra file Excel
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean kiemTraYTaCoGiamSatPhong(String maYT) throws ClassNotFoundException {
        boolean flag = false;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM PHONGBENH WHERE MaYTa=?")) {

            statement.setString(1, maYT);
            try (ResultSet resultSet = statement.executeQuery()) {
                flag = resultSet.next();
            }

        } catch (SQLException ex) {
            Logger.getLogger(YTaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
