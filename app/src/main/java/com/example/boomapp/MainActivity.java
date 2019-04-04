package com.example.boomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtFullName = findViewById(R.id.edtFullName);
        Button cmdCheck = findViewById(R.id.cmdCheck);

        if (cmdCheck != null){
            cmdCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (edtFullName.getText().toString().trim() != ""){
                        Toast.makeText(MainActivity.this,edtFullName.getText(),Toast.LENGTH_LONG).show();
                    }
                }
            });

        }


    }
}
