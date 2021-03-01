package vendorapplication.form;

import java.io.Serializable;

public class SubCategoryForm implements Serializable {

    private Integer categoryId;
    private String subcategoryName;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    @Override
    public String toString() {
        return "SubCategoryForm{" +
                "categoryId=" + categoryId +
                ", subcategoryName='" + subcategoryName + '\'' +
                '}';
    }
}
