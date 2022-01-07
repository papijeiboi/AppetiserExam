package com.papijeiboi.appetiser_exam.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.papijeiboi.appetiser_exam.data.TrackResult
import com.papijeiboi.appetiser_exam.databinding.ItemTrackBinding

class TrackAdapter(private val onClickListener: OnClickListener)  : ListAdapter<TrackResult, TrackAdapter.TrackViewHolder>(TrackComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val binding = ItemTrackBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TrackViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
            holder.itemView.setOnClickListener {
                onClickListener.onClick(currentItem)
            }
        }
    }

    class TrackViewHolder(private val binding: ItemTrackBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(track: TrackResult) {
            binding.apply {
                Glide.with(itemView)
                    .load(track.artworkUrl100)
                    .circleCrop()
                    .into(ivTrackArtwork)

                tvTrackName.text = track.trackName ?: "Title not available"
                tvTrackGenre.text = track.primaryGenreName ?: "Genre not available"
                tvTrackPrice.text = "$${track.trackPrice ?: "Price not available"}"
            }
        }
    }


    // To calculate differences between old data and new data
    class TrackComparator : DiffUtil.ItemCallback<TrackResult>() {
        override fun areItemsTheSame(oldItem: TrackResult, newItem: TrackResult) =
            oldItem.trackName == newItem.trackName

        override fun areContentsTheSame(oldItem: TrackResult, newItem: TrackResult) =
            oldItem == newItem
    }

    class OnClickListener(val clickListener: (track: TrackResult) -> Unit) {
        fun onClick(track: TrackResult) = clickListener(track)
    }
}