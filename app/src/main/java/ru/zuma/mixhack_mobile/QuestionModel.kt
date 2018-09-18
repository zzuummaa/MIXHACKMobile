package ru.zuma.mixhack_mobile

import java.io.Serializable

class QuestionModel(val question: String, val type: Type = Type.SINGLE_LINE): Serializable {
    var isAnswered = false
    var answer = ""

    enum class Type {
        SINGLE_CHOICE, MULTI_CHOICE, SINGLE_LINE, MULTI_LINE
    }
}