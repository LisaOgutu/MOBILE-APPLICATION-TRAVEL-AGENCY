package com.example.doramilaje;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ItineraryActivity extends AppCompatActivity {
    private EditText itineraryEditText;
    private Button saveItineraryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary);

        itineraryEditText = findViewById(R.id.itineraryEditText);
        saveItineraryButton = findViewById(R.id.saveItineraryButton);

        saveItineraryButton.setOnClickListener(v -> saveItinerary());
    }

    private void saveItinerary() {
        String itineraryDetails = itineraryEditText.getText().toString().trim();

        if (itineraryDetails.isEmpty()) {
            Toast.makeText(this, "Please enter itinerary details", Toast.LENGTH_SHORT).show();
            return;
        }

        // Here you would typically save the itinerary to a database or a file
        // For demonstration, we will just show a toast
        Toast.makeText(this, "Itinerary saved: " + itineraryDetails, Toast.LENGTH_SHORT).show();

        // Clear the input field after saving
        itineraryEditText.setText("");
    }
}