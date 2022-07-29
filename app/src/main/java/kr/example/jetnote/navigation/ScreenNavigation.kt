package kr.example.jetnote.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

import androidx.navigation.compose.rememberNavController



import kr.example.jetnote.screens.animation.AnimationScreen
import kr.example.jetnote.screens.dogprofile.FourProfile
import kr.example.jetnote.screens.dogprofile.subPages.Dialer
import kr.example.jetnote.screens.dogprofile.subPages.IndicatorBar
import kr.example.jetnote.screens.dogprofile.subPages.Knob
import kr.example.jetnote.screens.dogprofile.subPages.MusicKnob
import kr.example.jetnote.screens.greeting.Greeting
import kr.example.jetnote.screens.home.HomeScreen
import kr.example.jetnote.screens.movies.Movie
import kr.example.jetnote.screens.movies.MovieDetail
import kr.example.jetnote.screens.note.MemoViewModel
import kr.example.jetnote.screens.note.Note2
import kr.example.jetnote.screens.paging.Paging

import kr.example.jetnote.screens.readbook.SplashScreen
import kr.example.jetnote.screens.readbook.details.ReaderDetail

import kr.example.jetnote.screens.readbook.home.ReaderHomeScreen
import kr.example.jetnote.screens.readbook.login.LoginScreen
import kr.example.jetnote.screens.readbook.search.ReaderSearch
import kr.example.jetnote.screens.readbook.stats.ReaderStatsScreen
import kr.example.jetnote.screens.readbook.update.UpdateScreen
import kr.example.jetnote.screens.screenb.ScreenB
import kr.example.jetnote.screens.screenc.ScreenC
import kr.example.jetnote.screens.showImage.ShowImage
import kr.example.jetnote.screens.splash.Splash
import kr.example.jetnote.screens.trivia.Trivia

