package com.example.musicplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var playButton: Button
    private lateinit var pauseButton: Button
    private lateinit var imageCover: ImageView
    private lateinit var songTitle: TextView

    private var mediaPlayer: MediaPlayer? = null
    private var currentSongIndex = 0

    // Lista de músicas e capas
    private val songResIds = arrayOf(R.raw.song1, R.raw.song2, R.raw.song3)
    private val coverResIds = arrayOf(R.drawable.cover1, R.drawable.cover2, R.drawable.cover3)
    private val titles = arrayOf("Song One", "Song Two", "Song Three")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playButton = findViewById(R.id.playPauseButton)
        pauseButton = findViewById(R.id.prevButton)
        imageCover = findViewById(R.id.songImage)
        songTitle = findViewById(R.id.Jesus)

        playButton.setOnClickListener {
            playSong(currentSongIndex)
        }

        pauseButton.setOnClickListener {
            mediaPlayer?.pause()
        }
    }

    private fun playSong(index: Int) {
        mediaPlayer?.release()  // Liberta música anterior

        mediaPlayer = MediaPlayer.create(this, songResIds[index])
        mediaPlayer?.start()

        // Atualizar imagem e título
        imageCover.setImageResource(coverResIds[index])
        songTitle.text = "Now Playing: ${titles[index]}"

        // Quando acabar, toca a próxima música
        mediaPlayer?.setOnCompletionListener {
            currentSongIndex = (currentSongIndex + 1) % songResIds.size
            playSong(currentSongIndex)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}
