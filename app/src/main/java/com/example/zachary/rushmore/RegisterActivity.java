package com.example.zachary.rushmore;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText mFirst;
    private TextInputEditText mLast;
    private TextInputEditText mUser;
    private TextInputEditText mPass;
    private TextInputEditText mConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button button = (Button) findViewById(R.id.newRegister);
        Button cancel = (Button) findViewById(R.id.Cancel);

        final Customer[] customerList = (Customer[]) getIntent().getSerializableExtra("customerList");
        final int customerCount = (int) getIntent().getIntExtra("customerCount", 0);

        mFirst = (TextInputEditText) findViewById(R.id.firstName);
        mLast = (TextInputEditText) findViewById(R.id.lastName);
        mUser = (TextInputEditText) findViewById(R.id.username);
        mPass = (TextInputEditText) findViewById(R.id.pass);
        mConfirm = (TextInputEditText) findViewById(R.id.ConfirmPass);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                boolean filledOut = true;
                String firstname = mFirst.getText().toString();
                String lastname = mLast.getText().toString();
                String username = mUser.getText().toString();
                String password = mPass.getText().toString();
                String confirmPass = mConfirm.getText().toString();

                if (TextUtils.isEmpty(firstname)) {
                    mFirst.setError("First name required");
                    filledOut = false;
                }

                if (TextUtils.isEmpty(lastname)) {
                    mLast.setError("Last name required");
                    filledOut = false;
                }

                if (TextUtils.isEmpty(username)) {
                    mUser.setError("Username required");
                    filledOut = false;
                }

                else {
                    for(int i = 0; i < customerCount; i++) {
                        if(customerList[i].getUsername().equals(username)) {
                            mUser.setError("Username is taken");
                            filledOut = false;
                        }
                    }
                }

                if (TextUtils.isEmpty(password)) {
                    mPass.setError("Password required");
                    filledOut = false;
                }

                if (TextUtils.isEmpty(confirmPass)) {
                    mConfirm.setError("Please confirm password");
                    filledOut = false;
                }

                else if(!confirmPass.equals(password)){
                    mConfirm.setError("Passwords do not match");
                    filledOut = false;
                }

                if(filledOut) {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.putExtra("firstname", firstname);
                    intent.putExtra("lastname", lastname);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    intent.putExtra("customerList", customerList);
                    intent.putExtra("customerCount", customerCount);
                    startActivity(intent);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.putExtra("customerList", customerList);
                intent.putExtra("customerCount", customerCount);
                startActivity(intent);
            }
        });
    }
}
