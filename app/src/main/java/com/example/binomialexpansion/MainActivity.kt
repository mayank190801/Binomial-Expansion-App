package com.example.binomialexpansion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        startButton.setOnClickListener {
            val intent = Intent(this,EnterInputs::class.java)
            startActivity(intent)
            finish()
        }

        //Things left to do in this APP
        //-> Making the UI of the both the pages better
        //Hint and types stuff should be cleared

        //Outputing Something more with the final solutions
        //Not just the direct Answer
        //Properly Comment Down the Code Sections!!!!
        //That's it for the project
    }


}