<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!--- footer Starts --->
      <div class="container-fluid">
         <div class="row">
            <div style="margin-top:20px; background-color: #2AABE4; width:100%;">
               &nbsp;
            </div>
         </div>
      </div>
      <div class="container-fluid" >
         <div class="row" style="background-color: #006FB9; box-shadow: 0 0 5px #000; ">
            <div class="col-lg-4">
               <h3 style="margin-top:0; padding-top:20px; padding-bottom:10px; padding-left:30px; color:#FFF;"><spring:message code="mainpage.footer.otherdepartmentallinks" text="Other Departmental Links"/></h3>
               <ul class="footer_list">
                  <li ><a href="https://www.himachal.nic.in/en-IN/" target="_blank"><spring:message code="mainpage.footer.otherdepartmentallinks.hp" text="Government of Himachal Pradesh"/></a></li>
                  <li ><a href="https://cmsankalp.hp.gov.in/" target="_blank"><spring:message code="mainpage.footer.otherdepartmentallinks.helpline" text="CM Helpline"/></a></li>
                  <li ><a href="http://cmhimachal.nic.in/" target="_blank"><spring:message code="mainpage.footer.otherdepartmentallinks.relief" text="CM Relief Fund"/></a></li>
                  <li ><a href="https://eflight.hp.gov.in/" target="_blank"><spring:message code="mainpage.footer.otherdepartmentallinks.eheli" text="eHeli"/></a></li>
                   <li >&nbsp;</li>

               </ul>
            </div>
            <div class="col-lg-4">
               <h3 style="margin-top:0; padding-top:20px; padding-bottom:10px; padding-left:30px; color:#FFF;"><spring:message code="mainpage.footer.policies" text="Policies"/></h3>
               <ul class="footer_list">
                  <li><a title="Terms and Conditions"  href="${pageContext.request.contextPath}/termsandconditions"><spring:message code="mainpage.footer.policies.tc" text="Terms and Conditions"/></a></li>
                  <li><a title="Privacy Policy" href="${pageContext.request.contextPath}/privacypolicy"><spring:message code="mainpage.footer.policies.privacy" text="Privacy Policy"/></a></li>
                   <li><a title="Refund Policy" href="${pageContext.request.contextPath}/refundpage"><spring:message code="mainpage.footer.refund" text="Refund Policy"/> </a></li>

               </ul>
            </div>
            <div class="col-lg-4">
               <h3 style="margin-top:0; padding-top:20px; padding-bottom:10px; padding-left:30px; color:#FFF;">&nbsp;</h3>
                &nbsp;
            </div>
         </div>

      </div>
      <!-- Footer Ends -->
    <script src="${pageContext.request.contextPath}/resources/js/vendor/jquery.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/vendor/popper.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/vendor/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/vendor/metisMenu.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/vendor/jquery.slimscroll.min.js" type="text/javascript"></script>
        <!-- PAGE LEVEL PLUGINS-->
        <script src="${pageContext.request.contextPath}/resources/js/vendor/Chart.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/vendor/jquery-jvectormap-2.0.3.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/vendor/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/vendor/jquery-jvectormap-us-aea-en.js" type="text/javascript"></script>
        <!-- CORE SCRIPTS-->
        <script src="${pageContext.request.contextPath}/resources/js/vendor/app.min.js" type="text/javascript"></script>
         <script src="${pageContext.request.contextPath}/resources/js/vendor/app.js" type="text/javascript"></script>
         <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/internationalization.js"></script>



      <script>
         /* Toggle between showing and hiding the navigation menu links when the user clicks on the hamburger menu / bar icon */
function myFunction() {
  var x = document.getElementById("myLinks");
  if (x.style.display === "block") {
    x.style.display = "none";
  } else {
    x.style.display = "block";
  }
}

 function disableBack() {window.history.forward()}

    window.onload = disableBack();
    window.onpageshow = function (evt) {if (evt.persisted) disableBack()}
      </script>

   </body>
  </html>