package com.rujirakongsomran.jc_animate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
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
                AnimateTextColor()
            }
        }
    }
}

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

@Composable
fun AnimatePadding() {
    var toggled by remember { mutableStateOf(false) }

    val animatedPadding by animateDpAsState(
        if (toggled) {
            0.dp
        } else {
            60.dp
        },
        label = "padding"
    )
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxSize()
            .padding(animatedPadding)
            .background(Color(0xff53D9A1))
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null
            ) {
                toggled = !toggled
            }
    )
}

@Preview(showSystemUi = true)
@Composable
fun AnimateTextColor() {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
    val animatedColor by infiniteTransition.animateColor(
        initialValue = Color(0xFF60DDAD),
        targetValue = Color(0xFF4285F4),
        animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
        label = "color"
    )

    BasicText(
        text = "Hello Compose",
        color = {
            animatedColor
        },
    )
}

