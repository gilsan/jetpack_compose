package kr.example.jetnote.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
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



