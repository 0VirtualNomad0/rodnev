package vendorapplication.modal;

import java.io.Serializable;

public class FutureCropDetails implements Serializable {

    private String cropType;
    private String cropName;
    private String cropArea;

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getCropArea() {
        return cropArea;
    }

    public void setCropArea(String cropArea) {
        this.cropArea = cropArea;
    }

    @Override
    public String toString() {
        return "CropDetails{" +
                "cropType='" + cropType + '\'' +
                ", cropName='" + cropName + '\'' +
                ", cropArea='" + cropArea + '\'' +
                '}';
    }
}
