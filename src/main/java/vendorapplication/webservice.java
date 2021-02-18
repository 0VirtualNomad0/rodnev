package vendorapplication;

import com.google.gson.JsonObject;
import com.oracle.javafx.jmx.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class webservice {

    public static String hashCal(String type,String str){
        byte[] hashseq=str.getBytes();
        StringBuffer hexString = new StringBuffer();
        try{
            MessageDigest algorithm = MessageDigest.getInstance(type);
            algorithm.reset();
            algorithm.update(hashseq);
            byte messageDigest[] = algorithm.digest();
            for (int i=0;i<messageDigest.length;i++) {
                String hex=Integer.toHexString(0xFF & messageDigest[i]);
                if(hex.length()==1) hexString.append("0");
                hexString.append(hex);
            }

        }catch(NoSuchAlgorithmException nsae){ }
        return hexString.toString();
    }

    public static void main(String args[]){

        JsonObject jObject = null;
        String testUrl = "https://test.payu.in/merchant/postservice.php?form=2";
        String method = "verify_payment";

        //Salt of the merchant
        String salt = "pjVQAWpA";

        //Key of the merchant
        String key = "7rnFly";

        String var1= "84330869536e"; // transaction id


        String toHash = key + "|" + method + "|" + var1 + "|" + salt;
        String Hashed = hashCal("SHA-512",toHash);
        String Poststring = "key=" + key +  "&command=" + method +  "&hash=" + Hashed + "&var1=" + var1 ;


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
            try {
                System.out.println(response);
//                jObject = new JsonObject(response);
//                if(null!=jObject){
//                    System.out.println(jObject.getAsJsonObject("transaction_details").get(var1).toString());
//                }
            } catch (JSONException e) {
            }

        } catch (IOException e) {

        }


    }
}