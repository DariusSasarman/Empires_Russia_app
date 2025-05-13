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

class Chestionar_2 {
    public static String[] question ={
            "Cine „a pus temelia orașului Moscova”?",
            "Sub conducerea cui a fost cucerită Moscova în decembrie 1237?",
            "Cine a convins capul Bisericii Ortodoxe Ruse să locuiască în Moscova?",
            "Cine a eliberat Moscova de sub puterea mongolilor?",
            "Cine a fost desemnat la tron la 3 ani?",
            "De unde i se trage numele de Groaznic al lui Ivan al IV-lea?",
            "Cât a durat masacrul din Novgorod?",
            "Când a cucerit Ivan cel Groaznic orașul Poloțk?",
            "Cine a urmat după Ivan cel Groaznic?",
            "Câți oameni au murit în Moscova între anii 1601 și 1603?"
    };


    public static String[][] choices ={
            {"Cneazul Ivan","Cneazul Dolgoruki","Cneazul Vladimir","Cneazul din Reazan"},
            {"Sub conducerea lui Batu-Khan","Sub conducerea lui Tabu-Khan","Sub conducerea lui Ghenghis-Khan","Sub conducerea lui Tuba-Khan"},
            {"Ivan cel Drept","Ivan cel Mare","Ivan Kalita","Ivan cel Groaznic"},
            {"Ivan cel Drept","Ivan cel Mare","Ivan Kalita","Ivan cel Groaznic"},
            {"Ivan cel Drept","Ivan cel Mare","Ivan Kalita","Ivan cel Groaznic"},
            {"Datorită poreclei folosite de oamenii de atunci","Datorită masacrului din Novgorod","Datorită atitudinii sale","Datorită masacrului din Pskov"},
            {"Cinci săptămâni","Cinci zile","Șase săptamâni","Cinci săptămâni și cinci zile"},
            {"1558","1554","1552","1563"},
            {"Fyodor Mikhailovich Dostoevsky","Feodor Ivanovici","Feodor Makhnov","Fyodor III Alekseyevich"},
            {"aproape 300 000","peste 120 000","sub 120 000","aproximativ 50 000"}
    };

    public static String[] correctAnswers ={
            "Cneazul Dolgoruki",
            "Sub conducerea lui Batu-Khan",
            "Ivan Kalita",
            "Ivan cel Mare",
            "Ivan cel Groaznic",
            "Datorită masacrului din Novgorod",
            "Cinci săptămâni",
            "1563",
            "Feodor Ivanovici",
            "peste 120 000"
    };

}


public class chestionarCod_2 extends AppCompatActivity implements View.OnClickListener{


    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;
    int score= 0;
    int totalQuestion = com.example.slider.Chestionar_2.question.length;
    int currentQuestion=0;
    String selectedAnswer ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chestionar_cod2);

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
        questionTextView.setText(com.example.slider.Chestionar_2.question[currentQuestion]);
        ansA.setText(com.example.slider.Chestionar_2.choices[currentQuestion][0]);
        ansB.setText(com.example.slider.Chestionar_2.choices[currentQuestion][1]);
        ansC.setText(com.example.slider.Chestionar_2.choices[currentQuestion][2]);
        ansD.setText(com.example.slider.Chestionar_2.choices[currentQuestion][3]);
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
            if(selectedAnswer.equals(com.example.slider.Chestionar_2.correctAnswers[currentQuestion]))
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