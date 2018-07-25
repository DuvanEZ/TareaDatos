package com.duvanez7.tareadatos;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Datos extends AppCompatActivity {

    private TextView mNombre;
    private TextView mPhone;
    private TextView mDate;
    private TextView mEmail;
    private TextView mDesc;
    private String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        mNombre = findViewById(R.id.tvNombre);
        mPhone  = findViewById(R.id.tvTel);
        mDate   = findViewById(R.id.tvDate);
        mEmail  = findViewById(R.id.tvEmail);
        mDesc   = findViewById(R.id.tvDesc);

        Bundle parametros = getIntent().getExtras();
        nombre            = parametros.getString("Nombre");
        String phone = parametros.getString("Phone");
        String date = parametros.getString("Date");
        String email = parametros.getString("Email");
        String desc = parametros.getString("Desc");

        mNombre.setText(nombre);
        mPhone.setText(phone);
        mDate.setText(date);
        mEmail.setText(email);
        mDesc.setText(desc);





    }

    public void mEdit(View v){
        Intent intent = new Intent(Datos.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
