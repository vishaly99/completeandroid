package com.example.employeeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button btninsert,btnback;
    EditText txtempid,txtempname,txtempdesignation,txtempphoneno;
    TextView txtdate;
    Spinner spinnerage,spinnerdepartment;
    Integer[] age={18,19,20,21,22,23};
    String[] dept={"HR","IT","SUPPORT"};

    final Calendar calendar=Calendar.getInstance();
    final int year=calendar.get(Calendar.YEAR);
    final int month=calendar.get(Calendar.MONTH);
    final int day=calendar.get(Calendar.DAY_OF_MONTH);
    database d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d=new database(this);
        setContentView(R.layout.activity_main);
        btninsert=findViewById(R.id.btninsert);
        btnback=findViewById(R.id.btnback);
        txtempid=findViewById(R.id.txtempid);
        txtempname=findViewById(R.id.txtempname);
        txtempdesignation=findViewById(R.id.txtempdesignation);
        txtempphoneno=findViewById(R.id.txtempphoneno);
        txtdate=findViewById(R.id.txtdate);
        spinnerage=findViewById(R.id.spinnerage);
        spinnerdepartment=findViewById(R.id.spinnerdepartment);
        spinnerage.setOnItemSelectedListener(this);
        spinnerdepartment.setOnItemSelectedListener(this);

        ArrayAdapter aaage=new ArrayAdapter(this, android.R.layout.simple_spinner_item,age);
        ArrayAdapter aadept=new ArrayAdapter(this, android.R.layout.simple_spinner_item,dept);

        aaage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aadept.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerage.setAdapter(aaage);
        spinnerdepartment.setAdapter(aadept);

        txtdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                        month=month+1;
                        String date=dayofmonth+"/"+month+"/"+year;
                        txtdate.setText(date);
                    }
                },year,month,day);
                dialog.show();
            }
        });

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer empid=Integer.parseInt(txtempid.getText().toString());
                String empname=txtempname.getText().toString();
                String empdesgination=txtempdesignation.getText().toString();
                String empphoneno=txtempphoneno.getText().toString();
                Integer empage= (int) spinnerage.getSelectedItem();
                String empdepartment=(String) spinnerdepartment.getSelectedItem();
                String empdate=txtdate.getText().toString();
                Boolean result=d.insert_data(empname,empdesgination,empphoneno,empage,empdepartment,empdate);
                if(result==true)
                {
                    Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data not inserted",Toast.LENGTH_LONG).show();
                }
//                Toast.makeText(getApplicationContext(),"Id:="+empid+"empnam:="+empname+"empdesgination:="+empdesgination
//                        +"empphoneno:="+empphoneno+"empage:="+empage+":="+empdepartment+":="+empdate
//                        ,Toast.LENGTH_LONG).show();
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String item=adapterView.getItemAtPosition(i).toString();
            Toast.makeText(getApplicationContext(),"Data:="+item,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}