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
         //  var json_ = JSON.parse(data);
            console.log(data)
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
                selectRole.append("<option value=" + data.RESPONSE[i].categoryId + " >" + data.RESPONSE[i].categoryName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//getsVendor
function getsVendor() {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getVendor",
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#categoryId'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].categoryId + " >" + data.RESPONSE[i].categoryName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//getNationalRegional
function getNationalRegional() {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getNationalRegional",
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#nationalRegional'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].nationalRegionalId + " >" + data.RESPONSE[i].nationalRegionalName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//Table get National Regional
function getNationalRegionalT(value) {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getNationalRegional",
        success: function(data) {
            console.log(data.RESPONSE)
             var id_ = "#nationalRegional" + value;
              console.log(id_)
            var selectRole = $(id_); // the state select element
           // var selectRole = $('#nationalRegional'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].nationalRegionalId + " >" + data.RESPONSE[i].nationalRegionalName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//getLandType Table
function getLandTypeT(value) {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getLandType",
        success: function(data) {
            console.log(data.RESPONSE)
            var id_ = "#landType" + value;
                          console.log(id_)
            var selectRole = $(id_);
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].landTypeId + " >" + data.RESPONSE[i].landTypeName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//getItemsTent
function getItemsTent(landType,nationalRegional,category,subCatId,elementIdwithRow) {

     console.log("landType:- " + landType);
       console.log("category:- " + category);
        console.log("subCatId:- " + subCatId);
      $.ajax({
            type: "GET",
            url: formURL + "/ajax/getItemsviaSubCategoriesTent",
            data: {

                        "landType":landType,
                        "regional":nationalRegional,
                        "category":category,
                        "subCategory":subCatId
                    },
            success: function(data) {
                console.log(data.RESPONSE)
                var id_ = "#item" + elementIdwithRow;
                                          console.log(id_)
                            var selectRole = $(id_);
                selectRole.find('option').remove();
                selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
                for (i = 0; i < data.RESPONSE.length; i++) {
                  var amountForest_Panchayat = 0
                amountForest_Panchayat = parseInt(data.RESPONSE[i].rate) + parseInt(data.RESPONSE[i].fee_panchayat);

                    selectRole.append("<option value=" + data.RESPONSE[i].itemId + " >" + data.RESPONSE[i].itemName +" "+ (amountForest_Panchayat) +"/-"  + "</option>")
                }

            },
            error: function(data) {
                console.log(data)
            }

        });
}




//getItemsNR
function getItemsNR(landType,nationalRegional,category,subCatId,elementIdwithRow) {

     console.log("landType:- " + landType);
       console.log("category:- " + category);
        console.log("subCatId:- " + subCatId);
        console.log("nationalRegional:- " + nationalRegional);
      $.ajax({
            type: "GET",
            url: formURL + "/ajax/getItemsviaSubCategoriesNR",
            data: {

                        "landType":landType,
                        "category":category,
                        "regional":nationalRegional,
                        "subCategory":subCatId
                    },
            success: function(data) {
                console.log(data.RESPONSE)
                var id_ = "#item_non_tent" + elementIdwithRow;
                                          console.log(id_)
                            var selectRole = $(id_);
                selectRole.find('option').remove();
                selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
                for (i = 0; i < data.RESPONSE.length; i++) {
                 var amountForest_Panchayat = 0
                amountForest_Panchayat = parseInt(data.RESPONSE[i].rate) + parseInt(data.RESPONSE[i].fee_panchayat);

                    selectRole.append("<option value=" + data.RESPONSE[i].itemId + " >" + data.RESPONSE[i].itemName  +" "+ (amountForest_Panchayat) +"/-"  + "</option>")
                }

            },
            error: function(data) {
                console.log(data)
            }

        });
}


//getItemsitem_non_tent($('#nationality').val(),$('#landType').val(),$('#nationalRegional').val(),$('#vendor').val(),$('#vendorType').val(),'');
function getItemsnonTent(landType,nationalRegional,category,subCatId,elementIdwithRow) {

     console.log("landType:- " + landType);
      console.log("nationalRegional:- " + nationalRegional);
       console.log("category:- " + category);
        console.log("subCatId:- " + subCatId);
      $.ajax({
            type: "GET",
            url: formURL + "/ajax/getItemsviaSubCategoriesNonTentNonRegional",
            data: {

                        "landType":landType,
                        "regional":nationalRegional,
                        "category":category,
                        "subCategory":subCatId
                    },
            success: function(data) {
                console.log(data.RESPONSE)
                var id_ = "#item_non_tent" + elementIdwithRow;
                                          console.log(id_)
                            var selectRole = $(id_);
                selectRole.find('option').remove();
                selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
                for (i = 0; i < data.RESPONSE.length; i++) {
                  var amountForest_Panchayat = 0
                amountForest_Panchayat = parseInt(data.RESPONSE[i].rate) + parseInt(data.RESPONSE[i].fee_panchayat);

                                       selectRole.append("<option value=" + data.RESPONSE[i].itemId + " >" + data.RESPONSE[i].itemName  +" "+ (amountForest_Panchayat) +"/-"  + "</option>")

                }

            },
            error: function(data) {
                console.log(data)
            }

        });
}

//getLandType
function getLandType() {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getLandType",
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#landType'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < data.RESPONSE.length; i++) {
                selectRole.append("<option value=" + data.RESPONSE[i].landTypeId + " >" + data.RESPONSE[i].landTypeName + "</option>")
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

//getvTehsils
function getvTehsils(id) {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getTehsils",
        data: {
                    "id": id
                },
        success: function(data) {
            console.log(data.RESPONSE)
            var selectRole = $('#vlocalTehsil'); // the state select element
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
 document.getElementById("tableDiv_tent").style.display = "none";
 document.getElementById("non_tent_Items").style.display = "none";
 document.getElementById("div_regional_nonregional").style.display = "none";


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


    function getVendorCategoryAdmin(id) {
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