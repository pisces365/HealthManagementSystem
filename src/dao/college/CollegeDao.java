package dao.college;

import java.util.ArrayList;
import basicDatas.collegeDatas;
import dao.DaoException;

public interface CollegeDao extends dao.Dao{
    //查询所有学院信息
    public ArrayList<collegeDatas> selectAllCollegeDatas(String college) throws DaoException;

    //以 学院号 查询特定信息
    public collegeDatas selectByCollegeNum (String collegeNum) throws DaoException;

    //以 学院号 删除元组
    public boolean deleteCollegeData(String collegeNum) throws DaoException;

    //插入新元组
    public boolean insertCollegeData(collegeDatas coD) throws DaoException;

    //数据更新
    public boolean updateCollegeData(collegeDatas coD) throws DaoException;

}
