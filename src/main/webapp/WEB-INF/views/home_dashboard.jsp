<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="content-wrapper">
            <!-- START PAGE CONTENT-->
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="ibox bg-success color-white widget-stat">
                            <div class="ibox-body">
                                <h2 class="m-b-5 font-strong">${totalApplications}</h2>
                                <div class="m-b-5">Total Applications </div><i class="ti-shopping-cart widget-stat-icon"></i>
                                <div><i class="m-r-5"></i><small>&nbsp;</small></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="ibox bg-info color-white widget-stat">
                            <div class="ibox-body">
                                <h2 class="m-b-5 font-strong">${approvedApplications}</h2>
                                <div class="m-b-5">Approved Applications </div><i class="ti-bar-chart widget-stat-icon"></i>
                                <div><i class="m-r-5"></i><small>&nbsp;</small></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="ibox bg-warning color-white widget-stat">
                            <div class="ibox-body">
                                <h2 class="m-b-5 font-strong">${pendingApplications}</h2>
                                <div class="m-b-5">Pending Applications</div><i class="fa fa-money widget-stat-icon"></i>
                                <div><i class="m-r-5"></i><small>&nbsp;</small></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="ibox bg-danger color-white widget-stat">
                            <div class="ibox-body">
                                <h2 class="m-b-5 font-strong">${rejectedApplications}</h2>
                                <div class="m-b-5">Rejected Applications</div><i class="ti-user widget-stat-icon"></i>
                                <div><i class="m-r-5"></i><small>&nbsp;</small></div>
                            </div>
                        </div>
                    </div>
                </div>







            </div>

        </div>

