package kr.example.jetnote.screens.note2


import android.provider.ContactsContract
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kr.example.jetnote.components.TopBar
import kr.example.jetnote.screens.note2.data.getNoteList
import kr.example.jetnote.screens.note2.model.Note



@Composable
fun Note(navController: NavController, noteViewModel: NoteViewModel) {

    Scaffold(
        topBar = {
            TopBar(title = "노트", icon = Icons.Default.ArrowBack, navController = navController )
        },
        ) {

            NoteModel(noteViewModel)

    }
}

@Composable
fun NoteModel(noteViewModel: NoteViewModel) {
    val notes = noteViewModel.noteList.collectAsState().value
    // val notes = getNoteList()

    NoteScreen( notes = notes,
        onAddNote = {
            noteViewModel.addNote(it)
        },
        onRemoveNote = {
            noteViewModel.removeNote(it)
        })
}

