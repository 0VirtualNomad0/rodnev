<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.userId.firstName}" readonly  class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Last Name</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.userId.lastName}" readonly  class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >User Name</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.userId.username}"  readonly  class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Mobile Number</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="${applicationData.userId.mobileNumber}" readonly  class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Age</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.userId.age}" readonly  class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Email</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.userId.email}" readonly  class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Gender</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="${applicationData.userId.genderID.genderName}" class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >State</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="${applicationData.userId.state.stateName}" class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >District</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="${applicationData.userId.district.districtName}" class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Block</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="${applicationData.userId.block.districtName}" class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Tehsil</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="${applicationData.userId.tehsil.districtName}" class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Gram Panchayat</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="${applicationData.userId.grampanchayat.panchayatName}" class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Permanent Address</label>
      <textarea rows="4" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.userId.pAddress}" readonly  class="form-control"
         autofocus="true">${applicationData.userId.pAddress}</textarea>
   </div>

</div>
<!--  Row One Ends -->
<!-- Row Two Starts -->
<div class="row">
   <h2 class="form-signin-heading col-lg-12"><strong>Application Details (Vending Details)</strong></h2>
   <br>
   <div class="form-group col-lg-4">
         <label >State</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="${applicationData.userId.state.stateName}" class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >District</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="${applicationData.district.districtName}" class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Block</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="${applicationData.block.districtName}" class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Tehsil</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="${applicationData.tehsil.districtName}" class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Gram Panchayat</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="${applicationData.panchayat.panchayatName}" class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Vending Address</label>
         <textarea rows="4" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.vendingAddress}" readonly  class="form-control"
            autofocus="true">${applicationData.vendingAddress}</textarea>
      </div>
   <div class="form-group col-lg-4">
      <label >Nationality</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.nationalityEntity.nationalityName}" readonly  class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Vendor Type</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.category.categoryName}" readonly  class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Vendor Category</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.subcategory.subCategoryName}"  readonly  class="form-control"
         autofocus="true"></input>
   </div>
    <div class="form-group col-lg-4">
         <label >Purpose of Activity</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.purposeActivity.landTypeName}"  readonly  class="form-control"
            autofocus="true"></input>
      </div>

   <div class="form-group col-lg-4">
      <label >Attached Document <i class="fa fa-download" aria-hidden="true"></i></label>
      <a href="${pageContext.request.contextPath}/downloadFile/${applicationData.identityDoc}"><input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.identityDoc}" readonly  class="form-control"
         autofocus="true"></input></a>
   </div>
   <div class="form-group col-lg-4">
         <label >Photo of Vendor <i class="fa fa-download" aria-hidden="true"></i></label>
         <a href="${pageContext.request.contextPath}/downloadFile/${applicationData.photoDoc}"><input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.photoDoc}" readonly  class="form-control"
            autofocus="true"></input></a>
      </div>

<div class="form-group col-lg-4">
         <label >Defaulter (Fine)</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.fineDefaulter}"  readonly  class="form-control"
            autofocus="true"></input>
      </div>

      <div class="form-group col-lg-4">
               <label >Licence Withdrawn</label>
               <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.withdrawVenLicence}"  readonly  class="form-control"
                  autofocus="true"></input>
            </div>

   <div class="form-group col-lg-4">
      <label >Application Submitted Date</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="<fmt:formatDate value='${applicationData.createdDate}' pattern='dd-MM-yyyy HH:mm:ss' />" class="form-control" style="color:red;"
         autofocus="true"></input>
   </div>
</div>
<!-- Row Transaction -->
<c:if test="${not empty transaction}">
   <br>
   <div class="row">
      <h2 class="form-signin-heading col-lg-12"><strong>Payment Details</strong></h2>
      <br>
      <div class="form-group col-lg-4">
         <label >Payment Status</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return true" onpaste="return false" value="${transaction.paymentStatus}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Transaction Amount</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return true" onpaste="return false" value="${transaction.amount}/-"  readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Transaction Id</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return true" onpaste="return false" value="${transaction.transactionId}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >MIH Pay ID</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return true" onpaste="return false" value="${transaction.mihpayId}"  readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Payment Mode</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return true" onpaste="return false" value="${transaction.paymentMode}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Bank Reference Number</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return true" onpaste="return false"  value="${transaction.bankRefNumber}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label>Transaction Date</label>
         <input type="text" onkeypress="return alpha(event)" style="color:red;" oncopy="return false" onpaste="return false"  value="<fmt:formatDate value='${transaction.paymentdateresponse}' pattern='dd-MM-yyyy HH:mm:ss' />" readonly  class="form-control"
            autofocus="true"></input>
      </div>
   </div>
</c:if>
<!-- Row Transaction -->


<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/vendorApplicationForm.js"></script>