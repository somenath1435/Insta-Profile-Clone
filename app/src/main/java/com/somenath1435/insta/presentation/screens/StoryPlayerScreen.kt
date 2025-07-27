package com.somenath1435.insta.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.rememberAsyncImagePainter

@Composable
fun StoryPlayerScreen(storyId: Int) {
    val imageUrls = listOf(
        "https://picsum.photos/seed/$storyId/800/1200"
    )

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { imageUrls.size })

    Column(Modifier.fillMaxSize()) {
        HorizontalPager(state = pagerState) { page ->
            Image(
                painter = rememberAsyncImagePainter(imageUrls[page]),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}