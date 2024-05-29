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
                if (!resultSet.getString("TrangThai").equals("Đã khám") && !resultSet.getBoolean("TrangThaiXoa")) {

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

        String sql = """
        SELECT DANGKY.MaDangKy, DANGKY.MaDichVuKB, PHONGKHAM.MaPhongKham, LyDoKham, NgayKham, DANGKY.TrangThai,
        BENHNHAN.MaBenhNhan, HoTen, GioiTinh, NamSinh, TenPhongKham, TenDichVuKB, ThuTu, DANGKY.TrangThaiXoa, DANGKY.ThuTu
        FROM DANGKY
        JOIN BENHAN ON BENHAN.MaDangKy = DANGKY.MaDangKy
        JOIN BENHNHAN ON BENHNHAN.MaBenhNhan = BENHAN.MaBenhNhan
        JOIN PHONGKHAM ON DANGKY.MaPhongKham = PHONGKHAM.MaPhongKham
        JOIN DICHVUKB ON DICHVUKB.MaDichVuKB = DANGKY.MaDichVuKB
        WHERE (DANGKY.MaDangKy LIKE ? OR BENHNHAN.MaBenhNhan LIKE ? OR PHONGKHAM.MaPhongKham LIKE ? OR HoTen LIKE ? OR CanCuoc LIKE ? OR SoDienThoai LIKE ? OR TenPhongKham LIKE ? OR TenDichVuKB LIKE ? OR DANGKY.MaDichVuKB LIKE ?)
    """;

        if (!maPhongKham.equals("---Phòng khám---")) {
            sql += " AND PHONGKHAM.MaPhongKham = ?";
        }

        if (!trangThai.equals("Tất cả")) {
            sql += " AND DANGKY.TrangThai LIKE ?";
        }

        sql += " ORDER BY DANGKY.ThuTu ASC";

        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            int paramIndex = 1;
            for (int i = 0; i < 9; i++) {
                statement.setString(paramIndex++, "%" + timKiem + "%");
            }

            if (!maPhongKham.equals("---Phòng khám---")) {
                statement.setString(paramIndex++, maPhongKham);
            }

            if (!trangThai.equals("Tất cả")) {
                statement.setString(paramIndex++, "%" + trangThai + "%");
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (!resultSet.getString("TrangThai").equals("Đã khám") && !resultSet.getBoolean("TrangThaiXoa")) {
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
            }

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsBenhNhan;
    }
}
