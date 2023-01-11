package com.example.foster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import android.app.ProgressDialog;

import java.util.HashMap;
import java.util.Objects;



public class SettingsName extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_edit_name);

        EditText editfirstname = findViewById(R.id.editTextFirstName);
        EditText editlastname = findViewById(R.id.editTextLastName);
        Button confirm = findViewById(R.id.submitButton);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference root = db.getInstance().getReference();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editfirstname.getText().toString().isEmpty() || editlastname.getText().toString().isEmpty()) {
                    Toast.makeText(SettingsName.this, "Please fill in the text fields", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(SettingsName.this, "Saved successfully", Toast.LENGTH_SHORT).show();
                    String firstName = editfirstname.getText().toString();
                    String lastName = editlastname.getText().toString();

                    HashMap<String, Object> userMap = new HashMap<>();
                    userMap.put("firstName", firstName);
                    userMap.put("lastName", lastName);

                    root.child("Users").child(Objects.requireNonNull(firebaseAuth.getUid())).updateChildren(userMap);


                }

            }
        });


    }
}