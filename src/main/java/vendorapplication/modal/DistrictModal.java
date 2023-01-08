package vendorapplication.modal;

import java.io.Serializable;

public class DistrictModal implements Serializable {

    private Integer districtId;
    private String districtName;

    public DistrictModal(Integer districtId, String districtName) {
        this.districtId = districtId;
        this.districtName = districtName;
    }

    public DistrictModal() {
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Override
    public String toString() {
        return "DistrictModal{" +
                "districtId=" + districtId +
                ", districtName='" + districtName + '\'' +
                '}';
    }
}
