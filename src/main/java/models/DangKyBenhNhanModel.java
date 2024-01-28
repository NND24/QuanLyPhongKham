package models;

import java.sql.Date;

public class DangKyBenhNhanModel extends DangKyModel {

    private String hoTen, gioiTinh, namSinh;

    public DangKyBenhNhanModel(String hoTen, String gioiTinh, String namSinh, String maDangKy, String maBenhNhan, String maDichVuKB, String maPhongKham, String lyDoKham, int thuTuKham, Date ngayKham, String trangThai) {
        super(maDangKy, maBenhNhan, maDichVuKB, maPhongKham, lyDoKham, thuTuKham, ngayKham, trangThai);
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

}
