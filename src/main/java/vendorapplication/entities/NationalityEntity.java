package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mst_nationality")
public class NationalityEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_nationality_nationality_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_nationality_nationality_id_seq", sequenceName = "public.mst_nationality_nationality_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "nationality_id")
    private Integer nationalityId;

    @Column(name = "nationality_name")
    private String nationalityName;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Integer getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
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
        return "NationalityEntity{" +
                "nationalityId=" + nationalityId +
                ", nationalityName='" + nationalityName + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}