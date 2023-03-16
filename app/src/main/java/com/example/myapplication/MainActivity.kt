package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonTree()
        }
    }
}
@SuppressLint("SuspiciousIndentation")
@Composable
fun LemonTree() {
    var onImageClick by remember { mutableStateOf(1) }
    val drawableResourceId = when(onImageClick) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val contentDescriptionResourceId = drawableResourceId

        when(onImageClick) {
        1 -> Text(
            text = "Tap the lemon tree to select a lemon",
            Modifier.fillMaxSize().
            padding(0.dp, 260.dp, 0.dp, 0.dp),
            textAlign = TextAlign.Center)
        2 -> Text(text = "Keep lapping the lemon to squeeze it",
            Modifier.fillMaxSize().
            padding(0.dp, 260.dp, 0.dp, 0.dp),
            textAlign = TextAlign.Center)
        3 -> Text(text = "Tap the lemonade to drink it",
            Modifier.fillMaxSize().
            padding(0.dp, 260.dp, 0.dp, 0.dp),
            textAlign = TextAlign.Center)
        else -> Text(text = "Tap the empty glass to start again",
            Modifier.fillMaxSize().
            padding(0.dp, 260.dp, 0.dp, 0.dp),
            textAlign = TextAlign.Center)
    }

    Row(modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {

        Image(painter = painterResource(id = drawableResourceId),
            contentDescription = stringResource(id = contentDescriptionResourceId),
            modifier = Modifier
                .wrapContentSize()
                .clickable {
                    onImageClick++
                    if (onImageClick > 4) onImageClick = 1
                }
                .border(
                    BorderStroke(2.dp, Color(105, 205, 216)),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(16.dp)
        )
    }

}
