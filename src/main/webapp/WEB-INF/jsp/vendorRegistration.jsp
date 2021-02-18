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
      <h2 class="login-title col-lg-12 text-left" style="background-color:#FFFFFF"> <strong> Vendor Details</strong></h2>
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
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="roleId" for="roles">User Type</form:label>
               <form:select  path="roleId" name="roleId" class="form-control" id="roles">
               </form:select>
               <form:errors  path="roleId"></form:errors>
            </div>
         </spring:bind>
      </div>
      <!-- Address (Local) -->
      <br>
      <h2 class="login-title col-lg-12 text-left" style="background-color:#FFFFFF"> <strong>Vendor Local Address</strong></h2>
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
      <h2 class="login-title col-lg-12 text-left" style="background-color:#FFFFFF"> <strong> Application Details</strong></h2>
      <hr>
      <div class="row">
         <spring:bind path="nationality">
            <div class="form-group col-lg-4">
               <form:label path="nationality" for="nationality">Nationality</form:label>
               <form:select  path="nationality" name="nationality" class="form-control" id="nationality">
               </form:select>
               <form:errors  path="nationality"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="vendor">
            <div class="form-group col-lg-4">
               <form:label path="vendor" for="nationality">Vendor Type</form:label>
               <form:select  path="vendor" name="vendor" class="form-control" id="vendor" onchange="getVendorCategory(this.value);">
               </form:select>
               <form:errors  path="vendor"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="vendorType">
            <div class="form-group col-lg-4">
               <form:label path="vendorType" for="vendorType">Vendor Category</form:label>
               <form:select  path="vendorType" name="vendorType" class="form-control" onchange="hideunhide(this.value);" id="vendorType">
               </form:select>
               <form:errors  path="vendorType"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="tentNumber">
            <div id="tentDiv" style="display:none;" class="form-group col-lg-4">
               <form:label path="tentNumber" for="tentNumber">Tent Number</form:label>
               <form:input  path="tentNumber" name="tentNumber" type="text" onKeyPress="return isNumber(event)" maxlength="3"  class="form-control" id="tentNumber" />
               <form:errors  path="tentNumber"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="district">
            <div class="form-group col-lg-4">
               <form:label path="district" for="district">Select Location</form:label>
               <form:select  path="district" name="district" class="form-control" id="district" onchange="getArea(this.value)">
               </form:select>
               <form:errors  path="district"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="locationAvailable">
            <div class="form-group col-lg-4">
               <form:label path="locationAvailable" for="locationAvailable">Select Area</form:label>
               <form:select multiple="multiple" data-live-search="true" path="locationAvailable" name="locationAvailable" class="form-control"  id="locationAvailable">
               </form:select>
               <form:errors  path="locationAvailable"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="identityDoc">
            <div class="form-group col-lg-4">
               <form:label path="identityDoc" for="identityDoc" >
                  Identity Proof *
               </form:label>
               <form:input class="form-control" oncopy="return false" onpaste="return false" type="file" path="identityDoc" id="identityDoc" name="identityDoc"/>
               <form:errors  path="identityDoc"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="comments">
            <div class="form-group col-lg-4">
               <form:label path="comments">Vendor Comments (if any)</form:label>
               <form:textarea  path="comments" rows="4" id="comments" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"    class="form-control"
                  autofocus="true" />
               <form:errors  path="comments"></form:errors>
            </div>
         </spring:bind>
      </div>
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
                     <form:input   onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" path="captcha" id="captcha" name="captcha" />
                  </td>
                  <form:errors style="color:red;" path="captcha"></form:errors>
               </tr>
            </tbody>
         </table>
         <!-- Captcha -->
      </div>
      <div class="form-group col-lg-12">
         <button class="btn btn-info btn-block" type="submit">Submit</button> <br>
         <c:remove var="successMessage" scope="session" />
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
       getDistrict();
       getgender();
       getVendor();
       getState();
       getDistrictsViaState('9');
   });

</script>