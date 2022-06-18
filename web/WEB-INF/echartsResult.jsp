<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="dao.dataStatistics.dataStatisticsDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/2
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="assets/js/echarts.min.js" rel="external nofollow"></script>
<%
    ArrayList<collegeDatas> aco = (ArrayList<collegeDatas>)request.getSession().getAttribute("collegeDatas");
    ArrayList<majorDatas> ama = (ArrayList<majorDatas>)request.getSession().getAttribute("majorDatas");
    ArrayList<classDatas> acl = (ArrayList<classDatas>)request.getSession().getAttribute("classDatas");
    HashMap<String,Integer> hm = (HashMap<String,Integer>)request.getSession().getAttribute("studatas1");
    Set<String> key1 = hm.keySet();
    Collection<Integer> connection = hm.values();
    Iterator<Integer> iterator1 = connection.iterator();


    HashMap<String,Integer> hmT =(HashMap<String,Integer>)request.getSession().getAttribute("Teadatas4");
    Set<String> key4 = hmT.keySet();
    Collection<Integer> connection4 = hmT.values();
    Iterator<Integer> iterator4 = connection4.iterator();

    double howManyStu =  (int)request.getSession().getAttribute("howManyStu");
    double howManyTea = (int)request.getSession().getAttribute("howManyTea");
    double percentStu = (int)request.getSession().getAttribute("percentStu");
    double percentTea = (int)request.getSession().getAttribute("percentTea");
    System.out.println(howManyStu);
    System.out.println(howManyTea);
    System.out.println(percentStu);
    System.out.println(percentTea);
