package com.example.app_test_user.fragments;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.app_test_user.R;
import com.example.app_test_user.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;

import java.util.ArrayList;

public class AppDrawer {

    private AppCompatActivity mainActivity = null;
    private Toolbar toolbar = null;

    private String hhhuserId;

    private User curUser;


    public AppDrawer(AppCompatActivity mainActivity, Toolbar toolbar, User user) {

        this.mainActivity = mainActivity;
        this.toolbar = toolbar;
        curUser = user;

    }

    private Drawer mDrawer = null;
    private AccountHeader mHeader = null;

    public void create() {

        createHeader();
        createDrawer();
    }

    private void createDrawer() {

        mDrawer = new DrawerBuilder()
                .withActivity(mainActivity)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withSelectedItem(-1)
                .withAccountHeader(mHeader)
                .addDrawerItems(
                        new PrimaryDrawerItem().withIdentifier(100)
                                .withIconTintingEnabled(true)
                                .withName("Профиль")
                                .withSelectable(false),
                        //.withIcon(R.drawable.ic_menu_create_groups),
                        new PrimaryDrawerItem().withIdentifier(101)
                                .withIconTintingEnabled(true)
                                .withName("Пройти тест")
                                .withSelectable(false),
                        //.withIcon(R.drawable.ic_menu_secret_chat),
                        new PrimaryDrawerItem().withIdentifier(102)
                                .withIconTintingEnabled(true)
                                .withName("Результаты теста")
                                .withSelectable(false),
                        new PrimaryDrawerItem().withIdentifier(103)
                                .withIconTintingEnabled(true)
                                .withName("Настройки")
                                .withSelectable(false),
                        new PrimaryDrawerItem().withIdentifier(104)
                                .withIconTintingEnabled(true)
                                .withName("Выход")
                                .withSelectable(false)
                ).build();

    }

    private void createHeader() {


        mHeader = new AccountHeaderBuilder()
                .withActivity(mainActivity)
                .withHeaderBackground(R.drawable.header_bg)
                .addProfiles(
                        new ProfileDrawerItem().withName(curUser.getFirst_name() + " " + curUser.getSecond_name())
                                .withEmail(curUser.getNumber())
                ).build();
    }


}
