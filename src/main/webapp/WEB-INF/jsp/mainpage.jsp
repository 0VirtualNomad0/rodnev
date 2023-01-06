<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <!-- Section More Options-->
      <!--Section Slider and Quick Links-->
      <section>
         <div class="container-fluid" style="margin-top:5px;" >
            <div class="row">

            <div class="col-lg-4">
               <!--Slider Starts-->
               <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                 <ol class="carousel-indicators">
                   <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                   <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                 </ol>
                 <div class="carousel-inner">
                   <div class="carousel-item active">
                     <img class="d-block w-100" style="max-height:300px;" src="${pageContext.request.contextPath}/resources/images/slider1.jpg" alt="First slide">
                   </div>


                 </div>
                 <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                   <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                   <span class="sr-only">Previous</span>
                 </a>
                 <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                   <span class="carousel-control-next-icon" aria-hidden="true"></span>
                   <span class="sr-only">Next</span>
                 </a>
               </div>
               </div>
               <!-- SLIDER ENDS -->

               <!-- About eLahaul-->


                   <div class="card col-lg-4" style="background-color:white;">
                     <div class="card-body"><img src="${pageContext.request.contextPath}/resources/images/vector/agri_logo.jpeg" class="img-thumbnail center" style="max-height:150px;" alt="Image"></div>
                    <div class="card-header bg-primary text-light text-center"><a href="${pageContext.request.contextPath}/vendorAgriForm" style="text-decoration:none; color:white;">Survey Form Agriculture Department</a></div>
                   </div>

                      <div class="card col-lg-4" style="background-color:white;">
                    <div class="card-body"><img src="${pageContext.request.contextPath}/resources/images/vector/animal_hus.jpeg" class="img-thumbnail center" style="max-height:150px;" alt="Image"></div>
                    <div class="card-header bg-primary text-light text-center"><a href="${pageContext.request.contextPath}/vendorForm" style="text-decoration:none; color:white;">Survey Form Animal Husbandry Department</a></div>
                  </div>


               <!-- CM Minister Links-->
            </div>
         </div>
      </section>

      <br>
      <br>
      <br>
      <br>

 <br>
      <br>
      <br>
      <br>

      <!-- Section Marqie Working-->
     <!--  <section class="container-fluid marquee_con" >
         <div class="row">
            <div class="col-lg-12">
               <marquee style="margin-top: auto; margin-bottom: auto;" direction="left"><span style="margin-top: auto; font-weight: bold; margin-top: 5px; margin-bottom: auto; color:#FFF;">TEXT</span></marquee>
            </div>
         </div>
      </section> -->
      <!-- Section Marquee-->
      <!-- Investment Count-->
<hr>


      <!-- Section Marquee-->

      <!-- News and Events ends-->
      <!-- Queries-->

      <a  class="queries_div circle_div" href="#" >
         <img src="${pageContext.request.contextPath}/resources/images/vector/worker.svg" alt="sometext" height="50px" width="50px" />
         <p style="font-size: 14px; color:#5B3560; font-weight: bold;"><spring:message code="mainpage.queries.heading" text="Queries"/></p>
         <div class="queries_menu">
            <div class="container">
               <div class="row">
                    <div  class="queries_live">
                            <div class="queries_key" >
                               <p class="queries_key_p" ><spring:message code="mainpage.queries.general" text="General"/></p>
                            </div>
                            <div class="queries_value">
                               <p class="queries_value_p"><spring:message code="mainpage.queries.general.name" text="Name with Phone"/></p>
                            </div>
                         </div>


                             <div  class="queries_live">
                                    <div class="queries_key" >
                                       <p class="queries_key_p" ><spring:message code="mainpage.queries.technical" text="Technical"/></p>
                                    </div>
                                    <div class="queries_value">
                                       <p class="queries_value_p"><spring:message code="mainpage.queries.technical.name" text="Name with Phone"/></p>
                                    </div>
                             </div>



               </div>
               <div class="row">
                  <p class="queries_text"><spring:message code="mainpage.queries.note" /></p>
               </div>
            </div>
         </div>
      </a>
      <!-- General Queries, Mining Queries and Technical Queries-->