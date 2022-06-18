package dao.dataStatistics;

import basicDatas.QRcodeColors;
import dao.Dao;
import dao.DaoException;

import java.util.HashMap;

public interface dataStatisticsDao extends Dao {
    public QRcodeColors selectColorsStu(String college, String major, String classes) throws DaoException;

    public HashMap<String,Integer> selectdatasStu(String college, String major) throws DaoException;

    public QRcodeColors selectColorsTea(String college) throws DaoException;

    public HashMap<String,Integer> selectdatasTea(String college) throws DaoException;

    public int howManyStu(String college)  throws DaoException;

    public int howManyTea(String college)  throws DaoException;

    public int percentStu(String college)  throws DaoException;

    public int percentTea(String college)  throws DaoException;
}
