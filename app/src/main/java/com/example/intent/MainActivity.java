package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText em;
    EditText pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        em=(EditText)findViewById(R.id.email);
        pw=(EditText)findViewById(R.id.pass);
    }
    public void logIn(View v)
    {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("email",em.getText().toString());
        intent.putExtra("pass", pw.getText().toString());
        startActivity(intent);
    }
}