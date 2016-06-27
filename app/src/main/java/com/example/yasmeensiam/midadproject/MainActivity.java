package com.example.yasmeensiam.midadproject;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    // private NavigationView nvDrawer;
    private DrawerFragment drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerFragment= (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        drawerFragment.setUp(R.id.fragment,mDrawer,toolbar);


    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        Fragment fragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.nav_first_fragment:
                fragmentClass = live_broadcast.class;
                break;
            case R.id.nav_second_fragment:
                fragmentClass = recent_time.class;
                break;
            case R.id.nav_third_fragment:
                fragmentClass = favorite.class;
                break;
            default:
                fragmentClass = favorite.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawer.closeDrawers();
    }
//
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        // Pass any configuration change to the drawer toggles
//        drawerToggle.onConfigurationChanged(newConfig);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                mDrawer.openDrawer(GravityCompat.START);
//                return true;
//        }
//        if (drawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        drawerToggle.syncState();
//
//    }

}