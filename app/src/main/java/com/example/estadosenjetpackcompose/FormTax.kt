package com.example.estadosenjetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.floor


@Composable
fun FormTax(
    myViewModel : FormTaxViewModel
) {
    Scaffold() { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(18.dp)
        ) {
            TextField(
                label = { Text("Cantidad") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AttachMoney,
                        contentDescription = null
                    )
                },
                value = myViewModel.inputCantidad,
                onValueChange = {
                    myViewModel.updateCantidad(it)
                })

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                label = { Text("Porcentaje") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Percent,
                        contentDescription = null
                    )
                },
                value = myViewModel.inputPorcentaje,
                onValueChange = {
                    myViewModel.updatePorcentaje(it)
                })

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Redondear")
                Switch(
                    checked = myViewModel.inputRedondear,
                    onCheckedChange = {
                        myViewModel.updateRedondear(it)
                    })
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Resultado = ${myViewModel.resultado}", fontSize = 50.sp)
        }

    }
}