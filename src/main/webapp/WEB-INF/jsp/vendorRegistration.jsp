<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/vendor/auth-light.css">
<div class="container" >
    <div id="loader" class="center" style="display:none;"></div>
    <div class="container grey_top_bar">
         <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.animal.husbandry.heading" /> </p>
    </div>
   <form:form method="POST" onsubmit="return submit_form()" id="register-form" modelAttribute="vendorApplicationForm" enctype="multipart/form-data" action="${pageContext.request.contextPath}/saveapplication" class="form-signin">
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
      <div class="container grey_top_bar">
         <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.heading.one" /> </p>
      </div>
      <hr>





        <div class="row">
       <spring:bind path="aadhaarNumber">
                <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
                   <form:label path="aadhaarNumber"  for="aadhaarNumber"><spring:message code="form.aadhaarnumber" /></form:label>
                   <form:input type="text"  id="aadhaarNumber" required="required" oncopy="return false" onpaste="return false" onfocus="this.removeAttribute('readonly');" autocomplete="off" path="aadhaarNumber" maxlength="12" minlength="12"  class="form-control" onKeyPress="return isNumber(event)"  name="aadhaarNumber"  onchange="getSurveyUserAnimalHusbandryData(this.value);"></form:input>
                   <form:errors style="color: red;"  path="aadhaarNumber"></form:errors>
                </div>
             </spring:bind>
