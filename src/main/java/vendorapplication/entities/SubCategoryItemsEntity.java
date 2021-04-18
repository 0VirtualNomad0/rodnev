package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mst_subcategoryitems")
public class SubCategoryItemsEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_subcategoryitems_items_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_subcategoryitems_items_id_seq", sequenceName = "public.mst_subcategoryitems_items_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "items_id")
    private Integer itemId;

    @OneToOne
    @JoinColumn(name="category_id" )
    private CategoryEntity category;

    @OneToOne
    @JoinColumn(name="subcategory_id" )
    private SubCategoryEntity subCategory;

    @Column(name = "items_name")
    private String itemName;

    @OneToOne
    @JoinColumn(name="landtype_id" )
    private LandTypeEntity landType;

    @OneToOne
    @JoinColumn(name="nationality_id" )
    private NationalityEntity nationality;

    @OneToOne
    @JoinColumn(name="nationalregional_id" )
    private NationalRegionalEntity nationalRegional;

    @Column(name = "securityamount")
    private String securityAmount;

    @Column(name = "fee")
    private String fee;

    @Column(name = "fee_panchayat")
    private String fee_bdo;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public SubCategoryEntity getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategoryEntity subCategory) {
        this.subCategory = subCategory;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public LandTypeEntity getLandType() {
        return landType;
    }

    public void setLandType(LandTypeEntity landType) {
        this.landType = landType;
    }

    public NationalityEntity getNationality() {
        return nationality;
    }

    public void setNationality(NationalityEntity nationality) {
        this.nationality = nationality;
    }

    public NationalRegionalEntity getNationalRegional() {
        return nationalRegional;
    }

    public void setNationalRegional(NationalRegionalEntity nationalRegional) {
        this.nationalRegional = nationalRegional;
    }

    public String getSecurityAmount() {
        return securityAmount;
    }

    public void setSecurityAmount(String securityAmount) {
        this.securityAmount = securityAmount;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
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

    public String getFee_bdo() {
        return fee_bdo;
    }

    public void setFee_bdo(String fee_bdo) {
        this.fee_bdo = fee_bdo;
    }

    @Override
    public String toString() {
        return "SubCategoryItemsEntity{" +
                "itemId=" + itemId +
                ", category=" + category +
                ", subCategory=" + subCategory +
                ", itemName='" + itemName + '\'' +
                ", landType=" + landType +
                ", nationality=" + nationality +
                ", nationalRegional=" + nationalRegional +
                ", securityAmount='" + securityAmount + '\'' +
                ", fee='" + fee + '\'' +
                ", fee_bdo='" + fee_bdo + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}