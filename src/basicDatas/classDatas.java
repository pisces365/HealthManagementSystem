package basicDatas;

import java.io.Serializable;

public class classDatas implements Serializable {
    private String classNum;
    private String className;
    private String classLeader;
    private String majorNum;
    private String majorBelonging;
    private String collegeNum;
    private String collegeBelonging;

    public classDatas(){}

    public classDatas(String classNum, String className, String classLeader, String majorNum, String majorBelonging, String collegeNum, String collegeBelonging) {
        this.classNum = classNum;
        this.className = className;
        this.classLeader = classLeader;
        this.majorNum = majorNum;
        this.majorBelonging = majorBelonging;
        this.collegeNum = collegeNum;
        this.collegeBelonging = collegeBelonging;
    }

    public String getMajorNum() {
        return majorNum;
    }

    public void setMajorNum(String majorNum) {
        this.majorNum = majorNum;
    }

    public String getCollegeNum() {
        return collegeNum;
    }

    public void setCollegeNum(String collegeNum) {
        this.collegeNum = collegeNum;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassLeader() {
        return classLeader;
    }

    public void setClassLeader(String classLeader) {
        this.classLeader = classLeader;
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
}
