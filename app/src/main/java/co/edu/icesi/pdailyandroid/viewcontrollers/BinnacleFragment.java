package co.edu.icesi.pdailyandroid.viewcontrollers;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.UUID;

import co.edu.icesi.pdailyandroid.R;
import co.edu.icesi.pdailyandroid.adapters.NotificationsAdapter;
import co.edu.icesi.pdailyandroid.database.DataHandler;
import co.edu.icesi.pdailyandroid.interfaces.INotification;
import co.edu.icesi.pdailyandroid.model.NotificationFoodFollowUp;
import co.edu.icesi.pdailyandroid.model.NotificationGame;


public class BinnacleFragment extends Fragment {

    private ListView notificationTable;
    private NotificationsAdapter adapter;
    private ArrayList<INotification> notifications;

    public BinnacleFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_binnacle, container, false);
        notifications = new ArrayList<>();
        notificationTable = v.findViewById(R.id.notificationTable);
        adapter = new NotificationsAdapter(notifications);
        notificationTable.setAdapter(adapter);
        getAllInfo();
        return v;
    }

    private void getAllInfo() {
        notifications.clear();

        DataHandler db = DataHandler.getInstance(getContext());

        //ArrayList<NotificationFoodFollowUp> info = db.getAllFoodNotifications();

        ArrayList<INotification> info = new ArrayList<>();
        info.add( new NotificationFoodFollowUp(UUID.randomUUID().toString(), "¿Ya almorzaste?", "29/01/2020 15:01:00") );
        info.add( new NotificationGame(NotificationGame.BANANA_GAME_ID, "Vamos a jugar con la banana", "29/01/2020 14:31:00"));
        info.add( new NotificationGame(NotificationGame.WORM_GAME_ID, "Vamos a jugar con los gusanos", "29/01/2020 11:26:00"));

        for(int i=0 ; i<info.size() ; i++){
            notifications.add(info.get(i));
        }
        adapter.notifyDataSetChanged();

    }

    public void updateTable() {
        if(adapter != null){
            getAllInfo();
        }
    }

}
