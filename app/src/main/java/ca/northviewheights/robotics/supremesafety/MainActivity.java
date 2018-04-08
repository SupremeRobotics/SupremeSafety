package ca.northviewheights.robotics.supremesafety;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Futura.ttf");
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setTypeface(typeface);
        TextView textView2 = (TextView) findViewById(R.id.textView4);
        textView2.setTypeface(typeface);
        TextView textView3 = (TextView) findViewById(R.id.textView5);
        textView3.setTypeface(typeface);
        Button buttonA = (Button) findViewById(R.id.button);
        buttonA.setTypeface(typeface);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
    }
    public void goToActivity2 (View view){
        Intent intent = new Intent (this, DisplayMessageActivity.class);
        startActivity(intent);
    }

}
