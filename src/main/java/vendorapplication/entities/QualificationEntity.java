package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mst_qualification")
public class QualificationEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_qualification_qualification_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_qualification_qualification_id_seq", sequenceName = "public.mst_qualification_qualification_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "qualification_id")
    private Integer qualificationId;

    @Column(name = "qualification_name")
    private String qualificationName;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    public Integer getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Integer qualificationId) {
        this.qualificationId = qualificationId;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
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
        return "QualificationEntity{" +
                "qualificationId=" + qualificationId +
                ", qualificationName='" + qualificationName + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}
