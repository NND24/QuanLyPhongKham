package models;

/**
 *
 * @author Phu Bao
 */
public class GiuongBenhModel {
    private String maGiuong, maPhong, tenPhong, tenLoaiPhong, coNguoi;
    private int donGia;
    private boolean trangThaiXoa;

    public GiuongBenhModel() {
    }

    public GiuongBenhModel(String maGiuong, String maPhong) {
        this.maGiuong = maGiuong;
        this.maPhong = maPhong;
    }

    public GiuongBenhModel(String maGiuong, String maPhong, String tenPhong, String tenLoaiPhong, String coNguoi, int donGia) {
        this.maGiuong = maGiuong;
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.coNguoi = coNguoi;
        this.donGia = donGia;
    }
    
    public GiuongBenhModel(String maGiuong, String maPhong, String tenPhong, String tenLoaiPhong, String coNguoi, int donGia, boolean trangThaiXoa) {
        this.maGiuong = maGiuong;
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.coNguoi = coNguoi;
        this.donGia = donGia;
        this.trangThaiXoa = trangThaiXoa;
    }
    
    

    public String getMaGiuong() {
        return maGiuong;
    }

    public void setMaGiuong(String maGiuong) {
        this.maGiuong = maGiuong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }
    
    public String getCoNguoi() {
        return coNguoi;
    }

    public void setCoNguoi(String coNguoi) {
        this.coNguoi = coNguoi;
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
