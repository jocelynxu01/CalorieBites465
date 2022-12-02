package edu.illinois.cs465.caloriebites465.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.Random;

import edu.illinois.cs465.caloriebites465.R;
import edu.illinois.cs465.caloriebites465.SettingsActivity;
import edu.illinois.cs465.caloriebites465.databinding.FragmentDashboardBinding;
import edu.illinois.cs465.caloriebites465.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    String[] item = {"Apples", "Oranges", "Bananas", "Hamburgers", "Pizza Slice", "PBJ Sandwich", "Oreo Cookies", "Potato Chips"};

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Initializing Settings Button
        ImageButton settings_btn = (ImageButton) root.findViewById(R.id.settings_button);
        // Adding Click Listener for Settings Button
        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        // search
        ImageButton btn = (ImageButton) root.findViewById(R.id.shuffleButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleFood(v);
                randomize(v);
            }
        });

        return root;
    }

    public void handleFood(View v) {
        int rnd = new Random().nextInt(item.length);

        ((TextView) getView().findViewById(R.id.foodName)).setText(String.valueOf(item[rnd].toLowerCase()));
    }

    public void randomize(View v) {
        int steps = new Random().nextInt(4001) + 2000; // [0, 4000] + 2000 => [2000, 6000]
        int calories = new Random().nextInt(901) + 100; // [0, 900] + 100 => [100, 1000]
        int number = new Random().nextInt(9) + 1; // [0, 8] + 1 => [1, 9]
        ((TextView) getView().findViewById(R.id.numFood)).setText(String.valueOf(number));
        ((TextView) getView().findViewById(R.id.numSteps)).setText(String.valueOf(steps));
        ((TextView) getView().findViewById(R.id.numCalories)).setText(String.valueOf(calories));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}