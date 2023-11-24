package com.example.bmicalculator

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Classification {
    var description: String = ""
    var color: Int = 0
}

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassification = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.0f)

        tvResult.text = result.toString()

        val classificationObj = Classification().apply {
            if (result < 18.5f) {
                description = "UNDERWEIGHT"
                color = getColor(R.color.red)
            } else if (result in 18.5f..24.9f) {
                description = "NORMAL"
                color = getColor(R.color.green)
            } else if (result in 25f..29.9f) {
                description = "OVERWEIGHT"
                color = getColor(R.color.yellow)
            } else if (result in 30f..39.9f) {
                description = "OBESITY"
                color = getColor(R.color.red)
            } else {
                description = "SEVERE OBESITY"
                color = getColor(R.color.red)
            }
        }

        tvClassification.text = getString(R.string.message_classification, classificationObj.description)
        tvClassification.setTextColor(classificationObj.color)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

}