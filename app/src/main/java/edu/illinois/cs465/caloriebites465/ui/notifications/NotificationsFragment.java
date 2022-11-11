package edu.illinois.cs465.caloriebites465.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.illinois.cs465.caloriebites465.R;
import edu.illinois.cs465.caloriebites465.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    public NotificationsFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}