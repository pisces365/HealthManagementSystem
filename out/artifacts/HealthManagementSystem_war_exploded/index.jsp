<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/30
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
  <title>师生健康码系统登录</title>
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
</head>

<body>
<nav class="navbar navbar-light navbar-expand-md navigation-clean">
  <div class="container"><a class="navbar-brand" href="index.jsp">师生健康码管理系统<br></a>
    <div class="collapse navbar-collapse" id="navcol-1">
      <ul class="nav navbar-nav ml-auto">
        <li class="nav-item" role="presentation"><a class="nav-link active mt-auto" href="backstage.jsp" >后台管理</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="register-photo" style="height: 836px;background-position: center;">
  <div class="form-container" style="margin-top: 109px;">
    <div class="image-holder" style="background-image: url(&quot;assets/img/QQ截图20210529230642.png&quot;);background-position: center;background-repeat: no-repeat;background-size: cover;"></div>
    <form method="post" action="mainPage" onsubmit="return isagree()">
      <h2 class="text-center"><strong>登录</strong></h2>
      <div class="form-group"><select class="form-control" name="person-type"><option value="学生" selected="">学生</option><option value="普通">教师</option></select></div>
      <div class="form-group"><input class="form-control" type="text" name="name" placeholder="姓名"></div>
      <div class="form-group"><input class="form-control" type="text" name="number" placeholder="学号/工号"></div>
      <div class="form-group"><input class="form-control" type="password" name="password" placeholder="密码"></div>
      <div class="form-group">
        <div class="form-check"><label class="form-check-label"><input class="form-check-input" type="checkbox" checked="checked" id="agree" name="agree" value="agree">我同意系统收集隐私信息</label></div>
        <script>
          function isagree()
          {
            var condition = document.getElementById('agree');
            if(condition.checked == true)
            {
              return true;
            }
            else
            {
              alert("同意隐私收集后方可登录");
              return false;
            }
          }
        </script>
      </div>
      <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="background-color: rgb(17,206,218);">登录</button></div>
    </form>
  </div>
</div>
<div class="footer-basic">
  <footer>
    <p class="copyright"><br>Copyright&nbsp;© 2021 师生健康码管理系统&nbsp; 版权所有</p>
  </footer>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/Sidebar-Menu.js"></script>
</body>

</html>
