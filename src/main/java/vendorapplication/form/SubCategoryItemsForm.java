package vendorapplication.form;

import java.io.Serializable;

public class SubCategoryItemsForm implements Serializable {

    private String itemName;
    private String categoryId;
    private String vendorType;
    private String landType;
    private String security;
    private String fee;
    private String nationality;
    private String nationalRegional;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getVendorType() {
        return vendorType;
    }

    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }

    public String getLandType() {
        return landType;
    }

    public void setLandType(String landType) {
        this.landType = landType;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationalRegional() {
        return nationalRegional;
    }

    public void setNationalRegional(String nationalRegional) {
        this.nationalRegional = nationalRegional;
    }

    @Override
    public String toString() {
        return "SubCategoryItemsForm{" +
                "itemName='" + itemName + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", vendorType='" + vendorType + '\'' +
                ", landType='" + landType + '\'' +
                ", security='" + security + '\'' +
                ", fee='" + fee + '\'' +
                ", nationality='" + nationality + '\'' +
                ", nationalRegional='" + nationalRegional + '\'' +
                '}';
    }
}
