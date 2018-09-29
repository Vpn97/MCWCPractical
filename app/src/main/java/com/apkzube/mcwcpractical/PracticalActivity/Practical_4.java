package com.apkzube.mcwcpractical.PracticalActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.service.autofill.RegexValidator;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.apkzube.mcwcpractical.R;


import java.util.Date;
import java.util.regex.Pattern;

public class Practical_4 extends AppCompatActivity {

    TextInputEditText txtUsername,txtPassword,txtEmail,txtPhone,txtInterests;
    EditText txtBirthdate;
    AutoCompleteTextView txtCountry;
    Button btnSubmit;
    RadioGroup rdoGrpGender;
    RadioButton rdoMale,rdoFemale;
    Spinner spnState;
    Boolean spnValid;
    ImageButton btnDatePicker;
    TextView txtSpnError;


    int day,month,year;
    Calendar mCalendar;

    String username,password,email,phone,intrests,gender,dob,state,country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_4);
        allocation();
        setEvent();
    }



    @SuppressLint("NewApi")
    private void allocation() {

        txtUsername=findViewById(R.id.txtUsername);
        txtPassword=findViewById(R.id.txtPassword);
        txtEmail=findViewById(R.id.txtEmail);
        txtPhone=findViewById(R.id.txtPhone);
        txtInterests=findViewById(R.id.txtInterests);
        txtCountry=findViewById(R.id.txtCountry);
        txtBirthdate=findViewById(R.id.txtBirthdate);
        btnSubmit=findViewById(R.id.btnSubmit);
        rdoGrpGender=findViewById(R.id.rdoGrpGender);
        rdoMale=findViewById(R.id.rdoMale);
        rdoFemale=findViewById(R.id.rdoFemale);
        spnState=findViewById(R.id.spnState);
        btnDatePicker=findViewById(R.id.btnDatePicker);
        txtSpnError=findViewById(R.id.txtSpnError);



    }

    @SuppressLint("NewApi")
    private void setEvent() {
        //set country auto text
        String[] autoCountry=getResources().getStringArray(R.array.contry);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,autoCountry);
        txtCountry.setAdapter(arrayAdapter);


        GregorianCalendar calendar=new GregorianCalendar();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month=calendar.get(Calendar.MONTH);
        year=calendar.get(Calendar.YEAR);
        txtBirthdate.setText(day+"/"+month+"/"+year);

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
           @SuppressLint("NewApi")
           @Override
           public void onClick(View v) {


            DatePickerDialog dialog=new DatePickerDialog(Practical_4.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    txtBirthdate.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            },year,month,day);
            dialog.getDatePicker().setMaxDate(new Date().getDate());
            dialog.getDatePicker().init(year,month,day,null);
               dialog.show();

           }

       });


        //select state from spinner
        //spnState.setPrompt("State");
        spnState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] statesStrings=getResources().getStringArray(R.array.states);
                if(position==0){
                    spnValid=false;
                }else {
                    state = statesStrings[position];
                    spnValid=true;
                }
              //  Toast.makeText(Practical_4.this, state, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //phone num validation
        txtPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String phone=txtPhone.getText().toString().trim();
                if(!hasFocus){
                    if(phone.length()<10){
                        if(phone.length()==0){
                            txtPhone.setError("enter phone number");
                        }else {
                            txtPhone.setError("not valid");
                        }
                    }
                }
            }
        });

        //btnSubmit Click
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //select gender from radio group

                int rdoID=rdoGrpGender.getCheckedRadioButtonId();
                if(rdoID==R.id.rdoMale){
                    gender="Male";
                }else{
                    gender="Female";
                }
               // Toast.makeText(Practical_4.this, gender, Toast.LENGTH_SHORT).show();



                if(isValid()){

                    final AlertDialog.Builder cDialog=new AlertDialog.Builder(Practical_4.this);
                    LayoutInflater inflater=LayoutInflater.from(Practical_4.this);
                    final View infoView =inflater.inflate(R.layout.custom_dialogbox,null);

                    cDialog.setView(infoView);
                    cDialog.setTitle("User Information");
                    TextView txtUserinfo=infoView.findViewById(R.id.txtUserinfo);

                    txtUserinfo.setText("Username : "+username+"\n"+
                            "Password : "+password+"\n"+
                            "Email : "+email+"\n"+
                            "Phone : "+phone+"\n"+
                            "Country : "+country+"\n"+
                            "State : "+state+"\n"+
                            "Gender : "+gender+"\n"+
                            "Interests : "+intrests+"\n"+
                            "DOB : "+dob
                    );
                    cDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            cDialog.create().dismiss();
                            finish();
                        }
                    });
                    cDialog.create().show();


                }else{
                    Toast.makeText(Practical_4.this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValid() {
        boolean b=true;
        String phone=txtPhone.getText().toString().trim();
        String email=txtEmail.getText().toString().trim();
        String username=txtUsername.getText().toString().trim();
        String password=txtPassword.getText().toString().trim();
        String country=txtCountry.getText().toString().trim();
        String interests=txtInterests.getText().toString().trim();
        String dob=txtBirthdate.getText().toString().trim();

        if(username.length()==0 || !Pattern.matches("^[a-zA-Z0-9_-]{6,14}$",username)){
            b=false;
            txtUsername.setError("Username should be 6-14 length");
        }else{
            this.username=username;
        }

        if(password.length()==0 || !Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$",password)){
            b=false;
            if(password.length()<8){
             txtPassword.setError("length between 8-16");
            }else {
                txtPassword.setError("Must contain @#$%^&=+");
            }
        }else{
            this.password=password;
        }



        if(phone.length()<10){
            if(phone.length()==0){
            txtPhone.setError("enter phone number");
            }else {
                txtPhone.setError("not valid");
            }
            b=false;
        }else{
            this.phone=phone;
        }

        if(!Pattern.matches("\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}",email)){
            b=false;
            txtEmail.setError("not valid email");
        }else{
            this.email=email;
        }
        if(!spnValid){
            b=false;
            txtSpnError.setText("Setect State Please");
            //Toast.makeText(this, "Setect State Please", Toast.LENGTH_SHORT).show();
        }else{
            txtSpnError.setText("");
        }
        if(country.length()==0){
            txtCountry.setError("enter country");
            b=false;
        }else{
            this.country=country;
        }

        if(interests.length()==0){
            txtInterests.setError("enter interests");
            b=false;
        }else{
            this.intrests=interests;
        }

        if(dob.length()==0){
            b=false;
            txtBirthdate.setError("select DOB");
        }else{
            this.dob=dob;
        }


        return b;
    }
}
