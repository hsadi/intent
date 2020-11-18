package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    String emails[]={"haleema@gmail.com","zainab@gmail.com","sana@gmail.com","sehrish@gmail.com","sidra@gmil.com","sara@gmail.com","zara@gmail.com","zoya@gmail.com","zubab@gmail.com"};
    String Passwords[]={"haleema","zainab","sana","sehrish","sidra","sara","zara","zoya","zubab"};
    String alpha[];
    TextView message;
    TextView message2;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        alpha=getResources().getStringArray(R.array.alphabets);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alpha);
        GridView gridview = (GridView) findViewById(R.id.grid_view);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                Toast.makeText(getApplicationContext(), "You Clicked: "  + alpha[position], Toast.LENGTH_LONG).show();
                Intent intent= new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("alpha",alpha[position]);
                startActivity(intent);
            }
        });

        message = (TextView) findViewById(R.id.mess);
        message2=(TextView)findViewById(R.id.mess1);
        Intent intent = getIntent();
        String e = intent.getStringExtra("email");
        String p = intent.getStringExtra("pass");
        for (int i = 0; i < emails.length; i++)
            if ((e.matches(emails[i]))&& (p.matches(Passwords[i]))) {
                message.setText("You are logged in" );
                message2.setText("Your EmailAddress is "+ e);
                message.setTextColor(getResources().getColor(R.color.colorPrimaryDark));


            }
    }


}
