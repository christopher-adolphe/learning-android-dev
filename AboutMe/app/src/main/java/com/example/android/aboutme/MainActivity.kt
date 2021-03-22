package com.example.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Declaring a Binding Object for the main activity
    private lateinit var binding: ActivityMainBinding

    // Creating an instance of the MyName data class
    private val myName: MyName = MyName("John Doe")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Using the findViewById approach
        // Using setContentView to connect the layout to the activity
        // setContentView(R.layout.activity_main)

        // val doneButton: Button = findViewById(R.id.done_button)

        // doneButton.setOnClickListener {
            // addNickname(it)
        // }

        // Using the Binding Object approach
        // Setting the Binding Object to the inflated layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Setting the myName variable in the layout to the instance of the MyName data class
        binding.myName = myName

        // Using the Binding Object to reference the view elements
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        // val editText: EditText = findViewById(R.id.nickname_edit)
        // val nicknameText: TextView = findViewById(R.id.nickname_text)

        // nicknameText.text = editText.text
        // editText.visibility = View.GONE
        // view.visibility = View.GONE
        // nicknameText.visibility = View.VISIBLE

        // Using kotlin apply to reduce binding repetition
        binding.apply {
            // nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()

            // Using invalidateAll() to invalidate all binding expression and refresh the UI with the new data
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}