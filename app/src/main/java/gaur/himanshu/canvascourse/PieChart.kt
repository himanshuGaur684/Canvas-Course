package gaur.himanshu.canvascourse

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PieChart(modifier: Modifier = Modifier, data: List<Float>, colors: List<Color>) {
    Box(modifier.padding(12.dp), contentAlignment = Alignment.Center) {
        val total = data.sum()
        var startAngle = -90f

        Canvas(modifier = Modifier.fillMaxSize()) {
            val size = size.minDimension
            val radius = size.div(2)
            val center = Offset(size.div(2), size.div(2))

            data.forEachIndexed { index, value ->
                val sweepAngle = (value.div(total)) * 360f
                drawArc(
                    color = colors.get(index),
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = true,
                    topLeft = Offset(center.x - radius, center.y - radius),
                    size = Size(width = radius.times(2), height = radius.times(2))
                )
                startAngle += sweepAngle
            }

            drawCircle(
                color = Color.White, center = center, radius = 120f
            )

            val paint = Paint().apply {
                textSize = 24f
                color = Black.toArgb()
            }
            drawContext.canvas.nativeCanvas.drawText(
                "hello", center.x, center.y, paint
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PieChartPreview(modifier: Modifier = Modifier) {
    PieChart(
        data = listOf(12f, 4f, 6f, 9f),
        colors = listOf(Red, Blue, Color.Yellow, Green),
        modifier = Modifier
            .width(300.dp)
            .height(200.dp)
    )
}
