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
      <label >Permanent Address</label>
      <textarea rows="4" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.userId.pAddress}" readonly  class="form-control"
         autofocus="true">${applicationData.userId.pAddress}</textarea>
   </div>
   <div class="form-group col-lg-4">
      <label >Correspondence Address</label>
      <textarea rows="4" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.userId.cAddress}" readonly  class="form-control"
         autofocus="true">${applicationData.userId.cAddress}</textarea>
   </div>
</div>
<!--  Row One Ends -->
<!-- Row Two Starts -->
<div class="row">
   <h2 class="form-signin-heading col-lg-12"><strong>Application Details</strong></h2>
   <br>
   <div class="form-group col-lg-4">
      <label >Nationality</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.nationalityEntity.nationalityName}" readonly  class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Vendor Type</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.vendorId.venTypeName}" readonly  class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Vendor Category</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.vendorTypeId.vendorTypeName}"  readonly  class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Location</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.districtId.districtName}" readonly  class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Area</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="area not coming" readonly  class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Attached Document <i class="fa fa-download" aria-hidden="true"></i></label>
      <a href="${pageContext.request.contextPath}/downloadFile/${applicationData.identityDoc}"><input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.identityDoc}" readonly  class="form-control"
         autofocus="true"></input></a>
   </div>
   <div class="form-group col-lg-4">
      <label >Comments</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="${applicationData.vendorComments}" class="form-control"
         autofocus="true"></input>
   </div>
   <div class="form-group col-lg-4">
      <label >Application Submitted Date</label>
      <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="<fmt:formatDate value='${applicationData.createdDate}' pattern='dd-MM-yyyy HH:mm:ss' />" class="form-control" style="color:red;"
         autofocus="true"></input>
   </div>
</div>
<sec:authorize access="hasAnyAuthority('Admin','Super Admin','Vendor','BDO','DFO')">
   <c:if test="${applicationData.appActionDfo == 'A' || applicationData.appActionDfo == 'R'   || applicationData.appActionDfo == 'I' }">
      </br>
      <div class="row">
         <hr>
         <h2 class="form-signin-heading col-lg-12"><strong>DFO Action</strong></h2>
         <hr>
         <div class="form-group col-lg-4">
            <label >DFO Action</label>

            <c:if test="${applicationData.appActionDfo == 'A'}">
               <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="Approved" readonly  class="form-control"
                  autofocus="true"></input>
            </c:if>
            <c:if test="${applicationData.appActionDfo == 'I'}">
               <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="Incomplete" readonly  class="form-control"
                  autofocus="true"></input>
            </c:if>
            <c:if test="${applicationData.appActionDfo == 'P'}">
               <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="Pending" readonly  class="form-control"
                  autofocus="true"></input>
            </c:if>
            <c:if test="${applicationData.appActionDfo == 'R'}">
               <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="Rejected" readonly  class="form-control"
                  autofocus="true"></input>
            </c:if>
         </div>
         <div class="form-group col-lg-4">
            <label >DFO Comments</label>
            <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.dfoComments}" readonly  class="form-control"
               autofocus="true"></input>
         </div>
         <div class="form-group col-lg-4">
            <label >Date</label>
            <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="<fmt:formatDate value='${applicationData.appDfoDate}' pattern='dd-MM-yyyy HH:mm:ss' />" class="form-control" style="color:red;"
               autofocus="true"></input>
         </div>
      </div>
   </c:if>
   <c:if test="${applicationData.appActionBdo == 'A' || applicationData.appActionBdo == 'R'   || applicationData.appActionBdo == 'I' }">
      </br>
      <div class="row">
         <hr>
         <h2 class="form-signin-heading col-lg-12"><strong>BDO Action</strong></h2>
         <hr>
         <div class="form-group col-lg-4">
            <label >BDO Action</label>
            <c:if test="${applicationData.appActionBdo == 'A'}">
               <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="Approved" readonly  class="form-control"
                  autofocus="true"></input>
            </c:if>
            <c:if test="${applicationData.appActionBdo == 'I'}">
               <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="Incomplete" readonly  class="form-control"
                  autofocus="true"></input>
            </c:if>
            <c:if test="${applicationData.appActionBdo == 'P'}">
               <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="Pending" readonly  class="form-control"
                  autofocus="true"></input>
            </c:if>
            <c:if test="${applicationData.appActionBdo == 'R'}">
               <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="Rejected" readonly  class="form-control"
                  autofocus="true"></input>
            </c:if>
         </div>
         <div class="form-group col-lg-4">
            <label >BDO Comments</label>
            <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.bdoComments}" readonly  class="form-control"
               autofocus="true"></input>
         </div>
         <div class="form-group col-lg-4">
            <label >Date</label>
            <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="<fmt:formatDate value='${applicationData.appBdoDate}' pattern='dd-MM-yyyy HH:mm:ss' />" class="form-control" style="color:red;"
               autofocus="true"></input>
         </div>
      </div>
   </c:if>
   <c:if test="${applicationData.appActionDc == 'A' || applicationData.appActionDc == 'R'   || applicationData.appActionDc == 'I' }">
      </br>
      <div class="row">
         <hr>
         <h2 class="form-signin-heading col-lg-12"><strong>DC Action</strong></h2>
         <hr>
         <div class="form-group col-lg-4">
            <label >DC Action</label>
            <c:if test="${applicationData.appActionDc == 'A'}">
               <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="Approved" readonly  class="form-control"
                  autofocus="true"></input>
            </c:if>
            <c:if test="${applicationData.appActionDc == 'I'}">
               <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="Incomplete" readonly  class="form-control"
                  autofocus="true"></input>
            </c:if>
            <c:if test="${applicationData.appActionDc == 'R'}">
               <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="Rejected" readonly  class="form-control"
                  autofocus="true"></input>
            </c:if>
            <c:if test="${applicationData.appActionDc == 'P'}">
               <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="Pending" readonly  class="form-control"
                  autofocus="true"></input>
            </c:if>
         </div>
         <div class="form-group col-lg-4">
            <label >DC Comments</label>
            <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.dcComments}" readonly  class="form-control"
               autofocus="true"></input>
         </div>
         <div class="form-group col-lg-4">
            <label >Date</label>
            <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="<fmt:formatDate value='${applicationData.appDcDate}' pattern='dd-MM-yyyy HH:mm:ss' />" class="form-control" style="color:red;"
               autofocus="true"></input>
         </div>
      </div>
   </c:if>
