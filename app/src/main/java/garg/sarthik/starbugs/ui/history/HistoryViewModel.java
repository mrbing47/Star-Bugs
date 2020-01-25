package garg.sarthik.starbugs.ui.history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import garg.sarthik.starbugs.POJO.Event;

public class HistoryViewModel extends ViewModel {

    private MutableLiveData<List<Event>> mEvents;

    public HistoryViewModel() {
        mEvents = new MutableLiveData<>();
        List<Event> events = new ArrayList<>();

        events.add(new Event("77 , 80", "202001240821"));
        events.add(new Event("25 , 33", "202001240821"));
        events.add(new Event("0 , 0", "202001240821"));
        events.add(new Event("71 , 25", "202001240821"));
        events.add(new Event("69 , 55", "202001240821"));
        events.add(new Event("7 , 8", "202001240821"));

        mEvents.setValue(events);
    }

    public LiveData<List<Event>> getEvents() {
        return mEvents;
    }
}