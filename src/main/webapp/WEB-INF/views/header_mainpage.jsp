<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/vendor/bootstrap.min.css">
      <!-- PAGE LEVEL STYLES-->
   </head>
   <body>
      <!--Top Bar Starts-->
      <section class="container-fluid top_bar"  >
         <div class="row" style="margin:0;padding:0;">
            <div class="col-xl-8">&nbsp;</div>
            <div class="col-xl-4" >
               <div class="flex_style" style="margin-top:5px;">

                  <div class="register_department" >
                  <a class="text_decorate" href="${pageContext.request.contextPath}/login" >Department Login</a>
                  </div>
                    &nbsp;&nbsp;
                  <div class="form-group">
                     <select class="form-control" id="locales">
                        <option value="">
                           <spring:message code="form.choose.lang" text="Choose Language"/>
                        </option>
                        <option value="en">
                           <spring:message code="form.lang.english" text="English"/>
                        </option>
                        <option value="hi">
                           <spring:message code="form.lang.hindi" text="Hindi"/>
                        </option>
                     </select>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <!-- Top Bar Ends-->
      <!-- Navigation and Header-->
      <div class="header_logo_megamenu" >
         <div class="row ">
            <div class="col-xl-1 col-lg-1 col-md-1 col-sm-1 col-1" style="margin-left: 50px;"> <img src="${pageContext.request.contextPath}/resources/images/logo_gov_hp.png"  class="logo_hp"   alt="Himachal Pradesh Government"></div>
            <div class="col-xl-5 col-lg-5 col-md-10 col-sm-9 col-9 padding_">
               <div>
                  <p class="text-left text_logo_one">eLahaul (V1.0)</p>
               </div>
               <div>
                  <p class="text_logo_two">Department of Information Technology </p>
               </div>
               <div>
                                 <p class="text_logo_three">Government of Himachal Pradesh </p>
                              </div>
            </div>
             <div class="col-xl-5 col-lg-5 col-md-12">
                           <nav class="navbar_" style="margin-top: 15px;">
                              <ul >
                                 <li><a href="${pageContext.request.contextPath}/"> <img src="${pageContext.request.contextPath}/resources/images/vector/house.svg" class="icon_mega_menu"><span class="parent-menga-menu">Home</span></a></li>

                              </ul>
                           </nav>
                        </div>

         </div>
      </div>



      <!-- Section More Options-->
      <section class="secondary_menu_options" style="width: auto"  >
         <div class="row">
            <div class="hide_unhide">
               <ul class="secondary_menu">
                  <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                  <li><a href="${pageContext.request.contextPath}/contactus">Contact Us</a></li>
                  <li><a href="https://cmsankalp.hp.gov.in/" target="_blank">Grievance</a></li>
                  <li><a href="${pageContext.request.contextPath}/vendorForm">Register as Vendor </a></li>
               </ul>
            </div>
            <div class="topnav">
               <a href="#home" class="active">&nbsp;</a>
               <!-- Navigation links (hidden by default) -->
               <div id="myLinks">
                  <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                  <li><a href="${pageContext.request.contextPath}/contactus">Contact Us</a></li>
                  <li><a href="https://cmsankalp.hp.gov.in/" target="_blank">Grievance</a></li>
                   <li><a href="${pageContext.request.contextPath}/vendorForm">Register as Vendor </a></li>
               </div>
               <!-- "Hamburger menu" / "Bar icon" to toggle the navigation links -->
               <a href="javascript:void(0);" class="icon" onclick="myFunction()">
               <i class="fa fa-bars"></i>
               </a>
            </div>
         </div>
      </section>
        <!-- Section More Options Ends-->