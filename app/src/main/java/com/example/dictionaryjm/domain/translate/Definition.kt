package com.example.dictionaryjm.domain.translate

import com.google.gson.annotations.SerializedName

data class Definition(

    @SerializedName("text") val text: String,

    @SerializedName("tr") val tr: List<TrResponse>
)
