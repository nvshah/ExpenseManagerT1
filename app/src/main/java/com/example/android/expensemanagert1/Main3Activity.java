package com.example.android.expensemanagert1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import Database.DatabaseHelper;

public class Main3Activity extends AppCompatActivity {

    EditText expense,reason,Dt,detail;
    Spinner method,IorE;

    Button save;
    final Calendar myCalendar = Calendar.getInstance();

    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expense_taker_activity);

        save = findViewById(R.id.save);

        expense = (EditText)findViewById(R.id.price);
        reason = (EditText)findViewById(R.id.purpose);
        detail = findViewById(R.id.des);
        method = (Spinner)findViewById(R.id.amt);
        IorE = (Spinner)findViewById(R.id.inorex);

        db = new DatabaseHelper(this);

        Dt = findViewById(R.id.date);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        Dt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Main3Activity.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        final Intent j = new Intent(this, DisplayActivity.class);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(expense.getText().toString())){
                    Toast.makeText(Main3Activity.this, "Enter Amount!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(TextUtils.isEmpty(reason.getText().toString())){
                    Toast.makeText(Main3Activity.this, "Enter Purpose!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{

                    int amountval = Integer.parseInt(expense.getText().toString());
                    String purposeval = reason.getText().toString();
                    String dateval = Dt.getText().toString();
                    String desval = detail.getText().toString();
                    String methodval = method.getSelectedItem().toString();

                    String ioreval = IorE.getSelectedItem().toString();

                    db.insertTracker(amountval, purposeval, dateval, desval, methodval, ioreval);
                    Toast.makeText(getApplicationContext(), "Save Successfully", Toast.LENGTH_SHORT).show();

                    startActivity(j);
                }

            }
        });
    }
    private void updateLabel() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

        Dt.setText(sdf.format(myCalendar.getTime()));
    }
}
