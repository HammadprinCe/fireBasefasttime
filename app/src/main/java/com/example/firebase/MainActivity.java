package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText editText1;
    EditText editText2;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        btn=findViewById(R.id.btnsign);
        editText1=findViewById(R.id.editTextEmail);
        editText2=findViewById(R.id.editTextPassword);


  btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
         String email= editText1.getText().toString();
          String password=editText2.getText().toString();
          auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                  if (task.isSuccessful()){
                      Toast.makeText(getApplicationContext(), "successful", Toast.LENGTH_SHORT).show();
                  }else {
                      Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                  }
              }
          });


      }
  });
    }
}