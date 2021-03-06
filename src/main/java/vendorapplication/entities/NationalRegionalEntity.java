package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="mst_nationalRegional")
public class NationalRegionalEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_nationalregional_nationalregional_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_nationalregional_nationalregional_id_seq", sequenceName = "public.mst_nationalregional_nationalregional_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "nationalRegional_id")
    private Integer nationalRegionalId;

    @Column(name = "nationalRegional_name")
    private String nationalRegionalName;

//    @Column(name = "active")
//    private Boolean active;
//
//    @Column(name = "createddate")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;

    public Integer getNationalRegionalId() {
        return nationalRegionalId;
    }

    public void setNationalRegionalId(Integer nationalRegionalId) {
        this.nationalRegionalId = nationalRegionalId;
    }

    public String getNationalRegionalName() {
        return nationalRegionalName;
    }

    public void setNationalRegionalName(String nationalRegionalName) {
        this.nationalRegionalName = nationalRegionalName;
    }

//    public Boolean getActive() {
//        return active;
//    }
//
//    public void setActive(Boolean active) {
//        this.active = active;
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
        return "NationalRegionalEntity{" +
                "nationalRegionalId=" + nationalRegionalId +
                ", nationalRegionalName='" + nationalRegionalName + '\'' +
//                ", active=" + active +
//                ", createdDate=" + createdDate +
                '}';
    }
}
