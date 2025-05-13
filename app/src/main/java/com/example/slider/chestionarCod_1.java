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

class Chestionar_1 {
    public static String[] question ={
            "Când a fost înființată Rusia Kieveana?",
            "Cine a fost Rurik?",
            "Cine a urmat la domnie după Rurik?",
            "În ce an și de către cine a fost adoptat creștinismul în Rusia Kieveană?",
            "Ce spunea Vladimir despre alcool?",
            "Cu ce a ajutat adoptarea creștinsimului?",
            "Unde au fost botezați rușii kieveni?",
            "Cine a fost Iaroslav cel Înțelept?",
            "Cum s-a numit codul de legi scris de Iaroslav?",
            "În ce an a primit Domnia lui Iaroslav o lovitură?"
    };


    public static String[][] choices ={
            {"987","978","879","798"},
            {"Primul cneaz al Rusiei Kieviene","Prima dinastie la conducerea Rusiei","Primul Țar al Rusiei Kieviene","Cel care a înființat Rusia Kieviana"},
            {"Cneazul Igor","Cneazul Oleg","Cneazul Sveatoslav","Cneazul Vladimir"},
            {"În anul 989 de către țarul Vladimir","În anul 988 de către cneazul Igor","În anul 889 de către cneazul Vladimir","În anul 988 de către cneazul Vladimir"},
            {"„Băutura este bucuria rusului”","„Am luat mai mult din alcool decât a luat alcoolul din mine”","„Refuz islamismul pentru că interzice alcoolul”","„Noi am făcut vodka”"},
            {"Cu educarea oamenilor din Rusia Kieveană","Cu întărirea relațiilor cu alte țări creștine","Cu zeități cărora să se închine, deoarece nu aveau înainte","Cu absolut nimic"},
            {"În apele râului Volga","În cea mai apropiată biserică de ei","În apele Mării Negre","În apele râului Nipru"},
            {"Fiul lui Vladimir","Nepotul lui Vladimir","Un înțelept","Fiul lui Oleg"},
            {"„Codex Theresianus”","„Mein Kampf”","„Ruskaia pravda”","„Codex Hammurapi”"},
            {"1042","1024","124","1240"}
    };

    public static String[] correctAnswers ={
            "879",
            "Primul cneaz al Rusiei Kieviene",
            "Cneazul Oleg",
            "În anul 988 de către cneazul Vladimir",
            "„Băutura este bucuria rusului”",
            "Cu întărirea relațiilor cu alte țări creștine",
            "În apele râului Nipru",
            "Fiul lui Vladimir",
            "„Ruskaia pravda”",
            "1024"
    };

}


public class chestionarCod_1 extends AppCompatActivity implements View.OnClickListener{


    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;
    int score= 0;
    int totalQuestion = Chestionar_1.question.length;
    int currentQuestion=0;
    String selectedAnswer ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chestionarcod1);

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
        questionTextView.setText(Chestionar_1.question[currentQuestion]);
        ansA.setText(Chestionar_1.choices[currentQuestion][0]);
        ansB.setText(Chestionar_1.choices[currentQuestion][1]);
        ansC.setText(Chestionar_1.choices[currentQuestion][2]);
        ansD.setText(Chestionar_1.choices[currentQuestion][3]);
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
            if(selectedAnswer.equals(Chestionar_1.correctAnswers[currentQuestion]))
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