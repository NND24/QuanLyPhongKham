package controllers;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.GiuongBenhModel;
import models.PhongBenhModel;

/**
 *
 * @author Phu Bao
 */
public class GiuongBenhCtrl {

    public static String generateMaGiuong() {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String timeString = dateFormat.format(now);

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String randomString = "GN" + timeString + randomNumber;
        return randomString;
    }

    public static List<GiuongBenhModel> hienThiTatCa() throws ClassNotFoundException {
        List<GiuongBenhModel> dsGiuongBenh = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "SELECT GB.MaGiuong, PB.MaPhong, PB.TenPhong, DG.TenLoaiPhong, DG.DonGia, GB.CoNguoi "
                    + "FROM GIUONGBENH AS GB JOIN PHONGBENH AS PB "
                    + "ON GB.MaPhong = PB.MaPhong "
                    + "JOIN DONGIAPHONGBENH AS DG ON PB.MaDonGia = DG.MaDonGia "
                    + "WHERE PB.TrangThaiXoa=0 AND GB.TrangThaiXoa = 0 "
                    + "ORDER BY PB.TenPhong";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                GiuongBenhModel gb = new GiuongBenhModel(
                        resultSet.getString("MaGiuong"),
                        resultSet.getString("MaPhong"),
                        resultSet.getString("TenPhong"),
                        resultSet.getString("TenLoaiPhong"),
                        resultSet.getString("CoNguoi"),
                        resultSet.getInt("DonGia"));
                dsGiuongBenh.add(gb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiuongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsGiuongBenh;
    }

    public static List<GiuongBenhModel> hienThiTheoMaPhong(String maPhong) throws ClassNotFoundException {
        List<GiuongBenhModel> dsGiuongBenh = new ArrayList<>();
        String sql = "SELECT GB.MaGiuong, PB.MaPhong, PB.TenPhong, DG.TenLoaiPhong, DG.DonGia, GB.CoNguoi "
                + "FROM GIUONGBENH AS GB JOIN PHONGBENH AS PB "
                + "ON GB.MaPhong = PB.MaPhong "
                + "JOIN DONGIAPHONGBENH AS DG ON PB.MaDonGia = DG.MaDonGia "
                + "WHERE PB.TrangThaiXoa=0 AND GB.TrangThaiXoa = 0 "
                + "AND PB.MaPhong = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maPhong);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                GiuongBenhModel gb = new GiuongBenhModel(
                        resultSet.getString("MaGiuong"),
                        resultSet.getString("MaPhong"),
                        resultSet.getString("TenPhong"),
                        resultSet.getString("TenLoaiPhong"),
                        resultSet.getString("CoNguoi"),
                        resultSet.getInt("DonGia"));
                dsGiuongBenh.add(gb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiuongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsGiuongBenh;
    }

    public static void themGiuongBenh(String maPhong) throws ClassNotFoundException {
        String sql = "INSERT INTO GIUONGBENH(MaGiuong, MaPhong) VALUES (?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            String maGiuong = generateMaGiuong();

            statement.setString(1, maGiuong);
            statement.setString(2, maPhong);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GiuongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaGiuongBenhTrongPhong(String maPhong) throws ClassNotFoundException {
        String sql = "UPDATE GIUONGBENH SET TrangThaiXoa=? WHERE MaPhong=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, true);
            statement.setString(2, maPhong);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GiuongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void khoiPhucTrangThaiXoa(String maPhong, int soLanKhoiPhuc) throws ClassNotFoundException {
        if (soLanKhoiPhuc > 0) {
            String sql = "UPDATE TOP (?) GIUONGBENH SET TrangThaiXoa=? WHERE MaPhong=? AND TrangThaiXoa=?";
            try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
                // Sử dụng TOP để giới hạn số lần cập nhật
                statement.setInt(1, soLanKhoiPhuc);
                statement.setBoolean(2, false);
                statement.setString(3, maPhong);
                statement.setBoolean(4, true);

                statement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(GiuongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Số lần khôi phục không hợp lệ.");
        }
    }

    public static void giamGiuongBenh(String maPhong, int soGiuongCanGiam) throws ClassNotFoundException {
        if (soGiuongCanGiam > 0) {
            String sql = "UPDATE TOP (?) GIUONGBENH SET TrangThaiXoa=? WHERE MaPhong=? AND TrangThaiXoa=?";
            try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
                // Sử dụng TOP để giới hạn số lần cập nhật
                statement.setInt(1, soGiuongCanGiam);
                statement.setBoolean(2, true);
                statement.setString(3, maPhong);
                statement.setBoolean(4, false);
                statement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(GiuongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Số lần giảm không hợp lệ.");
        }
    }

    public static void nhapVien(String maGiuong) throws ClassNotFoundException {
        String sql = "UPDATE GIUONGBENH SET CoNguoi=? WHERE MaGiuong = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "Có người");
            statement.setString(2, maGiuong);

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GiuongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void khoiPhucTrangThaiGiuong(String maGiuong) throws ClassNotFoundException {
        String sql = "UPDATE GIUONGBENH SET CoNguoi = ? WHERE MaGiuong = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "-");
            statement.setString(2, maGiuong);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GiuongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
