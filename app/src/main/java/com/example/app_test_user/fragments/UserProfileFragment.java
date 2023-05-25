package com.example.app_test_user.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_test_user.R;
import com.example.app_test_user.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserProfileFragment extends Fragment {

    private User currentUser;
    private Button btn_fname, btn_sname, btn_pass, btn_save;
    private EditText edFirstNameProfile,edSecNameProfile,edEmailProfile,edNumberProfile,edPassProfile;

    public UserProfileFragment(User user) {
        currentUser = user;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public void onStart() {
        super.onStart();
        init();

        edFirstNameProfile.setText(currentUser.getFirst_name());
        edSecNameProfile.setText(currentUser.getSecond_name());
        edEmailProfile.setText(currentUser.getEmail());
        edNumberProfile.setText(currentUser.getNumber());
        edPassProfile.setText(currentUser.getPass());

        btn_fname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edFirstNameProfile.setEnabled(true);
            }
        });
        btn_sname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edSecNameProfile.setEnabled(true);
            }
        });
        btn_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edPassProfile.setEnabled(true);
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edFirstNameProfile.setEnabled(false);
                edSecNameProfile.setEnabled(false);
                edPassProfile.setEnabled(false);

                currentUser.first_name = edFirstNameProfile.getText().toString();
                currentUser.second_name = edSecNameProfile.getText().toString();
                currentUser.pass = edPassProfile.getText().toString();

                saveData();




            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {







        return inflater.inflate(R.layout.fragment_user_profile, container, false);
    }
    private void init(){
        edFirstNameProfile = (EditText) getActivity().findViewById(R.id.edFirstNameProfile);
        edSecNameProfile = (EditText) getActivity().findViewById(R.id.edSecondNameProfile);
        edEmailProfile = (EditText) getActivity().findViewById(R.id.edEmailProfile);
        edNumberProfile = (EditText) getActivity().findViewById(R.id.edNumberProfile);
        edPassProfile = (EditText) getActivity().findViewById(R.id.edPassProfile);

        btn_fname = (Button) getActivity().findViewById(R.id.btn_fname_change);
        btn_sname = (Button) getActivity().findViewById(R.id.btn_sname_change);
        btn_pass = (Button) getActivity().findViewById(R.id.btn_pass_change);
        btn_save = (Button) getActivity().findViewById(R.id.btn_save_user_info);

    }

    private void saveData() {
        User newUser = currentUser;
        FirebaseDatabase dataBase = FirebaseDatabase.getInstance("https://otstavnovdiploma-default-rtdb.europe-west1.firebasedatabase.app");
        DatabaseReference usersRef = dataBase.getReference("Users");
        usersRef.child(newUser.getNumber()).setValue(newUser)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        Toast.makeText(getActivity(), "Изменения сохранены", Toast.LENGTH_SHORT).show();

                    }
                });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.updatePassword(currentUser.getPass());
    }
}