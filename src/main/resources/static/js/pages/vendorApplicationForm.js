function hasExtension(inputID, exts) {
    var fileName = document.getElementById(inputID).value;
    return (new RegExp('(' + exts.join('|').replace(/\./g, '\\.') + ')$')).test(fileName);
}

function validateFields() {

    var firstname = document.getElementById('firstname').value;
    var lastname = document.getElementById('lastname').value;
    var gender = document.getElementById('gender').value;
    var mobileNumber = document.getElementById('mobileNumber').value;
    var age = document.getElementById('age').value;
    var emailAddress = document.getElementById('emailAddress').value;
    var state = document.getElementById('state').value;
    var localDistrict = document.getElementById('localDistrict').value;
    var localBlock = document.getElementById('localBlock').value;
    var localTehsil = document.getElementById('localTehsil').value;
    var localgp = document.getElementById('localgp').value;
    var p_address = document.getElementById('p_address').value;
    var vstate = document.getElementById('vstate').value;
    var vlocalDistrict = document.getElementById('vlocalDistrict').value;
    var vlocalBlock = document.getElementById('vlocalBlock').value;
    var vlocalTehsil = document.getElementById('vlocalTehsil').value;
    var vlocalgp = document.getElementById('vlocalgp').value;
    var loc_address = document.getElementById('loc_address').value;
    var fromDate = document.getElementById('fromDate').value;
    var toDate = document.getElementById('toDate').value;
    var totalDays = document.getElementById('totalDays').value;
    var nationality = document.getElementById('nationality').value;
    var landType = document.getElementById('landType').value;
    var vendor = document.getElementById('vendor').value;
    var vendorType = document.getElementById('vendorType').value;
    var nationalRegional = document.getElementById('nationalRegional').value;
    var item_non_tent = document.getElementById('item_non_tent').value;
    var identityDoc = document.getElementById('identityDoc').value;
    var photoDoc = document.getElementById('photoDoc').value;
    var captcha_id = document.getElementById('captcha_id').value;



    if (firstname == "" || firstname == null) {
        alert("Please enter  First Name");
        return false;
    } else if (lastname == "" || lastname == null) {
        alert("Please enter Last Name");
        return false;
    } else if (gender == "" || gender == null || gender == '0') {
        alert("Please select Gender");
        return false;
    } else if (mobileNumber == "" || mobileNumber == null || mobileNumber.length != 10) {
        alert("Please enter a valid 10 digit mobile number");
        return false;
    } else if (age == "" || age == null) {
        alert("Please Enter Age.");
        return false;
    } else if (localDistrict == "" || localDistrict == null || localDistrict == '0') {
        alert("Please select District (Local Address) ");
        return false;
    } else if (localBlock == "" || localBlock == null || localBlock == '0') {
        alert("Please select Block (Local Address)");
        return false;
    } else if (localTehsil == "" || localTehsil == null || localTehsil == '0') {
        alert("Please Select Tehsil (Local Address)");
        return false;


    } else if (localgp == "" || localgp == null || localgp == '0') {
        alert("Please Select Gram Panchayat /Ward  (Local Address)");
        return false;


    } else if (vlocalDistrict == "" || vlocalDistrict == null || vlocalDistrict == '0') {
        alert("Please select District (Vending Address) ");
        return false;
    } else if (vlocalBlock == "" || vlocalBlock == null || vlocalBlock == '0') {
        alert("Please select Block (Vending Address)");
        return false;
    } else if (vlocalTehsil == "" || vlocalTehsil == null || vlocalTehsil == '0') {
        alert("Please select Tehsil (Vending Address)");
        return false;
    } else if (vlocalgp == "" || vlocalgp == null || vlocalgp == '0') {
        alert("Please Select Gram Panchayat/ Ward (Vending Address)");
        return false;
    } else if (nationality == "" || nationality == null || nationality == '0') {
        alert("Please select Nationality");
        return false;
    } else if (landType == "" || landType == null || landType == '0') {
        alert("Please select Purpose for activity");
        return false;
    } else if (vendor == "" || vendor == null || vendor == '0') {
        alert("Please select Category for  Vending");
        return false;
    } else if (vendorType == "" || vendorType == null || vendorType == '0') {
        alert("Please select Subcategory for Vending");
        return false;
    } else if (fromDate == "" || fromDate == null) {
        alert("Please select From Date .");
        return false;
    } else if (toDate == "" || toDate == null) {
        alert("Please select To Date.");
        return false;
    } else if (totalDays == "" || totalDays == null) {
        alert("Total Days cannot be Empty");
        return false;
    } else if (identityDoc == null || identityDoc == "") {
        alert("Please attach any Identity (Aadhaar Card, Voter Card etc.)");
        return false;
    } else if (!hasExtension('identityDoc', ['.jpg', '.jpeg', '.png', '.pdf'])) {
        alert("Only PDF or Images are allowed");
        return false;
    } else if (photoDoc == null || photoDoc == "") {
        alert("Please attach any Photograph");
        return false;
    } else if (!hasExtension('photoDoc', ['.jpg', '.jpeg', '.png'])) {
        alert("Only Images are allowed [Applicant Photograph]");
        return false;
    } else if (p_address == "" || p_address == null) {
        alert("Please Enter Permanent Address.");
        return false;
    } else if (loc_address == "" || loc_address == null) {
        alert("Please Enter Vending Address.");
        return false;
    } else if (vendorType != "2" && (item_non_tent == "" || item_non_tent == null || item_non_tent == "0")) {
        alert("Please Select Items.");
        return false;
    }  else return true;
}

function checkValue(value) {

    var x = document.getElementById("tableDiv_tent");
    var y = document.getElementById("non_tent_Items");
    var z = document.getElementById("div_regional_nonregional");
    var a = document.getElementById("div_numberItems");

    if (value == "2") {
        x.style.display = "block";
        y.style.display = "none";
        z.style.display = "none";
        a.style.display = "none";
        getItemsTent($('#landType').val(), $('#nationalRegional').val(), $('#vendor').val(), $('#vendorType').val(), '');


    } else if (value == "7" || value == "3") {
        x.style.display = "none";
        y.style.display = "block";
        z.style.display = "block";
        a.style.display = "none";
    }   else if (value == "28" || value == "13" || value == "15" || value=="16" || value=="18") {
         //-- 28 snow scooters, 13 PAraGliding, 15 yark, 16 horse, 18 raft
                 x.style.display = "none";
                 y.style.display = "block";
                 z.style.display = "none";
                 a.style.display = "block";
                  getItemsnonTent( $('#landType').val(), $('#nationalRegional').val(), $('#vendor').val(), $('#vendorType').val(), '');


             }

    else {
        x.style.display = "none";
        y.style.display = "block";
        z.style.display = "none";
        a.style.display = "none";
        getItemsnonTent( $('#landType').val(), $('#nationalRegional').val(), $('#vendor').val(), $('#vendorType').val(), '');


    }
}



function submit_form() {
    var submitData = validateFields();

    if (!submitData) return false;

}