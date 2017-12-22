package com2.example.imac.wellstick;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com2.example.imac.wellstick.Interface.Bottclick;
import com2.example.imac.wellstick.adapter.PjpAdapter;

/**
 * Created by imac on 12/21/17.
 */

public class TodatPjp extends AppCompatActivity implements Bottclick{


    AHBottomNavigation bottomNavigation;

    AHBottomNavigationItem item1,item2,item3;

    private Context context =  TodatPjp.this;

    private Dialog dialog;

    private  static String[] language ={"preet","pritesh","sai","Boss"};

    Calendar c ;

    String formattedDate2;

    private RecyclerView recyclerView;

    private PjpAdapter people_adapter;

    private List<String> strings ;

    private BottomSheetBehavior bottomSheetBehavior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.todaypjp);

        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        item1 = new AHBottomNavigationItem("Create PJP", R.drawable.ic_pencil);
         item2 = new AHBottomNavigationItem("View All", R.drawable.ic_format_list);
         item3 = new AHBottomNavigationItem("Performance", R.drawable.ic_checkbox_multiple);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);

        LinearLayoutManager llm = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(llm);


// Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);


        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

// Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);

// Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#8FBC8F"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

// Force to tint the drawable (useful for font with icon for example)
        bottomNavigation.setForceTint(true);

        bottomNavigation.setCurrentItem(-1);

        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheetLayout));

        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);


        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                 if(position == 0){

                     OpenPopUp();

                 }

                return true;
            }
        });



         c = Calendar.getInstance();

        SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");

         formattedDate2 = df2.format(c.getTime());


        people_adapter = new PjpAdapter(context,strings);

        recyclerView.setAdapter(people_adapter);

        people_adapter.notifyDataSetChanged();


        people_adapter.setClickListener(this);




    }



    private void OpenPopUp() {
        //Find screen size
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int smallerDimension = width < height ? width : height;
        smallerDimension = smallerDimension * 3 / 4;

        dialog = new Dialog(context);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //  dialog.getWindow().getAttributes().windowAnimations = R.style.animationdialog;
        dialog.setContentView(R.layout.popup);

        TextView date = (TextView) dialog.findViewById(R.id.date);

        date.setText(formattedDate2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,language);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv= (AutoCompleteTextView)dialog.findViewById(R.id.autoCompleteTextView1);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
 //       actv.setTextColor(Color.RED);


        // listView = (ListView) dialog.findViewById(R.id.listItems);



        //   searchView = (SearchView) dialog.findViewById(R.id.search);

        //




        //  searchView.setOnQueryTextListener(this);




        // Include dialog.xml file




        // Set dialog title
//            dialog.setTitle("Scan this code to redeem offer");

        // set values for custom dialog components - text, image and button
        dialog.show();


    }


    @Override
    public void onClick(View view, int position) {


        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

    }
}
