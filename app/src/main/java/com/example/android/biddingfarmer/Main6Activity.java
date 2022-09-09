package com.example.android.biddingfarmer;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {

    DataManager dm;
    Button b1;
    EditText t1,t2,t3;
    ListView l;
    public static String[] veg;
    public static String[] user;
    public static String[] q;
    public static String[] g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        b1=(Button)findViewById(R.id.button10);
        t1=(EditText)findViewById(R.id.editText12);
        t2=(EditText)findViewById(R.id.editText13);
        t3=(EditText)findViewById(R.id.editText14);

        dm=new DataManager(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Cursor cursor=dm.get_rows(t1.getText().toString(),t2.getText().toString(),t3.getText().toString());


                int i=0;
            while (cursor.moveToNext())
            {
                user[i]=cursor.getString(0);
                veg[i]=cursor.getString(1);
                q[i]=cursor.getString(2);
                g[i]=cursor.getString(3);
                i++;
            }

            user[i]="\0";
            veg[i]="\0";
            q[i]="\0";
            g[i]="\0";

//            startActivity(new Intent(Main6Activity.this,List.class));
//            for(int a=0;a<i;a++)
//            {
//                Log.d("tag", user[a]);
//            }
            }
        });
    }
}
