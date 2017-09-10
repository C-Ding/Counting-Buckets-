package waysionanalytics.counter;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    TextView myTV;
    Button button2Pointer;
    Button buttonReset;
    Button button3Pointer;
    Button StartTimer;
    Button StopTimer;
    TextView TimerView;
    int tapCount;
    TextView Message;
    ProgressBar mProgressbar;
    CountDownTimer mCountDownTimer;

    int timer= 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartTimer = (Button) findViewById(R.id.StartTimer);
        StopTimer = (Button) findViewById(R.id.StopTimer);
        myTV= (TextView) findViewById(R.id.myTV);
        button2Pointer = (Button) findViewById(R.id.Button1);
        buttonReset = (Button) findViewById(R.id.button2);
        button3Pointer = (Button) findViewById(R.id.button3);
        Message = (TextView) findViewById(R.id.MessageBox);
        mProgressbar = (ProgressBar) findViewById(R.id.mProgressbar);
        mProgressbar.setProgress(timer);
        TimerView = (TextView) findViewById(R.id.TiemrView);

        tapCount = 0;

        StartTimer.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v){
              mCountDownTimer.start();
          }

        });



            mCountDownTimer = new CountDownTimer(10000,100) { //(howl ong we want it to run, interval)
                @Override
                public void onTick(long millisUntilFinished) {
                TimerView.setText(String.format("Time Elasped", timer));
                timer++;
                }
                @Override
                public void onFinish() {

                }
            };





        buttonReset.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                tapCount= 0;
                Message.setText("Start Again");
                myTV.setText(String.format("%d Points", tapCount));
                //timer= 0;
            }
        });

        button2Pointer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // tapCount++;
                Message.setText("2PT");
                myTV.setText(String.format("%d Points", tapCount+= 2));
            }

        });

        button3Pointer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Message.setText("3PT");
                myTV.setText(String.format("%d Points", tapCount+= 3));

            }
        });



}}


