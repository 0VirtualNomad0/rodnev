<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/vendor/auth-light.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/vendor/main.css">
<div class="row" style="background-color:#FFFFFF;margin-top:10px;">
   <br>
   <br>
   <div class="col-lg-6" > &nbsp;</div>
   <div class="col-lg-5" style="background-color:#F2F2F2;margin-left:10px;" >
      <form:form method="POST" onsubmit="return submit_form()" id="register-form" modelAttribute="registerUser" action="${pageContext.request.contextPath}/savevendor" class="form-signin">
         <h2 class="login-title"> <strong> Vendor Registration </strong></h2>
         <hr>
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
         <div class="row">
            <div class="col-6">
               <spring:bind path="firstname">
                  <div class="form-group  ${status.error ? 'has-error' : ''}">
                     <form:label path="firstname" for="firstname">First Name</form:label>
                     <form:input id="firstname" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  path="firstname" name="firstname" class="form-control"
                        autofocus="true"></form:input>
                     <form:errors  path="firstname"></form:errors>
                  </div>
               </spring:bind>
            </div>
            <div class="col-6">
               <spring:bind path="lastname">
                  <div class="form-group  ${status.error ? 'has-error' : ''}">
                     <form:label path="lastname" for="lastname">Last Name</form:label>
                     <form:input id="lastname" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  path="lastname" name="lastname" class="form-control"
                        autofocus="true"></form:input>
                     <form:errors  path="lastname"></form:errors>
                  </div>
               </spring:bind>
            </div>
         </div>
         <div class="form-group">
            <spring:bind path="username">
               <div class="form-group  ${status.error ? 'has-error' : ''}">
                  <form:label path="username" for="username">Username</form:label>
                  <form:input id="username" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  path="username" name="username" class="form-control"
                     autofocus="true"></form:input>
                  <form:errors  path="username"></form:errors>
               </div>
            </spring:bind>
         </div>
         <div class="row">
            <div class="col-6">
               <spring:bind path="mobileNumber">
                  <div class="form-group  ${status.error ? 'has-error' : ''}">
                     <form:label path="mobileNumber"  for="mobileNumber">Mobile Number</form:label>
                     <form:input type="text"  id="mobileNumber" required="required" oncopy="return false" onpaste="return false" path="mobileNumber" maxlength="10" minlength="10"  class="form-control" onKeyPress="return isNumber(event)"  name="mobileNumber" ></form:input>
                     <form:errors  path="mobileNumber"></form:errors>
                  </div>
               </spring:bind>
            </div>
            <div class="col-6">
               <spring:bind path="age">
                  <div class="form-group   ${status.error ? 'has-error' : ''}">
                     <form:label path="age" for="age">Age</form:label>
                     <form:input type="text" id="age" required="required" oncopy="return false" onpaste="return false" path="age" maxlength="2" minlength="2"  class="form-control" onKeyPress="return isNumber(event)"  name="age"  ></form:input>
                     <form:errors  path="age"></form:errors>
                  </div>
               </spring:bind>
            </div>
         </div>
         <div class="form-group">
            <spring:bind path="emailAddress">
               <div class="form-group ${status.error ? 'has-error' : ''}">
                  <form:label path="emailAddress" for="emailAddress">Email</form:label>
                  <form:input type="text"  id="emailAddress" required="required" oncopy="return false" onpaste="return false" path="emailAddress" maxlength="40" minlength="10"  class="form-control"  name="emailAddress"  ></form:input>
                  <form:errors  path="emailAddress"></form:errors>
               </div>
            </spring:bind>
         </div>
         <div class="form-group">
            <spring:bind path="gender">
               <div class="form-group  ${status.error ? 'has-error' : ''}">
                  <form:label path="gender" for="gender">Select Gender</form:label>
                  <form:select path="gender"  name="gender" class="form-control" id="gender">
                  </form:select>
                  <form:errors  path="gender"></form:errors>
               </div>
            </spring:bind>
         </div>
         <div class="row">
            <div class="col-6">
               <spring:bind path="p_address">
                  <div class="form-group   ${status.error ? 'has-error' : ''}">
                     <form:label path="p_address" for="p_address">Permanent Address</form:label>
                     <form:textarea id="p_address" rows="4" type="text"  required="required" oncopy="return false" onpaste="return false" path="p_address" maxlength="40" minlength="10"  class="form-control"  name="p_address"  />
                     <form:errors  path="p_address"></form:errors>
                  </div>
               </spring:bind>
            </div>
            <div class="col-6">
               <spring:bind path="c_address">
                  <div class="form-group ${status.error ? 'has-error' : ''}">
                     <form:label path="c_address" for="c_address">Correspondence Address</form:label>
                     <form:textarea id="c_address" type="text"  rows="4"   oncopy="return false" onpaste="return false" path="c_address" maxlength="40" minlength="10"  class="form-control"  name="c_address"  />
                     <form:errors  path="c_address"></form:errors>
                  </div>
               </spring:bind>
            </div>
         </div>
         <div class="form-group">
            <spring:bind path="roleId">
               <div class="form-group  ${status.error ? 'has-error' : ''}">
                  <form:label path="roleId" for="roles">User Type</form:label>
                  <form:select  path="roleId" name="roleId" class="form-control" id="roles">
                  </form:select>
                  <form:errors  path="roleId"></form:errors>
               </div>
            </spring:bind>
         </div>
         <div class="form-group">
            <spring:bind path="password">
               <div class="form-group ${status.error ? 'has-error' : ''}">
                  <form:label path="password" for="password">Password </form:label>
                  <form:input type="password" id="password" path="password" oncopy="return false" onpaste="return false" class="form-control" ></form:input>
                  <form:errors path="password"></form:errors>
               </div>
            </spring:bind>
         </div>
         <div class="form-group">
            <spring:bind path="passwordConfirm">
               <div class="form-group ${status.error ? 'has-error' : ''}">
                  <form:label path="passwordConfirm" for="passwordConfirm">Confirm Password</form:label>
                  <form:input type="password" id="passwordConfirm" oncopy="return false" onpaste="return false" path="passwordConfirm" class="form-control"
                     ></form:input>
                  <form:errors path="passwordConfirm"></form:errors>
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
         <div class="form-group">
            <button class="btn btn-info btn-block" type="submit">Sign up</button>
            <c:remove var="successMessage" scope="session" />
         </div>
         <div class="text-center">Already a member?
            <a class="color-blue" href="${pageContext.request.contextPath}/login">Login here</a>
         </div>
      </form:form>
   </div>
  <!-- <div class="col-lg-1" > &nbsp;</div>  -->
</div>
<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/vendor/script.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/registration.js"></script>
<script type="text/javascript">
   $( document ).ready(function() {
       getrolesVendor();
       getgender();
   });

</script>