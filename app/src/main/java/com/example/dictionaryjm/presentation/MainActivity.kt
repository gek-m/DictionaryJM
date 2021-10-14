package com.example.dictionaryjm.presentation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
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
        setDefaultSplashScreen()

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

    private fun setDefaultSplashScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            setSplashScreenAnimation()
        }
    }

    @RequiresApi(31)
    private fun setSplashScreenAnimation() {
        val splashScreen = installSplashScreen()

        splashScreen.setOnExitAnimationListener { splashScreenViewProvider ->
            val animator = ObjectAnimator.ofFloat(
                splashScreenViewProvider.view,
                View.TRANSLATION_X,
                0F,
                splashScreenViewProvider.view.width.toFloat(),
            )
            animator.apply {
                duration = 1200
                doOnEnd {
                    splashScreenViewProvider.remove()
                }
            }.also { objectAnimator ->
                objectAnimator.start()
            }
        }
    }

}