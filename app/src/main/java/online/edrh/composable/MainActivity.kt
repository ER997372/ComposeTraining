package online.edrh.composable

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
    MyMessage("Juan", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Leo vel fringilla est ullamcorper eget nulla. Gravida dictum fusce ut placerat. Proin sagittis nisl rhoncus mattis rhoncus urna neque viverra justo. Sodales ut etiam sit amet nisl purus. Quis commodo odio aenean sed. Massa massa ultricies mi quis hendrerit dolor magna. At lectus urna duis convallis convallis tellus id interdum velit. Accumsan in nisl nisi scelerisque eu ultrices. Vulputate eu scelerisque felis imperdiet proin fermentum leo vel. Elementum nisi quis eleifend quam adipiscing vitae proin sagittis. Eget nulla facilisi etiam dignissim diam quis. Magna ac placerat vestibulum lectus mauris. Maecenas volutpat blandit aliquam etiam erat."),
    MyMessage("Pedro", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Leo vel fringilla est ullamcorper eget nulla. Gravida dictum fusce ut placerat. Proin sagittis nisl rhoncus mattis rhoncus urna neque viverra justo. Sodales ut etiam sit amet nisl purus. Quis commodo "),
    MyMessage("Esteban", "dio aenean sed. Massa massa ultricies mi quis hendrerit dolor magna. At lectus urna duis convallis convallis tellus id interdum velit. Accumsan in nisl nisi scelerisque eu ultrices. Vulputate eu scelerisque felis imperdiet proin fermentum leo ve"),
    MyMessage("Itati", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Leo vel fringilla est ullamcorper eget nulla."),
    MyMessage("Leonardo", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Leo vel fringilla est ullamcorper eget nulla."),
    MyMessage("Oscar", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Leo vel fringilla est ullamcorper eget nulla."),
    MyMessage("Pablo", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Leo vel fringilla est ullamcorper eget nulla."),
    MyMessage("Ximena", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Leo vel fringilla est ullamcorper eget nulla."),
    MyMessage("Roxana", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Leo vel fringilla est ullamcorper eget nulla."),
    MyMessage("Liliana", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Leo vel fringilla est ullamcorper eget nulla."),
    MyMessage("Michael", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Leo vel fringilla est ullamcorper eget nulla."),
    MyMessage("Alan", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Leo vel fringilla est ullamcorper eget nulla."),
    MyMessage("Guillermo", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Leo vel fringilla est ullamcorper eget nulla."),
    MyMessage("Damian", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Leo vel fringilla est ullamcorper eget nulla."),
    MyMessage("Miguel", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Leo vel fringilla est ullamcorper eget nulla."),
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

    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(start = 8.dp)
        .clickable {
            expanded = !expanded
        }) {
        myText(message.title,
        MaterialTheme.colorScheme.primary,
        MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(10.dp))
        myText(message.body,
        MaterialTheme.colorScheme.onBackground,
        MaterialTheme.typography.bodyMedium,
            if (expanded) Int.MAX_VALUE else 1
        )
    }
}

@Composable
fun myText(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(text, color = color, style = style, maxLines = lines)
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