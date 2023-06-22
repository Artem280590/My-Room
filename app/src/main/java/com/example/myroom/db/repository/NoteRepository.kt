package com.example.myroom.db.repository

import androidx.lifecycle.LiveData
import com.example.myroom.model.NoteModel

interface NoteRepository {

    val allNotes: LiveData<List<NoteModel>>

    suspend fun insertNote(noteModel: NoteModel)
    suspend fun deleteNote(noteModel: NoteModel)
}