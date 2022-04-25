package com.example.employeeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity6 extends AppCompatActivity {
    ListView listview;
    EditText txtname;
    Button btnadd;
    ArrayList<String> ls=new ArrayList<>();
    ArrayAdapter<String> adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        listview=findViewById(R.id.listview);
        txtname=findViewById(R.id.txtname);
        btnadd=findViewById(R.id.btnadd);
        ls.add("aaa");
        ls.add("qqq");
        adp=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,ls);
        listview.setAdapter(adp);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ls.remove(i);
                adp.notifyDataSetChanged();
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=txtname.getText().toString();
                ls.add(name);
                listview.setAdapter(adp);
                //adp.notifyDataSetChanged();
            }
        });
    }
}