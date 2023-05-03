package com.example.app_test_user.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.app_test_user.R;
import com.example.app_test_user.TestActivity;
import com.example.app_test_user.databinding.FragmentLoginBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class LoginFragment extends Fragment {

    EditText edLog, edPass;
    Button btn_SingIn;
    private FragmentLoginBinding mBinding = null;
    private FirebaseAuth usersAuth;
    private FirebaseDatabase db;
    private DatabaseReference users;
    private final String USER_K = "Users";

    public LoginFragment() {
        super(R.layout.fragment_login);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        edLog = view.findViewById(R.id.edLoginLog);
        edPass = view.findViewById(R.id.edPassLog);
        btn_SingIn = view.findViewById(R.id.btnSignIn);

        btn_SingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edLog.getText().toString();
                String pass = edPass.getText().toString();

                if(TextUtils.isEmpty(email))
                    Toast.makeText(getActivity(), "Введите логин", Toast.LENGTH_SHORT).show();
                if(TextUtils.isEmpty(pass))
                    Toast.makeText(getActivity(), "Введите пароль", Toast.LENGTH_SHORT).show();

                usersAuth.signInWithEmailAndPassword(email, pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Intent intent = new Intent(getActivity() , TestActivity.class);

                                Toast.makeText(getActivity(), "Успешная авторизация", Toast.LENGTH_SHORT).show();

                                startActivity(intent);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getActivity(), "Ошибка авторизации", Toast.LENGTH_SHORT).show();

                            }
                        });
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mBinding = FragmentLoginBinding.inflate(getLayoutInflater());
        init();
        getView().findViewById(R.id.btnGoToReg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getParentFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.start_main_container , new RegisterFragment()).commit();
            }
        });
    }

    public void init() {
        usersAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance("https://otstavnovdiploma-default-rtdb.europe-west1.firebasedatabase.app");
        users = db.getReference(USER_K);
    }



}