<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/datatable/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/datatable/dataTables.bootstrap.min.css"/>

<style>
div#agriSurveyUsers_wrapper {
    display: initial !important;
}

div#agriSurveyUsers_wrapper label {
    display: initial !important;
}
</style>

<div class="content-wrapper">
            <!-- START PAGE CONTENT-->
            <div class="page-content fade-in-up">
                <div class="row">
                <c:if test = "${userRole == 'superAdmin'}">
                    <div class="col-lg-3 col-md-6">
                        <div class="ibox bg-success color-white widget-stat">
                            <div class="ibox-body">
                                <h2 class="m-b-5 font-strong">${totalUsers}</h2>
                               <a href="#" style="color:white;">  <div class="m-b-5">Total Survey count </div><i class="ti-shopping-cart widget-stat-icon"></i> </a>
                                <div><i class="m-r-5"></i><small>&nbsp;</small></div>
                            </div>
                        </div>
                    </div>
                    </c:if>

                    <c:if test = "${userRole == 'superAdmin' || userRole == 'agricultureDept'}">
                    <div class="col-lg-3 col-md-6">
                        <div class="ibox bg-info color-white widget-stat">
                            <div class="ibox-body">
                                <h2 class="m-b-5 font-strong">${totalAgricultureSurveys}</h2>
                                 <a href="#" onclick="loadDataTable('/agriculture-survey-users'); return false;" style="color:white;"> <div class="m-b-5">Agriculture Surveys count </div><i class="ti-bar-chart widget-stat-icon"></i></a>
                                <div><i class="m-r-5"></i><small>&nbsp;</small></div>
                            </div>
                        </div>
                    </div>
                    </c:if>

                    <c:if test = "${userRole == 'superAdmin' || userRole == 'animalHusbandryDept'}">
                    <div class="col-lg-3 col-md-6">
                        <div class="ibox bg-warning color-white widget-stat">
                            <div class="ibox-body">
                                <h2 class="m-b-5 font-strong">${totalAnimalHusbandrySurveys}</h2>
                                <a href="#" onclick="loadDataTable('/animal-husbandry-survey-users'); return false;" style="color:white;"> <div class="m-b-5">Animal Husbandry Survey count</div><i class="fa fa-money widget-stat-icon"></i> </a>
                                <div><i class="m-r-5"></i><small>&nbsp;</small></div>
                            </div>
                        </div>
                    </div>
                    </c:if>
                </div>
            </div>
            <table id="agriSurveyUsers" class="table table-bordered table-striped">
                <thead>
                    <tr>
                       <th>ID</th>
                       <th>Aadhaar Number</th>
                       <th>Firstname</th>
                       <th>Lastname</th>
                       <th>MobileNumber</th>
                       <th>Age</th>
                       <th>District</th>
                       <th>Block</th>
                       <th>Gender</th>
                       <th>Permanent Address</th>
                       <th>Created On</th>
                    </tr>
                </thead>
            </table>
            <div class="modal fade" id="detailModal" tabindex="-1" role="dialog"
              aria-hidden="true">
              <div class="modal-dialog modal-lg" style="max-height: 400px; overflow-y: auto;" role="document">
                <div class="modal-content">
                  <!--Header-->
                  <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">Your cart</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">×</span>
                    </button>
                  </div>
                  <!--Body-->
                  <div class="modal-body">
                  </div>
                  <!--Footer-->
                  <div class="modal-footer">
                    <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Close</button>
                  </div>
                </div>
              </div>
            </div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/datatable/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/datatable/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.spring-friendly.js"></script>

<script type="text/javascript">
var activeURL;
    function loadDataTable(url) {
    activeURL = url;
        datatable.ajax.url(url).load();
    }

    var datatable = $('table#agriSurveyUsers').DataTable({
        ajax: '${userRole}' == 'animalHusbandryDept' ? '/animal-husbandry-survey-users'
         : '/agriculture-survey-users',
        serverSide: true,
        columns: [
            {
                data: 'surveyUserId.surveyUserId'
            },
            {
                data: 'surveyUserId.aadhaarNumber'
            },
            {
                data: 'surveyUserId.firstName'
            },
            {
                data: 'surveyUserId.lastName'
            },
            {
                data: 'surveyUserId.mobileNumber'
            },
            {
                data: 'surveyUserId.age',
                render: function (data) { return data != 0 ? data : '-'; }
            },
            {
                data: 'surveyUserId.districtId.districtName'
            },
            {
                data: 'surveyUserId.blockId.blockName'
            },
            {
                data: 'surveyUserId.genderId.genderName'
            },
            {
                data: 'surveyUserId.permanentAddress'
            },
            {
                data: 'surveyUserId.createdDate',
                render : function(d, type, full) {
                               d = new Date(d);
                               month = '' + (d.getMonth() + 1),
                               day = '' + d.getDate(),
                               year = d.getFullYear();

                               if (month.length < 2)
                                 month = '0' + month;
                               if (day.length < 2)
                                 day = '0' + day;

                               return [day, month, year].join('-');
                       }
            },
        ]
    });

   $('table#agriSurveyUsers').on('click', 'tbody tr', function() {
        var surveyUserId = datatable.row(this).data()['surveyUserId']['surveyUserId'];
        console.log('API row values : ', surveyUserId);
        console.log('active url is: ', activeURL);
        if(activeURL=== undefined){
        activeURL = '${userRole}' == 'animalHusbandryDept' ? '/ajax/animal-husbandry-survey-details'
                                                               : '/ajax/agriculture-survey-details';
        }else if(activeURL == '/animal-husbandry-survey-users'
          || activeURL == '/ajax/animal-husbandry-survey-details'){
            activeURL = '/ajax/animal-husbandry-survey-details';
        }else{
            activeURL = '/ajax/agriculture-survey-details';
        }

        $.ajax({
                   url: activeURL,
                   type: 'GET',
                   data: {userid: surveyUserId},
                   success: function(data){
                       var json_ = JSON.parse(data);

                       // Add response in Modal body
                       $('.modal-body').html(json_.RESPONSE);

                       // Display Modal
                       $('#detailModal').modal('show');
                   }
               });
   })
</script>

