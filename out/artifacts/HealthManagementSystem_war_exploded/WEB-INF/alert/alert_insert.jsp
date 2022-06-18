<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/1
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="alert_insert" class="row register-form" style="margin:auto; top:0; left: 0; right: 0; bottom: 0;
  display: none; position: fixed; z-index: 10000; background-color: rgba(191,191,191,.9)">
    <div class="col-md-8 offset-md-2">
        <form action="<%= action%>>" method="post" onsubmit="return check()" class="custom-form" style="width: 700px; padding: 30px; position: fixed; top: 15%; left: 27%; right: 27%;
        background-color: rgb(255,255,255); box-shadow: 0 0.1rem 1rem rgba(0,0,0,.1)!important; border: 1px solid rgba(0,0,0,.125); border-radius: .25rem;">
            <input name="operationNumber" type="hidden" value="2">
            <h1>插入数据</h1>
            <div class="form-row form-group">
                <div class="col-sm-4 label-column"><label id="insertLabel+num" class="col-form-label" >编号</label></div>
                <div class="col-sm-6 input-column"><input id="insert+num" class="form-control" type="text" ></div>
                <script>
                    function check()
                    {
                        var insertnum = document.getElementById("insert+num");
                        if (insertnum.value == "") {
                            alert("编号不能为空");
                            return false;
                        }
                    }
                </script>
            </div>
            <%
                for(int i=0; i<listNum; ++i)
                {
            %>
            <div class="form-row form-group">
                <div class="col-sm-4 label-column"><label id="insertLabel+<%=i%>" class="col-form-label" ></label></div>
                <div class="col-sm-6 input-column"><input id="insert+<%=i%>" class="form-control" type="text"></div>
            </div>
            <%
                }
            %>
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
        for(var i=0; i<list; ++i)
        {
            document.getElementById("insertLabel+"+i).innerText=table_th[i].innerText;
        }
    }
</script>
