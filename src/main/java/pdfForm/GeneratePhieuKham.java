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

public class GeneratePhieuKham {

    String ten, tuoi, gioiTinh, diaChi;
    String maDangKy, ngayKham, lyDoKham, dichVuKham, phongKham, thuTu;

    public GeneratePhieuKham(String ten, String tuoi, String gioiTinh, String diaChi, String maDangKy, String ngayKham, String lyDoKham, String dichVuKham, String phongKham, String thuTu) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.maDangKy = maDangKy;
        this.ngayKham = ngayKham;
        this.lyDoKham = lyDoKham;
        this.dichVuKham = dichVuKham;
        this.phongKham = phongKham;
        this.thuTu = thuTu;
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

    public String getMaDangKy() {
        return maDangKy;
    }

    public void setMaDangKy(String maDangKy) {
        this.maDangKy = maDangKy;
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

    public String getDichVuKham() {
        return dichVuKham;
    }

    public void setDichVuKham(String dichVuKham) {
        this.dichVuKham = dichVuKham;
    }

    public String getPhongKham() {
        return phongKham;
    }

    public void setPhongKham(String phongKham) {
        this.phongKham = phongKham;
    }

    public String getThuTu() {
        return thuTu;
    }

    public void setThuTu(String thuTu) {
        this.thuTu = thuTu;
    }

    public void taoPhieuKham() throws FileNotFoundException, IOException {
        String path = "PhieuKhamBenh.pdf";
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
        Paragraph centerParagraph = new Paragraph("PHIẾU KHÁM BỆNH").setBold().setTextAlignment(TextAlignment.CENTER);
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

        Table dangKyTable = new Table(new float[]{1, 1, 1});
        dangKyTable.setWidth(UnitValue.createPercentValue(100));
        Paragraph maDangKyParagraph = new Paragraph("- Mã đăng ký: ")
                .add(new Paragraph(maDangKy));
        Paragraph ngayKhamParagraph = new Paragraph("Ngày khám: ")
                .add(new Paragraph(ngayKham));
        Paragraph thuTuParagraph = new Paragraph("Thứ tự: ")
                .add(new Paragraph(thuTu).setFontSize(26).setBold());
        dangKyTable.addCell(new Cell().add(maDangKyParagraph).setBorder(Border.NO_BORDER));
        dangKyTable.addCell(new Cell().add(ngayKhamParagraph).setBorder(Border.NO_BORDER));
        dangKyTable.addCell(new Cell().add(thuTuParagraph).setBorder(Border.NO_BORDER));

        Paragraph lyDoParagraph = new Paragraph("- Lý do khám: ").add(new Paragraph(lyDoKham));
        Paragraph dichVuParagraph = new Paragraph("- Dịch vụ khám: ").add(new Paragraph(dichVuKham));
        Paragraph phongKhamParagraph = new Paragraph("- Phòng khám: ").add(new Paragraph(phongKham));

        document.add(table);
        document.add(centerCell);
        document.add(infoTable);
        document.add(diaChiParagraph);
        document.add(dangKyTable);
        document.add(lyDoParagraph);
        document.add(dichVuParagraph);
        document.add(phongKhamParagraph);

        document.close();
    }
}
