package com.example.taskcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editText1: EditText = findViewById(R.id.editText1)
        val editText2: EditText = findViewById(R.id.editText2)
        val editText3: EditText = findViewById(R.id.editText3)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val textViewIntersect: TextView = findViewById(R.id.textViewIntersect)
        val textViewUnion: TextView = findViewById(R.id.textViewUnion)
        val textViewMax: TextView = findViewById(R.id.textViewMax)

        buttonCalculate.setOnClickListener {
            val input1 = editText1.text.toString()
            val input2 = editText2.text.toString()
            val input3 = editText3.text.toString()

            if (input1.isNotEmpty() && input2.isNotEmpty() && input3.isNotEmpty()) {
                try {
                    val numbers1 = input1.split(",").map { it.trim().toInt() }.toSet()
                    val numbers2 = input2.split(",").map { it.trim().toInt() }.toSet()
                    val numbers3 = input3.split(",").map { it.trim().toInt() }.toSet()

                    val intersect = numbers1 intersect numbers2 intersect numbers3
                    val union = numbers1 union numbers2 union numbers3
                    val max = (numbers1 + numbers2 + numbers3).maxOrNull()

                    textViewIntersect.text = "Intersect: ${intersect.joinToString(", ")}"
                    textViewUnion.text = "Union: ${union.joinToString(", ")}"
                    textViewMax.text = "Max: $max"
                } catch (e: NumberFormatException) {
                    Toast.makeText(
                        this,
                        "Invalid input. Please enter comma-separated numbers.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(this, "All fields must be filled.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

