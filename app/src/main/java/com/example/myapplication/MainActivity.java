package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("is_crying");

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        Button btn = (Button)findViewById(R.id.btn1);
        btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                Toast t = Toast.makeText(getApplicationContext(),"Click Button",Toast.LENGTH_SHORT);
                t.show();
                v.cancel();
                myRef.setValue(0);
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            private static final String TAG = "Error!";
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value = dataSnapshot.getValue(Long.class);
                if(value == 1){
                    Toast t = Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_SHORT);
                    t.show();
                    v.vibrate(100000);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
