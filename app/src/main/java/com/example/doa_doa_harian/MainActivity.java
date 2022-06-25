package com.example.doa_doa_harian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    //Deklarasi variabel untok button
    Button  Login, Signup;
    EditText inp_mail, inp_pass;
    String email, password;


    //Ira Eriska_20200140097
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        Login = findViewById(R.id.btnlogin);
        inp_mail=findViewById(R.id.edemail);
        inp_pass=findViewById(R.id.edpass);
        Signup = findViewById(R.id.btnsign);

        //Membuat fungksi one klik pada batton battonlogin
        Login.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                ceklogin();

            }
        });

        Signup.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View View) {
                Intent Signup = new Intent(getApplicationContext(), SignUp.class);
                startActivity(Signup);
            }
        });

    }

    private void ceklogin() {
        email = inp_mail.getText().toString();
        password = inp_pass.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //membuat object intent berpindah ke Activity No Admin
                            Intent nt = new Intent(getApplicationContext(),Menu.class);
                            //berpindah ke Activity
                            startActivity(nt);
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Login Gagal, masukkan email dan password dengan benar", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
