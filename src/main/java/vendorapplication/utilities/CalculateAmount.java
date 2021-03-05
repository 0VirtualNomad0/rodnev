package vendorapplication.utilities;

import vendorapplication.entities.UserApplicationEntity;

public class CalculateAmount {


    public static String calculateAmount(UserApplicationEntity user){
        String amountToDeposit = null;
//        if(user.getVendorTypeId().getSubCategoryName().equalsIgnoreCase("Tent") ){
//             Long amount_tent = Long.valueOf(500 * user.getTentNumber());
//            amountToDeposit = String.valueOf(amount_tent) ;
//        }else{
//            amountToDeposit = "500";
//        }


        return amountToDeposit;
    }
}
