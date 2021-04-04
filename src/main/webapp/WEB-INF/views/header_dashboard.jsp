<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
      <meta name="viewport" content="width=device-width initial-scale=1.0">
      <title>eVendor Dashboard</title>
      <!-- GLOBAL MdINLY STYLES-->
      <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/vendor/bootstrap.min.css" rel="stylesheet" />
      <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/vendor/font-awesome.min.css" rel="stylesheet" />
      <link  rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/vendor/themify-icons.css" rel="stylesheet" />
      <!-- PLUGINS STYLES-->
      <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/vendor/jquery-jvectormap-2.0.3.css" rel="stylesheet" />
      <!-- THEME STYLES-->
      <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/vendor/main.min.css" rel="stylesheet" />
      <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/vendor/datatables.min.css" rel="stylesheet" />
      <!-- PAGE LEVEL STYLES-->
   </head>
   <body class="fixed-navbar">
      <div>
         <!-- START HEADER class="page-wrapper"-->
         <header class="header">
            <div class="page-brand">
               <a class="link" href="index.html">
               <span class="brand">eVendor
               </span>
               </a>
            </div>
            <div class="flexbox flex-1">
               <!-- START TOP-LEFT TOOLBAR-->
               <ul class="nav navbar-toolbar">
                  <li>
                     <a class="nav-link sidebar-toggler js-sidebar-toggler"><i class="ti-menu"></i></a>
                  </li>
               </ul>
               <!-- END TOP-LEFT TOOLBAR-->
               <!-- START TOP-RIGHT TOOLBAR-->
               <ul class="nav navbar-toolbar">
                  <li class="dropdown dropdown-user">
                     <a class="nav-link dropdown-toggle link" data-toggle="dropdown">
                     <img src="${pageContext.request.contextPath}/resources/images/admin-avatar.png" />
                     <span></span>${pageContext.request.userPrincipal.name}<i class="fa fa-angle-down m-l-5"></i></a>
                     <ul class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/updateProfile"><i class="fa fa-user"></i>Edit Profile</a>
                        <li class="dropdown-divider"></li>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/logout"><i class="fa fa-power-off"></i>Logout</a>
                     </ul>
                  </li>
               </ul>
               <!-- END TOP-RIGHT TOOLBAR-->
            </div>
         </header>
         <!-- END HEADER-->
         <!-- START SIDEBAR-->
         <nav class="page-sidebar" id="sidebar">
            <div id="sidebar-collapse">
               <div class="admin-block d-flex">
                  <div>
                     <img src="${pageContext.request.contextPath}/resources/images/admin-avatar.png" width="45px" />
                  </div>
                  <div class="admin-info">
                     <div class="font-strong">${pageContext.request.userPrincipal.name}</div>
                  </div>
               </div>
               <ul class="side-menu metismenu">
                  <sec:authorize access="hasAnyAuthority('Super Admin','Admin','DC')">
                     <li>
                        <a class="active" href="${pageContext.request.contextPath}/dashboard"><i class="sidebar-item-icon fa fa-th-large"></i>
                        <span class="nav-label">Dashboard</span>
                        </a>
                     </li>
                  </sec:authorize>
                  <li class="heading">OPTIONS</li>
                  <sec:authorize access="hasAnyAuthority('Super Admin', 'Admin','DC')">
                     <li>
                        <a href="javascript:;"><i class="sidebar-item-icon fa fa-bookmark"></i>
                        <span class="nav-label">Super Admin Features</span><i class="fa fa-angle-left arrow"></i></a>
                        <ul class="nav-2-level collapse">
                           <li>
                              <a href="${pageContext.request.contextPath}/createRole">Create Roles</a>
                           </li>
                           <li>
                              <a href="${pageContext.request.contextPath}/createUser">Create Users</a>
                           </li>
                        </ul>
                     </li>
                     <li>
                        <a href="javascript:;"><i class="sidebar-item-icon fa fa-bookmark"></i>
                        <span class="nav-label">Categories Masters</span><i class="fa fa-angle-left arrow"></i></a>
                        <ul class="nav-2-level collapse">
                           <li>
                              <a href="${pageContext.request.contextPath}/getcategory">Create Category</a>
                           </li>
                           <li>
                              <a href="${pageContext.request.contextPath}/addsubcategories">Create Sub-Category</a>
                           </li>
                           <li>
                              <a href="${pageContext.request.contextPath}/subcategoriesitems">Create Sub-Category Items</a>
                           </li>
                        </ul>
                     </li>
                     <li>
                        <a href="javascript:;"><i class="sidebar-item-icon fa fa-bookmark"></i>
                        <span class="nav-label">Verify Payment</span><i class="fa fa-angle-left arrow"></i></a>
                        <ul class="nav-2-level collapse">
                           <li>
                              <a href="${pageContext.request.contextPath}/checkpayment">Check Payment (PayU)</a>
                           </li>
                           <li>
                              <a href="${pageContext.request.contextPath}/checkpaymentdb">Check Payment (eVendor App)</a>
                           </li>
                        </ul>
                     </li>
                     <li>
                        <a href="${pageContext.request.contextPath}/bdo_dfo"><i class="sidebar-item-icon fa fa-dashboard"></i>
                        <span class="nav-label">Applications List </span></a>
                     </li>
                  </sec:authorize>
                  <sec:authorize access="hasAnyAuthority('BDO', 'DFO','DC')">
                     <li>
                        <a href="${pageContext.request.contextPath}/bdo_dfo"><i class="sidebar-item-icon fa fa-dashboard"></i>
                        <span class="nav-label">Applications List </span></a>
                     </li>
                  </sec:authorize>
                  <sec:authorize access="hasAuthority('Vendor')">
                     <li>
                        <a href="${pageContext.request.contextPath}/vendorIndex"><i class="sidebar-item-icon fa fa-dashboard"></i>
                        <span class="nav-label">Vendor Dashboard</span></a>
                     </li>
                     <li>
                        <a href="${pageContext.request.contextPath}/vendorForm"><i class="sidebar-item-icon fa fa-edit"></i>
                        <span class="nav-label">Vendor Application Form</span><i class="fa fa-angle-left arrow"></i></a>
                     </li>
                  </sec:authorize>
               </ul>
            </div>
         </nav>
         <!-- END SIDEBAR-->
      </div>
   </body>
</html>