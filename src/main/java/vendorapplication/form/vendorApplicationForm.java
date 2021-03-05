package vendorapplication.form;

import org.springframework.web.multipart.MultipartFile;
import vendorapplication.modal.ItemList;

import java.io.Serializable;
import java.util.List;

public class vendorApplicationForm implements Serializable {


    private String firstname;
    private String lastname;
    private String gender;
    private String mobileNumber;
    private String age;
    private String emailAddress;
    private String state;
    private String localBlock;
    private String localDistrict;
    private String localTehsil;
    private String localgp;
    private String p_address;
    private String vstate;
    private String vlocalDistrict;
    private String vlocalBlock;
    private String vlocalTehsil;
    private String vlocalgp;
    private String loc_address;
    private String fromDate;
    private String toDate;
    private String totalDays;
    private String nationality;
    private String vendor;
    private String vendorType;
    private String landType;
    private String regional_national;
    private String item;
    private  List<ItemList> itemsForm;
    private MultipartFile identityDoc;
    private MultipartFile photoDoc;
    private String captcha;
    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public String getVlocalTehsil() {
        return vlocalTehsil;
    }

    public void setVlocalTehsil(String vlocalTehsil) {
        this.vlocalTehsil = vlocalTehsil;
    }

    public String getVlocalgp() {
        return vlocalgp;
    }

    public void setVlocalgp(String vlocalgp) {
        this.vlocalgp = vlocalgp;
    }

    public String getLoc_address() {
        return loc_address;
    }

    public void setLoc_address(String loc_address) {
        this.loc_address = loc_address;
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

    public String getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(String totalDays) {
        this.totalDays = totalDays;
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

    public String getLandType() {
        return landType;
    }

    public void setLandType(String landType) {
        this.landType = landType;
    }

    public String getRegional_national() {
        return regional_national;
    }

    public void setRegional_national(String regional_national) {
        this.regional_national = regional_national;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public List<ItemList> getItemsForm() {
        return itemsForm;
    }

    public void setItemsForm(List<ItemList> itemsForm) {
        this.itemsForm = itemsForm;
    }

    public MultipartFile getIdentityDoc() {
        return identityDoc;
    }

    public void setIdentityDoc(MultipartFile identityDoc) {
        this.identityDoc = identityDoc;
    }

    public MultipartFile getPhotoDoc() {
        return photoDoc;
    }

    public void setPhotoDoc(MultipartFile photoDoc) {
        this.photoDoc = photoDoc;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    @Override
    public String toString() {
        return "vendorApplicationForm{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", age='" + age + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", state='" + state + '\'' +
                ", localBlock='" + localBlock + '\'' +
                ", localDistrict='" + localDistrict + '\'' +
                ", localTehsil='" + localTehsil + '\'' +
                ", localgp='" + localgp + '\'' +
                ", p_address='" + p_address + '\'' +
                ", vstate='" + vstate + '\'' +
                ", vlocalDistrict='" + vlocalDistrict + '\'' +
                ", vlocalBlock='" + vlocalBlock + '\'' +
                ", vlocalTehsil='" + vlocalTehsil + '\'' +
                ", vlocalgp='" + vlocalgp + '\'' +
                ", loc_address='" + loc_address + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", totalDays='" + totalDays + '\'' +
                ", nationality='" + nationality + '\'' +
                ", vendor='" + vendor + '\'' +
                ", vendorType='" + vendorType + '\'' +
                ", landType='" + landType + '\'' +
                ", regional_national='" + regional_national + '\'' +
                ", item='" + item + '\'' +
                ", itemsForm=" + itemsForm +
                ", identityDoc=" + identityDoc +
                ", photoDoc=" + photoDoc +
                ", captcha='" + captcha + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
