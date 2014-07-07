
package org.asha.app.ui;

import org.asha.app.datamodel.Event;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    private ListView mEventsListView;

    private ArrayList<Event> mEventList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mEventsListView = (ListView)rootView.findViewById(R.id.event_list);
        if (savedInstanceState != null) {
            mEventList = savedInstanceState.getParcelableArrayList(UiResources.EVENTS_KEY);
        } else {
            mockEventData();
        }
        mEventsListView.setAdapter(mEventListAdapter);
        return rootView;
    }

    private void mockEventData() {
        mEventList = new ArrayList<Event>();
        for (int i = 1; i <= 15; i++) {
            mEventList.add(Event.createMockObject(i));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(UiResources.EVENTS_KEY, mEventList);
    }

    private BaseAdapter mEventListAdapter = new BaseAdapter() {

        @Override
        public View getView(int position, View convertView, ViewGroup parentView) {
            View view;
            ViewHolder holder;
            if (convertView != null) {
                view = convertView;
                holder = (ViewHolder)view.getTag();
            } else {
                view = View.inflate(getActivity(), R.layout.event_list_item, null);
                holder = new ViewHolder();
                holder.eventLocationTextView = (TextView)view.findViewById(R.id.event_location);
                holder.eventTitleTextView = (TextView)view.findViewById(R.id.event_title);
                holder.color = UiResources.pickRandomColor();
            }

            Event event = getItem(position);
            holder.eventLocationTextView.setText(event.getEventLocation());
            holder.eventTitleTextView.setText(event.getEventTitle());
            view.setBackgroundColor(holder.color);
            view.setTag(holder);

            return view;
        }

        @Override
        public long getItemId(int arg0) {
            return 0;
        }

        @Override
        public Event getItem(int position) {
            return mEventList.get(position);
        }

        @Override
        public int getCount() {
            return mEventList.size();
        }

        class ViewHolder {
            public TextView eventTitleTextView;
            public int color;
            public TextView eventLocationTextView;
        }
    };
}
