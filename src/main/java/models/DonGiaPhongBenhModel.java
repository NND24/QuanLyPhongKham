package models;

public class DonGiaPhongBenhModel {
    private String maDonGia, tenLoaiPhong;
    private int donGia;
    private boolean trangThaiXoa;

    public DonGiaPhongBenhModel() {
    }

    public DonGiaPhongBenhModel(String maDonGia, String tenLoaiPhong, int donGia, boolean trangThaiXoa) {
        this.maDonGia = maDonGia;
        this.tenLoaiPhong = tenLoaiPhong;
        this.donGia = donGia;
        this.trangThaiXoa = trangThaiXoa;
    }

    public DonGiaPhongBenhModel(String maDonGia, String tenLoaiPhong, int donGia) {
        this.maDonGia = maDonGia;
        this.tenLoaiPhong = tenLoaiPhong;
        this.donGia = donGia;
    }

    public DonGiaPhongBenhModel(String tenLoaiPhong, int donGia) {
        this.tenLoaiPhong = tenLoaiPhong;
        this.donGia = donGia;
    }
    
    public String getMaDonGia() {
        return maDonGia;
    }

    public void setMaDonGia(String maDonGia) {
        this.maDonGia = maDonGia;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public boolean isTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(boolean trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }
    
}
