package edu.illinois.cs465.caloriebites465;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class Rewards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards2);

        // Initializing Settings Button
        ImageButton dumpling_btn = (ImageButton) findViewById(R.id.imageView5);
        // Adding Click Listener for Settings Button
        dumpling_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webPage = Uri.parse("https://tasty.co/recipe/homemade-dumplings");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(webPage);
                Intent chooser = Intent.createChooser(intent, "Open With");
                startActivity(chooser);
            }
        });

        // Initializing Settings Button
        ImageButton spaghetti_btn = (ImageButton) findViewById(R.id.imageView6);
        // Adding Click Listener for Settings Button
        spaghetti_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webPage = Uri.parse("https://www.inspiredtaste.net/38940/spaghetti-with-meat-sauce-recipe/");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(webPage);
                Intent chooser = Intent.createChooser(intent, "Open With");
                startActivity(chooser);
            }
        });
    }
}