package vendorapplication.modal;

import java.io.Serializable;

public class Items implements Serializable {

    private Integer itemId;
    private String itemName;
    private String rate;
    private String securityamount;

    public String getSecurityamount() {
        return securityamount;
    }

    public void setSecurityamount(String securityamount) {
        this.securityamount = securityamount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", rate='" + rate + '\'' +
                ", securityamount='" + securityamount + '\'' +
                '}';
    }
}
