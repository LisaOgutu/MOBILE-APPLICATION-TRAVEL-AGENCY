package com.example.doramilaje;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ReservationActivity extends AppCompatActivity {
    private EditText locationEditText, datesEditText;
    private Button reserveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        locationEditText = findViewById(R.id.locationEditText);
        datesEditText = findViewById(R.id.datesEditText);
        reserveButton = findViewById(R.id.reserveButton);

        reserveButton.setOnClickListener(v -> reserve());
    }

    private void reserve() {
        String location = locationEditText.getText().toString().trim();
        String dates = datesEditText.getText().toString().trim();

        // Here you would integrate with a payment gateway and save the reservation
        // For demonstration, we will just show a toast
        Toast.makeText(this, "Reservation made for " + location + " on " + dates, Toast.LENGTH_SHORT).show();
    }
}
