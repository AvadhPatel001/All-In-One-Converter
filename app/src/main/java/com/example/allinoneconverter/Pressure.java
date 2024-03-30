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

public class Pressure extends AppCompatActivity {

    Spinner unit1;
    Spinner unit2;
    String[] List_1 = {"atm", "bar", "mmHg", "pascal", "psi"};
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
        setContentView(R.layout.activity_pressure);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Pressure Conversion");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        unit1 = findViewById(R.id.spinner_pressure_1);
        unit2 = findViewById(R.id.spinner_pressure_2);
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
                Toast.makeText(Pressure.this, "Please Enter Value", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void conversion()
    {
        try {
            if (fromUnit.equalsIgnoreCase("atm") && toUnit.equalsIgnoreCase("atm"))
            {
                toValue = fromValue;
            }
            else if (fromUnit.equalsIgnoreCase("atm") && toUnit.equalsIgnoreCase("bar"))
            {
                toValue = fromValue * 1.013;
            }
            else if (fromUnit.equalsIgnoreCase("atm") && toUnit.equalsIgnoreCase("mmHg"))
            {
                toValue = fromValue * 760.0;
            }
            else if (fromUnit.equalsIgnoreCase("atm") && toUnit.equalsIgnoreCase("pascal"))
            {
                toValue = fromValue * 101300.0;
            }
            else if (fromUnit.equalsIgnoreCase("atm") && toUnit.equalsIgnoreCase("psi"))
            {
                toValue = fromValue * 14.696;
            }
            else if (fromUnit.equalsIgnoreCase("bar") && toUnit.equalsIgnoreCase("atm"))
            {
                toValue = fromValue / 1.013;
            }
            else if (fromUnit.equalsIgnoreCase("bar") && toUnit.equalsIgnoreCase("bar"))
            {
                toValue = fromValue;
            }
            else if (fromUnit.equalsIgnoreCase("bar") && toUnit.equalsIgnoreCase("mmHg"))
            {
                toValue = fromValue * 750.1;
            }
            else if (fromUnit.equalsIgnoreCase("bar") && toUnit.equalsIgnoreCase("pascal"))
            {
                toValue = fromValue * 100000;
            }
            else if (fromUnit.equalsIgnoreCase("bar") && toUnit.equalsIgnoreCase("psi"))
            {
                toValue = fromValue * 14.504;
            }
            else if (fromUnit.equalsIgnoreCase("mmHg") && toUnit.equalsIgnoreCase("atm"))
            {
                toValue = fromValue / 760.0;
            }
            else if (fromUnit.equalsIgnoreCase("mmHg") && toUnit.equalsIgnoreCase("bar"))
            {
                toValue = fromValue / 750.1;
            }
            else if (fromUnit.equalsIgnoreCase("mmHg") && toUnit.equalsIgnoreCase("mmHg"))
            {
                toValue = fromValue;
            }
            else if (fromUnit.equalsIgnoreCase("mmHg") && toUnit.equalsIgnoreCase("pascal"))
            {
                toValue = fromValue * 133.322;
            }
            else if (fromUnit.equalsIgnoreCase("mmHg") && toUnit.equalsIgnoreCase("psi"))
            {
                toValue = fromValue / 51.751;
            }
            else if (fromUnit.equalsIgnoreCase("pascal") && toUnit.equalsIgnoreCase("atm"))
            {
                toValue = fromValue / 101300.0;
            }
            else if (fromUnit.equalsIgnoreCase("pascal") && toUnit.equalsIgnoreCase("bar"))
            {
                toValue = fromValue / 100000.0;
            }
            else if (fromUnit.equalsIgnoreCase("pascal") && toUnit.equalsIgnoreCase("mmHg"))
            {
                toValue = fromValue / 133.3;
            }
            else if (fromUnit.equalsIgnoreCase("pascal") && toUnit.equalsIgnoreCase("pascal"))
            {
                toValue = fromValue;
            }
            else if (fromUnit.equalsIgnoreCase("pascal") && toUnit.equalsIgnoreCase("psi"))
            {
                toValue = fromValue / 6895.0;
            }
            else if (fromUnit.equalsIgnoreCase("psi") && toUnit.equalsIgnoreCase("atm"))
            {
                toValue = fromValue / 14.696;
            }
            else if (fromUnit.equalsIgnoreCase("psi") && toUnit.equalsIgnoreCase("bar"))
            {
                toValue = fromValue / 14.504;
            }
            else if (fromUnit.equalsIgnoreCase("psi") && toUnit.equalsIgnoreCase("mmHg"))
            {
                toValue = fromValue * 51.715;
            }
            else if (fromUnit.equalsIgnoreCase("psi") && toUnit.equalsIgnoreCase("pascal"))
            {
                toValue = fromValue * 6894.76;
            }
            else if (fromUnit.equalsIgnoreCase("psi") && toUnit.equalsIgnoreCase("psi"))
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