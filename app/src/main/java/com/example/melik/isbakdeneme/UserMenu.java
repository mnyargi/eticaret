package com.example.melik.isbakdeneme;

import android.os.Bundle;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.widget.Toast;


public class UserMenu extends AppCompatActivity{

    android.support.v4.app.FragmentManager fragmentManager;

    public Toolbar toolbar;


    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Ilanlar");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        ProfileFragment proFragment = new ProfileFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, proFragment)
                .commit();//fragment sonundaaaaa



        final DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){

            @Override
            public void onDrawerClosed(View drawerView) {

                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {


                super.onDrawerOpened(drawerView);
            }
        };
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);

                drawerLayout.closeDrawers();

                switch (item.getItemId()){

                    case R.id.nav_camera:

                        AdsFragment adsFragment = new AdsFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container,adsFragment);
                        fragmentTransaction.commit();
                        toolbar.setTitle("İlanlar");
                        return true;

                    case R.id.nav_gallery:

                        CvFragment cvFragment = new CvFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.container,cvFragment);
                        fragmentTransaction1.commit();
                        toolbar.setTitle("cvler");
                        return true;

                    case R.id.nav_slideshow:

                        ApplyFragment applyFragment = new ApplyFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.container,applyFragment);
                        fragmentTransaction2.commit();
                        toolbar.setTitle("başvurular");
                        return true;

                    case  R.id.nav_manage:


                        ProfileFragment proFragment = new ProfileFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction3.replace(R.id.container,proFragment);//container içinde açılacak olan fragment
                        fragmentTransaction3.commit();
                        toolbar.setTitle("profil");
                        return  true;

                    default:
                        Toast.makeText(getApplicationContext(),"Yapım asamasında !!",Toast.LENGTH_SHORT).show();
                        return true;

                }

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
