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
import models.PhongBenhModel;

/**
 *
 * @author Phu Bao
 */
public class PhongBenhCtrl {

    public static String generateMaPhongBenh() {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String timeString = dateFormat.format(now);

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String randomString = "PHG" + timeString + randomNumber;
        return randomString;
    }

    public static String taoTenPhong() throws ClassNotFoundException {
        String tp = "P" + (hienThiTatCa().size() + 1);
        return tp;
    }

    public static List<PhongBenhModel> hienThiTatCa() throws ClassNotFoundException {
        List<PhongBenhModel> dsPhongBenh = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "SELECT PB.MaPhong, YT.MaYTa, YT.HoTen, DG.MaDonGia, "
                    + "DG.DonGia, PB.TenPhong, PB.SoGiuong, DG.TenLoaiPhong, PB.TrangThaiXoa "
                    + "FROM PHONGBENH AS PB, DONGIAPHONGBENH AS DG, YTA AS YT "
                    + "WHERE PB.MaDonGia =  DG.MaDonGia "
                    + "AND PB.MaYTa = YT.MaYTa AND PB.TrangThaiXoa = 0 "
                    + "ORDER BY TenPhong";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                PhongBenhModel pb = new PhongBenhModel(
                        resultSet.getString("MaPhong"),
                        resultSet.getString("MaYTa"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("MaDonGia"),
                        resultSet.getString("TenPhong"),
                        resultSet.getString("TenLoaiPhong"),
                        resultSet.getInt("DonGia"),
                        resultSet.getInt("SoGiuong"),
                        resultSet.getBoolean("TrangThaiXoa"));
                dsPhongBenh.add(pb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsPhongBenh;
    }

    public static void themPhongBenh(PhongBenhModel pb) throws ClassNotFoundException {
        String sql = "INSERT INTO PHONGBENH(MaPhong, MaYTa, MaDonGia, TenPhong, SoGiuong) VALUES (?, ? ,?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            String mp = generateMaPhongBenh();
            String tp = taoTenPhong();
            statement.setString(1, mp);
            statement.setString(2, pb.getMaYTa());
            statement.setString(3, pb.getMaDonGia());
            statement.setString(4, tp);
            statement.setInt(5, pb.getSoGiuong());
            statement.executeUpdate();
            themGiuongBenhVaoPhong(pb, mp);
        } catch (SQLException ex) {
            Logger.getLogger(PhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void themGiuongBenhVaoPhong(PhongBenhModel pb, String maPhong) throws ClassNotFoundException {
        for (int soGiuong = 0; soGiuong < pb.getSoGiuong(); soGiuong++) {
            GiuongBenhCtrl.themGiuongBenh(maPhong);
        }
    }

    public static boolean kiemTraPhongBenhCoNguoi(String maPhong) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT GB.CoNguoi FROM PHONGBENH PH "
                + "JOIN GIUONGBENH GB ON PH.MaPhong = GB.MaPhong "
                + "WHERE PH.MaPhong = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maPhong);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String coNguoi = resultSet.getString("CoNguoi");
                if (coNguoi != null && !"-".equals(coNguoi) && !coNguoi.isEmpty()) {
                    flag = true;
                    break; // Không cần tiếp tục duyệt các kết quả khác nếu đã tìm thấy một giá trị hợp lệ
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void xoaPhongBenh(String maPhong) throws ClassNotFoundException {
        String sql = "UPDATE PHONGBENH SET TrangThaiXoa=? WHERE MaPhong=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, true);
            statement.setString(2, maPhong);
            statement.executeUpdate();
            GiuongBenhCtrl.xoaGiuongBenhTrongPhong(maPhong);
            capNhatTenPhong();

        } catch (SQLException ex) {
            Logger.getLogger(PhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatTenPhong() throws ClassNotFoundException {
        String sql = "UPDATE PHONGBENH SET TenPhong=? WHERE MaPhong=? ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            List<PhongBenhModel> dsPhongBenh = hienThiTatCa();
            int count = 0;
            //Cập nhật Tên Phòng trong PHONGBENH
            for (int i = 0; i < dsPhongBenh.size(); i++) {
                PhongBenhModel phong = dsPhongBenh.get(i);
                count += 1;
                String tp = "P" + count;
                statement.setString(1, tp);
                statement.setString(2, phong.getMaPhong());
                statement.executeUpdate();

            }

        } catch (SQLException ex) {
            Logger.getLogger(PhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Cập nhật số giường
    //- Tăng số giường
    public static void boSungGiuong(int soGiuongCanThem, String maPhong) throws ClassNotFoundException {
        for (int soGiuong = 0; soGiuong < soGiuongCanThem; soGiuong++) {
            GiuongBenhCtrl.themGiuongBenh(maPhong);
        }
    }

    public static boolean themGiuongBenh(PhongBenhModel pb, int soGiuongMoi) throws ClassNotFoundException {
        String sql = "SELECT GB.TrangThaiXoa FROM PHONGBENH PH "
                + "JOIN GIUONGBENH GB ON PH.MaPhong = GB.MaPhong "
                + "WHERE PH.MaPhong = ?";
        int count = 0;
        int soGiuongCanThem = soGiuongMoi - pb.getSoGiuong();
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pb.getMaPhong());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                boolean trangThaiXoa = resultSet.getBoolean("TrangThaiXoa");
                if (trangThaiXoa) {
                    count += 1;
                }
            }
            //Nếu tất cả trạng thái xóa của giường trong phòng bệnh là false
            if (count == 0) {
                boSungGiuong(soGiuongCanThem, pb.getMaPhong());
            } //Nếu có giường có trạng thái xóa là true thì khôi phục lại giường đó         
            else {
                //Trường hợp có đủ số giường để khôi phục
                if (count >= soGiuongCanThem) {
                    GiuongBenhCtrl.khoiPhucTrangThaiXoa(pb.getMaPhong(), soGiuongCanThem);
                } //Trường hợp có số giường khôi phục nhưng không đủ
                else {
                    int soGiuongKhoiPhuc = count;
                    int soGiuongBoSung = soGiuongCanThem - count;
                    //Khôi phục giường đã xóa
                    GiuongBenhCtrl.khoiPhucTrangThaiXoa(pb.getMaPhong(), soGiuongKhoiPhuc);
                    //Bổ sung giường
                    boSungGiuong(soGiuongBoSung, pb.getMaPhong());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    //- Giảm số giường
    public static boolean giamGiuongBenh(PhongBenhModel pb, int soGiuongMoi) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT GB.TrangThaiXoa, GB.CoNguoi FROM PHONGBENH PH "
                + "JOIN GIUONGBENH GB ON PH.MaPhong = GB.MaPhong "
                + "WHERE GB.TrangThaiXoa=0 AND (GB.CoNguoi='-' OR GB.CoNguoi IS NULL) "
                + "AND PH.MaPhong = ?";
        int count = 0;
        int soGiuongCanGiam = pb.getSoGiuong() - soGiuongMoi;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pb.getMaPhong());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                boolean trangThaiXoa = resultSet.getBoolean("TrangThaiXoa");
                String coNguoi = resultSet.getString("CoNguoi");
                if (!trangThaiXoa && (coNguoi == null || coNguoi.equalsIgnoreCase("-"))) {
                    count += 1;
                }
            }
            //*Chỉ có thể giảm nếu số giường còn trống nhiều hơn hoặc bằng số giường cần giảm
            if (count >= soGiuongCanGiam) {
                GiuongBenhCtrl.giamGiuongBenh(pb.getMaPhong(), soGiuongCanGiam);
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    private static boolean chinhSoGiuong(PhongBenhModel pb, int soGiuongMoi) throws ClassNotFoundException {
        boolean flag = false;
        if (soGiuongMoi >= pb.getSoGiuong()) {
            if (themGiuongBenh(pb, soGiuongMoi)) {
                return true;
            }
        } else if (soGiuongMoi < pb.getSoGiuong()) {
            if (giamGiuongBenh(pb, soGiuongMoi)) {
                flag = true;
            }
        }
        return flag;
    }

    public static boolean capNhatPhongBenh(PhongBenhModel pb, PhongBenhModel pbDaChon) throws ClassNotFoundException {
        if (chinhSoGiuong(pbDaChon, pb.getSoGiuong())) {
            String sql = "UPDATE PHONGBENH SET MaYTa=?, MaDonGia=?, SoGiuong=? WHERE MaPhong=?";
            try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, pb.getMaYTa());
                statement.setString(2, pb.getMaDonGia());
                statement.setInt(3, pb.getSoGiuong());
                statement.setString(4, pbDaChon.getMaPhong());
                statement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(PhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;
    }

    public static List<PhongBenhModel> timKiemPhongBenh(String tuKhoa) throws ClassNotFoundException {
        List<PhongBenhModel> ketQuaTimKiem = new ArrayList<>();
        String sql = "SELECT PB.MaPhong, YT.MaYTa, YT.HoTen, DG.MaDonGia, "
                + "DG.DonGia, PB.TenPhong, PB.SoGiuong, DG.TenLoaiPhong, PB.TrangThaiXoa "
                + "FROM PHONGBENH AS PB, DONGIAPHONGBENH AS DG, YTA AS YT "
                + "WHERE PB.MaDonGia =  DG.MaDonGia "
                + "AND PB.MaYTa = YT.MaYTa AND PB.TrangThaiXoa = 0 "
                + "AND (PB.MaPhong LIKE ? OR YT.MaYTa LIKE ? OR YT.HoTen LIKE ? "
                + "OR DG.MaDonGia LIKE ? OR PB.TenPhong LIKE ? OR DG.TenLoaiPhong LIKE ?) "
                + "ORDER BY TenPhong";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + tuKhoa + "%");
            statement.setString(2, "%" + tuKhoa + "%");
            statement.setString(3, "%" + tuKhoa + "%");
            statement.setString(4, "%" + tuKhoa + "%");
            statement.setString(5, "%" + tuKhoa + "%");
            statement.setString(6, "%" + tuKhoa + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PhongBenhModel pb = new PhongBenhModel(
                        resultSet.getString("MaPhong"),
                        resultSet.getString("MaYTa"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("MaDonGia"),
                        resultSet.getString("TenPhong"),
                        resultSet.getString("TenLoaiPhong"),
                        resultSet.getInt("DonGia"),
                        resultSet.getInt("SoGiuong"),
                        resultSet.getBoolean("TrangThaiXoa"));
                ketQuaTimKiem.add(pb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQuaTimKiem;
    }

}
