package com.example.employeeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    ListView listview;
    database d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listview=findViewById(R.id.listview);
        d=new database(this);
        Cursor c=d.getinfo();
        if(c.getCount()==0)
        {
            Toast.makeText(MainActivity3.this,"Datais not getting",Toast.LENGTH_SHORT).show();
        }
        else
        {
            List<String> ls=new ArrayList<>();
            while(c.moveToNext())
            {
                ls.add(c.getString(0));
                ls.add(c.getString(1));
                ls.add(c.getString(2));
                ls.add(c.getString(3));
                ls.add(c.getString(4));
                ls.add(c.getString(5));
                ls.add(c.getString(6));
            }
            ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,ls);
            listview.setAdapter(ad);
        }
    }
}