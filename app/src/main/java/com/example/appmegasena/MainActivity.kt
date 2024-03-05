package com.example.appmegasena

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get the objects by searching it's reference
        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        // Option 1: XML
        // Function below that need's to be called in activity_main.xml

        // Option 2: variable of type (anonymous object) View.OnClickListener (interface)
        // btnGenerate.setOnClickListener(btnClickListener)

        // Option 3: simplest and recommended option - code block that will be fired directly by the onClickListener interface
        btnGenerate.setOnClickListener {
            // Programming logic for touch events goes here

            val text = editText.text.toString()

            numberGenerator(text, txtResult)
        }
    }

    private fun numberGenerator(text: String, txtResult: TextView) {
        // Check if field is empty
        if (text.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_LONG).show()
            return
        }

        // Check if number is between 6 and 15
        val value = text.toInt()

        if (value < 6 || value > 15) {
            Toast.makeText(this, "Enter a number between 6 and 15", Toast.LENGTH_LONG).show()
            return
        }

        // Generate random numbers
        val random = Random()
        val numbers = mutableSetOf<Int>()

        while (true) {
            val number = random.nextInt(60) // 0...59
            numbers.add(number + 1)

            if (numbers.size == value) {
                break
            }
        }

        txtResult.text = numbers.joinToString(" | ")
    }


    // Option 1: XML
//    fun buttonClicked(view: View) {
//        Log.i("Test", "Button Clicked!")
//    }

    // Option 2: Variable
//    val btnClickListener = object : View.OnClickListener {
//        override fun onClick(v: View?) {
//            Log.i("Test", "Button Clicked!!!")
//        }
//
//    }

    // Lambda expression
//    val btnClickListener = View.OnClickListener { Log.i("Test", "Button Clicked!!!") }


}
