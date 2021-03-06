package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    @JoinColumn(name="state_id" ,updatable = false)
    private StateEntity state;

    @OneToOne
    @JoinColumn(name="district_id" ,updatable = false)
    private DistrictEntity district;

    @OneToOne
    @JoinColumn(name="block_id" ,updatable = false)
    private BlocksEntity block;

    @OneToOne
    @JoinColumn(name="tehsil_id" ,updatable = false)
    private TehsilEntity tehsil;

    @OneToOne
    @JoinColumn(name="panchayat_id" ,updatable = false)
    private GPEntity panchayat;

    @Column(name = "vending_address")
    private String vendingAddress;

    @Column(name = "from_date")
    private String fromDate;

    @Column(name = "to_date")
    private String to_date;

    @Column(name = "total_days")
    private Integer totalDays;

    @OneToOne
    @JoinColumn(name = "nationality_id",updatable = false)
    private NationalityEntity nationalityEntity;

    @OneToOne
    @JoinColumn(name = "category_id",updatable = false)
    private CategoryEntity category;

    @OneToOne
    @JoinColumn(name = "subcategory_id",updatable = false)
    private SubCategoryEntity subcategory;

    @OneToOne
    @JoinColumn(name = "landtype_id",updatable = false)
    private LandTypeEntity purposeActivity;

    @Column(name = "fine_defaulter")
    private String fineDefaulter;

    @Column(name = "withdraw_ven_licence")
    private String withdrawVenLicence;

    @Column(name = "identity_doc")
    private String identityDoc;

    @Column(name = "photo_doc")
    private String photoDoc;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,targetEntity = UserAppItemsEntity.class)
    @JoinColumn(name="app_id")
    private List<UserAppItemsEntity> app_items;

    public List<UserAppItemsEntity> getApp_items() {
        return app_items;
    }

    public void setApp_items(List<UserAppItemsEntity> app_items) {
        this.app_items = app_items;
    }

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

    public StateEntity getState() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
    }

    public DistrictEntity getDistrict() {
        return district;
    }

    public void setDistrict(DistrictEntity district) {
        this.district = district;
    }

    public BlocksEntity getBlock() {
        return block;
    }

    public void setBlock(BlocksEntity block) {
        this.block = block;
    }

    public TehsilEntity getTehsil() {
        return tehsil;
    }

    public void setTehsil(TehsilEntity tehsil) {
        this.tehsil = tehsil;
    }

    public GPEntity getPanchayat() {
        return panchayat;
    }

    public void setPanchayat(GPEntity panchayat) {
        this.panchayat = panchayat;
    }

    public String getVendingAddress() {
        return vendingAddress;
    }

    public void setVendingAddress(String vendingAddress) {
        this.vendingAddress = vendingAddress;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    public NationalityEntity getNationalityEntity() {
        return nationalityEntity;
    }

    public void setNationalityEntity(NationalityEntity nationalityEntity) {
        this.nationalityEntity = nationalityEntity;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public SubCategoryEntity getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(SubCategoryEntity subcategory) {
        this.subcategory = subcategory;
    }

    public LandTypeEntity getPurposeActivity() {
        return purposeActivity;
    }

    public void setPurposeActivity(LandTypeEntity purposeActivity) {
        this.purposeActivity = purposeActivity;
    }

    public String getFineDefaulter() {
        return fineDefaulter;
    }

    public void setFineDefaulter(String fineDefaulter) {
        this.fineDefaulter = fineDefaulter;
    }

    public String getWithdrawVenLicence() {
        return withdrawVenLicence;
    }

    public void setWithdrawVenLicence(String withdrawVenLicence) {
        this.withdrawVenLicence = withdrawVenLicence;
    }

    public String getIdentityDoc() {
        return identityDoc;
    }

    public void setIdentityDoc(String identityDoc) {
        this.identityDoc = identityDoc;
    }

    public String getPhotoDoc() {
        return photoDoc;
    }

    public void setPhotoDoc(String photoDoc) {
        this.photoDoc = photoDoc;
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

    @Override
    public String toString() {
        return "UserApplicationEntity{" +
                "appId=" + appId +
                ", userId=" + userId +
                ", state=" + state +
                ", district=" + district +
                ", block=" + block +
                ", tehsil=" + tehsil +
                ", panchayat=" + panchayat +
                ", vendingAddress='" + vendingAddress + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", to_date='" + to_date + '\'' +
                ", totalDays=" + totalDays +
                ", nationalityEntity=" + nationalityEntity +
                ", category=" + category +
                ", subcategory=" + subcategory +
                ", purposeActivity=" + purposeActivity +
                ", fineDefaulter='" + fineDefaulter + '\'' +
                ", withdrawVenLicence='" + withdrawVenLicence + '\'' +
                ", identityDoc='" + identityDoc + '\'' +
                ", photoDoc='" + photoDoc + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                ", app_items=" + app_items +
                '}';
    }
}