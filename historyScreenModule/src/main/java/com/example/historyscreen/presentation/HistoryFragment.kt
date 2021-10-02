package com.example.historyscreen.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.historyscreen.R.layout.fragment_history
import com.example.historyscreen.adapter.HistoryAdapter
import com.example.historyscreen.databinding.FragmentHistoryBinding
import com.example.historyscreen.presentation.viewmodels.HistoryFragmentViewModel
import org.koin.android.ext.android.inject

class HistoryFragment : Fragment(fragment_history) {

    private val historyFragmentViewModel: HistoryFragmentViewModel by inject()

    companion object {
        fun newInstance(): Fragment = HistoryFragment()
    }

    private val viewBinding: FragmentHistoryBinding by viewBinding()
    private val adapter = HistoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            historyFragmentViewModel.getHistoryData()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.historyRecords.adapter = adapter

        historyFragmentViewModel.liveDataStorage.observe(viewLifecycleOwner) {
            adapter.apply {
                setData(it)
                notifyDataSetChanged()
            }
        }
    }
}