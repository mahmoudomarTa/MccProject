package com.example.finalproject

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory


class RunVideoActivity : AppCompatActivity() {
    var playerView: PlayerView? = null
    var mPlayer: SimpleExoPlayer? = null
    private var playWhenReady = true
    private var currentWindow = 0
    private var playPackPosition: Long = 0
    var url: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_run_video)

    }

    fun initVideo(url: String?) {
        playerView = findViewById(R.id.video_view)
        mPlayer = ExoPlayerFactory.newSimpleInstance(applicationContext)
        playerView!!.player = mPlayer
        val uri = Uri.parse(url)
        val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(this, "exoplayer.codelab")
        val mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
        mPlayer!!.setPlayWhenReady(playWhenReady)
        mPlayer!!.seekTo(currentWindow, playPackPosition)
        mPlayer!!.prepare(mediaSource, false, false)
    }

    fun releaseVideo() {
        if (mPlayer != null) {
            playWhenReady = mPlayer!!.playWhenReady
            playPackPosition = mPlayer!!.currentPosition
            currentWindow = mPlayer!!.currentWindowIndex
            mPlayer!!.release()
            mPlayer = null
        }
    }

    override fun onStart() {
        super.onStart()
        val i = intent
        url = i.getStringExtra("uri")
        initVideo(url)
    }

    override fun onResume() {
        super.onResume()
        val i = intent
        url = i.getStringExtra("uri")
        if (mPlayer != null) {
            initVideo(url)
        }
    }

    override fun onPause() {
        super.onPause()
        releaseVideo()
    }

    override fun onStop() {
        super.onStop()
        releaseVideo()
    }
}


