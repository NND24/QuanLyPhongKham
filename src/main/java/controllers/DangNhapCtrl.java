package controllers;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.PasswordHashing;

/**
 *
 * @author Phu Bao
 */
public class DangNhapCtrl {
    public static String currentEmail;
    
    public static boolean kiemTraEmailCoTonTai(String email) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM TAIKHOAN WHERE Email = ? ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }  
        } catch (SQLException ex) {
            Logger.getLogger(DangNhapCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return flag;
    }
    
    public static boolean kiemTraPasswordCoChinhXac(String email, String password) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT MatKhau FROM TaiKhoan WHERE Email = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){           
            statement.setString(1, email);           
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String rightPassword = resultSet.getString("MatKhau");
                if(PasswordHashing.checkPassword(password, rightPassword)){
                    flag = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DangNhapCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public static String traVeChucVu(String email) throws ClassNotFoundException {
        String maChucVu = null;
        String sql = "SELECT * FROM TaiKhoan WHERE Email = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){           
            statement.setString(1, email);           
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                maChucVu = resultSet.getString("MaChucVu");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DangNhapCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maChucVu;
    }
    
    public static void doiMatKhau(String email, String password) throws ClassNotFoundException {
        String sql = "UPDATE TaiKhoan SET MatKhau=? WHERE Email=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){                  
            statement.setString(1, password);
            statement.setString(2, email);  
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DangNhapCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
