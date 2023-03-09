package com.example.bluejackpharmacy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends Activity{

    EditText emailText, passwordText;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailText = findViewById(R.id.emailFormField);
        passwordText = findViewById(R.id.passwordFormField);
        loginBtn = findViewById(R.id.loginButton);

        loginBtn.setOnClickListener(e -> {loginValidate();});
    }

    void loginValidate() {
        String email = emailText.getText().toString().toLowerCase();
        String password = passwordText.getText().toString();

        if(Data.userList.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Database is corrupted", Toast.LENGTH_SHORT).show();
        } else {
            for(User user : Data.userList) {
                if(user.email.matches(email)) {
                    if(user.password.matches(User.hashPassword(password))) {
                        startActivity(new Intent(this, HomeActivity.class));
                        Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        break;
                    }
                }
            }
            Toast.makeText(getApplicationContext(), "Wrong username/password", Toast.LENGTH_SHORT).show();
        }

    }

    public void toRegisterActivity(View v){
        startActivity(new Intent(this, RegisterActivity.class));
    }

}