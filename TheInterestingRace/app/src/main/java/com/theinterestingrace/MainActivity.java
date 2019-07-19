package com.theinterestingrace;

import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    CheckBox cb_player1,cb_player2, cb_player3;
    SeekBar sb_player1,sb_player2, sb_player3;
    ImageView iv_play;
    TextView tv_point;
    Button bt_continue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();// hàm thực hiện ánh xạ

        // cài đặt để không thao tác được với seekbar --> tránh gian lận
        sb_player1.setEnabled(false);
        sb_player2.setEnabled(false);
        sb_player3.setEnabled(false);
        ///////////////////////////////
        // ẩn nút Continue trước khi bắt đầu
        bt_continue.setVisibility(View.INVISIBLE);

        final CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                int goal = sb_player1.getMax();

                // thuật toán chính của chương trình
                Random random = new Random();
                sb_player1.setProgress(sb_player1.getProgress()+random.nextInt(10));
                sb_player2.setProgress(sb_player2.getProgress()+random.nextInt(10));
                sb_player3.setProgress(sb_player3.getProgress()+random.nextInt(10));

                int chosen = isChosen();
                if(sb_player1.getProgress()>=goal && chosen ==1)
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "You are winner\n The turtle win", Toast.LENGTH_SHORT).show();
                    tv_point.setText(Integer.parseInt(tv_point.getText().toString())+10+"");
                    bt_continue.setVisibility(View.VISIBLE);
                }
                if(sb_player2.getProgress()>=goal && chosen ==2)
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "You are winner \n The buffalo win", Toast.LENGTH_SHORT).show();
                    tv_point.setText(Integer.parseInt(tv_point.getText().toString())+10+"");
                    bt_continue.setVisibility(View.VISIBLE);
                }
                if(sb_player3.getProgress()>=goal && chosen ==3)
                {
                    this.cancel();

                    Toast.makeText(MainActivity.this, "You are winner \n The bird win", Toast.LENGTH_SHORT).show();
                    bt_continue.setVisibility(View.VISIBLE);
                    tv_point.setText(Integer.parseInt(tv_point.getText().toString())+10+"");
                }
                if((sb_player1.getProgress()>=goal && chosen !=1)||(sb_player2.getProgress()>=goal && chosen !=2)||(sb_player3.getProgress()>=goal && chosen != 3))
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "You are loser", Toast.LENGTH_SHORT).show();
                    bt_continue.setVisibility(View.VISIBLE);
                    tv_point.setText(Integer.parseInt(tv_point.getText().toString())-10+"");
                }

            }

            @Override
            public void onFinish() {

            }
        };
        iv_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isChosen() != 0) {
                    if(Integer.parseInt(tv_point.getText().toString())<=0)
                    {
                        // nếu điểm âm thì đặt lại như ban đầu
                        Toast.makeText(MainActivity.this, "You lost all of your point\n This is new game", Toast.LENGTH_SHORT).show();
                        tv_point.setText("100");
                    }
                    iv_play.setVisibility(View.INVISIBLE);
                    bt_continue.setVisibility(View.INVISIBLE);

                    // khi bắt đầu chơi thì chặn người dùng thao tác checkbox và seekbar --. tránh việc người dùng chọn lại
                    disable();
                    //

                    countDownTimer.start();

                }
                else// nếu như chưa chọn con vật nào để đua
                    Toast.makeText(MainActivity.this, "Please choose a animal", Toast.LENGTH_SHORT).show();
            }
        });

        bt_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mỗi khi nhấn button Continue --> đặt các con vật về vị trí xuất phát
                sb_player1.setProgress(0);
                sb_player2.setProgress(0);
                sb_player3.setProgress(0);
                // cho phép thao tác với checkbox để chọn con vật
                enable();

                // hiện button play và ẩn button Continue
                iv_play.setVisibility(View.VISIBLE);
                bt_continue.setVisibility(View.INVISIBLE);
            }
        });

        // check nếu chọn checkbox này thì hủy chọn 2 checkbox còn lại
        cb_player1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    cb_player2.setChecked(false);
                    cb_player3.setChecked(false);
                }
            }
        });
        cb_player2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    cb_player3.setChecked(false);
                    cb_player1.setChecked(false);
                }
            }
        });
        cb_player3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    cb_player2.setChecked(false);
                    cb_player1.setChecked(false);
                }
            }
        });

    }
    private void mapping()
    {
        cb_player1 = (CheckBox)findViewById(R.id.CheckBox_player1);
        cb_player2 = (CheckBox)findViewById(R.id.CheckBox_player2);
        cb_player3 = (CheckBox)findViewById(R.id.CheckBox_player3);

        sb_player1 = (SeekBar)findViewById(R.id.SeekBar_player1);
        sb_player2 = (SeekBar)findViewById(R.id.SeekBar_player2);
        sb_player3 = (SeekBar)findViewById(R.id.SeekBar_player3);

        tv_point = (TextView)findViewById(R.id.TextView_point);
        iv_play = (ImageView)findViewById(R.id.ImageView_play);

        bt_continue = (Button)findViewById(R.id.Button_continue);
    }
    // trả về lựa chọn của người chơi
    private int isChosen()
    {
        if(cb_player1.isChecked())
            return 1;
        if(cb_player2.isChecked())
            return 2;
        if(cb_player3.isChecked())
            return 3;
        return 0;
    }
    //hàm chặn thao tác
    private void disable()
    {
        cb_player1.setEnabled(false);
        cb_player2.setEnabled(false);
        cb_player3.setEnabled(false);
    }

    // hàm cho phép thao tác
    private void enable()
    {
        cb_player1.setEnabled(true);
        cb_player2.setEnabled(true);
        cb_player3.setEnabled(true);

    }
}
