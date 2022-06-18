package basicDatas;

import java.io.Serializable;

public class studentsDatas implements Serializable {
    private String stuNum;
    private String stuName;
    private String stuID;
    private String classNum;
    private String classBelonging;
    private String majorBelonging;
    private String collegeBelonging;
    private String stuPassword;

    public studentsDatas(){}
    public studentsDatas(String stuNum,String stuName,String stuID,String classNum,String classBelonging,
                            String majorBelonging,String collegeBelonging,String stuPassword)
    {
        this.classBelonging = classBelonging;
        this.collegeBelonging = collegeBelonging;
        this.stuID = stuID;
        this.stuName = stuName;
        this.majorBelonging = majorBelonging;
        this.stuPassword = stuPassword;
        this.stuNum = stuNum;
        this.classNum = classNum;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getClassBelonging() {
        return classBelonging;
    }

    public void setClassBelonging(String classBelonging) {
        this.classBelonging = classBelonging;
    }

    public String getMajorBelonging() {
        return majorBelonging;
    }

    public void setMajorBelonging(String majorBelonging) {
        this.majorBelonging = majorBelonging;
    }

    public String getCollegeBelonging() {
        return collegeBelonging;
    }

    public void setCollegeBelonging(String collegeBelonging) {
        this.collegeBelonging = collegeBelonging;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }
}
