package com.example.slider;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

class Chestionar_4 {
    public static String[] question ={
            "Când și cum a ajuns Ecaterina cea Mare împărăteasă?",
            "La ce a contribuit cel mai mult Ecaterina cea Mare?",
            "Cine a inițiat Tripla Alianță?",
            "De ce a fost considerat Alexandru I învingător al lui Napoleon?",
            "De la ce se datorau revoltele de la începutul domniei lui Nicolae I?",
            "Când și cum s-a finalizat războiul Crimeii?",
            "Care a fost cel mai promițător progres în timpul lui Alexandru al II-lea?",
            "Când a fost asasinat Alexandru al II-lea?",
            "Care a fost scopul reformelor interne ale lui Alexandru al III-lea?",
            "Ce a adus Rusiei tratatul cu China din 1893?",
            "Care este tragedia de la încoronarea lui Nicolae al II-lea?",
            "Când a luat sfârșit dinastia Romanovilor?"
    };


    public static String[][] choices ={
            {"În 1762,cu permisiunea soțului ei","În 1752, după moartea soțului său","În 1762, contribuind la moartea soțului său","În 1862, asasinându-și soțul"},
            {"La expansiunea teritorială","La educarea populației","La lupta împotriva bolilor","La renașterea nobilimii rusești"},
            {"Alexandru I","Alexandru II","Alexandru III","Alexandru IV"},
            {"Datorită faptului că n-a pierdut","Datorită campaniei inițiate de el din Rusia, în 1812","Datorită campaniei inițiate de el din Rusia, în 1912","Datorită Triplei Alianțe"},
            {"Se datorau războaielor împotriva Imperiului Otoman","Se datorau războiului Crimeii","Se datorau războaielor napoleoniene","Se datorau războaielor ruso-persane"},
            {"În 1956, cu înfrângerea Imperiului Otoman","În 1956, cu înfrângerea Rusiei","În 1856, cu înfrângerea Imperiului Otoman","În 1856, cu înfrângerea Rusiei"},
            {"Programul de construcție al căilor ferate","Programul de construcție a palatelor","Programul de distrugere a inamicilor","Programul de construcție al bazelor navale"},
            {"1982","1981","1881","1882"},
            {"Să dezvolte liberalizarea care a avut loc sub domnia tatălui său","Să inverseze liberalizarea care a avut loc sub domnia tatălui său","Să oprească liberalizarea care a avut loc sub domnia tatălui său","Să inverseze suprimarea care a avut loc sub domnia tatălui său"},
            {"O parte din Polul Nord","O parte din Polonia","O parte din Japonia","O parte din Turkestanul chinez"},
            {"Moartea a 1400 de ruși","Moartea soției sale","Dispariția a 1302 de ruși","Împiedicarea sa înainte de încoronare"},
            {"În noaptea de 16 spre 17 iunie 1918","În noaptea de 26 spre 27 iulie 1918","În noaptea de 16 spre 17 iulie 1928","În noaptea de 16 spre 17 iulie 1918"}
    };

    public static String[] correctAnswers ={
            "În 1762, contribuind la moartea soțului său",
            "La renașterea nobilimii rusești",
            "Alexandru I",
            "Datorită campaniei inițiate de el din Rusia, în 1812",
            "Se datorau războaielor napoleoniene",
            "În 1856, cu înfrângerea Rusiei",
            "Programul de construcție al căilor ferate",
            "1881",
            "Să inverseze liberalizarea care a avut loc sub domnia tatălui său",
            "O parte din Turkestanul chinez",
            "Moartea a 1400 de ruși",
            "În noaptea de 16 spre 17 iulie 1918"
    };

}


public class chestionarCod_4 extends AppCompatActivity implements View.OnClickListener{


    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;
    int score= 0;
    int totalQuestion = com.example.slider.Chestionar_4.question.length;
    int currentQuestion=0;
    String selectedAnswer ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chestionar_cod4);

        questionTextView =(TextView) findViewById(R.id.question);
        ansA = (Button) findViewById(R.id.ans_A);
        ansB = (Button) findViewById(R.id.ans_B);
        ansC = (Button) findViewById(R.id.ans_C);
        ansD = (Button) findViewById(R.id.ans_D);
        submitBtn = (Button) findViewById(R.id.submit_btn);


        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);


        loadNewQuestion();
    }


    void loadNewQuestion() {

        if (currentQuestion == totalQuestion) {
            finishQuiz();
            return;
        }
        questionTextView.setText(com.example.slider.Chestionar_4.question[currentQuestion]);
        ansA.setText(com.example.slider.Chestionar_4.choices[currentQuestion][0]);
        ansB.setText(com.example.slider.Chestionar_4.choices[currentQuestion][1]);
        ansC.setText(com.example.slider.Chestionar_4.choices[currentQuestion][2]);
        ansD.setText(com.example.slider.Chestionar_4.choices[currentQuestion][3]);
    }
    void finishQuiz()
    {
        String passStatus;
        if(score > totalQuestion * 0.5) {
            passStatus = "Felicitări! Testul a fost trecut!";
        }else {
            passStatus = "Din păcate, nu ai reușit să treci testul.";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Ai luat " + score +" puncte din " + totalQuestion)
                .setPositiveButton("Restart",((dialogInterface, i) -> restartQuiz()))
                .setCancelable(false)
                .show();
    }

    void restartQuiz(){
        score = 0;
        currentQuestion=0;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);
        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn)
        {
            if(selectedAnswer.equals(com.example.slider.Chestionar_4.correctAnswers[currentQuestion]))
            {
                score++;
            }
            currentQuestion++;
            loadNewQuestion();
        }
        else
        {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.YELLOW);

        }
    }
}



















