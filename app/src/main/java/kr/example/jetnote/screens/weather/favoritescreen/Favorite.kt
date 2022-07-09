package kr.example.jetnote.screens.weather.favoritescreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.asStateFlow
import kr.example.jetnote.components.TopBar

@Composable
fun Favorite(
    navController: NavController,
    favoriteViewModel: FavoriteViewModel = hiltViewModel()
    ) {
    Scaffold(
        topBar = {
            TopBar(title = "선호도시", icon = Icons.Default.ArrowBack , navController = navController )
        },
    ) {
        Surface(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            val list = favoriteViewModel.favLists.collectAsState().value
            Text(text="$list")
        }

    }
}