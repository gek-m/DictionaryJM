package com.example.historyscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.historyscreen.R.layout.view_word_history
import com.example.storage.entity.TranslateStorage

class HistoryAdapter : ListAdapter<com.example.storage.entity.TranslateStorage, HistoryViewHolder>(HistoryDiffUtil) {

    private val data = mutableListOf<com.example.storage.entity.TranslateStorage>()

    fun setData(dataToSet: List<com.example.storage.entity.TranslateStorage>) {
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