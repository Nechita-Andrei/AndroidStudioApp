package com.example.mersultrenurilor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DataFetched extends AppCompatActivity {


    static TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_fetched);
        data=findViewById(R.id.fetcheddata);
        fetchData proces=new fetchData();
        proces.execute();
    }
}