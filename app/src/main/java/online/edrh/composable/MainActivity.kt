package online.edrh.composable

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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

val template = listOf(
    MyMessage("Juan", "Hola amigo"),
    MyMessage("Pedro", "Hola amigo"),
    MyMessage("Esteban", "Hola amigo"),
    MyMessage("Itati", "Hola amigo"),
    MyMessage("Leonardo", "Hola amigo"),
    MyMessage("Oscar", "Hola amigo"),
    MyMessage("Pablo", "Hola amigo"),
    MyMessage("Ximena", "Hola amigo"),
    MyMessage("Roxana", "Hola amigo"),
    MyMessage("Liliana", "Hola amigo"),
    MyMessage("Michael", "Hola amigo"),
    MyMessage("Alan", "Hola amigo"),
    MyMessage("Guillermo", "Hola amigo"),
    MyMessage("Damian", "Hola amigo"),
    MyMessage("Miguel", "Hola amigo"),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            renderUI(template)
        }
    }
}

@Composable
fun renderUI(messages: List<MyMessage>) {
    val scrollState = rememberScrollState()
    ComposableTheme {
        LazyColumn {
            items(items = messages) { message ->
                myComponent(message)
            }
        }
    }
}

@Composable
fun myTexts(message: MyMessage) {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        myText(message.title,
        MaterialTheme.colorScheme.primary,
        MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(10.dp))
        myText(message.body,
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
fun myComponent(message: MyMessage) {
    Row(modifier = Modifier.padding(top = 8.dp).background(MaterialTheme.colorScheme.background)) {
        myImage()
        myTexts(message)
    }
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,
showSystemUi = true)
@Composable
fun PreviewComponent() {
    renderUI(template)
}

data class MyMessage(val title: String, val body: String)