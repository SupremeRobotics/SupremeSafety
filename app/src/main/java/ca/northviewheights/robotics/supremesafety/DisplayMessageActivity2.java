package ca.northviewheights.robotics.supremesafety;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DisplayMessageActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message2);
    }

    public void goToActivity1 (View view){
        CopyReadAssets("doc1.pdf");
    }

    public void goToActivity2 (View view){
        CopyReadAssets("doc2.pdf");
    }

    public void goToActivity3 (View view){
        CopyReadAssets("doc3.pdf");
    }

    public void goToActivity4 (View view){
        CopyReadAssets("doc4.pdf");
    }

    public void goToActivity5 (View view){
        CopyReadAssets("doc5.pdf");
    }

    public void goToActivity6 (View view){
        CopyReadAssets("doc6.pdf");
    }

    public void goToActivity7 (View view){
        CopyReadAssets("doc7.pdf");
    }

    public void goToActivity8 (View view){
        CopyReadAssets("doc8.pdf");
    }

    public void goToActivity9 (View view){
        CopyReadAssets("doc9.pdf");
    }

    public void goToActivity10 (View view){
        CopyReadAssets("doc10.pdf");
    }

    public void goToActivity11 (View view){
        CopyReadAssets("doc11.pdf");
    }

    public void goToActivity12 (View view){
        CopyReadAssets("doc12.pdf");
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
}
