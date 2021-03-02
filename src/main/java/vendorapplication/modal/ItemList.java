package vendorapplication.modal;

import java.io.Serializable;

public class ItemList implements Serializable {

    private String item;
    private String land_item;
    private String national_regional_item;
    private String item_fee;
    private String item_number;

    public String getItem_number() {
        return item_number;
    }

    public void setItem_number(String item_number) {
        this.item_number = item_number;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getLand_item() {
        return land_item;
    }

    public void setLand_item(String land_item) {
        this.land_item = land_item;
    }

    public String getNational_regional_item() {
        return national_regional_item;
    }

    public void setNational_regional_item(String national_regional_item) {
        this.national_regional_item = national_regional_item;
    }

    public String getItem_fee() {
        return item_fee;
    }

    public void setItem_fee(String item_fee) {
        this.item_fee = item_fee;
    }

    @Override
    public String toString() {
        return "ItemList{" +
                "item='" + item + '\'' +
                ", land_item='" + land_item + '\'' +
                ", national_regional_item='" + national_regional_item + '\'' +
                ", item_fee='" + item_fee + '\'' +
                ", item_number='" + item_number + '\'' +
                '}';
    }
}
