package com.example.dictionaryjm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dictionaryjm.App
import com.example.dictionaryjm.databinding.ActivityMainBinding
import com.example.dictionaryjm.presenter.DictionaryPresenter

class MainActivity : AppCompatActivity(), DictionaryView {

    private lateinit var presenter: DictionaryPresenter
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        presenter = App.instance.dictionaryPresenter
        presenter.attachPresenter(this)

        viewBinding.button.setOnClickListener {
            presenter.getTranslation(viewBinding.textField.text.toString())
        }
    }

    override fun setTranslation(translate: String) {
        viewBinding.textView.text = translate
    }
}