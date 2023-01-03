<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/vendor/auth-light.css">
<div class="container" >
    <div id="loader" class="center" style="display:none;"></div>
    <div class="container grey_top_bar">
             <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.agriculture.heading" /> </p>
    </div>
   <form:form method="POST" onsubmit="return submit_form()" id="register-form" modelAttribute="vendorAgriApplicationForm" enctype="multipart/form-data" action="${pageContext.request.contextPath}/saveagriapplication" class="form-signin">
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
                   <form:input type="text"  id="aadhaarNumber" required="required" oncopy="return false" onpaste="return false" onfocus="this.removeAttribute('readonly');" autocomplete="off" path="aadhaarNumber" maxlength="12" minlength="12"  class="form-control" onKeyPress="return isNumber(event)"  name="aadhaarNumber" onchange="getSurveyUserAgricultureData(this.value);" ></form:input>
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
               <form:errors style="color: red;"  path="gender"></form:errors>
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
               <form:input type="text" id="age" required="required" oncopy="return false" onpaste="return false" path="age" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="2" minlength="2"  class="form-control" onKeyPress="return isNumber(event)"  name="age"  ></form:input>
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
                              <form:input id="itemsForm[0].age" autocomplete="off" onfocus="this.removeAttribute('readonly');" type="text" onKeyPress="return isNumber(event)" oncopy="return false" onpaste="return false"  path="itemsForm[0].age"  class="form-control" maxlength="3"
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
         <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.agri.land.details" /> </p>
      </div>
      <hr>
      <div class="row">

     <spring:bind path="totalLand">
        <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
           <form:label path="totalLand" for="totalLand"><spring:message code="agri.total.land" /></form:label>
           <form:input type="text" id="totalLand" oncopy="return false" onpaste="return false" path="totalLand" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="8" class="form-control floatEntry" name="totalLand"  ></form:input>
           <form:errors style="color: red;"  path="totalLand"></form:errors>
        </div>
     </spring:bind>

       <spring:bind path="cultivatedLand">
         <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
            <form:label path="cultivatedLand" for="cultivatedLand"><spring:message code="agri.cultivated.land" /></form:label>
            <form:input type="text" id="cultivatedLand" oncopy="return false" onpaste="return false" path="cultivatedLand" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="8"  class="form-control floatEntry"  name="cultivatedLand"  ></form:input>
            <form:errors style="color: red;"  path="cultivatedLand"></form:errors>
         </div>
      </spring:bind>

      <spring:bind path="irrigatedLand">
       <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
          <form:label path="irrigatedLand" for="irrigatedLand"><spring:message code="agri.irrigated.land" /></form:label>
          <form:input type="text" id="irrigatedLand" oncopy="return false" onpaste="return false" path="irrigatedLand" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="8"  class="form-control floatEntry"  name="irrigatedLand"  ></form:input>
          <form:errors style="color: red;"  path="irrigatedLand"></form:errors>
       </div>
    </spring:bind>

     <spring:bind path="nonIrrigatedLand">
           <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
              <form:label path="nonIrrigatedLand" for="nonIrrigatedLand"><spring:message code="agri.nonirrigated.land" /></form:label>
              <form:input type="text" id="nonIrrigatedLand" oncopy="return false" onpaste="return false" path="nonIrrigatedLand" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="8" class="form-control floatEntry"  name="nonIrrigatedLand"  ></form:input>
              <form:errors style="color: red;"  path="nonIrrigatedLand"></form:errors>
           </div>
        </spring:bind>


      </div>




 <!-- form.agri.present.crops.grown -->
            <div class="container grey_top_bar">
               <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.agri.present.crops.grown" /> </p>
            </div>
            <hr>
            <div class="row">


             <!-- tableDiv -->
                              <div id="tableDiv_tent" class="col-lg-12">
                                 <div class="row" style="margin-bottom:10px;">
                                    <div class="col-lg-9">
                                       <hr>
                                       <strong>
                                          <spring:message code="form.agri.present.crops.grown"/>
                                       </strong>
                                       <hr>
                                    </div>
                                    <div class="col-lg-3 ">
                                       <br/>
                                       <button type="button"  class="btn btn-success" data-style="slide-right" onclick="return addNewRowCropDetails();" ><spring:message code="form.tent.add.row" /></button>
                                       <button type="button"  class="btn btn-danger" data-style="slide-right" onclick="return deleteRowCropDetails();" ><spring:message code="form.tent.delete.row" /></button>
                                    </div>
                                 </div>
                                 <div class="row" style="margin-top:10px">
                                    <spring:bind path="cropdetailsForm[0].cropType">
                                       <div class="form-group col-lg-2 ${status.error ? 'has-error' : ''}">
                                          <form:label path="cropdetailsForm[0].cropType" for="cropType"><spring:message code="form.agri.crop.type" /></form:label>
                                          <form:select path="cropdetailsForm[0].cropType"   class="form-control" id="cropTypeTable">
                                          </form:select>
                                          <form:errors style="color: red;"  path="cropdetailsForm[0].cropType"></form:errors>
                                       </div>
                                    </spring:bind>
                                    <spring:bind path="cropdetailsForm[0].cropName">
                                       <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                                          <form:label path="cropdetailsForm[0].cropName" for="cropdetailsForm[0].cropName"><spring:message code="form.agri.crop.name" /></form:label>
                                          <form:input id="cropdetailsForm[0].cropName" autocomplete="off" onfocus="this.removeAttribute('readonly');" type="text" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  path="cropdetailsForm[0].cropName"  class="form-control"
                                             autofocus="true"></form:input>
                                          <form:errors style="color: red;"  path="cropdetailsForm[0].cropName"></form:errors>
                                       </div>
                                    </spring:bind>
                                    <spring:bind path="cropdetailsForm[0].cropArea">
                                       <div class="form-group col-lg-2 ${status.error ? 'has-error' : ''}">
                                          <form:label path="cropdetailsForm[0].cropArea" for="cropdetailsForm[0].cropArea"><spring:message code="form.agri.crop.area" /></form:label>
                                          <form:input id="cropdetailsForm[0].cropArea" autocomplete="off" onfocus="this.removeAttribute('readonly');" type="text" oncopy="return false" onpaste="return false"  path="cropdetailsForm[0].cropArea"  class="form-control floatEntry"
                                             autofocus="true"></form:input>
                                          <form:errors style="color: red;"  path="cropdetailsForm[0].cropArea"></form:errors>
                                       </div>
                                    </spring:bind>
                                     <spring:bind path="cropdetailsForm[0].cropProduction">
                                       <div class="form-group col-lg-2 ${status.error ? 'has-error' : ''}">
                                          <form:label path="cropdetailsForm[0].cropProduction" for="cropdetailsForm[0].cropProduction"><spring:message code="form.agri.crop.production" /></form:label>
                                          <form:input id="cropdetailsForm[0].cropProduction" autocomplete="off" onfocus="this.removeAttribute('readonly');" type="text" oncopy="return false" onpaste="return false"  path="cropdetailsForm[0].cropProduction"  class="form-control floatEntry"
                                             autofocus="true"></form:input>
                                          <form:errors style="color: red;"  path="cropdetailsForm[0].cropProduction"></form:errors>
                                       </div>
                                    </spring:bind>
                                    <spring:bind path="cropdetailsForm[0].cropMarketing">
                                       <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                                          <form:label path="cropdetailsForm[0].cropMarketing" for="cropdetailsForm[0].cropMarketing"><spring:message code="form.agri.crop.marketing" /></form:label>
                                          <form:input id="cropdetailsForm[0].cropMarketing" autocomplete="off" onfocus="this.removeAttribute('readonly');" type="text" oncopy="return false" onpaste="return false"  path="cropdetailsForm[0].cropMarketing"  class="form-control floatEntry"
                                             autofocus="true"></form:input>
                                          <form:errors style="color: red;"  path="cropdetailsForm[0].cropMarketing"></form:errors>
                                       </div>
                                    </spring:bind>



                                    <div id="addRowCropDetails" class="col-lg-12">
                                    </div>
                                 </div>
                              </div>

                           <br>


            </div>


 <!-- Other Data -->
            <div class="container grey_top_bar">
               <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="form.heading.other.data" /> </p>
            </div>
            <hr>

            <div class="row">


            <spring:bind path="presentIncome">
                        <div class="form-group  col-lg-3 ${status.error ? 'has-error' : ''}">
                           <form:label path="presentIncome" for="presentIncome"><spring:message code="form.agri.present.income" /></form:label>
            <form:input type="text" id="presentIncome" oncopy="return false" onpaste="return false" path="presentIncome" onfocus="this.removeAttribute('readonly');" autocomplete="off" maxlength="10"  class="form-control floatEntry"  name="presentIncome"  ></form:input>
                           <form:errors style="color: red;"  path="presentIncome"></form:errors>
                        </div>
                     </spring:bind>


                     <spring:bind path="marketableSystem">
                                 <div class="form-group  col-lg-3 ${status.error ? 'has-error' : ''}">
                                    <form:label path="marketableSystem" for="marketableSystem"><spring:message code="form.agri.present.marketable.system" /></form:label>
                                    <form:textarea id="marketableSystem" rows="4" type="text" autocomplete="off" onfocus="this.removeAttribute('readonly');" oncopy="return false" onpaste="return false" path="marketableSystem" maxlength="40" minlength="10"  class="form-control"  name="marketableSystem"  />
                                    <form:errors style="color: red;"  path="marketableSystem"></form:errors>
                                 </div>
                              </spring:bind>



                              <spring:bind path="infrareq">
                                          <div class="form-group  col-lg-6 ${status.error ? 'has-error' : ''}">
                                             <form:label path="infrareq" for="infrareq"><spring:message code="form.agri.infra" /></form:label>
                                             <form:textarea id="infrareq" rows="4" type="text" autocomplete="off" onfocus="this.removeAttribute('readonly');"  oncopy="return false" onpaste="return false" path="infrareq" maxlength="40" minlength="10"  class="form-control"  name="infrareq"  />
                                             <form:errors style="color: red;"  path="infrareq"></form:errors>
                                          </div>
                                       </spring:bind>

             <spring:bind path="trainingAgri">
                        <div class="form-group  col-lg-12 ${status.error ? 'has-error' : ''}">
                           <form:label path="trainingAgri" for="trainingAgri"><spring:message code="form.agri.natural.farming.training" /></form:label>
                           <form:textarea id="trainingAgri" rows="4" type="text" autocomplete="off" onfocus="this.removeAttribute('readonly');" oncopy="return false" onpaste="return false" path="trainingAgri" maxlength="40" minlength="10"  class="form-control"  name="trainingAgri"  />
                           <form:errors style="color: red;"  path="trainingAgri"></form:errors>
                        </div>
                     </spring:bind>

             <spring:bind path="naturalFarming">
               <div class="form-group col-lg-6  ${status.error ? 'has-error' : ''}">
                  <form:label path="naturalFarming" for="naturalFarming"><spring:message code="form.agri.natural.farming" /></form:label>
                   <form:select path="naturalFarming"  name="naturalFarming" class="form-control" id="naturalFarming">
                    <form:option value="0"> --Select--</form:option>
                     <form:option value="1"> Yes</form:option>
                      <form:option value="2"> No</form:option>
                    </form:select>
                  <form:errors style="color: red;"  path="naturalFarming"></form:errors>
               </div>
            </spring:bind>

             <spring:bind path="fullPartial">
                           <div class="form-group col-lg-6  ${status.error ? 'has-error' : ''}">
                              <form:label path="fullPartial" for="fullPartial"><spring:message code="form.agri.natural.farming.fullPartial" /></form:label>
                               <form:select path="fullPartial"  name="fullPartial" class="form-control" id="fullPartial">
                                <form:option value="0"> --Select--</form:option>
                                 <form:option value="1"> Full </form:option>
                                  <form:option value="2"> Partial</form:option>
                                </form:select>
                              <form:errors style="color: red;"  path="fullPartial"></form:errors>
                           </div>
                        </spring:bind>





                        <spring:bind path="pmkisanbenifit">
                                       <div class="form-group col-lg-12  ${status.error ? 'has-error' : ''}">
                                          <form:label path="pmkisanbenifit" for="pmkisanbenifit"><spring:message code="form.agri.benifit.pmkisan" /></form:label>
                                        <form:select path="pmkisanbenifit"  name="pmkisanbenifit" class="form-control" id="pmkisanbenifit">
                                                            <form:option value="0"> --Select--</form:option>
                                                                                <form:option value="1"> Yes</form:option>
                                                                                 <form:option value="2"> No</form:option>
                                                            </form:select>
                                          <form:errors style="color: red;"  path="pmkisanbenifit"></form:errors>
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
        getCropTypeTable_();
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
    +'<div class="col-lg-3"><div class="form-group"><input oncopy="return false" onpaste="return false" path="itemsForm['+add+'].name" name="itemsForm['+add+'].name"   class="form-control"   /></div></div>'
    +'<div class="col-lg-3"><div class="form-group"><input oncopy="return false" onpaste="return false" maxlength="3" path="itemsForm['+add+'].age" name="itemsForm['+add+'].age"   class="form-control" onKeyPress="return isNumber(event)"  /></div></div>'
    +'<div class="col-lg-3"><div class="form-group"><select path="itemsForm['+add+'].qualification" name="itemsForm['+add+'].qualification" id="qualification'+add+'"   class="form-control"  ></select></div></div>'
    +'</div>'

   	add++;
        $("#addRow").append(row);
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

