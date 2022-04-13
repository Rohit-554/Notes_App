package com.example.notes_app

import android.widget.TextView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note database")
class Note(@ColumnInfo(name = "text") val word: String) {
    @PrimaryKey(autoGenerate = true) var id=0
}