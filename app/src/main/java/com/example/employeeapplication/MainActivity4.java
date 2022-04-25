package com.example.employeeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    Button btnsearch;
    EditText txtsearchname;
    ListView searchlist;
    database g;
    List<String> ls=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        g=new database(this);
        btnsearch=findViewById(R.id.btnsearch);
        txtsearchname=findViewById(R.id.txtsearchname);
        searchlist=findViewById(R.id.searchlist);

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=txtsearchname.getText().toString();
                Cursor c=g.getdatabyname(name);
                if(c.getCount()==0)
                {
                    Toast.makeText(MainActivity4.this,"Data is not getting",Toast.LENGTH_LONG).show();
                }
                else
                {

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
                    ArrayAdapter<String> adp=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,ls);
                    searchlist.setAdapter(adp);
                }

            }
        });



    }
}