%>
<div class="container-fluid" id="myPage" style="margin-top: 20px;">
    <div class="d-sm-flex justify-content-between align-items-center mb-4">
        <h3 class="text-dark mb-0">每日打卡概览</h3>
    </div>
    <div class="row">
        <div class="col-md-6 col-xl-3 mb-4">
            <div class="card shadow border-left-primary py-2">
                <div class="card-body">
                    <div class="row align-items-center no-gutters">
                        <div class="col mr-2">
                            <div class="text-uppercase text-primary font-weight-bold text-xs mb-1">
                                <span>学生打卡统计</span></div>
                            <div class="text-dark font-weight-bold h5 mb-0"><span>${sessionScope.howManyStu}人</span></div>
                        </div>
                        <div class="col-auto"><i class="fas fa-calendar fa-2x text-gray-300"></i></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-xl-3 mb-4">
            <div class="card shadow border-left-success py-2">
                <div class="card-body">
                    <div class="row align-items-center no-gutters">
                        <div class="col mr-2">
                            <div class="text-uppercase text-success font-weight-bold text-xs mb-1">
                                <span>教师打卡统计</span></div>
                            <div class="text-dark font-weight-bold h5 mb-0"><span>${sessionScope.howManyTea}人</span></div>
                        </div>
                        <div class="col-auto"><i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-xl-3 mb-4">
            <div class="card shadow border-left-info py-2">
                <div class="card-body">
                    <div class="row align-items-center no-gutters">
                        <div class="col mr-2">
                            <div class="text-uppercase text-info font-weight-bold text-xs mb-1">
                                <span>学生打卡比例</span></div>
                            <div class="row no-gutters align-items-center">
                                <div class="col-auto">
                                    <div class="text-dark font-weight-bold h5 mb-0 mr-3">
                                        <span><%= String.format("%.1f",howManyStu/percentStu*100)%>%</span></div>
                                </div>
                                <div class="col">
                                    <div class="progress progress-sm">
                                        <div class="progress-bar bg-info" aria-valuenow="50"
                                             aria-valuemin="0" aria-valuemax="100" style="width: <%= String.format("%.1f",howManyStu/percentStu*100)%>%;">
                                            <span class="sr-only"><%= String.format("%.1f",howManyStu/percentStu*100)%>%</span></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-auto"><i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-xl-3 mb-4">
            <div class="card shadow border-left-info py-2">
                <div class="card-body">
                    <div class="row align-items-center no-gutters">
                        <div class="col mr-2">
                            <div class="text-uppercase text-warning font-weight-bold text-xs mb-1">
                                <span>教师打卡比例</span></div>
                            <div class="row no-gutters align-items-center">
                                <div class="col-auto">
                                    <div class="text-dark font-weight-bold h5 mb-0 mr-3">
                                        <span><%= String.format("%.1f",howManyTea/percentTea*100)%>%</span></div>
                                </div>
                                <div class="col">
                                    <div class="progress progress-sm">
                                        <div class="progress-bar" aria-valuenow="50"
                                             aria-valuemin="0" aria-valuemax="100" style="background-color: #ffc107!important; width: <%= String.format("%.1f",howManyTea/percentTea*100)%>%;">
                                            <span class="sr-only"><%= String.format("%.1f",howManyTea/percentTea*100)%>%</span></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-auto"><i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6 col-xl-7">
            <div class="card shadow mb-4">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h6 class="text-primary font-weight-bold m-0">学生打卡概览</h6>
                    <div class="dropdown no-arrow">

                        <div class="dropdown-menu shadow dropdown-menu-right animated--fade-in"
                             role="menu">
                            <p class="text-center dropdown-header">dropdown header:</p><a
                                class="dropdown-item" role="presentation" href="#">&nbsp;Action</a><a
                                class="dropdown-item" role="presentation" href="#">&nbsp;Another
                            action</a>
                            <div class="dropdown-divider"></div><a class="dropdown-item"
                                                                   role="presentation" href="#">&nbsp;Something else here</a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="text-nowrap" style="max-width: 100%;">
                            <form action="showDatasPage" method="post">
                            <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable">
                                &nbsp;&nbsp;&nbsp;
                                <label  style="margin-right: 40px">学院(各专业)
                                    <select name="college1" class="form-control form-control-sm custom-select custom-select-sm">
                                        <option value="请选择" selected="selected">请选择</option>
                                        <% for(int i=0;i<aco.size();++i)
                                        { %>
                                        <option value="<%= aco.get(i).getCollegeName()%>"><%= aco.get(i).getCollegeName()%></option>
                                        <% }%>
                                    </select>&nbsp;
                                </label>
                                <br>
                                <label  style="margin: 0 18px">专业(各班级)
                                    <select name="major1" class="form-control form-control-sm custom-select custom-select-sm">
                                        <option value="请选择" selected="selected">请选择</option>
                                        <% for(int i=0;i<ama.size();++i)
                                        { %>
                                        <option value="<%= ama.get(i).getMajorName()%>"><%= ama.get(i).getMajorName()%></option>
                                        <% }%>
                                    </select>&nbsp;
                                </label>

                                <label style="margin: 0 80px"><button type="submit" class="form-control form-control-sm">搜索</button></label>
                            </div>
                                <input type="hidden" name="tableNum" value="1">
                            </form>
                        </div>
                    </div>
                    <div id="stu_Histogram" class="chart-area" style="width: 100%; min-height: 400px;">

                    </div>
                    <script>
                        var chartDom = document.getElementById('stu_Histogram');
                        var myChart = echarts.init(chartDom);
                        var option;

                        option = {
                            tooltip: {
                                trigger: 'axis',
                                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                                }
                            },
                            grid: {
                                left: '3%',
                                right: '4%',
                                bottom: '3%',
                                containLabel: true
                            },
                            xAxis: [
                                {
                                    type: 'category',
                                    data: [
                                    <% int flag1=1;
                                    	for (String string : key1) {
                                    	if(flag1==1){
                                    %>
                                    	'<%=string%>'
                                    	<%flag1++; } else{%>

                                        ,'<%=string%>'
                                    <%}} %>
                                    ],
                                    // data: ["123"
                                    // ],
                                    axisTick: {
                                        alignWithLabel: true
                                    }
                                }
                            ],
                            yAxis: [
                                {
                                    type: 'value'
                                }
                            ],
                            series: [
                                {
                                    name: '填报人数',
                                    type: 'bar',
                                    barWidth: '60%',
                                    data: [
                                        <% int flag2=1;
                                            while (iterator1.hasNext())  {
                                                if(flag2==1){
                                        %>
                                        <%=iterator1.next()%>
                                        <%flag2++; } else{%>

                                        ,<%=iterator1.next()%>
                                        <%} }%>
                                    ]
                                    // data: [123
                                    // ]
                                }
                            ]
                        };

                        option && myChart.setOption(option);
                    </script>
                </div>
            </div>
        </div>
        <div class="col-lg-6 col-xl-5">
            <div class="card shadow mb-4">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h6 class="text-primary font-weight-bold m-0">学生健康码颜色分布概览</h6>
                    <div class="dropdown no-arrow">

                        <div class="dropdown-menu shadow dropdown-menu-right animated--fade-in"
                             role="menu">
                            <p class="text-center dropdown-header">dropdown header:</p><a
                                class="dropdown-item" role="presentation" href="#">&nbsp;Action</a><a
                                class="dropdown-item" role="presentation" href="#">&nbsp;Another
                            action</a>
                            <div class="dropdown-divider"></div><a class="dropdown-item"
                                                                   role="presentation" href="#">&nbsp;Something else here</a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-6 text-nowrap">
                            <form action="showDatasPage" method="post">
                            <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable">
                                <label style="margin-right: 40px">学院
                                    <select name="college2" class="form-control form-control-sm custom-select custom-select-sm">
                                        <option value="请选择" selected="selected">请选择</option>
                                        <% for(int i=0;i<aco.size();++i)
                                        { %>
                                        <option value="<%= aco.get(i).getCollegeName()%>"><%= aco.get(i).getCollegeName()%></option>
                                        <% }%>
                                    </select>&nbsp;
                                </label>
                                <label style="margin-right: 40px">专业
                                    <select name="major2" class="form-control form-control-sm custom-select custom-select-sm">
                                        <option value="请选择" selected="selected">请选择</option>
                                        <% for(int i=0;i<ama.size();++i)
                                        { %>
                                        <option value="<%= ama.get(i).getMajorName()%>"><%= ama.get(i).getMajorName()%></option>
                                        <% }%>
                                    </select>&nbsp;
                                </label>
                                <br>
                                <label style="margin-right: 40px">班级
                                    <select name="classes2" class="form-control form-control-sm custom-select custom-select-sm">
                                        <option value="请选择" selected="selected">请选择</option>
                                        <% for(int i=0;i<acl.size();++i)
                                        { %>
                                        <option value="<%= acl.get(i).getClassName()%>"><%= acl.get(i).getClassName()%></option>
                                        <% }%>
                                    </select>&nbsp;
                                </label>
                                <label ><button type="submit" class="form-control form-control-sm">搜索</button></label>
                            </div>
                                <input type="hidden" name="tableNum" value="2">
                            </form>
                        </div>

                    </div>
                    <div id="stu_PieChart" class="chart-area" style="width: 100%; min-height: 400px;">

                    </div>
                    <script>
                        var chartDom = document.getElementById('stu_PieChart');
                        var myChart = echarts.init(chartDom);
                        var option;

                        option = {
                            title: {
                                text: '',
                                subtext: '',
                                left: 'right'
                            },
                            tooltip: {
                                trigger: 'item'
                            },
                            legend: {
                                orient: 'vertical',
                                left: 'left',
                            },
                            color:['rgb(238,102,102)','rgb(250,200,88)', 'rgb(145,204,117)','rgb(115,192,222)'],
                            series: [
                                {
                                    name: '健康码',
                                    type: 'pie',
                                    radius: '50%',
                                    data: [
                                        {value: ${sessionScope.studatas2.red}, name: '红色'},
                                        {value: ${sessionScope.studatas2.yellow}, name: '黄色'},
                                        {value: ${sessionScope.studatas2.green}, name: '绿色'},
                                        {value: ${sessionScope.studatas2.blue}, name: '蓝色'}
                                    ],
                                    emphasis: {
                                        itemStyle: {
                                            shadowBlur: 10,
                                            shadowOffsetX: 0,
                                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                                        }
                                    }
                                }
                            ]
                        };

                        option && myChart.setOption(option);
                    </script>
                </div>
            </div>
        </div>
        <div class="col-lg-6 col-xl-5">
            <div class="card shadow mb-4">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h6 class="text-primary font-weight-bold m-0">教师健康码颜色分布概览</h6>
                    <div class="dropdown no-arrow">

                        <div class="dropdown-menu shadow dropdown-menu-right animated--fade-in"
                             role="menu">
                            <p class="text-center dropdown-header">dropdown header:</p><a
                                class="dropdown-item" role="presentation" href="#">&nbsp;Action</a><a
                                class="dropdown-item" role="presentation" href="#">&nbsp;Another
                            action</a>
                            <div class="dropdown-divider"></div><a class="dropdown-item"
                                                                   role="presentation" href="#">&nbsp;Something else here</a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-6 text-nowrap">
                            <form action="showDatasPage" method="post">
                            <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable">
                                <label style="margin-right: 40px">学院
                                    <select name="college3"  class="form-control form-control-sm custom-select custom-select-sm">
                                        <option value="请选择" selected="selected">请选择</option>
                                        <% for(int i=0;i<aco.size();++i)
                                        { %>
                                        <option value="<%= aco.get(i).getCollegeName()%>"><%= aco.get(i).getCollegeName()%></option>
                                        <% }%>
                                    </select>&nbsp;
                                </label>
                                <label ><button type="submit" class="form-control form-control-sm">搜索</button></label>
                            </div>
                                <input type="hidden" name="tableNum" value="3">
                            </form>
                        </div>

                    </div>
                    <div id="teacher_PieChart" class="chart-area" style="width: 100%; min-height: 400px;">

                    </div>
                    <script>
                        var chartDom = document.getElementById('teacher_PieChart');
                        var myChart = echarts.init(chartDom);
                        var option;

                        option = {
                            title: {
                                text: '',
                                subtext: '',
                                left: 'right'
                            },
                            tooltip: {
                                trigger: 'item'
                            },
                            legend: {
                                orient: 'vertical',
                                left: 'left',
                            },
                            color:['rgb(238,102,102)','rgb(250,200,88)', 'rgb(145,204,117)','rgb(115,192,222)'],
                            series: [
                                {
                                    name: '健康码',
                                    type: 'pie',
                                    radius: '50%',
                                    data: [
                                        {value: ${sessionScope.Teadatas3.red}, name: '红色'},
                                        {value: ${sessionScope.Teadatas3.yellow}, name: '黄色'},
                                        {value: ${sessionScope.Teadatas3.green}, name: '绿色'},
                                        {value: ${sessionScope.Teadatas3.blue}, name: '蓝色'}
                                    ],
                                    emphasis: {
                                        itemStyle: {
                                            shadowBlur: 10,
                                            shadowOffsetX: 0,
                                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                                        }
                                    }
                                }
                            ]
                        };

                        option && myChart.setOption(option);
                    </script>
                </div>
            </div>
        </div>
        <div class="col-lg-6 col-xl-7">
            <div class="card shadow mb-4">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h6 class="text-primary font-weight-bold m-0">教师打卡概览</h6>
                    <div class="dropdown no-arrow">

                        <div class="dropdown-menu shadow dropdown-menu-right animated--fade-in"
                             role="menu">
                            <p class="text-center dropdown-header">dropdown header:</p><a
                                class="dropdown-item" role="presentation" href="#">&nbsp;Action</a><a
                                class="dropdown-item" role="presentation" href="#">&nbsp;Another
                            action</a>
                            <div class="dropdown-divider"></div><a class="dropdown-item"
                                                                   role="presentation" href="#">&nbsp;Something else here</a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="text-nowrap" style="max-width: 100%;">
                            <form action="showDatasPage" method="post">
                            <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable">
                                <label style="margin: 0 30px"><button type="submit" class="form-control form-control-sm">搜索</button></label>
                                <input type="hidden" name="tableNum" value="4">
                            </div>
                            </form>
                        </div>
                    </div>
                    <div id="teacher_Histogram" class="chart-area" style="width: 100%; min-height: 400px;">

                    </div>
                    <script>
                        var chartDom = document.getElementById('teacher_Histogram');
                        var myChart = echarts.init(chartDom);
                        var option;

                        option = {
                            tooltip: {
                                trigger: 'axis',
                                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                                }
                            },
                            grid: {
                                left: '3%',
                                right: '4%',
                                bottom: '3%',
                                containLabel: true
                            },
                            xAxis: [
                                {
                                    type: 'category',
                                    data: [
                                        <% int flag3=1;
                                            for (String string : key4) {
                                            if(flag3==1){
                                        %>
                                        '<%=string%>'
                                        <%flag1++; } else{%>

                                        ,'<%=string%>'
                                        <%}} %>
                                    ],
                                    // data: ["123"
                                    // ],
                                    axisTick: {
                                        alignWithLabel: true
                                    }
                                }
                            ],
                            yAxis: [
                                {
                                    type: 'value'
                                }
                            ],
                            series: [
                                {
                                    name: '填报人数',
                                    type: 'bar',
                                    barWidth: '60%',
                                    data: [
                                        <% int flag4=1;
                                            while (iterator4.hasNext())  {
                                                if(flag4==1){
                                        %>
                                        <%=iterator4.next()%>
                                        <%flag2++; } else{%>

                                        ,<%=iterator4.next()%>
                                        <%} }%>
                                    ]
                                    // data: [123
                                    // ]
                                }
                            ]
                        };

                        option && myChart.setOption(option);
                    </script>
                </div>
            </div>
        </div>
    </div>

</div>
