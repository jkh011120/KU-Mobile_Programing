package com.example.dress_up.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dress_up.viewmodel.ImageViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel: ImageViewModel = viewModel()
) {
    val potato = imageViewModel.imageList
    val orientation = LocalConfiguration.current.orientation
    //세로
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {

        Column() {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) {
                ShowImage(potato)
            }
            Box(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                CheckBoxList(potato)
            }
        }
    } else {
        Row() {
            Box(
                modifier = modifier
                    .fillMaxHeight()
                    .width(400.dp)
            ) {
                ShowImage(potato)
            }
            Box(
                modifier = modifier
                    .fillMaxHeight()
            ) {
                CheckBoxList(potato)
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}