package controllers;

import database.ConnectDB;
import java.io.FileOutputStream;
import java.io.IOException;
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
import models.NhomDichVuCLSModelTest;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NhomDichVuCLSCtrlTest {

    public static List<NhomDichVuCLSModelTest> timTatNhomDichVuCLS() throws ClassNotFoundException {
        List<NhomDichVuCLSModelTest> dsNhomDichVu = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM NHOMDICHVUCLS";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                NhomDichVuCLSModelTest dvkb = new NhomDichVuCLSModelTest(
                        resultSet.getString("MaNhomDichVuCLS"),
                        resultSet.getString("TenNhomDichVuCLS"),
                        resultSet.getString("TrangThai"));
                dsNhomDichVu.add(dvkb);
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

        return dsNhomDichVu;
    }

    public static void themNhomDichVuCLS(NhomDichVuCLSModelTest dv) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO NHOMDICHVUCLS (MaNhomDichVuCLS, TenNhomDichVuCLS, TrangThai) VALUES (?, ?, ?);";
            statement = connection.prepareStatement(sql);

            statement.setString(1, dv.getMaNhomDichVuCLS());
            statement.setString(2, dv.getTenNhomDichVuCLS());
            statement.setString(3, dv.getTrangThai());

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

    public static void CapNhatNhomDichVuCLS(NhomDichVuCLSModelTest dv) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE NHOMDICHVUCLS SET TenNhomDichVuCLS=?, TrangThai=? WHERE MaNhomDichVuCLS=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, dv.getTenNhomDichVuCLS());
            statement.setString(2, dv.getTrangThai());
            statement.setString(3, dv.getMaNhomDichVuCLS());

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

    public static void xoaNhomDichVuCLS(String maNhomDichVu) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "DELETE FROM NHOMDICHVUCLS WHERE MaNhomDichVuCLS=?";
            statement = connection.prepareStatement(sql);

            statement.setString(1, maNhomDichVu);

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

    public static List<NhomDichVuCLSModelTest> timTatCaDichVuTheoDK(String timKiem) throws ClassNotFoundException {
        List<NhomDichVuCLSModelTest> dsNhomDichVu = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM NHOMDICHVUCLS WHERE MaNhomDichVuCLS LIKE ? OR TenNhomDichVuCLS LIKE ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + timKiem + "%");
            statement.setString(2, "%" + timKiem + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                NhomDichVuCLSModelTest dvkb = new NhomDichVuCLSModelTest(
                        resultSet.getString("MaNhomDichVuCLS"),
                        resultSet.getString("TenNhomDichVuCLS"),
                        resultSet.getString("TrangThai"));
                dsNhomDichVu.add(dvkb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BenhNhanCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return dsNhomDichVu;
    }

    public static void exportToExcel(List<NhomDichVuCLSModelTest> dsDichVu, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachNhomDichVuCLS");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("MaNhomDichVuCLS");
            headerRow.createCell(1).setCellValue("TenNhomDichVuCLS");
            headerRow.createCell(2).setCellValue("TrangThai");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (NhomDichVuCLSModelTest dv : dsDichVu) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(dv.getMaNhomDichVuCLS());
                row.createCell(1).setCellValue(dv.getTenNhomDichVuCLS());
                row.createCell(2).setCellValue(dv.getTrangThai());
            }

            // Xuất workbook ra file Excel
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateMaNhomDichVuCLS() {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String timeString = dateFormat.format(now);

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String randomString = "NDVC" + timeString + randomNumber;
        return randomString;
    }
}
