package gaur.himanshu.canvascourse

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import gaur.himanshu.canvascourse.ui.theme.CanvasCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CanvasCourseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IosWeatherAppIcon(modifier: Modifier = Modifier) {

    Canvas(
        modifier
            .padding(12.dp)
            .size(300.dp)
    ) {

        val path = Path().apply {
            moveTo(
                size.width.times(0.45f),
                size.height.times(0.75f)
            )

            cubicTo(
                size.width.times(0.25f),
                size.height.times(0.75f),
                size.width.times(0.25f),
                size.height.times(0.45f),
                size.width.times(0.45f),
                size.height.times(0.5f)
            )

            cubicTo(
                size.width.times(0.45f),
                size.height.times(0.2f),
                size.width.times(0.65f),
                size.height.times(0.15f),
                size.width.times(0.75f),
                size.height.times(0.4f)
            )

            cubicTo(
                size.width.times(0.95f),
                size.height.times(0.35f),
                size.width.times(0.95f),
                size.height.times(0.75f),
                size.width.times(0.75f),
                size.height.times(0.75f)
            )

        }

        drawRoundRect(
            color = Blue,
            cornerRadius = CornerRadius(120f, 120f)
        )

        drawCircle(
            color = Yellow,
            radius = size.width.times(0.2f),
            center = Offset(
                size.width.times(0.35f),
                size.height.times(0.45f)
            )
        )

        drawPath(
            path,
            color = Color.White.copy(alpha = 0.8f),
        )


    }

}

@Composable
fun GoogleIcons(modifier: Modifier = Modifier) {

    Canvas(
        modifier
            .padding(12.dp)
            .size(300.dp)
    ) {

        drawArc(
            color = Red,
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(
                size.width.div(2f),
                size.height.times(0.25f)
            ),
            size = Size(
                size.width.div(2f),
                size.height.div(2f)
            )
        )

        drawArc(
            color = Blue,
            startAngle = -90f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(
                size.width.times(0.25f),
                0f
            ),
            size = Size(
                size.width.div(2f),
                size.height.div(2f)
            )
        )

        drawArc(
            color = Yellow,
            startAngle = 0f,
            sweepAngle = -180f,
            useCenter = true,
            topLeft = Offset(0f, size.height.times(0.25f)),
            size = Size(size.width.div(2f), size.height.div(2f))
        )

        drawArc(
            color = Black,
            startAngle = -90f,
            sweepAngle = -180f,
            useCenter = true,
            topLeft = Offset(
                size.width.times(0.25f),
                size.height.times(0.5f)
            ),
            size = Size(size.width.div(2f), size.height.div(2f))
        )


    }

}


@Composable
fun MessengerLogo(modifier: Modifier = Modifier) {

    Canvas(
        modifier
            .padding(12.dp)
            .size(300.dp)
    ) {

        val triangle = Path().apply {
            moveTo(
                size.width.times(0.2f), size.height.times(0.84f)
            )
            lineTo(size.width.times(0.2f), size.height.times(0.99f))
            lineTo(size.width.times(0.3f), size.height.times(0.91f))
        }


        val electricPath = Path().apply {
            moveTo(
                size.width.times(0.2f), size.height.times(0.6f)
            )
            lineTo(size.width.times(0.45f), size.height.times(.34f))
            lineTo(size.width.times(0.55f), size.height.times(.45f))
            lineTo(size.width.times(0.8f), size.height.times(.33f))
            lineTo(size.width.times(0.55f), size.height.times(.6f))
            lineTo(size.width.times(0.45f), size.height.times(.47f))
            close()
        }


        drawOval(
            color = Blue,
            size = Size(
                width = size.width,
                height = size.height.times(0.95f)
            )
        )

        drawPath(
            path = triangle,
            color = Blue,
            style = Fill
        )

        drawPath(
            path = electricPath,
            color = White,
            style = Fill
        )


    }

}

@Composable
fun FacebookLogo(modifier: Modifier = Modifier) {

    Canvas(
        modifier = modifier
            .padding(12.dp)
            .size(300.dp)
    ) {

        val paint = Paint().apply {
            textAlign = Paint.Align.CENTER
            textSize = 820f
            color = Color.White.toArgb()
        }

        drawRoundRect(
            color = Color.Blue,
            cornerRadius = CornerRadius(120f, 120f)
        )

        drawContext.canvas.nativeCanvas.drawText(
            "f",
            center.x + 100f,
            center.y + 320f,
            paint
        )

    }

}

@Composable
fun InstagramLogo(modifier: Modifier = Modifier) {

    Canvas(
        modifier = modifier
            .padding(12.dp)
            .size(300.dp)
    ) {


        drawRoundRect(
            brush = Brush.linearGradient(
                listOf(Red, Color.Blue)
            ),
            cornerRadius = CornerRadius(x = 120f, y = 120f),
            style = Stroke(width = 36f),
        )

        drawCircle(
            brush = Brush.linearGradient(
                listOf(Red, Color.Blue)
            ),
            radius = 150f,
            style = Stroke(width = 24f)
        )

        drawCircle(
            brush = Brush.linearGradient(
                listOf(Red, Color.Blue)
            ),
            radius = 24f,
            center = Offset(
                size.width.times(0.8f),
                size.height.times(0.2f)
            )
        )


    }

}