import kr.example.jetnote.screens.weather.Weather
import kr.example.jetnote.screens.weather.WeatherViewModel
import kr.example.jetnote.screens.weather.aboutscreen.About
import kr.example.jetnote.screens.weather.favoritescreen.Favorite
import kr.example.jetnote.screens.weather.favoritescreen.FavoriteViewModel
import kr.example.jetnote.screens.weather.searchscreen.Search
import kr.example.jetnote.screens.weather.settingscreen.Settings

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()
    val route = ScreenNav.Splash.name

    NavHost(navController = navController, startDestination = route ) {

        composable(ScreenNav.Splash.name) {
            Splash(navController = navController)
        }

        composable(ScreenNav.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        composable(ScreenNav.ScreenB.name) {

            ScreenB(navController = navController)
        }

        composable(ScreenNav.ScreenC.name) {
            ScreenC(navController = navController)
        }

        // 이미지 보여주기
        composable(ScreenNav.ShowImage.name + "/{imageResource}/{scale}?name={name}",
            arguments = listOf(
                navArgument("imageResource") { type = NavType.IntType},
                navArgument("scale") { type = NavType.FloatType},
                navArgument("name") { type = NavType.StringType; defaultValue = "사과"}
            )
        ) { backStackEntry ->
            val image = backStackEntry.arguments?.getInt("imageResource")
            val scale = backStackEntry.arguments?.getFloat("scale")
            val name  = backStackEntry.arguments?.getString("name").toString()
            if (image != null && scale !== null) {
                ShowImage(navController = navController, imageResource= image, scale= scale, title=name)
            }

        }

        // 인사말 보여주기
        composable(ScreenNav.Greeting.name + "?name={name}", arguments = listOf(
            navArgument("name") { type = NavType.StringType}
        )) {
                navBackStackEntry ->
            val name = navBackStackEntry.arguments?.getString("name")
            if (name != null) {
                Greeting(navController = navController, greeting = name )
            }
        }

        // Movie
        composable( ScreenNav.Movie.name) {
            Movie(navController = navController)
        }

        composable(ScreenNav.MovieDetail.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") {
                type = NavType.StringType
            })) { navBackStackEntry ->
            MovieDetail(navController = navController, navBackStackEntry.arguments?.getString("movie"))

        }

        // animation
        composable(ScreenNav.AnimationScreen.name) {
            AnimationScreen(navController = navController)
        }

        composable(ScreenNav.Note2.name) {
            val noteViewModel = hiltViewModel<MemoViewModel>()
            Note2(navController = navController, noteViewModel)
        }

        composable(ScreenNav.Quiz.name) {
            // val triviaViewModel  = hiltViewModel<TriviaViewModel>()
            Trivia(navController = navController )
        }

        composable(ScreenNav.Weather.name) {
            val weatherViewModel  = hiltViewModel<WeatherViewModel>()
            Weather(navController = navController, weatherViewModel = weatherViewModel )
        }
        
        composable(ScreenNav.Weather.name + "/{city}",
          arguments = listOf(navArgument(name = "city"){
              type= NavType.StringType
          })) {
            navBackStackEntry ->
            val weatherViewModel  = hiltViewModel<WeatherViewModel>()
            Weather(
                navController = navController,
                weatherViewModel = weatherViewModel,
                navBackStackEntry.arguments?.getString("city")!!
                )
        }

        composable(ScreenNav.About.name) {
            About(navController = navController )
        }

        composable(ScreenNav.Favorite.name) {
            val favoriteViewModel = hiltViewModel<FavoriteViewModel>()
            Favorite(navController = navController , favoriteViewModel = favoriteViewModel)
        }

        composable(ScreenNav.Search.name) {
            Search(navController = navController )
        }

        composable(ScreenNav.Setting.name) {
            Settings(navController = navController )
        }

        // Reader

        composable(ScreenNav.SplashScreen.name) {
            SplashScreen(navController = navController)
        }



        composable(ScreenNav.ReaderHomeScreen.name) {
            ReaderHomeScreen(navController = navController, id = null )
        }

        composable(ScreenNav.ReaderHomeScreen.name + "/{id}",
            arguments = listOf( navArgument(name="id") {
                type= NavType.StringType
            })
            ) {
                navBackStackEntry ->
                ReaderHomeScreen(navController = navController,
                    navBackStackEntry.arguments?.getString("id")
            )
        }
        
        composable(ScreenNav.LoginScreen.name) {
            LoginScreen(navController = navController)
        }

        composable(ScreenNav.SearchScreen.name) {
            ReaderSearch(navController = navController)
        }

        composable(ScreenNav.ReaderStatsScreen.name) {
            ReaderStatsScreen(navController = navController)
        }

        composable(ScreenNav.DetailsScreen.name + "/{bookId}",
            arguments = listOf(navArgument(
                name ="bookId"
            ){ type= NavType.StringType})
        ) {
                navBackStackEntry ->
                  ReaderDetail(navController = navController, id =  navBackStackEntry.arguments?.getString("bookId").toString())

        }

        composable(ScreenNav.UpdateScreen.name + "/{bookID}",
            arguments = listOf(navArgument(name="bookID"){ type= NavType.StringType})
            ) {
            navBackStackEntry ->
            UpdateScreen(navController = navController, bookId = navBackStackEntry.arguments?.getString("bookID").toString() )
        }
        
        ////////////////////////////
        composable(ScreenNav.FourProfile.name) {
            FourProfile(navController = navController)
        }

        ////////// Side bar Menu
        // profileSideBarNav(navController = navController)
        composable(ScreenNav.MusicKnob.name) {
            MusicKnob(navController = navController)
        }

        composable(ScreenNav.Indicator.name) {
            IndicatorBar(navController = navController)
        }

        composable(ScreenNav.Dialer.name) {
            Dialer(navController = navController)
        }

        composable(ScreenNav.VolumeKnob.name) {
            Knob(navController = navController)
        }

        /////////// Paging Screen
        composable(ScreenNav.Paging.name) {
            Paging(navController = navController)
        }

    }
}