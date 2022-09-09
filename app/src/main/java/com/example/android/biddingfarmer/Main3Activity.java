package com.example.android.biddingfarmer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    Button button;
    EditText edit1,edit2;
    DataManager dm;
    static String str;
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
                String temp="Farmer";
                boolean validate=dm.validate_password(edit1.getText().toString(),edit2.getText().toString(),temp);
                str=edit1.getText().toString();
                if(validate==true)
                {
                    Toast.makeText(Main3Activity.this,"Login Successful",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Main3Activity.this,Main5Activity.class));
                }
                else
                    Toast.makeText(Main3Activity.this,"Login Unsuccessful",Toast.LENGTH_LONG).show();

            }
        });

    }
}
