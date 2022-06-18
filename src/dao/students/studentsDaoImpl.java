package dao.students;

import basicDatas.LogInDatas;
import basicDatas.studentsDatas;
import dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class studentsDaoImpl implements studentsDao{
    public ArrayList<studentsDatas> selectAllstudentsDatas(String college) throws DaoException
    {

        ArrayList<studentsDatas> studentsDatasArrayList = new ArrayList<studentsDatas>();
        String sql="SELECT 学号,姓名,身份证,班级表.班级号,班级表.班级名,专业表.专业名,学院表.学院名,密码\n" +
                "FROM 学生表,班级表,专业表,学院表\n" +
                "WHERE 学生表.班级号=班级表.班级号 AND 班级表.专业号=专业表.专业号 AND 专业表.学院号=学院表.学院号 AND 学院名 LIKE ? ";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+college+"%");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                studentsDatas d = new studentsDatas();
                d.setStuNum(rst.getString("学号"));
                d.setStuName(rst.getString("姓名"));
                d.setStuID(rst.getString("身份证"));
                d.setClassNum(rst.getString("班级号"));
                d.setClassBelonging(rst.getString("班级名"));
                d.setMajorBelonging(rst.getString("专业名"));
                d.setCollegeBelonging(rst.getString("学院名"));
                d.setStuPassword(rst.getString("密码"));
                studentsDatasArrayList.add(d);
            }
            conn.close();
            return studentsDatasArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<studentsDatas> selectBystudentsNum (String studentsNum, String college) throws DaoException
    {
        ArrayList<studentsDatas> studentsDatasArrayList = new ArrayList<studentsDatas>();
        String sql="SELECT 学号,姓名,身份证,班级表.班级号,班级表.班级名,专业表.专业名,学院表.学院名,密码\n" +
                "FROM 学生表,班级表,专业表,学院表\n" +
                "WHERE 学生表.班级号=班级表.班级号 AND 班级表.专业号=专业表.专业号 AND 专业表.学院号=学院表.学院号  AND 学院名 LIKE ? \n" +
                "AND (学号 LIKE ? OR 姓名 LIKE ? ) ";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+college+"%");

            pstmt.setString(2, "%"+studentsNum+"%");
            pstmt.setString(3, "%"+studentsNum+"%");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                studentsDatas d = new studentsDatas();
                d.setStuNum(rst.getString("学号"));
                d.setStuName(rst.getString("姓名"));
                d.setStuID(rst.getString("身份证"));
                d.setClassNum(rst.getString("班级号"));
                d.setClassBelonging(rst.getString("班级名"));
                d.setMajorBelonging(rst.getString("专业名"));
                d.setCollegeBelonging(rst.getString("学院名"));
                d.setStuPassword(rst.getString("密码"));
                studentsDatasArrayList.add(d);
            }
            conn.close();
            return studentsDatasArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deletestudentsData(String studentsNum) throws DaoException
    {
        String sql="DELETE FROM 学生表 WHERE 学号=?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentsNum);
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

    public boolean insertstudentsData(studentsDatas coD) throws DaoException
    {
        String sql="INSERT INTO 学生表 VALUES(?,?,?,?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, coD.getStuNum());
            pstmt.setString(2, coD.getStuName());
            pstmt.setString(3, coD.getStuID());
            pstmt.setString(4, coD.getClassNum());
            pstmt.setString(5, coD.getStuPassword());
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

    public boolean updatestudentsData(studentsDatas coD) throws DaoException
    {
        String sql="UPDATE 学生表 SET 姓名=?,身份证=?,班级号=?,密码=? WHERE 学号=?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(5, coD.getStuNum());
            pstmt.setString(1, coD.getStuName());
            pstmt.setString(2, coD.getStuID());
            pstmt.setString(3, coD.getClassNum());
            pstmt.setString(4, coD.getStuPassword());
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
        String sql="SELECT 姓名,'学生' 角色,学号,学院表.学院名,身份证,密码\n" +
                "FROM 学生表,班级表,专业表,学院表\n" +
                "WHERE 学生表.班级号=班级表.班级号 AND 班级表.专业号=专业表.专业号 AND 专业表.学院号=学院表.学院号\n" +
                "AND 姓名=? AND 学号=? AND 密码=?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, number);
            pstmt.setString(3, password);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                lid.setName(rst.getString("姓名"));
                lid.setRole(rst.getString("角色"));
                lid.setNumber(rst.getString("学号"));
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
