package com.papijeiboi.appetiser_exam.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.papijeiboi.appetiser_exam.adapter.TrackAdapter
import com.papijeiboi.appetiser_exam.databinding.ActivityMainBinding
import com.papijeiboi.appetiser_exam.util.Resource
import com.papijeiboi.appetiser_exam.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val trackAdapter = TrackAdapter(TrackAdapter.OnClickListener { track ->
            val mGson = GsonBuilder()
                .setLenient()
                .create()
            mGson.toJson(track)

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(EXTRA_TRACK_INFORMATION, mGson.toJson(track))
            startActivity(intent)
        })

        binding.apply {
            rvTrack.apply {
                adapter = trackAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }

            viewModel.tracks.observe(this@MainActivity) { result ->
                trackAdapter.submitList(result.data)
                pbTrack.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                tvError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                tvError.text = result.error?.localizedMessage
            }
        }
    }
}