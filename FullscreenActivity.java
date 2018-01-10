package com.example.a24107.computeapplication2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends Activity {

    private static String suanshi = "";

    private TextView textView;

    private int kuohaocount = 0;

    private Button buttonC;
    private Button buttonkuo;
    private Button buttonpercent;
    private Button buttonchu;
    private Button button7;
    private Button button9;
    private Button button8;
    private Button buttonX;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button buttonjian;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button buttonplus;
    private Button buttonfu;
    private Button button0;
    private Button buttondot;
    private Button buttonequal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        textView = (TextView)findViewById(R.id.textView2);

        buttonC = (Button)findViewById(R.id.buttonC);
        buttonkuo = (Button)findViewById(R.id.buttonkuo);
        buttonpercent = (Button)findViewById(R.id.buttonpercent);
        buttonchu = (Button)findViewById(R.id.buttonchu);
        button7 = (Button)findViewById(R.id.button7);
        button9 = (Button)findViewById(R.id.button9);
        button8 = (Button)findViewById(R.id.button8);
        buttonX = (Button)findViewById(R.id.buttonX);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        buttonjian = (Button)findViewById(R.id.buttonjian);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        buttonplus = (Button)findViewById(R.id.buttonplus);
        buttonfu = (Button)findViewById(R.id.buttonfu);
        button0 = (Button)findViewById(R.id.button0);
        buttondot = (Button)findViewById(R.id.buttondot);
        buttonequal = (Button)findViewById(R.id.buttonequal);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strcombine("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strcombine("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strcombine("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                strcombine("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strcombine("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strcombine("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strcombine("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strcombine("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strcombine("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strcombine("9");
            }
        });

        buttondot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strcombine(".");
            }
        });

        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strcombine("+");
            }
        });

        buttonjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strcombine("-");
            }
        });

        buttonchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strcombine("÷");
            }
        });

        buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strcombine("×");
            }
        });

        buttonpercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strcombine("%");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strclean();
            }
        });

        buttonkuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kuohao();
            }
        });

        buttonequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suanshi = StrToNum.LeftToRightCompute(textView.getText().toString());
                float answer = Float.parseFloat(suanshi);
                if(answer == (int)answer){ //不是小数就把'.0'去掉
                    suanshi = (int)answer+"";
                }
                    textView.setText(suanshi);
            }
        });

        System.out.println(suanshi.length());
    }

    public void strcombine(String str){
        suanshi = suanshi+str;
        textView.setText(suanshi);
    }

    public void strclean(){
        suanshi="";
        textView.setText(suanshi);
    }

    public void kuohao(){
        if (suanshi.length()>0) {

            if (Objects.equals(suanshi.substring(suanshi.length() - 1), "1") ||
                    Objects.equals(suanshi.substring(suanshi.length() - 1), "2") ||
                    Objects.equals(suanshi.substring(suanshi.length() - 1), "3") ||
                    Objects.equals(suanshi.substring(suanshi.length() - 1), "4") ||
                    Objects.equals(suanshi.substring(suanshi.length() - 1), "5") ||
                    Objects.equals(suanshi.substring(suanshi.length() - 1), "6") ||
                    Objects.equals(suanshi.substring(suanshi.length() - 1), "7") ||
                    Objects.equals(suanshi.substring(suanshi.length() - 1), "8") ||
                    Objects.equals(suanshi.substring(suanshi.length() - 1), "9") ||
                    Objects.equals(suanshi.substring(suanshi.length() - 1), "10")) {
                if (kuohaocount >= 1) {
                    kuohaocount--;
                    strcombine(")");
                }
            } else if (Objects.equals(suanshi.substring(suanshi.length() - 1), ")") && (kuohaocount > 0)) {
                kuohaocount--;
                strcombine(")");
            } else if (Objects.equals(suanshi.substring(suanshi.length() - 1), "(")) {
                kuohaocount++;
                strcombine("(");
            } else if (suanshi.substring(suanshi.length() - 1).equals("×") ||
                    Objects.equals(suanshi.substring(suanshi.length() - 1), "÷") ||
                    Objects.equals(suanshi.substring(suanshi.length() - 1), "+") ||
                    Objects.equals(suanshi.substring(suanshi.length() - 1), "-")) {
                kuohaocount++;
                strcombine("(");
            }
        }
        else if (suanshi.length()==0){
            kuohaocount++;
            strcombine("(");
        }
    }
}
