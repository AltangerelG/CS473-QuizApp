package com.altangerel.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_quiz.*
import java.text.SimpleDateFormat
import java.util.*

class Quiz : AppCompatActivity() {
    private val rightAnswers = hashMapOf<String, Int>()
    private val chosen = hashSetOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        supportActionBar?.title = "Quiz application"

        rightAnswers[getString(R.string.ans2)] = 50
        rightAnswers[getString(R.string.q2ans1)] = 25
        rightAnswers[getString(R.string.q2ans2)] = 25
        rightAnswers[getString(R.string.q2ans3)] = -25

        radio.setOnCheckedChangeListener { group, checkedId ->
            val clicked = group.findViewById(checkedId) as RadioButton
            if (clicked.isChecked) {
                if(clicked.text.toString() == getString(R.string.ans2)) {
                    chosen.add(clicked.text.toString())
                } else {
                    chosen.remove(getString(R.string.ans2))
                }
            }
        }

        checkBox1.setOnCheckedChangeListener { view, isChecked ->
            toggleAnswer(isChecked, R.string.q2ans1)
        }

        checkBox2.setOnCheckedChangeListener { view, isChecked ->
            toggleAnswer(isChecked, R.string.q2ans2)
        }

        checkBox3.setOnCheckedChangeListener { view, isChecked ->
            toggleAnswer(isChecked, R.string.q2ans3)
        }

        btn_submit.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("“Congratulations!")
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())
            builder.setMessage("""
                Submission date: $currentDate
                Your achieved: ${calcPoint()}
            """.trimIndent())
            builder.setPositiveButton("Close"){dialogInterface, which ->
                dialogInterface.dismiss()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        btn_reset.setOnClickListener {
            var checkedButton = findViewById<RadioButton>(radio.checkedRadioButtonId);
            if (checkedButton.isChecked) checkedButton.isChecked = false
            checkBox1.isChecked = false
            checkBox2.isChecked = false
            checkBox3.isChecked = false
            chosen.clear()
        }
    }

    private fun toggleAnswer(isChecked: Boolean, ans: Int) {
        if (isChecked) {
            chosen.add(getString(ans))
        } else {
            chosen.remove(getString(ans))
        }
    }

    private fun calcPoint():Int {
        var points = 0;
        for (item in chosen) {
            if (rightAnswers.containsKey(item)) {
                points += rightAnswers[item]!!
            }
        }
        return points;
    }
}