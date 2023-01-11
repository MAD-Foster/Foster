package com.example.foster;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SettingsMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_main);

        TextView txt = findViewById(R.id.editname);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(getApplicationContext(), SettingsName.class);
                startActivity(int1);
            }
        });

        TextView txt2 = findViewById(R.id.changepassword);
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(int2);
            }
        });

        TextView txt3 = findViewById(R.id.details);
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3 = new Intent(getApplicationContext(), UpdateDetails.class);
                startActivity(int3);
            }
        });

        TextView txt4 = findViewById(R.id.aboutUs);
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int4 = new Intent(getApplicationContext(), AboutUsActivity.class);
                startActivity(int4);
            }
        });

        TextView txt5 = findViewById(R.id.TVPrivacy);
        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int5 = new Intent(getApplicationContext(), PrivacyActivity.class);
                startActivity(int5);
            }
        });

        TextView txt6 = findViewById(R.id.TVtnc);
        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int6 = new Intent(getApplicationContext(), TermsActivity.class);
                startActivity(int6);
            }
        });
    }


}

