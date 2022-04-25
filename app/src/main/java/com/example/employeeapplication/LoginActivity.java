package com.example.employeeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button btnlogin;
    EditText txtusername,txtpassword;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="email";
    private static final String KEY_PASSWORD="password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnlogin=findViewById(R.id.btnlogin);
        txtusername=findViewById(R.id.txtusername);
        txtpassword=findViewById(R.id.txtpassword);

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name=sharedPreferences.getString(KEY_NAME,null);
        if(name!=null)
        {
            Intent i=new Intent(LoginActivity.this,MainActivity2.class);
            startActivity(i);
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(KEY_NAME,txtusername.getText().toString());
                editor.putString(KEY_PASSWORD,txtpassword.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_LONG).show();
                Intent i=new Intent(LoginActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
    }
}