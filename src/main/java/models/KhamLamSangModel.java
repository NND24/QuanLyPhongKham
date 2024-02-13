package models;

import java.sql.Date;

public class KhamLamSangModel {

    private String maKhamLamSang, maPhongKham, maDichVu, tenDichVu, maBacSi, giaTien;
    private Date ngayKham;
    private String canNang, chieuCao, nhietDo, nhipTho, huyetAp, mach, BMI, lyDoKhamBenh, chuanDoan, benhChinh, benhPhu, huongXuLy, loiDan, benhSu, tienSu, khamToanThan, khamBoPhan, tomTatKetQuaCLS;

    public KhamLamSangModel(String tenDichVu, String giaTien) {
        this.tenDichVu = tenDichVu;
        this.giaTien = giaTien;
    }

    public KhamLamSangModel(String maKhamLamSang, String maBacSi, Date ngayKham, String canNang, String chieuCao, String nhietDo, String nhipTho, String huyetAp, String mach, String BMI, String lyDoKhamBenh, String chuanDoan, String benhChinh, String benhPhu, String huongXuLy, String loiDan, String benhSu, String tienSu, String khamToanThan, String khamBoPhan, String tomTatKetQuaCLS) {
        this.maKhamLamSang = maKhamLamSang;
        this.maBacSi = maBacSi;
        this.ngayKham = ngayKham;
        this.canNang = canNang;
        this.chieuCao = chieuCao;
        this.nhietDo = nhietDo;
        this.nhipTho = nhipTho;
        this.huyetAp = huyetAp;
        this.mach = mach;
        this.BMI = BMI;
        this.lyDoKhamBenh = lyDoKhamBenh;
        this.chuanDoan = chuanDoan;
        this.benhChinh = benhChinh;
        this.benhPhu = benhPhu;
        this.huongXuLy = huongXuLy;
        this.loiDan = loiDan;
        this.benhSu = benhSu;
        this.tienSu = tienSu;
        this.khamToanThan = khamToanThan;
        this.khamBoPhan = khamBoPhan;
        this.tomTatKetQuaCLS = tomTatKetQuaCLS;
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

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getMaBacSi() {
        return maBacSi;
    }

    public void setMaBacSi(String maBacSi) {
        this.maBacSi = maBacSi;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getCanNang() {
        return canNang;
    }

    public void setCanNang(String canNang) {
        this.canNang = canNang;
    }

    public String getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(String chieuCao) {
        this.chieuCao = chieuCao;
    }

    public String getNhietDo() {
        return nhietDo;
    }

    public void setNhietDo(String nhietDo) {
        this.nhietDo = nhietDo;
    }

    public String getNhipTho() {
        return nhipTho;
    }

    public void setNhipTho(String nhipTho) {
        this.nhipTho = nhipTho;
    }

    public String getHuyetAp() {
        return huyetAp;
    }

    public void setHuyetAp(String huyetAp) {
        this.huyetAp = huyetAp;
    }

    public String getMach() {
        return mach;
    }

    public void setMach(String mach) {
        this.mach = mach;
    }

    public String getBMI() {
        return BMI;
    }

    public void setBMI(String BMI) {
        this.BMI = BMI;
    }

    public String getLyDoKhamBenh() {
        return lyDoKhamBenh;
    }

    public void setLyDoKhamBenh(String lyDoKhamBenh) {
        this.lyDoKhamBenh = lyDoKhamBenh;
    }

    public String getChuanDoan() {
        return chuanDoan;
    }

    public void setChuanDoan(String chuanDoan) {
        this.chuanDoan = chuanDoan;
    }

    public String getBenhChinh() {
        return benhChinh;
    }

    public void setBenhChinh(String benhChinh) {
        this.benhChinh = benhChinh;
    }

    public String getBenhPhu() {
        return benhPhu;
    }

    public void setBenhPhu(String benhPhu) {
        this.benhPhu = benhPhu;
    }

    public String getHuongXuLy() {
        return huongXuLy;
    }

    public void setHuongXuLy(String huongXuLy) {
        this.huongXuLy = huongXuLy;
    }

    public String getLoiDan() {
        return loiDan;
    }

    public void setLoiDan(String loiDan) {
        this.loiDan = loiDan;
    }

    public String getBenhSu() {
        return benhSu;
    }

    public void setBenhSu(String benhSu) {
        this.benhSu = benhSu;
    }

    public String getTienSu() {
        return tienSu;
    }

    public void setTienSu(String tienSu) {
        this.tienSu = tienSu;
    }

    public String getKhamToanThan() {
        return khamToanThan;
    }

    public void setKhamToanThan(String khamToanThan) {
        this.khamToanThan = khamToanThan;
    }

    public String getKhamBoPhan() {
        return khamBoPhan;
    }

    public void setKhamBoPhan(String khamBoPhan) {
        this.khamBoPhan = khamBoPhan;
    }

    public String getTomTatKetQuaCLS() {
        return tomTatKetQuaCLS;
    }

    public void setTomTatKetQuaCLS(String tomTatKetQuaCLS) {
        this.tomTatKetQuaCLS = tomTatKetQuaCLS;
    }

}
