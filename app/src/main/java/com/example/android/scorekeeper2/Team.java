package com.example.android.scorekeeper2;

class Team {

    private int scoreTeam;
    private int outTeam;

    private int[] inningScore;

    Team() {
        scoreTeam = 0;
        outTeam = 0;

        inningScore = new int[9];
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
