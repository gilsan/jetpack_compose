package kr.example.jetnote.screens.note.data

import kr.example.jetnote.screens.note.model.Memo

fun getNoteList(): List<Memo> {

    return listOf(
        Memo(title = "A good day", description = "We went on a vacation by the lake"),
        Memo(title = "Android Compose", description = "Working on Android Compose course today"),
        Memo(title = "Keep at it...", description = "Sometimes things just happen"),
        Memo(title = "A movie day", description = "Watching a movie with family today"),
        Memo(title = "A movie day", description = "Watching a movie with family today"),
        Memo(title = "A movie day", description = "Watching a movie with family today"),
        Memo(title = "A movie day", description = "Watching a movie with family today"),
    )
}