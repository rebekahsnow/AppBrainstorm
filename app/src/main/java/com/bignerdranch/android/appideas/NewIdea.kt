package com.bignerdranch.android.appideas

import IdeasViewModel
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.appideas.databinding.ActivityNewIdeaBinding

private const val TAG = "New"

const val EXTRA_NEW_IDEA = "com.bignerdranch.android.appideas.new_idea"

class NewIdea : AppCompatActivity() {
    private lateinit var textInput: EditText
    private lateinit var binding: ActivityNewIdeaBinding
    private val ideasViewModel: IdeasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewIdeaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ideaSave.setOnClickListener {
            textInput = findViewById(R.id.ideaInput)
            val idea = textInput.text.toString()
//            val intent = ViewIdeas.newIntent(this@NewIdea, idea)
//            startActivity(intent)
            Log.d(TAG, idea)
            setNewIdeaResult(idea)
            finish()
        }

    }

    private fun setNewIdeaResult(newIdea: String) {
        val data = Intent().apply {
            putExtra(EXTRA_NEW_IDEA, newIdea)
        }
        setResult(Activity.RESULT_OK, data)
    }
}