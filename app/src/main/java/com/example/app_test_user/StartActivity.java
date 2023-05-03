package com.example.app_test_user;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.app_test_user.databinding.ActivityStartBinding;
import com.example.app_test_user.fragments.LoginFragment;

public class StartActivity extends AppCompatActivity {

    private ActivityStartBinding mBinding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.start_main_container, new LoginFragment())
                .commit();
    }
}