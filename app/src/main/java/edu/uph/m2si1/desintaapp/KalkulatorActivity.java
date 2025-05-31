package edu.uph.m2si1.desintaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KalkulatorActivity extends AppCompatActivity {
    EditText angka1, angka2;
    Button tombolTambah, tombolKali, tombolBagi;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        angka1 = findViewById(R.id.angka1);
        angka2 = findViewById(R.id.angka2);
        tombolTambah = findViewById(R.id.tombolTambah);
        tombolKali = findViewById(R.id.tombolKali);
        tombolBagi = findViewById(R.id.tombolBagi);
        hasil = findViewById(R.id.hasil);

        tombolTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('+');
            }
        });

        tombolKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('*');
            }
        });

        tombolBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('/');
            }
        });
    }

    private void hitung(char operasi) {
        String input1 = angka1.getText().toString();
        String input2 = angka2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            hasil.setText("Masukkan kedua angka!");
            return;
        }

        double a = Double.parseDouble(input1);
        double b = Double.parseDouble(input2);
        double hasilPerhitungan = 0;

        switch (operasi) {
            case '+':
                hasilPerhitungan = a + b;
                break;
            case '*':
                hasilPerhitungan = a * b;
                break;
            case '/':
                if (b == 0) {
                    hasil.setText("Tidak bisa dibagi 0!");
                    return;
                }
                hasilPerhitungan = a / b;
                break;
        }

        hasil.setText(String.valueOf(hasilPerhitungan));
    }
}

