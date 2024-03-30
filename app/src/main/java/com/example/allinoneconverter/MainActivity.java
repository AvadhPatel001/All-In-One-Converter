package com.example.allinoneconverter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button weight = findViewById(R.id.weight);
        Button length = findViewById(R.id.length);
        Button temperature = findViewById(R.id.temperature);
        Button pressure = findViewById(R.id.pressure);
        Button angle = findViewById(R.id.angle);

        weight.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Weight.class);
            startActivity(intent);
        });

        length.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Length.class);
            startActivity(intent);
        });

        temperature.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Temperature.class);
            startActivity(intent);
        });

        pressure.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Pressure.class);
            startActivity(intent);
        });

        angle.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Angle.class);
            startActivity(intent);
        });

    }
}