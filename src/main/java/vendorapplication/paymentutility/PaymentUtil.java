package vendorapplication.paymentutility;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vendorapplication.property.PaymentProperties;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;


public class PaymentUtil {


    @Autowired
    static private PaymentProperties properties;



    private static final String paymentKey = "7rnFly";
    private static final String paymentSalt = "pjVQAWpA";
    private static final String serverPath = ServletUriComponentsBuilder.fromCurrentContextPath().path("/paymentResponse").toUriString();
    private static final String fUrl = serverPath;
    private static final String sUrl = serverPath;


    public  PaymentDetail populatePaymentDetail(PaymentDetail paymentDetail) {
        String hashString = "";
        Random rand = new Random();
        String rndm = Integer.toString(rand.nextInt()) + (System.currentTimeMillis() / 1000L);
        String txnId = hashCal("SHA-256", rndm).substring(0, 12);
        paymentDetail.setTxnId(txnId);
        String hash = "";
        String hashSequence = "key|txnid|amount|productinfo|firstname|email|||||||||||";
        hashString = hashSequence.concat(paymentSalt);
        hashString = hashString.replace("key", paymentKey);
        hashString = hashString.replace("txnid", txnId);
        hashString = hashString.replace("amount", Double.toString(paymentDetail.getAmount()));
        hashString = hashString.replace("productinfo", paymentDetail.getProductInfo());
        hashString = hashString.replace("firstname", paymentDetail.getName());
        hashString = hashString.replace("email", paymentDetail.getEmail());
        hash = hashCal("SHA-512", hashString);
        paymentDetail.setHash(hash);
        paymentDetail.setfUrl(fUrl);
        paymentDetail.setsUrl(sUrl);
        paymentDetail.setKey(paymentKey);
        System.out.println(paymentDetail.toString());
        return paymentDetail;
    }

    public static String hashCal(String type, String str) {
        byte[] hashseq = str.getBytes();
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest algorithm = MessageDigest.getInstance(type);
            algorithm.reset();
            algorithm.update(hashseq);
            byte messageDigest[] = algorithm.digest();
            for (int i = 0; i < messageDigest.length; i++) {
                String hex = Integer.toHexString(0xFF & messageDigest[i]);
                if (hex.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(hex);
            }

        } catch (NoSuchAlgorithmException nsae) {
        }
        return hexString.toString();
    }

    public  String verifyHash(PaymentCallback paymentCallback) {
        String hashString = "";
        String hashSequence = null;
        String hash;


        if (paymentCallback.getAdditionalCharges().isEmpty()) {
            hashSequence = paymentSalt + "|" + paymentCallback.getStatus() + "|||||||||||" + paymentCallback.getEmail() + "|" + paymentCallback.getFirstname() + "|" + paymentCallback.getProductinfo() + "|" + paymentCallback.getAmount() + "|" + paymentCallback.getTxnid() + "|";

        } else {
            hashSequence = paymentCallback.getAdditionalCharges() + "|" + paymentSalt + "|" + paymentCallback.getStatus() + "|||||||||||" + paymentCallback.getEmail() + "|" + paymentCallback.getFirstname() + "|" + paymentCallback.getProductinfo() + "|" + paymentCallback.getAmount() + "|" + paymentCallback.getTxnid() + "|";

        }

        hashString = hashSequence.concat(paymentCallback.getKey());
        System.out.println(hashString);
        hash = hashCal("SHA-512", hashString);
        System.out.println(hash);

        return hash;


    }


    //This function is used to double check payment
    public  String verifyPayment(String txnid) {
        String command = "verify_payment";

        JsonObject jObject = null;
        String testUrl = "https://test.payu.in/merchant/postservice.php?form=2";
        String method = "verify_payment";

        //Salt of the merchant
        String salt = paymentSalt;

        //Key of the merchant
        String key = paymentKey;

        String var1 = txnid; // transaction id


        String toHash = key + "|" + method + "|" + var1 + "|" + salt;
        String Hashed = hashCal("SHA-512", toHash);
        String Poststring = "key=" + key + "&command=" + method + "&hash=" + Hashed + "&var1=" + var1;


        // Create connection

        try {
            URL url = new URL(testUrl);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(Poststring);
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String response = "";
            while ((line = rd.readLine()) != null) {
                response += line;
            }

                return response;


        } catch (IOException e) {
            return e.getLocalizedMessage().toString();
        }

    }

    public  boolean verifyPaymentcheck(String txnid) {
        String command = "verify_payment";
        String hashstr = paymentKey + "|" + command + "|" + txnid + "|" + paymentSalt;

        String hash = hashCal("SHA-512", hashstr);

        StringBuilder response = new StringBuilder();

        try {
            //for production
            //String wsUrl = "https://info.payu.in/merchant/postservice.php?form=1";

            //for test
            URL wsUrl = new URL("https://test.payu.in/merchant/postservice.php?form=2");

            Map<String, Object> params = new LinkedHashMap<>();
            params.put("key", paymentKey);
            params.put("hash", hash);
            params.put("var1", txnid);
            params.put("command", command);

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) wsUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-vendorapplication.form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));


            for (int c; (c = in.read()) >= 0; ) {
                response.append((char) c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String resp = response.toString();
        System.out.println(resp.toString());

        if (resp.indexOf("\"status\":\"success\"") > 1)
            return true;
        else
            return false;

    }

}