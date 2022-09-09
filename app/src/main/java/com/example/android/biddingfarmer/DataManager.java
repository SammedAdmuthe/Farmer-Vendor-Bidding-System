package com.example.android.biddingfarmer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataManager extends SQLiteOpenHelper {

    public static  String db_name="FARMER_BID.DB";
    public static  String db_table_name="FARMER_LOGIN";
    public static  String col1="ID";
    public static  String col2="NAME";
    public static  String col3="PHONE";
    public static  String col4="USER";
    public static  String col5="PASS";
    public static  String col6="TYPE";
    public static  String db_farmer_bid_table="FARMER_BID";
    public static  String c1="farmer_name";
    public static  String c2="veg_name";
    public static  String c3="qty";
    public static  String c4="grade";



    public DataManager(Context context) {
        super(context, db_name , null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + db_table_name + "(id integer primary key autoincrement,name text,phone integer(9),user text,pass text,type text)");
        db.execSQL("CREATE TABLE " + db_farmer_bid_table + "(id integer primary key autoincrement,farmer_name text,veg_name text,qty text,grade text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("Drop table if EXISTS "+db_table_name);
          db.execSQL("Drop table if EXISTS "+db_farmer_bid_table);
          onCreate(db);
    }
    public boolean insert_data(String name,String phone,String user,String pass,String type)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues val=new ContentValues();
        val.put(col2,name);
        val.put(col3,phone);
        val.put(col4,user);
        val.put(col5,pass);
        val.put(col6,type);
        long temp=db.insert(db_table_name,null,val);
        if(temp==-1)
            return false;
        return true;
    }

    public boolean insert_bid(String farmer_name,String veg_name,String qty,String grade)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues val=new ContentValues();
        val.put(c1,farmer_name);
        val.put(c2,veg_name);
        val.put(c3,qty);
        val.put(c4,grade);
        long temp =db.insert(db_farmer_bid_table,null,val);
        if(temp==-1)
            return false;
        return true;
    }
    public Cursor get_rows(String veg_name,String qty,String grade)
    {
        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor=db.rawQuery("select ?,?,?,? from " +db_table_name+" where "+c2+"=? and "+c4+"=? and "+c3+">=?",new String[]{c1,c2,c3,c4,veg_name,grade,qty});
          Cursor c=db.rawQuery("select * from "+db_farmer_bid_table,null);
        return c;
    }
    public boolean validate_password(String user,String pass,String type) {
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor=db.rawQuery("select * from " +db_table_name+" where "+col4 +"=? and "+col5+"=? and "+col6+"=?" ,new String[] {user,pass,type});
        if(cursor.getCount()>0)
        {
            return true;
        }
        return false;
    }
}
