package vendorapplication.entities;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mst_block")
public class BlocksEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_block_block_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_block_block_id_seq", sequenceName = "public.mst_block_block_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "block_id")
    private Integer districtId;

    @Column(name = "block_name")
    private String districtName;

//    @Column(name = "block_code")
//    private Integer blockCode;
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

    @Override
    public String toString() {
        return "BlocksEntity{" +
                "districtId=" + districtId +
                ", districtName='" + districtName + '\'' +
                '}';
    }
}