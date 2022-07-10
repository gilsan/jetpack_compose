package kr.example.jetnote.screens.note2


import android.provider.ContactsContract
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.example.jetnote.components.MyBotttomBar
import kr.example.jetnote.components.TopBar
import kr.example.jetnote.components.NoteScreen
import kr.example.jetnote.screens.note2.data.getNoteList
import kr.example.jetnote.screens.note2.model.Note



@Composable
fun Note(navController: NavController, noteViewModel: NoteViewModel) {
    val navControllerBottom = rememberNavController()
    Scaffold(
        topBar = {
            TopBar(title = "노트", icon = Icons.Default.ArrowBack, navController = navController )
        },
        bottomBar = {
            MyBotttomBar(navController = navControllerBottom)
        }
        ) {

            NoteModel(noteViewModel, navHostController = navControllerBottom)

    }
}

@Composable
fun NoteModel(
    noteViewModel: NoteViewModel,
    navHostController: NavHostController
    ) {
    val notes = noteViewModel.noteList.collectAsState().value
    // val notes = getNoteList()



        NavHost(
            navController = navHostController,
            startDestination =  NoteScreen.Home.route,
            modifier = Modifier.padding(3.dp)
             ) {
                composable(NoteScreen.Home.route) {
                    NoteScreen( notes = notes,
                        onAddNote = {
                            noteViewModel.addNote(it)
                        },
                        onRemoveNote = {
                            noteViewModel.removeNote(it)
                        })
                }

                composable(NoteScreen.Profile.route) {
                    Text(text="test....")
                // Counter()
                }
           }

}

