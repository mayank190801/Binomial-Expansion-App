package com.example.binomialexpansion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_final_solution.*

class FinalSolution : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_solution)

        val intent = intent
        var finalAnswer = intent.getStringExtra("FinalAnswer")

        solutionTv.text = finalAnswer

        backButton.setOnClickListener {

            val intent = Intent(this, EnterInputs::class.java)
            startActivity(intent)
            finish()

        }
    }
}