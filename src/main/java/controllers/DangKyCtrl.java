package controllers;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DangKyModel;

public class DangKyCtrl {


    public static void themBenhDangKy(DangKyModel dk) throws ClassNotFoundException {

    public static void themBenhNhanCho(DangKyModel dk) throws ClassNotFoundException {

        String sql = "INSERT INTO DANGKY (MaDangKy, MaBenhNhan, MaDichVuKham, MaPhongKham, LyDoKham, NgayKham, TrangThai, ThuTu) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, dk.getMaDangKy());
            statement.setString(2, dk.getMaBenhNhan());
            statement.setString(3, dk.getMaDichVuKB());
            statement.setString(4, dk.getMaPhongKham());
            statement.setString(5, dk.getLyDoKham());
            statement.setDate(6, dk.getNgayKham());
            statement.setString(7, dk.getTrangThai());
            statement.setInt(8, dk.getThuTuKham());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String generateMaDangKy() {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String timeString = dateFormat.format(now);

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String randomString = "DK" + timeString + randomNumber;
        return randomString;
    }
}
