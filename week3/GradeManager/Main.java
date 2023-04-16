package GradeManager;

import java.util.Scanner;

public class Main{
    int stdnum;
    Scanner sc = new Scanner(System.in);
    public Main(){
        System.out.print("학생 수를 입력하세요: ");
        stdnum = sc.nextInt();
        StdInfo[] stdinfo = new StdInfo[stdnum];

        for(int i=0; i<stdinfo.length; i++){
            stdinfo[i] = new StdInfo();
            System.out.println("=============================");
            System.out.print((i+1) + "번 학생의 학번을 입력하세요: ");
            stdinfo[i].setStdId(sc.nextInt());
            sc.nextLine();  //scanner 버퍼를 비워주기 위함
            System.out.print((i+1) + "번 학생의 이름을 입력하세요: ");
            stdinfo[i].setStdName(sc.nextLine());
            System.out.print((i+1) + "번 학생의 국어성적(0~100점)을 입력하세요: ");
            stdinfo[i].subInfo.setKorScore(sc.nextInt());
            System.out.print((i+1) + "번 학생의 영어성적(0~100점)을 입력하세요: ");
            stdinfo[i].subInfo.setEngScore(sc.nextInt());
            System.out.print((i+1) + "번 학생의 수학성적(0~100점)을 입력하세요: ");
            stdinfo[i].subInfo.setMathScore(sc.nextInt());
            System.out.print((i+1) + "번 학생의 자바성적(0~100점)을 입력하세요: ");
            stdinfo[i].subInfo.setJavaScore(sc.nextInt());
        }
        for(int i=0; i<stdnum; i++){
            System.out.println("=============================");
            System.out.println((i+1) + "번 학생의 학번: " + stdinfo[i].getStdNum());
            System.out.println((i+1) + "번 학생의 이름: " + stdinfo[i].getStdName());
            System.out.println((i+1) + "번 학생의 국어성적: " + stdinfo[i].subInfo.getKorScore());
            System.out.println((i+1) + "번 학생의 영어성적: " + stdinfo[i].subInfo.getEngScore());
            System.out.println((i+1) + "번 학생의 수학성적: " + stdinfo[i].subInfo.getMathScore());
            System.out.println((i+1) + "번 학생의 자바성적: " + stdinfo[i].subInfo.getJavaScore());
            System.out.println((i+1) + "번 학생의 총점: " + stdinfo[i].subInfo.CalcSum());
            System.out.println((i+1) + "번 학생의 평균: " + stdinfo[i].subInfo.CalcAvg());
            System.out.println((i+1) + "번 학생의 학점: " + stdinfo[i].subInfo.CalcGrade());
            System.out.println("=============================");
        }
    }
    public static void main(String[] args) {
        new Main();
    }
}
