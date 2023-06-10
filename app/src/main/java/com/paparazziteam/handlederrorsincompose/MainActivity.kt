package com.paparazziteam.handlederrorsincompose

import android.net.wifi.hotspot2.pps.HomeSp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.paparazziteam.handlederrorsincompose.screens.HomeViewModel
import com.paparazziteam.handlederrorsincompose.ui.theme.HandledErrorsInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HandledErrorsInComposeTheme {
                HomeSp()
            }
        }
    }
}

@Composable
fun HomeSp() {
    val homeViewModel = hiltViewModel<HomeViewModel>()

    HomeScreen(
        homeViewModel.nombres,
        homeViewModel.apellidos,
        homeViewModel.edad
    )
}

@Composable
fun HomeScreen(
    nombres : MutableState<String>,
    apellidos : MutableState<String>,
    edad : MutableState<String>
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SimpleTextField(
            nombres,
            label = "Nombres",
            placeholder = "Escriba su nombre"
        )
        Spacer(modifier = Modifier.padding(16.dp))
        SimpleTextField(
            apellidos,
            label = "Apellidos",
            placeholder = "Escriba su apellido"
        )
        Spacer(modifier = Modifier.padding(16.dp))
        SimpleTextField(
            edad,
            label = "Edad",
            placeholder = "Escriba su edad"
        )
        Spacer(modifier = Modifier.padding(16.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextField(
    text : MutableState<String>,
    label : String = "label",
    placeholder : String = "Placeholder",
){
    TextField(
        value = text.value,
        onValueChange = { newtext ->
            text.value  = newtext
        },
        label = { Text(text = label)},
        placeholder = { Text(text = placeholder)}

    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    HandledErrorsInComposeTheme {
        val homeViewModel = hiltViewModel<HomeViewModel>()

        HomeScreen(
            homeViewModel.nombres,
            homeViewModel.apellidos,
            homeViewModel.edad
        )
    }
}