<%@ page import="basicDatas.*" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/30
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-Cn">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>师生健康码管理系统</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/Bootstrap-4---Table-Fixed-Header.css">
    <link rel="stylesheet" href="assets/css/Footer-Basic.css">
    <link rel="stylesheet" href="assets/css/Footer-Clean.css">
    <link rel="stylesheet" href="assets/css/Formulario-Farmacia.css">
    <link rel="stylesheet" href="assets/css/Navbar---App-Toolbar--LG--MD---Mobile-Nav--SM--XS-1.css">
    <link rel="stylesheet" href="assets/css/Navbar---App-Toolbar--LG--MD---Mobile-Nav--SM--XS.css">
    <link rel="stylesheet" href="assets/css/Navigation-Clean.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets/css/Sidebar-1-1.css">
    <link rel="stylesheet" href="assets/css/Sidebar-1.css">
    <link rel="stylesheet" href="assets/css/Sidebar-Menu-1.css">
    <link rel="stylesheet" href="assets/css/Sidebar-Menu.css">
    <link rel="stylesheet" href="assets/css/styles.css">
<%--mypage.jsp--%>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">

<%--QRcode.jsp--%>
    <link rel="stylesheet" href="assets/css/Features-Boxed.css">
    <style>
        .none-input {
            pointer-events: none;
        }

        .submit-button {
            display: block;
            width: 20%;
            height: calc(1.5em + .75rem + 2px);
            margin-top: 10px;
            padding: .375rem .75rem;
            font-size: 1rem;
            font-weight: 400;
            line-height: 1.5;
            color: #495057;
            background-color: rgb(234, 245, 254);
            background-clip: padding-box;
            border: 1px solid #ced4da;
            border-radius: .25rem;
            transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;
        }

        .submit-button:hover {
            background-color: rgb(205, 228, 247);
        }
    </style>
</head>

<% LogInDatas lid = (LogInDatas)request.getSession().getAttribute("userLoginDatas"); %>

