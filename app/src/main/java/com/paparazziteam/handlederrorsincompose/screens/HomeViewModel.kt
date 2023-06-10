package com.paparazziteam.handlederrorsincompose.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {
    val nombres = mutableStateOf("")
    val apellidos = mutableStateOf("")
    val edad = mutableStateOf("")
}