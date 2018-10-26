package com.example.zachary.rushmore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Button viewProf = (Button) findViewById(R.id.ViewProfile);

        final Customer[] customerList = (Customer[]) getIntent().getSerializableExtra("customerList");
        final int customerCount = (int) getIntent().getIntExtra("customerCount", 0);
        final Customer curr = (Customer) getIntent().getSerializableExtra("curr");

        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText("Hello Fraternity Member " + curr.getFirstName());
        editText.setFocusable(false);
        editText.setClickable(false);

        EditText post1 = (EditText) findViewById(R.id.Post1);
        post1.setFocusable(false);
        post1.setClickable(false);
        EditText post2 = (EditText) findViewById(R.id.Post2);
        post2.setFocusable(false);
        post2.setClickable(false);
        EditText post3 = (EditText) findViewById(R.id.Post3);
        post3.setFocusable(false);
        post3.setClickable(false);
        EditText post4 = (EditText) findViewById(R.id.Post4);
        post4.setFocusable(false);
        post4.setClickable(false);
        EditText post5 = (EditText) findViewById(R.id.Post5);
        post5.setFocusable(false);
        post5.setClickable(false);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.putExtra("customerList", customerList);
                intent.putExtra("customerCount", customerCount);
                startActivity(intent);
            }
            });

        viewProf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ViewProfileActivity.class);
                intent.putExtra("curr", curr);
                intent.putExtra("customerList", customerList);
                intent.putExtra("customerCount", customerCount);
                startActivity(intent);
            }
        });
    }
}
