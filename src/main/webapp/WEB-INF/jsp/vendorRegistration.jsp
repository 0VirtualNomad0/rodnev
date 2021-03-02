<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/vendor/auth-light.css">
<div class="container" >
   <form:form method="POST" onsubmit="return submit_form()" id="register-form" modelAttribute="vendorApplicationForm" enctype="multipart/form-data" action="${pageContext.request.contextPath}/saveapplication" class="form-signin">
      <c:if test="${not empty successMessage}">
         <div id="serverError" class="alert alert-success alert-dismissable fade show successMessage">
            <button class="close" data-dismiss="alert" aria-label="Close">?</button>
            <strong>Success!</strong> ${successMessage}
         </div>
      </c:if>
      <br>
      <c:if test="${not empty serverError}">
         <div id="serverError" class="alert alert-warning alert-dismissable fade show plErroMessage">
            <button class="close" data-dismiss="alert" aria-label="Close">?</button>
            <strong>Warning!</strong> ${serverError}
         </div>
      </c:if>
      <h4 class="login-title col-lg-12 text-left" style="background-color:#FFFFFF"> <strong> Vendor Details</strong></h4>
      <hr>
      <div class="row">
         <spring:bind path="firstname">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="firstname" for="firstname">First Name</form:label>
               <form:input id="firstname" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  path="firstname" name="firstname" class="form-control"
                  autofocus="true"></form:input>
               <form:errors  path="firstname"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="lastname">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="lastname" for="lastname">Last Name</form:label>
               <form:input id="lastname" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  path="lastname" name="lastname" class="form-control"
                  autofocus="true"></form:input>
               <form:errors  path="lastname"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="gender">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="gender" for="gender">Select Gender</form:label>
               <form:select path="gender"  name="gender" class="form-control" id="gender">
               </form:select>
               <form:errors  path="gender"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="mobileNumber">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="mobileNumber"  for="mobileNumber">Mobile Number</form:label>
               <form:input type="text"  id="mobileNumber" required="required" oncopy="return false" onpaste="return false" path="mobileNumber" maxlength="10" minlength="10"  class="form-control" onKeyPress="return isNumber(event)"  name="mobileNumber" ></form:input>
               <form:errors  path="mobileNumber"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="age">
            <div class="form-group col-lg-4  ${status.error ? 'has-error' : ''}">
               <form:label path="age" for="age">Age</form:label>
               <form:input type="text" id="age" required="required" oncopy="return false" onpaste="return false" path="age" maxlength="2" minlength="2"  class="form-control" onKeyPress="return isNumber(event)"  name="age"  ></form:input>
               <form:errors  path="age"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="emailAddress">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="emailAddress" for="emailAddress">Email</form:label>
               <form:input type="text"  id="emailAddress" required="required" oncopy="return false" onpaste="return false" path="emailAddress" maxlength="40" minlength="10"  class="form-control"  name="emailAddress"  ></form:input>
               <form:errors  path="emailAddress"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="roleId">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}" style="display:none;">
               <form:label path="roleId" for="roles">User Type</form:label>
               <form:select  path="roleId" name="roleId" class="form-control" id="roles">
               </form:select>
               <form:errors  path="roleId"></form:errors>
            </div>
         </spring:bind>
      </div>
      <!-- Address (Local) -->
      <br>
      <h4 class="login-title col-lg-12 text-left" style="background-color:#FFFFFF"> <strong>Vendor Local Address</strong></h4>
      <hr>
      <div class="row">
         <spring:bind path="state">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="state" for="state">State</form:label>
               <form:select path="state"  name="state" class="form-control" id="state">
               </form:select>
               <form:errors  path="state"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="localDistrict">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="localDistrict" for="localDistrict">District</form:label>
               <form:select path="localDistrict"  name="localDistrict" class="form-control" id="localDistrict" onchange="getBlocks(this.value);getTehsils(this.value);">
               </form:select>
               <form:errors  path="localDistrict"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="localBlock">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="localBlock" for="localBlock">Block/Town</form:label>
               <form:select path="localBlock" onchange="getWardPanchayat(this.value);"  name="localBlock" class="form-control" id="localBlock">
               </form:select>
               <form:errors  path="localBlock"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="localTehsil">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="localTehsil" for="localTehsil">Tehsil</form:label>
               <form:select path="localTehsil"  name="localTehsil" class="form-control" id="localTehsil">
               </form:select>
               <form:errors  path="localTehsil"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="localgp">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="localgp" for="localgp">Panchayat/Wards</form:label>
               <form:select path="localgp"  name="localgp" class="form-control" id="localgp">
               </form:select>
               <form:errors  path="localgp"></form:errors>
            </div>
         </spring:bind>
         <div class="col-lg-4">&nbsp;</div>
         <spring:bind path="p_address">
            <div class="form-group  col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="p_address" for="p_address">Full Address (House Number/Street/Landmark/Village names etc)</form:label>
               <form:textarea id="p_address" rows="4" type="text"  required="required" oncopy="return false" onpaste="return false" path="p_address" maxlength="40" minlength="10"  class="form-control"  name="p_address"  />
               <form:errors  path="p_address"></form:errors>
            </div>
         </spring:bind>
      </div>
      <!-- Application Details -->
      <br>
      <hr>
      <h4 class="login-title col-lg-12 text-left" style="background-color:#FFFFFF"> <strong> Vendor Application Details</strong></h4>
      <hr>
      <div class="row">
         <h4 class="login-title col-lg-12 text-left" style="background-color:#FFFFFF"> <strong> Vending Location</strong></h4>
         <spring:bind path="vstate">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="vstate" for="state">State</form:label>
               <form:select path="vstate"  name="vstate" class="form-control" id="vstate">
               </form:select>
               <form:errors  path="vstate"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="vlocalDistrict">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="vlocalDistrict" for="vlocalDistrict">District</form:label>
               <form:select path="vlocalDistrict"  name="vlocalDistrict" class="form-control" id="vlocalDistrict" onchange="getvBlocks(this.value);getvTehsils(this.value);">
               </form:select>
               <form:errors  path="vlocalDistrict"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="vlocalBlock">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="vlocalBlock" for="localBlock">Block/Town</form:label>
               <form:select path="vlocalBlock" onchange="getvWardPanchayat(this.value);"  name="localBlock" class="form-control" id="vlocalBlock">
               </form:select>
               <form:errors  path="vlocalBlock"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="vlocalTehsil">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="vlocalTehsil" for="vlocalTehsil">Tehsil</form:label>
               <form:select path="vlocalTehsil"  name="vlocalTehsil" class="form-control" id="vlocalTehsil">
               </form:select>
               <form:errors  path="vlocalTehsil"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="vlocalgp">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="vlocalgp" for="vlocalgp">Panchayat/Wards</form:label>
               <form:select path="vlocalgp"  name="vlocalgp" class="form-control" id="vlocalgp">
               </form:select>
               <form:errors  path="vlocalgp"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="loc_address">
            <div class="form-group  col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="loc_address" for="loc_address">Enter Location</form:label>
               <form:textarea id="loc_address" rows="4" type="text"  required="required" oncopy="return false" onpaste="return false" path="loc_address" maxlength="40" minlength="10"  class="form-control"  name="loc_address"  />
               <form:errors  path="loc_address"></form:errors>
            </div>
         </spring:bind>
      </div>
      <!-- Vending Type -->
      <div class="row">
         <h4 class="login-title col-lg-12 text-left" style="background-color:#FFFFFF"> <strong>Vending Details (Category, Sub Category and Time )</strong></h4>
         <spring:bind path="fromDate">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <label for="fromDate">
               Select From Date
               </label>
               <form:input maxlength="10"  path="fromDate" id="fromDate" oncopy="return false" onpaste="return false" type="date" class="form-control input-sm" />
               <form:errors  style="color:red;" path="fromDate"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="toDate">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <label for="toDate">
               Select To Date
               </label>
               <form:input maxlength="10"  path="toDate" oncopy="return false" onpaste="return false" id="toDate" type="date" onchange="calculateDays();" class="form-control input-sm" />
               <form:errors  style="color:red;" path="toDate"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="totalDays">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="totalDays"  for="totalDays">Total Number of Days</form:label>
               <form:input type="text"  id="totalDays" readonly="true" oncopy="return false" onpaste="return false" path="mobileNumber"  class="form-control" onKeyPress="return isNumber(event)"  name="totalDays" ></form:input>
               <form:errors  path="totalDays"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="nationality">
            <div class="form-group col-lg-4">
               <form:label path="nationality" for="nationality">Nationality</form:label>
               <form:select  path="nationality" name="nationality" class="form-control" id="nationality">
               </form:select>
               <form:errors  path="nationality"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="landType">
            <div class="form-group col-lg-4">
               <form:label path="landType" for="land_item">Purpose of Activity</form:label>
               <form:select  path="landType"  class="form-control"  id="landType">
               </form:select>
               <form:errors  path="landType"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="regional_national">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="regional_national" for="regional_national">Regional/National</form:label>
               <form:select path="regional_national"   class="form-control" id="nationalRegional">
               </form:select>
               <form:errors  path="regional_national"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="vendor">
            <div class="form-group col-lg-4">
               <form:label path="vendor" >Vendor Category</form:label>
               <form:select  path="vendor" name="vendor" class="form-control" id="vendor" onchange="getVendorCategory(this.value);">
               </form:select>
               <form:errors  path="vendor"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="vendorType">
            <div class="form-group col-lg-4">
               <form:label path="vendorType" for="vendorType">Vending Sub Category</form:label>
               <form:select  path="vendorType" name="vendorType" class="form-control"  id="vendorType" onchange="checkValue(this.value);">
               </form:select>
               <form:errors  path="vendorType"></form:errors>
            </div>
         </spring:bind>
         <div class="col-lg-4" style="display:none;" id="non_tent_Items">
            <spring:bind path="item">
               <div class="form-group  ${status.error ? 'has-error' : ''}">
                  <form:label path="item" for="item">Select Item</form:label>
                  <form:select path="item"   class="form-control" id="item_non_tent">
                  </form:select>
                  <form:errors  path="item"></form:errors>
               </div>
            </spring:bind>
         </div>
      </div>
      <div class="row">
         <!-- tableDiv -->
         <div id="tableDiv_tent" class="col-lg-12" style="display:none">
            <div class="row" style="margin-bottom:10px;">
               <div class="col-lg-9">
                  <hr>
                  <strong>
                     <spring:message code="from.give.details.all.the.services.availed" text="Please Provide Tent Details : -" />
                  </strong>
                  <hr>
               </div>
               <div class="col-lg-3 ">
                  <br/>
                  <button type="button"  class="btn btn-success" data-style="slide-right" onclick="return addNewRow();" >Add Row</button>
                  <button type="button"  class="btn btn-danger" data-style="slide-right" onclick="return deleteRow();" >Delete Row</button>
               </div>
            </div>
            <div class="row" style="margin-top:10px">
               <spring:bind path="itemsForm[0].item">
                  <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
                     <form:label path="itemsForm[0].item" for="item">Select Type of Tents</form:label>
                     <form:select path="itemsForm[0].item"   class="form-control" id="item">
                     </form:select>
                     <form:errors  path="itemsForm[0].item"></form:errors>
                  </div>
               </spring:bind>
               <spring:bind path="itemsForm[0].item_number">
                  <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
                     <form:label path="itemsForm[0].item_number" for="itemsForm[0].item_number">Enter Number of Tents</form:label>
                     <form:input id="itemsForm[0].item_number" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  path="itemsForm[0].item_number"  class="form-control"
                        autofocus="true"></form:input>
                     <form:errors  path="itemsForm[0].item_number"></form:errors>
                  </div>
               </spring:bind>
               <div id="addRow" class="col-lg-12">
               </div>
            </div>
         </div>
      </div>
      <br>
      <div class="row">
         <h4 class="login-title col-lg-12 text-left" style="background-color:#FFFFFF"> <strong> Documents </strong></h4>
         <spring:bind path="identityDoc">
            <div class="form-group col-lg-4">
               <form:label path="identityDoc" for="identityDoc" >
                  Identity Proof *
               </form:label>
               <form:input class="form-control" oncopy="return false" onpaste="return false" type="file" path="identityDoc" id="identityDoc" name="identityDoc"/>
               <form:errors  path="identityDoc"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="photoDoc">
            <div class="form-group col-lg-4">
               <form:label path="photoDoc" for="photoDoc" >
                  Vendor Photograph *
               </form:label>
               <form:input class="form-control" oncopy="return false" onpaste="return false" type="file" path="photoDoc" id="photoDoc" name="photoDoc"/>
               <form:errors  path="photoDoc"></form:errors>
            </div>
         </spring:bind>
      </div>
      <div class="row breadcrumb" style="margin-bottom:10px;">
         <div class="form-group">
            <!-- Captcha -->
            <table >
               <tbody>
                  <tr>
                     <td>
                        <div>
                           <img id="captcha_id" name="imgCaptcha" src="captcha.jpg">
                        </div>
                     </td>
                     <td align="left"><a href="javascript:;"
                        title="change captcha text"
                        onclick="document.getElementById('captcha_id').src = 'captcha.jpg?' + Math.random();  return false">
                        <i class="fa fa-refresh"></i>
                        </a>
                     </td>
                  </tr>
                  <tr>
                     <td>Enter Image Text</td>
                     <td>
                        <form:input  onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" path="captcha" id="captcha" name="captcha" />
                     </td>
                     <form:errors style="color:red;" path="captcha"></form:errors>
                  </tr>
               </tbody>
            </table>
            <!-- Captcha -->
         </div>
         <div class="form-group col-lg-12">
            <button class="btn btn-success btn-block" type="submit">Submit</button>
            <c:remove var="successMessage" scope="session" />
         </div>
      </div>
   </form:form>
