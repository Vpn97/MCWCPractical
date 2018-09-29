package com.apkzube.mcwcpractical.PracticalActivity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.apkzube.mcwcpractical.R;

import java.util.List;

public class Practical_7 extends AppCompatActivity {

    EditText txtCount;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_7);
        allocation();
        setEvent();
    }

    private void allocation() {
        txtCount=findViewById(R.id.txtCount);
        btnNext=findViewById(R.id.btnNext);
    }

    private void setEvent() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=1;
                try {
                     count= Integer.parseInt(txtCount.getText().toString().trim());
                    if(count<=0){
                        txtCount.setError("input > 0");
                    }else{

                        startActivity(new Intent(Practical_7.this,Practical_7_New.class)
                                .putExtra("count",count));
                    }
                }catch (Exception e){
                    txtCount.setError("input not valid");
                }

            }
        });
    }
}
