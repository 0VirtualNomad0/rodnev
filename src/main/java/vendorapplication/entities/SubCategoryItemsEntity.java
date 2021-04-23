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

   // @OneToOne
    //@JoinColumn(name="category_id" )
    @Column(name="category_id")
    private Integer category;

   // @OneToOne
   // @JoinColumn(name="subcategory_id" )
   @Column(name="subcategory_id")
    private Integer subCategory;

    @Column(name = "items_name")
    private String itemName;

   // @OneToOne
    //@JoinColumn(name="landtype_id" )
   @Column(name="landtype_id")
    private Integer landType;

  //  @OneToOne
    //@JoinColumn(name="nationality_id" )
  @Column(name="nationality_id")
    private Integer nationality;

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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Integer subCategory) {
        this.subCategory = subCategory;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getLandType() {
        return landType;
    }

    public void setLandType(Integer landType) {
        this.landType = landType;
    }

    public Integer getNationality() {
        return nationality;
    }

    public void setNationality(Integer nationality) {
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

    public String getFee_bdo() {
        return fee_bdo;
    }

    public void setFee_bdo(String fee_bdo) {
        this.fee_bdo = fee_bdo;
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