package vendorapplication.modal;

import java.util.Date;

public class SurveyUserBasicModal {

    private long surveyUserId;

    private long aadhaarNumber;

    private String firstName;

    private String lastName;

    private long mobileNumber;

    private String permanentAddress;

    private int age;

    private DistrictModal districtId;

    private BlockModal blockId;

    private GenderModal genderId;

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

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        try {
            this.createdDate = createdDate;
        } catch (Exception ex) {
            this.createdDate = new Date();
        }
    }

    public DistrictModal getDistrictId() {
        return districtId;
    }

    public void setDistrictId(DistrictModal districtId) {
        this.districtId = districtId;

    }

    public BlockModal getBlockId() {
        return blockId;
    }

    public void setBlockId(BlockModal blockId) {
        this.blockId = blockId;
    }

    public GenderModal getGenderId() {
        return genderId;
    }

    public void setGenderId(GenderModal genderId) {
        this.genderId = genderId;
    }

    @Override
    public String toString() {
        return "SurveyUserBasicModal{" +
                "surveyUserId=" + surveyUserId +
                ", aadhaarNumber=" + aadhaarNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", age=" + age +
                ", districtId=" + districtId +
                ", blockId=" + blockId +
                ", genderId=" + genderId +
                ", createdDate=" + createdDate +
                '}';
    }

}
