package com.jetpackcompose.viewpager.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun HorizontalPagerWithNextPrevButtonExampleScreen() {
    Column {
        HorizontalPagerWithNextPrevButtonExample()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerWithNextPrevButtonExample() {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        HorizontalPager(pageCount = 5, state = pagerState) { pageIndex ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Current Page Index $pageIndex")
            }
        }

        Row(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val prevButtonVisible = remember {
                derivedStateOf {
                    pagerState.currentPage > 0
                }
            }

            val nextButtonVisible = remember {
                derivedStateOf {
                    pagerState.currentPage < 4 // total pages are 5
                }
            }

            Button(
                enabled = prevButtonVisible.value,
                onClick = {
                    val prevPageIndex = pagerState.currentPage - 1
                    coroutineScope.launch { pagerState.animateScrollToPage(prevPageIndex) }
                },
            ) {
                Text(text = "Prev")
            }

            Button(
                enabled = nextButtonVisible.value ,
                onClick = {
                    val nextPageIndex = pagerState.currentPage + 1
                    coroutineScope.launch { pagerState.animateScrollToPage(nextPageIndex) }
                },
            ) {
                Text(text = "Next")
            }
        }
    }
}