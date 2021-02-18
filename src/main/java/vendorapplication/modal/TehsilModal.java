package vendorapplication.modal;

import java.io.Serializable;

public class TehsilModal implements Serializable {

    private Integer tehsilId;
    private String tehsilName;

    public Integer getTehsilId() {
        return tehsilId;
    }

    public void setTehsilId(Integer tehsilId) {
        this.tehsilId = tehsilId;
    }

    public String getTehsilName() {
        return tehsilName;
    }

    public void setTehsilName(String tehsilName) {
        this.tehsilName = tehsilName;
    }

    @Override
    public String toString() {
        return "TehsilModal{" +
                "tehsilId=" + tehsilId +
                ", tehsilName='" + tehsilName + '\'' +
                '}';
    }
}
