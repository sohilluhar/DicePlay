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

    Button btnplayer1,btnplayer2;
    ImageView imgp1d1,imgp1d2,imgp2d1,imgp2d2;
    TextView tvp1,tvp2,txtp1score,txtp2score;

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



        btnplayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1=true;
                Log.d("p1c",p1c+"");
                if(p1c==p2c||p1c+1==p2c){
                p1c++;

                scorep1=10;
                check();
                }
                Log.d("p1c",p1c+"");
            }
        });

        btnplayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                player2=true;
                Log.d("p2count",p2c+"");
                if(p1c==p2c||p2c+1==p1c){
                p2c++;

                scorep2=6;
                check();
                }
            }
        });

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

                p1=new StringBuffer("Score: ");
                p2=new StringBuffer("Score:");
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


                p1=new StringBuffer("Score: ");
                p2=new StringBuffer("Score:");
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
