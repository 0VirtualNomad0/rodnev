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
<h2 class="form-signin-heading col-lg-12"><strong>Vendor Dashboard</strong></h2>
<!-- START PAGE CONTENT-->
<div class="page-content fade-in-up">
<div class="row">
   <div class="col-lg-3 col-md-6">
      <div class="ibox bg-success color-white widget-stat">
         <div class="ibox-body">
            <h2 class="m-b-5 font-strong">201</h2>
            <div class="m-b-5">NEW ORDERS</div>
            <i class="ti-shopping-cart widget-stat-icon"></i>
            <div><i class="fa fa-level-up m-r-5"></i><small>25% higher</small></div>
         </div>
      </div>
   </div>
   <div class="col-lg-3 col-md-6">
      <div class="ibox bg-info color-white widget-stat">
         <div class="ibox-body">
            <h2 class="m-b-5 font-strong">1250</h2>
            <div class="m-b-5">UNIQUE VIEWS</div>
            <i class="ti-bar-chart widget-stat-icon"></i>
            <div><i class="fa fa-level-up m-r-5"></i><small>17% higher</small></div>
         </div>
      </div>
   </div>
   <div class="col-lg-3 col-md-6">
      <div class="ibox bg-warning color-white widget-stat">
         <div class="ibox-body">
            <h2 class="m-b-5 font-strong">$1570</h2>
            <div class="m-b-5">TOTAL INCOME</div>
            <i class="fa fa-money widget-stat-icon"></i>
            <div><i class="fa fa-level-up m-r-5"></i><small>22% higher</small></div>
         </div>
      </div>
   </div>
   <div class="col-lg-3 col-md-6">
      <div class="ibox bg-danger color-white widget-stat">
         <div class="ibox-body">
            <h2 class="m-b-5 font-strong">108</h2>
            <div class="m-b-5">NEW USERS</div>
            <i class="ti-user widget-stat-icon"></i>
            <div><i class="fa fa-level-down m-r-5"></i><small>-12% Lower</small></div>
         </div>
      </div>
   </div>
</div>

	<c:if test="${not empty userApplications}">
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
                  <td class="text-center">${application.vendorId.venTypeName}</td>
                <td class="text-center">${application.vendorTypeId.vendorTypeName}</td>
                  <td class="text-center">${application.createdDate}</td>
                   <c:if test = "${application.appActionDc == 'P'}">
                                                                       <td class="text-center btn-warning" style="color:white;">Pending</td>
                                                               </c:if>
                                                                <c:if test = "${application.appActionDc == 'A'}">
                                                                <td class="text-center btn-success" style="color:white;">Approved</td>
                                                                 </c:if>
                                                                <c:if test = "${application.appActionDc == 'R'}">
                                                                 <td class="text-center btn-danger" style="color:white;">Rejected</td>
                                                                  </c:if>
                  <td class="text-center btn-success" style="color:white;" > <a href="${pageContext.request.contextPath}/getUserDetails/${application.userId}" style="color:white; text-decoration:none;"> View  </a> </td>
                 <td class="text-center btn-info" style="color:white;" > <a href="${pageContext.request.contextPath}/getUserDetails/${application.userId}" style="color:white; text-decoration:none;"> Edit </a> </td>
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