package com.somenath1435.insta.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.compose.rememberAsyncImagePainter
import com.somenath1435.insta.domain.Image

sealed class Screen(val route: String) {
    object Profile : Screen("profile")

    object StoryPlayer : Screen("storyPlayer/{storyId}") {
        fun createRoute(storyId: Int) = "storyPlayer/$storyId"
    }

}

@Composable
fun AppNavHost(navController: NavHostController, viewModel: ProfileViewModel) {
    NavHost(navController = navController, startDestination = Screen.Profile.route) {
        composable(Screen.Profile.route) {
            ProfileScreen(viewModel = viewModel, navController = navController)
        }
        composable(Screen.StoryPlayer.route) { backStackEntry ->
            val storyId = backStackEntry.arguments?.getString("storyId")?.toIntOrNull()
            storyId?.let {
                StoryPlayerScreen(storyId = it)
            }
        }
    }
}

@Composable
fun ProfileScreen(viewModel: ProfileViewModel, navController: NavController) {
    val images = viewModel.images

    Scaffold(topBar = { InstagramTopBar() }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            ProfileHeader()
            Spacer(Modifier.height(12.dp))
            HighlightsSection(navController)
            Spacer(Modifier.height(12.dp))
            PostGrid(images = images)
        }
    }
}

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

@Composable
fun PostGrid(images: List<Image>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(1.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        items(images) { image ->
            Image(
                painter = rememberAsyncImagePainter(image.url),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Instagram",
                fontFamily = FontFamily.Cursive,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        },
        actions = {
            IconButton(onClick = { /* TODO: Add Post */ }) {
                Icon(Icons.Default.Add, contentDescription = "Add Post")
            }
            IconButton(onClick = { /* TODO: Notifications */ }) {
                Icon(Icons.Default.Notifications, contentDescription = "Notifications")
            }
            IconButton(onClick = { /* TODO: Menu or Messenger */ }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },
    )
}

@Composable
fun StoryPlayerScreen(storyId: Int) {
    val imageUrls = listOf(
        "https://picsum.photos/seed/$storyId/800/1200",
    )

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { imageUrls.size })

    Column(Modifier.fillMaxSize()) {
        HorizontalPager(state = pagerState) { page ->
            Image(
                painter = rememberAsyncImagePainter(imageUrls[page]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}

