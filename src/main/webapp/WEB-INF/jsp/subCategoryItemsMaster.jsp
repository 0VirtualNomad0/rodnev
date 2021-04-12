<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<div class="content-wrapper">
   <form:form method="POST" modelAttribute="subCategoryItemsForm" action="${pageContext.request.contextPath}/addsubcategoriesitems" class="form-signin">
      <h2 class="form-signin-heading">Create Iteams for respective Sub Categories</h2>
      <c:if test="${not empty successMessage}">
         <div id="serverError" class="successMessage">${successMessage}</div>
      </c:if>
      <br>
      <c:if test="${not empty serverError}">
         <div id="serverError" class="plErroMessage">${serverError}</div>
      </c:if>
      <spring:bind path="categoryId">
         <div class="form-group  ${status.error ? 'has-error' : ''}">
            <form:label path="categoryId" for="categoryId">Select Category</form:label>
            <form:select path="categoryId" name="categoryId" class="form-control" id="categoryId" onchange="getVendorCategoryAdmin(this.value);">
            </form:select>
            <form:errors  path="categoryId"></form:errors>
         </div>
      </spring:bind>
      <spring:bind path="vendorType">
         <div class="form-group  ${status.error ? 'has-error' : ''}">
            <form:label path="vendorType" for="vendorType">Select Sub Category</form:label>
            <form:select path="vendorType" name="vendorType" class="form-control" id="vendorType" >
            </form:select>
            <form:errors  path="vendorType"></form:errors>
         </div>
      </spring:bind>
      <spring:bind path="landType">
         <div class="form-group  ${status.error ? 'has-error' : ''}">
            <form:label path="landType" for="landType">Select Land Type (Commercial/Non Commercial)</form:label>
            <form:select path="landType" name="landType" class="form-control" id="landType">
            </form:select>
            <form:errors  path="landType"></form:errors>
         </div>
      </spring:bind>
      <spring:bind path="nationality">
         <div class="form-group  ${status.error ? 'has-error' : ''}">
            <form:label path="nationality" for="nationality">Select Nationality</form:label>
            <form:select path="nationality" name="nationality" class="form-control" id="nationality">
            </form:select>
            <form:errors  path="nationality"></form:errors>
         </div>
      </spring:bind>
      <spring:bind path="nationalRegional">
         <div class="form-group  ${status.error ? 'has-error' : ''}">
            <form:label path="nationalRegional" for="nationalRegional">Select National/Regional</form:label>
            <form:select path="nationalRegional" name="nationalRegional" class="form-control" id="nationalRegional">
            </form:select>
            <form:errors  path="nationalRegional"></form:errors>
         </div>
      </spring:bind>
      <spring:bind path="itemName">
         <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:label path="itemName" for="itemName">Enter Item Name</form:label>
            <form:input type="text" path="itemName" autocomplete="off" onfocus="this.removeAttribute('readonly');" onkeypress="return alpha(event) "  oncopy="return false" onpaste="return false" class="form-control" placeholder="Item Name"
               autofocus="true" ></form:input>
            <form:errors  path="itemName"></form:errors>
         </div>
      </spring:bind>
      <spring:bind path="fee">
         <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:label path="landType" for="landType">Enter Fee</form:label>
            <form:input type="text" path="fee" autocomplete="off" onfocus="this.removeAttribute('readonly');" onkeypress="return alpha(event) "  oncopy="return false" onpaste="return false" class="form-control" placeholder="Fee"
               autofocus="true" ></form:input>
            <form:errors  path="fee"></form:errors>
         </div>
      </spring:bind>
      <spring:bind path="security">
         <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:label path="security" for="security">Enter Security Amount</form:label>
            <form:input type="text" path="security" autocomplete="off" onfocus="this.removeAttribute('readonly');" onkeypress="return alpha(event) "  oncopy="return false" onpaste="return false" class="form-control" placeholder="Security Fee"
               autofocus="true" ></form:input>
            <form:errors  path="security"></form:errors>
         </div>
      </spring:bind>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
      <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
      <c:remove var="successMessage" scope="session" />
   </form:form>
</div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/vendor/script.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<script type="text/javascript">
   $( document ).ready(function() {
       getNationality();
       getsVendor();
       getNationalRegional();
       getLandType();
   });




</script>