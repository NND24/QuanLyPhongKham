package controllers;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.BenhNhanModel;

public class BenhNhanCtrl {

    public static List<BenhNhanModel> timTatCaBenhNhan() throws ClassNotFoundException {
        List<BenhNhanModel> dsBenhNhan = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM BENHNHAN";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                if (resultSet.getInt("TrangThaiXoa") == 0) {
                    BenhNhanModel bn = new BenhNhanModel(
                            resultSet.getString("MaBenhNhan"),
                            resultSet.getString("HoTen"),
                            resultSet.getString("GioiTinh"),
                            resultSet.getString("NamSinh"),
                            resultSet.getString("DiaChi"),
                            resultSet.getString("CanCuoc"),
                            resultSet.getString("BHYT"),
                            resultSet.getString("SoDienThoai"),
                            resultSet.getString("ngheNghiep"),
                            resultSet.getString("DanToc"),
                            resultSet.getString("QuocTich")
                    );
                    dsBenhNhan.add(bn);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsBenhNhan;
    }

    public static List<BenhNhanModel> timBenhNhanTheoMa(String maBenhNhan) throws ClassNotFoundException {
        List<BenhNhanModel> dsBenhNhan = new ArrayList<>();
        String sql = "SELECT * FROM BENHNHAN WHERE MaBenhNhan=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maBenhNhan);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("TrangThaiXoa") == 0) {
                    BenhNhanModel bn = new BenhNhanModel(
                            resultSet.getString("MaBenhNhan"),
                            resultSet.getString("HoTen"),
                            resultSet.getString("GioiTinh"),
                            resultSet.getString("NamSinh"),
                            resultSet.getString("DiaChi"),
                            resultSet.getString("CanCuoc"),
                            resultSet.getString("BHYT"),
                            resultSet.getString("SoDienThoai"),
                            resultSet.getString("ngheNghiep"),
                            resultSet.getString("DanToc"),
                            resultSet.getString("QuocTich")
                    );
                    dsBenhNhan.add(bn);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsBenhNhan;
    }

