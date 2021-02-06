package vendorapplication.modal;

import java.io.Serializable;

public class GenderModal implements Serializable {

    private Integer genderId;
    private String genderName;

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
        return "GenderModal{" +
                "genderId=" + genderId +
                ", genderName='" + genderName + '\'' +
                '}';
    }
}
