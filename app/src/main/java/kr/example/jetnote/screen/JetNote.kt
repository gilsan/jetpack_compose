package kr.example.jetnote.screen

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*


import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.example.jetnote.R
import kr.example.jetnote.components.NoteButton
import kr.example.jetnote.components.NoteInputText
import kr.example.jetnote.data.NoteDataSource
import kr.example.jetnote.model.Note
import kr.example.jetnote.util.formatDate
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter



@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note)-> Unit
) {
    var title by remember {
        mutableStateOf("")
    }

    var description by remember { mutableStateOf("")}
  Column(
      modifier = Modifier.padding(6.dp)
  ) {
    Scaffold(
        topBar = {
            TopAppBar(
                contentColor = Color.Green,

            ) {
                Text(text = stringResource(id = R.string.app_name))
                Spacer(modifier = Modifier.width(200.dp))
                Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "Icon")
            }
        }
    ) {
        val context = LocalContext.current
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            NoteInputText(

                text = title, label = "제목",  onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) {
                        title = it
                    }
                })
            NoteInputText(
                modifier = Modifier.padding(top=5.dp, bottom = 5.dp),
                text = description, label = "노트추가",  onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) {
                        description = it
                    }
                })
            NoteButton(text = "저장", onClick = {
                if (title.isNotEmpty() && description.isNotEmpty()) {
                    // save/add to the list
                    onAddNote(Note(title = title, description =description))
                    title =""
                    description = ""
                    Toast.makeText(context, "추가했습니다.", Toast.LENGTH_SHORT).show()
                }
             })
            Divider(modifier = Modifier.padding(10.dp))

            LazyColumn(
                modifier = Modifier.padding(5.dp)
            ) {
                items(notes) { note ->
                    NoteRow(note=note, onNoteClicked = {
                        onRemoveNote(note)
                    })
                }
            }

        } // End of Column


    }


  }
}


@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit
) {
   Surface(
       modifier = Modifier
           .padding(4.dp)
           .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
           .fillMaxWidth(),
            color=Color(0xFFDFE6EB),
            elevation = 4.dp
   ) {
       Column(
           modifier = Modifier
               .clickable {
                   onNoteClicked(note)
               }
               .padding(
                   horizontal = 14.dp, vertical = 6.dp
               ),
           horizontalAlignment = Alignment.Start,
           verticalArrangement = Arrangement.Center
       ) {
           Text(text = note.title, style=MaterialTheme.typography.subtitle2)
           Text(text = note.description, style=MaterialTheme.typography.subtitle1)

           Text(text = formatDate(note.entryDate.time),
            style=MaterialTheme.typography.caption)
       }
       
   }
}



@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(notes = NoteDataSource().getNoteData(), onAddNote = {}, onRemoveNote = {})
}