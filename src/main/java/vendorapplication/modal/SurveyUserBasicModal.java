package vendorapplication.modal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class SurveyUserBasicModal {

    private long surveyUserId;

    private long aadhaarNumber;

    private String firstName;

    private String lastName;

    private String gender;

    private long mobileNumber;

    private String permanentAddress;

    private int age;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
            String dateString = sdf.format(createdDate);
            calendar.setTime(sdf.parse(dateString));
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = calendar.getTime();
            this.createdDate = date;
        }catch (Exception ex){
            this.createdDate = new Date();
        }
    }

    @Override
    public String toString() {
        return "SurveyUserBasicModal{" +
                "surveyUserId=" + surveyUserId +
                ", aadhaarNumber=" + aadhaarNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", age=" + age +
                ", createdDate=" + createdDate +
                '}';
    }
}
