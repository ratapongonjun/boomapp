package com.example.boomapp;

import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    com.google.android.material.bottomsheet.BottomSheetDialog bsDlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.recyclerview);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(lm);
        androidx.recyclerview.widget.RecyclerView.Adapter adt = new adt_rv_cardview();
        rv.setAdapter(adt);

        View v = getLayoutInflater().inflate(R.layout.bs_layout, null);
        bsDlg = new com.google.android.material.bottomsheet.BottomSheetDialog(MainActivity.this);
        bsDlg.setContentView(v);

        final BottomSheetBehavior bsBeh = BottomSheetBehavior.from((View) v.getParent());
        bsBeh.setBottomSheetCallback(bsCallback);

        Button cmdSimpleBottomSheet = findViewById(R.id.cmdSimpleBottomSheet);
        cmdSimpleBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bsBeh.setState(BottomSheetBehavior.STATE_EXPANDED);
                bsDlg.show();
            }
        });

        Button cmdProcess = v.findViewById(R.id.cmdProcess);
        cmdProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "คุณรับทราบข้อมูลแล้ว", Toast.LENGTH_LONG).show();
                bsDlg.hide();
            }
        });
    }

    BottomSheetBehavior.BottomSheetCallback bsCallback = new com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback() {
        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            switch (newState) {
                case BottomSheetBehavior.STATE_HIDDEN:
                    bsDlg.hide();
                    break;
                case BottomSheetBehavior.STATE_EXPANDED:
                    bsDlg.hide();
                    break;
                case BottomSheetBehavior.STATE_COLLAPSED:
                    bsDlg.hide();
                    break;
                case com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_DRAGGING:
                    bsDlg.hide();
                    break;
                case com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_SETTLING:
                    bsDlg.hide();
                    break;
            }
        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {

        }
    };
}