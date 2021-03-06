package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="userapplication_items")
public class UserAppItemsEntity implements Serializable {


    @Id
    @GeneratedValue(generator = "userapplication_items_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "userapplication_items_id_seq", sequenceName = "public.userapplication_items_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
    private Integer itemId;

    @Column(name = "app_id",updatable = false)
    private Integer appId;

    @OneToOne
    @JoinColumn(name="items_id" ,updatable = false)
    private SubCategoryItemsEntity item;

    @Column(name = "tent_number",updatable = false)
    private Integer tentNumber;


    @Column(name = "active")
    private Boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public SubCategoryItemsEntity getItem() {
        return item;
    }

    public void setItem(SubCategoryItemsEntity item) {
        this.item = item;
    }

    public Integer getTentNumber() {
        return tentNumber;
    }

    public void setTentNumber(Integer tentNumber) {
        this.tentNumber = tentNumber;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    @Override
    public String toString() {
        return "UserAppItemsEntity{" +
                "itemId=" + itemId +
                ", appId=" + appId +
                ", item=" + item +
                ", tentNumber=" + tentNumber +
                ", active=" + active +
                ", createddate=" + createddate +
                '}';
    }
}
