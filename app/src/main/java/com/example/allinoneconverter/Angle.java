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

public class Angle extends AppCompatActivity {

    Spinner unit1;
    Spinner unit2;
    String[] List_1 = {"degree", "radian"};
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
        setContentView(R.layout.activity_angle);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Angle Conversion");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        unit1 = findViewById(R.id.spinner_angle_1);
        unit2 = findViewById(R.id.spinner_angle_2);
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
                Toast.makeText(Angle.this, "Please Enter Value", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void conversion()
    {
        try {
            if (fromUnit.equalsIgnoreCase("degree") && toUnit.equalsIgnoreCase("radian"))
            {
                toValue = fromValue / 57.3;
            }
            else if (fromUnit.equalsIgnoreCase("degree") && toUnit.equalsIgnoreCase("degree"))
            {
                toValue = fromValue;
            }
            else if (fromUnit.equalsIgnoreCase("radian") && toUnit.equalsIgnoreCase("degree"))
            {
                toValue = fromValue * 57.3;
            }
            else
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