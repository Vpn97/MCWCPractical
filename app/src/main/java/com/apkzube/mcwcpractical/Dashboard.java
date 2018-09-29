package com.apkzube.mcwcpractical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.apkzube.mcwcpractical.PracticalActivity.Practical_10;
import com.apkzube.mcwcpractical.PracticalActivity.Practical_3;
import com.apkzube.mcwcpractical.PracticalActivity.Practical_4;
import com.apkzube.mcwcpractical.PracticalActivity.Practical_5;
import com.apkzube.mcwcpractical.PracticalActivity.Practical_6;
import com.apkzube.mcwcpractical.PracticalActivity.Practical_7;
import com.apkzube.mcwcpractical.PracticalActivity.Practical_8;
import com.apkzube.mcwcpractical.PracticalActivity.Practical_9;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        allocation();
    }

    private void allocation() {

    }

    public void onBtnClick(View v){
        Intent nextIntent=new Intent(Dashboard.this, Practical_3.class);;
        switch (v.getId()){

            case R.id.btn3:
                nextIntent=new Intent(Dashboard.this, Practical_3.class);
                break;

            case R.id.btn4:

                nextIntent=new Intent(Dashboard.this, Practical_4.class);
                break;

            case R.id.btn5:
                nextIntent=new Intent(Dashboard.this, Practical_5.class);
                break;

            case R.id.btn6:
                nextIntent=new Intent(Dashboard.this, Practical_6.class);
                break;

            case R.id.btn7:
                nextIntent=new Intent(Dashboard.this, Practical_7.class);
                break;

            case R.id.btn8:
                nextIntent=new Intent(Dashboard.this, Practical_8.class);
                break;

            case R.id.btn9:
                nextIntent=new Intent(Dashboard.this, Practical_9.class);
                break;

            case R.id.btn10:
                nextIntent=new Intent(Dashboard.this, Practical_10.class);
                break;

        }
        startActivity(nextIntent);

    }
}
