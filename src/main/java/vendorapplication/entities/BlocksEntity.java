package vendorapplication.entities;

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
    private Integer blockId;

    @Column(name = "block_name")
    private String blockName;

    @Column(name = "is_active")
    private Boolean active;

    @Column(name = "district_id")
    private Integer districtId;


    @Column(name = "is_deleted")
    private Boolean deleted;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
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
                "blockId=" + blockId +
                ", blockName='" + blockName + '\'' +
                ", active=" + active +
                ", districtId=" + districtId +
                ", deleted=" + deleted +
                ", createdDate=" + createdDate +
                '}';
    }
}