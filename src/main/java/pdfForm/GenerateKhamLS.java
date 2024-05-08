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

public class GenerateKhamLS {

    String ten, tuoi, gioiTinh, diaChi, chieuCao, canNang, nhietDo, nhipTho, huyetAp, mach, bmi;
    String lyDoKham, chuanDoan, huongXuLy, benhChinh, benhPhu, loiDan;
    String benhSu, tienSu, khamToanThan, khamBoPhan, tomTatKQ;
    String ngay, thang, nam;

    public GenerateKhamLS(String ten, String tuoi, String gioiTinh, String diaChi, String chieuCao, String canNang, String nhietDo, String nhipTho, String huyetAp, String mach, String bmi, String lyDoKham, String chuanDoan, String huongXuLy, String benhChinh, String benhPhu, String loiDan, String benhSu, String tienSu, String khamToanThan, String khamBoPhan, String tomTatKQ, String ngay, String thang, String nam) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
        this.nhietDo = nhietDo;
        this.nhipTho = nhipTho;
        this.huyetAp = huyetAp;
        this.mach = mach;
        this.bmi = bmi;
        this.lyDoKham = lyDoKham;
        this.chuanDoan = chuanDoan;
        this.huongXuLy = huongXuLy;
        this.benhChinh = benhChinh;
        this.benhPhu = benhPhu;
        this.loiDan = loiDan;
        this.benhSu = benhSu;
        this.tienSu = tienSu;
        this.khamToanThan = khamToanThan;
        this.khamBoPhan = khamBoPhan;
        this.tomTatKQ = tomTatKQ;
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

    public String getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(String chieuCao) {
        this.chieuCao = chieuCao;
    }

    public String getCanNang() {
        return canNang;
    }

    public void setCanNang(String canNang) {
        this.canNang = canNang;
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

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getLyDoKham() {
        return lyDoKham;
    }

    public void setLyDoKham(String lyDoKham) {
        this.lyDoKham = lyDoKham;
    }

    public String getChuanDoan() {
        return chuanDoan;
    }

    public void setChuanDoan(String chuanDoan) {
        this.chuanDoan = chuanDoan;
    }

    public String getHuongXuLy() {
        return huongXuLy;
    }

    public void setHuongXuLy(String huongXuLy) {
        this.huongXuLy = huongXuLy;
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

    public String getTomTatKQ() {
        return tomTatKQ;
    }

    public void setTomTatKQ(String tomTatKQ) {
        this.tomTatKQ = tomTatKQ;
    }

    public void taoPhieuKham() throws FileNotFoundException, IOException {
        String path = "src/main/java/files/PhieuKhamLS.pdf";
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
        Paragraph centerParagraph = new Paragraph("PHIẾU KHÁM LÂM SÀNG").setBold().setTextAlignment(TextAlignment.CENTER);
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

        Table chiSoTable = new Table(new float[]{1, 1, 1, 1});
        chiSoTable.setWidth(UnitValue.createPercentValue(100));
        Paragraph chieuCaoParagraph = new Paragraph("- Chiều cao: ")
                .add(new Paragraph(chieuCao)).add(new Paragraph(" cm"));
        Paragraph canNangParagraph = new Paragraph("Cân nặng: ")
                .add(new Paragraph(canNang)).add(new Paragraph(" kg"));
        Paragraph bmiParagraph = new Paragraph("BMI: ")
                .add(new Paragraph(bmi));
        Paragraph nhietDoParagraph = new Paragraph("Nhiệt độ: ")
                .add(new Paragraph(nhietDo)).add(new Paragraph(" oC"));
        chiSoTable.addCell(new Cell().add(chieuCaoParagraph).setBorder(Border.NO_BORDER));
        chiSoTable.addCell(new Cell().add(canNangParagraph).setBorder(Border.NO_BORDER));
        chiSoTable.addCell(new Cell().add(bmiParagraph).setBorder(Border.NO_BORDER));
        chiSoTable.addCell(new Cell().add(nhietDoParagraph).setBorder(Border.NO_BORDER));

        Table chiSo1Table = new Table(new float[]{1, 1, 1});
        chiSo1Table.setWidth(UnitValue.createPercentValue(100));
        Paragraph nhipThoParagraph = new Paragraph("- Nhịp thở: ")
                .add(new Paragraph(nhipTho)).add(new Paragraph(" l/p"));
        Paragraph huyetApParagraph = new Paragraph("Huyết áp: ")
                .add(new Paragraph(canNang));
        Paragraph machParagraph = new Paragraph("Mạch: ")
                .add(new Paragraph(mach)).add(new Paragraph(" l/p"));
        chiSo1Table.addCell(new Cell().add(nhipThoParagraph).setBorder(Border.NO_BORDER));
        chiSo1Table.addCell(new Cell().add(huyetApParagraph).setBorder(Border.NO_BORDER));
        chiSo1Table.addCell(new Cell().add(machParagraph).setBorder(Border.NO_BORDER));

        Paragraph lyDoParagraph = new Paragraph("- Lý do khám: ").add(new Paragraph(lyDoKham));
        Paragraph chuanDoanParagraph = new Paragraph("- Chuẩn đoán: ").add(new Paragraph(chuanDoan));
        Paragraph huongXuLyParagraph = new Paragraph("- Hướnng xử lý: ").add(new Paragraph(huongXuLy));
        Paragraph benhChinhParagraph = new Paragraph("- Bệnh chính: ").add(new Paragraph(benhChinh));
        Paragraph benhPhuParagraph = new Paragraph("- Bệnh phụ: ").add(new Paragraph(benhPhu));
        Paragraph loiDanParagraph = new Paragraph("- Lời dặn: ").add(new Paragraph(loiDan));

        Paragraph benhSuParagraph = new Paragraph("- Bệnh sử: ").add(new Paragraph(benhSu));
        Paragraph tienSuParagraph = new Paragraph("- Tiền sử: ").add(new Paragraph(benhPhu));
        Paragraph khamToanThanParagraph = new Paragraph("- Khám toàn thân: ").add(new Paragraph(khamToanThan));
        Paragraph khamBoPhanParagraph = new Paragraph("- Khám bộ phận: ").add(new Paragraph(khamBoPhan));
        Paragraph tomTatKQParagraph = new Paragraph("- Tóm tắt kết quả: ").add(new Paragraph(tomTatKQ));

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
        document.add(chiSoTable);
        document.add(chiSo1Table);

        if (!lyDoKham.isEmpty()) {
            document.add(lyDoParagraph);
        }
        if (!chuanDoan.isEmpty()) {
            document.add(chuanDoanParagraph);
        }
        if (!huongXuLy.isEmpty()) {
            document.add(huongXuLyParagraph);
        }
        if (!benhChinh.isEmpty()) {
            document.add(benhChinhParagraph);
        }
        if (!benhPhu.isEmpty()) {
            document.add(benhPhuParagraph);
        }
        if (!loiDan.isEmpty()) {
            document.add(loiDanParagraph);
        }
        if (!benhSu.isEmpty()) {
            document.add(benhSuParagraph);
        }
        if (!tienSu.isEmpty()) {
            document.add(tienSuParagraph);
        }
        if (!khamToanThan.isEmpty()) {
            document.add(khamToanThanParagraph);
        }
        if (!khamBoPhan.isEmpty()) {
            document.add(khamBoPhanParagraph);
        }
        if (!tomTatKQ.isEmpty()) {
            document.add(tomTatKQParagraph);
        }

        document.add(onesp);
        document.add(thoiGianTable);
        document.add(kyTable);

        document.close();
    }
}
