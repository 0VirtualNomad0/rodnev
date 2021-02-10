<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/vendor/script.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<div class="content-wrapper" style="background-color:#FFFFFF;">
   <h2 class="form-signin-heading">Vendor Application Form</h2>
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
      <h2 class="form-signin-heading col-lg-12"><strong>User Details</strong></h2>
      <br>
      <div class="form-group col-lg-4">
         <label >First Name</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${user.firstName}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Last Name</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${user.lastName}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >User Name</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${user.username}"  readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Mobile Number</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="${user.mobileNumber}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Age</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${user.age}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Email</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${user.email}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Gender</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="${user.genderID.genderName}" class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Permanent Address</label>
         <textarea rows="4" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${user.pAddress}" readonly  class="form-control"
            autofocus="true">${user.pAddress}</textarea>
      </div>
      <div class="form-group col-lg-4">
         <label >Correspondence Address</label>
         <textarea rows="4" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${user.cAddress}" readonly  class="form-control"
            autofocus="true">${user.cAddress}</textarea>
      </div>
   </div>
   <!-- Form Row -->
   <div class="row">
      <hr>
      <h2 class="form-signin-heading col-lg-12" style="background-color:#F2F2F2; padding:10px;"><strong>Application Form</strong></h2>
      <hr>
      <br>
      <div class="form-group col-lg-4">
         <label path="nationality" for="nationality">Nationality</label>
         <select  path="nationality" name="nationality" class="form-control" id="nationality">
         </select>
      </div>
      <div class="form-group col-lg-4">
         <label path="vendor" for="nationality">Vendor Type</label>
         <select  path="vendor" name="vendor" class="form-control" id="vendor" onchange="getVendorCategory(this.value);">
         </select>
      </div>
      <div class="form-group col-lg-4">
         <label path="vendorType" for="vendorType">Vendor Category</label>
         <select  path="vendorType" name="vendorType" class="form-control" id="vendorType">
         </select>
      </div>
   </div>
</div>

<script>

  $( document ).ready(function() {
        getNationality();
        getVendor();
    });

</script>