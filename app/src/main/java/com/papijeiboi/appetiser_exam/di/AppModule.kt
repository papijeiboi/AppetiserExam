package com.papijeiboi.appetiser_exam.di

import android.app.Application
import androidx.room.Room
import com.papijeiboi.appetiser_exam.api.TrackApi
import com.papijeiboi.appetiser_exam.data.TrackDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Contains dependency for the whole app
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(TrackApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideTrackApi(retrofit: Retrofit): TrackApi =
        retrofit.create(TrackApi::class.java)


    @Provides
    @Singleton
    fun provideDatabase(app: Application): TrackDatabase =
        Room.databaseBuilder(app, TrackDatabase::class.java, "track_database")
            .build()
}

