package kr.example.jetnote.screens.screenc

import kr.example.jetnote.R
import java.util.*

data class Profile(
    val name: String,
    val picture: Int,
    val id: String = UUID.randomUUID().toString()
)

val ProfilesList = listOf(
    Profile("공리", R.drawable.pineapple),
    Profile("John", R.drawable.john),
    Profile("Andrew", R.drawable.andrew),
    Profile("Elisa", R.drawable.elisa),
    Profile("Edward", R.drawable.edward),
    Profile("Jacky", R.drawable.jacky),
    Profile("Jade", R.drawable.jade),
    Profile("Jane", R.drawable.jane),
    Profile("Jennifer", R.drawable.jennifer),
    Profile("Jerard", R.drawable.jerard),
    Profile("Ted", R.drawable.ted),

    Profile("John", R.drawable.john),
    Profile("Andrew", R.drawable.andrew),
    Profile("Elisa", R.drawable.elisa),
    Profile("Edward", R.drawable.edward),
    Profile("Jacky", R.drawable.jacky),
    Profile("Jade", R.drawable.jade),
    Profile("Jane", R.drawable.jane),
    Profile("Jennifer", R.drawable.jennifer),
    Profile("Jerard", R.drawable.jerard),
    Profile("Ted", R.drawable.ted),

    )
