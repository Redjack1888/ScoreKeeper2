package com.example.android.scorekeeper2;

import android.widget.TextView;

class Team {

    private int scoreTeam;
    private int outTeam;

    private int[] inningScore;
    TextView[] inningScoreView;

    Team() {
        scoreTeam = 0;
        outTeam = 0;

        inningScore = new int[9];
        inningScoreView = new TextView[9];
    }

    void setInningScoreView(int index, TextView textViews) {
       this.inningScoreView[index] = textViews;
    }
    TextView getInningScoreView(int index){
        return this.inningScoreView[index];

    }


    void setInningScore(int index, int score) {
        inningScore[index] = score;
    }

    int getInningScore(int index) {
        return inningScore[index];

    }

    int getScoreTeam() {
        return scoreTeam;
    }

    void setScoreTeam(int scoreTeam) {
        this.scoreTeam = scoreTeam;
    }

    int getOutTeam() {
        return outTeam;
    }

    void setOutTeam(int outTeam) {
        this.outTeam = outTeam;
    }

}
