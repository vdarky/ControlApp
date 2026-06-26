package com.example.control

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.control.ui.theme.ControlTheme
import com.example.control.ui.viewModel.AccessViewModel
import com.example.control.view.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ControlTheme {
                LoginScreen(viewModel = viewModel< AccessViewModel>())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ControlTheme {
        LoginScreen(viewModel = viewModel<AccessViewModel>())

    }
}



