package kr.example.jetnote.screens.note

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kr.example.jetnote.screens.note.model.Memo
import kr.example.jetnote.screens.note.repository.Repository
import javax.inject.Inject


@HiltViewModel
class MemoViewModel @Inject constructor(private val repository: Repository ) : ViewModel() {

    private val _memoList = MutableStateFlow<List<Memo>>(emptyList())
    val memoList = _memoList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllMemo().distinctUntilChanged().collect {
                listOfMemo ->
                if (listOfMemo.isNullOrEmpty()) {

                } else {
                    _memoList.value = listOfMemo
                }
            }
        }

       // getOneNote()
    }

    fun addNote(note: Memo) {
        viewModelScope.launch {
            repository.addNote(memo = note)
        }
    }

    fun removeNote(note: Memo) {
        viewModelScope.launch {
            repository.deleteNote(memo = note)
        }
    }

    private fun getOneNote() {
        viewModelScope.launch {
            val result =  repository.getOneNote(uuid ="52fd6b9a-48c8-4791-9ea3-9f3d3cc4d621")
            Log.d("TAG", "[NOTE][52]>>>>>>>>> $result")
        }
    }

}