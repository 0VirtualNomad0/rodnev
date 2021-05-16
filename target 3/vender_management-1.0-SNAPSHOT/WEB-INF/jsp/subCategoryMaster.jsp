<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="content-wrapper">

        <form:form method="POST" modelAttribute="subCategoryForm" action="${pageContext.request.contextPath}/saveSubCategory" class="form-signin">
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
                    <form:input type="text" autocomplete="off" onfocus="this.removeAttribute('readonly');" path="subcategoryName" onkeypress="return alpha(event) "  oncopy="return false" onpaste="return false" class="form-control" placeholder="Sub Category Name"
                                autofocus="true" ></form:input>
                    <form:errors  path="subcategoryName"></form:errors>
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
           getsVendor();
       });

    </script>
