package com.example.zachary.rushmore;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

public class EditProfileActivity extends AppCompatActivity {

    private TextInputEditText mFirst;
    private TextInputEditText mLast;
    private TextInputEditText mUser;
    private TextInputEditText mPass;
    private TextInputEditText mConfirm;
    private TextInputEditText mDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_edit_profile);

        final Customer[] customerList = (Customer[]) getIntent().getSerializableExtra("customerList");
        final int customerCount = (int) getIntent().getIntExtra("customerCount", 0);
        final Customer curr = (Customer) getIntent().getSerializableExtra("curr");

        Button button = (Button) findViewById(R.id.ConfirmChanges);
        Button cancel = (Button) findViewById(R.id.Cancel);

        mFirst = (TextInputEditText) findViewById(R.id.FirstName1);
        mLast = (TextInputEditText) findViewById(R.id.LastName1);
        mUser = (TextInputEditText) findViewById(R.id.Username1);
        mPass = (TextInputEditText) findViewById(R.id.Password1);
        mConfirm = (TextInputEditText) findViewById(R.id.ConfirmPassword1);
        mDescription = (TextInputEditText) findViewById(R.id.Description1);

        mFirst.setText(curr.getFirstName());
        mLast.setText(curr.getLastName());
        mUser.setText(curr.getUsername());
        mDescription.setText(curr.getDescription());


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                boolean filledOut = true;
                String firstname = mFirst.getText().toString();
                String lastname = mLast.getText().toString();
                String username = mUser.getText().toString();
                String password = mPass.getText().toString();
                String confirmPass = mConfirm.getText().toString();
                String description = mDescription.getText().toString();

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
                        if(customerList[i].getUsername().equals(username) && !username.equals(curr.getUsername())) {
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
                    curr.setFirstName(mFirst.getText().toString());
                    curr.setLastName(mLast.getText().toString());
                    curr.setUsername(mUser.getText().toString());
                    curr.setPassword(mPass.getText().toString());
                    curr.setDescription(mDescription.getText().toString());

                    for(int i = 0; i < customerCount; i++) {
                        if(customerList[i].getUsername().equals(username)) {
                            customerList[i] = curr;
                        }
                    }
                    Intent intent = new Intent(getApplicationContext(), ViewProfileActivity.class);
                    intent.putExtra("curr", curr);
                    intent.putExtra("customerList", customerList);
                    intent.putExtra("customerCount", customerCount);
                    startActivity(intent);
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener(){
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
