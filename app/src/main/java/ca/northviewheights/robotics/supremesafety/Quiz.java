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
    char[] answers = {'a', 'd', 'd', 'd', 'a', 'b', 'd', 'b', 'a', 'c'};
    String [] optionsA = {"Vent out the air into the atmosphere", "Feet planted, back straight, lifting with arm power, and keeping close to the robot.",
            "Yellow", "Safety Bucket", "Check to make sure that all articles on the robot are secure.",
            "Relieve all stored energy and open the main circuit braker on the robot", "Granola bars", "2 People",
            "Remove it from service, and inform the safety captain and mentor", "Mithil Kumar"};
    String [] optionsB = {"Leave the air compressed inside", "Start with a curved back, and slowly straighten out lifting the robot, while attempting to jump.",
            "Amber", "Plastic Bag", "Check to make sure that the robot is on.",
            "Coming out to the field with purple lights", "Tinfoil wrapped food", "1 Person",
            "Inform the UL safety advisor", "Vedant Shah"};
    String [] optionsC = {"Poke a hole into a pneumatics tubing to release air", "Feet planted, back curved, lifting with leg power, and keeping close to the robot.",
            "Blue", "Metallic, leak-proof container.", "Check to make sure that the wheels are not scuffed up.",
            "Remove debris from the playing field", "Closed container food", "5 People",
            "Remove it from service, do NOT inform anyone", "Eknoor Singh"};
    String [] optionsD = {"None of the above", "Feet planted, back straight, lifting with leg power, and keeping close to the robot.",
            "Purple", "Non-metallic, leak-proof container.", "Make sure that the robot's laces are tied.",
            "Use the \"Pre-Lift\", and \"During the Lift\" procedures", "None of the above", "7 People",
            "Inform the mentor", "Allan Thoms"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView qNumberComp = (TextView) findViewById(R.id.textView);
        qNum = 1;
        score = 0;
        qNumberComp.setText(qNum + "/10");
        TextView qNumber = (TextView) findViewById(R.id.textView3);
        qNumber.setText("Question " + qNum);
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
        qNumber.setText("Question " + qNum);
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
