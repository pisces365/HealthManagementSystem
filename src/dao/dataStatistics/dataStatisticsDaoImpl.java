package dao.dataStatistics;

import basicDatas.QRcodeColors;
import basicDatas.majorDatas;
import dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class dataStatisticsDaoImpl implements dataStatisticsDao{
    public QRcodeColors selectColorsStu(String college,String major,String classes) throws DaoException
    {
        if(college.equals("请选择"))
        {
            college = "";
        }
        if(major.equals("请选择"))
        {
            major = "";
        }
        if(classes.equals("请选择"))
        {
            classes = "";
        }

        String sql="SELECT 健康码颜色, COUNT(学生打卡表.学号) 数量\n" +
                "FROM 学生打卡表,学院表,专业表,班级表,学生表\n" +
                "WHERE 学生打卡表.学号=学生表.学号 AND \n" +
                "\t学生表.班级号=班级表.班级号 AND\n" +
                "\t班级表.专业号=专业表.专业号 AND\n" +
                "\t专业表.学院号=学院表.学院号 AND\n" +
                "\t学院名 LIKE ? AND 专业名 LIKE ? AND 班级名 LIKE ? AND 填报日期= ? \n" +
                "GROUP BY 健康码颜色";

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        QRcodeColors qc = new QRcodeColors(0,0,0,0);
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+college+"%");
            pstmt.setString(2, "%"+major+"%");
            pstmt.setString(3, "%"+classes+"%");
            pstmt.setString(4, sdf.format(date));
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                if(rst.getString("健康码颜色").equals("蓝色"))
                {
                    qc.setBlue(rst.getInt("数量"));
                }
                else if(rst.getString("健康码颜色").equals("绿色"))
                {
                    qc.setGreen(rst.getInt("数量"));
                }
                else if(rst.getString("健康码颜色").equals("黄色")||rst.getString("健康码颜色").equals("黄色（绿）"))
                {
                    qc.setYellow(rst.getInt("数量"));
                }
                else
                {
                    qc.setRed(rst.getInt("数量"));
                }
            }
            conn.close();
            return qc;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("selectColorsStu error: "+e);
            return null;
        }
    }

    public HashMap<String,Integer> selectdatasStu(String college, String major) throws DaoException
    {
        try
        {
            HashMap<String,Integer> hm = new HashMap<String,Integer>();
            String sql = null;
            Connection conn = getConnection();
            PreparedStatement pstmt;
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
        if(college.equals("请选择")&&major.equals("请选择"))
        {
            sql="SELECT 学院名 名字,COUNT(学生打卡表.学号) 数量\n" +
                    "FROM 学生打卡表,学院表,专业表,班级表,学生表\n" +
                    "WHERE 学生打卡表.学号=学生表.学号 AND \n" +
                    "\t学生表.班级号=班级表.班级号 AND\n" +
                    "\t班级表.专业号=专业表.专业号 AND\n" +
                    "\t专业表.学院号=学院表.学院号 AND 填报日期 LIKE ? \n" +
                    "GROUP BY 学院名";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sdf.format(date));
        }
        else if(major.equals("请选择"))
        {
            sql="SELECT 专业名 名字,COUNT(学生打卡表.学号) 数量\n" +
                    "FROM 学生打卡表,学院表,专业表,班级表,学生表\n" +
                    "WHERE 学生打卡表.学号=学生表.学号 AND \n" +
                    "\t学生表.班级号=班级表.班级号 AND\n" +
                    "\t班级表.专业号=专业表.专业号 AND\n" +
                    "\t专业表.学院号=学院表.学院号 AND\n" +
                    "\t学院名 LIKE ? AND 填报日期 LIKE ?  \n" +
                    "GROUP BY 专业名";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+college+"%");
            pstmt.setString(2, sdf.format(date));
        }
        else
        {
            sql="SELECT 班级名 名字,COUNT(学生打卡表.学号) 数量\n" +
                    "FROM 学生打卡表,学院表,专业表,班级表,学生表\n" +
                    "WHERE 学生打卡表.学号=学生表.学号 AND \n" +
                    "\t学生表.班级号=班级表.班级号 AND\n" +
                    "\t班级表.专业号=专业表.专业号 AND\n" +
                    "\t专业表.学院号=学院表.学院号 AND\n" +
                    "\t学院名 LIKE ? AND 专业名 LIKE ?  AND 填报日期 LIKE ? \n" +
                    "GROUP BY 班级名";

            pstmt = conn.prepareStatement(sql);
            if(college.equals("请选择"))
                pstmt.setString(1, "%"+"%");
            else
                pstmt.setString(1, "%"+college+"%");

            pstmt.setString(2, "%"+major+"%");
            pstmt.setString(3, sdf.format(date));
        }

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                hm.put(rst.getString("名字"),rst.getInt("数量"));
            }
            conn.close();
            return hm;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public QRcodeColors selectColorsTea(String college) throws DaoException
    {
        if(college.equals("请选择"))
        {
            college = "";
        }

        String sql="SELECT 健康码颜色, COUNT(教师打卡表.工号) 数量\n" +
                "FROM 教师打卡表,学院表,教师表\n" +
                "WHERE 教师打卡表.工号=教师表.工号 AND \n" +
                "\t教师表.学院号=学院表.学院号 AND\n" +
                "\t学院名 LIKE ? AND 填报日期 LIKE ? \n" +
                "GROUP BY 健康码颜色";

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        QRcodeColors qc = new QRcodeColors(0,0,0,0);
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+college+"%");
            pstmt.setString(2, sdf.format(date));
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                if(rst.getString("健康码颜色").equals("蓝色"))
                {
                    qc.setBlue(rst.getInt("数量"));
                }
                else if(rst.getString("健康码颜色").equals("绿色"))
                {
                    qc.setGreen(rst.getInt("数量"));
                }
                else if(rst.getString("健康码颜色").equals("黄色")||rst.getString("健康码颜色").equals("黄色（绿）"))
                {
                    qc.setYellow(rst.getInt("数量"));
                }
                else
                {
                    qc.setRed(rst.getInt("数量"));
                }
            }
            conn.close();
            return qc;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("selectColorsTea error: "+e);
            return null;
        }
    }

    public HashMap<String,Integer> selectdatasTea(String college) throws DaoException
    {
        try
        {
            HashMap<String,Integer> hm = new HashMap<String,Integer>();
            String sql = null;
            Connection conn = getConnection();
            PreparedStatement pstmt;
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            sql="SELECT 学院名 名字, COUNT(教师打卡表.工号) 数量\n" +
                    "FROM 教师打卡表,学院表,教师表\n" +
                    "WHERE 教师打卡表.工号=教师表.工号 AND \n" +
                    "\t教师表.学院号=学院表.学院号 AND 填报日期 LIKE ?   AND 学院名 LIKE ? \n" +
                    "GROUP BY 学院名";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sdf.format(date));
            pstmt.setString(2, "%"+college+"%");

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                hm.put(rst.getString("名字"),rst.getInt("数量"));
            }
            conn.close();
            return hm;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public int howManyStu(String college)  throws DaoException
    {
        try
        {
            String sql = null;
            Connection conn = getConnection();
            PreparedStatement pstmt;
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            sql="SELECT COUNT(学生打卡表.学号) 数量\n" +
                    "FROM 学生打卡表,学院表,专业表,班级表,学生表\n" +
                    "WHERE 填报日期=? AND 学生打卡表.学号=学生表.学号 AND \n" +
                    "\t学生表.班级号=班级表.班级号 AND\n" +
                    "\t班级表.专业号=专业表.专业号 AND\n" +
                    "\t专业表.学院号=学院表.学院号 AND\n" +
                    "\t学院名 LIKE ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sdf.format(date));
            pstmt.setString(2, "%"+college+"%");

            ResultSet rst = pstmt.executeQuery();
            int re=0;
            while (rst.next())
            {
                re = rst.getInt("数量");
            }
            conn.close();
            System.out.println(re);
            return re;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    public int howManyTea(String college)  throws DaoException
    {
        try
        {
            String sql = null;
            Connection conn = getConnection();
            PreparedStatement pstmt;
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            sql="SELECT COUNT(教师打卡表.工号) 数量\n" +
                    "FROM 教师打卡表,学院表,教师表\n" +
                    "WHERE 教师打卡表.工号=教师表.工号 AND \n" +
                    "\t教师表.学院号=学院表.学院号 AND 填报日期 LIKE ?  AND 学院名 LIKE ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sdf.format(date));
            pstmt.setString(2, "%"+college+"%");

            ResultSet rst = pstmt.executeQuery();
            int re=0;
            while (rst.next())
            {
                re = rst.getInt("数量");
            }
            conn.close();
            System.out.println(re);
            return re;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    public int percentStu(String college)  throws DaoException
    {
        try
        {
            String sql = null;
            Connection conn = getConnection();
            PreparedStatement pstmt;

            sql="\n" +
                    "SELECT COUNT(学号) 数量\n" +
                    "FROM 学生表,班级表,专业表,学院表\n" +
                    "WHERE 学生表.班级号=班级表.班级号 AND 班级表.专业号=专业表.专业号 AND 专业表.学院号=学院表.学院号 AND 学院名 LIKE ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+college+"%");

            ResultSet rst = pstmt.executeQuery();
            int re=0;
            while (rst.next())
            {
                re = rst.getInt("数量");
            }
            conn.close();
            System.out.println(re);
            return re;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    public int percentTea(String college)  throws DaoException
    {
        try
        {
            String sql = null;
            Connection conn = getConnection();
            PreparedStatement pstmt;

            sql="SELECT COUNT(工号) 数量\n" +
                    "FROM 教师表,学院表\n" +
                    "WHERE 教师表.学院号=学院表.学院号 AND 学院名 LIKE ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+college+"%");

            ResultSet rst = pstmt.executeQuery();
            int re=0;
            while (rst.next())
            {
                re = rst.getInt("数量");
            }
            conn.close();
            System.out.println(re);
            return re;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }
}
