package vendorapplication.modal;

import java.io.Serializable;

public class VendorModal implements Serializable {

    private Integer vendorId;
    private String vendorName;

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Override
    public String toString() {
        return "VendorModal{" +
                "vendorId=" + vendorId +
                ", vendorName='" + vendorName + '\'' +
                '}';
    }
}
