package Servlet.basicDatasServlet;

import basicDatas.majorDatas;
import basicDatas.collegeDatas;
import dao.major.majorDaoImpl;
import dao.college.CollegeDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "majorServlet", value = "/majorPage")
public class majorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNum = request.getParameter("pageNum");
        request.setAttribute("pageNum", pageNum);
        ArrayList<majorDatas> majorDatasArrayList = null;
        ArrayList<String> majorName = null;
        ArrayList<collegeDatas> collegeNameList = null;
        try {
            majorDatasArrayList = new majorDaoImpl().selectAllmajorDatas((String)request.getSession().getAttribute("isCollegeRole"));
            collegeNameList = new dao.college.CollegeDaoImpl().selectAllCollegeDatas((String)request.getSession().getAttribute("isCollegeRole"));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        request.setAttribute("message", "");
        request.setAttribute("majorDatas", majorDatasArrayList);
        request.getSession().setAttribute("majorNameList", majorDatasArrayList);
        request.getSession().setAttribute("collegeNameListFormajor", collegeNameList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main-page.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //操作数：负责确定查找1 插入2 更新3 删除4
        String operationNumber = request.getParameter("operationNumber");
        //查询结果
        ArrayList<majorDatas> majorDatasArrayList = null;
        switch (operationNumber)
        {
            case "1":
                request.setAttribute("message", "");
                majorDatasArrayList = search(request, response);
                request.setAttribute("pageNum", "table_major");
                request.setAttribute("majorDatas", majorDatasArrayList);
                break;
            case "2":
                boolean isInserted = insert(request,response);
                if(isInserted==true)
                {
                    request.setAttribute("message", "插入成功");
                }
                else request.setAttribute("message", "插入失败");
                request.setAttribute("pageNum", "table_major");
                try {
                    majorDatasArrayList = new majorDaoImpl().selectAllmajorDatas((String)request.getSession().getAttribute("isCollegeRole"));
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                request.setAttribute("majorDatas", majorDatasArrayList);
                request.getSession().setAttribute("majorNameList", majorDatasArrayList);
                break;
            case "3":
                boolean isUpdated = update(request,response);
                if(isUpdated==true)
                {
                    request.setAttribute("message", "更新成功");
                }
                else request.setAttribute("message", "更新失败");
                request.setAttribute("pageNum", "table_major");
                try {
                    majorDatasArrayList = new majorDaoImpl().selectAllmajorDatas((String)request.getSession().getAttribute("isCollegeRole"));
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                request.setAttribute("majorDatas", majorDatasArrayList);
                request.getSession().setAttribute("majorNameList", majorDatasArrayList);
                break;
            case "4":
                boolean isDeleted = delete(request,response);
                if(isDeleted==true)
                {
                    request.setAttribute("message", "删除成功");
                }
                else request.setAttribute("message", "删除失败");
                request.setAttribute("pageNum", "table_major");
                try {
                    majorDatasArrayList = new majorDaoImpl().selectAllmajorDatas((String)request.getSession().getAttribute("isCollegeRole"));
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                request.setAttribute("majorDatas", majorDatasArrayList);
                request.getSession().setAttribute("majorNameList", majorDatasArrayList);
                break;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main-page.jsp");
        dispatcher.forward(request,response);
    }

    private ArrayList<majorDatas> search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String majorSelect = request.getParameter("majorSelect");
        ArrayList<majorDatas> majorDatasArrayList = null;
        if(majorSelect.equals("pleaseSelect"))
        {
            try {
                majorDatasArrayList = new majorDaoImpl().selectAllmajorDatas((String)request.getSession().getAttribute("isCollegeRole"));
                return majorDatasArrayList;
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
                majorDatasArrayList = new ArrayList<majorDatas>();
                majorDatas coD = new majorDaoImpl().selectBymajorNum(majorSelect);
                majorDatasArrayList.add(coD);
                return majorDatasArrayList;
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
        String majorNum = request.getParameter("insert+num");
        String majorName = request.getParameter("insert+0");
        String majorLeader = request.getParameter("insert+1");
        String collegeNum = request.getParameter("insert+2");
        majorDatas co = new majorDatas(majorNum,majorName,majorLeader,collegeNum,null);
        try {
            boolean isInserted = new majorDaoImpl().insertmajorData(co);
            return isInserted;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    private boolean update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String majorNum = request.getParameter("majorNumUpdate");
        String majorName = request.getParameter("update+0");
        String majorLeader = request.getParameter("update+1");
        String collegeNum = request.getParameter("update+2");
        majorDatas co = new majorDatas(majorNum,majorName,majorLeader,collegeNum,null);

        try {
            boolean isUpdated = new majorDaoImpl().updatemajorData(co);
            return isUpdated;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    private boolean delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String majorNum = request.getParameter("majorNumDelete");
        try {
            boolean isDeleted = new majorDaoImpl().deletemajorData(majorNum);
            return isDeleted;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}
