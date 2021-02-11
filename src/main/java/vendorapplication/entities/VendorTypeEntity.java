package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mst_vendortype")
public class VendorTypeEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_vendortype_vendortype_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_vendortype_vendortype_id_seq", sequenceName = "public.mst_vendortype_vendortype_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "vendortype_id")
    private Integer vendorTypeId;


    @OneToOne
    @JoinColumn(name="ventype_id" )
    private VendorEntity venTypeId;

    @Column(name = "vendortype_name")
    private String vendorTypeName;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Integer getVendorTypeId() {
        return vendorTypeId;
    }

    public void setVendorTypeId(Integer vendorTypeId) {
        this.vendorTypeId = vendorTypeId;
    }

    public VendorEntity getVenTypeId() {
        return venTypeId;
    }

    public void setVenTypeId(VendorEntity venTypeId) {
        this.venTypeId = venTypeId;
    }

    public String getVendorTypeName() {
        return vendorTypeName;
    }

    public void setVendorTypeName(String vendorTypeName) {
        this.vendorTypeName = vendorTypeName;
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
        return "VendorTypeEntity{" +
                "vendorTypeId=" + vendorTypeId +
                ", venTypeId=" + venTypeId +
                ", vendorTypeName='" + vendorTypeName + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}