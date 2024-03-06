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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.BacSiModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.GenerateCode;

/**
 *
 * @author Phu Bao
 */
public class BacSiCtrl {

    public static List<BacSiModel> hienThiTatCa() throws ClassNotFoundException {
        List<BacSiModel> dsBacSi = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "SELECT BS.MaBacSi, BS.Email, KH.MaKhoa, KH.TenKhoa,BS.HoTen, BS.GioiTinh, "
                    + "BS.NamSinh, BS.DiaChi, BS.SoDienThoai, BS.CanCuoc, BS.TrinhDo, BS.Anh "
                    + "FROM BACSI AS BS, KHOA AS KH WHERE BS.MaKhoa = KH.MaKhoa AND BS.TrangThaiXoa=0";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                BacSiModel bs = new BacSiModel(
                        resultSet.getString("MaBacSi"),
                        resultSet.getString("Email"),
                        resultSet.getString("MaKhoa"),
                        resultSet.getString("TenKhoa"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getString("NamSinh"),
                        resultSet.getString("DiaChi"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("TrinhDo"),
                        resultSet.getString("Anh"));
                dsBacSi.add(bs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsBacSi;
    }

    public static List<BacSiModel> hienThiDanhSachTheoKhoa(String maKhoa) throws ClassNotFoundException {
        List<BacSiModel> dsBacSi = new ArrayList<>();
        String sql = "SELECT BS.MaBacSi, BS.Email, KH.MaKhoa, KH.TenKhoa,BS.HoTen, BS.GioiTinh, "
                + "BS.NamSinh, BS.DiaChi, BS.SoDienThoai, BS.CanCuoc, BS.TrinhDo, BS.Anh "
                + "FROM BACSI AS BS, KHOA AS KH WHERE BS.MaKhoa = KH.MaKhoa AND BS.TrangThaiXoa=0 "
                + "AND BS.MaKhoa = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maKhoa);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BacSiModel bs = new BacSiModel(
                        resultSet.getString("MaBacSi"),
                        resultSet.getString("Email"),
                        resultSet.getString("MaKhoa"),
                        resultSet.getString("TenKhoa"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getString("NamSinh"),
                        resultSet.getString("DiaChi"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("TrinhDo"),
                        resultSet.getString("Anh"));
                dsBacSi.add(bs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsBacSi;
    }

    public static void themBacSi(BacSiModel bacSi) throws ClassNotFoundException {
        String sql = "INSERT INTO BACSI(MaBacSi, Email, MaKhoa, HoTen, GioiTinh, NamSinh, DiaChi, SoDienThoai, CanCuoc, TrinhDo, Anh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            String maBacSi = GenerateCode.generateMa("BS");
            String matKhau = GenerateCode.generatePassword(maBacSi, bacSi.getNamSinh());
            String email = GenerateCode.generateEmail(maBacSi, "doctor");
            TaiKhoanCtrl.themTaiKhoan(email, "BS", matKhau);
            statement.setString(1, maBacSi);
            statement.setString(2, email);
            statement.setString(3, bacSi.getMaKhoa());
            statement.setString(4, bacSi.getHoTen());
            statement.setString(5, bacSi.getGioiTinh());
            statement.setString(6, bacSi.getNamSinh());
            statement.setString(7, bacSi.getDiaChi());
            statement.setString(8, bacSi.getSoDienThoai());
            statement.setString(9, bacSi.getCanCuoc());
            statement.setString(10, bacSi.getTrinhDo());
            statement.setString(11, bacSi.getAnh());
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean kiemTraEmailCoTonTai(String email) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM BACSI WHERE Email=? AND TrangThaiXoa=0";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraCanCuocCoTonTai(String canCuoc) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM BACSI WHERE CanCuoc=? AND TrangThaiXoa=0";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, canCuoc);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraCanCuocCoTonTai_CapNhat(String canCuoc, String maBacSi) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM BACSI WHERE CanCuoc=? AND MaBacSi!=? AND TrangThaiXoa=0";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, canCuoc);
            statement.setString(2, maBacSi);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void capNhatBacSi(BacSiModel bs) throws ClassNotFoundException {
        String sql = "UPDATE BACSI SET MaKhoa=?, HoTen=?, GioiTinh=?, NamSinh=?, DiaChi=?, SoDienThoai=?, CanCuoc=?, TrinhDo=?, Anh=? WHERE MaBacSi=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, bs.getMaKhoa());
            statement.setString(2, bs.getHoTen());
            statement.setString(3, bs.getGioiTinh());
            statement.setString(4, bs.getNamSinh());
            statement.setString(5, bs.getDiaChi());
            statement.setString(6, bs.getSoDienThoai());
            statement.setString(7, bs.getCanCuoc());
            statement.setString(8, bs.getTrinhDo());
            statement.setString(9, bs.getAnh());
            statement.setString(10, bs.getMaBacSi());
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaBacSi(BacSiModel bs) throws ClassNotFoundException {
        String sql = "UPDATE BACSI SET TrangThaiXoa=? WHERE MaBacSi=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, true);
            statement.setString(2, bs.getMaBacSi());
            statement.executeUpdate();
            TaiKhoanCtrl.xoaTaiKhoan(bs.getEmail());

        } catch (SQLException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<BacSiModel> timKiemBacSi(String tuKhoa) throws ClassNotFoundException {
        List<BacSiModel> ketQua = new ArrayList<>();
        String sql = "SELECT MaBacSi, Email, KHOA.MaKhoa, HoTen, GioiTinh, NamSinh, DiaChi, SoDienThoai, CanCuoc, TrinhDo, KHOA.TenKhoa "
                + "FROM BACSI, KHOA WHERE BACSI.MaKhoa = KHOA.MaKhoa AND BacSi.TrangThaiXoa=0 "
                + "AND(MaBacSi LIKE ? OR Email LIKE ? OR KHOA.MaKhoa LIKE ? OR HoTen LIKE ? OR GioiTinh LIKE ? OR NamSinh LIKE ? OR DiaChi LIKE ? OR SoDienThoai LIKE ? OR CanCuoc LIKE ? OR TrinhDo LIKE ? OR TenKhoa LIKE ?)";
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
            statement.setString(9, keyword);
            statement.setString(10, keyword);
            statement.setString(11, keyword);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                BacSiModel bs = new BacSiModel();
                bs.setMaBacSi(resultSet.getString("MaBacSi"));
                bs.setHoTen(resultSet.getString("HoTen"));
                bs.setGioiTinh(resultSet.getString("GioiTinh"));
                bs.setNamSinh(resultSet.getString("NamSinh"));
                bs.setDiaChi(resultSet.getString("DiaChi"));
                bs.setSoDienThoai(resultSet.getString("SoDienThoai"));
                bs.setCanCuoc(resultSet.getString("CanCuoc"));
                bs.setEmail(resultSet.getString("Email"));
                bs.setTrinhDo(resultSet.getString("TrinhDo"));
                bs.setMaKhoa(resultSet.getString("MaKhoa"));
                bs.setTenKhoa(resultSet.getString("TenKhoa"));

                ketQua.add(bs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    public static List<BacSiModel> sapXepTheoTen_AZ() throws ClassNotFoundException {
        List<BacSiModel> dsBacSi = hienThiTatCa();
        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);
        Collections.sort(dsBacSi, Comparator.comparing(bs -> bs.getHoTen().substring(bs.getHoTen().lastIndexOf(" ") + 1), collator));
        return dsBacSi;
    }

    public static List<BacSiModel> sapXepTheoTen_ZA() throws ClassNotFoundException {
        List<BacSiModel> dsBacSi = sapXepTheoTen_AZ();
        Collections.reverse(dsBacSi);
        return dsBacSi;
    }

    public static List<BacSiModel> sapXepTheoNamSinh_TangDan() throws ClassNotFoundException {
        List<BacSiModel> dsBacSi = hienThiTatCa();
        dsBacSi.sort(Comparator.comparing(BacSiModel::getNamSinh));
        return dsBacSi;
    }

    public static List<BacSiModel> sapXepTheoNamSinh_GiamDan() throws ClassNotFoundException {
        List<BacSiModel> dsBacSi = hienThiTatCa();
        dsBacSi.sort(Comparator.comparing(BacSiModel::getNamSinh).reversed());
        return dsBacSi;
    }

    public static void exportToExcel(List<BacSiModel> dsBacSi, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachBacSi");

            // Thêm tiêu đề "Danh Sách Bác Sĩ"
            Row titleRow = sheet.createRow(0);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("Danh Sách Bác Sĩ");
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9)); // Merge cells cho tiêu đề

            // Tạo header
            Row headerRow = sheet.createRow(1); // Dòng 1 là dòng header
            headerRow.createCell(0).setCellValue("Mã Bác sĩ");
            headerRow.createCell(1).setCellValue("Tên Bác sĩ");
            headerRow.createCell(2).setCellValue("Giới tính");
            headerRow.createCell(3).setCellValue("Năm sinh");
            headerRow.createCell(4).setCellValue("Căn cước");
            headerRow.createCell(5).setCellValue("Địa chỉ");
            headerRow.createCell(6).setCellValue("Số điện thoại");
            headerRow.createCell(7).setCellValue("Email");
            headerRow.createCell(8).setCellValue("Trình độ");
            headerRow.createCell(9).setCellValue("Khoa");

            // Ghi dữ liệu vào sheet
            int rowNum = 2; // Bắt đầu ghi từ dòng 2
            for (BacSiModel bs : dsBacSi) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(bs.getMaBacSi());
                row.createCell(1).setCellValue(bs.getHoTen());
                row.createCell(2).setCellValue(bs.getGioiTinh());
                row.createCell(3).setCellValue(bs.getNamSinh());
                row.createCell(4).setCellValue(bs.getCanCuoc());
                row.createCell(5).setCellValue(bs.getDiaChi());
                row.createCell(6).setCellValue(bs.getSoDienThoai());
                row.createCell(7).setCellValue(bs.getEmail());
                row.createCell(8).setCellValue(bs.getTrinhDo());
                row.createCell(9).setCellValue(bs.getTenKhoa());
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
