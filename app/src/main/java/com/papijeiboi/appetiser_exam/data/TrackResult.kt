package com.papijeiboi.appetiser_exam.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "track")
data class TrackResult(
    @PrimaryKey
    @SerializedName("collectionId")
    val collectionId: Int,
    @SerializedName("trackName")
    val trackName: String?,
    @SerializedName("primaryGenreName")
    val primaryGenreName: String?,
    @SerializedName("trackPrice")
    val trackPrice: Double?,
    @SerializedName("longDescription")
    val longDescription: String?,
    @SerializedName("artworkUrl100")
    val artworkUrl100: String?
)