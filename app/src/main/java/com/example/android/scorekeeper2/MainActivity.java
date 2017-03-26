package com.example.android.scorekeeper2;

import android.content.pm.ActivityInfo;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {
    int strikes = 0;
    int foulball = 0;

//    // Tracks the score for Team A
//    int scoreTeamA = 0;
//    int scoreTeamA_In1 = 0;
//    int scoreTeamA_In2 = 0;
//    int scoreTeamA_In3 = 0;
//    int scoreTeamA_In4 = 0;
//    int scoreTeamA_In5 = 0;
//    int scoreTeamA_In6 = 0;
//    int scoreTeamA_In7 = 0;
//    int scoreTeamA_In8 = 0;
//    int scoreTeamA_In9 = 0;
//    int outTeamA = 0;
//    // Tracks the score for Team B
//    int scoreTeamB = B.getScoreTeam();
//    int scoreTeamB_In1 = 0;
//    int scoreTeamB_In2 = 0;
//    int scoreTeamB_In3 = 0;
//    int scoreTeamB_In4 = 0;
//    int scoreTeamB_In5 = 0;
//    int scoreTeamB_In6 = 0;
//    int scoreTeamB_In7 = 0;
//    int scoreTeamB_In8 = 0;
//    int scoreTeamB_In9 = 0;
//    int outTeamB = 0;
    int balls = 0;
    int out = 0;
    int freeRunner = 0;
    int runner = 0;
    SoundPool mySound;
    int batterhitId;
    int hbpId;
    int homerunId;
    int youreoutId;
    int strikeId;
    int ballId;
    int erroralertId;
    private Team A = new Team();
    private Team B = new Team();
    private ToggleButton turnSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        turnSwitch = (ToggleButton) findViewById(R.id.turnSwitch);
        //set the switch to Team A
        turnSwitch.setChecked(false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            mySound = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .build();

            batterhitId = mySound.load(this, R.raw.batterhit, 1);
            hbpId = mySound.load(this, R.raw.hitbypitch, 1);
            homerunId = mySound.load(this, R.raw.homerun, 1);
            youreoutId = mySound.load(this, R.raw.youreout, 1);
            strikeId = mySound.load(this, R.raw.strike, 1);
            ballId = mySound.load(this, R.raw.ball, 1);
            erroralertId = mySound.load(this, R.raw.erroralert, 1);
        } else {
            batterhitId = mySound.load(this, R.raw.batterhit, 1);
            hbpId = mySound.load(this, R.raw.hitbypitch, 1);
            homerunId = mySound.load(this, R.raw.homerun, 1);
            youreoutId = mySound.load(this, R.raw.youreout, 1);
            strikeId = mySound.load(this, R.raw.strike, 1);
            ballId = mySound.load(this, R.raw.ball, 1);
            erroralertId = mySound.load(this, R.raw.erroralert, 1);
        }
    }


    /**
     * Increase the score for the right Team.
     */
    public void addOneToScore(View v) {

        //check the current state before display on the screen
        if (turnSwitch.isChecked()) {
            B.setScoreTeam(B.getScoreTeam() + 1);
            displayForTeamB(B.getScoreTeam());
            if (B.getOutTeam() < 3) {
                B.setScoreIn1(B.getScoreTeam());
                displayForTeamB_In1(B.getScoreIn1());
            }
            if ((B.getOutTeam() >= 3) && (B.getOutTeam() < 6)) {
                B.setScoreIn2(B.getScoreTeam() - B.getScoreIn1());
                displayForTeamB_In2(B.getScoreIn2());
            }
            if ((B.getOutTeam() >= 6) && (B.getOutTeam() < 9)) {
                B.setScoreIn3(B.getScoreTeam() - B.getScoreIn1() - B.getScoreIn2());
                displayForTeamB_In3(B.getScoreIn3());
            }
            if ((B.getOutTeam() >= 9) && (B.getOutTeam() < 12)) {
                B.setScoreIn4(B.getScoreTeam() - B.getScoreIn1() - B.getScoreIn2() - B.getScoreIn3());
                displayForTeamB_In4(B.getScoreIn4());
            }
            if ((B.getOutTeam() >= 12) && (B.getOutTeam() < 15)) {
                B.setScoreIn5(B.getScoreTeam() - B.getScoreIn1() - B.getScoreIn2() - B.getScoreIn3() - B.getScoreIn4());
                displayForTeamB_In5(B.getScoreIn5());
            }
            if ((B.getOutTeam() >= 15) && (B.getOutTeam() < 18)) {
                B.setScoreIn6(B.getScoreTeam() - B.getScoreIn1() - B.getScoreIn2() - B.getScoreIn3() - B.getScoreIn4() - B.getScoreIn5());
                displayForTeamB_In6(B.getScoreIn6());
            }
            if ((B.getOutTeam() >= 18) && (B.getOutTeam() < 21)) {
                B.setScoreIn7(B.getScoreTeam() - B.getScoreIn1() - B.getScoreIn2() - B.getScoreIn3() - B.getScoreIn4() - B.getScoreIn5() - B.getScoreIn6());
                displayForTeamB_In7(B.getScoreIn7());
            }
            if ((B.getOutTeam() >= 21) && (B.getOutTeam() < 24)) {
                B.setScoreIn8(B.getScoreTeam() - B.getScoreIn1() - B.getScoreIn2() - B.getScoreIn3() - B.getScoreIn4() - B.getScoreIn5() - B.getScoreIn6() - B.getScoreIn7());
                displayForTeamB_In8(B.getScoreIn8());
            }
            if ((B.getOutTeam() >= 24) && (B.getOutTeam() < 27)) {
                B.setScoreIn9(B.getScoreTeam() - B.getScoreIn1() - B.getScoreIn2() - B.getScoreIn3() - B.getScoreIn4() - B.getScoreIn5() - B.getScoreIn6() - B.getScoreIn8());
                displayForTeamB_In9(B.getScoreIn9());
            }

        } else {
            A.setScoreTeam(A.getScoreTeam() + 1);
            displayForTeamA(A.getScoreTeam());
            if (A.getOutTeam() < 3) {
                A.setScoreIn1(A.getScoreTeam());
                displayForTeamA_In1(A.getScoreIn1());
            }
            if ((A.getOutTeam() >= 3) && (A.getOutTeam() < 6)) {
                A.setScoreIn2(A.getScoreTeam() - A.getScoreIn1());
                displayForTeamA_In2(A.getScoreIn2());
            }
            if ((A.getOutTeam() >= 6) && (A.getOutTeam() < 9)) {
                A.setScoreIn3(A.getScoreTeam() - A.getScoreIn1() - A.getScoreIn2());
                displayForTeamA_In3(A.getScoreIn3());
            }
            if ((A.getOutTeam() >= 9) && (A.getOutTeam() < 12)) {
                A.setScoreIn4(A.getScoreTeam() - A.getScoreIn1() - A.getScoreIn2() - A.getScoreIn3());
                displayForTeamA_In4(A.getScoreIn4());
            }
            if ((A.getOutTeam() >= 12) && (A.getOutTeam() < 15)) {
                A.setScoreIn5(A.getScoreTeam() - A.getScoreIn1() - A.getScoreIn2() - A.getScoreIn3() - A.getScoreIn4());
                displayForTeamA_In5(A.getScoreIn5());
            }
            if ((A.getOutTeam() >= 15) && (A.getOutTeam() < 18)) {
                A.setScoreIn6(A.getScoreTeam() - A.getScoreIn1() - A.getScoreIn2() - A.getScoreIn3() - A.getScoreIn4() - A.getScoreIn5());
                displayForTeamA_In6(A.getScoreIn6());
            }
            if ((A.getOutTeam() >= 18) && (A.getOutTeam() < 21)) {
                A.setScoreIn7(A.getScoreTeam() - A.getScoreIn1() - A.getScoreIn2() - A.getScoreIn3() - A.getScoreIn4() - A.getScoreIn5() - A.getScoreIn6());
                displayForTeamA_In7(A.getScoreIn7());
            }
            if ((A.getOutTeam() >= 21) && (A.getOutTeam() < 24)) {
                A.setScoreIn8(A.getScoreTeam() - A.getScoreIn1() - A.getScoreIn2() - A.getScoreIn3() - A.getScoreIn4() - A.getScoreIn5() - A.getScoreIn6() - A.getScoreIn7());
                displayForTeamA_In8(A.getScoreIn8());
            }
            if ((A.getOutTeam() >= 24) && (A.getOutTeam() < 27)) {
                A.setScoreIn9(A.getScoreTeam() - A.getScoreIn1() - A.getScoreIn2() - A.getScoreIn3() - A.getScoreIn4() - A.getScoreIn5() - A.getScoreIn6() - A.getScoreIn7() - A.getScoreIn8());
                displayForTeamA_In9(A.getScoreIn9());
            }
        }
        if (runner <= 0) {
            runner = 0;
            displayRunners(runner);
        } else {
            runner = runner - 1;
            displayRunners(runner);
        }
        if (runner == 4) {
            runner = runner - 1;
            displayRunners(runner);
        }
    }

    /**
     * Decrease the score for the right Team.
     */
    public void delOneToScore(View v) {
        if (turnSwitch.isChecked()) {
            B.setScoreTeam(B.getScoreTeam() - 1);
            displayForTeamB(B.getScoreTeam());
            if (B.getScoreTeam() <= 0) {
                //Show an error message as Toast
                mySound.play(erroralertId, 1, 1, 1, 0, 1);
                Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                //exit this method early
                B.setScoreTeam(0);
                displayForTeamB(B.getScoreTeam());

            }


            if (B.getOutTeam() < 3) {
                B.setScoreIn1(B.getScoreTeam());
                displayForTeamB_In1(B.getScoreIn1());
                if (B.getScoreIn1() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setScoreIn1(0);
                    displayForTeamB_In1(B.getScoreIn1());

                }

            }
            if ((B.getOutTeam() >= 3) && (B.getOutTeam() < 6)) {
                B.setScoreIn2(B.getScoreTeam() - B.getScoreIn1());
                displayForTeamB_In2(B.getScoreIn2());
                if (B.getScoreIn2() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setScoreIn1(B.getScoreTeam());
                    B.setScoreIn2(0);
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getScoreIn1());
                    displayForTeamB_In2(B.getScoreIn1());

                }
            }
            if ((B.getOutTeam() >= 6) && (B.getOutTeam() < 9)) {
                B.setScoreIn3(B.getScoreTeam() - B.getScoreIn1() - B.getScoreIn2());
                displayForTeamB_In3(B.getScoreIn3());
                if (B.getScoreIn3() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setScoreIn3(0);
                    displayForTeamB_In3(B.getScoreIn3());
                    B.setScoreTeam(B.getScoreIn1() + B.getScoreIn1());
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getScoreIn1());
                    displayForTeamB_In2(B.getScoreIn2());
                }
            }
            if ((B.getOutTeam() >= 9) && (B.getOutTeam() < 12)) {
                B.setScoreIn4(B.getScoreTeam() - B.getScoreIn1() - B.getScoreIn2() - B.getScoreIn3());
                displayForTeamB_In4(B.getScoreIn4());
                if (B.getScoreIn4() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setScoreIn4(0);
                    displayForTeamB_In4(B.getScoreIn4());
                    B.setScoreTeam(B.getScoreIn1() + B.getScoreIn2() + B.getScoreIn3());
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getScoreIn1());
                    displayForTeamB_In2(B.getScoreIn2());
                    displayForTeamB_In3(B.getScoreIn3());
                }
            }
            if ((B.getOutTeam() >= 12) && (B.getOutTeam() < 15)) {
                B.setScoreIn5(B.getScoreTeam() - B.getScoreIn1() - B.getScoreIn2() - B.getScoreIn3() - B.getScoreIn4());
                displayForTeamB_In5(B.getScoreIn5());
                if (B.getScoreIn5() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setScoreIn5(0);
                    displayForTeamB_In5(B.getScoreIn5());
                    B.setScoreTeam(B.getScoreIn1() + B.getScoreIn2() + B.getScoreIn3() + B.getScoreIn4());
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getScoreIn1());
                    displayForTeamB_In2(B.getScoreIn2());
                    displayForTeamB_In3(B.getScoreIn3());
                    displayForTeamB_In4(B.getScoreIn4());

                }
            }
            if ((B.getOutTeam() >= 15) && (B.getOutTeam() < 18)) {
                B.setScoreIn6(B.getScoreTeam() - B.getScoreIn1() - B.getScoreIn2() - B.getScoreIn3() - B.getScoreIn4() - B.getScoreIn5());
                displayForTeamB_In6(B.getScoreIn6());
                if (B.getScoreIn6() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setScoreIn6(0);
                    displayForTeamB_In6(B.getScoreIn6());
                    B.setScoreTeam(B.getScoreIn1() + B.getScoreIn2() + B.getScoreIn3() + B.getScoreIn4() + B.getScoreIn5());
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getScoreIn1());
                    displayForTeamB_In2(B.getScoreIn2());
                    displayForTeamB_In3(B.getScoreIn3());
                    displayForTeamB_In4(B.getScoreIn4());
                    displayForTeamB_In5(B.getScoreIn5());
                }
            }
            if ((B.getOutTeam() >= 18) && (B.getOutTeam() < 21)) {
                B.setScoreIn7(B.getScoreTeam() - B.getScoreIn1() - B.getScoreIn2() - B.getScoreIn3() - B.getScoreIn4() - B.getScoreIn5() - B.getScoreIn6());
                displayForTeamB_In7(B.getScoreIn7());
                if (B.getScoreIn7() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setScoreIn7(0);
                    displayForTeamB_In7(B.getScoreIn7());
                    B.setScoreTeam(B.getScoreIn1() + B.getScoreIn2() + B.getScoreIn3() + B.getScoreIn4() + B.getScoreIn5() + B.getScoreIn6());
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getScoreIn1());
                    displayForTeamB_In2(B.getScoreIn2());
                    displayForTeamB_In3(B.getScoreIn3());
                    displayForTeamB_In4(B.getScoreIn4());
                    displayForTeamB_In5(B.getScoreIn5());
                    displayForTeamB_In6(B.getScoreIn6());

                }
            }
            if ((B.getOutTeam() >= 21) && (B.getOutTeam() < 24)) {
                B.setScoreIn8(B.getScoreTeam() - B.getScoreIn1() - B.getScoreIn2() - B.getScoreIn3() - B.getScoreIn4() - B.getScoreIn5() - B.getScoreIn6() - B.getScoreIn7());
                displayForTeamB_In8(B.getScoreIn8());
                if (B.getScoreIn8() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setScoreIn8(0);
                    displayForTeamB_In8(B.getScoreIn8());
                    B.setScoreTeam(B.getScoreIn1() + B.getScoreIn2() + B.getScoreIn3() + B.getScoreIn4() + B.getScoreIn5() + B.getScoreIn6() + B.getScoreIn7());
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getScoreIn1());
                    displayForTeamB_In2(B.getScoreIn2());
                    displayForTeamB_In3(B.getScoreIn3());
                    displayForTeamB_In4(B.getScoreIn4());
                    displayForTeamB_In5(B.getScoreIn5());
                    displayForTeamB_In6(B.getScoreIn6());
                    displayForTeamB_In7(B.getScoreIn7());

                }
            }
            if ((B.getOutTeam() >= 24) && (B.getOutTeam() < 27)) {
                B.setScoreIn9(B.getScoreTeam() - B.getScoreIn1() - B.getScoreIn2() - B.getScoreIn3() - B.getScoreIn4() - B.getScoreIn5() - B.getScoreIn6() - B.getScoreIn8());
                if (B.getScoreIn9() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setScoreIn9(0);
                    displayForTeamB_In9(B.getScoreIn9());
                    B.setScoreTeam(B.getScoreIn1() + B.getScoreIn2() + B.getScoreIn3() + B.getScoreIn4() + B.getScoreIn5() + B.getScoreIn6() + B.getScoreIn7() + B.getScoreIn8());
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getScoreIn1());
                    displayForTeamB_In2(B.getScoreIn2());
                    displayForTeamB_In3(B.getScoreIn3());
                    displayForTeamB_In4(B.getScoreIn4());
                    displayForTeamB_In5(B.getScoreIn5());
                    displayForTeamB_In6(B.getScoreIn6());
                    displayForTeamB_In7(B.getScoreIn7());
                    displayForTeamB_In8(B.getScoreIn8());
                }
            }

        } else {
            A.setScoreTeam(A.getScoreTeam() - 1);
            displayForTeamA(A.getScoreTeam());
            if (A.getScoreTeam() <= 0) {
                //Show an error message as Toast
                mySound.play(erroralertId, 1, 1, 1, 0, 1);
                Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                //exit this method early
                A.setScoreTeam(0);
                displayForTeamA(A.getScoreTeam());

            }


            if (A.getOutTeam() < 3) {
                A.setScoreIn1(A.getScoreTeam());
                displayForTeamA_In1(A.getScoreIn1());
                if (A.getScoreIn1() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setScoreIn1(0);
                    displayForTeamA_In1(A.getScoreIn1());

                }

            }
            if ((A.getOutTeam() >= 3) && (A.getOutTeam() < 6)) {
                A.setScoreIn2(A.getScoreTeam() - A.getScoreIn1());
                displayForTeamA_In2(A.getScoreIn2());
                if (A.getScoreIn2() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setScoreIn1(A.getScoreTeam());
                    A.setScoreIn2(0);
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getScoreIn1());
                    displayForTeamA_In2(A.getScoreIn1());

                }
            }
            if ((A.getOutTeam() >= 6) && (A.getOutTeam() < 9)) {
                A.setScoreIn3(A.getScoreTeam() - A.getScoreIn1() - A.getScoreIn2());
                displayForTeamA_In3(A.getScoreIn3());
                if (A.getScoreIn3() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setScoreIn3(0);
                    displayForTeamA_In3(A.getScoreIn3());
                    A.setScoreTeam(A.getScoreIn1() + A.getScoreIn1());
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getScoreIn1());
                    displayForTeamA_In2(A.getScoreIn2());
                }
            }
            if ((A.getOutTeam() >= 9) && (A.getOutTeam() < 12)) {
                A.setScoreIn4(A.getScoreTeam() - A.getScoreIn1() - A.getScoreIn2() - A.getScoreIn3());
                displayForTeamA_In4(A.getScoreIn4());
                if (A.getScoreIn4() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setScoreIn4(0);
                    displayForTeamA_In4(A.getScoreIn4());
                    A.setScoreTeam(A.getScoreIn1() + A.getScoreIn2() + A.getScoreIn3());
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getScoreIn1());
                    displayForTeamA_In2(A.getScoreIn2());
                    displayForTeamA_In3(A.getScoreIn3());
                }
            }
            if ((A.getOutTeam() >= 12) && (A.getOutTeam() < 15)) {
                A.setScoreIn5(A.getScoreTeam() - A.getScoreIn1() - A.getScoreIn2() - A.getScoreIn3() - A.getScoreIn4());
                displayForTeamA_In5(A.getScoreIn5());
                if (A.getScoreIn5() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setScoreIn5(0);
                    displayForTeamA_In5(A.getScoreIn5());
                    A.setScoreTeam(A.getScoreIn1() + A.getScoreIn2() + A.getScoreIn3() + A.getScoreIn4());
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getScoreIn1());
                    displayForTeamA_In2(A.getScoreIn2());
                    displayForTeamA_In3(A.getScoreIn3());
                    displayForTeamA_In4(A.getScoreIn4());

                }
            }
            if ((A.getOutTeam() >= 15) && (A.getOutTeam() < 18)) {
                A.setScoreIn6(A.getScoreTeam() - A.getScoreIn1() - A.getScoreIn2() - A.getScoreIn3() - A.getScoreIn4() - A.getScoreIn5());
                displayForTeamA_In6(A.getScoreIn6());
                if (A.getScoreIn6() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setScoreIn6(0);
                    displayForTeamA_In6(A.getScoreIn6());
                    A.setScoreTeam(A.getScoreIn1() + A.getScoreIn2() + A.getScoreIn3() + A.getScoreIn4() + A.getScoreIn5());
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getScoreIn1());
                    displayForTeamA_In2(A.getScoreIn2());
                    displayForTeamA_In3(A.getScoreIn3());
                    displayForTeamA_In4(A.getScoreIn4());
                    displayForTeamA_In5(A.getScoreIn5());
                }
            }
            if ((A.getOutTeam() >= 18) && (A.getOutTeam() < 21)) {
                A.setScoreIn7(A.getScoreTeam() - A.getScoreIn1() - A.getScoreIn2() - A.getScoreIn3() - A.getScoreIn4() - A.getScoreIn5() - A.getScoreIn6());
                displayForTeamA_In7(A.getScoreIn7());
                if (A.getScoreIn7() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setScoreIn7(0);
                    displayForTeamA_In7(A.getScoreIn7());
                    A.setScoreTeam(A.getScoreIn1() + A.getScoreIn2() + A.getScoreIn3() + A.getScoreIn4() + A.getScoreIn5() + A.getScoreIn6());
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getScoreIn1());
                    displayForTeamA_In2(A.getScoreIn2());
                    displayForTeamA_In3(A.getScoreIn3());
                    displayForTeamA_In4(A.getScoreIn4());
                    displayForTeamA_In5(A.getScoreIn5());
                    displayForTeamA_In6(A.getScoreIn6());

                }
            }
            if ((A.getOutTeam() >= 21) && (A.getOutTeam() < 24)) {
                A.setScoreIn8(A.getScoreTeam() - A.getScoreIn1() - A.getScoreIn2() - A.getScoreIn3() - A.getScoreIn4() - A.getScoreIn5() - A.getScoreIn6() - A.getScoreIn7());
                displayForTeamA_In8(A.getScoreIn8());
                if (A.getScoreIn8() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setScoreIn8(0);
                    displayForTeamA_In8(A.getScoreIn8());
                    A.setScoreTeam(A.getScoreIn1() + A.getScoreIn2() + A.getScoreIn3() + A.getScoreIn4() + A.getScoreIn5() + A.getScoreIn6() + A.getScoreIn7());
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getScoreIn1());
                    displayForTeamA_In2(A.getScoreIn2());
                    displayForTeamA_In3(A.getScoreIn3());
                    displayForTeamA_In4(A.getScoreIn4());
                    displayForTeamA_In5(A.getScoreIn5());
                    displayForTeamA_In6(A.getScoreIn6());
                    displayForTeamA_In7(A.getScoreIn7());

                }
            }
            if ((A.getOutTeam() >= 24) && (A.getOutTeam() < 27)) {
                A.setScoreIn9(A.getScoreTeam() - A.getScoreIn1() - A.getScoreIn2() - A.getScoreIn3() - A.getScoreIn4() - A.getScoreIn5() - A.getScoreIn6() - A.getScoreIn8());
                displayForTeamA_In9(A.getScoreIn9());
                if (A.getScoreIn9() <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "You cannot have less than 0 as Score", Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setScoreIn9(0);
                    displayForTeamA_In9(A.getScoreIn9());
                    A.setScoreTeam(A.getScoreIn1() + A.getScoreIn2() + A.getScoreIn3() + A.getScoreIn4() + A.getScoreIn5() + A.getScoreIn6() + A.getScoreIn7() + A.getScoreIn8());
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getScoreIn1());
                    displayForTeamA_In2(A.getScoreIn2());
                    displayForTeamA_In3(A.getScoreIn3());
                    displayForTeamA_In4(A.getScoreIn4());
                    displayForTeamA_In5(A.getScoreIn5());
                    displayForTeamA_In6(A.getScoreIn6());
                    displayForTeamA_In7(A.getScoreIn7());
                    displayForTeamA_In8(A.getScoreIn8());
                }
            }
        }
    }


    /**
     * Increase the score for homeruns to right Team.
     */
    public void homerun(View v) {
        mySound.play(batterhitId, 1, 1, 1, 0, 1);
        mySound.play(homerunId, 1, 1, 1, 0, 1);

        //check the current state before we display the screen
        if (turnSwitch.isChecked()) {
            B.setScoreTeam(B.getScoreTeam() + runner + 1);
            displayForTeamB(B.getScoreTeam());
            if (B.getOutTeam() < 3) {
                B.setScoreIn1(B.getScoreIn1() + runner + 1);
                displayForTeamB_In1(B.getScoreIn1());
            }
            if ((B.getOutTeam() >= 3) && (B.getOutTeam() < 6)) {
                B.setScoreIn2(B.getScoreIn2() + runner + 1);
                displayForTeamB_In2(B.getScoreIn2());
            }
            if ((B.getOutTeam() >= 6) && (B.getOutTeam() < 9)) {
                B.setScoreIn3(B.getScoreIn3() + runner + 1);
                displayForTeamB_In3(B.getScoreIn3());
            }
            if ((B.getOutTeam() >= 9) && (B.getOutTeam() < 12)) {
                B.setScoreIn4(B.getScoreIn4() + runner + 1);
                displayForTeamB_In4(B.getScoreIn4());
            }
            if ((B.getOutTeam() >= 12) && (B.getOutTeam() < 15)) {
                B.setScoreIn5(B.getScoreIn5() + runner + 1);
                displayForTeamB_In5(B.getScoreIn5());
            }
            if ((B.getOutTeam() >= 15) && (B.getOutTeam() < 18)) {
                B.setScoreIn6(B.getScoreIn6() + runner + 1);
                displayForTeamB_In6(B.getScoreIn6());
            }
            if ((B.getOutTeam() >= 18) && (B.getOutTeam() < 21)) {
                B.setScoreIn7(B.getScoreIn7() + runner + 1);
                displayForTeamB_In7(B.getScoreIn7());
            }
            if ((B.getOutTeam() >= 21) && (B.getOutTeam() < 24)) {
                B.setScoreIn8(B.getScoreIn8() + runner + 1);
                displayForTeamB_In8(B.getScoreIn8());
            }
            if ((B.getOutTeam() >= 24) && (B.getOutTeam() < 27)) {
                B.setScoreIn9(B.getScoreIn9() + runner + 1);
                displayForTeamB_In9(B.getScoreIn9());
            }
        } else {
            A.setScoreTeam(A.getScoreTeam() + runner + 1);
            displayForTeamA(A.getScoreTeam());
            if (A.getOutTeam() < 3) {
                A.setScoreIn1(A.getScoreIn1() + runner + 1);
                displayForTeamA_In1(A.getScoreIn1());
            }
            if ((A.getOutTeam() >= 3) && (A.getOutTeam() < 6)) {
                A.setScoreIn2(A.getScoreIn2() + runner + 1);
                displayForTeamA_In2(A.getScoreIn2());
            }
            if ((A.getOutTeam() >= 6) && (A.getOutTeam() < 9)) {
                A.setScoreIn3(A.getScoreIn3() + runner + 1);
                displayForTeamA_In3(A.getScoreIn3());
            }
            if ((A.getOutTeam() >= 9) && (A.getOutTeam() < 12)) {
                A.setScoreIn4(A.getScoreIn4() + runner + 1);
                displayForTeamA_In4(A.getScoreIn4());
            }
            if ((A.getOutTeam() >= 12) && (A.getOutTeam() < 15)) {
                A.setScoreIn5(A.getScoreIn5() + runner + 1);
                displayForTeamA_In5(A.getScoreIn5());
            }
            if ((A.getOutTeam() >= 15) && (A.getOutTeam() < 18)) {
                A.setScoreIn6(A.getScoreIn6() + runner + 1);
                displayForTeamA_In6(A.getScoreIn6());
            }
            if ((A.getOutTeam() >= 18) && (A.getOutTeam() < 21)) {
                A.setScoreIn7(A.getScoreIn7() + runner + 1);
                displayForTeamA_In7(A.getScoreIn7());
            }
            if ((A.getOutTeam() >= 21) && (A.getOutTeam() < 24)) {
                A.setScoreIn8(A.getScoreIn8() + runner + 1);
                displayForTeamA_In8(A.getScoreIn8());
            }
            if ((A.getOutTeam() >= 24) && (A.getOutTeam() < 27)) {
                A.setScoreIn9(A.getScoreIn9() + runner + 1);
                displayForTeamA_In9(A.getScoreIn9());
            }
        }
        runner = 0;
        displayRunners(runner);
        freeRunner = 0;

    }

    /**
     * This method is called when the plus button is clicked for Strikes.
     */
    public void incrementStrike(View view) {
        mySound.play(strikeId, 1, 1, 1, 0, 1);
        strikes = strikes + 1;
        displayStrikes(strikes);
        if (strikes == 3) {
            mySound.play(youreoutId, 1, 1, 1, 0, 1);
            if (turnSwitch.isChecked()) {
                B.setOutTeam(B.getOutTeam() + 1);
            } else {
                A.setOutTeam(A.getOutTeam() + 1);
            }
//            //Show an error message as Toast
//            Toast.makeText(this, "You cannot have more than 3 Strikes", Toast.LENGTH_SHORT).show();
//            //exit this method early
            strikes = 0;
            balls = 0;
            foulball = 0;
            out = out + 1;
            displayStrikes(strikes);
            displayFoulball(foulball);
            displayBalls(balls);
            displayOut(out);
            if (out == 3) {
                if (turnSwitch.isChecked()) {
                    turnSwitch.setChecked(false);
                } else {
                    turnSwitch.setChecked(true);
                }


//            //Show an error message as Toast
//            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
//            //exit this method early
                out = 0;
                strikes = 0;
                foulball = 0;
                balls = 0;
                displayOut(out);
                displayStrikes(strikes);
                displayBalls(balls);
                displayFoulball(foulball);

            }

        }
    }

    /**
     * This method is called when the minus button is clicked for Strikes.
     */
    public void decrementStrike(View view) {
        strikes = strikes - 1;
        displayStrikes(strikes);
        if (strikes <= 0) {
            //Show an error message as Toast
            mySound.play(erroralertId, 1, 1, 1, 0, 1);
            Toast.makeText(this, "You cannot have less than 0 Strikes", Toast.LENGTH_SHORT).show();
            //exit this method early
            strikes = 0;
            displayStrikes(strikes);

        }
    }

    //    /**
