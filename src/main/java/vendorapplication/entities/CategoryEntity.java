package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mst_category")
public class CategoryEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_category_category_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_category_category_id_seq", sequenceName = "public.mst_category_category_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "category_id")
    private Integer categoryID;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
        return "CategoryEntity{" +
                "categoryID=" + categoryID +
                ", categoryName='" + categoryName + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}