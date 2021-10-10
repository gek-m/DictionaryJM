package com.example.dictionaryjm.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.dictionaryjm.R
import com.example.dictionaryjm.databinding.ActivityMainBinding
import com.example.dictionaryjm.presentation.viewmodels.MainActivityViewModel
import com.example.domainModule.OnlineLiveData
import com.example.historyscreen.presentation.HistoryScreen
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private var isNetworkAvailable: Boolean = true

    private val scope = getKoin().createScope<MainActivity>()

    private val mainActivityViewModel: MainActivityViewModel by scope.inject()

    private val router: Router by inject()
    private val navigatorHolder: NavigatorHolder by inject()
    private val appNavigator = AppNavigator(this, android.R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(appNavigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeToNetworkChange()

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

    private fun subscribeToNetworkChange() {
        OnlineLiveData(this).observe(
            this@MainActivity,
            Observer<Boolean> {
                isNetworkAvailable = it
                if (!isNetworkAvailable) {
                    Toast.makeText(
                        this@MainActivity,
                        R.string.dialog_message_device_is_offline,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }
}