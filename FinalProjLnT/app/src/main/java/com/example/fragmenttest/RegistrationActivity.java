package com.example.fragmenttest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        EditText etIdBimbel = findViewById(R.id.et_IdBimbel);
        EditText etEmail = findViewById(R.id.et_email);
        EditText etName = findViewById(R.id.et_name);
        EditText etPass = findViewById(R.id.et_password);
        EditText etConfPass = findViewById(R.id.et_confPass);
        Button btnRegister = findViewById(R.id.btn_register);

        sp = getSharedPreferences("information", Context.MODE_PRIVATE);
        firebaseAuth = FirebaseAuth.getInstance();


        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String idBimbel = etIdBimbel.getEditableText().toString().trim();
                String email = etEmail.getEditableText().toString().trim();
                String name = etName.getEditableText().toString().trim();
                String pass = etPass.getEditableText().toString().trim();
                String confPass = etConfPass.getEditableText().toString().trim();

                Boolean checkID = false, checkEmail = false, checkName = false, checkPass = false;

                //validation
                checkID = checkIDMethod(idBimbel);
                checkEmail = checkEmailMethod(email);
                checkName = checkNameMethod(name);
                checkPass = checkPasswordMethod(pass,confPass);

                if(checkEmail && checkID && checkPass && checkName){

                    //save ke firebase
                    firebaseAuth.createUserWithEmailAndPassword(email,pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(RegistrationActivity.this, "Registration Completed!!", Toast.LENGTH_SHORT).show();
                                        SharedPreferences.Editor editor = sp.edit();
                                        editor.putString("idPref", idBimbel);
                                        editor.putString("emailPref", email);
                                        editor.putString("namePref", name);
                                        editor.putString("passPref", pass);
                                        editor.commit();
                                        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                                        finish();
                                    }else{
                                        Toast.makeText(RegistrationActivity.this, "Registration failed!"+ task.getException(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                }
            }
        });
    }
    public boolean checkIDMethod(String str){
        if(str.isEmpty()) {
            Toast.makeText(RegistrationActivity.this, "ID is Empty!", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }

    }
    public boolean checkEmailMethod(String email){
        if(email.isEmpty()) {
            Toast.makeText(RegistrationActivity.this, "Email Is Empty!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            if (email.contains("@") && email.endsWith(".com")) return true;
            else {
                Toast.makeText(RegistrationActivity.this, "Check Email's Condition", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
    }
    public boolean checkNameMethod(String name){
        if(name.isEmpty()){
            Toast.makeText(RegistrationActivity.this, "Name is Empty!", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            if(name.length() >= 5){
                return true;
            }else{
                Toast.makeText(RegistrationActivity.this, "Name needs to be more than 5 character!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
    }
    public boolean checkPasswordMethod(String pass, String confPass){
        if(pass.isEmpty()){
            Toast.makeText(RegistrationActivity.this, "Password is Empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(confPass.isEmpty()){
            Toast.makeText(RegistrationActivity.this, "Confirm Password is Empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(pass.equals(confPass)){
            return true;
        }else{
            Toast.makeText(this, "Password is not matched!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}