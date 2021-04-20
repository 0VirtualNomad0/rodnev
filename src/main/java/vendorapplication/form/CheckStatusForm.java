package vendorapplication.form;

import java.io.Serializable;

public class CheckStatusForm implements Serializable {

    private String appId;
    private String mobileNumber;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "CheckStatusForm{" +
                "appId='" + appId + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
