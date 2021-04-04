package vendorapplication.Controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vendorapplication.entities.OTPEntity;
import vendorapplication.entities.UserApplicationEntity;
import vendorapplication.entities.UserTranactionEntity;
import vendorapplication.enums.PaymentMode;
import vendorapplication.enums.PaymentStatus;
import vendorapplication.form.PaymentForm;
import vendorapplication.paymentutility.PaymentCallback;
import vendorapplication.paymentutility.PaymentDetail;
import vendorapplication.paymentutility.PaymentUtil;
import vendorapplication.services.OTPService;
import vendorapplication.services.UserApplicationService;
import vendorapplication.services.UserTransactionService;
import vendorapplication.utilities.CalculateAmount;
import vendorapplication.utilities.Constants;
import vendorapplication.utilities.SMSServices;
import vendorapplication.utilities.Utilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class PaymentPageController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentPageController.class);

    @Autowired
    UserTransactionService userTransactionService;

    @Autowired
    private UserApplicationService userApplicationService;

    @Autowired
    private OTPService otpService;

    private String otp_response = null;





    @RequestMapping(value = "/paymentpage", method = RequestMethod.GET)
    @Transactional
    public String paymentpage(Model model, HttpServletRequest request, HttpSession session) {
        model.addAttribute("paymentForm", new PaymentForm());
       // Integer appId_ = (Integer) model.asMap().get("appId");
        Integer appId_ = (Integer) session.getAttribute("appId");
        System.out.println(appId_);
        UserApplicationEntity appData = null;
        PaymentUtil paymentUtil = new PaymentUtil();

        try {
            appData = userApplicationService.getUserApplicationViaAppId(appId_);
            if (appData != null) {

                    System.out.println(appData.toString());
                    PaymentDetail paymentDetail = new PaymentDetail();


                if(appData.getNationalityEntity().getNationalityId() == 1){

                    paymentDetail.setAmount(Double.parseDouble(CalculateAmount.calculateAmount(appData)));
                }else{
                    /**
                     * 3X In Case of Foreigner
                     */
                    paymentDetail.setAmount(Double.parseDouble(CalculateAmount.calculateAmount(appData))*3);
                }



                    paymentDetail.setName(appData.getUserId().getFirstName()+" "+ appData.getUserId().getLastName());
                    paymentDetail.setProductInfo(Integer.toString(appData.getAppId()));
                    paymentDetail.setPhone(String.valueOf(appData.getUserId().getMobileNumber()));

                    if(appData.getUserId().getEmail().isEmpty() || appData.getUserId().getEmail() == null){
                        paymentDetail.setEmail(Constants.email_reference);
                    }else{
                        paymentDetail.setEmail(appData.getUserId().getEmail());
                    }


                    paymentDetail = paymentUtil.populatePaymentDetail(paymentDetail);

                    //Save Data to Entity
                    UserTranactionEntity transactionEntity = new UserTranactionEntity();
                    transactionEntity.setUserId(appData.getAppId());
                    if(appData.getUserId().getEmail().isEmpty() || appData.getUserId().getEmail() ==null ){
                        transactionEntity.setEmail(Constants.email_reference);
                    }else{
                        transactionEntity.setEmail(appData.getUserId().getEmail().trim());
                    }

                    transactionEntity.setName(appData.getUserId().getFirstName()+" "+ appData.getUserId().getLastName());
                    transactionEntity.setPhone(String.valueOf(appData.getUserId().getMobileNumber()));
                    transactionEntity.setAmount(String.valueOf(paymentDetail.getAmount()));
                    transactionEntity.setPaymentStatus("");
                    transactionEntity.setTransactionId(paymentDetail.getTxnId());
                    transactionEntity.setActive(true);
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    Date date = new Date(timestamp.getTime());
                    transactionEntity.setCreatedDate(date);
                    transactionEntity.setPaymentdateresponse(date);
                    userTransactionService.saveTransaction(transactionEntity);


                    request.getSession().setAttribute("merchant_key", paymentDetail.getKey());
                    request.getSession().setAttribute("hash", paymentDetail.getHash());
                    request.getSession().setAttribute("txnid", paymentDetail.getTxnId());
                    request.getSession().setAttribute("amount", paymentDetail.getAmount());
                    request.getSession().setAttribute("firstname", paymentDetail.getName());
                    request.getSession().setAttribute("email", paymentDetail.getEmail());
                    request.getSession().setAttribute("phone", paymentDetail.getPhone());
                    request.getSession().setAttribute("productinfo", paymentDetail.getProductInfo());
                    request.getSession().setAttribute("surl", paymentDetail.getsUrl());
                    request.getSession().setAttribute("furl", paymentDetail.getfUrl());
                    request.getSession().setAttribute("security", appData.getApp_items().get(0).getItem().getSecurityAmount());

                    model.addAttribute("user", appData);
                    return "paymentpage";


            } else {
                return "vendorForm";
            }
        } catch (Exception ex) {
            return "vendorForm";
        }

    }




    @RequestMapping(value = "/paymentResponse", method = RequestMethod.POST)
    public String paymentResponse(Model model, HttpServletRequest request,
                                  @RequestParam String mihpayid,
                                  @RequestParam String status,
                                  @RequestParam String txnid,
                                  @RequestParam PaymentMode mode,
                                  @RequestParam String hash,
                                  @RequestParam String key,
                                  @RequestParam String amount,
                                  @RequestParam String productinfo,
                                  @RequestParam String firstname,
                                  @RequestParam String email,
                                  @RequestParam String phone,
                                  @RequestParam String error,
                                  @RequestParam String bank_ref_num,
                                  @RequestParam String addedon,
                                  @RequestParam (value = "additionalCharges", required = false, defaultValue = "") String additionalCharges
                                 ) {
        PaymentCallback paymentCallback = new PaymentCallback();
        PaymentUtil paymentUtil = new PaymentUtil();
        UserTranactionEntity entity_ = null;

        try {



            if (Utilities.empty(additionalCharges)) {
                paymentCallback.setAdditionalCharges("");
            } else {
                paymentCallback.setAdditionalCharges(additionalCharges);
            }

            if (Utilities.empty(amount)) {
                paymentCallback.setAmount("");
            } else {
                paymentCallback.setAmount(amount);
            }


            if (Utilities.empty(mihpayid)) {
                paymentCallback.setMihpayid("");
            } else {
                paymentCallback.setMihpayid(mihpayid);
            }

            if (Utilities.empty(status)) {
                paymentCallback.setStatus(PaymentStatus.Failed.toString());
            } else {
                paymentCallback.setStatus(status);
            }

            if (Utilities.empty(txnid)) {
                paymentCallback.setTxnid("");
            } else {
                paymentCallback.setTxnid(txnid);
            }

            if (Utilities.empty(hash)) {
                paymentCallback.setHash("");
            } else {
                paymentCallback.setHash(hash);
            }

            if (Utilities.empty(key)) {
                paymentCallback.setKey("");
            } else {
                paymentCallback.setKey(key);
            }

            if (Utilities.empty(productinfo)) {
                paymentCallback.setProductinfo("");
            } else {
                paymentCallback.setProductinfo(productinfo);
            }

            if (Utilities.empty(firstname)) {
                paymentCallback.setFirstname("");
            } else {
                paymentCallback.setFirstname(firstname);
            }

            if (Utilities.empty(email)) {
                paymentCallback.setEmail("");
            } else {
                paymentCallback.setEmail(email);
            }

            if (Utilities.empty(phone)) {
                paymentCallback.setPhone("");
            } else {
                paymentCallback.setPhone(phone);
            }

            if (Utilities.empty(error)) {
                paymentCallback.setError(error);
            } else {
                paymentCallback.setError(error);
            }

            if (Utilities.empty(bank_ref_num)) {
                paymentCallback.setBank_ref_num("");
            } else {
                paymentCallback.setBank_ref_num(bank_ref_num);
            }


            if (Utilities.empty(mode.toString())) {

                paymentCallback.setMode(PaymentMode.NA);
            } else {
                paymentCallback.setMode(mode);
            }

             entity_ = userTransactionService.getUserTransaction(Integer.parseInt(productinfo));
            if(entity_!=null){
                //Check if the transaction ID is Same
                if(!entity_.getTransactionId().equalsIgnoreCase(txnid) && Utilities.empty(txnid)){
                    //Payment False
                    entity_.setPaymentStatus(status);
                    entity_.setBankRefNumber(bank_ref_num);
                    entity_.setPaymentMode(mode.toString());
                    entity_.setError("Transaction ID Null");
                    entity_.setMihpayId(mihpayid);
                    entity_.setEmail(email);
                    request.getSession().setAttribute("paymentStatus", "Failed");
                    request.getSession().setAttribute("TransactionId", entity_.getTransactionId());
                    request.getSession().setAttribute("Amount", entity_.getAmount());
                    request.getSession().setAttribute("ApplicationId", entity_.getUserId());
                    request.getSession().setAttribute("Name", entity_.getName());
                    request.getSession().setAttribute("MobileNumber", entity_.getPhone());
                    request.getSession().setAttribute("email", entity_.getEmail());
                    userTransactionService.saveTransaction(entity_);
                    return "paymentResponse";
                }else{
                    //Check Hash
                    if(hash.equalsIgnoreCase(paymentUtil.verifyHash(paymentCallback))){
                       if(status.equalsIgnoreCase("success")){
                           entity_.setPaymentStatus("Success");
                           entity_.setBankRefNumber(bank_ref_num);
                           entity_.setPaymentMode(mode.toString());
                           entity_.setMihpayId(mihpayid);
                           entity_.setEmail(email);
                           entity_.setError("");
                           request.getSession().setAttribute("paymentStatus", "Success");
                           request.getSession().setAttribute("TransactionId", entity_.getTransactionId());
                           request.getSession().setAttribute("Amount", entity_.getAmount());
                           request.getSession().setAttribute("ApplicationId", entity_.getUserId());
                           request.getSession().setAttribute("Name", entity_.getName());
                           request.getSession().setAttribute("MobileNumber", entity_.getPhone());
                           request.getSession().setAttribute("email", entity_.getEmail());
                           //SEND OTP TO CLIENT
                           SMSServices sms = new SMSServices();
                           String SMSServerCode = null;
                           otp_response = sms.sendOtpSMS(Constants.smsUsername,
                                   Constants.smsPassword, Constants.otp_Message +" "+ entity_.getUserId() + Constants.otp_MessageEnd,
                                   Constants.smsSenderId,entity_.getPhone(),Constants.smsSecureKey, Constants.templateId);

                           if (!otp_response.isEmpty()) {
                               System.out.println(otp_response);
                               SMSServerCode = otp_response.split(",")[0];

                               if(SMSServerCode.equalsIgnoreCase("402")){
                                   OTPEntity otp = new OTPEntity();
                                   otp.setCdac_response(otp_response);
                                   otp.setPhone(String.valueOf(entity_.getPhone()));
                                   otp.setUserId(entity_.getUserId());
                                   otp.setSent_message(Constants.otp_Message +" "+ entity_.getUserId() + Constants.otp_MessageEnd);
                                   Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                                   Date date = new Date(timestamp.getTime());
                                   otp.setSendTime(date);
                                   otpService.saveOTP(otp);

                               }else{
                                   //Save to DB no SMS
                                   OTPEntity otp = new OTPEntity();
                                   otp.setCdac_response(otp_response);
                                   otp.setPhone(String.valueOf(entity_.getPhone()));
                                   otp.setUserId(entity_.getUserId());
                                   otp.setSent_message(Constants.otp_Message +" "+ entity_.getUserId() + Constants.otp_MessageEnd);
                                   Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                                   Date date = new Date(timestamp.getTime());
                                   otp.setSendTime(date);
                                   otpService.saveOTP(otp);
                               }

                           }else{
                               OTPEntity otp = new OTPEntity();
                               otp.setCdac_response("No Resonse From CDAC");
                               otp.setPhone(String.valueOf(entity_.getPhone()));
                               otp.setUserId(entity_.getUserId());
                               otp.setSent_message(Constants.otp_Message +" "+ entity_.getUserId() + Constants.otp_MessageEnd);
                               Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                               Date date = new Date(timestamp.getTime());
                               otp.setSendTime(date);
                               otpService.saveOTP(otp);
                           }




                           userTransactionService.saveTransaction(entity_);
                           return "paymentResponse";
                       }else{
                           entity_.setPaymentStatus("Faliure");
                           entity_.setBankRefNumber(bank_ref_num);
                           entity_.setPaymentMode(mode.toString());
                           entity_.setMihpayId(mihpayid);
                           entity_.setEmail(email);
                           entity_.setError("PAyment Failed . Please contact Admin.");
                           request.getSession().setAttribute("paymentStatus", "Failed");
                           request.getSession().setAttribute("TransactionId", entity_.getTransactionId());
                           request.getSession().setAttribute("Amount", entity_.getAmount());
                           request.getSession().setAttribute("ApplicationId", entity_.getUserId());
                           request.getSession().setAttribute("Name", entity_.getName());
                           request.getSession().setAttribute("MobileNumber", entity_.getPhone());
                           request.getSession().setAttribute("email", entity_.getEmail());
                           userTransactionService.saveTransaction(entity_);
                           return "paymentResponse";
                       }
                    }else{
                        entity_.setPaymentStatus("Faliure");
                        entity_.setBankRefNumber(bank_ref_num);
                        entity_.setPaymentMode(mode.toString());
                        entity_.setMihpayId(mihpayid);
                        entity_.setEmail(email);
                        entity_.setError("Hash Mismatched");
                        request.getSession().setAttribute("paymentStatus", "Failed, Hash Mismatched");
                        request.getSession().setAttribute("TransactionId", entity_.getTransactionId());
                        request.getSession().setAttribute("Amount", entity_.getAmount());
                        request.getSession().setAttribute("ApplicationId", entity_.getUserId());
                        request.getSession().setAttribute("Name", entity_.getName());
                        request.getSession().setAttribute("MobileNumber", entity_.getPhone());
                        request.getSession().setAttribute("email", entity_.getEmail());
                        userTransactionService.saveTransaction(entity_);
                        return "paymentResponse";
                    }

                }
            }else{
                entity_.setPaymentStatus("Faliure");
                entity_.setBankRefNumber(bank_ref_num);
                entity_.setPaymentMode(mode.toString());
                entity_.setMihpayId(mihpayid);
                entity_.setError("No data Found for the corresponding Application ID");
                request.getSession().setAttribute("paymentStatus", "Failed, Hash Mismatched");
                request.getSession().setAttribute("TransactionId", entity_.getTransactionId());
                request.getSession().setAttribute("Amount", entity_.getAmount());
                request.getSession().setAttribute("ApplicationId", entity_.getUserId());
                request.getSession().setAttribute("Name", entity_.getName());
                request.getSession().setAttribute("MobileNumber", entity_.getPhone());
                request.getSession().setAttribute("email", entity_.getEmail());
                userTransactionService.saveTransaction(entity_);
                return "paymentResponse";
            }



        } catch (Exception ex) {
            entity_.setPaymentStatus("Faliure");
            entity_.setBankRefNumber(bank_ref_num);
            entity_.setPaymentMode(mode.toString());
            entity_.setMihpayId(mihpayid);
            entity_.setError("Unexpected Error Occured!");
            request.getSession().setAttribute("paymentStatus", "Failed, Hash Mismatched");
            request.getSession().setAttribute("TransactionId", entity_.getTransactionId());
            request.getSession().setAttribute("Amount", entity_.getAmount());
            request.getSession().setAttribute("ApplicationId", entity_.getUserId());
            request.getSession().setAttribute("Name", entity_.getName());
            request.getSession().setAttribute("MobileNumber", entity_.getPhone());
            request.getSession().setAttribute("email", entity_.getEmail());
            userTransactionService.saveTransaction(entity_);
            return "paymentResponse";
        }


    }

    private UserTranactionEntity saveEntity(PaymentCallback paymentCallback){
        UserTranactionEntity entity = new UserTranactionEntity();
        entity.setActive(true);
        entity.setAmount(paymentCallback.getAmount());
        entity.setBankRefNumber(paymentCallback.getBank_ref_num());
        entity.setEmail(paymentCallback.getEmail());
        entity.setError(paymentCallback.getError());
        entity.setMihpayId(paymentCallback.getMihpayid());
        entity.setName(paymentCallback.getFirstname());
        entity.setPaymentMode(paymentCallback.getMode().toString());
        entity.setPaymentStatus("Failed");
        entity.setTransactionId(paymentCallback.getTxnid());
        entity.setUserId(Integer.parseInt(paymentCallback.getProductinfo()));
        entity.setPhone(paymentCallback.getPhone());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());
        entity.setCreatedDate(date);
        UserTranactionEntity transactionDB = userTransactionService.saveTransaction(entity);
        return transactionDB;
    }

    private UserTranactionEntity saveEntitySuccess(PaymentCallback paymentCallback){
        UserTranactionEntity entity = new UserTranactionEntity();
        entity.setActive(true);
        entity.setAmount(paymentCallback.getAmount());
        entity.setBankRefNumber(paymentCallback.getBank_ref_num());
        entity.setEmail(paymentCallback.getEmail());
        entity.setError(paymentCallback.getError());
        entity.setMihpayId(paymentCallback.getMihpayid());
        entity.setName(paymentCallback.getFirstname());
        entity.setPaymentMode(paymentCallback.getMode().toString());
        entity.setPaymentStatus("success");
        entity.setTransactionId(paymentCallback.getTxnid());
        entity.setUserId(Integer.parseInt(paymentCallback.getProductinfo()));
        entity.setPhone(paymentCallback.getPhone());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());
        entity.setCreatedDate(date);
        UserTranactionEntity transactionDB = userTransactionService.saveTransaction(entity);
        return transactionDB;
    }


}