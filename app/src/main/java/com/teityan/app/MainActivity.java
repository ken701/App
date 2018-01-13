package com.teityan.app;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

   TextView test;
    EditText editText;
    Random b;
    int A;
    int B;
    int c;
    int d;
    int e;
    Chronometer chronometer;
    Button f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test=(TextView)findViewById(R.id.test);
        editText=(EditText)findViewById(R.id.editText);
        chronometer=(Chronometer) findViewById(R.id.chronometer2);
        f=(Button)findViewById(R.id.button);
        chronometer.start();
        c=S();



        //TextViewに出る

        //ログに出る
        Log.d("test","test");
        //画面に一時出来に出る(上から順番に)
        //短い
        Toast("start!");
        //長い
        //Toast.makeText(this,"test",Toast.LENGTH_LONG).show();
    }
    public void o(View v){
        if(c==1000){
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            f.setText("確定");
            c=S();

        }
        String text=null;
      text = editText.getText().toString();
        if(text.length() == 0 ) {
        Toast.makeText(this,"何も入力されていません。",Toast.LENGTH_SHORT).show();

        }else{
        int x=Integer.valueOf(text);
        // 取得したテキストを TextView に張り付ける
        if(c==x){
            Toast("正解！");
            c=S();
            editText.setText("");;
        }
        else {
            Toast("不正解...");
            e++;
            editText.setText("");

        }
        }



    }
    public int S()
    {
        int results;
        d++;
        if(d<10){
        b=new Random();
        A=b.nextInt(9);
        A++;
        B=b.nextInt(9);
        B++;
        test.setText(A+"×"+B+"=？");
        results=A*B;
        }
        else {
            d = 0;
            test.setText("不正解数は"+e+"問です");
            f.setText("もう一度チャレンジ");
            chronometer.stop();

            e=0;
            results=1000;
        }

        return results;
    }
    public void Toast(String text)
    {
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
    }
    }
