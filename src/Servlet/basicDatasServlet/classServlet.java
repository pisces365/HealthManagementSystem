package Servlet.basicDatasServlet;

import basicDatas.classDatas;
import basicDatas.majorDatas;
import basicDatas.classDatas;
import basicDatas.classDatas;
import dao.classes.classDaoImpl;
import dao.classes.classDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "classServlet", value = "/classPage")
public class classServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String pageNum = request.getParameter("pageNum");
        request.setAttribute("pageNum", pageNum);
        ArrayList<classDatas> classesDatasArrayList = null;
        ArrayList<String> classesName = null;
        ArrayList<majorDatas> majorNameList = null;
        try {
            classesDatasArrayList = new classDaoImpl().selectAllclassDatas((String)request.getSession().getAttribute("isCollegeRole"));
            majorNameList = new dao.major.majorDaoImpl().selectAllmajorDatas((String)request.getSession().getAttribute("isCollegeRole"));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        request.setAttribute("message", "");
        request.setAttribute("classesDatas", classesDatasArrayList);
        request.getSession().setAttribute("classesNameList", classesDatasArrayList);
        request.getSession().setAttribute("majorNameListForclass", majorNameList);
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
        ArrayList<classDatas> classesDatasArrayList = null;
        switch (operationNumber)
        {
            case "1":
                request.setAttribute("message", "");
                classesDatasArrayList = search(request, response);
                request.setAttribute("pageNum", "table_class");
                request.setAttribute("classesDatas", classesDatasArrayList);
                break;
            case "2":
                boolean isInserted = insert(request,response);
                if(isInserted==true)
                {
                    request.setAttribute("message", "插入成功");
                }
                else request.setAttribute("message", "插入失败");
                request.setAttribute("pageNum", "table_class");
                try {
                    classesDatasArrayList = new classDaoImpl().selectAllclassDatas((String)request.getSession().getAttribute("isCollegeRole"));
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                request.setAttribute("classesDatas", classesDatasArrayList);
                request.getSession().setAttribute("classesNameList", classesDatasArrayList);
                break;
            case "3":
                boolean isUpdated = update(request,response);
                if(isUpdated==true)
                {
                    request.setAttribute("message", "更新成功");
                }
                else request.setAttribute("message", "更新失败");
                request.setAttribute("pageNum", "table_class");
                try {
                    classesDatasArrayList = new classDaoImpl().selectAllclassDatas((String)request.getSession().getAttribute("isCollegeRole"));
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                request.setAttribute("classesDatas", classesDatasArrayList);
                request.getSession().setAttribute("classesNameList", classesDatasArrayList);
                break;
            case "4":
                boolean isDeleted = delete(request,response);
                if(isDeleted==true)
                {
                    request.setAttribute("message", "删除成功");
                }
                else request.setAttribute("message", "删除失败");
                request.setAttribute("pageNum", "table_class");
                try {
                    classesDatasArrayList = new classDaoImpl().selectAllclassDatas((String)request.getSession().getAttribute("isCollegeRole"));
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                request.setAttribute("classesDatas", classesDatasArrayList);
                request.getSession().setAttribute("classesNameList", classesDatasArrayList);
                break;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main-page.jsp");
        dispatcher.forward(request,response);
    }

    private ArrayList<classDatas> search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String classesSelect = request.getParameter("classSelect");
        ArrayList<classDatas> classesDatasArrayList = null;
        if(classesSelect.equals("pleaseSelect"))
        {
            try {
                classesDatasArrayList = new classDaoImpl().selectAllclassDatas((String)request.getSession().getAttribute("isCollegeRole"));
                return classesDatasArrayList;
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
                classesDatasArrayList = new ArrayList<classDatas>();
                classDatas coD = new classDaoImpl().selectByclassNum(classesSelect);
                classesDatasArrayList.add(coD);
                return classesDatasArrayList;
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
        String classesNum = request.getParameter("insert+num");
        String classesName = request.getParameter("insert+0");
        String classesLeader = request.getParameter("insert+1");
        String majorNum = request.getParameter("insert+2");
        classDatas co = new classDatas(classesNum,classesName,classesLeader,majorNum,null,null,null);
        try {
            boolean isInserted = new classDaoImpl().insertclassData(co);
            return isInserted;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    private boolean update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String classesNum = request.getParameter("classNumUpdate");
        String classesName = request.getParameter("update+0");
        String classesLeader = request.getParameter("update+1");
        String majorNum = request.getParameter("update+2");
        classDatas co = new classDatas(classesNum,classesName,classesLeader,majorNum,null,null,null);

        try {
            boolean isUpdated = new classDaoImpl().updateclassData(co);
            return isUpdated;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    private boolean delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String classesNum = request.getParameter("classNumDelete");
        try {
            boolean isDeleted = new classDaoImpl().deleteclassData(classesNum);
            return isDeleted;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

}
