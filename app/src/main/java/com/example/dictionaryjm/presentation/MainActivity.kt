package com.example.dictionaryjm.presentation

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.dictionaryjm.databinding.ActivityMainBinding
import com.example.dictionaryjm.presentation.abs.AbsActivity
import com.example.dictionaryjm.presentation.viewmodel.MainActivityViewModel

class MainActivity : AbsActivity() {

    /*@Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory*/

    private val viewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewModel.liveDataTranslate.observe(this) {
            viewBinding.textView.text = it
        }

        viewBinding.button.setOnClickListener {
            viewModel.getData(viewBinding.textField.text.toString())
        }
    }
}