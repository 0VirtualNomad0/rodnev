package vendorapplication.modal;

import java.io.Serializable;

public class ItemList implements Serializable {

    private String item;
    private String item_number;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem_number() {
        return item_number;
    }

    public void setItem_number(String item_number) {
        this.item_number = item_number;
    }

    @Override
    public String toString() {
        return "ItemList{" +
                "item='" + item + '\'' +
                ", item_number='" + item_number + '\'' +
                '}';
    }
}
