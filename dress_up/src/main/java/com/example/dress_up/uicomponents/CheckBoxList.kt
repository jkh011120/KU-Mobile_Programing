package com.example.dress_up.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dress_up.model.IMG
import com.example.dress_up.model.IMGFactory
import com.example.dress_up.model.IMGStatus

@Composable
fun CheckBoxList(IMGList: MutableList<IMG>, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        for (i in 0 until IMGList.size step (2)) {
            Column() {
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Box(
                        modifier = modifier
                            .width(125.dp)
                            .padding(vertical = 10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CheckBox(checked = IMGList[i].status == IMGStatus.ON) { isChecked ->
                                IMGList[i] = IMGList[i].copy(
                                    status = if (isChecked) IMGStatus.ON
                                    else IMGStatus.OFF
                                )
                            }
                            CheckImage(item = IMGList[i])
                        }
                    }
                    Box(
                        modifier = modifier
                            .width(125.dp)
                            .padding(vertical = 10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            var item = IMGList[i + 1]
                            CheckBox(checked = IMGList[i + 1].status == IMGStatus.ON) { isChecked ->
                                IMGList[i + 1] = item.copy(
                                    status = if (isChecked) IMGStatus.ON
                                    else IMGStatus.OFF
                                )
                            }
                            CheckImage(item = IMGList[i + 1])
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CheckBoxListPreview() {
    CheckBoxList(IMGFactory.makeIMGList())
}