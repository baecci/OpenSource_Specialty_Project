package GradeManager;

public class SubInfo {
    private int KorScore = 0;
    private int EngScore = 0;
    private int MathScore = 0;
    private int JavaScore = 0;
    private double sum = 0.0;
    private double avg = 0.0;

    public void setKorScore(int kor) {
        this.KorScore = kor;
    }

    public void setEngScore(int eng) {
        this.EngScore = eng;
    }

    public void setMathScore(int math) {
        this.MathScore = math;
    }

    public void setJavaScore(int java) {
        this.JavaScore = java;
    }

    public int getKorScore() {
        return KorScore;
    }

    public int getEngScore() {
        return EngScore;
    }

    public int getMathScore() {
        return MathScore;
    }

    public int getJavaScore() {
        return JavaScore;
    }

    public double CalcSum(){
        sum = KorScore + EngScore + MathScore + JavaScore;
        return sum;
    }
    public double CalcAvg(){
        avg = sum / 4.0;
        return avg;
    }
    public String CalcGrade(){
        int temp = (int) avg / 10;
        String grade = "";
        if (temp == 10 || temp == 9) {
            grade = "A";
        } else if (temp == 8) {
            grade = "B";
        } else if (temp == 7) {
            grade = "C";
        } else if (temp == 6) {
            grade = "D";
        } else
            grade = "F";
        return grade;
    }
}
