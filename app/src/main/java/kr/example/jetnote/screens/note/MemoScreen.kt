package kr.example.jetnote.screens.note


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kr.example.jetnote.screens.note.component.MemoButton
import kr.example.jetnote.screens.note.component.MemoInputText
import kr.example.jetnote.screens.note.model.Memo
import kr.example.jetnote.screens.note.util.formatDate


@Composable
fun MemoScreen(
    notes: List<Memo>,
    onAddNote: (Memo)-> Unit = {},
    onRemoveNote: (Memo) -> Unit = {}
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MemoInputText(
            modifier = Modifier.padding(5.dp),
            text= title,
            label = "제 목",
            onTextChange = {
                if (it.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) title = it
            }
        )

        MemoInputText(
            modifier = Modifier.padding(5.dp),
            text= description,
            label = "노 트",
            onTextChange = {
                if (it.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) description = it
            }
        )

        MemoButton(
            text = "저장",
            onClick = {
                if (title.isNotEmpty() && description.isNotEmpty()) {
                    onAddNote(Memo(title=title, description = description))
                    title = ""
                    description = ""
                }
            },
            modifier = Modifier.padding(top = 9.dp))

        Divider(modifier =  Modifier.padding(10.dp))

        LazyColumn(modifier = Modifier.padding(5.dp) ) {
            items(notes) {
                    note ->
                NoteRow(note = note) {
                    onRemoveNote(it)
                }

            }
        }

    } // End of Column
}


@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Memo,
    onNoteClicked: (Memo) -> Unit
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 30.dp)),
        color= Color(0xFFDFE6EB),
        elevation = 5.dp

    ) {
        Column(
            modifier= Modifier
                .clickable {
                    onNoteClicked(note)
                }
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text= note.title, style= MaterialTheme.typography.subtitle1)
            Text(text= note.description, style= MaterialTheme.typography.subtitle2)
            Text(text=  formatDate(note.entryDate.time), style= MaterialTheme.typography.caption )
        }
    }

}