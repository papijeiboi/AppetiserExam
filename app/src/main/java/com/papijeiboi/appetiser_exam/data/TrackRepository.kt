package com.papijeiboi.appetiser_exam.data

import androidx.room.withTransaction
import com.papijeiboi.appetiser_exam.api.TrackApi
import com.papijeiboi.appetiser_exam.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class TrackRepository @Inject constructor(
    private val api: TrackApi,
    private val db: TrackDatabase
) {

    private val personDao = db.trackDao()

    fun getTrack() = networkBoundResource(
        query = {
            personDao.getAllTrack()
        },
        fetch = {
            delay(2000)
            api.getTrack()
        },
        savedFetchResult = { track ->
            db.withTransaction {
                personDao.deleteAllTrack()
                personDao.insertTrack(track.results)
            }

        }
    )
}