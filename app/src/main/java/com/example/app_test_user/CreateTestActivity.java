package com.example.app_test_user;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateTestActivity extends AppCompatActivity {


    EditText ed_Section, ed_Id, ed_Text, ed_Answer1, ed_Answer2, ed_Answer3, ed_Answer4, ed_Correct_answer;
    Button btnAdd;
    long numb = 0;

    String id = "0";
    private FirebaseDatabase db;
    private DatabaseReference questions;
    private final String QUESTION_K = "Questions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_test);

        init();

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
                    Toast.makeText(CreateTestActivity.this, "Пожалуйста, введите раздел", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(id)) {
                    Toast.makeText(CreateTestActivity.this, "Пожалуйста, введите номер вопроса", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(text)) {
                    Toast.makeText(CreateTestActivity.this, "Пожалуйста, введите текст вопроса", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(answer1)) {
                    Toast.makeText(CreateTestActivity.this, "Пожалуйста, введите первый вариант ответа", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(answer2)) {
                    Toast.makeText(CreateTestActivity.this, "Пожалуйста, введите второй вариант ответа", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(answer3)) {
                    Toast.makeText(CreateTestActivity.this, "Пожалуйста, введите третий вариант ответа", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(answer4)) {
                    Toast.makeText(CreateTestActivity.this, "Пожалуйста, введите четвертый вариант ответа", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(correct_answer)) {
                    Toast.makeText(CreateTestActivity.this, "Пожалуйста, введите правильный вариант ответа", Toast.LENGTH_SHORT).show();
                } else {
                    Question newQuestion = new Question(section, id, text, answer1, answer2, answer3, answer4, correct_answer);
                    questions.child(newQuestion.getSection()).child(newQuestion.getId()).setValue(newQuestion);
                    Toast.makeText(CreateTestActivity.this, "Вопрос успешно добавлен", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    public void init() {
        ed_Section = findViewById(R.id.edSection);
        ed_Id = findViewById(R.id.edNumbQuestion);
        ed_Text = findViewById(R.id.edQuestion);
        ed_Answer1 = findViewById(R.id.edAnswer1);
        ed_Answer2 = findViewById(R.id.edAnswer2);
        ed_Answer3 = findViewById(R.id.edAnswer3);
        ed_Answer4 = findViewById(R.id.edAnswer4);
        btnAdd = findViewById(R.id.btn_add_question);
        ed_Correct_answer = findViewById(R.id.edCorrectAnswer);
        db = FirebaseDatabase.getInstance("https://otstavnovdiploma-default-rtdb.europe-west1.firebasedatabase.app");
        questions = db.getReference(QUESTION_K);
    }
}



