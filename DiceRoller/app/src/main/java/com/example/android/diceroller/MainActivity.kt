package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

// An activity is a core android class responsible for
// drawing an app user interface and receiving input events.
// Layout inflation is the process of creating a view hierarchy tree
// by converting layout xml file into kotlin view objects in memory.
// The view hierarchy tree matches the structure of the layout xml file.
class MainActivity : AppCompatActivity() {
    // Using lateinit to initialize non-null variables
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // The setContentView method starts the layout inflation
        setContentView(R.layout.activity_main)

        // Using the findViewById method to get a reference to the image view
        diceImage = findViewById(R.id.dice_image)

        // Using the findViewById method to get a reference to the button view in the xml layout
        // and assigning it to an immutable variable
        val rollButton: Button = findViewById(R.id.roll_button)

        // Setting the label of the button view dynamically
        rollButton.text = "Let's Roll"

        // Setting a click listener on the button
        rollButton.setOnClickListener {
            // Using a toast to display a text whenever the button is clicked
            //Toast.makeText(this, "Roll button clicked", Toast.LENGTH_SHORT).show()

            // Calling the rollDice method
            rollDice()
        }
    }

    private fun rollDice() {
        // Using the Random method to generate a random number between 1 & 6
        val randomInt: Int = Random().nextInt(6) + 1

        // Using the findViewById method to get a reference to the text view
        // val resultText: TextView = findViewById(R.id.result_text)

        // Setting the label of the text view to the random number
        // resultText.text = randomInt.toString()

        // Using a when expression to get the respective drawable resource based on the random num
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Setting the source of the image view dynamically
        diceImage.setImageResource(drawableResource)
    }
}