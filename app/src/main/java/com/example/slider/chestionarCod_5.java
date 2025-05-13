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

class Chestionar_5 {
    public static String[] question ={
            "Când a avut loc insurecția declanșată de partidul bolșevic condus de Lenin?",
            "Când a avut loc proclamația Uniunii Republicilor Sovietice Socialiste?",
            "Care era obiectivul URSS?",
            "În ce an a murit Vladimir Lenin?",
            "Cine a urmat la conducere după Vladimir Lenin?",
            "În ce constă Războiul Rece?",
            "În ce an a murit Stalin?",
            "Cine a fost ultimul lider al URSS?",
            "Când a devenit Mihail Gorbaciov secretar general al PCUS?",
            "Când a încetat să mai existe Uniunea Sovietică?"
    };


    public static String[][] choices ={
            {"În noaptea de 6 spre 7 noiembrie 1917","În noaptea de 7 spre 8 noiembrie 1917","În noaptea de 6 spre 7 noiembrie 1918","În noaptea de 6 spre 7 decembrie 1917"},
            {"30 octombrie 1922","30 noiembrie 1922","30 ianuarie 1923","30 decembrie 1922"},
            {"Înfângerea capitalismului","Transcenderea particularităților naționale prin crearea „omului sovietic”","Instaurarea comunismului","Să urmeze ideile lui Lenin"},
            {"1924","1923","1934","1922"},
            {"J.F. Kennedy","K. Marx","A. Hitler","I.V.Stalin"},
            {"O ceartă dintre America și Rusia","Un război pe timpul iernii","O perioadă de tensiuni și confruntări politice","Un război ce a avut loc în Siberia"},
            {"1988","1989","1952","1953"},
            {"Leonid Brezhnev","Mihail Gorbaciov","Yuri Andropov","Konstantin Cernenko"},
            {"13 martie 1985","11 martie 1995","11 martie 1985","11 martie 1995"},
            {"26 decembrie 1991","16 decembrie 1989","16 decembrie 1986","26 decembrie 1981"}
    };

    public static String[] correctAnswers ={
            "În noaptea de 6 spre 7 noiembrie 1917",
            "30 decembrie 1922",
            "Transcenderea particularităților naționale prin crearea „omului sovietic”",
            "1924",
            "I.V.Stalin",
            "O perioadă de tensiuni și confruntări politice",
            "1953",
            "Mihail Gorbaciov",
            "11 martie 1985",
            "26 decembrie 1991"
    };

}


public class chestionarCod_5 extends AppCompatActivity implements View.OnClickListener{


    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;
    int score= 0;
    int totalQuestion = com.example.slider.Chestionar_5.question.length;
    int currentQuestion=0;
    String selectedAnswer ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chestionar_cod5);

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
        questionTextView.setText(com.example.slider.Chestionar_5.question[currentQuestion]);
        ansA.setText(com.example.slider.Chestionar_5.choices[currentQuestion][0]);
        ansB.setText(com.example.slider.Chestionar_5.choices[currentQuestion][1]);
        ansC.setText(com.example.slider.Chestionar_5.choices[currentQuestion][2]);
        ansD.setText(com.example.slider.Chestionar_5.choices[currentQuestion][3]);
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
            if(selectedAnswer.equals(com.example.slider.Chestionar_5.correctAnswers[currentQuestion]))
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