//     * This method is called when the plus button is clicked for Foul Ball.
//     */
    public void incrementFoulBall(View view) {

        foulball = foulball + 1;
        displayFoulball(foulball);
        if (strikes < 2) {
            strikes = strikes + 1;
            displayStrikes(strikes);
        }
//        else {
//            foulball = foulball+1;
//            displayFoulball(foulball);
//        }
    }

    //    /**
//     * This method is called when the minus button is clicked for Strikes.
//     */
    public void decrementFoulball(View view) {
        foulball = foulball - 1;
        displayFoulball(foulball);
        if (foulball <= 0) {
            //Show an error message as Toast
            mySound.play(erroralertId, 1, 1, 1, 0, 1);
            Toast.makeText(this, "You cannot have less than 0 Foul Ball", Toast.LENGTH_SHORT).show();
            //exit this method early
            foulball = 0;
            displayFoulball(foulball);

        }
    }


    /**
     * This method is called when the plus button is clicked for Balls.
     */
    public void incrementBall(View view) {
        mySound.play(ballId, 1, 1, 1, 0, 1);
        balls = balls + 1;
        displayBalls(balls);
        if (balls == 4) {
            freeRunner = freeRunner + 1;
            runner = runner + 1;
            displayRunners(runner);
            strikes = 0;
            displayStrikes(strikes);
            foulball = 0;
            displayFoulball(foulball);
            balls = 0;
            displayBalls(balls);

        }
        if (freeRunner == 4) {

            //check the current state before display on the screen
            if (turnSwitch.isChecked()) {
                B.setScoreTeam(B.getScoreTeam() + 1);
                displayForTeamB(B.getScoreTeam());
                if (B.getOutTeam() < 3) {
                    B.setScoreIn1(B.getScoreIn1() + 1);
                    displayForTeamB_In1(B.getScoreIn1());
                }
                if ((B.getOutTeam() >= 3) && (B.getOutTeam() < 6)) {
                    B.setScoreIn2(B.getScoreIn2() + 1);
                    displayForTeamB_In2(B.getScoreIn2());
                }
                if ((B.getOutTeam() >= 6) && (B.getOutTeam() < 9)) {
                    B.setScoreIn3(B.getScoreIn3() + 1);
                    displayForTeamB_In3(B.getScoreIn3());
                }
                if ((B.getOutTeam() >= 9) && (B.getOutTeam() < 12)) {
                    B.setScoreIn4(B.getScoreIn4() + 1);
                    displayForTeamB_In4(B.getScoreIn4());
                }
                if ((B.getOutTeam() >= 12) && (B.getOutTeam() < 15)) {
                    B.setScoreIn5(B.getScoreIn5() + 1);
                    displayForTeamB_In5(B.getScoreIn5());
                }
                if ((B.getOutTeam() >= 15) && (B.getOutTeam() < 18)) {
                    B.setScoreIn6(B.getScoreIn6() + 1);
                    displayForTeamB_In6(B.getScoreIn6());
                }
                if ((B.getOutTeam() >= 18) && (B.getOutTeam() < 21)) {
                    B.setScoreIn7(B.getScoreIn7() + 1);
                    displayForTeamB_In7(B.getScoreIn7());
                }
                if ((B.getOutTeam() >= 21) && (B.getOutTeam() < 24)) {
                    B.setScoreIn8(B.getScoreIn8() + 1);
                    displayForTeamB_In8(B.getScoreIn8());
                }
                if ((B.getOutTeam() >= 24) && (B.getOutTeam() < 27)) {
                    B.setScoreIn9(B.getScoreIn9() + 1);
                    displayForTeamB_In9(B.getScoreIn9());
                }
            } else {
                A.setScoreTeam(A.getScoreTeam() + 1);
                displayForTeamA(A.getScoreTeam());
                if (A.getOutTeam() < 3) {
                    A.setScoreIn1(A.getScoreIn1() + 1);
                    displayForTeamA_In1(A.getScoreIn1());
                }
                if ((A.getOutTeam() >= 3) && (A.getOutTeam() < 6)) {
                    A.setScoreIn2(A.getScoreIn2() + 1);
                    displayForTeamA_In2(A.getScoreIn2());
                }
                if ((A.getOutTeam() >= 6) && (A.getOutTeam() < 9)) {
                    A.setScoreIn3(A.getScoreIn3() + 1);
                    displayForTeamA_In3(A.getScoreIn3());
                }
                if ((A.getOutTeam() >= 9) && (A.getOutTeam() < 12)) {
                    A.setScoreIn4(A.getScoreIn4() + 1);
                    displayForTeamA_In4(A.getScoreIn4());
                }
                if ((A.getOutTeam() >= 12) && (A.getOutTeam() < 15)) {
                    A.setScoreIn5(A.getScoreIn5() + 1);
                    displayForTeamA_In5(A.getScoreIn5());
                }
                if ((A.getOutTeam() >= 15) && (A.getOutTeam() < 18)) {
                    A.setScoreIn6(A.getScoreIn6() + 1);
                    displayForTeamA_In6(A.getScoreIn6());
                }
                if ((A.getOutTeam() >= 18) && (A.getOutTeam() < 21)) {
                    A.setScoreIn7(A.getScoreIn7() + 1);
                    displayForTeamA_In7(A.getScoreIn7());
                }
                if ((A.getOutTeam() >= 21) && (A.getOutTeam() < 24)) {
                    A.setScoreIn8(A.getScoreIn8() + 1);
                    displayForTeamA_In8(A.getScoreIn8());
                }
                if ((A.getOutTeam() >= 24) && (A.getOutTeam() < 27)) {
                    A.setScoreIn9(A.getScoreIn9() + 1);
                    displayForTeamA_In9(A.getScoreIn9());
                }

            }
            runner = runner - 1;
            freeRunner = freeRunner - 1;
            displayRunners(runner);
        }
    }

    /**
     * This method is called when the minus button is clicked for Balls.
     */
    public void decrementBall(View view) {
        balls = balls - 1;
        displayBalls(balls);
        if (balls <= 0) {
            //Show an error message as Toast
            mySound.play(erroralertId, 1, 1, 1, 0, 1);
            Toast.makeText(this, "You cannot have less than 0 Balls", Toast.LENGTH_SHORT).show();
            //exit this method early
            balls = 0;
            displayBalls(balls);
        }
    }

    /**
     * This method is called when the plus button is clicked for Out.
     */
    public void incrementOut(View view) {
        mySound.play(youreoutId, 1, 1, 1, 0, 1);
        out = out + 1;
        runner = runner - 1;
        freeRunner = freeRunner - 1;
        displayOut(out);
        displayRunners(runner);

        if (runner <= 0) {
            runner = 0;
            displayRunners(runner);
        }

        if (turnSwitch.isChecked()) {
            B.setOutTeam(B.getOutTeam() + 1);
        } else {
            A.setOutTeam(A.getOutTeam() + 1);
        }

        if (out == 3) {
            out = 0;
            strikes = 0;
            foulball = 0;
            balls = 0;
            freeRunner = 0;
            runner = 0;
            displayOut(out);
            displayStrikes(strikes);
            displayFoulball(foulball);
            displayBalls(balls);
            displayRunners(runner);

            if (turnSwitch.isChecked()) {
                turnSwitch.setChecked(false);
            } else {
                turnSwitch.setChecked(true);
            }
        }

    }

    /**
     * This method is called when the minus button is clicked for Out.
     */
    public void decrementOut(View view) {
        out = out - 1;
        displayOut(out);
        if (out <= 0) {
            //Show an error message as Toast
            mySound.play(erroralertId, 1, 1, 1, 0, 1);
            Toast.makeText(this, "You cannot have less than 0 Out", Toast.LENGTH_SHORT).show();
            //exit this method early
            out = 0;
            displayOut(out);
        }
    }

    /**
     * Method to calculate Free Bases.
     */
    public void freeRunner(View v) {
        mySound.play(hbpId, 1, 1, 1, 0, 1);
        freeRunner = freeRunner + 1;
        runner = runner + 1;
        displayRunners(runner);
        strikes = 0;
        displayStrikes(strikes);
        balls = 0;
        displayBalls(balls);

        if (freeRunner == 4) {
            freeRunner = freeRunner - 1;
            runner = runner - 1;
            displayRunners(runner);

            //check the current state before display on the screen
            if (turnSwitch.isChecked()) {
                B.setScoreTeam(B.getScoreTeam() + 1);
                displayForTeamB(B.getScoreTeam());
                if (B.getOutTeam() < 3) {
                    B.setScoreIn1(B.getScoreIn1() + 1);
                    displayForTeamB_In1(B.getScoreIn1());
                }
                if ((B.getOutTeam() >= 3) && (B.getOutTeam() < 6)) {
                    B.setScoreIn2(B.getScoreIn2() + 1);
                    displayForTeamB_In2(B.getScoreIn2());
                }
                if ((B.getOutTeam() >= 6) && (B.getOutTeam() < 9)) {
                    B.setScoreIn3(B.getScoreIn3() + 1);
                    displayForTeamB_In3(B.getScoreIn3());
                }
                if ((B.getOutTeam() >= 9) && (B.getOutTeam() < 12)) {
                    B.setScoreIn4(B.getScoreIn4() + 1);
                    displayForTeamB_In4(B.getScoreIn4());
                }
                if ((B.getOutTeam() >= 12) && (B.getOutTeam() < 15)) {
                    B.setScoreIn5(B.getScoreIn5() + 1);
                    displayForTeamB_In5(B.getScoreIn5());
                }
                if ((B.getOutTeam() >= 15) && (B.getOutTeam() < 18)) {
                    B.setScoreIn6(B.getScoreIn6() + 1);
                    displayForTeamB_In6(B.getScoreIn6());
                }
                if ((B.getOutTeam() >= 18) && (B.getOutTeam() < 21)) {
                    B.setScoreIn7(B.getScoreIn7() + 1);
                    displayForTeamB_In7(B.getScoreIn7());
                }
                if ((B.getOutTeam() >= 21) && (B.getOutTeam() < 24)) {
                    B.setScoreIn8(B.getScoreIn8() + 1);
                    displayForTeamB_In8(B.getScoreIn8());
                }
                if ((B.getOutTeam() >= 24) && (B.getOutTeam() < 27)) {
                    B.setScoreIn9(B.getScoreIn9() + 1);
                    displayForTeamB_In9(B.getScoreIn9());
                }
            } else {
                A.setScoreTeam(A.getScoreTeam() + 1);
                displayForTeamA(A.getScoreTeam());
                if (A.getOutTeam() < 3) {
                    A.setScoreIn1(A.getScoreIn1() + 1);
                    displayForTeamA_In1(A.getScoreIn1());
                }
                if ((A.getOutTeam() >= 3) && (A.getOutTeam() < 6)) {
                    A.setScoreIn2(A.getScoreIn2() + 1);
                    displayForTeamA_In2(A.getScoreIn2());
                }
                if ((A.getOutTeam() >= 6) && (A.getOutTeam() < 9)) {
                    A.setScoreIn3(A.getScoreIn3() + 1);
                    displayForTeamA_In3(A.getScoreIn3());
                }
                if ((A.getOutTeam() >= 9) && (A.getOutTeam() < 12)) {
                    A.setScoreIn4(A.getScoreIn4() + 1);
                    displayForTeamA_In4(A.getScoreIn4());
                }
                if ((A.getOutTeam() >= 12) && (A.getOutTeam() < 15)) {
                    A.setScoreIn5(A.getScoreIn5() + 1);
                    displayForTeamA_In5(A.getScoreIn5());
                }
                if ((A.getOutTeam() >= 15) && (A.getOutTeam() < 18)) {
                    A.setScoreIn6(A.getScoreIn6() + 1);
                    displayForTeamA_In6(A.getScoreIn6());
                }
                if ((A.getOutTeam() >= 18) && (A.getOutTeam() < 21)) {
                    A.setScoreIn7(A.getScoreIn7() + 1);
                    displayForTeamA_In7(A.getScoreIn7());
                }
                if ((A.getOutTeam() >= 21) && (A.getOutTeam() < 24)) {
                    A.setScoreIn8(A.getScoreIn8() + 1);
                    displayForTeamA_In8(A.getScoreIn8());
                }
                if ((A.getOutTeam() >= 24) && (A.getOutTeam() < 27)) {
                    A.setScoreIn9(A.getScoreIn9() + 1);
                    displayForTeamA_In9(A.getScoreIn9());
                }
            }

        }

    }


    /**
     * Method to calculate men on Bases.
     */
    public void runner(View v) {
        mySound.play(batterhitId, 1, 1, 1, 0, 1);
        runner = runner + 1;
        displayRunners(runner);
        strikes = 0;
        displayStrikes(strikes);
        balls = 0;
        displayBalls(balls);

        if (runner <= 0) {
            runner = 0;
            displayRunners(runner);
        }

    }

    /**
     * Method to RESET.
     */
    public void reset(View v) {
        A.setScoreTeam(0);
        displayForTeamA(A.getScoreTeam());
        A.setScoreIn1(0);
        displayForTeamA_In1(A.getScoreIn1());
        A.setScoreIn2(0);
        displayForTeamA_In2(A.getScoreIn2());
        A.setScoreIn3(0);
        displayForTeamA_In3(A.getScoreIn3());
        A.setScoreIn4(0);
        displayForTeamA_In4(A.getScoreIn4());
        A.setScoreIn5(0);
        displayForTeamA_In5(A.getScoreIn5());
        A.setScoreIn6(0);
        displayForTeamA_In6(A.getScoreIn6());
        A.setScoreIn7(0);
        displayForTeamA_In7(A.getScoreIn7());
        A.setScoreIn8(0);
        displayForTeamA_In8(A.getScoreIn8());
        A.setScoreIn9(0);
        displayForTeamA_In9(A.getScoreIn9());
        // Tracks the score for Team B
        B.setScoreTeam(0);
        displayForTeamB(B.getScoreTeam());
        B.setScoreIn1(0);
        displayForTeamB_In1(B.getScoreIn1());
        B.setScoreIn2(0);
        displayForTeamB_In2(B.getScoreIn2());
        B.setScoreIn3(0);
        displayForTeamB_In3(B.getScoreIn3());
        B.setScoreIn4(0);
        displayForTeamB_In4(B.getScoreIn4());
        B.setScoreIn5(0);
        displayForTeamB_In5(B.getScoreIn5());
        B.setScoreIn6(0);
        displayForTeamB_In6(B.getScoreIn6());
        B.setScoreIn7(0);
        displayForTeamB_In7(B.getScoreIn7());
        B.setScoreIn8(0);
        displayForTeamB_In8(B.getScoreIn8());
        B.setScoreIn9(0);
        displayForTeamB_In9(B.getScoreIn9());
        // Tracks the Out for Team A
        A.setOutTeam(0);
        // Tracks the Out for Team B
        B.setOutTeam(0);

        strikes = 0;
        displayStrikes(strikes);
        foulball = 0;
        displayFoulball(foulball);
        balls = 0;
        displayBalls(balls);
        out = 0;
        displayOut(out);
        freeRunner = 0;
        runner = 0;
        displayRunners(runner);
        turnSwitch.setChecked(false);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int scoreTeamA) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreTeamA));
    }

    /**
     * Displays the given score for INNING 1 for Team A.
     */
    public void displayForTeamA_In1(int scoreTeamA_In1) {
        TextView scoreView = (TextView) findViewById(R.id.in1a);
        scoreView.setText(String.valueOf(scoreTeamA_In1));
    }

    /**
     * Displays the given score for INNING 2 for Team A.
     */
    public void displayForTeamA_In2(int scoreTeamA_In2) {
        TextView scoreView = (TextView) findViewById(R.id.in2a);
        scoreView.setText(String.valueOf(scoreTeamA_In2));
    }

    /**
     * Displays the given score for INNING 3 for Team A.
     */
    public void displayForTeamA_In3(int scoreTeamA_In3) {
        TextView scoreView = (TextView) findViewById(R.id.in3a);
        scoreView.setText(String.valueOf(scoreTeamA_In3));
    }

    /**
     * Displays the given score for INNING 4 for Team A.
     */
    public void displayForTeamA_In4(int scoreTeamA_In4) {
        TextView scoreView = (TextView) findViewById(R.id.in4a);
        scoreView.setText(String.valueOf(scoreTeamA_In4));
    }

    /**
     * Displays the given score for INNING 5 for Team A.
     */
    public void displayForTeamA_In5(int scoreTeamA_In5) {
        TextView scoreView = (TextView) findViewById(R.id.in5a);
        scoreView.setText(String.valueOf(scoreTeamA_In5));
    }

    /**
     * Displays the given score for INNING 6 for Team A.
     */
    public void displayForTeamA_In6(int scoreTeamA_In6) {
        TextView scoreView = (TextView) findViewById(R.id.in6a);
        scoreView.setText(String.valueOf(scoreTeamA_In6));
    }

    /**
     * Displays the given score for INNING 7 for Team A.
     */
    public void displayForTeamA_In7(int scoreTeamA_In7) {
        TextView scoreView = (TextView) findViewById(R.id.in7a);
        scoreView.setText(String.valueOf(scoreTeamA_In7));
    }

    /**
     * Displays the given score for INNING 8 for Team A.
     */
    public void displayForTeamA_In8(int scoreTeamA_In8) {
        TextView scoreView = (TextView) findViewById(R.id.in8a);
        scoreView.setText(String.valueOf(scoreTeamA_In8));
    }

    /**
     * Displays the given score for INNING 9 for Team A.
     */
    public void displayForTeamA_In9(int scoreTeamA_In9) {
        TextView scoreView = (TextView) findViewById(R.id.in9a);
        scoreView.setText(String.valueOf(scoreTeamA_In9));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int scoreTeamB) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreTeamB));
    }

    /**
     * Displays the given score for INNING 1 for Team B.
     */
    public void displayForTeamB_In1(int scoreTeamB_In1) {
        TextView scoreView = (TextView) findViewById(R.id.in1b);
        scoreView.setText(String.valueOf(scoreTeamB_In1));
    }

    /**
     * Displays the given score for INNING 2 for Team B.
     */
    public void displayForTeamB_In2(int scoreTeamB_In2) {
        TextView scoreView = (TextView) findViewById(R.id.in2b);
        scoreView.setText(String.valueOf(scoreTeamB_In2));
    }

    /**
     * Displays the given score for INNING 3 for Team B.
     */
    public void displayForTeamB_In3(int scoreTeamB_In3) {
        TextView scoreView = (TextView) findViewById(R.id.in3b);
        scoreView.setText(String.valueOf(scoreTeamB_In3));
    }

    /**
     * Displays the given score for INNING 4 for Team B.
     */
    public void displayForTeamB_In4(int scoreTeamB_In4) {
        TextView scoreView = (TextView) findViewById(R.id.in4b);
        scoreView.setText(String.valueOf(scoreTeamB_In4));
    }

    /**
     * Displays the given score for INNING 5 for Team B.
     */
    public void displayForTeamB_In5(int scoreTeamB_In5) {
        TextView scoreView = (TextView) findViewById(R.id.in5b);
        scoreView.setText(String.valueOf(scoreTeamB_In5));
    }

    /**
     * Displays the given score for INNING 6 for Team B.
     */
    public void displayForTeamB_In6(int scoreTeamB_In6) {
        TextView scoreView = (TextView) findViewById(R.id.in6b);
        scoreView.setText(String.valueOf(scoreTeamB_In6));
    }

    /**
     * Displays the given score for INNING 7 for Team B.
     */
    public void displayForTeamB_In7(int scoreTeamA_In7) {
        TextView scoreView = (TextView) findViewById(R.id.in7b);
        scoreView.setText(String.valueOf(scoreTeamA_In7));
    }

    /**
     * Displays the given score for INNING 8 for Team B.
     */
    public void displayForTeamB_In8(int scoreTeamB_In8) {
        TextView scoreView = (TextView) findViewById(R.id.in8b);
        scoreView.setText(String.valueOf(scoreTeamB_In8));
    }

    /**
     * Displays the given score for INNING 9 for Team B.
     */
    public void displayForTeamB_In9(int scoreTeamB_In9) {
        TextView scoreView = (TextView) findViewById(R.id.in9b);
        scoreView.setText(String.valueOf(scoreTeamB_In9));
    }

    /**
     * Displays the given Strikes.
     */
    public void displayStrikes(int strikes) {
        TextView strikeView = (TextView) findViewById(R.id.strike_number);
        strikeView.setText(String.valueOf(strikes));
    }

    /**
     * Displays the given Foulballs.
     */
    public void displayFoulball(int foulball) {
        TextView foulballView = (TextView) findViewById(R.id.foulball_number);
        foulballView.setText(String.valueOf(foulball));
    }

    /**
     * Displays the given Balls.
     */
    public void displayBalls(int balls) {
        TextView ballView = (TextView) findViewById(R.id.ball_number);
        ballView.setText(String.valueOf(balls));
    }

    /**
     * Displays the given Out.
     */
    public void displayOut(int out) {
        TextView outView = (TextView) findViewById(R.id.out_number);
        outView.setText(String.valueOf(out));

    }

    /**
     * Displays the given Runners.
     */
    public void displayRunners(int runner) {
        TextView runnerView = (TextView) findViewById(R.id.man_on_diamond);
        runnerView.setText(String.valueOf(runner));

    }


}
