package edu.illinois.cs465.caloriebites465;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        // elevating root_preferences to view
        if (findViewById(R.id.settings_activity_id) != null) {
            if (savedInstanceState != null) {
                return;
            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings_activity_id, new SettingsFragment())
                    .commit();
        }

        // below line is to change
        // the title of our action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Settings");
        }
    }

    // Enabling Back Button Press on Action Bar
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}