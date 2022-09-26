package com.example.pract5_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play = findViewById<FloatingActionButton>(R.id.playbutton)
        val stop = findViewById<FloatingActionButton>(R.id.stopbutton)
        var count = 0
        play.setOnClickListener {
            count++
            play()
            if(count%2!=0){
                play.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_pause_24))
            }
            else{
                play.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_play_arrow_24))
            }
        }
        stop.setOnClickListener {
            stop()
        }
    }

    fun play() {
        Intent(applicationContext, Myservise::class.java).putExtra(
            Myservise.Service1,
            Myservise.PlayPause
        ).apply {
            startService(this)
        }
    }

    fun stop() {
        Intent(applicationContext, Myservise::class.java).apply {
            stopService(this)
        }

    }

}
