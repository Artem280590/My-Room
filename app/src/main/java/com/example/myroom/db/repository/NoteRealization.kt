package com.example.myroom.db.repository

import androidx.lifecycle.LiveData
import com.example.myroom.db.dao.NoteDao
import com.example.myroom.model.NoteModel

class NoteRealization(private val noteDao: NoteDao): NoteRepository {

    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel) {
        noteDao.insert(noteModel)
    }

    override suspend fun deleteNote(noteModel: NoteModel) {
        noteDao.delete(noteModel)
    }


}