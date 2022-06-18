package Servlet.showDatas;

import basicDatas.QRcodeColors;
import basicDatas.classDatas;
import basicDatas.collegeDatas;
import basicDatas.majorDatas;
import dao.classes.classDaoImpl;
import dao.college.CollegeDaoImpl;
import dao.dataStatistics.dataStatisticsDaoImpl;
import dao.major.majorDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "showDatasServlet", value = "/showDatasPage")
public class showDatasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            String whichCollege = "请选择";
            if(!((String)request.getSession().getAttribute("isCollegeRole")).equals(""))
            {
                whichCollege = (String)request.getSession().getAttribute("isCollegeRole");
            }
            ArrayList<collegeDatas> aco = new CollegeDaoImpl().selectAllCollegeDatas((String)request.getSession().getAttribute("isCollegeRole"));
            ArrayList<majorDatas> ama = new majorDaoImpl().selectAllmajorDatas((String)request.getSession().getAttribute("isCollegeRole"));
            ArrayList<classDatas> acl = new classDaoImpl().selectAllclassDatas((String)request.getSession().getAttribute("isCollegeRole"));

            request.getSession().setAttribute("collegeDatas", aco);
            request.getSession().setAttribute("majorDatas", ama);
            request.getSession().setAttribute("classDatas", acl);

            HashMap<String,Integer> hm = new dataStatisticsDaoImpl().selectdatasStu(whichCollege,"请选择");
            request.getSession().setAttribute("studatas1", hm);

            QRcodeColors qc = new dataStatisticsDaoImpl().selectColorsStu(whichCollege,"请选择","请选择");
            request.getSession().setAttribute("studatas2", qc);

            QRcodeColors qcT = new dataStatisticsDaoImpl().selectColorsTea(whichCollege);
            request.getSession().setAttribute("Teadatas3", qcT);

            HashMap<String,Integer> hmT = new dataStatisticsDaoImpl().selectdatasTea((String)request.getSession().getAttribute("isCollegeRole"));
            request.getSession().setAttribute("Teadatas4", hmT);

            int howManyStu =  new dataStatisticsDaoImpl().howManyStu((String)request.getSession().getAttribute("isCollegeRole"));
            System.out.println(howManyStu);
            request.getSession().setAttribute("howManyStu", howManyStu);
            int howManyTea = new dataStatisticsDaoImpl().howManyTea((String)request.getSession().getAttribute("isCollegeRole"));
            request.getSession().setAttribute("howManyTea", howManyTea);
            int percentStu = new dataStatisticsDaoImpl().percentStu((String)request.getSession().getAttribute("isCollegeRole"));
            request.getSession().setAttribute("percentStu", percentStu);
            int percentTea = new dataStatisticsDaoImpl().percentTea((String)request.getSession().getAttribute("isCollegeRole"));
            request.getSession().setAttribute("percentTea", percentTea);
        }
        catch(Exception e)
        {
            System.out.println("ArrayList系列: "+e);
        }
        request.setAttribute("pageNum", "echartsResult");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main-page.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String tableNum = request.getParameter("tableNum");
        if(tableNum.equals("1"))
        {
            String college = request.getParameter("college1");
            String major = request.getParameter("major1");
            try
            {
                HashMap<String,Integer> hm = new dataStatisticsDaoImpl().selectdatasStu(college,major);
                request.getSession().setAttribute("studatas1", hm);
            }
            catch(Exception e)
            {
                System.out.println("HashMap<String,Integer>: "+e);
            }
        }
        else if(tableNum.equals("2"))
        {
            String college = request.getParameter("college2");
            String major = request.getParameter("major2");
            String classes = request.getParameter("classes2");
            try
            {
                QRcodeColors qc = new dataStatisticsDaoImpl().selectColorsStu(college,major,classes);
                request.getSession().setAttribute("studatas2", qc);
            }
            catch(Exception e)
            {
                System.out.println("QRcodeColors qc: "+e);
            }
        }
        else if(tableNum.equals("3"))
        {
            String college = request.getParameter("college3");
            try
            {
                QRcodeColors qcT = new dataStatisticsDaoImpl().selectColorsTea(college);
                request.getSession().setAttribute("Teadatas3", qcT);
            }
            catch(Exception e)
            {
                System.out.println("TeaQRcodeColors qc: "+e);
            }
        }
        else if(tableNum.equals("4"))
        {
            try
            {
                HashMap<String,Integer> hmT = new dataStatisticsDaoImpl().selectdatasTea((String)request.getSession().getAttribute("isCollegeRole"));
                request.getSession().setAttribute("Teadatas4", hmT);
            }
            catch(Exception e)
            {
                System.out.println("HashMap<String,Integer>: "+e);
            }
        }
        request.setAttribute("pageNum", "echartsResult");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main-page.jsp");
        dispatcher.forward(request,response);
    }
}
