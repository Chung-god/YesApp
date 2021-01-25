package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                Toast t = Toast.makeText(getApplicationContext(),"end",Toast.LENGTH_SHORT);
                t.show();
                Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                v.vibrate(1000);
            }
        });
    }
}
