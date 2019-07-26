package com.ldh.android.easygame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    TextView app_name,point,clock, question;
    Button ansA, ansB, ansC, ansD;

    ArrayList<C_Text_Question> listQuestion;
    Random random;
    C_Text_Question C_question;
    CountDownTimer countDownTimer;
    Handler handler;

    Intent intent;

    MediaPlayer mp3_true, mp3_false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        mapping();
        Play();

        countDownTimer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {
                clock.setText(Integer.parseInt(clock.getText().toString()) - 1+"");
            }

            @Override
            public void onFinish() {
            }
        };
        countDownTimer.start();
        ansA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(C_question.getTrue_Ans()==1)
                {
                    ansA.setBackgroundResource(R.drawable.custom_correctly_button);
                    mp3_true.start();

                    point.setText(Integer.parseInt(point.getText().toString())+1+"");
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ansA.setBackgroundResource(R.drawable.custom_ans_button);
                            Play();
                        }
                    },500);
                }
                else
                {
                    ansB.setBackgroundResource(R.drawable.custom_wrong_button);
                    mp3_false.start();

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(intent);
                            finish();
                        }
                    },2000);
                }
            }
        });

        ansB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (C_question.getTrue_Ans() == 2)
                {
                    ansB.setBackgroundResource(R.drawable.custom_correctly_button);
                    mp3_true.start();
                    point.setText(Integer.parseInt(point.getText().toString())+1+"");

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ansB.setBackgroundResource(R.drawable.custom_ans_button);
                            Play();
                        }
                    },500);
                }
                else
                {
                    ansB.setBackgroundResource(R.drawable.custom_wrong_button);
                    mp3_false.start();

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(intent);
                            finish();
                        }
                    },2000);
                }
            }
        });

        ansC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(C_question.getTrue_Ans()==3)
                {
                    ansC.setBackgroundResource(R.drawable.custom_correctly_button);
                    mp3_true.start();
                    point.setText(Integer.parseInt(point.getText().toString())+1+"");

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ansC.setBackgroundResource(R.drawable.custom_ans_button);
                            Play();
                        }
                    },500);
                }
                else {
                    ansC.setBackgroundResource(R.drawable.custom_wrong_button);
                    mp3_false.start();

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(intent);
                            finish();
                        }
                    },2000);
                }

            }
        });

        ansD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(C_question.getTrue_Ans()==4)
                {
                    ansD.setBackgroundResource(R.drawable.custom_correctly_button);
                    mp3_true.start();
                    point.setText(Integer.parseInt(point.getText().toString())+1+"");

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ansD.setBackgroundResource(R.drawable.custom_ans_button);
                            Play();
                        }
                    },500);
                }
                else
                {
                    ansD.setBackgroundResource(R.drawable.custom_wrong_button);
                    mp3_false.start();

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(intent);
                            finish();
                        }
                    },2000);
                }
            }
        });

    }



    private void Play()
    {
        // tìm câu hỏi khác
        int index = random.nextInt(listQuestion.size());
        C_question = listQuestion.get(index);
        question.setText(C_question.getQuestion());
        ansA.setText(C_question.getAns_A());
        ansB.setText(C_question.getAns_B());
        ansC.setText(C_question.getAns_C());
        ansD.setText(C_question.getAns_D());
    }


    private void mapping()
    {
        app_name = (TextView)findViewById(R.id.TextView_appname);
        point = (TextView)findViewById(R.id.TextView_pointInt);
        clock = (TextView)findViewById(R.id.TextView_clock);
        question = (TextView)findViewById(R.id.TextView_question);

        ansA = (Button)findViewById(R.id.Button_ansA);
        ansB = (Button)findViewById(R.id.Button_ansB);
        ansC = (Button)findViewById(R.id.Button_ans_C);
        ansD = (Button)findViewById(R.id.Button_ans_D);


        listQuestion = new ArrayList<>();
        listQuestion.add(new C_Text_Question("Q2","A. 10","B.01", "C.02", "D.4",1));
        listQuestion.add(new C_Text_Question("Q3","A. 10","B.01", "C.02", "D.4",2));
        listQuestion.add(new C_Text_Question("Q4","A. 10","B.01", "C.02", "D.4",3));

        random = new Random();
        intent = new Intent(PlayActivity.this, MainActivity.class);
        handler =  new Handler();

        mp3_false =  MediaPlayer.create(PlayActivity.this, R.raw.wrong_ans);
        mp3_true =  MediaPlayer.create(PlayActivity.this, R.raw.true_ans);
    }

}
