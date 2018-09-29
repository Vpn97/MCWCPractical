package com.apkzube.mcwcpractical.PracticalActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.apkzube.mcwcpractical.Car;
import com.apkzube.mcwcpractical.R;

public class Practical_10_New extends AppCompatActivity {

    TextView txtCmpName,txtColor,txtLaunchDate,txtModel;
    ImageView imageCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_10__new);
        allocation();
        setEvent();
    }

    private void allocation() {
        txtCmpName=findViewById(R.id.txtCmpName);
        txtColor=findViewById(R.id.txtColors);
        txtLaunchDate=findViewById(R.id.txtLaunchDate);
        txtModel=findViewById(R.id.txtModel);
        imageCar=findViewById(R.id.imageCar);
    }

    private void setEvent() {
        Car car=new Car(getIntent().getStringExtra("company"),
                getIntent().getStringExtra("model"),
                getIntent().getIntExtra("imgId",R.mipmap.a),
                getIntent().getStringExtra("colors"),
                getIntent().getStringExtra("launch_date"));

        txtCmpName.setText(car.getCompanyName());
        txtColor.setText(car.getCarColors());
        imageCar.setImageResource(car.getCarImg());
        txtLaunchDate.setText(car.getLaunchDate());
        txtModel.setText(car.getCarModelName());
    }
}
