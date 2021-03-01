package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mst_subcategory")
public class SubCategoryEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_subcategory_subcategory_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_subcategory_subcategory_id_seq", sequenceName = "public.mst_subcategory_subcategory_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "subcategory_id")
    private Integer subCategoryId;


    @OneToOne
    @JoinColumn(name="category_id" )
    private CategoryEntity categoryId;

    @Column(name = "subcategory_name")
    private String subCategoryName;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public CategoryEntity getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryEntity categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
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
        return "SubCategoryEntity{" +
                "subCategoryId=" + subCategoryId +
                ", categoryId=" + categoryId +
                ", subCategoryName='" + subCategoryName + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}