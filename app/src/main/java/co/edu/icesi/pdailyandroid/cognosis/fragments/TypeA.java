package co.edu.icesi.pdailyandroid.cognosis.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import co.edu.icesi.pdailyandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TypeA extends Fragment {

//    private String text;
//    private String ideal;

    private  String formQuestion;

    private  String answerOne;
    private  String answerTwo;
    private  String answerThree;
    private  String answerFour;

    private int formTotalNumber;
    private int index;

    public TypeA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_type_a, container, false);
//        EditText pregunta1 = view.findViewById(R.id.pregunta1);
//        EditText pregunta2 = view.findViewById(R.id.pregunta2);

//        pregunta1.setText(this.text);
//        pregunta2.setText(this.ideal);

        TextView formQuestion = view.findViewById(R.id.TextFormQuestion);

        Button answerOne = view.findViewById(R.id.ButtonAnswerOne);
        Button answerTwo = view.findViewById(R.id.ButtonAnswerTwo);
        Button answerThree = view.findViewById(R.id.ButtonAnswerThree);
        Button answerFour = view.findViewById(R.id.ButtonAnswerFour);

        formQuestion.setText(this.formQuestion);

        answerOne.setText(this.answerOne);
        answerTwo.setText(this.answerTwo);
        answerThree.setText(this.answerThree);
        answerFour.setText(this.answerFour);

        return view;
    }

    public void setFormQuestion(String formQuestion) {
        this.formQuestion = formQuestion;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }

    public void setAnswerThree(String answerThree) {
        this.answerThree = answerThree;
    }

    public void setAnswerFour(String answerFour) {
        this.answerFour = answerFour;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setFormTotalNumber(int formTotalNumber) {
        this.formTotalNumber = formTotalNumber;
    }
}
