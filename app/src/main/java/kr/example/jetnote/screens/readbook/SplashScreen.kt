package kr.example.jetnote.screens.readbook


import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kr.example.jetnote.navigation.ScreenNav

@Composable
fun SplashScreen(navController: NavController) {
    val scale  = remember { Animatable(0f) }

    LaunchedEffect(key1 = true, block = {
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 800,
                delayMillis = 200,
                easing = {
                    OvershootInterpolator(8f).getInterpolation(it)
                }
            )
        )
        delay(2000L)
        if (FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()) {
            navController.navigate(ScreenNav.LoginScreen.name)
        } else {
            val id = FirebaseAuth.getInstance().currentUser?.uid
            if (id.toString().isNotEmpty()) {
                navController.navigate(ScreenNav.ReaderHomeScreen.name + "/$id")
            } else {
                navController.navigate(ScreenNav.ReaderHomeScreen.name)
            }

        }
    } )

    Surface(
        modifier = Modifier
            .padding(15.dp)
            .size(200.dp)
            .scale(scale.value),
        shape = CircleShape,
        color = Color.White,
        border = BorderStroke(width = 2.dp, color = Color.DarkGray)
    ) {
        Column(
            modifier = Modifier.padding(2.dp).fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text="나의책장", color=Color.Blue, fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text="\"읽고, 생각하고, 변화하라..\"", color=Color.DarkGray, textAlign = TextAlign.Center,
                    fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        }


    }
}