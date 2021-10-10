package com.example.historyscreen.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.historyscreen.databinding.ViewWordHistoryBinding

class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewBindingHistory: ViewWordHistoryBinding by viewBinding()

    fun bind(translateStorage: com.example.storage.entity.TranslateStorage) {
        with(viewBindingHistory) {
            originalWord.text = translateStorage.sourceWord
            translatedWord.text = translateStorage.translateWord
        }
    }
}