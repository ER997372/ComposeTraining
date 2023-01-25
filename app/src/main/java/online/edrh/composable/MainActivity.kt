package online.edrh.composable

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import online.edrh.composable.ui.theme.ComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableTheme {
                myComponent()
            }
        }
    }
}

@Composable
fun myTexts() {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        myText("Hola jetpack Compose!",
        MaterialTheme.colorScheme.primary,
        MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(10.dp))
        myText("estas listo?",
        MaterialTheme.colorScheme.onBackground,
        MaterialTheme.typography.bodyMedium)
        myText("Vamos a comenzar",
        MaterialTheme.colorScheme.onBackground,
        MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun myText(text: String, color: Color, style: TextStyle) {
    Text(text, color = color, style = style)
}

@Composable
fun myImage() {
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Imagen de prueba",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(64.dp)
    )
}

@Composable
fun myComponent() {
    Row(modifier = Modifier.padding(top = 8.dp).background(MaterialTheme.colorScheme.background)) {
        myImage()
        myTexts()
    }
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,
showSystemUi = true)
@Composable
fun PreviewComponent() {
    ComposableTheme {
        Column {
            myComponent()
        }
    }
}

