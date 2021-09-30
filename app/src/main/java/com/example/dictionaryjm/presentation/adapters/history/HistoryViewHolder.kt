package com.example.dictionaryjm.presentation.adapters.history

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dictionaryjm.databinding.ViewWordHistoryBinding
import com.example.dictionaryjm.domain.storage.entity.TranslateStorage

class HistoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val viewBindingHistory: ViewWordHistoryBinding by viewBinding()

    fun bind(translateStorage: TranslateStorage) {
        with (viewBindingHistory) {
            originalWord.text = translateStorage.sourceWord
            translatedWord.text = translateStorage.translateWord
        }
    }
}