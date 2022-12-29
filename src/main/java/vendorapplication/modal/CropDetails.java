package vendorapplication.modal;

import java.io.Serializable;

public class CropDetails implements Serializable {

    private String cropType;
    private String cropName;
    private String cropArea;
    private String cropProduction;
    private String cropMarketing;

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

    public String getCropProduction() {
        return cropProduction;
    }

    public void setCropProduction(String cropProduction) {
        this.cropProduction = cropProduction;
    }

    public String getCropMarketing() {
        return cropMarketing;
    }

    public void setCropMarketing(String cropMarketing) {
        this.cropMarketing = cropMarketing;
    }

    @Override
    public String toString() {
        return "CropDetails{" +
                "cropType='" + cropType + '\'' +
                ", cropName='" + cropName + '\'' +
                ", cropArea='" + cropArea + '\'' +
                ", cropProduction='" + cropProduction + '\'' +
                ", cropMarketing='" + cropMarketing + '\'' +
                '}';
    }
}
