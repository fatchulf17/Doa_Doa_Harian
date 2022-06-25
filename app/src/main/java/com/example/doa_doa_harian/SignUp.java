package com.example.doa_doa_harian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    EditText inp_name, inp_email, inp_password;
    Button btnRegis;
    String name, email, password;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        inp_name = findViewById(R.id.ednamasignup);
        inp_email = findViewById(R.id.edemailsignup);
        inp_password = findViewById(R.id.edpasssignup);
        btnRegis = findViewById(R.id.btnsignup);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inp_name.getText().length()>0 && inp_email.getText().length()>0 && inp_password.getText().length()>0){
                        registrasi();
                }else{
                    Toast.makeText(getApplicationContext(), "Isi semua data", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void registrasi() {
        name = inp_name.getText().toString();
        email = inp_email.getText().toString();
        password = inp_password.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //membuat object intent berpindah ke Mainactivity
                            Intent nt = new Intent(getApplicationContext(),MainActivity.class);
                            //berpindah start
                            startActivity(nt);
                            // Sign in sukses
                            Toast.makeText(SignUp.this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            // If sign gagal
                            Toast.makeText(SignUp.this, "Registrasi Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}