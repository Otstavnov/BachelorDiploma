package com.example.app_test_user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.app_test_user.databinding.ActivityAdminMainBinding;
import com.example.app_test_user.fragments.AdminUserCheckFragment;
import com.example.app_test_user.fragments.ChangeQuestionFragment;
import com.example.app_test_user.fragments.LoginFragment;
import com.example.app_test_user.fragments.TestResultFragment;
import com.example.app_test_user.fragments.TestingFragment;
import com.example.app_test_user.fragments.UserProfileFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class AdminMainActivity extends AppCompatActivity {

    public ActivityAdminMainBinding adminBinding = null;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private List<User> listUsers;

    private User user;

    private DatabaseReference mDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adminBinding = ActivityAdminMainBinding.inflate(getLayoutInflater());
        setContentView(adminBinding.getRoot());

        listView = findViewById(R.id.list_view_users);
        listData = new ArrayList<>();
        listUsers = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        if (listView != null) {
            listView.setAdapter(adapter);
        }
        mDataBase = FirebaseDatabase
                .getInstance("https://otstavnovdiploma-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference("Users");
        getData();
        setOnClickItem();

        adminBinding.bottomAdminNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.profileAdmin:
                    Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.admin_main_container);
                    getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                    break;

                case R.id.testAdmin:

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.admin_main_container, new ChangeQuestionFragment())
                                .commit();
                    break;


            }


            return true;
        });

    }
    private void getData() {
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (listData.size() > 0) listData.clear();
                if (listUsers.size() > 0) listUsers.clear();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    User user = ds.getValue(User.class);
                    TestResult res = user.getUser_test_result();
                    assert user != null;
                    listData.add(user.getFirst_name() + " " + user.getSecond_name()+ "\n" + res.getPointsAll()+ " баллов") ;
                    listUsers.add(user);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDataBase.addValueEventListener(valueEventListener);
    }
    private void setOnClickItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                user = listUsers.get(i);
                check();
            }
        });

    }

    public void check(){
        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.admin_main_container, new AdminUserCheckFragment(user))
                .commit();
    }
    @Override
    protected void onStart() {
        super.onStart();
    }


}