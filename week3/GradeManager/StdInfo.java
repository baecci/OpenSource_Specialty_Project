package GradeManager;

public class StdInfo{
    private int stdId = 0;
    private String stdName = "";
    SubInfo subInfo = new SubInfo();

    public void setStdId(int id) {
        this.stdId = id;
    }

    public void setStdName(String name) {
        this.stdName = name;
    }

    public int getStdNum() {
        return stdId;
    }

    public String getStdName() {
        return stdName;
    }

    StdInfo(){}
}
