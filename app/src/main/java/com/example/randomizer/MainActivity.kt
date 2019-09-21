package com.example.randomizer

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils.isEmpty
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val textEditWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            randomizeButton.isEnabled = isInputsValid()
            randomizeButton.isClickable = isInputsValid()
            if (!isInputsValid()) {
                randomizeButton.setBackgroundColor(resources.getColor(R.color.colorDisabled))
            } else {
                randomizeButton.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        randomizeButton.setOnClickListener { randomize() }
        randomizeButton.isEnabled = isInputsValid()
        randomizeButton.isClickable = isInputsValid()
        if (!isInputsValid()) {
            randomizeButton.setBackgroundColor(resources.getColor(R.color.colorDisabled))
        } else randomizeButton.setBackgroundColor(resources.getColor(R.color.colorPrimary))

        minEdit.addTextChangedListener(textEditWatcher)
        maxEdit.addTextChangedListener(textEditWatcher)
    }

    private fun randomize() {
        if (!isEmpty(minEdit.text.toString()) && !isEmpty(maxEdit.text.toString())) {
            val min = minEdit.text.toString().toInt()
            val max = maxEdit.text.toString().toInt()
            val result = (min..max).random()
            outputText.text = result.toString()
            Toast.makeText(this, "Your random number: $result", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isInputsValid(): Boolean {
        return !isEmpty(minEdit.text) && !isEmpty(maxEdit.text)
                && (minEdit.text.toString().toInt() <= maxEdit.text.toString().toInt())
    }
}
