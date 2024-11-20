package com.example.doramilaje


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.doramilaje.ui.theme.DoramilajeTheme
import androidx.appcompat.app.AppCompatActivity;


public final class MainActivity : ComponentActivity() {
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize DatabaseHelper
        dbHelper = DatabaseHelper(this)

        // Populate the database
        populateDatabase()

        setContent {
            DoramilajeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }


    }

    private fun populateDatabase() {
        // Example data to insert
        val hotelData = listOf(
            Hotel("Hotel A", "Location A", "5 Stars", 100),
            Hotel("Hotel B", "Location B", "4 Stars", 80),
            Hotel("Hotel C", "Location C", "3 Stars", 60)
        )

        // Insert each hotel into the database
        for (hotel in hotelData) {
            dbHelper.addData(hotel.name, hotel.location, hotel.rating, hotel.price.toString())
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        DoramilajeTheme {
            Greeting("Android")
        }
    }

    // Data class to represent hotel information
    data class Hotel(val name: String, val location: String, val rating: String, val price: Int)
}