<body>
<main>
    <div id="wrapper">
        <div class="border rounded-0 shadow" id="sidebar-wrapper"
             style="background-color: rgb(234,245,254);color: rgb(255,255,255);">
            <div id="sidebar-main" class="sidebar sidebar-default sidebar-separate"
                 style="box-shadow: none; border: 0px; background-color: rgb(234,245,254);">
                <div class="sidebar-category sidebar-default"
                     style="box-shadow: none; border: 0px; border-radius: 0px; width: 248px;">
                    <div class="category-title" style="height: 64px; background-color: rgb(234,245,254);">
                            <span
                                    style="color: black; font-size: 1.25rem; line-height: 40px; padding-top: 0">师生健康码管理系统</span>
                    </div>
                    <div class="category-content" style=" background-color: rgb(234,245,254);">
                        <ul id="fruits-nav" class="nav flex-column">
                            <li class="nav-item">
                                <a href="/HealthManagementSystem_war_exploded/mainPage?pageNum=myPage" id="myPage_Button" class="nav-link">
                                    <i class=" " aria-hidden="true"></i> 我的主页
                                </a>
                            </li>
                            <% if(lid.getRole().equals("系统")
                                    || lid.getRole().equals("校级")
                                    || lid.getRole().equals("院级")
                            ) {%>
                            <li class="nav-item">
                                <a href="#other-fruits1" class="nav-link" data-toggle="collapse" role="button"
                                   aria-expanded="false" aria-controls="other-fruits1">
                                    <i class=" " aria-hidden="true"></i> 基本信息管理
                                </a>
                                <ul id="other-fruits1" class="flex-column collapse">
                                    <li class="nav-item">
                                        <a href="/HealthManagementSystem_war_exploded/CollegePage?pageNum=table_college" id="table_college_Button" class="nav-link">
                                            <i class=" " aria-hidden="true"></i> 学院信息
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="/HealthManagementSystem_war_exploded/majorPage?pageNum=table_major" id="table_major_Button" class="nav-link">
                                            <i class=" " aria-hidden="true"></i> 专业信息
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="/HealthManagementSystem_war_exploded/classPage?pageNum=table_class" id="table_class_Button" class="nav-link">
                                            <i class=" " aria-hidden="true"></i> 班级信息
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="/HealthManagementSystem_war_exploded/studentsPage?pageNum=table_student" id="table_student_Button" class="nav-link">
                                            <i class=" " aria-hidden="true"></i> 学生信息
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="/HealthManagementSystem_war_exploded/teachersPage?pageNum=table_teacher" id="table_teacher_Button" class="nav-link">
                                            <i class=" " aria-hidden="true"></i> 教师信息
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item">
                                <a href="/HealthManagementSystem_war_exploded/showDatasPage?pageNum=echartsResult" class="nav-link">
                                    <i class=" " aria-hidden="true"></i> 每日打卡概览
                                </a>
                            </li>
                            <% }%>
                            <li class="nav-item">
                                <a href="/HealthManagementSystem_war_exploded/mainPage?pageNum=fillTable" id="fillTable_Button" class="nav-link">
                                    <i class=" " aria-hidden="true"></i> 每日打卡信息填报
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/HealthManagementSystem_war_exploded/QRcodePage?pageNum=QRcode" id="QRcode_Button" class="nav-link">
                                    <i class=" " aria-hidden="true"></i> 健康码领取
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="page-content-wrapper">
            <div class="container-fluid" style="padding-left: 0px;padding-right: 0px;">
                <header>
                    <nav class="navbar navbar-light navbar-expand-md border rounded-0 shadow-sm"
                         style="padding-left: 0;height: 62px;padding-right: 0px; ">
                        <div class="container-fluid"><a class="btn btn-link" role="button" id="menu-toggle"
                                                        href="#menu-toggle" style="padding-left: -13px;"><i class="fa fa-bars"
                                                                                                            style="color: rgb(17,206,218);"></i></a>
                            <div>
                                <a class="navbar-brand" style="margin-left: 13px;"></a><button
                                    data-toggle="collapse" class="navbar-toggler" data-target="#navcol-2"><span
                                    class="sr-only">Toggle navigation</span><span
                                    class="navbar-toggler-icon"></span></button>
                            </div>
                            <div class="collapse navbar-collapse" id="navcol-2">
                                <ul class="nav navbar-nav ml-auto" id="desktop-toolbar">
                                    <li class="nav-item dropdown"><a class="dropdown-toggle nav-link"
                                                                     data-toggle="dropdown" aria-expanded="false" href="#"><img
                                            class="rounded-circle" src="assets/img/user-photo.jpg" width="25px"
                                            height="25px">&nbsp;<%=lid.getName()%><i class="fa fa-chevron-down fa-fw"></i></a>
                                        <div class="dropdown-menu" role="menu">
                                            <a class="dropdown-item" role="presentation" href="Index"><i
                                                class="fa fa-power-off fa-fw"></i>退出</a>
                                        </div>
                                    </li>
                                </ul>
                                <ul class="nav navbar-nav" id="mobile-nav">
                                    <li class="nav-item" role="presentation"></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </header>
                <div class="row">
                    <div class="col-md-12">
                        <div></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">

            <%
                String pageNum = (String)request.getAttribute("pageNum");
                switch(pageNum){
                    case "fillTable" :
                    if((boolean)request.getSession().getAttribute("isFilled"))
                    {
            %>
                <%@ include file="/WEB-INF/TableIsFilled.jsp" %>
            <%
                    }
                    else
                    {
            %>
                <%@ include file="/WEB-INF/fillTable.jsp" %>
            <%
                    }
                     break;
                     case "QRcode":
                         if((boolean)request.getSession().getAttribute("isFilled"))
                         {
            %>
                    <%@ include file="/WEB-INF/QRcode.jsp" %>
            <%
                }
                else
                {

            %>
                    <%@ include file="/WEB-INF/QRcodeError.jsp" %>
            <%
                    }
                    break;
                    case "myPage" :
            %>
            <% if(lid.getRole().equals("系统")
                    || lid.getRole().equals("校级")
                    || lid.getRole().equals("院级")
            ) {%>
                <%@ include file="/WEB-INF/myPages/myPage_admin.jsp" %>
            <%
            }
            else
            { %>
                <%@ include file="/WEB-INF/myPages/myPage.jsp" %>
            <%
            }
                    break;
                    case "table_college" :
            %>
                <%@ include file="/WEB-INF/table/table-college.jsp" %>
            <%
                    break;
                    case "table_major" :
            %>
                <%@ include file="/WEB-INF/table/table-major.jsp" %>

            <%
                    break;
                    case "table_class" :
            %>
                <%@ include file="/WEB-INF/table/table-class.jsp" %>
            <%
                    break;
                    case "table_student" :
            %>
                <%@ include file="/WEB-INF/table/table-student.jsp" %>

            <%
                    break;
                    case "table_teacher" :
            %>
                <%@ include file="/WEB-INF/table/table-teacher.jsp" %>

            <%
                    break;
                    case "echartsResult" :
            %>
            <%@ include file="/WEB-INF/echartsResult.jsp" %>
            <%
                }
            %>
        </div>
    </div>
</main>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/Sidebar-Menu.js"></script>
</body>

</html>
