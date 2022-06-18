<%@ page import="basicDatas.teachersDatas" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/31
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-------------------------------%>
<%
    ArrayList<teachersDatas> teachersDatasArrayList = (ArrayList<teachersDatas>)request.getAttribute("teachersDatas");
    ArrayList<teachersDatas> teachersNameList = (ArrayList<teachersDatas>)request.getSession().getAttribute("teachersNameList");
    ArrayList<collegeDatas> collegeNameListForteachers = (ArrayList<collegeDatas>)request.getSession().getAttribute("collegeNameListForteachers");
    String teachersMessage = (String)request.getAttribute("message");
    if(!teachersMessage.equals(""))
    {
        System.out.println(teachersMessage);

%>

<div id="teachersMessageBox" style="width: 100px; padding: 3px; position: fixed; top: 2%; left: 50%; right: 50%;
        background-color: rgb(255,255,255); box-shadow: 0 0.1rem 1rem rgba(0,0,0,.1)!important; border: 1px solid rgba(0,0,0,.125); border-radius: .25rem;">
    <h6 style="text-align: center;"><%=teachersMessage%></h6>
</div>
<script type="text/javascript">
    setTimeout(function(){document.getElementById("teachersMessageBox").style.display="none";},3000);
</script>

<%
}
else

%>
<%-------------------------------%>
<div id="alert_insert" class="row register-form" style="margin:auto; top:0; left: 0; right: 0; bottom: 0;
  display: none; position: fixed; z-index: 10000; background-color: rgba(191,191,191,.9)">
    <div class="col-md-8 offset-md-2">
        <form action="teachersPage" method="post" onsubmit="return check()" class="custom-form" style="width: 700px; padding: 30px; position: fixed; top: 15%; left: 27%; right: 27%;
        background-color: rgb(255,255,255); box-shadow: 0 0.1rem 1rem rgba(0,0,0,.1)!important; border: 1px solid rgba(0,0,0,.125); border-radius: .25rem;">
            <input name="operationNumber" type="hidden" value="2">
            <h1>插入数据</h1>
            <div class="form-row form-group">
                <div class="col-sm-4 label-column"><label id="insertLabel+num" class="col-form-label" >工号</label></div>
                <div class="col-sm-6 input-column"><input name="insert+num" class="form-control" type="text" ></div>
                <script>
                    function check()
                    {
                        var insertnum = document.getElementsByName("insert+num");
                        if (insertnum[0].value === "") {
                            alert("编号不能为空");
                            return false;
                        }
                    }
                </script>
            </div>
            <%
                for(int i=1; i<5; ++i)
                {
            %>
            <div class="form-row form-group">
                <div class="col-sm-4 label-column"><label id="insertLabel+<%=i%>" class="col-form-label" ></label></div>
                <div class="col-sm-6 input-column"><input name="insert+<%=i%>" class="form-control" type="text"></div>
            </div>
            <%
                }
            %>
            <div class="form-row form-group">
                <div class="col-sm-4 label-column"><label id="insertLabel+5" class="col-form-label" for="name-input-field">所属学院</label></div>
                <div class="col-sm-6 input-column">
                    <select id="insert+5" name="insert+5" class="form-control form-control-sm custom-select custom-select-sm">
                        <option value="pleaseSelect" selected="selected">请选择</option>
                        <% for(int i=0;i<collegeNameListForteachers.size();++i)
                        { %>
                        <option value="<%= collegeNameListForteachers.get(i).getCollegeNum()%>"><%= collegeNameListForteachers.get(i).getCollegeName()%></option>
                        <% }%>
                    </select>&nbsp;
                </div>
            </div>
            <div class="form-check">
                <br>
            </div>
            <button style="display: inline-block;" class="btn btn-light submit-button" type="submit">确定</button>&nbsp;&nbsp;
            <button style="display: inline-block;" onclick="cancel_insert_onclick()" class="btn btn-light submit-button" type="button">取消</button>
        </form>
    </div>
</div>

<script>

    function cancel_insert_onclick()
    {
        var alert_insert = document.getElementById("alert_insert");
        alert_insert.style.display = "none";
    }
    function insert_onclick(formTitle, list)
    {
        var alert_insert = document.getElementById("alert_insert");
        alert_insert.style.display = "block";
        var table_tr = document.getElementById(formTitle);
        var table_th = table_tr.getElementsByTagName("th");
        for(var i=1; i<5; ++i)
        {
            document.getElementById("insertLabel+"+i).innerText=table_th[i].innerText;
        }
    }
