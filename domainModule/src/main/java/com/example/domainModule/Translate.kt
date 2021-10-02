package com.example.domainModule

import com.google.gson.annotations.SerializedName

data class Translate(

    @SerializedName("def") val def: List<Definition>
)
