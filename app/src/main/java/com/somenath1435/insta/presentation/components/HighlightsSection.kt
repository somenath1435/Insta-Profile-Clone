package com.somenath1435.insta.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.somenath1435.insta.presentation.navigation.Screen

@Composable
fun HighlightsSection(navController: NavController) {
    val stories = List(10) { index -> index }
    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp)) {
        items(stories) { id ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.StoryPlayer.createRoute(id))
                }) {
                Image(
                    painter = rememberAsyncImagePainter("https://picsum.photos/seed/$id/150/150"),
                    contentDescription = null,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.LightGray, CircleShape)
                )
                Text("Story $id", fontSize = 12.sp)
            }
            Spacer(Modifier.width(8.dp))
        }
    }
}