</div>
<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/vendor/script.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/registration.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/vendorApplicationForm.js"></script>
<script type="text/javascript">
   $( document ).ready(function() {
       getrolesVendor();
       getNationality();
       getLandType();
       getNationalRegional();
       getgender();
       getVendor();
       getState();
       getvState();
       getDistrictsViaState('9');
       getvDistrictsViaState('9');
   });

   var add= 0+${count+1};
   console.log(add);
   var status=0;

    function addNewRow()
   {
    getItems($('#nationality').val(),$('#landType').val(),$('#nationalRegional').val(),$('#vendor').val(),$('#vendorType').val(),add);
   	var row ='<div class="row " id="id'+add+'">'
    +'<div class="col-lg-4"><div class="form-group"><select path="itemsForm['+add+'].item" name="itemsForm['+add+'].item" id="item'+add+'"   class="form-control" placeholder="District"  onchange="gethalipadLocationadd(this.value ,'+add+')" ></select></div></div>'
    +'<div class="col-lg-4"><div class="form-group"><input oncopy="return false" onpaste="return false" maxlength="10" path="itemsForm['+add+'].item_number" name="itemsForm['+add+'].item_number"   class="form-control"   /></div></div>'

    +'</div>'

   	add++;
        $("#addRow").append(row);
        $('.bootstrap-select').selectpicker('render');
   }

   function deleteRow()
   {

   	if(add==0){
   		alert("Last Row can Not be deleted !!")
   	}else{

   		$("#id"+(add-1)).remove();
   		add--;
   	}
   }

   function calculateDays(){
   var from_date = document.getElementById("fromDate").value;
   var to_date = document.getElementById("toDate").value;

                  var date1 = new Date(from_date);
                  var date2 = new Date(to_date);

                  var time_difference = date2.getTime() - date1.getTime();
                           var result = time_difference / (1000 * 60 * 60 * 24);

                            document.getElementById("totalDays").value = result;



   }


</script>