var addCropDetails= 0+${countAddCrop+1};
console.log(addCropDetails);
var statusCropDetails=0;

    function addNewRowCropDetails()
      {
       getCropType(addCropDetails);
      	var row ='<div class="row " id="id'+addCropDetails+'">'
       +'<div class="col-lg-2"><div class="form-group"><select path="cropdetailsForm['+addCropDetails+'].cropType" name="cropdetailsForm['+addCropDetails+'].cropType" id="cropType'+addCropDetails+'"   class="form-control"  ></select></div></div>'
       +'<div class="col-lg-3"><div class="form-group"><input oncopy="return false" onpaste="return false" maxlength="50" path="cropdetailsForm['+addCropDetails+'].cropName" name="cropdetailsForm['+addCropDetails+'].cropName"   class="form-control"   /></div></div>'
       +'<div class="col-lg-2"><div class="form-group"><input oncopy="return false" onpaste="return false" maxlength="10" path="cropdetailsForm['+addCropDetails+'].cropArea" name="cropdetailsForm['+addCropDetails+'].cropArea"   class="form-control floatEntry" onKeyPress="return floatCheck(event)"/></div></div>'
       +'<div class="col-lg-2"><div class="form-group"><input oncopy="return false" onpaste="return false" maxlength="10" path="cropdetailsForm['+addCropDetails+'].cropProduction" name="cropdetailsForm['+addCropDetails+'].cropProduction"   class="form-control floatEntry" onKeyPress="return floatCheck(event)" /></div></div>'
       +'<div class="col-lg-3"><div class="form-group"><input oncopy="return false" onpaste="return false" maxlength="10" path="cropdetailsForm['+addCropDetails+'].cropMarketing" name="cropdetailsForm['+addCropDetails+'].cropMarketing"   class="form-control floatEntry" onKeyPress="return floatCheck(event)" /></div></div>'

       +'</div>'

      	addCropDetails++;
           $("#addRowCropDetails").append(row);
      }


    function deleteRowCropDetails()
      {

      	if(addCropDetails==0){
      		alert("Last Row can Not be deleted !!")
      	}else{

      		$("#id"+(addCropDetails-1)).remove();
      		addCropDetails--;
      	}
      }



   function changeValues(){
      getVendor();
      document.getElementById("tableDiv_tent").style.display = "none";
   }


</script>