package com.example.app_test_user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.app_test_user.databinding.TestLayoutBinding;
import com.example.app_test_user.fragments.AppDrawer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TestActivity extends AppCompatActivity {

    private AppDrawer mAppDrawer = null;
    private TestLayoutBinding mBinding = null;
    private Toolbar mToolbar = null;

    private DatabaseReference mDatabase = FirebaseDatabase.getInstance("https://otstavnovdiploma-default-rtdb.europe-west1.firebasedatabase.app").getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = TestLayoutBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mDatabase.child("questions").child("java").child("Questions1");
        /*
        * -> variablse
        *   -> 1 : question1
        *       ->"awdawdawd 0"
        *       ->"wadawdaw 0"
        *       ->"wadwadw 1"
        *       ->"awdawdwa 0"
        *       -> 3
        * question = firebase.qusetion.split (" ")
        * question ["awdawdwa", 1]
        * question[0]
        *
        *


        *
        *
        *
        *
        * */


    }

    @Override
    protected void onStart() {
        super.onStart();
        initFields();
        setSupportActionBar(mToolbar);
        mAppDrawer.create();

    }

    private void initFields() {
        mToolbar = mBinding.mainToolbar;
        mAppDrawer = new AppDrawer(this , mToolbar);

    }
}