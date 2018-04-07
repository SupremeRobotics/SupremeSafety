package ca.northviewheights.robotics.supremesafety;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Results extends Quiz {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        int score = intent.getIntExtra(Quiz.EXTRA_MESSAGE, 0);
        TextView qNumber = (TextView) findViewById(R.id.textView8);
        qNumber.setText(score + "/10");
        TextView isPerfect = (TextView) findViewById(R.id.textView7);
        if (score == 10){
            isPerfect.setText("Perfect!");
        }
        else{
            isPerfect.setText("Not Perfect?");
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Results.this,
                DisplayMessageActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void goToActivity1 (View view){
        finish();
    }

    public void goToActivity2 (View view){
        finish();
        onBackPressed();
    }
}
