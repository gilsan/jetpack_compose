package kr.example.jetnote.screens.note

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import kr.example.jetnote.components.TopBar
import kr.example.jetnote.screen.NoteScreen
import kr.example.jetnote.screen.NoteViewModel
import kr.example.jetnote.screens.note.data.getNoteList

@Composable
fun Note2(navController: NavController, noteViewModel: MemoViewModel) {
    Scaffold(
        topBar = {
            TopBar(title = "노트", icon = Icons.Default.ArrowBack, navController = navController )
        },
    ) {
        NotesApp(noteViewModel)
    }

}

@Composable
fun NotesApp(noteViewModel: MemoViewModel) {
    val noteList = noteViewModel.memoList.collectAsState().value
//    val noteList = noteViewModel.noteList.collectAsState().value
//    MemoScreen(notes = noteList,
//        onAddNote = {
//            noteViewModel.addNote(it)
//        },
//        onRemoveNote = {
//            noteViewModel.removeNote(it)
//        })


   // val notes = getNoteList()
    MemoScreen(notes = noteList,
        onAddNote = {
            noteViewModel.addNote(it)
        },
        onRemoveNote = {
            noteViewModel.removeNote(it)
        }
    )


}