package com.example.dictionaryjm.domain.translate

import com.google.gson.annotations.SerializedName

data class TrResponse(

    @SerializedName("text") val text: String,

    @SerializedName("fr") val fr: String
)
