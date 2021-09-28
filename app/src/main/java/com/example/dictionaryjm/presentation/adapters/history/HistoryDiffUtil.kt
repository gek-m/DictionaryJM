package com.example.dictionaryjm.presentation.adapters.history

import androidx.recyclerview.widget.DiffUtil
import com.example.dictionaryjm.domain.storage.entity.TranslateStorage

object HistoryDiffUtil: DiffUtil.ItemCallback<TranslateStorage>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: TranslateStorage, newItem: TranslateStorage): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TranslateStorage, newItem: TranslateStorage): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: TranslateStorage, newItem: TranslateStorage) = payload
}