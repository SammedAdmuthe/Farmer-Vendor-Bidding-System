package com.example.android.biddingfarmer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity {

    DataManager dM;
    Button button;
    EditText e1,e2,e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        button=(Button)findViewById(R.id.button9);
        dM = new DataManager(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1=(EditText)findViewById(R.id.editText7);
                e2=(EditText)findViewById(R.id.editText10);
                e3=(EditText)findViewById(R.id.editText11);
                boolean temp=dM.insert_bid(Main3Activity.str,e1.getText().toString(),e2.getText().toString(),e3.getText().toString());
                if(temp==true)
                {
                    Toast.makeText(Main7Activity.this,"Data Inserted", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(Main7Activity.this,"Data not Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }
}
