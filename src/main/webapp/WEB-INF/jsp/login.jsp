<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/flight_application_form.js"></script>
<section class="container" style="margin-top:30px; margin-bottom:30px;">
   <div class="row">
      <h2 class="col-lg-12 text-center"  style="color:#77332F;"> Login </h2>
      <br>
   </div>
   <div class="row">
      <div class="col-lg-4"> &nbsp </div>
      <div class="col-lg-4" style="padding:10px; marging:10px; background-color:#F2F2F2; ">
         <form  method="post" class="loginForm"  action="${pageContext.request.contextPath}/login">
            <h3 class="login-head"><i class="fa fa-lg fa-fw fa-user"></i>SIGN IN</h3>
            <div class="form-group col-lg-12">
               <label class="control-label" for="username" >Username:</label><br>
               <input class="form-control" type="text" oncopy="return false" autocomplete="off" onfocus="this.removeAttribute('readonly');" onpaste="return false" maxlength="20" onkeypress="return alpha(event)"  required autofocus name="username" id="username">
            </div>
            <div class="form-group col-lg-12">
               <label class="control-label" for="password" >Password:</label><br>
               <input class="form-control" type="password" autocomplete="off" onfocus="this.removeAttribute('readonly');" oncopy="return false" onpaste="return false" name="password"  maxLength="10"  size="10" id="password">
            </div>
            <!-- Captcha -->

               <div class="form-group col-lg-12">

                        <img id="captcha_id" class="col-lg-10" name="imgCaptcha" src="captcha.jpg">
                     <a href="javascript:;" class="col-lg-2" title="change captcha text"  onclick="document.getElementById('captcha_id').src = 'captcha.jpg?' + Math.random();  return false">
                    <i class="fa fa-refresh"></i>
                                             </a>
                        </div>



                       <div class="col-lg-12"><input autocomplete="off" onfocus="this.removeAttribute('readonly');" class="form-control" maxlength="5" required onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"  id="captcha" name="captcha" /></div>
<br>
            <!-- Captcha Ends -->
            <div class="form-group col-lg-12">
               <input class="btn btn-success btn-block col-lg-12" type="submit" name="submit" class="btn btn-info btn-md" value="submit">
               <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            </div>
            <div class="form-group">
               <c:if test="${error != null}">
                <div id="serverError" class="alert alert-warning alert-dismissable fade show plErroMessage">
                           <button class="close" data-dismiss="alert" aria-label="Close">×</button>
                           <strong>Warning!</strong> ${error}</div>

               </c:if>
            </div>
         </form>
      </div>
      <div class="col-lg-3"> &nbsp </div>
   </div>
</section>