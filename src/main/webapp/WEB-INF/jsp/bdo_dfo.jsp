<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h2 class="form-signin-heading col-lg-12"><strong>Dashboard</strong></h2>
<!-- START PAGE CONTENT-->
<c:if test="${empty userApplications}">
   <div class="page-content fade-in-up">

      <div class="row">
         <h4 class="form-signin-heading col-lg-12" ><strong>No Applications Available. </strong></h4>
         <br>

      </div>
   </div>
</c:if>
<c:if test="${not empty userApplications}">
<br>
   <div class="row">
      <div class="col-lg-12">
         <div class="ibox-head">
            <h4 class="form-signin-heading col-lg-12"><strong>Vendor Applications</strong></h4>
         </div>
         <div class="ibox-body">
            <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
               <thead>
                  <tr>

                     <th class="text-center">S.No</th>
                     <th class="text-center">Name</th>
                      <th class="text-center">Mobile Number</th>
                     <th class="text-center">Category</th>
                     <th class="text-center">Subcategory</th>
                     <th class="text-center">Status (DC)</th>
                     <th class="text-center">View</th>

                  </tr>
               </thead>
               <tbody>
                  <c:forEach items="${userApplications}" var="application" varStatus="loopCounter">
                     <tr>
                        <td class="text-center">
                           <c:out value="${loopCounter.count}"/>
                        </td>
                        <td class="text-center" >${application.firstName} &nbsp; ${application.lastName}</td>
                         <td class="text-center" >${application.mobileNumber} </td>
                         <td class="text-center" >${application.category}</td>
                          <td class="text-center">${application.subCategory}</td>
                         <c:if test = "${application.application_status == 'P'}">
                                                   <td class="text-center btn-warning" style="color:white;">Pending</td>
                                                </c:if>
                                                <c:if test = "${application.application_status == 'A'}">
                                                   <td class="text-center btn-success" style="color:white;">Approved</td>
                                                </c:if>
                                                <c:if test = "${application.application_status == 'R'}">
                                                   <td class="text-center btn-danger" style="color:white;">Rejected</td>
                                                </c:if>
                                                <c:if test = "${application.application_status == 'I'}">
                                                   <td class="text-center btn-primary" style="color:white;">Incomplete</td>
                                                </c:if>

                        <td class="text-center btn-success" style="color:white;" > <a href="${pageContext.request.contextPath}/getApplicationDetails/${application.app_id}" style="color:white; text-decoration:none;"> View  </a> </td>
                     </tr>
                  </c:forEach>
               </tbody>
            </table>
         </div>
      </div>
   </div>
</c:if>
<script type="text/javascript">
   $(function() {
       $('#example-table').DataTable({
           pageLength: 20,

       });
   })
</script>