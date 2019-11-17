package com.example.foodrecipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.foodrecipe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Create a variable for the binding object
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Uses the setContentView() function from the DataBindingUtil class to associate the
        activity_main layout with the com.example.foodrecipe.MainActivity */
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }

}