package com.example.auditreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FormPageTwo extends AppCompatActivity {

    Button btn_Prev, btn_Save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_page_two);

        btn_Prev = findViewById(R.id.btn_prev);
        btn_Save = findViewById(R.id.btn_save);

        btn_Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //  startActivity(new Intent(FormPageTwo.this,FormPageOne.class));
                onBackPressed();

            }
        });

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormPageTwo.this, TabForm.class));
            }
        });



    }
}
