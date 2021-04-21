<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrapd.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/pace.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/flight_application_form.js"></script>
<main class="app-content" style="min-height:350px;">
   <form:form method="POST" class="form-horizontal" id="form" modelAttribute="checkStatus" action="${pageContext.request.contextPath}/checkStatusApp">
      <div class="container" style="padding:10px; margin-top:20px; margin:bottom:20px;">
         <h4 class="text-center">Check Application Status</h4>
         <ol class="breadcrumb">
            <li> <spring:message code="checkstatus.heading"/> </li>
         </ol>
         <c:if test="${not empty successMessage}">
            <div id="serverError" class="successMessage">${successMessage}</div>
         </c:if>
         <br>
         <c:if test="${not empty serverError}">
            <div id="serverError" class="plErroMessage">${serverError}</div>
         </c:if>

         <div class="row">
         <spring:bind path="appId">
            <label class="col-lg-3 col-md-3 col-xs-12 col-sm-12 text-center" for="id1"><strong><spring:message code="checkstatus.enterappId"/></strong></label>
            <div class="col-lg-3 col-md-3 col-xs-12 col-sm-12 ${status.error ? 'has-error' : ''}">
               <form:input onkeypress="return alpha(event)" autocomplete="off" onfocus="this.removeAttribute('readonly');"  oncopy="return false" onpaste="return false" maxlength="10" class="form-control " path="appId" name="appId" type="text" id="appId" />
               <form:errors  path="appId"></form:errors>
            </div>
            </spring:bind>
            <spring:bind path="mobileNumber">
                        <label class="col-lg-3 col-md-3 col-xs-12 col-sm-12 text-center" for="id1"><strong><spring:message code="checkstatus.enterMobileNumber"/></strong></label>
                        <div class="col-lg-3 col-md-3 col-xs-12 col-sm-12 ${status.error ? 'has-error' : ''}">
                           <form:input onkeypress="return alpha(event)" autocomplete="off" onfocus="this.removeAttribute('readonly');"  oncopy="return false" onpaste="return false" maxlength="10" class="form-control " path="mobileNumber" name="mobileNumber" type="text" id="mobileNumber" />
                           <form:errors  path="mobileNumber"></form:errors>
                        </div>
                        </spring:bind>
                        <br>
                        <br>
            <input type="submit"  value="Submit" text="Submit" class="btn btn-success pull-left col-lg-12 col-md-12 col-xs-12 col-sm-12">
             <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            <c:remove var="successMessage" scope="session" />
         </div>

      </div>
   </form:form>
   </div>


 <!-- Comments by DC, BDO and DFO -->
 <c:if test="${not empty appPermissions}">
 <div class="container" style="padding:10px;">
 <br>
 <br>
 <h2 class="form-signin-heading col-lg-12"><strong><spring:message code="checkstatus.appPermissions"/></strong></h2>
 <hr>
 <br>

 <table class="col-lg-12 table table-hover table-bordered">
    <thead>
       <tr>
          <th>S.No</th>
          <th>Role Name</th>
          <th>Application Status </th>
          <th>Comments</th>
          <th>Date</th>
         <!-- <th>Attachment</th>  -->

       </tr>
    </thead>
    <tbody>

          <c:forEach items="${appPermissions}" var="application" varStatus="loopCounter">
             <tr>
                <td>
                   <c:out value="${loopCounter.count}"/>
                </td>
                <td><a href="${pageContext.request.contextPath}/viewRoleDetails/${application.userId}" style="text-decoration:none;">${application.roleName}</a></td>
                 <c:if test = "${application.status == 'P'}">
                                                                     <td class="text-center btn-warning" style="color:white;">Pending</td>
                                                             </c:if>
                                                              <c:if test = "${application.status == 'A'}">
                                                              <td class="text-center btn-success" style="color:white;">Approved</td>
                                                               </c:if>
                                                              <c:if test = "${application.status == 'R'}">
                                                               <td class="text-center btn-danger" style="color:white;">Rejected</td>
                                                                </c:if>
                <td>${application.comments}</td>
                <td style="color:red;"><fmt:formatDate value='${application.createddate}' pattern='dd-MM-yyyy HH:mm:ss' /></td>

              <!--   <c:if test="${not empty application.attachemnts}">
                  <td><a href="${pageContext.request.contextPath}/downloadFile/${application.attachemnts}">Download</a></td>
                 </c:if>  -->



               </tr>
          </c:forEach>

    </tbody>
 </table>
  </c:if>
 <br />
 <!-- Comments by DC, BDO and DFO ENDS -->

 <!-- downloadApplication -->

  <c:if test = "${downloadApplication}">
   <br>
   <h2 class="form-signin-heading col-lg-12"><strong><spring:message code="checkstatus.downloadReport"/></strong></h2>
<br>
  <div class="container">
  <div class="row">
   <div class="text-center btn-success col-lg-12" style="color:white; padding: 10px;" >
   <a href="${pageContext.request.contextPath}/generatePdf/${applicatoinId}" target= "_blank" style="color:white; padding:10px; text-decoration:none;"> <strong><spring:message code="checkstatus.download"/></strong> </a> </div>
   </div>
   </div>
   </c:if>



   <!-- autoApproved -->
   <c:if test = "${autoApproved}">
      <br>
      <h2 class="form-signin-heading col-lg-12"><strong><spring:message code="checkstatus.downloadReport"/></strong></h2>
         <h4 class="form-signin-heading col-lg-12"><strong><spring:message code="checkstatus.autoApproved"/></strong></h4>

   <br>
     <div class="container">
     <div class="row">
      <div class="text-center btn-success col-lg-12" style="color:white; padding: 10px;" >
      <a href="${pageContext.request.contextPath}/generatePdf/${applicatoinId}" target= "_blank" style="color:white; padding:10px; text-decoration:none;"> <strong><spring:message code="checkstatus.download"/></strong> </a> </div>
      </div>
      </div>
      </c:if>



</main>