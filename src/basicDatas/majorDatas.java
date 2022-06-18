package basicDatas;

import java.io.Serializable;

public class majorDatas implements Serializable {
    private String majorNum;
    private String majorName;
    private String majorLeader;
    private String collegeNum;
    private String collegeBelonging;

    public majorDatas(){}

    public majorDatas(String majorNum, String majorName, String majorLeader, String collegeNum, String collegeBelonging) {
        this.majorNum = majorNum;
        this.majorName = majorName;
        this.majorLeader = majorLeader;
        this.collegeNum = collegeNum;
        this.collegeBelonging = collegeBelonging;
    }

    public String getCollegeNum() {
        return collegeNum;
    }

    public void setCollegeNum(String collegeNum) {
        this.collegeNum = collegeNum;
    }

    public String getMajorNum() {
        return majorNum;
    }

    public void setMajorNum(String majorNum) {
        this.majorNum = majorNum;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorLeader() {
        return majorLeader;
    }

    public void setMajorLeader(String majorLeader) {
        this.majorLeader = majorLeader;
    }

    public String getCollegeBelonging() {
        return collegeBelonging;
    }

    public void setCollegeBelonging(String collegeBelonging) {
        this.collegeBelonging = collegeBelonging;
    }
}
