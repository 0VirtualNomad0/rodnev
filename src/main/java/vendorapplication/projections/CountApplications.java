package vendorapplication.projections;

import java.io.Serializable;

public class CountApplications  implements Serializable {

    private Integer count ;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CountApplications{" +
                "count=" + count +
                '}';
    }
}
