package luhar.sohil.diceplay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean player1,player2;
    int scorep1,scorep2;
    int finscrp1,finscrp2;

    StringBuffer p1;
    StringBuffer p2;

    int p1c,p2c;

    Button btnplayer1,btnplayer2,txtp1score,txtp2score;
    ImageView imgp1d1,imgp1d2,imgp2d1,imgp2d2;

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
        txtp1score=(Button)findViewById(R.id.p1score);
        txtp2score=(Button)findViewById(R.id.p2score);

        imgp1d1=(ImageView)findViewById(R.id.p1d1);
        imgp1d2=(ImageView)findViewById(R.id.p1d2);
        imgp2d1=(ImageView)findViewById(R.id.p2d1);
        imgp2d2=(ImageView)findViewById(R.id.p2d2);

        btnplayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1=true;

                p1c++;
                scorep1=10;
                check();
            }
        });

        btnplayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player2=true;

                p2c++;
                scorep2=6;
                check();
            }
        });

    }

    private void check() {
        if(p1c>p2c)
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Wait for Player 2 ", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);

                       toast.show();
        }

        if(p2c>p1c){
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "Wait for player 1", Toast.LENGTH_SHORT);
        toast1.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

        toast1.show();}

        if(player1 && player2 && p1c==p2c) {
            if (scorep1 > scorep2) {
                finscrp1++;

                p1=new StringBuffer("Score: ");
                p2=new StringBuffer("Score:");
                p1.append(finscrp1);
                p2.append(finscrp2);

                Toast toast = Toast.makeText(getApplicationContext(),
                        "YOU WIN", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);

                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "YOU LOSE", Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

                toast.show();
                toast1.show();


                txtp1score.setText(p1);
                txtp2score.setText(p2);
            }

            else if (scorep2==scorep1){

                Toast toast = Toast.makeText(getApplicationContext(),
                        "YOU WIN", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);


                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "ITS TIE", Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast1.show();
                toast.show();
            }
            else{

                finscrp2++;


                p1=new StringBuffer("Score: ");
                p2=new StringBuffer("Score:");
                p1.append(finscrp1);
                p2.append(finscrp2);


                Toast toast = Toast.makeText(getApplicationContext(),
                        "YOU WIN", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);

                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "YOU WIN", Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast1.show();
                toast.show();

                txtp1score.setText(p1);
                txtp2score.setText(p2);

            }
            player1=false;
            player2=false;
        }


    }

    private class CustomTextView extends View {
        private int m_nColor;
        private Typeface m_tTypeface;
        private int m_nSize;
        private int m_nRotationAngle, m_nRotationW, m_nRotationH;
        private String m_szText;

        public CustomTextView(Context context) {
            super(context);
            // set default parameters
            m_nColor = Color.WHITE;
            m_nSize = 14;
            m_nRotationAngle = 0;
            m_nRotationW = 0;
            m_nRotationH = 0;
            m_tTypeface = Typeface.create("arial", Typeface.NORMAL);
        }

        public void SetColor(int newcolor) {
            m_nColor = newcolor;
            this.invalidate();
        }

        public void SetTextSize(int newsize) {
            m_nSize = newsize;
            this.invalidate();
        }

        //style: normal-0,bold-1,italic-2,bold-italic-3,
        public void SetFont(String newfontface, int style) {
            m_tTypeface = Typeface.create(newfontface, style);
            this.invalidate();
        }
        public void SetRotation(int newangle, int neww, int newh) {
            m_nRotationAngle = newangle;
            m_nRotationW = neww;
            m_nRotationH = newh;
            this.invalidate();
        }
        public void SetText(String newtext) {
            m_szText = newtext;
            this.invalidate();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setTypeface(m_tTypeface);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(m_nColor);
            //paint.setShadowLayer(1, 0, 1, Color.parseColor("#000000"));
            paint.setTextSize(m_nSize);
            canvas.rotate(m_nRotationAngle,m_nRotationW,m_nRotationH);
            canvas.drawText(m_szText, 0, 0, paint);
            super.onDraw(canvas);
        }
    }
}
