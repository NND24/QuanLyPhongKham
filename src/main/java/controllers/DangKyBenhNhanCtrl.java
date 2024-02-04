package controllers;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DangKyBenhNhanModel;

public class DangKyBenhNhanCtrl {

    public static List<DangKyBenhNhanModel> timTatCaBenhNhanDK() throws ClassNotFoundException {
        List<DangKyBenhNhanModel> dsBenhNhan = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                         SELECT .DANGKY.MaDangKy, DANGKY.MaDichVuKB, PHONGKHAM.MaPhongKham, BENHNHAN.MaBenhNhan, LyDoKham, NgayKham, DANGKY.TrangThai,
                         HoTen, GioiTinh, NamSinh, TenPhongKham, TenDichVuKB, ThuTu, DANGKY.TrangThaiXoa
                         FROM DANGKY, BENHNHAN, PHONGKHAM, DICHVUKB, BENHAN
                         WHERE BENHAN.MaBenhNhan = BENHNHAN.MaBenhNhan AND DANGKY.MaPhongKham=PHONGKHAM.MaPhongKham
                         AND DICHVUKB.MaDichVuKB=DANGKY.MaDichVuKB AND BENHAN.MaDangKy=DANGKY.MaDangKy
                         ORDER BY ThuTu ASC
                         """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                if (!resultSet.getString("TrangThai").equals("Đã khám") && resultSet.getString("TrangThaiXoa").equals("0")) {

                    DangKyBenhNhanModel bn = new DangKyBenhNhanModel(
                            resultSet.getString("HoTen"),
                            resultSet.getString("GioiTinh"),
                            resultSet.getString("NamSinh"),
                            resultSet.getString("MaDangKy"),
                            resultSet.getString("MaBenhNhan"),
                            resultSet.getString("MaDichVuKB"),
                            resultSet.getString("MaPhongKham"),
                            resultSet.getString("LyDoKham"),
                            resultSet.getInt("ThuTu"),
                            resultSet.getDate("NgayKham"),
                            resultSet.getString("TrangThai"),
                            resultSet.getString("TenPhongKham"),
                            resultSet.getString("TenDichVuKB")
                    );
                    dsBenhNhan.add(bn);

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsBenhNhan;
    }

    public static List<DangKyBenhNhanModel> timTatCaBenhNhanDKTheoDieuKien(String maPhongKham, String timKiem, String trangThai) throws ClassNotFoundException {
        List<DangKyBenhNhanModel> dsBenhNhan = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();

            if (!timKiem.isEmpty() && maPhongKham.equals("---Phòng khám---") && trangThai.equals("Tất cả")) {
                String sql = """
                         SELECT .DANGKY.MaDangKy, DANGKY.MaDichVuKB, PHONGKHAM.MaPhongKham, LyDoKham, NgayKham, DANGKY.TrangThai,
                         HoTen, GioiTinh, NamSinh, TenPhongKham, TenDichVuKB, ThuTu, DANGKY.TrangThaiXoa
                         FROM DANGKY, BENHNHAN, PHONGKHAM, DICHVUKB, BENHAN
                         WHERE BENHAN.MaBenhNhan = BENHNHAN.MaBenhNhan AND DANGKY.MaPhongKham=PHONGKHAM.MaPhongKham
                         AND DICHVUKB.MaDichVuKB=DANGKY.MaDichVuKB AND BENHAN.MaDangKy=DANGKY.MaDangKy
                         AND (DANGKY.MaDangKy LIKE ? OR BENHNHAN.MaBenhNhan LIKE ? OR PHONGKHAM.MaPhongKham LIKE ? OR HoTen LIKE ? OR CanCuoc LIKE ? OR SoDienThoai LIKE ? OR TenPhongKham LIKE ? OR TenDichVu LIKE ? OR MaDichVuKham LIKE ?)
                         ORDER BY ThuTu ASC
                         """;

                statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + timKiem + "%");
                statement.setString(2, "%" + timKiem + "%");
                statement.setString(3, "%" + timKiem + "%");
                statement.setString(4, "%" + timKiem + "%");
                statement.setString(5, "%" + timKiem + "%");
                statement.setString(6, "%" + timKiem + "%");
                statement.setString(7, "%" + timKiem + "%");
                statement.setString(8, "%" + timKiem + "%");
                statement.setString(9, "%" + timKiem + "%");
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    if (!resultSet.getString("TrangThai").equals("Đã khám")) {
                        DangKyBenhNhanModel bn = new DangKyBenhNhanModel(
                                resultSet.getString("HoTen"), resultSet.getString("GioiTinh"),
                                resultSet.getString("NamSinh"), resultSet.getString("MaDangKy"),
                                resultSet.getString("MaBenhNhan"), resultSet.getString("MaDichVuKB"),
                                resultSet.getString("MaPhongKham"), resultSet.getString("LyDoKham"),
                                resultSet.getInt("ThuTuKham"), resultSet.getDate("NgayKham"),
                                resultSet.getString("TrangThai")
                        );
                        dsBenhNhan.add(bn);
                    }
                }
            }
            if (timKiem.isEmpty() && !maPhongKham.equals("---Phòng khám---") && trangThai.equals("Tất cả")) {
                String sql = """
                         SELECT .DANGKY.MaDangKy, DANGKY.MaDichVuKB, PHONGKHAM.MaPhongKham, LyDoKham, NgayKham, DANGKY.TrangThai,
                         HoTen, GioiTinh, NamSinh, TenPhongKham, TenDichVuKB, ThuTu, DANGKY.TrangThaiXoa
                         FROM DANGKY, BENHNHAN, PHONGKHAM, DICHVUKB, BENHAN
                         WHERE BENHAN.MaBenhNhan = BENHNHAN.MaBenhNhan AND DANGKY.MaPhongKham=PHONGKHAM.MaPhongKham
                         AND DICHVUKB.MaDichVuKB=DANGKY.MaDichVuKB AND BENHAN.MaDangKy=DANGKY.MaDangKy AND PHONGKHAM.MaPhongKham=?
                         ORDER BY ThuTu ASC
                         """;

                statement = connection.prepareStatement(sql);
                statement.setString(1, maPhongKham);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    if (!resultSet.getString("TrangThai").equals("Đã khám")) {
                        DangKyBenhNhanModel bn = new DangKyBenhNhanModel(
                                resultSet.getString("HoTen"), resultSet.getString("GioiTinh"),
                                resultSet.getString("NamSinh"), resultSet.getString("MaDangKy"),
                                resultSet.getString("MaBenhNhan"), resultSet.getString("MaDichVuKB"),
                                resultSet.getString("MaPhongKham"), resultSet.getString("LyDoKham"),
                                resultSet.getInt("ThuTuKham"), resultSet.getDate("NgayKham"),
                                resultSet.getString("TrangThai")
                        );
                        dsBenhNhan.add(bn);
                    }
                }
            }
            if (timKiem.isEmpty() && maPhongKham.equals("---Phòng khám---") && !trangThai.equals("Tất cả")) {
                String sql = """
                         SELECT .DANGKY.MaDangKy, DANGKY.MaDichVuKB, PHONGKHAM.MaPhongKham, LyDoKham, NgayKham, DANGKY.TrangThai,
                         HoTen, GioiTinh, NamSinh, TenPhongKham, TenDichVuKB, ThuTu, DANGKY.TrangThaiXoa
                         FROM DANGKY, BENHNHAN, PHONGKHAM, DICHVUKB, BENHAN
                         WHERE BENHAN.MaBenhNhan = BENHNHAN.MaBenhNhan AND DANGKY.MaPhongKham=PHONGKHAM.MaPhongKham
                         AND DICHVUKB.MaDichVuKB=DANGKY.MaDichVuKB AND BENHAN.MaDangKy=DANGKY.MaDangKy AND DANGKY.TrangThai LIKE ?
                         ORDER BY ThuTu ASC
                         """;
                statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + trangThai + "%");

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    if (!resultSet.getString("TrangThai").equals("Đã khám")) {
                        DangKyBenhNhanModel bn = new DangKyBenhNhanModel(
                                resultSet.getString("HoTen"), resultSet.getString("GioiTinh"),
                                resultSet.getString("NamSinh"), resultSet.getString("MaDangKy"),
                                resultSet.getString("MaBenhNhan"), resultSet.getString("MaDichVuKB"),
                                resultSet.getString("MaPhongKham"), resultSet.getString("LyDoKham"),
                                resultSet.getInt("ThuTuKham"), resultSet.getDate("NgayKham"),
                                resultSet.getString("TrangThai")
                        );
                        dsBenhNhan.add(bn);
                    }
                }
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

        return dsBenhNhan;
    }
}
