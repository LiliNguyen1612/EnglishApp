package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String answer = "";

    TextView question;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    TextView result;
    TextView wrapContent;
    ImageView imageView;
    TextView clockText;
    ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cai dat ProgressBar
        progressBar = findViewById(R.id.progressBar);

        // Cai dat textView
        question = findViewById(R.id.textView);
        result = findViewById(R.id.result);
        wrapContent = findViewById(R.id.wrapContent);
        clockText = findViewById(R.id.clockText);

        // Cai dat Spannable
        String content = "Không chính xác\n" + "Trả lời đúng\n" + "WATCHES";
        SpannableString s = new SpannableString(content);
        s.setSpan(new StyleSpan(Typeface.BOLD),0,15,0);
        s.setSpan(new RelativeSizeSpan(1.25f),0,15,0);
        s.setSpan(new StyleSpan(Typeface.BOLD),16,28,0);

        // Cai dat icon
        imageView = findViewById(R.id.imageView);

        // Cai dat button 1 va su kien chon dap an
        button1 = findViewById(R.id.button);
        button1.setText("WATCHES");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer = "WATCHES";
            }
        });


        // Cai dat button 2 va su kien chon dap an
        button2 = findViewById(R.id.button2);
        button2.setText("LISTEN");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer = "LISTEN";
            }
        });


        // Cai dat button 3 va su kien chon dap an
        button3 = findViewById(R.id.button3);
        button3.setText("ARE");
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer = "ARE";
            }
        });


        // Cai dat button 4 va su kien chon dap an
        button4 = findViewById(R.id.button4);
        button4.setText("WATCH");
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer = "WATCH";
            }
        });

        // Cai dat button 5 va su kien kiem tra dap an va in ra ket qua
        button5 = findViewById(R.id.button5);
        button5.setText("CHECK");
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer.equals("WATCHES"))
                {
                    result.setText("Bạn đã trả lời đúng");
                    button5.setText("Next Question");
                    imageView.setVisibility(View.VISIBLE);
                }
                else if(answer.equals(""))
                {
                    result.setText("Bạn chưa chọn đáp án");
                }
                else
                {
                    result.setText(s);
                    button5.setText("Đã hiểu");
                    imageView.setVisibility(View.VISIBLE);
                }
            }
        });


        // Tao thanh chay thoi gian
        CountDownTimer countDownTimer1 = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                int current = progressBar.getProgress();
                if (current >= progressBar.getMax()) {
                    current = 0;
                }
                progressBar.setProgress(current + 1);
            }

            @Override
            public void onFinish() {
                // Chay lai tu dau
                this.start();

            }
        }.start();

        // Tao dong ho thoi gian
        CountDownTimer countDownTimer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                clockText.setText("" + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                clockText.setText("0");
                this.start();
            }
        }.start();
    }
}
