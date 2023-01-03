package vendorapplication.form;

import org.springframework.web.multipart.MultipartFile;
import vendorapplication.modal.CropDetails;
import vendorapplication.modal.FamilyMemberList;

import java.io.Serializable;
import java.util.List;

public class vendorAgriApplicationForm implements Serializable {


    /**
     * Commmon Details
     */

    private String aadhaarNumber;  //new
    private String firstname;
    private String lastname;
    private String gender;
    private String mobileNumber;
    private String age;
    private String category; //new
    private String familyHead; //New
    private String educationalQualification; //new
    private String state;
    private String localBlock;
    private String localDistrict;
    private String localgp;
    private String villageName; //New
    private String p_address;
    private  List<FamilyMemberList> itemsForm;
    private String totalLand; //new
    private String cultivatedLand; //new
    private String irrigatedLand; //new
    private String nonIrrigatedLand; //new
    private List<CropDetails> cropdetailsForm;
    private String presentIncome;
    private String marketableSystem;
    private String infrareq;
    private String pmkisanbenifit;
    private String naturalFarming;
    private String fullPartial;
    private String trainingAgri;


    public String getPresentIncome() {
        return presentIncome;
    }

    public void setPresentIncome(String presentIncome) {
        this.presentIncome = presentIncome;
    }

    public String getMarketableSystem() {
        return marketableSystem;
    }

    public void setMarketableSystem(String marketableSystem) {
        this.marketableSystem = marketableSystem;
    }

    public String getInfrareq() {
        return infrareq;
    }

    public void setInfrareq(String infrareq) {
        this.infrareq = infrareq;
    }

    public String getTrainingAgri() {
        return trainingAgri;
    }

    public void setTrainingAgri(String trainingAgri) {
        this.trainingAgri = trainingAgri;
    }

    public String getFullPartial() {
        return fullPartial;
    }

    public void setFullPartial(String fullPartial) {
        this.fullPartial = fullPartial;
    }

    public String getNaturalFarming() {
        return naturalFarming;
    }

    public void setNaturalFarming(String naturalFarming) {
        this.naturalFarming = naturalFarming;
    }

    public String getPmkisanbenifit() {
        return pmkisanbenifit;
    }

    public void setPmkisanbenifit(String pmkisanbenifit) {
        this.pmkisanbenifit = pmkisanbenifit;
    }

    public List<CropDetails> getCropdetailsForm() {
        return cropdetailsForm;
    }

    public void setCropdetailsForm(List<CropDetails> cropdetailsForm) {
        this.cropdetailsForm = cropdetailsForm;
    }

    public String getTotalLand() {
        return totalLand;
    }

    public void setTotalLand(String totalLand) {
        this.totalLand = totalLand;
    }

    public String getCultivatedLand() {
        return cultivatedLand;
    }

    public void setCultivatedLand(String cultivatedLand) {
        this.cultivatedLand = cultivatedLand;
    }

    public String getIrrigatedLand() {
        return irrigatedLand;
    }

    public void setIrrigatedLand(String irrigatedLand) {
        this.irrigatedLand = irrigatedLand;
    }

    public String getNonIrrigatedLand() {
        return nonIrrigatedLand;
    }

    public void setNonIrrigatedLand(String nonIrrigatedLand) {
        this.nonIrrigatedLand = nonIrrigatedLand;
    }

    public String getFamilyHead() {
        return familyHead;
    }

    public void setFamilyHead(String familyHead) {
        this.familyHead = familyHead;
    }

    public String getEducationalQualification() {
        return educationalQualification;
    }

    public void setEducationalQualification(String educationalQualification) {
        this.educationalQualification = educationalQualification;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
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

    public String getP_address() {
        return p_address;
    }

    public void setP_address(String p_address) {
        this.p_address = p_address;
    }

    public List<FamilyMemberList> getItemsForm() {
        return itemsForm;
    }

    public void setItemsForm(List<FamilyMemberList> itemsForm) {
        this.itemsForm = itemsForm;
    }

    @Override
    public String toString() {
        return "vendorApplicationForm{" +
                "aadhaarNumber='" + aadhaarNumber + '\'' +
                ", villageName='" + villageName + '\'' +
                ", category='" + category + '\'' +
                ", familyHead='" + familyHead + '\'' +
                ", educationalQualification='" + educationalQualification + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", age='" + age + '\'' +
                ", state='" + state + '\'' +
                ", localBlock='" + localBlock + '\'' +
                ", localDistrict='" + localDistrict + '\'' +
                ", localgp='" + localgp + '\'' +
                ", p_address='" + p_address + '\'' +
                ", itemsForm=" + itemsForm +
                '}';
    }
}
