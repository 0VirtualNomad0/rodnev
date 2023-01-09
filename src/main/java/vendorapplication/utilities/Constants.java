package vendorapplication.utilities;


import java.util.regex.Pattern;

public class Constants {


    public static final String space = " ";

    public static final String keyResponse = "RESPONSE";
    public static final String keyMessage = "MSG";
    public static final String keyStatus = "STATUS";
    public static final String valueMessage = "Request Successful.";
    public static final String valueMessageEmpty = "Please enter valid Vehicle Registration Number";
    public static final String email_reference = "dc-lah-hp@nic.in";


    /**
     * Credentials For the CDAC OTP
     */
    public static final String smsUsername = "hpgovt-DCLAS";
    public static final String smsPassword = "LAS@123456789";
    public static final String smsSenderId = "hpgovt";
    public static final String smsSecureKey = "01817f89-bba9-4c78-80f4-78a6ab49e88a";
    public static final String otp_Message = "You have been successfully registered for E-Flight Service. Your Application ID is:-";
    public static final String otp_MessageEnd = "- DC Office Lahaul Spiti ";
    public static final String templateId = "1007290394704048702";


    public static final String PENDING = "P";
    public static final String INCOMPLETE = "I";
    public static final String APPROVED = "A";
    public static final String REJECTED = "R";

    public static final String SuccessRegistration = "Registration Successful. Please Login using your credentials to fill the vendor application form. ";

    public static final String ErrorAjaxResponse = "Unable to retrieve data from Server. Please try again and check weather you are connected to Internet or Not.";
    /**
     * Security Key AES
     */
    public static final String securityKeyAES = "hPelahaul@17_04_21";

    /**
     * State Id
     */
    public static final Integer stateID = 9;


    /**
     *
     * Merchant Name	DC L&S-HELICOPTER FLIGHT BOOKINGS
     * Key	7rnFly
     * Salt	pjVQAWpA
     * Merchant Domain	WWW.STAGING12.HP.GOV.IN/FLIGHT
     * SETUP TYPE	Hosted
     */
    /**
     * Json Data Rest Service
     */
    public static final String application_id = "application_id";
    public static final String user_id = "user_id";
    public static final String username = "username";
    public static final String password = "password";
    public static final String mobule_number = "mobile_number";
    public static final String genericError = "Something Bad Happened. Please try again later.";
    public static final String nothingFound = "No Record Found";
    public static final String consumesProducesJson = "text/plain";  //application/*+json
    public static final String getConsumesProducesPlainText = "text/plain";
    public static final String apiMethod = "/api/getCompleteApplication";
    public static final String apiMethodLogin = "/api/login";
    public static final String applicationDataEmpty = "Application Data Empty";
    public static final String userDetailsDataEmpty = "User Details  Data Empty";
    /**
     * Captcha Salt Characters
     */
    public static final String captchaSaltCharacters = "1234567890";
    /**
     * AJAX Constants
     * All the Javascript Mappings defined as constants
     * AJAX Constants Parameters
     */
    public static final String requestParam = "id";
    public static final String userDetailRequestParam = "aadhaarNumber";
    public static final String surveyDetailRequestParam = "userid";
    public static final String getArea = "/ajax/getArea";
    public static final String getDistrict = "/ajax/getDistrict";
    public static final String getItemsviaSubCategoriesNonTentNonRegional = "/ajax/getItemsviaSubCategoriesNonTentNonRegional";
    public static final String getItemsviaSubCategoriesNR = "/ajax/getItemsviaSubCategoriesNR";
    public static final String getItemsviaSubCategoriesTent = "/ajax/getItemsviaSubCategoriesTent";
    public static final String getVendorCategory = "/ajax/getVendorCategory";
    public static final String getVendor = "/ajax/getVendor";
    public static final String getCasteCategories = "/ajax/getCasteCategories";
    public static final String getQualifications = "/ajax/getQualifications";
    public static final String getrolesVendor = "/ajax/getrolesVendor";
    public static final String getLandType = "/ajax/getLandType";
    public static final String getNationalRegional = "/ajax/getNationalRegional";
    public static final String getNationality = "/ajax/getNationality";
    public static final String getWardPanchayat = "/ajax/getWardPanchayat";
    public static final String getTehsils = "/ajax/getTehsils";
    public static final String getBlocks = "/ajax/getBlocks";

    public static final String getSurveyUserAnimalHusbandryData = "/ajax/getSurveyUserAnimalHusbandryData";
    public static final String getAnimalHusbandryData = "/ajax/animal-husbandry-survey-details";

