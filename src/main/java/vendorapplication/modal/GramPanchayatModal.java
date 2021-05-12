package vendorapplication.modal;

import java.io.Serializable;

public class GramPanchayatModal implements Serializable {

    private Integer gpId;
    private String gpName;

    public GramPanchayatModal(Integer gpId, String gpName) {
        this.gpId = gpId;
        this.gpName = gpName;
    }

    public Integer getGpId() {
        return gpId;
    }

    public void setGpId(Integer gpId) {
        this.gpId = gpId;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    @Override
    public String toString() {
        return "GramPanchayatModal{" +
                "gpId=" + gpId +
                ", gpName='" + gpName + '\'' +
                '}';
    }
}
