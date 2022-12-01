package edu.illinois.cs465.caloriebites465.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.Random;

import edu.illinois.cs465.caloriebites465.Converter;
import edu.illinois.cs465.caloriebites465.R;
import edu.illinois.cs465.caloriebites465.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    String[] item = {"Apples", "Oranges", "Bananas", "Hamburgers", "Pizza Slice", "PBJ Sandwich", "Oreo Cookies", "Potato Chips"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;

    String input;

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        autoCompleteTextView = root.findViewById(R.id.auto_complete_textview);

        adapterItems = new ArrayAdapter<String>(getActivity(), R.layout.list_item, item);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int position, long l) {
                input = adapterView.getItemAtPosition(position).toString();
            }
        });

        Button caloriesTab = (Button) root.findViewById(R.id.caloriesTab);

        caloriesTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Converter.class);
                startActivity(intent);
            }
        });

        Button btn = (Button) root.findViewById(R.id.searchButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNumber(v);
                handleFood(v, input);
                randomize(v);
            }
        });
        return root;
    }

    public void handleNumber(View v) {
        EditText t = getView().findViewById(R.id.input_number);
        String input = t.getText().toString();
        ((TextView) getView().findViewById(R.id.output_number)).setText(input);
    }

    public void handleFood(View v, String input) {
        ((TextView) getView().findViewById(R.id.output_food)).setText(input.toLowerCase());
    }

    public void randomize(View v) {
        int steps = new Random().nextInt(4001) + 2000; // [0, 4000] + 2000 => [2000, 6000]
        int calories = new Random().nextInt(901) + 100; // [0, 900] + 100 => [100, 1000]
        ((TextView) getView().findViewById(R.id.numSteps)).setText(String.valueOf(steps));
        ((TextView) getView().findViewById(R.id.numCalories)).setText(String.valueOf(calories));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}