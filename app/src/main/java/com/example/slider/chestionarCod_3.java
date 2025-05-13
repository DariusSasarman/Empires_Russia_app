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

class Chestionar_3 {
    public static String[] question ={
            "Când a domnit Petru cel Mare?",
            "În ce perioadă a călătorit Petru cel Mare cu „Marea Ambasadă”?",
            "Ce meserie a avut Petru cel Mare sub numele de Piotr Mihailov?",
            "Cu ce s-a întors Petru cel Mare din occident?",
            "În ce an a fost fondat orașul Sankt Petersburg?",
            "Când a avut loc victoria de la Poltava?",
            "În ce an a devenit Sankt Petersburg capitala Rusiei?",
            "În ce an a fost întemeiată Academia de Ștințe?",
            "În ce zi a murit Petru cel Mare?",
            "Cine a urmat la conducere după Petru cel Mare?"
    };


    public static String[][] choices ={
            {"1582-1625","1683-1724","1682-1725","1684-1726"},
            {"1594-1597","1695-1698","1696-1699","1697-1700"},
            {"Arhitect","Profesor","Pescar","Tâmplar"},
            {"260 de cufere ce conțineau obiecte și un număr mare de experți tehnici și militari","260 de experți tehnici și militari și un număr mare de cufere ce conțineau obiecte","un număr mare de obiecte și experți","bogățiile obținute din salariul de meseria sa de tâmplar"},
            {"1673","1703","1602","1702"},
            {"1907","1703","1709","1790"},
            {"1712","1721","1713","1711"},
            {"1741","1711","1732","1724"},
            {"18 februarie 1725","19 ianuarie 1725","18 ianuarie 1723","18 ianuarie 1725"},
            {"Ecaterina Alekseevna","Ecaterina Varga","Ecaterina Teodoroiu","Ecaterina Howard"}
    };

    public static String[] correctAnswers ={
            "1682-1725",
            "1695-1698",
            "Tâmplar",
            "260 de cufere ce conțineau obiecte și un număr mare de experți tehnici și militari",
            "1703",
            "1709",
            "1712",
            "1724",
            "18 ianuarie 1725",
            "Ecaterina Alekseevna"
    };

}


public class chestionarCod_3 extends AppCompatActivity implements View.OnClickListener{


    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;
    int score= 0;
    int totalQuestion = com.example.slider.Chestionar_3.question.length;
    int currentQuestion=0;
    String selectedAnswer ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chestionar_cod3);

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
        questionTextView.setText(com.example.slider.Chestionar_3.question[currentQuestion]);
        ansA.setText(com.example.slider.Chestionar_3.choices[currentQuestion][0]);
        ansB.setText(com.example.slider.Chestionar_3.choices[currentQuestion][1]);
        ansC.setText(com.example.slider.Chestionar_3.choices[currentQuestion][2]);
        ansD.setText(com.example.slider.Chestionar_3.choices[currentQuestion][3]);
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
            if(selectedAnswer.equals(com.example.slider.Chestionar_3.correctAnswers[currentQuestion]))
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