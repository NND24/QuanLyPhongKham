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
import models.DichVuCLSModel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class DichVuCLSCtrl {

    public static List<DichVuCLSModel> timTatCaDichVu() throws ClassNotFoundException {
        List<DichVuCLSModel> dsDichVu = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT MaDichVu, TenDichVu, DICHVUCLS.MaNhomDichVu, TenNhomDichVu, GiaTien, GiaBaoHiem, DICHVUCLS.TrangThai FROM DICHVUCLS, NHOMDICHVUCLS WHERE DICHVUCLS.MaNhomDichVu=NHOMDICHVUCLS.MaNhomDichVu";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                DichVuCLSModel dv = new DichVuCLSModel(
                        resultSet.getString("MaDichVu"),
                        resultSet.getString("TenDichVu"),
                        resultSet.getString("MaNhomDichVu"),
                        resultSet.getString("TenNhomDichVu"),
                        resultSet.getInt("GiaTien"),
                        resultSet.getInt("GiaBaoHiem"),
                        resultSet.getString("TrangThai"));
                dsDichVu.add(dv);
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

        return dsDichVu;
    }

    public static List<DichVuCLSModel> timTatCaDichVuTheoMaNhom(String maNhomDichVu) throws ClassNotFoundException {
        List<DichVuCLSModel> dsDichVu = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT MaDichVu, TenDichVu, DICHVUCLS.MaNhomDichVu, TenNhomDichVu, GiaTien, GiaBaoHiem, DICHVUCLS.TrangThai FROM DICHVUCLS, NHOMDICHVUCLS WHERE DICHVUCLS.MaNhomDichVu=NHOMDICHVUCLS.MaNhomDichVu AND DICHVUCLS.MaNhomDichVu=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maNhomDichVu);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DichVuCLSModel dv = new DichVuCLSModel(
                        resultSet.getString("MaDichVu"),
                        resultSet.getString("TenDichVu"),
                        resultSet.getString("MaNhomDichVu"),
                        resultSet.getString("TenNhomDichVu"),
                        resultSet.getInt("GiaTien"),
                        resultSet.getInt("GiaBaoHiem"),
                        resultSet.getString("TrangThai"));
                dsDichVu.add(dv);
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

        return dsDichVu;
    }

    public static List<DichVuCLSModel> timTatCaDichVuTheoDK(String timKiem, String maNhomDichVu) throws ClassNotFoundException {
        List<DichVuCLSModel> dsDichVu = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();
            if (!timKiem.isEmpty() && maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                String sql = "SELECT MaDichVu, TenDichVu, DICHVUCLS.MaNhomDichVu, TenNhomDichVu, GiaTien, GiaBaoHiem, DICHVUCLS.TrangThai FROM DICHVUCLS, NHOMDICHVUCLS WHERE DICHVUCLS.MaNhomDichVu=NHOMDICHVUCLS.MaNhomDichVu \n"
                        + "AND (MaDichVu LIKE ? OR TenDichVu LIKE ? OR DICHVUCLS.MaNhomDichVu LIKE ? OR TenNhomDichVu LIKE ?)";

                statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + timKiem + "%");
                statement.setString(2, "%" + timKiem + "%");
                statement.setString(3, "%" + timKiem + "%");
                statement.setString(4, "%" + timKiem + "%");

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    DichVuCLSModel dv = new DichVuCLSModel(
                            resultSet.getString("MaDichVu"),
                            resultSet.getString("TenDichVu"),
                            resultSet.getString("MaNhomDichVu"),
                            resultSet.getString("TenNhomDichVu"),
                            resultSet.getInt("GiaTien"),
                            resultSet.getInt("GiaBaoHiem"),
                            resultSet.getString("TrangThai"));
                    dsDichVu.add(dv);
                }
            } else if (timKiem.isEmpty() && !maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                String sql = "SELECT MaDichVu, TenDichVu, DICHVUCLS.MaNhomDichVu, TenNhomDichVu, GiaTien, GiaBaoHiem, DICHVUCLS.TrangThai FROM DICHVUCLS, NHOMDICHVUCLS WHERE DICHVUCLS.MaNhomDichVu=NHOMDICHVUCLS.MaNhomDichVu \n"
                        + " AND DICHVUCLS.MaNhomDichVu = ?";

                statement = connection.prepareStatement(sql);
                statement.setString(1, maNhomDichVu);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    DichVuCLSModel dv = new DichVuCLSModel(
                            resultSet.getString("MaDichVu"),
                            resultSet.getString("TenDichVu"),
                            resultSet.getString("MaNhomDichVu"),
                            resultSet.getString("TenNhomDichVu"),
                            resultSet.getInt("GiaTien"),
                            resultSet.getInt("GiaBaoHiem"),
                            resultSet.getString("TrangThai"));
                    dsDichVu.add(dv);
                }
            } else if (!timKiem.isEmpty() && !maNhomDichVu.equals("---Nhóm dịch vụ---")) {
                String sql = "SELECT MaDichVu, TenDichVu, DICHVUCLS.MaNhomDichVu, TenNhomDichVu, GiaTien, GiaBaoHiem, DICHVUCLS.TrangThai FROM DICHVUCLS, NHOMDICHVUCLS WHERE DICHVUCLS.MaNhomDichVu=NHOMDICHVUCLS.MaNhomDichVu \n"
                        + "AND (MaDichVu LIKE ? OR TenDichVu LIKE ? OR DICHVUCLS.MaNhomDichVu LIKE ? OR TenNhomDichVu LIKE ?) AND DICHVUCLS.MaNhomDichVu = ?";

                statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + timKiem + "%");
                statement.setString(2, "%" + timKiem + "%");
                statement.setString(3, "%" + timKiem + "%");
                statement.setString(4, "%" + timKiem + "%");
                statement.setString(5, maNhomDichVu);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    DichVuCLSModel dv = new DichVuCLSModel(
                            resultSet.getString("MaDichVu"),
                            resultSet.getString("TenDichVu"),
                            resultSet.getString("MaNhomDichVu"),
                            resultSet.getString("TenNhomDichVu"),
                            resultSet.getInt("GiaTien"),
                            resultSet.getInt("GiaBaoHiem"),
                            resultSet.getString("TrangThai"));
                    dsDichVu.add(dv);
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

        return dsDichVu;
    }

    public static List<DichVuCLSModel> timTatCaDichVuTheoMa(String maDichVu) throws ClassNotFoundException {
        List<DichVuCLSModel> dsDichVu = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT MaDichVu, TenDichVu, DICHVUCLS.MaNhomDichVu, TenNhomDichVu, GiaTien, GiaBaoHiem, DICHVUCLS.TrangThai FROM DICHVUCLS, NHOMDICHVUCLS WHERE DICHVUCLS.MaNhomDichVu=NHOMDICHVUCLS.MaNhomDichVu AND DICHVUCLS.MaDichVu=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maDichVu);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DichVuCLSModel dv = new DichVuCLSModel(
                        resultSet.getString("MaDichVu"),
                        resultSet.getString("TenDichVu"),
                        resultSet.getString("MaNhomDichVu"),
                        resultSet.getString("TenNhomDichVu"),
                        resultSet.getInt("GiaTien"),
                        resultSet.getInt("GiaBaoHiem"),
                        resultSet.getString("TrangThai"));
                dsDichVu.add(dv);
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

        return dsDichVu;
    }

    public static void ThemDichVuCLS(DichVuCLSModel dv) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO DICHVUCLS (MaDichVu, TenDichVu, MaNhomDichVu, GiaTien, GiaBaoHiem, TrangThai) VALUES (?, ?, ?, ?, ?, ?);";
            statement = connection.prepareStatement(sql);

            statement.setString(1, dv.getMaDichVu());
            statement.setString(2, dv.getTenDichVu());
            statement.setString(3, dv.getMaNhomDichVu());
            statement.setInt(4, dv.getGiaTien());
            statement.setInt(5, dv.getGiaBaoHiem());
            statement.setString(6, dv.getTrangThai());

            statement.executeUpdate();

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
    }

    public static void CapNhatDichVuCLS(DichVuCLSModel dv) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE DICHVUCLS SET TenDichVu=?, MaNhomDichVu=?, GiaTien=?, GiaBaoHiem=?, TrangThai=? WHERE MaDichVu=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, dv.getTenDichVu());
            statement.setString(2, dv.getMaNhomDichVu());
            statement.setInt(3, dv.getGiaTien());
            statement.setInt(4, dv.getGiaBaoHiem());
            statement.setString(5, dv.getTrangThai());
            statement.setString(6, dv.getMaDichVu());

            statement.executeUpdate();
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
    }

    public static void XoaDichVuCLS(String maDichVu) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "DELETE FROM DICHVUCLS WHERE MaDichVu=?";
            statement = connection.prepareStatement(sql);

            statement.setString(1, maDichVu);

            statement.executeUpdate();

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
    }

    public static void exportToExcel(List<DichVuCLSModel> dsDichVu, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachDichVuCLS");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("MaDichVu");
            headerRow.createCell(1).setCellValue("TenDichVu");
            headerRow.createCell(2).setCellValue("MaNhomDichVu");
            headerRow.createCell(3).setCellValue("TenNhomDichVu");
            headerRow.createCell(4).setCellValue("GiaTien");
            headerRow.createCell(5).setCellValue("GiaBaoHiem");
            headerRow.createCell(6).setCellValue("TrangThai");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (DichVuCLSModel dv : dsDichVu) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(dv.getMaDichVu());
                row.createCell(1).setCellValue(dv.getTenDichVu());
                row.createCell(2).setCellValue(dv.getMaNhomDichVu());
                row.createCell(3).setCellValue(dv.getTenNhomDichVu());
                row.createCell(4).setCellValue(dv.getGiaTien());
                row.createCell(5).setCellValue(dv.getGiaBaoHiem());
                row.createCell(6).setCellValue(dv.getTrangThai());
            }

            // Xuất workbook ra file Excel
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateMaDichVuCLS() {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String timeString = dateFormat.format(now);

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String randomString = "DVC" + timeString + randomNumber;
        return randomString;
    }
}
