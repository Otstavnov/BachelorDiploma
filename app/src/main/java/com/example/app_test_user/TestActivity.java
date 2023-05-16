package com.example.app_test_user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app_test_user.databinding.TestLayoutBinding;
import com.example.app_test_user.fragments.AppDrawer;
import com.example.app_test_user.fragments.TestingFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {


    Button btn_answer1, btn_answer2, btn_answer3, btn_answer4, btn_load;
    TextView txt_question;
    private FirebaseDatabase database;
    private DatabaseReference questions;
    private final String QUESTION_K = "Questions";

    public String user_num;


    private AppDrawer mAppDrawer = null;
    private TestLayoutBinding mBinding = null;
    private Toolbar mToolbar = null;
private Button startTest;

    //private DatabaseReference mDatabase = FirebaseDatabase.getInstance("https://otstavnovdiploma-default-rtdb.europe-west1.firebasedatabase.app").getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = TestLayoutBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        //init();
        //onClickLoad();

    }

    @Override
    protected void onStart() {
        super.onStart();
        initFields();
        setSupportActionBar(mToolbar);
        mAppDrawer.create();

        startTest = findViewById(R.id.btn_startTest);
        startTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.home_main_container, new TestingFragment())
                        .commit();
            }
        });

    }

    private void initFields() {
        mToolbar = mBinding.mainToolbar;
        mAppDrawer = new AppDrawer(this, mToolbar, user_num);

    }
}

//    public void init(){
//        btn_answer1 = findViewById(R.id.btn_answer1);
//        btn_answer2 = findViewById(R.id.btn_answer2);
//        btn_answer3 = findViewById(R.id.btn_answer3);
//        btn_answer4 = findViewById(R.id.btn_answer4);
//        txt_question = findViewById(R.id.txt_TestQuest);
//
//        listQuest = new ArrayList<>();
//
//        database = FirebaseDatabase.getInstance("https://otstavnovdiploma-default-rtdb.europe-west1.firebasedatabase.app");
//        questions = database.getReference(QUESTION_K);
//    }
//    private void loadDataBaseQuestion(){
//        ValueEventListener vListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(listQuest.size()>0)listQuest.clear();
//                for(DataSnapshot ds : snapshot.getChildren()){
//                    Question question = ds.child("Questions").child("ООП").getValue(Question.class);
//                    listQuest.add(question);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        };
//
//    }
//    private void onClickLoad(){
//        btn_load.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadDataBaseQuestion();
//                Question question = listQuest.get(0);
//                txt_question.setText(question.getText());
//                btn_answer1.setText(question.getAnswer1());
//                btn_answer2.setText(question.getAnswer2());
//                btn_answer3.setText(question.getAnswer3());
//                btn_answer4.setText(question.getAnswer4());
//            }
//        });
//    }
//}