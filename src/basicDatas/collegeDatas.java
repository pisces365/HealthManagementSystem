package basicDatas;

import java.io.Serializable;

public class collegeDatas implements Serializable {
    private String collegeNum;
    private String CollegeName;
    private String CollegeLeader;

    public collegeDatas(){};

    public collegeDatas(String collegeNum, String collegeName, String collegeLeader) {
        this.collegeNum = collegeNum;
        this.CollegeName = collegeName;
        this.CollegeLeader = collegeLeader;
    }

    public String getCollegeNum() {
        return collegeNum;
    }

    public void setCollegeNum(String collegeNum) {
        this.collegeNum = collegeNum;
    }

    public String getCollegeName() {
        return CollegeName;
    }

    public void setCollegeName(String collegeName) {
        CollegeName = collegeName;
    }

    public String getCollegeLeader() {
        return CollegeLeader;
    }

    public void setCollegeLeader(String collegeLeader) {
        CollegeLeader = collegeLeader;
    }

}
