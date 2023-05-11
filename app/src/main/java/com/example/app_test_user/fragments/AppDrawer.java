package com.example.app_test_user.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.app_test_user.R;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;

public class AppDrawer{

    private AppCompatActivity mainActivity = null;
    private Toolbar toolbar = null;


    public AppDrawer(AppCompatActivity mainActivity, Toolbar toolbar){

        this.mainActivity = mainActivity;
        this.toolbar = toolbar;

    }
    private Drawer mDrawer = null;
    private AccountHeader mHeader = null;

    public void create () {
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
                                .withSelectable(false)).build();
                                //.withIcon(R.drawable.ic_menu_create_channel),

    }

    private void createHeader() {
        mHeader = new AccountHeaderBuilder()
                .withActivity(mainActivity)
                .withHeaderBackground(R.drawable.header_bg)
                .addProfiles(
                        new ProfileDrawerItem().withName("Sanya NYan")
                                .withEmail("+79111111111")
                ).build();
    }



}
