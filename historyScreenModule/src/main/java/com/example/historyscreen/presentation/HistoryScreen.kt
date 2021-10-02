package com.example.historyscreen.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object HistoryScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        HistoryFragment.newInstance()
}