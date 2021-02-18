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

    @Column(name = "block_code")
    private Integer blockCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="district_id", updatable = false )
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private DistrictEntity district;

    @Column(name = "is_active")
    private Boolean active;


    @Column(name = "is_deleted")
    private Boolean deleted;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

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

    public Integer getBlockCode() {
        return blockCode;
    }

    public void setBlockCode(Integer blockCode) {
        this.blockCode = blockCode;
    }

    public DistrictEntity getDistrict() {
        return district;
    }

    public void setDistrict(DistrictEntity district) {
        this.district = district;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "BlocksEntity{" +
                "districtId=" + districtId +
                ", districtName='" + districtName + '\'' +
                ", blockCode=" + blockCode +
                ", district=" + district +
                ", active=" + active +
                ", deleted=" + deleted +
                ", createdDate=" + createdDate +
                '}';
    }
}