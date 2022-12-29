package vendorapplication.modal;

import java.io.Serializable;

public class CropTypeModal implements Serializable {

    private Integer cropTypeId;
    private String cropTypeName;

    public CropTypeModal(Integer cropTypeId, String cropTypeName) {
        this.cropTypeId = cropTypeId;
        this.cropTypeName = cropTypeName;
    }

    public Integer getCropTypeId() {
        return cropTypeId;
    }

    public void setCropTypeId(Integer cropTypeId) {
        this.cropTypeId = cropTypeId;
    }

    public String getCropTypeName() {
        return cropTypeName;
    }

    public void setCropTypeName(String cropTypeName) {
        this.cropTypeName = cropTypeName;
    }

    @Override
    public String toString() {
        return "CropTypeModal{" +
                "cropTypeId=" + cropTypeId +
                ", cropTypeName='" + cropTypeName + '\'' +
                '}';
    }
}
