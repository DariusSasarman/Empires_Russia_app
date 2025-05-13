package com.example.slider;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar_main;
    TextView scris;
    TextView patrundere_siberia;
    Button buton_chestionar;
    Button Rusia_Kieveana_lectie;
    Button Rusia_Kieveana_lectie_2;
    Button Moscova_lectie;
    Button Petru_cel_mare_buton;
    Button Ecaterina_cea_mare_buton;
    Button rusia_bolsevica;
    Button ussr;
    Button rusia_de_azi;
    Button sursa;
    int status;
    LinearLayout backgroundImagine;

    ScrollView scrollView;
    HorizontalScrollView horizontalScrollView;

    int[] background_imagine ={
            R.drawable.i0,
            R.drawable.i1,
            R.drawable.i2,
            R.drawable.i3,
            R.drawable.i4,
            R.drawable.i5,
            R.drawable.i6,
            R.drawable.i7,
            R.drawable.i8,
            R.drawable.i9,
            R.drawable.i10
    };

    public void mergem(int ind){
        Intent intent;
        intent = new Intent(this,error.class);
        if(ind == 0)
        {
            intent = new Intent(this, Surse.class);
        }
        else if(ind == 1)
        {
            intent = new Intent(this, Lectie_1.class);
        }
        else if(ind == 2)
        {
            intent = new Intent(this, Lectie_2.class);
        }
        else if(ind == 3)
        {
            intent = new Intent(this, Lectie_3.class);
        }
        else if(ind == 4)
        {
            intent = new Intent(this, Lectie_4.class);
        }
        else if(ind == 5)
        {
            intent = new Intent(this, Lectie_5.class);
        }
        else if(ind == 6)
        {
            intent = new Intent(this, Lectie_6.class);
        }
        else if(ind == 7)
        {
            intent = new Intent(this, Lectie_7.class);
        }
        else if(ind == 8)
        {
            intent = new Intent(this, Lectie_8.class);
        }
        startActivity(intent);
    }
    public void mergem_chestionar(){
        Intent intent;
        if(status == 0 || status == 1)
        {
            intent = new Intent(this, chestionarCod_1.class);
        }
        else if(status == 2)
        {
            intent = new Intent(this,chestionarCod_2.class);
        }
        else if(status == 3)
        {
            intent = new Intent(this,chestionarCod_3.class);
        }
        else if(status == 4 || status == 5)
        {
            intent = new Intent(this,chestionarCod_4.class);
        }
        else if(status == 6)
        {
            intent = new Intent(this,chestionarCod_5.class);
        }
        else
        {
            intent = new Intent(this,error.class);
        }
        startActivity(intent);
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        scrollView=(ScrollView) findViewById(R.id.sv);
        horizontalScrollView=(HorizontalScrollView)findViewById(R.id.hsv);
        seekBar_main = (SeekBar)findViewById(R.id.seekBar);
        seekBar_main.setMax(7);
        seekBar_main.refreshDrawableState();
        buton_chestionar=(Button)findViewById(R.id.button_chestionar);
        sursa =(Button)findViewById(R.id.surse);
        scris = (TextView)findViewById(R.id.textView1);
        patrundere_siberia = (TextView)findViewById(R.id.scris_capitol4);
        backgroundImagine = (LinearLayout) findViewById(R.id.background);
        backgroundImagine.setBackground(getResources().getDrawable(background_imagine[status]));
        Rusia_Kieveana_lectie = (Button)findViewById(R.id.button1);
        Rusia_Kieveana_lectie_2=(Button)findViewById(R.id.button2);
        Moscova_lectie=(Button)findViewById(R.id.button3);
        Petru_cel_mare_buton=(Button)findViewById(R.id.button4);
        Ecaterina_cea_mare_buton=(Button)findViewById(R.id.button5);
        rusia_bolsevica =(Button)findViewById(R.id.button6);
        ussr = (Button)findViewById(R.id.button7);
        rusia_de_azi = (Button)findViewById(R.id.button8);


        seekBar_main.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                status = seekBar_main.getProgress();
                backgroundImagine.setBackground(getResources().getDrawable(background_imagine[status]));
                status++;
                scris.setText("Capitol " + status);
                status--;
                buton_chestionar.setVisibility(View.VISIBLE);
                Rusia_Kieveana_lectie.setVisibility(View.GONE);
                Rusia_Kieveana_lectie_2.setVisibility(View.GONE);
                Moscova_lectie.setVisibility(View.GONE);
                Petru_cel_mare_buton.setVisibility(View.GONE);
                patrundere_siberia.setVisibility(View.GONE);
                Ecaterina_cea_mare_buton.setVisibility(View.GONE);
                rusia_bolsevica.setVisibility(View.GONE);
                ussr.setVisibility(View.GONE);
                rusia_de_azi.setVisibility(View.GONE);
                if(status == 0)
                {
                    scrollView.scrollTo(200,1400);
                    horizontalScrollView.scrollTo(200,1400);
                    Rusia_Kieveana_lectie.setVisibility(View.VISIBLE);}
                else if(status == 1)
                {
                    scrollView.scrollTo(200,1100);
                    horizontalScrollView.scrollTo(200,1100);
                    Rusia_Kieveana_lectie_2.setVisibility(View.VISIBLE);}
                else if(status == 2)
                {
                    scrollView.scrollTo(700,1100);
                    horizontalScrollView.scrollTo(700,1100);
                    Moscova_lectie.setVisibility(View.VISIBLE);
                }
                else if(status == 3)
                {
                    scrollView.scrollTo(700,1100);
                    horizontalScrollView.scrollTo(700,1100);
                    Petru_cel_mare_buton.setVisibility(View.VISIBLE);
                    patrundere_siberia.setVisibility(View.VISIBLE);
                }
                else if(status == 4){
                    scrollView.scrollTo(300,1500);
                    horizontalScrollView.scrollTo(300,1500);
                    Ecaterina_cea_mare_buton.setVisibility(View.VISIBLE);
                }
                else if(status == 5){
                    scrollView.scrollTo(200,1500);
                    horizontalScrollView.scrollTo(200,1500);
                    rusia_bolsevica.setVisibility(View.VISIBLE);
                }
                else if(status == 6)
                {
                    scrollView.scrollTo(1300,1200);
                    horizontalScrollView.scrollTo(1300,1200);
                    ussr.setVisibility(View.VISIBLE);
                }
                else if(status == 7)
                {
                    scrollView.scrollTo(300,1500);
                    horizontalScrollView.scrollTo(300,1500);
                    rusia_de_azi.setVisibility(View.VISIBLE);
                    buton_chestionar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                backgroundImagine.setBackground(getResources().getDrawable(background_imagine[status]));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                backgroundImagine.setBackground(getResources().getDrawable(background_imagine[status]));
            }
        });
        Rusia_Kieveana_lectie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mergem(1);
            }
        });

        Rusia_Kieveana_lectie_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mergem(2);
            }
        });

        buton_chestionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mergem_chestionar();
            }
        });

        Moscova_lectie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mergem(3);
            }
        });

        Petru_cel_mare_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mergem(4);
            }
        });

        Ecaterina_cea_mare_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mergem(5);
            }
        });

        rusia_bolsevica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mergem(6);
            }
        });

        ussr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mergem(7);
            }
        });

        sursa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mergem(0);
            }
        });
        rusia_de_azi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mergem(8);
            }
        });

        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(200,1400);
                horizontalScrollView.scrollTo(200,1400);
            }
        });

        horizontalScrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(200,1400);
                horizontalScrollView.scrollTo(200,1400);
            }
        });
    }
}