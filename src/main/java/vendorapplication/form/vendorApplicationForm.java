package vendorapplication.form;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

public class vendorApplicationForm implements Serializable {


    private String nationality;
    private String vendor;
    private String vendorType;
    private String tentNumber;
    private String district;
    private List<Integer> locationAvailable;
    private MultipartFile identityDoc;
    private String comments;


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
                "nationality='" + nationality + '\'' +
                ", vendor='" + vendor + '\'' +
                ", vendorType='" + vendorType + '\'' +
                ", tentNumber='" + tentNumber + '\'' +
                ", district='" + district + '\'' +
                ", locationAvailable=" + locationAvailable +
                ", identityDoc=" + identityDoc +
                ", comments='" + comments + '\'' +
                '}';
    }
}
