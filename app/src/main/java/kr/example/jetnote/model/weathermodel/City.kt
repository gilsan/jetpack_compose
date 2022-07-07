package kr.example.jetnote.model.weathermodel

data class City(
    val coord: Coord,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val timezone: Int
)