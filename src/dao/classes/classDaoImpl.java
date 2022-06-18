package dao.classes;

import basicDatas.classDatas;
import dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class classDaoImpl implements classDao{

    public ArrayList<classDatas> selectAllclassDatas(String college) throws DaoException
    {

        ArrayList<classDatas> classDatasArrayList = new ArrayList<classDatas>();
        String sql="SELECT 班级号,班级名,班主任,班级表.专业号,专业表.专业名,专业表.学院号,学院表.学院名 学院名 \n" +
                "FROM 专业表,学院表,班级表\n" +
                "WHERE 专业表.学院号=学院表.学院号 AND 班级表.专业号=专业表.专业号 AND 学院表.学院名 LIKE ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+college+"%");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                classDatas d = new classDatas();
                d.setClassNum(rst.getString("班级号"));
                d.setClassName(rst.getString("班级名"));
                d.setClassLeader(rst.getString("班主任"));
                d.setMajorNum(rst.getString("专业号"));
                d.setMajorBelonging(rst.getString("专业名"));
                d.setCollegeNum(rst.getString("学院号"));
                d.setCollegeBelonging(rst.getString("学院名"));
                classDatasArrayList.add(d);
            }
            conn.close();
            return classDatasArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public classDatas selectByclassNum (String classNum) throws DaoException
    {
        classDatas d = new classDatas();
        String sql="SELECT 班级号,班级名,班主任,班级表.专业号,专业表.专业名,专业表.学院号,学院表.学院名 \n" +
                "FROM 专业表,学院表,班级表\n" +
                "WHERE 专业表.学院号=学院表.学院号 AND 班级表.专业号=专业表.专业号 AND 班级号=?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, classNum);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                d.setClassNum(rst.getString("班级号"));
                d.setClassName(rst.getString("班级名"));
                d.setClassLeader(rst.getString("班主任"));
                d.setMajorNum(rst.getString("专业号"));
                d.setMajorBelonging(rst.getString("专业名"));
                d.setCollegeNum(rst.getString("学院号"));
                d.setCollegeBelonging(rst.getString("学院名"));
            }
            conn.close();
            return d;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteclassData(String classNum) throws DaoException
    {
        String sql="DELETE FROM 班级表 WHERE 班级号=?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, classNum);
            int n = pstmt.executeUpdate();
            conn.close();
            if(n!=0)
            {
                return true;
            }
            return false;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertclassData(classDatas coD) throws DaoException
    {
        String sql="INSERT INTO 班级表 VALUES(?,?,?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, coD.getClassNum());
            pstmt.setString(2, coD.getClassName());
            pstmt.setString(3, coD.getClassLeader());
            pstmt.setString(4, coD.getMajorNum());
            int n = pstmt.executeUpdate();
            conn.close();
            if(n!=0)
            {
                return true;
            }
            return false;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateclassData(classDatas coD) throws DaoException
    {
        String sql="UPDATE 班级表 SET 班级名=?,班主任=?,专业号=? WHERE 班级号=?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(4, coD.getClassNum());
            pstmt.setString(1, coD.getClassName());
            pstmt.setString(2, coD.getClassLeader());
            pstmt.setString(3, coD.getMajorNum());
            int n = pstmt.executeUpdate();
            conn.close();
            if(n!=0)
            {
                return true;
            }
            return false;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

}
