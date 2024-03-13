package models;

public class BenhAnModel extends BenhNhanModel {

    private String maBenhAn, maDangKy, maKhamLamSang;
    private String maPhongKham, tenPhongKham, maDichVuKham, tenDichVuKham, ngayKham, lyDoKham;
    private int tongTien, daThu;

    public BenhAnModel(String maBenhAn, String maDangKy, String maKhamLamSang, String maPhongKham, String tenPhongKham, String maDichVuKham, String tenDichVuKham, String ngayKham, String lyDoKham, int tongTien, int daThu, String maBenhNhan, String hoTen, String gioiTinh, String namSinh) {
        super(maBenhNhan, hoTen, gioiTinh, namSinh);
        this.maBenhAn = maBenhAn;
        this.maDangKy = maDangKy;
        this.maKhamLamSang = maKhamLamSang;
        this.maPhongKham = maPhongKham;
        this.tenPhongKham = tenPhongKham;
        this.maDichVuKham = maDichVuKham;
        this.tenDichVuKham = tenDichVuKham;
        this.ngayKham = ngayKham;
        this.lyDoKham = lyDoKham;
        this.tongTien = tongTien;
        this.daThu = daThu;
    }

    public BenhAnModel(String maBenhAn, String maDangKy, String maKhamLamSang, String maBenhNhan) {
        super(maBenhNhan);
        this.maBenhAn = maBenhAn;
        this.maDangKy = maDangKy;
        this.maKhamLamSang = maKhamLamSang;
    }

    public BenhAnModel(String maBenhAn, String maBenhNhan, String maDangKy, String maKhamLamSang, String hoTen, String gioiTinh, String maPhongKham, String tenPhongKham, String maDichVuKham, String tenDichVuKham, String ngayKham, String lyDoKham) {
        super(maBenhNhan, hoTen, gioiTinh);
        this.maBenhAn = maBenhAn;
        this.maDangKy = maDangKy;
        this.maKhamLamSang = maKhamLamSang;
        this.maPhongKham = maPhongKham;
        this.tenPhongKham = tenPhongKham;
        this.maDichVuKham = maDichVuKham;
        this.tenDichVuKham = tenDichVuKham;
        this.ngayKham = ngayKham;
        this.lyDoKham = lyDoKham;
    }

    public BenhAnModel(String maBenhAn, String ngayKham, int tongTien, int daThu, String maBenhNhan, String hoTen, String gioiTinh, String namSinh) {
        super(maBenhNhan, hoTen, gioiTinh, namSinh);
        this.maBenhAn = maBenhAn;
        this.ngayKham = ngayKham;
        this.tongTien = tongTien;
        this.daThu = daThu;
    }

    public BenhAnModel(String maBenhAn, int tongTien, int daThu) {
        super();
        this.maBenhAn = maBenhAn;
        this.tongTien = tongTien;
        this.daThu = daThu;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaDangKy() {
        return maDangKy;
    }

    public void setMaDangKy(String maDangKy) {
        this.maDangKy = maDangKy;
    }

    public String getMaKhamLamSang() {
        return maKhamLamSang;
    }

    public void setMaKhamLamSang(String maKhamLamSang) {
        this.maKhamLamSang = maKhamLamSang;
    }

    public String getMaPhongKham() {
        return maPhongKham;
    }

    public void setMaPhongKham(String maPhongKham) {
        this.maPhongKham = maPhongKham;
    }

    public String getTenPhongKham() {
        return tenPhongKham;
    }

    public void setTenPhongKham(String tenPhongKham) {
        this.tenPhongKham = tenPhongKham;
    }

    public String getMaDichVuKham() {
        return maDichVuKham;
    }

    public void setMaDichVuKham(String maDichVuKham) {
        this.maDichVuKham = maDichVuKham;
    }

    public String getTenDichVuKham() {
        return tenDichVuKham;
    }

    public void setTenDichVuKham(String tenDichVuKham) {
        this.tenDichVuKham = tenDichVuKham;
    }

    public String getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(String ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getLyDoKham() {
        return lyDoKham;
    }

    public void setLyDoKham(String lyDoKham) {
        this.lyDoKham = lyDoKham;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getDaThu() {
        return daThu;
    }

    public void setDaThu(int daThu) {
        this.daThu = daThu;
    }

}
