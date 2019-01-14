package com.example.mmanoghna.juicebergserver;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mmanoghna.juicebergserver.Common.Common;
import com.example.mmanoghna.juicebergserver.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {
    EditText edtPassword,edtPhone;
    Button btnSignIn;
    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edtPassword=(EditText) findViewById(R.id.edtpassword);
        edtPhone=(EditText)findViewById(R.id.phonenumber);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        db=FirebaseDatabase.getInstance();
        users=db.getReference("User");
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInUser(edtPhone.getText().toString(),edtPassword.getText().toString());
            }
        });
    }

    private void signInUser(String phone, String password) {
        final ProgressDialog mDialog=new ProgressDialog(SignIn.this);
        mDialog.setMessage("Loading..");
        mDialog.show();
        final String localPhone=phone;
        final String localPassword=password;
        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(localPhone).exists())
                {
                    mDialog.dismiss();
                    User user=dataSnapshot.child(localPhone).getValue(User.class);
                    user.setPhone(localPhone);
                    if(Boolean.parseBoolean(user.getIsStaff()))
                    {
                        if(user.getPassword().equals(localPassword))
                        {
                            Intent login=new Intent(SignIn.this,Home.class);
                            Common.CurrentUser=user;
                            startActivity(login);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(SignIn.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                        Toast.makeText(SignIn.this,"Login with staff account",Toast.LENGTH_SHORT).show();


                }


            else
            {
                mDialog.dismiss();
                Toast.makeText(SignIn.this,"User doesnt exists",Toast.LENGTH_SHORT).show();

            }}

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
