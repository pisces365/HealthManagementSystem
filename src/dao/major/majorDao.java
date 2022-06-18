package dao.major;
import java.util.ArrayList;
import basicDatas.majorDatas;
import dao.DaoException;
public interface majorDao extends dao.Dao{
    //查询所有专业信息
    public ArrayList<majorDatas> selectAllmajorDatas(String college) throws DaoException;

    //以 专业号 查询特定信息
    public majorDatas selectBymajorNum (String majorNum) throws DaoException;

    //以 专业号 删除元组
    public boolean deletemajorData(String majorNum) throws DaoException;

    //插入新元组
    public boolean insertmajorData(majorDatas maD) throws DaoException;

    //数据更新
    public boolean updatemajorData(majorDatas maD) throws DaoException;


}
