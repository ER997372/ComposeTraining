package online.edrh.composable.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import online.edrh.composable.ui.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(navController: NavController, name: String?, description: String?) {
    Scaffold(topBar = {
        TopAppBar(title = { name?.let { Text(it) } },
        navigationIcon = { Icon(Icons.Default.ArrowBack,
            null,
        modifier = Modifier.clickable {
            navController.popBackStack()
        }) })
    }) {
        SecondBodyContent(navController, description)
    }
}

@Composable
fun SecondBodyContent(navController: NavController, description: String?) {
    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        description?.let { Text(modifier = Modifier.padding(20.dp, 0.dp), text = it) }
        Button(onClick = {
            navController.navigate(AppScreens.FirstScreen.route)
        }) {
            Text("Volver atras")
        }
    }
}