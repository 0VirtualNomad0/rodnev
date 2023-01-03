package vendorapplication.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "family_members")
public class FamilyMembersEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "family_members_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "family_members_id_seq", sequenceName = "public.family_members_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "family_member_id")
    private long familyMemberId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne()
    @JoinColumn(name = "gender_id")
    private GenderEntity genderId;

    @OneToOne()
    @JoinColumn(name = "qualification_id")
    private QualificationEntity qualificationId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="survey_user_id")
    private SurveyUserEntity surveyUserId;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public long getFamilyMemberId() {
        return familyMemberId;
    }

    public void setFamilyMemberId(long familyMemberId) {
        this.familyMemberId = familyMemberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GenderEntity getGenderId() {
        return genderId;
    }

    public void setGenderId(GenderEntity genderId) {
        this.genderId = genderId;
    }

    public QualificationEntity getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(QualificationEntity qualificationId) {
        this.qualificationId = qualificationId;
    }

    public SurveyUserEntity getSurveyUserId() {
        return surveyUserId;
    }

    public void setSurveyUserId(SurveyUserEntity surveyUserId) {
        this.surveyUserId = surveyUserId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "FamilyMembersEntity{" +
                "familyMemberId=" + familyMemberId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", genderId=" + genderId +
                ", qualificationId=" + qualificationId +
                ", createdDate=" + createdDate +
                '}';
    }
}
