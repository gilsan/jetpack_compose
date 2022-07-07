package kr.example.jetnote.screens.note

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

}