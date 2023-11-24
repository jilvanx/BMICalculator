package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalc: Button = findViewById(R.id.btnCalc)
        val edtWeight: EditText = findViewById(R.id.editWeight)
        val edtHeight: EditText = findViewById(R.id.editHeight)

        btnCalc.setOnClickListener {

            val heightStr = edtHeight.text.toString()
            val weightStr = edtWeight.text.toString()

            if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {

                val weight: Float = edtWeight.text.toString().toFloat()
                val height: Float = edtHeight.text.toString().toFloat()

                val result = weight / (height * height)

                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("EXTRA_RESULT", result)
                }

                startActivity(intent)

            } else {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_LONG).show()
            }

        }

    }
}