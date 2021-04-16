package com.example.listviews;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;



public class UserListAdapter extends BaseAdapter {
    List<UserModel> usrList;
    Context context;
    Activity activity;
    public UserListAdapter(List<UserModel> usrList, Context context, Activity activity) {
        this.usrList = usrList;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return usrList.size();
    }

    @Override
    public Object getItem(int position) {
        return usrList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        TextView name = convertView.findViewById(R.id.name);
        TextView surname = convertView.findViewById(R.id.surname);
        TextView age = convertView.findViewById(R.id.age);
        TextView team = convertView.findViewById(R.id.team);
        LinearLayout linearLayout= convertView.findViewById(R.id.mainLayout);

        name.setText(usrList.get(position).getName());
        surname.setText(usrList.get(position).getSurname());
        age.setText(usrList.get(position).getAge());
        team.setText(usrList.get(position).getTeam());

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Activity2.class);
                intent.putExtra("name",usrList.get(position).getName());
                intent.putExtra("surname",usrList.get(position).getSurname());
                intent.putExtra("age",usrList.get(position).getAge());
                intent.putExtra("team",usrList.get(position).getTeam());
                activity.startActivity(intent);
            }
        });

        return convertView;
    }
}
