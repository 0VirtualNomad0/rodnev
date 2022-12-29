package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mst_croptype")
public class CropTypeEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_croptype_croptype_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_croptype_croptype_id_seq", sequenceName = "public.mst_croptype_croptype_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "croptype_id")
    private Integer cropTypeId;

    @Column(name = "croptype_name")
    private String cropTypeName;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Integer getCropTypeId() {
        return cropTypeId;
    }

    public void setCropTypeId(Integer cropTypeId) {
        this.cropTypeId = cropTypeId;
    }

    public String getCropTypeName() {
        return cropTypeName;
    }

    public void setCropTypeName(String cropTypeName) {
        this.cropTypeName = cropTypeName;
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
        return "CropTypeEntity{" +
                "cropTypeId=" + cropTypeId +
                ", cropTypeName='" + cropTypeName + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}
