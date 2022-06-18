package basicDatas;

import java.io.Serializable;

public class teachersDatas implements Serializable {
    private String teacherNum;
    private String teacherName;
    private String teacherID;
    private String role;
    private String collegeNum;
    private String collegeBelonging;
    private String teacherPassword;

    public teachersDatas() {
    }

    public teachersDatas(String teacherNum, String teacherName, String teacherID, String role, String collegeNum, String collegeBelonging, String teacherPassword) {
        this.teacherNum = teacherNum;
        this.teacherName = teacherName;
        this.teacherID = teacherID;
        this.role = role;
        this.collegeNum = collegeNum;
        this.collegeBelonging = collegeBelonging;
        this.teacherPassword = teacherPassword;
    }

    public String getCollegeNum() {
        return collegeNum;
    }

    public void setCollegeNum(String collegeNum) {
        this.collegeNum = collegeNum;
    }

    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCollegeBelonging() {
        return collegeBelonging;
    }

    public void setCollegeBelonging(String collegeBelonging) {
        this.collegeBelonging = collegeBelonging;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }
}
