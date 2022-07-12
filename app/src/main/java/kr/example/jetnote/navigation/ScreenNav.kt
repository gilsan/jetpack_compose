package kr.example.jetnote.navigation

enum class ScreenNav {
    HomeScreen,
    ScreenB,
    ScreenC,
    ScreenD,
    ScreenE,
    ShowImage,
    Greeting,
    Movie,
    MovieDetail,
    Note,
    Note2,
    Quiz,
    Weather,
    About,
    Favorite,
    Search,
    Setting,
    Splash,
    Reader,
    AnimationScreen;

    companion object {
        fun fromRoute(route: String): ScreenNav
                = when(route.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            ScreenB.name -> ScreenB
            ScreenC.name -> ScreenC
            ScreenD.name -> ScreenD
            ScreenE.name -> ScreenE
            ShowImage.name -> ShowImage
            Greeting.name -> Greeting
            Movie.name -> Movie
            MovieDetail.name -> MovieDetail
            Note.name -> Note
            Note2.name -> Note2
            Quiz.name -> Quiz
            Weather.name -> Weather
            About.name -> About
            Favorite.name -> Favorite
            Search.name -> Search
            Splash.name -> Splash
            Reader.name -> Reader
            AnimationScreen.name -> AnimationScreen
            else -> throw IllegalArgumentException("경로를 찿을수 없습니다.")
        }
    }
}