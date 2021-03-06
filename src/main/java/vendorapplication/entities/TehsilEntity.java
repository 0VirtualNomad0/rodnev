package vendorapplication.entities;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mst_tehsil")
public class TehsilEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_tehsil_tehsil_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_tehsil_tehsil_id_seq", sequenceName = "public.mst_tehsil_tehsil_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "tehsil_id")
    private Integer districtId;

    @Column(name = "tehsil_name")
    private String districtName;

//    @Column(name = "sub_division_id")
//    private Integer subDivision;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="district_id", updatable = false )
//    @LazyToOne(LazyToOneOption.NO_PROXY)
//    private DistrictEntity district;
//
//    @Column(name = "is_active")
//    private Boolean active;
//
//
//    @Column(name = "is_deleted")
//    private Boolean deleted;
//
//    @Column(name = "created_on")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

//    public Integer getSubDivision() {
//        return subDivision;
//    }
//
//    public void setSubDivision(Integer subDivision) {
//        this.subDivision = subDivision;
//    }
//
//    public DistrictEntity getDistrict() {
//        return district;
//    }
//
//    public void setDistrict(DistrictEntity district) {
//        this.district = district;
//    }
//
//    public Boolean getActive() {
//        return active;
//    }
//
//    public void setActive(Boolean active) {
//        this.active = active;
//    }
//
//    public Boolean getDeleted() {
//        return deleted;
//    }
//
//    public void setDeleted(Boolean deleted) {
//        this.deleted = deleted;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }

    @Override
    public String toString() {
        return "TehsilEntity{" +
                "districtId=" + districtId +
                ", districtName='" + districtName + '\'' +
//                ", subDivision=" + subDivision +
//                ", district=" + district +
//                ", active=" + active +
//                ", deleted=" + deleted +
//                ", createdDate=" + createdDate +
                '}';
    }
}