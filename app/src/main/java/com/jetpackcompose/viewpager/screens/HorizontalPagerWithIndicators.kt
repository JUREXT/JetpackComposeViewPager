package com.jetpackcompose.viewpager.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.jetpackcompose.viewpager.R

@Composable
fun HorizontalPagerWithIndicatorsScreen() {
    val images = listOf(
        R.drawable.logo_android,
        R.drawable.logo_kotlin,
        R.drawable.logo_gradle,
        R.drawable.logo_github,
        R.drawable.logo_google,
    )
    Column {
        HorizontalPagerWithIndicators(images)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerWithIndicators(images: List<Int>) {
    val pagerState = rememberPagerState()
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
    ) {
        HorizontalPager(pageCount = 5, state = pagerState) {
            Image(
                painter = painterResource(id = images[it]),
                contentScale = ContentScale.Crop,
                contentDescription = "" )
        }

        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp),
            pageCount = 5,
            pagerState = pagerState,
        )
    }
}