    public static List<BenhNhanModel> timBenhNhanTheoDK(String timKiem, String gioiTinh) throws ClassNotFoundException {
        List<BenhNhanModel> dsBenhNhan = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();

            if (!timKiem.isEmpty() && gioiTinh.equals("Tất cả")) {
                String sql = "SELECT * FROM BENHNHAN WHERE MaBenhNhan LIKE ? OR HoTen LIKE ? OR SoDienThoai LIKE ? OR CanCuoc LIKE ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + timKiem + "%");
                statement.setString(2, "%" + timKiem + "%");
                statement.setString(3, "%" + timKiem + "%");
                statement.setString(4, "%" + timKiem + "%");

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    BenhNhanModel bn = new BenhNhanModel(resultSet.getString("MaBenhNhan"), resultSet.getString("HoTen"),
                            resultSet.getString("GioiTinh"), resultSet.getString("NamSinh"),
                            resultSet.getString("DiaChi"), resultSet.getString("CanCuoc"),
                            resultSet.getString("BHYT"), resultSet.getString("SoDienThoai"), resultSet.getString("ngheNghiep"),
                            resultSet.getString("DanToc"), resultSet.getString("QuocTich"));
                    dsBenhNhan.add(bn);
                }
            } else if (timKiem.isEmpty() && !gioiTinh.equals("Tất cả")) {
                String sql = "SELECT * FROM BENHNHAN WHERE GioiTinh LIKE ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + gioiTinh + "%");

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    BenhNhanModel bn = new BenhNhanModel(resultSet.getString("MaBenhNhan"), resultSet.getString("HoTen"),
                            resultSet.getString("GioiTinh"), resultSet.getString("NamSinh"),
                            resultSet.getString("DiaChi"), resultSet.getString("CanCuoc"),
                            resultSet.getString("BHYT"), resultSet.getString("SoDienThoai"), resultSet.getString("ngheNghiep"),
                            resultSet.getString("DanToc"), resultSet.getString("QuocTich"));
                    dsBenhNhan.add(bn);
                }
            } else if (!timKiem.isEmpty() && !gioiTinh.equals("Tất cả")) {
                String sql = "SELECT * FROM BENHNHAN WHERE ( MaBenhNhan LIKE ? OR HoTen LIKE ? OR SoDienThoai LIKE ? OR CanCuoc LIKE ?) AND GioiTinh LIKE ?";
                statement = connection.prepareStatement(sql);
                statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + timKiem + "%");
                statement.setString(2, "%" + timKiem + "%");
                statement.setString(3, "%" + timKiem + "%");
                statement.setString(4, "%" + timKiem + "%");
                statement.setString(5, "%" + gioiTinh + "%");

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    BenhNhanModel bn = new BenhNhanModel(resultSet.getString("MaBenhNhan"), resultSet.getString("HoTen"),
                            resultSet.getString("GioiTinh"), resultSet.getString("NamSinh"),
                            resultSet.getString("DiaChi"), resultSet.getString("CanCuoc"),
                            resultSet.getString("BHYT"), resultSet.getString("SoDienThoai"), resultSet.getString("ngheNghiep"),
                            resultSet.getString("DanToc"), resultSet.getString("QuocTich"));
                    dsBenhNhan.add(bn);
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

    public static void ThemBenhNhan(BenhNhanModel bn) throws ClassNotFoundException {
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO BENHNHAN (MaBenhNhan, HoTen, GioiTinh, NamSinh, DiaChi, CanCuoc, SoDienThoai, NgheNghiep, DanToc, BHYT, QuocTich) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, bn.getMaBenhNhan());
            statement.setString(2, bn.getHoTen());
            statement.setString(3, bn.getGioiTinh());
            statement.setString(4, bn.getNamSinh());
            statement.setString(5, bn.getDiaChi());
            statement.setString(6, bn.getCanCuoc());
            statement.setString(7, bn.getSoDienThoai());
            statement.setString(8, bn.getNgheNghiep());
            statement.setString(9, bn.getDanToc());
            statement.setString(10, bn.getBhyt());
            statement.setString(11, bn.getQuocTich());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void CapNhatBenhNhan(BenhNhanModel bn) throws ClassNotFoundException {
        String sql = "UPDATE BENHNHAN SET HoTen=?, GioiTinh=?, NamSinh=?, DiaChi=?,CanCuoc=?,SoDienThoai=?,NgheNghiep=?,DanToc=?,BHYT=?,QuocTich=? WHERE MaBenhNhan=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, bn.getHoTen());
            statement.setString(2, bn.getGioiTinh());
            statement.setString(3, bn.getNamSinh());
            statement.setString(4, bn.getDiaChi());
            statement.setString(5, bn.getCanCuoc());
            statement.setString(6, bn.getSoDienThoai());
            statement.setString(7, bn.getNgheNghiep());
            statement.setString(8, bn.getDanToc());
            statement.setString(9, bn.getBhyt());
            statement.setString(10, bn.getQuocTich());
            statement.setString(11, bn.getMaBenhNhan());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void XoaBenhNhan(String maBN) throws ClassNotFoundException {
        String sql = "UPDATE BENHNHAN SET HoTen='1' WHERE MaBenhNhan=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maBN);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean kiemTraCccdCoTonTai(String cccd) throws ClassNotFoundException {
        boolean flag = false;

        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM BENHNHAN WHERE CanCuoc=?")) {

            statement.setString(1, cccd);
            ResultSet resultSet = statement.executeQuery();

            flag = resultSet.next();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTrabHYTCoTonTai(String bhyt) throws ClassNotFoundException {
        boolean flag = false;

        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM BENHNHAN WHERE BHYT=?")) {

            statement.setString(1, bhyt);
            ResultSet resultSet = statement.executeQuery();

            flag = resultSet.next();

        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static String generateMaBenhNhan() {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String timeString = dateFormat.format(now);

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String randomString = "BN" + timeString + randomNumber;
        return randomString;
    }
}
