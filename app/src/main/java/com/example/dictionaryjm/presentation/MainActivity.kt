package com.example.dictionaryjm.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dictionaryjm.databinding.ActivityMainBinding
import com.example.dictionaryjm.presentation.viewmodel.MainActivityViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel: MainActivityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        mainActivityViewModel.liveDataTranslate.observe(this) {
            viewBinding.textView.text = it
        }

        viewBinding.button.setOnClickListener {
            mainActivityViewModel.getData(viewBinding.textField.text.toString())
        }
    }
}