</script>
<%-------------------------------%>
<div id="alert_update" class="row register-form" style="margin:auto; top:0; left: 0; right: 0; bottom: 0;
  display: none; position: fixed; z-index: 10000; background-color: rgba(191,191,191,.9)">
    <div class="col-md-8 offset-md-2">
        <form action="teachersPage" method="post" class="custom-form" style="width: 700px; padding: 30px; position: fixed; top: 15%; left: 27%; right: 27%;
        background-color: rgb(255,255,255); box-shadow: 0 0.1rem 1rem rgba(0,0,0,.1)!important; border: 1px solid rgba(0,0,0,.125); border-radius: .25rem;">
            <input name="operationNumber" type="hidden" value="3">
            <h1>更新数据</h1>
            <input name="teachersNumUpdate" type="hidden" >
            <%
                for(int i=1; i<5; ++i)
                {
            %>
            <div class="form-row form-group">
                <div class="col-sm-4 label-column"><label id="updateLabel+<%=i%>" class="col-form-label" for="name-input-field"></label></div>
                <div class="col-sm-6 input-column"><input id="update+<%=i%>" name="update+<%=i%>" class="form-control" type="text"></div>
            </div>
            <%
                }
            %>
            <div class="form-row form-group">
                <div class="col-sm-4 label-column"><label id="updateLabel+5" class="col-form-label" for="name-input-field">所属学院</label></div>
                <div class="col-sm-6 input-column">
                    <select id="update+5" name="update+5" class="form-control form-control-sm custom-select custom-select-sm">
                        <option value="pleaseSelect" selected="selected">请选择</option>
                        <% for(int i=0;i<collegeNameListForteachers.size();++i)
                        { %>
                        <option value="<%= collegeNameListForteachers.get(i).getCollegeNum()%>"><%= collegeNameListForteachers.get(i).getCollegeName()%></option>
                        <% }%>
                    </select>&nbsp;
                </div>
            </div>
            <div class="form-check">
                <br>
            </div>
            <button style="display: inline-block;" class="btn btn-light submit-button" type="submit">确定</button>&nbsp;&nbsp;
            <button style="display: inline-block;" onclick="cancel_update_onclick()" class="btn btn-light submit-button" type="button">取消</button>
        </form>
    </div>
</div>

<script>
    function cancel_update_onclick()
    {
        var alert_update = document.getElementById("alert_update");
        alert_update.style.display = "none";
    }
    function update_onclick(getvalue, listNum, formTitle)
    {
        var alert_update = document.getElementById("alert_update");
        alert_update.style.display = "block";
        var table_tr = document.getElementById(getvalue);
        var table_td = table_tr.getElementsByTagName("td");
        var table_tr = document.getElementById(formTitle);
        var table_th = table_tr.getElementsByTagName("th");

        for(var i=1; i<5; ++i)
        {
            document.getElementById("update+"+i).value=table_td[i].innerText;
            document.getElementById("updateLabel+"+i).innerText=table_th[i].innerText;
        }

        document.getElementsByName("teachersNumUpdate")[0].value = getvalue;
    }
</script>
<%-------------------------------%>
<div id="alert_delete" class="row register-form" style="margin:auto; top:0; left: 0; right: 0; bottom: 0;
  display: none; position: fixed; z-index: 10000; background-color: rgba(191,191,191,.9)">
    <div class="col-md-8 offset-md-2">
        <form action="teachersPage" method="post" class="custom-form" style="width: 700px; padding: 30px; position: fixed; top: 15%; left: 27%; right: 27%;
        background-color: rgb(255,255,255); box-shadow: 0 0.1rem 1rem rgba(0,0,0,.1)!important; border: 1px solid rgba(0,0,0,.125); border-radius: .25rem;">
            <input name="operationNumber" type="hidden" value="4">
            <h1>删除数据</h1>
            <input name="teachersNumDelete" type="hidden" >
            <div class="form-check">
                <label style="margin: 30px 0;" class="form-check-label" >您确定要删除吗？</label>
            </div>
            <button style="display: inline-block;" class="btn btn-light submit-button" type="submit">确定</button>&nbsp;&nbsp;
            <button style="display: inline-block;" onclick="cancel_delete_onclick()" class="btn btn-light submit-button" type="button">取消</button>
        </form>
    </div>
