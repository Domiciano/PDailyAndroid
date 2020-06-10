package co.edu.icesi.pdailyandroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import co.edu.icesi.pdailyandroid.cognosis.builder.Form;
import co.edu.icesi.pdailyandroid.cognosis.fragments.TMT;
import co.edu.icesi.pdailyandroid.cognosis.fragments.TypeA;
import co.edu.icesi.pdailyandroid.cognosis.fragments.TypeB;
import co.edu.icesi.pdailyandroid.cognosis.fragments.TypeC;

public class MocaActivity extends AppCompatActivity {

    TMT tmt;
    private Button next;
    String score = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moca);

        next = findViewById(R.id.ButtonNext);

        updateFragmentTMT();
        next.setEnabled(false);
//        updateListener();

        Log.i("MoCA_SCORE", score);


        next.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

            }
        });
    }


    protected void updateFragmentTMT() {
        tmt = new TMT();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, tmt);
        transaction.commit();
    }

    // Actualiza en tiempo real las modificaciones del fragment
//    private void updateListener() {
//        if(tmt != null){
//            tmt.setListener(new TMT.FragmentListener() {
//                @Override
//                public void onCompleteScore(String score) {
//                    score = score;
//                    if (score.equals("Si") || score.equals("No")) {
//                        next.setEnabled(true);
//                        Log.i("MoCA_SCORE", score);
//                    }
//                }
//            });
//        }
//    }
}