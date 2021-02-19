function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}

var formURL = getContextPath();


function getFormData() {

    var loginForm = {};

    loginForm.username = document.getElementById("username").value;
    loginForm.password = document.getElementById("password").value;
    //loginForm.captcha=grecaptcha.getResponse();

    alert(loginForm);
    return loginForm;

}

function submit1() {
    var data_ = JSON.stringify(getFormData());
    alert(formURL);
    $.ajax({
        type: "GET",
        url: formURL,
        contentType: 'application/json',
        dataType: "json",
        data: data_,
        success: function(data) {
            alert(data.message);
            console.log(data.message)

        },
        error: function(data) {
            alert(data);
            console.log(data)
        }

    });
}

//ajaxcall

function getroles() {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getRoles",
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#roles'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].role_id + " >" + data.RESPONSE[i].role_name + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

// Get Gender
function getgender() {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getGender",
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#gender'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].genderId + " >" + data.RESPONSE[i].genderName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//getNationality
function getNationality() {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getNationality",
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#nationality'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].nationalityId + " >" + data.RESPONSE[i].nationalityName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//getVendor
function getVendor() {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getVendor",
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#vendor'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].vendorId + " >" + data.RESPONSE[i].vendorName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}


//Get States
function getState() {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getState",
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#state'); // the state select element
            selectRole.find('option').remove();
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].stateId + " >" + data.RESPONSE[i].stateName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

function getvState() {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getState",
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#vstate'); // the state select element
            selectRole.find('option').remove();
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].stateId + " >" + data.RESPONSE[i].stateName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

function getDistrictsViaState(id) {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getDistrictsViaState",
        data: {
                    "id": id
                },
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#localDistrict'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].districtId + " >" + data.RESPONSE[i].districtName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

function getvDistrictsViaState(id) {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getDistrictsViaState",
        data: {
                    "id": id
                },
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#vlocalDistrict'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].districtId + " >" + data.RESPONSE[i].districtName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//getBlocks
function getBlocks(id) {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getBlocks",
        data: {
                    "id": id
                },
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#localBlock'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].blockId + " >" + data.RESPONSE[i].blockName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//getvBlocks
function getvBlocks(id) {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getBlocks",
        data: {
                    "id": id
                },
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#vlocalBlock'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].blockId + " >" + data.RESPONSE[i].blockName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//getTehsils
function getTehsils(id) {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getTehsils",
        data: {
                    "id": id
                },
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#localTehsil'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].tehsilId + " >" + data.RESPONSE[i].tehsilName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//getWardPanchayat
function getWardPanchayat(id) {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getWardPanchayat",
        data: {
                    "id": id
                },
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#localgp'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].gpId + " >" + data.RESPONSE[i].gpName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//getvWardPanchayat
function getvWardPanchayat(id) {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getWardPanchayat",
        data: {
                    "id": id
                },
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#vlocalgp'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].gpId + " >" + data.RESPONSE[i].gpName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}



function getVendorCategory(id) {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getVendorCategory",
        data: {
            "id": id
        },
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#vendorType'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option  value=" + data.RESPONSE[i].vendorCategoryId + " >" + data.RESPONSE[i].vendorCategoryName + "</option>")


            };

        },
        error: function(data) {
            console.log(data)
        }

    });
    }

    //getArea
    function getArea(id) {

        $.ajax({
            type: "GET",
            url: formURL + "/ajax/getArea",
            data: {
                "id": id
            },
            success: function(data) {
                console.log(data.RESPONSE)
                var selectRole = $('#locationAvailable'); // the state select element
                selectRole.find('option').remove();

                for (i = 0; i < data.RESPONSE.length; i++) {
                    selectRole.append("<option  value=" + data.RESPONSE[i].areaId + " >" + data.RESPONSE[i].areaName + "</option>")


                };

            },
            error: function(data) {
                console.log(data)
            }

        });
        }


//getrolesVendor
function getrolesVendor() {

   $.ajax({
           type: "GET",
           url: formURL + "/ajax/getrolesVendor",
           success: function(data) {
               console.log(data.RESPONSE)
               var selectRole = $('#roles'); // the state select element
               selectRole.find('option').remove();
               for (i = 0; i < data.RESPONSE.length; i++) {
                   selectRole.append("<option value=" + data.RESPONSE[i].role_id + " >" + data.RESPONSE[i].role_name + "</option>")
               }

           },
           error: function(data) {
               console.log(data)
           }

       });
}

//getDistrict
function getDistrict() {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getDistrict",
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#district'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option  value=" + data.RESPONSE[i].districtId + " >" + data.RESPONSE[i].districtName + "</option>")


            };

        },
        error: function(data) {
            console.log(data)
        }

    });
    }