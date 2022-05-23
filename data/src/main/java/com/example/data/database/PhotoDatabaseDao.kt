package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.models.PhotoRoomModel
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDatabaseDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPhoto(photo: PhotoRoomModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllPhotos(photos: List<PhotoRoomModel>)

    @Query("SELECT * from photo_table")
    fun getAllPhotos(): Flow<List<PhotoRoomModel>>

    @Query("DELETE FROM photo_table")
    fun clearPhotos()
}