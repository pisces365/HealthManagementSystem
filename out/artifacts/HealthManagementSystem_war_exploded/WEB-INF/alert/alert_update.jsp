<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/1
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="alert_update" class="row register-form" style="margin:auto; top:0; left: 0; right: 0; bottom: 0;
  display: none; position: fixed; z-index: 10000; background-color: rgba(191,191,191,.9)">
    <div class="col-md-8 offset-md-2">
        <form action="<%= action%>>" method="post" class="custom-form" style="width: 700px; padding: 30px; position: fixed; top: 15%; left: 27%; right: 27%;
        background-color: rgb(255,255,255); box-shadow: 0 0.1rem 1rem rgba(0,0,0,.1)!important; border: 1px solid rgba(0,0,0,.125); border-radius: .25rem;">
            <input name="operationNumber" type="hidden" value="3">
            <h1>更新数据</h1>
            <%
                for(int i=0; i<listNum; ++i)
                {
            %>
            <div class="form-row form-group">
                <div class="col-sm-4 label-column"><label id="updateLabel+<%=i%>" class="col-form-label" for="name-input-field"></label></div>
                <div class="col-sm-6 input-column"><input id="C01+<%=i%>" class="form-control" type="text"></div>
            </div>
            <%
                }
            %>
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
        for(var i=0; i<listNum; ++i)
        {
            document.getElementById("C01+"+i).value=table_td[i].innerText;
            document.getElementById("updateLabel+"+i).innerText=table_th[i].innerText;
        }
    }
</script>
