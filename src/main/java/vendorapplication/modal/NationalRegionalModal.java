package vendorapplication.modal;

import java.io.Serializable;

public class NationalRegionalModal implements Serializable {

    private Integer nationalRegionalId;
    private String nationalRegionalName;

    public NationalRegionalModal(Integer nationalRegionalId, String nationalRegionalName) {
        this.nationalRegionalId = nationalRegionalId;
        this.nationalRegionalName = nationalRegionalName;
    }

    public Integer getNationalRegionalId() {
        return nationalRegionalId;
    }

    public void setNationalRegionalId(Integer nationalRegionalId) {
        this.nationalRegionalId = nationalRegionalId;
    }

    public String getNationalRegionalName() {
        return nationalRegionalName;
    }

    public void setNationalRegionalName(String nationalRegionalName) {
        this.nationalRegionalName = nationalRegionalName;
    }

    @Override
    public String toString() {
        return "NationalRegionalModal{" +
                "nationalRegionalId=" + nationalRegionalId +
                ", nationalRegionalName='" + nationalRegionalName + '\'' +
                '}';
    }
}
