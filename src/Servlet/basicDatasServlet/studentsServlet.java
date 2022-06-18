package Servlet.basicDatasServlet;

import basicDatas.LogInDatas;
import basicDatas.classDatas;
import basicDatas.studentsDatas;
import dao.students.studentsDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "studentsServlet", value = "/studentsPage")
public class studentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNum = request.getParameter("pageNum");
        request.setAttribute("pageNum", pageNum);
        ArrayList<studentsDatas> studentsDatasArrayList = null;
        ArrayList<String> studentsName = null;
        ArrayList<classDatas> classNameList = null;
        try {
            studentsDatasArrayList = new studentsDaoImpl().selectAllstudentsDatas((String)request.getSession().getAttribute("isCollegeRole"));
            classNameList = new dao.classes.classDaoImpl().selectAllclassDatas((String)request.getSession().getAttribute("isCollegeRole"));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        request.setAttribute("message", "");
        request.setAttribute("studentsDatas", studentsDatasArrayList);
        request.getSession().setAttribute("studentsNameList", studentsDatasArrayList);
        request.getSession().setAttribute("classNameListForstudents", classNameList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main-page.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //操作数：负责确定查找1 插入2 更新3 删除4
        String operationNumber = request.getParameter("operationNumber");
        //查询结果
        ArrayList<studentsDatas> studentsDatasArrayList = null;
        switch (operationNumber)
        {
            case "1":
                request.setAttribute("message", "");
                studentsDatasArrayList = search(request, response);
                request.setAttribute("pageNum", "table_student");
                request.setAttribute("studentsDatas", studentsDatasArrayList);
                break;
            case "2":
                boolean isInserted = insert(request,response);
                if(isInserted==true)
                {
                    request.setAttribute("message", "插入成功");
                }
                else request.setAttribute("message", "插入失败");
                request.setAttribute("pageNum", "table_student");
                try {
                    studentsDatasArrayList = new studentsDaoImpl().selectAllstudentsDatas((String)request.getSession().getAttribute("isCollegeRole"));
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                request.setAttribute("studentsDatas", studentsDatasArrayList);
                request.getSession().setAttribute("studentsNameList", studentsDatasArrayList);
                break;
            case "3":
                boolean isUpdated = update(request,response);
                if(isUpdated==true)
                {
                    request.setAttribute("message", "更新成功");
                }
                else request.setAttribute("message", "更新失败");
                request.setAttribute("pageNum", "table_student");
                try {
                    studentsDatasArrayList = new studentsDaoImpl().selectAllstudentsDatas((String)request.getSession().getAttribute("isCollegeRole"));
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                request.setAttribute("studentsDatas", studentsDatasArrayList);
                request.getSession().setAttribute("studentsNameList", studentsDatasArrayList);
                break;
            case "4":
                boolean isDeleted = delete(request,response);
                if(isDeleted==true)
                {
                    request.setAttribute("message", "删除成功");
                }
                else request.setAttribute("message", "删除失败");
                request.setAttribute("pageNum", "table_student");
                try {
                    studentsDatasArrayList = new studentsDaoImpl().selectAllstudentsDatas((String)request.getSession().getAttribute("isCollegeRole"));
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                request.setAttribute("studentsDatas", studentsDatasArrayList);
                request.getSession().setAttribute("studentsNameList", studentsDatasArrayList);
                break;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main-page.jsp");
        dispatcher.forward(request,response);

    }

    private ArrayList<studentsDatas> search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String studentsSelect = request.getParameter("studentsSelect");
        ArrayList<studentsDatas> studentsDatasArrayList = null;
        if(studentsSelect.equals(""))
        {
            try {
                studentsDatasArrayList = new studentsDaoImpl().selectAllstudentsDatas((String)request.getSession().getAttribute("isCollegeRole"));
                return studentsDatasArrayList;
            }
            catch (Exception e)
            {
                System.out.println(e);
                return null;
            }
        }
        else
        {
            try {
                studentsDatasArrayList = new studentsDaoImpl().selectBystudentsNum(studentsSelect,(String)request.getSession().getAttribute("isCollegeRole"));
                return studentsDatasArrayList;
            }
            catch (Exception e)
            {
                System.out.println(e);
                return null;
            }
        }
    }

    private boolean insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String studentsNum = request.getParameter("insert+num");
        String studentsName = request.getParameter("insert+1");
        String studentsID = request.getParameter("insert+2");
        String studentsPassword = request.getParameter("insert+3");
        String classNum= request.getParameter("insert+4");

        studentsDatas co = new studentsDatas(studentsNum,studentsName,studentsID,classNum,null,null,null,studentsPassword);
        try {
            boolean isInserted = new studentsDaoImpl().insertstudentsData(co);
            return isInserted;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    private boolean update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String studentsNum = request.getParameter("studentsNumUpdate");
        String studentsName = request.getParameter("update+1");
        String studentsID = request.getParameter("update+2");
        String studentsPassword = request.getParameter("update+3");
        String classNum= request.getParameter("update+4");
        System.out.println(studentsNum);
        System.out.println(studentsName);
        System.out.println(studentsID);
        System.out.println(classNum);
        System.out.println(studentsPassword);
        studentsDatas co = new studentsDatas(studentsNum,studentsName,studentsID,classNum,null,null,null,studentsPassword);

        try {
            boolean isUpdated = new studentsDaoImpl().updatestudentsData(co);
            return isUpdated;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    private boolean delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String studentsNum = request.getParameter("studentsNumDelete");
        try {
            boolean isDeleted = new studentsDaoImpl().deletestudentsData(studentsNum);
            return isDeleted;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}
