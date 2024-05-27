package controllers;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DangKyModel;

public class DangKyCtrl {

    public static void themBenhNhanCho(DangKyModel dk) throws ClassNotFoundException {
        String sql = "INSERT INTO DANGKY (MaDangKy, MaDichVuKB, MaPhongKham, LyDoKham, NgayKham, TrangThai, ThuTu) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, dk.getMaDangKy());
            statement.setString(2, dk.getMaDichVuKB());
            statement.setString(3, dk.getMaPhongKham());
            statement.setString(4, dk.getLyDoKham());
            statement.setDate(5, dk.getNgayKham());
            statement.setString(6, dk.getTrangThai());
            statement.setInt(7, dk.getThuTuKham());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatDangKy(DangKyModel dk) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("UPDATE DANGKY SET MaDichVuKham=?, MaPhongKham=?, LyDoKham=?, TrangThai=? WHERE MaDangKy=?")) {

            statement.setString(1, dk.getMaDangKy());
            statement.setString(2, dk.getMaPhongKham());
            statement.setString(3, dk.getLyDoKham());
            statement.setString(4, dk.getTrangThai());
            statement.setString(5, dk.getMaDangKy());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatTrangThai(DangKyModel dk) throws ClassNotFoundException {
        String sql = "UPDATE DANGKY SET TrangThai=? WHERE MaDangKy=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, dk.getTrangThai());
            statement.setString(2, dk.getMaDangKy());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaDangKy(String maDangKy) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("DELETE FROM DANGKY WHERE MaDangKy=?")) {

            statement.setString(1, maDangKy);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean kiemTraMaDangKyTonTai(String maDangKy) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT 1 FROM DANGKY WHERE MaDangKy=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maDangKy);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
