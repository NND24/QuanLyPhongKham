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
import models.NhomDichVuKhamBenhModelTest;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NhomDichVuKhamBenhCtrlTest {

    public static List<NhomDichVuKhamBenhModelTest> timTatNhomDichVuKhamBenh() throws ClassNotFoundException {
        List<NhomDichVuKhamBenhModelTest> dsNhomDichVuKhamBenh = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM NHOMDICHVUKB";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                NhomDichVuKhamBenhModelTest dvkb = new NhomDichVuKhamBenhModelTest(
                        resultSet.getString("MaNhomDichVuKB"),
                        resultSet.getString("TenNhomDichVuKB"),
                        resultSet.getString("TrangThai"));
                dsNhomDichVuKhamBenh.add(dvkb);
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

        return dsNhomDichVuKhamBenh;
    }

    public static void themNhomDichVuKhamBenh(NhomDichVuKhamBenhModelTest dvkb) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO NHOMDICHVUKB (MaNhomDichVuKB, TenNhomDichVuKB, TrangThai) VALUES (?, ?, ?);";
            statement = connection.prepareStatement(sql);

            statement.setString(1, dvkb.getMaNhomDichVuKB());
            statement.setString(2, dvkb.getTenNhomDichVuKB());
            statement.setString(3, dvkb.getTrangThai());

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

    public static void capNhatNhomDichVuKhamBenh(NhomDichVuKhamBenhModelTest dvkb) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE NHOMDICHVUKB SET TenNhomDichVuKB=?, TrangThai=? WHERE MaNhomDichVuKB=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, dvkb.getTenNhomDichVuKB());
            statement.setString(2, dvkb.getTrangThai());
            statement.setString(3, dvkb.getMaNhomDichVuKB());

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

    public static void xoaNhomDichVuKhamBenh(String maNhomDichVu) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "DELETE FROM NHOMDICHVUKB WHERE MaNhomDichVuKB=?";
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

    public static List<NhomDichVuKhamBenhModelTest> timTatCaDichVuTheoDK(String timKiem) throws ClassNotFoundException {
        List<NhomDichVuKhamBenhModelTest> dsNhomDichVu = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM NHOMDICHVUKB WHERE MaNhomDichVuKB LIKE ? OR TenNhomDichVuKB LIKE ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + timKiem + "%");
            statement.setString(2, "%" + timKiem + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                NhomDichVuKhamBenhModelTest dvkb = new NhomDichVuKhamBenhModelTest(
                        resultSet.getString("MaNhomDichVuKB"),
                        resultSet.getString("TenNhomDichVuKB"),
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

    public static void exportToExcel(List<NhomDichVuKhamBenhModelTest> dsDichVu, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachNhomDichVuKhamBenh");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("MaNhomDichVuKB");
            headerRow.createCell(1).setCellValue("TenNhomDichVuKB");
            headerRow.createCell(2).setCellValue("TrangThai");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (NhomDichVuKhamBenhModelTest dv : dsDichVu) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(dv.getMaNhomDichVuKB());
                row.createCell(1).setCellValue(dv.getTenNhomDichVuKB());
                row.createCell(2).setCellValue(dv.getMaNhomDichVuKB());
            }

            // Xuất workbook ra file Excel
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateMaNhomDichVuKhamBenh() {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String timeString = dateFormat.format(now);

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String randomString = "NDVK" + timeString + randomNumber;
        return randomString;
    }
}
