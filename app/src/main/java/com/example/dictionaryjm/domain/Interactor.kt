package com.example.dictionaryjm.domain

class Interactor() {

    fun getData(translate: com.example.domainModule.Translate) =
        translate.let { translateResponse ->
            translateResponse.def[0].let { definition ->
                definition.tr[0].text
            }
        }
}