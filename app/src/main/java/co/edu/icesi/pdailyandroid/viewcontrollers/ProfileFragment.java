package co.edu.icesi.pdailyandroid.viewcontrollers;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import co.edu.icesi.pdailyandroid.R;


public class ProfileFragment extends Fragment {

    private TextView statusMessage;
    private ImageView statusFace;
    private ConstraintLayout messageContainer;
    private Button statusBtn2;
    private Button statusBtn3;
    private Button statusBtn4;
    private Button statusBtn5;
    private Button statusBtn6;
    private Button statusBtn7;
    private Button statusBtn8;
    private Button statusBtn9;
    private Button statusBtn10;

    private int statusValue;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        statusMessage = v.findViewById(R.id.statusMessage);
        statusFace = v.findViewById(R.id.statusFace);
        messageContainer = v.findViewById(R.id.messageContainer);
        statusBtn2 = v.findViewById(R.id.statusBtn2);
        statusBtn3 = v.findViewById(R.id.statusBtn3);
        statusBtn4 = v.findViewById(R.id.statusBtn4);
        statusBtn5 = v.findViewById(R.id.statusBtn5);
        statusBtn6 = v.findViewById(R.id.statusBtn6);
        statusBtn7 = v.findViewById(R.id.statusBtn7);
        statusBtn8 = v.findViewById(R.id.statusBtn8);
        statusBtn9 = v.findViewById(R.id.statusBtn9);
        statusBtn10 = v.findViewById(R.id.statusBtn10);

        statusBtn2.setOnClickListener(this::doStatusAssess);
        statusBtn3.setOnClickListener(this::doStatusAssess);
        statusBtn4.setOnClickListener(this::doStatusAssess);
        statusBtn5.setOnClickListener(this::doStatusAssess);
        statusBtn6.setOnClickListener(this::doStatusAssess);
        statusBtn7.setOnClickListener(this::doStatusAssess);
        statusBtn8.setOnClickListener(this::doStatusAssess);
        statusBtn9.setOnClickListener(this::doStatusAssess);
        statusBtn10.setOnClickListener(this::doStatusAssess);
        return v;
    }


    public void doStatusAssess(View sender) {

        deselectAll();


        if (sender.equals(statusBtn2)) {
            statusValue = 9;
            statusFace.setImageResource(R.drawable.rostro9);
            statusMessage.setText("Muy mal");
        } else if (sender.equals(statusBtn3)) {
            statusValue = 8;
            statusFace.setImageResource(R.drawable.rostro8);
            statusMessage.setText("Mal");
        } else if (sender.equals(statusBtn4)) {
            statusMessage.setText("...");
            statusValue = 7;
            statusFace.setImageResource(R.drawable.rostro7);
        } else if (sender.equals(statusBtn5)) {
            statusMessage.setText("...");
            statusValue = 6;
            statusFace.setImageResource(R.drawable.rostro6);
        } else if (sender.equals(statusBtn6)) {
            statusMessage.setText("...");
            statusValue = 5;
            statusFace.setImageResource(R.drawable.rostro5);
        } else if (sender.equals(statusBtn7)) {
            statusMessage.setText("...");
            statusValue = 4;
            statusFace.setImageResource(R.drawable.rostro4);
        } else if (sender.equals(statusBtn8)) {
            statusMessage.setText("...");
            statusValue = 3;
            statusFace.setImageResource(R.drawable.rostro3);
        } else if (sender.equals(statusBtn9)) {
            statusMessage.setText("Bien. Algunos sintomas pero mejorando");
            statusValue = 2;
            statusFace.setImageResource(R.drawable.rostro2);
        } else if (sender.equals(statusBtn10)) {
            statusMessage.setText("Excelente");
            statusValue = 1;
            statusFace.setImageResource(R.drawable.rostro1);
        }

        sender.setBackgroundColor(Color.WHITE);

        if (statusValue < 5) {
            messageContainer.setY(sender.getY()+sender.getHeight()/2);
        } else {
            messageContainer.setY(sender.getY() + (int)(1.5*sender.getHeight()) - messageContainer.getHeight());
        }
    }

    public void deselectAll() {
        statusBtn10.setBackgroundColor(Color.rgb(24, 255, 0));
        statusBtn9.setBackgroundColor(Color.rgb(116, 255, 0));
        statusBtn8.setBackgroundColor(Color.rgb(158, 255, 0));
        statusBtn7.setBackgroundColor(Color.rgb(255, 255, 0));
        statusBtn6.setBackgroundColor(Color.rgb(255, 241, 1));
        statusBtn5.setBackgroundColor(Color.rgb(255, 178, 0));
        statusBtn4.setBackgroundColor(Color.rgb(255, 139, 0));
        statusBtn3.setBackgroundColor(Color.rgb(255, 43, 0));
        statusBtn2.setBackgroundColor(Color.rgb(255, 0, 2));
    }


}
