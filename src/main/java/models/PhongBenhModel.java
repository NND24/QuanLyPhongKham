package models;

/**
 *
 * @author Phu Bao
 */
public class PhongBenhModel {
    private String maPhong, maYTa, tenYTa, maDonGia, tenPhong, loaiPhong;
    private int donGia, soGiuong;
    private boolean trangThaiXoa;

    public PhongBenhModel() {
    }

    public PhongBenhModel(String maYTa, String maDonGia, int soGiuong) {
        this.maYTa = maYTa;
        this.maDonGia = maDonGia;
        this.soGiuong = soGiuong;
    }
        
    public PhongBenhModel(String maPhong, String maYTa, String tenYTa, String maDonGia, String tenPhong, String loaiPhong, int donGia, int soGiuong, boolean trangThaiXoa) {
        this.maPhong = maPhong;
        this.maYTa = maYTa;
        this.tenYTa = tenYTa;
        this.maDonGia = maDonGia;
        this.tenPhong = tenPhong;
        this.loaiPhong = loaiPhong;
        this.donGia = donGia;
        this.soGiuong = soGiuong;
        this.trangThaiXoa = trangThaiXoa;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaYTa() {
        return maYTa;
    }

    public void setMaYTa(String maYTa) {
        this.maYTa = maYTa;
    }

    public String getTenYTa() {
        return tenYTa;
    }

    public void setTenYTa(String tenYTa) {
        this.tenYTa = tenYTa;
    }

    public String getMaDonGia() {
        return maDonGia;
    }

    public void setMaDonGia(String maDonGia) {
        this.maDonGia = maDonGia;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoGiuong() {
        return soGiuong;
    }

    public void setSoGiuong(int soGiuong) {
        this.soGiuong = soGiuong;
    }

    public boolean isTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(boolean trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }
   
}
