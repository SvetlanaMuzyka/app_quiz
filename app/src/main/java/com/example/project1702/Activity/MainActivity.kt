package com.example.project1702.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.project1702.Domain.QuestionModel
import com.example.project1702.R
import com.example.project1702.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window = this@MainActivity.window
        window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.on_prim_cont)

        binding.apply {
            bottomMenu.setItemSelected(R.id.home)
            bottomMenu.setOnItemSelectedListener {
                if (it == R.id.Board) {
                    startActivity(Intent(this@MainActivity, LeaderActivity::class.java))
                }
            }

            singleBtn.setOnClickListener {
                val intent=Intent(this@MainActivity,QuestionActivity::class.java)
                intent.putParcelableArrayListExtra("list",ArrayList(questionList()))
                startActivity(intent)
            }
        }
    }



    private fun questionList(): MutableList<QuestionModel> {
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "What is the name of the oldest active national constitution in the world?",
                "The Constitution of South Africa",
                "The Constitution of Japan",
                "The French Constitution",
                "The United States Constitution",
                "d",
                5,
                "qu_1",
                null
            )
        )
        question.add(
            QuestionModel(
                2,
                "What is the process by which light is bent as it passes through a prism?",
                "Refraction",
                "Reflection",
                "Absorption",
                "Diffraction",
                "a",
                5,
                "qu_2",
                null
            )
        )
        question.add(
            QuestionModel(
                3,
                "Which of the following substances is used as an anti-cancer medication in the medical world?",
                "Cheese",
                " Lemon juice",
                "Cannabis",
                "Paspalum",
                "c",
                5,
                "qu_3",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Which moon in the Earth's solar system has an atmosphere?",
                "Luna (Moon)",
                "Phobos (Mars' moon)",
                "Venus' moon",
                "None of the above",
                "d",
                5,
                "qu_4",
                null
            )
        )
        question.add(
            QuestionModel(
                5,
                "Which of the following symbols represents the chemical element with the atomic number 6?",
                "O",
                "H",
                "C",
                "N",
                "c",
                5,
                "q_5",
                null
            )
        )
        question.add(
            QuestionModel(
                6,
                "Who is credited with inventing theater as we know it today?",
                "Shakespeare",
                "Arthur Miller",
                "Ashkouri",
                "Ancient Greeks",
                "d",
                5,
                "q_6",
                null
            )
        )


        question.add(
            QuestionModel(
                7,
                "Which ocean is the largest ocean in the world?",
                "Pacific Ocean",
                "Atlantic Ocean",
                "Indian Ocean",
                "Arctic Ocean",
                "a",
                5,
                "q_7",
                null
            )
        )
        question.add(
            QuestionModel(
                8,
                "Which religions are among the most practiced religions in the world?",
                "Islam, Christianity, Judaism",
                "Buddhism, Hinduism, Sikhism",
                "Zoroastrianism, Brahmanism, Yazdanism",
                "Taoism, Shintoism, Confucianism",
                "a",
                5,
                "q_8",
                null
            )
        )
        question.add(
            QuestionModel(
                9,
                "In which continent are the most independent countries located?",
                "Asia",
                "Europe",
                "Africa",
                "Americas",
                "c",
                5,
                "q_9",
                null
            )
        )
        question.add(
            QuestionModel(
                10,
                "Which ocean has the greatest average depth?",
                "Pacific Ocean",
                "Atlantic Ocean",
                "Indian Ocean",
                "Southern Ocean",
                "d",
                5,
                "q_10",
                null
            )
        )
        return question
    }
}