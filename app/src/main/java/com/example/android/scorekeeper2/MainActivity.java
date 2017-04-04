package com.example.android.scorekeeper2;

import android.annotation.TargetApi;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static com.example.android.scorekeeper2.R.id.team_a_score;
import static com.example.android.scorekeeper2.R.raw.strike;

public class MainActivity extends AppCompatActivity {

    int strikes;
    int foulBall;
    int balls;
    int out;
    int freeRunner;
    int runner;
    int currentInning;

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
    private TextView totalScoreViewA, totalScoreViewB, numberOfStrikes, numberOfFoulBall, numberOfBall, numberOfOut, numberOfRunner;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        turnSwitch = (ToggleButton) findViewById(R.id.turnSwitch);
        //set the switch to Team A
        turnSwitch.setChecked(false);

        currentInning = 0;

        totalScoreViewA = (TextView) findViewById(team_a_score);
        A.inningScoreView[0] = (TextView) findViewById(R.id.in1a);
        A.inningScoreView[1] = (TextView) findViewById(R.id.in2a);
        A.inningScoreView[2] = (TextView) findViewById(R.id.in3a);
        A.inningScoreView[3] = (TextView) findViewById(R.id.in4a);
        A.inningScoreView[4] = (TextView) findViewById(R.id.in5a);
        A.inningScoreView[5] = (TextView) findViewById(R.id.in6a);
        A.inningScoreView[6] = (TextView) findViewById(R.id.in7a);
        A.inningScoreView[7] = (TextView) findViewById(R.id.in8a);
        A.inningScoreView[8] = (TextView) findViewById(R.id.in9a);
        totalScoreViewB = (TextView) findViewById(R.id.team_b_score);
        B.inningScoreView[0] = (TextView) findViewById(R.id.in1b);
        B.inningScoreView[1] = (TextView) findViewById(R.id.in2b);
        B.inningScoreView[2] = (TextView) findViewById(R.id.in3b);
        B.inningScoreView[3] = (TextView) findViewById(R.id.in4b);
        B.inningScoreView[4] = (TextView) findViewById(R.id.in5b);
        B.inningScoreView[5] = (TextView) findViewById(R.id.in6b);
        B.inningScoreView[6] = (TextView) findViewById(R.id.in7b);
        B.inningScoreView[7] = (TextView) findViewById(R.id.in8b);
        B.inningScoreView[8] = (TextView) findViewById(R.id.in9b);
        numberOfStrikes = (TextView) findViewById(R.id.strike_number);
        numberOfFoulBall = (TextView) findViewById(R.id.foulball_number);
        numberOfBall = (TextView) findViewById(R.id.ball_number);
        numberOfOut = (TextView) findViewById(R.id.out_number);
        numberOfRunner = (TextView) findViewById(R.id.man_on_diamond);

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
        strikeId = mySound.load(this, strike, 1);
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
            addOnePoint(B);
            displayScore(B.getInningScore(currentInning), B.inningScoreView[currentInning]);
            calculateTotalScore();
            displayTotalScore(B.getScoreTeam(), totalScoreViewB);

        } else {
            addOnePoint(A);
            displayScore(A.getInningScore(currentInning), A.inningScoreView[currentInning]);
            calculateTotalScore();
            displayTotalScore(A.getScoreTeam(), totalScoreViewA);
        }

        if (runner <= 0) {
            runner = 0;
            displayRunners(runner, numberOfRunner);
        } else {
            runner = runner - 1;
            displayRunners(runner, numberOfRunner);
        }
        if (runner == 4) {
            runner = runner - 1;
            displayRunners(runner, numberOfRunner);
        }
    }

    private void addOnePoint(Team t) {

        t.setInningScore(currentInning, t.getInningScore(currentInning) + 1);
        displayScore(t.getInningScore(currentInning), t.inningScoreView[currentInning]);
    }

    private void calculateTotalScore() {
        if (turnSwitch.isChecked()) {
            B.setScoreTeam(B.getInningScore(0) + B.getInningScore(1) + B.getInningScore(2) + B.getInningScore(3) + B.getInningScore(4) + B.getInningScore(5) + B.getInningScore(6) + B.getInningScore(7) + B.getInningScore(8));
            displayTotalScore(B.getScoreTeam(), totalScoreViewB);

        } else {
            A.setScoreTeam(A.getInningScore(0) + A.getInningScore(1) + A.getInningScore(2) + A.getInningScore(3) + A.getInningScore(4) + A.getInningScore(5) + A.getInningScore(6) + A.getInningScore(7) + A.getInningScore(8));
            displayTotalScore(A.getScoreTeam(), totalScoreViewA);

        }
    }

    /**
     * Decrease the score for the right Team.
     */
    public void delOneToScore(View v) {
        if (turnSwitch.isChecked()) {
            delOnePoint(B);
            displayScore(B.getInningScore(currentInning), B.inningScoreView[currentInning]);
            calculateTotalScore();
            displayTotalScore(B.getScoreTeam(), totalScoreViewB);
            if (B.getInningScore(currentInning) <= 0) {
                //Show an error message as Toast
                mySound.play(erroralertId, 1, 1, 1, 0, 1);
                Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                //exit this method early
                B.setInningScore(currentInning, 0);
                displayScore(B.getInningScore(currentInning), B.inningScoreView[currentInning]);
            }
        } else {
            delOnePoint(A);
            displayScore(A.getInningScore(currentInning), A.inningScoreView[currentInning]);
            calculateTotalScore();
            displayTotalScore(A.getScoreTeam(), totalScoreViewA);
            if (A.getInningScore(currentInning) <= 0) {
                //Show an error message as Toast
                mySound.play(erroralertId, 1, 1, 1, 0, 1);
                Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
                //exit this method early
                A.setInningScore(currentInning, 0);
                displayScore(A.getInningScore(currentInning), A.inningScoreView[currentInning]);
            }
        }

    }

    private void delOnePoint(Team t) {

        t.setInningScore(currentInning, t.getInningScore(currentInning) - 1);
        displayScore(t.getInningScore(currentInning), t.inningScoreView[currentInning]);

        if (t.getInningScore(currentInning) <= 0) {
            //Show an error message as Toast
            mySound.play(erroralertId, 1, 1, 1, 0, 1);
            Toast.makeText(this, getString(R.string.Toast1), Toast.LENGTH_SHORT).show();
            //exit this method early
            t.setInningScore(currentInning, 0);
            displayScore(t.getScoreTeam(), t.inningScoreView[currentInning]);
        }
    }

    public void doHomeRun(Team t) {

        t.setInningScore(currentInning, t.getInningScore(currentInning) + runner + 1);
        displayScore(t.getInningScore(currentInning), t.inningScoreView[currentInning]);
    }

    /**
     * Increase the score for homeruns to right Team.
     */
    public void homerun(View v) {
        mySound.play(batterhitId, 1, 1, 1, 0, 1);
        mySound.play(homerunId, 1, 1, 1, 0, 1);
        //check the current state before we display the screen
        if (turnSwitch.isChecked()) {
            doHomeRun(B);
            displayScore(B.getInningScore(currentInning), B.inningScoreView[currentInning]);
            calculateTotalScore();
            displayTotalScore(B.getScoreTeam(), totalScoreViewB);
        } else {
            doHomeRun(A);
            displayScore(A.getInningScore(currentInning), A.inningScoreView[currentInning]);
            calculateTotalScore();
            displayTotalScore(A.getScoreTeam(), totalScoreViewA);
        }

        runner = 0;
        displayRunners(runner, numberOfRunner);
        freeRunner = 0;
    }

    /**
     * This method is called when the plus button is clicked for Strikes.
     */
    public void incrementStrike(View view) {
        strikes = strikes + 1;
        displayStrikes(strikes, numberOfStrikes);
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
            foulBall = 0;
            out = out + 1;
            displayStrikes(strikes, numberOfStrikes);
            displayFoulball(foulBall, numberOfFoulBall);
            displayBalls(balls, numberOfBall);
            displayOut(out, numberOfOut);
            if (out == 3) {
                mySound.play(toggleId, 1, 1, 1, 0, 1);
                if (turnSwitch.isChecked()) {
                    turnSwitch.setChecked(false);
                    currentInning = currentInning + 1;
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
                foulBall = 0;
                balls = 0;
                runner = 0;
                freeRunner = 0;
                displayOut(out, numberOfOut);
                displayStrikes(strikes, numberOfStrikes);
                displayBalls(balls, numberOfBall);
                displayFoulball(foulBall, numberOfFoulBall);
                displayRunners(runner, numberOfRunner);
            }
        }
    }

    /**
     * This method is called when the minus button is clicked for Strikes.
     */
    public void decrementStrike(View view) {
        strikes = strikes - 1;
        displayStrikes(strikes, numberOfStrikes);
        if (strikes <= 0) {
            //Show an error message as Toast
            mySound.play(erroralertId, 1, 1, 1, 0, 1);
            Toast.makeText(this, getString(R.string.Toast2), Toast.LENGTH_SHORT).show();
            //exit this method early
            strikes = 0;
            displayStrikes(strikes, numberOfStrikes);
        }
    }

    /**
     * This method is called when the plus button is clicked for Foul Ball.
     */
    public void incrementFoulBall(View view) {
        mySound.play(foulballId, 1, 1, 1, 0, 1);
        foulBall = foulBall + 1;
        displayFoulball(foulBall, numberOfFoulBall);
        if (strikes < 2) {
            strikes = strikes + 1;
            displayStrikes(strikes, numberOfStrikes);
        }
    }

    /**
     * This method is called when the minus button is clicked for Strikes.
     */
    public void decrementFoulball(View view) {
        foulBall = foulBall - 1;
        displayFoulball(foulBall, numberOfFoulBall);
        if (foulBall <= 0) {
            //Show an error message as Toast
            mySound.play(erroralertId, 1, 1, 1, 0, 1);
            Toast.makeText(this, getString(R.string.Toast3), Toast.LENGTH_SHORT).show();
            //exit this method early
            foulBall = 0;
            displayFoulball(foulBall, numberOfFoulBall);
        }
    }

    /**
     * This method is called when the plus button is clicked for Balls.
     */
    public void incrementBall(View view) {
        balls = balls + 1;
        displayBalls(balls, numberOfBall);
        if (balls < 4) {
            mySound.play(ballId, 1, 1, 1, 0, 1);
        }
        if (balls == 4) {
            mySound.play(ball4Id, 1, 1, 1, 0, 1);
            freeRunner = freeRunner + 1;
            runner = runner + 1;
            displayRunners(runner, numberOfRunner);
            strikes = 0;
            displayStrikes(strikes, numberOfStrikes);
            foulBall = 0;
            displayFoulball(foulBall, numberOfFoulBall);
            balls = 0;
            displayBalls(balls, numberOfBall);
        }
        if ((freeRunner == 4) || (runner == 4)) {
            mySound.play(homerunId, 1, 1, 1, 0, 1);
            //check the current state before display on the screen
            if (turnSwitch.isChecked()) {
                addOnePoint(B);
                displayScore(B.getInningScore(currentInning), B.inningScoreView[currentInning]);
                calculateTotalScore();
                displayTotalScore(B.getScoreTeam(), totalScoreViewB);
            } else {
                addOnePoint(A);
                displayScore(A.getInningScore(currentInning), A.inningScoreView[currentInning]);
                calculateTotalScore();
                displayTotalScore(A.getScoreTeam(), totalScoreViewA);
            }
            runner = runner - 1;
            freeRunner = freeRunner - 1;
            displayRunners(runner, numberOfRunner);
        }
    }

    /**
     * This method is called when the minus button is clicked for Balls.
     */
    public void decrementBall(View view) {
        balls = balls - 1;
        displayBalls(balls, numberOfBall);
        if (balls <= 0) {
            //Show an error message as Toast
            mySound.play(erroralertId, 1, 1, 1, 0, 1);
            Toast.makeText(this, getString(R.string.Toast4), Toast.LENGTH_SHORT).show();
            //exit this method early
            balls = 0;
            displayBalls(balls, numberOfBall);
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
        displayOut(out, numberOfOut);
        displayRunners(runner, numberOfRunner);
        if (runner <= 0) {
            runner = 0;
            displayRunners(runner, numberOfRunner);
        }
        if (turnSwitch.isChecked()) {
            B.setOutTeam(B.getOutTeam() + 1);
        } else {
            A.setOutTeam(A.getOutTeam() + 1);
        }
        if (out == 3) {
            out = 0;
            strikes = 0;
            foulBall = 0;
            balls = 0;
            freeRunner = 0;
            runner = 0;
            displayOut(out, numberOfOut);
            displayStrikes(strikes, numberOfStrikes);
            displayFoulball(foulBall, numberOfFoulBall);
            displayBalls(balls, numberOfBall);
            displayRunners(runner, numberOfRunner);
            mySound.play(toggleId, 1, 1, 1, 0, 1);
            if (turnSwitch.isChecked()) {
                turnSwitch.setChecked(false);
                currentInning = currentInning + 1;
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
                disableButtons();
            }
        }
    }

    /**
     * This method is called when the minus button is clicked for Out.
     */
    public void decrementOut(View view) {
        out = out - 1;
        displayOut(out, numberOfOut);
        if (out <= 0) {
            //Show an error message as Toast
            mySound.play(erroralertId, 1, 1, 1, 0, 1);
            Toast.makeText(this, getString(R.string.Toast5), Toast.LENGTH_SHORT).show();
            //exit this method early
            out = 0;
            displayOut(out, numberOfOut);
        }
    }

    /**
     * Method to calculate Free Bases.
     */
    public void freeRunner(View v) {
        mySound.play(hbpId, 1, 1, 1, 0, 1);
        freeRunner = freeRunner + 1;
        runner = runner + 1;
        displayRunners(runner, numberOfRunner);
        strikes = 0;
        displayStrikes(strikes, numberOfStrikes);
        balls = 0;
        displayBalls(balls, numberOfBall);
        if (freeRunner == 4) {
            freeRunner = freeRunner - 1;
            runner = runner - 1;
            displayRunners(runner, numberOfRunner);
            mySound.play(homerunId, 1, 1, 1, 0, 1);
            //check the current state before display on the screen
            if (turnSwitch.isChecked()) {
                addOnePoint(B);
                displayScore(B.getInningScore(currentInning), B.inningScoreView[currentInning]);
                calculateTotalScore();
                displayTotalScore(B.getScoreTeam(), totalScoreViewB);
            } else {
                addOnePoint(A);
                displayScore(A.getInningScore(currentInning), A.inningScoreView[currentInning]);
                calculateTotalScore();
                displayTotalScore(A.getScoreTeam(), totalScoreViewA);
            }
        }
    }

    /**
     * Method to calculate men on Bases.
     */
    public void runner(View v) {
        mySound.play(batterhitId, 1, 1, 1, 0, 1);
        runner = runner + 1;
        displayRunners(runner, numberOfRunner);
        strikes = 0;
        displayStrikes(strikes, numberOfStrikes);
        foulBall = 0;
        displayFoulball(foulBall, numberOfFoulBall);
        balls = 0;
        displayBalls(balls, numberOfBall);
        if (runner <= 0) {
            runner = 0;
            displayRunners(runner, numberOfRunner);
        }
    }

    /**
     * Method to disable buttons - RESET only active.
     */
    private void disableButtons() {
        Button plusScore = (Button) findViewById(R.id.plus_score);
        plusScore.setEnabled(false);
        Button minusScore = (Button) findViewById(R.id.minus_score);
        minusScore.setEnabled(false);
        Button hbp = (Button) findViewById(R.id.hbp);
        hbp.setEnabled(false);
        Button batter = (Button) findViewById(R.id.batter);
        batter.setEnabled(false);
        Button homerun = (Button) findViewById(R.id.homerun);
        homerun.setEnabled(false);
        Button strikeP = (Button) findViewById(R.id.incrementStrike);
        strikeP.setEnabled(false);
        Button strikeM = (Button) findViewById(R.id.decrementStrike);
        strikeM.setEnabled(false);
        Button foulballP = (Button) findViewById(R.id.incrementFoulBall);
        foulballP.setEnabled(false);
        Button foulballM = (Button) findViewById(R.id.decrementFoulBall);
        foulballM.setEnabled(false);
        Button ballP = (Button) findViewById(R.id.incrementBall);
        ballP.setEnabled(false);
        Button ballM = (Button) findViewById(R.id.decrementBall);
        ballM.setEnabled(false);
        Button outP = (Button) findViewById(R.id.incrementOut);
        outP.setEnabled(false);
        Button outM = (Button) findViewById(R.id.decrementOut);
        outM.setEnabled(false);
        turnSwitch.setEnabled(false);
    }

    /**
     * Method to RESET.
     */
    public void reset(View v) {
        mySound.play(resetId, 1, 1, 1, 0, 1);
        A.setScoreTeam(0);
        displayScore(A.getScoreTeam(), totalScoreViewA);
        A.setInningScore(0, 0);
        displayScore(A.getInningScore(0), A.inningScoreView[0]);
        A.setInningScore(1, 0);
        displayScore(A.getInningScore(1), A.inningScoreView[1]);
        A.setInningScore(2, 0);
        displayScore(A.getInningScore(2), A.inningScoreView[2]);
        A.setInningScore(3, 0);
        displayScore(A.getInningScore(3), A.inningScoreView[3]);
        A.setInningScore(4, 0);
        displayScore(A.getInningScore(4), A.inningScoreView[4]);
        A.setInningScore(5, 0);
        displayScore(A.getInningScore(5), A.inningScoreView[5]);
        A.setInningScore(6, 0);
        displayScore(A.getInningScore(6), A.inningScoreView[6]);
        A.setInningScore(7, 0);
        displayScore(A.getInningScore(7), A.inningScoreView[7]);
        A.setInningScore(8, 0);
        displayScore(A.getInningScore(8), A.inningScoreView[8]);
        // Tracks the score for Team B
        B.setScoreTeam(0);
        displayTotalScore(B.getScoreTeam(), totalScoreViewB);
        B.setInningScore(0, 0);
        displayScore(B.getInningScore(0), B.inningScoreView[0]);
        B.setInningScore(1, 0);
        displayScore(B.getInningScore(1), B.inningScoreView[1]);
        B.setInningScore(2, 0);
        displayScore(B.getInningScore(2), B.inningScoreView[2]);
        B.setInningScore(3, 0);
        displayScore(B.getInningScore(3), B.inningScoreView[3]);
        B.setInningScore(4, 0);
        displayScore(B.getInningScore(4), B.inningScoreView[4]);
        B.setInningScore(5, 0);
        displayScore(B.getInningScore(5), B.inningScoreView[5]);
        B.setInningScore(6, 0);
        displayScore(B.getInningScore(6), B.inningScoreView[6]);
        B.setInningScore(7, 0);
        displayScore(B.getInningScore(7), B.inningScoreView[7]);
        B.setInningScore(8, 0);
        displayScore(B.getInningScore(8), B.inningScoreView[8]);
        // Tracks the Out for Team A
        A.setOutTeam(0);
        // Tracks the Out for Team B
        B.setOutTeam(0);
        strikes = 0;
        displayStrikes(strikes, numberOfStrikes);
        foulBall = 0;
        displayFoulball(foulBall, numberOfFoulBall);
        balls = 0;
        displayBalls(balls, numberOfBall);
        out = 0;
        displayOut(out, numberOfOut);
        freeRunner = 0;
        runner = 0;
        displayRunners(runner, numberOfRunner);
        turnSwitch.setChecked(false);
        currentInning = 0;

        Button plusScore = (Button) findViewById(R.id.plus_score);
        plusScore.setEnabled(true);
        Button minusScore = (Button) findViewById(R.id.minus_score);
        minusScore.setEnabled(true);
        Button hbp = (Button) findViewById(R.id.hbp);
        hbp.setEnabled(true);
        Button batter = (Button) findViewById(R.id.batter);
        batter.setEnabled(true);
        Button homerun = (Button) findViewById(R.id.homerun);
        homerun.setEnabled(true);
        Button strikeP = (Button) findViewById(R.id.incrementStrike);
        strikeP.setEnabled(true);
        Button strikeM = (Button) findViewById(R.id.decrementStrike);
        strikeM.setEnabled(true);
        Button foulballP = (Button) findViewById(R.id.incrementFoulBall);
        foulballP.setEnabled(true);
        Button foulballM = (Button) findViewById(R.id.decrementFoulBall);
        foulballM.setEnabled(true);
        Button ballP = (Button) findViewById(R.id.incrementBall);
        ballP.setEnabled(true);
        Button ballM = (Button) findViewById(R.id.decrementBall);
        ballM.setEnabled(true);
        Button outP = (Button) findViewById(R.id.incrementOut);
        outP.setEnabled(true);
        Button outM = (Button) findViewById(R.id.decrementOut);
        outM.setEnabled(true);
        turnSwitch.setEnabled(true);
    }

    /**
     * Displays the given Strikes.
     */
    public void displayStrikes(int strikes, TextView numberOfStrikes) {
        numberOfStrikes.setText(String.valueOf(strikes));
    }

    /**
     * Displays the given Foulballs.
     */
    public void displayFoulball(int foulball, TextView numberOfFoulBall) {
        numberOfFoulBall.setText(String.valueOf(foulball));
    }

    /**
     * Displays the given Balls.
     */
    public void displayBalls(int balls, TextView numberOfBall) {
        numberOfBall.setText(String.valueOf(balls));
    }

    /**
     * Displays the given Out.
     */
    public void displayOut(int out, TextView numberOfOut) {
        numberOfOut.setText(String.valueOf(out));
    }

    /**
     * Displays the given Runners.
     */
    public void displayRunners(int runner, TextView numberOfRunner) {
        numberOfRunner.setText(String.valueOf(runner));
    }

    /**
     * Displays the given Inning Score.
     */
    public void displayScore(int score, TextView scoreView) {
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given Team Score.
     */
    public void displayTotalScore(int score, TextView scoreView) {
        scoreView.setText(String.valueOf(score));
    }
}