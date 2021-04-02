<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<div class="row" style="padding=10px;">
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
      <label >Total number of days:- </label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.totalDays}"  readonly  class="form-control"
         autofocus="true"></input>
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
<!-- Application Item Details Start -->
<div class="row" style="padding:10px;">
<br>
<h2 class="form-signin-heading col-lg-12"><strong>Vending Details</strong></h2>
<hr>
<br>
<div class="col-lg-1"> &nbsp;  </div>
<table class="col-lg-10 table table-hover table-bordered">
   <thead>
      <tr>
         <th>S.No</th>
         <th>Category Name</th>
         <th>Sub Category </th>
         <th>Land Type</th>
         <th>Nationality</th>
         <th>Regional/National</th>
         <th>Items/Tent Number</th>
      </tr>
   </thead>
   <tbody>
      <c:if test="${not empty applicationData.app_items}">
         <c:forEach items="${applicationData.app_items}" var="application" varStatus="loopCounter">
            <tr>
               <td>
                  <c:out value="${loopCounter.count}"/>
               </td>
               <td>${application.item.category.categoryName}</td>
               <td>${application.item.subCategory.subCategoryName}</td>
               <td>${application.item.landType.landTypeName}</td>
               <td>${application.item.nationality.nationalityName}</td>
               <td>${application.item.nationalRegional.nationalRegionalName}</td>
               <c:if test="${application.tentNumber == 0}">
                  <td>${application.item.itemName}</td>
               </c:if>
               <c:if test="${application.tentNumber != 0}">
                  <td>${application.tentNumber}</td>
               </c:if>
               <!-- <td class="text-center" rowspan="${fn:length(user.app_items)}">${application.item.securityAmount}</td> -->
            </tr>
         </c:forEach>
      </c:if>
   </tbody>
</table>
<div class="col-lg-1"> &nbsp;  </div>
<br />
<!-- Application Item Details Ends -->
<!-- Row Transaction -->
<c:if test="${not empty transaction}">
   <br>
   <div class="row" style="padding:10px;">
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
<!-- Comments by DC, BDO and DFO -->
<!-- Comments by DC, BDO and DFO ENDS -->
<!-- Actions By DC,BDO and DFO -->

