package kr.example.jetnote.screens.splash



import android.view.animation.OvershootInterpolator
import android.widget.GridLayout
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kr.example.jetnote.R
import kr.example.jetnote.navigation.ScreenNav


@Composable
fun Splash(navController: NavController) {


    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true, block = {
        scale.animateTo(targetValue = 0.9f, animationSpec = tween(
            durationMillis = 800,
            delayMillis = 10,
            easing =  { OvershootInterpolator(8f).getInterpolation(it) }))

        delay(2000L)
        navController.popBackStack()
        navController.navigate(route=ScreenNav.HomeScreen.name)
    })

     Surface(
        modifier = Modifier
            .padding(15.dp)
            .size(330.dp)
            .scale(scale.value),

        shape = CircleShape,
        color = Color.White,
        border = BorderStroke(width = 2.dp, color = Color.LightGray)
    ) {

        Column(

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.sun), contentDescription = "Icon" ,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(70.dp))

            Text(text="맑은 날씨..", color = Color.LightGray, fontSize = 20.sp)
        }
    }

}