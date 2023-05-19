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
import com.example.app_test_user.fragments.TestResultFragment;
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

    private AppDrawer mAppDrawer = null;
    private TestLayoutBinding mBinding = null;
    private Toolbar mToolbar = null;
    private Button startTest;
    private User curUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = TestLayoutBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


    }

    @Override
    protected void onStart() {
        super.onStart();
        initFields();
        setSupportActionBar(mToolbar);
        mAppDrawer.create();

        if (curUser.user_test_result.pointsAll != 0) {
            startTest = findViewById(R.id.btn_startTest);
            startTest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.home_main_container, new TestingFragment(curUser))
                            .commit();
                }
            });

        }
        else{
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.home_main_container, new TestResultFragment(curUser.getUser_test_result()))
                    .commit();
        }
    }

    private void initFields() {
        mToolbar = mBinding.mainToolbar;
        Bundle arguments = getIntent().getExtras();

        curUser = new User();
        curUser.first_name = arguments.get("userFName").toString();
        curUser.second_name = arguments.get("userSName").toString();
        curUser.email = arguments.get("userEmail").toString();
        curUser.number = arguments.get("userNumber").toString();
        curUser.pass = arguments.get("userPass").toString();

        curUser.user_test_result = new TestResult();
        curUser.user_test_result.pointsAll = arguments.getInt("pointsAll");
        curUser.user_test_result.pointsBasic = arguments.getInt("pointsBasic");
        curUser.user_test_result.pointsCollections = arguments.getInt("pointsCol");
        curUser.user_test_result.pointsExceptions = arguments.getInt("pointsExc");
        curUser.user_test_result.pointsOOP = arguments.getInt("pointsOOP");
        curUser.user_test_result.pointsOperators = arguments.getInt("pointsOper");

        mAppDrawer = new AppDrawer(this, mToolbar, curUser);

    }


}