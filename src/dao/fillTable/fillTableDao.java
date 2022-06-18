package dao.fillTable;

import basicDatas.studentsDatas;
import dao.Dao;
import dao.DaoException;

import java.util.ArrayList;
import java.util.Date;

public interface fillTableDao extends Dao {
    //查询用户打卡记录，并返回正确颜色
    public String selectColor (String studentsNum, Date currentDate, String personType) throws DaoException;

    //今日是否已经打卡
    public String isFill (String studentsNum, Date date, String personType) throws DaoException;

    public boolean isFillbool (String studentsNum, Date date, String personType) throws DaoException;

    //插入新元组
    public boolean insertstudentsData(String number,String color,Date date,String phone, String personType) throws DaoException;
}
