package kr.example.jetnote.screens.note

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.example.jetnote.components.NoteBotttomBar
import kr.example.jetnote.components.NoteScreen
import kr.example.jetnote.components.TopBar
import kr.example.jetnote.screens.note2.NoteScreen


@Composable
fun Note2(navController: NavController, noteViewModel: MemoViewModel) {
    val navControllerBottom = rememberNavController()
    Scaffold(
        topBar = {
            TopBar(title = "메모", icon = Icons.Default.ArrowBack, navController = navController )
        },
        bottomBar = {
            NoteBotttomBar(navController = navControllerBottom)
        }
    ) {
        NotesApp(noteViewModel, navHostController = navControllerBottom)
    }

}

@Composable
fun NotesApp(
    noteViewModel: MemoViewModel,
    navHostController: NavHostController
    ) {
    val noteList = noteViewModel.memoList.collectAsState().value

    NavHost(
        navController = navHostController,
        startDestination =  NoteScreen.Home.route,
        modifier = Modifier.padding(3.dp)
    ) {
        composable(NoteScreen.Home.route) {
            MemoScreen(notes = noteList,
                onAddNote = {
                    noteViewModel.addNote(it)
                },
                onRemoveNote = {
                    noteViewModel.removeNote(it)
                }
            )
        }

        composable(NoteScreen.Profile.route) {
            Counter()
        }

        composable(NoteScreen.Notification.route) {
            BizCard()
        }
    }


}