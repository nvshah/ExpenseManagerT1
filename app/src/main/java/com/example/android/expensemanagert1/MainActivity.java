package com.example.android.expensemanagert1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Database.DatabaseHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button seeexpense,addexpense;

    TextView report;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seeexpense = (Button)findViewById(R.id.view);
        addexpense = (Button)findViewById(R.id.add);

        report = findViewById(R.id.report1);

        db= new DatabaseHelper(this);

        int[] r1 = new int[3];
        r1 = db.report1();

        //Log.i("in",r1));

        report.setText("Total Spent This month : "+Integer.toString(r1[0])+"\n\nTotal Spent this Year : "+Integer.toString(r1[1])+"\n\nTotal Expense Today : "+Integer.toString(r1[2]));
        seeexpense.setOnClickListener(this);
        addexpense.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.add:
                Intent i = new Intent(this, Main3Activity.class);
                startActivity(i);
                break;
            case R.id.view:
                Intent j = new Intent(this, DisplayActivity.class);
                startActivity(j);
                break;
        }

    }


}
