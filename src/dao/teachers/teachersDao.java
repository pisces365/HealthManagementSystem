package dao.teachers;

import basicDatas.LogInDatas;
import basicDatas.teachersDatas;
import dao.Dao;
import dao.DaoException;

import java.util.ArrayList;

public interface teachersDao extends Dao {
    //查询所有专业信息
    public ArrayList<teachersDatas> selectAllteachersDatas(String college) throws DaoException;

    //以 专业号 查询特定信息
    public ArrayList<teachersDatas> selectByteachersNum (String teachersNum, String college) throws DaoException;

    //以 专业号 删除元组
    public boolean deleteteachersData(String teachersNum) throws DaoException;

    //插入新元组
    public boolean insertteachersData(teachersDatas maD) throws DaoException;

    //数据更新
    public boolean updateteachersData(teachersDatas maD) throws DaoException;

    //教师登陆验证
    public LogInDatas loginVerification(String name, String number, String password, String personType) throws DaoException;

}
