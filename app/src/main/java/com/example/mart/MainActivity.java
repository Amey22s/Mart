package com.example.mart;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.mart.ui.main.SectionsPagerAdapter;


public class MainActivity extends AppCompatActivity {

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    FloatingActionButton fab,fab1,fab2;
    Animation fabOpen,fabClose,rotateFwd,rotateBack;
    boolean isOpen = false;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar=(Toolbar)findViewById(R.id.toolbar);
        if (toolbar != null)
        {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setElevation(0); // or other
        }


        drawerLayout = (DrawerLayout)findViewById(R.id.menu);
        nav = (NavigationView)findViewById(R.id.navmenu);


        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.toggle_open,R.string.toggle_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);

        fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close);
        rotateFwd = AnimationUtils.loadAnimation(this,R.anim.rotate_forward);
        rotateBack = AnimationUtils.loadAnimation(this,R.anim.rotate_backward);


        getSupportFragmentManager().beginTransaction().replace(R.id.frag_con,new Home()).commit();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment frag;
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home:
                        frag = new Home();
                        break;

                    case R.id.orders:
                        frag = new Orders();
                        break;

                    case R.id.categories:
                        frag = new Categories();
                        break;

                    case R.id.contact:
                        frag = new Contact();
                        break;

                    case R.id.logout:
                        frag = new Logout();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_con,frag).addToBackStack("my fragment").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatefab();
            }

        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatefab();
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_con,new Cart()).addToBackStack("my fragment").commit();

            }

        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatefab();
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_con,new Settings()).addToBackStack("my fragment").commit();
            }

        });


    }

    private void animatefab() {
        if(isOpen)
        {
            fab.startAnimation(rotateFwd);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isOpen=false;
        }
        else
        {
            fab.startAnimation(rotateBack);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isOpen=true;
        }
    }

    @Override
    public void onBackPressed()
    {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
            return;
        }

        if(getFragmentManager().getBackStackEntryCount()>0)
        {
            getFragmentManager().popBackStack();
        }
        else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // Here I tell Android to inflate your menu
        inflater.inflate(R.menu.drawer_menu, menu);
        return true;
    }
}