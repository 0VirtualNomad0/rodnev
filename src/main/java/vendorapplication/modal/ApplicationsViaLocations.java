package vendorapplication.modal;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class ApplicationsViaLocations implements Serializable {


     private Integer app_id;
     private Integer user_id;
     private String application_status;
     private String category;
     private String subCategory;
     private String firstName;
     private String lastName;
     private BigInteger mobileNumber;

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getApplication_status() {
        return application_status;
    }

    public void setApplication_status(String application_status) {
        this.application_status = application_status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigInteger getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(BigInteger mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "VendorDashboardList{" +
                "app_id=" + app_id +
                ", user_id=" + user_id +
                ", application_status='" + application_status + '\'' +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
