package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="gender")
public class GenderEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "gender_gender_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "gender_gender_id_seq", sequenceName = "public.gender_gender_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "gender_id")
    private Integer genderId;

    @Column(name = "gender_name")
    private String genderName;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Boolean getActive() {
        return active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }


    @Override
    public String toString() {
        return "GenderEntity{" +
                "genderId=" + genderId +
                ", genderName='" + genderName + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}