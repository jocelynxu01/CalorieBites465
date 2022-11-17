package edu.illinois.cs465.caloriebites465.ui.notifications;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.illinois.cs465.caloriebites465.R;
import edu.illinois.cs465.caloriebites465.Rewards;
import edu.illinois.cs465.caloriebites465.databinding.FragmentRewardsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentRewardsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentRewardsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView pastRecords = (ListView)root.findViewById(R.id.pastRecordsList);

        pastRecords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),Rewards.class);
                startActivity(intent);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}