package vendorapplication.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("payment")
public class PaymentProperties {

    private String paymentGatewayUrl;
    private String verifyPaymentUrl;
    private String key;
    private String salt;

    public String getPaymentGatewayUrl() {
        return paymentGatewayUrl;
    }

    public void setPaymentGatewayUrl(String paymentGatewayUrl) {
        this.paymentGatewayUrl = paymentGatewayUrl;
    }

    public String getVerifyPaymentUrl() {
        return verifyPaymentUrl;
    }

    public void setVerifyPaymentUrl(String verifyPaymentUrl) {
        this.verifyPaymentUrl = verifyPaymentUrl;
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
}
