package dao.students;

import basicDatas.LogInDatas;
import basicDatas.studentsDatas;
import dao.Dao;
import dao.DaoException;

import java.util.ArrayList;

public interface studentsDao extends Dao {
    //查询所有专业信息
    public ArrayList<studentsDatas> selectAllstudentsDatas(String college) throws DaoException;

    //以 专业号 查询特定信息
    public ArrayList<studentsDatas> selectBystudentsNum (String studentsNum, String college) throws DaoException;

    //以 专业号 删除元组
    public boolean deletestudentsData(String studentsNum) throws DaoException;

    //插入新元组
    public boolean insertstudentsData(studentsDatas maD) throws DaoException;

    //数据更新
    public boolean updatestudentsData(studentsDatas maD) throws DaoException;

    //学生登陆验证
    public LogInDatas loginVerification(String name,String number,String password, String personType) throws DaoException;
}
