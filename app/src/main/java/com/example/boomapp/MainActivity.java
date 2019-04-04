package com.example.boomapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

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

        final ConstraintLayout ctMain = findViewById(R.id.ctMain);

        FloatingActionButton fabSearch = findViewById(R.id.fabSearch);
        fabSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(ctMain,"ข้อความ Snackbar มาจากกดปุ่ม FAB",Snackbar.LENGTH_LONG).show();
            }
        });

    }
}
