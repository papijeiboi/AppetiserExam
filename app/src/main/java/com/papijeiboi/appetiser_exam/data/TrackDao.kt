package com.papijeiboi.appetiser_exam.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackDao {

    @Query("SELECT * FROM track")
    fun getAllTrack(): Flow<List<TrackResult>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrack(person: List<TrackResult>)

    @Query("DELETE FROM track")
    suspend fun deleteAllTrack()
}