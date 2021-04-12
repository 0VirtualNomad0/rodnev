<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/vendor/script.js"></script>

<div class="content-wrapper" style="background-color:#FFFFFF;">
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
      <h2 class="form-signin-heading col-lg-12"><strong>User Details</strong></h2>
      <br>
      <div class="form-group col-lg-4">
         <label >First Name</label>
         <input type="text" onkeypress="return alpha(event)" autocomplete="off" onfocus="this.removeAttribute('readonly');" oncopy="return false" onpaste="return false" value="${user.firstName}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Last Name</label>
         <input type="text" onkeypress="return alpha(event)" autocomplete="off" onfocus="this.removeAttribute('readonly');" oncopy="return false" onpaste="return false" value="${user.lastName}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >User Name</label>
         <input type="text" onkeypress="return alpha(event)" autocomplete="off" onfocus="this.removeAttribute('readonly');" oncopy="return false" onpaste="return false" value="${user.username}"  readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Mobile Number</label>
         <input type="text" onkeypress="return alpha(event)" autocomplete="off" onfocus="this.removeAttribute('readonly');" oncopy="return false" onpaste="return false"  value="${user.mobileNumber}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Age</label>
         <input type="text" onkeypress="return alpha(event)" autocomplete="off" onfocus="this.removeAttribute('readonly');" oncopy="return false" onpaste="return false" value="${user.age}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Email</label>
         <input type="text" onkeypress="return alpha(event)" autocomplete="off" onfocus="this.removeAttribute('readonly');" oncopy="return false" onpaste="return false" value="${user.email}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Gender</label>
         <input type="text" onkeypress="return alpha(event)" autocomplete="off" onfocus="this.removeAttribute('readonly');" oncopy="return false" onpaste="return false"  readonly value="${user.genderID.genderName}" class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Permanent Address</label>
         <textarea rows="4" type="text" onkeypress="return alpha(event)" autocomplete="off" onfocus="this.removeAttribute('readonly');"  oncopy="return false" onpaste="return false" value="${user.pAddress}" readonly  class="form-control"
            autofocus="true">${user.pAddress}</textarea>
      </div>
      <div class="form-group col-lg-4">
         <label >Correspondence Address</label>
         <textarea rows="4" type="text" onkeypress="return alpha(event)" autocomplete="off" onfocus="this.removeAttribute('readonly');" oncopy="return false" onpaste="return false" value="${user.cAddress}" readonly  class="form-control"
            autofocus="true">${user.cAddress}</textarea>
      </div>
   </div>
   <!-- Form Row -->
    <form:form method="POST" onsubmit="return submit_form()" id="vendor-form" modelAttribute="vendorApplicationForm" enctype="multipart/form-data" action="${pageContext.request.contextPath}/saveapplication" class="form-signin">

   <div class="row">
      <hr>
      <h2 class="form-signin-heading col-lg-12" style="background-color:#F2F2F2; padding:10px;"><strong>Application Form</strong></h2>
      <hr>
      <br>
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
               <form:input  path="tentNumber" autocomplete="off" onfocus="this.removeAttribute('readonly');" name="tentNumber" type="text" onKeyPress="return isNumber(event)" maxlength="3"  class="form-control" id="tentNumber" />

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
         Identity Document *
         </form:label>
         <form:input class="form-control" oncopy="return false" onpaste="return false" type="file" path="identityDoc" id="identityDoc" name="identityDoc"/>
        <form:errors  path="identityDoc"></form:errors>
      </div>
      </spring:bind>

       <spring:bind path="comments">
      <div class="form-group col-lg-4">
         <form:label path="comments">Vendor Comments</form:label>
         <form:textarea  path="comments" rows="4" id="comments" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"    class="form-control"
            autofocus="true" />
             <form:errors  path="comments"></form:errors>
      </div>
      </spring:bind>
   </div>
   <div class="form-group col-lg-12">
      <button class="btn btn-info btn-block" type="submit">Submit</button>
      <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
      <c:remove var="successMessage" scope="session" />
   </div>
</div>
</form:form>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/vendorApplicationForm.js"></script>
<script>
   $( document ).ready(function() {
         getNationality();
         getVendor();
         getDistrict();
     });

</script>