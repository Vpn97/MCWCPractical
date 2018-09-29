package com.apkzube.mcwcpractical.PracticalActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import com.apkzube.mcwcpractical.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Practical_8 extends AppCompatActivity {

    Spinner spnMenu;
    ImageView imgMenu;
    ArrayList<Integer> menuList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_8);
        allocation();
        setEvent();

    }

    private void allocation() {
        spnMenu=findViewById(R.id.spnMenu);
        imgMenu=findViewById(R.id.imgMenu);
        menuList=new ArrayList<Integer>();
        menuList.add(R.mipmap.java);
        menuList.add(R.mipmap.python);
        menuList.add(R.mipmap.android);
        menuList.add(R.mipmap.html);
        menuList.add(R.mipmap.css);
        menuList.add(R.mipmap.js);
        menuList.add(R.mipmap.php);
        menuList.add(R.mipmap.dotnet);
    }

    private void setEvent() {
        spnMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imgMenu.setImageResource(menuList.get(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
