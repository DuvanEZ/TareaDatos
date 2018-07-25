package com.duvanez7.tareadatos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText textInputEmail;
    private EditText textInputUsername;
    private EditText textInputPhone;
    private EditText textInputDesc;
    private TextView mDisplayDate;
    private String desc;
    private String phoneInput;
    private String emailInpunt;
    private String usernameInput;
    private String date;
    private DatePickerDialog.OnDateSetListener  mDateSetListener;
    private static final String TAG = "MyActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mDisplayDate = findViewById(R.id.tvDate);
        textInputEmail = findViewById(R.id.text_input_email);
        textInputUsername =findViewById(R.id.text_input_username);
        textInputDesc = findViewById(R.id.text_input_Desc);
        textInputPhone= findViewById(R.id.text_input_Tel);

        fecha();//Muestra el tablero de selección de la

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String name  = pref.getString("name",usernameInput);
        String email = pref.getString("email",emailInpunt);
        String phone = pref.getString("phone",phoneInput);
        String date1 = pref.getString("date",date);
        String desc1 = pref.getString("desc",desc);
        textInputUsername.setText(name);
        mDisplayDate.setText(date1);
        textInputEmail.setText(email);
        textInputDesc.setText(desc1);
        textInputPhone.setText(phone);



    }
    private boolean validateEmail(){
        emailInpunt=  textInputEmail.getText().toString().trim();// trim remove the empty spaces
        if(emailInpunt.isEmpty()){
            textInputEmail.setError("Field can't be empty");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }
    private boolean validateUsername(){
        usernameInput= textInputUsername.getText().toString().trim();

        if (usernameInput.isEmpty()){
            textInputUsername.setError("Field can't be empty");
            return false;
        } else {
            textInputUsername.setError(null);
            return true;

        }

    }
    private boolean validateDesc(){
        desc = textInputDesc.getText().toString().trim();

        if (desc.isEmpty()){
            textInputUsername.setError("Field can't be empty");
            return false;
        } else {
            textInputUsername.setError(null);
            return true;

        }

    }
    private boolean validatePhone(){
         phoneInput =  textInputPhone.getText().toString().trim();// trim remove the empty spaces
        if(phoneInput.isEmpty()){
            textInputEmail.setError("Field can't be empty");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }
    public void confirmInput(View v){
        if(!validateEmail()| !validateUsername()| !validateDesc()| !validateDesc()| !validatePhone()) {
            return;
        }
        Intent intent = new Intent(MainActivity.this, Datos.class);
        intent.putExtra("Nombre",usernameInput);
        intent.putExtra("Email",emailInpunt);
        intent.putExtra("Phone",phoneInput);
        intent.putExtra("Date", date);
        intent.putExtra("Desc", desc);
        startActivity(intent);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor    editor = pref.edit();
        editor.putString("name",usernameInput);
        editor.putString("email",emailInpunt);
        editor.putString("phone",phoneInput);
        editor.putString("date",date);
        editor.putString("desc",desc);


        editor.apply();
        finish();


    }

    public void fecha (){
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener, year, month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month= month + 1;
                Log.d(TAG, "onDateSet:  mm/dd/yyy:" + month + "/" + day + "/" + year);

                date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);

            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();

    }
    protected void onResume(){
        super.onResume();

    } // Corriendo
    @Override
    protected void onRestart() {
        super.onRestart();


    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
