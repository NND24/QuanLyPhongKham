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

            String sql = "SELECT MaDangKy, BENHNHAN.MaBenhNhan, MaDichVuKham, PHONGKHAM.MaPhongKham, LyDoKham, NgayKham, DANGKY.TrangThai, HoTen, GioiTinh, NamSinh, DiaChi, CanCuoc, BHYT, SoDienThoai, NgheNghiep, DanToc, QuocTich, TenPhongKham, TenDichVu, ThuTu FROM DANGKY, BENHNHAN, PHONGKHAM, DICHVUKB WHERE DANGKY.MaBenhNhan = BENHNHAN.MaBenhNhan AND DANGKY.MaPhongKham=PHONGKHAM.MaPhongKham AND DICHVUKB.MaDichVu=DANGKY.MaDichVuKham ORDER BY ThuTu ASC";
            ResultSet resultSet = statement.executeQuery(sql);

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
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsBenhNhan;
    }

    public static List<DangKyBenhNhanModel> timTatCaBenhNhanDKTheoDieuKien(String maPhongKham, String timKiem, String trangThai) throws ClassNotFoundException {
        List<DangKyBenhNhanModel> dsBenhNhan = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection()) {
            String sql = "SELECT MaDangKy, BENHNHAN.MaBenhNhan, MaDichVuKham, PHONGKHAM.MaPhongKham, LyDoKham, NgayKham, DANGKY.TrangThai, HoTen, GioiTinh, NamSinh, DiaChi, CanCuoc, BHYT, SoDienThoai, NgheNghiep, DanToc, QuocTich, TenPhongKham, TenDichVu, ThuTu "
                    + "FROM DANGKY, BENHNHAN, PHONGKHAM, DICHVUKB "
                    + "WHERE DANGKY.MaBenhNhan = BENHNHAN.MaBenhNhan AND DANGKY.MaPhongKham=PHONGKHAM.MaPhongKham AND DICHVUKB.MaDichVu=DANGKY.MaDichVuKham AND "
                    + "(DANGKY.MaDangKy LIKE ? OR BENHNHAN.MaBenhNhan LIKE ? OR PHONGKHAM.MaPhongKham LIKE ? OR HoTen LIKE ? OR CanCuoc LIKE ? OR SoDienThoai LIKE ? OR TenPhongKham LIKE ? OR TenDichVu LIKE ? OR MaDichVuKham LIKE ?) "
                    + "ORDER BY ThuTu ASC";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
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
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsBenhNhan;
    }
}
