package com.example.app_test_user;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.app_test_user.databinding.TestLayoutBinding;
import com.example.app_test_user.fragments.TestResultFragment;
import com.example.app_test_user.fragments.TestingFragment;


public class TestActivity extends AppCompatActivity {

    private TestLayoutBinding mBinding = null;
    private Toolbar mToolbar = null;
    private Button startTest;
    private User curUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFields();
        mBinding = TestLayoutBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.profile:
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.home_main_container, new TestResultFragment(curUser.getUser_test_result()))
//                            .commit();
                    break;
                case R.id.test:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.home_main_container, new TestingFragment(curUser))
                            .commit();

                    break;
                case R.id.results:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.home_main_container, new TestResultFragment(curUser.getUser_test_result()))
                            .commit();
                    break;
                case R.id.exit:
                    Intent intent = new Intent(this, StartActivity.class);
                    startActivity(intent);
                    break;

            }




            return true;
        });

    }

    @Override
    protected void onStart() {
        super.onStart();


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

        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.home_main_container, new TestResultFragment(curUser.getUser_test_result()))
                    .commit();
        }


    }

    private void initFields() {

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

    }

}