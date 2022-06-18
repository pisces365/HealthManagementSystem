package Servlet.LogInAndOutServlet;

import LogIn.LogInHandler;
import basicDatas.LogInDatas;
import dao.fillTable.fillTableDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "LoginManagement", value = "/mainPage")
public class LoginManagement extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String person_type = request.getParameter("person-type");
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String password = request.getParameter("password");
        LogInDatas lid = LogInHandler.logInHandler(person_type,name,number,password);//登陆验证


        if(lid!=null&&lid.getName()!=null)
        {
            String isCollegeRole = "";
            if(lid.getRole().equals("院级"))
            {
                isCollegeRole = lid.getCollege();
            }
            boolean ifed = false;
            try
            {
                ifed = new fillTableDaoImpl().isFillbool(lid.getNumber(),new Date(),lid.getRole());
            }
            catch(Exception e)
            {
                System.out.println("fillTableDaoImpl.isFillbool ERROR："+e);
            }
            request.setAttribute("pageNum", "myPage");
            HttpSession session = request.getSession();
            session.setAttribute("userLoginDatas", lid);
            session.setAttribute("isFilled", ifed);

            session.setAttribute("isCollegeRole", isCollegeRole);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main-page.jsp");
            dispatcher.forward(request,response);
        }
        else
        {
            if(person_type.equals("学生") || person_type.equals("普通"))
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request,response);
            }
            else
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/backstage.jsp");
                dispatcher.forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNum = request.getParameter("pageNum");
        request.setAttribute("pageNum", pageNum);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main-page.jsp");
        dispatcher.forward(request,response);
    }

}
