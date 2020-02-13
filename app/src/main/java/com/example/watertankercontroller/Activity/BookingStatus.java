package com.example.watertankercontroller.Activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.watertankercontroller.R;

public class BookingStatus extends AppCompatActivity implements View.OnClickListener {
    ImageView toolbar_notification;
    ActionBarDrawerToggle actionBarDrawerToggle;
    RelativeLayout bookingstatus,bookingform,tankerdetail,logout,completedbooking,pendingbooking,ongoingbooking,abortedbooking,toolbar_toggle;
    TextView name,mail;
    DrawerLayout navdrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_status);
        navdrawer = (DrawerLayout)findViewById(R.id.nav_drawer_bookingstatus);
        toolbar_toggle = (RelativeLayout) findViewById(R.id.rl_toolbar_menu);
        toolbar_notification = (ImageView)findViewById(R.id.iv_toolabar_notification);
        toolbar_notification.setOnClickListener(this);
        name = (TextView)findViewById(R.id.tv_nav_name);
        mail = (TextView)findViewById(R.id.tv_nav_username);
        bookingstatus = (RelativeLayout)findViewById(R.id.rl_nav_bookingstatus);
        bookingstatus.setOnClickListener(this);
        bookingform = (RelativeLayout)findViewById(R.id.rl_nav_bookingform);
        bookingform.setOnClickListener(this);
        tankerdetail = (RelativeLayout)findViewById(R.id.rl_nav_tankerdetails);
        tankerdetail.setOnClickListener(this);
        logout = (RelativeLayout)findViewById(R.id.rl_nav_logout);
        logout.setOnClickListener(this);
        completedbooking = (RelativeLayout)findViewById(R.id.rl_bookingstatus_completed);
        completedbooking.setOnClickListener(this);
        pendingbooking = (RelativeLayout)findViewById(R.id.rl_bookingstatus_pending);
        pendingbooking.setOnClickListener(this);
        ongoingbooking = (RelativeLayout)findViewById(R.id.rl_bookingstatus_ongoing);
        ongoingbooking.setOnClickListener(this);
        abortedbooking = (RelativeLayout)findViewById(R.id.rl_bookingstatus_aborted);
        abortedbooking.setOnClickListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, navdrawer,
                R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };
        navdrawer.setScrimColor(Color.TRANSPARENT);
        navdrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navdrawer.setDrawerElevation(0f);
        toolbar_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerMenu(view);
            }
        });
    }

    public void drawerMenu (View view ){
        navdrawer.openDrawer(Gravity.LEFT);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        navdrawer.closeDrawers();
        switch(view.getId()){
            case R.id.rl_nav_bookingstatus:
                break;
            case R.id.rl_nav_bookingform:
                intent = new Intent(BookingStatus.this,BookingForm.class);
                startActivity(intent);
                break;
            case R.id.rl_nav_tankerdetails:
                intent = new Intent(BookingStatus.this,TankerDetails.class);
                startActivity(intent);
                break;
            case R.id.rl_nav_logout:
                intent = new Intent(BookingStatus.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.rl_bookingstatus_completed:
                intent = new Intent(BookingStatus.this,CompletedActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_bookingstatus_pending:
                intent = new Intent(BookingStatus.this,PendingActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_bookingstatus_ongoing:
                intent = new Intent(BookingStatus.this,OngoingActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_bookingstatus_aborted:
                intent = new Intent(BookingStatus.this,AbortedActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_toolabar_notification:
                intent = new Intent(BookingStatus.this,NotificationActivity.class);
                startActivity(intent);
                break;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}