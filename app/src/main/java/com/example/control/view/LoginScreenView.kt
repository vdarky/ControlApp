package com.example.control.view

import androidx.compose.foundation.Image
import com.example.control.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.control.ui.viewModel.AccessViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(viewModel: AccessViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Login(Modifier.align(Alignment.Center), viewModel)
    }
}
@Composable
fun Login(modifier: Modifier, viewModel: AccessViewModel) {

    val pin :String by viewModel.pin.observeAsState(initial = "")
    val loginEnable: Boolean? by viewModel.loginEnable.observeAsState(initial = false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()
    if (isLoading){
        Box(Modifier.fillMaxSize()){
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }else{
        Column(modifier = modifier) {                          // ✅ usa el modifier recibido
            HeaderImage(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))
            PinField(pin, {viewModel.onLoginChanged(it)})
            Spacer(modifier = Modifier.padding(16.dp))
            LoginButton(loginEnable == true){
                coroutineScope.launch {
                    viewModel.onLoginSelected()
                }
            }
        }
    }
}

@Composable
fun LoginButton(loginEnable: Boolean, onLoginSelected: ()-> Unit) {
    Button(
        onClick = {onLoginSelected()},
        modifier =Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFE95996),
            disabledContainerColor = Color(0xFFEDDFE0),
            contentColor = Color.White,
            disabledContentColor = Color.White
        ), enabled = loginEnable
    ){
        Text(text = "Ingresar")
    }
}


@Composable
fun PinField(pin: String, onTextFieldChanged: (String) -> Unit) {                                           // ✅ sin parámetros

    TextField(
        value = pin,
        onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "PIN") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.colors(                 // ✅ API correcta de Material3
            focusedTextColor      = Color(0xFF8B7AB7),
            unfocusedTextColor    = Color(0xFF8B7AB7),
            focusedContainerColor = Color(0xFFEDDFE0),
            unfocusedContainerColor = Color(0xFFEDDFE0),
            focusedIndicatorColor   = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_png),
        contentDescription = "Header",
        modifier = modifier                                // ✅ usa el modifier recibido
    )
}