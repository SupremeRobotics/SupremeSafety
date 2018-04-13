package ca.northviewheights.robotics.supremesafety;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Futura-Bold-Italic-font.ttf");
        Button buttonA = (Button) findViewById(R.id.button2);
        buttonA.setTypeface(typeface);
        Button buttonB = (Button) findViewById(R.id.button3);
        buttonB.setTypeface(typeface);
        Button buttonC = (Button) findViewById(R.id.button4);
        buttonC.setTypeface(typeface);
        Button buttonD = (Button) findViewById(R.id.button6);
        buttonD.setTypeface(typeface);
        Button buttonE = (Button) findViewById(R.id.button7);
        buttonE.setTypeface(typeface);
    }

    public void goToActivity1 (View view){
        CopyReadAssets("manual.pdf");
    }

    public void goToActivity2 (View view){
        CopyReadAssets("brochure.pdf");
    }

    private void CopyReadAssets(String name)
    {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), name);
        try
        {
            in = assetManager.open(name);
            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e)
        {
            Log.e("tag", e.getMessage());
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(
                Uri.parse("file://" + getFilesDir() + "/" + name),
                "application/pdf");

        startActivity(intent);
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, read);
        }
    }

    public void goToActivity3 (View view){
        Intent intent = new Intent (this, DisplayMessageActivity2.class);
        startActivity(intent);
    }

    public void goToActivity4 (View view){
        Intent intent = new Intent (this, Quiz.class);
        startActivity(intent);
    }

    public void goToActivity5 (View view){
        Intent intent = new Intent (this, Gallery.class);
        startActivity(intent);
    }
}
