package com.example.appmegasena

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
            Log.i("Test", "Button Clicked!!!")
        }
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
