package Servlet.LogInAndOutServlet;

import basicDatas.LogInDatas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutMangement", value = "/Index")
public class LogoutMangement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogInDatas lid = (LogInDatas)request.getSession().getAttribute("userLoginDatas");
        if(lid.getRole().equals("学生")||lid.getRole().equals("普通"))
        {
            HttpSession session = request.getSession(false);
            session.invalidate();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request,response);
        }
        else
        {
            HttpSession session = request.getSession(false);
            session.invalidate();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/backstage.jsp");
            dispatcher.forward(request,response);
        }
    }

}
