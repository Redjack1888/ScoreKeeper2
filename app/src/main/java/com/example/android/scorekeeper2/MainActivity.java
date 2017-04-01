package com.example.android.scorekeeper2;

import android.annotation.TargetApi;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static com.example.android.scorekeeper2.R.id.team_a_score;

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
    int chargeId;
    int resetId;

    private Team A = new Team();
    private Team B = new Team();
    private ToggleButton turnSwitch;
    private TextView totalScoreA, scoreInning1TeamA, scoreInning2TeamA, scoreInning3TeamA, scoreInning4TeamA, scoreInning5TeamA, scoreInning6TeamA, scoreInning7TeamA, scoreInning8TeamA, scoreInning9TeamA, totalScoreB, scoreInning1TeamB, scoreInning2TeamB, scoreInning3TeamB, scoreInning4TeamB, scoreInning5TeamB, scoreInning6TeamB, scoreInning7TeamB, scoreInning8TeamB, scoreInning9TeamB, strikeView, foulballView, ballView, outView, runnerView;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        turnSwitch = (ToggleButton) findViewById(R.id.turnSwitch);
        //set the switch to Team A
        turnSwitch.setChecked(false);

        totalScoreA = (TextView) findViewById(team_a_score);
        scoreInning1TeamA = (TextView) findViewById(R.id.in1a);
        scoreInning2TeamA = (TextView) findViewById(R.id.in2a);
        scoreInning3TeamA = (TextView) findViewById(R.id.in3a);
        scoreInning4TeamA = (TextView) findViewById(R.id.in4a);
        scoreInning5TeamA = (TextView) findViewById(R.id.in5a);
        scoreInning6TeamA = (TextView) findViewById(R.id.in6a);
        scoreInning7TeamA = (TextView) findViewById(R.id.in7a);
        scoreInning8TeamA = (TextView) findViewById(R.id.in8a);
        scoreInning9TeamA = (TextView) findViewById(R.id.in9a);
        totalScoreB = (TextView) findViewById(R.id.team_b_score);
        scoreInning1TeamB = (TextView) findViewById(R.id.in1b);
        scoreInning2TeamB = (TextView) findViewById(R.id.in2b);
        scoreInning3TeamB = (TextView) findViewById(R.id.in3b);
        scoreInning4TeamB = (TextView) findViewById(R.id.in4b);
        scoreInning5TeamB = (TextView) findViewById(R.id.in5b);
        scoreInning6TeamB = (TextView) findViewById(R.id.in6b);
        scoreInning7TeamB = (TextView) findViewById(R.id.in7b);
        scoreInning8TeamB = (TextView) findViewById(R.id.in8b);
        scoreInning9TeamB = (TextView) findViewById(R.id.in9b);
        strikeView = (TextView) findViewById(R.id.strike_number);
        foulballView = (TextView) findViewById(R.id.foulball_number);
        ballView = (TextView) findViewById(R.id.ball_number);
        outView = (TextView) findViewById(R.id.out_number);
        runnerView = (TextView) findViewById(R.id.man_on_diamond);

        createSoundPool();
        loadSounds();
    }

    protected void createSoundPool() {
        // Set MUSIC
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mySound = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .build();
        } else {
            mySound = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        }
    }

    protected void loadSounds() {
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
        chargeId = mySound.load(this, R.raw.charge, 1);
        resetId = mySound.load(this, R.raw.fizzle, 1);
    }

    /**
     * Increase the score for the right Team.
     */
    public void addOneToScore(View v) {
        mySound.play(homerunId, 1, 1, 1, 0, 1);
        //check the current state before display on the screen
        if (turnSwitch.isChecked()) {
            B.setScoreTeam(B.getScoreTeam() + 1);
            displayScore(B.getScoreTeam(), totalScoreB);
            if (B.getOutTeam() < 3) {
                B.setInningScore(0, B.getScoreTeam());
                displayScore(B.getInningScore(0), scoreInning1TeamB);
            }
            if ((B.getOutTeam() >= 3) && (B.getOutTeam() < 6)) {
                B.setInningScore(1, B.getScoreTeam() - B.getInningScore(0));
                displayScore(B.getInningScore(1), scoreInning2TeamB);
            }
            if ((B.getOutTeam() >= 6) && (B.getOutTeam() < 9)) {
                B.setInningScore(2, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1));
                displayScore(B.getInningScore(2), scoreInning3TeamB);
            }
            if ((B.getOutTeam() >= 9) && (B.getOutTeam() < 12)) {
                B.setInningScore(3, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2));
                displayScore(B.getInningScore(3), scoreInning4TeamB);
            }
            if ((B.getOutTeam() >= 12) && (B.getOutTeam() < 15)) {
                B.setInningScore(4, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3));
                displayScore(B.getInningScore(4), scoreInning5TeamB);
            }
            if ((B.getOutTeam() >= 15) && (B.getOutTeam() < 18)) {
                B.setInningScore(5, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3) - B.getInningScore(4));
                displayScore(B.getInningScore(5), scoreInning6TeamB);
            }
            if ((B.getOutTeam() >= 18) && (B.getOutTeam() < 21)) {
                B.setInningScore(6, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3) - B.getInningScore(4) - B.getInningScore(5));
                displayScore(B.getInningScore(6), scoreInning7TeamB);
            }
            if ((B.getOutTeam() >= 21) && (B.getOutTeam() < 24)) {
                B.setInningScore(7, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3) - B.getInningScore(4) - B.getInningScore(5) - B.getInningScore(6));
                displayScore(B.getInningScore(7), scoreInning8TeamB);
            }
            if ((B.getOutTeam() >= 24) && (B.getOutTeam() < 27)) {
                B.setInningScore(8, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3) - B.getInningScore(4) - B.getInningScore(5) - B.getInningScore(6) - B.getInningScore(7));
                displayScore(B.getInningScore(8), scoreInning9TeamB);
            }
        } else {
            A.setScoreTeam(A.getScoreTeam() + 1);
            displayScore(A.getScoreTeam(), totalScoreA);
            if (A.getOutTeam() < 3) {
                A.setInningScore(0, A.getScoreTeam());
                displayScore(A.getInningScore(0), scoreInning1TeamA);
            }
            if ((A.getOutTeam() >= 3) && (A.getOutTeam() < 6)) {
                A.setInningScore(1, A.getScoreTeam() - A.getInningScore(0));
                displayScore(A.getInningScore(1), scoreInning2TeamA);
            }
            if ((A.getOutTeam() >= 6) && (A.getOutTeam() < 9)) {
                A.setInningScore(2, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1));
                displayScore(A.getInningScore(2), scoreInning3TeamA);
            }
            if ((A.getOutTeam() >= 9) && (A.getOutTeam() < 12)) {
                A.setInningScore(3, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2));
                displayScore(A.getInningScore(3), scoreInning4TeamA);
            }
            if ((A.getOutTeam() >= 12) && (A.getOutTeam() < 15)) {
                A.setInningScore(4, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3));
                displayScore(A.getInningScore(4), scoreInning5TeamA);
            }
            if ((A.getOutTeam() >= 15) && (A.getOutTeam() < 18)) {
                A.setInningScore(5, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4));
                displayScore(A.getInningScore(5), scoreInning6TeamA);
            }
            if ((A.getOutTeam() >= 18) && (A.getOutTeam() < 21)) {
                A.setInningScore(6, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4) - A.getInningScore(5));
                displayScore(A.getInningScore(6), scoreInning7TeamA);
            }
            if ((A.getOutTeam() >= 21) && (A.getOutTeam() < 24)) {
                A.setInningScore(7, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4) - A.getInningScore(5) - A.getInningScore(6));
                displayScore(A.getInningScore(7), scoreInning8TeamA);
            }
            if ((A.getOutTeam() >= 24) && (A.getOutTeam() < 27)) {
                A.setInningScore(8, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4) - A.getInningScore(5) - A.getInningScore(6) - A.getInningScore(7));
                displayScore(A.getInningScore(8), scoreInning9TeamA);
            }
        }
        if (runner <= 0) {
            runner = 0;
            displayRunners(runner, runnerView);
        } else {
            runner = runner - 1;
            displayRunners(runner, runnerView);
        }
        if (runner == 4) {
            runner = runner - 1;
            displayRunners(runner, runnerView);
        }
    }

    /**
     * Decrease the score for the right Team.
     */
    public void delOneToScore(View v) {
        if (turnSwitch.isChecked()) {
            B.setScoreTeam(B.getScoreTeam() - 1);
            displayScore(B.getScoreTeam(), totalScoreB);
            if (B.getScoreTeam() <= 0) {
                //Show an error message as Toast
                mySound.play(erroralertId, 1, 1, 1, 0, 1);
                Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                //exit this method early
                B.setScoreTeam(0);
                displayScore(B.getScoreTeam(), totalScoreB);
            }
            if (B.getOutTeam() < 3) {
                B.setInningScore(0, B.getScoreTeam());
                displayScore(B.getInningScore(0), scoreInning1TeamB);
                if (B.getInningScore(0) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(0, 0);
                    displayScore(B.getInningScore(0), scoreInning1TeamB);
                }
            }
            if ((B.getOutTeam() >= 3) && (B.getOutTeam() < 6)) {
                B.setInningScore(1, B.getScoreTeam() - B.getInningScore(0));
                displayScore(B.getInningScore(1), scoreInning2TeamB);
                if (B.getInningScore(1) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(0, B.getScoreTeam());
                    B.setInningScore(1, 0);
                    displayScore(B.getScoreTeam(), totalScoreB);
                    displayScore(B.getInningScore(0), scoreInning1TeamB);
                    displayScore(B.getInningScore(1), scoreInning2TeamB);
                }
            }
            if ((B.getOutTeam() >= 6) && (B.getOutTeam() < 9)) {
                B.setInningScore(2, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1));
                displayScore(B.getInningScore(2), scoreInning3TeamB);
                if (B.getInningScore(2) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(2, 0);
                    displayScore(B.getInningScore(2), scoreInning3TeamB);
                    B.setScoreTeam(B.getInningScore(0) + B.getInningScore(0));
                    displayScore(B.getScoreTeam(), totalScoreB);
                    displayScore(B.getInningScore(0), scoreInning1TeamB);
                    displayScore(B.getInningScore(1), scoreInning2TeamB);
                }
            }
            if ((B.getOutTeam() >= 9) && (B.getOutTeam() < 12)) {
                B.setInningScore(3, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2));
                displayScore(B.getInningScore(3), scoreInning4TeamB);
                if (B.getInningScore(3) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(3, 0);
                    displayScore(B.getInningScore(3), scoreInning4TeamB);
                    B.setScoreTeam(B.getInningScore(0) + B.getInningScore(1) + B.getInningScore(2));
                    displayScore(B.getScoreTeam(), totalScoreB);
                    displayScore(B.getInningScore(0), scoreInning1TeamB);
                    displayScore(B.getInningScore(1), scoreInning2TeamB);
                    displayScore(B.getInningScore(2), scoreInning3TeamB);
                }
            }
            if ((B.getOutTeam() >= 12) && (B.getOutTeam() < 15)) {
                B.setInningScore(4, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3));
                displayScore(B.getInningScore(4), scoreInning5TeamB);
                if (B.getInningScore(4) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(4, 0);
                    displayScore(B.getInningScore(4), scoreInning5TeamB);
                    B.setScoreTeam(B.getInningScore(0) + B.getInningScore(1) + B.getInningScore(2) + B.getInningScore(3));
                    displayScore(B.getScoreTeam(), totalScoreB);
                    displayScore(B.getInningScore(0), scoreInning1TeamB);
                    displayScore(B.getInningScore(1), scoreInning2TeamB);
                    displayScore(B.getInningScore(2), scoreInning3TeamB);
                    displayScore(B.getInningScore(3), scoreInning4TeamB);
                }
            }
            if ((B.getOutTeam() >= 15) && (B.getOutTeam() < 18)) {
                B.setInningScore(5, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3) - B.getInningScore(4));
                displayScore(B.getInningScore(5), scoreInning6TeamB);
                if (B.getInningScore(5) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(5, 0);
                    displayScore(B.getInningScore(5), scoreInning6TeamB);
                    B.setScoreTeam(B.getInningScore(0) + B.getInningScore(1) + B.getInningScore(2) + B.getInningScore(3) + B.getInningScore(4));
                    displayScore(B.getScoreTeam(), totalScoreB);
                    displayScore(B.getInningScore(0), scoreInning1TeamB);
                    displayScore(B.getInningScore(1), scoreInning2TeamB);
                    displayScore(B.getInningScore(2), scoreInning3TeamB);
                    displayScore(B.getInningScore(3), scoreInning4TeamB);
                    displayScore(B.getInningScore(4), scoreInning5TeamB);
                }
            }
            if ((B.getOutTeam() >= 18) && (B.getOutTeam() < 21)) {
                B.setInningScore(6, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3) - B.getInningScore(4) - B.getInningScore(5));
                displayScore(B.getInningScore(6), scoreInning7TeamB);
                if (B.getInningScore(6) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(6, 0);
                    displayScore(B.getInningScore(6), scoreInning7TeamB);
                    B.setScoreTeam(B.getInningScore(0) + B.getInningScore(1) + B.getInningScore(2) + B.getInningScore(3) + B.getInningScore(4) + B.getInningScore(5));
                    displayScore(B.getScoreTeam(), totalScoreB);
                    displayScore(B.getInningScore(0), scoreInning1TeamB);
                    displayScore(B.getInningScore(1), scoreInning2TeamB);
                    displayScore(B.getInningScore(2), scoreInning3TeamB);
                    displayScore(B.getInningScore(3), scoreInning4TeamB);
                    displayScore(B.getInningScore(4), scoreInning5TeamB);
                    displayScore(B.getInningScore(5), scoreInning6TeamB);
                }
            }
            if ((B.getOutTeam() >= 21) && (B.getOutTeam() < 24)) {
                B.setInningScore(7, B.getScoreTeam() - B.getInningScore(0) - B.getInningScore(1) - B.getInningScore(2) - B.getInningScore(3) - B.getInningScore(4) - B.getInningScore(5) - B.getInningScore(6));
                displayScore(B.getInningScore(7), scoreInning8TeamB);
                if (B.getInningScore(7) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    B.setInningScore(7, 0);
                    displayScore(B.getInningScore(7), scoreInning8TeamB);
                    B.setScoreTeam(B.getInningScore(0) + B.getInningScore(1) + B.getInningScore(2) + B.getInningScore(3) + B.getInningScore(4) + B.getInningScore(5) + B.getInningScore(6));
                    displayScore(B.getScoreTeam(), totalScoreB);
                    displayScore(B.getInningScore(0), scoreInning1TeamB);
                    displayScore(B.getInningScore(1), scoreInning2TeamB);
                    displayScore(B.getInningScore(2), scoreInning3TeamB);
                    displayScore(B.getInningScore(3), scoreInning4TeamB);
                    displayScore(B.getInningScore(4), scoreInning5TeamB);
                    displayScore(B.getInningScore(5), scoreInning6TeamB);
                    displayScore(B.getInningScore(6), scoreInning7TeamB);
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
                    displayScore(B.getInningScore(8), scoreInning9TeamB);
                    B.setScoreTeam(B.getInningScore(0) + B.getInningScore(1) + B.getInningScore(2) + B.getInningScore(3) + B.getInningScore(4) + B.getInningScore(5) + B.getInningScore(6) + B.getInningScore(7));
                    displayScore(B.getScoreTeam(), totalScoreB);
                    displayScore(B.getInningScore(0), scoreInning1TeamB);
                    displayScore(B.getInningScore(1), scoreInning2TeamB);
                    displayScore(B.getInningScore(2), scoreInning3TeamB);
                    displayScore(B.getInningScore(3), scoreInning4TeamB);
                    displayScore(B.getInningScore(4), scoreInning5TeamB);
                    displayScore(B.getInningScore(5), scoreInning6TeamB);
                    displayScore(B.getInningScore(6), scoreInning7TeamB);
                    displayScore(B.getInningScore(7), scoreInning8TeamB);
                }
            }
        } else {
            A.setScoreTeam(A.getScoreTeam() - 1);
            displayScore(A.getScoreTeam(), totalScoreA);
            if (A.getScoreTeam() <= 0) {
                //Show an error message as Toast
                mySound.play(erroralertId, 1, 1, 1, 0, 1);
                Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                //exit this method early
                A.setScoreTeam(0);
                displayScore(A.getScoreTeam(), totalScoreA);
            }
            if (A.getOutTeam() < 3) {
                A.setInningScore(0, A.getScoreTeam());
                displayScore(A.getInningScore(0), scoreInning1TeamA);
                if (A.getInningScore(0) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(0, 0);
                    displayScore(A.getInningScore(0), scoreInning1TeamA);
                }
            }
            if ((A.getOutTeam() >= 3) && (A.getOutTeam() < 6)) {
                A.setInningScore(1, A.getScoreTeam() - A.getInningScore(0));
                displayScore(A.getInningScore(1), scoreInning2TeamA);
                if (A.getInningScore(1) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(0, A.getScoreTeam());
                    A.setInningScore(1, 0);
                    displayScore(A.getScoreTeam(), totalScoreA);
                    displayScore(A.getInningScore(0), scoreInning1TeamA);
                    displayScore(A.getInningScore(1), scoreInning2TeamA);
                }
            }
            if ((A.getOutTeam() >= 6) && (A.getOutTeam() < 9)) {
                A.setInningScore(2, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1));
                displayScore(A.getInningScore(2), scoreInning3TeamA);
                if (A.getInningScore(2) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(2, 0);
                    displayScore(A.getInningScore(2), scoreInning3TeamA);
                    A.setScoreTeam(A.getInningScore(0) + A.getInningScore(0));
                    displayScore(A.getScoreTeam(), totalScoreA);
                    displayScore(A.getInningScore(0), scoreInning1TeamA);
                    displayScore(A.getInningScore(1), scoreInning2TeamA);
                }
            }
            if ((A.getOutTeam() >= 9) && (A.getOutTeam() < 12)) {
                A.setInningScore(3, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2));
                displayScore(A.getInningScore(3), scoreInning4TeamA);
                if (A.getInningScore(3) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(3, 0);
                    displayScore(A.getInningScore(3), scoreInning4TeamA);
                    A.setScoreTeam(A.getInningScore(0) + A.getInningScore(1) + A.getInningScore(2));
                    displayScore(A.getScoreTeam(), totalScoreA);
                    displayScore(A.getInningScore(0), scoreInning1TeamA);
                    displayScore(A.getInningScore(1), scoreInning2TeamA);
                    displayScore(A.getInningScore(2), scoreInning3TeamA);
                }
            }
            if ((A.getOutTeam() >= 12) && (A.getOutTeam() < 15)) {
                A.setInningScore(4, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3));
                displayScore(A.getInningScore(4), scoreInning5TeamA);
                if (A.getInningScore(4) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(4, 0);
                    displayScore(A.getInningScore(4), scoreInning5TeamA);
                    A.setScoreTeam(A.getInningScore(0) + A.getInningScore(1) + A.getInningScore(2) + A.getInningScore(3));
                    displayScore(A.getScoreTeam(), totalScoreA);
                    displayScore(A.getInningScore(0), scoreInning1TeamA);
                    displayScore(A.getInningScore(1), scoreInning2TeamA);
                    displayScore(A.getInningScore(2), scoreInning3TeamA);
                    displayScore(A.getInningScore(3), scoreInning4TeamA);
                }
            }
            if ((A.getOutTeam() >= 15) && (A.getOutTeam() < 18)) {
                A.setInningScore(5, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4));
                displayScore(A.getInningScore(5), scoreInning6TeamA);
                if (A.getInningScore(5) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(5, 0);
                    displayScore(A.getInningScore(5), scoreInning6TeamA);
                    A.setScoreTeam(A.getInningScore(0) + A.getInningScore(1) + A.getInningScore(2) + A.getInningScore(3) + A.getInningScore(4));
                    displayScore(A.getScoreTeam(), totalScoreA);
                    displayScore(A.getInningScore(0), scoreInning1TeamA);
                    displayScore(A.getInningScore(1), scoreInning2TeamA);
                    displayScore(A.getInningScore(2), scoreInning3TeamA);
                    displayScore(A.getInningScore(3), scoreInning4TeamA);
                    displayScore(A.getInningScore(4), scoreInning5TeamA);
                }
            }
            if ((A.getOutTeam() >= 18) && (A.getOutTeam() < 21)) {
                A.setInningScore(6, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4) - A.getInningScore(5));
                displayScore(A.getInningScore(6), scoreInning7TeamA);
                if (A.getInningScore(6) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(6, 0);
                    displayScore(A.getInningScore(6), scoreInning7TeamA);
                    A.setScoreTeam(A.getInningScore(0) + A.getInningScore(1) + A.getInningScore(2) + A.getInningScore(3) + A.getInningScore(4) + A.getInningScore(5));
                    displayScore(A.getScoreTeam(), totalScoreA);
                    displayScore(A.getInningScore(0), scoreInning1TeamA);
                    displayScore(A.getInningScore(1), scoreInning2TeamA);
                    displayScore(A.getInningScore(2), scoreInning3TeamA);
                    displayScore(A.getInningScore(3), scoreInning4TeamA);
                    displayScore(A.getInningScore(4), scoreInning5TeamA);
                    displayScore(A.getInningScore(5), scoreInning6TeamA);
                }
            }
            if ((A.getOutTeam() >= 21) && (A.getOutTeam() < 24)) {
                A.setInningScore(7, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4) - A.getInningScore(5) - A.getInningScore(6));
                displayScore(A.getInningScore(7), scoreInning8TeamA);
                if (A.getInningScore(7) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(7, 0);
                    displayScore(A.getInningScore(7), scoreInning8TeamA);
                    A.setScoreTeam(A.getInningScore(0) + A.getInningScore(1) + A.getInningScore(2) + A.getInningScore(3) + A.getInningScore(4) + A.getInningScore(5) + A.getInningScore(6));
                    displayScore(A.getScoreTeam(), totalScoreA);
                    displayScore(A.getInningScore(0), scoreInning1TeamA);
                    displayScore(A.getInningScore(1), scoreInning2TeamA);
                    displayScore(A.getInningScore(2), scoreInning3TeamA);
                    displayScore(A.getInningScore(3), scoreInning4TeamA);
                    displayScore(A.getInningScore(4), scoreInning5TeamA);
                    displayScore(A.getInningScore(5), scoreInning6TeamA);
                    displayScore(A.getInningScore(6), scoreInning7TeamA);
                }
            }
            if ((A.getOutTeam() >= 24) && (A.getOutTeam() < 27)) {
                A.setInningScore(8, A.getScoreTeam() - A.getInningScore(0) - A.getInningScore(1) - A.getInningScore(2) - A.getInningScore(3) - A.getInningScore(4) - A.getInningScore(5) - A.getInningScore(7));
                displayScore(A.getInningScore(8), scoreInning9TeamA);
                if (A.getInningScore(8) <= 0) {
                    //Show an error message as Toast
                    mySound.play(erroralertId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                    //exit this method early
                    A.setInningScore(8, 0);
                    displayScore(A.getInningScore(8), scoreInning9TeamA);
                    A.setScoreTeam(A.getInningScore(0) + A.getInningScore(1) + A.getInningScore(2) + A.getInningScore(3) + A.getInningScore(4) + A.getInningScore(5) + A.getInningScore(6) + A.getInningScore(7));
                    displayScore(A.getScoreTeam(), totalScoreA);
                    displayScore(A.getInningScore(0), scoreInning1TeamA);
                    displayScore(A.getInningScore(1), scoreInning2TeamA);
                    displayScore(A.getInningScore(2), scoreInning3TeamA);
                    displayScore(A.getInningScore(3), scoreInning4TeamA);
                    displayScore(A.getInningScore(4), scoreInning5TeamA);
                    displayScore(A.getInningScore(5), scoreInning6TeamA);
                    displayScore(A.getInningScore(6), scoreInning7TeamA);
                    displayScore(A.getInningScore(7), scoreInning8TeamA);
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
            displayScore(B.getScoreTeam(), totalScoreB);
            if (B.getOutTeam() < 3) {
                B.setInningScore(0, B.getInningScore(0) + runner + 1);
                displayScore(B.getInningScore(0), scoreInning1TeamB);
            }
            if ((B.getOutTeam() >= 3) && (B.getOutTeam() < 6)) {
                B.setInningScore(1, B.getInningScore(1) + runner + 1);
                displayScore(B.getInningScore(1), scoreInning2TeamB);
            }
            if ((B.getOutTeam() >= 6) && (B.getOutTeam() < 9)) {
                B.setInningScore(2, B.getInningScore(2) + runner + 1);
                displayScore(B.getInningScore(2), scoreInning3TeamB);
            }
            if ((B.getOutTeam() >= 9) && (B.getOutTeam() < 12)) {
                B.setInningScore(3, B.getInningScore(3) + runner + 1);
                displayScore(B.getInningScore(3), scoreInning4TeamB);
            }
            if ((B.getOutTeam() >= 12) && (B.getOutTeam() < 15)) {
                B.setInningScore(4, B.getInningScore(4) + runner + 1);
                displayScore(B.getInningScore(4), scoreInning5TeamB);
            }
            if ((B.getOutTeam() >= 15) && (B.getOutTeam() < 18)) {
                B.setInningScore(5, B.getInningScore(5) + runner + 1);
                displayScore(B.getInningScore(5), scoreInning6TeamB);
            }
            if ((B.getOutTeam() >= 18) && (B.getOutTeam() < 21)) {
                B.setInningScore(6, B.getInningScore(6) + runner + 1);
                displayScore(B.getInningScore(6), scoreInning7TeamB);
            }
            if ((B.getOutTeam() >= 21) && (B.getOutTeam() < 24)) {
                B.setInningScore(7, B.getInningScore(7) + runner + 1);
                displayScore(B.getInningScore(7), scoreInning8TeamB);
            }
            if ((B.getOutTeam() >= 24) && (B.getOutTeam() < 27)) {
                B.setInningScore(8, B.getInningScore(8) + runner + 1);
                displayScore(B.getInningScore(8), scoreInning9TeamB);
            }
        } else {
            A.setScoreTeam(A.getScoreTeam() + runner + 1);
            displayScore(A.getScoreTeam(), totalScoreA);
            if (A.getOutTeam() < 3) {
                A.setInningScore(0, A.getInningScore(0) + runner + 1);
                displayScore(A.getInningScore(0), scoreInning1TeamA);
            }
            if ((A.getOutTeam() >= 3) && (A.getOutTeam() < 6)) {
                A.setInningScore(1, A.getInningScore(1) + runner + 1);
                displayScore(A.getInningScore(1), scoreInning2TeamA);
            }
            if ((A.getOutTeam() >= 6) && (A.getOutTeam() < 9)) {
                A.setInningScore(2, A.getInningScore(2) + runner + 1);
                displayScore(A.getInningScore(2), scoreInning3TeamA);
            }
            if ((A.getOutTeam() >= 9) && (A.getOutTeam() < 12)) {
                A.setInningScore(3, A.getInningScore(3) + runner + 1);
                displayScore(A.getInningScore(3), scoreInning4TeamA);
            }
            if ((A.getOutTeam() >= 12) && (A.getOutTeam() < 15)) {
                A.setInningScore(4, A.getInningScore(4) + runner + 1);
                displayScore(A.getInningScore(4), scoreInning5TeamA);
            }
            if ((A.getOutTeam() >= 15) && (A.getOutTeam() < 18)) {
                A.setInningScore(5, A.getInningScore(5) + runner + 1);
                displayScore(A.getInningScore(5), scoreInning6TeamA);
            }
            if ((A.getOutTeam() >= 18) && (A.getOutTeam() < 21)) {
                A.setInningScore(6, A.getInningScore(6) + runner + 1);
                displayScore(A.getInningScore(6), scoreInning7TeamA);
            }
            if ((A.getOutTeam() >= 21) && (A.getOutTeam() < 24)) {
                A.setInningScore(7, A.getInningScore(7) + runner + 1);
                displayScore(A.getInningScore(7), scoreInning8TeamA);
            }
            if ((A.getOutTeam() >= 24) && (A.getOutTeam() < 27)) {
                A.setInningScore(8, A.getInningScore(8) + runner + 1);
                displayScore(A.getInningScore(8), scoreInning9TeamA);
            }
        }
        runner = 0;
        displayRunners(runner, runnerView);
        freeRunner = 0;
    }

    /**
     * This method is called when the plus button is clicked for Strikes.
     */
    public void incrementStrike(View view) {
        strikes = strikes + 1;
        displayStrikes(strikes, strikeView);
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
            displayStrikes(strikes, strikeView);
            displayFoulball(foulball, foulballView);
            displayBalls(balls, ballView);
            displayOut(out, outView);
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
                            mySound.play(chargeId, 1, 1, 1, 0, 1);
                            // A is the Winner
                            Toast.makeText(this, getString(R.string.WinnerA), Toast.LENGTH_LONG).show();
                            //exit this method early
                        } else {
                            mySound.play(chargeId, 1, 1, 1, 0, 1);
                            // B is the Winner
                            Toast.makeText(this, getString(R.string.WinnerB), Toast.LENGTH_LONG).show();
                            //exit this method early
                        }
                    }
                    if (A.getScoreTeam() == B.getScoreTeam()) {
                        mySound.play(chargeId, 1, 1, 1, 0, 1);
                        // There is no Winner yet
                        Toast.makeText(this, getString(R.string.NoWinner), Toast.LENGTH_LONG).show();
                        //exit this method early
                    }
                }
                out = 0;
                strikes = 0;
                foulball = 0;
                balls = 0;
                displayOut(out, outView);
                displayStrikes(strikes, strikeView);
                displayBalls(balls, ballView);
                displayFoulball(foulball, foulballView);
            }
        }
    }

    /**
     * This method is called when the minus button is clicked for Strikes.
     */
    public void decrementStrike(View view) {
        strikes = strikes - 1;
        displayStrikes(strikes, strikeView);
        if (strikes <= 0) {
            //Show an error message as Toast
            mySound.play(erroralertId, 1, 1, 1, 0, 1);
            Toast.makeText(this, getString(R.string.Toast2), Toast.LENGTH_SHORT).show();
            //exit this method early
            strikes = 0;
            displayStrikes(strikes, strikeView);
        }
    }

    /**
     * This method is called when the plus button is clicked for Foul Ball.
     */
    public void incrementFoulBall(View view) {
        mySound.play(foulballId, 1, 1, 1, 0, 1);
        foulball = foulball + 1;
        displayFoulball(foulball, foulballView);
        if (strikes < 2) {
            strikes = strikes + 1;
            displayStrikes(strikes, strikeView);
        }
    }

    /**
     * This method is called when the minus button is clicked for Strikes.
     */
    public void decrementFoulball(View view) {
        foulball = foulball - 1;
        displayFoulball(foulball, foulballView);
        if (foulball <= 0) {
            //Show an error message as Toast
            mySound.play(erroralertId, 1, 1, 1, 0, 1);
            Toast.makeText(this, getString(R.string.Toast3), Toast.LENGTH_SHORT).show();
            //exit this method early
            foulball = 0;
            displayFoulball(foulball, foulballView);
        }
    }

    /**
     * This method is called when the plus button is clicked for Balls.
     */
    public void incrementBall(View view) {
        balls = balls + 1;
        displayBalls(balls, ballView);
        if (balls < 4) {
            mySound.play(ballId, 1, 1, 1, 0, 1);
        }
        if (balls == 4) {
            mySound.play(ball4Id, 1, 1, 1, 0, 1);
            freeRunner = freeRunner + 1;
            runner = runner + 1;
            displayRunners(runner, runnerView);
            strikes = 0;
            displayStrikes(strikes, strikeView);
            foulball = 0;
            displayFoulball(foulball, foulballView);
            balls = 0;
            displayBalls(balls, ballView);
        }
        if (freeRunner == 4) {
            mySound.play(homerunId, 1, 1, 1, 0, 1);
            //check the current state before display on the screen
            if (turnSwitch.isChecked()) {
                B.setScoreTeam(B.getScoreTeam() + 1);
                displayScore(B.getScoreTeam(), totalScoreB);
                if (B.getOutTeam() < 3) {
                    B.setInningScore(0, B.getInningScore(0) + 1);
                    displayScore(B.getInningScore(0), scoreInning1TeamB);
                }
                if ((B.getOutTeam() >= 3) && (B.getOutTeam() < 6)) {
                    B.setInningScore(1, B.getInningScore(1) + 1);
                    displayScore(B.getInningScore(1), scoreInning2TeamB);
                }
                if ((B.getOutTeam() >= 6) && (B.getOutTeam() < 9)) {
                    B.setInningScore(2, B.getInningScore(2) + 1);
                    displayScore(B.getInningScore(2), scoreInning3TeamB);
                }
                if ((B.getOutTeam() >= 9) && (B.getOutTeam() < 12)) {
                    B.setInningScore(3, B.getInningScore(3) + 1);
                    displayScore(B.getInningScore(3), scoreInning4TeamB);
                }
                if ((B.getOutTeam() >= 12) && (B.getOutTeam() < 15)) {
                    B.setInningScore(4, B.getInningScore(4) + 1);
                    displayScore(B.getInningScore(4), scoreInning5TeamB);
                }
                if ((B.getOutTeam() >= 15) && (B.getOutTeam() < 18)) {
                    B.setInningScore(5, B.getInningScore(5) + 1);
                    displayScore(B.getInningScore(5), scoreInning6TeamB);
                }
                if ((B.getOutTeam() >= 18) && (B.getOutTeam() < 21)) {
                    B.setInningScore(6, B.getInningScore(6) + 1);
                    displayScore(B.getInningScore(6), scoreInning7TeamB);
                }
                if ((B.getOutTeam() >= 21) && (B.getOutTeam() < 24)) {
                    B.setInningScore(7, B.getInningScore(7) + 1);
                    displayScore(B.getInningScore(7), scoreInning8TeamB);
                }
                if ((B.getOutTeam() >= 24) && (B.getOutTeam() < 27)) {
                    B.setInningScore(8, B.getInningScore(8) + 1);
                    displayScore(B.getInningScore(8), scoreInning9TeamB);
                }
            } else {
                A.setScoreTeam(A.getScoreTeam() + 1);
                displayScore(A.getScoreTeam(), totalScoreA);
                if (A.getOutTeam() < 3) {
                    A.setInningScore(0, A.getInningScore(0) + 1);
                    displayScore(A.getInningScore(0), scoreInning1TeamA);
                }
                if ((A.getOutTeam() >= 3) && (A.getOutTeam() < 6)) {
                    A.setInningScore(1, A.getInningScore(1) + 1);
                    displayScore(A.getInningScore(1), scoreInning2TeamA);
                }
                if ((A.getOutTeam() >= 6) && (A.getOutTeam() < 9)) {
                    A.setInningScore(2, A.getInningScore(2) + 1);
                    displayScore(A.getInningScore(2), scoreInning3TeamA);
                }
                if ((A.getOutTeam() >= 9) && (A.getOutTeam() < 12)) {
                    A.setInningScore(3, A.getInningScore(3) + 1);
                    displayScore(A.getInningScore(3), scoreInning4TeamA);
                }
                if ((A.getOutTeam() >= 12) && (A.getOutTeam() < 15)) {
                    A.setInningScore(4, A.getInningScore(4) + 1);
                    displayScore(A.getInningScore(4), scoreInning5TeamA);
                }
                if ((A.getOutTeam() >= 15) && (A.getOutTeam() < 18)) {
                    A.setInningScore(5, A.getInningScore(5) + 1);
                    displayScore(A.getInningScore(5), scoreInning6TeamA);
                }
                if ((A.getOutTeam() >= 18) && (A.getOutTeam() < 21)) {
                    A.setInningScore(6, A.getInningScore(6) + 1);
                    displayScore(A.getInningScore(6), scoreInning7TeamA);
                }
                if ((A.getOutTeam() >= 21) && (A.getOutTeam() < 24)) {
                    A.setInningScore(7, A.getInningScore(7) + 1);
                    displayScore(A.getInningScore(7), scoreInning8TeamA);
                }
                if ((A.getOutTeam() >= 24) && (A.getOutTeam() < 27)) {
                    A.setInningScore(8, A.getInningScore(8) + 1);
                    displayScore(A.getInningScore(8), scoreInning9TeamA);
                }
            }
            runner = runner - 1;
            freeRunner = freeRunner - 1;
            displayRunners(runner, runnerView);
        }
    }

    /**
     * This method is called when the minus button is clicked for Balls.
     */
    public void decrementBall(View view) {
        balls = balls - 1;
        displayBalls(balls, ballView);
        if (balls <= 0) {
            //Show an error message as Toast
            mySound.play(erroralertId, 1, 1, 1, 0, 1);
            Toast.makeText(this, getString(R.string.Toast4), Toast.LENGTH_SHORT).show();
            //exit this method early
            balls = 0;
            displayBalls(balls, ballView);
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
        displayOut(out, outView);
        displayRunners(runner, runnerView);
        if (runner <= 0) {
            runner = 0;
            displayRunners(runner, runnerView);
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
            displayOut(out, outView);
            displayStrikes(strikes, strikeView);
            displayFoulball(foulball, foulballView);
            displayBalls(balls, ballView);
            displayRunners(runner, runnerView);
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
                        mySound.play(chargeId, 1, 1, 1, 0, 1);
                        // A is the Winner
                        Toast.makeText(this, getString(R.string.WinnerA), Toast.LENGTH_LONG).show();
                        //exit this method early
                    } else {
                        mySound.play(chargeId, 1, 1, 1, 0, 1);
                        // B is the Winner
                        Toast.makeText(this, getString(R.string.WinnerB), Toast.LENGTH_LONG).show();
                        //exit this method early
                    }
                }
                if (A.getScoreTeam() == B.getScoreTeam()) {
                    mySound.play(chargeId, 1, 1, 1, 0, 1);
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
        displayOut(out, outView);
        if (out <= 0) {
            //Show an error message as Toast
            mySound.play(erroralertId, 1, 1, 1, 0, 1);
            Toast.makeText(this, getString(R.string.Toast5), Toast.LENGTH_SHORT).show();
            //exit this method early
            out = 0;
            displayOut(out, outView);
        }
    }

    /**
     * Method to calculate Free Bases.
     */
    public void freeRunner(View v) {
        mySound.play(hbpId, 1, 1, 1, 0, 1);
        freeRunner = freeRunner + 1;
        runner = runner + 1;
        displayRunners(runner, runnerView);
        strikes = 0;
        displayStrikes(strikes, strikeView);
        balls = 0;
        displayBalls(balls, ballView);
        if (freeRunner == 4) {
            freeRunner = freeRunner - 1;
            runner = runner - 1;
            displayRunners(runner, runnerView);
            mySound.play(homerunId, 1, 1, 1, 0, 1);
            //check the current state before display on the screen
            if (turnSwitch.isChecked()) {
                B.setScoreTeam(B.getScoreTeam() + 1);
                displayScore(B.getScoreTeam(), totalScoreB);
                if (B.getOutTeam() < 3) {
                    B.setInningScore(0, B.getInningScore(0) + 1);
                    displayScore(B.getInningScore(0), scoreInning1TeamB);
                }
                if ((B.getOutTeam() >= 3) && (B.getOutTeam() < 6)) {
                    B.setInningScore(1, B.getInningScore(1) + 1);
                    displayScore(B.getInningScore(1), scoreInning2TeamB);
                }
                if ((B.getOutTeam() >= 6) && (B.getOutTeam() < 9)) {
                    B.setInningScore(2, B.getInningScore(2) + 1);
                    displayScore(B.getInningScore(2), scoreInning3TeamB);
                }
                if ((B.getOutTeam() >= 9) && (B.getOutTeam() < 12)) {
                    B.setInningScore(3, B.getInningScore(3) + 1);
                    displayScore(B.getInningScore(3), scoreInning4TeamB);
                }
                if ((B.getOutTeam() >= 12) && (B.getOutTeam() < 15)) {
                    B.setInningScore(4, B.getInningScore(4) + 1);
                    displayScore(B.getInningScore(4), scoreInning5TeamB);
                }
                if ((B.getOutTeam() >= 15) && (B.getOutTeam() < 18)) {
                    B.setInningScore(5, B.getInningScore(5) + 1);
                    displayScore(B.getInningScore(5), scoreInning6TeamB);
                }
                if ((B.getOutTeam() >= 18) && (B.getOutTeam() < 21)) {
                    B.setInningScore(6, B.getInningScore(6) + 1);
                    displayScore(B.getInningScore(6), scoreInning7TeamB);
                }
                if ((B.getOutTeam() >= 21) && (B.getOutTeam() < 24)) {
                    B.setInningScore(7, B.getInningScore(7) + 1);
                    displayScore(B.getInningScore(7), scoreInning8TeamB);
                }
                if ((B.getOutTeam() >= 24) && (B.getOutTeam() < 27)) {
                    B.setInningScore(8, B.getInningScore(8) + 1);
                    displayScore(B.getInningScore(8), scoreInning9TeamB);
                }
            } else {
                A.setScoreTeam(A.getScoreTeam() + 1);
                displayScore(A.getScoreTeam(), totalScoreA);
                if (A.getOutTeam() < 3) {
                    A.setInningScore(0, A.getInningScore(0) + 1);
                    displayScore(A.getInningScore(0), scoreInning1TeamA);
                }
                if ((A.getOutTeam() >= 3) && (A.getOutTeam() < 6)) {
                    A.setInningScore(1, A.getInningScore(1) + 1);
                    displayScore(A.getInningScore(1), scoreInning2TeamA);
                }
                if ((A.getOutTeam() >= 6) && (A.getOutTeam() < 9)) {
                    A.setInningScore(2, A.getInningScore(2) + 1);
                    displayScore(A.getInningScore(2), scoreInning3TeamA);
                }
                if ((A.getOutTeam() >= 9) && (A.getOutTeam() < 12)) {
                    A.setInningScore(3, A.getInningScore(3) + 1);
                    displayScore(A.getInningScore(3), scoreInning4TeamA);
                }
                if ((A.getOutTeam() >= 12) && (A.getOutTeam() < 15)) {
                    A.setInningScore(4, A.getInningScore(4) + 1);
                    displayScore(A.getInningScore(4), scoreInning5TeamA);
                }
                if ((A.getOutTeam() >= 15) && (A.getOutTeam() < 18)) {
                    A.setInningScore(5, A.getInningScore(5) + 1);
                    displayScore(A.getInningScore(5), scoreInning6TeamA);
                }
                if ((A.getOutTeam() >= 18) && (A.getOutTeam() < 21)) {
                    A.setInningScore(6, A.getInningScore(6) + 1);
                    displayScore(A.getInningScore(6), scoreInning7TeamA);
                }
                if ((A.getOutTeam() >= 21) && (A.getOutTeam() < 24)) {
                    A.setInningScore(7, A.getInningScore(7) + 1);
                    displayScore(A.getInningScore(7), scoreInning8TeamA);
                }
                if ((A.getOutTeam() >= 24) && (A.getOutTeam() < 27)) {
                    A.setInningScore(8, A.getInningScore(8) + 1);
                    displayScore(A.getInningScore(8), scoreInning9TeamA);
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
        displayRunners(runner, runnerView);
        strikes = 0;
        displayStrikes(strikes, strikeView);
        foulball = 0;
        displayFoulball(foulball, foulballView);
        balls = 0;
        displayBalls(balls, ballView);
        if (runner <= 0) {
            runner = 0;
            displayRunners(runner, runnerView);
        }
    }

    /**
     * Method to RESET.
     */
    public void reset(View v) {
        mySound.play(resetId, 1, 1, 1, 0, 1);
        A.setScoreTeam(0);
        displayScore(A.getScoreTeam(), totalScoreA);
        A.setInningScore(0, 0);
        displayScore(A.getInningScore(0), scoreInning1TeamA);
        A.setInningScore(1, 0);
        displayScore(A.getInningScore(1), scoreInning2TeamA);
        A.setInningScore(2, 0);
        displayScore(A.getInningScore(2), scoreInning3TeamA);
        A.setInningScore(3, 0);
        displayScore(A.getInningScore(3), scoreInning4TeamA);
        A.setInningScore(4, 0);
        displayScore(A.getInningScore(4), scoreInning5TeamA);
        A.setInningScore(5, 0);
        displayScore(A.getInningScore(5), scoreInning6TeamA);
        A.setInningScore(6, 0);
        displayScore(A.getInningScore(6), scoreInning7TeamA);
        A.setInningScore(7, 0);
        displayScore(A.getInningScore(7), scoreInning8TeamA);
        A.setInningScore(8, 0);
        displayScore(A.getInningScore(8), scoreInning9TeamA);
        // Tracks the score for Team B
        B.setScoreTeam(0);
        displayScore(B.getScoreTeam(), totalScoreB);
        B.setInningScore(0, 0);
        displayScore(B.getInningScore(0), scoreInning1TeamB);
        B.setInningScore(1, 0);
        displayScore(B.getInningScore(1), scoreInning2TeamB);
        B.setInningScore(2, 0);
        displayScore(B.getInningScore(2), scoreInning3TeamB);
        B.setInningScore(3, 0);
        displayScore(B.getInningScore(3), scoreInning4TeamB);
        B.setInningScore(4, 0);
        displayScore(B.getInningScore(4), scoreInning5TeamB);
        B.setInningScore(5, 0);
        displayScore(B.getInningScore(5), scoreInning6TeamB);
        B.setInningScore(6, 0);
        displayScore(B.getInningScore(6), scoreInning7TeamB);
        B.setInningScore(7, 0);
        displayScore(B.getInningScore(7), scoreInning8TeamB);
        B.setInningScore(8, 0);
        displayScore(B.getInningScore(8), scoreInning9TeamB);
        // Tracks the Out for Team A
        A.setOutTeam(0);
        // Tracks the Out for Team B
        B.setOutTeam(0);
        strikes = 0;
        displayStrikes(strikes, strikeView);
        foulball = 0;
        displayFoulball(foulball, foulballView);
        balls = 0;
        displayBalls(balls, ballView);
        out = 0;
        displayOut(out, outView);
        freeRunner = 0;
        runner = 0;
        displayRunners(runner, runnerView);
        turnSwitch.setChecked(false);
    }

    /**
     * Displays the given Strikes.
     */
    public void displayStrikes(int strikes, TextView strikeView) {
        strikeView.setText(String.valueOf(strikes));
    }

    /**
     * Displays the given Foulballs.
     */
    public void displayFoulball(int foulball, TextView foulballView) {
        foulballView.setText(String.valueOf(foulball));
    }

    /**
     * Displays the given Balls.
     */
    public void displayBalls(int balls, TextView ballView) {
        ballView.setText(String.valueOf(balls));
    }

    /**
     * Displays the given Out.
     */
    public void displayOut(int out, TextView outView) {
        outView.setText(String.valueOf(out));
    }

    /**
     * Displays the given Runners.
     */
    public void displayRunners(int runner, TextView runnerView) {
        runnerView.setText(String.valueOf(runner));
    }

    /**
     * Displays the given Score.
     */
    public void displayScore(int score, TextView scoreView) {
        scoreView.setText(String.valueOf(score));
    }
}