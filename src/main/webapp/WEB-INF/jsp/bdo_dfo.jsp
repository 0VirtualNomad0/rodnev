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

	<c:if test="${not empty userApplications}">
<div class="row">
   <div class="col-lg-12">
      <div class="ibox-head">
         <h4 class="form-signin-heading col-lg-12"><strong>Applications List</strong></h4>
      </div>
      <div class="ibox-body">
         <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
            <thead>
               <tr>
                  <th class="text-center">S.No</th>
                  <th class="text-center">Vendor Name</th>
                  <th class="text-center">Vendor Type</th>
                  <th class="text-center">Vendor Category</th>
                  <th class="text-center">Application Submitted Date</th>
                  <th class="text-center">App Status</th>
                  <th class="text-center">View</th>
                  <th class="text-center">Edit</th>
               </tr>
            </thead>
            <tbody>
            <c:forEach items="${userApplications}" var="application" varStatus="loopCounter">
               <tr>
                  	<td class="text-center">
                  												<c:out value="${loopCounter.count}"/>
                  											</td>
                  											 <td class="text-center">${application.userId.firstName} &nbsp; ${application.userId.lastName}</td>
                  <td class="text-center">${application.vendorId.venTypeName}</td>
                <td class="text-center">${application.vendorTypeId.vendorTypeName}</td>
                <td class="text-center"> <fmt:formatDate value="${application.createdDate}" pattern="dd-MM-yyyy" /> </td>
                   <c:if test = "${application.appActionDc == 'P'}">
                                                                       <td class="text-center btn-warning" style="color:white;">Pending</td>
                                                               </c:if>
                                                                <c:if test = "${application.appActionDc == 'A'}">
                                                                <td class="text-center btn-success" style="color:white;">Approved</td>
                                                                 </c:if>
                                                                <c:if test = "${application.appActionDc == 'R'}">
                                                                 <td class="text-center btn-danger" style="color:white;">Rejected</td>
                                                                  </c:if>
                  <td class="text-center btn-success" style="color:white;" > <a href="${pageContext.request.contextPath}/getApplicationDetails/${application.appId}" style="color:white; text-decoration:none;"> View  </a> </td>
                 <td class="text-center btn-info" style="color:white;" > <a href="${pageContext.request.contextPath}/getApplicationDetails/${application.appId}" style="color:white; text-decoration:none;"> Edit </a> </td>
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
           pageLength: 10,

       });
   })
</script>