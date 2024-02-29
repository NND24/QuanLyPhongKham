package models;

public class ChiDinhModel {

    private String maChiDinh, maBacSi, maBenhAn, maDichVuCLS, tenDichVuCLS, maNhomDichVuCLS, tenNhomDichVuCLS;
    private int soLuong, donGia, thanhTien;
    private String ghiChu, ketQua;

    public ChiDinhModel(String maChiDinh, String maBacSi, String maBenhAn, String maDichVuCLS, int soLuong, int donGia, int thanhTien, String ghiChu) {
        this.maChiDinh = maChiDinh;
        this.maBacSi = maBacSi;
        this.maBenhAn = maBenhAn;
        this.maDichVuCLS = maDichVuCLS;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.ghiChu = ghiChu;
    }

    public ChiDinhModel(String maChiDinh, String maDichVuCLS, String ghiChu, int soLuong, int thanhTien) {
        this.maChiDinh = maChiDinh;
        this.maDichVuCLS = maDichVuCLS;
        this.ghiChu = ghiChu;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public ChiDinhModel(String maChiDinh, String ketQua, String maDichVuCLS, String tenDichVuCLS, String maNhomDichVuCLS, String tenNhomDichVuCLS, int soLuong, int donGia, int thanhTien, String ghiChu) {
        this.maChiDinh = maChiDinh;
        this.maDichVuCLS = maDichVuCLS;
        this.tenDichVuCLS = tenDichVuCLS;
        this.maNhomDichVuCLS = maNhomDichVuCLS;
        this.tenNhomDichVuCLS = tenNhomDichVuCLS;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.ghiChu = ghiChu;
        this.ketQua = ketQua;
    }

    public ChiDinhModel(String maChiDinh, String maBacSi, String ketQua) {
        this.maChiDinh = maChiDinh;
        this.maBacSi = maBacSi;
        this.ketQua = ketQua;
    }

    public String getMaNhomDichVuCLS() {
        return maNhomDichVuCLS;
    }

    public void setMaNhomDichVuCLS(String maNhomDichVuCLS) {
        this.maNhomDichVuCLS = maNhomDichVuCLS;
    }

    public String getTenNhomDichVuCLS() {
        return tenNhomDichVuCLS;
    }

    public void setTenNhomDichVuCLS(String tenNhomDichVuCLS) {
        this.tenNhomDichVuCLS = tenNhomDichVuCLS;
    }

    public String getMaBacSi() {
        return maBacSi;
    }

    public void setMaBacSi(String maBacSi) {
        this.maBacSi = maBacSi;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    public String getTenDichVuCLS() {
        return tenDichVuCLS;
    }

    public void setTenDichVuCLS(String tenDichVuCLS) {
        this.tenDichVuCLS = tenDichVuCLS;
    }

    public String getMaChiDinh() {
        return maChiDinh;
    }

    public void setMaChiDinh(String maChiDinh) {
        this.maChiDinh = maChiDinh;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaDichVuCLS() {
        return maDichVuCLS;
    }

    public void setMaDichVu(String maDichVuCLS) {
        this.maDichVuCLS = maDichVuCLS;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.soLuong = SoLuong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

}
