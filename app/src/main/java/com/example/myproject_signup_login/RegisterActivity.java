package com.example.myproject_signup_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextView btn;

    private EditText username, email, password, repassword;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

         btn=findViewById(R.id.alreadyacc);
         username=findViewById(R.id.username);
         email=findViewById(R.id.email);
         password=findViewById(R.id.password);
         repassword=findViewById(R.id.repassword);

         btnRegister=findViewById(R.id.signupbtn);
         btnRegister.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 checkCrededentials();
             }
         });

         checkCrededentials();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    private void checkCrededentials() {
        String user=username.getText().toString();
        String mail=email.getText().toString();
        String pass=password.getText().toString();
        String repass=repassword.getText().toString();

        if (user.isEmpty() || user.length()<7)
        {
            showError(username,  "Your username is not valid!");
        }
        else if (mail.isEmpty() || !mail.contains("@"))
        {
            showError(email, "Email is not valid!");
        }
        else if (pass.isEmpty() || pass.length()<7)
        {
            showError(password, "Password must be 7 character!");
        }
        else if (repass.isEmpty() || !repass.equals(pass))
        {
            showError(repassword, "Password not match!");
        }
        else
        {
            Toast.makeText(this, "Call Registration Method", Toast.LENGTH_SHORT).show();
        }
    }
    private void showError(EditText input, String s){
        input.setError(s);
        input.requestFocus();
    }
}