package com.bcp.basicsuperapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bcp.basicsuperapp.databinding.ActivityMainBinding
import com.bcp.sdk.product.peoplecompose.presentation.ui.activities.PeopleActivity
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setViewTitle()
        setOnClickListeners()
    }

    private fun setViewTitle() {
        binding.tvTitle.text = getString(R.string.title_people)
    }

    private fun setOnClickListeners() {
        binding.mbPeople.setOnClickListener {
            val intent = Intent(this, PeopleActivity::class.java)
            startActivity(intent)
        }
    }
}