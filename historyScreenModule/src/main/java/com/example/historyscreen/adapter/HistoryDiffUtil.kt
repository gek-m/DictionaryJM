package com.example.historyscreen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.storage.entity.TranslateStorage

object HistoryDiffUtil : DiffUtil.ItemCallback<com.example.storage.entity.TranslateStorage>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: com.example.storage.entity.TranslateStorage, newItem: com.example.storage.entity.TranslateStorage): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: com.example.storage.entity.TranslateStorage, newItem: com.example.storage.entity.TranslateStorage): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: com.example.storage.entity.TranslateStorage, newItem: com.example.storage.entity.TranslateStorage) = payload
}