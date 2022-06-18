package LogIn;

import basicDatas.LogInDatas;
import dao.students.studentsDaoImpl;
import dao.teachers.teachersDaoImpl;

public class LogInHandler {
    public LogInHandler() {
    }

    public static LogInDatas logInHandler(String personType,String name,String number,String password)
    {
        LogInDatas lid = null;
        if(personType.equals("学生"))
        {
            try{
                lid = new studentsDaoImpl().loginVerification(name, number, password, personType);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            try{
                lid = new teachersDaoImpl().loginVerification(name, number, password, personType);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        return lid;
    }
}
