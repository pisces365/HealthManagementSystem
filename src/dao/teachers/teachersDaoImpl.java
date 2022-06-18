package dao.teachers;

import basicDatas.LogInDatas;
import basicDatas.teachersDatas;
import dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class teachersDaoImpl implements teachersDao{
    public ArrayList<teachersDatas> selectAllteachersDatas(String college) throws DaoException
    {

        ArrayList<teachersDatas> teachersDatasArrayList = new ArrayList<teachersDatas>();
        String sql="SELECT 工号,姓名,身份证,角色,密码,学院表.学院号,学院表.学院名\n" +
                "FROM 教师表,学院表\n" +
                "WHERE 教师表.学院号=学院表.学院号 AND 学院名 LIKE ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+college+"%");

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                teachersDatas d = new teachersDatas();
                d.setTeacherNum(rst.getString("工号"));
                d.setTeacherName(rst.getString("姓名"));
                d.setTeacherID(rst.getString("身份证"));
                d.setRole(rst.getString("角色"));
                d.setTeacherPassword(rst.getString("密码"));
                d.setCollegeNum(rst.getString("学院号"));
                d.setCollegeBelonging(rst.getString("学院名"));
                teachersDatasArrayList.add(d);
            }
            conn.close();
            return teachersDatasArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<teachersDatas> selectByteachersNum (String teachersNum, String college) throws DaoException
    {
        ArrayList<teachersDatas> teachersDatasArrayList = new ArrayList<teachersDatas>();
        String sql="SELECT 工号,姓名,身份证,角色,密码,学院表.学院号,学院表.学院名\n" +
                "FROM 教师表,学院表\n" +
                "WHERE 教师表.学院号=学院表.学院号  AND 学院名 LIKE ?  \n" +
                "AND (工号 LIKE ? OR 姓名 LIKE ? ) ";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+college+"%");

            pstmt.setString(2, "%"+teachersNum+"%");
            pstmt.setString(3, "%"+teachersNum+"%");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                teachersDatas d = new teachersDatas();
                d.setTeacherNum(rst.getString("工号"));
                d.setTeacherName(rst.getString("姓名"));
                d.setTeacherID(rst.getString("身份证"));
                d.setRole(rst.getString("角色"));
                d.setTeacherPassword(rst.getString("密码"));
                d.setCollegeNum(rst.getString("学院号"));
                d.setCollegeBelonging(rst.getString("学院名"));
                teachersDatasArrayList.add(d);
            }
            conn.close();
            return teachersDatasArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteteachersData(String teachersNum) throws DaoException
    {
        String sql="DELETE FROM 教师表 WHERE 工号=?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, teachersNum);
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

    public boolean insertteachersData(teachersDatas coD) throws DaoException
    {
        String sql="INSERT INTO 教师表 VALUES(?,?,?,?,?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, coD.getTeacherNum());
            pstmt.setString(2, coD.getTeacherName());
            pstmt.setString(3, coD.getTeacherID());
            pstmt.setString(4, coD.getRole());
            pstmt.setString(5, coD.getCollegeNum());
            pstmt.setString(6, coD.getTeacherPassword());
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

    public boolean updateteachersData(teachersDatas coD) throws DaoException
    {
        String sql="UPDATE 教师表 SET 姓名=?,身份证=?,角色=?,学院号=?,密码=? WHERE 工号=?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(6, coD.getTeacherNum());
            pstmt.setString(1, coD.getTeacherName());
            pstmt.setString(2, coD.getTeacherID());
            pstmt.setString(3, coD.getRole());
            pstmt.setString(4, coD.getCollegeNum());
            pstmt.setString(5, coD.getTeacherPassword());
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

    public LogInDatas loginVerification(String name, String number, String password, String personType) throws DaoException
    {
        LogInDatas lid = new LogInDatas();
        String sql="SELECT 姓名,角色,工号,学院表.学院名,身份证,密码\n" +
                "FROM 教师表,学院表\n" +
                "WHERE 教师表.学院号=学院表.学院号\n" +
                "AND 姓名=? AND 工号=? AND 密码=? AND 角色=? ";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, number);
            pstmt.setString(3, password);
            pstmt.setString(4, personType);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                lid.setName(rst.getString("姓名"));
                lid.setRole(rst.getString("角色"));
                lid.setNumber(rst.getString("工号"));
                lid.setCollege(rst.getString("学院名"));
                lid.setId(rst.getString("身份证"));
                lid.setPassword(rst.getString("密码"));
            }
            conn.close();
            return lid;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }


    }
}
