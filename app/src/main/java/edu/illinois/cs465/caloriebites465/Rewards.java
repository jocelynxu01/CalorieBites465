package edu.illinois.cs465.caloriebites465;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Rewards extends AppCompatActivity {

    ListView pastRecordsView;

    //change to get dates dynamically
    String pastRecords[] = {"November 10th", "November 9th", "November 8th", "November 7th", "November 6th", "November 5th"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        pastRecordsView = (ListView)findViewById(R.id.pastRecordsList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_rewards, R.id.textView, pastRecords);
        System.out.println(arrayAdapter);
        pastRecordsView.setAdapter(arrayAdapter);
    }
}