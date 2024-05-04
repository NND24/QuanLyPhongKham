package controllers;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.BenhAnModel;
import models.BacSiModel;

public class BenhAnCtrl {

    public static BacSiModel layThongTinBacSiTheoEmail(String maBenhAn) throws ClassNotFoundException {
        BacSiModel bacSi = null;
        String sql = "SELECT MaBacSi, HoTen FROM BACSI WHERE TrangThaiXoa='0' AND Email=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maBenhAn);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    bacSi = new BacSiModel(
                            resultSet.getString("MaBacSi"),
                            resultSet.getString("HoTen")
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bacSi;
    }

    public static void themBenhAn(BenhAnModel ba) throws ClassNotFoundException {
        String sql = "INSERT INTO BENHAN (MaBenhAn, MaBenhNhan, MaDangKy, MaKhamLamSang) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, ba.getMaBenhAn());
            statement.setString(2, ba.getMaBenhNhan());
            statement.setString(3, ba.getMaDangKy());
            statement.setString(4, ba.getMaKhamLamSang());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static BenhAnModel timBenhAn(String maBenhAn) throws ClassNotFoundException {
        BenhAnModel benhAn = null;
        String sql = "SELECT * FROM BENHAN WHERE MaBenhAn = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maBenhAn);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (!resultSet.getBoolean("TrangThaiXoa")) {
                        benhAn = new BenhAnModel(
                                resultSet.getString("MaBenhAn"),
                                resultSet.getString("MaDangKy"),
                                resultSet.getString("MaKhamLamSang"),
                                resultSet.getString("MaBenhNhan")
                        );
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return benhAn;
    }

    public static String timMaBenhAnTheoDK(String maDangKy) throws ClassNotFoundException {
        String maBenhAn = null;
        String sql = "SELECT MaBenhAn, BENHAN.MaDangKy FROM DANGKY, BENHAN WHERE DANGKY.MaDangKy=BENHAN.MaDangKy AND BENHAN.MaDangKy = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maDangKy);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    maBenhAn = resultSet.getString("MaBenhAn");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maBenhAn;
    }

    public static List<BenhAnModel> timTatCaBenhAn() throws ClassNotFoundException {
        List<BenhAnModel> dsBenhAn = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {
            String sql = """
                        SELECT DISTINCT MaBenhAn, BENHAN.MaBenhNhan, BENHAN.MaDangKy, MaKhamLamSang, HoTen,
                        GioiTinh, NgayKham, DANGKY.LyDoKham, DICHVUKB.MaDichVuKB, DICHVUKB.TenDichVuKB,
                        PHONGKHAM.MaPhongKham, PHONGKHAM.TenPhongKham, BENHAN.TrangThaiXoa AS TTXBenhAn,
                        DANGKY.TrangThaiXoa AS TTXDangKy, DICHVUKB.TrangThaiXoa AS TTXDichVuKB, PHONGKHAM.TrangThaiXoa AS TTXPhongKham
                        FROM BENHAN
                        INNER JOIN DANGKY ON BENHAN.MaDangKy = DANGKY.MaDangKy
                        INNER JOIN BENHNHAN ON BENHAN.MaBenhNhan = BENHNHAN.MaBenhNhan
                        INNER JOIN DICHVUKB ON DANGKY.MaDichVuKB = DICHVUKB.MaDichVuKB
                        INNER JOIN PHONGKHAM ON DANGKY.MaPhongKham = PHONGKHAM.MaPhongKham
                         """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                if (!resultSet.getBoolean("TTXBenhAn") && !resultSet.getBoolean("TTXDangKy") && !resultSet.getBoolean("TTXDichVuKB") && !resultSet.getBoolean("TTXPhongKham")) {
                    BenhAnModel ba = new BenhAnModel(
                            resultSet.getString("MaBenhAn"), resultSet.getString("MaBenhNhan"),
                            resultSet.getString("MaDangKy"), resultSet.getString("MaKhamLamSang"),
                            resultSet.getString("HoTen"), resultSet.getString("GioiTinh"),
                            resultSet.getString("MaPhongKham"), resultSet.getString("TenPhongKham"),
                            resultSet.getString("MaDichVuKB"), resultSet.getString("TenDichVuKB"),
                            resultSet.getString("NgayKham"), resultSet.getString("LyDoKham"));
                    dsBenhAn.add(ba);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsBenhAn;
    }

    public static List<BenhAnModel> timBenhAnTheoDK(String timKiem) throws ClassNotFoundException {
        List<BenhAnModel> dsBenhAn = new ArrayList<>();

        if (timKiem.isEmpty()) {
            return dsBenhAn;
        }

        String sql = """
                    SELECT DISTINCT MaBenhAn, BENHAN.MaBenhNhan, BENHAN.MaDangKy, MaKhamLamSang, HoTen,
                    GioiTinh, NgayKham, DANGKY.LyDoKham, DICHVUKB.MaDichVuKB, DICHVUKB.TenDichVuKB,
                    PHONGKHAM.MaPhongKham, PHONGKHAM.TenPhongKham, BENHAN.TrangThaiXoa AS TTXBenhAn,
                    DANGKY.TrangThaiXoa AS TTXDangKy, DICHVUKB.TrangThaiXoa AS TTXDichVuKB, PHONGKHAM.TrangThaiXoa AS TTXPhongKham
                    FROM BENHAN
                    INNER JOIN DANGKY ON BENHAN.MaDangKy = DANGKY.MaDangKy
                    INNER JOIN BENHNHAN ON BENHAN.MaBenhNhan = BENHNHAN.MaBenhNhan
                    INNER JOIN DICHVUKB ON DANGKY.MaDichVuKB = DICHVUKB.MaDichVuKB
                    INNER JOIN PHONGKHAM ON DANGKY.MaPhongKham = PHONGKHAM.MaPhongKham
                    WHERE (MaBenhAn LIKE ? OR BENHAN.MaBenhNhan LIKE ? OR BENHAN.MaDangKy LIKE ? OR MaKhamLamSang LIKE ? OR HoTen LIKE ?
                    OR TenPhongKham LIKE ? OR PHONGKHAM.MaPhongKham LIKE ? OR TenDichVuKB LIKE ? OR DICHVUKB.MaDichVuKB LIKE ?)
                    """;

        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            for (int i = 1; i <= 9; i++) {
                statement.setString(i, "%" + timKiem + "%");
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (!resultSet.getBoolean("TTXBenhAn") && !resultSet.getBoolean("TTXDangKy") && !resultSet.getBoolean("TTXDichVuKB") && !resultSet.getBoolean("TTXPhongKham")) {
                        BenhAnModel ba = new BenhAnModel(
                                resultSet.getString("MaBenhAn"), resultSet.getString("MaBenhNhan"),
                                resultSet.getString("MaDangKy"), resultSet.getString("MaKhamLamSang"),
                                resultSet.getString("HoTen"), resultSet.getString("GioiTinh"),
                                resultSet.getString("MaPhongKham"), resultSet.getString("TenPhongKham"),
                                resultSet.getString("MaDichVuKB"), resultSet.getString("TenDichVuKB"),
                                resultSet.getString("NgayKham"), resultSet.getString("LyDoKham"));
                        dsBenhAn.add(ba);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsBenhAn;
    }

    public static List<BenhAnModel> timBenhAnTheoThoiGian(Date tuNgay, Date denNgay) throws ClassNotFoundException {
        List<BenhAnModel> dsBenhAn = new ArrayList<>();
        String sql = """
                SELECT DISTINCT MaBenhAn, BENHAN.MaBenhNhan, BENHAN.MaDangKy, MaKhamLamSang, HoTen,
                GioiTinh, NgayKham, DANGKY.LyDoKham, DICHVUKB.MaDichVuKB, DICHVUKB.TenDichVuKB,
                PHONGKHAM.MaPhongKham, PHONGKHAM.TenPhongKham, BENHAN.TrangThaiXoa AS TTXBenhAn,
                DANGKY.TrangThaiXoa AS TTXDangKy, DICHVUKB.TrangThaiXoa AS TTXDichVuKB, PHONGKHAM.TrangThaiXoa AS TTXPhongKham
                FROM BENHAN
                INNER JOIN DANGKY ON BENHAN.MaDangKy = DANGKY.MaDangKy
                INNER JOIN BENHNHAN ON BENHAN.MaBenhNhan = BENHNHAN.MaBenhNhan
                INNER JOIN DICHVUKB ON DANGKY.MaDichVuKB = DICHVUKB.MaDichVuKB
                INNER JOIN PHONGKHAM ON DANGKY.MaPhongKham = PHONGKHAM.MaPhongKham
                WHERE (NgayKham BETWEEN ? AND ?)
                """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(tuNgay.getTime()));
            statement.setDate(2, new java.sql.Date(denNgay.getTime()));

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (!resultSet.getBoolean("TTXBenhAn") && !resultSet.getBoolean("TTXDangKy") && !resultSet.getBoolean("TTXDichVuKB") && !resultSet.getBoolean("TTXPhongKham")) {
                        BenhAnModel ba = new BenhAnModel(
                                resultSet.getString("MaBenhAn"), resultSet.getString("MaBenhNhan"),
                                resultSet.getString("MaDangKy"), resultSet.getString("MaKhamLamSang"),
                                resultSet.getString("HoTen"), resultSet.getString("GioiTinh"),
                                resultSet.getString("MaPhongKham"), resultSet.getString("TenPhongKham"),
                                resultSet.getString("MaDichVuKB"), resultSet.getString("TenDichVuKB"),
                                resultSet.getString("NgayKham"), resultSet.getString("LyDoKham"));
                        dsBenhAn.add(ba);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsBenhAn;
    }

    public static List<BenhAnModel> timTatCaThuTien() throws ClassNotFoundException {
        List<BenhAnModel> dsBenhAn = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = "SELECT MaBenhAn, BENHAN.MaBenhNhan, HoTen, GioiTinh, NamSinh, TongTien, DaThu, NgayKham "
                    + "FROM BENHAN, BENHNHAN, DANGKY "
                    + "WHERE BENHAN.MaBenhNhan=BENHNHAN.MaBenhNhan AND BENHAN.MaDangKy=DANGKY.MaDangKy";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                if (resultSet.getInt("DaThu") > 0) {
                    BenhAnModel ba = new BenhAnModel(
                            resultSet.getString("MaBenhAn"), resultSet.getString("NgayKham"),
                            resultSet.getInt("TongTien"), resultSet.getInt("DaThu"),
                            resultSet.getString("MaBenhNhan"), resultSet.getString("HoTen"),
                            resultSet.getString("GioiTinh"), resultSet.getString("NamSinh"));
                    dsBenhAn.add(ba);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsBenhAn;
    }

    public static List<BenhAnModel> timTienDaThu(String maBenhAn) throws ClassNotFoundException {
        List<BenhAnModel> dsBenhAn = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "SELECT MaBenhAn, BENHAN.MaBenhNhan, HoTen, GioiTinh, NamSinh, TongTien, DaThu, NgayKham "
                + "FROM BENHAN, BENHNHAN, DANGKY "
                + "WHERE BENHAN.MaBenhNhan=BENHNHAN.MaBenhNhan AND "
                + "BENHAN.MaDangKy=DANGKY.MaDangKy AND MaBenhAn=?")) {

            statement.setString(1, maBenhAn);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("DaThu") > 0) {
                    BenhAnModel ba = new BenhAnModel(
                            resultSet.getString("MaBenhAn"), resultSet.getString("NgayKham"),
                            resultSet.getInt("TongTien"), resultSet.getInt("DaThu"),
                            resultSet.getString("MaBenhNhan"), resultSet.getString("HoTen"),
                            resultSet.getString("GioiTinh"), resultSet.getString("NamSinh"));
                    dsBenhAn.add(ba);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsBenhAn;
    }

    public static List<BenhAnModel> timThuTienTheoDK(String tuKhoa) throws ClassNotFoundException {
        List<BenhAnModel> dsBenhAn = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "SELECT MaBenhAn, BENHAN.MaBenhNhan, HoTen, GioiTinh, NamSinh, TongTien, DaThu, NgayKham "
                + "FROM BENHAN, BENHNHAN, DANGKY "
                + "WHERE BENHAN.MaBenhNhan=BENHNHAN.MaBenhNhan AND "
                + "BENHAN.MaDangKy=DANGKY.MaDangKy AND (MaBenhAn LIKE ? OR BENHAN.MaBenhNhan LIKE ? OR HoTen LIKE ?)")) {

            statement.setString(1, "%" + tuKhoa + "%");
            statement.setString(2, "%" + tuKhoa + "%");
            statement.setString(3, "%" + tuKhoa + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("DaThu") > 0) {
                    BenhAnModel ba = new BenhAnModel(
                            resultSet.getString("MaBenhAn"), resultSet.getString("NgayKham"),
                            resultSet.getInt("TongTien"), resultSet.getInt("DaThu"),
                            resultSet.getString("MaBenhNhan"), resultSet.getString("HoTen"),
                            resultSet.getString("GioiTinh"), resultSet.getString("NamSinh"));
                    dsBenhAn.add(ba);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsBenhAn;
    }

    public static List<BenhAnModel> timThuTienTheoThoiGian(Date tuNgay, Date denNgay) throws ClassNotFoundException {
        List<BenhAnModel> dsBenhAn = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "SELECT MaBenhAn, BENHAN.MaBenhNhan, HoTen, GioiTinh, NamSinh, TongTien, DaThu, NgayKham "
                + "FROM BENHAN, BENHNHAN, DANGKY "
                + "WHERE BENHAN.MaBenhNhan=BENHNHAN.MaBenhNhan AND "
                + "BENHAN.MaDangKy=DANGKY.MaDangKy AND (NgayKham BETWEEN ? AND ?)")) {

            statement.setDate(1, new java.sql.Date(tuNgay.getTime()));
            statement.setDate(2, new java.sql.Date(denNgay.getTime()));
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("DaThu") > 0) {
                    BenhAnModel ba = new BenhAnModel(
                            resultSet.getString("MaBenhAn"), resultSet.getString("NgayKham"),
                            resultSet.getInt("TongTien"), resultSet.getInt("DaThu"),
                            resultSet.getString("MaBenhNhan"), resultSet.getString("HoTen"),
                            resultSet.getString("GioiTinh"), resultSet.getString("NamSinh"));
                    dsBenhAn.add(ba);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsBenhAn;
    }

    public static void capNhatTien(BenhAnModel ba) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "UPDATE BENHAN SET TongTien=?, DaThu=? WHERE MaBenhAn=?")) {

            statement.setInt(1, ba.getTongTien());
            statement.setInt(2, ba.getDaThu());
            statement.setString(3, ba.getMaBenhAn());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaBenhAn(String maBenhAn) throws ClassNotFoundException {
        String sql = "UPDATE BENHAN SET TrangThaiXoa='1' WHERE MaBenhAn=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maBenhAn);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
