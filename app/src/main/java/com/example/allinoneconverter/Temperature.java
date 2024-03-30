package com.example.allinoneconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;

public class Temperature extends AppCompatActivity {

    Spinner unit1;
    Spinner unit2;
    String[] List_1 = {"°C", "F", "K"};
    double fromValue = 0.0;
    double toValue = 0.0;
    String fromUnit = "";
    String toUnit = "";
    EditText value1;
    EditText value2;
    Button convert;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_temperature);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Temperature Conversion");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        unit1 = findViewById(R.id.spinner_temperature_1);
        unit2 = findViewById(R.id.spinner_temperature_2);
        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        convert = findViewById(R.id.convert);

        List_Vales();
    }

    private void List_Vales()
    {
        ArrayAdapter<String> UnitList = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, List_1);
        unit1.setAdapter(UnitList);
        unit2.setAdapter(UnitList);

        convert.setOnClickListener(v -> {
            try {
                fromValue = Double.parseDouble(value1.getText().toString());
                fromUnit = unit1.getSelectedItem().toString();
                toUnit = unit2.getSelectedItem().toString();
                conversion();
            }
            catch (Exception e)
            {
                Toast.makeText(Temperature.this, "Please Enter Value", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void conversion()
    {
        try {
            if (fromUnit.equalsIgnoreCase("°C") && toUnit.equalsIgnoreCase("°C"))
            {
                toValue = fromValue;
            }
            else if (fromUnit.equalsIgnoreCase("°C") && toUnit.equalsIgnoreCase("F"))
            {
                toValue = (fromValue * (9.0 / 5.0)) + 32.0;
            }
            else if (fromUnit.equalsIgnoreCase("°C") && toUnit.equalsIgnoreCase("K"))
            {
                toValue = fromValue + 273.15;
            }
            else if (fromUnit.equalsIgnoreCase("F") && toUnit.equalsIgnoreCase("°C"))
            {
                toValue = (fromValue - 32) * (5.0 / 9.0);
            }
            else if (fromUnit.equalsIgnoreCase("F") && toUnit.equalsIgnoreCase("F"))
            {
                toValue = fromValue;
            }
            else if (fromUnit.equalsIgnoreCase("F") && toUnit.equalsIgnoreCase("K"))
            {
                toValue = ((fromValue - 32) * (5.0 / 9.0)) + 273.15;
            }
            else if (fromUnit.equalsIgnoreCase("K") && toUnit.equalsIgnoreCase("°C"))
            {
                toValue = fromValue - 273.15;
            }
            else if (fromUnit.equalsIgnoreCase("K") && toUnit.equalsIgnoreCase("F"))
            {
                toValue = ((fromValue - 273.15) * (9.0 / 5.0)) + 32;
            }
            else if (fromUnit.equalsIgnoreCase("K") && toUnit.equalsIgnoreCase("K"))
            {
                toValue = fromValue;
            }

            value2.setText(String.valueOf(toValue));
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}