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
import vendorapplication.entities.UserTranactionEntity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratePdfReport {


    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);


    public static ByteArrayInputStream generateIdCard(UserApplicationEntity data, UserTranactionEntity transaction) throws JsonProcessingException, MalformedURLException {
        UserApplicationEntity userApplicationEntity = null;
        ObjectMapper objectMapper = new ObjectMapper();

        userApplicationEntity = data;
        String postJson = objectMapper.writeValueAsString(userApplicationEntity);
        Document document = new Document(PageSize.A4, 10, 10, 10, 10);

        document.addTitle(String.valueOf(userApplicationEntity.getAppId()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Font boldFont2 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        Font boldFont21 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Font boldFontIns = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.ITALIC);
        Font boldFontInsHead = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

        try {

            PdfPTable parent = new PdfPTable(1);
            float[] columnWidthsnestedparent = {100f};
            parent.setWidths(columnWidthsnestedparent);
            parent.setWidthPercentage(100);
            parent.getDefaultCell().setBorder(1);


            //Zero
            PdfPTable zero = new PdfPTable(1);
            float[] columnWidthsnestedz = {100f};
            zero.setWidths(columnWidthsnestedz);
            zero.getDefaultCell().setBorder(1);

            // Create a new Table
            PdfPTable childTable0 = new PdfPTable(6);
            float[] z = {25f, 25f, 25f, 25f, 25f, 25f};
            childTable0.setWidths(z);
            childTable0.getDefaultCell().setBorder(0);


            Image image = Image.getInstance(new URL(Utilities.getPhotoUrl(Constants.IMAGE_NAME_PASS)));
            childTable0.addCell(image);

            PdfPCell cellheader = new PdfPCell(new Phrase(Constants.TICKET_HEADING, boldFont));
            cellheader.setColspan(4);
            cellheader.setBorder(0);
            cellheader.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cellheader.setHorizontalAlignment(Element.ALIGN_CENTER);

            PdfPCell cellheader2 = new PdfPCell(new Phrase("District Administration Lahaul & Spiti \n eLahaul V1.0", boldFont));
            cellheader2.setColspan(4);
            cellheader2.setBorder(0);
            cellheader2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cellheader2.setHorizontalAlignment(Element.ALIGN_CENTER);
            childTable0.addCell(cellheader2);



            Image photo = Image.getInstance(new URL(Utilities.getPhotoUrl(userApplicationEntity.getPhotoDoc())));
            //image.setBorder(5);
            PdfPCell imageCell = new PdfPCell(photo);
            imageCell.setPadding(10);
            imageCell.setBorder(0);
            imageCell.setFixedHeight(120);
            imageCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            childTable0.addCell(imageCell);

            zero.addCell(childTable0);


/**
 * User Details
 */
            PdfPTable userDetailTable = new PdfPTable(4);
            float[] userDetailTableColumns = {25f, 25f, 25f, 25f};
            userDetailTable.setWidths(userDetailTableColumns);
            PdfPCell cellUserDetialsHeading = new PdfPCell(new Phrase("Entrepreneur/ Operator/ Vendor  Details:- ", boldFont));
            cellUserDetialsHeading.setColspan(4);
            cellUserDetialsHeading.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cellUserDetialsHeading.setHorizontalAlignment(Element.ALIGN_LEFT);
            cellUserDetialsHeading.setPadding(5);
            cellUserDetialsHeading.setBorder(0);
            userDetailTable.addCell(cellUserDetialsHeading);
            userDetailTable.addCell(getCell("Application ID:", boldFont21));
            userDetailTable.addCell(getCell(String.valueOf(userApplicationEntity.getAppId()), boldFont2));
            userDetailTable.addCell(getCell("Application Created Date:", boldFont21));
            userDetailTable.addCell(getCell(DateUtilities.convertToDateCustom(userApplicationEntity.getCreatedDate().toString()), boldFont2));
            userDetailTable.addCell(getCell("Full Name:", boldFont21));
            userDetailTable.addCell(getCell(String.valueOf(userApplicationEntity.getUserId().getFirstName() + Constants.space + userApplicationEntity.getUserId().getLastName()), boldFont2));
            userDetailTable.addCell(getCell("Gender:", boldFont21));
            userDetailTable.addCell(getCell(String.valueOf(userApplicationEntity.getUserId().getGenderID().getGenderName()), boldFont2));
            userDetailTable.addCell(getCell("Age:", boldFont21));
            userDetailTable.addCell(getCell(String.valueOf(userApplicationEntity.getUserId().getAge()), boldFont2));
            userDetailTable.addCell(getCell("Mobile Number:", boldFont21));
            userDetailTable.setSpacingBefore(Constants.reportTableSpacing);
            userDetailTable.getDefaultCell().setBorder(0);


            /**
             * User Permanent Address
             */
            PdfPTable userDetailPermanetAddressTable = new PdfPTable(4);
            float[] userDetailPermanetAddressTableColumns = {25f, 25f, 25f, 25f};
            userDetailPermanetAddressTable.setWidths(userDetailPermanetAddressTableColumns);
            PdfPCell userDetailPermanetAddressTableHeading = new PdfPCell(new Phrase("Entrepreneur/ Operator/ Vendor Local Address Details- ", boldFont));
            userDetailPermanetAddressTableHeading.setColspan(4);
            userDetailPermanetAddressTableHeading.setBorder(0);
            userDetailPermanetAddressTableHeading.setVerticalAlignment(Element.ALIGN_MIDDLE);
            userDetailPermanetAddressTableHeading.setHorizontalAlignment(Element.ALIGN_LEFT);
            userDetailPermanetAddressTableHeading.setPadding(5);
            userDetailPermanetAddressTable.addCell(userDetailPermanetAddressTableHeading);
            userDetailPermanetAddressTable.addCell(getCell("State:", boldFont21));
            userDetailPermanetAddressTable.addCell(getCell(userApplicationEntity.getUserId().getState().getStateName(), boldFont2));
            userDetailPermanetAddressTable.addCell(getCell("District:", boldFont21));
            userDetailPermanetAddressTable.addCell(getCell(userApplicationEntity.getUserId().getDistrict().getDistrictName(), boldFont2));
            userDetailPermanetAddressTable.addCell(getCell("Block:", boldFont21));
            userDetailPermanetAddressTable.addCell(getCell(userApplicationEntity.getUserId().getBlock().getDistrictName(), boldFont2));
            userDetailPermanetAddressTable.addCell(getCell("Tehsil:", boldFont21));
            userDetailPermanetAddressTable.addCell(getCell(userApplicationEntity.getUserId().getTehsil().getDistrictName(), boldFont2));
            userDetailPermanetAddressTable.addCell(getCell("Gram Panchayat/ Ward:", boldFont21));
            userDetailPermanetAddressTable.addCell(getCell(userApplicationEntity.getUserId().getGrampanchayat().getPanchayatName(), boldFont2));
            userDetailPermanetAddressTable.addCell(getCell("Permanent Address:", boldFont21));
            userDetailPermanetAddressTable.addCell(getCell(userApplicationEntity.getUserId().getpAddress(), boldFont2));
            userDetailPermanetAddressTable.setSpacingBefore(Constants.reportTableSpacing);
            userDetailPermanetAddressTable.getDefaultCell().setBorder(0);

            /**
             * User Vending Address
             */
            PdfPTable userDetailVendingAddressTable = new PdfPTable(4);
            float[] userDetailVendingAddressTableColumns = {25f, 25f, 25f, 25f};
            userDetailVendingAddressTable.setWidths(userDetailVendingAddressTableColumns);
            PdfPCell userDetailVendingAddressTableHeading = new PdfPCell(new Phrase("Entrepreneur/ Operator/ Vendor Application Details:- ", boldFont));
            userDetailVendingAddressTableHeading.setColspan(4);
            userDetailVendingAddressTableHeading.setBorder(0);
            userDetailVendingAddressTableHeading.setVerticalAlignment(Element.ALIGN_MIDDLE);
            userDetailVendingAddressTableHeading.setHorizontalAlignment(Element.ALIGN_LEFT);
            userDetailVendingAddressTableHeading.setPadding(5);
            userDetailVendingAddressTable.addCell(userDetailVendingAddressTableHeading);
            userDetailVendingAddressTable.addCell(getCell("State:", boldFont21));
            userDetailVendingAddressTable.addCell(getCell(userApplicationEntity.getState().getStateName(), boldFont2));
            userDetailVendingAddressTable.addCell(getCell("District:", boldFont21));
            userDetailVendingAddressTable.addCell(getCell(userApplicationEntity.getDistrict().getDistrictName(), boldFont2));
            userDetailVendingAddressTable.addCell(getCell("Block:", boldFont21));
            userDetailVendingAddressTable.addCell(getCell(userApplicationEntity.getBlock().getDistrictName(), boldFont2));
            userDetailVendingAddressTable.addCell(getCell("Tehsil:", boldFont21));
            userDetailVendingAddressTable.addCell(getCell(userApplicationEntity.getTehsil().getDistrictName(), boldFont2));
            userDetailVendingAddressTable.addCell(getCell("Gram Panchayat/ Ward:", boldFont21));
            userDetailVendingAddressTable.addCell(getCell(userApplicationEntity.getPanchayat().getPanchayatName(), boldFont2));
            userDetailVendingAddressTable.addCell(getCell("Entrepreneur/ Operator/ Vendor Application Address:", boldFont21));
            userDetailVendingAddressTable.addCell(getCell(userApplicationEntity.getVendingAddress(), boldFont2));
            userDetailVendingAddressTable.setSpacingBefore(Constants.reportTableSpacing);
            userDetailVendingAddressTable.getDefaultCell().setBorder(0);

            /**
             * User Application Details
             */
            PdfPTable userApplicationTable = new PdfPTable(4);
            float[] userApplicationTableColumns = {25f, 25f, 25f, 25f};
            userApplicationTable.setWidths(userApplicationTableColumns);
            PdfPCell userApplicationTableHeading = new PdfPCell(new Phrase("Other Details (Category, Subcategory and Dates):-  ", boldFont));
            userApplicationTableHeading.setColspan(4);
            userApplicationTableHeading.setBorder(0);
            userApplicationTableHeading.setVerticalAlignment(Element.ALIGN_MIDDLE);
            userApplicationTableHeading.setHorizontalAlignment(Element.ALIGN_LEFT);
            userApplicationTableHeading.setPadding(5);
            userApplicationTable.addCell(userApplicationTableHeading);
            userApplicationTable.addCell(getCell("From Date:", boldFont21));
            userApplicationTable.addCell(getCell(userApplicationEntity.getFromDate(), boldFont2));
            userApplicationTable.addCell(getCell("To Date:", boldFont21));
            userApplicationTable.addCell(getCell(userApplicationEntity.getTo_date(), boldFont2));
            userApplicationTable.addCell(getCell("Number of Days:", boldFont21));
            userApplicationTable.addCell(getCell(Integer.toString(userApplicationEntity.getTotalDays()), boldFont2));
            userApplicationTable.addCell(getCell("Nationality:", boldFont21));
            userApplicationTable.addCell(getCell(userApplicationEntity.getNationalityEntity().getNationalityName(), boldFont2));
            userApplicationTable.addCell(getCell("Purpose of Activity:", boldFont21));
            userApplicationTable.addCell(getCell(userApplicationEntity.getPurposeActivity().getLandTypeName(), boldFont2));
            userApplicationTable.addCell(getCell("Category:", boldFont21));
            userApplicationTable.addCell(getCell(userApplicationEntity.getCategory().getCategoryName(), boldFont2));
            userApplicationTable.addCell(getCell("Sub-Category:", boldFont21));
            userApplicationTable.addCell(getCell(userApplicationEntity.getSubcategory().getSubCategoryName(), boldFont2));
            userApplicationTable.setSpacingBefore(Constants.reportTableSpacing);
            userApplicationTable.getDefaultCell().setBorder(0);


            /**
             * Permissions
             */
            PdfPTable permissionsTable = new PdfPTable(5);
            float[] permissionsTableColumn = {10f, 10f, 20f, 40f, 20f};
            permissionsTable.setWidths(permissionsTableColumn);
            PdfPCell permissionsTableHeading = new PdfPCell(new Phrase("Application Permissions:- ", boldFont));
            permissionsTableHeading.setColspan(5);
            permissionsTableHeading.setBorder(0);
            permissionsTableHeading.setVerticalAlignment(Element.ALIGN_MIDDLE);
            permissionsTableHeading.setHorizontalAlignment(Element.ALIGN_LEFT);
            permissionsTableHeading.setPadding(5);
            permissionsTable.addCell(permissionsTableHeading);
            permissionsTable.setSpacingBefore(Constants.reportTableSpacing);
            permissionsTable.getDefaultCell().setBorder(0);

            if (!userApplicationEntity.getApp_permissions().isEmpty()) {
                permissionsTable.addCell(getCell("S.No:", boldFont21));
                permissionsTable.addCell(getCell("Role Name:", boldFont21));
                permissionsTable.addCell(getCell("Application Status:", boldFont21));
                permissionsTable.addCell(getCell("Comments:", boldFont21));
                permissionsTable.addCell(getCell("Date:", boldFont21));


                for (int i = 0; i < userApplicationEntity.getApp_permissions().size(); i++) {
                    // permissionsTable.addCell(getCell("S.No:",boldFont2));
                    permissionsTable.addCell(getCell(String.valueOf(i + 1), boldFont2));
                    // permissionsTable.addCell(getCell("Role Name:",boldFont2));
                    permissionsTable.addCell(getCell(userApplicationEntity.getApp_permissions().get(i).getRoleName(), boldFont2));
                    // permissionsTable.addCell(getCell("Application Status:",boldFont2));
                    if (userApplicationEntity.getApp_permissions().get(i).getStatus().equalsIgnoreCase("A")) {
                        permissionsTable.addCell(getCell("Approved", boldFont2));
                    } else if (userApplicationEntity.getApp_permissions().get(i).getStatus().equalsIgnoreCase("R")) {
                        permissionsTable.addCell(getCell("Rejected", boldFont2));
                    } else if (userApplicationEntity.getApp_permissions().get(i).getStatus().equalsIgnoreCase("P")) {
                        permissionsTable.addCell(getCell("Pending", boldFont2));
                    }

                    //  permissionsTable.addCell(getCell("Comments:",boldFont2));
                    permissionsTable.addCell(getCell(userApplicationEntity.getApp_permissions().get(i).getComments(), boldFont2));
                    //  permissionsTable.addCell(getCell("Date:",boldFont2));
                    permissionsTable.addCell(getCell(DateUtilities.convertToDateCustom(userApplicationEntity.getApp_permissions().get(i).getCreateddate().toString()), boldFont2));


                }

            } else {
                permissionsTable.addCell(getCell("No Permission Found", boldFont2));
            }

            /**
             * ApplicationFee Details
             *
             */
            /**
             * Fee As per Compliance
             */
            PdfPTable feeTable = new PdfPTable(6);
            float[] FeeTableColumn = {8f, 17f, 25f, 15f, 15f, 20f};
            feeTable.setWidths(FeeTableColumn);
            PdfPCell feeTableHeading = new PdfPCell(new Phrase("Fee Table :- ", boldFont));
            feeTableHeading.setColspan(6);
            feeTableHeading.setBorder(0);
            feeTableHeading.setVerticalAlignment(Element.ALIGN_MIDDLE);
            feeTableHeading.setHorizontalAlignment(Element.ALIGN_LEFT);
            feeTableHeading.setPadding(5);
            feeTable.addCell(feeTableHeading);
            feeTable.setSpacingBefore(Constants.reportTableSpacing);
            feeTable.getDefaultCell().setBorder(0);

            if (!userApplicationEntity.getApp_items().isEmpty()) {
                feeTable.addCell(getCell("S.No:", boldFont21));
                feeTable.addCell(getCell("Category Name:", boldFont21));
                feeTable.addCell(getCell("Item Name:", boldFont21));
                feeTable.addCell(getCell("Fees (Panchayat):", boldFont21));
                feeTable.addCell(getCell("Fees (Forest):", boldFont21));
                feeTable.addCell(getCell("Security Amount:", boldFont21));


                for (int i = 0; i < userApplicationEntity.getApp_items().size(); i++) {
                    feeTable.addCell(getCell(String.valueOf(i + 1), boldFont2));
                    feeTable.addCell(getCell(userApplicationEntity.getCategory().getCategoryName(), boldFont2));
                    feeTable.addCell(getCell(userApplicationEntity.getApp_items().get(i).getItem().getItemName(), boldFont2));
                    feeTable.addCell(getCell(userApplicationEntity.getApp_items().get(i).getItem().getFee(), boldFont2));
                    feeTable.addCell(getCell(userApplicationEntity.getApp_items().get(i).getItem().getFee_bdo(), boldFont2));
                    feeTable.addCell(getCell(userApplicationEntity.getApp_items().get(i).getItem().getSecurityAmount(), boldFont2));


                }

            } else {
                feeTable.addCell(getCell("No Items Selected.", boldFont2));
            }

            /**
             * Fee Status
             */
            PdfPTable feeStatusTable = new PdfPTable(4);
            float[] FeeStatusColumn = {20f, 25f, 20f, 20f};
            feeStatusTable.setWidths(FeeStatusColumn);
            PdfPCell feeStatusTableHeading = new PdfPCell(new Phrase("Fee Status :- ", boldFont));
            feeStatusTableHeading.setColspan(4);
            feeStatusTableHeading.setBorder(0);
            feeStatusTableHeading.setVerticalAlignment(Element.ALIGN_MIDDLE);
            feeStatusTableHeading.setHorizontalAlignment(Element.ALIGN_LEFT);
            feeStatusTableHeading.setPadding(5);
            feeStatusTable.addCell(feeStatusTableHeading);
            feeStatusTable.setSpacingBefore(Constants.reportTableSpacing);
            feeStatusTable.getDefaultCell().setBorder(0);


            if (transaction != null) {

                feeStatusTable.addCell(getCell("Payment Status:", boldFont21));
                feeStatusTable.addCell(getCell("Transaction ID", boldFont21));
                feeStatusTable.addCell(getCell("Payment Date", boldFont21));
                feeStatusTable.addCell(getCell("Amount:", boldFont21));

                if (transaction.getPaymentStatus().isEmpty()) {
                    feeStatusTable.addCell(getCell("Payment Status Unavailable", boldFont2));
                } else {
                    feeStatusTable.addCell(getCell(transaction.getPaymentStatus(), boldFont2));
                }


                feeStatusTable.addCell(getCell(transaction.getTransactionId(), boldFont2));
                feeStatusTable.addCell(getCell(DateUtilities.convertToDateCustom(transaction.getPaymentdateresponse().toString()), boldFont2));
                feeStatusTable.addCell(getCell(transaction.getAmount(), boldFont2));

            } else {
                feeStatusTable.addCell(getCell("Transaction Details Not Found", boldFont21));
            }

            /**
             * Instructions and QR Code
             */
            //Two
            // Create a Simple table
            PdfPTable two = new PdfPTable(2);
            float[] columnWidthsnestedtwo = {70f, 30f};
            two.setWidths(columnWidthsnestedtwo);
            two.getDefaultCell().setBorder(0);
            two.setSpacingBefore(Constants.reportTableSpacing);
            two.getDefaultCell().setBorder(0);


            // Create a new Table
            PdfPTable instructions_QrcodeTable = new PdfPTable(1);
            instructions_QrcodeTable.getDefaultCell().setBorder(0);
            float[] x = {100f};
            instructions_QrcodeTable.setWidths(x);
            instructions_QrcodeTable.addCell(new Phrase("Instructions:- ",boldFont2));
            instructions_QrcodeTable.addCell(new Phrase("Instructions One ",boldFont2));
            instructions_QrcodeTable.addCell(new Phrase("Instructions Two ",boldFont2));
            instructions_QrcodeTable.addCell(new Phrase("If found Please handover to DC OFFICE Lahaul (Keylong)", boldFont2));
            instructions_QrcodeTable.addCell(new Phrase("Application Generated On:- \t" + DateUtilities.getCurrentDate(), boldFont2));

            JsonObject jsonObjecttwo = new JsonObject();
            jsonObjecttwo.addProperty("application_id", userApplicationEntity.getAppId());
            jsonObjecttwo.addProperty("mobile_number", userApplicationEntity.getUserId().getMobileNumber());
            jsonObjecttwo.addProperty("user_id", userApplicationEntity.getUserId().getUserId());

            //postJson
            BarcodeQRCode barcodeQRCodetwo = new BarcodeQRCode(jsonObjecttwo.toString(), 30, 30, null);
            Image codeQrImagetwo = barcodeQRCodetwo.getImage();
            codeQrImagetwo.setBorder(0);
            PdfPTable childTable2two = new PdfPTable(1);
            childTable2two.addCell(codeQrImagetwo);
            childTable2two.getDefaultCell().setBorder(0);

            two.addCell(instructions_QrcodeTable);
            two.addCell(childTable2two);




            //Add the Sections to the Parent Table
            parent.addCell(zero);
            parent.addCell(userDetailTable);
            parent.addCell(userDetailPermanetAddressTable);
            parent.addCell(userDetailVendingAddressTable);
            parent.addCell(userApplicationTable);
            parent.addCell(permissionsTable);
            parent.addCell(feeTable);
            parent.addCell(feeStatusTable);
            parent.addCell(two);


            PdfWriter.getInstance(document, out);
            document.open();

            document.add(parent);

            document.close();

        } catch (DocumentException | MalformedURLException ex) {

            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    private static PdfPCell getCell(String data, Font font) {

        PdfPCell cell = new PdfPCell(new Phrase(data, font));
        cell.setBorderColorLeft(new BaseColor(242, 242, 242));
        cell.setBorderColorRight(new BaseColor(242, 242, 242));
        cell.setBorderColorTop(new BaseColor(242, 242, 242));
        cell.setBorderColorBottom(new BaseColor(242, 242, 242));
        cell.setPadding(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);

        return cell;
    }

    private static PdfPCell instructionCell(String data, Font font) {

        PdfPCell cell = new PdfPCell(new Phrase(data, font));
        cell.setColspan(3);
        cell.setBorderColorLeft(new BaseColor(242, 242, 242));
        cell.setBorderColorRight(new BaseColor(242, 242, 242));
        cell.setBorderColorTop(new BaseColor(242, 242, 242));
        cell.setBorderColorBottom(new BaseColor(242, 242, 242));
        cell.setPadding(5);
        cell.setBorder(0);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);

        return cell;
    }
}