package com.example.app_test_user.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_test_user.CreateTestActivity;
import com.example.app_test_user.Question;
import com.example.app_test_user.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ChangeQuestionFragment extends Fragment {

    private EditText ed_Section, ed_Id, ed_Text, ed_Answer1, ed_Answer2, ed_Answer3, ed_Answer4, ed_Correct_answer;
    private Button btnAdd;
    long numb = 0;

    String id = "0";
    private FirebaseDatabase db;
    private DatabaseReference questions;
    private final String QUESTION_K = "Questions";

    public ChangeQuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        }

//        public void init() {
//
//
////        ed_Section.setText("ООП");
////        ed_Id.setText("ООП-1");
////        ed_Text.setText("Java - это ... язык программирования. Заполните пропуск");
////        ed_Answer1.setText("объектно-ориентированный");
////        ed_Answer2.setText("функциональный");
////        ed_Answer3.setText("теоретический");
////        ed_Answer4.setText("Все варианты");
////        ed_Correct_answer.setText("объектно-ориентированный");
//        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_question, container, false);

        ed_Section = view.findViewById(R.id.edSection);
        ed_Id = view.findViewById(R.id.edNumbQuestion);
        ed_Text = view.findViewById(R.id.edQuestion);
        ed_Answer1 = view.findViewById(R.id.edAnswer1);
        ed_Answer2 = view.findViewById(R.id.edAnswer2);
        ed_Answer3 = view.findViewById(R.id.edAnswer3);
        ed_Answer4 = view.findViewById(R.id.edAnswer4);
        btnAdd = view.findViewById(R.id.btn_add_question);
        ed_Correct_answer = view.findViewById(R.id.edCorrectAnswer);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String section = ed_Section.getText().toString();
                String id = ed_Id.getText().toString();
                String text = ed_Text.getText().toString();
                String answer1 = ed_Answer1.getText().toString();
                String answer2 = ed_Answer2.getText().toString();
                String answer3 = ed_Answer3.getText().toString();
                String answer4 = ed_Answer4.getText().toString();
                String correct_answer = ed_Correct_answer.getText().toString();


                if (TextUtils.isEmpty(section)) {
                    Toast.makeText(getActivity(), "Пожалуйста, введите раздел", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(id)) {
                    Toast.makeText(getActivity(), "Пожалуйста, введите номер вопроса", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(text)) {
                    Toast.makeText(getActivity(), "Пожалуйста, введите текст вопроса", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(answer1)) {
                    Toast.makeText(getActivity(), "Пожалуйста, введите первый вариант ответа", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(answer2)) {
                    Toast.makeText(getActivity(), "Пожалуйста, введите второй вариант ответа", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(answer3)) {
                    Toast.makeText(getActivity(), "Пожалуйста, введите третий вариант ответа", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(answer4)) {
                    Toast.makeText(getActivity(), "Пожалуйста, введите четвертый вариант ответа", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(correct_answer)) {
                    Toast.makeText(getActivity(), "Пожалуйста, введите правильный вариант ответа", Toast.LENGTH_SHORT).show();
                } else {
                    Question newQuestion = new Question(section, id, text, answer1, answer2, answer3, answer4, correct_answer);
                    questions.child(newQuestion.getSection()).child(newQuestion.getId()).setValue(newQuestion);
                    Toast.makeText(getActivity(), "Вопрос успешно добавлен", Toast.LENGTH_SHORT).show();
                }

            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        db = FirebaseDatabase.getInstance("https://otstavnovdiploma-default-rtdb.europe-west1.firebasedatabase.app");
        questions = db.getReference(QUESTION_K);

    }

}