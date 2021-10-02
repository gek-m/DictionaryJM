package com.example.dictionaryjm.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dictionaryjm.databinding.ActivityMainBinding
import com.example.dictionaryjm.presentation.viewmodels.MainActivityViewModel
import com.example.historyscreen.presentation.HistoryScreen
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel: MainActivityViewModel by inject()

    private val router : Router by inject()
    private val navigatorHolder : NavigatorHolder by inject()
    private val appNavigator = AppNavigator(this, android.R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(appNavigator)
    }

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

        viewBinding.buttonHistory.setOnClickListener {
            router.navigateTo(HistoryScreen)
        }
    }
}
