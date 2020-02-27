package com.tonikamitv.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class UserAreaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Map<String, String> map = new HashMap<String, String>();
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        setContentView(R.layout.activity_user_area);
        final TextView tvGroupeLink = (TextView) findViewById(R.id.tvCreateGroupeLink);


        Intent intent = getIntent();
        System.out.println("test");
        System.out.println(intent.getExtras());
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", -1);
        final int id_user = intent.getIntExtra("id_user", 1 );
        //databaseHelper.Insert("users", id_user,name,username,age);
        //databaseHelper.Insert("groups");

        //Toast.makeText(getApplicationContext(), id_user, Toast.LENGTH_LONG).show();
        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        EditText etUsername = (EditText) findViewById(R.id.etUsername);
        EditText etAge = (EditText) findViewById(R.id.etAge);

        // Display user details
        String message = name + " welcome to your user area";
        tvWelcomeMsg.setText(message);
        etUsername.setText(username);
        etAge.setText(age + "");

        tvGroupeLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final Intent registerIntent = new Intent(UserAreaActivity.this, CreateGroupActivity.class);
                registerIntent.putExtra("id_user",id_user);
                UserAreaActivity.this.startActivity(registerIntent);
            }
        });
    }
}
