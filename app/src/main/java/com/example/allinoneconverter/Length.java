package com.example.allinoneconverter;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;



public class Length extends AppCompatActivity {

        Spinner unit1;
        Spinner unit2;
        String[] List_1 = {"cm", "foot", "inch", "km", "meter", "mile", "mm"};
        double fromValue = 0.0;
        double toValue = 0.0;
        String fromUnit = "";
        String toUnit = "";
        EditText value1;
        EditText value2;
        Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_length);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Length Conversion");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        unit1 = findViewById(R.id.spinner_length_1);
        unit2 = findViewById(R.id.spinner_length_2);
        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        convert = findViewById(R.id.convert);

        List_Vales();
    }

    private void List_Vales() {
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
                Toast.makeText(Length.this, "Please Enter Value", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void conversion() {
        try {
            if (fromUnit.equalsIgnoreCase("cm") && toUnit.equalsIgnoreCase("cm"))
            {
                toValue = fromValue;
            }
            else if (fromUnit.equalsIgnoreCase("cm") && toUnit.equalsIgnoreCase("foot"))
            {
                toValue = fromValue / 30.48;
            }
            else if (fromUnit.equalsIgnoreCase("cm") && toUnit.equalsIgnoreCase("inch"))
            {
                toValue = fromValue / 2.54;
            }
            else if (fromUnit.equalsIgnoreCase("cm") && toUnit.equalsIgnoreCase("km"))
            {
                toValue = fromValue / 100000.0;
            }
            else if (fromUnit.equalsIgnoreCase("cm") && toUnit.equalsIgnoreCase("meter"))
            {
                toValue = fromValue / 100.0;
            }
            else if (fromUnit.equalsIgnoreCase("cm") && toUnit.equalsIgnoreCase("mile"))
            {
                toValue = fromValue / 160934.0;
            }
            else if (fromUnit.equalsIgnoreCase("cm") && toUnit.equalsIgnoreCase("mm"))
            {
                toValue = fromValue * 10.0;
            }
            else if (fromUnit.equalsIgnoreCase("foot") && toUnit.equalsIgnoreCase("cm"))
            {
                toValue = fromValue * 30.48;
            }
            else if (fromUnit.equalsIgnoreCase("foot") && toUnit.equalsIgnoreCase("foot"))
            {
                toValue = fromValue;
            }
            else if (fromUnit.equalsIgnoreCase("foot") && toUnit.equalsIgnoreCase("inch"))
            {
                toValue = fromValue * 12.0;
            }
            else if (fromUnit.equalsIgnoreCase("foot") && toUnit.equalsIgnoreCase("km"))
            {
                toValue = fromValue / 3280.84;
            }
            else if (fromUnit.equalsIgnoreCase("foot") && toUnit.equalsIgnoreCase("meter"))
            {
                toValue = fromValue / 3.28084;
            }
            else if (fromUnit.equalsIgnoreCase("foot") && toUnit.equalsIgnoreCase("mile"))
            {
                toValue = fromValue / 5280.0;
            }
            else if (fromUnit.equalsIgnoreCase("foot") && toUnit.equalsIgnoreCase("mm"))
            {
                toValue = fromValue * 304.8;
            }
            else if (fromUnit.equalsIgnoreCase("inch") && toUnit.equalsIgnoreCase("cm"))
            {
                toValue = fromValue * 2.54;
            }
            else if (fromUnit.equalsIgnoreCase("inch") && toUnit.equalsIgnoreCase("foot"))
            {
                toValue = fromValue / 12.0;
            }
            else if (fromUnit.equalsIgnoreCase("inch") && toUnit.equalsIgnoreCase("inch"))
            {
                toValue = fromValue;
            }
            else if (fromUnit.equalsIgnoreCase("inch") && toUnit.equalsIgnoreCase("km"))
            {
                toValue = fromValue / 39370.1;
            }
            else if (fromUnit.equalsIgnoreCase("inch") && toUnit.equalsIgnoreCase("meter"))
            {
                toValue = fromValue / 39.3701;
            }
            else if (fromUnit.equalsIgnoreCase("inch") && toUnit.equalsIgnoreCase("mile"))
            {
                toValue = fromValue / 63360.0;
            }
            else if (fromUnit.equalsIgnoreCase("inch") && toUnit.equalsIgnoreCase("mm"))
            {
                toValue = fromValue * 25.4;
            }
            else if (fromUnit.equalsIgnoreCase("km") && toUnit.equalsIgnoreCase("cm"))
            {
                toValue = fromValue * 100000.0;
            }
            else if (fromUnit.equalsIgnoreCase("km") && toUnit.equalsIgnoreCase("foot"))
            {
                toValue = fromValue * 3280.84;
            }
            else if (fromUnit.equalsIgnoreCase("km") && toUnit.equalsIgnoreCase("inch"))
            {
                toValue = fromValue * 39370.1;
            }
            else if (fromUnit.equalsIgnoreCase("km") && toUnit.equalsIgnoreCase("km"))
            {
                toValue = fromValue;
            }
            else if (fromUnit.equalsIgnoreCase("km") && toUnit.equalsIgnoreCase("meter"))
            {
                toValue = fromValue * 1000.0;
            }
            else if (fromUnit.equalsIgnoreCase("km") && toUnit.equalsIgnoreCase("mile"))
            {
                toValue = fromValue / 1.60934;
            }
            else if (fromUnit.equalsIgnoreCase("km") && toUnit.equalsIgnoreCase("mm"))
            {
                toValue = fromValue * (1e+6);
            }
            else if (fromUnit.equalsIgnoreCase("meter") && toUnit.equalsIgnoreCase("cm"))
            {
                toValue = fromValue * 100;
            }
            else if (fromUnit.equalsIgnoreCase("meter") && toUnit.equalsIgnoreCase("foot"))
            {
                toValue = fromValue * 3.28084;
            }
            else if (fromUnit.equalsIgnoreCase("meter") && toUnit.equalsIgnoreCase("inch"))
            {
                toValue = fromValue * 39.3701;
            }
            else if (fromUnit.equalsIgnoreCase("meter") && toUnit.equalsIgnoreCase("km"))
            {
                toValue = fromValue / 1000.0;
            }
            else if (fromUnit.equalsIgnoreCase("meter") && toUnit.equalsIgnoreCase("meter"))
            {
                toValue = fromValue;
            }
            else if (fromUnit.equalsIgnoreCase("meter") && toUnit.equalsIgnoreCase("mile"))
            {
                toValue = fromValue * 1609.34;
            }
            else if (fromUnit.equalsIgnoreCase("meter") && toUnit.equalsIgnoreCase("mm"))
            {
                toValue = fromValue * 1000.0;
            }
            else if (fromUnit.equalsIgnoreCase("mile") && toUnit.equalsIgnoreCase("cm"))
            {
                toValue = fromValue * 160934.0;
            }
            else if (fromUnit.equalsIgnoreCase("mile") && toUnit.equalsIgnoreCase("foot"))
            {
                toValue = fromValue * 5280.0;
            }
            else if (fromUnit.equalsIgnoreCase("mile") && toUnit.equalsIgnoreCase("inch"))
            {
                toValue = fromValue * 63360.0;
            }
            else if (fromUnit.equalsIgnoreCase("mile") && toUnit.equalsIgnoreCase("km"))
            {
                toValue = fromValue * 1.60934;
            }
            else if (fromUnit.equalsIgnoreCase("mile") && toUnit.equalsIgnoreCase("meter"))
            {
                toValue = fromValue * 1609.34;
            }
            else if (fromUnit.equalsIgnoreCase("mile") && toUnit.equalsIgnoreCase("mile"))
            {
                toValue = fromValue;
            }
            else if (fromUnit.equalsIgnoreCase("mile") && toUnit.equalsIgnoreCase("mm"))
            {
                toValue = fromValue * (1.609e+6);
            }
            else if (fromUnit.equalsIgnoreCase("mm") && toUnit.equalsIgnoreCase("cm"))
            {
                toValue = fromValue / 10.0;
            }
            else if (fromUnit.equalsIgnoreCase("mm") && toUnit.equalsIgnoreCase("foot"))
            {
                toValue = fromValue / 304.8;
            }
            else if (fromUnit.equalsIgnoreCase("mm") && toUnit.equalsIgnoreCase("inch"))
            {
                toValue = fromValue / 25.4;
            }
            else if (fromUnit.equalsIgnoreCase("mm") && toUnit.equalsIgnoreCase("km"))
            {
                toValue = fromValue / (1e+6);
            }
            else if (fromUnit.equalsIgnoreCase("mm") && toUnit.equalsIgnoreCase("meter"))
            {
                toValue = fromValue / 1000.0;
            }
            else if (fromUnit.equalsIgnoreCase("mm") && toUnit.equalsIgnoreCase("mile"))
            {
                toValue = fromValue / (1.609e+6);
            }
            else if (fromUnit.equalsIgnoreCase("mm") && toUnit.equalsIgnoreCase("mm"))
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