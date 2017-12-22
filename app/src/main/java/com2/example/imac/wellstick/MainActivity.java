package com2.example.imac.wellstick;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import com2.example.imac.wellstick.adapter.CustomGrid;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{


    public static final   String[] titles = new String[] { "Create Outlet", "Attendance", "Schedule", "Order", "Stock",
            "Activity Planner","Analysis","Offers","Target","Team","Naviation","Monthly Plan"};


   public static int[] imageId = {
            R.drawable.createoutlet,
            R.drawable.attendance,
            R.drawable.schedule,
            R.drawable.orders,
            R.drawable.stocks,
            R.drawable.planner,
            R.drawable.analysis,
            R.drawable.offers,
            R.drawable.targets,
            R.drawable.teamanagement,
            R.drawable.navigation,
            R.drawable.monthlyplan,


    };


    private CustomGrid customGrid;

    private  GridView grid;

    private Context context = MainActivity.this;
    private Toolbar toolbar;

    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        assert drawer != null;
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.inflateMenu(R.menu.drawermenu);

        grid=(GridView)findViewById(R.id.grid);


        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheetLayout));

        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        customGrid = new CustomGrid(context,titles,imageId);


        grid.setAdapter(customGrid);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {

                if (newState == BottomSheetBehavior.STATE_HIDDEN) {

                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });





    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.pjp){

            Intent intent = new Intent(context,TodatPjp.class);
            startActivity(intent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
