package com.it.shka.feature_main.presentation.animation


import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity



@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun ShimmerPlaceholder(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    highlightColor: Color = Color(0x6D696868),
    baseColor: Color =  Color(0x57757575),
    animationDurationMillis: Int = 1200
){
    val transition = rememberInfiniteTransition(label = "ShimmerAnimation")
    val translateAnimation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = animationDurationMillis,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "ShimmerTranslate"
    )
    // Размеры элемента будут получены через BoxWithConstraints
    BoxWithConstraints(
        modifier = modifier
            .clip(shape)
            .background(baseColor)
    ) {
        val maxWidthPx = with(LocalDensity.current) { maxWidth.toPx() }

        // Ширина "луча" мерцания — 30% от ширины
        val shimmerWidthPx = maxWidthPx * 0.3f

        // Вычисляем начальную и конечную позиции градиента
        val startX = (translateAnimation * (maxWidthPx + shimmerWidthPx)) - shimmerWidthPx
        val endX = startX + shimmerWidthPx

        // Создаём градиент, который "движется" по элементу
        val brush = Brush.linearGradient(
            colors = listOf(
                Color.Transparent,
                highlightColor,
                Color.Transparent
            ),
            start = Offset(startX, 0f),
            end = Offset(endX, 0f)
        )

        // Применяем градиент как фон
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(brush = brush)
        )
    }

}