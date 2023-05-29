package com.example.app_test_user.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.app_test_user.R;
import com.example.app_test_user.TestResult;
import com.example.app_test_user.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminUserCheckFragment extends Fragment {

    private User userCheck;
    private TestResult userCheckResult;
    private EditText name, num, email, pass, allPoints, basic, collect, except, oop, oper;
    Button btn_delete;

    public AdminUserCheckFragment() {
        // Required empty public constructor
    }

    public AdminUserCheckFragment(User user) {
        this.userCheck = user;
        this.userCheckResult = user.user_test_result;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vview = inflater.inflate(R.layout.fragment_admin_user_check, container, false);
        name = vview.findViewById(R.id.edFullName);
        email = vview.findViewById(R.id.edCheckEmail);
        num = vview.findViewById(R.id.edCheckNum);
        pass = vview.findViewById(R.id.edCheckPass);
        allPoints = vview.findViewById(R.id.edCheckAllPoints);
        basic = vview.findViewById(R.id.edCheckBasic);
        collect = vview.findViewById(R.id.edCheckCollections);
        except = vview.findViewById(R.id.edCheckExceptions);
        oop = vview.findViewById(R.id.edCheckOOP);
        oper = vview.findViewById(R.id.edCheckOperators);
        btn_delete = vview.findViewById(R.id.btn_delete);

        return vview;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onStart() {
        super.onStart();
        name.setText(userCheck.getFirst_name() + " " + userCheck.getSecond_name());
        email.setText(userCheck.getEmail());
        num.setText(userCheck.getNumber());
        pass.setText(userCheck.getPass());
        allPoints.setText(String.valueOf(userCheckResult.getPointsAll()));
        basic.setText(String.valueOf(userCheckResult.getPointsBasic()));
        collect.setText(String.valueOf(userCheckResult.getPointsCollections()));
        except.setText(String.valueOf(userCheckResult.getPointsExceptions()));
        oop.setText(String.valueOf(userCheckResult.getPointsOOP()));
        oper.setText(String.valueOf(userCheckResult.getPointsOperators()));

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Удаляем соответствующую запись из базы данных Realtime Database Firebase
                DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://otstavnovdiploma-default-rtdb.europe-west1.firebasedatabase.app").getReference();
                databaseReference.child("Users").child(userCheck.getNumber()).removeValue();
            }
        });
    }
}