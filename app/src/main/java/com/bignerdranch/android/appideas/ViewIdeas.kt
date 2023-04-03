package com.bignerdranch.android.appideas

//import Ideas
import IdeasViewModel
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.bignerdranch.android.appideas.databinding.ActivityViewIdeasBinding

private const val TAG = "ViewIdeas"

class ViewIdeas : AppCompatActivity() {

    private lateinit var binding: ActivityViewIdeasBinding
    private var newIdea = "holding"
//    private val ideasViewModel: IdeasViewModel by viewModels()

    private val newIdeaLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        // Handle the result
        if (result.resultCode == Activity.RESULT_OK) {
            val newIdea = result.data?.getStringExtra(EXTRA_NEW_IDEA) ?: ""
            if (newIdea.isNotEmpty()) {
                ideasBank.add(Ideas(newIdea))
                Toast.makeText(
                    this,
                    R.string.new_idea_toast,
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(
                    this,
                    R.string.empty_toast,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private var ideasBank = mutableListOf(
//        Ideas("idea 1"),
        Ideas("Ex: Social Media Network to share photos")
    )
//    private var ideasBank = listOf(
//        Ideas(newIdea)
//    );
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")

        binding = ActivityViewIdeasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ideaTextView.text = ideasBank[currentIndex].idea

        binding.nextButton.setOnClickListener {
//            ideasViewModel.moveToNext()
            currentIndex = (currentIndex + 1) % ideasBank.size
            val ideaText = ideasBank[currentIndex].idea
            binding.ideaTextView.text = ideaText

        }
        binding.newButton.setOnClickListener {
            val intent = Intent(this@ViewIdeas, NewIdea::class.java)
//            startActivity(intent)
            newIdeaLauncher.launch(intent)
        }
    }

}