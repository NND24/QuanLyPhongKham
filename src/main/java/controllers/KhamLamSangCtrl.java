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
import models.KhamLamSangModel;

public class KhamLamSangCtrl {

    public static List<KhamLamSangModel> timKhamBenhTheoMa(String maKhamBenh) throws ClassNotFoundException {
        List<KhamLamSangModel> dsKhamLamSan = new ArrayList<>();
        String sql = "SELECT * FROM KHAMLAMSANG WHERE MaKhamLamSang=? ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maKhamBenh);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    KhamLamSangModel bn = new KhamLamSangModel(
                            resultSet.getString("MaKhamLamSang"),
                            resultSet.getString("MaBacSi"), resultSet.getDate("NgayKham"),
                            resultSet.getString("CanNang"), resultSet.getString("ChieuCao"),
                            resultSet.getString("NhietDo"), resultSet.getString("NhipTho"),
                            resultSet.getString("HuyetAp"), resultSet.getString("Mach"),
                            resultSet.getString("BMI"), resultSet.getString("LyDoKhamBenh"),
                            resultSet.getString("ChuanDoan"), resultSet.getString("BenhChinh"),
                            resultSet.getString("BenhPhu"), resultSet.getString("HuongXuLy"),
                            resultSet.getString("LoiDan"), resultSet.getString("BenhSu"),
                            resultSet.getString("TienSu"), resultSet.getString("KhamToanThan"),
                            resultSet.getString("KhamBoPhan"), resultSet.getString("TomTatKetQuaCLS"));
                    dsKhamLamSan.add(bn);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsKhamLamSan;
    }

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

            statement.setString(1, kb.getMaBacSi());
            statement.setDate(2, kb.getNgayKham());
            statement.setString(3, kb.getCanNang());
            statement.setString(4, kb.getChieuCao());
            statement.setString(5, kb.getNhietDo());
            statement.setString(6, kb.getNhipTho());
            statement.setString(7, kb.getHuyetAp());
            statement.setString(8, kb.getMach());
            statement.setString(9, kb.getBMI());
            statement.setString(10, kb.getLyDoKhamBenh());
            statement.setString(11, kb.getChuanDoan());
            statement.setString(12, kb.getBenhChinh());
            statement.setString(13, kb.getBenhPhu());
            statement.setString(14, kb.getHuongXuLy());
            statement.setString(15, kb.getLoiDan());
            statement.setString(16, kb.getBenhSu());
            statement.setString(17, kb.getTienSu());
            statement.setString(18, kb.getKhamToanThan());
            statement.setString(19, kb.getKhamBoPhan());
            statement.setString(20, kb.getTomTatKetQuaCLS());
            statement.setString(21, kb.getMaKhamLamSang());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<KhamLamSangModel> thanhToanKLS(String maBenhAn) throws ClassNotFoundException {
        List<KhamLamSangModel> dsKhamLamSan = new ArrayList<>();
        String sql = """
                    SELECT TenDichVuKB, GiaTien, GiaBaoHiem, BHYT
                    FROM BENHAN, KHAMLAMSANG, DICHVUKB, BENHNHAN
                    WHERE BENHAN.MaKhamLamSang=KHAMLAMSANG.MaKhamLamSang AND
                    KHAMLAMSANG.MaKhamLamSang=DICHVUKB.MaDichVuKB AND
                    BENHAN.MaBenhNhan=BENHNHAN.MaBenhNhan AND
                    BENHAN.MaBenhAn=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maBenhAn);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String giaTien = resultSet.getString("BHYT").isEmpty()
                        ? resultSet.getString("GiaTien")
                        : resultSet.getString("GiaBaoHiem");

                KhamLamSangModel bn = new KhamLamSangModel(
                        resultSet.getString("TenDichVu"), giaTien);
                dsKhamLamSan.add(bn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsKhamLamSan;
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
