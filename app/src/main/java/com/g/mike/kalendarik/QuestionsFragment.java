package com.g.mike.kalendarik;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.g.mike.kalendarik.Data.Questions365;

/**
 * Created by Mike on 22.10.2016.
 */
public class QuestionsFragment extends Fragment {

    TextView textQuestion;
    EditText[] answer = new EditText[5];
    int day;

    public static QuestionsFragment newInstance(int day){
        QuestionsFragment questionsFragment = new QuestionsFragment();
        Bundle args = new Bundle();
        args.putInt("day", day);
        questionsFragment.setArguments(args);
        return questionsFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.day = this.getArguments().getInt("day");
        return inflater.inflate(R.layout.day_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        textQuestion = (TextView)getActivity().findViewById(R.id.questionText);
        answer[0] = (EditText) getActivity().findViewById(R.id.answer1) ;
        answer[1] = (EditText) getActivity().findViewById(R.id.answer1) ;
        answer[2] = (EditText) getActivity().findViewById(R.id.answer1) ;
        answer[3] = (EditText) getActivity().findViewById(R.id.answer1) ;
        answer[4] = (EditText) getActivity().findViewById(R.id.answer1) ;
        textQuestion.setText(Questions365.getQuestions('e')[day]);
        super.onViewCreated(view, savedInstanceState);
    }

    public void setDay(int day) {
        this.day = day;
    }


}
