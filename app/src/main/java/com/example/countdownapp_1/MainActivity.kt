package com.example.countdownapp_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    private lateinit var timer1: Chronometer
    private var running = false
    private var offset: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timer1 = findViewById<Chronometer>(R.id.countdown1)


        val addOneSec = findViewById<Button>(R.id.fwd1)

        addOneSec.setOnClickListener {

            setTimer(1000)

        }

        val addFiveSec = findViewById<Button>(R.id.fwd5)

        addFiveSec.setOnClickListener {

            setTimer(5000)

        }

        val addTenSec = findViewById<Button>(R.id.fwd10)

        addTenSec.setOnClickListener {

            setTimer(10000)

        }

        val startButton = findViewById<Button>(R.id.startbutton)

        startButton.setOnClickListener {

            if(!running) {
                timer1.start()
                running = true

            }

        }

        val pauseButton = findViewById<Button>(R.id.pausebutton)

        pauseButton.setOnClickListener {

            if(running) {
                saveOffset()
                timer1.stop()
                running = false
            }
        }

        val resetButton = findViewById<Button>(R.id.resetbutton)

        resetButton.setOnClickListener {

            resetTimer()
            running = false
        }

    }




    private fun setTimer(value: Long) {
        offset = offset + value
        timer1.base = SystemClock.elapsedRealtime() + offset
    }

    private fun resetTimer() {
        timer1.base = SystemClock.elapsedRealtime()
        offset = 0
    }

    private fun saveOffset() {

        offset = timer1.base - SystemClock.elapsedRealtime()

    }


}