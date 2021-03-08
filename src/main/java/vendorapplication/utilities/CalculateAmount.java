package vendorapplication.utilities;

import vendorapplication.entities.UserApplicationEntity;

public class CalculateAmount {


    public static String calculateAmount(UserApplicationEntity user){
        Integer numberOfDays = user.getTotalDays();
        String amountToDeposit = null;
        Double fee = 0.0;
        Double security = 0.0;

        // 2 is Tent Case
        if(user.getSubcategory().getSubCategoryId() == 2){
            for(int i=0; i<user.getApp_items().size(); i++){
                Double itemFee = 0.0;
                itemFee = (Double.parseDouble(user.getApp_items().get(i).getItem().getFee())) * user.getApp_items().get(i).getTentNumber();
                fee += itemFee;
                security = Double.parseDouble(user.getApp_items().get(i).getItem().getSecurityAmount());
            }
            return Double.toString((fee * user.getTotalDays()) + security);

        }else if(user.getSubcategory().getSubCategoryId() == 5 || user.getSubcategory().getSubCategoryId() == 6 || user.getSubcategory().getSubCategoryId() == 7){
            //non tent case
            for(int i=0; i<user.getApp_items().size(); i++){
                Double itemFee = 0.0;
                itemFee = Double.parseDouble(user.getApp_items().get(i).getItem().getFee());
                fee += itemFee;
                security = Double.parseDouble(user.getApp_items().get(i).getItem().getSecurityAmount());
            }
            return Double.toString((fee * user.getTotalDays()) + security);
        }else{
            for(int i=0; i<user.getApp_items().size(); i++){
                Double itemFee = 0.0;
                itemFee = Double.parseDouble(user.getApp_items().get(i).getItem().getFee());
                fee += itemFee;
                security = Double.parseDouble(user.getApp_items().get(i).getItem().getSecurityAmount());
            }

            return Double.toString((fee) + security);
        }

    }
}
