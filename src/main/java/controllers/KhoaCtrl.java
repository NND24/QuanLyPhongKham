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
import models.KhoaModel;

public class KhoaCtrl {
    
    public static String generateMaKhoa() {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String timeString = dateFormat.format(now);

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String randomString = "KH" + timeString + randomNumber;
        return randomString;
    }
    
    public static List<KhoaModel> hienThiTatCa() throws ClassNotFoundException {
        List<KhoaModel> dsKhoa = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM KHOA WHERE TrangThaiXoa = 0";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                KhoaModel khoa = new KhoaModel(
                        resultSet.getString("MaKhoa"),
                        resultSet.getString("TenKhoa"),
                        resultSet.getString("TrangThai"));
                dsKhoa.add(khoa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return dsKhoa;
    }
    
    public static void themKhoa(KhoaModel khoa) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO KHOA(MaKhoa, TenKhoa, TrangThai) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            String maKhoa = generateMaKhoa();
            statement.setString(1, maKhoa);
            statement.setString(2, khoa.getTenKhoa());
            statement.setString(3, khoa.getTrangThai());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void capNhatKhoa(KhoaModel khoa, String maKhoa) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE KHOA SET TenKhoa=?, TrangThai=? WHERE MaKhoa=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, khoa.getTenKhoa());
            statement.setString(2, khoa.getTrangThai());
            statement.setString(3, maKhoa);

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void xoaKhoa(String maKhoa) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE KHOA SET TrangThaiXoa=? WHERE MaKhoa=?";
            statement = connection.prepareCall(sql);

            statement.setBoolean(1,true);
            statement.setString(2, maKhoa);

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<KhoaModel> timKiemKhoa(String tuKhoa) throws ClassNotFoundException {
        List<KhoaModel> ketQua = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM KHOA WHERE MaKhoa LIKE ? OR TenKhoa LIKE ?";
            statement = connection.prepareStatement(sql);
            String keyword = "%" + tuKhoa + "%";
            statement.setString(1, keyword);
            statement.setString(2, keyword);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maKhoa = resultSet.getString("MaKhoa");
                String tenKhoa = resultSet.getString("TenKhoa");
                String trangThai = resultSet.getString("TrangThai");

                KhoaModel khoa = new KhoaModel(maKhoa, tenKhoa, trangThai);
                ketQua.add(khoa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return ketQua;
    }
    
    
    
    
    
    
}
