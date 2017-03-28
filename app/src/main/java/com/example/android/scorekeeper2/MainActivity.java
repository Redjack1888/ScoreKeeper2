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
    int strike3Id;
    int ballId;
    int ball4Id;
    int erroralertId;
    int toggleId;
    int foulballId;

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

        // Set MUSIC
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            mySound = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .build();

            batterhitId = mySound.load(this, R.raw.batterhit, 1);
            hbpId = mySound.load(this, R.raw.hitbypitch, 1);
            homerunId = mySound.load(this, R.raw.homerun, 1);
            youreoutId = mySound.load(this, R.raw.youreout, 1);
            strikeId = mySound.load(this, R.raw.strike, 1);
            strike3Id = mySound.load(this, R.raw.strike_three, 1);
            ballId = mySound.load(this, R.raw.ball, 1);
            ball4Id = mySound.load(this, R.raw.ball_four, 1);
            erroralertId = mySound.load(this, R.raw.erroralert, 1);
            toggleId = mySound.load(this, R.raw.toggle, 1);
            foulballId = mySound.load(this, R.raw.foulball, 1);
        } else {
            batterhitId = mySound.load(this, R.raw.batterhit, 1);
            hbpId = mySound.load(this, R.raw.hitbypitch, 1);
            homerunId = mySound.load(this, R.raw.homerun, 1);
            youreoutId = mySound.load(this, R.raw.youreout, 1);
            strikeId = mySound.load(this, R.raw.strike, 1);
            strike3Id = mySound.load(this, R.raw.strike_three, 1);
            ballId = mySound.load(this, R.raw.ball, 1);
            ball4Id = mySound.load(this, R.raw.ball_four, 1);
            erroralertId = mySound.load(this, R.raw.erroralert, 1);
            toggleId = mySound.load(this, R.raw.toggle, 1);
            foulballId = mySound.load(this, R.raw.foulball, 1);
        }
    }


    /**
     * Increase the score for the right Team.
     */
    public void addOneToScore(View v) {
        mySound.play(homerunId, 1, 1, 1, 0, 1);
        //check the current state before display on the screen
        if (turnSwitch.isChecked()) {
            B.setScoreTeam(B.getScoreTeam() + 1);
            displayForTeamB(B.getScoreTeam());
            if (B.getOutTeam() < 3) {
                B.setInningScore(0, B.getScoreTeam());
                displayForTeamB_In1(B.getInningScore(0));
            }
            if ((B.getOutTeam() >= 3) && (B.getOutTeam() < 6)) {
                B.setInningScore(1, B.getScoreTeam() - B.getInningScore(0));
                displayForTeamB_In2(B.getInningScore(1));
            }
            if ((B.getOutTeam() >= 6) && (B.getOutTeam() < 9)) {
                B.setInningScore(2, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1));
                displayForTeamB_In3(B.getInningScore(2));
            }
            if ((B.getOutTeam() >= 9) && (B.getOutTeam() < 12)) {
                B.setInningScore(3, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2));
                displayForTeamB_In4(B.getInningScore(3));
            }
            if ((B.getOutTeam() >= 12) && (B.getOutTeam() < 15)) {
                B.setInningScore(4, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3));
                displayForTeamB_In5(B.getInningScore(4));
            }
            if ((B.getOutTeam() >= 15) && (B.getOutTeam() < 18)) {
                B.setInningScore(5, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3) - B.getInningScore(4));
                displayForTeamB_In6(B.getInningScore(5));
            }
            if ((B.getOutTeam() >= 18) && (B.getOutTeam() < 21)) {
                B.setInningScore(6, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3) - B.getInningScore(4) - B.getInningScore(5));
                displayForTeamB_In7(B.getInningScore(6));
            }
            if ((B.getOutTeam() >= 21) && (B.getOutTeam() < 24)) {
                B.setInningScore(7, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3) - B.getInningScore(4) - B.getInningScore(5) - B.getInningScore(6));
                displayForTeamB_In8(B.getInningScore(7));
            }
            if ((B.getOutTeam() >= 24) && (B.getOutTeam() < 27)) {
                B.setInningScore(8, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3) - B.getInningScore(4) - B.getInningScore(5) - B.getInningScore(6) - B.getInningScore(7));
                displayForTeamB_In9(B.getInningScore(8));
            }

        } else {
            A.setScoreTeam(A.getScoreTeam() + 1);
            displayForTeamA(A.getScoreTeam());
            if (A.getOutTeam() < 3) {
                A.setInningScore(0, A.getScoreTeam());
                displayForTeamA_In1(A.getInningScore(0));
            }
            if ((A.getOutTeam() >= 3) && (A.getOutTeam() < 6)) {
                A.setInningScore(1, A.getScoreTeam() - A.getInningScore(0));
                displayForTeamA_In2(A.getInningScore(1));
            }
            if ((A.getOutTeam() >= 6) && (A.getOutTeam() < 9)) {
                A.setInningScore(2, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1));
                displayForTeamA_In3(A.getInningScore(2));
            }
            if ((A.getOutTeam() >= 9) && (A.getOutTeam() < 12)) {
                A.setInningScore(3, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2));
                displayForTeamA_In4(A.getInningScore(3));
            }
            if ((A.getOutTeam() >= 12) && (A.getOutTeam() < 15)) {
                A.setInningScore(4, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3));
                displayForTeamA_In5(A.getInningScore(4));
            }
            if ((A.getOutTeam() >= 15) && (A.getOutTeam() < 18)) {
                A.setInningScore(5, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4));
                displayForTeamA_In6(A.getInningScore(5));
            }
            if ((A.getOutTeam() >= 18) && (A.getOutTeam() < 21)) {
                A.setInningScore(6, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4) - A.getInningScore(5));
                displayForTeamA_In7(A.getInningScore(6));
            }
            if ((A.getOutTeam() >= 21) && (A.getOutTeam() < 24)) {
                A.setInningScore(7, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4) - A.getInningScore(5) - A.getInningScore(6));
                displayForTeamA_In8(A.getInningScore(7));
            }
            if ((A.getOutTeam() >= 24) && (A.getOutTeam() < 27)) {
                A.setInningScore(8, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4) - A.getInningScore(5) - A.getInningScore(6) - A.getInningScore(7));
                displayForTeamA_In9(A.getInningScore(8));
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
                Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                //exit this method early
                B.setScoreTeam(0);
                displayForTeamB(B.getScoreTeam());

            }


            if (B.getOutTeam() < 3) {
                B.setInningScore(0, B.getScoreTeam());
                displayForTeamB_In1(B.getInningScore(0));
                if (B.getInningScore(0) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(0, 0);
                    displayForTeamB_In1(B.getInningScore(0));

                }

            }
            if ((B.getOutTeam() >= 3) && (B.getOutTeam() < 6)) {
                B.setInningScore(1, B.getScoreTeam() - B.getInningScore(0));
                displayForTeamB_In2(B.getInningScore(1));
                if (B.getInningScore(1) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(0, B.getScoreTeam());
                    B.setInningScore(1, 0);
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getInningScore(0));
                    displayForTeamB_In2(B.getInningScore(1));

                }
            }
            if ((B.getOutTeam() >= 6) && (B.getOutTeam() < 9)) {
                B.setInningScore(2, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1));
                displayForTeamB_In3(B.getInningScore(2));
                if (B.getInningScore(2) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(2, 0);
                    displayForTeamB_In3(B.getInningScore(2));
                    B.setScoreTeam(B.getInningScore(0) + B.getInningScore(0));
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getInningScore(0));
                    displayForTeamB_In2(B.getInningScore(1));
                }
            }
            if ((B.getOutTeam() >= 9) && (B.getOutTeam() < 12)) {
                B.setInningScore(3, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2));
                displayForTeamB_In4(B.getInningScore(3));
                if (B.getInningScore(3) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(3, 0);
                    displayForTeamB_In4(B.getInningScore(3));
                    B.setScoreTeam(B.getInningScore(0) + B.getInningScore(1) + B.getInningScore(2));
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getInningScore(0));
                    displayForTeamB_In2(B.getInningScore(1));
                    displayForTeamB_In3(B.getInningScore(2));
                }
            }
            if ((B.getOutTeam() >= 12) && (B.getOutTeam() < 15)) {
                B.setInningScore(4, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3));
                displayForTeamB_In5(B.getInningScore(4));
                if (B.getInningScore(4) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(4, 0);
                    displayForTeamB_In5(B.getInningScore(4));
                    B.setScoreTeam(B.getInningScore(0) + B.getInningScore(1) + B.getInningScore(2) + B.getInningScore(3));
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getInningScore(0));
                    displayForTeamB_In2(B.getInningScore(1));
                    displayForTeamB_In3(B.getInningScore(2));
                    displayForTeamB_In4(B.getInningScore(3));

                }
            }
            if ((B.getOutTeam() >= 15) && (B.getOutTeam() < 18)) {
                B.setInningScore(5, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3) - B.getInningScore(4));
                displayForTeamB_In6(B.getInningScore(5));
                if (B.getInningScore(5) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(5, 0);
                    displayForTeamB_In6(B.getInningScore(5));
                    B.setScoreTeam(B.getInningScore(0) + B.getInningScore(1) + B.getInningScore(2) + B.getInningScore(3) + B.getInningScore(4));
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getInningScore(0));
                    displayForTeamB_In2(B.getInningScore(1));
                    displayForTeamB_In3(B.getInningScore(2));
                    displayForTeamB_In4(B.getInningScore(3));
                    displayForTeamB_In5(B.getInningScore(4));
                }
            }
            if ((B.getOutTeam() >= 18) && (B.getOutTeam() < 21)) {
                B.setInningScore(6, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3) - B.getInningScore(4) - B.getInningScore(5));
                displayForTeamB_In7(B.getInningScore(6));
                if (B.getInningScore(6) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(6, 0);
                    displayForTeamB_In7(B.getInningScore(6));
                    B.setScoreTeam(B.getInningScore(0) + B.getInningScore(1) + B.getInningScore(2) + B.getInningScore(3) + B.getInningScore(4) + B.getInningScore(5));
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getInningScore(0));
                    displayForTeamB_In2(B.getInningScore(1));
                    displayForTeamB_In3(B.getInningScore(2));
                    displayForTeamB_In4(B.getInningScore(3));
                    displayForTeamB_In5(B.getInningScore(4));
                    displayForTeamB_In6(B.getInningScore(5));

                }
            }
            if ((B.getOutTeam() >= 21) && (B.getOutTeam() < 24)) {
                B.setInningScore(7, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3) - B.getInningScore(4) - B.getInningScore(5) - B.getInningScore(6));
                displayForTeamB_In8(B.getInningScore(7));
                if (B.getInningScore(7) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(7, 0);
                    displayForTeamB_In8(B.getInningScore(7));
                    B.setScoreTeam(B.getInningScore(0) + B.getInningScore(1) + B.getInningScore(2) + B.getInningScore(3) + B.getInningScore(4) + B.getInningScore(5) + B.getInningScore(6));
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getInningScore(0));
                    displayForTeamB_In2(B.getInningScore(1));
                    displayForTeamB_In3(B.getInningScore(2));
                    displayForTeamB_In4(B.getInningScore(3));
                    displayForTeamB_In5(B.getInningScore(4));
                    displayForTeamB_In6(B.getInningScore(5));
                    displayForTeamB_In7(B.getInningScore(6));

                }
            }
            if ((B.getOutTeam() >= 24) && (B.getOutTeam() < 27)) {
                B.setInningScore(8, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3) - B.getInningScore(4) - B.getInningScore(5) - B.getInningScore(7));
                if (B.getInningScore(8) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(8, 0);
                    displayForTeamB_In9(B.getInningScore(8));
                    B.setScoreTeam(B.getInningScore(0) + B.getInningScore(1) + B.getInningScore(2) + B.getInningScore(3) + B.getInningScore(4) + B.getInningScore(5) + B.getInningScore(6) + B.getInningScore(7));
                    displayForTeamB(B.getScoreTeam());
                    displayForTeamB_In1(B.getInningScore(0));
                    displayForTeamB_In2(B.getInningScore(1));
                    displayForTeamB_In3(B.getInningScore(2));
                    displayForTeamB_In4(B.getInningScore(3));
                    displayForTeamB_In5(B.getInningScore(4));
                    displayForTeamB_In6(B.getInningScore(5));
                    displayForTeamB_In7(B.getInningScore(6));
                    displayForTeamB_In8(B.getInningScore(7));
                }
            }

        } else {
            A.setScoreTeam(A.getScoreTeam() - 1);
            displayForTeamA(A.getScoreTeam());
            if (A.getScoreTeam() <= 0) {
                //Show an error message as Toast
                mySound.play(erroralertId, 1, 1, 1, 0, 1);
                Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                //exit this method early
                A.setScoreTeam(0);
                displayForTeamA(A.getScoreTeam());

            }


            if (A.getOutTeam() < 3) {
                A.setInningScore(0, A.getScoreTeam());
                displayForTeamA_In1(A.getInningScore(0));
                if (A.getInningScore(0) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(0, 0);
                    displayForTeamA_In1(A.getInningScore(0));

                }

            }
            if ((A.getOutTeam() >= 3) && (A.getOutTeam() < 6)) {
                A.setInningScore(1, A.getScoreTeam() - A.getInningScore(0));
                displayForTeamA_In2(A.getInningScore(1));
                if (A.getInningScore(1) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(0, A.getScoreTeam());
                    A.setInningScore(1, 0);
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getInningScore(0));
                    displayForTeamA_In2(A.getInningScore(1));

                }
            }
            if ((A.getOutTeam() >= 6) && (A.getOutTeam() < 9)) {
                A.setInningScore(2, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1));
                displayForTeamA_In3(A.getInningScore(2));
                if (A.getInningScore(2) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(2, 0);
                    displayForTeamA_In3(A.getInningScore(2));
                    A.setScoreTeam(A.getInningScore(0) + A.getInningScore(0));
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getInningScore(0));
                    displayForTeamA_In2(A.getInningScore(1));
                }
            }
            if ((A.getOutTeam() >= 9) && (A.getOutTeam() < 12)) {
                A.setInningScore(3, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2));
                displayForTeamA_In4(A.getInningScore(3));
                if (A.getInningScore(3) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(3, 0);
                    displayForTeamA_In4(A.getInningScore(3));
                    A.setScoreTeam(A.getInningScore(0) + A.getInningScore(1) + A.getInningScore(2));
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getInningScore(0));
                    displayForTeamA_In2(A.getInningScore(1));
                    displayForTeamA_In3(A.getInningScore(2));
                }
            }
            if ((A.getOutTeam() >= 12) && (A.getOutTeam() < 15)) {
                A.setInningScore(4, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3));
                displayForTeamA_In5(A.getInningScore(4));
                if (A.getInningScore(4) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(4, 0);
                    displayForTeamA_In5(A.getInningScore(4));
                    A.setScoreTeam(A.getInningScore(0) + A.getInningScore(1) + A.getInningScore(2) + A.getInningScore(3));
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getInningScore(0));
                    displayForTeamA_In2(A.getInningScore(1));
                    displayForTeamA_In3(A.getInningScore(2));
                    displayForTeamA_In4(A.getInningScore(3));

                }
            }
            if ((A.getOutTeam() >= 15) && (A.getOutTeam() < 18)) {
                A.setInningScore(5, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4));
                displayForTeamA_In6(A.getInningScore(5));
                if (A.getInningScore(5) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(5, 0);
                    displayForTeamA_In6(A.getInningScore(5));
                    A.setScoreTeam(A.getInningScore(0) + A.getInningScore(1) + A.getInningScore(2) + A.getInningScore(3) + A.getInningScore(4));
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getInningScore(0));
                    displayForTeamA_In2(A.getInningScore(1));
                    displayForTeamA_In3(A.getInningScore(2));
                    displayForTeamA_In4(A.getInningScore(3));
                    displayForTeamA_In5(A.getInningScore(4));
                }
            }
            if ((A.getOutTeam() >= 18) && (A.getOutTeam() < 21)) {
                A.setInningScore(6, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4) - A.getInningScore(5));
                displayForTeamA_In7(A.getInningScore(6));
                if (A.getInningScore(6) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(6, 0);
                    displayForTeamA_In7(A.getInningScore(6));
                    A.setScoreTeam(A.getInningScore(0) + A.getInningScore(1) + A.getInningScore(2) + A.getInningScore(3) + A.getInningScore(4) + A.getInningScore(5));
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getInningScore(0));
                    displayForTeamA_In2(A.getInningScore(1));
                    displayForTeamA_In3(A.getInningScore(2));
                    displayForTeamA_In4(A.getInningScore(3));
                    displayForTeamA_In5(A.getInningScore(4));
                    displayForTeamA_In6(A.getInningScore(5));

                }
            }
            if ((A.getOutTeam() >= 21) && (A.getOutTeam() < 24)) {
                A.setInningScore(7, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4) - A.getInningScore(5) - A.getInningScore(6));
                displayForTeamA_In8(A.getInningScore(7));
                if (A.getInningScore(7) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(7, 0);
                    displayForTeamA_In8(A.getInningScore(7));
                    A.setScoreTeam(A.getInningScore(0) + A.getInningScore(1) + A.getInningScore(2) + A.getInningScore(3) + A.getInningScore(4) + A.getInningScore(5) + A.getInningScore(6));
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getInningScore(0));
                    displayForTeamA_In2(A.getInningScore(1));
                    displayForTeamA_In3(A.getInningScore(2));
                    displayForTeamA_In4(A.getInningScore(3));
                    displayForTeamA_In5(A.getInningScore(4));
                    displayForTeamA_In6(A.getInningScore(5));
                    displayForTeamA_In7(A.getInningScore(6));

                }
            }
            if ((A.getOutTeam() >= 24) && (A.getOutTeam() < 27)) {
                A.setInningScore(8, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4) - A.getInningScore(5) - A.getInningScore(7));
                displayForTeamA_In9(A.getInningScore(8));
                if (A.getInningScore(8) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(8, 0);
                    displayForTeamA_In9(A.getInningScore(8));
                    A.setScoreTeam(A.getInningScore(0) + A.getInningScore(1) + A.getInningScore(2) + A.getInningScore(3) + A.getInningScore(4) + A.getInningScore(5) + A.getInningScore(6) + A.getInningScore(7));
                    displayForTeamA(A.getScoreTeam());
                    displayForTeamA_In1(A.getInningScore(0));
                    displayForTeamA_In2(A.getInningScore(1));
                    displayForTeamA_In3(A.getInningScore(2));
                    displayForTeamA_In4(A.getInningScore(3));
                    displayForTeamA_In5(A.getInningScore(4));
                    displayForTeamA_In6(A.getInningScore(5));
                    displayForTeamA_In7(A.getInningScore(6));
                    displayForTeamA_In8(A.getInningScore(7));
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
                B.setInningScore(0, B.getInningScore(0) + runner + 1);
                displayForTeamB_In1(B.getInningScore(0));
            }
            if ((B.getOutTeam() >= 3) && (B.getOutTeam() < 6)) {
                B.setInningScore(1, B.getInningScore(1) + runner + 1);
                displayForTeamB_In2(B.getInningScore(1));
            }
            if ((B.getOutTeam() >= 6) && (B.getOutTeam() < 9)) {
                B.setInningScore(2, B.getInningScore(2) + runner + 1);
                displayForTeamB_In3(B.getInningScore(2));
            }
            if ((B.getOutTeam() >= 9) && (B.getOutTeam() < 12)) {
                B.setInningScore(3, B.getInningScore(3) + runner + 1);
                displayForTeamB_In4(B.getInningScore(3));
            }
            if ((B.getOutTeam() >= 12) && (B.getOutTeam() < 15)) {
                B.setInningScore(4, B.getInningScore(4) + runner + 1);
                displayForTeamB_In5(B.getInningScore(4));
            }
            if ((B.getOutTeam() >= 15) && (B.getOutTeam() < 18)) {
                B.setInningScore(5, B.getInningScore(5) + runner + 1);
                displayForTeamB_In6(B.getInningScore(5));
            }
            if ((B.getOutTeam() >= 18) && (B.getOutTeam() < 21)) {
                B.setInningScore(6, B.getInningScore(6) + runner + 1);
                displayForTeamB_In7(B.getInningScore(6));
            }
            if ((B.getOutTeam() >= 21) && (B.getOutTeam() < 24)) {
                B.setInningScore(7, B.getInningScore(7) + runner + 1);
                displayForTeamB_In8(B.getInningScore(7));
            }
            if ((B.getOutTeam() >= 24) && (B.getOutTeam() < 27)) {
                B.setInningScore(8, B.getInningScore(8) + runner + 1);
                displayForTeamB_In9(B.getInningScore(8));
            }
        } else {
            A.setScoreTeam(A.getScoreTeam() + runner + 1);
            displayForTeamA(A.getScoreTeam());
            if (A.getOutTeam() < 3) {
                A.setInningScore(0, A.getInningScore(0) + runner + 1);
                displayForTeamA_In1(A.getInningScore(0));
            }
            if ((A.getOutTeam() >= 3) && (A.getOutTeam() < 6)) {
                A.setInningScore(1, A.getInningScore(1) + runner + 1);
                displayForTeamA_In2(A.getInningScore(1));
            }
            if ((A.getOutTeam() >= 6) && (A.getOutTeam() < 9)) {
                A.setInningScore(2, A.getInningScore(2) + runner + 1);
                displayForTeamA_In3(A.getInningScore(2));
            }
            if ((A.getOutTeam() >= 9) && (A.getOutTeam() < 12)) {
                A.setInningScore(3, A.getInningScore(3) + runner + 1);
                displayForTeamA_In4(A.getInningScore(3));
            }
            if ((A.getOutTeam() >= 12) && (A.getOutTeam() < 15)) {
                A.setInningScore(4, A.getInningScore(4) + runner + 1);
                displayForTeamA_In5(A.getInningScore(4));
            }
            if ((A.getOutTeam() >= 15) && (A.getOutTeam() < 18)) {
                A.setInningScore(5, A.getInningScore(5) + runner + 1);
                displayForTeamA_In6(A.getInningScore(5));
            }
            if ((A.getOutTeam() >= 18) && (A.getOutTeam() < 21)) {
                A.setInningScore(6, A.getInningScore(6) + runner + 1);
                displayForTeamA_In7(A.getInningScore(6));
            }
            if ((A.getOutTeam() >= 21) && (A.getOutTeam() < 24)) {
                A.setInningScore(7, A.getInningScore(7) + runner + 1);
                displayForTeamA_In8(A.getInningScore(7));
            }
            if ((A.getOutTeam() >= 24) && (A.getOutTeam() < 27)) {
                A.setInningScore(8, A.getInningScore(8) + runner + 1);
                displayForTeamA_In9(A.getInningScore(8));
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
        strikes = strikes + 1;
        displayStrikes(strikes);
        if (strikes < 3) {
            mySound.play(strikeId, 1, 1, 1, 0, 1);
        }
        if (strikes == 3) {
            mySound.play(strike3Id, 1, 1, 1, 0, 1);
            if (turnSwitch.isChecked()) {
                B.setOutTeam(B.getOutTeam() + 1);
            } else {
                A.setOutTeam(A.getOutTeam() + 1);
            }

            strikes = 0;
            balls = 0;
            foulball = 0;
            out = out + 1;
            displayStrikes(strikes);
            displayFoulball(foulball);
            displayBalls(balls);
            displayOut(out);
            if (out == 3) {
                mySound.play(toggleId, 1, 1, 1, 0, 1);
                if (turnSwitch.isChecked()) {
                    turnSwitch.setChecked(false);
                } else {
                    turnSwitch.setChecked(true);
                }

                if (B.getOutTeam() == 27) {
                    turnSwitch.setChecked(true);
                    if (A.getScoreTeam() != B.getScoreTeam()) {
                        if (A.getScoreTeam() > B.getScoreTeam()) {
                            // A is the Winner
                            Toast.makeText(this, getString(R.string.WinnerA), Toast.LENGTH_LONG).show();
                            //exit this method early
                        } else {
                            // B is the Winner
                            Toast.makeText(this, getString(R.string.WinnerB), Toast.LENGTH_LONG).show();
                            //exit this method early
                        }
                    }
                    if (A.getScoreTeam() == B.getScoreTeam()) {
                        // There is no Winner yet
                        Toast.makeText(this, getString(R.string.NoWinner), Toast.LENGTH_LONG).show();
                        //exit this method early
                    }
                }
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
            Toast.makeText(this, getString(R.string.Toast2), Toast.LENGTH_SHORT).show();
            //exit this method early
            strikes = 0;
            displayStrikes(strikes);

        }
    }

    /**
     * This method is called when the plus button is clicked for Foul Ball.
     */
    public void incrementFoulBall(View view) {
        mySound.play(foulballId, 1, 1, 1, 0, 1);
        foulball = foulball + 1;
        displayFoulball(foulball);
        if (strikes < 2) {
            strikes = strikes + 1;
            displayStrikes(strikes);
        }

    }

    /**
     * This method is called when the minus button is clicked for Strikes.
     */
    public void decrementFoulball(View view) {
        foulball = foulball - 1;
        displayFoulball(foulball);
        if (foulball < 2) {
            strikes = foulball;
            displayStrikes(strikes);
            displayFoulball(foulball);
        }
        if (foulball <= 0) {
            //Show an error message as Toast
            mySound.play(erroralertId, 1, 1, 1, 0, 1);
            Toast.makeText(this, getString(R.string.Toast3), Toast.LENGTH_SHORT).show();
            //exit this method early
            foulball = 0;
            strikes = 0;
            displayFoulball(foulball);
            displayStrikes(strikes);
        }
    }

    /**
     * This method is called when the plus button is clicked for Balls.
     */
    public void incrementBall(View view) {
        balls = balls + 1;
        displayBalls(balls);
        if (balls < 4) {
            mySound.play(ballId, 1, 1, 1, 0, 1);
        }
        if (balls == 4) {
            mySound.play(ball4Id, 1, 1, 1, 0, 1);
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
            mySound.play(homerunId, 1, 1, 1, 0, 1);
            //check the current state before display on the screen
            if (turnSwitch.isChecked()) {
                B.setScoreTeam(B.getScoreTeam() + 1);
                displayForTeamB(B.getScoreTeam());
                if (B.getOutTeam() < 3) {
                    B.setInningScore(0, B.getInningScore(0) + 1);
                    displayForTeamB_In1(B.getInningScore(0));
                }
                if ((B.getOutTeam() >= 3) && (B.getOutTeam() < 6)) {
                    B.setInningScore(1, B.getInningScore(1) + 1);
                    displayForTeamB_In2(B.getInningScore(1));
                }
                if ((B.getOutTeam() >= 6) && (B.getOutTeam() < 9)) {
                    B.setInningScore(2, B.getInningScore(2) + 1);
                    displayForTeamB_In3(B.getInningScore(2));
                }
                if ((B.getOutTeam() >= 9) && (B.getOutTeam() < 12)) {
                    B.setInningScore(3, B.getInningScore(3) + 1);
                    displayForTeamB_In4(B.getInningScore(3));
                }
                if ((B.getOutTeam() >= 12) && (B.getOutTeam() < 15)) {
                    B.setInningScore(4, B.getInningScore(4) + 1);
                    displayForTeamB_In5(B.getInningScore(4));
                }
                if ((B.getOutTeam() >= 15) && (B.getOutTeam() < 18)) {
                    B.setInningScore(5, B.getInningScore(5) + 1);
                    displayForTeamB_In6(B.getInningScore(5));
                }
                if ((B.getOutTeam() >= 18) && (B.getOutTeam() < 21)) {
                    B.setInningScore(6, B.getInningScore(6) + 1);
                    displayForTeamB_In7(B.getInningScore(6));
                }
                if ((B.getOutTeam() >= 21) && (B.getOutTeam() < 24)) {
                    B.setInningScore(7, B.getInningScore(7) + 1);
                    displayForTeamB_In8(B.getInningScore(7));
                }
                if ((B.getOutTeam() >= 24) && (B.getOutTeam() < 27)) {
                    B.setInningScore(8, B.getInningScore(8) + 1);
                    displayForTeamB_In9(B.getInningScore(8));
                }
            } else {
                A.setScoreTeam(A.getScoreTeam() + 1);
                displayForTeamA(A.getScoreTeam());
                if (A.getOutTeam() < 3) {
                    A.setInningScore(0, A.getInningScore(0) + 1);
                    displayForTeamA_In1(A.getInningScore(0));
                }
                if ((A.getOutTeam() >= 3) && (A.getOutTeam() < 6)) {
                    A.setInningScore(1, A.getInningScore(1) + 1);
                    displayForTeamA_In2(A.getInningScore(1));
                }
                if ((A.getOutTeam() >= 6) && (A.getOutTeam() < 9)) {
                    A.setInningScore(2, A.getInningScore(2) + 1);
                    displayForTeamA_In3(A.getInningScore(2));
                }
                if ((A.getOutTeam() >= 9) && (A.getOutTeam() < 12)) {
                    A.setInningScore(3, A.getInningScore(3) + 1);
                    displayForTeamA_In4(A.getInningScore(3));
                }
                if ((A.getOutTeam() >= 12) && (A.getOutTeam() < 15)) {
                    A.setInningScore(4, A.getInningScore(4) + 1);
                    displayForTeamA_In5(A.getInningScore(4));
                }
                if ((A.getOutTeam() >= 15) && (A.getOutTeam() < 18)) {
                    A.setInningScore(5, A.getInningScore(5) + 1);
                    displayForTeamA_In6(A.getInningScore(5));
                }
                if ((A.getOutTeam() >= 18) && (A.getOutTeam() < 21)) {
                    A.setInningScore(6, A.getInningScore(6) + 1);
                    displayForTeamA_In7(A.getInningScore(6));
                }
                if ((A.getOutTeam() >= 21) && (A.getOutTeam() < 24)) {
                    A.setInningScore(7, A.getInningScore(7) + 1);
                    displayForTeamA_In8(A.getInningScore(7));
                }
                if ((A.getOutTeam() >= 24) && (A.getOutTeam() < 27)) {
                    A.setInningScore(8, A.getInningScore(8) + 1);
                    displayForTeamA_In9(A.getInningScore(8));
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
            Toast.makeText(this, getString(R.string.Toast4), Toast.LENGTH_SHORT).show();
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
            mySound.play(toggleId, 1, 1, 1, 0, 1);
            if (turnSwitch.isChecked()) {
                turnSwitch.setChecked(false);
            } else {
                turnSwitch.setChecked(true);
            }
            if (B.getOutTeam() == 27) {
                turnSwitch.setChecked(true);
                if (A.getScoreTeam() != B.getScoreTeam()) {
                    if (A.getScoreTeam() > B.getScoreTeam()) {
                        // A is the Winner
                        Toast.makeText(this, getString(R.string.WinnerA), Toast.LENGTH_LONG).show();
                        //exit this method early
                    } else {
                        // B is the Winner
                        Toast.makeText(this, getString(R.string.WinnerB), Toast.LENGTH_LONG).show();
                        //exit this method early
                    }
                }
                if (A.getScoreTeam() == B.getScoreTeam()) {
                    // There is no Winner yet
                    Toast.makeText(this, getString(R.string.NoWinner), Toast.LENGTH_LONG).show();
                    //exit this method early
                }
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
            Toast.makeText(this, getString(R.string.Toast5), Toast.LENGTH_SHORT).show();
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
            mySound.play(homerunId, 1, 1, 1, 0, 1);
            //check the current state before display on the screen
            if (turnSwitch.isChecked()) {
                B.setScoreTeam(B.getScoreTeam() + 1);
                displayForTeamB(B.getScoreTeam());
                if (B.getOutTeam() < 3) {
                    B.setInningScore(0, B.getInningScore(0) + 1);
                    displayForTeamB_In1(B.getInningScore(0));
                }
                if ((B.getOutTeam() >= 3) && (B.getOutTeam() < 6)) {
                    B.setInningScore(1, B.getInningScore(1) + 1);
                    displayForTeamB_In2(B.getInningScore(1));
                }
                if ((B.getOutTeam() >= 6) && (B.getOutTeam() < 9)) {
                    B.setInningScore(2, B.getInningScore(2) + 1);
                    displayForTeamB_In3(B.getInningScore(2));
                }
                if ((B.getOutTeam() >= 9) && (B.getOutTeam() < 12)) {
                    B.setInningScore(3, B.getInningScore(3) + 1);
                    displayForTeamB_In4(B.getInningScore(3));
                }
                if ((B.getOutTeam() >= 12) && (B.getOutTeam() < 15)) {
                    B.setInningScore(4, B.getInningScore(4) + 1);
                    displayForTeamB_In5(B.getInningScore(4));
                }
                if ((B.getOutTeam() >= 15) && (B.getOutTeam() < 18)) {
                    B.setInningScore(5, B.getInningScore(5) + 1);
                    displayForTeamB_In6(B.getInningScore(5));
                }
                if ((B.getOutTeam() >= 18) && (B.getOutTeam() < 21)) {
                    B.setInningScore(6, B.getInningScore(6) + 1);
                    displayForTeamB_In7(B.getInningScore(6));
                }
                if ((B.getOutTeam() >= 21) && (B.getOutTeam() < 24)) {
                    B.setInningScore(7, B.getInningScore(7) + 1);
                    displayForTeamB_In8(B.getInningScore(7));
                }
                if ((B.getOutTeam() >= 24) && (B.getOutTeam() < 27)) {
                    B.setInningScore(8, B.getInningScore(8) + 1);
                    displayForTeamB_In9(B.getInningScore(8));
                }
            } else {
                A.setScoreTeam(A.getScoreTeam() + 1);
                displayForTeamA(A.getScoreTeam());
                if (A.getOutTeam() < 3) {
                    A.setInningScore(0, A.getInningScore(0) + 1);
                    displayForTeamA_In1(A.getInningScore(0));
                }
                if ((A.getOutTeam() >= 3) && (A.getOutTeam() < 6)) {
                    A.setInningScore(1, A.getInningScore(1) + 1);
                    displayForTeamA_In2(A.getInningScore(1));
                }
                if ((A.getOutTeam() >= 6) && (A.getOutTeam() < 9)) {
                    A.setInningScore(2, A.getInningScore(2) + 1);
                    displayForTeamA_In3(A.getInningScore(2));
                }
                if ((A.getOutTeam() >= 9) && (A.getOutTeam() < 12)) {
                    A.setInningScore(3, A.getInningScore(3) + 1);
                    displayForTeamA_In4(A.getInningScore(3));
                }
                if ((A.getOutTeam() >= 12) && (A.getOutTeam() < 15)) {
                    A.setInningScore(4, A.getInningScore(4) + 1);
                    displayForTeamA_In5(A.getInningScore(4));
                }
                if ((A.getOutTeam() >= 15) && (A.getOutTeam() < 18)) {
                    A.setInningScore(5, A.getInningScore(5) + 1);
                    displayForTeamA_In6(A.getInningScore(5));
                }
                if ((A.getOutTeam() >= 18) && (A.getOutTeam() < 21)) {
                    A.setInningScore(6, A.getInningScore(6) + 1);
                    displayForTeamA_In7(A.getInningScore(6));
                }
                if ((A.getOutTeam() >= 21) && (A.getOutTeam() < 24)) {
                    A.setInningScore(7, A.getInningScore(7) + 1);
                    displayForTeamA_In8(A.getInningScore(7));
                }
                if ((A.getOutTeam() >= 24) && (A.getOutTeam() < 27)) {
                    A.setInningScore(8, A.getInningScore(8) + 1);
                    displayForTeamA_In9(A.getInningScore(8));
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

//    public void winnerIs(View v) {
//        if (B.getOutTeam() == 27)) {
//            if (A.getScoreTeam() > B.getScoreTeam()) {
//                // A is the Winner
//                Toast.makeText(this, "THE WINNER IS TEAM A", Toast.LENGTH_LONG).show();
//                //exit this method early
//            } else {
//                // B is the Winner
//                Toast.makeText(this, "THE WINNER IS TEAM B", Toast.LENGTH_LONG).show();
//                //exit this method early
//            }
//            if (A.getScoreTeam() == B.getScoreTeam()){
//                // There is no Winner yet
//                Toast.makeText(this, "Afetr 9 Innings there is not yet a winner. This App unfortunately don't support EXTRA Innings.", Toast.LENGTH_LONG).show();
//                //exit this method early
//            }
//
//        }
//    }

    /**
     * Method to RESET.
     */

    public void reset(View v) {
        A.setScoreTeam(0);
        displayForTeamA(A.getScoreTeam());
        A.setInningScore(0, 0);
        displayForTeamA_In1(A.getInningScore(0));
        A.setInningScore(1, 0);
        displayForTeamA_In2(A.getInningScore(1));
        A.setInningScore(2, 0);
        displayForTeamA_In3(A.getInningScore(2));
        A.setInningScore(3, 0);
        displayForTeamA_In4(A.getInningScore(3));
        A.setInningScore(4, 0);
        displayForTeamA_In5(A.getInningScore(4));
        A.setInningScore(5, 0);
        displayForTeamA_In6(A.getInningScore(5));
        A.setInningScore(6, 0);
        displayForTeamA_In7(A.getInningScore(6));
        A.setInningScore(7, 0);
        displayForTeamA_In8(A.getInningScore(7));
        A.setInningScore(8, 0);
        displayForTeamA_In9(A.getInningScore(8));
        // Tracks the score for Team B
        B.setScoreTeam(0);
        displayForTeamB(B.getScoreTeam());
        B.setInningScore(0, 0);
        displayForTeamB_In1(B.getInningScore(0));
        B.setInningScore(1, 0);
        displayForTeamB_In2(B.getInningScore(1));
        B.setInningScore(2, 0);
        displayForTeamB_In3(B.getInningScore(2));
        B.setInningScore(3, 0);
        displayForTeamB_In4(B.getInningScore(3));
        B.setInningScore(4, 0);
        displayForTeamB_In5(B.getInningScore(4));
        B.setInningScore(5, 0);
        displayForTeamB_In6(B.getInningScore(5));
        B.setInningScore(6, 0);
        displayForTeamB_In7(B.getInningScore(6));
        B.setInningScore(7, 0);
        displayForTeamB_In8(B.getInningScore(7));
        B.setInningScore(8, 0);
        displayForTeamB_In9(B.getInningScore(8));
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
