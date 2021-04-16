package com.example.listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<UserModel> usrList;
    UserListAdapter adp;
    ListView listView;
    Button btnSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillList();
        define();
        sign();
    }

    public void fillList() {
        usrList = new ArrayList<>();
        usrList.add(new UserModel("Amine", "Yesilyurt", "26", "GS"));
        usrList.add(new UserModel("Nese", "Gok", "23", "BJK"));
        usrList.add(new UserModel("Aylin", "Sevil", "34", "FB"));
        usrList.add(new UserModel("Ozan", "Kara", "40", "BJK"));

    }

    private void define() {
        listView = findViewById(R.id.listview);
        btnSign= findViewById(R.id.sign);
        adp = new UserListAdapter(usrList, this, this);
        listView.setAdapter(adp);
    }

    public void sign(){
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AlertActivity.class);
                startActivity(intent);
            }
        });
    }


}