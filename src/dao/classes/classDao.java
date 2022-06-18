package dao.classes;
import java.util.ArrayList;
import basicDatas.classDatas;
import dao.Dao;
import dao.DaoException;
public interface classDao extends Dao {
    //查询所有班级信息
    public ArrayList<classDatas> selectAllclassDatas(String college) throws DaoException;

    //以 学院号 查询特定信息
    public classDatas selectByclassNum (String classNum) throws DaoException;

    //以 学院号 删除元组
    public boolean deleteclassData(String classNum) throws DaoException;

    //插入新元组
    public boolean insertclassData(classDatas coD) throws DaoException;

    //数据更新
    public boolean updateclassData(classDatas coD) throws DaoException;


}
