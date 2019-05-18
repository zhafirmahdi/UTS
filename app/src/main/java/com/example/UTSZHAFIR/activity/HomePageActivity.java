package com.example.UTSZHAFIR.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.UTSZHAFIR.R;
import com.example.UTSZHAFIR.adapter.HomeAdapter;

public class HomePageActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //16-05-2019-10116368-ZHAFIR-MAHDI-IF-8
    FloatingActionButton btnFab;
    private int clickedNavItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        btnFab = findViewById(R.id.fab_mail_me);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Profile");

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                /**
                 * Change fragment for all items excluding nav_five
                 * as it opens up an Activity
                 */
                switch (clickedNavItem) {
                    case R.id.findme:
                        startActivity(new Intent(getApplicationContext(), FindMeActivity.class));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }

        });
        toggle.syncState();

        ViewPager pager = (ViewPager) findViewById(R.id.home_pager);
        HomeAdapter adapterHomePage = new HomeAdapter(getSupportFragmentManager());
        pager.setAdapter(adapterHomePage);
        pager.addOnPageChangeListener(viewPagerPageChangeListener);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.findme) {
                    clickedNavItem = R.id.findme;
                } else if (id == R.id.media) {
                    clickedNavItem = R.id.media;
                }

                drawer.closeDrawer(GravityCompat.START);

                return true;
            }
        });


        btnFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /* Do intent event listener */
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return true;
    }


    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == 1) {
                btnFab.hide();
            } else {
                if (position == 0) {
                    btnFab.setImageDrawable(getResources().getDrawable(R.drawable.mail_me));
                } else {
                    btnFab.setImageDrawable(getResources().getDrawable(R.drawable.icon_feed));
                }

                btnFab.show();
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };
}
