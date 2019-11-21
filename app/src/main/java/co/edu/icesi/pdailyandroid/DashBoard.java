package co.edu.icesi.pdailyandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import co.edu.icesi.pdailyandroid.viewcontrollers.BinnacleFragment;
import co.edu.icesi.pdailyandroid.viewcontrollers.EventFragment;
import co.edu.icesi.pdailyandroid.viewcontrollers.FoodFragment;
import co.edu.icesi.pdailyandroid.viewcontrollers.LevoFragment;
import co.edu.icesi.pdailyandroid.viewcontrollers.OthersFragment;
import co.edu.icesi.pdailyandroid.viewcontrollers.ProfileFragment;
import co.edu.icesi.pdailyandroid.viewcontrollers.RoutineFragment;
import co.edu.icesi.pdailyandroid.viewcontrollers.SupportFragment;

public class DashBoard extends AppCompatActivity {



    private Button supportButton;
    private Button routineButton;
    private Button foodButton;
    private Button profileButton;
    private Button othersButton;
    private Button levoButton;
    private Button binButton;
    private Button eventsButton;
    private FrameLayout fragmentContainer;

    private Fragment actualControl;

    private Fragment binFragment;
    private Fragment levoFragment;
    private Fragment othersFragment;
    private Fragment profileFragment;

    private Fragment foodFragment;
    private Fragment routineFragment;
    private Fragment supportFragment;
    private Fragment eventFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        supportButton = findViewById(R.id.supportButton);
        routineButton= findViewById(R.id.routineButton);
        foodButton= findViewById(R.id.foodButton);
        profileButton= findViewById(R.id.profileButton);
        othersButton= findViewById(R.id.othersButton);
        levoButton= findViewById(R.id.levoButton);
        binButton= findViewById(R.id.binButton);
        eventsButton= findViewById(R.id.eventsButton);
        fragmentContainer= findViewById(R.id.frameLayout);

        binFragment = new BinnacleFragment();
        levoFragment = new LevoFragment();
        othersFragment = new OthersFragment();
        profileFragment = new ProfileFragment();

        foodFragment = new FoodFragment();
        routineFragment = new RoutineFragment();
        supportFragment = new SupportFragment();
        eventFragment = new EventFragment();
    }

    public void doDashboardAction(View sender) {

        if(sender.equals(binButton)) {
            loadEventFragment(binFragment);
        }else if(sender.equals(levoButton)){
            loadEventFragment(levoFragment);
        }else if(sender.equals(othersButton)){
            loadEventFragment(othersFragment);
        }else if(sender.equals(profileButton)){
            loadEventFragment(profileFragment);
        }else if(sender.equals(foodButton)){
            loadEventFragment(foodFragment);
        }else if(sender.equals(routineButton)){
            loadEventFragment(routineFragment);
        }else if(sender.equals(supportButton)){
            loadEventFragment(supportFragment);
        }else if(sender.equals(eventsButton)){
            loadEventFragment(eventFragment);
        }

        allIsUnselected();

        if(actualControl == null){
            return;
        }


        if(actualControl instanceof SupportFragment){
            supportButton.setBackgroundResource(R.drawable.apoyoactivo);
        }
        else if(actualControl instanceof RoutineFragment){
            routineButton.setBackgroundResource(R.drawable.rutinaactivo);
        }
        else if(actualControl instanceof FoodFragment){
            foodButton.setBackgroundResource(R.drawable.comidaactivo);
        }
        else if(actualControl instanceof ProfileFragment){

        }
        else if(actualControl instanceof OthersFragment){
            othersButton.setBackgroundResource(R.drawable.otrosactivo);
        }
        else if(actualControl instanceof LevoFragment){
            levoButton.setBackgroundResource(R.drawable.levodopaactivo);
        }
        else if(actualControl instanceof BinnacleFragment){
            binButton.setBackgroundResource(R.drawable.bitacoraactivo);
        }
        else if(actualControl instanceof EventFragment){
            eventsButton.setBackgroundResource(R.drawable.eventosactivo);
        }

    }


    public void loadEventFragment(Fragment fragment){

        if(actualControl == null){
            load(fragment);
            return;
        }

        if (actualControl.equals(fragment)) {
            unload();
            return;
        }else{
            unload();
            load(fragment);
        }
    }

    private void load(Fragment fragment){
        actualControl = fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.frameLayout,actualControl);
        ft.commit();
    }

    private void unload(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.remove(actualControl);
        ft.commit();
        actualControl = null;
    }

    private void allIsUnselected(){
        supportButton.setBackgroundResource(R.drawable.apoyoinactivo);
        routineButton.setBackgroundResource(R.drawable.rutinainactivo);
        foodButton.setBackgroundResource(R.drawable.comidainactivo);
        //profileButton.setImage(UIImage(named: "apoyoinactivo"), for: .normal)
        othersButton.setBackgroundResource(R.drawable.otrosinactivo);
        levoButton.setBackgroundResource(R.drawable.levodopainactivo);
        binButton.setBackgroundResource(R.drawable.bitacorainactivo);
        eventsButton.setBackgroundResource(R.drawable.eventosinactivo);
    }

}
