package kr.example.jetnote.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    object HomeSub: Screen("home", Icons.Default.Home, "홈")
    object Profile: Screen("profile", Icons.Default.Person, "프로파일")
    object Notification: Screen("notification", Icons.Default.Notifications, "알림")
}

sealed class NoteScreen (
    val route: String,
    val icon: ImageVector,
    val title: String
        )  {
    object Home: NoteScreen( "home", Icons.Default.Home, "홈")
    object Profile: NoteScreen("profile", Icons.Default.Person, "카운터")
    object Notification: NoteScreen("notification", Icons.Default.Notifications, "명함")
}

sealed class AniScreen (
    val route: String,
    val icon: ImageVector,
    val title: String
)  {
    object Home: AniScreen( "home", Icons.Default.Home, "애니1")
    object Profile: AniScreen("profile", Icons.Default.Person, "애니2")
    object Notification: AniScreen("notification", Icons.Default.Notifications, "애니3")
}

sealed class FourScreen(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    object BOM1: FourScreen("BOM1", Icons.Default.Home, "홈")
    object BOM2: FourScreen("BOM2", Icons.Default.ShoppingCart, "쇼핑")
    object BOM3: FourScreen("BOM3", Icons.Default.Token," 토큰")
    object BOM4: FourScreen("BOM4", Icons.Default.SentimentVerySatisfied, "만족")
}



