package online.edrh.composable.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import online.edrh.composable.R
import online.edrh.composable.ui.navigation.AppScreens
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController) {
    Scaffold(modifier = Modifier.background(MaterialTheme.colorScheme.background),
        topBar = {
        TopAppBar(title = {
            Text(text = "First Screen",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.headlineLarge)

        })
    }) {
        BodyContent(template, navController)
    }
}

@Composable
fun myTexts(message: MyMessage, navController: NavController) {

    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(start = 8.dp)
        .clickable {
            expanded = !expanded
            navController.navigate(AppScreens.SecondScreen.route + "/" + message.title + "/" + message.body)
        }) {
        myText(message.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(10.dp))
        myText(message.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyMedium,
//            if (expanded) Int.MAX_VALUE else 1
        1
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
            .padding(vertical = 10.dp)
            .padding(start = 10.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(64.dp)
    )
}

@Composable
fun myComponent(message: MyMessage, navController: NavController) {
    Row(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        myImage()
        myTexts(message, navController)
    }
}

@Composable
fun BodyContent(messages: List<MyMessage>, navController: NavController) {
    val scrollState = rememberScrollState()
    ComposableTheme {
        LazyColumn(modifier = Modifier.padding(top = 60.dp).background(MaterialTheme.colorScheme.background)) {
            items(items = messages) { message ->
                myComponent(message, navController)
            }
        }
    }
}

data class MyMessage(val title: String, val body: String)