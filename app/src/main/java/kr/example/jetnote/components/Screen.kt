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
    object Profile: Screen("profile", Icons.Default.Person, "그리드")
    object Notification: Screen("notification", Icons.Default.Notifications, "개별로나누기")
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
    object BOM1: FourScreen("BOM1", Icons.Default.Email, "메일")
    object BOM2: FourScreen("BOM2", Icons.Default.Favorite, "반려견")
    object BOM3: FourScreen("BOM3", Icons.Default.CellWifi," 뉴스")
    object BOM4: FourScreen("BOM4", Icons.Default.SentimentVerySatisfied, "진행율")
    object BOM5: FourScreen("BOM5", Icons.Default.SentimentVerySatisfied, "크높")
}

sealed class Restful(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    object HOME: Restful("HOME", Icons.Default.Home, "공유기필요")
    object SEARCH: Restful("SEARCH", Icons.Default.Search, "페이징1")
    object DETAIL: Restful("DETAIL", Icons.Default.Details, "페이징2")
    object CONTENT: Restful("CONTENT", Icons.Default.Details, "내역")
}



