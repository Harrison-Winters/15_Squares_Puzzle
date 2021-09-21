package com.example.a15squarespuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Find TextViews
    TextView Col0Row0 = (TextView)findViewById(R.id.Col0Row0);
    TextView Col1Row0 = (TextView)findViewById(R.id.Col1Row0);
    TextView Col2Row0 = (TextView)findViewById(R.id.Col2Row0);
    TextView Col3Row0 = (TextView)findViewById(R.id.Col3Row0);
    TextView Col0Row1 = (TextView)findViewById(R.id.Col0Row1);
    TextView Col1Row1 = (TextView)findViewById(R.id.Col1Row1);
    TextView Col2Row1 = (TextView)findViewById(R.id.Col2Row1);
    TextView Col3Row1 = (TextView)findViewById(R.id.Col3Row1);
    TextView Col0Row2 = (TextView)findViewById(R.id.Col0Row2);
    TextView Col1Row2 = (TextView)findViewById(R.id.Col1Row2);
    TextView Col2Row2 = (TextView)findViewById(R.id.Col2Row2);
    TextView Col3Row2 = (TextView)findViewById(R.id.Col3Row2);
    TextView Col0Row3 = (TextView)findViewById(R.id.Col0Row3);
    TextView Col1Row3 = (TextView)findViewById(R.id.Col1Row3);
    TextView Col2Row3 = (TextView)findViewById(R.id.Col2Row3);
    TextView Col3Row3 = (TextView)findViewById(R.id.Col3Row3);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}