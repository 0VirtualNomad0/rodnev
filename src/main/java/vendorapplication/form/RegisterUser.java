package vendorapplication.form;

import java.io.Serializable;

public class RegisterUser implements Serializable {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String passwordConfirm;
    private String mobileNumber;
    private String age;
    private String state;
    private String localDistrict;
    private String localBlock;
    private String localTehsil;
    private String localgp;
    private String p_address;
    private String emailAddress;
    private String gender;
    private String roleId;
    private String captcha;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocalDistrict() {
        return localDistrict;
    }

    public void setLocalDistrict(String localDistrict) {
        this.localDistrict = localDistrict;
    }

    public String getLocalBlock() {
        return localBlock;
    }

    public void setLocalBlock(String localBlock) {
        this.localBlock = localBlock;
    }

    public String getLocalTehsil() {
        return localTehsil;
    }

    public void setLocalTehsil(String localTehsil) {
        this.localTehsil = localTehsil;
    }

    public String getLocalgp() {
        return localgp;
    }

    public void setLocalgp(String localgp) {
        this.localgp = localgp;
    }

    public String getP_address() {
        return p_address;
    }

    public void setP_address(String p_address) {
        this.p_address = p_address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    @Override
    public String toString() {
        return "RegisterUser{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", age='" + age + '\'' +
                ", state='" + state + '\'' +
                ", localDistrict='" + localDistrict + '\'' +
                ", localBlock='" + localBlock + '\'' +
                ", localTehsil='" + localTehsil + '\'' +
                ", localgp='" + localgp + '\'' +
                ", p_address='" + p_address + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", gender='" + gender + '\'' +
                ", roleId='" + roleId + '\'' +
                ", captcha='" + captcha + '\'' +
                '}';
    }
}
