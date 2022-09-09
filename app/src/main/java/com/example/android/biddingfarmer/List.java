
package com.example.android.biddingfarmer;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class List extends AppCompatActivity {
    ListView l;
    DataManager dm;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        l=(ListView)findViewById(R.id.list);
        dm=new DataManager(this);
        CustAdapter c=new CustAdapter(this,Main6Activity.user,Main6Activity.veg,Main6Activity.q,Main6Activity.g);
        l.setAdapter(c);
    }
}
class CustAdapter extends ArrayAdapter<String>
{
    Context c;
    String[] user;
    String[] veg;
    String[] q;
    String[] g;
    public CustAdapter(@NonNull Context context, String[] user,String[] veg,String[] q,String[] g) {
        super(context, R.layout.single_row,R.id.textView19,Main6Activity.g);
        this.user=user;
        this.veg=veg;
        this.q=q;
        this.g=g;
        this.c=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater l_inf= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=l_inf.inflate(R.layout.single_row,parent,false);
        TextView t1=(TextView) v.findViewById(R.id.textView14);
        TextView t2=(TextView) v.findViewById(R.id.textView16);
        TextView t3=(TextView) v.findViewById(R.id.textView17);
        TextView t4=(TextView) v.findViewById(R.id.textView19);
        t1.setText(user[position]);
        t2.setText(veg[position]);
        t3.setText(q[position]);
        t4.setText(g[position]);
        return v;
    }
}