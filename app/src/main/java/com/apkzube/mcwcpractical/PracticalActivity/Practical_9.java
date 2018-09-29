package com.apkzube.mcwcpractical.PracticalActivity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.apkzube.mcwcpractical.R;

public class Practical_9 extends AppCompatActivity {
    TextView txtColor;
    RelativeLayout layoutRel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_9);
        allocation();
        setEvent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        txtColor.setTextColor(getResources().getColor(R.color.black));
        switch (item.getItemId()) {


            case R.id.menu_red:
                layoutRel.setBackgroundColor(getResources().getColor(R.color.red));
                txtColor.setText("Color : #ff0000");
                return true;

            case R.id.menu_green:
                layoutRel.setBackgroundColor(getResources().getColor(R.color.green));
                txtColor.setText("Color : #00ff00");
                return true;
            case R.id.menu_blue:
                layoutRel.setBackgroundColor(getResources().getColor(R.color.blue));
                txtColor.setText("Color : #0000ff");

                return true;
            case R.id.menu_Orange:
                layoutRel.setBackgroundColor(getResources().getColor(R.color.orange));
                txtColor.setText("Color : #ff7300");
                return true;
            case R.id.menu_yellow:
                layoutRel.setBackgroundColor(getResources().getColor(R.color.yellow));
                txtColor.setText("Color : #ffff00");
                return true;

            case R.id.menu_Black:

                layoutRel.setBackgroundColor(getResources().getColor(R.color.black));
                txtColor.setText("Color : #000000");
                txtColor.setTextColor(getResources().getColor(R.color.white));

                return true;
            case R.id.menu_white:

                layoutRel.setBackgroundColor(getResources().getColor(R.color.white));
                txtColor.setText("Color : #ffffff");
                
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void allocation() {
        txtColor = findViewById(R.id.txtColor);
        layoutRel = findViewById(R.id.layoutRel);
    }

    private void setEvent() {

        layoutRel.setBackgroundColor(getResources().getColor(R.color.white));
        txtColor.setText("Color : #ffffff");
    }
}
