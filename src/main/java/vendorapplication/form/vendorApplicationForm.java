package vendorapplication.form;

import org.springframework.web.multipart.MultipartFile;
import vendorapplication.modal.ItemList;

import java.io.Serializable;
import java.util.List;

public class vendorApplicationForm implements Serializable {


    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String passwordConfirm;
    private String mobileNumber;
    private String age;
    private String p_address;
    private String c_address;
    private String emailAddress;
    private String gender;
    private String roleId;
    private String captcha;
    private String nationality;
    private String vendor;
    private String vendorType;
    private String tentNumber;
    private String district;
    private List<Integer> locationAvailable;
    private MultipartFile identityDoc;
    private MultipartFile photoDoc;
    private String comments;

    private String state;
    private String localBlock;
    private String localDistrict;
    private String localTehsil;
    private String localgp;
    private String totalDays;

    private String vstate;
    private String vlocalDistrict;
    private String vlocalBlock;
    private String vlocalTehsil;
    private String vlocalgp;

    private String landType;
    private String regional_national;
    private String fromDate;
    private String toDate;
    private String tentCapacity;

    private String item;

    public String getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(String totalDays) {
        this.totalDays = totalDays;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getRegional_national() {
        return regional_national;
    }

    public void setRegional_national(String regional_national) {
        this.regional_national = regional_national;
    }

    private String loc_address;

    private  List<ItemList> itemsForm;

    public List<ItemList> getItemsForm() {
        return itemsForm;
    }

    public void setItemsForm(List<ItemList> itemsForm) {
        this.itemsForm = itemsForm;
    }

    public String getLoc_address() {
        return loc_address;
    }

    public void setLoc_address(String loc_address) {
        this.loc_address = loc_address;
    }

    public String getVlocalTehsil() {
        return vlocalTehsil;
    }

    public void setVlocalTehsil(String vlocalTehsil) {
        this.vlocalTehsil = vlocalTehsil;
    }

    public MultipartFile getPhotoDoc() {
        return photoDoc;
    }

    public void setPhotoDoc(MultipartFile photoDoc) {
        this.photoDoc = photoDoc;
    }

    public String getVstate() {
        return vstate;
    }

    public void setVstate(String vstate) {
        this.vstate = vstate;
    }

    public String getVlocalDistrict() {
        return vlocalDistrict;
    }

    public void setVlocalDistrict(String vlocalDistrict) {
        this.vlocalDistrict = vlocalDistrict;
    }

    public String getVlocalBlock() {
        return vlocalBlock;
    }

    public void setVlocalBlock(String vlocalBlock) {
        this.vlocalBlock = vlocalBlock;
    }

    public String getVlocalgp() {
        return vlocalgp;
    }

    public void setVlocalgp(String vlocalgp) {
        this.vlocalgp = vlocalgp;
    }

    public String getTentCapacity() {
        return tentCapacity;
    }

    public void setTentCapacity(String tentCapacity) {
        this.tentCapacity = tentCapacity;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getLandType() {
        return landType;
    }

    public void setLandType(String landType) {
        this.landType = landType;
    }

    public String getLocalTehsil() {
        return localTehsil;
    }

    public void setLocalTehsil(String localTehsil) {
        this.localTehsil = localTehsil;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocalBlock() {
        return localBlock;
    }

    public void setLocalBlock(String localBlock) {
        this.localBlock = localBlock;
    }

    public String getLocalDistrict() {
        return localDistrict;
    }

    public void setLocalDistrict(String localDistrict) {
        this.localDistrict = localDistrict;
    }

    public String getLocalgp() {
        return localgp;
    }

    public void setLocalgp(String localgp) {
        this.localgp = localgp;
    }

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

    public String getP_address() {
        return p_address;
    }

    public void setP_address(String p_address) {
        this.p_address = p_address;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendorType() {
        return vendorType;
    }

    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }

    public String getTentNumber() {
        return tentNumber;
    }

    public void setTentNumber(String tentNumber) {
        this.tentNumber = tentNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<Integer> getLocationAvailable() {
        return locationAvailable;
    }

    public void setLocationAvailable(List<Integer> locationAvailable) {
        this.locationAvailable = locationAvailable;
    }

    public MultipartFile getIdentityDoc() {
        return identityDoc;
    }

    public void setIdentityDoc(MultipartFile identityDoc) {
        this.identityDoc = identityDoc;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "vendorApplicationForm{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", age='" + age + '\'' +
                ", p_address='" + p_address + '\'' +
                ", c_address='" + c_address + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", gender='" + gender + '\'' +
                ", roleId='" + roleId + '\'' +
                ", captcha='" + captcha + '\'' +
                ", nationality='" + nationality + '\'' +
                ", vendor='" + vendor + '\'' +
                ", vendorType='" + vendorType + '\'' +
                ", tentNumber='" + tentNumber + '\'' +
                ", district='" + district + '\'' +
                ", locationAvailable=" + locationAvailable +
                ", identityDoc=" + identityDoc +
                ", photoDoc=" + photoDoc +
                ", comments='" + comments + '\'' +
                ", state='" + state + '\'' +
                ", localBlock='" + localBlock + '\'' +
                ", localDistrict='" + localDistrict + '\'' +
                ", localTehsil='" + localTehsil + '\'' +
                ", localgp='" + localgp + '\'' +
                ", totalDays='" + totalDays + '\'' +
                ", vstate='" + vstate + '\'' +
                ", vlocalDistrict='" + vlocalDistrict + '\'' +
                ", vlocalBlock='" + vlocalBlock + '\'' +
                ", vlocalTehsil='" + vlocalTehsil + '\'' +
                ", vlocalgp='" + vlocalgp + '\'' +
                ", landType='" + landType + '\'' +
                ", regional_national='" + regional_national + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", tentCapacity='" + tentCapacity + '\'' +
                ", item='" + item + '\'' +
                ", loc_address='" + loc_address + '\'' +
                ", itemsForm=" + itemsForm +
                '}';
    }
}
