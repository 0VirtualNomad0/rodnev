package vendorapplication.projections;

import java.io.Serializable;
import java.sql.Date;

public class CheckStatusProjection implements Serializable {

    private Date applicationCreatedDate;


    public Date getApplicationCreatedDate() {
        return applicationCreatedDate;
    }

    public void setApplicationCreatedDate(Date applicationCreatedDate) {
        this.applicationCreatedDate = applicationCreatedDate;
    }

    @Override
    public String toString() {
        return "CheckStatusProjection{" +
                "applicationCreatedDate=" + applicationCreatedDate +
                '}';
    }
}
