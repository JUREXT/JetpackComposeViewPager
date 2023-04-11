package com.jetpackcompose.viewpager.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalPagerSimpleExampleScreen() {
    Column {
        HorizontalPagerSimpleExample()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerSimpleExample() {
    val pagerState = rememberPagerState()
    HorizontalPager(pageCount = 5, state = pagerState) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Page Index : $it")
        }
    }
}