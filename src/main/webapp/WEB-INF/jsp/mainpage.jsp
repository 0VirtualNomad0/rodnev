<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <!-- Section More Options-->
      <!--Section Slider and Quick Links-->
      <section>
         <div class="container-fluid" style="margin-top:5px;" >
            <div class="row">

            <div class="col-lg-6">
               <!--Slider Starts-->
               <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                 <ol class="carousel-indicators">
                   <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                   <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                 </ol>
                 <div class="carousel-inner">
                   <div class="carousel-item active">
                     <img class="d-block w-100" style="max-height:300px;" src="${pageContext.request.contextPath}/resources/images/slider1.jpeg" alt="First slide">
                   </div>
                   <div class="carousel-item">
                     <img class="d-block w-100" style="max-height:300px;" src="${pageContext.request.contextPath}/resources/images/slider2.jpeg" alt="Second slide">
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
               <div class="col-lg-6" style="background-color:white;">

                    <div class="card text-center" style="max-height:300px; min-height:300px;">
                        <div class="card-header">&nbsp;</div>
                        <div class="card-body">
                            <h5 class="card-title"><spring:message code="mainpage.about.elahaul.heading"/></h5>
                            <p class="card-text"><spring:message code="mainpage.about.elahaul.paragraph"/></p>

                        </div>
                        <div class="btn btn-primary"><a style="text-decoration:none; color:white;" href="${pageContext.request.contextPath}/vendorForm"><spring:message code="mainpage.about.applyhere"/></a></div>
                    </div>

            </div>
               <!-- CM Minister Links-->
            </div>
         </div>
      </section>
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
<section>
  <div class="container grey_top_bar"> <p style="color:#FFFFFF; margin-top:30px; font-weight: bold; font-size: 20px;"> <spring:message code="mainpage.vending.categories" text="Vending Categories"/></p> </div>
         <div class="container" style=" margin-bottom:10px;">
          <div class="row">
 <div class="col-lg-3">
          <div class="card" >
            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/tent.jpeg" alt="Card image cap">
            <div class="card-body" style="max-height:150px;">
              <p class="card-text" ><spring:message code="mainpage.vending.tentsdhabhas" text="Tents, Dhaba & Camping Sites"/></p>
            </div>
          </div>
          </div>

<div class="col-lg-3">
           <div class="card" >
                      <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/shooting.jpeg" alt="Card image cap">
                      <div class="card-body" style="max-height:150px;">
                        <p class="card-text" ><spring:message code="mainpage.vending.shooting" text="Film Shooting, Documentary Films, Regional and Non Regional Films"/></p>
                      </div>
                    </div>
                    </div>

<div class="col-lg-3">
                     <div class="card" >
                                <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/foodvan.jpeg" alt="Card image cap">
                                <div class="card-body" style="max-height:150px;">
                                  <p class="card-text" ><spring:message code="mainpage.vending.others" text="Food Van, Photography, Local Food"/></p>
                                </div>
                              </div>
                              </div>

<div class="col-lg-3">
                               <div class="card" >
                                          <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/sports.jpeg" alt="Card image cap">
                                          <div class="card-body" style="max-height:150px;">
                                            <p class="card-text" ><spring:message code="mainpage.vending.sports" text="Skiings, Cycling, Bike Riding etc."/></p>
                                          </div>
                                        </div>
                                        </div>


          </div>
         </div>
      </section>

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