package ru.zuma.mixhack_mobile

import android.support.v7.app.AppCompatActivity
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {

    private lateinit var questions: Array<QuestionModel>
    private lateinit var adapter: QuestionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        questions = intent.getSerializableExtra(getString(R.string.QUESTIONS)) as Array<QuestionModel>
        if (questions.isEmpty()) Log.w(javaClass.simpleName, "questions array is empty")

        adapter = QuestionAdapter(questions, this)

        btNext.setOnClickListener {
            adapter.next()
        }

        btPrev.setOnClickListener {
            adapter.prev()
        }
    }
}

/**
 * Assert questions isn't empty
 */
class QuestionAdapter(val questions: Array<QuestionModel>, activity: Activity) {
    var point = 0
    var etAnswer: EditText
    var tvQuestion: TextView

    init {
        if (questions.isEmpty()) throw IllegalArgumentException("questions must be non empty")

        etAnswer = activity.findViewById(R.id.etAnswer)!!
        tvQuestion = activity.findViewById(R.id.tvQuestion)

        setQuestion(questions[point], point)
    }

    fun next(): Int {
        val lastPoint = point
        if (point + 1 < questions.size) point++ else point = 0
        update(questions, lastPoint, point)
        return point
    }
    fun prev(): Int {
        val lastPoint = point
        if (point > 0) point-- else point = questions.size - 1
        update(questions, lastPoint, point)
        return point
    }

    fun update(questions: Array<QuestionModel>, prev: Int, next: Int) {
        val prevQuest = questions[prev]
        val nextQuest = questions[next]

        when (prevQuest.type) {
            QuestionModel.Type.SINGLE_LINE -> prevQuest.answer = etAnswer.text.toString()
            QuestionModel.Type.MULTI_LINE -> TODO()
            QuestionModel.Type.SINGLE_CHOICE -> TODO()
            QuestionModel.Type.MULTI_CHOICE -> TODO()
        }

        setQuestion(nextQuest, next)
    }

    private fun setQuestion(question: QuestionModel, num: Int) {
        tvQuestion.text = "${num+1}. ${question.question}"

        when (question.type) {
            QuestionModel.Type.SINGLE_LINE -> etAnswer.setText(question.answer)
            QuestionModel.Type.MULTI_LINE -> TODO()
            QuestionModel.Type.SINGLE_CHOICE -> TODO()
            QuestionModel.Type.MULTI_CHOICE -> TODO()
        }
    }
}
