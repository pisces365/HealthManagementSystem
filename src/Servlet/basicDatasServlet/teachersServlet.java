package Servlet.basicDatasServlet;

import basicDatas.classDatas;
import basicDatas.collegeDatas;
import basicDatas.teachersDatas;
import dao.teachers.teachersDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "teachersServlet", value = "/teachersPage")
public class teachersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String pageNum = request.getParameter("pageNum");
        request.setAttribute("pageNum", pageNum);
        ArrayList<teachersDatas> teachersDatasArrayList = null;
        ArrayList<String> teachersName = null;
        ArrayList<collegeDatas> collegeNameList = null;
        try {
            teachersDatasArrayList = new teachersDaoImpl().selectAllteachersDatas((String)request.getSession().getAttribute("isCollegeRole"));
            collegeNameList = new dao.college.CollegeDaoImpl().selectAllCollegeDatas((String)request.getSession().getAttribute("isCollegeRole"));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        request.setAttribute("message", "");
        request.setAttribute("teachersDatas", teachersDatasArrayList);
        request.getSession().setAttribute("teachersNameList", teachersDatasArrayList);
        request.getSession().setAttribute("collegeNameListForteachers", collegeNameList);
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
        ArrayList<teachersDatas> teachersDatasArrayList = null;
        switch (operationNumber)
        {
            case "1":
                request.setAttribute("message", "");
                teachersDatasArrayList = search(request, response);
                request.setAttribute("pageNum", "table_teacher");
                request.setAttribute("teachersDatas", teachersDatasArrayList);
                break;
            case "2":
                boolean isInserted = insert(request,response);
                if(isInserted==true)
                {
                    request.setAttribute("message", "插入成功");
                }
                else request.setAttribute("message", "插入失败");
                request.setAttribute("pageNum", "table_teacher");
                try {
                    teachersDatasArrayList = new teachersDaoImpl().selectAllteachersDatas((String)request.getSession().getAttribute("isCollegeRole"));
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                request.setAttribute("teachersDatas", teachersDatasArrayList);
                request.getSession().setAttribute("teachersNameList", teachersDatasArrayList);
                break;
            case "3":
                boolean isUpdated = update(request,response);
                if(isUpdated==true)
                {
                    request.setAttribute("message", "更新成功");
                }
                else request.setAttribute("message", "更新失败");
                request.setAttribute("pageNum", "table_teacher");
                try {
                    teachersDatasArrayList = new teachersDaoImpl().selectAllteachersDatas((String)request.getSession().getAttribute("isCollegeRole"));
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                request.setAttribute("teachersDatas", teachersDatasArrayList);
                request.getSession().setAttribute("teachersNameList", teachersDatasArrayList);
                break;
            case "4":
                boolean isDeleted = delete(request,response);
                if(isDeleted==true)
                {
                    request.setAttribute("message", "删除成功");
                }
                else request.setAttribute("message", "删除失败");
                request.setAttribute("pageNum", "table_teacher");
                try {
                    teachersDatasArrayList = new teachersDaoImpl().selectAllteachersDatas((String)request.getSession().getAttribute("isCollegeRole"));
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                request.setAttribute("teachersDatas", teachersDatasArrayList);
                request.getSession().setAttribute("teachersNameList", teachersDatasArrayList);
                break;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main-page.jsp");
        dispatcher.forward(request,response);
    }

    private ArrayList<teachersDatas> search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String teachersSelect = request.getParameter("teachersSelect");
        ArrayList<teachersDatas> teachersDatasArrayList = null;
        if(teachersSelect.equals("pleaseSelect"))
        {
            try {
                teachersDatasArrayList = new teachersDaoImpl().selectAllteachersDatas((String)request.getSession().getAttribute("isCollegeRole"));
                return teachersDatasArrayList;
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
                teachersDatasArrayList = new teachersDaoImpl().selectByteachersNum(teachersSelect,(String)request.getSession().getAttribute("isCollegeRole"));
                return teachersDatasArrayList;
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
        String teachersNum = request.getParameter("insert+num");
        String teachersName = request.getParameter("insert+1");
        String teachersID = request.getParameter("insert+2");
        String role = request.getParameter("insert+3");
        String teachersPassword = request.getParameter("insert+4");
        String collegeNum= request.getParameter("insert+5");
        System.out.println(teachersNum);
        System.out.println(teachersName);
        System.out.println(teachersID);
        System.out.println(role);
        System.out.println(teachersPassword);
        System.out.println(collegeNum);

        teachersDatas co = new teachersDatas(teachersNum,teachersName,teachersID,role,collegeNum,null,teachersPassword);
        try {
            boolean isInserted = new teachersDaoImpl().insertteachersData(co);
            return isInserted;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    private boolean update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String teachersNum = request.getParameter("teachersNumUpdate");
        String teachersName = request.getParameter("update+1");
        String teachersID = request.getParameter("update+2");
        String role = request.getParameter("update+3");
        String teachersPassword = request.getParameter("update+4");
        String collegeNum= request.getParameter("update+5");

        teachersDatas co = new teachersDatas(teachersNum,teachersName,teachersID,role,collegeNum,null,teachersPassword);

        try {
            boolean isUpdated = new teachersDaoImpl().updateteachersData(co);
            return isUpdated;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    private boolean delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String teachersNum = request.getParameter("teachersNumDelete");
        try {
            boolean isDeleted = new teachersDaoImpl().deleteteachersData(teachersNum);
            return isDeleted;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}
