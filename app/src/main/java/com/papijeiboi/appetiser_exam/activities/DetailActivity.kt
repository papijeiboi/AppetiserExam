package com.papijeiboi.appetiser_exam.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.papijeiboi.appetiser_exam.data.TrackResult
import com.papijeiboi.appetiser_exam.databinding.ActivityDetailBinding

const val EXTRA_TRACK_INFORMATION = "EXTRA_TRACK_INFORMATION"

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listType = object : TypeToken<TrackResult>() {}.type
        val trackInfo: TrackResult =
            Gson().fromJson<TrackResult>(
                intent.getStringExtra(EXTRA_TRACK_INFORMATION),
                listType
            )


        binding.apply {
            setSupportActionBar(toolbarLayout)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            trackInfo.trackName.let {
                collapsingToolbarLayout.title = it ?: "Track name not avaiable"
            }

            Glide.with(ivTrackPicture)
                .load(trackInfo.artworkUrl100)
                .into(ivTrackPicture)

            tvDescription.text = trackInfo.longDescription ?: "Description not available"
            tvGenre.text = trackInfo.primaryGenreName ?: "Genre not available"
            tvPrice.text = "${trackInfo.trackPrice ?: "Price not available"}"
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}