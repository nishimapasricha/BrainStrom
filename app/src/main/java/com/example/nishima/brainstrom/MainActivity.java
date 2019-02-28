package com.example.nishima.brainstrom;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
TextView txt;
    TextView txt1;
    TextView txt2;
    TextView txt3;
int rightloc,no_of_question=0,score=0,done=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView ed=(TextView) findViewById(R.id.textView);
        ed.setText("Instruction                               In this game you will get 60 seconds. In which you have to do caculations and get more and more scores ");
        generate();
    }
    public void start(final View view)
    {
        RelativeLayout rel=(RelativeLayout) findViewById(R.id.init);
        rel.setVisibility(View.INVISIBLE);
       RelativeLayout relative=(RelativeLayout) findViewById(R.id.rel);
        relative.setVisibility(View.VISIBLE);
        txt2=(TextView)findViewById(R.id.textView2);
        txt1=(TextView)findViewById(R.id.textView4);
        new CountDownTimer(60000,1000)
        {

            @Override
            public void onTick(long millisUntilFinished) {
                txt2.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {

                txt1.setText("Done "+"your score is "+score+"/"+(no_of_question));
                score=0;
                no_of_question=0;

                txt2=(TextView)findViewById(R.id.textView2);
                txt1=(TextView)findViewById(R.id.textView4);
              //  txt1.setText("");
                done=1;
                Button bt2=(Button)findViewById(R.id.button6);
                bt2.setVisibility(view.VISIBLE);
            }
        }.start();
    }
 public void generate()

 {
     no_of_question++;
     ArrayList<Integer> answer=new ArrayList<Integer>();
     txt=(TextView) findViewById(R.id.ques);
     Button b0=(Button)findViewById(R.id.button2);
     Button b1=(Button)findViewById(R.id.button4);
     Button b2=(Button)findViewById(R.id.button5);
     Button b3=(Button)findViewById(R.id.button3);

     Random ran=new Random();
     int a=ran.nextInt(100);

     int b=ran.nextInt(100);
     while(a<b)
     {
       a=ran.nextInt(100);
     }

  //   System.out.print("hello");
     String[] op= {"+","-","*","/"};
     int d=ran.nextInt(4);
     txt.setText(Integer.toString(a)+op[d]+Integer.toString(b));
int ans=0;
     rightloc=ran.nextInt(4);
     for(int i=0;i<4;i++)
     {//System.out.print("hello");

         if(i==rightloc)
         {
            if(op[d]=="+")
            {answer.add(a+b);
            ans=a+b;}
            else if(op[d]=="-") {
                answer.add(a - b);
                ans=a-b;
            }
            else if(op[d]=="*"){
                answer.add(a*b);
            ans=a*b;}
            else if(op[d]=="/") {
                answer.add(a / b);
                ans=a/b;
            }


         }
         else
         {  System.out.println(ans);
             int r=ran.nextInt(1000);
             //int r=ran.nextInt((ans - min) + 1) + min;
           while(r==ans){
               r=ran.nextInt(1000);
             }
             answer.add(r);
         }
     }
//System.out.print("hello"+answer.get(0));

     b0.setText(Integer.toString(answer.get(0)));
     b1.setText(Integer.toString(answer.get(1)));
     b2.setText(Integer.toString(answer.get(2)));
     b3.setText(Integer.toString(answer.get(3)));



 }

    public void set(View view) {
        txt1=(TextView)findViewById(R.id.textView4);
        txt3=(TextView)findViewById(R.id.textView3);
         //  Log.i(view.getTag().toString(),Integer.toString(rightloc));
if(done==0)
{ if(Integer.parseInt(view.getTag().toString())==rightloc)
            {
                txt1.setText("CORRECT");
                score++;

                txt3.setText(score+"/"+no_of_question);
                generate();
            }
            else
            {
                txt1.setText("Wrong");

                generate();
                txt3.setText(score+"/"+no_of_question);
            }

    }}

    public void playagain(final View view) {
        score=0;
        no_of_question=0;
        done=0;
        txt2=(TextView)findViewById(R.id.textView2);
        txt1=(TextView)findViewById(R.id.textView4);
        txt1.setText("");
        Button bt2=(Button)findViewById(R.id.button6);

        bt2.setVisibility(view.INVISIBLE);
        generate();
        new CountDownTimer(60000,1000)
        {

            @Override
            public void onTick(long millisUntilFinished) {
                txt2.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {

                txt1.setText("Done "+"your score is "+score+"/"+no_of_question);
                score=0;
                no_of_question=0;

                txt2=(TextView)findViewById(R.id.textView2);
                txt1=(TextView)findViewById(R.id.textView4);
              //  txt1.setText("");
                done=1;
                Button bt2=(Button)findViewById(R.id.button6);
                bt2.setVisibility(view.VISIBLE);
            }
        }.start();

    }
}
