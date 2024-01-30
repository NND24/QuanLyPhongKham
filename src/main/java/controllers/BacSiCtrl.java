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
import models.BacSiModel;

/**
 *
 * @author Phu Bao
 */
public class BacSiCtrl {
    
    public static String generateMaBacSi() {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String timeString = dateFormat.format(now);

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String randomString = "BS" + timeString + randomNumber;
        return randomString;
    }
    
    public static String generatePassword (String ma, String namSinh){
        String password = ma + "#" + namSinh;
        return password;           
    }
    
    public static List<BacSiModel> hienThiTatCa() throws ClassNotFoundException {
        List<BacSiModel> dsBacSi = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "SELECT BS.MaBacSi, BS.Email, KH.MaKhoa, KH.TenKhoa,BS.HoTen, BS.GioiTinh, "
                    + "BS.NamSinh, BS.DiaChi, BS.SoDienThoai, BS.CanCuoc, BS.TrinhDo, BS.Anh "
                    + "FROM BACSI AS BS, KHOA AS KH WHERE BS.MaKhoa = KH.MaKhoa AND BS.TrangThaiXoa=0";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                BacSiModel bs = new BacSiModel(
                        resultSet.getString("MaBacSi"),
                        resultSet.getString("Email"),
                        resultSet.getString("MaKhoa"),
                        resultSet.getString("TenKhoa"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getString("NamSinh"),
                        resultSet.getString("DiaChi"),
                        resultSet.getString("SoDienThoai"), 
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("TrinhDo"),
                        resultSet.getString("Anh"));
                dsBacSi.add(bs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsBacSi;
    }
    
    public static void themBacSi(BacSiModel bacSi) throws ClassNotFoundException {
        String sql = "INSERT INTO BACSI(MaBacSi, Email, MaKhoa, HoTen, GioiTinh, NamSinh, DiaChi, SoDienThoai, CanCuoc, TrinhDo, Anh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            String maBacSi = generateMaBacSi();
            String matKhau = generatePassword(maBacSi, bacSi.getNamSinh());
            TaiKhoanCtrl.themTaiKhoan(bacSi.getEmail(), "BS", matKhau);         
            statement.setString(1,maBacSi);
            statement.setString(2,bacSi.getEmail());
            statement.setString(3,bacSi.getMaKhoa());
            statement.setString(4,bacSi.getHoTen());
            statement.setString(5,bacSi.getGioiTinh());
            statement.setString(6,bacSi.getNamSinh());
            statement.setString(7,bacSi.getDiaChi());
            statement.setString(8,bacSi.getSoDienThoai());
            statement.setString(9,bacSi.getCanCuoc());
            statement.setString(10,bacSi.getTrinhDo());
            statement.setString(11,bacSi.getAnh());
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static boolean kiemTraEmailCoTonTai(String email) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM BACSI WHERE Email=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraCanCuocCoTonTai(String canCuoc) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM BACSI WHERE CanCuoc=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, canCuoc);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return flag;
    }
    
    public static void capNhatBacSi(BacSiModel bs) throws ClassNotFoundException {
        String sql = "UPDATE BACSI SET Email=?, MaKhoa=?, HoTen=?, GioiTinh=?, NamSinh=?, DiaChi=?, SoDienThoai=?, CanCuoc=?, TrinhDo=?, Anh=? WHERE MaBacSi=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){           
            statement.setString(1, bs.getEmail());
            statement.setString(2, bs.getMaKhoa());
            statement.setString(3, bs.getHoTen());
            statement.setString(4, bs.getGioiTinh());
            statement.setString(5, bs.getNamSinh());
            statement.setString(6, bs.getDiaChi());
            statement.setString(7, bs.getSoDienThoai());
            statement.setString(8, bs.getCanCuoc());
            statement.setString(9, bs.getTrinhDo());
            statement.setString(10, bs.getAnh());
            statement.setString(11, bs.getMaBacSi());
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void xoaBacSi(BacSiModel bs) throws ClassNotFoundException {
        String sql = "UPDATE BACSI SET TrangThaiXoa=? WHERE MaBacSi=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){     
            statement.setBoolean(1, true);
            statement.setString(2, bs.getMaBacSi());
            statement.executeUpdate();
            TaiKhoanCtrl.xoaTaiKhoan(bs.getEmail());

        } catch (SQLException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static List<BacSiModel> timKiemBacSi(String tuKhoa) throws ClassNotFoundException {
        List<BacSiModel> ketQua = new ArrayList<>();
        String sql = "SELECT MaBacSi, Email, KHOA.MaKhoa, HoTen, GioiTinh, NamSinh, DiaChi, SoDienThoai, CanCuoc, TrinhDo, KHOA.TenKhoa "
                    + "FROM BACSI, KHOA WHERE BACSI.MaKhoa = KHOA.MaKhoa AND BacSi.TrangThaiXoa=0 "
                    + "AND(MaBacSi LIKE ? OR Email LIKE ? OR KHOA.MaKhoa LIKE ? OR HoTen LIKE ? OR GioiTinh LIKE ? OR NamSinh LIKE ? OR DiaChi LIKE ? OR SoDienThoai LIKE ? OR CanCuoc LIKE ? OR TrinhDo LIKE ? OR TenKhoa LIKE ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            String keyword = "%" + tuKhoa + "%";
            statement.setString(1, keyword);
            statement.setString(2, keyword);
            statement.setString(3, keyword);
            statement.setString(4, keyword);
            statement.setString(5, keyword);
            statement.setString(6, keyword);
            statement.setString(7, keyword);
            statement.setString(8, keyword);
            statement.setString(9, keyword);
            statement.setString(10, keyword);
            statement.setString(11, keyword);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                BacSiModel bs = new BacSiModel();
                bs.setMaBacSi(resultSet.getString("MaBacSi"));
                bs.setHoTen(resultSet.getString("HoTen"));
                bs.setGioiTinh(resultSet.getString("GioiTinh"));
                bs.setNamSinh(resultSet.getString("NamSinh"));
                bs.setDiaChi(resultSet.getString("DiaChi"));
                bs.setSoDienThoai(resultSet.getString("SoDienThoai"));
                bs.setCanCuoc(resultSet.getString("CanCuoc"));
                bs.setEmail(resultSet.getString("Email"));
                bs.setTrinhDo(resultSet.getString("TrinhDo"));
                bs.setMaKhoa(resultSet.getString("MaKhoa"));
                bs.setTenKhoa(resultSet.getString("TenKhoa"));

                ketQua.add(bs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BacSiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return ketQua;
    }
    
}
