package com.example.roadrivals

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class GameRegister : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout for this activity
        setContentView(R.layout.activity_game_register)

        // Initialize views
        editText = findViewById(R.id.editTextText45)
        val continueBtn = findViewById<Button>(R.id.continueBtn)


        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Set a click listener for the continue button
        continueBtn.setOnClickListener {
            // Retrieve the player name entered in the editText
            val playerName = editText.text.toString()
            // Save the player name in SharedPreferences
            savePlayerName(playerName)
            // Start MainActivity
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    // Function to save the player name in SharedPreferences
    private fun savePlayerName(playerName: String) {
        // Get an editor for SharedPreferences
        val editor = sharedPreferences.edit()
        // Put the player name into SharedPreferences
        editor.putString("playerName", playerName)
        // Apply the changes
        editor.apply()
    }
}
