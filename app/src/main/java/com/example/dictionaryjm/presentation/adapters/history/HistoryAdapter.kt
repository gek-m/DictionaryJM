package com.example.dictionaryjm.presentation.adapters.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.dictionaryjm.R.layout.view_word_history
import com.example.dictionaryjm.domain.storage.entity.TranslateStorage

class HistoryAdapter: ListAdapter<TranslateStorage, HistoryViewHolder>(HistoryDiffUtil) {

    private val data = mutableListOf<TranslateStorage>()

    fun setData(dataToSet: List<TranslateStorage>) {
        data.apply {
            clear()
            addAll(dataToSet)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder =
        HistoryViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(view_word_history, parent, false)
        )

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size
}