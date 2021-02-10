package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mst_vendor")
public class VendorEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_vendor_ventype_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_vendor_ventype_id_seq", sequenceName = "public.mst_vendor_ventype_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "venType_id")
    private Integer venTypeID;

    @Column(name = "venType_name")
    private String venTypeName;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    public Integer getVenTypeID() {
        return venTypeID;
    }

    public void setVenTypeID(Integer venTypeID) {
        this.venTypeID = venTypeID;
    }

    public String getVenTypeName() {
        return venTypeName;
    }

    public void setVenTypeName(String venTypeName) {
        this.venTypeName = venTypeName;
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
        return "VendorEntity{" +
                "venTypeID=" + venTypeID +
                ", venTypeName='" + venTypeName + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}