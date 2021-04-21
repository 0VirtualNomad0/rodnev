package vendorapplication.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.LoggerFactory;
import vendorapplication.entities.UserApplicationEntity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratePdfReport {


    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);


    public static ByteArrayInputStream generateIdCard(UserApplicationEntity data) throws JsonProcessingException {
        UserApplicationEntity userApplicationEntity = null;
        ObjectMapper objectMapper = new ObjectMapper();

        userApplicationEntity = data;
        String postJson = objectMapper.writeValueAsString(userApplicationEntity);
        Document document = new Document(PageSize.A4, 40 , 40, 40, 40);
        document.addTitle(String.valueOf(userApplicationEntity.getAppId()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Font boldFont2 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        Font boldFontIns = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.ITALIC);
        Font boldFontInsHead = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

        try {

            PdfPTable parent = new PdfPTable(1);
            float[] columnWidthsnestedparent = {100f};
            parent.setWidths(columnWidthsnestedparent);
            parent.setWidthPercentage(100);

            //Zero
            PdfPTable zero = new PdfPTable(1);
            float[] columnWidthsnestedz = {100f};
            zero.setWidths(columnWidthsnestedz);
            zero.getDefaultCell().setBorder(0);

            // Create a new Table
            PdfPTable childTable0 = new PdfPTable(6);
            float[] z = {25f,25f, 25f,25f,25f,25f};
            childTable0.setWidths(z);
            childTable0.getDefaultCell().setBorder(0);

            Image image = Image.getInstance(new URL(Utilities.getPhotoUrl(Constants.IMAGE_NAME_PASS)));
            // image.setUseVariableBorders(false);
            image.setBorder(Image.NO_BORDER);
            childTable0.addCell(image);

            PdfPCell cellheader = new PdfPCell(new Phrase(Constants.TICKET_HEADING, boldFont));
            cellheader.setColspan(4);
            cellheader.setBorder(0);
            cellheader.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cellheader.setHorizontalAlignment(Element.ALIGN_CENTER);
            childTable0.addCell(cellheader);



            JsonObject jsonObjecttwo = new JsonObject();
            jsonObjecttwo.addProperty("app_id", userApplicationEntity.getAppId());
            jsonObjecttwo.addProperty("mobile_number", userApplicationEntity.getUserId().getMobileNumber());
            jsonObjecttwo.addProperty("firstName", userApplicationEntity.getUserId().getFirstName());

            //postJson
            BarcodeQRCode barcodeQRCodetwo = new BarcodeQRCode(jsonObjecttwo.toString(), 60, 60, null);
            Image codeQrImagetwo = barcodeQRCodetwo.getImage();
            childTable0.addCell(codeQrImagetwo);

            zero.addCell(childTable0);


            // Create a Simple table
            PdfPTable one = new PdfPTable(1);
            float[] columnWidthsnested = {100f};
            one.setWidths(columnWidthsnested);
            one.getDefaultCell().setBorder(0);

            PdfPCell cell = new PdfPCell(new Phrase(userApplicationEntity.getUserId().getFirstName() + userApplicationEntity.getUserId().getLastName(), boldFont));
            cell.setColspan(2);
            cell.setBorder(0);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setPadding(5);
            one.addCell(cell);


            // Create a new Table
            PdfPTable childTable1 = new PdfPTable(2);
            float[] y = {50f,50f};
            childTable1.setWidths(y);



            childTable1.addCell(getCell("Application ID:",boldFont2));
            childTable1.addCell(getCell( String.valueOf(userApplicationEntity.getAppId()),boldFont2));
            childTable1.addCell(getCell("Category Type:",boldFont2));
            childTable1.addCell(getCell( userApplicationEntity.getCategory().getCategoryName(),boldFont2));
            childTable1.addCell(getCell("Sub Category Type:",boldFont2));
            childTable1.addCell(getCell( userApplicationEntity.getSubcategory().getSubCategoryName(),boldFont2));
            childTable1.addCell(getCell("Age:",boldFont2));
            childTable1.addCell(getCell( String.valueOf(userApplicationEntity.getUserId().getAge()),boldFont2));

            childTable1.addCell(getCell("Mobile Number:",boldFont2));
            childTable1.addCell(getCell( String.valueOf(userApplicationEntity.getUserId().getMobileNumber()),boldFont2));

            childTable1.addCell(getCell("Permanent Address:",boldFont2));
            childTable1.addCell(getCell( userApplicationEntity.getUserId().getpAddress(),boldFont2));




            one.addCell(childTable1);
            one.addCell(instructionCell(Constants.INSTRUCTUIN_0,boldFontInsHead));
            one.addCell(instructionCell(Constants.INSTRUCTUIN_I,boldFontIns));
            one.addCell(instructionCell(Constants.INSTRUCTUIN_II,boldFontIns));
            one.addCell(instructionCell(Constants.INSTRUCTUIN_III,boldFontIns));

            parent.addCell(zero);
            parent.addCell(one);


            PdfWriter.getInstance(document, out);
            document.open();

            document.add(parent);

            document.close();

        } catch (DocumentException | MalformedURLException ex) {

            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    private static PdfPCell getCell(String data, Font font){

        PdfPCell cell = new PdfPCell(new Phrase(data, font));
        cell.setBorderColorLeft(new BaseColor(242,242,242));
        cell.setBorderColorRight(new BaseColor(242,242,242));
        cell.setBorderColorTop(new BaseColor(242,242,242));
        cell.setBorderColorBottom(new BaseColor(242,242,242));
        cell.setPadding(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);

        return cell;
    }

    private static PdfPCell instructionCell(String data, Font font){

        PdfPCell cell = new PdfPCell(new Phrase(data, font));
        cell.setColspan(2);
        cell.setBorderColorLeft(new BaseColor(242,242,242));
        cell.setBorderColorRight(new BaseColor(242,242,242));
        cell.setBorderColorTop(new BaseColor(242,242,242));
        cell.setBorderColorBottom(new BaseColor(242,242,242));
        cell.setPadding(5);
        cell.setBorder(0);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);

        return cell;
    }
}