package com.example.android.biddingfarmer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    Button button;
    EditText edit1,edit2;
    DataManager dm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button=(Button)findViewById(R.id.button6);
        dm=new DataManager(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1=(EditText)findViewById(R.id.editText6);
                edit2=(EditText)findViewById(R.id.editText8);
                String temp="Bidder";
                boolean validate=dm.validate_password(edit1.getText().toString(),edit2.getText().toString(),temp);
                if(validate==true)
                {
                    Toast.makeText(Main4Activity.this,"Login Successful",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Main4Activity.this,Main6Activity.class));
                }
                else
                    Toast.makeText(Main4Activity.this,"Login Unsuccessful",Toast.LENGTH_LONG).show();

            }
        });

    }
}
