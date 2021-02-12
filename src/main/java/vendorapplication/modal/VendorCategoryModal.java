package vendorapplication.modal;


import java.io.Serializable;

public class VendorCategoryModal implements Serializable {

    private Integer vendorCategoryId;
    private String vendorCategoryName;

    public Integer getVendorCategoryId() {
        return vendorCategoryId;
    }

    public void setVendorCategoryId(Integer vendorCategoryId) {
        this.vendorCategoryId = vendorCategoryId;
    }

    public String getVendorCategoryName() {
        return vendorCategoryName;
    }

    public void setVendorCategoryName(String vendorCategoryName) {
        this.vendorCategoryName = vendorCategoryName;
    }

    @Override
    public String toString() {
        return "VendorCategoryModal{" +
                "vendorCategoryId=" + vendorCategoryId +
                ", vendorCategoryName='" + vendorCategoryName + '\'' +
                '}';
    }
}
