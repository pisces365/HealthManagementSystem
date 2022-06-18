package dao.college;

import java.sql.*;
import java.util.ArrayList;
import basicDatas.collegeDatas;
import dao.DaoException;

public class CollegeDaoImpl implements CollegeDao{
    public ArrayList<collegeDatas> selectAllCollegeDatas(String college) throws DaoException
    {

        ArrayList<collegeDatas> collegeDatasArrayList = new ArrayList<collegeDatas>();
        String sql="SELECT * FROM 学院表  Where 学院名 LIKE ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+college+"%");

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                collegeDatas collegeDatas = new collegeDatas();
                collegeDatas.setCollegeNum(rst.getString("学院号"));
                collegeDatas.setCollegeName(rst.getString("学院名"));
                collegeDatas.setCollegeLeader(rst.getString("责任人"));
                collegeDatasArrayList.add(collegeDatas);
            }
            conn.close();
            return collegeDatasArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public collegeDatas selectByCollegeNum (String collegeNum) throws DaoException
    {
        collegeDatas coD = new collegeDatas();
        String sql="SELECT * FROM 学院表 WHERE 学院号= ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, collegeNum);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                coD.setCollegeNum(rst.getString("学院号"));
                coD.setCollegeName(rst.getString("学院名"));
                coD.setCollegeLeader(rst.getString("责任人"));
            }
            conn.close();
            return coD;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteCollegeData(String collegeNum) throws DaoException
    {
        String sql="DELETE FROM 学院表 WHERE 学院号= ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, collegeNum);
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

    public boolean insertCollegeData(collegeDatas coD) throws DaoException
    {
        String sql="INSERT INTO 学院表 VALUES(?,?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, coD.getCollegeNum());
            pstmt.setString(2, coD.getCollegeName());
            pstmt.setString(3, coD.getCollegeLeader());
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

    public boolean updateCollegeData(collegeDatas coD) throws DaoException
    {
        String sql="UPDATE 学院表 SET 学院名=?,责任人=? WHERE 学院号=?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(3, coD.getCollegeNum());
            pstmt.setString(1, coD.getCollegeName());
            pstmt.setString(2, coD.getCollegeLeader());
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
