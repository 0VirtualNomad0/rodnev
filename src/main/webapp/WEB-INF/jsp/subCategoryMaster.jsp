<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>

<div class="content-wrapper">
   <form:form method="POST" modelAttribute="subCategoryForm" action="${pageContext.request.contextPath}/addSubCategory" class="form-signin">
      <h2 class="form-signin-heading">Create Sub Category</h2>
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
                  <form:select path="categoryId" name="categoryId" class="form-control" id="categoryId">
                  </form:select>
                  <form:errors  path="categoryId"></form:errors>
               </div>
            </spring:bind>
      <spring:bind path="subcategoryName">
         <div class="form-group ${status.error ? 'has-error' : ''}">
          <form:label path="subcategoryName" for="subcategoryName">Enter Sub Category</form:label>
            <form:input type="text" path="subcategoryName" onkeypress="return alpha(event) "  oncopy="return false" onpaste="return false" class="form-control" placeholder=" Sub Category Name"
               autofocus="true" ></form:input>
            <form:errors  path="subcategoryName"></form:errors>
         </div>
      </spring:bind>
      <spring:bind path="landType">
         <div class="form-group  ${status.error ? 'has-error' : ''}">
            <form:label path="landType" for="landType">Select Land Type</form:label>
            <form:select path="landType" name="landType" class="form-control" id="landType">
            </form:select>
            <form:errors  path="landType"></form:errors>
         </div>
      </spring:bind>
      <spring:bind path="security">
         <div class="form-group ${status.error ? 'has-error' : ''}">
         <form:label path="security" for="security">Enter Security Amount</form:label>
            <form:input type="text" path="security" onkeypress="return alpha(event) "  oncopy="return false" onpaste="return false" class="form-control" placeholder="Security Fee"
               autofocus="true" ></form:input>
            <form:errors  path="security"></form:errors>
         </div>
      </spring:bind>
      <spring:bind path="fee">
         <div class="form-group ${status.error ? 'has-error' : ''}">
                  <form:label path="landType" for="landType">Enter Fee</form:label>
            <form:input type="text" path="fee" onkeypress="return alpha(event) "  oncopy="return false" onpaste="return false" class="form-control" placeholder="Fee"
               autofocus="true" ></form:input>
            <form:errors  path="fee"></form:errors>
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
      <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
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