<!-- BDO Starts -->
<sec:authorize access="hasAuthority('BDO')">
   <!-- Check Weather the list is empty or not -->
   <c:if test="${empty applicationData.app_permissions}">
      <!-- No Permission Found  -->
      <!-- Give Permission -->
      <div class="col-lg-12">
         <h2 class="form-signin-heading col-lg-12"><strong>Actions BDO (Approve/Reject)</strong></h2>
         <br>
         <div class="col-lg-12">
            <form:form method="POST"  modelAttribute="actionForm" enctype="multipart/form-data"  action="${pageContext.request.contextPath}/updateActionApplication" class="form-signin">
               <spring:bind path="action">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:label  path="action" > Please Select any Action </form:label>
                     <form:select  path="action" class="form-control" id="earlierService">
                        <option value=""> --Select-- </option>
                        <option value="A"> Approve </option>
                        <option value="R"> Reject </option>
                     </form:select>
                     <form:errors  style="color:red;" path="action"></form:errors>
                  </div>
               </spring:bind>
               <spring:bind path="comments">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:label path="comments" for="comments"> Comments </form:label>
                     <form:textarea rows="4" path="comments" id="comments" class="form-control" onkeypress="return alpha(event)"  oncopy="return false" onpaste="return false" />
                  </div>
                  <form:errors  style="color:red;" path="comments"></form:errors>
               </spring:bind>
               <spring:bind path="attachment_if_any">
                  <div class="form-group col-lg-4">
                     <form:label path="attachment_if_any" for="attachment_if_any" >
                        Add Attachment (PDF) if any
                     </form:label>
                     <form:input class="form-control" oncopy="return false" onpaste="return false" type="file" path="attachment_if_any" id="attachment_if_any" name="attachment_if_any"/>
                     <form:errors  path="attachment_if_any"></form:errors>
                  </div>
               </spring:bind>
               <spring:bind path="user_role">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:input type="hidden" path="user_role" id="user_role" class="form-control"  value="BDO" />
                  </div>
                  <form:errors  style="color:red;" path="user_role"></form:errors>
               </spring:bind>
               <spring:bind path="app_id">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:input type="hidden" path="app_id" id="app_id" class="form-control"  value="${applicationData.appId}" />
                  </div>
                  <form:errors  style="color:red;" path="app_id"></form:errors>
               </spring:bind>
               <spring:bind path="user_id">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:input type="hidden" path="user_id" id="user_id" class="form-control"  value="${applicationData.userId.userId}" />
                  </div>
                  <form:errors  style="color:red;" path="user_id"></form:errors>
               </spring:bind>
               <spring:bind path="applicant_mobile">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:input type="hidden" path="applicant_mobile" id="applicant_mobile" class="form-control"  value="${applicationData.userId.mobileNumber}" />
                  </div>
                  <form:errors  style="color:red;" path="applicant_mobile"></form:errors>
               </spring:bind>
               <input type="submit"  value="Submit" class="btn btn-success col-lg-12">
               <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            </form:form>
         </div>
      </div>
   </c:if>
   <c:if test="${ not empty applicationData.app_permissions}">
      <!--  Permission Found We dont know what permission it is  -->
      <!-- If list not empty parse the list to check weather BDO is there or not -->
      <c:forEach items="${applicationData.app_permissions}" var="permissions" varStatus="loopCounter">
         <c:if test="${permissions.roleId == 'BDO'}" >
            <!-- Nothing to Show -->
            <div class="row" style="padding:10px;">
               <br>
               <h2 class="form-signin-heading col-lg-12"><strong>BDO Action:- </strong></h2>
               <br>
               <div class="form-group col-lg-4">
                  <label >Approved By:- </label>
                  <input type="text" onkeypress="return alpha(event)" oncopy="return true" onpaste="return false" value="${permissions.roleId}" readonly  class="form-control"
                     autofocus="true"></input>
               </div>
               <div class="form-group col-lg-4">
                  <label >Application Status</label>
                  <input type="text" onkeypress="return alpha(event)" oncopy="return true" onpaste="return false" value="${permissions.status}" readonly  class="form-control"
                     autofocus="true"></input>
               </div>
               <div class="form-group col-lg-4">
                  <label >Comments</label>
                  <input type="text" onkeypress="return alpha(event)" oncopy="return true" onpaste="return false"  value="${permissions.comments}" readonly  class="form-control"
                     autofocus="true"></input>
               </div>
               <div class="form-group col-lg-4">
                  <label>Approval Date</label>
                  <input type="text" onkeypress="return alpha(event)" style="color:red;" oncopy="return false" onpaste="return false"  value="<fmt:formatDate value='${permissions.createddate}' pattern='dd-MM-yyyy HH:mm:ss' />" readonly  class="form-control"
                     autofocus="true"></input>
               </div>
            </div>
         </c:if>
         <!-- Give Permission -->
         <c:if test="${permissions.roleId != 'BDO'}" >
            <!-- Nothing to Show -->
            <p> BDO NOT FOUND IN LIST</p>
            <!-- Give Permission -->
            <div class="col-lg-12">
               <h2 class="form-signin-heading col-lg-12"><strong>Actions BDO (Approve/Reject)</strong></h2>
               <br>
               <div class="col-lg-12">
                  <form:form method="POST"  modelAttribute="actionForm" enctype="multipart/form-data"  action="${pageContext.request.contextPath}/updateActionApplication" class="form-signin">
                     <spring:bind path="action">
                        <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                           <form:label  path="action" > Please Select any Action </form:label>
                           <form:select  path="action" class="form-control" id="earlierService">
                              <option value=""> --Select-- </option>
                              <option value="A"> Approve </option>
                              <option value="R"> Reject </option>
                           </form:select>
                           <form:errors  style="color:red;" path="action"></form:errors>
                        </div>
                     </spring:bind>
                     <spring:bind path="comments">
                        <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                           <form:label path="comments" for="comments"> Comments </form:label>
                           <form:textarea rows="4" path="comments" id="comments" class="form-control" onkeypress="return alpha(event)"  oncopy="return false" onpaste="return false" />
                        </div>
                        <form:errors  style="color:red;" path="comments"></form:errors>
                     </spring:bind>
                     <spring:bind path="attachment_if_any">
                        <div class="form-group col-lg-4">
                           <form:label path="attachment_if_any" for="attachment_if_any" >
                              Add Attachment (PDF) if any
                           </form:label>
                           <form:input class="form-control" oncopy="return false" onpaste="return false" type="file" path="attachment_if_any" id="attachment_if_any" name="attachment_if_any"/>
                           <form:errors  path="attachment_if_any"></form:errors>
                        </div>
                     </spring:bind>
                     <spring:bind path="user_role">
                        <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                           <form:input type="hidden" path="user_role" id="user_role" class="form-control"  value="BDO" />
                        </div>
                        <form:errors  style="color:red;" path="user_role"></form:errors>
                     </spring:bind>
                     <spring:bind path="app_id">
                        <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                           <form:input type="hidden" path="app_id" id="app_id" class="form-control"  value="${applicationData.appId}" />
                        </div>
                        <form:errors  style="color:red;" path="app_id"></form:errors>
                     </spring:bind>
                     <spring:bind path="user_id">
                        <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                           <form:input type="hidden" path="user_id" id="user_id" class="form-control"  value="${applicationData.userId.userId}" />
                        </div>
                        <form:errors  style="color:red;" path="user_id"></form:errors>
                     </spring:bind>
                     <spring:bind path="applicant_mobile">
                        <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                           <form:input type="hidden" path="applicant_mobile" id="applicant_mobile" class="form-control"  value="${applicationData.userId.mobileNumber}" />
                        </div>
                        <form:errors  style="color:red;" path="applicant_mobile"></form:errors>
                     </spring:bind>
                     <input type="submit"  value="Submit" class="btn btn-success col-lg-12">
                     <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                  </form:form>
               </div>
            </div>
         </c:if>
      </c:forEach>
   </c:if>
