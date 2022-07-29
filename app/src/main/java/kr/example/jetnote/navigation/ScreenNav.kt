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
    SplashScreen,
    LoginScreen,
    CreateAccountScreen,
    ReaderHomeScreen,
    SearchScreen,
    DetailsScreen,
    UpdateScreen,
    ReaderStatsScreen,
    AnimationScreen,
    FourProfile,
    MusicKnob,
    Indicator,
    Dialer,
    VolumeKnob,
    Paging,
    ;

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
            SplashScreen.name -> SplashScreen
            LoginScreen.name -> LoginScreen
            CreateAccountScreen.name -> CreateAccountScreen
            ReaderHomeScreen.name -> ReaderHomeScreen
            SearchScreen.name -> SearchScreen
            DetailsScreen.name -> DetailsScreen
            UpdateScreen.name -> UpdateScreen
            ReaderStatsScreen.name -> ReaderStatsScreen
            AnimationScreen.name -> AnimationScreen
            FourProfile.name -> FourProfile
            MusicKnob.name -> MusicKnob
            Indicator.name -> Indicator
            Dialer.name -> Dialer
            VolumeKnob.name -> VolumeKnob
            Paging.name -> Paging
            else -> throw IllegalArgumentException("경로를 찿을수 없습니다.")
        }
    }
}