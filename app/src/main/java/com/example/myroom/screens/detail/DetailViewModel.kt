package com.example.myroom.screens.detail

import android.os.Build
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myroom.REPOSITORY
import com.example.myroom.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.Serializable

class DetailViewModel: ViewModel() {

    fun delete(noteModel: NoteModel) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.deleteNote(noteModel)
        }



}