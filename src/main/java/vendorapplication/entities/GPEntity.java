package vendorapplication.entities;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mst_gram_panchyat")
public class GPEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_gram_panchyat_panchayat_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_gram_panchyat_panchayat_id_seq", sequenceName = "public.mst_gram_panchyat_panchayat_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "panchayat_id")
    private Integer panchayatId;

    @Column(name = "panchayat_name")
    private String panchayatName;

    @Column(name = "pachayat_code")
    private Integer panchayatCode;


    @Column(name = "is_active")
    private Boolean active;

    @Column(name = "block_id")
    private Integer blockId;

    @Column(name = "is_deleted")
    private Boolean deleted;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Integer getPanchayatId() {
        return panchayatId;
    }

    public void setPanchayatId(Integer panchayatId) {
        this.panchayatId = panchayatId;
    }

    public String getPanchayatName() {
        return panchayatName;
    }

    public void setPanchayatName(String panchayatName) {
        this.panchayatName = panchayatName;
    }

    public Integer getPanchayatCode() {
        return panchayatCode;
    }

    public void setPanchayatCode(Integer panchayatCode) {
        this.panchayatCode = panchayatCode;
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
        return "GPEntity{" +
                "panchayatId=" + panchayatId +
                ", panchayatName='" + panchayatName + '\'' +
                ", panchayatCode=" + panchayatCode +
                ", active=" + active +
                ", blockId=" + blockId +
                ", deleted=" + deleted +
                ", createdDate=" + createdDate +
                '}';
    }
}