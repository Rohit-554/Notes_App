package com.example.notes_app

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM `Note database` ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<Note>>
}