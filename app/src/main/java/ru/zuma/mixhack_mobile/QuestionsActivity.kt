package ru.zuma.mixhack_mobile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        btNext.setOnClickListener {
            // TODO next QuestionModel
        }

        btPrev.setOnClickListener {
            // TODO prev QuestionModel
        }
    }
}
