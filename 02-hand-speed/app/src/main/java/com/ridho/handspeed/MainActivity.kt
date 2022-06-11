package com.ridho.handspeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var gameScoreText: TextView
    private lateinit var timeLeftText: TextView
    private lateinit var tapMeImage:  ImageView
    private var score = 0

    private var gameStarted = false
    private lateinit var countDownTime: CountDownTimer
    // 60000 = 60 detik, yang durasi yang kita gunakan saat di game
    private var initialCountDown: Long = 60000
    private var countDownInterval: Long = 1000
    private var timeLeft = 60

    private val TAG = MainActivity::class.java.simpleName

    companion object{
        private const val SCORE_KEY = "SCORE_KEY"
        private const val TIME_LEFT_KEY = "TIME_LEFT_KEY"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SCORE_KEY, score)
        outState.putInt(TIME_LEFT_KEY, timeLeft)
        countDownTime.cancel()
        Log.d(TAG,"onSaveInstanceState: Saving score : $score & Time left : $timeLeft")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

//        melinkkan antara variabel dan layout id di file main activity.xml
        gameScoreText = findViewById(R.id.score_game)
        timeLeftText = findViewById(R.id.time_game)
        tapMeImage = findViewById(R.id.tab_me_image)

        // animation
        // ketika klik image, akan menjalankan method incrementScore
        tapMeImage.setOnClickListener { v->
            val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)
            v.startAnimation(bounceAnimation)
            incrementScore()
        }
        Log.d(TAG, "onCreat called. Score is : $score")

        if(savedInstanceState != null) {
            score = savedInstanceState.getInt(SCORE_KEY)
            timeLeft = savedInstanceState.getInt(TIME_LEFT_KEY)
            restoreGame()
        } else {
            resetGame()
        }


    }

    private fun restoreGame() {
        val restoredScore = getString(R.string.your_score, score)
        gameScoreText.text = restoredScore

        val restoredTime = getString(R.string.time_left, timeLeft)
        timeLeftText.text = restoredTime

        countDownTime = object :CountDownTimer((timeLeft * 1000).toLong(), countDownInterval) {
            override fun onTick(millishUntilFinished: Long) {
                timeLeft = millishUntilFinished.toInt() / 1000
                val timeLeftString = getString(R.string.time_left, timeLeft)
                timeLeftText.text = timeLeftString
            }

            override fun onFinish() {
                endGame()
            }
        }
        countDownTime.start()
        gameStarted = true
    }

    private fun incrementScore() {
        score++
        val newScore = getString(R.string.your_score, score)
        // val newScore = "Score : $score"
        // setelah diklik masukan score baru ke dalam text
        gameScoreText.text = newScore

        if (!gameStarted) {
            startGame()
        }
    }

    private fun resetGame() {
        score = 0

        val initialScore = getString(R.string.your_score, score)
        gameScoreText.text = initialScore

        val initialTimeLeft = getString(R.string.time_left, 60)
        timeLeftText.text = initialTimeLeft

        countDownTime = object : CountDownTimer(initialCountDown, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = millisUntilFinished.toInt() / 1000
                val timeLeftString = getString(R.string.time_left, timeLeft)
                timeLeftText.text = timeLeftString
            }

            // ketika gamenya telah berakhir
            override fun onFinish() {
                endGame()
            }
        }
        gameStarted = false
    }

    private fun startGame() {
        countDownTime.start()
        gameStarted = true
    }

    private fun endGame() {
        // Toast = menampilkan pesan
        Toast.makeText(this, getString(R.string.game_over_message, score), Toast.LENGTH_LONG).show()
        resetGame()
    }
}