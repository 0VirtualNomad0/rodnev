<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <form method="POST" name="payuForm"  action="https://test.payu.in/_payment">
      <c:if test="${not empty successMessage}">
         <div class="row">
            <div id="serverError" style="color:#77332F; display: block ;" class="text-center successMessage col-lg-12 breadcrumb">${successMessage}</div>
         </div>
      </c:if>
      <br>
      <c:if test="${not empty serverError}">
         <div class="row">
            <div id="serverError" style="color:#77332F; display: block ;" class="plErroMessage text-center  col-lg-12 breadcrumb">${serverError}</div>
         </div>
      </c:if>
      <!-- Section Three -->

<div class="content-wrapper" style="background-color:#FFFFFF;">

      <div class="row ">
         <div class="col-lg-3"> &nbsp;  </div>
         <div class="table-responsive col-lg-6 breadcrumb">
            <h4 class="text-left col-lg-12">Verify the Details before proceeding :</h4>
            <hr>
            <table class="table table-hover table-bordered">
               <tbody>
                  <tr>
                     <td class="text-center">Application No.</td>
                     <td class="text-center" >${user.appId}
                     </td>
                  </tr>
                  <tr>
                     <td class="text-center">User Full Name:</td>
                     <td class="text-center" >${user.userId.firstName} &nbsp; ${user.userId.lastName}
                     </td>
                  </tr>
                  <tr>
                     <td class="text-center">Age</td>
                     <td class="text-center" > ${user.userId.age}  </td>
                  </tr>

                  <tr class="text-center">
                     <td>Vendor Category</td>
                     <td class="text-center"> ${user.vendorId.venTypeName}  </td>
                  </tr>
                  <tr class="text-center">
                     <td>Vendor Type</td>
                     <td class="text-center"  > ${user.vendorTypeId.vendorTypeName}  </td>
                  </tr>

                  <tr>
                     <td class="text-center">Mobile Number</td>
                     <td class="text-center" >${user.userId.mobileNumber}</input>
                     </td>
                  </tr>
                  <td class="text-center">Amount to Pay</td>
                  <c:if test="${user.vendorTypeId.vendorTypeName == 'Tent'  }">
                     <td class="text-center" >${500* user.tentNumber}/-</td>
                  </c:if>
                  <c:if test="${user.vendorTypeId.vendorTypeName != 'Tent'  }">
                  <td class="text-center" >500/-</td>
                  </c:if>

                  </tr>
               </tbody>
            </table>
            <br />
            <input type="hidden" name="key" value="<%= session.getAttribute("merchant_key") %>" />
                  <input type="hidden" name="hash" value="<%= session.getAttribute("hash") %>"/>
                  <input type="hidden" name="txnid" value="<%= session.getAttribute("txnid") %>" />
                  <input type="hidden" name="amount" value="<%= session.getAttribute("amount") %>" />
                  <input type="hidden" name="firstname" id="firstname" value="<%= session.getAttribute("firstname") %>" />
                  <input type="hidden" name="email" id="email" value="<%= session.getAttribute("email") %>" />
                  <input type="hidden" name="phone" value="<%= session.getAttribute("phone") %>" />
                  <input type="hidden" name="productinfo" value="<%= session.getAttribute("productinfo") %>" />
                  <input type="hidden" name="surl" value="<%= session.getAttribute("surl") %>" size="64" />
                  <input type="hidden" name="furl" value="<%= session.getAttribute("furl") %>" size="64" />
            <input class="col-lg-12 btn-success" name="submit" type="submit" value="Proceed to Payment ." />
             <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            <br/>
         </div>
         <div class="col-lg-3"> &nbsp;  </div>
      </div>
      </div>
      <!-- Section Three Ends -->
      </form>
