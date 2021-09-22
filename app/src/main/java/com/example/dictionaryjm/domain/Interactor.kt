package com.example.dictionaryjm.domain

import com.example.dictionaryjm.domain.translate.Translate

class Interactor() {

    fun getData(translate: Translate) =
        translate.let { translateResponse ->
            translateResponse.def[0].let { definition ->
                definition.tr[0].text
            }
        }
}