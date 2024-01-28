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
import models.TaiKhoanModel;

public class TaiKhoanCtrl {
    
    public static List<TaiKhoanModel> hienThiTatCa() throws ClassNotFoundException {
        List<TaiKhoanModel> dsTaiKhoan = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM TAIKHOAN, KHOA WHERE TrangThaiXoa = 0";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                TaiKhoanModel tk = new TaiKhoanModel(
                        resultSet.getString("Email"),
                        resultSet.getString("MaChucVu"),
                        resultSet.getString("MatKhau"));
                dsTaiKhoan.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return dsTaiKhoan;
    }
    
    public static void themTaiKhoan(String email, String maChucVu, String password) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO TAIKHOAN(Email, MaChucVu, MatKhau) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2,maChucVu);
            statement.setString(3,password);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void xoaTaiKhoan (String email) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE TAIKHOAN SET TrangThaiXoa=? WHERE Email=?";

            statement = connection.prepareCall(sql);

            statement.setBoolean(1, true);
            statement.setString(2, email);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
