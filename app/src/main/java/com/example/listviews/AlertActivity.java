package com.example.listviews;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlertActivity extends AppCompatActivity {

    Button btn;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        define();
        openDialog();
    }

    public void define() {
        btn = findViewById(R.id.showdialog);
    }


    public void openDialog() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDiolog();
            }
        });
    }

    public void createDiolog() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.alertlayout, null);

        EditText name = view.findViewById(R.id.name);
        EditText eposta = view.findViewById(R.id.mail);
        EditText pass = view.findViewById(R.id.pass);

        Button send = view.findViewById(R.id.send);
        Button btnQuit = view.findViewById(R.id.quit);
        Button btnPull = view.findViewById(R.id.pull);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(view);
        alert.setCancelable(false);
        AlertDialog dialog = alert.create();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), name.getText().toString() +
                        " " + eposta.getText().toString() +
                        " " + pass.getText().toString(), Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        btnPull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progDialog();
            }
        });
        dialog.show();
    }

    public void progDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Infos");
        progressDialog.setMessage("Pulling your infos from somewhere, please wait");
        progressDialog.setCancelable(true);
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    progressDialog.cancel();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

}