</sec:authorize>
<!-- Row Two ends-->
<sec:authorize access="hasAuthority('BDO')">
   <!-- Section Five -->
   <c:if test="${applicationData.appActionBdo == 'P'}">
      <hr>
      <h2>Approve/Reject Application</h2>
      <hr>
      <div class="row">
         <div class="col-lg-12">
            <form:form method="POST"  modelAttribute="actionForm"  action="${pageContext.request.contextPath}/updateActionApplication" class="form-signin">
               <spring:bind path="action">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:label  path="action" > Please Select any Action </form:label>
                     <form:select  path="action" class="form-control" id="earlierService">
                        <option value=""> --Select-- </option>
                        <option value="A"> Approve </option>
                        <option value="R"> Reject </option>
                        <option value="I"> Incomplete </option>
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
               <input type="submit"  value="Submit" class="btn btn-success col-lg-12">
               <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            </form:form>
         </div>
      </div>
   </c:if>
</sec:authorize>
<!-- Section Five Ends -->
<!-- Row Ends Permession by BDO-->
<sec:authorize access="hasAuthority('DFO')">
   <!-- Section Five -->
   <c:if test="${applicationData.appActionDfo == 'P'}">
      <hr>
      <h2>Approve/Reject Application</h2>
      <hr>
      <div class="row">
         <div class="col-lg-12">
            <form:form method="POST"  modelAttribute="actionForm"  action="${pageContext.request.contextPath}/updateActionApplication" class="form-signin">
               <spring:bind path="action">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:label  path="action" > Please Select any Action </form:label>
                     <form:select  path="action" class="form-control" id="earlierService">
                        <option value=""> --Select-- </option>
                        <option value="A"> Approve </option>
                        <option value="R"> Reject </option>
                        <option value="I"> Incomplete </option>
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
               <input type="submit"  value="Submit" class="btn btn-success col-lg-12">
               <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            </form:form>
         </div>
      </div>
   </c:if>
</sec:authorize>
<sec:authorize access="hasAnyAuthority('Admin','Super Admin')">
   <!-- Section Five -->
   <c:if test="${applicationData.appActionDc == 'P'}">
      <hr>
      <h2>Approve/Reject Application</h2>
      <hr>
      <div class="row">
         <div class="col-lg-12">
            <form:form method="POST"  modelAttribute="actionForm"  action="${pageContext.request.contextPath}/updateActionApplication" class="form-signin">
               <spring:bind path="action">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:label  path="action" > Please Select any Action </form:label>
                     <form:select  path="action" class="form-control" id="earlierService">
                        <option value=""> --Select-- </option>
                        <option value="A"> Approve </option>
                        <option value="R"> Reject </option>
                        <option value="I"> Incomplete </option>
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
               <spring:bind path="user_role">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:input type="hidden" path="user_role" id="user_role" class="form-control"  value="DC" />
                  </div>
                  <form:errors  style="color:red;" path="user_role"></form:errors>
               </spring:bind>
               <spring:bind path="app_id">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:input type="hidden" path="app_id" id="app_id" class="form-control"  value="${applicationData.appId}" />
                  </div>
                  <form:errors  style="color:red;" path="app_id"></form:errors>
               </spring:bind>
               <input type="submit"  value="Submit" class="btn btn-success col-lg-12">
               <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            </form:form>
         </div>
      </div>
   </c:if>
</sec:authorize>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/vendorApplicationForm.js"></script>