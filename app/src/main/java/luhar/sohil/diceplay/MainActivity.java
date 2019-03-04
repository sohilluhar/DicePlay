package luhar.sohil.diceplay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    boolean player1,player2;
    int scorep1,scorep2;
    int finscrp1,finscrp2;

    String win="Win";
    String lose="Lose";
    String tie="Tie";
    String wait="Wait...";


    StringBuffer p1;
    StringBuffer p2;

    int p1c,p2c;

    int dicearr[]={
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
    };

    Button btnplayer1,btnplayer2;
    ImageView imgp1d1,imgp1d2,imgp2d1,imgp2d2;
    TextView tvp1,tvp2,txtp1score,txtp2score,p1dscore,p2dscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1=false;
        player2=false;

        finscrp1=0;
        finscrp2=0;
        p1c=0;
        p2c=0;

        btnplayer1=(Button)findViewById(R.id.btnPlayer1);
        btnplayer2=(Button)findViewById(R.id.btnPlayer2);
        txtp1score=(TextView)findViewById(R.id.p1score);
        txtp2score=(TextView)findViewById(R.id.p2score);

        imgp1d1=(ImageView)findViewById(R.id.p1d1);
        imgp1d2=(ImageView)findViewById(R.id.p1d2);
        imgp2d1=(ImageView)findViewById(R.id.p2d1);
        imgp2d2=(ImageView)findViewById(R.id.p2d2);


        tvp1=(TextView) findViewById(R.id.status1);
        tvp2=(TextView) findViewById(R.id.status2);
        p1dscore=(TextView) findViewById(R.id.p1dscore);
        p2dscore=(TextView) findViewById(R.id.p2dscore);



        btnplayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1=true;

                if(p1c==p2c||p1c+1==p2c){
                p1c++;
                rolldice1();
                check();
                }

            }
        });

        btnplayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                player2=true;

                if(p1c==p2c||p2c+1==p1c){
                p2c++;
                rolldice2();
                check();
                }
            }
        });

    }

    private void rolldice1() {
        Random num=new Random();
        int d1=num.nextInt(6);
        int d2=num.nextInt(6);
        scorep1=d1+d2;

        String temp="Score: "+(scorep1+2);
        p1dscore.setText(temp);
        imgp1d1.setImageResource(dicearr[d1]);
        imgp1d2.setImageResource(dicearr[d2]);
    }

    private void rolldice2() {
        Random num=new Random();
        int d1=num.nextInt(6);
        int d2=num.nextInt(6);
        scorep2=d1+d2;
        String temp="Score: "+(scorep2+2);
        p2dscore.setText(temp);
        imgp2d1.setImageResource(dicearr[d1]);
        imgp2d2.setImageResource(dicearr[d2]);
    }

    private void check() {
        if(p1c>p2c)
        {
            tvp1.setText(wait);
        }

        if(p2c>p1c){
            tvp2.setText(wait);
        }

        if(player1 && player2 && p1c==p2c) {
            if (scorep1 > scorep2) {
                finscrp1++;

                p1=new StringBuffer("Total Win: ");
                p2=new StringBuffer("Total Win: ");
                p1.append(finscrp1);
                p2.append(finscrp2);


                tvp1.setText(win);
                tvp2.setText(lose);

                txtp1score.setText(p1);
                txtp2score.setText(p2);
            }

            else if (scorep2==scorep1){
                tvp1.setText(tie);
                tvp2.setText(tie);
            }
            else{

                finscrp2++;


                p1=new StringBuffer("Total Win: ");
                p2=new StringBuffer("Total Win: ");
                p1.append(finscrp1);
                p2.append(finscrp2);

                tvp1.setText(lose);
                tvp2.setText(win);

                txtp1score.setText(p1);
                txtp2score.setText(p2);

            }
            player1=false;
            player2=false;
        }


    }
}
