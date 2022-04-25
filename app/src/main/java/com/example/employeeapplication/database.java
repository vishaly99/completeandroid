package com.example.employeeapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.CheckBox;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    public final static String dbname="external.db";
    public database(@Nullable Context context) {
        super(context, dbname, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
         sqLiteDatabase.execSQL("create table externaltb(empid integer primary key autoincrement,empname text,empdesgination text,empphoneno text,empage integer,empdepartment text,empdate text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("drop table if exists externaltb");
    }
    public boolean insert_data(String empname, String empdesgination, String empphoneno, Integer empage, String empdepartment, String empdate)
    {

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("empname",empname);
        c.put("empdesgination",empdesgination);
        c.put("empphoneno",empphoneno);
        c.put("empage",empage);
        c.put("empdepartment",empdepartment);
        c.put("empdate",empdate);
        long i=db.insert("externaltb",null,c);
        if(i==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Cursor getinfo()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from externaltb",null);
        return cursor;
    }
    public Cursor getdatabyname(String empname)
    {
        System.out.println("Empname:="+empname);
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from externaltb where empname='"+empname+"'",null);
        return cursor;
    }
//    public boolean delete_data(Integer id)
//    {
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor cursor=db.rawQuery( "select * from employeetb where empid="+id+"", null );
//        if(cursor.getCount()>0)
//        {
//            long r=db.delete("employeetb","empid=?",new String[]{Integer.toString(id)});
//            if(r==-1)
//            {
//                return false;
//            }
//            else
//            {
//                return true;
//            }
//        }
//        return false;
//    }
//    public boolean update_data(Integer id,String name,String gender,String contactno,Integer age,String salary)
//    {
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor=db.rawQuery( "select * from employeetb where empid="+id+"", null );
//        if(cursor.getCount()>0)
//        {
//            ContentValues c=new ContentValues();
//            c.put("empname",name);
//            c.put("gender",gender);
//            c.put("contactno",contactno);
//            c.put("age",age);
//            c.put("salary",salary);
//            long r=db.update("employeetb",c,"empid=?",new String[]{Integer.toString(id)});
//            if(r==-1)
//            {
//                return false;
//            }
//            else
//            {
//                return true;
//            }
//        }
//        return false;
//    }

    //CheckBox pizza,coffee,burger;
    //pizza=(CheckBox)findViewById(R.id.checkBox1);
    //        coffee=(CheckBox)findViewById(R.id.checkBox2);
    //        burger=(CheckBox)findViewById(R.id.checkBox3);StringBuilder result=new StringBuilder();  if(pizza.isChecked())
    //                {
    //                    result.append("\n Pizza:100");
    //                    total+=100;
    //                }
//       <RadioGroup
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:id="@+id/radioGroup">
//
//        <RadioButton
//    android:id="@+id/radioMale"
//    android:layout_width="fill_parent"
//    android:layout_height="wrap_content"
//    android:text="  Male"
//    android:layout_marginTop="10dp"
//    android:checked="false"
//    android:textSize="20dp" />
//
//        <RadioButton
//    android:id="@+id/radioFemale"
//    android:layout_width="fill_parent"
//    android:layout_height="wrap_content"
//    android:text="   Female"
//    android:layout_marginTop="20dp"
//    android:checked="false"
//
//    android:textSize="20dp" />
//    </RadioGroup>
    //   RadioButton genderradioButton;
    //    RadioGroup radioGroup;   radioGroup=(RadioGroup)findViewById(R.id.radioGroup);  int selectedId = radioGroup.getCheckedRadioButtonId();
    //        genderradioButton = (RadioButton) findViewById(selectedId);
    //        if(selectedId==-1){
    //            Toast.makeText(MainActivity.this,"Nothing selected", Toast.LENGTH_SHORT).show();
    //        }
    //        else{
    //            Toast.makeText(MainActivity.this,genderradioButton.getText(), Toast.LENGTH_SHORT).show();
    //        }
}
