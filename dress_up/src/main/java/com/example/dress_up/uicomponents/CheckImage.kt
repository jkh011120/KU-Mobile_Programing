package com.example.dress_up.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.dress_up.model.IMG
import com.example.dress_up.model.IMGFactory.makeIMGList

@Composable
fun CheckImage(item: IMG, modifier: Modifier = Modifier) {
    Column() {
        Text(
            text = item.name,
            fontSize = 16.sp,
        )
    }
}

@Preview
@Composable
private fun CheckImagePreview() {
    val item = makeIMGList()[0]
    CheckImage(item)
}
