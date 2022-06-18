package dao.fillTable;

import basicDatas.majorDatas;
import basicDatas.studentsDatas;
import dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class fillTableDaoImpl implements  fillTableDao{

    //查询用户打卡记录，并返回正确颜色
    public String selectColor (String studentsNum, Date currentDate, String personType) throws DaoException
    {
        //获取前一天的时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = currentDate;
        Calendar calendar = Calendar.getInstance();
        String sqlDate = null;//转换为数据库存储的日期
        int redRecord = 0;//记录红色（绿）码的连续次数
        int yellowRecord = 0;//记录黄色（绿）码的连续次数
        Connection conn = getConnection();
        for(int i=0;i<7;++i)
        {
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            date = calendar.getTime();
            sqlDate = sdf.format(date);

            String sql;
            if(personType.equals("学生"))
            {
                sql="SELECT 学号,健康码颜色,填报日期\n" +
                    "FROM 学生打卡表\n" +
                    "WHERE 学号=? AND 填报日期=? ";
            }
            else
            {
                sql="SELECT 工号,健康码颜色,填报日期\n" +
                        "FROM 教师打卡表\n" +
                        "WHERE 工号=? AND 填报日期=? ";
            }

            try
            {

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, studentsNum);
                pstmt.setString(2, sqlDate);
                ResultSet rst = pstmt.executeQuery();
                if(rst.next() == false){
                        conn.close();
                        return "绿色";
                }

                String color = rst.getString("健康码颜色");

                if(color.equals("蓝色"))
                {
                    conn.close();
                    return "蓝色";
                }
                else if(color.equals("绿色"))
                {
                    conn.close();
                    return "绿色";
                }
                else if(color.equals("黄色"))
                {
                    conn.close();
                    return "黄色（绿）";
                }
                else if(color.equals("红色"))
                {
                    conn.close();
                    return "红色（绿）";
                }
                else if(color.equals("黄色（绿）"))
                {
                    yellowRecord++;
                }
                else if(color.equals("红色（绿）"))
                {
                    redRecord++;
                }

                if(yellowRecord==7)
                {
                    conn.close();
                    return "绿色";
                }

                if(redRecord==7)
                {
                    conn.close();
                    return "黄色（绿）";
                }

            }
            catch (SQLException e)
            {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    //今日是否打卡查询
    public String isFill (String studentsNum, Date date, String personType) throws DaoException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        String sql;
        if(personType.equals("学生"))
        {
            sql="SELECT 学号,健康码颜色,填报日期\n" +
                    "FROM 学生打卡表\n" +
                    "WHERE 学号=? AND 填报日期=? ";
        }
        else
        {
            sql="SELECT 工号,健康码颜色,填报日期\n" +
                    "FROM 教师打卡表\n" +
                    "WHERE 工号=? AND 填报日期=? ";
        }
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentsNum);
            pstmt.setString(2, sdf.format(date));
            ResultSet rst = pstmt.executeQuery();


            if(rst.next() == false){
                conn.close();
                return null;
            }
            else
            {
                String re = rst.getString("健康码颜色");
                conn.close();
                return re;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isFillbool (String studentsNum, Date date, String personType) throws DaoException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String sql;
        if(personType.equals("学生"))
        {
            sql="SELECT 学号,健康码颜色,填报日期\n" +
                    "FROM 学生打卡表\n" +
                    "WHERE 学号=? AND 填报日期=? ";
        }
        else
        {
            sql="SELECT 工号,健康码颜色,填报日期\n" +
                    "FROM 教师打卡表\n" +
                    "WHERE 工号=? AND 填报日期=? ";
        }
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentsNum);
            pstmt.setString(2, sdf.format(date));
            ResultSet rst = pstmt.executeQuery();


            if(rst.next() == false){
                conn.close();
                return false;
            }
            else
            {
                conn.close();
                return true;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    //插入新元组
    public boolean insertstudentsData(String number,String color,Date date,String phone, String personType) throws DaoException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String sql;
        if(personType.equals("学生"))
        {
            sql="INSERT INTO 学生打卡表 VALUES(?,?,?,?)";
        }
        else
        {
            sql="INSERT INTO 教师打卡表 VALUES(?,?,?,?)";
        }
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, number);
            pstmt.setString(2, color);
            pstmt.setString(3, sdf.format(date));
            pstmt.setString(4, phone);
            int n = pstmt.executeUpdate();
            conn.close();
            if(n!=0)
            {
                conn.close();
                return true;
            }
            conn.close();
            return false;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("学生打卡信息插入失败");
            return false;
        }
    }
}
