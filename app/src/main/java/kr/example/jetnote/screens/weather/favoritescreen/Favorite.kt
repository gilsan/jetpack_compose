package kr.example.jetnote.screens.weather.favoritescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.asStateFlow
import kr.example.jetnote.components.TopBar
import kr.example.jetnote.model.weathermodel.Favorite
import kr.example.jetnote.navigation.ScreenNav

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
            val lists = favoriteViewModel.favLists.collectAsState().value

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn {
                    items(lists) {
                        item ->
                        CityRow(item, navController = navController, favoriteViewModel)
                    }
                }
            }
        }

    }
}

@Composable
fun CityRow(
    favorite: Favorite,
    navController: NavController,
    favoriteViewModel: FavoriteViewModel
) {
    Surface(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .height(50.dp)
            .clickable {

            },
        shape = CircleShape.copy(topEnd = CornerSize(6.dp)),
        color = Color(0xFFB2DFDB)
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    navController.navigate(ScreenNav.Weather.name + "/${favorite.city}")
                }
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
                Text(text="${favorite.country}", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                Text(text="${favorite.city}", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                Icon(imageVector = Icons.Default.Delete, contentDescription = null, tint = Color.Red.copy(alpha = 0.8f),
                         modifier = Modifier.clickable {
                             favoriteViewModel.deleteFavorite(favorite)
                         })
        }
    }
}