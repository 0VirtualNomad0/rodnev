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
           var json_ = JSON.parse(data);
            console.log(json_);
            var selectRole = $('#roles'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].role_id + " >" + json_.RESPONSE[i].role_name + "</option>")
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
        var json_ = JSON.parse(data);
        console.log(json_);
            var selectRole = $('#gender'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].genderId + " >" + json_.RESPONSE[i].genderName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}


// getGenderTable_();
function getGenderTable_() {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getGender",
        success: function(data) {
        var json_ = JSON.parse(data);
        console.log(json_);
            var selectRole = $('#genderTable'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].genderId + " >" + json_.RESPONSE[i].genderName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

 function getQualificationsTable_() {

     $.ajax({
         type: "GET",
         url: formURL + "/ajax/getQualifications",
         success: function(data) {
             var json_ = JSON.parse(data);
                         console.log(json_);
             var selectRole = $('#qualificationTable'); // the state select element
             selectRole.find('option').remove();
             selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
             for (i = 0; i < json_.RESPONSE.length; i++) {
                 selectRole.append("<option value=" + json_.RESPONSE[i].qualificationId + " >" + json_.RESPONSE[i].qualificationName + "</option>")
             }

         },
         error: function(data) {
             console.log(data)
         }

     });
 }

 function getCropTypeTable_() {
     $.ajax({
           type: "GET",
           url: formURL + "/ajax/getCropType",
           success: function(data) {
               var json_ = JSON.parse(data);
               console.log(json_);
               var selectRole = $('#cropTypeTable');
               var selectFutureCrop = $('#futureCropTypeTable');
               selectRole.find('option').remove();
               selectFutureCrop.find('option').remove();
               selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
               selectFutureCrop.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
               for (i = 0; i < json_.RESPONSE.length; i++) {
                   selectRole.append("<option value=" + json_.RESPONSE[i].cropTypeId + " >" + json_.RESPONSE[i].cropTypeName   + "</option>")
                   selectFutureCrop.append("<option value=" + json_.RESPONSE[i].cropTypeId + " >" + json_.RESPONSE[i].cropTypeName   + "</option>")
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
            var json_ = JSON.parse(data);
            console.log(json_);
            var selectRole = $('#nationality'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].nationalityId + " >" + json_.RESPONSE[i].nationalityName + "</option>")
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
            var json_ = JSON.parse(data);
            console.log(json_);
            var selectRole = $('#vendor'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].categoryId + " >" + json_.RESPONSE[i].categoryName + "</option>")
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
            var json_ = JSON.parse(data);
                        console.log(json_);
            var selectRole = $('#categoryId'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].categoryId + " >" + json_.RESPONSE[i].categoryName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//getCasteCategories
function getCasteCategories() {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getCasteCategories",
        success: function(data) {
            var json_ = JSON.parse(data);
                        console.log(json_);
            var selectRole = $('#castecategory'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].categoryId + " >" + json_.RESPONSE[i].categoryName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//getQualifications
function getQualifications() {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getQualifications",
        success: function(data) {
            var json_ = JSON.parse(data);
                        console.log(json_);
            var selectRole = $('#educationalQualification'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].qualificationId + " >" + json_.RESPONSE[i].qualificationName + "</option>")
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
             var json_ = JSON.parse(data);
                                    console.log(json_);
            var selectRole = $('#nationalRegional'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].nationalRegionalId + " >" + json_.RESPONSE[i].nationalRegionalName + "</option>")
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
             var json_ = JSON.parse(data);
                                    console.log(json_);
             var id_ = "#nationalRegional" + value;
              console.log(id_)
            var selectRole = $(id_); // the state select element
           // var selectRole = $('#nationalRegional'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].nationalRegionalId + " >" + json_.RESPONSE[i].nationalRegionalName + "</option>")
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
             var json_ = JSON.parse(data);
                                    console.log(json_);
            var id_ = "#landType" + value;
                          console.log(id_)
            var selectRole = $(id_);
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].landTypeId + " >" + json_.RESPONSE[i].landTypeName + "</option>")
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
                var json_ = JSON.parse(data);
                                       console.log(json_);
                var id_ = "#item" + elementIdwithRow;
                                          console.log(id_)
                            var selectRole = $(id_);
                selectRole.find('option').remove();
                selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
                for (i = 0; i < json_.RESPONSE.length; i++) {
                  var amountForest_Panchayat = 0
                amountForest_Panchayat = parseInt(json_.RESPONSE[i].rate) + parseInt(json_.RESPONSE[i].fee_panchayat);

                    selectRole.append("<option value=" + json_.RESPONSE[i].itemId + " >" + json_.RESPONSE[i].itemName +" "+ (amountForest_Panchayat) +"/-"  + "</option>")
                }

            },
            error: function(data) {
                console.log(data)
            }

        });
}


//getGenderTable
function getGenderTable(elementIdwithRow, selected = "") {

      $.ajax({
            type: "GET",
            url: formURL + "/ajax/getGender",
            success: function(data) {
                var json_ = JSON.parse(data);
                                       console.log(json_);
                var id_ = "#gender" + elementIdwithRow;
                                          console.log(id_)
                            var selectRole = $(id_);
                selectRole.find('option').remove();
                selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
                for (i = 0; i < json_.RESPONSE.length; i++) {
                    selectRole.append('<option value="' + json_.RESPONSE[i].genderId +'" '+(selected == json_.RESPONSE[i].genderId ? "selected": "")+ ' >' + json_.RESPONSE[i].genderName   + '</option>')
                }

            },
            error: function(data) {
                console.log(data)
            }

        });
}

 function getCropType(elementIdwithRow, selected="") {

       $.ajax({
             type: "GET",
             url: formURL + "/ajax/getCropType",
             success: function(data) {
                 var json_ = JSON.parse(data);
                                        console.log(json_);
                 var id_ = "#cropType" + elementIdwithRow;
                  console.log(id_)
                 var selectRole = $(id_);
                 selectRole.find('option').remove();
                 selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
                 for (i = 0; i < json_.RESPONSE.length; i++) {
                     selectRole.append('<option value="' + json_.RESPONSE[i].cropTypeId +'" '+(selected == json_.RESPONSE[i].cropTypeId ? "selected": "")+ ' >' + json_.RESPONSE[i].cropTypeName   + '</option>')
                 }

             },
             error: function(data) {
                 console.log(data)
             }

         });
 }

function getFutureCropType(elementIdwithRow, selected="") {

       $.ajax({
             type: "GET",
             url: formURL + "/ajax/getCropType",
             success: function(data) {
                 var json_ = JSON.parse(data);
                                        console.log(json_);
                 var id_ = "#futureCropType" + elementIdwithRow;
                  console.log(id_)
                 var selectRole = $(id_);
                 selectRole.find('option').remove();
                 selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
                 for (i = 0; i < json_.RESPONSE.length; i++) {
                     selectRole.append('<option value="' + json_.RESPONSE[i].cropTypeId +'" '+(selected == json_.RESPONSE[i].cropTypeId ? "selected": "")+ ' >' + json_.RESPONSE[i].cropTypeName   + '</option>')
                 }

             },
             error: function(data) {
                 console.log(data)
             }

         });
 }

function getQualificationTable(elementIdwithRow, selected = "") {

      $.ajax({
            type: "GET",
            url: formURL + "/ajax/getQualifications",
            success: function(data) {
                var json_ = JSON.parse(data);
                                       console.log(json_);
                var id_ = "#qualification" + elementIdwithRow;
                                          console.log(id_)
                            var selectRole = $(id_);
                selectRole.find('option').remove();
                selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
                for (i = 0; i < json_.RESPONSE.length; i++) {
                    selectRole.append('<option value="' + json_.RESPONSE[i].qualificationId +'" '+(selected == json_.RESPONSE[i].qualificationId ? "selected": "")+ ' >' + json_.RESPONSE[i].qualificationName   + '</option>')
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
                 var json_ = JSON.parse(data);
                                        console.log(json_);
                var id_ = "#item_non_tent" + elementIdwithRow;
                                          console.log(id_)
                            var selectRole = $(id_);
                selectRole.find('option').remove();
                selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
                for (i = 0; i < json_.RESPONSE.length; i++) {
                 var amountForest_Panchayat = 0
                amountForest_Panchayat = parseInt(json_.RESPONSE[i].rate) + parseInt(json_.RESPONSE[i].fee_panchayat);

                    selectRole.append("<option value=" + json_.RESPONSE[i].itemId + " >" + json_.RESPONSE[i].itemName  +" "+ (amountForest_Panchayat) +"/-"  + "</option>")
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
                var json_ = JSON.parse(data);
                                       console.log(json_);
                var id_ = "#item_non_tent" + elementIdwithRow;
                                          console.log(id_)
                            var selectRole = $(id_);
                selectRole.find('option').remove();
                selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
                for (i = 0; i < json_.RESPONSE.length; i++) {
                  var amountForest_Panchayat = 0
                amountForest_Panchayat = parseInt(json_.RESPONSE[i].rate) + parseInt(json_.RESPONSE[i].fee_panchayat);

                                       selectRole.append("<option value=" + json_.RESPONSE[i].itemId + " >" + json_.RESPONSE[i].itemName  +" "+ (amountForest_Panchayat) +"/-"  + "</option>")

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
            var json_ = JSON.parse(data);
                                   console.log(json_);
            var selectRole = $('#landType'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].landTypeId + " >" + json_.RESPONSE[i].landTypeName + "</option>")
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
            var json_ = JSON.parse(data);
                                   console.log(json_);
            var selectRole = $('#state'); // the state select element
            selectRole.find('option').remove();
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].stateId + " >" + json_.RESPONSE[i].stateName + "</option>")
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
            var json_ = JSON.parse(data);
                                   console.log(json_);
            var selectRole = $('#vstate'); // the state select element
            selectRole.find('option').remove();
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].stateId + " >" + json_.RESPONSE[i].stateName + "</option>")
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
             var json_ = JSON.parse(data);
                                    console.log(json_);
            var selectRole = $('#localDistrict'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].districtId + " >" + json_.RESPONSE[i].districtName + "</option>")
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
             var json_ = JSON.parse(data);
                                    console.log(json_);
            var selectRole = $('#vlocalDistrict'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].districtId + " >" + json_.RESPONSE[i].districtName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//get surveyUserData
function getSurveyUserAnimalHusbandryData(aadhaarNumber)
{
    if(aadhaarNumber.length != 12 )
    return;
    $.ajax({
            type: "GET",
            url: formURL + "/ajax/getSurveyUserAnimalHusbandryData",
            data: {
                "aadhaarNumber": aadhaarNumber
            },
            beforeSend: function(){
                 $("#loader").show();
               },
               complete: function(){
                 $("#loader").hide();
               },
            success: function(data) {
                var json_ = JSON.parse(data);
                $('#register-form').trigger("reset");
                getWardPanchayat("0");
                getBlocks("0");
                removeFamilyDetails();
                document.getElementById("aadhaarNumber").value = aadhaarNumber;
                if(json_.RESPONSE == "SurveyUserNotFound" || json_.MSG == "AadhaarDataNotFound"){
                    console.log(json_);
                    return;
                } else if(json_.MSG == "AadhaarDataFound"){
                    console.log(json_);
                    document.getElementById("firstname").value = json_.RESPONSE.firstName;
                    document.getElementById("lastname").value = json_.RESPONSE.lastName;
                    document.getElementById("age").value = json_.RESPONSE.age;
                    return;
                }
                document.getElementById("firstname").value = json_.RESPONSE.firstname;
                document.getElementById("lastname").value = json_.RESPONSE.lastname;
                document.getElementById("gender").value = json_.RESPONSE.gender;
                document.getElementById("mobileNumber").value = json_.RESPONSE.mobileNumber;
                document.getElementById("age").value = json_.RESPONSE.age;
                document.getElementById("castecategory").value = json_.RESPONSE.category;
                document.getElementById("familyHead").value = json_.RESPONSE.familyHead;
                document.getElementById("educationalQualification").value = json_.RESPONSE.educationalQualification;
                document.getElementById("state").value = json_.RESPONSE.state;
                document.getElementById("localDistrict").value = json_.RESPONSE.localDistrict;
                getBlocks(json_.RESPONSE.localDistrict, json_.RESPONSE.localBlock);
                document.getElementById("localBlock").value = json_.RESPONSE.localBlock;
                getWardPanchayat(json_.RESPONSE.localBlock, json_.RESPONSE.localgp);
                fillFamilyFormData(json_.RESPONSE.itemsForm);
                document.getElementById("localgp").value = json_.RESPONSE.localgp;
                document.getElementById("villageName").value = json_.RESPONSE.villageName;
                document.getElementById("p_address").value = json_.RESPONSE.p_address;
                document.getElementById("governmentEmp").value = json_.RESPONSE.governmentEmp;
                document.getElementById("selfEmp").value = json_.RESPONSE.selfEmp;
                document.getElementById("outsourcedEmp").value = json_.RESPONSE.outsourcedEmp;
                document.getElementById("pmuEmp").value = json_.RESPONSE.pmuEmp;
                document.getElementById("privateEmp").value = json_.RESPONSE.privateEmp;
                document.getElementById("cowNum").value = json_.RESPONSE.cowNum;
                document.getElementById("buffaloNum").value = json_.RESPONSE.buffaloNum;
                document.getElementById("otherNum").value = json_.RESPONSE.otherNum;
                document.getElementById("totalNum").value = json_.RESPONSE.totalNum;
                document.getElementById("buffaloMilkProduction").value = json_.RESPONSE.buffaloMilkProduction;
                document.getElementById("cowMilkProduction").value = json_.RESPONSE.cowMilkProduction;
                document.getElementById("houseMilkProduction").value = json_.RESPONSE.houseMilkProduction;
                document.getElementById("milkquantitySold").value = json_.RESPONSE.milkquantitySold;
                document.getElementById("milkwheresold").value = json_.RESPONSE.milkwheresold;
                document.getElementById("milksellingprice").value = json_.RESPONSE.milksellingprice;
                document.getElementById("willingsellmilk").value = json_.RESPONSE.willingsellmilk;
                document.getElementById("qyantitytosell").value = json_.RESPONSE.qyantitytosell;
                document.getElementById("willingtosell").value = json_.RESPONSE.willingtosell;
            },
            error: function(data) {
                console.log(data)
            }

        });


}

function getSurveyUserAgricultureData(aadhaarNumber)
{
    if(aadhaarNumber.length != 12 )
    return;
    $.ajax({
            type: "GET",
            url: formURL + "/ajax/getSurveyUserAgricultureData",
            data: {
                "aadhaarNumber": aadhaarNumber
            },
            beforeSend: function(){
                $("#loader").show();
            },
            complete: function(){
                $("#loader").hide();
            },
            success: function(data) {
                var json_ = JSON.parse(data);
                $('#register-form').trigger("reset");
                getWardPanchayat("0");
                getBlocks("0");

                removeFamilyAndCropDetails();
                document.getElementById("aadhaarNumber").value = aadhaarNumber;
                if(json_.RESPONSE == "SurveyUserNotFound" || json_.MSG == "AadhaarDataNotFound"){
                    console.log(json_);
                    return;
                } else if(json_.MSG == "AadhaarDataFound"){
                    console.log(json_);
                    document.getElementById("firstname").value = json_.RESPONSE.firstName;
                    document.getElementById("lastname").value = json_.RESPONSE.lastName;
                    document.getElementById("age").value = json_.RESPONSE.age;
                    return;
                }

                document.getElementById("firstname").value = json_.RESPONSE.firstname;
                document.getElementById("lastname").value = json_.RESPONSE.lastname;
                document.getElementById("gender").value = json_.RESPONSE.gender;
                document.getElementById("mobileNumber").value = json_.RESPONSE.mobileNumber;
                document.getElementById("age").value = json_.RESPONSE.age;
                document.getElementById("castecategory").value = json_.RESPONSE.category;
                document.getElementById("familyHead").value = json_.RESPONSE.familyHead;
                document.getElementById("educationalQualification").value = json_.RESPONSE.educationalQualification;
                document.getElementById("state").value = json_.RESPONSE.state;
                document.getElementById("localDistrict").value = json_.RESPONSE.localDistrict;
                getBlocks(json_.RESPONSE.localDistrict, json_.RESPONSE.localBlock);
                document.getElementById("localBlock").value = json_.RESPONSE.localBlock;
                getWardPanchayat(json_.RESPONSE.localBlock, json_.RESPONSE.localgp);
                fillFamilyFormData(json_.RESPONSE.itemsForm);
                fillCropFormData(json_.RESPONSE.cropdetailsForm);
                fillFutureCropFormData(json_.RESPONSE.futureCropDetailsForm);
                document.getElementById("localgp").value = json_.RESPONSE.localgp;
                document.getElementById("villageName").value = json_.RESPONSE.villageName;
                document.getElementById("p_address").value = json_.RESPONSE.p_address;
                document.getElementById("totalLand").value = json_.RESPONSE.totalLand;
                document.getElementById("cultivatedLand").value = json_.RESPONSE.cultivatedLand;
                document.getElementById("irrigatedLand").value = json_.RESPONSE.irrigatedLand;
                document.getElementById("nonIrrigatedLand").value = json_.RESPONSE.nonIrrigatedLand;
                document.getElementById("presentIncome").value = json_.RESPONSE.presentIncome;
                document.getElementById("marketableSystem").value = json_.RESPONSE.marketableSystem;
                document.getElementById("infrareq").value = json_.RESPONSE.infrareq;
                document.getElementById("trainingAgri").value = json_.RESPONSE.trainingAgri;
                document.getElementById("naturalFarming").value = json_.RESPONSE.naturalFarming;
                document.getElementById("fullPartial").value = json_.RESPONSE.fullPartial;
                document.getElementById("pmkisanbenifit").value = json_.RESPONSE.pmkisanbenifit;
            },
            error: function(data) {
                console.log(data)
            }
        });
}

function removeFamilyAndCropDetails()
{
        for(var i = 1; i <= add; i++)
        {
      		$("#id"+(i)).remove();
        }
        for(var i = 1; i <= addCropDetails; i++)
        {
      		$("#cropId"+(i)).remove();
        }
      	for(var i = 1; i <= addFutureCropDetails; i++)
      	{
            $("#futureCropId"+(i)).remove();
        }
        addCropDetails = 1;
        add = 1;
        addFutureCropDetails = 1;
}

function removeFamilyDetails()
{
    for(var i = 1; i <= add; i++)
      	{
            $("#id"+(i)).remove();
        }
    add = 1;
}
function fillFamilyFormData(familyDataList)
{
    for(let i in familyDataList)
    {
        if( i == 0)
        {
            document.getElementById("itemsForm[0].name").value = familyDataList[0].name;
            document.getElementById("itemsForm[0].age").value = familyDataList[0].age;
            document.getElementById("qualificationTable").value = familyDataList[0].qualification;
            document.getElementById("genderTable").value = familyDataList[0].gender;
        }
        else{
           	var row ='<div class="row " id="id'+i+'">'
            +'<div class="col-lg-3"><div class="form-group"><select path="itemsForm['+i+'].gender" name="itemsForm['+i+'].gender" id="gender'+i+'"   class="form-control"></select></div></div>'
            +'<div class="col-lg-3"><div class="form-group"><input oncopy="return false" onpaste="return false" path="itemsForm['+i+'].name" name="itemsForm['+i+'].name"   class="form-control" value="'+familyDataList[i].name+'"  /></div></div>'
            +'<div class="col-lg-3"><div class="form-group"><input oncopy="return false" onpaste="return false" maxlength="3" path="itemsForm['+i+'].age" name="itemsForm['+i+'].age"   class="form-control" value="'+familyDataList[i].age+'" onKeyPress="return isNumber(event)" /></div></div>'
            +'<div class="col-lg-3"><div class="form-group"><select path="itemsForm['+i+'].qualification" name="itemsForm['+i+'].qualification" id="qualification'+i+'"   class="form-control" ></select></div></div>'
            +'</div>'
           	add++;
            $("#addRow").append(row);
            getGenderTable(i, familyDataList[i].gender);
            getQualificationTable(i, familyDataList[i].qualification);

        }
    }
}

function fillCropFormData(cropDetailsForm)
{
    for(let i in cropDetailsForm)
    {
        if( i == 0)
        {
            document.getElementById("cropdetailsForm[0].cropName").value = cropDetailsForm[0].cropName;
            document.getElementById("cropdetailsForm[0].cropArea").value = cropDetailsForm[0].cropArea;
            document.getElementById("cropTypeTable").value = cropDetailsForm[0].cropType;
            document.getElementById("cropdetailsForm[0].cropProduction").value = cropDetailsForm[0].cropProduction;
            document.getElementById("cropdetailsForm[0].cropMarketing").value = cropDetailsForm[0].cropMarketing;
        }
        else{
           	var row ='<div class="row " id="cropId'+i+'">'
                   +'<div class="col-lg-2"><div class="form-group"><select path="cropdetailsForm['+i+'].cropType" name="cropdetailsForm['+i+'].cropType" id="cropType'+i+'"   class="form-control"  ></select></div></div>'
                   +'<div class="col-lg-3"><div class="form-group"><input oncopy="return false" onpaste="return false" maxlength="50" path="cropdetailsForm['+i+'].cropName" name="cropdetailsForm['+i+'].cropName"   class="form-control" value="'+cropDetailsForm[i].cropName+'"   /></div></div>'
                   +'<div class="col-lg-2"><div class="form-group"><input oncopy="return false" onpaste="return false" maxlength="10" path="cropdetailsForm['+i+'].cropArea" name="cropdetailsForm['+i+'].cropArea"   class="form-control floatEntry" onKeyPress="return floatCheck(event)" value="'+cropDetailsForm[i].cropArea+'" /></div></div>'
                   +'<div class="col-lg-2"><div class="form-group"><input oncopy="return false" onpaste="return false" maxlength="10" path="cropdetailsForm['+i+'].cropProduction" name="cropdetailsForm['+i+'].cropProduction"   class="form-control floatEntry" onKeyPress="return floatCheck(event)" value="'+cropDetailsForm[i].cropProduction+'"/></div></div>'
                   +'<div class="col-lg-3"><div class="form-group"><input oncopy="return false" onpaste="return false" maxlength="10" path="cropdetailsForm['+i+'].cropMarketing" name="cropdetailsForm['+i+'].cropMarketing"   class="form-control floatEntry" onKeyPress="return floatCheck(event)" value="'+cropDetailsForm[i].cropMarketing+'"/></div></div>'
                   +'</div>'
           	addCropDetails++;
            $("#addRowCropDetails").append(row);
            getCropType(i, cropDetailsForm[i].cropType);

        }
    }
}

function fillFutureCropFormData(futureCropDetailsForm)
{
    for(let i in futureCropDetailsForm)
    {
        if( i == 0)
        {
            document.getElementById("futureCropDetailsForm[0].cropName").value = futureCropDetailsForm[0].cropName;
            document.getElementById("futureCropDetailsForm[0].cropArea").value = futureCropDetailsForm[0].cropArea;
            document.getElementById("futureCropTypeTable").value = futureCropDetailsForm[0].cropType;
        }
        else{
           	var row ='<div class="row " id="futureCropId'+i+'">'
                   +'<div class="col-lg-2"><div class="form-group"><select path="futureCropDetailsForm['+i+'].cropType" name="futureCropDetailsForm['+i+'].cropType" id="futureCropType'+i+'"   class="form-control"  ></select></div></div>'
                   +'<div class="col-lg-3"><div class="form-group"><input oncopy="return false" onpaste="return false" maxlength="50" path="futureCropDetailsForm['+i+'].cropName" name="futureCropDetailsForm['+i+'].cropName"   class="form-control" value="'+futureCropDetailsForm[i].cropName+'"   /></div></div>'
                   +'<div class="col-lg-2"><div class="form-group"><input oncopy="return false" onpaste="return false" maxlength="10" path="futureCropDetailsForm['+i+'].cropArea" name="futureCropDetailsForm['+i+'].cropArea"   class="form-control floatEntry" onKeyPress="return floatCheck(event)" value="'+futureCropDetailsForm[i].cropArea+'" /></div></div>'
                   +'</div>'
           	addFutureCropDetails++;
            $("#addRowFutureCropDetails").append(row);
            getFutureCropType(i, futureCropDetailsForm[i].cropType);

        }
    }
}

//getBlocks
function getBlocks(id,selected="") {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getBlocks",
        data: {
                    "id": id
                },
        success: function(data) {
             var json_ = JSON.parse(data);
                                    console.log(json_);
            var selectRole = $('#localBlock'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {

                selectRole.append('<option value="' + json_.RESPONSE[i].blockId +'" '+ (selected ==json_.RESPONSE[i].blockId? "selected": "" )+'  >' + json_.RESPONSE[i].blockName + '</option>')
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
             var json_ = JSON.parse(data);
                                    console.log(json_);
            var selectRole = $('#vlocalBlock'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].blockId + " >" + json_.RESPONSE[i].blockName + "</option>")
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
            var json_ = JSON.parse(data);
                                   console.log(json_);
            var selectRole = $('#localTehsil'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].tehsilId + " >" + json_.RESPONSE[i].tehsilName + "</option>")
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
            var json_ = JSON.parse(data);
                                   console.log(json_);
            var selectRole = $('#vlocalTehsil'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].tehsilId + " >" + json_.RESPONSE[i].tehsilName + "</option>")
            }

        },
        error: function(data) {
            console.log(data)
        }

    });
}

