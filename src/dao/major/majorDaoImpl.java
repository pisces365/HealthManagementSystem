package dao.major;

import basicDatas.majorDatas;
import dao.DaoException;
import dao.major.majorDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class majorDaoImpl  implements majorDao {

    public ArrayList<majorDatas> selectAllmajorDatas(String college) throws DaoException
    {

        ArrayList<majorDatas> majorDatasArrayList = new ArrayList<majorDatas>();
        String sql="SELECT 专业号,专业名,系主任,专业表.学院号,学院名 FROM 专业表,学院表 WHERE 专业表.学院号=学院表.学院号  AND 学院名 LIKE ? ";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+college+"%");

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                majorDatas d = new majorDatas();
                d.setMajorNum(rst.getString("专业号"));
                d.setMajorName(rst.getString("专业名"));
                d.setMajorLeader(rst.getString("系主任"));
                d.setCollegeNum(rst.getString("学院号"));
                d.setCollegeBelonging(rst.getString("学院名"));
                majorDatasArrayList.add(d);
            }
            conn.close();
            return majorDatasArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public majorDatas selectBymajorNum (String majorNum) throws DaoException
    {
        majorDatas d = new majorDatas();
        String sql="SELECT 专业号,专业名,系主任,专业表.学院号,学院名 FROM 专业表,学院表 WHERE 专业表.学院号=学院表.学院号 AND 专业号=?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, majorNum);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                d.setMajorNum(rst.getString("专业号"));
                d.setMajorName(rst.getString("专业名"));
                d.setMajorLeader(rst.getString("系主任"));
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

    public boolean deletemajorData(String majorNum) throws DaoException
    {
        String sql="DELETE FROM 专业表 WHERE 专业号= ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, majorNum);
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

    public boolean insertmajorData(majorDatas coD) throws DaoException
    {
        String sql="INSERT INTO 专业表 VALUES(?,?,?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, coD.getMajorNum());
            pstmt.setString(2, coD.getMajorName());
            pstmt.setString(3, coD.getMajorLeader());
            pstmt.setString(4, coD.getCollegeNum());
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

    public boolean updatemajorData(majorDatas coD) throws DaoException
    {
        String sql="UPDATE 专业表 SET 专业名=?,系主任=?,学院号=? WHERE 专业号=?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(4, coD.getMajorNum());
            pstmt.setString(1, coD.getMajorName());
            pstmt.setString(2, coD.getMajorLeader());
            pstmt.setString(3, coD.getCollegeNum());
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
