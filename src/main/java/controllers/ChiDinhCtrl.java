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
import models.ChiDinhModel;

public class ChiDinhCtrl {

    public static void themChiDinh(ChiDinhModel cd) throws ClassNotFoundException {
        String sql = "INSERT INTO CHIDINH (MaChiDinh, MaBenhAn, MaBacSi, MaDichVuCLS, SoLuong, DonGia, ThanhTien, GhiChu) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cd.getMaChiDinh());
            statement.setString(2, cd.getMaBenhAn());
            statement.setString(3, cd.getMaBacSi());
            statement.setString(4, cd.getMaDichVuCLS());
            statement.setInt(5, cd.getSoLuong());
            statement.setInt(6, cd.getDonGia());
            statement.setInt(7, cd.getThanhTien());
            statement.setString(8, cd.getGhiChu());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<ChiDinhModel> timChiDinhTheoMa(String maBenhAn) throws ClassNotFoundException {
        List<ChiDinhModel> dsChiDinh = new ArrayList<>();
        String sql = """
                     SELECT MaChiDinh, CHIDINH.MaDichVuCLS, TenDichVuCLS, GhiChu, SoLuong, DonGia, ThanhTien, KetQua, DICHVUCLS.MaNhomDichVuCLS, TenNhomDichVuCLS, CHIDINH.TrangThaiXoa
                     FROM CHIDINH, DICHVUCLS, NHOMDICHVUCLS
                     WHERE MaBenhAn=? AND CHIDINH.MaDichVuCLS=DICHVUCLS.MaDichVuCLS AND DICHVUCLS.MaNhomDichVuCLS=NHOMDICHVUCLS.MaNhomDichVuCLS
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maBenhAn);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (!resultSet.getBoolean("TrangThaiXoa")) {
                        ChiDinhModel cd = new ChiDinhModel(
                                resultSet.getString("MaChiDinh"), resultSet.getString("KetQua"),
                                resultSet.getString("MaDichVuCLS"), resultSet.getString("TenDichVuCLS"),
                                resultSet.getString("MaNhomDichVuCLS"), resultSet.getString("TenNhomDichVuCLS"),
                                resultSet.getInt("SoLuong"), resultSet.getInt("DonGia"),
                                resultSet.getInt("ThanhTien"), resultSet.getString("GhiChu")
                        );
                        dsChiDinh.add(cd);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dsChiDinh;
    }

    public static void xoaChiDinh(String maChiDinh) throws ClassNotFoundException {
        String sql = "UPDATE CHIDINH SET TrangThaiXoa='1' WHERE MaChiDinh=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maChiDinh);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatChiDinh(ChiDinhModel cd) throws ClassNotFoundException {
        String sql = "UPDATE CHIDINH SET GhiChu=?, SoLuong=?, ThanhTien=?, MaDichVuCLS=? WHERE MaChiDinh=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cd.getGhiChu());
            statement.setInt(2, cd.getSoLuong());
            statement.setInt(3, cd.getThanhTien());
            statement.setString(4, cd.getMaDichVuCLS());
            statement.setString(5, cd.getMaChiDinh());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatKetQua(ChiDinhModel kq) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("UPDATE CHIDINH SET MaBacSi=?, KetQua=? WHERE MaChiDinh=?")) {

            statement.setString(1, kq.getMaBacSi());
            statement.setString(2, kq.getKetQua());
            statement.setString(3, kq.getMaChiDinh());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
