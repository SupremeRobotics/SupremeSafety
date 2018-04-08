package ca.northviewheights.robotics.supremesafety;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;

public class Quiz extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public int qNum = 1;
    public int whichOne;
    public int score = 0;
    char[] answers = {'a', 'd', 'd', 'd', 'a', 'b', 'd', 'b', 'a', 'c'};
    String [] answers2 = {"Vent out the air into the atmosphere", "Feet planted, back straight, lifting with leg power, and keeping close to the robot.",
            "Purple", "Non-metallic, leak-proof container.", "Check to make sure that all articles on the robot are secure.",
            "Coming out to the field with purple lights", "None of the above", "1 Person",
            "Remove it from service, and inform the safety captain and mentor", "Eknoor Singh"};

    public String [] optionsA = {"Vent out the air into the atmosphere", "Feet planted, back straight, lifting with arm power, and keeping close to the robot.",
            "Yellow", "Safety Bucket", "Check to make sure that all articles on the robot are secure.",
            "Relieve all stored energy and open the main circuit braker on the robot", "Granola bars", "2 People",
            "Remove it from service, and inform the safety captain and mentor", "Mithil Kumar"};
    public String [] optionsB = {"Leave the air compressed inside", "Start with a curved back, and slowly straighten out lifting the robot, while attempting to jump.",
            "Amber", "Plastic Bag", "Check to make sure that the robot is on.",
            "Coming out to the field with purple lights", "Tinfoil wrapped food", "1 Person",
            "Inform the UL safety advisor", "Vedant Shah"};
    public String [] optionsC = {"Poke a hole into a pneumatics tubing to release air", "Feet planted, back curved, lifting with leg power, and keeping close to the robot.",
            "Blue", "Metallic, leak-proof container.", "Check to make sure that the wheels are not scuffed up.",
            "Remove debris from the playing field", "Closed container food", "5 People",
            "Remove it from service, do NOT inform anyone", "Eknoor Singh"};
    public String [] optionsD = {"None of the above", "Feet planted, back straight, lifting with leg power, and keeping close to the robot.",
            "Purple", "Non-metallic, leak-proof container.", "Make sure that the robot's laces are tied.",
            "Use the \"Pre-Lift\", and \"During the Lift\" procedures", "None of the above", "7 People",
            "Inform the mentor", "Allan Thoms"};
    public String [][] options = {optionsA, optionsB, optionsC, optionsD};

    ArrayList<Integer> order = new ArrayList<Integer>();
    ArrayList<Integer> optOrder = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Futura.ttf");
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setTypeface(typeface);
        Button buttonG = (Button) findViewById(R.id.button5);
        buttonG.setTypeface(typeface);
        Button buttonH = (Button) findViewById(R.id.button20);
        buttonH.setTypeface(typeface);
        Button buttonI = (Button) findViewById(R.id.button21);
        buttonI.setTypeface(typeface);
        Button buttonJ = (Button) findViewById(R.id.button22);
        buttonJ.setTypeface(typeface);

        for (int i = 0; i < 10; i++){
            order.add(i);
        }
        for (int i = 0; i < 4; i++){
            optOrder.add(i);
        }
        Collections.shuffle(optOrder);
        Collections.shuffle(order);
        whichOne = order.get(0);

        TextView qNumberComp = (TextView) findViewById(R.id.textView);
        qNum = 1;
        score = 0;
        qNumberComp.setText(qNum + "/10");
        TextView qNumber = (TextView) findViewById(R.id.textView3);
        qNumber.setText("Question " + qNum);
        drawImage(whichOne+1);

        Button buttonA = (Button) findViewById(R.id.button22);
        Button buttonB = (Button) findViewById(R.id.button21);
        Button buttonC = (Button) findViewById(R.id.button20);
        Button buttonD = (Button) findViewById(R.id.button5);
        String a = options[optOrder.get(0)][whichOne];
        String b = options[optOrder.get(1)][whichOne];
        String c = options[optOrder.get(2)][whichOne];
        String d = options[optOrder.get(3)][whichOne];
        buttonA.setText(a);
        buttonB.setText(b);
        buttonC.setText(c);
        buttonD.setText(d);
    }

    public void goToActivity1 (View view){
        String temp = options[optOrder.get(0)][whichOne];
        if (temp.equals(answers2[whichOne])){
            score++;
        }
        qNum++;
        if (qNum < 11)
            whichOne = order.get(qNum-1);
        updateStuff();
    }

    public void goToActivity2 (View view){
        String temp = options[optOrder.get(1)][whichOne];
        if (temp.equals(answers2[whichOne])){
            score++;
        }
        qNum++;
        if (qNum < 11)
            whichOne = order.get(qNum-1);
        updateStuff();
    }

    public void goToActivity3 (View view){
        String temp = options[optOrder.get(2)][whichOne];
        if (temp.equals(answers2[whichOne])){
            score++;
        }
        qNum++;
        if (qNum < 11)
            whichOne = order.get(qNum-1);
        updateStuff();
    }

    public void goToActivity4 (View view){
        String temp = options[optOrder.get(3)][whichOne];
        if (temp.equals(answers2[whichOne])){
            score++;
        }
        qNum++;
        if (qNum < 11)
            whichOne = order.get(qNum-1);
        updateStuff();
    }

    public void updateStuff(){
        if (qNum == 11){
            Intent intent = new Intent (this, Results.class);
            intent.putExtra(EXTRA_MESSAGE, score);
            startActivity(intent);
            qNum = 1;
            score = 0;
            Collections.shuffle(order);
            whichOne = order.get(0);
        }
        drawImage(whichOne+1);
        TextView qNumberComp = (TextView) findViewById(R.id.textView);
        qNumberComp.setText(qNum + "/10");
        TextView qNumber = (TextView) findViewById(R.id.textView3);
        qNumber.setText("Question " + qNum);

        Collections.shuffle(optOrder);
        Button buttonA = (Button) findViewById(R.id.button22);
        Button buttonB = (Button) findViewById(R.id.button21);
        Button buttonC = (Button) findViewById(R.id.button20);
        Button buttonD = (Button) findViewById(R.id.button5);
        String a = options[optOrder.get(0)][whichOne];
        String b = options[optOrder.get(1)][whichOne];
        String c = options[optOrder.get(2)][whichOne];
        String d = options[optOrder.get(3)][whichOne];
        buttonA.setText(a);
        buttonB.setText(b);
        buttonC.setText(c);
        buttonD.setText(d);

        if (whichOne == 1){
            buttonA.setTextSize(12);
            buttonB.setTextSize(12);
            buttonC.setTextSize(12);
            buttonD.setTextSize(12);
        }
        else{
            buttonA.setTextSize(14);
            buttonB.setTextSize(14);
            buttonC.setTextSize(14);
            buttonD.setTextSize(14);
        }
    }

    public void drawImage(int whichOne2){
        ImageView disQuestion = (ImageView) findViewById(R.id.imageView);
        if (whichOne2 == 1){
            disQuestion.setImageResource(R.drawable.q1);
        }
        else if (whichOne2 == 2){
            disQuestion.setImageResource(R.drawable.q2);
        }
        else if (whichOne2 == 3){
            disQuestion.setImageResource(R.drawable.q3);
        }
        else if (whichOne2 == 4){
            disQuestion.setImageResource(R.drawable.q4);
        }
        else if (whichOne2 == 5){
            disQuestion.setImageResource(R.drawable.q5);
        }
        else if (whichOne2 == 6){
            disQuestion.setImageResource(R.drawable.q6);
        }
        else if (whichOne2 == 7){
            disQuestion.setImageResource(R.drawable.q7);
        }
        else if (whichOne2 == 8){
            disQuestion.setImageResource(R.drawable.q8);
        }
        else if (whichOne2 == 9){
            disQuestion.setImageResource(R.drawable.q9);
        }
        else if (whichOne2 == 10){
            disQuestion.setImageResource(R.drawable.q10);
        }
    }
}
