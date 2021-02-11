package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mst_areaavailable")
public class AvailableAreaEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_areaavailable_area_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_areaavailable_area_id_seq", sequenceName = "public.mst_areaavailable_area_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "area_id")
    private Integer areaId;

    @OneToOne
    @JoinColumn(name="district_id" )
    private DistrictEntity districtId;

    @Column(name = "area_name")
    private String areaName;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public DistrictEntity getDistrictId() {
        return districtId;
    }

    public void setDistrictId(DistrictEntity districtId) {
        this.districtId = districtId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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
        return "AvailableAreaEntity{" +
                "areaId=" + areaId +
                ", districtId=" + districtId +
                ", areaName='" + areaName + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}