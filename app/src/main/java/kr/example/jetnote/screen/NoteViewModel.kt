package kr.example.jetnote.screen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

import kr.example.jetnote.model.Note
import kr.example.jetnote.repository.NoteRepository
import javax.inject.Inject


@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository): ViewModel() {
    // private var noteList = mutableStateListOf<Note>()
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
       // noteList.addAll(NoteDataSource().getNoteData())
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect { listofNotes ->
                    if (listofNotes.isNullOrEmpty()) {

                    } else {
                        _noteList.value = listofNotes
                    }
                }
        }
    }

     fun addNote(note: Note) {
       // noteList.add(note)
        viewModelScope.launch {  repository.addNote(note) }

    }

     fun update(note: Note) {
        viewModelScope.launch {  repository.updateNote(note) }
    }



     fun removeNote(note: Note) {
        // noteList.remove(note)
        viewModelScope.launch { repository.deleteNote(note) }
    }



//    fun getNoteList(): List<Note> {
//        return noteList
//    }
}