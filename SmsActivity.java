package com.cdhgold.shop.sender;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

//sms 수신
public class SmsActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// Get the transferred data from source activity.
        Intent intent = getIntent();
        String message = intent.getStringExtra("sender");
        String contents = intent.getStringExtra("contents");
        String receivedDate = intent.getStringExtra("receivedDate");
        /*
        local storage에저장
        */



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

}
