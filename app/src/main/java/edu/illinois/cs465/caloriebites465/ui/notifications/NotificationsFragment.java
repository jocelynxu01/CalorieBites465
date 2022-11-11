package edu.illinois.cs465.caloriebites465.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import edu.illinois.cs465.caloriebites465.R;

public class NotificationsFragment extends Fragment {

    public NotificationsFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rewards, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}