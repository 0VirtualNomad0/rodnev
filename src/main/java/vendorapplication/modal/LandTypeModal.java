package vendorapplication.modal;

import java.io.Serializable;

public class LandTypeModal implements Serializable {

    private Integer landTypeId;
    private String landTypeName;

    public LandTypeModal(Integer landTypeId, String landTypeName) {
        this.landTypeId = landTypeId;
        this.landTypeName = landTypeName;
    }

    public Integer getLandTypeId() {
        return landTypeId;
    }

    public void setLandTypeId(Integer landTypeId) {
        this.landTypeId = landTypeId;
    }

    public String getLandTypeName() {
        return landTypeName;
    }

    public void setLandTypeName(String landTypeName) {
        this.landTypeName = landTypeName;
    }

    @Override
    public String toString() {
        return "LandTypeModal{" +
                "landTypeId=" + landTypeId +
                ", landTypeName='" + landTypeName + '\'' +
                '}';
    }
}
