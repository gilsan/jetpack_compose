package kr.example.jetnote
//  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
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import kr.example.jetnote.data.NoteDataSource
import kr.example.jetnote.model.Note
import kr.example.jetnote.navigation.ScreenNavigation
import kr.example.jetnote.screen.NoteScreen
import kr.example.jetnote.screen.NoteViewModel
import kr.example.jetnote.screen.NotesApp
import kr.example.jetnote.ui.theme.JetNoteTheme
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ScreenNavigation()
                }
            }


        }
    }
}



@Composable
fun MyApp(content: @Composable ()-> Unit) {
    JetNoteTheme {
       content()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        NoteScreen(notes = NoteDataSource().getNoteData(), onAddNote = {}, onRemoveNote = {})
    }
}