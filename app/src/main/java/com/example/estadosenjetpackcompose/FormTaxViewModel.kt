package com.example.estadosenjetpackcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.ceil
import kotlin.math.floor

class FormTaxViewModel : ViewModel() {

    var inputCantidad by mutableStateOf("")
    var inputPorcentaje by mutableStateOf("")
    var inputRedondear by mutableStateOf(false)

    val resultado : String
        get() {

            var cantidad = inputCantidad.toDoubleOrNull() ?: 0.0
            var porcentaje = inputPorcentaje.toDoubleOrNull() ?: 0.0

            var resultado = (cantidad * porcentaje) / 100

            if(inputRedondear == true) {
                resultado = ceil(resultado)
            }

            return resultado.toString()
        }

    fun updateCantidad(text:String){
        inputCantidad = text
    }

    fun updatePorcentaje(text:String){
        inputPorcentaje = text
    }

    fun updateRedondear(bool: Boolean){
        inputRedondear = bool
        println(bool)
    }

}