package models;

public class DonThuocModel {

    private String maDonThuoc, maBenhAn, maBenhNhan, maThuoc, tenThuoc, maNhomThuoc, tenNhomThuoc, duongDung, cachDung;
    private int soNgay, soLuong, sang, trua, chieu, toi, donGia, thanhTien;

    public DonThuocModel(String maDonThuoc, String maBenhAn, String maBenhNhan, String maThuoc, String tenThuoc, String duongDung, String cachDung, int soNgay, int soLuong, int sang, int trua, int chieu, int toi, int donGia, int thanhTien) {
        this.maDonThuoc = maDonThuoc;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.duongDung = duongDung;
        this.cachDung = cachDung;
        this.soNgay = soNgay;
        this.soLuong = soLuong;
        this.sang = sang;
        this.trua = trua;
        this.chieu = chieu;
        this.toi = toi;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public DonThuocModel(String maDonThuoc, String maBenhAn, String maBenhNhan, String maThuoc, String tenThuoc, String maNhomThuoc, String tenNhomThuoc, String duongDung, String cachDung, int soNgay, int soLuong, int sang, int trua, int chieu, int toi, int donGia, int thanhTien) {
        this.maDonThuoc = maDonThuoc;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.maNhomThuoc = maNhomThuoc;
        this.tenNhomThuoc = tenNhomThuoc;
        this.duongDung = duongDung;
        this.cachDung = cachDung;
        this.soNgay = soNgay;
        this.soLuong = soLuong;
        this.sang = sang;
        this.trua = trua;
        this.chieu = chieu;
        this.toi = toi;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getDuongDung() {
        return duongDung;
    }

    public void setDuongDung(String duongDung) {
        this.duongDung = duongDung;
    }

    public String getMaNhomThuoc() {
        return maNhomThuoc;
    }

    public void setMaNhomThuoc(String maNhomThuoc) {
        this.maNhomThuoc = maNhomThuoc;
    }

    public String getTenNhomThuoc() {
        return tenNhomThuoc;
    }

    public void setTenNhomThuoc(String tenNhomThuoc) {
        this.tenNhomThuoc = tenNhomThuoc;
    }

    public String getMaDonThuoc() {
        return maDonThuoc;
    }

    public void setMaDonThuoc(String maDonThuoc) {
        this.maDonThuoc = maDonThuoc;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getCachDung() {
        return cachDung;
    }

    public void setCachDung(String cachDung) {
        this.cachDung = cachDung;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getSang() {
        return sang;
    }

    public void setSang(int sang) {
        this.sang = sang;
    }

    public int getTrua() {
        return trua;
    }

    public void setTrua(int trua) {
        this.trua = trua;
    }

    public int getChieu() {
        return chieu;
    }

    public void setChieu(int chieu) {
        this.chieu = chieu;
    }

    public int getToi() {
        return toi;
    }

    public void setToi(int toi) {
        this.toi = toi;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

}
