package com.app.screenpulse.ui.components


import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun AnimatedCircularProgressIndicator(
    modifier: Modifier = Modifier,
    currentValue: Int = 0,
    maxValue: Int = 100,
    progressBackgroundColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    progressIndicatorColor: Color = MaterialTheme.colorScheme.primary,
    completedColor: Color = MaterialTheme.colorScheme.primary,
) {

    val stroke = with(LocalDensity.current) {
        Stroke(width = 6.dp.toPx(), cap = StrokeCap.Round, join = StrokeJoin.Round)
    }

    Box(modifier = modifier, contentAlignment = Alignment.Center) {

        val animateFloat = remember { Animatable(0f) }
        LaunchedEffect(animateFloat) {
            animateFloat.animateTo(
                targetValue = currentValue / maxValue.toFloat(),
                animationSpec = tween(durationMillis = 2000, easing = FastOutSlowInEasing)
            )
        }

        Canvas(
            Modifier
                .progressSemantics(currentValue / maxValue.toFloat())
                .size(CircularIndicatorDiameter)
        ) {
            // Start at 12 O'clock
            val startAngle = 270f
            val sweep: Float = animateFloat.value * 360f
            val diameterOffset = stroke.width / 2

            drawCircle(
                color = progressBackgroundColor,
                style = stroke,
                radius = size.minDimension / 2.0f - diameterOffset
            )
            drawCircularProgressIndicator(startAngle, sweep, progressIndicatorColor, stroke)

            if (currentValue == maxValue) {
                drawCircle(
                    color = completedColor,
                    style = stroke,
                    radius = size.minDimension / 2.0f - diameterOffset
                )
            }
        }
    }
}


private fun DrawScope.drawCircularProgressIndicator(
    startAngle: Float,
    sweep: Float,
    color: Color,
    stroke: Stroke
) {
    // To draw this circle we need a rect with edges that line up with the midpoint of the stroke.
    // To do this we need to remove half the stroke width from the total diameter for both sides.
    val diameterOffset = stroke.width / 2
    val arcDimen = size.width - 2 * diameterOffset
    drawArc(
        color = color,
        startAngle = startAngle,
        sweepAngle = sweep,
        useCenter = false,
        topLeft = Offset(diameterOffset, diameterOffset),
        size = Size(arcDimen, arcDimen),
        style = stroke
    )
}

// Diameter of the indicator circle
private val CircularIndicatorDiameter = 84.dp