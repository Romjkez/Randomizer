package com.example.randomizer

import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        randomizeButton.setOnClickListener { randomize() }
    }

    private fun randomize() {
        if (!isEmpty(minEdit.text.toString()) && !isEmpty(maxEdit.text.toString())) {
            val min = minEdit.text.toString().toInt()
            val max = maxEdit.text.toString().toInt()
            val result = (min..max).random()
            outputText.text = result.toString()
            Toast.makeText(this, "Your random number: $result", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Enter min and max value", Toast.LENGTH_SHORT).show()
        }
    }
}
