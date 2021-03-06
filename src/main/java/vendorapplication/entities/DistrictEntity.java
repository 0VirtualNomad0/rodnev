package vendorapplication.entities;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mst_district")
public class DistrictEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_district_district_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_district_district_id_seq", sequenceName = "public.mst_district_district_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "district_id")
    private Integer districtId;

    @Column(name = "district_name")
    private String districtName;

//    @Column(name = "is_active")
//    private Boolean active;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="state_id", updatable = false )
//    @LazyToOne(LazyToOneOption.NO_PROXY)
//    private StateEntity stateEntity;
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

    @Override
    public String toString() {
        return "DistrictEntity{" +
                "districtId=" + districtId +
                ", districtName='" + districtName + '\'' +
                '}';
    }
}