    public static final String getSurveyUserAgricultureData = "/ajax/getSurveyUserAgricultureData";
    public static final String getAgricultureData = "/ajax/agriculture-survey-details";
    public static final String getDistrictsViaState = "/ajax/getDistrictsViaState";
    public static final String getState = "/ajax/getState";
    public static final String getGender = "/ajax/getGender";
    public static final String getCropType = "/ajax/getCropType";
    public static final String getRoles = "/ajax/getRoles";
    public static final String landType = "landType";
    public static final String category = "category";
    public static final String subCategory = "subCategory";
    public static final String regional = "regional";
    /**
     * Cache String
     */
    public static final String cacheLogString = "=========================================================" + "Using cache manager: " + " =========================================================";
    /**
     * Configuration Package Constants
     */
    public static final String messageSource = "messageSource";
    public static final String utf8 = "UTF-8";
    public static final String lang_messages = "lang/messages";
    public static final String lang = "lang";
    /**
     * Security Configuration
     */
    public static final String secMessage = "Logout Successful.";
    public static final String secError = "Please Enter valid User Credentials and Captcha";
    public static final String errorsec = "error";
    public static final String messagesec = "message";
    /**
     * Controllers Mapping
     */
    public static final String loginController = "/login";
    public static final String indexController = "/index";
    public static final String headerNameXXSRF = "X-XSRF-TOKEN";
    public static final String setHeaderCokkie = "Set-Cookie";
    public static final String headerNameXSRF = "XSRF-TOKEN";
    public static final String JSESSIONID = "JSESSIONID";
    public static final String SameSite_Strict = "SameSite=Strict";
    public static final String formatting = "%s; %s";
    public static final String nocache_nostore_mustrevalidate = "no-cache, no-store, must-revalidate";
    public static final String no_cache = "no-cache";
    public static final String text_html = "text/html; charset=UTF-8";
    public static final String pragma = "pragma";
    public static final String Cache_control = "Cache-control";
    public static final String seperator = "/";
    public static final String nocrf = "/nocsrf";
    /**
     * Tiles Configuration
     */
    public static final String tilesPath = "/WEB-INF/tiles.xml";
    /**
     * Permissions Access
     */
    public static final String permitAll = "/**";
    public static final String permitDownloadFile = "/downloadFile/**";
    public static final String permitApi = "/api/**";
    public static final String denyPermitResourcesFonts = "/resources/css/fonts";
    public static final String permitPaymentResponse = "/paymentResponse/**";
    public static final String permitSaveApplication = "/saveapplication/";
    public static final String permitPaymentPage = "/paymentpage/**";
    public static final String permitVendorApplicationAjax = "/vendorapplication.ajax/**";
    public static final String permitAdmin = "/admin/**";
    public static final String permitCreateUser = "/createuser/**";
    public static final String permitSaveUser = "/saveuser/";
    public static final String permitCreateRole = "/createrole/";
    public static final String permitFilterApplication = "/filterApplications/";
    public static final String permitApplications = "/applications/";
    public static final String permitGetUserDetails = "/getUserDetails/**";
    public static final String permitUpdateApplication = "/updateApplication/**";
    public static final String permitApplicationsAll_ = "/applications_all/**";
    public static final String permitCheckPayment = "/checkpayment/**";
    public static final String permitIndex = "/index/**";
    /**
     * Roles Names
     */
    public static final String vendor = "Vendor";
    public static final String admin = "Admin";
    public static final String superAdmin = "Super Admin";
    /**
     * E Ticket PDF Instructions
     */

    public static String TICKET_HEADING = "E-Lahaul V1.0";
    public static String INSTRUCTUIN_0 = "Instructions:";
    public static String INSTRUCTUIN_I = "The Luggage Should not exceed 10KG. ";
    public static String INSTRUCTUIN_II = "The amount charged shall be refunded if the booking is cancelled before 6 hours of scheduled flight.";
    public static String INSTRUCTUIN_III = "The passenger should reach at Helipad/Airport before the departure of Flight. ";
    public static String IMAGE_NAME_PASS = "hp_logo.png";
    /**
     * Report Constants
     */
    public static Integer reportTableSpacing = 20;

    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static final String createUsername(String firstname, String lastname, String age, String userType) {
        StringBuffer sb = new StringBuffer();
        sb.append(firstname);
        sb.append("_");
        sb.append(lastname);
        sb.append("_");
        sb.append(age);
        sb.append("_");
        sb.append(userType);
        return sb.toString();
    }


}
