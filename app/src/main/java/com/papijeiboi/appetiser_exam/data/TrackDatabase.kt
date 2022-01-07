package com.papijeiboi.appetiser_exam.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TrackResult::class], version = 1)
abstract class TrackDatabase: RoomDatabase() {

    abstract fun trackDao(): TrackDao
}