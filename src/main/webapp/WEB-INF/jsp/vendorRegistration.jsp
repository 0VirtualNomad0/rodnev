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
      <div class="container grey_top_bar">
         <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.heading.one" /> </p>
      </div>
      <hr>





        <div class="row">
       <spring:bind path="aadhaarNumber">
                <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
                   <form:label path="aadhaarNumber"  for="aadhaarNumber"><spring:message code="form.aadhaarnumber" /></form:label>
                   <form:input type="text"  id="aadhaarNumber" required="required" oncopy="return false" onpaste="return false" onfocus="this.removeAttribute('readonly');" autocomplete="off" path="aadhaarNumber" maxlength="12" minlength="12"  class="form-control" onKeyPress="return isNumber(event)"  name="aadhaarNumber" ></form:input>
                   <form:errors  path="aadhaarNumber"></form:errors>
                </div>
             </spring:bind>
</div><br></hr>

  <div class="row">

         <spring:bind path="firstname">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="firstname" for="firstname"><spring:message code="form.username.first" /></form:label>
               <form:input id="firstname" type="text" onkeypress="return alpha(event)" oncopy="return false" onfocus="this.removeAttribute('readonly');" onpaste="return false" autocomplete="off" path="firstname" name="firstname" class="form-control"
                  autofocus="true"></form:input>
               <form:errors  path="firstname"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="lastname">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="lastname" for="lastname"><spring:message code="form.username.last" /></form:label>
               <form:input id="lastname" type="text" onkeypress="return alpha(event)" oncopy="return false" onfocus="this.removeAttribute('readonly');" onpaste="return false" autocomplete="off"  path="lastname" name="lastname" class="form-control"
                  autofocus="true"></form:input>
               <form:errors  path="lastname"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="gender">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="gender" for="gender"><spring:message code="form.gender" /></form:label>
               <form:select path="gender"  name="gender" class="form-control" id="gender">
               </form:select>
               <form:errors  path="gender"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="mobileNumber">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="mobileNumber"  for="mobileNumber"><spring:message code="form.mobile" /></form:label>
               <form:input type="text"  id="mobileNumber" required="required" oncopy="return false" onpaste="return false" onfocus="this.removeAttribute('readonly');" autocomplete="off" path="mobileNumber" maxlength="10" minlength="10"  class="form-control" onKeyPress="return isNumber(event)"  name="mobileNumber" ></form:input>
               <form:errors  path="mobileNumber"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="age">
            <div class="form-group col-lg-4  ${status.error ? 'has-error' : ''}">
               <form:label path="age" for="age"><spring:message code="form.age" /></form:label>
               <form:input type="text" id="age" required="required" oncopy="return false" onpaste="return false" path="age" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="2" minlength="2"  class="form-control" onKeyPress="return isNumber(event)"  name="age"  ></form:input>
               <form:errors  path="age"></form:errors>
            </div>
         </spring:bind>


      </div>
      <!-- Address (Local) -->
      <br>
      <div class="container grey_top_bar">
         <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.heading.two" /> </p>
      </div>
      <hr>
      <div class="row">
         <spring:bind path="state">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="state" for="state"><spring:message code="form.local.state" /></form:label>
               <form:select path="state"  name="state" class="form-control" id="state">
               </form:select>
               <form:errors  path="state"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="localDistrict">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="localDistrict" for="localDistrict"><spring:message code="form.local.district" /></form:label>
               <form:select path="localDistrict"  name="localDistrict" class="form-control" id="localDistrict" onchange="getBlocks(this.value);">
               </form:select>
               <form:errors  path="localDistrict"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="localBlock">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="localBlock" for="localBlock"><spring:message code="form.local.block" /></form:label>
               <form:select path="localBlock" onchange="getWardPanchayat(this.value);"  name="localBlock" class="form-control" id="localBlock">
               </form:select>
               <form:errors  path="localBlock"></form:errors>
            </div>
         </spring:bind>
        <!-- <spring:bind path="localTehsil">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="localTehsil" for="localTehsil"><spring:message code="form.local.tehsil" /></form:label>
               <form:select path="localTehsil"  name="localTehsil" class="form-control" id="localTehsil">
               </form:select>
               <form:errors  path="localTehsil"></form:errors>
            </div>
         </spring:bind> -->
         <spring:bind path="localgp">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="localgp" for="localgp"><spring:message code="form.local.grampanchayat" /></form:label>
               <form:select path="localgp"  name="localgp" class="form-control" id="localgp">
               </form:select>
               <form:errors  path="localgp"></form:errors>
            </div>
         </spring:bind>

          <spring:bind path="villageName">
                     <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
                        <form:label path="villageName" for="villageName"><spring:message code="form.villageName" /></form:label>
                        <form:input id="villageName" type="text" onkeypress="return alpha(event)"  onfocus="this.removeAttribute('readonly');"  autocomplete="off" path="villageName" name="villageName" class="form-control"
                           autofocus="true"></form:input>
                        <form:errors  path="firstname"></form:errors>
                     </div>
                  </spring:bind>

         <spring:bind path="p_address">
            <div class="form-group  col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="p_address" for="p_address"><spring:message code="form.local.fulladdress" /></form:label>
               <form:textarea id="p_address" rows="4" type="text" autocomplete="off" onfocus="this.removeAttribute('readonly');"  required="required" oncopy="return false" onpaste="return false" path="p_address" maxlength="40" minlength="10"  class="form-control"  name="p_address"  />
               <form:errors  path="p_address"></form:errors>
            </div>
         </spring:bind>
      </div>
      <!-- Application Details -->
      <br>
      <hr>
      <div class="container grey_top_bar">
         <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.heading.three" /> </p>
      </div>
      <hr>
      <div class="row">
         <spring:bind path="vstate">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="vstate" for="state"><spring:message code="form.vending.state" /></form:label>
               <form:select path="vstate"  name="vstate" class="form-control" id="vstate">
               </form:select>
               <form:errors  path="vstate"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="vlocalDistrict">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="vlocalDistrict" for="vlocalDistrict"><spring:message code="form.vending.district" /></form:label>
               <form:select path="vlocalDistrict"  name="vlocalDistrict" class="form-control" id="vlocalDistrict" onchange="getvBlocks(this.value);">
               </form:select>
               <form:errors  path="vlocalDistrict"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="vlocalBlock">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="vlocalBlock" for="localBlock"><spring:message code="form.vending.block" /></form:label>
               <form:select path="vlocalBlock" onchange="getvWardPanchayat(this.value);"  name="localBlock" class="form-control" id="vlocalBlock">
               </form:select>
               <form:errors  path="vlocalBlock"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="vlocalTehsil">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="vlocalTehsil" for="vlocalTehsil"><spring:message code="form.vending.tehsil" /></form:label>
               <form:select path="vlocalTehsil"  name="vlocalTehsil" class="form-control" id="vlocalTehsil">
               </form:select>
               <form:errors  path="vlocalTehsil"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="vlocalgp">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="vlocalgp" for="vlocalgp"><spring:message code="form.vending.grampanchayat" /></form:label>
               <form:select path="vlocalgp"  name="vlocalgp" class="form-control" id="vlocalgp">
               </form:select>
               <form:errors  path="vlocalgp"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="loc_address">
            <div class="form-group  col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="loc_address" for="loc_address"><spring:message code="form.vending.fulladdress" /></form:label>
               <form:textarea id="loc_address" rows="4" type="text" autocomplete="off"  onfocus="this.removeAttribute('readonly');" required="required" oncopy="return false" onpaste="return false" path="loc_address" maxlength="40" minlength="10"  class="form-control"  name="loc_address"  />
               <form:errors  path="loc_address"></form:errors>
            </div>
         </spring:bind>
      </div>
      <!-- Vending Type -->
      <div class="container grey_top_bar">
         <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.heading.four" /> </p>
      </div>
      <hr>
      <div class="row">
         <spring:bind path="fromDate">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <label for="fromDate"><spring:message code="form.fromdate" /></label>
               <form:input maxlength="10"  path="fromDate" id="fromDate" autocomplete="off" onfocus="this.removeAttribute('readonly');" oncopy="return false" onpaste="return false" type="date" class="form-control input-sm" />
               <form:errors  style="color:red;" path="fromDate"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="toDate">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <label for="toDate">
               <spring:message code="form.todate" />
               </label>
               <form:input maxlength="10"  path="toDate" oncopy="return false" autocomplete="off" onfocus="this.removeAttribute('readonly');" onpaste="return false" id="toDate" type="date" onchange="calculateDays();" class="form-control input-sm" />
               <form:errors  style="color:red;" path="toDate"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="totalDays">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="totalDays"  for="totalDays"><spring:message code="form.totaldays" /></form:label>
               <form:input type="text"  id="totalDays" readonly="true" oncopy="return false" autocomplete="off" onfocus="this.removeAttribute('readonly');" onpaste="return false" path="totalDays"  class="form-control" onKeyPress="return isNumber(event)"  name="totalDays" ></form:input>
               <form:errors  path="totalDays"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="nationality">
            <div class="form-group col-lg-4">
               <form:label path="nationality" for="nationality"><spring:message code="form.nationality" /></form:label>
               <form:select  path="nationality" name="nationality"  class="form-control" id="nationality">
               </form:select>
               <form:errors  path="nationality"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="landType">
            <div class="form-group col-lg-4">
               <form:label path="landType" for="land_item"><spring:message code="form.purposeOfActivity" /></form:label>
               <form:select  path="landType"  class="form-control" onchange="changeValues();"  id="landType">
               </form:select>
               <form:errors  path="landType"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="vendor">
            <div class="form-group col-lg-4">
               <form:label path="vendor" ><spring:message code="form.category" /></form:label>
               <form:select  path="vendor" name="vendor" class="form-control" id="vendor" onchange="getVendorCategory(this.value);">
               </form:select>
               <form:errors  path="vendor"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="vendorType">
            <div class="form-group col-lg-4">
               <form:label path="vendorType" for="vendorType"><spring:message code="form.subcategory" /></form:label>
               <form:select  path="vendorType" name="vendorType" class="form-control"  id="vendorType" onchange="checkValue(this.value);">
               </form:select>
               <form:errors  path="vendorType"></form:errors>
            </div>
         </spring:bind>
         <div class="col-lg-4" style="display:none;" id="div_regional_nonregional">
            <spring:bind path="regional_national">
               <div class="form-group  ${status.error ? 'has-error' : ''}">
                  <form:label path="regional_national" for="regional_national"><spring:message code="form.national.regional" /></form:label>
                  <form:select path="regional_national" onchange="getItemsNR($('#landType').val(),$('#nationalRegional').val(),$('#vendor').val(),$('#vendorType').val(),'');"   class="form-control" id="nationalRegional">
                  </form:select>
                  <form:errors  path="regional_national"></form:errors>
               </div>
            </spring:bind>
         </div>
         <div class="col-lg-4" style="display:none;" id="non_tent_Items">
            <spring:bind path="item">
               <div class="form-group  ${status.error ? 'has-error' : ''}">
                  <form:label path="item" for="item"><spring:message code="form.item" /></form:label>
                  <form:select path="item"   class="form-control" id="item_non_tent">
                  </form:select>
                  <form:errors  path="item"></form:errors>
               </div>
            </spring:bind>
         </div>
         <div class="col-lg-4" style="display:none;" id="div_numberItems">
            <spring:bind path="numberItems">
               <div class="form-group  ${status.error ? 'has-error' : ''}">
                  <form:label path="numberItems" for="numberItems"><spring:message code="form.enterNumber" /></form:label>
                  <form:input type="text"  id="numberItems"  oncopy="return false" onpaste="return false" onfocus="this.removeAttribute('readonly');" autocomplete="off" path="numberItems" maxlength="3" class="form-control" onKeyPress="return isNumber(event)"  name="numberItems" ></form:input>
                  <form:errors  path="numberItems"></form:errors>
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
                     <spring:message code="form.tent.heading"/>
                  </strong>
                  <hr>
               </div>
               <div class="col-lg-3 ">
                  <br/>
                  <button type="button"  class="btn btn-success" data-style="slide-right" onclick="return addNewRow();" ><spring:message code="form.tent.add.row" /></button>
                  <button type="button"  class="btn btn-danger" data-style="slide-right" onclick="return deleteRow();" ><spring:message code="form.tent.delete.row" /></button>
               </div>
            </div>
            <div class="row" style="margin-top:10px">
               <spring:bind path="itemsForm[0].item">
                  <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
                     <form:label path="itemsForm[0].item" for="item"><spring:message code="form.tentType" /></form:label>
                     <form:select path="itemsForm[0].item"   class="form-control" id="item">
                     </form:select>
                     <form:errors  path="itemsForm[0].item"></form:errors>
                  </div>
               </spring:bind>
               <spring:bind path="itemsForm[0].item_number">
                  <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
                     <form:label path="itemsForm[0].item_number" for="itemsForm[0].item_number"><spring:message code="form.tentsNumber" /></form:label>
                     <form:input id="itemsForm[0].item_number" autocomplete="off" onfocus="this.removeAttribute('readonly');" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  path="itemsForm[0].item_number"  class="form-control"
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
      <div class="container grey_top_bar">
         <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.heading.five" /></p>
      </div>
      <hr>
      <div class="row">
         <spring:bind path="identityDoc">
            <div class="form-group col-lg-4">
               <form:label path="identityDoc" for="identityDoc" >
                  <spring:message code="form.identityDoc" />
               </form:label>
               <form:input class="form-control" oncopy="return false" onpaste="return false" type="file" path="identityDoc" id="identityDoc" name="identityDoc"/>
               <form:errors  path="identityDoc"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="photoDoc">
            <div class="form-group col-lg-4">
               <form:label path="photoDoc" for="photoDoc" >
                  <spring:message code="form.photo" />
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
                     <td><spring:message code="form.captcha" /></td>
                     <td>
                        <form:input  onkeypress="return alpha(event)" oncopy="return false"  autocomplete="off" onfocus="this.removeAttribute('readonly');" onpaste="return false" path="captcha" id="captcha" name="captcha" />
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/vendorApplicationForm.js"></script>
<script type="text/javascript">
   $( document ).ready(function() {

       getNationality();
       getLandType();
       getNationalRegional();
       getgender();
       getVendor();
       getState();
       getvState();
       getDistrictsViaState('9');
       getvDistrictsViaState('9');
       getrolesVendor()
   });

   var add= 0+${count+1};
   console.log(add);
   var status=0;

    function addNewRow()
   {
    getItemsTent($('#landType').val(),$('#nationalRegional').val(),$('#vendor').val(),$('#vendorType').val(),add);
   	var row ='<div class="row " id="id'+add+'">'
    +'<div class="col-lg-4"><div class="form-group"><select path="itemsForm['+add+'].item" name="itemsForm['+add+'].item" id="item'+add+'"   class="form-control"  ></select></div></div>'
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

                            document.getElementById("totalDays").value = result+1;



   }

   function changeValues(){
      getVendor();
      document.getElementById("tableDiv_tent").style.display = "none";
   }


</script>