package ru.zuma.mixhack_mobile

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ArrayAdapter
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    val professions = arrayOf("Программист", "Бухгалтер", "Ген. директор")
    val questions = arrayOf(
            QuestionModel("Вам нравится наше приложение?"),
            QuestionModel("Вы довольны своей работой?"),
            QuestionModel("Сколько вы зарабатываете?")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Top menu
        // -----------------------------------------------------------
        // Toolbar
        setSupportActionBar(tbMainTop)
        // -----------------------------------------------------------


        // создаем адаптер
        val adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, professions)

        // присваиваем адаптер списку
        lvProfessions.setAdapter(adapter)

        lvProfessions.setOnItemClickListener { _, _, pos, _ ->
            Toast.makeText(this@MainActivity, professions[pos], Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, QuestionsActivity::class.java)
            intent.putExtra(getString(R.string.QUESTIONS), questions);
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_top_toolbar_items, menu)
        return true
    }
}
