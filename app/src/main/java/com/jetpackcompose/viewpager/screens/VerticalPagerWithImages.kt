package com.jetpackcompose.viewpager.screens


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jetpackcompose.viewpager.R

@Composable
fun VerticalPagerWithImagesAndIndicatorsScreen() {
    val images = listOf(
        R.drawable.logo_android,
        R.drawable.logo_twitter,
        R.drawable.logo_google,
        R.drawable.logo_instagram,
        R.drawable.logo_fb,
    )
    Column {
        VerticalPagerWithImagesAndIndicators(images)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalPagerWithImagesAndIndicators(images: List<Int>) {
    val pagerState = rememberPagerState()
    VerticalPager(
        pageCount = 5,
        pageSize = PageSize.Fixed(300.dp),
        pageSpacing = 8.dp,
        state = pagerState) {
        Image(
            painter = painterResource(id = images[it]),
            contentScale = ContentScale.Crop,
            contentDescription = "" )
    }
}