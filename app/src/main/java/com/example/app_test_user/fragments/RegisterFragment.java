package com.example.app_test_user.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_test_user.R;
import com.example.app_test_user.TestActivity;
import com.example.app_test_user.TestResult;
import com.example.app_test_user.User;
import com.example.app_test_user.databinding.FragmentRegisterBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterFragment extends Fragment {

    EditText edFirstName, edSecName, edEmail, edNumber, edPass;
    Button btnReg;

    private FirebaseAuth usersAuth;
    private FirebaseDatabase db;
    private DatabaseReference usersRef;
    private final String USER_K = "Users";

    private FragmentRegisterBinding mBinding = null;

    public RegisterFragment() {
        super(R.layout.fragment_register);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        edFirstName = view.findViewById(R.id.edFirstNameReg);
        edSecName = view.findViewById(R.id.edSecNameReg);
        edEmail = view.findViewById(R.id.edEmailReg);
        edNumber = view.findViewById(R.id.edNumberReg);
        edPass = view.findViewById(R.id.edPassReg);
        btnReg = view.findViewById(R.id.btn_reg);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TestActivity.class);

                String fname = edFirstName.getText().toString();
                String sname = edSecName.getText().toString();
                String email = edEmail.getText().toString();
                String number = edNumber.getText().toString();
                String pass = edPass.getText().toString();

                intent.putExtra("numKey", number);


                if (TextUtils.isEmpty(fname)) {
                    Toast.makeText(getActivity(), "Пожалуйста, введите имя", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(sname)) {
                    Toast.makeText(getActivity(), "Пожалуйста, введите фамилию", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getActivity(), "Пожалуйста, введите почту", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(number)) {
                    Toast.makeText(getActivity(), "Пожалуйста, введите номер телефона", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(sname)) {
                    Toast.makeText(getActivity(), "Пожалуйста, введите фамилию", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(getActivity(), "Пожалуйста, введите пароль", Toast.LENGTH_SHORT).show();
                } else if (pass.length() < 6) {
                    Toast.makeText(getActivity(), "Минимальная длина пароля - 6 символов", Toast.LENGTH_SHORT).show();
                } else {

                    usersAuth.createUserWithEmailAndPassword(email, pass)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    User newUser = new User(fname, sname, email, number, pass);
                                    newUser.user_test_result = new TestResult();
                                    usersRef.child(newUser.getNumber()).setValue(newUser)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {
                                                    intent.putExtra("userFName", newUser.getFirst_name());
                                                    intent.putExtra("userSName", newUser.getSecond_name());
                                                    intent.putExtra("userEmail", newUser.getEmail());
                                                    intent.putExtra("userNumber", newUser.getNumber());
                                                    intent.putExtra("userPass", newUser.getPass());
                                                    Toast.makeText(getActivity(), "Регистрация прошла успешно", Toast.LENGTH_SHORT).show();
                                                    startActivity(intent);
                                                }
                                            });
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });
                }
            }
        });


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        init();
    }

    public void init() {
        usersAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance("https://otstavnovdiploma-default-rtdb.europe-west1.firebasedatabase.app");
        usersRef = db.getReference(USER_K);
    }

}