package com.example.notes_app

import androidx.room.*

@Dao
interface DAO {
    @Query("SELECT * FROM `Note database` ORDER BY id ASC")
    fun getAlphabetizedWords(): List<Note>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Note)

    @Delete
    fun delete(note: Note)
}