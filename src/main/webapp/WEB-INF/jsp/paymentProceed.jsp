<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


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
         <div class="table-responsive col-lg-6">
            <h4 class="text-left col-lg-12"><spring:message code="paymentpage.heading"/></h4>
            <hr>
            <table class="table table-hover table-bordered">
               <tbody>
                  <tr>
                     <td class="text-center"><spring:message code="paymentpage.application.no"/></td>
                     <td class="text-center" >${user.appId}
                     </td>
                  </tr>
                  <tr>
                     <td class="text-center"><spring:message code="paymentpage.application.username"/></td>
                     <td class="text-center" >${user.userId.firstName} &nbsp; ${user.userId.lastName}
                     </td>
                  </tr>
                  <tr>
                     <td class="text-center"><spring:message code="paymentpage.application.age"/></td>
                     <td class="text-center" > ${user.userId.age}  </td>
                  </tr>
                  <tr class="text-center">
                     <td><spring:message code="paymentpage.application.category"/></td>
                     <td class="text-center"> ${user.category.categoryName}  </td>
                  </tr>
                  <tr class="text-center">
                     <td><spring:message code="paymentpage.application.type"/></td>
                     <td class="text-center"  > ${user.subcategory.subCategoryName}  </td>
                  </tr>
                  <tr>
                     <td class="text-center"><spring:message code="paymentpage.application.mobile"/></td>
                     <td class="text-center" >${user.userId.mobileNumber}</input>
                     </td>
                  </tr>
                  <tr>
                     <td class="text-center"><spring:message code="paymentpage.application.totaldays"/></td>
                     <td class="text-center" >${user.totalDays}</input>
                     </td>
                  </tr>
                  <tr class="text-center">
                     <td ><spring:message code="paymentpage.application.amounttopay"/></td>
                     <td class="text-center" ><%= session.getAttribute("amount") %></input>
                  </tr>
                  <tr class="text-center">
                                       <td ><spring:message code="paymentpage.application.security"/></td>
                                       <td class="text-center" ><%= session.getAttribute("security") %></input>
                                    </tr>
               </tbody>
            </table>
         </div>
         <div class="col-lg-3"> &nbsp;  </div>
      </div>
      <h4 class="text-center col-lg-12" ><spring:message code="paymentpage.application.feedetails"/></h4>

      <div class="row">
         <div class="col-lg-1"> &nbsp;  </div>
         <table class="col-lg-10 table table-hover table-bordered">
            <thead>
               <tr>
                  <th><spring:message code="paymentpage.application.sno"/></th>
                  <th><spring:message code="paymentpage.application.categoryname"/></th>
                  <th><spring:message code="paymentpage.application.subcategory"/></th>
                  <th><spring:message code="paymentpage.application.landtype"/></th>
                  <th><spring:message code="paymentpage.application.nationality"/></th>
                  <th><spring:message code="paymentpage.application.regionalNational"/></th>
                  <th><spring:message code="paymentpage.application.items"/></th>
                  <th><spring:message code="paymentpage.application.fee"/></th>
               </tr>
            </thead>
            <tbody>

            <!-- Show Fee Details -->
               <c:if test="${not empty user.app_items}">
                  <c:forEach items="${user.app_items}" var="application" varStatus="loopCounter">
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
                           <td>${application.item.fee}</td>
                        </c:if>
                        <c:if test="${application.tentNumber != 0}">
                           <td>${application.tentNumber}</td>
                           <td> ${application.item.fee * application.tentNumber} (${application.item.fee} x ${application.tentNumber})</td>
                        </c:if>
                       <!-- <td class="text-center" rowspan="${fn:length(user.app_items)}">${application.item.securityAmount}</td> -->
                     </tr>
                  </c:forEach>
               </c:if>
                <!-- Show Fee Details -->



            </tbody>
         </table>
         <div class="col-lg-1"> &nbsp;  </div>
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
   </div>
   <!-- Section Three Ends -->
</form>