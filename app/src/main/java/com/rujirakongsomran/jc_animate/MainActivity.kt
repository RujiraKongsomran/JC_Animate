package com.rujirakongsomran.jc_animate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rujirakongsomran.jc_animate.ui.theme.JC_AnimateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_AnimateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AnimateSizeComposable() {
    var expended by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .animateContentSize()
            .height(if (expended) 400.dp else 200.dp)
            .fillMaxWidth()
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null
            ) {
                expended = !expended
            }
    ) {

    }
}

@Preview(showSystemUi = true)
@Composable
fun AnimateSizeComposableVertical() {
    var expended by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .background(Color.Green)
            .animateContentSize()
            .width(if (expended) 250.dp else 100.dp)
            .fillMaxHeight()
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null
            ) {
                expended = !expended
            }
    ) {

    }
}

