package com.bignerdranch.android.appideas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.appideas.databinding.ActivityMainBinding
import com.bignerdranch.android.appideas.databinding.ActivityViewIdeasBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

//    private val ideaLauncher = registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult()
//    ) { result ->
//        // Handle the result
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewButton.setOnClickListener {
            val intent = Intent(this@MainActivity, ViewIdeas::class.java)
            startActivity(intent)
//            ideaLauncher.launch(intent)
        }
    }

}