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

public class GenerateDonThuoc {

    String ten, tuoi, gioiTinh, diaChi, chuanDoan;

    List<String> medicines = new ArrayList<>();
    List<String> quantities = new ArrayList<>();
    List<String> usages = new ArrayList<>();

    String ngay, thang, nam;

    public GenerateDonThuoc(String ten, String tuoi, String gioiTinh, String diaChi, String chuanDoan, String ngay, String thang, String nam) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.chuanDoan = chuanDoan;
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
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

    public List<String> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<String> medicines) {
        this.medicines = medicines;
    }

    public List<String> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<String> quantities) {
        this.quantities = quantities;
    }

    public List<String> getUsages() {
        return usages;
    }

    public void setUsages(List<String> usages) {
        this.usages = usages;
    }

    public void taoDonThuoc() throws FileNotFoundException, IOException {
        String path = "src/main/java/files/DonThuoc.pdf";
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
        Paragraph centerParagraph = new Paragraph("ĐƠN THUỐC").setBold().setTextAlignment(TextAlignment.CENTER);
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

        Table donThuocTable = new Table(new float[]{1, 1});
        donThuocTable.setWidth(UnitValue.createPercentValue(100));

        for (int i = 0; i < medicines.size(); i++) {
            Paragraph thuocParagraph = new Paragraph((i + 1) + "/ ")
                    .add(new Paragraph(medicines.get(i)));

            Paragraph soLuongParagraph = new Paragraph("Số lượng: ")
                    .add(new Paragraph(quantities.get(i)));

            Paragraph cachDungParagraph = new Paragraph("- Cách Dùng: " + usages.get(i));
            Paragraph trangParagraph = new Paragraph(" ");

            donThuocTable.addCell(new Cell().add(thuocParagraph).setBorder(Border.NO_BORDER));
            donThuocTable.addCell(new Cell().add(soLuongParagraph).setBorder(Border.NO_BORDER));
            donThuocTable.addCell(new Cell().add(cachDungParagraph).setBorder(Border.NO_BORDER));
            donThuocTable.addCell(new Cell().add(trangParagraph).setBorder(Border.NO_BORDER));
        }

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
        document.add(donThuocTable);
        document.add(onesp);
        document.add(thoiGianTable);
        document.add(kyTable);

        document.close();
    }
}
