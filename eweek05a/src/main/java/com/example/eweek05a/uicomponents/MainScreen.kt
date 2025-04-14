package com.example.eweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eweek05a.viewmodel.ImageViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel: ImageViewModel = viewModel()
) {
    val scrollState = rememberScrollState()

    val imageList = imageViewModel.imageList
    //방향 정보 불러오기.
    val orientation = LocalConfiguration.current.orientation
    //세로모드
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageList(imageList = imageList)
        }
    } else {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .horizontalScroll(scrollState),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageList(imageList = imageList)
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