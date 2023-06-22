package com.example.myroom.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myroom.REPOSITORY
import com.example.myroom.db.NoteDataBase
import com.example.myroom.db.repository.NoteRealization
import com.example.myroom.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {

    var context = application

    fun initDataBase(){
        val daoNote = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }
}