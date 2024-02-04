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
import models.KhamLamSangModel;

public class KhamLamSangCtrl {

    public static void themMaKhamLamSang(String maKhamLamSang) throws ClassNotFoundException {
        String sql = "INSERT INTO KHAMLAMSANG (MaKhamLamSang) VALUES (?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maKhamLamSang);

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatKhamLamSang(KhamLamSangModel kb) throws ClassNotFoundException {
        String sql = "UPDATE KHAMLAMSANG SET MaBacSi=?,NgayKham=?,CanNang=?,ChieuCao=?,NhietDo=?,NhipTho=?,HuyetAp=?,Mach=?,BMI=?,LyDoKhamBenh=?,ChuanDoan=?,BenhChinh=?,BenhPhu=?,HuongXuLy=?,LoiDan=?,BenhSu=?,TienSu=?,KhamToanThan=?,KhamBoPhan=?,TomTatKetQuaCLS=? WHERE MaKhamLamSang=?";

        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareCall(sql)) {

            statement.setString(3, kb.getMaBacSi());
            statement.setDate(4, kb.getNgayKham());
            statement.setString(5, kb.getCanNang());
            statement.setString(6, kb.getChieuCao());
            statement.setString(7, kb.getNhietDo());
            statement.setString(8, kb.getNhipTho());
            statement.setString(9, kb.getHuyetAp());
            statement.setString(10, kb.getMach());
            statement.setString(11, kb.getBMI());
            statement.setString(12, kb.getLyDoKhamBenh());
            statement.setString(13, kb.getChuanDoan());
            statement.setString(14, kb.getBenhChinh());
            statement.setString(15, kb.getBenhPhu());
            statement.setString(16, kb.getHuongXuLy());
            statement.setString(17, kb.getLoiDan());
            statement.setString(18, kb.getBenhSu());
            statement.setString(19, kb.getTienSu());
            statement.setString(20, kb.getKhamToanThan());
            statement.setString(21, kb.getKhamBoPhan());
            statement.setString(22, kb.getTomTatKetQuaCLS());
            statement.setString(23, kb.getMaKhamLamSang());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String generateMaKhamLamSang() {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String timeString = dateFormat.format(now);

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String randomString = "KLS" + timeString + randomNumber;
        return randomString;
    }
}
