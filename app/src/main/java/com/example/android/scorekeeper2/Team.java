package com.example.android.scorekeeper2;

/**
 * Created by Alessandro Mana on 25/03/2017.
 */

public class Team {

    private int scoreTeam;
//    private int scoreIn1;
//    private int scoreIn2;
//    private int scoreIn3;
//    private int scoreIn4;
//    private int scoreIn5;
//    private int scoreIn6;
//    private int scoreIn7;
//    private int scoreIn8;
//    private int scoreIn9;
    private int outTeam;
    private boolean active;

    private int[] inningScore;

    public Team(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



    public Team() {
        scoreTeam = 0;
//        scoreIn1 = 0;
//        scoreIn2 = 0;
//        scoreIn3 = 0;
//        scoreIn4 = 0;
//        scoreIn5 = 0;
//        scoreIn6 = 0;
//        scoreIn7 = 0;
//        scoreIn8 = 0;
//        scoreIn9 = 0;
        outTeam = 0;

        inningScore = new int[9];
    }

    public void setInningScore(int index, int score){
        inningScore[index] = score;
    }

    public int getInningScore(int index)    {
        return inningScore[index];

    }

    public int getScoreTeam() {
        return scoreTeam;
    }

    public void setScoreTeam(int scoreTeam) {
        this.scoreTeam = scoreTeam;
    }

//    public int getScoreIn1() {
//        return scoreIn1;
//    }

//    public void setScoreIn1(int scoreIn1) {
//        this.scoreIn1 = scoreIn1;
//    }

//    public int getScoreIn2() {
//        return scoreIn2;
//    }

//    public void setScoreIn2(int scoreIn2) {
//        this.scoreIn2 = scoreIn2;
//    }

//    public int getScoreIn3() {
//        return scoreIn3;
//    }

//    public void setScoreIn3(int scoreIn3) {
//        this.scoreIn3 = scoreIn3;
//    }

//    public int getScoreIn4() {
//        return scoreIn4;
//    }

//    public void setScoreIn4(int scoreIn4) {
//        this.scoreIn4 = scoreIn4;
//    }

//    public int getScoreIn5() {
//        return scoreIn5;
//    }

//    public void setScoreIn5(int scoreIn5) {
//        this.scoreIn5 = scoreIn5;
//    }

//    public int getScoreIn6() {
//        return scoreIn6;
//    }

//    public void setScoreIn6(int scoreIn6) {
//        this.scoreIn6 = scoreIn6;
//    }

//    public int getScoreIn7() {
//        return scoreIn7;
//    }

//    public void setScoreIn7(int scoreIn7) {
//        this.scoreIn7 = scoreIn7;
//    }

//    public int getScoreIn8() {
//        return scoreIn8;
//    }

//    public void setScoreIn8(int scoreIn8) {
//        this.scoreIn8 = scoreIn8;
//    }

//    public int getScoreIn9() {
//        return scoreIn9;
//    }

//    public void setScoreIn9(int scoreIn9) {
//        this.scoreIn9 = scoreIn9;
//    }

    public int getOutTeam() {
        return outTeam;
    }

    public void setOutTeam(int outTeam) {
        this.outTeam = outTeam;
    }




}
