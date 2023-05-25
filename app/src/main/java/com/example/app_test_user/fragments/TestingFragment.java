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
import android.widget.Toast;

import com.example.app_test_user.Question;
import com.example.app_test_user.R;
import com.example.app_test_user.TestResult;
import com.example.app_test_user.User;
import com.google.android.gms.common.data.DataBuffer;
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
    private Question q1;
    private Question tempQuestion = null;
    private List<Question> questionList;
    private Question questTemp;
    public int iter = 0;
    private String correct_ans;
    private String section;
    private int pointOPP, pointBasic, pointCollections, pointExceptions, pointOperators;
    private TestResult userTestResult;
    private User user;

    public TestingFragment(User loadUser) {
        this.user = loadUser;
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
                        case "OOP":
                            pointOPP++;
                            break;
                        case "Collections":
                            pointCollections++;
                            break;
                        case "Basic":
                            pointBasic++;
                            break;
                        case "Exceptions":
                            pointExceptions++;
                            break;
                        case "Operators":
                            pointOperators++;
                            break;
                    }
                }
                iter++;
                if (iter >= 25) {
                    userTestResult = new TestResult(pointBasic, pointCollections, pointExceptions, pointOPP, pointOperators);
                    loadResults();
                    getParentFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.home_main_container, new TestResultFragment(userTestResult)).commit();
                }

                if (iter < 25) {
                    questTemp = questionList.get(iter);
                    txtView.setText(questTemp.getText());
                    ans1.setText(questTemp.getAnswer1());
                    ans2.setText(questTemp.getAnswer2());
                    ans3.setText(questTemp.getAnswer3());
                    ans4.setText(questTemp.getAnswer4());
                    correct_ans = questTemp.getCorrect_answer();
                    section = questTemp.getSection();
                }
            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correct_ans.equals(ans2.getText().toString())) {
                    switch (section) {
                        case "OOP":
                            pointOPP++;
                            break;
                        case "Collections":
                            pointCollections++;
                            break;
                        case "Basic":
                            pointBasic++;
                            break;
                        case "Exceptions":
                            pointExceptions++;
                            break;
                        case "Operators":
                            pointOperators++;
                            break;
                    }
                }
                iter++;
                if (iter >= 25) {
                    userTestResult = new TestResult(pointBasic, pointCollections, pointExceptions, pointOPP, pointOperators);
                    loadResults();
                    getParentFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.home_main_container, new TestResultFragment(userTestResult)).commit();
                }

                if (iter < 25) {
                    questTemp = questionList.get(iter);
                    txtView.setText(questTemp.getText());
                    ans1.setText(questTemp.getAnswer1());
                    ans2.setText(questTemp.getAnswer2());
                    ans3.setText(questTemp.getAnswer3());
                    ans4.setText(questTemp.getAnswer4());
                    correct_ans = questTemp.getCorrect_answer();
                    section = questTemp.getSection();
                }
            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correct_ans.equals(ans3.getText().toString())) {
                    switch (section) {
                        case "OOP":
                            pointOPP++;
                            break;
                        case "Collections":
                            pointCollections++;
                            break;
                        case "Basic":
                            pointBasic++;
                            break;
                        case "Exceptions":
                            pointExceptions++;
                            break;
                        case "Operators":
                            pointOperators++;
                            break;
                    }
                }
                iter++;
                if (iter >= 25) {
                    userTestResult = new TestResult(pointBasic, pointCollections, pointExceptions, pointOPP, pointOperators);
                    loadResults();
                    getParentFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.home_main_container, new TestResultFragment(userTestResult)).commit();
                }

                if (iter < 25) {
                    questTemp = questionList.get(iter);
                    txtView.setText(questTemp.getText());
                    ans1.setText(questTemp.getAnswer1());
                    ans2.setText(questTemp.getAnswer2());
                    ans3.setText(questTemp.getAnswer3());
                    ans4.setText(questTemp.getAnswer4());
                    correct_ans = questTemp.getCorrect_answer();
                    section = questTemp.getSection();
                }
            }
        });

        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correct_ans.equals(ans4.getText().toString())) {
                    switch (section) {
                        case "OOP":
                            pointOPP++;
                            break;
                        case "Collections":
                            pointCollections++;
                            break;
                        case "Basic":
                            pointBasic++;
                            break;
                        case "Exceptions":
                            pointExceptions++;
                            break;
                        case "Operators":
                            pointOperators++;
                            break;
                    }
                }
                iter++;
                if (iter >= 25) {
                    userTestResult = new TestResult(pointBasic, pointCollections, pointExceptions, pointOPP, pointOperators);
                    loadResults();
                    getParentFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.home_main_container, new TestResultFragment(userTestResult)).commit();
                }

                if (iter < 25) {
                    questTemp = questionList.get(iter);
                    txtView.setText(questTemp.getText());
                    ans1.setText(questTemp.getAnswer1());
                    ans2.setText(questTemp.getAnswer2());
                    ans3.setText(questTemp.getAnswer3());
                    ans4.setText(questTemp.getAnswer4());
                    correct_ans = questTemp.getCorrect_answer();
                    section = questTemp.getSection();
                }
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

        String idSectionBasic = "Basic";
        String idSectionCollections = "Collections";
        String idSectionExceptions = "Exceptions";
        String idSectionOOP = "OOP";
        String idSectionOperators = "Operators";

        String id_temp = "";
        String sec_temp = "";

        for (int i = 2; i <= 25; i++) {
            sec_temp = idSectionBasic;
            id_temp = sec_temp + "-" + i;
            int temp;

            if (i >= 6 && i <= 10) {
                temp = i - 5;
                sec_temp = idSectionCollections;
                id_temp = sec_temp + "-" + temp;
            }

            if (i >= 11 && i <= 15) {
                temp = i - 10;
                sec_temp = idSectionExceptions;
                id_temp = sec_temp + "-" + temp;
            }
            if (i >= 16 && i <= 20) {
                temp = i - 15;
                sec_temp = idSectionOOP;
                id_temp = sec_temp + "-" + temp;
            }
            if (i >= 21) {
                temp = i - 20;
                sec_temp = idSectionOperators;
                id_temp = sec_temp + "-" + temp;
            }
            FirebaseDatabase
                    .getInstance("https://otstavnovdiploma-default-rtdb.europe-west1.firebasedatabase.app/")
                    .getReference()
                    .child("Questions")
                    .child(sec_temp)
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


        q1 = new Question("Basic",
                "Basic-1",
                "... - шаблон, определяющий переменные и методы, общие для всех его объектов определённого типа. Заполните пропуск",
                "Объект",
                "Класс",
                "Метод",
                "Интерфейс",
                "Класс");
        questionList.add(q1);
    }

    private void initView() {
        txtView = (TextView) getActivity().findViewById(R.id.txt_TestQuest);
        ans1 = (Button) getActivity().findViewById(R.id.btn_answer1);
        ans2 = (Button) getActivity().findViewById(R.id.btn_answer2);
        ans3 = (Button) getActivity().findViewById(R.id.btn_answer3);
        ans4 = (Button) getActivity().findViewById(R.id.btn_answer4);
    }

    private void loadResults() {
        User newUser = user;
        newUser.user_test_result = userTestResult;
        FirebaseDatabase dataBase = FirebaseDatabase.getInstance("https://otstavnovdiploma-default-rtdb.europe-west1.firebasedatabase.app");
        DatabaseReference usersRef = dataBase.getReference("Users");
        usersRef.child(newUser.getNumber()).setValue(newUser)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        Toast.makeText(getActivity(), "Загрузка результатов прошла успешно", Toast.LENGTH_SHORT).show();

                    }
                });
    }

}