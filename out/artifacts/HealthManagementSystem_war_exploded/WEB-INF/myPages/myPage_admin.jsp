<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/31
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid" id="myPage" style="margin-top: 20px;">
    <div class="d-sm-flex justify-content-between align-items-center mb-4">
        <h3 class="text-dark mb-0">我的主页</h3>
    </div>
    <div class="row">
        <div class="col-md-6 col-xl-3 mb-4">
            <a href="/HealthManagementSystem_war_exploded/CollegePage?pageNum=table_college" id="fillTable_button" style="text-decoration: none;">
                <div class="card shadow border-left-primary py-2">
                    <div class="card-body">
                        <div class="row align-items-center no-gutters">
                            <div class="col mr-2">
                                <div class="text-uppercase text-primary font-weight-bold text-xs mb-1">
                                    <span>学院信息</span></div>
                                <div class="text-dark font-weight-bold h5 mb-0"><span>立即管理</span></div>
                            </div>
                            <div class="col-auto"><i class="fas fa-calendar fa-2x text-gray-300"></i></div>
                        </div>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-md-6 col-xl-3 mb-4">
            <a href="/HealthManagementSystem_war_exploded/majorPage?pageNum=table_major"  style="text-decoration: none;">
                <div class="card shadow border-left-primary py-2">
                    <div class="card-body">
                        <div class="row align-items-center no-gutters">
                            <div class="col mr-2">
                                <div class="text-uppercase text-primary font-weight-bold text-xs mb-1">
                                    <span>专业信息</span></div>
                                <div class="text-dark font-weight-bold h5 mb-0"><span>立即管理</span></div>
                            </div>
                            <div class="col-auto"><i class="fas fa-calendar fa-2x text-gray-300"></i></div>
                        </div>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-md-6 col-xl-3 mb-4">
            <a href="/HealthManagementSystem_war_exploded/classPage?pageNum=table_class"  style="text-decoration: none;">
                <div class="card shadow border-left-primary py-2">
                    <div class="card-body">
                        <div class="row align-items-center no-gutters">
                            <div class="col mr-2">
                                <div class="text-uppercase text-primary font-weight-bold text-xs mb-1">
                                    <span>班级信息</span></div>
                                <div class="text-dark font-weight-bold h5 mb-0"><span>立即管理</span></div>
                            </div>
                            <div class="col-auto"><i class="fas fa-calendar fa-2x text-gray-300"></i></div>
                        </div>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-md-6 col-xl-3 mb-4">
            <a href="/HealthManagementSystem_war_exploded/studentsPage?pageNum=table_student"  style="text-decoration: none;">
                <div class="card shadow border-left-primary py-2">
                    <div class="card-body">
                        <div class="row align-items-center no-gutters">
                            <div class="col mr-2">
                                <div class="text-uppercase text-primary font-weight-bold text-xs mb-1">
                                    <span>学生信息</span></div>
                                <div class="text-dark font-weight-bold h5 mb-0"><span>立即管理</span></div>
                            </div>
                            <div class="col-auto"><i class="fas fa-calendar fa-2x text-gray-300"></i></div>
                        </div>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-md-6 col-xl-3 mb-4">
            <a href="/HealthManagementSystem_war_exploded/teachersPage?pageNum=table_teacher"  style="text-decoration: none;">
                <div class="card shadow border-left-primary py-2">
                    <div class="card-body">
                        <div class="row align-items-center no-gutters">
                            <div class="col mr-2">
                                <div class="text-uppercase text-primary font-weight-bold text-xs mb-1">
                                    <span>教师信息</span></div>
                                <div class="text-dark font-weight-bold h5 mb-0"><span>立即管理</span></div>
                            </div>
                            <div class="col-auto"><i class="fas fa-calendar fa-2x text-gray-300"></i></div>
                        </div>
                    </div>
                </div>
            </a>
        </div>


    </div>

    <div class="d-sm-flex justify-content-between align-items-center mb-4">
        <h3 class="text-dark mb-0"></h3>
    </div>
    <div class="row">
        <div class="col-md-6 col-xl-3 mb-4">
            <a href="/HealthManagementSystem_war_exploded/showDatasPage?pageNum=echartsResult"  style="text-decoration: none;">
                <div class="card shadow border-left-success py-2">
                    <div class="card-body">
                        <div class="row align-items-center no-gutters">
                            <div class="col mr-2">
                                <div class="text-uppercase text-success font-weight-bold text-xs mb-1">
                                    <span>每日打卡概览</span></div>
                                <div class="text-dark font-weight-bold h5 mb-0"><span>立即前往</span></div>
                            </div>
                            <div class="col-auto"><i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-md-6 col-xl-3 mb-4">
            <a href="/HealthManagementSystem_war_exploded/mainPage?pageNum=fillTable"  style="text-decoration: none;">

                <div class="card shadow border-left-success py-2">
                    <div class="card-body">
                        <div class="row align-items-center no-gutters">
                            <div class="col mr-2">
                                <div class="text-uppercase text-info font-weight-bold text-xs mb-1">
                                    <span>每日信息上报</span></div>
                                <div class="text-dark font-weight-bold h5 mb-0"><span>现在填报</span></div>
                            </div>
                            <div class="col-auto"><i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-md-6 col-xl-3 mb-4">
            <a href="/HealthManagementSystem_war_exploded/QRcodePage?pageNum=QRcode"  style="text-decoration: none;">

                <div class="card shadow border-left-warning py-2">
                    <div class="card-body">
                        <div class="row align-items-center no-gutters">
                            <div class="col mr-2">
                                <div class="text-uppercase text-warning font-weight-bold text-xs mb-1">
                                    <span>健康码领取</span></div>
                                <div class="text-dark font-weight-bold h5 mb-0"><span>现在领取</span></div>
                            </div>
                            <div class="col-auto"><i class="fas fa-comments fa-2x text-gray-300"></i></div>
                        </div>
                    </div>
                </div>
            </a>
        </div>
    </div>
</div>