</div><br></hr>

  <div class="row">

         <spring:bind path="firstname">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="firstname" for="firstname"><spring:message code="form.username.first" /></form:label>
               <form:input id="firstname" type="text" required="required" onkeypress="return alpha(event)" oncopy="return false" onfocus="this.removeAttribute('readonly');" onpaste="return false" autocomplete="off" path="firstname" name="firstname" class="form-control"
                  autofocus="true"></form:input>
               <form:errors style="color: red;"  path="firstname"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="lastname">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="lastname" for="lastname"><spring:message code="form.username.last" /></form:label>
               <form:input id="lastname" type="text" onkeypress="return alpha(event)" oncopy="return false" onfocus="this.removeAttribute('readonly');" onpaste="return false" autocomplete="off"  path="lastname" name="lastname" class="form-control"
                  autofocus="true"></form:input>
               <form:errors style="color: red;"  path="lastname"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="gender">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="gender" for="gender"><spring:message code="form.gender" /></form:label>
               <form:select path="gender"  name="gender" class="form-control" id="gender">
               </form:select>
               <form:errors style="color: red;" path="gender"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="mobileNumber">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="mobileNumber"  for="mobileNumber"><spring:message code="form.mobile" /></form:label>
               <form:input type="text"  id="mobileNumber" required="required" oncopy="return false" onpaste="return false" onfocus="this.removeAttribute('readonly');" autocomplete="off" path="mobileNumber" maxlength="10" minlength="10"  class="form-control" onKeyPress="return isNumber(event)"  name="mobileNumber" ></form:input>
               <form:errors style="color: red;"  path="mobileNumber"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="age">
            <div class="form-group col-lg-4  ${status.error ? 'has-error' : ''}">
               <form:label path="age" for="age"><spring:message code="form.age" /></form:label>
               <form:input type="text" id="age" required="required" oncopy="return false" onpaste="return false" path="age" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="2"  class="form-control" onKeyPress="return isNumber(event)"  name="age"  ></form:input>
               <form:errors style="color: red;"  path="age"></form:errors>
            </div>
         </spring:bind>

         <spring:bind path="category">
                     <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
                        <form:label path="category" for="category"><spring:message code="form.category" /></form:label>
                        <form:select path="category"  name="category" class="form-control" id="castecategory">
                        </form:select>
                        <form:errors style="color: red;"  path="category"></form:errors>
                     </div>
                  </spring:bind>

         <br>
         <spring:bind path="familyHead">
         <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
            <form:label path="familyHead" for="familyHead"><spring:message code="form.familyHead" /></form:label>
            <form:input id="familyHead" type="text" onkeypress="return alpha(event)" oncopy="return false" onfocus="this.removeAttribute('readonly');" onpaste="return false" autocomplete="off" path="familyHead" name="familyHead" class="form-control"
               autofocus="true"></form:input>
            <form:errors style="color: red;"  path="familyHead"></form:errors>
         </div>
      </spring:bind>

        <spring:bind path="educationalQualification">
           <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
              <form:label path="educationalQualification" for="educationalQualification"><spring:message code="form.educationalQualification" /></form:label>
              <form:select path="educationalQualification"  name="educationalQualification" class="form-control" id="educationalQualification">
              </form:select>
              <form:errors style="color: red;"  path="educationalQualification"></form:errors>
           </div>
        </spring:bind>


      </div>
      <!-- Address (Local) -->
      <br>
      <div class="container grey_top_bar">
         <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.heading.two" /> </p>
      </div>
      <hr>
      <div class="row">
         <spring:bind path="state">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="state" for="state"><spring:message code="form.local.state" /></form:label>
               <form:select path="state"  name="state" class="form-control" id="state">
               </form:select>
               <form:errors style="color: red;"  path="state"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="localDistrict">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="localDistrict" for="localDistrict"><spring:message code="form.local.district" /></form:label>
               <form:select path="localDistrict"  name="localDistrict" class="form-control" id="localDistrict" onchange="getBlocks(this.value);">
               </form:select>
               <form:errors style="color: red;"  path="localDistrict"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="localBlock">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="localBlock" for="localBlock"><spring:message code="form.local.block" /></form:label>
               <form:select path="localBlock" onchange="getWardPanchayat(this.value);"  name="localBlock" class="form-control" id="localBlock">
               </form:select>
               <form:errors style="color: red;"  path="localBlock"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="localgp">
            <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="localgp" for="localgp"><spring:message code="form.local.grampanchayat" /></form:label>
               <form:select path="localgp"  name="localgp" class="form-control" id="localgp">
               </form:select>
               <form:errors style="color: red;"  path="localgp"></form:errors>
            </div>
         </spring:bind>

          <spring:bind path="villageName">
                     <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
                        <form:label path="villageName" for="villageName"><spring:message code="form.villageName" /></form:label>
                        <form:input id="villageName" type="text" onkeypress="return alpha(event)"  onfocus="this.removeAttribute('readonly');"  autocomplete="off" path="villageName" name="villageName" class="form-control"
                           autofocus="true"></form:input>
                        <form:errors style="color: red;"  path="villageName"></form:errors>
                     </div>
                  </spring:bind>

         <spring:bind path="p_address">
            <div class="form-group  col-lg-4 ${status.error ? 'has-error' : ''}">
               <form:label path="p_address" for="p_address"><spring:message code="form.local.fulladdress" /></form:label>
               <form:textarea id="p_address" rows="4" type="text" autocomplete="off" onfocus="this.removeAttribute('readonly');"  required="required" oncopy="return false" onpaste="return false" path="p_address" maxlength="40" minlength="10"  class="form-control"  name="p_address"  />
               <form:errors style="color: red;"  path="p_address"></form:errors>
            </div>
         </spring:bind>



                  <!-- tableDiv -->
                  <div id="tableDiv_tent" class="col-lg-12">
                     <div class="row" style="margin-bottom:10px;">
                        <div class="col-lg-9">
                           <hr>
                           <strong>
                              <spring:message code="form.item.heading"/>
                           </strong>
                           <hr>
                        </div>
                        <div class="col-lg-3 ">
                           <br/>
                           <button type="button"  class="btn btn-success" data-style="slide-right" onclick="return addNewRow();" ><spring:message code="form.tent.add.row" /></button>
                           <button type="button"  class="btn btn-danger" data-style="slide-right" onclick="return deleteRow();" ><spring:message code="form.tent.delete.row" /></button>
                        </div>
                     </div>
                     <div class="row" style="margin-top:10px">
                        <spring:bind path="itemsForm[0].gender">
                           <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                              <form:label path="itemsForm[0].gender" for="gender"><spring:message code="form.item.gender" /></form:label>
                              <form:select path="itemsForm[0].gender"   class="form-control" id="genderTable">
                              </form:select>
                              <form:errors style="color: red;"  path="itemsForm[0].gender"></form:errors>
                           </div>
                        </spring:bind>
                        <spring:bind path="itemsForm[0].name">
                           <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                              <form:label path="itemsForm[0].name" for="itemsForm[0].name"><spring:message code="form.item.name" /></form:label>
                              <form:input id="itemsForm[0].name" autocomplete="off" onfocus="this.removeAttribute('readonly');" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  path="itemsForm[0].name"  class="form-control"
                                 autofocus="true"></form:input>
                              <form:errors style="color: red;"  path="itemsForm[0].name"></form:errors>
                           </div>
                        </spring:bind>
                        <spring:bind path="itemsForm[0].age">
                           <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                              <form:label path="itemsForm[0].age" for="itemsForm[0].age"><spring:message code="form.item.age" /></form:label>
                              <form:input id="itemsForm[0].age" autocomplete="off" onfocus="this.removeAttribute('readonly');" type="text" onkeypress="return isNumber(event)" maxlength="2" oncopy="return false" onpaste="return false"  path="itemsForm[0].age"  class="form-control"
                                 autofocus="true"></form:input>
                              <form:errors style="color: red;"  path="itemsForm[0].age"></form:errors>
                           </div>
                        </spring:bind>
                        <spring:bind path="itemsForm[0].qualification">
                           <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                              <form:label path="itemsForm[0].qualification" for="qualification"><spring:message code="form.item.qualification" /></form:label>
                              <form:select path="itemsForm[0].qualification"   class="form-control" id="qualificationTable">
                              </form:select>
                              <form:errors style="color: red;"  path="itemsForm[0].qualification"></form:errors>
                           </div>
                        </spring:bind>

                        <div id="addRow" class="col-lg-12">
                        </div>
                     </div>
                  </div>

               <br>



      </div>

      <!-- Employment Type -->
      <div class="container grey_top_bar">
         <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.heading.four" /> </p>
      </div>
      <hr>
      <div class="row">

     <spring:bind path="governmentEmp">
        <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
           <form:label path="governmentEmp" for="governmentEmp"><spring:message code="form.governmentEmp" /></form:label>
           <form:input type="text" id="governmentEmp" oncopy="return false" onpaste="return false" path="governmentEmp" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="2"  class="form-control" onKeyPress="return isNumber(event)"  name="governmentEmp"  ></form:input>
           <form:errors style="color: red;"  path="governmentEmp"></form:errors>
        </div>
     </spring:bind>

       <spring:bind path="selfEmp">
         <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
            <form:label path="selfEmp" for="selfEmp"><spring:message code="form.selfEmp" /></form:label>
            <form:input type="text" id="selfEmp" oncopy="return false" onpaste="return false" path="selfEmp" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="2"  class="form-control" onKeyPress="return isNumber(event)"  name="selfEmp"  ></form:input>
            <form:errors style="color: red;"  path="selfEmp"></form:errors>
         </div>
      </spring:bind>

      <spring:bind path="outsourcedEmp">
       <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
          <form:label path="selfEmp" for="outsourcedEmp"><spring:message code="form.outsourcedEmp" /></form:label>
          <form:input type="text" id="outsourcedEmp" oncopy="return false" onpaste="return false" path="outsourcedEmp" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="2"  class="form-control" onKeyPress="return isNumber(event)"  name="outsourcedEmp"  ></form:input>
          <form:errors style="color: red;"  path="outsourcedEmp"></form:errors>
       </div>
    </spring:bind>

     <spring:bind path="pmuEmp">
           <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
              <form:label path="selfEmp" for="pmuEmp"><spring:message code="form.pmuEmp" /></form:label>
              <form:input type="text" id="pmuEmp" oncopy="return false" onpaste="return false" path="pmuEmp" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="2"  class="form-control" onKeyPress="return isNumber(event)"  name="pmuEmp"  ></form:input>
              <form:errors style="color: red;"  path="pmuEmp"></form:errors>
           </div>
        </spring:bind>

       <spring:bind path="privateEmp">
                <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
                   <form:label path="privateEmp" for="privateEmp"><spring:message code="form.privateEmp" /></form:label>
                   <form:input type="text" id="privateEmp" oncopy="return false" onpaste="return false" path="privateEmp" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="2"  class="form-control" onKeyPress="return isNumber(event)"  name="privateEmp"  ></form:input>
                   <form:errors style="color: red;"  path="privateEmp"></form:errors>
                </div>
             </spring:bind>


      </div>


        <!-- Number of Animals Being Rared (Species Wise) -->
            <div class="container grey_top_bar">
               <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.heading.species" /> </p>
            </div>
            <hr>
            <div class="row">

           <spring:bind path="cowNum">
              <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
                 <form:label path="cowNum" for="cowNum"><spring:message code="form.cowNum" /></form:label>
                 <form:input type="text" id="cowNum" oncopy="return false" onpaste="return false" path="cowNum" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="4"  class="form-control" onKeyPress="return isNumber(event)"  name="cowNum"  ></form:input>
                 <form:errors style="color: red;"  path="cowNum"></form:errors>
              </div>
           </spring:bind>

             <spring:bind path="buffaloNum">
               <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
                  <form:label path="buffaloNum" for="buffaloNum"><spring:message code="form.buffaloNum" /></form:label>
                  <form:input type="text" id="buffaloNum" oncopy="return false" onpaste="return false" path="buffaloNum" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="4"  class="form-control" onKeyPress="return isNumber(event)"  name="buffaloNum"  ></form:input>
                  <form:errors style="color: red;"  path="buffaloNum"></form:errors>
               </div>
            </spring:bind>

            <spring:bind path="otherNum">
             <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
                <form:label path="otherNum" for="otherNum"><spring:message code="form.otherNum" /></form:label>
                <form:input type="text" id="otherNum" oncopy="return false" onpaste="return false" path="otherNum" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="4"  class="form-control" onKeyPress="return isNumber(event)"  name="otherNum"  ></form:input>
                <form:errors style="color: red;"  path="otherNum"></form:errors>
             </div>
          </spring:bind>

           <spring:bind path="totalNum">
                 <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
                    <form:label path="selfEmp" for="totalNum"><spring:message code="form.totalNum" /></form:label>
                    <form:input type="text" id="totalNum" oncopy="return false" onpaste="return false" path="totalNum" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="4"  class="form-control" onKeyPress="return isNumber(event)"  name="totalNum"  ></form:input>
                    <form:errors style="color: red;"  path="totalNum"></form:errors>
                 </div>
              </spring:bind>

            </div>

 <!-- Milf Production Per Litre -->
            <div class="container grey_top_bar">
               <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.heading.production.milk" /> </p>
            </div>
            <hr>
            <div class="row">

           <spring:bind path="cowMilkProduction">
              <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
                 <form:label path="cowMilkProduction" for="cowMilkProduction"><spring:message code="form.cowNum" /></form:label>
                 <form:input type="text" id="cowMilkProduction" oncopy="return false" onpaste="return false" path="cowMilkProduction" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="8"  class="form-control floatEntry"  name="cowMilkProduction"  ></form:input>
                 <form:errors style="color: red;"  path="cowMilkProduction"></form:errors>
              </div>
           </spring:bind>

             <spring:bind path="buffaloMilkProduction">
               <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
                  <form:label path="buffaloMilkProduction" for="buffaloMilkProduction"><spring:message code="form.buffaloNum" /></form:label>
                  <form:input type="text" id="buffaloMilkProduction" oncopy="return false" onpaste="return false" path="buffaloMilkProduction" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="8"  class="form-control floatEntry"  name="buffaloMilkProduction"  ></form:input>
                  <form:errors style="color: red;"  path="buffaloMilkProduction"></form:errors>
               </div>
            </spring:bind>

             <spring:bind path="houseMilkProduction">
                           <div class="form-group col-lg-5  ${status.error ? 'has-error' : ''}">
                              <form:label path="houseMilkProduction" for="houseMilkProduction"><spring:message code="form.heading.production.milk.household" /></form:label>
                              <form:input type="text" id="houseMilkProduction" oncopy="return false" onpaste="return false" path="houseMilkProduction" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="8"  class="form-control floatEntry"  name="houseMilkProduction"  ></form:input>
                              <form:errors style="color: red;"  path="houseMilkProduction"></form:errors>
                           </div>
                        </spring:bind>
            </div>


 <!-- Details of Milk being Sold Per day -->
            <div class="container grey_top_bar">
               <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.heading.milk.sold" /> </p>
            </div>
            <hr>
            <div class="row">



             <spring:bind path="milkquantitySold">
               <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
                  <form:label path="milkquantitySold" for="milkquantitySold"><spring:message code="form.milkquantitySold" /></form:label>
                  <form:input type="text" id="milkquantitySold" oncopy="return false" onpaste="return false" path="milkquantitySold" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="8"  class="form-control floatEntry" name="milkquantitySold"  ></form:input>
                  <form:errors style="color: red;"  path="milkquantitySold"></form:errors>
               </div>
            </spring:bind>

             <spring:bind path="milkwheresold">
                           <div class="form-group col-lg-6  ${status.error ? 'has-error' : ''}">
                              <form:label path="milkwheresold" for="milkwheresold"><spring:message code="form.milkwheresold" /></form:label>
 <form:textarea id="milkwheresold" rows="4" type="text" autocomplete="off" onfocus="this.removeAttribute('readonly');" oncopy="return false" onpaste="return false" path="milkwheresold" maxlength="255"   class="form-control"  name="milkwheresold"  />
                                            <form:errors style="color: red;"  path="milkwheresold"></form:errors>
                           </div>
                        </spring:bind>

                        <spring:bind path="milksellingprice">
                                       <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
                                          <form:label path="milksellingprice" for="milksellingprice"><spring:message code="form.milksellingprice" /></form:label>
                                          <form:input type="text" id="milksellingprice" oncopy="return false" onpaste="return false" path="milksellingprice" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="8"  class="form-control floatEntry"  name="milksellingprice"  ></form:input>
                                          <form:errors style="color: red;"  path="milksellingprice"></form:errors>
                                       </div>
                                    </spring:bind>
            </div>



 <!-- Other Data -->
            <div class="container grey_top_bar">
               <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.heading.other.data" /> </p>
            </div>
            <hr>

            <div class="row">

             <spring:bind path="willingsellmilk">
               <div class="form-group col-lg-6  ${status.error ? 'has-error' : ''}">
                  <form:label path="willingsellmilk" for="willingsellmilk"><spring:message code="form.willing.sell.milk" /></form:label>
                   <form:select path="willingsellmilk"  name="willingsellmilk" class="form-control" id="willingsellmilk">
                    <form:option value="0"> --Select--</form:option>
                     <form:option value="1"> Yes</form:option>
                      <form:option value="2"> No</form:option>
                    </form:select>
                  <form:errors style="color: red;"  path="willingsellmilk"></form:errors>
               </div>
            </spring:bind>



             <spring:bind path="qyantitytosell">
                           <div class="form-group col-lg-6  ${status.error ? 'has-error' : ''}">
                              <form:label path="qyantitytosell" for="qyantitytosell"><spring:message code="form.quantity.sell.milk" /></form:label>
                                                                        <form:input type="text" id="qyantitytosell" oncopy="return false" onpaste="return false" path="qyantitytosell" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="8"  class="form-control floatEntry"  name="qyantitytosell"  ></form:input>

              <form:errors style="color: red;"  path="qyantitytosell"></form:errors>
                           </div>
                        </spring:bind>

                        <spring:bind path="willingtosell">
                                       <div class="form-group col-lg-12  ${status.error ? 'has-error' : ''}">
                                          <form:label path="willingtosell" for="willingtosell"><spring:message code="form.willing.govt.assistance" /></form:label>
                                        <form:select path="willingtosell"  name="willingtosell" class="form-control" id="willingtosell">
                                                            <form:option value="0"> --Select--</form:option>
                                                                                <form:option value="1"> Yes</form:option>
                                                                                 <form:option value="2"> No</form:option>
                                                            </form:select>
                                          <form:errors style="color: red;"  path="willingtosell"></form:errors>
                                       </div>
                                    </spring:bind>
            </div>





      <div class="row breadcrumb" style="margin-bottom:10px;">
         <div class="form-group">

         </div>
         <div class="form-group col-lg-12">
            <button class="btn btn-success btn-block" type="submit">Submit</button>
            <c:remove var="successMessage" scope="session" />
         </div>
      </div>
   </form:form>
