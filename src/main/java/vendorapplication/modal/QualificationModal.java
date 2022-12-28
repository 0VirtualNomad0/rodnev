package vendorapplication.modal;

import java.io.Serializable;

public class QualificationModal implements Serializable {

    private Integer qualificationId;
    private String qualificationName;

    public QualificationModal(Integer qualificationId, String qualificationName) {
        this.qualificationId = qualificationId;
        this.qualificationName = qualificationName;
    }

    public Integer getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Integer qualificationId) {
        this.qualificationId = qualificationId;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    @Override
    public String toString() {
        return "QualificationModal{" +
                "qualificationId=" + qualificationId +
                ", qualificationName='" + qualificationName + '\'' +
                '}';
    }
}
