package Servlet.fillTableServlet;

import basicDatas.LogInDatas;
import dao.fillTable.fillTableDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "FillTableServlet", value = "/HealthCode")
public class FillTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        LogInDatas lid = (LogInDatas)request.getSession().getAttribute("userLoginDatas");
        lid.setPhone(request.getParameter("phone"));
        request.getSession().setAttribute("userLoginDatas",lid);

        String color = "绿色";
        if(request.getParameter("inject").equals("Yes"))
        {
            color="蓝色";
        }

        if(request.getParameter("EpidemicArea").equals("Yes")||
                request.getParameter("Abroad").equals("Yes")||
                request.getParameter("healthy").equals("Yes1"))
        {
            color="黄色";
        }

        if (request.getParameter("Patient").equals("Yes")||
                request.getParameter("ill").equals("Yes")||
                request.getParameter("healthy").equals("Yes2"))
        {
            color="红色";
        }

        Date date = new Date();
        if(color.equals("绿色"))
        {

            try
            {
                color = new fillTableDaoImpl().selectColor(lid.getNumber(),date,lid.getRole());

            }
            catch (Exception e)
            {
                System.out.println("fillTableDaoImpl.selectColor ERROR："+e);
            }
        }

        boolean isFilled = false;
        try
        {
            isFilled =  new fillTableDaoImpl().insertstudentsData(lid.getNumber(),color,date,lid.getPhone(),lid.getRole());
        }
        catch(Exception e)
        {
            System.out.println("fillTableDaoImpl.insertstudentsData ERROR："+e);
        }

        request.getSession().setAttribute("isFilled", isFilled);

        if((boolean)request.getSession().getAttribute("isFilled"))
        {
            request.setAttribute("pageNum", "QRcode");
            RequestDispatcher dispatcher = request.getRequestDispatcher("QRcodePage");
            dispatcher.forward(request,response);
        }
        else
        {
            request.setAttribute("pageNum", "fillTable");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main-page.jsp");
            dispatcher.forward(request,response);
        }

    }
}
