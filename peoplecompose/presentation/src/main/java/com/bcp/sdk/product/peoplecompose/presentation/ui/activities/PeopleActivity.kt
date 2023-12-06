package com.bcp.sdk.product.peoplecompose.presentation.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bcp.sdk.product.peoplecompose.presentation.databinding.ActivityPeopleBinding

class PeopleActivity : AppCompatActivity() {

    private val binding: ActivityPeopleBinding by lazy {
        ActivityPeopleBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}