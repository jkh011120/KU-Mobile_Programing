package com.example.eweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eweek05a.viewmodel.ImageViewModel
import com.example.week05a.uiexamples.ScrollToTopButton
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel: ImageViewModel = viewModel()
) {
    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val showButton by remember {
        derivedStateOf {
            state.firstVisibleItemScrollOffset > 100
        }
    }

    val imageList = imageViewModel.imageList
    //방향 정보 불러오기.
    val orientation = LocalConfiguration.current.orientation

    //세로모드
    Box(modifier = Modifier.fillMaxSize()) {
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            LazyColumn(
                state = state,
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    ImageList(imageList = imageList)
                }
            }
        } else {
            LazyRow(
                state = state,
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                item {
                    ImageList(imageList = imageList)
                }
            }
        }
        AnimatedVisibility(visible = showButton) {
            ScrollToTopButton {
                scope.launch {
                    state.scrollToItem(0)
                }
            }
        }
    }


//    var img1State by rememberSaveable(stateSaver = ImageData.ImageSaver) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img1),
//                buttonType = ButtonType.BADGE,
//                likes = 50
//            )
//        )
//    }
//
//    var img2State by rememberSaveable(stateSaver = ImageData.ImageSaver) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img1),
//                buttonType = ButtonType.EMOGI,
//                likes = 100,
//                dislikes = 10
//            )
//        )
//    }
//
//    Column {
//        ImageWithButton(image = img1State.image) {
//            ButtonWithBadge(likes = img1State.likes) {
//                img1State = img1State.copy(likes = img1State.likes + 1)
//            }
//        }
//        ImageWithButton(image = img2State.image) {
//            ButtonWithEmoji(
//                likes = img2State.likes,
//                dislikes = img2State.dislikes,
//                onClickLikes = {
//                    img2State = img2State.copy(likes = img2State.likes + 1)
//                },
//                onClickDisLikes = {
//                    img2State = img2State.copy(dislikes = img2State.dislikes + 1)
//                }
//            )
//        }
//
//    }


}