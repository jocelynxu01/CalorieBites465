package edu.illinois.cs465.caloriebites465;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

import edu.illinois.cs465.caloriebites465.databinding.ActivityConverterBinding;
import edu.illinois.cs465.caloriebites465.ui.dashboard.DashboardFragment;

public class Converter extends AppCompatActivity {
    ActivityConverterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConverterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.foodTab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DashboardFragment fragment = new DashboardFragment();
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.container, fragment);
//                transaction.addToBackStack(null);
//                transaction.commit();
//            }
//        });

//        Button foodTab = (Button) findViewById(R.id.foodTab);
//
//        foodTab.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                Fragment fragment = new DashboardFragment();
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragment1, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//            }
//        });

        // search
        Button btn = (Button) findViewById(R.id.searchButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNumber(v);
                randomize(v);
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Convertor");
        }

        Button food_btn = (Button) findViewById(R.id.foodTab);

        food_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void handleNumber(View v) {
        EditText t = findViewById(R.id.input_number);
        String input = t.getText().toString();
        ((TextView) findViewById(R.id.output_number)).setText(input);
    }

    public void randomize(View v) {
        int steps = new Random().nextInt(4001) + 2000; // [0, 4000] + 2000 => [2000, 6000]
        int food = new Random().nextInt(21) + 10; // [0, 20] + 10 => [10, 30]
        ((TextView) findViewById(R.id.numSteps)).setText(String.valueOf(steps));
        ((TextView) findViewById(R.id.numFood)).setText(String.valueOf(food));
    }

    /*@Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }*/
}