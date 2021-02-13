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
   <div class="row">
      <h2 class="form-signin-heading col-lg-12"><strong>User Details</strong></h2>
      <br>
      <div class="form-group col-lg-4">
         <label >First Name</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.userId.firstName}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Last Name</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.userId.lastName}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >User Name</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.userId.username}"  readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Mobile Number</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="${applicationData.userId.mobileNumber}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Age</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.userId.age}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Email</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.userId.email}" readonly  class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Gender</label>
         <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="${applicationData.userId.genderID.genderName}" class="form-control"
            autofocus="true"></input>
      </div>
      <div class="form-group col-lg-4">
         <label >Permanent Address</label>
         <textarea rows="4" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.userId.pAddress}" readonly  class="form-control"
            autofocus="true">${applicationData.userId.pAddress}</textarea>
      </div>
      <div class="form-group col-lg-4">
         <label >Correspondence Address</label>
         <textarea rows="4" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.userId.cAddress}" readonly  class="form-control"
            autofocus="true">${applicationData.userId.cAddress}</textarea>
      </div>
   </div>
   <!--  Row One Ends -->

   <!-- Row Two Starts -->
         <div class="row">
              <h2 class="form-signin-heading col-lg-12"><strong>Application Details</strong></h2>
              <br>
              <div class="form-group col-lg-4">
                 <label >Nationality</label>
                 <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.nationalityEntity.nationalityName}" readonly  class="form-control"
                    autofocus="true"></input>
              </div>
              <div class="form-group col-lg-4">
                 <label >Vendor Type</label>
                 <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.vendorId.venTypeName}" readonly  class="form-control"
                    autofocus="true"></input>
              </div>
              <div class="form-group col-lg-4">
                 <label >Vendor Category</label>
                 <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.vendorTypeId.vendorTypeName}"  readonly  class="form-control"
                    autofocus="true"></input>
              </div>
              <div class="form-group col-lg-4">
                               <label >Location</label>
                               <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.districtId.districtName}" readonly  class="form-control"
                                  autofocus="true"></input>
                            </div>
              <div class="form-group col-lg-4">
                 <label >Area</label>
                 <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  value="area not coming" readonly  class="form-control"
                    autofocus="true"></input>
              </div>

              <div class="form-group col-lg-4">
                 <label >Attached Document</label>
                 <a href="${pageContext.request.contextPath}/downloadFile/${applicationData.identityDoc}"><input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" value="${applicationData.identityDoc}" readonly  class="form-control"
                    autofocus="true"></input></a>
              </div>
              <div class="form-group col-lg-4">
                 <label >Comments</label>
                 <input type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  readonly value="${applicationData.vendorComments}" class="form-control"
                    autofocus="true"></input>
              </div>

           </div>
   <!-- Row Two ends-->

   <!-- Row Three Permission by DFO -->
    <sec:authorize access="hasAuthority('DFO')">
     <!-- Section Five -->
         <c:if test="${userdata.appActionDfo == 'P'}">
            <div class="row user">
               <div class="col-md-12">
                  <div class="tab-content">
                     <div id="user-timeline">
                        <div class="timeline-post">
                           <h2>Approve/Reject Application</h2>
                           <hr>

                           <div class="row">
                           <div class="col-lg-12">
   <form:form method="POST"  modelAttribute="actionForm" action="${pageContext.request.contextPath}/updateApplication" class="form-signin">
           <spring:bind path="action">
                   <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                      <form:label  path="action" > Please Select any Action </form:label>
                      <form:select  path="action" class="form-control" id="earlierService">
                            <form:option value=""> --Select-- </form:option>
                            <form:option value="A"> Approve </form:option>
                            <form:option value="R"> Reject </form:option>
                              <form:option value="I"> Incomplete </form:option>
                      </form:select>
                      <form:errors  style="color:red;" path="action"></form:errors>
                   </div>
                    </spring:bind>

         <spring:bind path="comments">
                 <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                    <label for="comments"> <spring:message code="form.addressss"  text="Comments" /> </label>
                    <form:textarea rows="4" path="comments" id="comments" class="form-control" onkeypress="return alpha(event)"  oncopy="return false" onpaste="return false" />
                     <form:errors style="color:red;"  path="comments"></form:errors>
                 </div>
                  </spring:bind>

         <spring:bind path="user_id">
                       <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                          <form:input type="hidden" path="user_id" id="user_id" class="form-control"  value="${userdata.userId}" />
                           <form:errors style="color:red;"  path="user_id"></form:errors>
                       </div>
                        </spring:bind>

    <input type="submit"  value="<spring:message code="customhiring.submit" text="Submit"/>" class="btn btn-success">
             <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
   </form:form>
   </div>
                           </div>


                        </div>
                     </div>
                  </div>
               </div>
            </div>
            </div>
            </c:if>
            </sec:authorize>
            <!-- Section Five Ends -->
   <!-- Row Ends Permession by DFO-->


   <sec:authorize access="hasAuthority('BDO')">
        <!-- Section Five -->
            <c:if test="${userdata.appActionBfo == 'P'}">
               <div class="row user">
                  <div class="col-md-12">
                     <div class="tab-content">
                        <div id="user-timeline">
                           <div class="timeline-post">
                              <h2>Approve/Reject Application</h2>
                              <hr>

                              <div class="row">
                              <div class="col-lg-12">
      <form:form method="POST"  modelAttribute="actionForm" action="${pageContext.request.contextPath}/updateApplication" class="form-signin">
              <spring:bind path="action">
                      <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                         <form:label  path="action" > Please Select any Action </form:label>
                         <form:select  path="action" class="form-control" id="earlierService">
                               <form:option value=""> --Select-- </form:option>
                               <form:option value="A"> Approve </form:option>
                               <form:option value="R"> Reject </form:option>
                               <form:option value="I"> Incomplete </form:option>
                         </form:select>
                         <form:errors  style="color:red;" path="action"></form:errors>
                      </div>
                       </spring:bind>

            <spring:bind path="comments">
                    <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                       <label for="comments"> <spring:message code="form.addressss"  text="Comments" /> </label>
                       <form:textarea rows="4" path="comments" id="comments" class="form-control" onkeypress="return alpha(event)"  oncopy="return false" onpaste="return false" />
                        <form:errors style="color:red;"  path="comments"></form:errors>
                    </div>
                     </spring:bind>

            <spring:bind path="user_id">
                          <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                             <form:input type="hidden" path="user_id" id="user_id" class="form-control"  value="${userdata.userId}" />
                              <form:errors style="color:red;"  path="user_id"></form:errors>
                          </div>
                           </spring:bind>

       <input type="submit"  value="<spring:message code="customhiring.submit" text="Submit"/>" class="btn btn-success">
                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
      </form:form>
      </div>
                              </div>


                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               </div>
               </c:if>
               </sec:authorize>
               <!-- Section Five Ends -->
      <!-- Row Ends Permession by BDO-->


      <!-- Row Three Permission by DC -->
           <!-- Section Five -->
           <sec:authorize access="hasAuthority('Admin')">
               <c:if test="${userdata.appActionDc == 'P'}">
                  <div class="row user">
                     <div class="col-md-12">
                        <div class="tab-content">
                           <div id="user-timeline">
                              <div class="timeline-post">
                                 <h2>Approve/Reject Application</h2>
                                 <hr>

                                 <div class="row">
                                 <div class="col-lg-12">
         <form:form method="POST"  modelAttribute="actionForm" action="${pageContext.request.contextPath}/updateApplication" class="form-signin">
                 <spring:bind path="action">
                         <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                            <form:label  path="action" > Please Select any Action </form:label>
                            <form:select  path="action" class="form-control" id="earlierService">
                                  <form:option value=""> --Select-- </form:option>
                                  <form:option value="A"> Approve </form:option>
                                  <form:option value="R"> Reject </form:option>
                                  <form:option value="I"> Incomplete </form:option>
                            </form:select>
                            <form:errors  style="color:red;" path="action"></form:errors>
                         </div>
                          </spring:bind>

               <spring:bind path="comments">
                       <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                          <label for="comments"> <spring:message code="form.addressss"  text="Comments" /> </label>
                          <form:textarea rows="4" path="comments" id="comments" class="form-control" onkeypress="return alpha(event)"  oncopy="return false" onpaste="return false" />
                           <form:errors style="color:red;"  path="comments"></form:errors>
                       </div>
                        </spring:bind>

               <spring:bind path="user_id">
                             <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                                <form:input type="hidden" path="user_id" id="user_id" class="form-control"  value="${userdata.userId}" />
                                 <form:errors style="color:red;"  path="user_id"></form:errors>
                             </div>
                              </spring:bind>

          <input type="submit"  value="<spring:message code="customhiring.submit" text="Submit"/>" class="btn btn-success">
                   <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
         </form:form>
         </div>
                                 </div>


                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  </div>
                  </c:if>
                  </sec:authorize>
                  <!-- Section Five Ends -->
         <!-- Row Ends Permession by DC-->

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/vendorApplicationForm.js"></script>