</div>

<script>
    function cancel_delete_onclick()
    {
        var alert_delete = document.getElementById("alert_delete");
        alert_delete.style.display = "none";
    }
    function delete_onclick(getvalue)
    {
        var alert_delete = document.getElementById("alert_delete");
        alert_delete.style.display = "block";
        document.getElementsByName("teachersNumDelete")[0].value = getvalue;
    }
</script>
<%-------------------------------%>

<div class="container-fluid" id="table_teacher" style="margin-top: 20px" >
    <h3 class="text-dark mb-4">基本信息管理</h3>
    <div class="card shadow">
        <div class="card-header py-3">
            <p class="text-primary m-0 font-weight-bold">教师信息</p>
        </div>
        <div class="card-body">
            <form action="teachersPage" method="post">
            <div class="row">
                <div class="col-md-6 text-nowrap">
                    <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable">
                        <label style="margin-right: 40px">数量
                            <select class="form-control form-control-sm custom-select custom-select-sm">
                                <option value="10" selected="">10</option>
                                <option value="25">25</option>
                                <option value="50">50</option>
                                <option value="100">100</option>
                            </select>&nbsp;
                        </label>
                    </div>
                    <input name="operationNumber" type="hidden" value="1">
                </div>
                <div class="col-md-6">
                    <div class="text-md-right dataTables_filter" id="dataTable_filter"><label><input name="teachersSelect" type="search" class="form-control form-control-sm" aria-controls="dataTable" value="" placeholder="搜索：姓名或工号"></label>&nbsp;&nbsp;
                        <label><button type="submit" class="form-control form-control-sm">搜索</button></label>&nbsp;&nbsp;
                        <% if(lid.getRole().equals("系统")
                        ) {%>
                        <label><button onclick="insert_onclick('form_title', 3)" type="button" class="form-control form-control-sm">插入</button></label>
                    <% } %>
                    </div>
                </div>
            </div>
            </form>
            <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
                <table class="table my-0" id="dataTable">
                    <thead>
                    <tr id="form_title">
                        <th>工号</th>
                        <th>姓名</th>
                        <th>身份证号</th>
                        <th>角色</th>
                        <th>密码</th>
                        <th>所属学院</th>
                        <% if(lid.getRole().equals("系统")||lid.getRole().equals("校级")
                        ) {%>
                        <th>操作</th>
                        <% } %>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if(teachersDatasArrayList!=null)
                        {
                            for(int i=0; i<teachersDatasArrayList.size(); ++i)
                            {
                                teachersDatas coD = teachersDatasArrayList.get(i);

                    %>
                    <tr id="<%= coD.getTeacherNum()%>">
                        <td><%= coD.getTeacherNum()%></td>
                        <td><%= coD.getTeacherName()%></td>
                        <td><%= coD.getTeacherID()%></td>
                        <td><%= coD.getRole()%></td>
                        <td><%= coD.getTeacherPassword()%></td>
                        <td><%= coD.getCollegeBelonging()%></td>
                        <% if(lid.getRole().equals("系统")||lid.getRole().equals("校级")
                        ) {%>
                        <td>
                            <a href="javascript:void(0)" onclick="update_onclick('<%= coD.getTeacherNum()%>', 3, 'form_title')">更新</a>&nbsp;&nbsp;
                            <% if(lid.getRole().equals("系统")
                            ) {%>
                            <a href="javascript:void(0)" onclick="delete_onclick('<%= coD.getTeacherNum()%>')">删除</a>
                            <% } %>
                        </td>
                        <% } %>
                    </tr>
                    <%      }
                    }
                    %>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th>工号</th>
                        <th>姓名</th>
                        <th>身份证号</th>
                        <th>角色</th>
                        <th>密码</th>
                        <th>所属学院</th>
                        <% if(lid.getRole().equals("系统")||lid.getRole().equals("校级")
                        ) {%>
                        <th>操作</th>
                        <% } %>
                    </tr>
                    </tfoot>
                </table>
            </div>
            <div class="row">
                <div class="col-md-6 align-self-center">
                    <p id="dataTable_info" class="dataTables_info" role="status" aria-live="polite">第1页</p>
                </div>
                <div class="col-md-6">
                    <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                        <ul class="pagination">
                            <li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
