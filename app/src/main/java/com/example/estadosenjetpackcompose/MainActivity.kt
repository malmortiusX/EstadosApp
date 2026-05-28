package com.example.estadosenjetpackcompose

import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.widget.Button
import android.widget.GridLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.w3c.dom.Text
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val viewModel : FormTaxViewModel = viewModel()

            FormTax(viewModel)
        }
    }
}

@Composable
fun MyApp() {

    var contador by remember { mutableStateOf(0) }

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sumado de Números: $contador", fontSize = 50.sp, textAlign = TextAlign.Center)

        Button(onClick = {
            Log.i("mi-error", "Estoy haciendo click")
            contador++
        }) {
            Text("Sumar +")
        }
    }
}

@Composable
fun Dados() {

    var number by remember { mutableStateOf(1) }
    val list = listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Text(text = "Sumado de Números: $contador", fontSize = 50.sp, textAlign = TextAlign.Center)

        Image(
            painter = painterResource(list[number]),
            contentDescription = TODO(),
        )

        Button(onClick = {
            number = (1..6).random()
        }) {
            Text("¡¡¡Lanzar dado!!!")
        }
    }
}