//getWardPanchayat
function getWardPanchayat(id, selected="") {

    $.ajax({
        type: "GET",
        url: formURL + "/ajax/getWardPanchayat",
        data: {
                    "id": id
                },
        success: function(data) {
             var json_ = JSON.parse(data);
                                    console.log(json_);
            var selectRole = $('#localgp'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append('<option value="' + json_.RESPONSE[i].gpId +'" ' + (selected ==json_.RESPONSE[i].gpId ? "selected": "" ) +' >' + json_.RESPONSE[i].gpName + '</option>')
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
             var json_ = JSON.parse(data);
                                    console.log(json_);
            var selectRole = $('#vlocalgp'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Please Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option value=" + json_.RESPONSE[i].gpId + " >" + json_.RESPONSE[i].gpName + "</option>")
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
             var json_ = JSON.parse(data);
                                    console.log(json_);
            var selectRole = $('#vendorType'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option  value=" + json_.RESPONSE[i].vendorCategoryId + " >" + json_.RESPONSE[i].vendorCategoryName + "</option>")


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
                 var json_ = JSON.parse(data);
                                        console.log(json_);
                var selectRole = $('#vendorType'); // the state select element
                selectRole.find('option').remove();
                selectRole.append("<option value=" + 0 + " >" + "---Select---" + "</option>")
                for (i = 0; i < json_.RESPONSE.length; i++) {
                    selectRole.append("<option  value=" + json_.RESPONSE[i].vendorCategoryId + " >" + json_.RESPONSE[i].vendorCategoryName + "</option>")


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
                 var json_ = JSON.parse(data);
                                        console.log(json_);
                var selectRole = $('#locationAvailable'); // the state select element
                selectRole.find('option').remove();

                for (i = 0; i < json_.RESPONSE.length; i++) {
                    selectRole.append("<option  value=" + json_.RESPONSE[i].areaId + " >" + json_.RESPONSE[i].areaName + "</option>")


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
                var json_ = JSON.parse(data);
                                       console.log(json_);
               var selectRole = $('#roles'); // the state select element
               selectRole.find('option').remove();
               for (i = 0; i < json_.RESPONSE.length; i++) {
                   selectRole.append("<option value=" + json_.RESPONSE[i].role_id + " >" + json_.RESPONSE[i].role_name + "</option>")
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
             var json_ = JSON.parse(data);
             console.log(json_);
            var selectRole = $('#district'); // the state select element
            selectRole.find('option').remove();
            selectRole.append("<option value=" + 0 + " >" + "---Select---" + "</option>")
            for (i = 0; i < json_.RESPONSE.length; i++) {
                selectRole.append("<option  value=" + json_.RESPONSE[i].districtId + " >" + json_.RESPONSE[i].districtName + "</option>")


            };

        },
        error: function(data) {
            console.log(data)
        }

    });
    }