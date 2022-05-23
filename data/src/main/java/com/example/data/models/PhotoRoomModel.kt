package com.example.data.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "photo_table")
data class PhotoRoomModel(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    @ColumnInfo(name = "sol")
    val sol: Int,
    @ColumnInfo(name = "camera")
    val camera: String,
    @ColumnInfo(name = "img_src")
    val imgSrc: String,
    @ColumnInfo(name = "earth_date")
    val earthDate: String,
    @ColumnInfo(name = "String")
    val rover: String
) : Parcelable
