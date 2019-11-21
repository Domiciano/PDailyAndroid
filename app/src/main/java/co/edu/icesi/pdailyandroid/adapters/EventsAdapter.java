package co.edu.icesi.pdailyandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.icesi.pdailyandroid.R;
import co.edu.icesi.pdailyandroid.viewmodel.EventViewModel;

public class EventsAdapter extends BaseAdapter {

    private ArrayList<EventViewModel> events;

    public EventsAdapter(ArrayList<EventViewModel> events) {
        this.events = events;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.eventcell, null, false);
        TextView symptomLabel = row.findViewById(R.id.symptomLabel);
        ImageView symptomEvaluatedSign = row.findViewById(R.id.symptomEvaluatedSign);

        symptomLabel.setText(events.get(position).getName());
        if(events.get(position).isEvaluated()){
            symptomEvaluatedSign.setVisibility(View.VISIBLE);
        }else{
            symptomEvaluatedSign.setVisibility(View.GONE);
        }
        return row;
    }

    public EventViewModel select(int position) {

        return events.get(position);
    }
}
