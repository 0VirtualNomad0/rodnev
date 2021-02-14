package vendorapplication.modal;

import java.io.Serializable;
import java.util.Date;

public class VendorDashboardList implements Serializable {


     private Integer app_id;
     private String  app_action_dc;
     private Date  app_dc_date;
     private String  app_action_dfo;
     private Date  app_dfo_date;
     private String  app_action_bdo;
     private Date app_bdo_date;
     private Date createdDate;
     private String vendorType;
     private String vendorCategory;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }

    public String getApp_action_dc() {
        return app_action_dc;
    }

    public void setApp_action_dc(String app_action_dc) {
        this.app_action_dc = app_action_dc;
    }

    public Date getApp_dc_date() {
        return app_dc_date;
    }

    public void setApp_dc_date(Date app_dc_date) {
        this.app_dc_date = app_dc_date;
    }

    public String getApp_action_dfo() {
        return app_action_dfo;
    }

    public void setApp_action_dfo(String app_action_dfo) {
        this.app_action_dfo = app_action_dfo;
    }

    public Date getApp_dfo_date() {
        return app_dfo_date;
    }

    public void setApp_dfo_date(Date app_dfo_date) {
        this.app_dfo_date = app_dfo_date;
    }

    public String getApp_action_bdo() {
        return app_action_bdo;
    }

    public void setApp_action_bdo(String app_action_bdo) {
        this.app_action_bdo = app_action_bdo;
    }

    public Date getApp_bdo_date() {
        return app_bdo_date;
    }

    public void setApp_bdo_date(Date app_bdo_date) {
        this.app_bdo_date = app_bdo_date;
    }

    public String getVendorType() {
        return vendorType;
    }

    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }

    public String getVendorCategory() {
        return vendorCategory;
    }

    public void setVendorCategory(String vendorCategory) {
        this.vendorCategory = vendorCategory;
    }

    @Override
    public String toString() {
        return "VendorDashboardList{" +
                "app_id=" + app_id +
                ", app_action_dc='" + app_action_dc + '\'' +
                ", app_dc_date=" + app_dc_date +
                ", app_action_dfo='" + app_action_dfo + '\'' +
                ", app_dfo_date=" + app_dfo_date +
                ", app_action_bdo='" + app_action_bdo + '\'' +
                ", app_bdo_date=" + app_bdo_date +
                ", createdDate=" + createdDate +
                ", vendorType='" + vendorType + '\'' +
                ", vendorCategory='" + vendorCategory + '\'' +
                '}';
    }
}
