<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/1
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="alert_delete" class="row register-form" style="margin:auto; top:0; left: 0; right: 0; bottom: 0;
  display: none; position: fixed; z-index: 10000; background-color: rgba(191,191,191,.9)">
    <div class="col-md-8 offset-md-2">
        <form action="<%= action%>>" method="post" class="custom-form" style="width: 700px; padding: 30px; position: fixed; top: 15%; left: 27%; right: 27%;
        background-color: rgb(255,255,255); box-shadow: 0 0.1rem 1rem rgba(0,0,0,.1)!important; border: 1px solid rgba(0,0,0,.125); border-radius: .25rem;">
            <input name="operationNumber" type="hidden" value="4">
            <h1>删除数据</h1>
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
    function delete_onclick()
    {
        var alert_delete = document.getElementById("alert_delete");
        alert_delete.style.display = "block";
    }
</script>
