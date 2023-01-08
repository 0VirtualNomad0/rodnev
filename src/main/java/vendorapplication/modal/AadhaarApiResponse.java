package vendorapplication.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AadhaarApiResponse {
    @JsonProperty("STATUS")
    private int status;

    @JsonProperty("records")
    private List<AadhaarData> records;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<AadhaarData> getRecords() {
        return records;
    }

    public void setRecords(List<AadhaarData> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "AadhaarApiResponse{" +
                "status=" + status +
                ", records=" + records +
                '}';
    }
}
