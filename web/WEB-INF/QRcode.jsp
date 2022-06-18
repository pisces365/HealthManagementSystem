<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/31
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="QRcode" class="col-sm-6 col-md-5 col-lg-4 item" style="margin: 0 auto; box-shadow: 0 0.1rem 1rem rgba(0,0,0,.1)!important; border: 1px solid rgba(0,0,0,.125); border-radius: .25rem;">
    <div class="box" style="margin: 30px;">
        <div class="fa icon" style="width: 280px;height: 280px;margin: 20px 0; ">
            <img style="
            <%
               String colorQRQR = (String)request.getAttribute("colorQRQR");
               if(colorQRQR.equals("蓝色")){
            %>
                    border: 10px solid gold; border-radius: .25rem;
            <%
                }
            %>
             width: 280px;height: 280px;" src="data:image/jpg;base64,<%=request.getSession().getAttribute("QRimage") %>">
        </div>
        <h3 class="name" style="text-align: center">${sessionScope.userLoginDatas.name} 校园健康码</h3>
        <h3 class="name" style="text-align: center">${sessionScope.userLoginDatas.number}</h3>
        <h3 class="name" style="text-align: center">${sessionScope.userLoginDatas.college}</h3>
        <p class="description" style="text-align: center">
            <%
                Date date = new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            %>
            <%= sdf.format(date)%>
        </p>
        <p class="description">凭此码可在学校区域通行，请主动出示，配合检查！</p>
    </div>
</div>
