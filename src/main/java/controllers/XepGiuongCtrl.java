package controllers;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.GiuongBenhModel;
import models.XepGiuongModel;

/**
 *
 * @author Phu Bao
 */
public class XepGiuongCtrl {

    public static String generateMaXepGiuong() {
        java.util.Date now = new java.util.Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String timeString = dateFormat.format(now);
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        String randomString = "MXG" + timeString + randomNumber;
        return randomString;
    }

    public static List<GiuongBenhModel> hienThiGiuongTrong() throws ClassNotFoundException {
        List<GiuongBenhModel> dsGiuongTrong = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "SELECT GB.MaGiuong, GB.MaPhong, PB.TenPhong, DG.TenLoaiPhong, GB.CoNguoi, DG.DonGia "
                    + "FROM GIUONGBENH AS GB "
                    + "JOIN PHONGBENH AS PB ON GB.MaPhong = PB.MaPhong "
                    + "JOIN DONGIAPHONGBENH AS DG ON DG.MaDonGia = PB.MaDonGia "
                    + "WHERE (GB.CoNguoi IS NULL OR GB.CoNguoi = '-') AND GB.TrangThaiXoa = 0 "
                    + "ORDER BY PB.TenPhong";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                GiuongBenhModel gb = new GiuongBenhModel(
                        resultSet.getString("MaGiuong"),
                        resultSet.getString("MaPhong"),
                        resultSet.getString("TenPhong"),
                        resultSet.getString("TenLoaiPhong"),
                        resultSet.getString("CoNguoi"),
                        resultSet.getInt("DonGia"));
                dsGiuongTrong.add(gb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(XepGiuongCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsGiuongTrong;
    }
    
    public static List<XepGiuongModel> hienThiGiuongDangCoNguoi() throws ClassNotFoundException {
        List<XepGiuongModel> dsGiuongCoNguoi = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "SELECT PB.MaPhong, PB.TenPhong, XG.MaXepGiuong, GB.MaGiuong, BA.MaBenhAn, BN.MaBenhNhan, BN.HoTen, XG.NgayNhapVien "
                    + "FROM XEPGIUONGBENH AS XG "
                    + "JOIN GIUONGBENH AS GB ON GB.MaGiuong = XG.MaGiuong "
                    + "JOIN PHONGBENH AS PB ON PB.MaPhong = GB.MaPhong "
                    + "JOIN BENHAN AS BA ON BA.MaBenhAn = XG.MaBenhAn "
                    + "JOIN BENHNHAN AS BN ON BA.MaBenhNhan = BN.MaBenhNhan "
                    + "WHERE (XG.XuatVien IS NULL OR XG.XuatVien = '-') AND XG.TrangThaiXoa = 0 "
                    + "ORDER BY XG.NgayNhapVien ";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                XepGiuongModel xg = new XepGiuongModel(
                        resultSet.getString("MaXepGiuong"),
                        resultSet.getString("MaGiuong"),
                        resultSet.getString("MaBenhAn"),
                        resultSet.getString("MaBenhNhan"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("MaPhong"),
                        resultSet.getString("TenPhong"),
                        resultSet.getDate("NgayNhapVien"));

                dsGiuongCoNguoi.add(xg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(XepGiuongCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsGiuongCoNguoi;
    }
    
    public static List<XepGiuongModel> sapXepGiuongDangCoNguoiTheoTenPhong() throws ClassNotFoundException {
        List<XepGiuongModel> dsGiuongCoNguoi = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "SELECT PB.MaPhong, PB.TenPhong, XG.MaXepGiuong, GB.MaGiuong, BA.MaBenhAn, BN.MaBenhNhan, BN.HoTen, XG.NgayNhapVien "
                    + "FROM XEPGIUONGBENH AS XG "
                    + "JOIN GIUONGBENH AS GB ON GB.MaGiuong = XG.MaGiuong "
                    + "JOIN PHONGBENH AS PB ON PB.MaPhong = GB.MaPhong "
                    + "JOIN BENHAN AS BA ON BA.MaBenhAn = XG.MaBenhAn "
                    + "JOIN BENHNHAN AS BN ON BA.MaBenhNhan = BN.MaBenhNhan "
                    + "WHERE (XG.XuatVien IS NULL OR XG.XuatVien = '-') AND XG.TrangThaiXoa = 0 "
                    + "ORDER BY PB.TenPhong ";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                XepGiuongModel xg = new XepGiuongModel(
                        resultSet.getString("MaXepGiuong"),
                        resultSet.getString("MaGiuong"),
                        resultSet.getString("MaBenhAn"),
                        resultSet.getString("MaBenhNhan"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("MaPhong"),
                        resultSet.getString("TenPhong"),
                        resultSet.getDate("NgayNhapVien"));

                dsGiuongCoNguoi.add(xg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(XepGiuongCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsGiuongCoNguoi;
    }

    public static boolean kiemTraTonTaiBenhNhan(String maBenhAn, String maBenhNhan) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT 1 "
                + "FROM XEPGIUONGBENH AS XG "
                + "JOIN BENHAN AS BA ON XG.MaBenhAn = BA.MaBenhAn "
                + "JOIN BENHNHAN AS BN ON BA.MaBenhNhan = BN.MaBenhNhan "
                + "WHERE (XG.XuatVien IS NULL OR XG.XuatVien = '-') AND BN.MaBenhNhan = ? AND BA.MaBenhAn = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maBenhNhan);
            statement.setString(2, maBenhAn);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongBenhCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void nhapVien(XepGiuongModel xg, GiuongBenhModel gb) throws ClassNotFoundException {
        String sql = "INSERT INTO XEPGIUONGBENH (MaXepGiuong, MaGiuong, MaBenhAn, NgayNhapVien) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            String mxg = generateMaXepGiuong();
            statement.setString(1, mxg);
            statement.setString(2, gb.getMaGiuong());
            statement.setString(3, xg.getMaBenhAn());
            statement.setDate(4, new java.sql.Date(xg.getNgayNhapVien().getTime()));

            statement.executeUpdate();
            GiuongBenhCtrl.nhapVien(gb.getMaGiuong());

        } catch (SQLException ex) {
            Logger.getLogger(XepGiuongCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Date layNgayNhapVien(String maXepGiuong) throws ClassNotFoundException {
        ResultSet resultSet = null;
        Date ngayNhapVien = null;
        String sql = "SELECT NgayNhapVien FROM XEPGIUONGBENH WHERE MaXepGiuong = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, maXepGiuong);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ngayNhapVien = resultSet.getDate("NgayNhapVien");
            }

        } catch (SQLException ex) {
            Logger.getLogger(XepGiuongCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ngayNhapVien;
    }

    public static void xuatVien(String maGiuong, String maXepGiuong) throws ClassNotFoundException {
         String sql = "UPDATE XEPGIUONGBENH SET NgayXuatVien=?, SoNgay=?, ThanhTien=?, XuatVien=? "
                    + "FROM XEPGIUONGBENH WHERE MaXepGiuong = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            LocalDate ngayHomNay = LocalDate.now();
            Date sqlDate = Date.valueOf(ngayHomNay);
            LocalDate ngayNhapVienLocalDate = layNgayNhapVien(maXepGiuong).toLocalDate();
            long khoangCachNgay = ChronoUnit.DAYS.between(ngayNhapVienLocalDate, ngayHomNay);
            int thanhTien = (int) (donGia(maGiuong) * khoangCachNgay);
            statement.setDate(1, sqlDate);
            statement.setInt(2, (int) khoangCachNgay);
            statement.setInt(3, thanhTien);
            statement.setString(4, "Đã xuất viện");
            statement.setString(5, maXepGiuong);
            statement.executeUpdate();
            GiuongBenhCtrl.khoiPhucTrangThaiGiuong(maGiuong);
        } catch (SQLException ex) {
            Logger.getLogger(XepGiuongCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaXepGiuong(String maXepGiuong, String maGiuong) throws ClassNotFoundException {
        String sql = "UPDATE XEPGIUONGBENH SET TrangThaiXoa=? WHERE MaXepGiuong=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            GiuongBenhCtrl.khoiPhucTrangThaiGiuong(maGiuong);
            statement.setBoolean(1, true);
            statement.setString(2, maXepGiuong);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(XepGiuongCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public static int donGia(String maPhong) throws ClassNotFoundException {
        String sql = "SELECT * FROM PHONGBENH AS PB "
                    + "JOIN DONGIAPHONGBENH AS DG ON PB.MaDonGia = DG.MaDonGia "
                    + "WHERE PB.MaPhong = ?";
        int donGia = 0;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            
            ResultSet resultSet = null;
            statement.setString(1, maPhong);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Lấy giá trị từ cột DonGia trong kết quả
                donGia = resultSet.getInt("DonGia");
            }
        } catch (SQLException ex) {
            Logger.getLogger(XepGiuongCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return donGia;
    }

    public static List<GiuongBenhModel> timKiemNhapVien(String tuKhoa) throws ClassNotFoundException {
        List<GiuongBenhModel> ketQua = new ArrayList<>();
        String sql = "SELECT GB.MaGiuong, PB.MaPhong, PB.TenPhong, DG.TenLoaiPhong,GB.CoNguoi, DG.DonGia "
                    + "FROM GIUONGBENH AS GB "
                    + "JOIN PHONGBENH AS PB ON GB.MaPhong = PB.MaPhong "
                    + "JOIN DONGIAPHONGBENH AS DG ON DG.MaDonGia = PB.MaDonGia "
                    + "AND (CoNguoi IS NULL OR CoNguoi = '-') "
                    + "AND (GB.MaGiuong LIKE ? OR PB.MaPhong LIKE ? OR PB.TenPhong LIKE ? OR DG.TenLoaiPhong LIKE ?)";
        ResultSet resultSet = null;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            String keyword = "%" + tuKhoa + "%";
            statement.setString(1, keyword);
            statement.setString(2, keyword);
            statement.setString(3, keyword);
            statement.setString(4, keyword);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maGiuong = resultSet.getString("MaGiuong");
                String maPhong = resultSet.getString("MaPhong");
                String tenPhong = resultSet.getString("TenPhong");
                String tenLoaiPhong = resultSet.getString("TenLoaiPhong");
                int donGia = resultSet.getInt("DonGia");
                String coNguoi = resultSet.getString("CoNguoi");
                GiuongBenhModel gb = new GiuongBenhModel(maGiuong, maPhong, tenPhong, tenLoaiPhong, coNguoi, donGia);
                ketQua.add(gb);
            }

        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }
    
    public static List<GiuongBenhModel> locPhongTheoLoai(String tuKhoa) throws ClassNotFoundException {
        List<GiuongBenhModel> ketQua = new ArrayList<>();
        String sql = "SELECT GB.MaGiuong, PB.MaPhong, PB.TenPhong, DG.TenLoaiPhong,GB.CoNguoi, DG.DonGia "
                    + "FROM GIUONGBENH AS GB "
                    + "JOIN PHONGBENH AS PB ON GB.MaPhong = PB.MaPhong "
                    + "JOIN DONGIAPHONGBENH AS DG ON DG.MaDonGia = PB.MaDonGia "
                    + "WHERE (CoNguoi IS NULL OR CoNguoi = '-') "
                    + "AND DG.TenLoaiPhong LIKE ?";
        ResultSet resultSet = null;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            String keyword = "%" + tuKhoa + "%";
            statement.setString(1, keyword);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maGiuong = resultSet.getString("MaGiuong");
                String maPhong = resultSet.getString("MaPhong");
                String tenPhong = resultSet.getString("TenPhong");
                String tenLoaiPhong = resultSet.getString("TenLoaiPhong");
                int donGia = resultSet.getInt("DonGia");
                String coNguoi = resultSet.getString("CoNguoi");
                GiuongBenhModel gb = new GiuongBenhModel(maGiuong, maPhong, tenPhong, tenLoaiPhong, coNguoi, donGia);
                ketQua.add(gb);
            }

        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    public static List<XepGiuongModel> timKiemGiuongDangCoNguoi(String tuKhoa) throws ClassNotFoundException {
        List<XepGiuongModel> dsKetQuaTimKiem = new ArrayList<>();
        String sql = "SELECT PB.MaPhong, PB.TenPhong, XG.MaXepGiuong, GB.MaGiuong, BA.MaBenhAn, "
                    + "BN.MaBenhNhan, BN.HoTen, XG.NgayNhapVien "
                    + "FROM XEPGIUONGBENH AS XG "
                    + "JOIN GIUONGBENH AS GB ON XG.MaGiuong = GB.MaGiuong "
                    + "JOIN PHONGBENH AS PB ON PB.MaPhong = GB.MaPhong "
                    + "JOIN BENHAN AS BA ON BA.MaBenhAn = XG.MaBenhAn "
                    + "JOIN BENHNHAN AS BN ON BN.MaBenhNhan = BA.MaBenhNhan "
                    + "WHERE (XG.XuatVien IS NULL OR XG.XuatVien = '-') "
                    + "AND (PB.MaPhong LIKE ? OR PB.TenPhong LIKE ? OR XG.MaXepGiuong LIKE ? "
                    + "OR GB.MaGiuong LIKE ? OR BA.MaBenhAn LIKE ? OR BN.MaBenhNhan LIKE ? OR BN.HoTen LIKE ?) "
                    + "ORDER BY XG.NgayNhapVien";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){

            // Thiết lập tham số cho câu truy vấn
            statement.setString(1, "%" + tuKhoa + "%");
            statement.setString(2, "%" + tuKhoa + "%");
            statement.setString(3, "%" + tuKhoa + "%");
            statement.setString(4, "%" + tuKhoa + "%");
            statement.setString(5, "%" + tuKhoa + "%");
            statement.setString(6, "%" + tuKhoa + "%");
            statement.setString(7, "%" + tuKhoa + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                XepGiuongModel xg = new XepGiuongModel(
                        resultSet.getString("MaXepGiuong"),
                        resultSet.getString("MaGiuong"),
                        resultSet.getString("MaBenhAn"),
                        resultSet.getString("MaBenhNhan"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("MaPhong"),
                        resultSet.getString("TenPhong"),
                        resultSet.getDate("NgayNhapVien"));
                dsKetQuaTimKiem.add(xg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(XepGiuongCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsKetQuaTimKiem;
    }

    public static String loaiPhong(String maGiuong) throws ClassNotFoundException {
        String loaiPhong = null;
        String sql = "SELECT GB.MaGiuong, DG.TenLoaiPhong "
                    + "FROM GIUONGBENH AS GB "
                    + "JOIN PHONGBENH AS PB ON GB.MaPhong = PB.MaPhong "
                    + "JOIN DONGIAPHONGBENH AS DG ON DG.MaDonGia = PB.MaDonGia "
                    + "WHERE GB.MaGiuong = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){   
            ResultSet resultSet = null;
            statement.setString(1, maGiuong);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                loaiPhong = resultSet.getString("TenLoaiPhong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(XepGiuongCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loaiPhong;
    }

    public static void doiGiuongBenh(String maGiuong, String maGiuongMoi, String maXepGiuong) throws ClassNotFoundException {
        String sql = "UPDATE XEPGIUONGBENH SET MaGiuong=? WHERE MaXepGiuong = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            // Làm trống giường cũ
            GiuongBenhCtrl.khoiPhucTrangThaiGiuong(maGiuong);
            // Cập nhập xếp giường
            statement.setString(1, maGiuongMoi);
            statement.setString(2, maXepGiuong);
            statement.executeUpdate();
            // Bệnh nhân nhập viện bằng giường mới
            GiuongBenhCtrl.nhapVien(maGiuongMoi);           
        } catch (SQLException ex) {
            Logger.getLogger(XepGiuongCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // * DSGiuongBenhKhaDungCtrl
    public static List<GiuongBenhModel> hienThiGiuongBenhKhaDung(String loaiPhong) throws ClassNotFoundException {
        List<GiuongBenhModel> dsGiuongKhaDung = new ArrayList<>();
        String sql = "SELECT GB.MaGiuong, GB.MaPhong, PB.TenPhong, DG.TenLoaiPhong, GB.CoNguoi, DG.DonGia "
                    + "FROM GIUONGBENH AS GB "
                    + "JOIN PHONGBENH AS PB ON GB.MaPhong = PB.MaPhong "
                    + "JOIN DONGIAPHONGBENH AS DG ON DG.MaDonGia = PB.MaDonGia "
                    + "WHERE (GB.CoNguoi IS NULL OR GB.CoNguoi = '-') AND GB.TrangThaiXoa = 0 AND DG.TenLoaiPhong = ? "
                    + "ORDER BY PB.TenPhong";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){           
            statement.setString(1,loaiPhong);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                GiuongBenhModel gb = new GiuongBenhModel(
                        resultSet.getString("MaGiuong"),
                        resultSet.getString("MaPhong"),
                        resultSet.getString("TenPhong"),
                        resultSet.getString("TenLoaiPhong"),
                        resultSet.getString("CoNguoi"),
                        resultSet.getInt("DonGia"));
                dsGiuongKhaDung.add(gb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(XepGiuongCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsGiuongKhaDung;
    }
    
    public static List<GiuongBenhModel> timKiemGiuongBenhKhaDung(String loaiPhong, String tuKhoa) throws ClassNotFoundException {
        List<GiuongBenhModel> ketQua = new ArrayList<>();
        String sql = "SELECT GB.MaGiuong, PB.MaPhong, PB.TenPhong, DG.TenLoaiPhong,GB.CoNguoi, DG.DonGia "
                    + "FROM GIUONGBENH AS GB "
                    + "JOIN PHONGBENH AS PB ON GB.MaPhong = PB.MaPhong "
                    + "JOIN DONGIAPHONGBENH AS DG ON DG.MaDonGia = PB.MaDonGia "
                    + "AND (GB.CoNguoi IS NULL OR GB.CoNguoi = '-') AND DG.TenLoaiPhong = ?"
                    + "AND (GB.MaGiuong LIKE ? OR PB.MaPhong LIKE ? OR PB.TenPhong LIKE ? OR DG.TenLoaiPhong LIKE ?)";
        ResultSet resultSet = null;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, loaiPhong);
            String keyword = "%" + tuKhoa + "%";
            statement.setString(2, keyword);
            statement.setString(3, keyword);
            statement.setString(4, keyword);
            statement.setString(5, keyword);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maGiuong = resultSet.getString("MaGiuong");
                String maPhong = resultSet.getString("MaPhong");
                String tenPhong = resultSet.getString("TenPhong");
                String tenLoaiPhong = resultSet.getString("TenLoaiPhong");
                int donGia = resultSet.getInt("DonGia");
                String coNguoi = resultSet.getString("CoNguoi");
                GiuongBenhModel gb = new GiuongBenhModel(maGiuong, maPhong, tenPhong, tenLoaiPhong, coNguoi, donGia);
                ketQua.add(gb);
            }

        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }
    // End DSGiuongBenhKhaDungCtrl
}
