//Validations goes here
function validateFields() {

    var firstname = document.getElementById('firstname').value;
    var lastname = document.getElementById('lastname').value;
    var username = document.getElementById('username').value;
    var mobileNumber = document.getElementById('mobileNumber').value;
    var age = document.getElementById('age').value;
    var emailAddress = document.getElementById('emailAddress').value;
    var gender = document.getElementById('gender').value;
    var p_address = document.getElementById('p_address').value.trim();
    var c_address = document.getElementById('c_address').value;
    var roleId = document.getElementById('roles').value;
    var password = document.getElementById('password').value;
    var passwordConfirm = document.getElementById('passwordConfirm').value.trim();
    var captcha = document.getElementById('captcha').value.trim();

    if (firstname == "" || firstname == null ) {
        alert("Please enter First Name ");
        return false;
    } else if (lastname == "" || lastname == null ) {
        alert("Please enter Last Name");
        return false;
    } else if (username == "" || username == null) {
        alert("Please Enter Username");
        return false;
    }  else if (mobileNumber == "" || mobileNumber == null || mobileNumber.length != 10) {
       console.log(mobileNumber);
        alert("Please enter a valid 10 digit mobile number");
        return false;
    } else if (age == "" || age == null) {
        alert("Please Enter Age.");
        return false;
    } else if (emailAddress == "" || emailAddress == null) {
        alert("Please enter Email Address.");
        return false;
    } else if (gender == "" || gender == null || gender == '0') {
        alert("Please select Gender.");
        return false;
    }
    //else if (parseInt(luggageWeight) >= parseInt('11')) {
//        //  alert(parseInt(luggageWeight)+" int value");
//        // alert(parseInt('10')+" int value");
//        alert("Luggage Weight cannot be more than 10 KG");
//        return false;
   // }
    else if (p_address == "" || p_address == null) {
        alert("Please enter complete Permanent Address");
        return false;
    }  else if (roleId == "" || roleId == null || roleId == "0") {
        alert("Please select the type of User");
        return false;
    } else if (password == "" || password == null) {
        alert("Please enter Password");
        return false;
    }  else if (password != passwordConfirm) {
       // alert(declerationUser);
        alert("Passwords Does not Match.");
        return false;
    }  else return true;
}


function submit_form() {
    //alert("are we haere");
    var submitData = validateFields();

    if (!submitData) return false;

}