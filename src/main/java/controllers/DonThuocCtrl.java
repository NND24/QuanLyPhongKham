package controllers;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DonThuocModel;

public class DonThuocCtrl {

    public static void themDonThuoc(DonThuocModel dt) throws ClassNotFoundException {
        String sql = "INSERT INTO DONTHUOC (MaDonThuoc, MaBenhAn, MaThuoc, MaBacSi, CachDung, SoNgay, SoLuong, Sang, Trua, Chieu, Toi, DonGia,ThanhTien) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, dt.getMaDonThuoc());
            statement.setString(2, dt.getMaBenhAn());
            statement.setString(3, dt.getMaThuoc());
            statement.setString(4, dt.getMaBacSi());
            statement.setString(5, dt.getCachDung());
            statement.setInt(6, dt.getSoNgay());
            statement.setInt(7, dt.getSoLuong());
            statement.setInt(8, dt.getSang());
            statement.setInt(9, dt.getTrua());
            statement.setInt(10, dt.getChieu());
            statement.setInt(11, dt.getToi());
            statement.setInt(12, dt.getDonGia());
            statement.setInt(13, dt.getThanhTien());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DonThuocCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<DonThuocModel> timDonThuocTheoMa(String maBenhAn) throws ClassNotFoundException {
        List<DonThuocModel> dsDonThuoc = new ArrayList<>();
        String sql = """
                     SELECT DISTINCT MaDonThuoc,MaBenhAn, DONTHUOC.MaThuoc,THUOC.TenThuoc, NHOMTHUOC.MaNhomThuoc,NHOMTHUOC.TenNhomThuoc,CachDung,SoNgay,SoLuong,Sang,Trua,Chieu,Toi,DONTHUOC.DonGia,ThanhTien, THUOC.DuongDung
                     FROM DONTHUOC,THUOC,NHOMTHUOC
                     WHERE MaBenhAn=? AND DONTHUOC.MaThuoc=THUOC.MaThuoc AND THUOC.MaNhomThuoc=NHOMTHUOC.MaNhomThuoc AND DONTHUOC.TrangThaiXoa=0 AND THUOC.TrangThaiXoa=0 AND NHOMTHUOC.TrangThaiXoa=0
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maBenhAn);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    DonThuocModel dt = new DonThuocModel(
                            resultSet.getString("MaDonThuoc"), resultSet.getString("MaBenhAn"),
                            resultSet.getString("MaThuoc"),
                            resultSet.getString("TenThuoc"), resultSet.getString("MaNhomThuoc"),
                            resultSet.getString("TenNhomThuoc"), resultSet.getString("DuongDung"),
                            resultSet.getString("CachDung"), resultSet.getInt("SoNgay"),
                            resultSet.getInt("SoLuong"), resultSet.getInt("Sang"),
                            resultSet.getInt("Trua"), resultSet.getInt("Chieu"),
                            resultSet.getInt("Toi"), resultSet.getInt("DonGia"),
                            resultSet.getInt("ThanhTien"));
                    dsDonThuoc.add(dt);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonThuocCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsDonThuoc;
    }

    public static void xoaThuocTheoMaBA(String maBenhAn) throws ClassNotFoundException {
        String sql = "UPDATE DONTHUOC SET TrangThaiXoa='1' WHERE MaBenhAn=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maBenhAn);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DonThuocCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaThuocKhoiDon(String maDonThuoc) throws ClassNotFoundException {
        String sql = "UPDATE DONTHUOC SET TrangThaiXoa='1' WHERE MaDonThuoc=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maDonThuoc);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DonThuocCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatDonThuoc(DonThuocModel dt) throws ClassNotFoundException {
        String sql = "UPDATE DONTHUOC SET CachDung=?, SoNgay=?, SoLuong=?, ThanhTien=?, Sang=?, Trua=?, Chieu=?, Toi=?, MaThuoc=?, MaBacSi=? WHERE MaDonThuoc=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, dt.getCachDung());
            statement.setInt(2, dt.getSoNgay());
            statement.setInt(3, dt.getSoLuong());
            statement.setInt(4, dt.getThanhTien());
            statement.setInt(5, dt.getSang());
            statement.setInt(6, dt.getTrua());
            statement.setInt(7, dt.getChieu());
            statement.setInt(8, dt.getToi());
            statement.setString(9, dt.getMaThuoc());
            statement.setString(10, dt.getMaBacSi());
            statement.setString(11, dt.getMaDonThuoc());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DonThuocCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String generateMaDonThuoc() {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String timeString = dateFormat.format(now);

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String randomString = "DT" + timeString + randomNumber;
        return randomString;
    }
}
