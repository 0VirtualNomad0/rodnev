package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="mst_landType")
public class LandTypeEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_landtype_landtype_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_landtype_landtype_id_seq", sequenceName = "public.mst_landtype_landtype_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "landtype_id")
    private Integer landTypeId;

    @Column(name = "landTye_name")
    private String landTypeName;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    public Integer getLandTypeId() {
        return landTypeId;
    }

    public void setLandTypeId(Integer landTypeId) {
        this.landTypeId = landTypeId;
    }

    public String getLandTypeName() {
        return landTypeName;
    }

    public void setLandTypeName(String landTypeName) {
        this.landTypeName = landTypeName;
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
        return "LandTypeEntity{" +
                "landTypeId=" + landTypeId +
                ", landTypeName='" + landTypeName + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}