</div>
<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/vendor/script.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/vendorApplicationForm.js"></script>
<script type="text/javascript">
   $( document ).ready(function() {
       getCasteCategories();
       getQualifications();
       getgender();
       getState();
       getDistrictsViaState('9');
        getGenderTable_();
        getQualificationsTable_();
   });

   var add= 0+${count+1};
   console.log(add);
   var status=0;

    function addNewRow()
   {
    getGenderTable(add);
    getQualificationTable(add);
   	var row ='<div class="row " id="id'+add+'">'
    +'<div class="col-lg-3"><div class="form-group"><select path="itemsForm['+add+'].gender" name="itemsForm['+add+'].gender" id="gender'+add+'"   class="form-control"  ></select></div></div>'
    +'<div class="col-lg-3"><div class="form-group"><input oncopy="return false" onpaste="return false"  path="itemsForm['+add+'].name" name="itemsForm['+add+'].name"   class="form-control"   /></div></div>'
    +'<div class="col-lg-3"><div class="form-group"><input oncopy="return false" onpaste="return false"  path="itemsForm['+add+'].age" name="itemsForm['+add+'].age"   class="form-control"onKeyPress="return isNumber(event)"   /></div></div>'
    +'<div class="col-lg-3"><div class="form-group"><select path="itemsForm['+add+'].qualification" name="itemsForm['+add+'].qualification" id="qualification'+add+'"   class="form-control"  ></select></div></div>'
    +'</div>'

   	add++;
        $("#addRow").append(row);
        $('.bootstrap-select').selectpicker('render');
   }

   function deleteRow()
   {

   	if(add==0){
   		alert("Last Row can Not be deleted !!")
   	}else{

   		$("#id"+(add-1)).remove();
   		add--;
   	}
   }

   function calculateDays(){
   var from_date = document.getElementById("fromDate").value;
   var to_date = document.getElementById("toDate").value;

                  var date1 = new Date(from_date);
                  var date2 = new Date(to_date);

                  var time_difference = date2.getTime() - date1.getTime();
                           var result = time_difference / (1000 * 60 * 60 * 24);

                            document.getElementById("totalDays").value = result+1;



   }

   function changeValues(){
      getVendor();
      document.getElementById("tableDiv_tent").style.display = "none";
   }


</script>