function hasExtension(inputID, exts) {
    var fileName = document.getElementById(inputID).value;
    return (new RegExp('(' + exts.join('|').replace(/\./g, '\\.') + ')$')).test(fileName);
}

//Validations goes here
function validateFields() {

    var nationality = document.getElementById('nationality').value;
    var vendor = document.getElementById('vendor').value;
    var vendorType = document.getElementById('vendorType').value;
    var tentNumber = document.getElementById('tentNumber').value;
    var district = document.getElementById('district').value;
    var locationAvailable = document.getElementById('locationAvailable').value;
    var identityDoc = document.getElementById('identityDoc').value.trim();
    var tents = document.getElementById('tentNumber').value.trim();
     var tentCapacity = document.getElementById('tentCapacity').value.trim();

    var comments = document.getElementById('comments').value.trim();


    if (nationality == "" || nationality == null || nationality == '0') {
        alert("Please select Nationality ");
        return false;
    } else if (vendor == "" || vendor == null || vendor == '0') {
        alert("Please select Vendor Type");
        return false;
    } else if (vendorType == "" || vendorType == null || vendorType == '0') {
        alert("Please select Vendor Category");
        return false;
    } else if (district == "" || district == null || district == '0') {
        alert("Please Select Location");
        return false;
    } else if (locationAvailable == "" || locationAvailable == null) {
        alert("Please Select the Available Location  Select Area.");
        return false;
    } else if (identityDoc == null || identityDoc == "") {
        alert("Please attach any Identity (Aadhaar Card, Voter Card etc.)");
        return false;
    } else if (!hasExtension('identityDoc', ['.jpg', '.jpeg', '.png', '.pdf'])) {
        alert("Only PDF and Images are allowed");
        return false;
    }else if(vendorType == '1' && (parseInt(tents) <= parseInt('0') || tents == '')){
    alert("Please enter No. of Tents");
      return false;
    } else return true;
}

function hideunhide(value) {
    if (value != "1") {
        hide_ctrl('tentDiv~tentCapacityDiv', true);
            document.getElementById('tentNumber').value = "";
            document.getElementById('tentCapacity').value = "NA";

    } else {
        unhide_ctrl('tentDiv~tentCapacityDiv', true);


    }
}


function checkValue(value){

var x = document.getElementById("tableDiv_tent");
var y = document.getElementById("non_tent_Items");
var z = document.getElementById("div_regional_nonregional");

  if (value == "2") {
         x.style.display = "block";
         y.style.display = "none";
         z.style.display = "none";
          getItemsTent($('#nationality').val(),$('#landType').val(),$('#nationalRegional').val(),$('#vendor').val(),$('#vendorType').val(),'');


    } else if (value == "7" || value == "3"){
          x.style.display = "none";
          y.style.display = "block";
          z.style.display = "block";


    }
    else {
         x.style.display = "none";
         y.style.display = "block";
         z.style.display = "none";
         getItemsnonTent($('#nationality').val(),$('#landType').val(),$('#nationalRegional').val(),$('#vendor').val(),$('#vendorType').val(),'');


    }
}



function submit_form() {
    //alert("are we haere");
    var submitData = validateFields();

    if (!submitData) return false;

}