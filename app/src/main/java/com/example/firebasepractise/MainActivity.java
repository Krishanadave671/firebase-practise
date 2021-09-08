package com.example.firebasepractise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import android.view.View;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;



public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Mainactivity";
    private static final String key_title = "title";
    private static final String Key_Description = "description";
    private EditText editTexttitle, editTextDescrition;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTexttitle = findViewById(R.id.Edit_text_Title);
        editTextDescrition = findViewById(R.id.Edit_text_description);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTexttitle.getText().toString();
                String Description = editTextDescrition.getText().toString();
                Map<String, Object> note = new HashMap<>();
                note.put(key_title, title);
                note.put(Key_Description, Description);
                db.collection("Notebook").document("My first Note").set(note)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(MainActivity.this, "Note saved", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                                Log.d(TAG, e.toString());
                            }
                        });
            }


});}}















