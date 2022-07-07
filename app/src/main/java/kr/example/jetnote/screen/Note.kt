package kr.example.jetnote.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController



@Composable
fun Note(navController: NavController,noteViewModel: NoteViewModel) {

            NotesApp(noteViewModel)
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel ) {

    val noteList = noteViewModel.noteList.collectAsState().value
    NoteScreen(notes = noteList,
        onAddNote = {
            noteViewModel.addNote(it)
        },
        onRemoveNote = {
            noteViewModel.removeNote(it)
        })


}