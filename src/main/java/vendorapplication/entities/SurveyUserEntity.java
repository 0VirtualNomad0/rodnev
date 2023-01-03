package vendorapplication.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "survey_users")
public class SurveyUserEntity implements Serializable {

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "surveyUserId")
    private Set<FamilyMembersEntity> familyMembers = new HashSet<FamilyMembersEntity>();

    @Id
    @GeneratedValue(generator = "survey_users_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "survey_users_id_seq", sequenceName = "public.survey_users_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "survey_user_id")
    private long surveyUserId;

    @Column(name = "aadhaar_number", precision = 12, unique = true)
    private long aadhaarNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne()
    @JoinColumn(name = "gender_id")
    private GenderEntity genderId;

    @Column(name = "mobile_number", precision = 10)
    private long mobileNumber;

    @Column(name = "age")
    private int age;

    @OneToOne()
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryId;

    @Column(name = "family_head_name")
    private String familyHeadName;

    @OneToOne()
    @JoinColumn(name = "qualification_id")
    private QualificationEntity qualificationId;

    @OneToOne()
    @JoinColumn(name = "state_id")
    private StateEntity stateId;

    @OneToOne()
    @JoinColumn(name = "district_id")
    private DistrictEntity districtId;

    @OneToOne()
    @JoinColumn(name = "block_id")
    private BlocksEntity blockId;

    @OneToOne()
    @JoinColumn(name = "panchayat_id")
    private GPEntity panchayatId;

    @Column(name = "village_name")
    private String villageName;

    @Column(name = "permanent_address", length = 700)
    private String permanentAddress;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "surveyUserId")
    private SurveyAnimalHusbandryEntity surveyAnimalHusbandryId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "surveyUserId")
    private SurveyAgricultureEntity surveyAgricultureId;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public long getSurveyUserId() {
        return surveyUserId;
    }

    public void setSurveyUserId(long surveyUserId) {
        this.surveyUserId = surveyUserId;
    }

    public long getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(long aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GenderEntity getGenderId() {
        return genderId;
    }

    public void setGenderId(GenderEntity genderId) {
        this.genderId = genderId;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CategoryEntity getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryEntity categoryId) {
        this.categoryId = categoryId;
    }

    public String getFamilyHeadName() {
        return familyHeadName;
    }

    public void setFamilyHeadName(String familyHeadName) {
        this.familyHeadName = familyHeadName;
    }

    public QualificationEntity getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(QualificationEntity qualificationId) {
        this.qualificationId = qualificationId;
    }

    public StateEntity getStateId() {
        return stateId;
    }

    public void setStateId(StateEntity stateId) {
        this.stateId = stateId;
    }

    public DistrictEntity getDistrictId() {
        return districtId;
    }

    public void setDistrictId(DistrictEntity districtId) {
        this.districtId = districtId;
    }

    public BlocksEntity getBlockId() {
        return blockId;
    }

    public void setBlockId(BlocksEntity blockId) {
        this.blockId = blockId;
    }

    public GPEntity getPanchayatId() {
        return panchayatId;
    }

    public void setPanchayatId(GPEntity panchayatId) {
        this.panchayatId = panchayatId;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Set<FamilyMembersEntity> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Set<FamilyMembersEntity> familyMembers) {
        if (this.familyMembers == null) {
            this.familyMembers = familyMembers;
        } else {
            this.familyMembers.retainAll(familyMembers);
            this.familyMembers.addAll(familyMembers);
        }
    }

    public SurveyAnimalHusbandryEntity getSurveyAnimalHusbandryId() {
        return surveyAnimalHusbandryId;
    }

    public void setSurveyAnimalHusbandryId(SurveyAnimalHusbandryEntity surveyAnimalHusbandryId) {
        this.surveyAnimalHusbandryId = surveyAnimalHusbandryId;
    }

    public SurveyAgricultureEntity getSurveyAgricultureId() {
        return surveyAgricultureId;
    }

    public void setSurveyAgricultureId(SurveyAgricultureEntity surveyAgricultureId) {
        this.surveyAgricultureId = surveyAgricultureId;
    }

    @Override
    public String toString() {
        return "SurveyUserEntity{" +
                "surveyUserId=" + surveyUserId +
                ", aadhaarNumber=" + aadhaarNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", genderId=" + genderId +
                ", mobileNumber=" + mobileNumber +
                ", age=" + age +
                ", categoryId=" + categoryId +
                ", familyHeadName='" + familyHeadName + '\'' +
                ", qualificationId=" + qualificationId +
                ", stateId=" + stateId +
                ", districtId=" + districtId +
                ", blockId=" + blockId +
                ", panchayatId=" + panchayatId +
                ", villageName='" + villageName + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", familyMembers=" + familyMembers +
                ", surveyAnimalHusbandryId=" + surveyAnimalHusbandryId +
                ", surveyAgricultureId=" + surveyAgricultureId +
                ", createdDate=" + createdDate +
                '}';
    }
}
