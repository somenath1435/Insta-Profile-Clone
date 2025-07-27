package com.somenath1435.insta.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun ProfileHeader() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter("https://picsum.photos/200"),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Spacer(Modifier.width(16.dp))
        Column {
            Text("somenath1435", fontWeight = FontWeight.Bold)
            Text("Capturing life, one moment at a time", fontSize = 12.sp)
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatItem("100", "Posts")
                StatItem("1.2K", "Followers")
                StatItem("300", "Following")
            }
            Row(Modifier.padding(top = 8.dp)) {
                Button(onClick = {}) { Text("Follow") }
                Spacer(Modifier.width(8.dp))
                Button(onClick = {}) { Text("Message") }
            }
        }
    }
}

@Composable
fun StatItem(count: String, label: String) {
    Column(Modifier.padding(end = 12.dp)) {
        Text(count, fontWeight = FontWeight.Bold)
        Text(label, fontSize = 12.sp)
    }
}