package vendorapplication.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "payment.gateway")
public class PaymentGatewayProperties {

    private String url;
    private String verifypayment;
    private String key;
    private String salt;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVerifypayment() {
        return verifypayment;
    }

    public void setVerifypayment(String verifypayment) {
        this.verifypayment = verifypayment;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "PaymentGatewayProperties{" +
                "url='" + url + '\'' +
                ", verifypayment='" + verifypayment + '\'' +
                ", key='" + key + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
