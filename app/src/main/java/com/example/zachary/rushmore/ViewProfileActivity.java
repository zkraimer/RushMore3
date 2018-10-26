package com.example.zachary.rushmore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

public class ViewProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view_profile);

        Button back = (Button) findViewById(R.id.Back);
        Button editProf = (Button) findViewById(R.id.EditProfile);

        final Customer[] customerList = (Customer[]) getIntent().getSerializableExtra("customerList");
        final int customerCount = (int) getIntent().getIntExtra("customerCount", 0);
        final Customer curr = (Customer) getIntent().getSerializableExtra("curr");

        EditText editText = (EditText) findViewById(R.id.firstName);
        editText.setText("First Name: "+curr.getFirstName());
        editText.setFocusable(false);
        editText.setClickable(false);
        EditText editText2 = (EditText) findViewById(R.id.lastName);
        editText2.setText("Last Name: "+curr.getLastName());
        editText2.setFocusable(false);
        editText2.setClickable(false);
        EditText editText3 = (EditText) findViewById(R.id.username);
        editText3.setText("Username: "+curr.getUsername());
        editText3.setFocusable(false);
        editText3.setClickable(false);
        EditText editText4 = (EditText) findViewById(R.id.password);
        editText4.setText("Password: "+curr.getPassword());
        editText4.setFocusable(false);
        editText4.setClickable(false);
        EditText editText5 = (EditText) findViewById(R.id.Description);
        editText5.setText("Description: "+curr.getDescription());
        editText5.setFocusable(false);
        editText5.setClickable(false);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent;
                if(curr.getStatus() >= 1) {
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                }
                else{
                    intent = new Intent(getApplicationContext(),PotentialActivity.class);
                }
                intent.putExtra("curr", curr);
                intent.putExtra("customerList", customerList);
                intent.putExtra("customerCount", customerCount);
                startActivity(intent);
            }
        });

        editProf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditProfileActivity.class);
                intent.putExtra("curr", curr);
                intent.putExtra("customerList", customerList);
                intent.putExtra("customerCount", customerCount);
                startActivity(intent);
            }
        });
    }
}