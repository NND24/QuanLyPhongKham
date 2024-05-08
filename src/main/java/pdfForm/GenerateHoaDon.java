package pdfForm;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerateHoaDon {

    String ten, tuoi, gioiTinh, diaChi, chuanDoan, tongTien, daThu, thu;

    List<String> noiDung = new ArrayList<>();
    List<String> soLuong = new ArrayList<>();
    List<String> donGia = new ArrayList<>();
    List<String> thanhTien = new ArrayList<>();

    String ngay, thang, nam;

    public GenerateHoaDon(String ten, String tuoi, String gioiTinh, String diaChi, String chuanDoan, String tongTien, String daThu, String thu, String ngay, String thang, String nam) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.chuanDoan = chuanDoan;
        this.tongTien = tongTien;
        this.daThu = daThu;
        this.thu = thu;
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public String getDaThu() {
        return daThu;
    }

    public void setDaThu(String daThu) {
        this.daThu = daThu;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getChuanDoan() {
        return chuanDoan;
    }

    public void setChuanDoan(String chuanDoan) {
        this.chuanDoan = chuanDoan;
    }

    public List<String> getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(List<String> noiDung) {
        this.noiDung = noiDung;
    }

    public List<String> getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(List<String> soLuong) {
        this.soLuong = soLuong;
    }

    public List<String> getDonGia() {
        return donGia;
    }

    public void setDonGia(List<String> donGia) {
        this.donGia = donGia;
    }

    public List<String> getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(List<String> thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public void taoHoaDon() throws FileNotFoundException, IOException {
        String path = "src/main/java/files/HoaDon.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        Document document = new Document(pdfDocument);
        PdfFont font = PdfFontFactory.createFont("src/main/java/pdfForm/arial.ttf",
                PdfEncodings.IDENTITY_H);
        document.setFont(font);

        float twocol = 285f;
        float twocol150 = twocol + 150f;
        float twocolumnWidth[] = {twocol150, twocol};
        float threecol = 190f;
        float fullWidth[] = {threecol * 3};
        Paragraph onesp = new Paragraph("\n");

        Table table = new Table(twocolumnWidth);
        table.addCell(new Cell().add(new Paragraph("Phòng khám Đa khoa PTIT CARE")).setBorder(Border.NO_BORDER).setBold());

//        Table nestedTable = new Table(new float[]{twocol / 2, twocol / 2});
//        nestedTable.addCell(new Cell().add(new Paragraph("Ma don thuoc")).setBorder(Border.NO_BORDER));
//        table.addCell(new Cell().add(nestedTable).setBorder(Border.NO_BORDER));
        Paragraph centerParagraph = new Paragraph("HÓA ĐƠN").setBold().setTextAlignment(TextAlignment.CENTER);
        Cell centerCell = new Cell().add(centerParagraph).setBorder(Border.NO_BORDER).setWidth(UnitValue.createPercentValue(100));

        Table infoTable = new Table(new float[]{1, 1, 1});
        infoTable.setWidth(UnitValue.createPercentValue(100));

        Paragraph hoTenParagraph = new Paragraph("- Họ tên: ")
                .add(new Paragraph(ten).setBold());

        Paragraph tuoiParagraph = new Paragraph("Tuổi: ")
                .add(new Paragraph(tuoi).setBold());

        Paragraph gioiTinhParagraph = new Paragraph("Giới tính: ").add(new Paragraph(gioiTinh).setBold());

        infoTable.addCell(new Cell().add(hoTenParagraph).setBorder(Border.NO_BORDER));
        infoTable.addCell(new Cell().add(tuoiParagraph).setBorder(Border.NO_BORDER));
        infoTable.addCell(new Cell().add(gioiTinhParagraph).setBorder(Border.NO_BORDER));

        Paragraph diaChiParagraph = new Paragraph("- Địa chỉ: ").add(new Paragraph(diaChi));

        Paragraph chuanDoanParagraph = new Paragraph("- Chuẩn Đoán: ").add(new Paragraph(chuanDoan));

        Table chiTietTable = new Table(new float[]{1, 1});
        chiTietTable.setWidth(UnitValue.createPercentValue(100));

        for (int i = 0; i < noiDung.size(); i++) {
            Paragraph noiDungParagraph = new Paragraph((i + 1) + "/ ")
                    .add(new Paragraph(noiDung.get(i)));

            Paragraph soLuongParagraph;
            if (soLuong.get(i).isEmpty()) {
                soLuongParagraph = new Paragraph(" ");
            } else {
                soLuongParagraph = new Paragraph("Số lượng: ")
                        .add(new Paragraph(soLuong.get(i)));
            }

            Paragraph donGiaParagraph = new Paragraph("- Đơn giá: " + donGia.get(i));
            Paragraph thanhTienParagraph = new Paragraph("Thành tiền: " + thanhTien.get(i));

            chiTietTable.addCell(new Cell().add(noiDungParagraph).setBorder(Border.NO_BORDER));
            chiTietTable.addCell(new Cell().add(soLuongParagraph).setBorder(Border.NO_BORDER));
            chiTietTable.addCell(new Cell().add(donGiaParagraph).setBorder(Border.NO_BORDER));
            chiTietTable.addCell(new Cell().add(thanhTienParagraph).setBorder(Border.NO_BORDER));
        }

        Paragraph tongTienParagraph = new Paragraph("- Tổng tiền: " + tongTien);
        Paragraph daThuParagraph = new Paragraph("- Đã thu: " + daThu);
        Paragraph thuParagraph = new Paragraph("- Thu: " + thu);

        Table thoiGianTable = new Table(twocolumnWidth);
        Paragraph trangParagraph = new Paragraph(" ");
        Paragraph ngayThangParagraph = new Paragraph("Ngày ").add(new Paragraph(ngay))
                .add(new Paragraph(" Tháng ")).add(new Paragraph(thang))
                .add(new Paragraph(" Năm ")).add(new Paragraph(nam)).setTextAlignment(TextAlignment.CENTER);
        thoiGianTable.addCell(new Cell().add(trangParagraph).setBorder(Border.NO_BORDER));
        thoiGianTable.addCell(new Cell().add(ngayThangParagraph).setBorder(Border.NO_BORDER));

        Table kyTable = new Table(twocolumnWidth);

        Paragraph kyTenParagraph = new Paragraph("Ký và ghi rõ họ tên").setTextAlignment(TextAlignment.CENTER);
        kyTable.addCell(new Cell().add(trangParagraph).setBorder(Border.NO_BORDER));
        kyTable.addCell(new Cell().add(kyTenParagraph).setBorder(Border.NO_BORDER));

        document.add(table);
        document.add(centerCell);
        document.add(infoTable);
        document.add(diaChiParagraph);
        document.add(chuanDoanParagraph);
        document.add(chiTietTable);
        document.add(onesp);
        document.add(tongTienParagraph);
        document.add(daThuParagraph);
        document.add(thuParagraph);
        document.add(onesp);
        document.add(thoiGianTable);
        document.add(kyTable);

        document.close();
    }
}
