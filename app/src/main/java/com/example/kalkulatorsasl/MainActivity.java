package com.example.kalkulatorsasl;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etNilai1, etNilai2;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNilai1 = findViewById(R.id.etNilai1);
        etNilai2 = findViewById(R.id.etNilai2);
        tvHasil = findViewById(R.id.tvHasil);
    }

    private double getNilai1() {
        String input = etNilai1.getText().toString();
        if(input.isEmpty()) return 0;
        return Double.parseDouble(input);
    }

    private double getNilai2() {
        String input = etNilai2.getText().toString();
        if(input.isEmpty()) return 0;
        return Double.parseDouble(input);
    }

    public void onTambah(View view) {
        hitung('+');
    }

    public void onKurang(View view) {
        hitung('-');
    }

    public void onKali(View view) {
        hitung('×');
    }

    public void onBagi(View view) {
        hitung('÷');
    }

    private void hitung(char operator) {
        double nilai1 = getNilai1();
        double nilai2 = getNilai2();
        double hasil = 0;

        try {
            switch (operator) {
                case '+':
                    hasil = nilai1 + nilai2;
                    break;
                case '-':
                    hasil = nilai1 - nilai2;
                    break;
                case '×':
                    hasil = nilai1 * nilai2;
                    break;
                case '÷':
                    if(nilai2 == 0) {
                        Toast.makeText(this, "Tidak bisa membagi dengan nol", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    hasil = nilai1 / nilai2;
                    break;
            }

            // Format hasil ke 2 desimal
            tvHasil.setText(String.format("Hasil Perhitungan: %.2f", hasil));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show();
        }
    }
}