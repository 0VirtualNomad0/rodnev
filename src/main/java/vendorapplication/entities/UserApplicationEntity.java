package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="user_application")
public class UserApplicationEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "user_application_app_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "user_application_app_id_seq", sequenceName = "public.user_application_app_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "app_id")
    private Integer appId;

    @OneToOne
    @JoinColumn(name="user_id" ,updatable = false)
    private UserEntity userId;

    @OneToOne
    @JoinColumn(name = "nationality_id",updatable = false)
    private NationalityEntity nationalityEntity;

    @OneToOne
    @JoinColumn(name = "ventype_id",updatable = false)
    private VendorEntity vendorId;

    @OneToOne
    @JoinColumn(name = "vendortype_id",updatable = false)
    private VendorTypeEntity vendorTypeId;

    @Column(name = "tent_number")
    private Integer tentNumber;


    @OneToOne
    @JoinColumn(name = "district_id", updatable = false)
    private DistrictEntity districtId;


    @Column(name = "identity_doc")
    private String identityDoc;

    @Column(name = "app_action_dc")
    private String appActionDc;

    @Column(name = "dc_comments")
    private String dcComments;

    @Column(name = "app_action_dfo")
    private String appActionDfo;

    @Column(name = "dfo_comments")
    private String dfoComments;

    @Column(name = "app_action_bdo")
    private String appActionBdo;

    @Column(name = "bdo_comments")
    private String bdoComments;

    @Column(name = "vendor_comments")
    private String vendorComments;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "lastmodifieddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @Column(name = "app_bdo_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appBdoDate;

    @Column(name = "app_dfo_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appDfoDate;

    @Column(name = "app_dc_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appDcDate;

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public NationalityEntity getNationalityEntity() {
        return nationalityEntity;
    }

    public void setNationalityEntity(NationalityEntity nationalityEntity) {
        this.nationalityEntity = nationalityEntity;
    }

    public VendorEntity getVendorId() {
        return vendorId;
    }

    public void setVendorId(VendorEntity vendorId) {
        this.vendorId = vendorId;
    }

    public VendorTypeEntity getVendorTypeId() {
        return vendorTypeId;
    }

    public void setVendorTypeId(VendorTypeEntity vendorTypeId) {
        this.vendorTypeId = vendorTypeId;
    }

    public Integer getTentNumber() {
        return tentNumber;
    }

    public void setTentNumber(Integer tentNumber) {
        this.tentNumber = tentNumber;
    }

    public DistrictEntity getDistrictId() {
        return districtId;
    }

    public void setDistrictId(DistrictEntity districtId) {
        this.districtId = districtId;
    }

    public String getIdentityDoc() {
        return identityDoc;
    }

    public void setIdentityDoc(String identityDoc) {
        this.identityDoc = identityDoc;
    }

    public String getAppActionDc() {
        return appActionDc;
    }

    public void setAppActionDc(String appActionDc) {
        this.appActionDc = appActionDc;
    }

    public String getDcComments() {
        return dcComments;
    }

    public void setDcComments(String dcComments) {
        this.dcComments = dcComments;
    }

    public String getAppActionDfo() {
        return appActionDfo;
    }

    public void setAppActionDfo(String appActionDfo) {
        this.appActionDfo = appActionDfo;
    }

    public String getDfoComments() {
        return dfoComments;
    }

    public void setDfoComments(String dfoComments) {
        this.dfoComments = dfoComments;
    }

    public String getAppActionBdo() {
        return appActionBdo;
    }

    public void setAppActionBdo(String appActionBdo) {
        this.appActionBdo = appActionBdo;
    }

    public String getBdoComments() {
        return bdoComments;
    }

    public void setBdoComments(String bdoComments) {
        this.bdoComments = bdoComments;
    }

    public String getVendorComments() {
        return vendorComments;
    }

    public void setVendorComments(String vendorComments) {
        this.vendorComments = vendorComments;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getAppBdoDate() {
        return appBdoDate;
    }

    public void setAppBdoDate(Date appBdoDate) {
        this.appBdoDate = appBdoDate;
    }

    public Date getAppDfoDate() {
        return appDfoDate;
    }

    public void setAppDfoDate(Date appDfoDate) {
        this.appDfoDate = appDfoDate;
    }

    public Date getAppDcDate() {
        return appDcDate;
    }

    public void setAppDcDate(Date appDcDate) {
        this.appDcDate = appDcDate;
    }

    @Override
    public String toString() {
        return "UserApplicationEntity{" +
                "appId=" + appId +
                ", userId=" + userId +
                ", nationalityEntity=" + nationalityEntity +
                ", vendorId=" + vendorId +
                ", vendorTypeId=" + vendorTypeId +
                ", tentNumber=" + tentNumber +
                ", districtId=" + districtId +
                ", identityDoc='" + identityDoc + '\'' +
                ", appActionDc='" + appActionDc + '\'' +
                ", dcComments='" + dcComments + '\'' +
                ", appActionDfo='" + appActionDfo + '\'' +
                ", dfoComments='" + dfoComments + '\'' +
                ", appActionBdo='" + appActionBdo + '\'' +
                ", bdoComments='" + bdoComments + '\'' +
                ", vendorComments='" + vendorComments + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                ", lastModified=" + lastModified +
                ", appBdoDate=" + appBdoDate +
                ", appDfoDate=" + appDfoDate +
                ", appDcDate=" + appDcDate +
                '}';
    }
}