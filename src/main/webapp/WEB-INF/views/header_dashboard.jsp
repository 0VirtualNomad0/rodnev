<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>


    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width initial-scale=1.0">
        <title>eVendor Dashboard</title>
        <!-- GLOBAL MAINLY STYLES-->
        <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/vendor/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/vendor/font-awesome.min.css" rel="stylesheet" />
        <link  rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/vendor/themify-icons.css" rel="stylesheet" />
        <!-- PLUGINS STYLES-->
        <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/vendor/jquery-jvectormap-2.0.3.css" rel="stylesheet" />
        <!-- THEME STYLES-->
        <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/vendor/main.min.css" rel="stylesheet" />
        <!-- PAGE LEVEL STYLES-->
    </head>










  <body class="fixed-navbar">
    <div>
            <!-- START HEADER class="page-wrapper"-->
            <header class="header">
                <div class="page-brand">
                    <a class="link" href="index.html">
                        <span class="brand">eVendor
                        </span>

                    </a>
                </div>
                <div class="flexbox flex-1">
                    <!-- START TOP-LEFT TOOLBAR-->
                    <ul class="nav navbar-toolbar">
                        <li>
                            <a class="nav-link sidebar-toggler js-sidebar-toggler"><i class="ti-menu"></i></a>
                        </li>

                    </ul>
                    <!-- END TOP-LEFT TOOLBAR-->
                    <!-- START TOP-RIGHT TOOLBAR-->
                    <ul class="nav navbar-toolbar">
                        <li class="dropdown dropdown-user">
                            <a class="nav-link dropdown-toggle link" data-toggle="dropdown">
                                <img src="${pageContext.request.contextPath}/resources/images/admin-avatar.png" />
                                <span></span>Admin<i class="fa fa-angle-down m-l-5"></i></a>
                            <ul class="dropdown-menu dropdown-menu-right">
                               <!-- <a class="dropdown-item" href="profile.html"><i class="fa fa-user"></i>Profile</a>
                                <a class="dropdown-item" href="profile.html"><i class="fa fa-cog"></i>Settings</a>
                                <a class="dropdown-item" href="javascript:;"><i class="fa fa-support"></i>Support</a>
                                <li class="dropdown-divider"></li> -->
                                <a class="dropdown-item" href="login.html"><i class="fa fa-power-off"></i>Logout</a>
                            </ul>
                        </li>
                    </ul>
                    <!-- END TOP-RIGHT TOOLBAR-->
                </div>
            </header>
            <!-- END HEADER-->
            <!-- START SIDEBAR-->
            <nav class="page-sidebar" id="sidebar">
                <div id="sidebar-collapse">
                    <div class="admin-block d-flex">
                        <div>
                            <img src="${pageContext.request.contextPath}/resources/images/admin-avatar.png" width="45px" />
                        </div>
                        <div class="admin-info">
                            <div class="font-strong">James Brown</div><small>Administrator</small></div>
                    </div>
                    <ul class="side-menu metismenu">
                        <li>
                            <a class="active" href="index.html"><i class="sidebar-item-icon fa fa-th-large"></i>
                                <span class="nav-label">Dashboard</span>
                            </a>
                        </li>
                        <li class="heading">OPTIONS</li>
                        <li>
                            <a href="javascript:;"><i class="sidebar-item-icon fa fa-bookmark"></i>
                                <span class="nav-label">Super Admin Features</span><i class="fa fa-angle-left arrow"></i></a>
                            <ul class="nav-2-level collapse">
                                <li>
                                    <a href="${pageContext.request.contextPath}/createRole">Create Roles</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/createUser">Create Users</a>
                                </li>

                            </ul>
                        </li>
                        <li>
                            <a href="javascript:;"><i class="sidebar-item-icon fa fa-edit"></i>
                                <span class="nav-label">Forms</span><i class="fa fa-angle-left arrow"></i></a>
                            <ul class="nav-2-level collapse">
                                <li>
                                    <a href="form_basic.html">Basic Forms</a>
                                </li>
                                <li>
                                    <a href="form_advanced.html">Advanced Plugins</a>
                                </li>
                                <li>
                                    <a href="form_masks.html">Form input masks</a>
                                </li>
                                <li>
                                    <a href="form_validation.html">Form Validation</a>
                                </li>
                                <li>
                                    <a href="text_editors.html">Text Editors</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:;"><i class="sidebar-item-icon fa fa-table"></i>
                                <span class="nav-label">Tables</span><i class="fa fa-angle-left arrow"></i></a>
                            <ul class="nav-2-level collapse">
                                <li>
                                    <a href="table_basic.html">Basic Tables</a>
                                </li>
                                <li>
                                    <a href="datatables.html">Datatables</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:;"><i class="sidebar-item-icon fa fa-bar-chart"></i>
                                <span class="nav-label">Charts</span><i class="fa fa-angle-left arrow"></i></a>
                            <ul class="nav-2-level collapse">
                                <li>
                                    <a href="charts_flot.html">Flot Charts</a>
                                </li>
                                <li>
                                    <a href="charts_morris.html">Morris Charts</a>
                                </li>
                                <li>
                                    <a href="chartjs.html">Chart.js</a>
                                </li>
                                <li>
                                    <a href="charts_sparkline.html">Sparkline Charts</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:;"><i class="sidebar-item-icon fa fa-map"></i>
                                <span class="nav-label">Maps</span><i class="fa fa-angle-left arrow"></i></a>
                            <ul class="nav-2-level collapse">
                                <li>
                                    <a href="maps_vector.html">Vector maps</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="icons.html"><i class="sidebar-item-icon fa fa-smile-o"></i>
                                <span class="nav-label">Icons</span>
                            </a>
                        </li>
                        <li class="heading">PAGES</li>
                        <li>
                            <a href="javascript:;"><i class="sidebar-item-icon fa fa-envelope"></i>
                                <span class="nav-label">Mailbox</span><i class="fa fa-angle-left arrow"></i></a>
                            <ul class="nav-2-level collapse">
                                <li>
                                    <a href="mailbox.html">Inbox</a>
                                </li>
                                <li>
                                    <a href="mail_view.html">Mail view</a>
                                </li>
                                <li>
                                    <a href="mail_compose.html">Compose mail</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="calendar.html"><i class="sidebar-item-icon fa fa-calendar"></i>
                                <span class="nav-label">Calendar</span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:;"><i class="sidebar-item-icon fa fa-file-text"></i>
                                <span class="nav-label">Pages</span><i class="fa fa-angle-left arrow"></i></a>
                            <ul class="nav-2-level collapse">
                                <li>
                                    <a href="invoice.html">Invoice</a>
                                </li>
                                <li>
                                    <a href="profile.html">Profile</a>
                                </li>
                                <li>
                                    <a href="login.html">Login</a>
                                </li>
                                <li>
                                    <a href="register.html">Register</a>
                                </li>
                                <li>
                                    <a href="lockscreen.html">Lockscreen</a>
                                </li>
                                <li>
                                    <a href="forgot_password.html">Forgot password</a>
                                </li>
                                <li>
                                    <a href="error_404.html">404 error</a>
                                </li>
                                <li>
                                    <a href="error_500.html">500 error</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:;"><i class="sidebar-item-icon fa fa-sitemap"></i>
                                <span class="nav-label">Menu Levels</span><i class="fa fa-angle-left arrow"></i></a>
                            <ul class="nav-2-level collapse">
                                <li>
                                    <a href="javascript:;">Level 2</a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <span class="nav-label">Level 2</span><i class="fa fa-angle-left arrow"></i></a>
                                    <ul class="nav-3-level collapse">
                                        <li>
                                            <a href="javascript:;">Level 3</a>
                                        </li>
                                        <li>
                                            <a href="javascript:;">Level 3</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
            <!-- END SIDEBAR-->



            </div>




  </body>
</html>