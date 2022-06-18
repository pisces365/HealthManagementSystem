package Servlet.QRcode;

import QRcode.QRcodeCreator;
import basicDatas.LogInDatas;
import dao.fillTable.fillTableDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "QRcodeServlet", value = "/QRcodePage")
public class QRcodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogInDatas lid = (LogInDatas)request.getSession().getAttribute("userLoginDatas");
        Date date = new Date();
        String color = null;
        try {
            color = new fillTableDaoImpl().isFill(lid.getNumber(),date,lid.getRole());
        }
        catch (Exception e)
        {
            System.out.println("fillTableDaoImpl.isFill ERROR："+e);
        }

        if(color==null)
        {
            request.setAttribute("colorQRQR","");
            String QRimage = new QRcodeCreator().creatQR("color");
            request.getSession().setAttribute("QRimage",QRimage);

            request.setAttribute("pageNum", "QRcode");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main-page.jsp");
            dispatcher.forward(request,response);
        }
        else
        {
            request.setAttribute("colorQRQR",color);
            String QRimage = new QRcodeCreator(lid.getName()+"\n"+lid.getRole()+"\n"+lid.getNumber()+"\n"+lid.getCollege()).creatQR(color);
            request.getSession().setAttribute("QRimage",QRimage);
            request.setAttribute("pageNum", "QRcode");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main-page.jsp");
            dispatcher.forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
