package kr.example.jetnote.screens.screenc

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreenSub() {
    androidx.compose.material.Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            MyHorizontalList()
            MyVerticalList()
        }
    }
}


@Composable
fun MyVerticalList() {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = ProfilesList) {
                item ->
            Row(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text= item.name, modifier= Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically))
                Image(painter = painterResource(id = item.picture), contentDescription = item.name,
                    modifier= Modifier
                        .weight(1f)
                        .size(100.dp)
                        .clip(RoundedCornerShape(30.dp)),
                    contentScale = ContentScale.Crop)
            }
        }
    }
}

@Composable
fun MyHorizontalList() {
    LazyRow(
        modifier = Modifier.fillMaxWidth().height(120.dp)
    ) {
        items(items = ProfilesList) {
                item ->
            Row(
                modifier = Modifier.padding(10.dp)
                    .width(150.dp)
                    .height(150.dp)
            ) {

                Text(text= item.name, modifier= Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                    style=MaterialTheme.typography.caption
                )
                Image(painter = painterResource(id = item.picture), contentDescription = item.name,
                    modifier= Modifier
                        .weight(1f)
                        .size(100.dp)
                        .clip(RoundedCornerShape(30.dp)),
                    contentScale = ContentScale.Crop)
            }
        }
    }
}
