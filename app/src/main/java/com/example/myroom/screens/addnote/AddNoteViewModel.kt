package com.example.myroom.screens.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myroom.REPOSITORY
import com.example.myroom.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel: ViewModel() {

    fun insert(noteModel: NoteModel) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.insertNote(noteModel)
        }
}