package com.example.employeeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity5 extends AppCompatActivity {
    EditText txtName,txtdata;
    Button btnsave,btnread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        txtName=findViewById(R.id.txtName);
        txtdata=findViewById(R.id.txtdata);
        btnread=findViewById(R.id.btnread);
        btnsave=findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename=txtName.getText().toString();
                String data=txtdata.getText().toString();
                FileOutputStream fos;
                try {
                    fos=openFileOutput(filename, Context.MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(),filename+"saved",Toast.LENGTH_LONG).show();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename=txtName.getText().toString();
                StringBuffer stringBuffer=new StringBuffer();
                try {
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(openFileInput(filename)));
                    String  inputString;
                    while ((inputString=bufferedReader.readLine())!=null)
                    {
                        stringBuffer.append(inputString+"\n");
                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),stringBuffer.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}