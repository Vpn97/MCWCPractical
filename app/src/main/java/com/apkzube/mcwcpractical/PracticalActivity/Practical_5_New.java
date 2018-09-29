package com.apkzube.mcwcpractical.PracticalActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apkzube.mcwcpractical.R;

public class Practical_5_New extends AppCompatActivity {

    TextView txtInfo;
    Button btnOK;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_5__new);
        allocation();
        setEvent();
    }

    private void allocation() {
        username=getIntent().getStringExtra("username");
        txtInfo=findViewById(R.id.txtInfo);
        btnOK=findViewById(R.id.btnOK);

        txtInfo.setText("Welcome "+username);
    }

    private void setEvent() {
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
