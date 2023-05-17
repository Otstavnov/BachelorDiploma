package com.example.app_test_user.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.app_test_user.Question;
import com.example.app_test_user.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestingFragment extends Fragment {

    private TextView txtView;
    private Button ans1, ans2, ans3, ans4;
    private Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10;
    private Question tempQuestion = null;
    private List<Question> questionList;
    private Question questTemp;
    public int iter = 0;
    private String correct_ans;
    private String section;
    private int pointOPP, pointBasic, pointArray;

    public TestingFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        initQuest();
        initView();
        questTemp = questionList.get(0);
        txtView.setText(questTemp.getText());
        ans1.setText(questTemp.getAnswer1());
        ans2.setText(questTemp.getAnswer2());
        ans3.setText(questTemp.getAnswer3());
        ans4.setText(questTemp.getAnswer4());
        correct_ans = questTemp.getCorrect_answer();
        section = questTemp.getSection();

        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correct_ans.equals(ans1.getText().toString())) {
                    switch (section) {
                        case "ООП":
                            pointOPP++;
                            break;
                        case "Коллекции":
                            pointArray++;
                            break;
                        case "Базовые":
                            pointBasic++;
                            break;
                    }
                }
                iter++;
                questTemp = questionList.get(iter);
                txtView.setText(questTemp.getText());
                ans1.setText(questTemp.getAnswer1());
                ans2.setText(questTemp.getAnswer2());
                ans3.setText(questTemp.getAnswer3());
                ans4.setText(questTemp.getAnswer4());
                correct_ans = questTemp.getCorrect_answer();
                section = questTemp.getSection();
            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correct_ans.equals(ans2.getText().toString())) {
                    switch (section) {
                        case "ООП":
                            pointOPP++;
                            break;
                        case "Коллекции":
                            pointArray++;
                            break;
                        case "Базовые":
                            pointBasic++;
                            break;
                    }
                }
                iter++;
                questTemp = questionList.get(iter);
                txtView.setText(questTemp.getText());
                ans1.setText(questTemp.getAnswer1());
                ans2.setText(questTemp.getAnswer2());
                ans3.setText(questTemp.getAnswer3());
                ans4.setText(questTemp.getAnswer4());
                correct_ans = questTemp.getCorrect_answer();
                section = questTemp.getSection();
            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correct_ans.equals(ans3.getText().toString())) {
                    switch (section) {
                        case "ООП":
                            pointOPP++;
                            break;
                        case "Коллекции":
                            pointArray++;
                            break;
                        case "Базовые":
                            pointBasic++;
                            break;
                    }
                }
                iter++;
                questTemp = questionList.get(iter);
                txtView.setText(questTemp.getText());
                ans1.setText(questTemp.getAnswer1());
                ans2.setText(questTemp.getAnswer2());
                ans3.setText(questTemp.getAnswer3());
                ans4.setText(questTemp.getAnswer4());
                correct_ans = questTemp.getCorrect_answer();
                section = questTemp.getSection();
            }
        });

        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correct_ans.equals(ans4.getText().toString())) {
                    switch (section) {
                        case "ООП":
                            pointOPP++;
                            break;
                        case "Коллекции":
                            pointArray++;
                            break;
                        case "Базовые":
                            pointBasic++;
                            break;
                    }
                }
                iter++;
                questTemp = questionList.get(iter);
                txtView.setText(questTemp.getText());
                ans1.setText(questTemp.getAnswer1());
                ans2.setText(questTemp.getAnswer2());
                ans3.setText(questTemp.getAnswer3());
                ans4.setText(questTemp.getAnswer4());
                correct_ans = questTemp.getCorrect_answer();
                section = questTemp.getSection();
            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_testing, container, false);


        return inflater.inflate(R.layout.fragment_testing, container, false);
    }


    public void initQuest() {
        questionList = new ArrayList<>();
        String idSection = "ООП-";
        String id_temp = "";
        for (int i = 2; i <= 10; i++) {
            id_temp = idSection + i;
            FirebaseDatabase
                    .getInstance("https://otstavnovdiploma-default-rtdb.europe-west1.firebasedatabase.app/")
                    .getReference()
                    .child("Questions")
                    .child("ООП")
                    .child(id_temp).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            tempQuestion = snapshot.getValue(Question.class);
                            questionList.add(tempQuestion);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
        }


        q1 = new Question("ООП",
                "ООП-1",
                "Java - это ... язык программирования. Заполните пропуск",
                "объектно-ориентированный",
                "функциональный",
                "теоретический",
                "Всё вышеперечисленное",
                "объектно-ориентированный");
        questionList.add(q1);

//        q2 = new Question("ООП",
//                "ООП-2",
//                "Java - это ... язык программирования. Заполните пропуск",
//                "объектно-ориентированный",
//                "функциональный",
//                "теоретический",
//                "Всё вышеперечисленное",
//                "объектно-ориентированный");
//
//        q3 = new Question("ООП",
//                "ООП-3",
//                "Java - это ... язык программирования. Заполните пропуск",
//                "объектно-ориентированный",
//                "функциональный",
//                "теоретический",
//                "Всё вышеперечисленное",
//                "объектно-ориентированный");
//
//        q4 = new Question("ООП",
//                "ООП-4",
//                "Java - это ... язык программирования. Заполните пропуск",
//                "объектно-ориентированный",
//                "функциональный",
//                "теоретический",
//                "Всё вышеперечисленное",
//                "объектно-ориентированный");
//
//        q5 = new Question("ООП",
//                "ООП-5",
//                "Java - это ... язык программирования. Заполните пропуск",
//                "объектно-ориентированный",
//                "функциональный",
//                "теоретический",
//                "Всё вышеперечисленное",
//                "объектно-ориентированный");
//
//        q6 = new Question("ООП",
//                "ООП-6",
//                "Java - это ... язык программирования. Заполните пропуск",
//                "объектно-ориентированный",
//                "функциональный",
//                "теоретический",
//                "Всё вышеперечисленное",
//                "объектно-ориентированный");
//
//        q7 = new Question("ООП",
//                "ООП-7",
//                "Java - это ... язык программирования. Заполните пропуск",
//                "объектно-ориентированный",
//                "функциональный",
//                "теоретический",
//                "Всё вышеперечисленное",
//                "объектно-ориентированный");
//        q8 = new Question("ООП",
//                "ООП-8",
//                "Java - это ... язык программирования. Заполните пропуск",
//                "объектно-ориентированный",
//                "функциональный",
//                "теоретический",
//                "Всё вышеперечисленное",
//                "объектно-ориентированный");
//
//        q9 = new Question("ООП",
//                "ООП-9",
//                "Java - это ... язык программирования. Заполните пропуск",
//                "объектно-ориентированный",
//                "функциональный",
//                "теоретический",
//                "Всё вышеперечисленное",
//                "объектно-ориентированный");
//
//        q10 = new Question("ООП",
//                "ООП-10",
//                "Что такое наследование в Java?",
//                "Возможность создавать новый класс на основе уже существующего",
//                "Возможность создавать новый объект на основе уже существующего",
//                "Возможность создавать новый интерфейс на основе уже существующего",
//                "Возможность создавать новый метод на основе уже существующего",
//                "Возможность создавать новый класс на основе уже существующего");
//        questionList.add(q1);
//        questionList.add(q2);
//        questionList.add(q3);
//        questionList.add(q4);
//        questionList.add(q5);
//        questionList.add(q6);
//        questionList.add(q7);
//        questionList.add(q8);
//        questionList.add(q9);
//        questionList.add(q10);
    }

    public void initView() {
        txtView = (TextView) getActivity().findViewById(R.id.txt_TestQuest);
        ans1 = (Button) getActivity().findViewById(R.id.btn_answer1);
        ans2 = (Button) getActivity().findViewById(R.id.btn_answer2);
        ans3 = (Button) getActivity().findViewById(R.id.btn_answer3);
        ans4 = (Button) getActivity().findViewById(R.id.btn_answer4);
    }
}