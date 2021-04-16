package com.example.listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView name,surname,age,team;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        define();
        pass();
    }
    public void define(){
        name=findViewById(R.id.name);
        surname=findViewById(R.id.surname);
        age= findViewById(R.id.age);
        team= findViewById(R.id.team);
    }
    public void pass(){
        Bundle bundle= getIntent().getExtras();
         name.setText(bundle.getString("name"));
        surname.setText(bundle.getString("surname"));
        age.setText(bundle.getString("age"));
        team.setText(bundle.getString("team"));
    }
}