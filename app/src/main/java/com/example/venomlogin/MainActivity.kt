package com.example.venomlogin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnAdd: Button
    private lateinit var btnSub: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivision: Button
    private lateinit var etA: EditText
    private lateinit var etB: EditText
    private lateinit var resultTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)   // Load the XML layout

        // Initialize views (IDs match your XML exactly)
        btnAdd = findViewById(R.id.btn_add)
        btnSub = findViewById(R.id.btn_substruct)
        btnMultiply = findViewById(R.id.btn_multiplication)
        btnDivision = findViewById(R.id.btn_division)
        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        resultTv = findViewById(R.id.result_tv)

        // Set click listeners
        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnDivision.setOnClickListener(this)

        // Clear button functionality
        val clearBtn: Button = findViewById(R.id.btn_clear)
        val etA: EditText = findViewById(R.id.et_a)
        val etB: EditText = findViewById(R.id.et_b)
        val resultTv: TextView = findViewById(R.id.result_tv)

        clearBtn.setOnClickListener {
            etA.text.clear()        // clear first input
            etB.text.clear()        // clear second input
            resultTv.text = "Result" // reset the result text
        }


    }

    override fun onClick(v: View?) {
        // Get numbers safely (default 0 if input empty/invalid)
        val a = etA.text.toString().toDoubleOrNull() ?: 0.0
        val b = etB.text.toString().toDoubleOrNull() ?: 0.0
        var result = 0.0

        // Perform operation depending on which button was clicked
        when (v?.id) {
            R.id.btn_add -> result = a + b
            R.id.btn_substruct -> result = a - b
            R.id.btn_multiplication -> result = a * b
            R.id.btn_division -> result = if (b != 0.0) a / b else Double.NaN
        }

        // Show result
        resultTv.text = "Result is $result"
    }
}