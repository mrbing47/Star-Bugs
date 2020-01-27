package garg.sarthik.starbugs.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import garg.sarthik.starbugs.Adapters.NotificationAdapter;
import garg.sarthik.starbugs.POJO.Event;
import garg.sarthik.starbugs.R;

public class HistoryFragment extends Fragment {

    private HistoryViewModel historyViewModel;
    private RecyclerView rvHistory;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        historyViewModel =
                ViewModelProviders.of(this).get(HistoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_history, container, false);

        rvHistory = root.findViewById(R.id.rvHistory);

        historyViewModel.getEvents().observe((LifecycleOwner) getContext(), new Observer<List<Event>>() {
            @Override
            public void onChanged(List<Event> events) {

                rvHistory.setLayoutManager(new LinearLayoutManager(getContext()));
                rvHistory.setAdapter(new NotificationAdapter(events, getContext()));

            }
        });
        return root;
    }
}