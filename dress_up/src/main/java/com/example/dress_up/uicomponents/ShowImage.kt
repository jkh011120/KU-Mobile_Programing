package com.example.dress_up.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dress_up.R
import com.example.dress_up.model.IMG
import com.example.dress_up.model.IMGFactory
import com.example.dress_up.model.IMGStatus


@Composable
fun ShowImage(IMGList: MutableList<IMG>, modifier: Modifier = Modifier) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.body),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )

            for (i in 0 until IMGList.size) if (IMGList[i].status == IMGStatus.ON) {
                Image(
                    painter = painterResource(id = IMGList[i].image),
                    contentDescription = null,
                    modifier = modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }
        }
    }
}

@Preview
@Composable
private fun ShowImagePreview() {
    ShowImage(IMGList = IMGFactory.makeIMGList())
}
