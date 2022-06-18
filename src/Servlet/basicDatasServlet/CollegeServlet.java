package Servlet.basicDatasServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

import basicDatas.collegeDatas;
import dao.college.CollegeDao;
import dao.college.CollegeDaoImpl;

@WebServlet(name = "CollegeServlet", value = "/CollegePage")
public class CollegeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String pageNum = request.getParameter("pageNum");
        request.setAttribute("pageNum", pageNum);
        ArrayList<collegeDatas> collegeDatasArrayList = null;
        ArrayList<String> collegeName = null;
        try {
            collegeDatasArrayList = new CollegeDaoImpl().selectAllCollegeDatas((String)request.getSession().getAttribute("isCollegeRole"));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        request.setAttribute("message", "");
        request.setAttribute("collegeDatas", collegeDatasArrayList);
        request.getSession().setAttribute("collegeNameList", collegeDatasArrayList);
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
        ArrayList<collegeDatas> collegeDatasArrayList = null;

        switch (operationNumber)
        {
            case "1":
                request.setAttribute("message", "");
                collegeDatasArrayList = search(request, response);
                request.setAttribute("pageNum", "table_college");
                request.setAttribute("collegeDatas", collegeDatasArrayList);
                break;
            case "2":
                boolean isInserted = insert(request,response);
                if(isInserted==true)
                {
                    request.setAttribute("message", "插入成功");
                }
                else request.setAttribute("message", "插入失败");
                request.setAttribute("pageNum", "table_college");
                try {
                    collegeDatasArrayList = new CollegeDaoImpl().selectAllCollegeDatas((String)request.getSession().getAttribute("isCollegeRole"));
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                request.setAttribute("collegeDatas", collegeDatasArrayList);
                request.getSession().setAttribute("collegeNameList", collegeDatasArrayList);
                break;
            case "3":
                boolean isUpdated = update(request,response);
                if(isUpdated==true)
                {
                    request.setAttribute("message", "更新成功");
                }
                else request.setAttribute("message", "更新失败");
                request.setAttribute("pageNum", "table_college");
                try {
                    collegeDatasArrayList = new CollegeDaoImpl().selectAllCollegeDatas((String)request.getSession().getAttribute("isCollegeRole"));
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                request.setAttribute("collegeDatas", collegeDatasArrayList);
                request.getSession().setAttribute("collegeNameList", collegeDatasArrayList);
                break;
            case "4":
                boolean isDeleted = delete(request,response);
                if(isDeleted==true)
                {
                    request.setAttribute("message", "删除成功");
                }
                else request.setAttribute("message", "删除失败");
                request.setAttribute("pageNum", "table_college");
                try {
                    collegeDatasArrayList = new CollegeDaoImpl().selectAllCollegeDatas((String)request.getSession().getAttribute("isCollegeRole"));
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                request.setAttribute("collegeDatas", collegeDatasArrayList);
                request.getSession().setAttribute("collegeNameList", collegeDatasArrayList);
                break;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main-page.jsp");
        dispatcher.forward(request,response);
    }

    private ArrayList<collegeDatas> search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String CollegeSelect = request.getParameter("CollegeSelect");
        ArrayList<collegeDatas> collegeDatasArrayList = null;
        if(CollegeSelect.equals("pleaseSelect"))
        {
            try {
                collegeDatasArrayList = new CollegeDaoImpl().selectAllCollegeDatas((String)request.getSession().getAttribute("isCollegeRole"));
                return collegeDatasArrayList;
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
                collegeDatasArrayList = new ArrayList<collegeDatas>();
                collegeDatas coD = new CollegeDaoImpl().selectByCollegeNum(CollegeSelect);
                collegeDatasArrayList.add(coD);
                return collegeDatasArrayList;
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
        String CollegeNum = request.getParameter("insert+num");
        String CollegeName = request.getParameter("insert+0");
        String CollegeLeader = request.getParameter("insert+1");
        collegeDatas co = new collegeDatas(CollegeNum,CollegeName,CollegeLeader);
        try {
            boolean isInserted = new CollegeDaoImpl().insertCollegeData(co);
            return isInserted;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    private boolean update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String CollegeNum = request.getParameter("CollegeNumUpdate");
        String CollegeName = request.getParameter("update+0");
        String CollegeLeader = request.getParameter("update+1");
        collegeDatas co = new collegeDatas(CollegeNum,CollegeName,CollegeLeader);

        try {
            boolean isUpdated = new CollegeDaoImpl().updateCollegeData(co);
            return isUpdated;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    private boolean delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String CollegeNum = request.getParameter("CollegeNumDelete");
        try {
            boolean isDeleted = new CollegeDaoImpl().deleteCollegeData(CollegeNum);
            return isDeleted;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}
