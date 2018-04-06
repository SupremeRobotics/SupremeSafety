package ca.northviewheights.robotics.supremesafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public int qNum = 1;
    public int score = 0;
    char[] answers = {'a', 'a', 'c', 'd', 'b', 'a', 'a', 'd', 'c', 'c'};
    String [] optionsA = {"ayyye1", "ayyye2", "ayyye3", "ayyye4", "ayyye5",
            "ayyye11", "ayyye12", "ayyye13", "ayyye14", "ayyye15"};
    String [] optionsB = {"boooo1", "boooo2", "boooo3", "boooo4", "boooo5",
            "boooo11", "boooo12", "boooo13", "boooo14", "boooo15"};
    String [] optionsC = {"coool1", "coool2", "coool3", "coool4", "coool5",
            "coool11", "coool12", "coool13", "coool14", "coool15"};
    String [] optionsD = {"dopeyq", "dopeyw", "dopeye", "dopeyr", "dopeyt",
            "dopeya", "dopeys", "dopeyd", "dopeyf", "dopeyg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView qNumberComp = (TextView) findViewById(R.id.textView);
        qNum = 1;
        score = 0;
        qNumberComp.setText(qNum + "/10");
        TextView qNumber = (TextView) findViewById(R.id.textView3);
        qNumber.setText("Question" + qNum);
        ImageView disQuestion = (ImageView) findViewById(R.id.imageView);
        disQuestion.setImageResource(R.drawable.q1);

        Button buttonA = (Button) findViewById(R.id.button22);
        Button buttonB = (Button) findViewById(R.id.button21);
        Button buttonC = (Button) findViewById(R.id.button20);
        Button buttonD = (Button) findViewById(R.id.button5);
        buttonA.setText(optionsA[qNum-1]);
        buttonB.setText(optionsB[qNum-1]);
        buttonC.setText(optionsC[qNum-1]);
        buttonD.setText(optionsD[qNum-1]);
    }

    public void goToActivity1 (View view){
        if ('a' == answers[qNum-1]){
            score++;
        }
        qNum++;
        updateStuff();
    }

    public void goToActivity2 (View view){
        if ('b' == answers[qNum-1]){
            score++;
        }
        qNum++;
        updateStuff();
    }

    public void goToActivity3 (View view){
        if ('c' == answers[qNum-1]){
            score++;
        }
        qNum++;
        updateStuff();
    }

    public void goToActivity4 (View view){
        if ('d' == answers[qNum-1]){
            score++;
        }
        qNum++;
        updateStuff();
    }

    public void updateStuff(){
        if (qNum == 11){
            Intent intent = new Intent (this, Results.class);
            intent.putExtra(EXTRA_MESSAGE, score);
            startActivity(intent);
            qNum = 1;
            score = 0;
        }
        drawImage();
        TextView qNumberComp = (TextView) findViewById(R.id.textView);
        qNumberComp.setText(qNum + "/10");
        TextView qNumber = (TextView) findViewById(R.id.textView3);
        qNumber.setText("Question" + qNum);
        Button buttonA = (Button) findViewById(R.id.button22);
        Button buttonB = (Button) findViewById(R.id.button21);
        Button buttonC = (Button) findViewById(R.id.button20);
        Button buttonD = (Button) findViewById(R.id.button5);
        buttonA.setText(optionsA[qNum-1]);
        buttonB.setText(optionsB[qNum-1]);
        buttonC.setText(optionsC[qNum-1]);
        buttonD.setText(optionsD[qNum-1]);
    }

    public void drawImage(){
        ImageView disQuestion = (ImageView) findViewById(R.id.imageView);
        if (qNum == 1){
            disQuestion.setImageResource(R.drawable.q1);
        }
        else if (qNum == 2){
            disQuestion.setImageResource(R.drawable.q2);
        }
        else if (qNum == 3){
            disQuestion.setImageResource(R.drawable.q3);
        }
        else if (qNum == 4){
            disQuestion.setImageResource(R.drawable.q4);
        }
        else if (qNum == 5){
            disQuestion.setImageResource(R.drawable.q5);
        }
        else if (qNum == 6){
            disQuestion.setImageResource(R.drawable.q6);
        }
        else if (qNum == 7){
            disQuestion.setImageResource(R.drawable.q7);
        }
        else if (qNum == 8){
            disQuestion.setImageResource(R.drawable.q8);
        }
        else if (qNum == 9){
            disQuestion.setImageResource(R.drawable.q9);
        }
        else if (qNum == 10){
            disQuestion.setImageResource(R.drawable.q10);
        }
    }
}
