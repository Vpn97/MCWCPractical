package com.apkzube.mcwcpractical.PracticalActivity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apkzube.mcwcpractical.R;

import java.util.regex.Pattern;

public class Practical_5 extends AppCompatActivity {

    TextInputEditText txtUseerName,txtPass;
    TextView txtError;
    Button btnLogin;
    private String password;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_5);
        allocation();
        setEvent();
    }


    private void allocation() {
        txtUseerName=findViewById(R.id.txtUserName);
        txtError=findViewById(R.id.txtError);
        txtPass=findViewById(R.id.txtPass);
        btnLogin=findViewById(R.id.btnLogin);
    }
    private void setEvent() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid()){
                    startActivity(new Intent(Practical_5.this,Practical_5_New.class).putExtra("username",username));
                }
            }
        });

    }
    private boolean isValid() {
        boolean b=true;
        String username=txtUseerName.getText().toString().trim();
        String password=txtPass.getText().toString().trim();


        if(username.length()==0 || !Pattern.matches("^[a-zA-Z0-9_-]{6,14}$",username)){
            b=false;
            txtUseerName.setError("Username should be 6-14 length");
        }

        if(username.equals("vpn_97")){
            this.username=username;
        }else{
            b=false;
        }

        if(password.length()==0 || !Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$",password)){
            b=false;
            if(password.length()<8){
               // txtPass.setError("length between 8-16");
            }else {
              //  txtPass.setError("Must contain @#$%^&=+");
            }
        }
        if(password.equals("Vpn1012$@#")){
            this.password=password;
        }else{
            b=false;
            txtError.setText("Username and Password is wrong");
        }
        return b;
    }
}
