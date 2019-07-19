package com.random.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText number1,number2;
    TextView number;
    Button click_to_random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ánh xạ
        number = (TextView)findViewById(R.id.TextView_number);
        number1 = (EditText)findViewById(R.id.EditText_number1);
        number2 = (EditText) findViewById(R.id.EditText_number2);
        click_to_random = (Button)findViewById(R.id.Button_random);

        click_to_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1,num2;
                // lấy 2 chuỗi trong các edittext
                String numstr1 = number1.getText().toString().trim();

                String numstr2 = number2.getText().toString().trim();

                if(numstr1.length()>0 && numstr2.length()>0)// kiểm tra đã nhập chưa
                {
                    // chuyển chuỗi thành int
                    num2 = Integer.parseInt(numstr2);
                    num1 = Integer.parseInt(numstr1);

                    if(num2>=num1)// số thứ hai phải lớn hơn số thứ nhất
                    {
                        int temp;
                        Random random = new Random();
                        //thực hiện random
                        temp= random.nextInt(num2 - num1 +1 ) + num1;
                        number.setText(temp+"");

                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "The second number have to greater than the first one", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please enter all of two numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
