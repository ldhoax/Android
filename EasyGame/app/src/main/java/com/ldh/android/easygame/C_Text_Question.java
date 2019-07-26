package com.ldh.android.easygame;

public class C_Text_Question {
    private String Question;
    private String Ans_A;
    private String Ans_B;
    private String Ans_C;
    private String Ans_D;
    private int True_Ans;
    public C_Text_Question(String question, String ans_A, String ans_B, String ans_C, String ans_D, int true_Ans) {
        Question = question;
        Ans_A = ans_A;
        Ans_B = ans_B;
        Ans_C = ans_C;
        Ans_D = ans_D;
        True_Ans = true_Ans;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAns_A() {
        return Ans_A;
    }

    public void setAns_A(String ans_A) {
        Ans_A = ans_A;
    }

    public String getAns_B() {
        return Ans_B;
    }

    public void setAns_B(String ans_B) {
        Ans_B = ans_B;
    }

    public String getAns_C() {
        return Ans_C;
    }

    public void setAns_C(String ans_C) {
        Ans_C = ans_C;
    }

    public String getAns_D() {
        return Ans_D;
    }

    public void setAns_D(String ans_D) {
        Ans_D = ans_D;
    }

    public int getTrue_Ans() {
        return True_Ans;
    }

    public void setTrue_Ans(int true_Ans) {
        True_Ans = true_Ans;
    }
}