</sec:authorize>
<!-- BDO Ends -->



<!-- DFO Starts-->
<sec:authorize access="hasAuthority('DFO')">
   <!-- Check Weather the list is empty or not -->
   <c:if test="${empty applicationData.app_permissions}">
      <!-- No Permission Found  -->
      <!-- Give Permission -->
      <div class="col-lg-12">
         <h2 class="form-signin-heading col-lg-12"><strong>Actions DFO (Approve/Reject)</strong></h2>
         <br>
         <div class="col-lg-12">
            <form:form method="POST"  modelAttribute="actionForm" enctype="multipart/form-data"  action="${pageContext.request.contextPath}/updateActionApplication" class="form-signin">
               <spring:bind path="action">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:label  path="action" > Please Select any Action </form:label>
                     <form:select  path="action" class="form-control" id="earlierService">
                        <option value=""> --Select-- </option>
                        <option value="A"> Approve </option>
                        <option value="R"> Reject </option>
                     </form:select>
                     <form:errors  style="color:red;" path="action"></form:errors>
                  </div>
               </spring:bind>
               <spring:bind path="comments">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:label path="comments" for="comments"> Comments </form:label>
                     <form:textarea rows="4" path="comments" id="comments" class="form-control" onkeypress="return alpha(event)"  oncopy="return false" onpaste="return false" />
                  </div>
                  <form:errors  style="color:red;" path="comments"></form:errors>
               </spring:bind>
               <spring:bind path="attachment_if_any">
                  <div class="form-group col-lg-4">
                     <form:label path="attachment_if_any" for="attachment_if_any" >
                        Add Attachment (PDF) if any
                     </form:label>
                     <form:input class="form-control" oncopy="return false" onpaste="return false" type="file" path="attachment_if_any" id="attachment_if_any" name="attachment_if_any"/>
                     <form:errors  path="attachment_if_any"></form:errors>
                  </div>
               </spring:bind>
               <spring:bind path="user_role">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:input type="hidden" path="user_role" id="user_role" class="form-control"  value="DFO" />
                  </div>
                  <form:errors  style="color:red;" path="user_role"></form:errors>
               </spring:bind>
               <spring:bind path="app_id">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:input type="hidden" path="app_id" id="app_id" class="form-control"  value="${applicationData.appId}" />
                  </div>
                  <form:errors  style="color:red;" path="app_id"></form:errors>
               </spring:bind>
               <spring:bind path="user_id">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:input type="hidden" path="user_id" id="user_id" class="form-control"  value="${applicationData.userId.userId}" />
                  </div>
                  <form:errors  style="color:red;" path="user_id"></form:errors>
               </spring:bind>
               <spring:bind path="applicant_mobile">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:input type="hidden" path="applicant_mobile" id="applicant_mobile" class="form-control"  value="${applicationData.userId.mobileNumber}" />
                  </div>
                  <form:errors  style="color:red;" path="applicant_mobile"></form:errors>
               </spring:bind>
               <input type="submit"  value="Submit" class="btn btn-success col-lg-12">
               <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            </form:form>
         </div>
      </div>
   </c:if>
   <c:if test="${ not empty applicationData.app_permissions}">
      <!--  Permission Found We dont know what permission it is  -->
      <!-- If list not empty parse the list to check weather BDO is there or not -->
      <c:forEach items="${applicationData.app_permissions}" var="permissions" varStatus="loopCounter">
         <c:if test="${permissions.roleId == 'DFO'}" >
            <!-- Nothing to Show -->
            <div class="row" style="padding:10px;">
               <br>
               <h2 class="form-signin-heading col-lg-12"><strong>DFO Action:- </strong></h2>
               <br>
               <div class="form-group col-lg-4">
                  <label >Approved By:- </label>
                  <input type="text" onkeypress="return alpha(event)" oncopy="return true" onpaste="return false" value="${permissions.roleId}" readonly  class="form-control"
                     autofocus="true"></input>
               </div>
               <div class="form-group col-lg-4">
                  <label >Application Status</label>
                  <input type="text" onkeypress="return alpha(event)" oncopy="return true" onpaste="return false" value="${permissions.status}" readonly  class="form-control"
                     autofocus="true"></input>
               </div>
               <div class="form-group col-lg-4">
                  <label >Comments</label>
                  <input type="text" onkeypress="return alpha(event)" oncopy="return true" onpaste="return false"  value="${permissions.comments}" readonly  class="form-control"
                     autofocus="true"></input>
               </div>
               <div class="form-group col-lg-4">
                  <label>Approval Date</label>
                  <input type="text" onkeypress="return alpha(event)" style="color:red;" oncopy="return false" onpaste="return false"  value="<fmt:formatDate value='${permissions.createddate}' pattern='dd-MM-yyyy HH:mm:ss' />" readonly  class="form-control"
                     autofocus="true"></input>
               </div>
            </div>
         </c:if>
         <!-- Give Permission -->
         <c:if test="${permissions.roleId != 'DFO'}" >
            <!-- Nothing to Show -->
            <p> BDO NOT FOUND IN LIST</p>
            <!-- Give Permission -->
            <div class="col-lg-12">
               <h2 class="form-signin-heading col-lg-12"><strong>Actions BDO (Approve/Reject)</strong></h2>
               <br>
               <div class="col-lg-12">
                  <form:form method="POST"  modelAttribute="actionForm" enctype="multipart/form-data"  action="${pageContext.request.contextPath}/updateActionApplication" class="form-signin">
                     <spring:bind path="action">
                        <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                           <form:label  path="action" > Please Select any Action </form:label>
                           <form:select  path="action" class="form-control" id="earlierService">
                              <option value=""> --Select-- </option>
                              <option value="A"> Approve </option>
                              <option value="R"> Reject </option>
                           </form:select>
                           <form:errors  style="color:red;" path="action"></form:errors>
                        </div>
                     </spring:bind>
                     <spring:bind path="comments">
                        <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                           <form:label path="comments" for="comments"> Comments </form:label>
                           <form:textarea rows="4" path="comments" id="comments" class="form-control" onkeypress="return alpha(event)"  oncopy="return false" onpaste="return false" />
                        </div>
                        <form:errors  style="color:red;" path="comments"></form:errors>
                     </spring:bind>
                     <spring:bind path="attachment_if_any">
                        <div class="form-group col-lg-4">
                           <form:label path="attachment_if_any" for="attachment_if_any" >
                              Add Attachment (PDF) if any
                           </form:label>
                           <form:input class="form-control" oncopy="return false" onpaste="return false" type="file" path="attachment_if_any" id="attachment_if_any" name="attachment_if_any"/>
                           <form:errors  path="attachment_if_any"></form:errors>
                        </div>
                     </spring:bind>
                     <spring:bind path="user_role">
                        <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                           <form:input type="hidden" path="user_role" id="user_role" class="form-control"  value="DFO" />
                        </div>
                        <form:errors  style="color:red;" path="user_role"></form:errors>
                     </spring:bind>
                     <spring:bind path="app_id">
                        <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                           <form:input type="hidden" path="app_id" id="app_id" class="form-control"  value="${applicationData.appId}" />
                        </div>
                        <form:errors  style="color:red;" path="app_id"></form:errors>
                     </spring:bind>
                     <spring:bind path="user_id">
                        <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                           <form:input type="hidden" path="user_id" id="user_id" class="form-control"  value="${applicationData.userId.userId}" />
                        </div>
                        <form:errors  style="color:red;" path="user_id"></form:errors>
                     </spring:bind>
                     <spring:bind path="applicant_mobile">
                        <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                           <form:input type="hidden" path="applicant_mobile" id="applicant_mobile" class="form-control"  value="${applicationData.userId.mobileNumber}" />
                        </div>
                        <form:errors  style="color:red;" path="applicant_mobile"></form:errors>
                     </spring:bind>
                     <input type="submit"  value="Submit" class="btn btn-success col-lg-12">
                     <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                  </form:form>
               </div>
            </div>
         </c:if>
      </c:forEach>
   </c:if>
</sec:authorize>
<!-- DFO Ends -->


<!-- Actions by DC, BDO and DFO ENDS-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/vendorApplicationForm.js"></script>